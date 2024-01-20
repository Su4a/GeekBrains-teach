package telegram.bot.interfaces.inlineInterface;

import telegram.bot.Bot;
import telegram.bot.interfaces.Interface;
import telegram.bot.message.Mess;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import telegram.bot.message.OutputMessage;
import telegram.bot.user.TelegramUser;

public abstract class InlineMenu extends Interface {
    protected OutputMessage outputMessage = new OutputMessage();
    protected TelegramUser user;

    public InlineMenu sendMenu(Bot bot, TelegramUser user, Enum replace) throws TelegramApiException {
        new Mess(bot, user, outputMessage, replace);
        this.user = user;
        return this;
    }
}