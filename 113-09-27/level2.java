import java.util.Scanner;

public class level2 {
    

public static void main(String[] args) {
        char level = '\0';

        Scanner input = new Scanner(System.in);
        System.out.print("�п�J����:");
    
    while (input.hasNext())
    {
        int score = input.nextInt();
        switch(score / 10) { 
        case 10: 
        case 9: 
            level = 'A';
            break; 
        case 8: 
            level = 'B';
            break; 
        case 7: 
            level = 'C';
            break; 
        case 6: 
            level = 'D';
            break; 
        default: 
            level = 'E';
    }
    System.out.printf("�o�����šG%c%n", level);
    System.out.print("�п�J����:");
}
}
    
}


