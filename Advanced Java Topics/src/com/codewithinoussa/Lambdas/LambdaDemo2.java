package com.codewithinoussa.Lambdas;

public class LambdaDemo2 {
    //method signature of our interface
   // public static void print(String message){}
    public void print(String message){}
    public static void show() {
      /*greet(message -> print(message));
      greet(LambdaDemo2::print);*/

      //what if we rather have an instance of the interface class ie print not longer a static method, then

       // var demo = new LambdaDemo2();
       /* greet(message -> demo.print(message));
        greet(demo::print);*/

        // what about passing a message to an constructor?
       /* greet(message -> new LambdaDemo2(message));
        greet(LambdaDemo2::new);*/
    }

    // what about passing a message to an constructor?
    public LambdaDemo2(String message){

    }

    //programming against the interface "Printer"
    public static void greet(Printer printer){
        System.out.println("Hello World ref mthd");
    }
}
