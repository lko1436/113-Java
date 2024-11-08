public class Order {
    private String itemName;
    private double itemPrice;
    private int amount;

    // 建構子，初始化產品名稱、單價和數量
    public Order(String itemName, double itemPrice, int amount) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.amount = amount;
    }

    // 計算總銷售額
    public double totalSale() {
        return itemPrice * amount;
    }

    // 將訂單資料以字串形式回傳
    public String toString() {
        return String.format("產品名稱：%6s 單價：%7.1f 數量：%3d%n", itemName, itemPrice, amount);
    }
}
