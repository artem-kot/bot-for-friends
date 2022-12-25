package org.telegram.bot;

import lombok.SneakyThrows;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class ComplimentsBot extends BotMethods {

    CommonMethods api = new CommonMethods();

    @Override
    @SneakyThrows
    public void onUpdateReceived(Update update) {
        logRequests(update.getMessage());
        if(update.hasMessage()){
            handleMessage(update.getMessage(), api);
        }
    }

    @SneakyThrows
    public static void main(String[] args) {
        ComplimentsBot bot = new ComplimentsBot();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(bot);
    }
}
