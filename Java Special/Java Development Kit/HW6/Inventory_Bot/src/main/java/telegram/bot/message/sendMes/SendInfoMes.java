package telegram.bot.message.sendMes;

import org.telegram.telegrambots.meta.api.methods.ParseMode;
import telegram.bot.Bot;
import telegram.bot.message.OutputMessage;
import telegram.bot.user.TelegramUser;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SendInfoMes {
    public SendInfoMes(Bot bot, TelegramUser user, OutputMessage outputMessage) throws TelegramApiException {
        sendMessage(bot, user, outputMessage);
    }

    private void sendMessage(Bot bot, TelegramUser user, OutputMessage outputMessage) throws TelegramApiException {
        Long chatId;
        if (user.getLastUpdate().hasMessage()) chatId = user.getLastUpdate().getMessage().getChatId();
        else chatId = user.getLastUpdate().getCallbackQuery().getMessage().getChatId();

        SendMessage sendMessage = new SendMessage();
        if (outputMessage.hasText() || outputMessage.hasReplyMarkup()) {
            sendMessage.setChatId(chatId);
            sendMessage.setText(outputMessage.getText());
            sendMessage.setReplyMarkup(outputMessage.getReplyMarkup());
            sendMessage.setParseMode(ParseMode.MARKDOWN);
        }
        bot.execute(sendMessage);
    }
}
