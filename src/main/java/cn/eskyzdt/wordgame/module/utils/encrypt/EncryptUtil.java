package cn.eskyzdt.wordgame.module.utils.encrypt;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加密工具类
 *
 * @author dongtian
 * @since 2020/6/10
 */
public class EncryptUtil {

    public static String passwordEncrypt(String password) {

        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(
                    password.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("校验密码失败");
        }
        String md5code = new BigInteger(1, secretBytes).toString(16);
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }
}


