public class CreditCard
{
    private String accountHolder;
    private String personalPIN;
    private double balanceOwed;
    private static int cardsMade = 0;

    public CreditCard(String name, String personalPIN)
    {
        accountHolder = name;
        this.personalPIN = personalPIN;
        balanceOwed = 0;
        cardsMade++;
    }

    public String getAccountHolder()
    {
        return accountHolder;
    }

    public double getBalanceOwed()
    {
        return balanceOwed;
    }

    public static int getCardsMade(){return cardsMade;}

    /** Increases balanceOwed by the amount
     *
     *  @param amount  The amount of the credit card charge
     */
    public void chargeCard(double amount)
    {
        balanceOwed += amount;
    }

    /** Reduces balanceOwed by the amount
     *
     *  @param amount  The amount to reduce the balance
     */
    public void reduceBalance(double amount)
    {
        balanceOwed -= amount;
    }

    /** Checks to see if toCheckPIN matches personalPIN exactly;
     *  if so, return true, if not, return false.
     *
     *  @param toCheckPIN  The PIN to compare with personalPIN
     *
     *  @return  True if the PIN numbers match, otherwise return false
     */
    public boolean checkPIN(String toCheckPIN)
    {
        return personalPIN.equals(toCheckPIN);
    }

    public String toString()
    {
        String str = "CreditCard holder: " + accountHolder;
        str += "\nBalance Owed: " + balanceOwed;
        str += "\nPIN: " + personalPIN;
        return str;
    }
}
