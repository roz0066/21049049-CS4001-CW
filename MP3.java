public class MP3 extends Gadget {
    private int availableMemory;

    // Constructor
    public MP3(String model, double price, int weight, String size, int availableMemory) {
        super(model, price, weight, size);
        this.availableMemory = availableMemory;
    }

    // Accessor method for availableMemory
    public int getAvailableMemory() {
        return availableMemory;
    }

    // Method for downloading music
    public void downloadMusic(int memoryRequired) {
        if (memoryRequired <= availableMemory) {
            availableMemory -= memoryRequired;
            System.out.println("Music downloaded successfully.");
        } else {
            System.out.println("Insufficient memory to download music.");
        }
    }

    // Method for deleting music
    public void deleteMusic(int memoryFreed) {
        availableMemory += memoryFreed;
    }

    // Display method
    public void display() {
        super.display(); // Call display method of superclass
        System.out.println("Available Memory: " + availableMemory + " MB");
    }
}