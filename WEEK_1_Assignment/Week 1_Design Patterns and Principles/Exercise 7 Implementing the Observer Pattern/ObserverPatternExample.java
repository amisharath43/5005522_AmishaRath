import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(float price);
}

interface Stock {
    void register(Observer o);
    void deregister(Observer o);
    void notifyObservers();
}

class StockMarket implements Stock {
    private List<Observer> observers;
    private float price;

    public StockMarket() {
        this.observers = new ArrayList<>();
    }

    public void register(Observer o) {
        observers.add(o);
    }

    public void deregister(Observer o) {
        observers.remove(o);
    }

    public void setPrice(float price) {
        this.price = price;
        notifyObservers();
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(price);
        }
    }
}

class MobileApp implements Observer {
    public void update(float price) {
        System.out.println("MobileApp: Stock price updated to " + price);
    }
}

class WebApp implements Observer {
    public void update(float price) {
        System.out.println("WebApp: Stock price updated to " + price);
    }
}

public class ObserverPatternExample {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        stockMarket.register(mobileApp);
        stockMarket.register(webApp);

        stockMarket.setPrice(100.0f);
        stockMarket.setPrice(105.5f);
    }
}
