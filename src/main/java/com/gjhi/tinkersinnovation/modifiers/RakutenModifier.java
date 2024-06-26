package com.gjhi.tinkersinnovation.modifiers;

import net.minecraft.core.Direction;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.event.entity.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.TinkerHooks;
import slimeknights.tconstruct.library.modifiers.hook.ProjectileHitModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeDamageModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.mining.BreakSpeedModifierHook;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.modifiers.util.ModifierHookMap;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModifierNBT;
import slimeknights.tconstruct.library.tools.nbt.NamespacedNBT;

import javax.annotation.Nullable;
import java.util.Objects;

public class RakutenModifier extends NoLevelsModifier implements ProjectileHitModifierHook, MeleeDamageModifierHook, BreakSpeedModifierHook {
    @Override
    protected void registerHooks(ModifierHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, TinkerHooks.MELEE_DAMAGE, TinkerHooks.PROJECTILE_HIT, TinkerHooks.BREAK_SPEED);
    }

    @Override
    public void onBreakSpeed(@NotNull IToolStackView tool, @NotNull ModifierEntry modifier, PlayerEvent.BreakSpeed event, @NotNull Direction sideHit, boolean isEffective, float miningSpeedModifier) {
        Player player = event.getPlayer();
        if (player != null) {
            Level world = player.getLevel();
            if (!(world.getLevelData().isRaining() || world.getLevelData().isThundering())) {
                event.setNewSpeed(event.getNewSpeed() + 6);
            }
        }
    }

    @Override
    public boolean onProjectileHitEntity(ModifierNBT modifiers, NamespacedNBT persistentData, @NotNull ModifierEntry modifier, @NotNull Projectile projectile, EntityHitResult hit, @Nullable LivingEntity attacker, @Nullable LivingEntity target) {
        if (target != null && projectile instanceof AbstractArrow arrow) {
            Level world = target.getLevel();
            if (world.getLevelData().isRaining() || world.getLevelData().isThundering()) {
                target.invulnerableTime = 0;
                target.hurt(DamageSource.arrow(arrow, target), 3.5f);
            }
        }
        return false;
    }

    @Override
    public float getMeleeDamage(@NotNull IToolStackView tool, @NotNull ModifierEntry modifier, ToolAttackContext context, float baseDamage, float damage) {
        Player player = context.getPlayerAttacker();
        if (player != null) {
            Level world = player.getLevel();
            if (world.getLevelData().isRaining() || world.getLevelData().isThundering()) {
                damage += 5;
            }
        }
        return damage;
    }
}
