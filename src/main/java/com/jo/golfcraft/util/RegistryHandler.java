package com.jo.golfcraft.util;

import com.jo.golfcraft.Golfcraft;
import com.jo.golfcraft.Items.ItemBase;
import com.jo.golfcraft.blocks.BlockItemBase;
import com.jo.golfcraft.blocks.GolfBallBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Golfcraft.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Golfcraft.MOD_ID);

    public static void init(){

        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //Items
    public static final RegistryObject<Item> GOLF_CLUB = ITEMS.register("golf_club", ItemBase::new);

    //Blocks
    public static final RegistryObject<Block> GOLF_BALL_BLOCK = BLOCKS.register("golf_ball_block", GolfBallBlock::new);

    //Blocks Items
    public static final RegistryObject<Item> GOLF_BALL_BLOCK_ITEM = ITEMS.register("golf_ball_block", ()-> new BlockItemBase(GOLF_BALL_BLOCK.get()));
}
