package telegram.bot.interfaces.inlineInterface.menu.main.profile.setting;

import telegram.bot.interfaces.function.InlineMarkup;
import telegram.bot.interfaces.inlineInterface.InlineMenu;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import telegram.bot.interfaces.inlineInterface.menu.main.profile.setting.language.LanguageInlineMenu;

public class SettingInlineMenu extends InlineMenu {
    public static final String nameMenu = "Настройки";
    public static final String codeMenu = "setting.inline.menu";

    public SettingInlineMenu() {
        outputMessage.setText(nameMenu);
        outputMessage.setReplyMarkup(setMenu());
    }

    private InlineKeyboardMarkup setMenu() {
        InlineMarkup inlineMarkup = new InlineMarkup()
                .addButton(LanguageInlineMenu.nameMenu, LanguageInlineMenu.codeMenu).setLine()
                .addButton("Назад", "back").setLine()
                .setMarkup();
        return inlineMarkup.getInlineKeyboardMarkup();
    }
}
