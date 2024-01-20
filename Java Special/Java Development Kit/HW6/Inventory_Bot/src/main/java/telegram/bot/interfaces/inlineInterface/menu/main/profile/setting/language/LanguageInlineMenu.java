package telegram.bot.interfaces.inlineInterface.menu.main.profile.setting.language;

import telegram.bot.interfaces.function.InlineMarkup;
import telegram.bot.interfaces.inlineInterface.InlineMenu;
import telegram.bot.message.VisualMes;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public class LanguageInlineMenu extends InlineMenu {
    private final VisualMes visual = new VisualMes();
    public static final String nameMenu = "Язык";
    public static final String codeMenu = "language.inline.menu";

    public LanguageInlineMenu() {
        outputMessage.setText(nameMenu);
        outputMessage.setReplyMarkup(setMenu());
    }

    private InlineKeyboardMarkup setMenu() {
        InlineMarkup inlineMarkup = new InlineMarkup()
                .addButton("Русский  " + visual.emoji(":ru:"), "rus")
                .addButton("Английский  " + visual.emoji(":us:"), "eng").setLine()
                .addButton("Назад", "back").setLine()
                .setMarkup();
        return inlineMarkup.getInlineKeyboardMarkup();
    }
}
