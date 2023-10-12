package com.jellied.jhop;

import com.jellied.jhop.powers.PowerBhop;
import io.github.apace100.apoli.Apoli;
import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.factory.PowerFactory;
import io.github.apace100.apoli.registry.ApoliRegistries;
import io.github.apace100.calio.data.SerializableData;
import io.github.apace100.origins.origin.Origin;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.ConfigManager;
import me.sargunvohra.mcmods.autoconfig1u.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import com.jellied.jhop.config.BhopsConfig;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Bhops implements ModInitializer {
	public static final String MOD_ID = "jelliedbhops";
	public static ConfigManager configManager;
	public static final PowerFactory<Power> BHOP = new PowerFactory<>(createId("bhop"),
			new SerializableData(),
			data -> (type, entity) -> new PowerBhop(type, entity)).allowCondition();

	public static Identifier createId(String name) {
		return new Identifier(MOD_ID, name);
	}

	@Override
	public void onInitialize() {
		AutoConfig.register(BhopsConfig.class, GsonConfigSerializer::new);

		Registry.register(ApoliRegistries.POWER_FACTORY, BHOP.getSerializerId(), BHOP);

		System.out.println("jhops initialized :3");
	}
}
