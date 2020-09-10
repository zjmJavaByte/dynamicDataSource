package com.kh.jkdw.model.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author zjm
 * @version 1.0
 * 描述：TODO
 * @date 2020/9/9 15:11
 */
public class BaseModel<T> extends Model {

    @TableField(value = "DELETED", fill = FieldFill.INSERT)
    @TableLogic
    private Integer deleted;

    @TableField(value = "CREATE_BY", fill = FieldFill.INSERT)
    private String createBy;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @TableField(value = "CREATE_TIME", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "UPDATE_TIME", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableField(value = "UPDATE_BY", fill = FieldFill.INSERT_UPDATE)
    private String updateBy;

    @TableField(value = "VERSION", fill = FieldFill.INSERT)
    @Version
    private Integer version;
}
