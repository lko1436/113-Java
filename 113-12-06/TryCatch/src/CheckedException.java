import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class CheckedException {
    public static void main(String[] args) {
        try {
            File file = new File("nonexistentfile.txt");
            FileReader reader = new FileReader(file); // 可能拋出 FileNotFoundException
        } catch (FileNotFoundException e) {
            System.out.println("處理受檢例外: " + e.getMessage());
        }
    }
}