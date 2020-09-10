package com.kh.jkdw.controller;


import com.kh.jkdw.annotation.DataSource;
import com.kh.jkdw.config.DataSourceNames;
import com.kh.jkdw.enums.StatusCodeEnum;
import com.kh.jkdw.model.CentralControl;
import com.kh.jkdw.model.vo.ResponseResult;
import com.kh.jkdw.service.CentralControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Documented;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author kaihua
 * @since 2020-09-09
 */
@RestController
@RequestMapping("/cangLong")
public class CentralControlController {

    @Autowired
    private CentralControlService centralControlService;

    @ResponseBody
    @PostMapping(value = "/centralMsgPull")
    public ResponseResult insert(@RequestBody CentralControl centralControl){
        return centralControlService.insert(centralControl);
    }
}
