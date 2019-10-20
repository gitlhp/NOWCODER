package com.lhp.coder;

/**
 * @ClassName: Code2
 * @Description:替换空格
 * @Author: lhp
 * @Date: 2019/10/20 20:33
 * @Version: V1.0
 **/
public class Code2 {
    public String replaceSpace(StringBuffer str) {
        return str.toString().replaceAll(" ","%20");
    }

    public static void main(String[] args) {
        Code2 code2 = new Code2();
        StringBuffer stringBuffer = new StringBuffer("we are happy");
        System.out.println(code2.replaceSpace(stringBuffer));
    }
}
