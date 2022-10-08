/*
 * File updated ~ 8 - 10 - 2022 ~ Leaf
 */

package leaf.cosmere.hemalurgy;

import leaf.cosmere.api.Constants;
import leaf.cosmere.api.Metals;
import leaf.cosmere.api.providers.IItemProvider;
import leaf.cosmere.api.text.StringHelper;
import leaf.cosmere.hemalurgy.common.Hemalurgy;
import leaf.cosmere.hemalurgy.common.itemgroups.HemalurgyItemGroups;
import leaf.cosmere.hemalurgy.common.items.HemalurgicSpikeItem;
import leaf.cosmere.hemalurgy.common.registries.HemalurgyItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.LanguageProvider;

import static leaf.cosmere.api.Constants.Strings.CONTAINED_POWERS_FOUND;

public class HemalurgyEngLangGen extends LanguageProvider
{
	public HemalurgyEngLangGen(DataGenerator gen)
	{
		super(gen, Hemalurgy.MODID, "en_us");
	}

	@Override
	protected void addTranslations()
	{
		addItemsAndBlocks();
		addEntities();
		addAdvancements();
		addManifestations();
		addAttributes();
		addPatchouli();
		addTooltips();
		addItemGroups();
		addDamageSources();
		addMobEffects();
		addCurioIdentifiers();
		addConfigs();
		addCommands();
		addKeybindings();
		addStats();

	}


	private void addItemsAndBlocks()
	{
		//Items and Blocks
		for (IItemProvider itemRegistryObject : HemalurgyItems.ITEMS.getAllItems())
		{
			final Item item = itemRegistryObject.asItem();
			final ResourceLocation registryName = itemRegistryObject.getRegistryName();
			if (registryName.getNamespace().contentEquals(Hemalurgy.MODID))
			{
				String localisedString = StringHelper.fixCapitalisation(registryName.getPath());

				if (item instanceof HemalurgicSpikeItem)
				{
					String use = ((HemalurgicSpikeItem) item).getMetalType().getShortHemalurgicUseString();
					add("item.hemalurgy." + registryName.getPath() + ".tooltip", use);
				}

				add(item.getDescriptionId(), localisedString);
			}
		}
	}

	private void addEntities()
	{

	}

	private void addAdvancements()
	{

	}

	private void addManifestations()
	{
	}

	private void addAttributes()
	{
	}

	private void addPatchouli()
	{
		//work through each metal and generate localisation for related things.
		for (Metals.MetalType metalType : Metals.MetalType.values())
		{
			final String name = metalType.getName();
			String hKey = "hemalurgic_" + name;
			String hemalurgyGuide = "entry." + hKey;
			add(hemalurgyGuide, StringHelper.fixCapitalisation(name));
		}
	}

	private void addTooltips()
	{
		add("tooltip.cosmere.attribute.iron", "%s%s Attack Damage");
		add("tooltip.cosmere.attribute.tin", "%s%s%% Better Night Vision");
		add("tooltip.cosmere.attribute.copper", "%s%s%% XP");
		add("tooltip.cosmere.attribute.zinc", "%s%s%% Emotional Fortitude");
		add("tooltip.cosmere.attribute.duralumin", "");//todo hemalurgic connection/identity
		add("tooltip.cosmere.attribute.chromium", "%s%s Luck");
		add("tooltip.cosmere.attribute.nicrosil", "");//todo hemalurgic investiture

		add(CONTAINED_POWERS_FOUND, "Hemalurgic Charge:");
	}

	private void addItemGroups()
	{
		//ItemGroups/Tabs
		add("itemGroup." + HemalurgyItemGroups.HEMALURGIC_SPIKES.getRecipeFolderName(), "Hemalurgic Spikes");
	}

	private void addDamageSources()
	{
		//Damage Sources
		add("death.attack.spiked", "%1$s was not careful with their hemalurgic spike");
		add("death.attack.spiked.player", "%1$s was not careful with their hemalurgic spike while fighting %2$s");
	}

	private void addMobEffects()
	{
	}

	private void addCurioIdentifiers()
	{
		add("curios.identifier.feet", "Feet");
		add("curios.identifier.legs", "Legs");
		add("curios.identifier.linchpin", "Linchpin Spike");
	}

	private void addConfigs()
	{
	}

	private void addCommands()
	{
		add(Constants.Strings.SET_EYE_HEIGHT_SUCCESS, "Set eye height to %s");
	}

	private void addKeybindings()
	{
	}

	private void addStats()
	{
	}
}