package dev.ev1dent.boilerplate;

import dev.ev1dent.boilerplate.events.ReadyEventListener;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class BPMain {
    public static void main(String[] args) {
        final Dotenv config;
        config = Dotenv.configure().load();

        final String BOT_TOKEN = config.get("BOT_TOKEN");
        JDABuilder jdaBuilder = JDABuilder.createDefault(BOT_TOKEN);

        JDA jda = jdaBuilder
                // Start Intents
                .enableIntents(
                        GatewayIntent.GUILD_MESSAGES,
                        GatewayIntent.GUILD_MEMBERS
                )
                // Start add event listeners
                .addEventListeners(
                        new ReadyEventListener()
                )
                .build();
    }
}
