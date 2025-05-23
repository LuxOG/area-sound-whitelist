package com.areaSoundsWhitelist;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup("whitelist")
public interface AreaSoundsWhitelistConfig extends Config
{
	// ToB section =====================================================================================================
	@ConfigSection(
		position = 0,
		name = "Theatre of Blood",
		description = "ToB area sounds to whitelist"
	)
	String tobSection = "Theatre of Blood";

	@ConfigItem(
		position = 0,
		keyName = "maidenBlood",
		name = "Maiden",
		description = "Whitelists the area sounds for Maiden's targeted blood attack",
		section = tobSection
	)
	default boolean whitelistMaidenBlood()
	{
		return false;
	}

	@ConfigItem(
		position = 1,
		keyName = "bloatLimbs",
		name = "Bloat",
		description = "Whitelists the area sounds for falling limbs at Bloat",
		section = tobSection
	)
	default boolean whitelistBloatLimbs()
	{
		return false;
	}

	@ConfigItem(
		position = 2,
		keyName = "sotetsegAuto",
		name = "Sotetseg Basic Attacks",
		description = "Whitelists the area sounds for Sotetseg's basic attacks",
		section = tobSection
	)
	default boolean whitelistSotetsegAutos()
	{
		return false;
	}

	@ConfigItem(
		position = 3,
		keyName = "sotetsegDeathBall",
		name = "Sotetseg Death Ball",
		description = "Whitelists the area sounds for Sotetseg's death ball",
		section = tobSection
	)
	default boolean whitelistSotetsegDeathBall()
	{
		return false;
	}

	@ConfigItem(
		position = 4,
		keyName = "xarpusSpit",
		name = "Xarpus",
		description = "Whitelists the area sounds for Xarpus' spit",
		section = tobSection
	)
	default boolean whitelistXarpusSpit()
	{
		return false;
	}

	@ConfigItem(
		position = 5,
		keyName = "verzikP2Auto",
		name = "Verzik P2",
		description = "Whitelists the area sounds for Verzik's basic attacks during P2",
		section = tobSection
	)
	default boolean whitelistVerzikP2Autos()
	{
		return false;
	}

	@ConfigItem(
		position = 6,
		keyName = "verzikP3Auto",
		name = "Verzik P3",
		description = "Whitelists the area sounds for Verzik's basic attacks during P3",
		section = tobSection
	)
	default boolean whitelistVerzikP3Autos()
	{
		return false;
	}

	@ConfigItem(
		position = 7,
		keyName = "verzikYellows",
		name = "Verzik Yellows",
		description = "Whitelists the area sounds for Verzik's yellow pools",
		section = tobSection
	)
	default boolean whitelistVerzikYellows()
	{
		return false;
	}

	@ConfigSection(
		position = 1,
		name = "Other NPCs",
		description = "ToB area sounds to whitelist"
	)
	String otherNpcSection = "Other NPCs";

	@ConfigItem(
		position = 0,
		keyName = "solHeredit",
		name = "Sol Heredit",
		description = "Whitelists the area sounds for Sol Heredit's attacks",
		section = otherNpcSection
	)
	default boolean whitelistSolHereditAttacks()
	{
		return false;
	}

	@ConfigItem(
		position = 1,
		keyName = "yama",
		name = "Yama",
		description = "Whitelists the area sounds for Yama",
		section = otherNpcSection
	)
	default boolean whitelistYama()
	{
		return false;
	}

	// Items section ===================================================================================================
	@ConfigSection(
		position = 2,
		name = "Items",
		description = "Item area sounds to whitelist"
	)
	String itemSection = "Items";

	@ConfigItem(
		position = 0,
		keyName = "burningClaws",
		name = "Burning claws",
		description = "Whitelists the area sound for the Burning claws special attack",
		section = itemSection
	)
	default boolean whitelistBurningClaws()
	{
		return false;
	}

	@ConfigItem(
		position = 1,
		keyName = "dragonClaws",
		name = "Dragon claws",
		description = "Whitelists the area sounds for the Dragon claws special attack",
		section = itemSection
	)
	default boolean whitelistDragonClaws()
	{
		return false;
	}

	// No section ======================================================================================================
	@ConfigItem(
		position = 3,
		keyName = "whitelist",
		name = "Area Sound Whitelist",
		description = "Comma separated list of sound ids to be unmuted"
	)
	default String whitelist()
	{
		return "";
	}

	@ConfigItem(
		position = 4,
		keyName = "muteAmbient",
		name = "Mute Ambient Sounds",
		description = "Mutes all ambient sounds upon loading into a map. These cannot be whitelisted. " +
			"Requires re-entering the area to take effect."
	)
	default boolean muteAmbient()
	{
		return true;
	}
}
