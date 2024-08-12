package herb.herbsdecorations.block.custom;

import herb.herbsdecorations.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class JarBlock extends Block {
    private static final VoxelShape BODY_SHAPE = VoxelShapes.cuboid(0.25, 0.0, 0.25, 0.75, 0.5625, 0.75);
    private static final VoxelShape TOP_SHAPE = VoxelShapes.cuboid(0.3125, 0.625, 0.3125, 0.6875, 0.75, 0.6875);
    private static final VoxelShape BOTTOM_SHAPE = VoxelShapes.cuboid(0.375, 0.5, 0.375, 0.625, 0.625, 0.625);
    private static final VoxelShape RING_SHAPE = VoxelShapes.cuboid(0.25, 0.625, 0.25, 0.75, 0.6875, 0.75);
    private static final VoxelShape JAR_SHAPE = VoxelShapes.union(BODY_SHAPE, TOP_SHAPE, BOTTOM_SHAPE, RING_SHAPE);

    public JarBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return JAR_SHAPE;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        ItemStack heldItem = player.getMainHandStack(); // Get the item in the player's main hand

        if (heldItem.getItem() == Items.DIRT) {
            if (!world.isClient) {
                heldItem.decrement(1);

                world.setBlockState(pos, ModBlocks.SPECIES_JAR.getDefaultState());
            }
            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }
}
