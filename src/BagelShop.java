public class BagelShop
{
    /** The name of the BagelShop */
    private String name;

    /** The earned profit so far */
    private int profit;

    /** How many bagels are in inventory */
    private int inventory;

    /** The price of each bagel (in dollars) */
    private double bagelPrice;

    /** The Bank where the BagelShop has a vendor deposit account */
    private Bank vendorBank;

    private double purchasePrice;
    private double total;

    /** Creates a new BagelShop
     @param name  The name of the BagelShop
     @param inventory  How many bagels in starting inventory
     @param bagelPrice  How much (in dollars) each bagel costs
     @param vendorBank  The bank the BagelShop is using for depositing profits
     */
    public BagelShop(String name, int inventory, double bagelPrice, Bank vendorBank)
    {
        profit = 0;
        this.name = name;
        this.inventory = inventory;
        this.bagelPrice = bagelPrice;
        this.vendorBank = vendorBank;
        purchasePrice = bagelPrice/4;
        total = 0;
    }


    public String getName() {
        return name;
    }

    public int getProfit() {
        return profit;
    }

    public int getInventory() {
        return inventory;
    }

    public double getBagelPrice() {
        return bagelPrice;
    }

    public Bank getVendorBank() {
        return vendorBank;
    }

    public double getPurchasePrice(){
        return purchasePrice;
    }
//-------------------------------------------------------------
    public void setName(String name) {
        this.name = name;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public void setBagelPrice(double bagelPrice) {
        this.bagelPrice = bagelPrice;
    }
    public void setPurchasePrice(double purchasePrice){
        this.purchasePrice = purchasePrice;
    }


    /** First checks to see if the provided cardPIN matches the PIN number of the
     credit card; if not,do nothing, and immediately return false (purchase was not successful)

     If cardPIN number matches the credit card's PIN, calculate the total price of the purchase
     (bagel's price x quantity purchased), charge the credit card for that amount, add that
     amount to the bagel shop's profit, and reduce quantity.  Return true (bagel purchase was successful).

     @param card  The CreditCard used to pay for the bagels
     @param quantity  How many bagels are being purchasd
     @param cardPIN  The PIN number provided by the customer

     @return  Return true if the purchase was successful, false if the purchase was unsuccessful
     */
    public boolean payForBagels(CreditCard card, int quantity, String cardPIN)
    {
        if (card.checkPIN(cardPIN)){
            double total = quantity*bagelPrice;
            card.chargeCard(total);
            profit+= total;
            inventory -= quantity;
            return true;
        }
        return false;
    }

    /** First checks to see if the provided cardPIN matches the PIN number of the
     credit card; if not,do nothing, and immediately return false (purchase was not successful)

     If cardPIN number matches the credit card's PIN, calculate the total price of the return
     (bagel's price x quantity purchased), reduce the balance on the credit card for that amount, reduce
     the bagel shop's profit by that amount; do NOT add returned bagels back to inventory (yuck!).
     Return true (the bagel return was successful).

     @param card  The CreditCard used to pay for the bagels
     @param quantity  How many bagels are being purchasd
     @param cardPIN  The PIN number provided by the customer

     @return  Return true if the purchase was successful, false if the purchase was unsuccessful
     */
    public boolean returnBagels(CreditCard card, int quantity, String cardPIN)
    {
        if (card.checkPIN(cardPIN)){
            double total = quantity*bagelPrice;
            card.reduceBalance(total);
            profit-=total;
            return true;
        }
        return false;
    }

    /** Deposits all current profits in the vendorBank
     *  and sets profits back to 0.
     */
    public void depositProfits()
    {
        vendorBank.vendorDeposit(profit);
        profit = 0;
    }

    public String receipt(){

    }

    public String toString()
    {
        String str = "Vendor: " + name;
        str += "\nProfit: " + profit;
        str += "\nInventory: " + inventory;
        str += "\nItem price: " + bagelPrice;

        // omitting the bank instance variable from the String
        return str;
    }
}

