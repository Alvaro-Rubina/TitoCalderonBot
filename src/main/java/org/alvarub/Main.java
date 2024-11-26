package org.alvarub;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;
import org.alvarub.listeners.MessageListener;
import org.alvarub.listeners.SlashCommandListener;

import static net.dv8tion.jda.api.interactions.commands.OptionType.STRING;

public class Main {
    public static void main(String[] args) {

        // Carga el token desde el archivo .env
        Dotenv dotenv = Dotenv.load();
        String token = dotenv.get("DISCORD_BOT_TOKEN");
        if (token == null || token.isEmpty()) {
            throw new IllegalArgumentException("Token is not set in the environment variables");
        }

        JDA jda = JDABuilder.createDefault(token)
                .enableIntents(GatewayIntent.MESSAGE_CONTENT) // Enable the MESSAGE_CONTENT intent
                .addEventListeners(new SlashCommandListener(), new MessageListener())
                .setActivity(Activity.listening("ME LLAMA - MOMO (Beret)").withState("Temazo"))
                .build();

        // Registrar comandos
        CommandListUpdateAction commands = jda.updateCommands();

        commands.addCommands(
                Commands.slash("say", "Makes the bot say what you tell it to")
                        .addOption(STRING, "content", "What the bot should say", true), // Accepting a user input

                Commands.slash("aurisdevirgo", "Hace que el momo se enoje")
        );

        // Then finally send your commands to discord using the API
        commands.queue();
    }
}