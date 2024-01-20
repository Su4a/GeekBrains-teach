package telegram.bot;

import database.postgres.Postgres;
import org.telegram.telegrambots.meta.api.objects.Message;
import telegram.bot.user.TelegramUser;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import telegram.marketplace.Marketplace;

import java.util.HashMap;

public class Bot extends TelegramLongPollingBot {
    final private String BOT_TOKEN =;
    final private String BOT_NAME =;
    final private HashMap<Long, TelegramUser> telegramUsers = new HashMap<>();
    final private Marketplace marketplace = new Marketplace();
    final private CommandDistributor commandDistributor = new CommandDistributor();

    public Bot() throws TelegramApiException {
        new BotCommandMenu(this); //Установка команд для бота
        new Postgres().checkConnection(); //Проверка на установленное подключение к базе данных
    }

    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        TelegramUser user = TelegramUser.getUser(update, telegramUsers);
        user.setLastUpdate(update);
        try {
            commandDistributor.setDistributorMessage(this, user);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }
}