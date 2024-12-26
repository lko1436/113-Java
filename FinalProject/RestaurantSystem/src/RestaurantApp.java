public class RestaurantApp {
    public static void main(String[] args) {
        // 建立一個餐廳物件
        Restaurant restaurant = new Restaurant();

        // 加入菜單項目，分別是主餐、甜點、飲料
        restaurant.addToMenu(new MainDish("牛排", 25.99, false, 2)); // 主餐：牛排，價格：25.99，有貨數量：2
        restaurant.addToMenu(new Dessert("起司蛋糕", 6.99, true, 1)); // 甜點：起司蛋糕，價格：6.99，已售罄，庫存為 1
        restaurant.addToMenu(new Beverage("可樂", 2.99, false, 3)); // 飲料：可樂，價格：2.99，有貨數量：3

        // 建立顧客，分別是愛麗絲（有折扣）和鮑伯（無折扣）
        Customer alice = new Customer("愛麗絲", true); // 愛麗絲有折扣
        Customer bob = new Customer("鮑伯", false); // 鮑伯無折扣

        try {
            // 愛麗絲點餐
            restaurant.placeOrder(alice, "牛排"); // 愛麗絲點牛排
            restaurant.placeOrder(alice, "可樂"); // 愛麗絲點可樂

            // 鮑伯點餐
            restaurant.placeOrder(bob, "起司蛋糕"); // 鮑伯點起司蛋糕
            restaurant.placeOrder(bob, "牛排"); // 鮑伯點牛排
        } catch (OutOfStockException | InvalidOrderException e) {
            // 捕捉到庫存不足或無效訂單例外時，顯示錯誤訊息
            System.out.println(e.getMessage());
        }

        // 處理所有訂單並顯示結果
        restaurant.processOrders();

        // 顯示當前菜單，顯示菜品名稱、價格和庫存狀況
        restaurant.displayMenu();
    }
}
