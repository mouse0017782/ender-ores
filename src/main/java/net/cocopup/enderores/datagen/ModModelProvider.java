package net.cocopup.enderores.datagen;

import net.cocopup.enderores.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_LAPIS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_DIAMOND);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_REDSTONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_IRON);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_COAL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_GOLD);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
}
