package abilitymod.items;

import abilitymod.data.Ability;
import abilitymod.data.AbilityCategory;
import abilitymod.data.AbilityComponents;
import abilitymod.data.AbilityRegistry;
import abilitymod.particles.AbilityParticles;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class AggressiumItem extends Item
{
    public AggressiumItem(Properties properties) {
        super(properties.stacksTo(1));
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand)
    {
        ItemStack stack = player.getItemInHand(hand);
        String abilityId = stack.get(AbilityComponents.ABILITY);

        if (abilityId == null) {
            return InteractionResult.FAIL;
        }

        if (player.getCooldowns().isOnCooldown(stack)) {
            return InteractionResult.FAIL;
        }

        Ability ability = AbilityRegistry.get(abilityId, AbilityCategory.AGGRESSION);
        if (ability == null) {
            return InteractionResult.FAIL;
        }

        player.getCooldowns().addCooldown(stack, ability.getCooldown());
        if (!level.isClientSide())
        {
            spawnParticles((ServerLevel)level, player);
            ability.onActivate(level, player);
        }

        return InteractionResult.SUCCESS;
    }

    private void spawnParticles(ServerLevel level, Player player)
    {
        double x = player.getX();
        double y = player.getY() + 0.5D;
        double z = player.getZ();
        level.sendParticles(AbilityParticles.AGGRESSIUM_PARTICLE, x, y, z, 30, 0.3D, 0.4D, 0.3D, 0.1D);
    }

    public static AbilityCategory getCategory() {
        return AbilityCategory.AGGRESSION;
    }
}
