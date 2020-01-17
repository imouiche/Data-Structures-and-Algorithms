package com.codewithinoussa.Generics;
/*
we can impl a generic method inside a non generic class
 */
public class Utils {
    //max method
  /*  public static int max(int first, int second){
        return (first > second)? first : second; //returning operator
    }*/
    //considering all variable types
    public static <T extends Comparable<T>> T max(T first, T second){
        return (first.compareTo(second) > 0) ? first : second;
    }
// Multiple parameters
    public static <K, V> void print(K key, V value){
        System.out.println( key + " = " + value);
    }

    public static void printUser(User user){
        System.out.println(user);
    }
    //print list of users
// with '?' user.get will return an instance of CAP#1 {} ie capture class
    // Object x = users.get(0) is what happen when we use the wildcard
    // class CAP#1 extends User {}
    //class Instructor extends User {}
    // then we can only pass a list of User or sub type of User
    // public static void printUsers(GenericList<? extends User> users)
    public static void printUsers(GenericList<? super User> users){
        /*
         cannot add when we use the extend keyword, the we need to use the super keyword
         in order to use the parent class ie Object class
         GenericList<Object> temp = new GenericList<>()
         */
        users.add(new User(10));
        users.add(new Instructor(10));
        /*
        However with super keyword we cannot read from User class as we could not add with extends keyword
        ie User x = users.get(0);
         */
        Object x = users.get(0);
    }
}
