package telegram.bot.message;

import com.vdurmont.emoji.EmojiParser;

public class VisualMes {
    public String emoji(String string) {
        return EmojiParser.parseToUnicode(string);
    }


    /**
     * MarkownV2
     */
    public String bold(String string) {
        return "*" + string + "*";
    }
    public String cursive(String string) {
        return "_" + string + "_";
    }
    public String hashTeg(String string) {
        return "#" + string;
    }
}
