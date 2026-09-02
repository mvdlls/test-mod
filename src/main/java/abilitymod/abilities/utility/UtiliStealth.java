package abilitymod.abilities.utility;

import abilitymod.data.Ability;
import abilitymod.data.AbilityCategory;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class UtiliStealth implements Ability
{
    @Override
    public String getId() {
        return "stealth";
    }

    @Override
    public String getName() {
        return Component.translatable("abilities.utility.stealth").getString();
    }

    @Override
    public AbilityCategory getCategory() {
        return AbilityCategory.UTILITY;
    }

    @Override
    public int getCooldown() {
        return 200;
    }

    @Override
    public void onActivate(Level level, Player player) {
        System.out.println("Stealth activated!");
    }
}
