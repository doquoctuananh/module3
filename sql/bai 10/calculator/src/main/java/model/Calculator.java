package model;

public class Calculator {
    public static double caculator(String option,double first,double second) {
        double result=0;
        switch (option){
            case "add":{
                result= first + second;
                break;
            }
            case "subtraction":{
                result = first - second;
                break;
            }
            case"division" :{
//                try{
//                    result= first / second;
//                }
//                catch(ArithmeticException e){
//                    e.printStackTrace();
//                }
                result= first / second;
                break;
            }
        }
        return result;
    }
}
