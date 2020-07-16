

/**
 * This is a Class to Calculate the sum of two numbers and compare it
 */
public class MathModel {

    /**
     * Calculate sum of two number and compare
     * @param x first number
     * @param y second number
     * @param sumNumber third number
     * @return true if x + y = sumNumber
     */
    public boolean compare(int x, int y, int sumNumber)
    {
        if((x + y) == sumNumber)
            return true;
        else
            return false;
    }

}
