package com.anicompany.fixtures;

import com.anicompany.bizlogic.Calculator;

/**
 * Created by Anirban on 4/20/2014.
 */
public class FDivisionProgram extends BaseSlim{
    private float numerator;
    private float denominator;
    private float quotient;

    public void setNumerator(float numerator)
    {
        this.numerator = numerator;
    }

    public void setDenominator(float denominator)
    {
        this.denominator = denominator;
    }

    /**
     * called after each row's setters, but is executed before (any) getters
     */
    public void execute()
    {
        Calculator calculator = new Calculator(this.numerator, this.denominator);
        this.quotient = calculator.getQuotient();
    }

    public float quotient()
    {
        return this.quotient;
    }
}
