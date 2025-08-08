import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

// Class that stores loyalty account information
class loyaltyAccounts{
    int accountNumber = 0;
    int loyaltyPoints = 0;
    // Vector<String> productsSelected = new Vector<>();

    loyaltyAccounts(int cardID, int cur_p) {
        this.accountNumber = cardID;
        this.loyaltyPoints = cur_p;
    }

    // Getter method for loyaltyPoints
    public int getPoints() {
        return loyaltyPoints;
    }

    // Getter method for accountNumber
    public int getCardID() {
        return accountNumber;
    }
}

// Main Class
public class posLoyalty {
    public static void main( String[] args){

        // Variable Declarations for product name, amount, price, associated loyalty points, and total price
        String[] productName = {"Choco Biscuits", "Organic Shampoo", "Instant Noodles", "Facial Cleanser", "Coffee Grounds", "Dishwashing Liquid", "Hand Sanitizer", "Tomato Sauce", "Dog Food (Beef)", "Floor Cleaner", "Laundry Detergent", "Sardines", "Air Freshener Spray", "Antibacterial Wipes", "Baby Powder", "Liquid Hand Soap", "Chocolate Bar", "Milk", "Cooking Oil", "Vitamin C Tablets"};
        int[] productAmount = {15, 1, 10, 5, 15, 1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1, 3, 1, 1, 1};
        double[] productPrices = {7.00, 150.25, 25.00, 90.50, 15.00, 189.75, 45.00, 25.00, 270.25, 283.50, 190.00, 35.25, 150.00, 48.75, 30.00, 63.50, 15.00, 120.50, 175.00, 90.75};
        int[] productPoints = {1, 3, 1, 2, 3, 1, 2, 1, 1, 2, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1};
        double totalPrice = 0.00;
        
        // Generates a loyalty account with randomized info.
        Random rndg = new Random();
        int cardID = rndg.nextInt(9999);
        int currentPnts = rndg.nextInt(9999);
        loyaltyAccounts acc = new loyaltyAccounts(cardID, currentPnts);
        System.out.println("\n\n  Card ID: " + acc.getCardID() + "\n  Loyalty Points: " + acc.getPoints() + "\n");

        // Generates a random item checkout list
        Vector<String> prods_selected = new Vector<>();
        Vector<Double> prods_price = new Vector<>();
        Vector<Double> prods_total_price = new Vector<>();
        Vector<Integer> prods_amount = new Vector<>();
        Vector<Integer> prods_points = new Vector<>();


        while (true) {
            int prod_cont = rndg.nextInt(productName.length);
            prod_cont = (prod_cont < 1) ? 5 : prod_cont;

            for (int d = 0; d < prod_cont; d++) {
                int num_gen = rndg.nextInt(productName.length);

                int p_amount = rndg.nextInt(20);
                p_amount = (p_amount < 1) ? 1 : p_amount;

                prods_selected.addElement(productName[num_gen]);
                prods_amount.addElement(p_amount);
                prods_price.addElement(productPrices[num_gen]);
                prods_total_price.addElement(productPrices[num_gen] * p_amount);
                prods_points.addElement(productPoints[num_gen]);
            }

            if (prods_selected.isEmpty()) {
                continue;
            } else {
                break;
            }
        }

        // Sums up all the prices of the items generated
        for (double price : prods_total_price) {
            totalPrice += price;
        }

        // Unused?
        // System.out.println("\nProds selected list\n");
        // for(String p : prods_selected) {
        //     System.out.println(p);
        // }

        System.out.println("[]============================[ POS Checkout Receipt ]============================[]\n  Item/s for Checkout:");
        System.out.println("[]==============================[]==============[]===============[]===============[]");
        System.out.println("          Product Name          ||   Quantity   ||Price per Unit || Item Subtotal   ");
        System.out.println("[]==============================[]==============[]===============[]===============[]");

        // For loop that prints the list of items bought, amount selected, price per unit, and total price of item units.
        int i = 0;
        for (String product : prods_selected) {
            String tabCorrection[] = {"", "\t", "\t"};

            // Applies indentation based on the item name length to properly align the UI.
            if(product.length() < 8){
                tabCorrection[0] = "\t\t\t";
            } else if(product.length() >= 8 && product.length() < 15){
                tabCorrection[0] = "\t\t";
            } else{
                tabCorrection[0] = "\t";
            }

            // Checks for item amount, then applies the appropriate term.
            String unitPluralCheck;
            if(productAmount[i] != 1){
                unitPluralCheck = "units";
            } else{
                unitPluralCheck = "unit";
            }

            // Indents the the first nine items to align it with the rest.
            String lessThan10 = " ";
            if(i < 9){
                lessThan10 = "  ";
            } else{
                lessThan10 = " ";
            }

            // The actual print function the builds the item list UI.
            System.out.println("   " + lessThan10 + (i + 1) + ".) " + product + tabCorrection[0] +"|| x" + prods_amount.get(i) + " " + unitPluralCheck + tabCorrection[1] + "|| Php " + String.format("%.2f", prods_price.get(i)) + tabCorrection[2] + " || Php " + String.format("%.2f", prods_total_price.get(i)));
            i+=1;
        }

        
        // Prints out the total price of items in checkout.
        System.out.println("[]==============================[]==============[]===============[]===============[]");
        System.out.println("\n  Total Price:\n    [ Php " + String.format("%.2f", totalPrice) + " ]\n");

        //run the code indefinitely unless it went to a valid if/else statement then it would break
        while (true) {
            // Prompts the user to either enter loyalty card ID.
            Scanner card_input = new Scanner(System.in);
            System.out.println("[]==============================[ Loyalty  Rewards ]==============================[]");
            System.out.print("  Loyalty Rewards System:\n    Enter the card ID here (Type N/n if no card): ");
            String res = card_input.nextLine();

            // Outputs based on user input.
            // code will stop the loop on this valid condition
            if (res.equalsIgnoreCase("N")) {

                // If user inputs N or n.
                System.out.println("\n  Receipt printed. Thank you for shopping with us!\n\n[]================================================================================[]");
                break;
            } else {

                // If user inputs something else. If card ID input is correct, it will proceed to add points to the account.
                // if user inputs incorrect card ID or invalid inputs, no points will be added.
                try {
                    int intRes = Integer.parseInt(res);

                    // code will stop the loop on this valid condition
                    if (intRes == acc.getCardID()) {
                        int totalPoints = 0;

                        for (int p : prods_points) {
                            totalPoints += p;
                        }

                        System.out.println("\n  Current Points: " + acc.getPoints());
                        System.out.println("  Points to receive: " + totalPoints);
                        System.out.println("  Total Points: " + (totalPoints + acc.getPoints()));
                        System.out.println("\n  Receipt printed. Thank you for shopping with us!\n\n[]================================================================================[]");
                        break;
                    } else {
                        System.out.println("\n  Card ID not found:" + intRes);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("\n  Invalid input. Please enter a number or N/n");
                }
            }
        }

    }
}