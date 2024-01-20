package telegram.bot.interfaces.inlineInterface.menu;

import telegram.bot.Bot;
import telegram.bot.interfaces.Interface;
import telegram.bot.interfaces.inlineInterface.BuilderInlineInterfaces;
import telegram.bot.interfaces.inlineInterface.menu.main.MainInlineMenu;
import telegram.bot.interfaces.inlineInterface.menu.main.document.DocumentInlineMenu;
import telegram.bot.interfaces.inlineInterface.menu.main.hello.HelloInlineMenu;
import telegram.bot.interfaces.inlineInterface.menu.main.hello.ReplyHelloInlineMenu;
import telegram.bot.interfaces.inlineInterface.menu.main.profile.ProfileInlineMenu;
import telegram.bot.interfaces.inlineInterface.menu.main.profile.setting.SettingInlineMenu;
import telegram.bot.interfaces.inlineInterface.menu.main.profile.setting.language.LanguageInlineMenu;
import telegram.bot.message.MessReplace;
import telegram.bot.message.sendMes.DelMes;
import telegram.bot.message.sql.SqlScript;
import telegram.bot.user.TelegramUser;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;

public class InlineMenuInterface extends Interface {
    private final ArrayList<String> inlineMenu = new ArrayList<>();

    public InlineMenuInterface() {
        setInlineMenu();
    }

    public void setInterface(Bot bot, TelegramUser user, String message) throws TelegramApiException {
        Update update = user.getLastUpdate();
        if (update.hasMessage() && update.getMessage().hasText() && update.getMessage().isUserMessage()) {
            new DelMes(bot, update.getMessage());
            if (message.equals("/start")) {
                String telegramId = update.getMessage().getFrom().getId().toString();
                String userName = update.getMessage().getFrom().getUserName();
                String firstName = update.getMessage().getFrom().getFirstName();
                String lastName = update.getMessage().getFrom().getLastName();
                String language = update.getMessage().getFrom().getLanguageCode();
                try {
                    new SqlScript().addUser(telegramId, userName, firstName, lastName, language);
                    new HelloInlineMenu().sendMenu(bot, user, MessReplace.REPLACE);
                } catch (Exception e) {
                    new ReplyHelloInlineMenu().sendMenu(bot, user, MessReplace.REPLACE);
                }
            } else {
                if (message.equals("/menu")) user.getNavigationMenu().clear();
                user.addNavigationMenu(message);
                new BuilderInlineInterfaces(bot, user).build(message);
            }
        } else if (update.hasCallbackQuery()) {
            user.addNavigationMenu(message);
            new BuilderInlineInterfaces(bot, user).build(message);
        }
    }

    public boolean isMesInterface(String mes) {
        for (String i : inlineMenu) {
            if (i.equals(mes)) return  true;
        }
        return false;
    }

    private void setInlineMenu() {
        inlineMenu.add("/start");
        inlineMenu.add("/menu");
        inlineMenu.add(MainInlineMenu.codeMenu);
        inlineMenu.add(DocumentInlineMenu.codeMenu);
        //inlineMenu.add(StatementInlineMenu.codeMenu);
        inlineMenu.add(ProfileInlineMenu.codeMenu);
        inlineMenu.add(SettingInlineMenu.codeMenu);
        inlineMenu.add(LanguageInlineMenu.codeMenu);
    }
}
