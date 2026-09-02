package abilitymod.particles;

import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;

import static abilitymod.Abilities.MOD_ID;

public class AbilityParticles
{
    public static final SimpleParticleType AGGRESSIUM_PARTICLE = register("aggroparticle");
    public static final SimpleParticleType MOBILIUM_PARTICLE = register("mobiliparticle");
    public static final SimpleParticleType PROTISIUM_PARTICLE = register("proteparticle");
    public static final SimpleParticleType UTILIUM_PARTICLE = register("utiliparticle");

    private static SimpleParticleType register(String name)
    {
        return Registry.register(BuiltInRegistries.PARTICLE_TYPE,
                Identifier.fromNamespaceAndPath(MOD_ID, name),
                FabricParticleTypes.simple()
        );
    }

    public static void initialize()
    {
        ParticleFactoryRegistry registry = ParticleFactoryRegistry.getInstance();

        registry.register(AbilityParticles.AGGRESSIUM_PARTICLE,
                sprites -> new AbilityParticle.Provider(sprites, 10));
        registry.register(AbilityParticles.MOBILIUM_PARTICLE,
                sprites -> new AbilityParticle.Provider(sprites, 10));
        registry.register(AbilityParticles.PROTISIUM_PARTICLE,
                sprites -> new AbilityParticle.Provider(sprites, 10));
        registry.register(AbilityParticles.UTILIUM_PARTICLE,
                sprites -> new AbilityParticle.Provider(sprites, 10));
    }
}
