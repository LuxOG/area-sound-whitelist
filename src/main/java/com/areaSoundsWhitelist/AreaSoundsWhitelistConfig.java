package com.areaSoundsWhitelist;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup("whitelist")
public interface AreaSoundsWhitelistConfig extends Config
{
	@ConfigSection(
		name = "NPCs",
		description = "NPC area sounds to whitelist",
		position = 0
	)
	String npcSection = "NPCs";

	@ConfigItem(
		keyName = "sotetsegDeathBall",
		name = "Sotetseg",
		description = "Whitelists the area sounds for Sotetseg's death ball",
		section = npcSection
	)
	default boolean whitelistSotetsegDeathBall()
	{
		return false;
	}

	@ConfigItem(
		keyName = "xarpusSpit",
		name = "Xarpus",
		description = "Whitelists the area sounds for Xarpus' spit",
		section = npcSection
	)
	default boolean whitelistXarpusSpit()
	{
		return false;
	}

	@ConfigItem(
		keyName = "solHeredit",
		name = "Sol Heredit",
		description = "Whitelists the area sounds for Sol Heredit's attacks",
		section = npcSection
	)
	default boolean whitelistSolHereditAttacks()
	{
		return false;
	}

	@ConfigSection(
		name = "Items",
		description = "Item area sounds to whitelist",
		position = 1
	)
	String itemSection = "Items";

	@ConfigItem(
		keyName = "dragonClaws",
		name = "Dragon claws",
		description = "Whitelists the area sounds for the Dragon claws special attack",
		section = itemSection
	)
	default boolean whitelistDragonClaws()
	{
		return false;
	}

	@ConfigSection(
		name = "General",
		description = "General sounds to whitelist",
		position = 2
	)
	String generalSection = "General";

	@ConfigItem(
		keyName = "whitelist",
		name = "Area Sound Whitelist",
		description = "Comma separated list of sound ids to be unmuted",
		section = generalSection
	)
	default String whitelist()
	{
		return "";
	}

	@ConfigItem(
		keyName = "muteAmbient",
		name = "Mute Ambient Sounds",
		description = "Mutes all ambient sounds upon loading into a map. These cannot be whitelisted. " +
			"Requires re-entering the area to take effect.",
		section = generalSection
	)
	default boolean muteAmbient()
	{
		return true;
	}

}
