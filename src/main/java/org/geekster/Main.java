package org.geekster;

import javax.mail.MessagingException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws MessagingException {
        System.out.println("Starting to send out Mail");

        MailHandler mailHandler = new MailHandler();
        mailHandler.sendMail();

    }
}