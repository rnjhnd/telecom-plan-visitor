import java.util.*;

public class UnliCallTextPackage implements UnliCallsTextOffer {
    private static Map<String, String> unliPackageMap = new HashMap<>();

    static {
        unliPackageMap.put("Smart", "Does not offer any free calls or texts, and you will be charged per use.");
        unliPackageMap.put("Globe", "comes with unlimited calls and texts to subscribers within their network. Calls and texts to other networks are charged extra.");
        unliPackageMap.put("Dito", "This plan includes unlimited calls and texts to all networks within the country.");
    }

    @Override
    public String showUnliCallsTextOffer(String telcoName, boolean unliCallText) {
        return unliPackageMap.get(telcoName);
    }
}