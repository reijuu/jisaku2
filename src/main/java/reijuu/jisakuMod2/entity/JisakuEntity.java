package reijuu.jisakuMod2.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import reijuu.jisakuMod2.entity.projectile.JisakuArrow;

public class JisakuEntity {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, "jisakumod2");

    public static final RegistryObject<EntityType<JisakuArrow>> JISAKU_ARROW = ENTITY_TYPES.register("jisaku_arrow",
            () -> EntityType.Builder.<JisakuArrow>of(JisakuArrow::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F) // サイズを調整
                    .build("jisaku_arrow"));
}
