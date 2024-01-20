package telegram.bot.message.sendMes;

import org.telegram.telegrambots.meta.api.methods.updates.GetUpdates;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import telegram.bot.Bot;

import java.util.List;

public class RestoreMes {
    public Message res(Bot bot) throws TelegramApiException {
        GetUpdates getUpdates = new GetUpdates();
        try {
            List<Update> updates = bot.execute(getUpdates);
            for (Update update : updates) {
                Message message = update.getMessage();

            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        return null;
    }
}
