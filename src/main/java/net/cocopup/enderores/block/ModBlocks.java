package net.cocopup.enderores.block;

import net.cocopup.enderores.EnderOres;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block END_IRON = registerBlock("end_iron",
            new Block(AbstractBlock.Settings.copy(Blocks.IRON_ORE).sounds(BlockSoundGroup.STONE)));

    public static final Block END_COAL = registerBlock("end_coal",
            new Block(AbstractBlock.Settings.copy(Blocks.COAL_ORE).sounds(BlockSoundGroup.STONE)));

    public static final Block END_GOLD = registerBlock("end_gold",
            new Block(AbstractBlock.Settings.copy(Blocks.GOLD_ORE).sounds(BlockSoundGroup.STONE)));

    public static final Block END_REDSTONE = registerBlock("end_redstone",
            new Block(AbstractBlock.Settings.copy(Blocks.REDSTONE_ORE).sounds(BlockSoundGroup.STONE)));

    public static final Block END_LAPIS = registerBlock("end_lapis",
            new Block(AbstractBlock.Settings.copy(Blocks.LAPIS_ORE).sounds(BlockSoundGroup.STONE)));

    public static final Block END_DIAMOND = registerBlock("end_diamond",
            new Block(AbstractBlock.Settings.copy(Blocks.DIAMOND_ORE).sounds(BlockSoundGroup.STONE)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(EnderOres.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(EnderOres.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }
}
