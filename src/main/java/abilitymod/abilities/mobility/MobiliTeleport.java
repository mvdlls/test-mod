package abilitymod.abilities.mobility;

import abilitymod.data.Ability;
import abilitymod.data.AbilityCategory;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class MobiliTeleport implements Ability
{
    @Override
    public String getId() {
        return "teleport";
    }

    @Override
    public String getName() {
        return Component.translatable("abilities.mobility.teleport").getString();
    }

    @Override
    public AbilityCategory getCategory() {
        return AbilityCategory.MOBILITY;
    }

    @Override
    public int getCooldown() {
        return 140;
    }

    @Override
    public void onActivate(Level level, Player player) {
        System.out.println("Teleport activated!");
    }
}

