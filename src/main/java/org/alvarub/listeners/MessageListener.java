package org.alvarub.listeners;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) {
            return;
        }

        String message = event.getMessage().getContentRaw().toLowerCase();
        String username = event.getAuthor().getName();

        if (message.equals("hola")) {
            event.getChannel().sendMessage("Ciao " + username + ", il mio pezzo di vergine preferito").queue();
        }

        if (message.equals("momo se ve trabado")) {
            event.getChannel().sendMessage("Los que ponen que se ve trabado " +
                    "¿Ustedes se piensan que yo no me doy cuenta que se ve trabado? " +
                    "Porque tengo la calidad acá, me aparecen los kilobytes ¿Entendés? " +
                    "Me aparecen los kilobytes, yo sé cuándo se ve trabado, entonces no pongas se ve trabado, " +
                    "si sabes que estoy con un celular entre edificios y está lloviendo desde hoy, " +
                    "no pongas se ve trabado, eh, porque lo que tenés trabado es acá, tenés trabado un paty en la cabeza").queue();
        }
    }
}
