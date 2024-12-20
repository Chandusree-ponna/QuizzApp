package quizzApplication;

import java.util.Scanner;

public class QuizApp {
	    public static void main(String[] args) {
	    	
	        Scanner sc = new Scanner(System.in);

	        // Collect player details
	        Volunteer p = new Volunteer();
	        try {
	        System.out.println("Enter your name:");
	        p.name = sc.nextLine();
	        System.out.println("Enter your email:");
	        p.email = sc.nextLine();
	        System.out.println("Enter your place:");
	        p.place = sc.nextLine();
	        System.out.println("Enter your mobilenumber:");
	        p.mobilenumber = sc.nextLine();
	        System.out.println("Enter your address:");
	        p.address = sc.nextLine();

	        System.out.println("Hi " + p.name + ", are you ready to take the quiz? (yes/no)");
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}
	        String response = sc.nextLine();
	        if (!response.equalsIgnoreCase("yes")) {
	            System.out.println("Thank you! See you next time.");
	            sc.close();
	            return;
	        }

	        // Display rules
	        System.out.println("\nQuiz Rules:");
	        System.out.println("1. Each question has 4 options.");
	        System.out.println("2. You have 2 lifelines to use, but they can be used only once.");
	        System.out.println("3. Each correct answer earns you points.");
	        System.out.println("4. You can quit anytime or continue until you finish the quiz.");
	       
	        // Start the quiz
	        String[][] questions = {
{"What is the jersy number of viratkohli?", "1. 12", "2. 20", "3. 18", "4. 15" , "3"},
{"What is 10 + 12?", "1. 26", "2. 22", "3. 28", "4. 50", "2"},
{"who is our prime minister?","1.jagan","2.pawankalyan","3.narendhra modhi","4.Rahulgandhi" , "3"},
{"who invented bulb?","1.Thomosalvaedision","2.grahembel","3.gennisritche","4.james" ,"1"},
{"how many hours are there in a day?","1.26","2.30","3.12","4.24" , "4"},
{"what is the capital of japan?","1.beijing","2.tokyo","3.seoul","4.yangtz", "2"},
{"who invented java?","1.james josling","2.dennisritche","3.guidovan russum","4.benerji" ,"1"},
{"what is the extension for java code?","1.py","2.txt","3.class","4.java","4"},
{"how many keywords are there in java?","1.20","2.53","3.48","4.40", "2"},
{"which is the national friut given below?","1.mango","2.orange","3.banana","4.apple","1"}
	        };

	        String[] lifelines = {"50-50", "Ask the Audience"};

	        for (int i = 0; i < questions.length; i++) {
	            System.out.println("\nQuestion " + (i + 1) + ": " + questions[i][0]);
	            System.out.println(questions[i][1]);
	            System.out.println(questions[i][2]);
	            System.out.println(questions[i][3]);
	            System.out.println(questions[i][4]);

	            System.out.println("Enter your answer (or type 'lifeline' to use one):");
	            String answer = sc.nextLine();

	            if (answer.equalsIgnoreCase("lifeline")) {
	                if (p.lifelineUsed1 && p.lifelineUsed2) {
	                    System.out.println("Sorry, you have already used all lifelines.");
	                } else {
	                    System.out.println("Available lifelines:");
	                    if (!p.lifelineUsed1) System.out.println("1. " + lifelines[0]);
	                    if (!p.lifelineUsed2) System.out.println("2. " + lifelines[1]);

	                    System.out.println("Choose a lifeline:");
	                    int choice = sc.nextInt();
	                    sc.nextLine(); // Consume the newline character

	                    if (choice == 1 && !p.lifelineUsed1) {
	                        p.lifelineUsed1 = true;
	                        System.out.println("50-50 lifeline used! Two options remain: ");
	                        System.out.println(questions[i][2] + " and " + questions[i][3]); // Example simplification
	                    } else if (choice == 2 && !p.lifelineUsed2) {
	                        p.lifelineUsed2 = true;
	                        System.out.println("Audience suggests option " + questions[i][5]);
	                    } else {
	                        System.out.println("Invalid or already used lifeline. Choose another.");
	                        i--; // Re-attempt the same question
	                        continue;
	                    }
	                }

	                System.out.println("Enter your answer:");
	                answer = sc.nextLine();
	            }

	            if (answer.equals(questions[i][5])) {
	                System.out.println("Correct answer!");
	                p.score += 10; // Reward points
	            } else {
	                System.out.println("Wrong answer. The correct answer was option " + questions[i][5]);
	                System.out.println("You have won " + p.score + " points.");
	                break;
	            }
	        }
	           
	        System.out.println("\nThank you for playing, " + p.name + "!");
	        System.out.println("Your final score is: " + p.score);
	        sc.close();
	    }
	}