package com.codewithinoussa.BestPriceFinderProject;
/*
Here we need 2 thinks: The 'name' of the website and the 'price' they are offering
 */
public class Quote {

    private final String site;
    private final int price; //double in real world project

    public Quote(String site, int price) {
        this.site = site;
        this.price = price;
    }

    public String getSite() {
        return site;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "site='" + site + '\'' +
                ", price=" + price +
                '}';
    }
}
