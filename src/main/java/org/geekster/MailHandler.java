package org.geekster;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailHandler {

    void sendMail() throws MessagingException {
        Properties sysProperties = System.getProperties();//this gives me a hash map/hash-table

        System.out.println(sysProperties);
        sysProperties.put("mail.smtp.host", MailMetaData.HostServer);
        sysProperties.put("mail.smtp.port", MailMetaData.port);
        sysProperties.put(MailMetaData.sslProperty, "true");
        sysProperties.put(MailMetaData.authPerm, "true");

        //create a session using sender -email and password

        Authenticator MailAuthenticator = new customizedMailAuthentication();
        Session mailSession = Session.getInstance(sysProperties, MailAuthenticator);

        //mime message build
        try {
            MimeMessage mailMessage = new MimeMessage(mailSession);

            mailMessage.setFrom(MailMetaData.myUserMail);
            mailMessage.setSubject("This is my java code testing");
            mailMessage.setText("Hey this is Ashish who is trying to send mail using java");

            //set the receiver

            Address receiverEmail = new InternetAddress(MailMetaData.receiverMail);
            mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(MailMetaData.receiverMail));

            Transport.send(mailMessage);
        } catch (Exception mailException) {
            System.out.println(mailException.toString());
        }
    }
    }
