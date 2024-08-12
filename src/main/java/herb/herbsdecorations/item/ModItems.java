package herb.herbsdecorations.item;

import herb.herbsdecorations.HerbsDecorations;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item LABEL = registerItem("label", new Item(new Item.Settings()));
    public static final Item CATALOGUE = registerItem("catalogue", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(HerbsDecorations.MOD_ID, name), item);
    }

    public static void registerModItems() {
        HerbsDecorations.LOGGER.info("Registering Mod Items for " + HerbsDecorations.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(CATALOGUE);
            entries.add(LABEL);
        });
    }
}
