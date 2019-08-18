package com.cutelife.basic;

/**
 * Description:
 * User: tale@wacai.com
 *
 * @author: tale
 * Date: 2019-06-01
 * Time: 下午10:36
 * <p>
 * 回首向来萧瑟处，归去，也无风雨也无晴。
 * ----- 苏轼
 */
public class User {

    private Integer age;
    private String name;
    public User(Integer age,String name){

        this.age = age;
        this.name = name;

    }

    @Override
    public boolean equals(Object user){

        if(user == null){
            return false;
        }

        if(!(user instanceof User)){
            return false;
        }

        if(this == user){
            return true;
        }

        User us = (User) user;

        if(us.name.equals(this.name) && us.age.intValue() == this.age.intValue()){
            return true;
        }
        return false;
    }

    public static void main(String args[]){

        String s1= "user";
        String s2= "user";
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));



    }
}
