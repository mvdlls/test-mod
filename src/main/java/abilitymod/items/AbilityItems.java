package abilitymod.items;

import abilitymod.Abilities;
import abilitymod.data.Ability;
import abilitymod.data.AbilityCategory;
import abilitymod.data.AbilityRegistry;
import abilitymod.data.AbilityComponents;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.function.Function;

public final class AbilityItems
{
    public static final Item AGGRESSIUM = register("aggressium", AggressiumItem::new, new AggressiumItem.Properties());
    public static final Item MOBILIUM = register("mobilium", MobiliumItem::new, new MobiliumItem.Properties());
    public static final Item PROTISIUM = register("protisium", ProtisiumItem::new, new ProtisiumItem.Properties());
    public static final Item UTILIUM = register("utilium", UtiliumItem::new, new UtiliumItem.Properties());

    private static Item register(String name, Function<Item.Properties, Item> factory, Item.Properties properties)
    {
        Identifier id = Identifier.fromNamespaceAndPath(Abilities.MOD_ID, name);
        Item item = factory.apply(properties.setId(ResourceKey.create(Registries.ITEM, id)));
        return Registry.register(BuiltInRegistries.ITEM, id, item);
    }

    private static ItemStack createVariant(Item item, Ability ability)
    {
        ItemStack stack = new ItemStack(item);
        stack.set(AbilityComponents.ABILITY, ability.getId());
        return stack;
    }


    public static void initialize()
    {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(entries ->
        {
            for (Ability ability : AbilityRegistry.getAll(AbilityCategory.AGGRESSION)) {
                entries.accept(createVariant(AGGRESSIUM, ability));
            }

            for (Ability ability : AbilityRegistry.getAll(AbilityCategory.MOBILITY)) {
                entries.accept(createVariant(MOBILIUM, ability));
            }

            for (Ability ability : AbilityRegistry.getAll(AbilityCategory.PROTECTION)) {
                entries.accept(createVariant(PROTISIUM, ability));
            }

            for (Ability ability : AbilityRegistry.getAll(AbilityCategory.UTILITY)) {
                entries.accept(createVariant(UTILIUM, ability));
            }
        });
    }
}
