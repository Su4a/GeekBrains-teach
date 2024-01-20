package telegram.bot;


import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import telegram.bot.interfaces.inlineInterface.marketplace.InlineMarketplaceInterface;
import telegram.bot.interfaces.inlineInterface.menu.InlineMenuInterface;
import telegram.bot.user.TelegramUser;

public class CommandDistributor {
    private final InlineMenuInterface inlineMenuInterface = new InlineMenuInterface();
    //private final InlinePayInterface inlinePayInterface = new InlinePayInterface();
    private final InlineMarketplaceInterface inlineMarketplaceInterface= new InlineMarketplaceInterface();

    public void setDistributorMessage(Bot bot, TelegramUser user) throws TelegramApiException {
        //Получение последнего текстового сообщения от пользователя
        String message = user.getTextMessage(user.getLastUpdate());

        //Замена обратного вызова на предыдущее сообщение
        if (message.equals("back")) message = user.getPreLastNavigationMenu();

        //Вызов интерфейса меню, если сообщение соответствует вызову интерфейса интерфейсу
        if (inlineMenuInterface.isMesInterface(message)) inlineMenuInterface.setInterface(bot, user, message);
        //Вызов интерфейса маркетплейса
        else if (inlineMarketplaceInterface.isMesInterface(message)) inlineMarketplaceInterface.setInterface(bot,user, message);
        //Вызов интерфейса покупки
        //else if (inlinePayInterface.isMesInterface(message)) inlinePayInterface.setInterface(bot, user, message);
        //for (String i : user.getNavigationMenu()) System.out.print(i + " : ");
        //System.out.println(message);
    }
}