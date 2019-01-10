package cn.lang.server.utils;

import java.util.Random;

public class RandomUtils {
    static char[] chars = new char[52];
    static {
        for (int i=0;i<26;i++){
            chars[i]=(char)(i+97);
        }
        for(int i=26;i<=51;i++){
           chars[i]=(char)(i+39);
        }
    }
    public static String randomwPwd(int length){
        StringBuffer stringBuffer = new StringBuffer();
        for (int i=1;i<=length;i++){
            int ranInt = new Random().nextInt(52);
            stringBuffer.append(chars[ranInt]);
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(RandomUtils.randomwPwd(1000));
    }
}
