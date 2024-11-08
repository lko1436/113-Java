public class SalesPerson {
    private String id;
    private String name;
    private double grossSales;
    private double commissionRate;

    private Order[] orderArray = new Order[3]; // 記錄訂單的陣列
    private int orderCount = 0;

    // 建構子，初始化業務員編號、姓名，並預設獎金比例為 0.01
    public SalesPerson(String id, String name) {
        this.id = id;
        this.name = name;
        this.commissionRate = 0.01;
    }

    // 建構子，初始化業務員編號、姓名，並設定獎金比例
    public SalesPerson(String id, String name, double commissionRate) {
        this.id = id;
        this.name = name;
        this.commissionRate = commissionRate;
    }

    // 取得業務員編號
    public String getId() {
        return id;
    }

    // 取得業務員姓名
    public String getName() {
        return name;
    }

    // 設定業務員獎金比例
    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    // 新增訂單並處理訂單陣列長度不足的情況
    public void setOrderArray(String itemName, double itemPrice, int amount) {
        if (orderCount == orderArray.length) {
            // 若陣列已滿，擴展陣列
            Order[] newOrderArray = new Order[orderArray.length * 2];
            System.arraycopy(orderArray, 0, newOrderArray, 0, orderArray.length);
            orderArray = newOrderArray;
        }
        orderArray[orderCount] = new Order(itemName, itemPrice, amount);
        orderCount++;
    }

    // 計算總銷售額
    public double getGrossSales() {
        double total = 0;
        for (int i = 0; i < orderCount; i++) {
            total += orderArray[i].totalSale();
        }
        return total;
    }

    // 獲得所有訂單的字串表示
    public String getOrders() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < orderCount; i++) {
            sb.append(orderArray[i].toString());
        }
        return sb.toString();
    }

    // 計算薪資
    public double salary() {
        return getGrossSales() * commissionRate;
    }

    // 顯示業務員的基本資料
    public String toString() {
        return String.format("業務員編號：%s%n業務員姓名：%s%n銷售金額：%.1f%n獎金比例：%.2f%n薪資：%.1f%n",
                this.id, this.name, this.grossSales, this.commissionRate, salary());
    }
}
