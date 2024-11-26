package org.alvarub.utils;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

public class SlashCommandListener extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        switch (event.getName()) {
            case "say" -> {
                String content = event.getOption("content", OptionMapping::getAsString);
                event.reply(content).queue();
            }
            case "aurisdevirgo" -> {
                event.reply("juanceto01 vos sabes que vas a ser el primer baneado?, aaahi esta, te cayo primero el ban. Te voy a contar una cosa juanceto, te acabas de ir baneado, basicamente queres que te de la razon?, osea, por cual te fuiste baneado? por ser pelotudo.").queue();
            }
            default -> {
                return;
            }
        }
    }
}