import java.util.Scanner;

public class SalesDepartment {
    public static void main(String args[]) {
        SalesPerson[] salesTeam = new SalesPerson[3];
        // 假設你已經有 SalesPerson 類別，並且提供建構子來初始化每個銷售人員
        SalesPerson sales1 = new SalesPerson("SE111", "林俊傑");
        SalesPerson sales2 = new SalesPerson("SE222", "張佳豪");
        SalesPerson sales3 = new SalesPerson("SE333", "劉威廷");

        // 將銷售人員加入到團隊陣列中
        salesTeam[0] = sales1;
        salesTeam[1] = sales2;
        salesTeam[2] = sales3;

        // 執行操作方法
        operation(salesTeam);
    }

    // 主操作選項
    public static void operation(SalesPerson[] salesTeam) {
        SalesPerson targetSales;
        Scanner input = new Scanner(System.in);
        menu();

        // 不斷讀取用戶輸入直到結束
        while (input.hasNext()) {
            int choice = input.nextInt();
            try {
                switch (choice) {
                    case 1:
                        // 設定銷售金額
                        targetSales = selectedSales(salesTeam);
                        if (targetSales != null) {
                            System.out.print("請輸入銷售金額：");
                            double amount = input.nextDouble();
                            targetSales.setSalesAmount(amount);
                        }
                        break;
                    case 2:
                        // 設定獎金比例
                        targetSales = selectedSales(salesTeam);
                        if (targetSales != null) {
                            System.out.print("請輸入獎金比例：");
                            double commission = input.nextDouble();
                            targetSales.setCommissionRate(commission);
                        }
                        break;
                    case 3:
                        // 薪資查詢
                        targetSales = selectedSales(salesTeam);
                        if (targetSales != null) {
                            System.out.println("薪資: " + targetSales.getSalary());
                        }
                        break;
                    default:
                        System.out.println("無效選擇，請重新選擇。");
                }
            } catch (IllegalArgumentException ex) {
                System.out.println("輸入錯誤，請重新選擇。");
            }
            menu();
        }

        // 列出所有銷售人員的資料
        for (SalesPerson s : salesTeam) {
            System.out.print(s.toString());
        }
    }

    // 選擇某個銷售人員
    public static SalesPerson selectedSales(SalesPerson[] salesTeam) {
        Scanner input = new Scanner(System.in);
        System.out.print("請輸入編號： ");
        String salesID = input.next();

        for (SalesPerson s : salesTeam) {
            if (s.getSalesID().equals(salesID)) {
                return s;
            }
        }

        System.out.println("編號輸入錯誤");
        return null;
    }

    // 顯示操作選單
    public static void menu() {
        System.out.println("\n\nROC股份有限公司：");
        System.out.print("1.設定銷售金額\n2.設定獎金比例\n3.薪資查詢\n請輸入： ");
    }
}
