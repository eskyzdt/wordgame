package cn.eskyzdt.wordgame.module.exception;

/**
 * 自定义异常类
 *
 * @author dongtian
 * @since 2020/6/10
 */
public class WrongException extends RuntimeException {

    public WrongException() {
    }

    public WrongException(String message) {
        super(message);
    }
}
