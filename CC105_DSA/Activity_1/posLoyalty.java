
class loyaltyAccounts{
    String accountName;
    int accountNumber = 0;
    int loyaltyPoints = 0;

    public void account1(){

    }

    public void account2(){
        
    }

    public void account3(){
        
    }
}

public class posLoyalty extends loyaltyAccounts{

    public static void main( String[] args){
        String[] productName = {"Choco Biscuits", "Organic Shampoo", "Instant Noodles", "Facial Cleanser", "Coffee Grounds", "Dishwashing Liquid", "Hand Sanitizer", "Tomato Sauce", "Dog Food (Beef)", "Floor Cleaner", "Laundry Detergent", "Sardines", "Air Freshener Spray", "Antibacterial Wipes", "Baby Powder", "Liquid Hand Soap", "Chocolate Bar", "Milk", "Cooking Oil", "Vitamin C Tablets"};
        int[] productAmount = {15, 1, 10, 5, 15, 1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1, 3, 1, 1, 1};
        double[] productPrices = {7.00, 150.25, 25.00, 90.50, 15.00, 189.75, 45.00, 25.00, 270.25, 283.50, 190.00, 35.25, 150.00, 48.75, 30.00, 63.50, 15.00, 120.50, 175.00, 90.75};
        double totalPrice = 0.00;

        posLoyalty loyaltyAccounts = new posLoyalty();
        

        for(int i = 0; i < productName.length; i++){
            totalPrice = totalPrice + productPrices[i];
        }

        System.out.println("[]==================[ POS Checkout Receipt ]==================[]\n  Item/s for Checkout:");
        for(int i = 0; i < productName.length; i++){
            String tabCorrection[] = {"", ""};
            if(productName[i].length() < 8){
                tabCorrection[0] = "\t\t\t";
                tabCorrection[1] = "\t";
            } else if(productName[i].length() >= 8 && productName[i].length() < 16){
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


            System.out.println("    " + (i + 1) + ".) " + productName[i] + tabCorrection[0] +"|| x" + productAmount[i] + " " + unitPluralCheck + tabCorrection[1] +"|| Php " + String.format("%.2f", productPrices[i]));
        }

        System.out.println("\n[]=====================[ Subtotal Price ]=====================[]");
        System.out.println("  Subtotal Price:\n    [ Php" + String.format("%.2f", totalPrice) + " ]\n");
        System.out.println("[]=====================[ Loyalty  Rewards ]=====================[]\n  Loyalty Rewards System:\n    + Does the user have a Loyalty Rewards Card? [Yy/Nn]: ");

    }
}