package telegram.bot.interfaces.inlineInterface.menu.main.hello;

import telegram.bot.interfaces.inlineInterface.InlineMenu;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class HelloInlineMenu extends InlineMenu {
    private final String nameMenu = "Вас приветствует Инвентори бот" +
            "Это лучший многофункциональный бот для сознания Документов , билов , и просто продажи аккаунтов  , мы рады что вы решили воспользоваться именно нашим ботом ,приятного пользования";

    public HelloInlineMenu() {
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
