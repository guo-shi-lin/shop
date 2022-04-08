package com.gsl.shop.common;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author gsl
 * @Description: 基础实体
 * @date 2022/1/1114:46
 */
@Data
public class BaseEntity {

    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    protected Long id;

    /**
     * 创建时间
     */
    @TableField("create_time")
    protected LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    protected LocalDateTime updateTime;

    /**
     * 初始化时间
     */
    public void initTime() {
        createTime = LocalDateTime.now();
        updateTime = createTime;
    }

    /**
     * 设置修改时间
     */
    public void setUpdateTime() {
        updateTime = LocalDateTime.now();
    }
}
