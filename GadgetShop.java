import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GadgetShop extends JFrame implements ActionListener {
    //Initialise required variabls
    private ArrayList<Gadget> gadgets;
    private JTextField modelField, priceField, weightField, sizeField, creditField, memoryField, phoneNoField, durationField, downloadField, displayNoField;
    private JButton addMobileButton, addMP3Button, clearButton, displayAllButton, makeCallButton, downloadMusicButton;

    public GadgetShop() {
        setTitle("Gadget Shop");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        gadgets = new ArrayList<>();
        
        // Create the labels needed 
        JLabel modelLabel = new JLabel("Model:");
        JLabel priceLabel = new JLabel("Price:");
        JLabel weightLabel = new JLabel("Weight:");
        JLabel sizeLabel = new JLabel("Size:");
        JLabel creditLabel = new JLabel("Credit:");
        JLabel memoryLabel = new JLabel("Memory:");
        JLabel phoneNoLabel = new JLabel("Phone No:");
        JLabel durationLabel = new JLabel("Duration:");
        JLabel downloadLabel = new JLabel("Download:");
        JLabel displayNoLabel = new JLabel("Display Number:");
        
        // Create the text fields needed
        modelField = new JTextField(10);
        priceField = new JTextField(10);
        weightField = new JTextField(10);
        sizeField = new JTextField(10);
        creditField = new JTextField(10);
        memoryField = new JTextField(10);
        phoneNoField = new JTextField(10);
        durationField = new JTextField(10);
        downloadField = new JTextField(10);
        displayNoField = new JTextField(10);
        
        // Create the buttons
        addMobileButton = new JButton("Add Mobile");
        addMP3Button = new JButton("Add MP3");
        clearButton = new JButton("Clear");
        displayAllButton = new JButton("Display All");
        makeCallButton = new JButton("Make a Call");
        downloadMusicButton = new JButton("Download Music");

        // Adding the action listeners needed for each button
        addMobileButton.addActionListener(this);
        addMP3Button.addActionListener(this);
        clearButton.addActionListener(this);
        displayAllButton.addActionListener(this);
        makeCallButton.addActionListener(this);
        downloadMusicButton.addActionListener(this);
        
        // Create the panel and add all the components
        JPanel panel = new JPanel(new GridLayout(0,4));

        panel.add(modelLabel);
        panel.add(priceLabel);
        panel.add(weightLabel);
        panel.add(sizeLabel);

        panel.add(modelField);
        panel.add(priceField);
        panel.add(weightField);
        panel.add(sizeField);

        panel.add(creditLabel);
        panel.add(memoryLabel);
        panel.add(addMobileButton);
        panel.add(addMP3Button);

        panel.add(creditField);
        panel.add(memoryField);
        panel.add(clearButton);
        panel.add(displayAllButton);

        panel.add(phoneNoLabel);
        panel.add(durationLabel);
        panel.add(downloadLabel);
        panel.add(displayNoLabel);

        panel.add(phoneNoField);
        panel.add(durationField);
        panel.add(downloadField);
        panel.add(displayNoField);

        panel.add(makeCallButton);
        panel.add(downloadMusicButton);
        
        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        //get the action event source
        Object action = e.getSource();
        // Perform actions based on button clicks
        if (action == addMobileButton) {
            double price = getPriceTextField();
            try {
                String model = getModelTextField();
                //double price = getPriceTextField();
                int weight = getWeightTextField();
                String size = getSizeTextField();
                int callingCredit = getAvailableCreditTextField();
                Mobile newMobile = new Mobile(model, price, weight, size, callingCredit);

                gadgets.add(newMobile);
                clearFields();

            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        } else if (action == addMP3Button) {

            try {
                String model = getModelTextField();
                double price = getPriceTextField();
                int weight = getWeightTextField();
                String size = getSizeTextField();
                int availableMemory = getAvailableMemoryTextField();
                MP3 newMP3 = new MP3(model, price, weight, size, availableMemory);

                gadgets.add(newMP3);
                clearFields();

            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else if (action == clearButton) {
            clearFields();

        } else if (action == displayAllButton) {
            int index = 0;
            for (Gadget gadget : gadgets) {
                System.out.println("Display number: "+index);
                gadget.display();
                index++;
            }

        } else if (action == makeCallButton) {
            String phoneNumber = getPhoneNumberTextField();
            int duration = getDurationTextField();
            int displayNo = getDisplayNumberTextField();

            if(displayNo != -1){
                Mobile gadget =  (Mobile) gadgets.get(displayNo);
                gadget.makeCall(phoneNumber,duration);
            }

        } else if (action == downloadMusicButton) {
            int downloadSize = getDownloadSizeTextField();
            int displayNo = getDisplayNumberTextField();

            if(displayNo != -1){
                MP3 gadget = (MP3) gadgets.get(displayNo);
                gadget.downloadMusic(downloadSize);
            }
        }
    }
    
    private void clearFields() {
        modelField.setText("");
        priceField.setText("");
        weightField.setText("");
        sizeField.setText("");
        creditField.setText("");
        memoryField.setText("");
        phoneNoField.setText("");
        durationField.setText("");
        downloadField.setText("");
        displayNoField.setText("");
    }

     //get the model field value
     private String getModelTextField() {

        if (modelField.getText().equals("")){
            throw new IllegalArgumentException("The model cannot be null. Please provide the gadgets model");
        }else{
            return modelField.getText();
        }
        
    }

    //get the price field value
    private double getPriceTextField() { 
        try {
            return Double.parseDouble(priceField.getText());
        } catch (Exception e) {
            throw new NumberFormatException("Invalid value provided. Please make sure you provide a valid price");
        }
    }

    //get the weight field value
    private int getWeightTextField() {
        try {
            return Integer.parseInt(weightField.getText());
        } catch (Exception e) {
            throw new NumberFormatException("Invalid value provided. Please make sure you provide a valid weight in grams");
        }
        
    }

    //get the size field value
    private String getSizeTextField() {
        
        if (sizeField.getText().equals("")){
            throw new IllegalArgumentException("The device size cannot be null. Please provide the gadgets model");
        }else{
            return sizeField.getText(); 
        }
        
    }

    //get the credit field value
    private int getAvailableCreditTextField() {
        try {
           return Integer.parseInt(creditField.getText()); 
        } catch (Exception e) {
            throw new NumberFormatException("Invalid value provided. Please make sure you provide total calling credits");
        }
        
    }

    //get the available memory field values
    private int getAvailableMemoryTextField() {
        try {
            return Integer.parseInt(memoryField.getText());
        } catch (Exception e) {
            throw new NumberFormatException("Invalid value provided. Please make sure you provide available memeory for the device");
        }
        
    }

    //get the phone number field value
    private String getPhoneNumberTextField() {
        if (phoneNoField.getText().equals("")){
            throw new IllegalArgumentException("The phone number cannot be null. Please provide the gadgets model");
        }else{
            return phoneNoField.getText(); 
        }
    }

    //get the duration field value
    private int getDurationTextField() {
        try {

            return Integer.parseInt(durationField.getText());
        } catch (Exception e) {
            throw new NumberFormatException("Invalid value provided. Please make sure you provide correct duration in minutes");
        }
        
    }

    //get the download size field value
    private int getDownloadSizeTextField() {
        try {
            return Integer.parseInt(downloadField.getText());
        } catch (Exception e) {
            throw new NumberFormatException("Invalid value provided. Please make sure you provide the size of the download");
        }
        
    }

    //get the display number if it exists else return -1
    public int getDisplayNumberTextField() {
        int displayNumber = -1; // Initialise to -1
        try {
            displayNumber = Integer.parseInt(displayNoField.getText());
            if (displayNumber < 0 || displayNumber >= gadgets.size()) {
                // Display error message for out of range display number
                JOptionPane.showMessageDialog(null, "Display number is out of range.", "Error", JOptionPane.ERROR_MESSAGE);
                displayNumber = -1; // Reset to -1
            }
        } catch (NumberFormatException e) {
            // Display error message for non-integer input
            JOptionPane.showMessageDialog(null, "Display number must be an integer.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return displayNumber;
    }


    public static void main(String[] args) {
        new GadgetShop();
    }
}

