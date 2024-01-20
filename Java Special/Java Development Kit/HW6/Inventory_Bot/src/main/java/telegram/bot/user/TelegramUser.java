package telegram.bot.user;

import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import telegram.bot.interfaces.inlineInterface.InlineMenu;

import java.util.ArrayList;
import java.util.HashMap;

public class TelegramUser {
    private final ArrayList<String> navigationMenu = new ArrayList<>();
    private Update lastUpdate;
    private Message lastBotMessage;

    public void setLastUpdate(Update update) {
        lastUpdate = update;
    }

    public Update getLastUpdate() {
        return lastUpdate;
    }

    public void setLastBotMessage(Message message) {
        lastBotMessage = message;
    }

    public Message getLastBotMessage() {
        return lastBotMessage;
    }

    public void addNavigationMenu(String inlineMenu) {
        if (navigationMenu.isEmpty()) {
            navigationMenu.add(inlineMenu);
        } else if (!navigationMenu.get(navigationMenu.size() - 1).equals(inlineMenu)) {
            navigationMenu.add(inlineMenu);
        }
    }

    public String getPreLastNavigationMenu() {
        navigationMenu.remove(navigationMenu.size() - 1);
        return navigationMenu.get(navigationMenu.size() - 1);
    }

    public String getLastNavigationMenu() {
        return navigationMenu.get(navigationMenu.size() - 1);
    }

    public static TelegramUser getUser(Update update, HashMap<Long, TelegramUser> telegramUsers) {
        if (update.hasMessage()) {
            if (telegramUsers.get(update.getMessage().getFrom().getId()) == null) {
                telegramUsers.put(update.getMessage().getFrom().getId(), new TelegramUser());
            }
            return telegramUsers.get(update.getMessage().getFrom().getId());
        } else {
            if (telegramUsers.get(update.getCallbackQuery().getFrom().getId()) == null) {
                telegramUsers.put(update.getCallbackQuery().getFrom().getId(), new TelegramUser());
            }
            return telegramUsers.get(update.getCallbackQuery().getFrom().getId());
        }
    }

    public String getTextMessage(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) return update.getMessage().getText();
        else return update.getCallbackQuery().getData();
    }

    public ArrayList<String> getNavigationMenu() {
        return navigationMenu;
    }
}
