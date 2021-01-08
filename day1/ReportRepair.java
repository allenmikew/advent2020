/**
 * Mike Allen
 * Github: allenmikew
 * 
 * Advent of Code 2020
 * Day 1 - Report Repair
 * 
 * January 8, 2021
 */

package day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Advent of Code - Day 1 - Report Repair
 * 
 * This class contains the methods and algorithms for finding sets of numbers that add up
 * to 2020, and printing the product of those numbers.
 */
public class ReportRepair 
{
    final static String FILE_NAME = "day1/input.txt";
    final static int MAGIC_SUM = 2020;

    /**
     * Reads in a file specified by the class-level static constant FILE_NAME
     * @return an arraylist of input numbers
     */
    private static ArrayList<Integer> readFile() throws FileNotFoundException, IOException
    {
        ArrayList<Integer> expenses = new ArrayList<Integer>();
        File file = new File(FILE_NAME);
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;

        while((line = br.readLine()) != null)
        {
            expenses.add(Integer.parseInt(line));
        }
        
        // close the buffered reader
        br.close();

        return expenses;
    }

    /**
     * Finds two numbers in the input list that sum to 2020 and prints the product
     * Algorithm asymptotic analysis: O(n^2)
     * @param expenses
     */
    private static void findTwoNumbers(ArrayList<Integer> expenses)
    {
        if(expenses == null)
        {
            System.out.println("ArrayList is null.");
            return;
        }

        for(int i = 0; i < expenses.size(); i++)
        {
            for(int j = 0; j < expenses.size(); j++)
            {
                if (i != j)
                {
                    if (expenses.get(i) + expenses.get(j) == MAGIC_SUM)
                    {
                        System.out.println("Result: " + expenses.get(i) * expenses.get(j));
                        return;
                    }
                }
            }
        }
    }

    /**
     * Finds three numbers in the input list that sum to 2020 and prints the product of all three
     * Algoritm analysis: O(n^3)
     * @param expenses 
     */
    private static void findThreeNumbers(ArrayList<Integer> expenses)
    {
        // TODO: find better solution (sort the list?)

        // check to see if the list is null or empty
        if(expenses == null || expenses.size() == 0)
        {
            System.out.println("ArrayList is null.");
            return;
        }

        // find three numbers that sum to 2020 and return their product
        for(int i = 0; i < expenses.size(); i++)
        {
            for(int j = 0; j < expenses.size(); j++)
            {
                if (i != j)
                {
                    // iterate one at a time to get two numbers from the list
                    int iNum = expenses.get(i);
                    int jNum = expenses.get(j);
                
                    // check to make sure the two numbers don't exceed 2020 when summed
                    if (!(iNum + jNum >= MAGIC_SUM))
                    {
                        int temp = MAGIC_SUM - iNum - jNum;

                        // look for the final number in the list to complete the sum to 2020
                        for(int k = 0; k < expenses.size(); k++)
                        {
                            if(expenses.get(k) == temp)
                            {
                                System.out.println("Result: " + (iNum * jNum * expenses.get(k)));
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Main
     */
    public static void main (String[] args)
    {
        // define input list
        ArrayList<Integer> expenses = null;

        // read in the file
        try
        {
            expenses = readFile();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!");
            return;
        }
        catch (IOException e)
        {
            System.out.println("Error reading file contents.");
            return;
        }

        // part one
        findTwoNumbers(expenses);

        // part two
        findThreeNumbers(expenses);
    }
}