// 自訂例外類別，表示無效訂單
public class InvalidOrderException extends Exception {

    // 建構子：接收一個錯誤訊息並將其傳遞給父類別 Exception
    public InvalidOrderException(String message) {
        super(message); // 呼叫父類別建構子，將錯誤訊息傳遞給 Exception 類別
    }
}
