package Lab4;
public class ROT11 implements Algorithm{
    private static final int shift = 11;

    @Override
    public String crypt(String str){
        String crypted = "";
        for(int i = 0; i < str.length(); i++){
            char temp = str.charAt(i);
            if(temp >= 'a' && temp <='z'){
                if(temp > 'z' - shift) crypted += (char)(temp+shift -26);
                else crypted += (char)(temp + shift);
            }
            else if(temp >= 'A' && temp <='Z'){
                if(temp > 'Z' - shift) crypted += (char)(temp+shift -26);
                else crypted += (char)(temp + shift);
            }
        }
        return crypted;
    }

    @Override
    public String decrypt(String str){
        String decrypted = "";
        for(int i = 0; i < str.length(); i++){
            char temp = str.charAt(i);
            if(temp >= 'a' && temp <='z'){
                if(temp - shift >= 'a') decrypted += (char)(temp-shift);
                else decrypted += (char)(temp - shift + 26);
            }
            else if(temp >= 'A' && temp <='Z'){
                if(temp - shift >= 'A') decrypted += (char)(temp-shift);
                else decrypted += (char)(temp - shift + 26);
            }
        }
        return decrypted;
    }

}
