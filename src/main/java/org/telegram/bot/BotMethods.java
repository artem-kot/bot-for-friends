package org.telegram.bot;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.Update;
import java.util.Optional;

public class BotMethods extends TelegramLongPollingBot {

    String token = "5982336290:AAHUBb79PRoRDIgreoW3R9ptJUnqjEf_EG0";

    @Override
    public String getBotUsername() {
        return "@berlin_friends_bot";
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    @SneakyThrows
    public void onUpdateReceived(Update update) {
    }

    @SneakyThrows
    protected void logRequests(Message message) {
        String username = message.getFrom().getUserName();
        String name = message.getFrom().getFirstName() + " " +
                message.getFrom().getLastName();
        if(!username.equalsIgnoreCase("mantis_cat")) {
            execute(
                    SendMessage.builder()
                            .chatId("1441687338")
                            .text("From: " + username + "\nName: " + name + "\n\nText: " + message.getText())
                            .build());
        }
    }

    private String fetchCommand(Message message) {
        Optional<MessageEntity> commandEntity =
                message.getEntities().stream().filter(e -> "bot_command".equals(e.getType())).findFirst();
        if (commandEntity.isPresent()) {
            String command = message.getText().substring(commandEntity.get().getOffset(), commandEntity.get().getLength());
            return command;
        } else {
            handleMessage(message);
        }
        return null;
    }

    @SneakyThrows
    protected void handleMessage(Message message, CommonMethods api) {
        String command = fetchCommand(message);
        if (command.equals("/iaramer")){
            execute(
                    SendMessage.builder()
                            .chatId(message.getChatId().toString())
                            .text(api.getMaleCompliment())
                            .build());
        } else if (command.equals("/cherechniachip")) {
            execute(
                    SendMessage.builder()
                            .chatId(message.getChatId().toString())
                            .text(api.getFemaleCompliment())
                            .build());
        }
    }

    @SneakyThrows
    protected void handleMessage(Message message){
        execute(
                SendMessage.builder()
                        .chatId(message.getChatId().toString())
                        .text("Этот бот умеет только готовить комплименты. Попробуй одну из команд.\n/iaramer\n/cherechniachip")
                        .build());
    }
}
