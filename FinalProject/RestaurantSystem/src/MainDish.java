// 修改 MainDish 類別，表示主菜
public class MainDish extends Food {

    // 建構子：初始化主菜的名稱、價格、是否為素食、庫存數量
    public MainDish(String name, double price, boolean vegetarian, int stock) {
        super(name, price, vegetarian, stock); // 呼叫父類別 Food 的建構子，初始化食物屬性
    }

    // 實作準備主菜的具體方法
    @Override
    public void prepare() {
        // 輸出準備主菜的訊息
        System.out.println("準備主菜：" + getName());
    }
}
