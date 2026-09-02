package abilitymod.abilities.utility;

import abilitymod.data.Ability;
import abilitymod.data.AbilityCategory;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class UtiliTelekinesis implements Ability
{
    @Override
    public String getId() {
        return "telekinesis";
    }

    @Override
    public String getName() {
        return Component.translatable("abilities.utility.telekinesis").getString();
    }

    @Override
    public AbilityCategory getCategory() {
        return AbilityCategory.UTILITY;
    }

    @Override
    public int getCooldown() {
        return 160;
    }

    @Override
    public void onActivate(Level level, Player player) {
        System.out.println("Telekinesis activated!");
    }
}
