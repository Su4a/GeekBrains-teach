package telegram.bot.message.sendMes;

import org.telegram.telegrambots.meta.api.objects.Message;
import telegram.bot.Bot;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import telegram.bot.message.OutputMessage;

public class SendNotifyMes {
    AnswerCallbackQuery answer;

    public SendNotifyMes(Bot bot, CallbackQuery callbackQuery, OutputMessage outputMessage) throws TelegramApiException {
        answer = new AnswerCallbackQuery();
        answer.setCallbackQueryId(callbackQuery.getId());
        answer.setText(outputMessage.getText());
        bot.execute(answer);
    }
}
