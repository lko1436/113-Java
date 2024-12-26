// Beverage 類別繼承自 Food 類別，表示一種飲料，擁有食物的一些屬性和行為
public class Beverage extends Food {

    // 建構子：初始化飲料的基本屬性，透過呼叫父類別 Food 的建構子
    // 參數包括：飲料的名稱(name)，價格(price)，是否素食(vegetarian)，庫存(stock)
    public Beverage(String name, double price, boolean vegetarian, int stock) {
        // 呼叫父類別 Food 的建構子，將這些屬性傳遞給父類別初始化
        super(name, price, vegetarian, stock);
    }

    // 重寫 prepare 方法，這是 Beverage 類別特有的行為，用於準備飲料
    // prepare 方法的具體實現會根據 Beverage 類別的需求進行定義
    @Override
    public void prepare() {
        // 輸出準備飲料的訊息，顯示飲料的名稱
        System.out.println("準備飲料：" + getName());
    }
}