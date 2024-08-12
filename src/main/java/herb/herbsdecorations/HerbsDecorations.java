package herb.herbsdecorations;

import herb.herbsdecorations.block.ModBlocks;
import herb.herbsdecorations.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HerbsDecorations implements ModInitializer {
	public static final String MOD_ID = "herbsdecorations";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerBlocks();
	}
}