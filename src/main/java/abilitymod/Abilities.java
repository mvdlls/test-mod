package abilitymod;

import abilitymod.data.AbilityRegistry;
import abilitymod.data.AbilityComponents;
import abilitymod.items.AbilityItems;
import abilitymod.particles.AbilityParticles;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Abilities implements ModInitializer
{
	public static final String MOD_ID = "abilitymod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize()
	{
		//ComponentTooltipAppenderRegistry.addAfter(DataComponents.DAMAGE, AbilityComponents.ABILITY_DATA);
		AbilityComponents.initialize();
		AbilityRegistry.initialize();
		AbilityParticles.initialize();
		AbilityItems.initialize();
	}

	public static Identifier ID(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
