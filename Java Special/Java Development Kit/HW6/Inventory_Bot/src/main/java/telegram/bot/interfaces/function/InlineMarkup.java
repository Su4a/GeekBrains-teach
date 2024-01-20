package telegram.bot.interfaces.function;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class InlineMarkup {
    private final InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
    private List<InlineKeyboardButton> buttons = new ArrayList<>();
    private List<List<InlineKeyboardButton>> markup = new ArrayList<>();

    public InlineMarkup addButton(String textButton, String codeButton) {
        InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
        inlineKeyboardButton.setText(textButton);
        inlineKeyboardButton.setCallbackData(codeButton);
        buttons.add(inlineKeyboardButton);
        return this;
    }

    public InlineMarkup sortedButton() {
        buttons = buttons.stream().sorted(Comparator.comparing(InlineKeyboardButton::getText)).toList();
        return this;
    }

    public InlineMarkup setLine() {
        markup.add(buttons);
        buttons = new ArrayList<>();
        return this;
    }

    public InlineMarkup setVerticalLine(int countInLine) {
        int count = 0;
        List<InlineKeyboardButton> lines = new ArrayList<>();
        for (int i = 0; i < buttons.size() - 1; i++) {
            if (countInLine == count) {
                markup.add(lines);
                lines = new ArrayList<>();
                count = 0;
            } else {
                lines.add(buttons.get(i));
            }
            count++;
        }
        buttons = new ArrayList<>();
        return this;
    }

    public InlineMarkup setMarkup() {
        inlineKeyboardMarkup.setKeyboard(markup);
        return this;
    }

    public InlineKeyboardMarkup getInlineKeyboardMarkup() {
        return inlineKeyboardMarkup;
    }
}
