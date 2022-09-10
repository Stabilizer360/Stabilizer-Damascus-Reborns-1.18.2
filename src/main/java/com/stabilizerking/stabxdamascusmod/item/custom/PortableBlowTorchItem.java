package com.stabilizerking.stabxdamascusmod.item.custom;

import com.google.common.collect.ImmutableBiMap;
import com.stabilizerking.stabxdamascusmod.block.ModBlocks;
import com.stabilizerking.stabxdamascusmod.item.ModItems;
import net.minecraft.Util;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

public class PortableBlowTorchItem extends Item {
    private static final Map<Block, Item> PORTABLE_BLOW_TORCH_ITEM_CRAFT =
            new ImmutableBiMap.Builder<Block, Item>()
                    .put(ModBlocks.INSANE_DAMASCUS_BLOCK.get(), ModItems.DAMASCUS_INGOT.get())
                    .put(Blocks.SAND, Blocks.GLASS.asItem())
                    .put(Blocks.COBBLESTONE, Blocks.STONE.asItem())
                    .put(Blocks.COBBLED_DEEPSLATE, Blocks.DEEPSLATE.asItem())
                    .put(Blocks.COAL_ORE, Blocks.COAL_BLOCK.asItem())
                    .put(Blocks.DEEPSLATE_DIAMOND_ORE, Blocks.DIAMOND_BLOCK.asItem())
                    .put(Blocks.DIAMOND_ORE, Items.DIAMOND.asItem())
                    .put(Blocks.GOLD_ORE, Items.GOLD_INGOT.asItem())
                    .put(Blocks.BLUE_TERRACOTTA, Items.BLUE_GLAZED_TERRACOTTA.asItem())
                    .put(Blocks.GRAY_TERRACOTTA, Items.GRAY_GLAZED_TERRACOTTA.asItem())
                    .build();


    public PortableBlowTorchItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if (!pContext.getLevel().isClientSide()) {
            Level level = pContext.getLevel();
            BlockPos positionClicked = pContext.getClickedPos();
            Block blockClicked = level.getBlockState(positionClicked).getBlock();

            if (canBlowTorch(blockClicked)) {
                ItemEntity entityItem = new ItemEntity(level,
                        positionClicked.getX(), positionClicked.getY(), positionClicked.getZ(),
                        new ItemStack(PORTABLE_BLOW_TORCH_ITEM_CRAFT.get(blockClicked), 1));

                level.destroyBlock(positionClicked, false);
                level.addFreshEntity(entityItem);
                pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(), p -> {
                    p.broadcastBreakEvent(pContext.getHand());
                });
            } else {
                pContext.getPlayer().sendMessage(new TextComponent("Cannnot break this Block my guy!"),
                        Util.NIL_UUID);

            }

        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel,
                                List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {

        if(Screen.hasShiftDown()) {
            pTooltipComponents.add(new TranslatableComponent("tooltip.stabxdamascusmod.portableblowtorch"));
        } else {
            pTooltipComponents.add(new TranslatableComponent("tooltip.stabxdamascusmod.portableblowtorch_shift"));
        }
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    private boolean canBlowTorch(Block block) {return PORTABLE_BLOW_TORCH_ITEM_CRAFT.containsKey(block);}
}