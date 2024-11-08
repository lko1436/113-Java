public class SalesPerson {
    private String id;  // 業務員編號
    private String name;  // 業務員姓名
    private double grossSales;  // 銷售金額
    private double commissionRate;  // 獎金比例

    // 建構子，初始化業務員編號和姓名
    public SalesPerson(String id, String name) {
        this.id = id;
        this.name = name;
        this.grossSales = 0;  // 初始銷售金額設為0
        this.commissionRate = 0;  // 初始獎金比例設為0
    }

    // 取得業務員編號
    public String getSalesID() {
        return this.id;
    }

    // 取得業務員姓名
    public String getName() {
        return this.name;
    }

    // 設定銷售金額
    public void setSalesAmount(double grossSales) {
        this.grossSales = grossSales;
    }

    // 設定獎金比例
    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    // 計算薪資，薪資 = 銷售金額 * 獎金比例
    public double getSalary() {
        return this.grossSales * this.commissionRate;
    }

    // 輸出業務員資料
    public String toString() {
        return String.format("業務員編號：%s\n業務員姓名：%s\n銷售金額：%.1f\n獎金比例：%.1f\n薪資：%.1f\n",
                this.id, this.name, this.grossSales, this.commissionRate, getSalary());
    }
}
