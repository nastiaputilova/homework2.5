package com.company;

import java.util.Objects;

public class LoginPasswordCheck {

    private static final String validSymbols = "abcdefghijklmnopqrstuvwxyz1234567890_";

    private LoginPasswordCheck(){
    }

    public static boolean check(String login,
                                 String password,
                                 String confirmPassword){

        try{
            validate(login, password, confirmPassword);
            return true;
        } catch (WrongLoginException | WrongPasswordException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    private static void validate (String login,
                                 String password,
                                 String confirmPassword) throws WrongLoginException, WrongPasswordException{
        if (Objects.isNull(login) || login.length() > 20 || hasValidSymbols(login)){
            throw new WrongLoginException("Слишком длинный логин");
        }
        if (Objects.isNull(password) || password.length() > 20 || hasValidSymbols(password)){
            throw new WrongPasswordException("Слишком длинный пароль");
        }
        if (!password.equals(confirmPassword)){
            throw new WrongPasswordException("Пароли не совпадают");
    }
    }

    private static boolean hasValidSymbols(String s){
        char[] symbols = s.toCharArray();
        for (char symbol : symbols){
                if(!validSymbols.contains(String.valueOf(symbol))){
                    return false;
                }
                
            }
        return true;
}
}
