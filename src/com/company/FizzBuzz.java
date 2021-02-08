/**
 * Author: Hunter Stennett
 * Version: 2.2
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

    /**
     * Getter method for '_fizz' instance variable. Returns current value of _fizz;
     * @return _fizz value;
     */
    public int getFizz() {
        return _fizz;
    }

    /**
     * Getter method for '_buzz' instance variable. Returns current value of _buzz;
     * @return _buzz value;
     */
    public int getBuzz() {
        return _buzz;
    }

    /**
     * isFInvalid error checks _fizz, returns true if input number is invalid,
     * returns false if number is valid and can be set to _fizz;
     * @return _fizz is valid or invalid;
     */
    public boolean isFInvalid() {
        return getFizz() < 0 || getFizz() > 100;
    }

    /**
     * isBInvalid error checks _buzz, returns true if input number is invalid,
     * returns false if number is valid and can be set to _buzz;
     * @return _buzz is valid or invalid;
     */
    public boolean isBInvalid() {
        return getBuzz() < 0 || getBuzz() > 100;
    }

    /**
     * isInvalid checks to is if _fizz or _buzz is invalid. If either are invalid,
     * returns true. Otherwise, returns false;
     * @return true if _fizz or _buzz is invalid;
     */
    public boolean isInvalid() {
        return isFInvalid() || isBInvalid();
    }

    /**
     * dialog is a void method that starts the process of getting numbers from the user.
     * First asks for _fizz number input and error checks with isFInvalid(), then asks for
     * _buzz number input and error checks with isInvalid(). Finally, runs the method fbLoop();
     */
    public void dialog() {
        System.out.println("Enter any number for Fizz between 1-100");
        _fizz = _keyboard.nextInt();
        while(isFInvalid()) {
            System.out.println("Invalid Fizz Number. Number must be 1-100");
            _fizz = _keyboard.nextInt();
        }
        System.out.println("Enter any number for Buzz between 1-100");
        _buzz = _keyboard.nextInt();
        while (isInvalid()) {
            System.out.println("Invalid Buzz number. Number must be 1-100");
            _buzz = _keyboard.nextInt();
        }
        fbLoop();
    }

    /**
     * fbLoop() runs the input values through a simple for loop with branching if-else statement.
     * If _fizz AND _buzz values are multiples of current number in the for loop, prints FizzBuzz.
     * Then if _fizz value is multiple it prints Fizz. If _buzz is a multiple for current number in loop,
     * prints Buzz to console, if not prints current value of 'i' in for loop;
     */
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
            }
        }
    }

    /**
     * Overrides toString() method from the Object class. Prints out the values input for
     * _fizz and _buzz;
     * @return String representing current values of _fizz and _buzz
     */
    @Override
    public String toString() {
        return String.format("Fizz = %d, Buzz = %d", getFizz(), getBuzz());
    }

    /**
     * Overrides equals() method from the Object class. Checks if object is null
     * or if it isn't the same class as calling object. Then compares values of
     * _fizz and _buzz. Both are primitive values, so shallow copying isn't an issue;
     * @param obj
     * @return true if _fizz and _buzz values are the same in both FizzBuzz objects;
     */
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
