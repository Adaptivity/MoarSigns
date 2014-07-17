package gory_moon.moarsigns.api;

import com.google.common.collect.Lists;
import net.minecraft.item.ItemStack;

import java.util.List;

public class SignRegistry {

    private static List<SignInfo> signRegistry = Lists.newArrayList();

    /**
     * Registers a sign
     * <br>
     *
     * The sign item texture needs to go into the "@MODID@/textures/item/" then depending on if it's metal or not
     * it needs too go into either "/metal" or "/wood"
     * <br><br>
     *
     * The sign texture needs  to go into the "@MODID@/textures/signs/" then depending on if it's metal or not
     * it needs too go into either "/metal" or "/wood"
     *
     * @param itemName The name of the texture for the sign and the item texture
     * @param property The special property that the sign have
     * @param materialName The name of the material
     * @param path Path to the folder that contains the sign texture in the "/metal" or "/wood" folder
     * @param gotNugget True if the metal have a nugget, nugget should be obtainable trough 1 metal = nugget in a normal crafting table
     * @param materialItemStack An itemstack of the material
     * @param modId The modId that registers the sign, used when getting the textures.
     * @return returns the {@link gory_moon.moarsigns.api.SignInfo} that is registered
     */
    public static SignInfo register(String itemName, SignSpecialProperty property, String materialName, String path, boolean gotNugget, ItemStack materialItemStack, String modId) {
        MaterialInfo info = MaterialRegistry.register(materialName, path, gotNugget, materialItemStack);
        return register(itemName, property, info, modId);
    }

    private static SignInfo register(String itemName, SignSpecialProperty property, MaterialInfo material, String modId) {
        if (!MaterialRegistry.contains(material))
            MaterialRegistry.register(material);

        SignInfo signInfo = new SignInfo(itemName, material, property, modId);
        signRegistry.add(signInfo);
        return signInfo;
    }

    /**
     * Gets the {@link gory_moon.moarsigns.api.SignInfo} of a sign composed by the path and the itemname
     * @param s The string composed by the path and the itemname that is used for the search
     * @return The found {@link gory_moon.moarsigns.api.SignInfo} or if not found it returns null
     */
    public static SignInfo get(String s) {
        for (SignInfo info : signRegistry) {
            if ((info.material.path.replace("\\", "/") + info.itemName).equals(s)) {
                return info;
            }
        }
        return null;
    }

    public static List<SignInfo> getSignRegistry() {
        return signRegistry;
    }
}
