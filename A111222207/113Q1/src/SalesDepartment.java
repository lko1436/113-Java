public class SalesDepartment {
    public static void main(String[] args) {
        // Create SalesPerson objects with appropriate values
        SalesPerson sp1 = new SalesPerson("SE111", "王建銘", 2000000.0, 0); // Salary is fixed
        SalesPerson sp2 = new SalesPerson("SE222", "李國強", 2000000.0, 0); // Salary is fixed
        SalesPerson sp3 = new SalesPerson("SE333", "陳志明", 2000000.0, 0); // Salary is fixed
        SalesPerson sp4 = new SalesPerson("SE444", "李德輔", 0.0, 0.1);      // Salary is 0 due to 0 sales

        // Output the information for each salesperson
        System.out.println(sp1);
        System.out.println(sp2);
        System.out.println(sp3);
        System.out.println(sp4);
    }
}
