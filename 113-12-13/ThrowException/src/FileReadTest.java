public class FileReadTest {
    public static void main(String[] args) {
        try {
            String text = FileUtil.read("cashcard1.txt");
            System.out.println(text);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
