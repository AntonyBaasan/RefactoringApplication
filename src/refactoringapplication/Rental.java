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
public class Rental {
    private Movie _movie;
    private int _daysRented;
    
    public Rental(Movie movie, int daysRented)
    {
        _movie = movie;
        _daysRented = daysRented;
    }

    /**
     * @return the _movie
     */
    public Movie getMovie() {
        return _movie;
    }

    /**
     * @return the _daysRented
     */
    public int getDaysRented() {
        return _daysRented;
    }

    public double getCharge()
    {
        return getMovie().getCharge(getDaysRented());
    }
    
    public int getFrequentRenterPoints(){
        //add frequent renter points
        return getMovie().getFrequentRenterPoints(getDaysRented());
    }
}
