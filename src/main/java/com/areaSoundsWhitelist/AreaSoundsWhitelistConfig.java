package com.areaSoundsWhitelist;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("whitelist")
public interface AreaSoundsWhitelistConfig extends Config
{
	@ConfigItem(
		keyName = "whitelist",
		name = "Area Sound Whitelist",
		description = "Comma separated list of sound ids to be unmuted"
	)
	default String whitelist()
	{
		return "";
	}

	@ConfigItem(
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
