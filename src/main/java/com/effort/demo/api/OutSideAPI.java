package com.effort.demo.api;

import com.elinter.modules.utils.Result;
import com.wordnik.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;

@RequestMapping("smaCard")
@RestController
@Api(value = "SMACardController", description = "sma定制接口")
public class OutSideAPI {

    private Logger logger = LoggerFactory.getLogger(OutSideAPI.class);

    @RequestMapping(value = "info/{iccid}", method = RequestMethod.GET)
    @ApiOperation(value = "info", notes = "根据iccid查询卡信息", httpMethod = "GET", produces =
            MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "iccid", value = "物联卡号", required = true,
                    dataType = "String", paramType = "path")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "查询失败")
    })
    public Result getCardInfo(@PathVariable("iccid") String iccid) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {

        return Result.error(1, "查询失败");
    }

}
