/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.quarkus.myfaces.showcase.view;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@ViewScoped
@Named
public class SocketView implements Serializable {
    
    private static final Logger LOG = Logger.getLogger(SocketView.class.getName());
    
    @Inject
    @Push
    PushContext helloChannel;
    
    String message;
    
    public void sendMessage() {
        LOG.log(Level.INFO, "send push message");
        this.sendPushMessage("hello");
    }
    
    private void sendPushMessage(Object message) {
        helloChannel.send("" + message + " at " + LocalDateTime.now());
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public void sendMessage2() {
        LOG.log(Level.INFO, "send push message from input box::" + this.message);
        this.sendPushMessage(this.message);
    }
    
}
