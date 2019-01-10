package cn.lang.server.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class RandomUtils {
    static Logger logger = LoggerFactory.getLogger(RandomUtils.class);
    static char[] chars;
    static {
        ArrayList<Character> characters = new ArrayList<>();

//        for (int i=97;i<97+26;i++){
//            characters.add((char)i);
//        }
        for(int i=65;i<123;i++){
            characters.add((char)i);
        }
        for (int i=48;i<48+10;i++){
            characters.add((char) i);
        }
        characters.add('!');
        characters.add('@');
        characters.add('#');
        characters.add('$');
        characters.add('%');
        characters.add('^');
        characters.add('&');
        characters.add('*');
        characters.add('(');
        characters.add(')');
        characters.add('_');
        characters.add('+');
        chars = new char[characters.size()];
        for (int i=0;i<characters.size();i++){
            chars[i]=characters.get(i);
        }


    }
    public static String randomwPwd(int length){
        StringBuffer stringBuffer = new StringBuffer();
        for (int i=1;i<=length;i++){
            int ranInt = new Random().nextInt(chars.length);
            stringBuffer.append(chars[ranInt]);
        }
        String pwd = stringBuffer.toString();
        logger.info("随机密码={}", pwd);
        return pwd;
    }

    public static void main(String[] args) {
        System.out.println(chars);

        System.out.println(RandomUtils.randomwPwd(1000));
    }
}
