package telegram.bot.interfaces.inlineInterface.menu.main;

import org.telegram.telegrambots.meta.api.objects.Message;
import telegram.bot.interfaces.function.InlineMarkup;
import telegram.bot.interfaces.inlineInterface.InlineMenu;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import telegram.bot.interfaces.inlineInterface.menu.main.document.DocumentInlineMenu;
import telegram.bot.interfaces.inlineInterface.menu.main.statement.StatementInlineMenu;
import telegram.bot.interfaces.inlineInterface.menu.main.profile.ProfileInlineMenu;

public class MainInlineMenu extends InlineMenu {
    public static final String nameMenu = "Меню";
    public static final String botMenu = "/menu";
    public static final String codeMenu = "main.inline.menu";

    public MainInlineMenu() {
        outputMessage.setText(nameMenu);
        outputMessage.setReplyMarkup(setMenu());
    }

    private InlineKeyboardMarkup setMenu() {
        InlineMarkup inlineMarkup = new InlineMarkup()
                .addButton(DocumentInlineMenu.nameMenu, DocumentInlineMenu.codeMenu).setLine()
                .addButton(StatementInlineMenu.nameMenu, StatementInlineMenu.codeMenu).setLine()
                .addButton(ProfileInlineMenu.nameMenu, ProfileInlineMenu.codeMenu).setLine()
                .setMarkup();
        return inlineMarkup.getInlineKeyboardMarkup();
    }
}
