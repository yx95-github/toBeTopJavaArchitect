package com.rocksang.study.sharing.demo.utils;

import com.alibaba.fastjson.JSON;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Rock Sang
 * @Date: 2020/4/15 10:45 上午
 */
public class UppercaseUtils {

    public static void main(String[] args) {

        getUserNameCombinationList();

//        String test1 = "asdqweWadfaçsa iqw ıasda ğJJöş";
//        System.out.println(uppercaseText(test1));
//
//        String test2 = "Wadfaçsa i2qw ıasda ğJJöş";
//        System.out.println(uppercaseText(test2));
//
//        String test3 = "asdqweWadfaçsa iqw ıasda ğJJöş$   ";
//        System.out.println(uppercaseText(test3));
    }

    private static String uppercaseText(String text){
        StringBuffer stringBuf = new StringBuffer();
        for (int i = 0; i < text.length(); i++) {
            switch (text.charAt(i)) {
                case 'ç': stringBuf.append('Ç') ; break;
                case 'i': stringBuf.append('İ') ; break;
                case 'ı': stringBuf.append('I') ; break;
                case 'ü': stringBuf.append('Ü') ; break;
                case 'ğ': stringBuf.append('Ğ') ; break;
                case 'ö': stringBuf.append('Ö') ; break;
                case 'ş': stringBuf.append('Ş') ; break;
                default : stringBuf.append(text.charAt(i)) ; break;
            }
        }

        return stringBuf.toString().toUpperCase();
    }

    private static void getUserNameCombinationList(){

        String firstName = "rock";
        String middleName = "tomğJJöş";
        String lastName = "ıSang";

        // 校验：first_name 和 last_name 不能为空
        if(StringUtils.isEmpty(firstName) || StringUtils.isEmpty(lastName)){
            return ;
        }

        List<String> userNameCombinationList = new ArrayList<>();


        // 场景一：middle_name为空
        userNameCombinationList.add(uppercaseText(firstName+" "+lastName));

        // 场景二：middle_name不为空
        if(!StringUtils.isEmpty(middleName)){
            // 最标准的模式
            userNameCombinationList.add(uppercaseText(firstName+" "+middleName+" "+lastName));
            // 缩略形式1
            userNameCombinationList.add(uppercaseText(firstName+" "+middleName.substring(0,1)+". "+lastName));
            // 缩略形式2
            userNameCombinationList.add(uppercaseText(firstName+" "+middleName.substring(0,1)+" "+lastName));
            // 土耳其女性结婚后可能把原来的姓放在中间名
            userNameCombinationList.add(uppercaseText(firstName+" "+middleName));
        }

        System.out.printf(JSON.toJSONString(userNameCombinationList));
    }
}
