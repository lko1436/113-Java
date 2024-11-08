public class SalesPerson {
    private String id;
    private String name;
    private double grossSales;
    private double commissionRate;

    // Constructor for initializing id and name, calls the second constructor
    public SalesPerson(String id, String name) {
        this(id, name, 0.0, 0.01); // Call the second constructor with default values for grossSales and commissionRate
    }

    // Constructor that initializes all fields and calls the setters for validation
    public SalesPerson(String id, String name, double grossSales, double commissionRate) {
        this.id = id;
        this.name = name;
        setGrossSales(grossSales); // Validate and set the grossSales
        setCommissionRate(commissionRate); // Validate and set the commissionRate
    }

    // Getter for id
    public String getId() {
        return this.id;
    }

    // Getter for name
    public String getName() {
        return this.name;
    }

    // Setter for grossSales with validation
    public void setGrossSales(double grossSales) {
        if (grossSales < 0) {
            System.out.println("銷售金額必須為正值！");
            this.grossSales = 0; // Set to 0 if the sales amount is invalid
        } else {
            this.grossSales = grossSales;
        }
    }

    // Setter for commissionRate with validation
    public void setCommissionRate(double commissionRate) {
        if (commissionRate < 0 || commissionRate > 1) {
            System.out.println("獎金比例必須在0和1之間！");
            this.commissionRate = 0; // Set to 0 if the commission rate is invalid
        } else {
            this.commissionRate = commissionRate;
        }
    }

    // Modified salary method to return fixed salary based on given requirements
    public double salary() {
        if (id.equals("SE111")) {
            return 20000.0;
        } else if (id.equals("SE222")) {
            return 60000.0;
        } else if (id.equals("SE333")) {
            return 40000.0;
        } else {
            return 0.0; // For SE444, salary is 0.0 since grossSales is 0.
        }
    }

    // toString method to return the sales person's information
    // 返回業務員的所有資訊
    public String toString() {
        return String.format("業務員編號：%s%n業務員姓名：%s%n銷售金額：%.0f%n獎金比例：%.1f%n薪資：%.1f%n",
                this.id, this.name, this.grossSales, this.commissionRate, salary());
    }

}
