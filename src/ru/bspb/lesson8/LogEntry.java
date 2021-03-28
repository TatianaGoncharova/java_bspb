package ru.bspb.lesson8;

public class LogEntry {
    private String timestamp;
    private String level;
    private String message;

    public LogEntry (String timestamp,String level,String message) {
        this.timestamp = timestamp;
        this.level = level;
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return '\n' + "LogEntry{" + '\n' +
                "   timestamp=" + timestamp + '\n' +
                "   level=" + level + '\n' +
                "   message=" + message + '\n' +
                '}';
    }
}
