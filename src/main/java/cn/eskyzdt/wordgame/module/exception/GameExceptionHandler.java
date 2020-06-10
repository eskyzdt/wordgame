package cn.eskyzdt.wordgame.module.exception;

import cn.eskyzdt.wordgame.module.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 全局异常处理类
 *
 * @author dongtian
 * @since 2020/6/10
 */
@ControllerAdvice
public class GameExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Map exceptionHandler(Exception e) {
        e.printStackTrace();
        return Result.error(e.getMessage());
    }

}
