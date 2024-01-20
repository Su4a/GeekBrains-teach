package telegram.bot.message;

import telegram.bot.Bot;
import telegram.bot.message.sendMes.*;
import telegram.bot.user.TelegramUser;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Mess {
    private final String NEW = "NEW";
    private final String REPLACE = "REPLACE";
    private final String UPDATE = "UPDATE";
    private final String INFO = "INFO";
    private final String NOTIFY = "NOTIFY";
    private final Bot bot;
    private final TelegramUser user;

    public Mess(Bot bot, TelegramUser user, OutputMessage outputMessage, Enum replace) throws TelegramApiException {
        this.bot = bot;
        this.user = user;
        if (replace.toString().equals(NEW)) sendNewMes(outputMessage);
        if (replace.toString().equals(REPLACE)) sendReplaceMes(outputMessage);
        if (replace.toString().equals(UPDATE)) editMes(outputMessage);
        if (replace.toString().equals(INFO)) sendInfoMesMes(outputMessage);
        if (replace.toString().equals(NOTIFY)) sendNotifyMes(outputMessage);
    }

    private void sendNewMes(OutputMessage outputMessage) {
        try {
            new SendMes(bot, user, outputMessage);
        } catch (TelegramApiException e) {
            System.err.println("Произошла ошибка отправки сообщения");
        }
    }

    private void sendReplaceMes(OutputMessage outputMessage) {
        try {
            if (user.getLastBotMessage() != null) new DelMes(bot, user.getLastBotMessage());
            new SendMes(bot, user, outputMessage);
        } catch (TelegramApiException e) {
            System.err.println("Произошла ошибка переотправки сообщения");
        }
    }

    private void editMes(OutputMessage outputMessage) {
        try {
            new EditMes(bot, user, outputMessage, user.getLastUpdate().getCallbackQuery().getMessage());
        } catch (TelegramApiException e) {
            System.err.println("Произошла попытка изменения сообщения, но сообщение не было изменено т.к. совпадает с предыдущим");
        }
    }

    private void sendInfoMesMes(OutputMessage outputMessage) {
        try {
            new SendInfoMes(bot, user, outputMessage);
        } catch (TelegramApiException e) {
            System.err.println("Произошла ошибка отправки информативного сообщения");
        }
    }

    private void sendNotifyMes(OutputMessage outputMessage) {
        try {
            new SendNotifyMes(bot, user.getLastUpdate().getCallbackQuery(), outputMessage);
        } catch (TelegramApiException e) {
            System.err.println("Произошла ошибка отправки уведомленного сообщения");
        }
    }
}