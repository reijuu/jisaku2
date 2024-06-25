package reijuu.jisakuMod2.datagen.server;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import reijuu.jisakuMod2.Item.JisakuItems;
import reijuu.jisakuMod2.JisakuMod2;
import reijuu.jisakuMod2.block.JisakBlocks;

import java.util.Iterator;
import java.util.List;

public class JisakuRecipeProvider extends RecipeProvider {
    public JisakuRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }
    // オリハルコンインゴットを生成できるアイテムのリスト
    public static final List<ItemLike> ORIHALCON_SMELTABLLE =
            List.of(JisakuItems.RAW_ORIHALCON.get(),

                    JisakBlocks.ORIHALCON_ORE.get(),
                    JisakBlocks.DEEPSLATE_ORIHALCON_ORE.get());

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        // VanillaRecipeProviderを検索して参考に
        nineBlockStorageRecipes(pRecipeOutput, RecipeCategory.MISC,
                JisakuItems.ORIHALCON_INGOT.get(),
                RecipeCategory.BUILDING_BLOCKS,
                JisakBlocks.ORIHALCON_BLOCK.get());
        nineBlockStorageRecipes(pRecipeOutput, RecipeCategory.MISC,
                JisakuItems.RAW_ORIHALCON.get(),
                RecipeCategory.BUILDING_BLOCKS,
                JisakBlocks.RAW_ORIHALCON_BLOCK.get());
        oreSmelting(pRecipeOutput,ORIHALCON_SMELTABLLE,RecipeCategory.MISC,JisakuItems.ORIHALCON_INGOT.get(),
                // 製錬時の経験値と時間
                1.0f,200,"orihalcon");
        oreBlasting(pRecipeOutput,ORIHALCON_SMELTABLLE,RecipeCategory.MISC,JisakuItems.ORIHALCON_INGOT.get(),
                // 製錬時の経験値と時間
                1.0f,100,"orihalcon");

        // アイテムレシピの追加
         ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, JisakuItems.ORIHALCON_SWORD.get())
                .define('#', JisakuItems.ORIHALCON_INGOT.get())
                .define('X', Items.STICK)
                .pattern(" # ")
                .pattern(" # ")
                .pattern(" X ")
                .unlockedBy("has_orihalcon_ingot", has(JisakuItems.ORIHALCON_INGOT.get()))
                .save(pRecipeOutput);
    }

    // かまど用のレシピ
    protected static void oreSmelting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    // 溶鉱炉用のレシピ
    protected static void oreBlasting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    private static void oreCooking(RecipeOutput pRecipeOutput, RecipeSerializer<? extends AbstractCookingRecipe> pSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pSuffix) {

        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult, pExperience, pCookingTime, pSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pRecipeOutput,
                            JisakuMod2.MODID + ":" + getItemName(pResult) + pSuffix + "_" + getItemName(itemlike));
        }
    }
    protected static void nineBlockStorageRecipes(RecipeOutput pRecipeOutput,
                                                  RecipeCategory pUnpackedCategory,
                                                  ItemLike pUnpacked,
                                                  RecipeCategory pPackedCategory,
                                                  ItemLike pPacked) {
        ShapelessRecipeBuilder.shapeless(pUnpackedCategory, pUnpacked, 9)
                .requires(pPacked).unlockedBy(getHasName(pPacked), has(pPacked)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(pPackedCategory, pPacked).define('#', pUnpacked)
                .pattern("###").pattern("###").pattern("###")
                .unlockedBy(getHasName(pUnpacked), has(pUnpacked)).save(pRecipeOutput);
    }
}
