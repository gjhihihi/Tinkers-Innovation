package com.gjhi.tinkersinnovation.register;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.gjhi.tinkersinnovation.TinkersInnovation.MOD_ID;

public class TinkersInnovationBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
    private static final BlockBehaviour.Properties METAL = Block.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(5F, 1200f).sound(SoundType.METAL);
    private static final BlockBehaviour.Properties ORE = Block.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(2.5F, 5f).sound(SoundType.STONE);
    private static final BlockBehaviour.Properties END_ORE = Block.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3F, 5.5f).sound(SoundType.STONE);
    private static final BlockBehaviour.Properties DEEPSLATE_ORE = Block.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(2.5F, 5f).sound(SoundType.DEEPSLATE);
    private static final BlockBehaviour.Properties RAW_BLOCK = BlockBehaviour.Properties.copy(Blocks.RAW_COPPER_BLOCK);//cu'kuang'kuai
    private static final BlockBehaviour.Properties BEDROCK = BlockBehaviour.Properties.copy(Blocks.BEDROCK);

    public static RegistryObject<Block> polychrome_alloy_block = BLOCKS.register("polychrome_alloy_block", () -> new Block(METAL));
    public static RegistryObject<Block> void_crystal_block = BLOCKS.register("void_crystal_block", () -> new Block(METAL));
    public static RegistryObject<Block> enchantment_block = BLOCKS.register("enchantment_block", () -> new Block(METAL));
    public static RegistryObject<Block> life_block = BLOCKS.register("life_block", () -> new Block(METAL));
    public static RegistryObject<Block> ocean_block = BLOCKS.register("ocean_block", () -> new Block(METAL));
    public static RegistryObject<Block> slimton_block = BLOCKS.register("slimton_block", () -> new Block(METAL));
    public static RegistryObject<Block> ether_block = BLOCKS.register("ether_block", () -> new Block(METAL));

    public static RegistryObject<Block> void_crystal_ore = BLOCKS.register("void_crystal_ore", () -> new Block(DEEPSLATE_ORE));
    public static RegistryObject<Block> apatite_block = BLOCKS.register("apatite_block", () -> new Block(ORE));
    public static RegistryObject<Block> seared_bedrock = BLOCKS.register("seared_bedrock", () -> new Block(BEDROCK));
    public static RegistryObject<Block> scorched_bedrock = BLOCKS.register("scorched_bedrock", () -> new Block(BEDROCK));

}