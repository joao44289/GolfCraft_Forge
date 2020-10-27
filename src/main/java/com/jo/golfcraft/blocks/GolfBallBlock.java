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

public class GolfBallBlock extends Block {

    public static final VoxelShape SHAPE = Stream.of(
            Block.makeCuboidShape(5, 2, 5, 11, 6, 11), Block.makeCuboidShape(6, 7, 8, 10, 8, 9),
            Block.makeCuboidShape(7, 7, 9, 9, 8, 10), Block.makeCuboidShape(6, 7, 7, 10, 8, 8),
            Block.makeCuboidShape(7, 7, 6, 9, 8, 7), Block.makeCuboidShape(6, 6, 5, 10, 7, 8),
            Block.makeCuboidShape(5, 6, 6, 11, 7, 9), Block.makeCuboidShape(6, 6, 8, 10, 7, 11),
            Block.makeCuboidShape(5, 6, 7, 11, 7, 10), Block.makeCuboidShape(11, 5, 7, 12, 6, 9),
            Block.makeCuboidShape(11, 2, 7, 12, 3, 9), Block.makeCuboidShape(11, 3, 6, 12, 5, 10),
            Block.makeCuboidShape(4, 5, 7, 5, 6, 9), Block.makeCuboidShape(4, 2, 7, 5, 3, 9),
            Block.makeCuboidShape(4, 3, 6, 5, 5, 10), Block.makeCuboidShape(7, 5, 4, 9, 6, 5),
            Block.makeCuboidShape(7, 5, 11, 9, 6, 12), Block.makeCuboidShape(7, 2, 4, 9, 3, 5),
            Block.makeCuboidShape(7, 2, 11, 9, 3, 12), Block.makeCuboidShape(6, 3, 4, 10, 5, 5),
            Block.makeCuboidShape(6, 3, 11, 10, 5, 12), Block.makeCuboidShape(6, 0, 8, 10, 1, 9),
            Block.makeCuboidShape(7, 0, 6, 9, 1, 7), Block.makeCuboidShape(6, 0, 7, 10, 1, 8),
            Block.makeCuboidShape(7, 0, 9, 9, 1, 10), Block.makeCuboidShape(6, 1, 5, 10, 2, 8),
            Block.makeCuboidShape(5, 1, 6, 11, 2, 9), Block.makeCuboidShape(6, 1, 8, 10, 2, 11),
            Block.makeCuboidShape(5, 1, 7, 11, 2, 10)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public GolfBallBlock() {
        super(Block.Properties.create(Material.WOOL)
                .hardnessAndResistance(100.0f, 100.0f)
                .sound(SoundType.SNOW)
                .harvestLevel(3)
                .harvestTool(ToolType.AXE)
        );
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

}
