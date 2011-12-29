/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bridgeport.fractions;

/**
 *
 * @author Mohammad Typaldos [mohammad at reliablerabbit.com]
 */
class Fraction {
    double numerator;
    double denominator;
    
    // TODO: simplify method (because of adding method)
    
    public Fraction(double newNumerator, double newDenominator) {
        setNumerator(newNumerator);
        setDenominator(newDenominator);
    }
    
    public Fraction multiply(Fraction otherFraction){
        return(
                new Fraction(
                        this.getNumerator()   * otherFraction.getNumerator(),
                        this.getDenominator() * otherFraction.getDenominator()
                        )
                );
    }
    
    public Fraction divide(Fraction otherFraction){
        return(
                new Fraction(
                        this.getNumerator()   * otherFraction.getDenominator(),
                        this.getDenominator() * otherFraction.getNumerator()
                        )
                );
    }
    
    public Fraction add(Fraction otherFraction){
        Fraction f = new Fraction(1,1);
        f.setNumerator(
                this.getNumerator() * otherFraction.getDenominator() + 
                otherFraction.getNumerator() * this.getDenominator()
                );
        f.setDenominator(
                this.getDenominator() * otherFraction.getDenominator()
                );
        return f;
    }
    
    public Fraction subtract(Fraction otherFraction){
        Fraction f = new Fraction(1,1);
        f.setNumerator(
                this.getNumerator() * otherFraction.getDenominator() -
                otherFraction.getNumerator() * this.getDenominator()
                );
        f.setDenominator(
                this.getDenominator() * otherFraction.getDenominator()
                );
        return f;
    }
    
    public Fraction withDenominator(double newDenominator){
        double multiplier = newDenominator/this.getDenominator();
        Fraction multiply = new Fraction(multiplier, multiplier);
        return this.multiply(multiply);
    }
    
    public double getNumerator(){
        return numerator;
    }
    
    public double getDenominator(){
        return denominator;
    }

    public void setNumerator(double newNumerator) {
        numerator = newNumerator;
    }

    public void setDenominator(double newDenominator) {
        if(newDenominator == 0){
            throw new UnsupportedOperationException("Zeros are not allowed as a denominator");
        } else {
            denominator = newDenominator;
        }
    }
    
    public double getDouble(){
        return numerator/denominator;
    }
    
    @Override
    public String toString(){
        return getNumerator() + " over " + getDenominator() + " = " + String.valueOf(getDouble());
    }
}
