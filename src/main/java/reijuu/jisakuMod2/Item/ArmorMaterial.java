package reijuu.jisakuMod2.Item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import reijuu.jisakuMod2.Item.JisakuItems;
import reijuu.jisakuMod2.JisakuMod2;

import java.util.function.Supplier;

public record ArmorMaterial(String pName, int pDurabilityMultiplier, int[] pProtectionFunctionForType, int pEnchantmentValue, SoundEvent pSound, float pToughness, float pKnockbackResistance, Supplier  <Ingredient> repailMaterial)  implements net.minecraft.world.item.ArmorMaterial {


    private static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};


    public static final net.minecraft.world.item.ArmorMaterial ORIHALCON_INGOT = new reijuu.jisakuMod2.ArmorMaterial(
            "orihalcon",
            500,
            new int[]{20, 40, 50, 10},
            50,
            SoundEvents.ARMOR_EQUIP_DIAMOND,
            0.0f,
            0.0f,
            () -> Ingredient.of(JisakuItems.ORIHALCON_INGOT.get())
    );

    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()] * this.pDurabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return (Integer) this.pProtectionFunctionForType[type.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.pEnchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.pSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repailMaterial.get();
    }

    @Override
    public String getName() {
        return JisakuMod2.MODID + ":" + this.pName;
    }

    @Override
    public float getToughness() {
        return this.pToughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.pKnockbackResistance;
    }
}
