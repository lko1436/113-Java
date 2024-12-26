// Customer 類別，表示顧客
public class Customer {
    // 顧客的名稱
    private String name;

    // 顧客是否為會員，會員可享有折扣
    private boolean isMember;

    // 顧客的總消費金額
    private double totalSpent;

    // 建構子：初始化顧客的名稱、是否為會員，以及初始消費金額為 0
    public Customer(String name, boolean isMember) {
        this.name = name;
        this.isMember = isMember;
        this.totalSpent = 0;  // 初始消費金額設為 0
    }

    // 回傳顧客名稱
    public String getName() {
        return name;
    }

    // 回傳顧客是否為會員
    public boolean isMember() {
        return isMember;
    }

    // 回傳顧客的總消費金額
    public double getTotalSpent() {
        return totalSpent;
    }

    // 增加顧客的消費金額
    public void addSpending(double amount) {
        totalSpent += amount; // 累加消費金額
    }

    // 根據顧客是否為會員，返回顧客可以獲得的折扣
    public double getDiscount() {
        // 如果是會員，折扣為 10%（即 0.1）；如果不是會員，則沒有折扣（0）
        return isMember ? 0.1 : 0;
    }
}
