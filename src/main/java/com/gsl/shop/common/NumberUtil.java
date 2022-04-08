package com.gsl.shop.common;

import cn.hutool.core.util.StrUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Map;

/**
 * 数值格式化 <br>
 * 类详细说明.
 * <p>
 * Copyright: Copyright (c) 2021/4/8 11:20 上午
 * <p>
 * <p>
 *
 * @author Dongzl
 * @version 1.0.0
 **/
public class NumberUtil {

    /**
     * 数据格式化
     *
     * @param number 数据值
     * @return 格式化数据
     */
    public static String numberFormat(Integer number) {
        if (null == number) {
            number = 0;
        }
        DecimalFormat format = new DecimalFormat("#,###");
        return format.format(new BigDecimal(number));
    }

    /**
     * 金额格式化
     *
     * @param amount 金额
     * @return 格式化金额
     */
    public static String amountFormat(Object amount) {
        if (null == amount) {
            amount = 0;
        }
        DecimalFormat format = new DecimalFormat("#,##0.##");
        return format.format(new BigDecimal(amount.toString()).divide(new BigDecimal(100), 2, BigDecimal.ROUND_UP));
    }

    /**
     * 金额格式化
     *
     * @param amount 金额
     * @param point 积分标识
     * @return 格式化金额
     */
    public static String amountFormat(Object amount, boolean point) {
        if (null == amount) {
            amount = 0;
        }
        DecimalFormat format = new DecimalFormat("#,##0.##");
        if (point) {
            return format.format(new BigDecimal(amount.toString()));
        }
        return format.format(new BigDecimal(amount.toString()).divide(new BigDecimal(100), 2, BigDecimal.ROUND_UP));
    }

    /**
     * 格式化人民币数字
     *
     * @param amount 金额
     * @param minDigits 设置数的小数部分所允许的最小位数
     * @param maxDigits 设置数的小数部分所允许的最大位数
     * @return 格式化后金额
     */
    public static String formatNumber(Integer amount, int minDigits, int maxDigits) {
        return formatNumber(intToBigDecimal(amount), minDigits, maxDigits);
    }

    /**
     *  格式化人民币数字
     *
     * @param amount 金额
     * @param minDigits 设置数的小数部分所允许的最小位数(如果不足后面补0)
     * @param maxDigits 设置数的小数部分所允许的最大位数(如果超过会四舍五入)
     * @return String
     *
     */
    public static String formatNumber(BigDecimal amount, int minDigits, int maxDigits) {

        if (null == amount) {
            amount = BigDecimal.ZERO;
        }

        NumberFormat currency = NumberFormat.getCurrencyInstance();
        currency.setMinimumFractionDigits(minDigits);
        currency.setMaximumFractionDigits(maxDigits);
        return currency.format(amount);
    }

    /**
     * 金额转换（分转元）
     *
     * @param number 金额
     * @return 转换后金额
     */
    public static BigDecimal intToBigDecimal(Integer number) {
        if (null == number) {
            number = 0;
        }
        return new BigDecimal(number).divide(new BigDecimal(100), 2, RoundingMode.UP);
    }

    /**
     * 金额转换（分转元）
     *
     * @param number 金额
     * @return 转换后金额
     */
    public static BigDecimal toBigDecimal(Object number) {
        if (null == number) {
            number = "0";
        }
        return new BigDecimal(number.toString()).divide(new BigDecimal(100), 2, RoundingMode.UP);
    }

    /**
     * 金额转换（元转分）
     *
     * @param number 金额
     * @return 转换后金额
     */
    public static Integer bigDecimalToInt(BigDecimal number) {
        if (null == number) {
            return 0;
        }
        return number.multiply(new BigDecimal(100)).intValue();
    }

    /**
     * 金额转换（元转分）
     *
     * @param number 金额
     * @return 转换后金额
     */
    public static Long bigDecimalToLong(BigDecimal number) {
        if (null == number) {
            return 0L;
        }
        return number.multiply(new BigDecimal(100)).longValue();
    }

    /**
     * 金额（字符串）转换分
     *
     * @param amount 金额
     * @param unitFlag 单位为元标识 true:元 false:分
     * @return 转换后金额
     */
    public static Long strToLong(String amount, boolean unitFlag) {
        if (StrUtil.isBlank(amount)) {
            return 0L;
        }

        BigDecimal bigAmount;
        if (unitFlag) {
            // 单位为元
            bigAmount = new BigDecimal(amount).multiply(new BigDecimal(100));
        } else {
            // 单位为分
            bigAmount = new BigDecimal(amount);
        }
        return bigAmount.longValue();
    }

    /**
     * 数值转换
     *
     * @param number 数值
     * @return 转换后数值
     */
    public static Integer objToInt(Object number) {
        if (null == number) {
            return 0;
        }
        return new BigDecimal(number.toString()).intValue();
    }

    /**
     * 数值转换
     *
     * @param number 数值
     * @return 转换后数值
     */
    public static Long objToLong(Object number) {
        if (null == number) {
            return 0L;
        }
        return new BigDecimal(number.toString()).longValue();
    }

    /**
     * 计算税额及不含税金额
     *
     * @param strTaxRate 税率
     * @param taxIncludedAmount 含税金额
     * @return 税额及不含税金额
     */
    public static String[] calcTax(String strTaxRate, BigDecimal taxIncludedAmount) {

        // 税率
        BigDecimal taxRate = new BigDecimal(strTaxRate);

        // 税额 = 含税金额 - 含税金额 / (1 + 税率)
        BigDecimal taxAmount = taxIncludedAmount.subtract(taxIncludedAmount.divide((BigDecimal.ONE.add(taxRate)), 2, BigDecimal.ROUND_HALF_UP));
        // 不含税金额
        BigDecimal taxExcludedAmount = taxIncludedAmount.subtract(taxAmount);

        return new String[] {
                taxExcludedAmount.toString(),
                taxAmount.toString()
        };
    }

    /**
     * 取得Map中Int值
     *
     * @param map 数据集合
     * @param key 键值
     * @return 数值
     */
    public static Integer getIntVal(Map<String, Object> map, String key) {

        if (null == map || map.isEmpty()) {
            return 0;
        } else {
            return objToInt(map.get(key));
        }
    }

    /**
     * 取得Map中Long值
     *
     * @param map 数据集合
     * @param key 键值
     * @return 数值
     */
    public static Long getLongVal(Map<String, Object> map, String key) {

        if (null == map || map.isEmpty()) {
            return 0L;
        } else {
            return objToLong(map.get(key));
        }
    }

    /**
     * 价格比例转换(BigDecimal => Integer)
     * @param priceRatio 价格比例
     * @return
     */
    public static Integer priceRatioToInt(BigDecimal priceRatio) {
        if (null == priceRatio) {
            return 0;
        }
        return priceRatio.multiply(new BigDecimal(10000)).intValue();
    }

    /**
     * 价格比例转换(Integer => BigDecimal)
     * @param priceRatio 价格比例
     * @return
     */
    public static BigDecimal priceRatioToBigDecimal(Integer priceRatio) {
        if (null == priceRatio) {
            return BigDecimal.ZERO;
        }
        return new BigDecimal(priceRatio).divide(new BigDecimal(10000), 4 , RoundingMode.HALF_UP);
    }

    /**
     * 价格比例格式化 (Integer => String)
     * @param priceRatio 价格比例
     * @return 格式化价格比例
     */
    public static String priceRatioFormat(Integer priceRatio) {
        if (null == priceRatio) {
            priceRatio = 0;
        }
        DecimalFormat format = new DecimalFormat("#,##0.####");
        return format.format(new BigDecimal(priceRatio.toString()).divide(new BigDecimal(10000), 4, BigDecimal.ROUND_UP));
    }
}
