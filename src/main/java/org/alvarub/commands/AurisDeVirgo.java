package org.alvarub.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.util.List;
import java.util.Objects;

public class AurisDeVirgo implements ICommand {


    @Override
    public String getName() {
        return "aurisdevirgo";
    }

    @Override
    public String getDescription() {
        return "Sends a custom message to the user";
    }

    @Override
    public List<OptionData> getOptions() {
        return null;
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        String displayName = Objects.requireNonNull(event.getMember()).getEffectiveName();
        event.reply(displayName + " vos sabes que vas a ser el primer baneado?, aaahi esta, te cayo primero el ban. Te voy a contar una cosa " + displayName + ", te acabas de ir baneado, basicamente queres que te de la razon?, osea, por cual te fuiste baneado? por ser pelotudo.").queue();
    }
}
