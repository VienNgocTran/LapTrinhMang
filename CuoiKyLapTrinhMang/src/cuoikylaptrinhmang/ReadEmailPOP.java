
package cuoikylaptrinhmang;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;

public class ReadEmailPOP {
    public static void main(String[] args) throws NoSuchProviderException, MessagingException{
        ArrayList<Mail> arrayList = new ArrayList<>();
        ReadEmailPOP emailPOP = new ReadEmailPOP();
        String host = "pop.gmail.com";// change accordingly
        String mailStoreType = "pop3";
        String userName = "ngoxvien2014@gmail.com";// change accordingly
        String passWord = "0986572902ba";// change accordingly

        Properties properties = new Properties();
            properties.put("mail.pop3.host", host);
            properties.put("mail.pop3.port", "995");
            properties.put("mail.pop3.starttls.enable", "true");
        Session session = Session.getInstance(properties,new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, passWord);
            }            
        });
        //create the POP3 store object and connect with the pop server
            Store store = session.getStore("pop3s");

            store.connect(host, userName, passWord);

            //create the folder object and open it
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            // retrieve the messages from the folder in an array and print it
            Message[] messages = emailFolder.getMessages();
            System.out.println("messages.length---" + messages.length);

            for (int i = 0, n = 10; i < n; i++) {
                Message message = messages[i];
                System.out.println("---------------------------------");
                System.out.println("Email Number " + (i + 1));
                //System.out.println("Subject: " + message.getSubject());    
                //System.out.println("Subject: " + message.getSentDate());    
                System.out.println("From: " + message.getFrom()[0]+message.getFrom()[0]); 
                String from = String.valueOf(message.getFrom()[0]);
                System.out.println("Ok  : "+from);
                arrayList.add(new Mail(i+1, message.getSubject(), String.valueOf(message.getFrom()[0]),
                        String.valueOf(message.getSentDate()),emailPOP.getTextFromMessage(message) ));                
            }
            System.out.println("Size : "+arrayList.size());
            //close the store and folder objects
            emailFolder.close(false);
            store.close();
        
    }
    
    
    public String getTextFromMessage(Message message) {
        String result = "";
        try {
            
            if (message.isMimeType("text/plain")) {
                result = message.getContent().toString();
            } else if (message.isMimeType("multipart/*")) {
                MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
                result = getTextFromMimeMultipart(mimeMultipart);
            }
            
        } catch (MessagingException | IOException ex) {
            Logger.getLogger(ReadMail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    private String getTextFromMimeMultipart(MimeMultipart mimeMultipart)  throws MessagingException, IOException{
        String result = "";
        int count = mimeMultipart.getCount();
        for (int i = 0; i < count; i++) {
            BodyPart bodyPart = mimeMultipart.getBodyPart(i);
            if (bodyPart.isMimeType("text/plain")) {
                result = result + "\n" + bodyPart.getContent();
                break; // without break same text appears twice in my tests
            } else if (bodyPart.isMimeType("text/html")) {
                String html = (String) bodyPart.getContent();
                result = result + "\n" + org.jsoup.Jsoup.parse(html).text();
            } else if (bodyPart.getContent() instanceof MimeMultipart){
                result = result + getTextFromMimeMultipart((MimeMultipart)bodyPart.getContent());
            }
        }
        return result;
    }
}
