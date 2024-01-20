package telegram.bot.interfaces.inlineInterface.marketplace;

import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import telegram.bot.Bot;
import telegram.bot.interfaces.Interface;
import telegram.bot.interfaces.inlineInterface.marketplace.main.InlineMarketplace;
import telegram.bot.interfaces.inlineInterface.marketplace.main.InlineMarketplaceProduct;
import telegram.bot.interfaces.inlineInterface.marketplace.main.InlineMarketplaceCountry;
import telegram.bot.interfaces.inlineInterface.marketplace.main.InlineMarketplaceType;
import telegram.bot.interfaces.inlineInterface.menu.main.document.DocumentInlineMenu;
import telegram.bot.interfaces.inlineInterface.menu.main.statement.StatementInlineMenu;
import telegram.bot.message.MessReplace;
import telegram.bot.message.sendMes.DelMes;
import telegram.bot.user.TelegramUser;
import telegram.marketplace.Marketplace;
import telegram.marketplace.statement.Statement;

import java.util.ArrayList;

public class InlineMarketplaceInterface extends Interface {
    private final ArrayList<String> inlineMarketplace = new ArrayList<>();
    private final ArrayList<Statement> statements = Marketplace.getStatements();

    public InlineMarketplaceInterface() {
        setInlineMarketplace();
    }

    public void setInterface(Bot bot, TelegramUser user, String message) throws TelegramApiException {
        Update update = user.getLastUpdate();
        String[] splitMessage = splitString(message, '.');
        if (update.hasMessage() && update.getMessage().hasText() && update.getMessage().isUserMessage()) {
            new DelMes(bot, update.getMessage());
        } else if (update.hasCallbackQuery()) {
            if (splitMessage[1].equals(StatementInlineMenu.name)) {
                if (splitMessage.length == 2) {
                    user.addNavigationMenu(message);
                    new InlineMarketplaceCountry("Выберите страну выписки", message, statements).sendMenu(bot, user, MessReplace.UPDATE);
                }
                if (splitMessage.length == 3) {
                    user.addNavigationMenu(message);
                    new InlineMarketplaceType("Выберите тип выписки", message, statements).sendMenu(bot, user, MessReplace.UPDATE);
                }
                if (splitMessage.length == 4) {
                    user.addNavigationMenu(message);
                    new InlineMarketplaceProduct("Выписки", message, statements).sendMenu(bot, user, MessReplace.UPDATE);
                }
                if (splitMessage.length == 5) {
                    user.addNavigationMenu(message);
                    new InlineMarketplace("Образец", message, statements).sendMenu(bot, user, MessReplace.UPDATE);
                }
            } else if (splitMessage[1].equals(DocumentInlineMenu.name)) {
                //Будущие функции по документам
            } else if (splitMessage[1].equals("Аккаунты")) {
                //Будущие функции по аккаунтам
            }
        }
    }

    public boolean isMesInterface(String message) {
        String firstCall = splitString(message, '.')[0];
        for (String i : inlineMarketplace) if (i.contentEquals(firstCall)) return true;
        return false;
    }

    private void setInlineMarketplace() {
        inlineMarketplace.add("market");
    }
}
