package org.alvarub.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.util.Collections;
import java.util.List;

public class Say implements ICommand{

    @Override
    public String getName() {
        return "say";
    }

    @Override
    public String getDescription() {
        return "Repeats the content provided";
    }

    @Override
    public List<OptionData> getOptions() {
        return Collections.singletonList(new OptionData(OptionType.STRING, "content", "The content to repeat", true));
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        String content = event.getOption("content", OptionMapping::getAsString);
        event.reply(content).queue();
    }
}
