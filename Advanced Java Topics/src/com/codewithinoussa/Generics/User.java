package com.codewithinoussa.Generics;

public class User implements Comparable<User> {
    private int points;

    public User(int points){
        this.points = points;
    }

  /*  public User(){
        points = 0;
    }*/

    @Override
    public int compareTo(User other) {
        // if this < 0 -> return -1
        // if this == 0 -> return 0
        // if this > 0 -> return 1/ any positive number

/*        if (points < other.points)
            return -1;
        if (points == other.points)
            return 0;
        return 2;*/
        return points - other.points;
    }

    @Override
    public String toString(){
        return "Points= " + points;
    }
}
