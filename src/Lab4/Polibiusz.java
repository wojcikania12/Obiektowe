package Lab4;
import java.lang.*;

public class Polibiusz implements Algorithm{
    private static char polybius[][] = {
            {'A','B','C','D','E'},
            {'F','G','H','I','K'},
            {'L','M','N','O','P'},
            {'Q','R','S','T','U'},
            {'V','W','X','Y','Z'}};

    @Override
    public String crypt(String str){
        String crypted = "";
        char temp;
        for(int i = 0; i < str.length(); i++){
            temp = Character.toUpperCase(str.charAt(i));
            if(temp == 'J'){
                crypted += "24";
                continue;
            }

            for(int j = 1; j < 6; j++){
                for(int k = 1; k < 6; k++){
                    if(temp == polybius[j-1][k-1]) {
                        crypted += (Integer.toString(j * 10 + k));
                    }
                }
            }
        }
        return crypted;
    }


    @Override
    public String decrypt(String str){
        String decrypted = "";
        int x,y;
        for(int i = 0; i < str.length(); i+=2){
            x =Character.getNumericValue(str.charAt(i)- 1)  ;
            y =Character.getNumericValue(str.charAt(i+1) - 1) ;
            decrypted += (polybius[x][y]);}
        return decrypted;
    }

}
