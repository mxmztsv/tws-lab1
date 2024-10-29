package ru.mxmztsv.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum Key {
    FIRST_NAME(Command.SEARCH, "-fn", "--first-name", "-fn, --first-name\t\t->\tДобавление поля поиска по имени"),
    LAST_NAME(Command.SEARCH, "-ln", "--last-name", "-ln, --last-name\t\t->\tДобавление поля поиска по фамилии"),
    STATUS(Command.SEARCH, "-st", "--status", "-st, --status\t\t->\tДобавление поля поиска по статусу"),
    CATEGORY(Command.SEARCH, "-cat", "--category", "-cat, --category\t\t->\tДобавление поля поиска по категории"),
    DATE(Command.SEARCH, "-d", "--date", "-d, --date        \t\t->\tДобавление поля поиска по дате");

    private final Command command;
    private final String key;
    private final String fullKey;
    private final String description;

    public static Key findKey(String key) {
        return Arrays.stream(Key.values()).filter(k -> k.key.equals(key) || k.getFullKey().equals(key))
                .findFirst().orElse(null);
    }
}
