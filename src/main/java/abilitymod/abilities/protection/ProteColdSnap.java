package abilitymod.abilities.protection;

import abilitymod.data.Ability;
import abilitymod.data.AbilityCategory;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class ProteColdSnap implements Ability
{
    @Override
    public String getId() {
        return "coldsnap";
    }

    @Override
    public String getName() {
        return Component.translatable("abilities.protection.coldsnap").getString();
    }

    @Override
    public AbilityCategory getCategory() {
        return AbilityCategory.PROTECTION;
    }

    @Override
    public int getCooldown() {
        return 160;
    }

    @Override
    public void onActivate(Level level, Player player) {
        System.out.println("Cold Snap activated!");
    }
}
