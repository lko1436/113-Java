
import java.util.Scanner;


public class LeveL {
    public static void main(String[] args) {
        int score;
        char level = '\0';

        Scanner input = new Scanner(System.in);
        System.out.print("�п�J����:");
        score = input.nextInt();


        if(score >= 90) {
            level = 'A';
        } 
        else if(score >= 80 ) {
            level = 'B';
        }
        else if(score >= 70 ) {
            level = 'C';
        }
        else if(score >= 60 ) {
            level = 'D';
        }        
        else {
            level = 'E';
        }
        System.out.printf("�o�����šG%c%n", level);
    }
}
