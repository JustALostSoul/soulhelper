package soulback.soulhelper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ClientModInitializer;

public class SoulHelperClient implements ClientModInitializer {

	public static Logger LOGGER = LoggerFactory.getLogger("SoulHelper");

	//Tags to Search for in first Element of Messages
	public static final String[] SEARCH_TAGS = {"Bazaar"};

	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
	}
}