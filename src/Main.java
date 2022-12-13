import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        BagelShop bagelShop = null;
        int inv = 0;
        double price = 0;
        //creating credit card object
        Scanner s = new Scanner(System.in);
        System.out.println("What's your name?");
        String name = s.nextLine();
        System.out.println("What would you like your personal pin to be?");
        String pin = s.nextLine();
        CreditCard card = new CreditCard(name,pin);
        //creating bagelShop object
        System.out.println("What would you like to name your bagel shop?");
        String shopName = s.nextLine();
        //input validation; user can choose to choose their own values for bagelShop object.They will be set to a default otherwise.
        boolean notValid = true;
        while (notValid) {
            System.out.println("Would you like to configure " + shopName + "?(Y/N)");
            String answer = s.nextLine();
            if(answer.equals("Y")||answer.equals("y")){
                notValid = false;
                boolean notValid2 = true;
                while (notValid2) {
                    System.out.println("How much inventory do you have?");
                    String invTemp = s.nextLine();
                    try{
                        inv = Integer.parseInt(invTemp);
                        notValid2 = false;
                    }catch(Exception e){ System.out.println("Invalid input.");}
                }
                notValid2 = true;
                while (notValid2) {
                    System.out.println("How much are your bagels?");
                    String invTemp = s.nextLine();
                    try{
                        price = Double.parseDouble(invTemp);
                        price *= 100;
                        price = Math.round(price);
                        price /= 100;
                        notValid2 = false;
                    }catch(Exception e){ System.out.println("Invalid input.");}
                }
                bagelShop = new BagelShop(shopName,inv,price,bank);
            }else if (answer.equals("N")||answer.equals("n")){
                notValid = false;
                bagelShop = new BagelShop(shopName,1000,1.25,bank);
            }
        }
        //app stuff
        BankApp app = new BankApp(bagelShop);
        boolean isOver = false;
        int choice = 0;
        while (!isOver) {
            notValid = true;
            if (notValid){
                System.out.println(app.getMenu() + "\n");
                String choiceTemp = s.nextLine();
                try{
                    choice = Integer.parseInt(choiceTemp);
                    if (choice > 5 && choice < 1){
                        System.out.println("Invalid.");
                    }else{
                        notValid = false;
                    }
                }catch(Exception e){
                    System.out.println("Invalid");
                }
            }
            String response;
            notValid = true;
            if (choice == 1){
                if (notValid){
                    System.out.println("Would you like to make a purchase or return?");
                    response = s.nextLine();
                    if (response.equals("purchase")){
                        System.out.println("How many would you like?");
                        System.out.println();
                    }

                }
            }
        }
    }
}