package com.kh.jkdw.service.impl;

import com.kh.jkdw.enums.StatusCodeEnum;
import com.kh.jkdw.model.CentralControl;
import com.kh.jkdw.mapper.CentralControlMapper;
import com.kh.jkdw.model.vo.ResponseResult;
import com.kh.jkdw.service.CentralControlService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kaihua
 * @since 2020-09-09
 */
@Service
public class CentralControlServiceImpl extends ServiceImpl<CentralControlMapper, CentralControl> implements CentralControlService {

    @Resource
    private CentralControlMapper centralControlMapper;

    @Override
    public ResponseResult insert(CentralControl centralControl) {
        int insert = centralControlMapper.insert(centralControl);
        if (insert > 0){
            return ResponseResult.success(StatusCodeEnum.SUCCESS);
        }else {
            return ResponseResult.failure(StatusCodeEnum.INSERT_FAILURE);

        }
    }


    /*@Override
    public int insert(CentralControl centralControl) {
        return centralControlMapper.insert(centralControl);
    }
*/}
