package com.kh.jkdw.model;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.kh.jkdw.model.base.BaseModel;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author kaihua
 * @since 2020-09-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_central_control")
public class CentralControl extends Model<CentralControl> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 终端标识
     */
    private String terminalno;

    /**
     * 时间
     */
    private String time;

    /**
     * 昨日耗能
     */
    private BigDecimal dissipation;

    /**
     * 昨日前处理开机时长
     */
    @TableField("dealOpenDuration")
    private BigDecimal dealOpenDuration;

    /**
     * 昨日一级膜开机时长
     */
    @TableField("oneOpenDuration")
    private BigDecimal oneOpenDuration;

    /**
     * 昨日二级膜开机时长
     */
    @TableField("twoOpenDuration")
    private BigDecimal twoOpenDuration;

    /**
     * 昨日总进水量
     */
    @TableField("totalInWater")
    private BigDecimal totalInWater;

    /**
     * 日总产水量
     */
    @TableField("totalProudcWater")
    private BigDecimal totalProudcWater;

    /**
     * 前次运行一级膜入口压力
     */
    @TableField("oneInPa")
    private BigDecimal oneInPa;

    /**
     * 前次运行一级膜出口压力
     */
    @TableField("oneOutPa")
    private BigDecimal oneOutPa;

    /**
     * 前次运行一级膜产水流量
     */
    @TableField("oneProdcWater")
    private BigDecimal oneProdcWater;

    /**
     * 前次运行一级膜浓水流量
     */
    @TableField("oneDenseWater")
    private BigDecimal oneDenseWater;

    /**
     * 前次运行一级膜产水TDS
     */
    @TableField("oneWaterDTS")
    private BigDecimal oneWaterDTS;

    /**
     * 前次运行一级膜产水温度
     */
    @TableField("oneWaterTemper")
    private BigDecimal oneWaterTemper;

    /**
     * 前次运行二级膜入口压力
     */
    @TableField("twoInPa")
    private BigDecimal twoInPa;

    /**
     * 前次运行二级膜出口压力
     */
    @TableField("twoOutPa")
    private BigDecimal twoOutPa;

    /**
     * 前次运行二级膜产水流量
     */
    @TableField("twoProducWater")
    private BigDecimal twoProducWater;

    /**
     * 前次运行二级膜浓水流量
     */
    @TableField("twoDenseWater")
    private BigDecimal twoDenseWater;

    /**
     * 次运行二级膜产水TDS
     */
    @TableField("twoWaterDTS")
    private BigDecimal twoWaterDTS;

    /**
     * 前次运行二级膜产水温度
     */
    @TableField("twoWaterTemper")
    private BigDecimal twoWaterTemper;

    /**
     * 1#加药箱液位指示
     */
    @TableField("oneTankLevel")
    private String oneTankLevel;

    /**
     * 2#加药箱液位指示
     */
    @TableField("twoTankLevel")
    private String twoTankLevel;

    /**
     * 3#加药箱液位指示
     */
    @TableField("threeTankLevel")
    private String threeTankLevel;

    /**
     * 4#加药箱液位指示
     */
    @TableField("fourTankLevel")
    private String fourTankLevel;

    /**
     * 5#加药箱液位指示
     */
    @TableField("fiveTankLevel")
    private String fiveTankLevel;

    /**
     * 提升泵1工作指示
     */
    @TableField("liftPumpOne")
    private String liftPumpOne;

    /**
     * 1#搅拌工作指示
     */
    @TableField("oneStirWork")
    private String oneStirWork;

    /**
     * 2#搅拌工作指示
     */
    @TableField("twoStirWork")
    private String twoStirWork;

    /**
     * 3#搅拌工作指示
     */
    @TableField("threeStirWork")
    private String threeStirWork;

    /**
     * 4#搅拌工作指示
     */
    @TableField("fourStirWork")
    private String fourStirWork;

    /**
     * 空压机运行指示
     */
    @TableField("airCompressorOpera")
    private String airCompressorOpera;

    /**
     * 溶气泵运行指示
     */
    @TableField("airPumpOpera")
    private String airPumpOpera;

    /**
     * 刮泥运行指示
     */
    @TableField("mudScraperOpera")
    private String mudScraperOpera;

    /**
     * 一级膜系统运行指示
     */
    @TableField("oneSysOpera")
    private String oneSysOpera;

    /**
     * 膜系统运行指示
     */
    @TableField("twoSysOpera")
    private String twoSysOpera;

    /**
     * 系统报警指示
     */
    @TableField("systemAlarm")
    private String systemAlarm;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
