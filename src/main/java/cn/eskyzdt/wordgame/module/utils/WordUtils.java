package cn.eskyzdt.wordgame.module.utils;

import java.util.regex.Pattern;

public class WordUtils {

    /**
     * 判断一个字符串和正则表达式是否匹配
     *
     * @param match 匹配规则,一个正则表达式
     * @param string 待匹配的字符串
     * @return 匹配的结果,匹配为true,不匹配为false
     */
    public static boolean styleCheck(String match, String string) {
        Pattern compile = Pattern.compile(match);
        boolean result = compile.matcher(string).matches();
        return result;
    }
}
