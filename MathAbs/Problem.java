package com.jlbc.mathabs;

import java.util.Random;

/**
 *
 * @author Dr. José Luis Barrera Canto
 * 
 */

public class Problem 
{
    // <editor-fold desc="PRIVATE FIELDS">
    
    private static final Random random = new Random();
    private final int a;
    private final int b;
    private final char operator;
    private final int solution;
    private int answer;
    
    // </editor-fold>
    
    // <editor-fold desc="CONSTRUCTORS">
    
    public Problem()
    {
        this.a = random.nextInt(89) + 11;
        this.b = random.nextInt(89) + 11;
        switch(random.nextInt(3))
        {
            case 0: 
                this.operator = '+'; 
                this.solution = this.a + this.b;
                break;
            case 1: 
                this.operator = '-'; 
                this.solution = this.a - this.b;
                break;
            default: 
                this.operator = '*'; 
                this.solution = this.a * this.b;
                break;
        }
        this.answer = -1000;
    }
    
    // </editor-fold>
    
    // <editor-fold desc="PUBLIC PROPERTIES">
    
    public int getA()
    {
        return this.a;
    }
    public int getB()
    {
        return this.b;
    }
    public char getOperator()
    {
        return this.operator;
    }
    public int getSolution()
    {
        return this.solution;
    }
    public void setAnswer(int value)
    {
        this.answer = value;
    }
    public boolean getResult()
    {
        return this.solution == this.answer;
    }
    
    // </editor-fold>    
}
