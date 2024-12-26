// 自訂例外類別，表示缺貨情況
public class OutOfStockException extends Exception {

    // 建構子，接受一個錯誤訊息並傳遞給父類別 Exception 的建構子
    public OutOfStockException(String message) {
        super(message); // 呼叫父類別建構子，將錯誤訊息傳遞給 Exception 類別
    }
}
