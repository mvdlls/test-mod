package abilitymod.abilities.aggression;

import abilitymod.data.Ability;
import abilitymod.data.AbilityCategory;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class AggroShockWave implements Ability
{
    @Override
    public String getId() {
        return "shockwave";
    }

    @Override
    public String getName() {
        return Component.translatable("abilities.aggression.shockwave").getString();
    }

    @Override
    public AbilityCategory getCategory() {
        return AbilityCategory.AGGRESSION;
    }

    @Override
    public int getCooldown() {
        return 120;
    }

    @Override
    public void onActivate(Level level, Player player) {
        System.out.println("Shock Wave activated!");
    }
}

