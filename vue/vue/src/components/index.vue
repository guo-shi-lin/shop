<template>
  <div>
    <div class="w">
      <ul class="fr">
        <li><a v-if="userId === ''" @click="userLogin()">你好，请登录</a>
        <span v-else>用户名：{{userName}} &#8194; <a @click="userCart(userId)"><img style="height: 14px;width: 22px; " src="./222.jpg"><span style="color:red;">{{number}}</span></a></span></li>
        <Modal v-model="modal1" title="用户登录" @on-ok="ok" ok-text="登录">
          <div> <span style="color: red;">用户名：</span><input v-model="login.nickName"/></div>
          <div> <span style="color: red;">密&#8194; 码：</span>  <input type="password" v-model="login.password"/></div>
        </Modal>
        <Modal v-model="modal2" title="购物车" ok-text="结算">
          <div v-if="userCarts !== null && userCarts.length > 0">
              <ul  v-for="item in userCarts" :key="item">
                <li>
                  <img style="height: 155px;width: 155px; " :src="item.productImgUrl"/>
                  <p>名称：{{item.productName}}</p>
                  <p>数量：{{item.buyNum}}</p>
                  <span style="color: red;">价格：￥{{item.realPrice}}</span>
                </li>
             </ul>
          </div>
          <div v-else>购物车暂无商品</div>
        </Modal>
      </ul>
    </div>
    <div><input clearable v-model="param.productName"/> <button class="search_button" v-on:click="search()" style="width: 82px;height: 36px;">搜索</button></div>
    <ul>
      <li v-for="item in productList" :key="item">
        <div class="product_img"><img :src="item.productImgUrl"/></div>
        <div :title="item.productNameTitle"><p class="product_name"  v-html="item.productName">{{item.productName}}</p></div>
        <div><span style="color: red;">￥{{item.realPrice}}</span> &#8194;  <s>￥{{item.salePrice}}</s>&#8194; <a @click="cart(item.productId)">加入购物车</a></div>
      </li>
    </ul>
    <div style="padding: 10px;"><span style="font-weight:bold">总共{{total}}条，总共{{pages}}页，第{{current}}页</span>
    <button v-on:click="upon()">上一页</button> <button v-on:click="next()">下一页</button></div>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'shop',
  data () {
    return {
      number: 0,
      modal1: false,
      modal2: false,
      userId: '',
      userName: '',
      productList: [],
      userCarts: [],
      addCart: {
        uid: '',
        productId: '',
        num: 1
      },
      login: {
        nickName: '',
        password: ''
      },
      total: 0,
      pages: 0,
      current: 0,
      param: {
        page: 1,
        pageSize: 10,
        productName: ''
      }
    }
  },
  methods: {
    userCart (userId) {
      this.modal2 = true
      axios
        .post('http://localhost:8090/product/findCartList/' + userId)
        .then(response => {
          console.log(response)
          if (response.data.code === '00000') {
            console.log(response.data.data.length)
            this.userCarts = response.data.data
          } else {
            this.$Message.error('添加失败，' + response.data.msg)
          }
        })
        .catch(function (error) { // 请求失败处理
          console.log(error)
        })
    },
    cart (productId) {
      this.addCart.uid = this.userId
      this.addCart.productId = productId
      axios
        .post('http://localhost:8090/product/addCart', this.addCart)
        .then(response => {
          console.log(response)
          if (response.data.code === '00000') {
            this.getCartCount(this.userId)
            this.$Message.success('添加成功')
          } else {
            this.$Message.error('添加失败，' + response.data.msg)
          }
        })
        .catch(function (error) { // 请求失败处理
          console.log(error)
        })
    },
    userLogin () {
      this.login.nickName = ''
      this.login.password = ''
      this.modal1 = true
    },
    ok () {
      axios
        .post('http://localhost:8090/user/login', this.login)
        .then(response => {
          console.log(response)
          if (response.data.code === '00000') {
            this.userId = response.data.data.id
            this.userName = response.data.data.nickName
            this.getCartCount(this.userId)
            localStorage.setItem('userId', this.userId)
            localStorage.setItem('userName', this.userName)
            console.log('localStorage=' + JSON.stringify(localStorage))
            this.$Message.success('登录成功')
          } else {
            this.$Message.error('登录失败，' + response.data.msg)
          }
        })
        .catch(function (error) { // 请求失败处理
          console.log(error)
        })
    },
    upon: function () {
      if (this.current <= 1) {
        this.$Modal.warning({
          title: '警告提示',
          content: '已经是第一页了！！！'
        })
        return
      }
      this.param.page = this.current - 1
      this.findPage(this.param)
    },
    next: function () {
      if (this.current >= this.pages) {
        this.$Modal.warning({
          title: '警告提示',
          content: '已经是最后页了！！！'
        })
        return
      }
      this.param.page = this.current + 1
      this.findPage(this.param)
    },
    findPage: function (param) {
      axios
        .post('http://localhost:8090/product/findPage', param)
        .then(response => {
          if (response.data.code === '00000') {
            this.productList = response.data.data.records
            this.total = response.data.data.total
            this.current = response.data.data.current
            this.pages = response.data.data.pages
          }
        })
        .catch(function (error) { // 请求失败处理
          console.log(error)
        })
    },
    getCartCount (userId) {
      axios
        .get('http://localhost:8090/product/getCartCount/' + userId)
        .then(response => {
          if (response.data.code === '00000') {
            this.number = response.data.data
          }
        })
        .catch(function (error) { // 请求失败处理
          console.log(error)
        })
    },
    search: function () {
      this.param.page = 1
      this.findPage(this.param)
    }
  },
  mounted () {
    if (localStorage.userName !== undefined && localStorage.userName !== null && localStorage.userName !== '') {
      this.userName = localStorage.userName
    }
    if (localStorage.userId !== undefined && localStorage.userId !== null && localStorage.userId !== '') {
      this.userId = localStorage.userId
      this.getCartCount(this.userId)
    }
    axios
      .post('http://localhost:8090/product/findPage', this.param)
      .then(response => {
        if (response.data.code === '00000') {
          this.productList = response.data.data.records
          this.total = response.data.data.total
          this.current = response.data.data.current
          this.pages = response.data.data.pages
        }
      })
      .catch(function (error) { // 请求失败处理
        console.log(error)
      })
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
.product_name {
    width: 229px;
    overflow: hidden;
    display: -webkit-box;
    -webkit-line-clamp: 2;
    line-clamp: 2;
    -webkit-box-orient: vertical;
}
img {
  height: 220px;
  width: 220px;
}
input {
  width: 406px;
  padding: 17px;
  margin-bottom: 15px;
  border-color: #f30213;
  border-style: solid;
  outline: 0;
  font-size: 13px;
  height: 24px;
  line-height: 24px;
}
.search_button {
  background: #f30213;
  border: none;
  line-height: 1;
  color: #fff;
  font-size: 16px;
}
.w {
    margin-top: -55px;
    position: absolute;
    right: 0px;
    width: 443px;
}
a {
    color: #666;
    text-decoration: none;
}
.style-red {
    color: #f10215;
}
</style>
