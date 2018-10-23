package Lab3.Email;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class EmailMessage {

        private final String from;
        private final LinkedList<String> to;
        private final String subject;
        private final String content;
        private final String mimeType;
        private final LinkedList <String>cc;
        private final LinkedList<String> bcc;

        private EmailMessage(Builder builder){
            from = builder.from;
            to = builder.to;
            subject = builder.subject;
            content = builder.content;
            mimeType = builder.mimeType;
            cc = builder.cc;
            bcc = builder.bcc;
    }

    public String getFrom(){
        return from;
    }

    public String getSubject(){
        return subject;
    }

    public String getContent(){
        return content;
    }

    public String getMimeType(){
            return mimeType;
    }

    public LinkedList<String> getBcc() {
        return bcc;
    }

    public LinkedList<String> getCc() {
        return cc;
    }

    public LinkedList<String> getTo() {
        return to;
    }

    public static boolean validateEmail(String email){
        String regex_pattern = "^[\\w._%+-]+@([\\w-]+\\.)+[a-z]{2,}$";
        Pattern r = Pattern.compile(regex_pattern);
        Matcher m = r.matcher(email);
        return  m.matches();
    }

    public void send(){
        final String password;
        System.out.println("Podaj hasło: ");
        Scanner odczyt = new Scanner(System.in);
        password = odczyt.nextLine();


        Properties properties = System.getProperties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.wp.pl");
        properties.put("mail.debug", "true");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");


        Session session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, password);
                    }
                });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            for(String recipent : to) {
                message.addRecipients(Message.RecipientType.TO, recipent);
            }
            message.setSubject(subject);
            message.setText(content);

            Transport.send(message);
            System.out.println("Wysłano.");
        }
        catch (MessagingException e){
            throw new RuntimeException(e);
        }
    }

    public static class Builder{
            private final String from;
            private final LinkedList<String> to ;
            private String subject;
            private String content;
            private String mimeType;
            private LinkedList <String>cc;
            private LinkedList<String> bcc;

            public Builder(String from_, LinkedList<String> to_){
                if(!validateEmail(from_)) throw new IllegalArgumentException("Niepoprawny adres email.");
                for(String recipent : to_){
                    if(!validateEmail(recipent)) throw new IllegalArgumentException("Niepoprawny adres email.");
                }
                from = from_;
                to = to_;
            }

            public Builder subject(String subject_){
            subject = subject_;
            return this;
        }

        public Builder content(String content_){
            content = content_;
            return this;
        }

        public Builder mimeType(String mimeType_){
            mimeType = mimeType_;
            return this;
        }

        public Builder cc(LinkedList <String> cc_){
            cc = cc_;
            return this;
        }

        public Builder bcc(LinkedList <String> bcc_){
            bcc = bcc_;
            return this;
        }

        public EmailMessage build() {
            return new EmailMessage(this);
        }
    }

}

