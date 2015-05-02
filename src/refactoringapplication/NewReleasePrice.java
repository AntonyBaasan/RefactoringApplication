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
public class NewReleasePrice extends Price{
    int getPriceCode(){
        return Movie.NEW_RELEASE;
    }
    
    double getCharge(int daysRented){
        return daysRented * 3;
    }
    
    int getFrequentRenterPoints(int daysRented){
        return (daysRented > 1) ? 2 : 1;
    }
}