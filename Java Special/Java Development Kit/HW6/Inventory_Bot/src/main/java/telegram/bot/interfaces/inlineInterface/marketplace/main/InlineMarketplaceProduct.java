package telegram.bot.interfaces.inlineInterface.marketplace.main;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import telegram.bot.interfaces.function.InlineMarkup;
import telegram.bot.interfaces.inlineInterface.InlineMenu;
import telegram.marketplace.statement.Statement;

import java.util.ArrayList;
import java.util.List;

public class InlineMarketplaceProduct extends InlineMenu {
    public final String nameMenu;
    public final String codeMenu;
    ArrayList<Statement> statements;

    public InlineMarketplaceProduct(String nameMenu, String codeName, ArrayList<Statement> statements) {
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
                .toList();
        InlineMarkup inlineMarkup = new InlineMarkup();
        for (Statement i : tempStatement) inlineMarkup.addButton(i.getStatementName(), codeMenu + "." + i.getStatementName()).setLine();
        inlineMarkup.addButton("Назад", "back").setLine().setMarkup();
        return inlineMarkup.getInlineKeyboardMarkup();
    }
}
