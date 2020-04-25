package com.assignment2.wasteless.Presentation.Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class NotificationObserver implements PropertyChangeListener {
    private String expirationMessage;

    public NotificationObserver() {
    }

    public NotificationObserver(String expirationMessage) {
        this.expirationMessage = expirationMessage;
    }

    public void propertyChange(PropertyChangeEvent evt) {
        this.setExpirationMessage((String) evt.getNewValue());
    }

    private void setExpirationMessage(String newValue) {
        this.expirationMessage = newValue;
    }

    public String getExpirationMessage() {
        return expirationMessage;
    }
}
