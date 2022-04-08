package com.gsl.shop.common;

/**
 * Api接口返回值的统一错误信息。
 * 通用code：00000-返回正确；A0001-通用的用户端错误；B0001-通用的服务端错误；C0001-通用的第三方错误；
 */
public enum ApiResultFailEnum implements ApiResultFail {
    // ----- 用户端错误 -----
    DEFAULT_CLIENT_ERROR("A0001", "系统内部错误，请重试"),

    // 注册错误
    DEFAULT_CLIENT_REGISTER_ERROR("A0100", "注册发生错误"),
    CLIENT_REGISTER_HAS_REGISTERED("A0101", "已注册，请登录"),

    //登陆错误
    DEFAULT_CLIENT_LOGIN_USER_ERROR("A0200", "登陆发生错误"),
    CLIENT_LOGIN_USER_NOT_FOUND("A0201", "用户账户不存在"),
    CLIENT_LOGIN_USER_FROZEN("A0202", "用户账户被冻结"),
    CLIENT_LOGIN_USER_INVALID("A0203", "用户账户已作废"),
    CLIENT_LOGIN_PASSWORD_WRONG("A0210", "用户密码错误"),
    CLIENT_LOGIN_PASSWORD_OUT_OF_INPUT_LIMIT("A0211", "用户输入密码错误次数超限"),
    CLIENT_LOGIN_VERIFY_FAIL("A0220", "用户身份校验失败"),
    CLIENT_LOGIN_VERIFY_THIRD_AUTH_FAIL("A0223", "用户未获得第三方登录授权"),
    CLIENT_LOGIN_EXPIRED("A0230", "用户登录已过期"),
    CLIENT_LOGIN_VERIFY_CODE_WRONG("A0240", "用户验证码错误"),
    CLIENT_LOGIN_VERIFY_CODE_OUT_OF_LIMIT("A0241", "用户验证码尝试次数超限"),
    OPERATION_PASSWORD_MANAGE_NOT_FOUND("A0242", "操作密码未设置"),
    OPERATION_PASSWORD_FAIL("A0243", "操作密码错误"),
    CLIENT_LOGIN_SMS_VERIFY_FAIL("A0244", "短信验证码填写错误"),
    CLIENT_LOGIN_MOBILE_VERIFY_FAIL("A0245", "手机号不存在"),
    CLIENT_MOBILE_NOT_BIND("A0246", "用户手机号未绑定"),
    CLIENT_LOGIN_YZF_BACKEND_TOKEN_VERIFY_FAIL("A0248", "不合法的backend_token，或已过期"),

    CREATE_EXPORT_DIR_ERROR("A1001", "创建导出文件目录失败"),

    CLIENT_LOGIN_NOT_EXIST("A0250", "登陆客户端不存在"),

    // 授权错误
    DEFAULT_CLIENT_AUTH_ERROR("A0300", "权限错误"),
    CLIENT_AUTH_ERROR_NO_AUTH("A0300", "无权限访问"),
    CLIENT_AUTH_ERROR_IN_REVIEW("A0300", "授权审核中"),

    // 用户请求参数错误
    DEFAULT_CLIENT_REQ_PARAM_ERROR("A0400", "参数错误"),
    CLIENT_REQ_PARAM_INVALID_URL("A0401", "包含非法恶意跳转链接"),
    CLIENT_REQ_PARAM_INVALID_INPUT("A0402", "无效的用户输入"),
    CLIENT_REQ_PARAM_REQUIRED_EMPTY("A0410", "请求必填参数为空"),
    CLIENT_REQ_PARAM_ORDER_ID_EMPTY("A0411", "用户订单号为空"),
    CLIENT_REQ_PARAM_ORDER_NUM_EMPTY("A0412", "订购数量为空"),
    CLIENT_REQ_PARAM_NEED_TIMESTAMP("A0413", "缺少时间戳参数"),
    CLIENT_REQ_PARAM_INVALID_TIMESTAMP("A0414", "非法的时间戳参数"),
    CLIENT_REQ_PARAM_OUT_OF_RANGE("A0420", "请求参数值超出允许的范围"),
    CLIENT_REQ_PARAM_WRONG_FORMAT("A0421", "参数格式不匹配"),
    CLIENT_REQ_PARAM_ADDR_OUT_OF_SERVICE("A0422", "地址不在服务范围"),
    CLIENT_REQ_PARAM_TIME_OUT_OF_SERVICE("A0423", "时间不在服务范围"),
    CLIENT_REQ_PARAM_MONEY_OUT_OF_LIMIT("A0424", "金额超出限制"),
    CLIENT_REQ_PARAM_AMOUNT_OUT_OF_LIMIT("A0425", "数量超出限制"),
    CLIENT_REQ_PARAM_BATCH_NUM_OUT_OF_LIMIT("A0426", "请求批量处理总个数超出限制"),
    CLIENT_REQ_PARAM_PARSE_JSON_FAIL("A0427", "请求 JSON 解析失败"),
    CLIENT_REQ_PARAM_FORBID_INPUT("A0430", "用户输入内容非法"),
    CLIENT_REQ_PARAM_FORBID_WORD("A0431", "包含违禁敏感词"),
    CLIENT_REQ_PARAM_FORBID_IMG("A0432", "图片包含违禁信息"),
    CLIENT_REQ_PARAM_NO_RIGHT_FILE("A0433", "文件侵犯版权"),
    CLIENT_REQ_PARAM_OPERATE_FAIL("A0440", "用户操作异常"),
    CLIENT_REQ_PARAM_PAY_TIMEOUT("A0441", "用户支付超时"),
    CLIENT_REQ_PARAM_CONFIRM_TIMEOUT("A0442", "确认订单超时"),
    CLIENT_REQ_PARAM_ORDER_CLOSED("A0443", "订单已关闭"),
    CLIENT_REQ_PARAM_GROUP_ORDER_CLOSE("A0445", "拼团已结束"),
    CLIENT_REQ_PARAM_GROUP_ORDE("A0446", "拼团已完成"),
    CLIENT_REQ_PARAM_DATA_REPEAT("A0447", "数据重复"),
    CLIENT_REQ_PARAM_TOKEN_LOGIN("A0448", "邮政食堂登录token为空"),
    CLIENT_REQ_PARAM_FREQUENT_SMS_FETCHING("A0449", "短信获取太频繁"),
    CLIENT_REQ_PARAM_CODE_LOGIN_YSH("A0450", "邮生活登录code为空"),
    CLIENT_REQ_PARAM_CODE_LOGIN_YZF("A0451", "云支付登录code为空"),
    CLIENT_FAIL_LOGIN_CODE_WX("A0452", "微信授权code不能为空"),
    CLIENT_FAIL_LOGIN_INTERIM_TOKEN("A0453", "临时token不能为空"),
    POINT_COUPON_INADEQUATE("A0454", "积分加上优惠金额大于成交价"),
    //认证错误
    CLIENT_IDENTITY_PARAM_ERROR("A0501","参数错误"),
    //获取签名错误
    CLIENT_GET_SIGN("A0502","获取签名错误"),
    // ----- 服务端错误 -----
    DEFAULT_SERVER_ERROR("B0001", "系统内部错误，请重试"),
    SERVER_DATA_UPDATE_ERROR("B0002", "系统数据更新失败"),
    SERVER_PAY_ERROR("B0003", "系统支付异常"),
    SERVER_DATA_STATUS_ERROR("B0004", "数据状态异常"),
    SERVER_JOIN_GROUP_ERROR("B0005", "入团失败退单"),
    DEFAULT_INTERNAL_SERVER_ERROR("B0006", "内部服务远程调用异常，请重试"),
    SERVER_REFUND_DEALWITH_ERROR("B0007", "退款补处理异常"),
    SERVER_GROUP_RED_PACKAGE_ISSUE_EXCEPTION("B0008", "拼团红包积分发放异常"),
    SERVER_ACTIVE_LIMIT_ERROR("B0009", "虚拟活动限制异常"),
    SERVER_PAYD_ERROR("B0010", "订单已支付"),

    // 超时错误
    DEFAULT_SERVER_TIMEOUT_ERROR("B0100", "系统执行超时"),
    SERVER_ERROR_ORDER_TIME_OUT("B0101", "系统订单处理超时"),

    // 编辑错误
    EDIT_EXIST_ERROR("B0200", "编辑时，数据已存在"),
    ORDER_INFO_EXIST_ERROR("B0203", "创建订单数据已存在"),
    EDIT_NOT_EXIST_ERROR("B0201", "编辑时，数据不存在"),
    SUPPLIER_CONFIRM_ORDER_ERROR("B0202", "确认订单异常"),
    EDIT_SAVE_ERROR("B0204", "新增时，保存失败"),

    BRAND_IS_USING("B0204","品牌有商品正在使用，无法禁用"),
    CATEGORY_IS_USING("B0205","分类有商品正在使用，无法禁用"),

    EDIT_PRODUCT_ID_EQUAL_ERROR("B0206", "虚拟商品 供应商商品ID与备用供应商商品ID不可一致"),
    VIRTUAL_PRODUCT_RECHARGING("B0207", "虚拟商品充值中"),
    VIRTUAL_SUPPLIER_PRODUCT_IS_EXIST("B0208", "供应商商品已存在"),

    PRODUCT_EDIT_SUPPLIER_APP_NOT_EXIST("B0220", "商品编辑时供应商应用不存在"),
    PRODUCT_SPU_EDIT_ERROR("B0221", "商品编辑时失败"),
    PRODUCT_SKU_EDIT_ERROR("B0222", "单品编辑时失败"),
    PRODUCT_SKU_PRICE_CHECK_ERROR("B0223", "单品价格编辑时校验失败"),
    PRODUCT_SKU_ORIGIN_PRICE_CHECK_ERROR("B0231", "单品编辑时，划线价不能小于零"),
    PRODUCT_SKU_MARKET_PRICE_CHECK_ERROR("B0232", "单品编辑时，市场销售价不能小于零"),
    PRODUCT_SKU_SETTLE_PRICE_CHECK_ERROR("B0233", "单品编辑时，供应商结算价格不能小于零"),

    FIND_NO_DATA("B0300", "未查询到数据"),
    WX_APP_FIND_NO_DATA("B0301", "微信公众号不存在"),

    PRODUCT_ADD_SKU_SPEC_REPEAT("B0311", "添加单品时，规格重复"),
    PRODUCT_EDIT_SKU_SPEC_REPEAT("B0312", "更新单品规格时，规格重复"),

    SKU_ONLINE_SPU_NO_EXIST("B0331", "单品上架时，商品不存在"),
    SKU_ONLINE_SPU_NO_ONLNE("B0332", "商品未上架，请先上架商品"),
    SKU_ONLINE_SPU_NO_AUDIT("B0333", "商品未审核通道，请先提审商品"),

    PRODUCT_SPU_ADD_SPEC_NOT_EXIST("B0334", "商品编辑时，规格必需选择"),
    PRODUCT_SKU_ONLIEN_SPEC_NOT_EXIST("B0335", "单品上架时，规格值必需选择"),
    PRODUCT_SKU_AUDIT_SPEC_NOT_EXIST("B0336", "单品提审时，规格值必需选择"),
    PRODUCT_SKU_ADD_STOCK_SPU_NO_AUDIT("B0338", "追加库存时，商品未上架或未审核通过"),
    PRODUCT_SKU_ADD_STOCK_SKU_NO_AUDIT("B0339", "追加库存时，单品未上架或未审核通过"),
    PRODUCT_SKU_ADD_STOCK_ERROR("B0340", "追加库存时，操作失败"),
    PRODUCT_SKU_ADD_STOCK_NOT_AUTH("B0340", "追加库存时，单品库存未授权"),
    PRODUCT_SPU_REVIEW_AUDIT_FAIL("B0341", "商品提审时，操作失败"),
    PRODUCT_SPU_CANCEL_REVIEW_AUDIT_FAIL("B0342", "商品取消提审时，操作失败"),
    PRODUCT_SKU_REVIEW_AUDIT_FAIL("B0343", "单品提审时，操作失败"),
    PRODUCT_SKU_CANCEL_REVIEW_AUDIT_FAIL("B0344", "单品取消提审时，操作失败"),


    INVOICE_IS_EXIST("B0400", "发票已存在"),
    INVOICE_APPLY_ERROR("B0401", "发票申请失败"),
    ORDER_INVOICE_NOT_OPEN_SUCCESS("B0402", "订单未开票成功"),
    INVOICE_NULLIFY_FAIL("B0403", "发票作废失败"),

    // 积分错误
    POINT_ORGANIZE_APPID_EMPTY("B05013", "发放积分机构ID不存在"),
    POINT_ORGANIZE_EMPTY("B05014", "发放积分机构不存在"),
    POINT_ORGANIZE_ACCOUNT_NOT_EXIST("B0500", "积分发放时，机构账号不存在"),
    POINT_ACCOUNT_INSUFFICIENT("B0501", "积分发放时，机构账号积分不足"),
    POINT_USER_ACCOUNT_NOT_EXIST("B0502", "积分发放时，用户账号不存在"),
    POINT_BATCH_IMPORT_NOT_EXIST("B0503", "积分发放时，批量导入记录不存在"),
    USABLE_POINT_INADEQUATE("B0504", "可用积分余额不足"),
    POINT_THAW_DATA_EXIST("B0505", "解冻数据已存在"),
    FREEZE_POINT_INADEQUATE("B0506", "冻结积分余额不足"),
    POINT_USER_ACCOUNT_MANUAL_FROZEN_NOT_EXIST("B0507", "用户账户手动冻结记录不存在"),
    USER_POINT_UPDATE("B0508", "用户积分账户已被修改"),
    USER_NOT_EXIST_GRANT_FREEZE_POINT("B0509", "用户未发放冻结积分不存在"),
    USER_POINT_DETAIL_NULL("B0510", "暂无积分明细"),
    ORGANIZE_POINT_UPDATE("B05011", "机构账户积分已被修改"),
    USER_ACCOUNT_NOT_EXIST("B05012", "用户积分账户不存在"),

    // ----- 第三方错误 -----
    DEFAULT_THIRD_PARTY_ERROR("C0001", "系统内部错误，请重试"),
    THIRD_ACCESS_TOKEN_ERROR("C0002", "访问令牌已失效"),
    THIRD_CONFIRM_ORDER_ERROR("C0003", "确认订单失败"),
    THIRD_REFRESH_TOKEN_ERROR("C0004", "刷新token失败"),
    THIRD_PARAM_ERROR("C0005","第三方调用，参数错误"),
    THIRD_CANCEL_ORDER_ERROR("C0006", "取消订单失败"),
    DEFAULT_THIRD_PARTY_REMOTE_ERROR("C0007", "系统远程调用异常，请重试"),
    THIRD_PARTY_STOCK_ERROR("C0008", "库存不足，请更换商品"),
    QUERY_LOGISTICS_ORDER_ERROR("C0009", "物流信息查询失败"),
    CONFIRM_RECEIVED_ORDER_ERROR("C00010", "当前订单无法确认收货"),
    CHECK_ORDER_PRICE_ERROR("C00011", "商品结算价价格不一致"),
    QUERY_ORDER_ERROR("300001", "订单信息不存在"),
    AUTH_MOBILE_ERROR("C00012", "获取授权认证外部数据失败"),

    PAY_ORDER_NO_REPEAT("D0001", "商户订单号重复，请重新更换订单号"),
    PAY_PAYMENTS_ERROR("D0002", "订单支付中，请不要重复创建"),
    PAY_NOT_SET_CONFIG("D0003", "渠道未配置支付方式"),
    PAY_CREATE_ERROR("D0004", "支付创建异常"),
    REFUND_ORDER_NO_REPEAT("D0005", "商户退款单号重复，请重新更换退款单号"),
    REFUND_PAY_ORDER_NOT_EXIST("D0006", "支付订单不存在"),
    REFUND_PAY_ORDER_STATE_ERROR("D0007", "支付订单状态异常"),
    REFUND_PAY_ORDER_VALID_PERIOD_ERROR("D0008", "支付订单不在退款有效期范围内"),
    REFUND_AMOUNT_ERROR("D0009", "退款金额异常"),
    REFUND_NOTIFY_ERROR("D0010", "支付回调处理异常"),
    PAY_PSBC_CALL_ERROR("D0002", "邮储银行手机支付调用失败"),
    PAY_PSBC_MOBILE_CALLBACK_VERIFY_ERR("D0003", "邮储银行手机支付回调校验失败"),
    ENT_PAY_PAYMENTS_ERROR("D0022", "微信企业付款中，请不要重复创建"),

    // ------- 商品池 ---------
    PRODUCT_POOL_NOT_EXIST("P0001", "商品池不存在"),
    PRODUCT_SKU_NOT_EXIST("P0002", "商品池单品不存在"),
    PRODUCT_SKU_PRICE_CHECK_FAIL("P0003", "商品池单品价格校验失败"),
    PRODUCT_SKU_STOCK_NOT_EXIST("P0004", "商品池单品库存不存在"),
    PRODUCT_SKU_PRICE_CHECK_FAIL_1("P0005", "价格校验失败，售卖渠道市场价不能低于市场价"),
    PRODUCT_SKU_PRICE_CHECK_FAIL_2("P0006", "价格校验失败，售卖渠道结算价不能低于供应商结算价"),
    PRODUCT_SKU_PRICE_CHECK_FAIL_3("P0007", "价格校验失败，售卖渠道结算价不能高于售卖渠道市场价"),
    PRODUCT_ADD_SKU_FAIL("P0008", "商品池添加单品时，添加失败"),
    PRODUCT_SKU_PRICE_EDIT_FAIL("P0009", "商品池单品价格编辑失败"),

    BIG_PRODUCT_AUDTI_STATE_FAIL("P1001", "大池商品审核时，已审核"),
    BIG_PRODUCT_SUP_AUDIT_DONE("P1002", "大池单品审核时，商品未审核通过"),
    BIG_PRODUCT_SKU_AUDIT_STATE_FAIL("P1003", "大池单品审核时，已审核"),
    BIG_AUDIT_SUPPLIER_CONFIG_NOT_EXIST("P1004", "商品单品审核时，供应商配置不存在"),

    PRODUCT_SKU_ADD_STOCK_INSUFFICIENT("P1101", "追加库存时，库存不足"),
    PRODUCT_SKU_ADD_STOCK_NOT_EXIST("P1102", "追加库存时，库存不存在"),

    PRODUCT_P0OL_IMPORT_FILE_ERROR("P2001", "商品池上传文件出错"),

    POWER_MERCHANT_NO_NULL_ERROR("Z0001", "第三方订单号为空"),
    POWER_USER_MOBILE_NULL_ERROR("Z0002", "用户手机号为空"),
    POWER_MERCHANT_NO_REPEATED_ERROR("Z0003", "第三方订单号已重复"),
    POWER_CODE_NULL_ERROR("Z0004", "vip权益等级编号为空"),
    POWER_CODE_INVALID_ERROR("Z0005", "vip权益等级编号无效"),
    POWER_START_TIME_NULL_ERROR("Z0006", "期限开始时间为空"),
    POWER_END_TIME_NULL_ERROR("Z0007", "期限结束时间为空"),
    POWER_END_TIME_FORMAT_ERROR("Z0008", "期限结束时间格式错误"),
    POWER_LIMIT_NO_FOUND_ERROR("Z0009", "vip权益发放次数未配置"),
    POWER_COUNT_ERROR("Z0010", "vip权益发放次数已用完"),
    VERIFY_DATE_NULL_ERROR("Z0011", "对账时间不能为空"),
    VERIFY_DATE_BILL_NOT_GENERATED("Z0012", "对账日期账单未生成"),

    SIGN_LESS_IP_PARAM_ERROR("Z0100", "缺少参数IP"),
    SIGN_LESS_APPKEY_PARAM_ERROR("Z0101", "缺少参数appKey"),
    SIGN_LESS_TIMESTAMP_PARAM_ERROR("Z0102", "缺少参数timestamp"),
    SIGN_TIMESTAMP_PARAM_ERROR("Z0103", "时间戳必须为Long类型"),
    SIGN_LESS_SIGN_PARAM_ERROR("Z0104", "缺少参数sign"),
    SIGN_SENT_NUM_PARAM_ERROR("Z0105", "发放数量格式错误"),
    SIGN_SENT_NUM_LESS_ZERO_PARAM_ERROR("Z0106", "发放数量小于0"),
    SIGN_PARAM_ERROR("Z0107", "签名校验失败"),
    SIGN_APPKEY_INVALID_ERROR("Z0108", "appKey无效"),
    SIGN_NOT_FIND_MERCHANT_ERROR("Z0109", "未查到商户信息"),
    SIGN_IP_NOT_CONFIG_ERROR("Z0110", "IP白名单未配置IP"),
    SIGN_IP_NOT_INCLUDED_ERROR("Z0111", "白名单中不存在IP"),
    SIGN_APPKEY_NO_PERMISSION_ERROR("Z0112", "appKey无权限"),
    SIGN_APPKEY_NOT_ACTIVE_ERROR("Z0113", "appKey未生效"),
    SIGN_APPKEY_EXPIRED_ERROR("Z0114", "appKey已失效"),

    ISSUANCE_LESS_THIRD_ORDER_NO_ERROR("Z0130", "缺少第三方订单号"),
    ISSUANCE_THIRD_ORDER_NO_EXIST_ERROR("Z0131", "第三方单号已发放"),
    ISSUANCE_ACTIVITY_NO_INVALID_ERROR("Z0132", "活动编号无效"),
    ISSUANCE_ACTIVITY_NOT_START_OR_EXP_ERROR("Z0133", "活动未开始或已过期"),
    ISSUANCE_COUPON_NOT_EXIST_ERROR("Z0134", "优惠券信息不存在"),
    ISSUANCE_MERCHANT_INSUFFICIENT_BALANCE_ERROR("Z0135", "商户优惠余额不足"),
    ISSUANCE_SINGLE_INSUFFICIENT_BALANCE_ERROR("Z0136", "活动优惠余额不足"),
    ISSUANCE_ERROR("Z0137", "发放异常，系统内部错误"),
    GET_BILL_ERROR("Z0138", "账单获取异常"),
    ISSUANCE_SINGLE_ERROR("Z0139", "活动异常"),


    MQ_MSG_CODE_EMPTY("Y00001", "消息唯一标识为空"),
    MQ_SIGN_EMPTY("Y00002", "签名为空"),
    MQ_VERIFY_SIGN_ERROR("Y00003", "验签失败"),

    REQUEST_CODE_NO_NULL_ERROR("S0001", "销售渠道编号为空"),
    REQUEST_REQUEST_TIME_NO_NULL_ERROR("S0002", "请求时间为空"),
    REQUEST_VERSION_NO_NULL_ERROR("S0003", "版本号为空"),
    REQUEST_SIGN_NO_NULL_ERROR("S0004", "签名为空"),
    REQUEST_CODE_PARAM_ERROR("S0005", "销售渠道编号参数错误"),
    SALE_PAGE_NO_NULL_ERROR("S01006", "页码为空"),
    SALE_PAGE_SIZE_NO_NULL_ERROR("S01007", "每页显示数为空"),
    SALE_PAGE_SIZE_OVER_ERROR("S01008", "每页显示数超出最大数量"),
    REQUEST_LESS_IP_PARAM_ERROR("S0009", "缺少参数IP"),
    REQUEST_IP_NOT_INCLUDED_ERROR("S00010", "白名单中不存在IP"),
    REQUEST_IP_NOT_CONFIGURED_ERROR("S00011", "未配置IP白名单"),
    REQUEST_VERIFY_SIGN_PARAM_ERROR("S00012", "验签失败"),
    SALE_POOL_CODE_NO_NULL_ERROR("S01013", "商品池编号为空"),
    SALE_SKU_LIST_SIZE_ERROR("S01014", "skuId集合数量不能超过10"),
    ;

    /**
     * 返回报文的错误code
     */
    String code;

    /**
     * 返回报文的错误提示信息
     */
    String msg;

    ApiResultFailEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }
}
