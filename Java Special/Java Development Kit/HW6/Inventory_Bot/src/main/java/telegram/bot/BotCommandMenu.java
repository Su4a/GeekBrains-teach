package telegram.bot;

import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import telegram.bot.interfaces.inlineInterface.menu.main.MainInlineMenu;

import java.util.ArrayList;
import java.util.List;

public class BotCommandMenu {
    private final List<BotCommand> commands = new ArrayList<>();

    public BotCommandMenu(Bot bot) throws TelegramApiException {
        setCommand();
        bot.execute(new SetMyCommands(commands, new BotCommandScopeDefault(), null));
    }

    private void setCommand() {
        commands.add(new BotCommand("/menu", "Меню"));
    }
}
