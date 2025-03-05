public interface TelcoSubscription {
    String accept(UsagePromo promo, double price);
    String accept(UnliCallsTextOffer unliPackage, boolean unliCallText);
    String getTelcoName();
    double getPromoPrice();
    int getDataAllowance();
    boolean getUnliCallText();
}