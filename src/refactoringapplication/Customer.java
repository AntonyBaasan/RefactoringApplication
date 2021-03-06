/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refactoringapplication;

import java.util.Enumeration;
import java.util.Vector;

/**
 *
 * @author A
 */
public class Customer {
    private String _name;
    private Vector _rentals = new Vector();
    
    public Customer(String name)
    {
        _name = name;
    }
    
    public void addRental(Rental arg)
    {
        _rentals.addElement(arg);
    }
    
    public String getName(){
        return _name;
    }
    
    public String statement(){
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for "+getName()+"\n";
        while(rentals.hasMoreElements())
        {
            Rental each = (Rental) rentals.nextElement();
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }
        
        //add footer line
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        
        return result;
    }
    
    public String htmlStatement(){
        Enumeration rentals = _rentals.elements();
        String result = "<h1>Rental Record for <EM>"+getName()+"</EM><h1><p>\n";
        while(rentals.hasMoreElements())
        {
            Rental each = (Rental) rentals.nextElement();
            //show figures for this rental
            result += each.getMovie().getTitle() + ": " + String.valueOf(each.getCharge()) + "<br>\n";
        }
        
        //add footer line
        result += "<p>You owed <EM>" + String.valueOf(getTotalCharge()) + "<EM><p>\n";
        result += "On this rental you earned <EM>" + String.valueOf(getTotalFrequentRenterPoints()) + "<EM> frequent renter points<p>";
        
        return result;
    }

    public double getTotalCharge(){
        double result = 0;
        Enumeration rentals = _rentals.elements();
        while(rentals.hasMoreElements())
        {
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }
    
    private int getTotalFrequentRenterPoints(){
        int result = 0;
        Enumeration rentals = _rentals.elements();
        while(rentals.hasMoreElements())
        {
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }
}
