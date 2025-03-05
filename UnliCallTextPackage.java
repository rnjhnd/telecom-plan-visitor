import java.util.*;

public class UnliCallTextPackage implements UnliCallOffer {
    private static Map<String, String> uOfferMap = new HashMap<>();

    static {
        uOfferMap.put("Smart", "Does not offer any free calls or texts, and you will be charged per use.");
        uOfferMap.put("Globe", "comes with unlimited calls and texts to subscribers within their network. Calls and texts to other networks are charged extra.");
        uOfferMap.put("Dito", "This plan includes unlimited calls and texts to all networks within the country.");
    }

    @Override
    public String showUnliCallsTextOffer(String telcoName, boolean unliCallText) {
        return uOfferMap.get(telcoName);
    }
}