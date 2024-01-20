package telegram.bot.message;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public class OutputMessage {
    private String text;
    private String caption;
    private String photo;
    private String document;
    private InlineKeyboardMarkup replyMarkup;


    public void setText(String text) {
        this.text = text;
    }
    public String getText() {
        return text;
    }
    public boolean hasText() {
        return text != null;
    }

    public void setReplyMarkup(InlineKeyboardMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
    }
    public InlineKeyboardMarkup getReplyMarkup() {
        return replyMarkup;
    }
    public boolean hasReplyMarkup() {
        return replyMarkup != null;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
    public String getCaption() {
        return caption;
    }
    public boolean hasCaption() {
        return caption != null;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public String getPhoto() {
        return photo;
    }
    public boolean hasPhoto() {
        return photo != null;
    }

    public String getDocument() {
        return document;
    }
    public void setDocument(String document) {
        this.document = document;
    }
    public boolean hasDocument() {
        return document != null;
    }





}
