public class Mobile extends Gadget {
    private int callingCredit;

    // Constructor
    public Mobile(String model, double price, int weight, String size, int callingCredit) {
        super(model, price, weight, size);
        this.callingCredit = callingCredit;
    }

    // Accessor method for callingCredit
    public int getCallingCredit() {
        return callingCredit;
    }

    // Method to add calling credit
    public void addCallingCredit(int creditToAdd) {
        if (creditToAdd > 0) {
            callingCredit += creditToAdd;
        } else {
            System.out.println("Please enter a positive amount to add calling credit.");
        }
    }

    // Method to make a phone call
    public void makeCall(String phoneNumber, int duration) {
        if (callingCredit >= duration) {
            System.out.println("Making call to " + phoneNumber + " for " + duration + " minutes.");
            callingCredit -= duration;
        } else {
            System.out.println("Insufficient calling credit to make the call.");
        }
    }

    // Display method
    public void display() {
        super.display(); // Call display method of superclass
        System.out.println("Calling credit remaining: " + callingCredit + " minutes");
    }
}