// Food 類別，表示食物，實現 MenuItem 介面，並且是抽象類別
public abstract class Food implements MenuItem {
    // 食物名稱
    private String name;
    // 食物價格
    private double price;
    // 食物是否為素食
    private boolean vegetarian;
    // 食物庫存數量
    private int stock;

    // 建構子：初始化食物的名稱、價格、是否為素食以及庫存數量
    public Food(String name, double price, boolean vegetarian, int stock) {
        this.name = name;
        this.price = price;
        this.vegetarian = vegetarian;
        this.stock = stock;
    }

    // 取得食物名稱
    @Override
    public String getName() {
        return name;
    }

    // 取得食物價格
    @Override
    public double getPrice() {
        return price;
    }

    // 判斷食物是否為素食
    @Override
    public boolean isVegetarian() {
        return vegetarian;
    }

    // 判斷食物是否缺貨（庫存為 0 或更少）
    @Override
    public boolean isOutOfStock() {
        return stock <= 0;
    }

    // 取得食物的庫存數量
    @Override
    public int getStock() {
        return stock;
    }

    // 減少食物庫存，當庫存為 0 時，拋出缺貨異常
    @Override
    public void reduceStock() throws OutOfStockException {
        if (stock <= 0) {
            // 如果庫存為 0 或更少，拋出缺貨異常
            throw new OutOfStockException(name + " 缺貨中。");
        }
        stock--; // 減少庫存數量
    }

    // 抽象方法，準備食物的具體操作由子類別實現
    public abstract void prepare();
}
