package com.jo.golfcraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;
import java.util.stream.Stream;

public class GolfHoleBlock extends Block {

    public static final VoxelShape SHAPE = Stream.of(
            Block.makeCuboidShape(0, 0, 0, 16, 10, 16), Block.makeCuboidShape(11, 10, 6, 12, 11, 10),
            Block.makeCuboidShape(6, 10, 4, 10, 11, 12), Block.makeCuboidShape(4, 10, 6, 5, 11, 10),
            Block.makeCuboidShape(10, 10, 5, 11, 11, 11), Block.makeCuboidShape(5, 10, 5, 6, 11, 11),
            Block.makeCuboidShape(0, 10, 4, 4, 16, 12), Block.makeCuboidShape(12, 10, 4, 16, 16, 12),
            Block.makeCuboidShape(0, 10, 12, 16, 16, 16), Block.makeCuboidShape(0, 10, 0, 16, 16, 4),
            Block.makeCuboidShape(4, 10, 4, 5, 16, 6), Block.makeCuboidShape(4, 10, 10, 5, 16, 12),
            Block.makeCuboidShape(11, 10, 10, 12, 16, 12), Block.makeCuboidShape(11, 10, 4, 12, 16, 6),
            Block.makeCuboidShape(10, 11, 4, 11, 16, 5), Block.makeCuboidShape(5, 11, 4, 6, 16, 5),
            Block.makeCuboidShape(5, 11, 11, 6, 16, 12), Block.makeCuboidShape(10, 11, 11, 11, 16, 12)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public GolfHoleBlock() {
        super(Block.Properties.create(Material.EARTH)
                .hardnessAndResistance(100.0f, 100.0f)
                .sound(SoundType.STONE)
                .harvestLevel(3)
                .harvestTool(ToolType.AXE)
        );
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }
}
