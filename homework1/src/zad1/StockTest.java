package zad1;

public class StockTest {
    public static void main(String[] args) {
        Stock stock = new Stock("TSLA", "Tesla Inc", 162.99, 175.34);
        Stock nullStock = new Stock();
        Stock copyStock = new Stock(stock);
        copyStock.setCurrentPrice(130.23);
        copyStock.setPreviousClosingPrice(-175.34);
        System.out.println("The price of " + stock.getName() + "(" + stock.getSymbol() + ")" +  " was: "
                + stock.getPreviousClosingPrice() +  " and now it is: " + stock.getCurrentPrice() +
                ". The change in percentages is " + String.format("%.2f", stock.changePercent()) + "%\n");

        System.out.println("The price of " + nullStock.getName() + "(" + nullStock.getSymbol() + ")" +  " was: "
                + nullStock.getPreviousClosingPrice() +  " and now it is: " + nullStock.getCurrentPrice() +
                ". The change in percentages is " + String.format("%.2f", nullStock.changePercent()) + "%\n");

        System.out.println("The price of " + copyStock.getName() + "(" + copyStock.getSymbol() + ")" +  " was: "
                + copyStock.getPreviousClosingPrice() +  " and now it is: " + copyStock.getCurrentPrice() +
                ". The change in percentages is " + String.format("%.2f", copyStock.changePercent()) + "%\n");


    }




}
