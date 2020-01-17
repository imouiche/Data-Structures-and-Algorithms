package com.codewithinoussa.List;

import java.util.*;

//interface to compare two emails
public class EmailComparator  implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        return o1.getEmail().compareTo(o2.getEmail());
    }
}
