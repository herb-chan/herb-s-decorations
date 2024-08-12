package herb.herbsdecorations.block;

import herb.herbsdecorations.HerbsDecorations;
import herb.herbsdecorations.block.custom.JarBlock;
import herb.herbsdecorations.block.custom.SpeciesJarBlock;
import herb.herbsdecorations.block.custom.SpeciesJarWithBrownMushroom;
import herb.herbsdecorations.block.custom.SpeciesJarWithRedMushroom;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block JAR = register(
            "jar",
            new JarBlock(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GLASS)),
            true
    );

    public static final Block SPECIES_JAR = register(
            "species_jar",
            new SpeciesJarBlock(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GLASS)),
            true
    );

    public static final Block SPECIES_JAR_WITH_BROWN_MUSHROOM = register(
            "species_jar_with_brown_mushroom",
            new SpeciesJarWithBrownMushroom(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GLASS)),
            true
    );

    public static final Block SPECIES_JAR_WITH_RED_MUSHROOM = register(
            "species_jar_with_red_mushroom",
            new SpeciesJarWithRedMushroom(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GLASS)),
            true
    );

    public static Block register(String name, Block block, boolean shouldRegisterItem) {
        Identifier id = Identifier.of(HerbsDecorations.MOD_ID, name);

        if (shouldRegisterItem) {
            BlockItem blockItem;
            blockItem = new BlockItem(block, new Item.Settings());
            Registry.register(Registries.ITEM, id, blockItem);
        }

        return Registry.register(Registries.BLOCK, id, block);
    }

    public static void registerBlocks() {
        HerbsDecorations.LOGGER.info("Registering Mod Blocks for " + HerbsDecorations.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(JAR);
            entries.add(SPECIES_JAR);
            entries.add(SPECIES_JAR_WITH_BROWN_MUSHROOM);
            entries.add(SPECIES_JAR_WITH_RED_MUSHROOM);
        });
    }
}
