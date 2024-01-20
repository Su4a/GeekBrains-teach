package telegram.bot.interfaces.inlineInterface.marketplace.main;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import telegram.bot.interfaces.function.InlineMarkup;
import telegram.bot.interfaces.inlineInterface.InlineMenu;
import telegram.marketplace.statement.Statement;

import java.util.ArrayList;
import java.util.List;

public class InlineMarketplace extends InlineMenu {
    public final String nameMenu;
    public final String codeMenu;
    ArrayList<Statement> statements;

    public InlineMarketplace(String nameMenu, String codeName, ArrayList<Statement> statements) {
        this.nameMenu = nameMenu;
        this.codeMenu = codeName;
        this.statements = statements;
        outputMessage.setText(nameMenu);
        outputMessage.setReplyMarkup(setMenu());
    }

    private InlineKeyboardMarkup setMenu() {
        List<Statement> tempStatement = statements.stream()
                .filter(e -> e.getStatementCountry().equals(splitString(codeMenu, '.')[2]))
                .filter(e -> e.getStatementType().equals(splitString(codeMenu, '.')[3]))
                .filter(e -> e.getStatementName().equals(splitString(codeMenu, '.')[4]))
                .toList();
        outputMessage.setText(outputMessage.getText() + " " + tempStatement.getFirst().getStatementName());
        InlineMarkup inlineMarkup = new InlineMarkup()
                .addButton("Купить отдельно", "buy")
                .addButton("Добавить в комплект", "add").setLine()
                .addButton("Назад", "back").setLine().setMarkup();
        return inlineMarkup.getInlineKeyboardMarkup();
    }
}
