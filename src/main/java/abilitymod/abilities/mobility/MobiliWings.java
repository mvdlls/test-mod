package abilitymod.abilities.mobility;

import abilitymod.data.Ability;
import abilitymod.data.AbilityCategory;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class MobiliWings implements Ability
{
    @Override
    public String getId() {
        return "wings";
    }

    @Override
    public String getName() {
        return Component.translatable("abilities.mobility.wings").getString();
    }

    @Override
    public AbilityCategory getCategory() {
        return AbilityCategory.MOBILITY;
    }

    @Override
    public int getCooldown() {
        return 160;
    }

    @Override
    public void onActivate(Level level, Player player) {
        System.out.println("Wings activated!");
    }
}