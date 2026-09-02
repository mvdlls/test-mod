package abilitymod.data;

import abilitymod.abilities.aggression.*;
import abilitymod.abilities.mobility.*;
import abilitymod.abilities.protection.*;
import abilitymod.abilities.utility.*;

import java.util.HashMap;
import java.util.Map;

public class AbilityRegistry
{
    private static final Map<String, Ability> ABILITIES = new HashMap<>();

    // Aggressium
    public static final Ability AGGRO_SHOCKWAVE = register(new AggroShockWave());
    public static final Ability AGGRO_FIREBALL = register(new AggroFireball());
    public static final Ability AGGRO_DETONATE = register(new AggroDetonate());
    public static final Ability AGGRO_TORNADO = register(new AggroTornado());
    public static final Ability AGGRO_RAGE = register(new AggroRage());

    // Mobilium
    public static final Ability MOBILI_LEVITATION = register(new MobiliLevitation());
    public static final Ability MOBILI_TELEPORT = register(new MobiliTeleport());
    public static final Ability MOBILI_JETPACK = register(new MobiliJetpack());
    public static final Ability MOBILI_FLASH = register(new MobiliFlash());
    public static final Ability MOBILI_WINGS = register(new MobiliWings());

    // Protisium
    public static final Ability PROTE_RESISTANCE = register(new ProteResistance());
    public static final Ability PROTE_COLDSNAP = register(new ProteColdSnap());
    public static final Ability PROTE_BARRIER = register(new ProteBarrier());
    public static final Ability PROTE_THORNS = register(new ProteThorns());
    public static final Ability PROTE_CLONE = register(new ProteClone());

    // Utilium
    public static final Ability UTILI_REGENERATION = register(new UtiliRegeneration());
    public static final Ability UTILI_TELEKINESIS = register(new UtiliTelekinesis());
    public static final Ability UTILI_STEALTH = register(new UtiliStealth());
    public static final Ability UTILI_REPAIR = register(new UtiliRepair());
    public static final Ability UTILI_PURIFY = register(new UtiliPurify());

    private static Ability register(Ability ability)
    {
        ABILITIES.put(ability.getId(), ability);
        return ability;
    }

    public static Ability get(String id, AbilityCategory category)
    {
        Ability ability = ABILITIES.get(id);
        if (ability == null) {
            return null;
        }

        if (ability.getCategory() != category) {
            return null;
        }

        return ability;
    }

    public static java.util.List<Ability> getAll(AbilityCategory category)
    {
        return ABILITIES.values().stream().filter(ability ->
                ability.getCategory() == category).toList();
    }

    public static void initialize() {
    }
}