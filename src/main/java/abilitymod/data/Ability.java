package abilitymod.data;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public interface Ability
{
    String getId();

    String getName();

    AbilityCategory getCategory();

    int getCooldown();

    void onActivate(Level level, Player player);
}


