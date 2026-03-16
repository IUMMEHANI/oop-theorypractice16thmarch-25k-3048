package INHERITANCE;
interface TaxCalculator { //so classes must use its methods if implementing it
    double calculateImportDuty();
    double calculateSalesTax();
    double calculateGST(double amount);
}
abstract class Watch implements TaxCalculator { // As this class cannot be instantiated
   // To ensure that an object of the Watch class cannot be created directly, the class is declared as an abstract class.
    //An abstract class in Java is a class that cannot be instantiated (objects cannot be created from it directly). It is used only as a base or parent class for other classes.
    String customerName;
    String customerAddress;
    double capitalCost;
    final int watchID; //constant, unique for each watch
    static int totalWatches = 0;//tracks total watches
    static final double IMPORT_DUTY_RATE = 0.15;//constant
    static final double PROFIT_RATE = 0.75;//constant
    static final double GST_RATE = 0.06;//constant
    Watch(int id, String name, String address, double cost) {
        watchID = id;
        customerName = name;
        customerAddress = address;
        capitalCost = cost;
        totalWatches++;
    }
    public double calculateImportDuty() {
        return capitalCost * IMPORT_DUTY_RATE;
    }
    public abstract double calculateSalesTax();//This method has no body and is abstract as it does not provide implementation because LuxuryWatch and NonLuxuryWatch calculate tax differently and is providing overridden functionality.
    public double calculateGST(double amount) {
        return amount * GST_RATE;
    }
    public double calculateRetailPrice() {//calculating full price without discount aka no parameters
        double totalCost = capitalCost + calculateImportDuty() + calculateSalesTax();
        double profit = totalCost * PROFIT_RATE;
        double priceBeforeGST = totalCost + profit;
        return priceBeforeGST + calculateGST(priceBeforeGST);
    }
    public double calculateRetailPrice(double discount) { //discount parameter is given
        //function overloading implemented
        double price = calculateRetailPrice(); //as to calculate full price then subracting discount from it
        return price - discount;
    }
}
class LuxuryWatch extends Watch {
    static int luxuryCount = 0;
    LuxuryWatch(int id, String name, String address, double cost) {
        super(id, name, address, cost);//calling parent constructor
        luxuryCount++;//tracking
    }
    @Override
    public double calculateSalesTax() {
        return capitalCost * 0.10;
    }
}
class NonLuxuryWatch extends Watch {
    static int nonLuxuryCount = 0;
    NonLuxuryWatch(int id, String name, String address, double cost) {
        super(id, name, address, cost); //calling parent constructor
        nonLuxuryCount++;//tracking
    }
    @Override
    public double calculateSalesTax() {
        return capitalCost * 0.065;
    }
}
class Main {
    public static void main(String[] args) {
        LuxuryWatch w1 = new LuxuryWatch(1,"Amna","Karachi",50000);
        NonLuxuryWatch w2 = new NonLuxuryWatch(2,"Hani","Karachi",20000);
        System.out.println("Luxury Watch Retail Price: " + w1.calculateRetailPrice());
        System.out.println("Non Luxury Watch Retail Price: " + w2.calculateRetailPrice());
        System.out.println("Total Watches: " + Watch.totalWatches);
        System.out.println("Luxury Watches: " + LuxuryWatch.luxuryCount);
        System.out.println("Non Luxury Watches: " + NonLuxuryWatch.nonLuxuryCount);
    }
}