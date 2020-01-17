package com.codewithinoussa.Generics;

public class Main {
    public static void main(String[] args){
    var list  = new BadSolutionWithObjectType();
    list.add(1); //Integer.valueOf(1)  to convert
    list.add("Hi");
   /* list.add(new User());
    var list1 =  new GenericList<User>();
    list1.add(new User());
    User number  =  list1.get(0);*/

    GenericList<Integer> numbers = new GenericList<>();
    numbers.add(1); //Boxing i.e the java compiler is going to put the value 1 inside the box
    int number1 = numbers.get(0); // called unboxing;
    var user1 = new User(10);
    var user2 = new User(20);

    if (user1.compareTo(user2) < 0)
        System.out.println("user1 < user2");
    else if (user1.compareTo(user2) == 0)
        System.out.println("user1 == user2");
    else
        System.out.println("user1 > user2");

    //var max = Utils.max(0,2);
    var max = Utils.max(new User(10),new User(20)); // then to override the toString method

    System.out.println(max);
    Utils.print(1, 10);
// User user  = new Instructor(10); possible bc an instructor is a type of user
    User user  = new Instructor(10);
    Utils.printUser(new Instructor(30));

    var users = new GenericList<Instructor>();
    Utils.printUsers(new GenericList<User>());
    }
}
