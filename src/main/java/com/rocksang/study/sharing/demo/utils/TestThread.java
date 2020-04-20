package com.rocksang.study.sharing.demo.utils;

import org.springframework.util.ObjectUtils;

/**
 * @Author: Rock Sang
 * @Date: 2020/4/20 3:04 下午
 */
public class TestThread {



    public static void main(String[] args) {
        final Object lock = new Object();

        boolean isUpper = true;

        new Task(lock,isUpper,"线程1").run();
        new Task(lock,isUpper,"线程2").run();
        new Task(lock,isUpper,"线程3").run();

    }
}

class Task implements Runnable{

    private Object obj;
    private  boolean isUpper;
    private String name;
    public Task(Object obj,boolean isUpper,String name){
        this.obj = obj;
        isUpper = isUpper;
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (obj) {
            for (int i = 0; i < 26; i++) {

                if(isUpper){
                    //小写a~z
                    System.out.println( name+(char) (97 + i));
                    isUpper = false;
                }else{
                    //大写A~Z
                    System.out.println(name+(char) (65 + i));
                    isUpper = true;
                }

                try {
                    obj.wait(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
