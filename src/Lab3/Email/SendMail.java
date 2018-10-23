package Lab3.Email;
import java.util.LinkedList;

public class SendMail {
    public static void main(String[] args){
        LinkedList<String> temp = new LinkedList<String>();
        temp.add("zenek682@op.pl");
        temp.add("sosenkiewicz.marta@gmail.com");
        temp.add("wojcikania12@wp.pl");

        EmailMessage message = new EmailMessage.Builder("wojcikania12@wp.pl",temp).subject("Ungabunga").content("Ble").build();
        message.send();
    }
}
