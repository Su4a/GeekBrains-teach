package telegram.bot.message.sendMes;

import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.polls.SendPoll;
import org.telegram.telegrambots.meta.api.methods.send.*;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.polls.PollOption;
import telegram.bot.Bot;
import telegram.bot.message.OutputMessage;
import telegram.bot.user.TelegramUser;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;

public class SendMes {
    public SendMes(Bot bot, TelegramUser user, OutputMessage outputMessage) throws TelegramApiException {
        sendMessage(bot, user, outputMessage);
    }

    private void sendMessage(Bot bot, TelegramUser user, OutputMessage outputMessage) throws TelegramApiException {
        Long chatId;
        if (user.getLastUpdate().hasMessage()) chatId = user.getLastUpdate().getMessage().getChatId();
        else chatId = user.getLastUpdate().getCallbackQuery().getMessage().getChatId();

//        if (outputMessage.hasDocument()) {
//            SendDocument sendDocument = new SendDocument();
//            sendDocument.setChatId(chatId);
//            sendDocument.setCaption(outputMessage.getText());
//            sendDocument.setDocument(new InputFile(new File(String.valueOf(outputMessage.getDocument()))));
//            sendDocument.setReplyMarkup(outputMessage.getReplyMarkup());
//            sendDocument.setParseMode(ParseMode.MARKDOWN);
//            user.setLastBotMessage(bot.execute(sendDocument));
//        }

//        else if (outputMessage.hasPhoto()) {
//            SendPhoto sendPhoto = new SendPhoto();
//            sendPhoto.setChatId(chatId);
//            sendPhoto.setCaption(outputMessage.getText());
//            sendPhoto.setPhoto(new InputFile(new File(outputMessage.getPhoto())));
//            sendPhoto.setReplyMarkup(outputMessage.getReplyMarkup());
//            sendPhoto.setParseMode(ParseMode.MARKDOWN);
//            user.setLastBotMessage(bot.execute(sendPhoto));
//        }

//        else if (outputMessage.hasVideo()) {
//            SendVideo sendVideo = new SendVideo();
//            sendVideo.setChatId(chatId);
//            sendVideo.setCaption(outputMessage.getText());
//            //sendVideo.setVideo(new InputFile(new File()));
//            sendVideo.setReplyMarkup(outputMessage.getReplyMarkup());
//            sendVideo.setParseMode(ParseMode.MARKDOWN);
//            user.setLastBotMessage(bot.execute(sendVideo));
//        }

//        else if (outputMessage.hasAudio()) {
//            SendAudio sendAudio = new SendAudio();
//            sendAudio.setChatId(chatId);
//            sendAudio.setCaption(outputMessage.getText());
//            //sendAudio.setAudio(new InputFile(new File()));
//            sendAudio.setReplyMarkup(outputMessage.getReplyMarkup());
//            sendAudio.setParseMode(ParseMode.MARKDOWN);
//            user.setLastBotMessage(bot.execute(sendAudio));
//        }

//        else if (outputMessage.hasVoice()) {
//            SendVoice sendVoice = new SendVoice();
//            sendVoice.setChatId(chatId);
//            sendVoice.setCaption(outputMessage.getText());
//            //sendVoice.setVoice(new InputFile(new File()));
//            sendVoice.setReplyMarkup(outputMessage.getReplyMarkup());
//            sendVoice.setParseMode(ParseMode.MARKDOWN);
//            user.setLastBotMessage(bot.execute(sendVoice));
//        }

//        else if (outputMessage.hasAnimation()) {
//            SendAnimation sendAnimation = new SendAnimation();
//            sendAnimation.setChatId(chatId);
//            sendAnimation.setCaption(outputMessage.getText());
//            //sendAnimation.setAnimation(new InputFile(new File()));
//            sendAnimation.setReplyMarkup(outputMessage.getReplyMarkup());
//            sendAnimation.setParseMode(ParseMode.MARKDOWN);
//            user.setLastBotMessage(bot.execute(sendAnimation));
//        }

//        else if (outputMessage.hasSticker()) {
//            SendSticker sendSticker = new SendSticker();
//            sendSticker.setChatId(chatId);
//            //sendSticker.setSticker();
//            //sendSticker.setEmoji();
//            sendSticker.setReplyMarkup(outputMessage.getReplyMarkup());
//            user.setLastBotMessage(bot.execute(sendSticker));
//        }

//        else if (outputMessage.hasLocation()) {
//            //SendLocation sendLocation = new SendLocation();
//            SendVenue sendVenue = new SendVenue();
//            sendVenue.setChatId(chatId);
//            sendVenue.setLatitude(outputMessage.getLocation().getLatitude());
//            sendVenue.setLongitude(outputMessage.getLocation().getLongitude());
//            sendVenue.setAddress("TestLocaton");
//            sendVenue.setTitle("TestLocaton");
//            sendVenue.setReplyMarkup(outputMessage.getReplyMarkup());
//            user.setLastBotMessage(bot.execute(sendVenue));
//        }

        //SendMediaGroup sendMediaGroup = new SendMediaGroup();

//        else if (outputMessage.hasContact()) {
//            SendContact sendContact = new SendContact();
//            sendContact.setChatId(chatId);
//            sendContact.setFirstName(outputMessage.getContact().getFirstName());
//            sendContact.setLastName(outputMessage.getContact().getLastName());
//            sendContact.setPhoneNumber(outputMessage.getContact().getPhoneNumber());
//            sendContact.setVCard(outputMessage.getContact().getVCard());
//            sendContact.setReplyMarkup(outputMessage.getReplyMarkup());
//            user.setLastBotMessage(bot.execute(sendContact));
//        }

//        else if (outputMessage.hasPoll()) {
//            SendPoll sendPoll = new SendPoll();
//            sendPoll.setChatId(chatId);
//            sendPoll.setQuestion(outputMessage.getPoll().getQuestion());
//            sendPoll.setOptions(outputMessage.getPoll().getOptions().stream().map(PollOption::getText).toList());
//            sendPoll.setIsAnonymous(outputMessage.getPoll().getIsAnonymous());
//            sendPoll.setType(outputMessage.getPoll().getType());
//            sendPoll.setAllowMultipleAnswers(outputMessage.getPoll().getAllowMultipleAnswers());
//            sendPoll.setCorrectOptionId(outputMessage.getPoll().getCorrectOptionId());
//            sendPoll.setReplyMarkup(outputMessage.getReplyMarkup());
//            user.setLastBotMessage(bot.execute(sendPoll));
//        }

//        else if (outputMessage.hasDice()) {
//            SendDice sendDice = new SendDice();
//            sendDice.setChatId(chatId);
//            sendDice.setEmoji(outputMessage.getDice().getEmoji());
//            sendDice.setReplyMarkup(outputMessage.getReplyMarkup());
//            user.setLastBotMessage(bot.execute(sendDice));
//        }

        if (outputMessage.hasText() || outputMessage.hasReplyMarkup()) {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(chatId);
            sendMessage.setText(outputMessage.getText());
            sendMessage.setReplyMarkup(outputMessage.getReplyMarkup());
            sendMessage.setParseMode(ParseMode.MARKDOWN);
            user.setLastBotMessage(bot.execute(sendMessage));
        }

        //SendInvoice sendInvoice = new SendInvoice();
        //SendGame sendGame = new SendGame();
        //SendChatAction sendChatAction = new SendChatAction();
    }
}
