package abilitymod.abilities.aggression;

import abilitymod.data.Ability;
import abilitymod.data.AbilityCategory;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class AggroRage implements Ability
{
    @Override
    public String getId() {
        return "rage";
    }

    @Override
    public String getName() {
        return Component.translatable("abilities.aggression.rage").getString();
    }

    @Override
    public AbilityCategory getCategory() {
        return AbilityCategory.AGGRESSION;
    }

    @Override
    public int getCooldown() {
        return 200;
    }

    @Override
    public void onActivate(Level level, Player player) {
        System.out.println("Rage activated!");
    }
}
