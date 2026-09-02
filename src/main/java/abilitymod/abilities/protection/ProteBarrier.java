package abilitymod.abilities.protection;

import abilitymod.data.Ability;
import abilitymod.data.AbilityCategory;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class ProteBarrier implements Ability
{
    @Override
    public String getId() {
        return "barrier";
    }

    @Override
    public String getName() {
        return Component.translatable("abilities.protection.barrier").getString();
    }

    @Override
    public AbilityCategory getCategory() {
        return AbilityCategory.PROTECTION;
    }

    @Override
    public int getCooldown() {
        return 200;
    }

    @Override
    public void onActivate(Level level, Player player) {
        System.out.println("Barrier activated!");
    }
}
