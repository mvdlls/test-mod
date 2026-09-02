package abilitymod.particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SingleQuadParticle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;

public class AbilityParticle extends SingleQuadParticle
{
    private final SpriteSet sprites;

    protected AbilityParticle(ClientLevel level, double x, double y, double z, SpriteSet sprites, int lifetime)
    {
        super(level, x, y, z, sprites.first());
        this.sprites = sprites;
        this.lifetime = lifetime;

        this.gravity = 0.0F;
        this.xd = 0.00D;
        this.yd = 0.05D;
        this.zd = 0.00D;
    }

    @Override
    protected Layer getLayer() {
        return Layer.TRANSLUCENT;
    }

    public static class Provider implements ParticleProvider<SimpleParticleType>
    {
        private final SpriteSet sprites;
        private final int lifetime;

        public Provider(SpriteSet sprites, int lifetime)
        {
            this.sprites = sprites;
            this.lifetime = lifetime;
        }

        @Override
        public Particle createParticle(SimpleParticleType type, ClientLevel level,
            double x, double y, double z, double xd, double yd, double zd, RandomSource random) {
            return new AbilityParticle(level, x, y, z, sprites, lifetime);
        }
    }
}
