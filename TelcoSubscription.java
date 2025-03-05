public interface TelcoSubscription {
    String accept(UsagePromo promo);
    String accept(UnliCallsTextOffer offer);
    String getTelcoName();
    double getPromoPrice();
    int getDataAllowance();
    boolean getUnliCallText();
}