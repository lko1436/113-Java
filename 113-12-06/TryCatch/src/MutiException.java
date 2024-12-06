import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class MutiException {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};

        try {
            System.out.println(numbers[5]);
            File file = new File("nonexistentfile.txt");
            FileReader reader = new FileReader(file);
            //System.out.println(numbers[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("處理未檢例外: " + e.getMessage());
        } catch (Exception e ) {
            System.out.println("處理受檢例外: " + e.getMessage());
        }
    }
}