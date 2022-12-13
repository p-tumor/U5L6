public class BankApp {
    private String menu;
    private String subMenu;
    BagelShop shop;
    public BankApp(BagelShop shop){
        menu = "1. Make purchase/return to "+shop.getName()+".\n" +
                "2. Make a payment.\n" +
                "3. Open a second credit card.\n" +
                "4. Check "+shop.getName()+".\n" +
                "5. Exit";
        subMenu = "1. Check inventory.\n" +
                "2. Check profits.\n" +
                "3. Check price.\n" +
                "4. Modify price.\n" +
                "5. Buy more bagels.\n" +
                "6. Deposit profits.";
        this.shop = shop;
    }
    public void updateMenu(){
        menu = "1. Make purchase/return to "+shop.getName()+".\n" +
                "2. Make a payment.\n" +
                "3. Compare credit cards.\n" +
                "4. Check the inventory of "+shop.getName()+".\n" +
                "5. Deposit profits from "+shop.getName()+" into the bank.\n" +
                "5. Exit";
    }

    public String getSubMenu() {
        return subMenu;
    }

    public String getMenu() {
        return menu;
    }
}
