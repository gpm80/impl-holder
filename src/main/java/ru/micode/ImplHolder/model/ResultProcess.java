package ru.micode.ImplHolder.model;

/**
 * Модель ответа.
 */
public class ResultProcess {

    private String implId;
    private String message;

    public String getImplId() {
        return implId;
    }

    public void setImplId(String implId) {
        this.implId = implId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
