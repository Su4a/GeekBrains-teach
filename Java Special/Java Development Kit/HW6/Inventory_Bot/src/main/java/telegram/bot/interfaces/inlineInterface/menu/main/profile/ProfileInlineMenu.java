package telegram.bot.interfaces.inlineInterface.menu.main.profile;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import telegram.bot.interfaces.function.InlineMarkup;
import telegram.bot.interfaces.inlineInterface.InlineMenu;
import telegram.bot.interfaces.inlineInterface.menu.main.profile.setting.SettingInlineMenu;
import telegram.bot.message.VisualMes;

public class ProfileInlineMenu extends InlineMenu {
    public static final String nameMenu = "Профиль";
    public static final String codeMenu = "profile.inline.menu";
    VisualMes visualMes = new VisualMes();

    public ProfileInlineMenu() {
        outputMessage.setText(visualMes.bold(nameMenu) + "\n‾‾‾‾‾‾‾‾‾\n\n" + "Телеграм ИД: \n \nБаланс: \n");
        outputMessage.setReplyMarkup(setMenu());
    }

    private InlineKeyboardMarkup setMenu() {
        InlineMarkup inlineMarkup = new InlineMarkup()
                .addButton(SettingInlineMenu.nameMenu, SettingInlineMenu.codeMenu).setLine()
                .addButton("Назад", "back").setLine().setMarkup();
        return inlineMarkup.getInlineKeyboardMarkup();
    }
}
