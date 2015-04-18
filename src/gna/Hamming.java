package gna;

/**
 * Created by louis on 18/04/2015.
 * http://blogs.ucl.ac.uk/chime/2010/06/28/java-example-code-of-common-similarity-algorithms-used-in-data-mining/
 */
public class Hamming
{
    private String compOne;
    private String compTwo;

    public Hamming(String one, String two)
    {
        compOne = one;
        compTwo = two;
    }

    public int getHammingDistance()
    {
        if (compOne.length() != compTwo.length())
        {
            return -1;
        }

        int counter = 0;

        for (int i = 0; i < compOne.length(); i++)
        {
            if (compOne.charAt(i) != compTwo.charAt(i)) counter++;
        }

        return counter;
    }

    ///
// Hamming distance works best with binary comparisons, this function takes a string arrary of binary
// values and returns the minimum distance value
///
    public int minDistance(String[] numbers)
    {
        int minDistance = Integer.MAX_VALUE;

        if (checkConstraints(numbers))
        {
            for (int i = 1; i < numbers.length; i++)
            {
                int counter = 0;
                for (int j = 1; j <= numbers[i].length(); j++)
                {
                    if (numbers[i-1].charAt(j-1) != numbers[i].charAt(j-1))
                    {
                        counter++;
                    }
                }

                if (counter == 0) return counter;
                if (counter < minDistance) minDistance = counter;
            }
        }
        else
        {
            return -1;
        }

        return minDistance;
    }

    private Boolean checkConstraints(String[] numbers)
    {
        if (numbers.length > 1 && numbers.length <=50)
        {
            int prevLength = -1;
            for (String number : numbers) {
                if (number.length() > 0 && number.length() <= 50) {
                    if (prevLength == -1) {
                        prevLength = number.length();
                    } else {
                        if (prevLength != number.length()) {
                            return false;
                        }
                    }

                    for (int j = 0; j < number.length(); j++) {
                        if (number.charAt(j) !=‘0’ && number.charAt(j) !=‘1’)
                        {
                            return false;
                        }
                        loop;
                    }
                } else {
                    return false;
                }
            }
        }
        else
        {
            return false;
        }

        return true;
    }
}