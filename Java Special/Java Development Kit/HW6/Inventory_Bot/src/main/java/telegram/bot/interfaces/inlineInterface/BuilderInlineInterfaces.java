package telegram.bot.interfaces.inlineInterface;

import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import telegram.bot.Bot;
import telegram.bot.interfaces.inlineInterface.menu.main.MainInlineMenu;
import telegram.bot.interfaces.inlineInterface.menu.main.document.DocumentInlineMenu;
import telegram.bot.interfaces.inlineInterface.menu.main.profile.ProfileInlineMenu;
import telegram.bot.interfaces.inlineInterface.menu.main.profile.setting.SettingInlineMenu;
import telegram.bot.interfaces.inlineInterface.menu.main.profile.setting.language.LanguageInlineMenu;
import telegram.bot.message.MessReplace;
import telegram.bot.user.TelegramUser;

public class BuilderInlineInterfaces {
    Bot bot;
    TelegramUser user;

    public BuilderInlineInterfaces(Bot bot, TelegramUser user, String... string) {
        this.bot = bot;
        this.user = user;
    }

    //Установка кнопок, на которые можно нажать
    public void build(String mes) throws TelegramApiException {
        if (mes.equals("/menu")) {
            if (user.getLastUpdate().hasCallbackQuery()) new MainInlineMenu().sendMenu(bot, user, MessReplace.UPDATE);
            else new MainInlineMenu().sendMenu(bot, user, MessReplace.REPLACE);
        }
        if (mes.equals(MainInlineMenu.codeMenu)) new MainInlineMenu().sendMenu(bot, user, MessReplace.UPDATE);
        if (mes.equals(DocumentInlineMenu.codeMenu)) new DocumentInlineMenu().sendMenu(bot, user, MessReplace.UPDATE);
        //if (mes.equals(StatementInlineMenu.codeMenu)) new StatementInlineMenu().getInlineMarketplaceCountry().sendMenu(bot, user, MessReplace.UPDATE);
        if (mes.equals(ProfileInlineMenu.codeMenu)) new ProfileInlineMenu().sendMenu(bot, user, MessReplace.UPDATE);
        if (mes.equals(SettingInlineMenu.codeMenu)) new SettingInlineMenu().sendMenu(bot, user, MessReplace.UPDATE);
        if (mes.equals(LanguageInlineMenu.codeMenu)) new LanguageInlineMenu().sendMenu(bot, user, MessReplace.UPDATE);
    }
}
