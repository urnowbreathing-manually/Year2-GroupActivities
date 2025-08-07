import java.util.Scanner;
import java.util.Random;
import java.util.Vector;

class loyaltyAccounts{
    int accountNumber = 0;
    int loyaltyPoints = 0;
    // Vector<String> productsSelected = new Vector<>();

    loyaltyAccounts(int cardID, int cur_p) {
        this.accountNumber = cardID;
        this.loyaltyPoints = cur_p;
    }

    public int getPoints() {
        return loyaltyPoints;
    }

    public int getCardID() {
        return accountNumber;
    }
}

public class posLoyalty {
    public static void main( String[] args){
        String[] productName = {"Choco Biscuits", "Organic Shampoo", "Instant Noodles", "Facial Cleanser", "Coffee Grounds", "Dishwashing Liquid", "Hand Sanitizer", "Tomato Sauce", "Dog Food (Beef)", "Floor Cleaner", "Laundry Detergent", "Sardines", "Air Freshener Spray", "Antibacterial Wipes", "Baby Powder", "Liquid Hand Soap", "Chocolate Bar", "Milk", "Cooking Oil", "Vitamin C Tablets"};
        int[] productAmount = {15, 1, 10, 5, 15, 1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1, 3, 1, 1, 1};
        double[] productPrices = {7.00, 150.25, 25.00, 90.50, 15.00, 189.75, 45.00, 25.00, 270.25, 283.50, 190.00, 35.25, 150.00, 48.75, 30.00, 63.50, 15.00, 120.50, 175.00, 90.75};
        int[] productPoints = {1, 3, 1, 2, 3, 1, 2, 1, 1, 2, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1};
        double totalPrice = 0.00;
        
        // generate random customer
        Random rndg = new Random();
        int cardID = rndg.nextInt(9999);
        int currentPnts = rndg.nextInt(9999);
        loyaltyAccounts acc = new loyaltyAccounts(cardID, currentPnts);
        System.out.println("card id: " + acc.getCardID() + "\n points: " + acc.getPoints());

        // generate random items
        int prod_cont = rndg.nextInt(productName.length);
        Vector<String> prods_selected = new Vector<>();
        Vector<Double> prods_price = new Vector<>();
        Vector<Double> prods_total_price = new Vector<>();
        Vector<Integer> prods_amount = new Vector<>();

        for (int d = 0; d < prod_cont; d++) {
            int num_gen = rndg.nextInt(productName.length);
            int p_amount = rndg.nextInt(20);

            prods_selected.addElement(productName[num_gen]);
            prods_amount.addElement(p_amount);
            prods_price.addElement(productPrices[num_gen]);
            prods_total_price.addElement(productPrices[num_gen] * p_amount);
        }

        for (double price : prods_total_price) {
            totalPrice += price;
        }

        // System.out.println("\nProds selected list\n");
        // for(String p : prods_selected) {
        //     System.out.println(p);
        // }

        System.out.println("[]==================[ POS Checkout Receipt ]==================[]\n  Item/s for Checkout:");

        int i = 0;
        for (String product : prods_selected) {
            String tabCorrection[] = {"", ""};
            if(product.length() < 8){
                tabCorrection[0] = "\t\t\t";
                tabCorrection[1] = "\t";
            } else if(product.length() >= 8 && product.length() < 16){
                tabCorrection[0] = "\t\t";
                tabCorrection[1] = "\t";
            } else{
                tabCorrection[0] = "\t";
                tabCorrection[1] = "\t";
            }

            String unitPluralCheck;
            if(productAmount[i] != 1){
                unitPluralCheck = "units";
            } else{
                unitPluralCheck = "unit";
            }


            System.out.println("    " + (i + 1) + ".) " + product + tabCorrection[0] +"|| x" + prods_amount.get(i) + " " + unitPluralCheck + tabCorrection[1] + "|| Php " + String.format("%.2f", prods_price.get(i)) + " || Php " + String.format("%.2f", prods_total_price.get(i)));
            i+=1;
        }

        System.out.println("\n[]=====================[ Subtotal Price ]=====================[]");
        System.out.println("  Subtotal Price:\n    [ Php " + String.format("%.2f", totalPrice) + " ]\n");

        Scanner card_input = new Scanner(System.in);
        System.out.print("Enter the card ID here (Type N|n if no card): ");
          String res = card_input.nextLine();

          if (res.equalsIgnoreCase("N")) {
              System.out.println("Printed Receipt");
          } else {
              try {
                  int intRes = Integer.parseInt(res);

                  if (intRes == acc.getCardID()) {
                      System.out.println("\n[]=====================[ Loyalty  Rewards ]=====================[]");

                      int totalPoints = 0;
                      for (int j = 0; j < productName.length; j++) {
                          totalPoints += rndg.nextInt(5) + 1;
                      }

                      System.out.println("\tCurrent Points: " + acc.getPoints());
                      System.out.println("\tPoints to receive: " + totalPoints);
                      System.out.println("\tTotal Points: " + (totalPoints + acc.getPoints()));

                      System.out.println("[]=====================[ Loyalty  Rewards ]=====================[]\n");

                  } else {
                      System.out.println("Card ID not found:" + intRes);
                  }
              } catch (NumberFormatException e) {
                  System.out.println("Invalid input. Please enter a number or N/n");
              }
          }

//        int res = card_input.nextInt();
//
//        if (res == acc.getCardID()) {
//            System.out.println("\n[]=====================[ Loyalty  Rewards ]=====================[]");
//
//            int totalPoints = 0;
//            for (int j = 0; j < productName.length; j++) {
//                totalPoints += rndg.nextInt(5) + 1;
//            }
//
//            System.out.println("\tCurrent Points: " + acc.getPoints());
//            System.out.println("\tPoints to receive: " + totalPoints);
//            System.out.println("\tTotal Points: " + (totalPoints + acc.getPoints()));
//
//            System.out.println("[]=====================[ Loyalty  Rewards ]=====================[]\n");
//        } else {
//            System.out.println("No card: " + res);
//        }

    }
}