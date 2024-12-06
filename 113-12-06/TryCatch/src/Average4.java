
import java.util.Scanner;

public class Average4 {
    public static void main(String[] args) {
        var sum = 0.0;
        var count = 0;
        while(true) {
            var number = inputInt();
            if(number == 0) {
                break;
            }
            sum += number;
            count++;
        }
        System.out.printf("平均 %.2f%n", sum / count);
    }

    static Scanner console = new Scanner(System.in);

    static int inputInt() {
        String input = console.next();
        while(!input.matches("\\d+")) {  // 這裡使用正規表示法來檢查輸入是否為數字
            System.out.println("請輸入數字");
            input = console.next();
        }
        return Integer.parseInt(input);
    }
}