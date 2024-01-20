package telegram.bot.message.sendMes;

import telegram.bot.Bot;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class DelMes {
    public DelMes(Bot bot, Message message) {
        deleteMessage(bot, message);
    }

    private void deleteMessage(Bot bot, Message message) {
        DeleteMessage del = new DeleteMessage();
        del.setChatId(message.getChatId());
        del.setMessageId(message.getMessageId());
        try {
            bot.execute(del);
        } catch (TelegramApiException e) {
            System.out.println("Сообщение не получилось удалить т.к. оно было удалено пользователем");
        }
    }
}
