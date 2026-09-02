package abilitymod.data;

import abilitymod.Abilities;

import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;

public class AbilityComponents
{
    public static final DataComponentType<String> ABILITY = Registry.register(
        BuiltInRegistries.DATA_COMPONENT_TYPE, Abilities.ID("ability"),
        DataComponentType.<String>builder().persistent(Codec.STRING).build());

    public static void initialize() {
    }
}

