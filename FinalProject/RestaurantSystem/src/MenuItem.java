// 修改 MenuItem 介面
public interface MenuItem {
    String getName();
    double getPrice();
    boolean isVegetarian();
    boolean isOutOfStock();
    int getStock();
    void reduceStock() throws OutOfStockException;
}