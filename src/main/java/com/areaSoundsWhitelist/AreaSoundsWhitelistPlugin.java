package com.areaSoundsWhitelist;

import com.google.inject.Provides;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.AreaSoundEffectPlayed;
import net.runelite.client.callback.ClientThread;


import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.Text;

@Slf4j
@PluginDescriptor(
	name = "Area Sounds Whitelist"
)
public class AreaSoundsWhitelistPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private AreaSoundsWhitelistConfig config;

	private Set<Integer> soundsToWhitelist;

	@Override
	protected void startUp() throws Exception
	{
		setupWhitelist();
	}

	@Override
	public void shutDown()
	{
		soundsToWhitelist.clear();
	}

	@Subscribe(priority = -2) // priority -2 to run after music plugin
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		GameState gameState = gameStateChanged.getGameState();

		// on map load mute ambient sounds
		if (gameState == GameState.LOGGED_IN)
		{
			if (config.muteAmbient()) {
				client.getAmbientSoundEffects().clear();
			}
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged configChanged) {
		setupWhitelist();
	}

	@Subscribe
	public void onAreaSoundEffectPlayed(AreaSoundEffectPlayed areaSoundEffectPlayed) {
		int soundId = areaSoundEffectPlayed.getSoundId();
		if (!soundsToWhitelist.contains(soundId)) {
			areaSoundEffectPlayed.consume();
		}
	}

	@Provides
	AreaSoundsWhitelistConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(AreaSoundsWhitelistConfig.class);
	}

	private void setupWhitelist() {
		List<String> ids = Text.fromCSV(config.whitelist());
		soundsToWhitelist = ids.stream()
			.map(Integer::parseInt)
			.collect(Collectors.toCollection(HashSet::new));

		// Add NPC area sounds
		if (config.whitelistSotetsegDeathBall())
		{
			soundsToWhitelist.add(AreaSoundEffectID.SOTETSEG_DEATH_BALL);
		}

		if (config.whitelistXarpusSpit())
		{
			soundsToWhitelist.add(AreaSoundEffectID.XARPUS_SPIT);
		}

		if (config.whitelistSolHereditAttacks())
		{
			for (int sid : AreaSoundEffectID.SOL_HEREDIT_ATTACKS)
			{
				soundsToWhitelist.add(sid);
			}
		}

		// Add item area sounds
		if (config.whitelistDragonClaws())
		{
			for (int sid : AreaSoundEffectID.DRAGON_CLAWS_SPEC)
			{
				soundsToWhitelist.add(sid);
			}
		}
	}
}
