package sortedCollections.shoppingBasket;

import java.util.Map;

public class Shopping {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("Bread", 2.6, 100);
        stockList.addStock(temp);

        temp = new StockItem("Water 1,5L bottle", 1.7, 100);
        stockList.addStock(temp);

        temp = new StockItem("Tomato per item", 1.5, 300);
        stockList.addStock(temp);

        temp = new StockItem("Hummus", 6, 100);
        stockList.addStock(temp);

        temp = new StockItem("Salomon 300g", 25, 20);
        stockList.addStock(temp);

        temp = new StockItem("Car Toy", 30, 100);
        stockList.addStock(temp);

        temp = new StockItem("Rice 500g", 2, 100);
        stockList.addStock(temp);

        temp = new StockItem("Avocado per item", 1.7, 3);
        stockList.addStock(temp);

        temp = new StockItem("Rice Milk 1L", 5, 100);
        stockList.addStock(temp);

        System.out.println(stockList.toString());

        for (String s :
                stockList.getAllItems().keySet()) {
            System.out.println(s);
        }

        Basket robertsBasket = new Basket("Robert");
        sellItem(robertsBasket, "Avocado per item", 3);
        System.out.println(robertsBasket);
        sellItem(robertsBasket, "Water 1,5L bottle", 12);
        System.out.println(robertsBasket);
        sellItem(robertsBasket, "Hummus", 1);
        System.out.println(robertsBasket);
        sellItem(robertsBasket, "Salomon 300g", 2);
        System.out.println(robertsBasket);
        sellItem(robertsBasket, "Tomato per item", 10);
        System.out.println(robertsBasket);

        System.out.println(stockList);

        stockList.getAllItems().get("Hummus").adjustStock(3000);
//        Collections.unmodifiableMap(list) provide unmodifiable Map.
//        Objects inside this Map are still modifiable.
        System.out.println("Hummus +3000: \n" + stockList);
        stockList.getItemfromStock("Hummus").adjustStock(-2000);
        System.out.println("Hummus -2000: \n"+ stockList);

//        Here bot price and list are immutable. Check priceList().
        for (Map.Entry<String, Double> price : stockList.priceList().entrySet()) {
            System.out.println(price.getKey() + " cost " + price.getValue());
        }

    }

    public static int sellItem(Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.getItemfromStock(item);

        if (stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        if (stockList.sellStock(item, quantity) != 0) {
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }
        return 0;
    }
}
