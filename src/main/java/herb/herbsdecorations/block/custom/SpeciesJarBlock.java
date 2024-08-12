package herb.herbsdecorations.block.custom;

import herb.herbsdecorations.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SpeciesJarBlock extends JarBlock {
    public SpeciesJarBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        ItemStack heldItem = player.getMainHandStack();

        if (heldItem.getItem() == Items.BROWN_MUSHROOM) {
            if (!world.isClient) {
                heldItem.decrement(1);

                world.setBlockState(pos, ModBlocks.SPECIES_JAR_WITH_BROWN_MUSHROOM.getDefaultState());
            }
            return ActionResult.SUCCESS;
        } else if (heldItem.getItem() == Items.RED_MUSHROOM) {
            if (!world.isClient) {
                heldItem.decrement(1);

                world.setBlockState(pos, ModBlocks.SPECIES_JAR_WITH_RED_MUSHROOM.getDefaultState());
            }
            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }
}