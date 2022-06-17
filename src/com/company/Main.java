package com.company;

public class Main {

    public static void main(String[] args) {

       boolean result =  LoginPasswordCheck.check("test", "test", "test");
       if(result){
       System.out.println(":)");
    }else{
           System.out.println(":(");
       }


}
}
