// Dessert 類別，表示甜點，繼承自 Food 類別
public class Dessert extends Food {

    // Dessert 類別的建構子，初始化甜點名稱、價格、是否為素食以及庫存數量
    public Dessert(String name, double price, boolean vegetarian, int stock) {
        super(name, price, vegetarian, stock); // 呼叫父類別 (Food) 的建構子來初始化屬性
    }

    // 覆寫父類別的 prepare 方法，定義如何準備甜點
    @Override
    public void prepare() {
        // 在這裡打印出準備甜點的訊息，並顯示甜點的名稱
        System.out.println("準備甜點：" + getName());
    }
}
