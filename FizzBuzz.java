/**
 * Author: Hunter Stennett
 * Version: 2.1
 */
package com.company;
import java.util.Scanner;

/**
 * FizzBuzz class, takes input from user. Asks for integer input between 1-100 for Fizz and for Buzz.
 *      If input is valid (1-100), runs a for loop that prints integers 1-100. Each multiple of
 *      either Fizz input or Buzz input will output Fizz or Buzz instead of number. If it's a multiple
 *      of both, the output is then changed to FizzBuzz;
 * Class Invariant: User input for Fizz and for Buzz must be between 1 and 100;
 */
public class FizzBuzz {
    /**
     * Constants for 'fizz' and 'buzz', both are invalid numbers so that when constructor runs,
     *      it makes boolean invalid true;
     */
    public static final int FIZZ = -1;
    public static final int BUZZ = 101;

    /**
     * Instance Variables for FizzBuzz:
     *      _fizz: input integer;
     *      _buzz: input integer;
     *      _invalid: boolean initial value is true, false with correct input;
     *      _keyboard: Scanner that takes in user input on system console;
     */

    private int _fizz;
    private int _buzz;
    private boolean _invalid;
    private Scanner _keyboard;

    /** No argument constructor, sets to constants and defaults, but it runs dialog
     * at the end. dialog() will run the full program, so essentially all you need to do
     * is create a FizzBuzz object in the Driver.
     */
    public FizzBuzz() {
        setFizz(FIZZ);
        setBuzz(BUZZ);
        _invalid = isInvalid();
        _keyboard = new Scanner(System.in);
        dialog();
    }

    /**
     * Full argument constructor is really un-needed as dialog() will ask for two new integers,
     * and the user wouldn't be inputting the numbers into a constructor anyways due to encapsulation;
     */

    /**
     * Sets the value for '_fizz', error checks parameter;
     * @param xFizz Integer is error checked to make sure that it is between 1-100, sets value to _buzz;
     */
    public void setFizz(int xFizz) {
        if(xFizz > 0 && xFizz <= 100) {
            _fizz = xFizz;
        }
    }

    /**
     * Sets the value for '_buzz', error checks parameter xBuzz;
     * @param xBuzz Integer is error checked to make sure it is between 1-100, sets value to _buzz;
     */
    public void setBuzz(int xBuzz) {
        if(xBuzz > 0 && xBuzz <= 100) {
            _buzz = xBuzz;
        }
    }

    public int getFizz() {
        return _fizz;
    }

    public int getBuzz() {
        return _buzz;
    }

    public boolean isFInvalid() {
        return getFizz() < 0 || getFizz() > 100;
    }

    public boolean isBInvalid() {
        return getBuzz() < 0 || getBuzz() > 100;
    }

    public boolean isInvalid() {
        return isFInvalid() || isBInvalid();
    }

    public void dialog() {
        System.out.println("Enter any number for Fizz between 1-100");
        _fizz = _keyboard.nextInt();
        System.out.println("Enter any number for Buzz between 1-100");
        _buzz = _keyboard.nextInt();
        while (isInvalid()) {
            if(getFizz() < 0 || getFizz() > 100) {
                System.out.println("Invalid Fizz Number. Number must be 1-100");
                _fizz = _keyboard.nextInt();
            } else  {
                while (isBInvalid()) {
                    if(getBuzz() < 0 || getBuzz() > 100) {
                        System.out.println("Invalid Buzz number. Number must be 1-100");
                        _buzz = _keyboard.nextInt();
                    }
                }
            }
        }
        fbLoop();
    }

    public void fbLoop() {
        for (int i = 1; i <= 100; i++) {
            if (i % getFizz() == 0 && i % getBuzz() == 0) {
                System.out.println("FizzBuzz");
            } else if (i % getFizz() == 0) {
                System.out.println("Fizz");
            } else if (i % getBuzz() == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
                //if (!isFInvalid() && !isBInvalid()) {
                // isInvalid() = false;

            }
        }
    }

    @Override
    public String toString() {
        return String.format("Fizz = %d, Buzz = %d", getFizz(), getBuzz());
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        } else if(!(obj instanceof FizzBuzz)) {
            return false;
        }
        FizzBuzz other = (FizzBuzz) obj;

        return this._fizz == other._fizz &&
                this._buzz == other._buzz;
    }

}
