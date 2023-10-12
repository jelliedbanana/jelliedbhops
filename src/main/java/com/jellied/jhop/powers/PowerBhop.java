package com.jellied.jhop.powers;

import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.PowerType;
import net.minecraft.entity.LivingEntity;

public class PowerBhop extends Power {
    public PowerBhop(PowerType<?> type, LivingEntity entity) {
        super(type, entity);
    }

    public boolean isActive() {
        return true;
    }
}
