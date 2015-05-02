/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refactoringapplication;

/**
 *
 * @author A
 */
public class Movie {
    
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    
    private String _title;
    private Price _price;
    
    public Movie(String title, int priceCode){
        _title = title;
        setPriceCode(priceCode);
    }

    /**
     * @return the _priceCode
     */
    public int getPriceCode() {
        return _price.getPriceCode();
    }

    /**
     * @param _priceCode the _priceCode to set
     */
    public void setPriceCode(int priceCode) {
        switch(priceCode)
        {
            case Movie.REGULAR:
                _price = new RegularPrice();
                break;
            case Movie.NEW_RELEASE:
                _price = new NewReleasePrice();
                break;
            case Movie.CHILDRENS:
                _price = new ChildrensPrice();
                break;
        }
    }

    /**
     * @return the _title
     */
    public String getTitle() {
        return _title;
    }
    
    public double getCharge(int daysRented)
    {
        return _price.getCharge(daysRented);
    }
    
    public int getFrequentRenterPoints(int daysRented){
        return _price.getFrequentRenterPoints(daysRented);
        
        //add frequent renter points
        if((getPriceCode() == Movie.NEW_RELEASE)
                && daysRented> 1)
            return 2;
        else
            return 1;
    }
}
