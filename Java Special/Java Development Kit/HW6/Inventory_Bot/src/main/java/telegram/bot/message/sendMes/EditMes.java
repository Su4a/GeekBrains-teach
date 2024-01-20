package telegram.bot.message.sendMes;

import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageCaption;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageLiveLocation;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageMedia;
import org.telegram.telegrambots.meta.api.objects.media.InputMediaPhoto;
import telegram.bot.Bot;
import telegram.bot.message.OutputMessage;
import telegram.bot.user.TelegramUser;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class EditMes {
    public EditMes(Bot bot, TelegramUser user, OutputMessage newMes, Message oldMes) throws TelegramApiException {
        editMessage(bot, user, newMes, oldMes);
    }

    private void editMessage(Bot bot, TelegramUser user, OutputMessage newMes, Message oldMes) throws TelegramApiException {
        if (newMes.hasPhoto()) {
            InputMediaPhoto inputMediaPhoto = new InputMediaPhoto();
            inputMediaPhoto.setMedia(newMes.getPhoto());
            inputMediaPhoto.setCaption(newMes.getCaption());

            EditMessageMedia editMessageMedia = new EditMessageMedia();
            editMessageMedia.setChatId(oldMes.getChatId());
            editMessageMedia.setMessageId(oldMes.getMessageId());
            editMessageMedia.setMedia(inputMediaPhoto);
            editMessageMedia.setReplyMarkup(newMes.getReplyMarkup());
            user.setLastBotMessage((Message) bot.execute(editMessageMedia));
        }

        else if (newMes.hasText() || newMes.hasReplyMarkup()) {
            EditMessageText editMessageText = new EditMessageText();
            editMessageText.setChatId(oldMes.getChatId());
            editMessageText.setMessageId(oldMes.getMessageId());
            editMessageText.setText(newMes.getText());
            editMessageText.setReplyMarkup(newMes.getReplyMarkup());
            editMessageText.setParseMode(ParseMode.MARKDOWN);
            user.setLastBotMessage((Message) bot.execute(editMessageText));
        }

        EditMessageLiveLocation editMessageLiveLocation = new EditMessageLiveLocation();
    }
}