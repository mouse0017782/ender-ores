package net.cocopup.enderores.datagen;

import net.cocopup.enderores.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {

        addDrop(ModBlocks.END_COAL, oreDrops(ModBlocks.END_COAL, Items.COAL));
        addDrop(ModBlocks.END_IRON, oreDrops(ModBlocks.END_IRON, Items.RAW_IRON));
        addDrop(ModBlocks.END_GOLD, oreDrops(ModBlocks.END_GOLD, Items.RAW_GOLD));
        addDrop(ModBlocks.END_REDSTONE, redstoneLikeOreDrops(ModBlocks.END_REDSTONE, Items.REDSTONE));
        addDrop(ModBlocks.END_DIAMOND, oreDrops(ModBlocks.END_DIAMOND, Items.DIAMOND));
        addDrop(ModBlocks.END_LAPIS, lapisLikeOreDrops(ModBlocks.END_LAPIS, Items.LAPIS_LAZULI));


    }

    public LootTable.Builder lapisLikeOreDrops(Block drop, Item item) {
        return dropsWithSilkTouch(
                drop,
                (LootPoolEntry.Builder<?>)this.applyExplosionDecay(
                        drop,
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0F, 9.0F)))
                                .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))
                )
        );
    }

    public LootTable.Builder redstoneLikeOreDrops(Block drop, Item item) {
        return dropsWithSilkTouch(
                drop,
                (LootPoolEntry.Builder<?>)this.applyExplosionDecay(
                        drop,
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0F, 5.0F)))
                                .apply(ApplyBonusLootFunction.uniformBonusCount(Enchantments.FORTUNE))
                )
        );
    }

}
