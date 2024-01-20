package telegram.bot.interfaces.inlineInterface.menu.main.hello;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import telegram.bot.interfaces.inlineInterface.InlineMenu;

import java.util.ArrayList;
import java.util.List;

public class ReplyHelloInlineMenu extends InlineMenu {
    private final String nameMenu = "Повторно приветствую";

    public ReplyHelloInlineMenu() {
        outputMessage.setText(nameMenu);
        outputMessage.setReplyMarkup(setMenu());
    }

    private InlineKeyboardMarkup setMenu() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rows = new ArrayList<>();

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("Начать");
        button1.setCallbackData("hello");
        row1.add(button1);
        rows.add(row1);
        inlineKeyboardMarkup.setKeyboard(rows);
        return inlineKeyboardMarkup;
    }
}
