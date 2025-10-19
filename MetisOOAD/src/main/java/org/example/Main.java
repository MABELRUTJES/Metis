package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MetisController metis = MetisController.getInstance();

        // docent start toets in lokaal
        metis.startTest("egbc", "Toets requirements", "room_egbc");

        // student neemt deel aan toets en beantwoordt vragen
        System.out.println("Enter your name: ");
        String studentname = scanner.nextLine();
        metis.joinTest(studentname, "room_egbc");
        System.out.println("The test starts. Good luck!");
        do {
            System.out.println(metis.nextQuestion(studentname, "room_egbc"));
            System.out.print("Enter your answer to this question: ");
            String answer = scanner.nextLine();
            metis.saveAnswer(studentname, "room_egbc", answer);
        } while (!metis.testFinished(studentname, "room_egbc"));
        int score = metis.calculateScore(studentname, "room_egbc");
        System.out.println("Score: " + score);
    }
}