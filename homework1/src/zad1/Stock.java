package zad1;

public class Stock {
    private String symbol;
    private String name;
    private double previousClosingPrice;
    private double currentPrice;


    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public double getPreviousClosingPrice() {
        return previousClosingPrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    //checking if the price is negative and if it is - setting it to the default value of 1
    public void setPreviousClosingPrice(double previousClosingPrice) {
        if (previousClosingPrice >= 0) {
            this.previousClosingPrice = previousClosingPrice;
        } else {
            System.out.printf("%.2f is invalid price! Setting it to default value.%n", previousClosingPrice);
            this.currentPrice = 1;
        }

    }

    //checking if the price is negative and if it is - setting it to the default value of 1
    public void setCurrentPrice(double currentPrice) {
        if(currentPrice >= 0) {
            this.currentPrice = currentPrice;
        } else {
            System.out.printf("%.2f is invalid price! Setting it to default value.%n", currentPrice);
            this.currentPrice = 1;
        }


    }
    //checking if the string is null and if it is - setting it to the default value of "null"
    public void setSymbol(String symbol) {
        if (symbol == null) {
            this.symbol = "null";
        } else {
            this.symbol = symbol;
        }
    }

    //checking if the string is null and if it is - setting it to the default value of "null"
    public void setName(String name) {
        if (name == null) {
            this.name = "null";
        } else {
            this.name = name;
        }
    }

    // A constructor with parameters:
    public Stock(String symbol, String name, double previousClosingPrice, double currentPrice) {
        setSymbol(symbol);
        setName(name);
        setPreviousClosingPrice(previousClosingPrice);
        setCurrentPrice(currentPrice);
    }

    // A default constructor:
    public Stock() {
        setSymbol("null");
        setName("null");
        setPreviousClosingPrice(1);
        setCurrentPrice(1);
    }

    // A copy constructor:
    public Stock(Stock stock) {
        this.symbol = stock.symbol;
        this.name = stock.name;
        this.currentPrice = stock.currentPrice;
        this.previousClosingPrice = stock.previousClosingPrice;
    }

    // function that calculates the change in stock price
    public double changePercent() {
        if(getPreviousClosingPrice() == 0) // the previous price CAN be 0, but we cant divide by 0, so we set a really low value for it - 0.01
            setPreviousClosingPrice(0.01);
        return (getCurrentPrice() - getPreviousClosingPrice()) / getPreviousClosingPrice() * 100;
    }
}
