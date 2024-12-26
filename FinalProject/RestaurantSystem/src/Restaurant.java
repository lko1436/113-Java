import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;

public class Restaurant {
    private ArrayList<MenuItem> menu; // 存儲餐廳菜單的 ArrayList
    private HashMap<Customer, LinkedList<MenuItem>> customerOrders; // 顧客訂單的 HashMap，將顧客與其訂單項目對應

    // 建構子，初始化菜單與訂單資料結構
    public Restaurant() {
        menu = new ArrayList<>(); // 初始化菜單為空的 ArrayList
        customerOrders = new HashMap<>(); // 初始化顧客訂單為空的 HashMap
    }

    // 將菜品新增到菜單中
    public void addToMenu(MenuItem item) {
        menu.add(item); // 將菜品加入菜單
    }

    // 顧客點餐，檢查菜單中是否有該項目，並處理庫存及訂單
    public void placeOrder(Customer customer, String foodName) throws OutOfStockException, InvalidOrderException {
        // 如果顧客之前沒有訂單，則為顧客建立一個空的訂單 LinkedList
        customerOrders.putIfAbsent(customer, new LinkedList<>());

        // 遍歷菜單，檢查顧客點的菜品是否存在
        for (MenuItem item : menu) {
            if (item.getName().equalsIgnoreCase(foodName)) { // 找到菜名匹配的項目
                item.reduceStock(); // 減少庫存
                customerOrders.get(customer).add(item); // 將菜品加入顧客的訂單
                System.out.println(customer.getName() + " 已點餐：" + foodName);
                return; // 點餐成功，退出方法
            }
        }
        // 如果菜單中找不到該菜品，拋出 InvalidOrderException
        throw new InvalidOrderException("菜單中找不到此項目：" + foodName);
    }

    // 處理顧客的所有訂單並顯示訂單明細
    public void processOrders() {
        System.out.println("\n顧客訂單明細：");

        // 遍歷所有顧客的訂單
        for (Customer customer : customerOrders.keySet()) {
            LinkedList<MenuItem> orders = customerOrders.get(customer); // 取得顧客的訂單
            double total = 0; // 計算訂單總金額

            System.out.println("顧客：" + customer.getName());
            // 顯示顧客的每一項訂單及其價格
            for (MenuItem item : orders) {
                System.out.println("  - " + item.getName() + " - 價格：$" + item.getPrice());
                total += item.getPrice(); // 累加價格
            }

            // 計算折扣後的金額
            double discount = customer.getDiscount(); // 顧客的折扣
            double discountedTotal = total * (1 - discount); // 折扣後的總金額
            double discountAmount = total - discountedTotal; // 折扣金額

            // 顯示訂單金額、折扣與折扣後的總金額
            System.out.printf("  總金額：$%.2f，折扣 (%.0f%%)：-$%.2f，折扣後總金額：$%.2f%n",
                    total, discount * 100, discountAmount, discountedTotal);

            // 將顧客的消費金額加到顧客的總消費中
            customer.addSpending(discountedTotal);
        }
    }

    // 顯示菜單及每個菜品的庫存狀況
    public void displayMenu() {
        System.out.println("\n菜單：");
        // 遍歷菜單，顯示每個菜品的名稱、價格與庫存狀態
        for (MenuItem item : menu) {
            System.out.printf("  - %s - 價格：$%.2f - %s%n",
                    item.getName(), item.getPrice(), item.isOutOfStock() ? "已售罄" : "有貨");
        }
    }
}
