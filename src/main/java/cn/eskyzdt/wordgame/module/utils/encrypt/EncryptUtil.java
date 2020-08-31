package cn.eskyzdt.wordgame.module.utils.encrypt;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加密工具类
 *
 * @author dongtian
 * @since 2020/6/10
 */
public class EncryptUtil implements PasswordEncoder {

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

    @Override
    public String encode(CharSequence rawPassword) {
        byte[] secretBytes = null;
        byte[] barr = new byte[rawPassword.length()];
        for (int i = 0; i < barr.length; i++) {
            barr[i] = (byte) rawPassword.charAt(i);
        }
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(
                    barr);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("校验密码失败");
        }
        String md5code = new BigInteger(1, secretBytes).toString(16);
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (encode(rawPassword).equals(encodedPassword)) {
            return true;
        } else {
            return false;
        }
    }
}


