import java.util.List;

// Combo 類別實現了 MenuItem 接口，表示一個套餐。套餐由多個 MenuItem（單品）組成。
public class Combo implements MenuItem {

    // 套餐的名稱
    private String name;

    // 套餐的價格，會根據套餐內所有單品的價格總和計算
    private double price;

    // 是否是素食套餐，根據套餐內所有單品的素食屬性來決定
    private boolean vegetarian;

    // 套餐的庫存量
    private int stock;

    // 套餐內包含的所有單品列表
    private List<MenuItem> items;

    // Combo 類別的建構子，用來初始化套餐名稱、套餐內的單品和庫存
    public Combo(String name, List<MenuItem> items, int stock) {
        this.name = name;
        this.items = items;
        this.stock = stock;

        // 動態計算套餐價格：將所有單品的價格加總
        this.price = items.stream().mapToDouble(MenuItem::getPrice).sum();

        // 根據套餐內所有單品來確定是否為素食套餐
        // 如果所有單品都是素食，則套餐是素食；如果有任何一個單品不是素食，則套餐不是素食
        this.vegetarian = items.stream().allMatch(MenuItem::isVegetarian);
    }

    // 返回套餐的名稱
    @Override
    public String getName() {
        return name;
    }

    // 返回套餐的價格
    @Override
    public double getPrice() {
        return price;
    }

    // 返回套餐是否為素食
    @Override
    public boolean isVegetarian() {
        return vegetarian;
    }

    // 判斷套餐是否缺貨：如果套餐庫存為零，或者套餐內任一單品缺貨，則套餐也算作缺貨
    @Override
    public boolean isOutOfStock() {
        return stock <= 0 || items.stream().anyMatch(MenuItem::isOutOfStock);
    }

    // 返回套餐的庫存量
    @Override
    public int getStock() {
        return stock;
    }

    // 減少套餐庫存，並且減少套餐內每個單品的庫存
    @Override
    public void reduceStock() throws OutOfStockException {
        // 如果套餐缺貨，則拋出 OutOfStockException
        if (isOutOfStock()) {
            throw new OutOfStockException(name + " 缺貨中。");
        }

        // 減少套餐的庫存
        stock--;

        // 減少套餐內每一個單品的庫存
        for (MenuItem item : items) {
            item.reduceStock();
        }
    }
}
