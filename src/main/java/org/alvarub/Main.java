package org.alvarub;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.alvarub.commands.AurisDeVirgo;
import org.alvarub.commands.Say;
import org.alvarub.listeners.MessageListener;
import org.alvarub.listeners.SlashCommandListener;

public class Main {
    public static void main(String[] args) {

        // Carga el token desde el archivo .env
        Dotenv dotenv = Dotenv.load();
        String token = dotenv.get("DISCORD_BOT_TOKEN");
        if (token == null || token.isEmpty()) {
            throw new IllegalArgumentException("Token is not set in the environment variables");
        }

        JDA jda = JDABuilder.createDefault(token)
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .setActivity(Activity.listening("ME LLAMA - MOMO (Beret)").withState("Temazo"))
                .build();

        // Crear instancia de SlashCommandListener y agregar comandos
        SlashCommandListener commandListener = new SlashCommandListener();
        commandListener.add(new Say());
        commandListener.add(new AurisDeVirgo());

        // Agregar listeners al JDA
        jda.addEventListener(commandListener, new MessageListener());
    }
}