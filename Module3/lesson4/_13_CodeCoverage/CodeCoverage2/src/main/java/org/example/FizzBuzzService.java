package org.example;

public class FizzBuzzService {
    /**
     * Returns "Fizz" for multiples of 3, "Buzz" for multiples of 5,
     * and "FizzBuzz" for multiples of 3 and 5.
     *
     * @param i
     * @return
     */
    public String fizzBuzz(int i) {
        if (i % 15 == 0) {
            return "FizzBuzz";
        } else if (i % 3 == 0) {
            return "Fizz";
        } else if (i % 5 == 0) {
            return "Buzz";
        } else {
            return "" + i;
        }
    }

}
