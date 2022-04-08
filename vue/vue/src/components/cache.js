/**
 * 数据缓存
 */
class Cache {
  /**
     * 获取缓存
     * @param key
     * @return {any}
     */
  static get (key) {
    const result = JSON.parse(localStorage.getItem(key))
    const date = new Date()
    if (result && result.expires > date) {
      return result.data
    } else {
      Cache.remove(key)
      return null
    }
  }

  /**
     * 设置缓存
     * @param {String} key 键名
     * @param {any} value 缓存数据
     * @param {Number} expires 过期时间 单位 s
     */
  static set (key, value, expires = 3600) {
    const date = new Date()
    try {
      localStorage.setItem(key, JSON.stringify({
        expires: date.valueOf() + expires * 1000,
        data: value
      }))
    } catch (e) {
      if (e.name === 'QuotaExceededError') {
        console.log('数据已满，自动清空')
        Cache.clear()
        Cache.set(key, value, expires)
      }
    }
  }

  /**
     * 删除键
     * @param key
     */
  static remove (key) {
    localStorage.removeItem(key)
  }

  /**
     * 清空
     */
  static clear () {
    localStorage.clear()
  }
}

export default Cache
