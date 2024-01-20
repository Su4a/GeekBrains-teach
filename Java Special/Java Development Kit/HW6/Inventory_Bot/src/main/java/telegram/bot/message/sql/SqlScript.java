package telegram.bot.message.sql;

import database.postgres.Postgres;

import java.sql.SQLException;

public class SqlScript {

    public void addUser(String telegramId, String userName, String userFirstName, String userLastName, String language) throws SQLException {
        Postgres postgres = new Postgres();
        String[] sqlOperators = {telegramId, userName, userFirstName, userLastName, language};
        String sqlScript = "" +
                "INSERT INTO UserTelegram (telegramId, userName, firstName, lastName, language)" +
                "VALUES (?, ?, ?, ?, ?)";
        try {
            postgres.sendQuery(sqlScript, sqlOperators);
        } finally {
            postgres.connectionClose();
        }
    }

    public void addLastMessage(String telegramId, String chatNumber, String messageNumber) throws SQLException {
        Postgres postgres = new Postgres();
        String[] sqlOperators = {telegramId, chatNumber, messageNumber};
        String sqlScript = "" +
                "INSERT INTO LastMessages (telegramId, chatNumber, messageNumber) " +
                "VALUES (?, ?, ?)";
        try {
            postgres.sendQuery(sqlScript, sqlOperators);
        } finally {
            postgres.connectionClose();
        }
    }

    public void updateLastMessage(String telegramId, String chatNumber, String messageNumber) throws SQLException {
        Postgres postgres = new Postgres();
        String[] sqlOperators = {chatNumber, messageNumber, telegramId};
        String sqlScript = "" +
                "UPDATE LastMessages SET chatNumber = ?, messageNumber = ? " +
                "WHERE telegramId = ?";
        try {
            postgres.sendQuery(sqlScript, sqlOperators);
        } finally {
            postgres.connectionClose();
        }
    }


    //Сохранения команд для себя
    public void createUserTable() throws SQLException {
        Postgres postgres = new Postgres();
        postgres.sendQuery("CREATE TABLE IF NOT EXISTS UserTelegram (\n" +
                "telegramId VARCHAR(255) PRIMARY KEY,\n" +
                "userName VARCHAR(255),\n" +
                "firstName VARCHAR(255),\n" +
                "lastName VARCHAR(255),\n" +
                "language VARCHAR(255)\n" +
                ");");
        postgres.connectionClose();
    }

    //Сохранения команд для себя
    public void createLastMessageTable() throws SQLException {
        Postgres postgres = new Postgres();
        postgres.sendQuery("CREATE TABLE IF NOT EXISTS LastMessages (\n" +
                "telegramId VARCHAR(255) NOT NULL,\n" +
                "chatNumber VARCHAR(255) NOT NULL,\n" +
                "messageNumber VARCHAR(255) NOT NULL,\n" +
                "FOREIGN KEY (telegramId) REFERENCES UserTelegram(telegramId) ON DELETE CASCADE,\n" +
                "CONSTRAINT unique_telegramId UNIQUE (telegramId)\n" +
                ");");
        postgres.connectionClose();
    }
}
