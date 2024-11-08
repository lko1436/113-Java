import java.util.Scanner;

public class SalesDepartment {
    public  static void main(String args[]) {
        // 初始化銷售團隊
        SalesPerson[] salesTeam = new SalesPerson[3];
        SalesPerson sales1 = new SalesPerson("SE111", "周柏睿");
        SalesPerson sales2 = new SalesPerson("SE222", "黃敬宇");
        SalesPerson sales3 = new SalesPerson("SE333", "吳嘉文");
        salesTeam[0] = sales1;
        salesTeam[1] = sales2;
        salesTeam[2] = sales3;

        // 執行操作
        operation(salesTeam);
    }

    // 操作選單和選項處理
    public static void operation(SalesPerson[] salesTeam) {
        SalesPerson targetSales;
        Scanner input = new Scanner(System.in);
        menu();

        while (input.hasNext()) {
            int choice = input.nextInt();
            try {
                switch (choice) {
                    case 1:
                        // 設定獎金比例
                        targetSales = selectedSales(salesTeam);
                        if (targetSales != null) {
                            System.out.print("請輸入獎金比例： ");
                            double commissionRate = input.nextDouble();
                            targetSales.setCommissionRate(commissionRate);
                        }
                        break;
                    // 新增訂單
                    case 2:
                        targetSales = selectedSales(salesTeam);
                        if (targetSales != null) {
                            System.out.print("請輸入產品名稱： ");
                            String itemName = input.next();
                            System.out.print("請輸入產品單價： ");
                            double itemPrice = input.nextDouble();
                            System.out.print("請輸入產品數量： ");
                            int amount = input.nextInt();

                            // 顯示產品名稱、價格和數量
                            System.out.printf("產品名稱：%s，產品單價：%.1f，產品數量：%d%n", itemName, itemPrice, amount);

                            // 新增訂單
                            targetSales.setOrderArray(itemName, itemPrice, amount);
                        }
                        break;

                    case 3:
                        // 薪資查詢
                        targetSales = selectedSales(salesTeam);
                        if (targetSales != null) {
                            System.out.println(targetSales.toString());
                        }
                        break;
                    case 4:
                        // 訂單查詢
                        targetSales = selectedSales(salesTeam);
                        if (targetSales != null) {
                            System.out.println(targetSales.getOrders());
                        }
                        break;
                    default:
                        throw new IllegalArgumentException("選項無效");
                }
            }
            catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                menu();
                continue;
            }
            menu();
        }
        // 顯示所有業務員資訊
        for (SalesPerson s : salesTeam) {
            System.out.print(s.toString());
        }
    }

    // 選擇特定業務員
    public static SalesPerson selectedSales(SalesPerson[] salesTeam) {
        Scanner input = new Scanner(System.in);
        System.out.print("請輸入編號： ");
        String salesID = input.next();

        // 根據編號查找業務員
        for (SalesPerson s : salesTeam) {
            if (s.getId().equals(salesID)) {
                return s;
            }
        }
        System.out.println("編號輸入錯誤");
        return null;
    }

    // 顯示操作選單
    public static void menu() {
        System.out.println("\n\nROC股份有限公司：");
        System.out.print("1.設定獎金比例\n2.新增訂單\n3.薪資查詢\n4.訂單查詢\n請輸入： ");
    }
}
