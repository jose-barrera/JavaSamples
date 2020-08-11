package com.jlbc.mathabs;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

/**
 *
 * @author Dr. José Luis Barrera Canto
 * 
 */
public class Main 
{
    public static void main(String[] args) throws IOException 
    {
        // Variables to measure time
        Instant general_start, general_finish;
        Instant particular_start, particular_finish;
        long particular_time;
        long max_time = Long.MIN_VALUE;
        long min_time = Long.MAX_VALUE;
        long problems_time = 0;
        
        // Create the 10-problem array and initialize it
        Problem[] problems = new Problem[10];
        
        System.out.println("Welcome to the MathAbs competition.");
        System.out.println("");
        System.out.println("You will be presented with basic arithmetic problems, and");
        System.out.println("all you have to do is using only your brain, solve the problem");
        System.out.println("and enter your answer.");
        System.out.println("");
        System.out.println("When you're ready, press ENTER to begin.");
        System.in.read();

        // Loop to create the problem, display and keep score
        int correct = 0;
        Scanner input = new Scanner(System.in);
        // Start general timer
        general_start = Instant.now();
        for (Problem problem : problems)
        {
            // Create an instance and display the problem
            problem = new Problem();
            System.out.print(String.valueOf(problem.getA()) + " " + 
                    String.valueOf(problem.getOperator()) + " " + 
                    String.valueOf(problem.getB()) + " = ");
            
            // Start particular timer
            particular_start = Instant.now();
            // Wait for answer
            problem.setAnswer(input.nextInt());
            // Finish particular timer
            particular_finish = Instant.now();
            
            // Update the correct problem score 
            correct += problem.getResult() ? 1 : 0;
            
            // Check if it is min or max time
            particular_time = Duration.between(particular_start, particular_finish).toMillis();
            problems_time += particular_time;
            if (particular_time < min_time)
            {
                min_time = particular_time;
            }
            if (particular_time > max_time)
            {
                max_time = particular_time;
            }
        }
        // Finish general timer
        general_finish = Instant.now();
        
        // Display statistics
        System.out.println("");
        System.out.println("TOTAL TIME: " + Duration.between(general_start, general_finish).toMillis() / 1000f + " segundos.");
        System.out.println("AVERAGE TIME: " + problems_time / 10f / 1000f + " segundos.");
        System.out.println("BEST TIME: " + min_time / 1000f + " segundos.");
        System.out.println("WORST TIME: " + max_time / 1000f + " segundos.");
        System.out.println("SUCCESS RATIO: " + (int)(correct / 10f * 100f) + "%");
    }
}
