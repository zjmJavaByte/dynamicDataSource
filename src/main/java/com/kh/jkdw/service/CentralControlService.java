package com.kh.jkdw.service;

import com.kh.jkdw.model.CentralControl;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kh.jkdw.model.vo.ResponseResult;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kaihua
 * @since 2020-09-09
 */
public interface CentralControlService extends IService<CentralControl> {

    ResponseResult insert(CentralControl centralControl);
}
