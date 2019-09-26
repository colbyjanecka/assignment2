package assignment2;

public class Code {

    public char [] charArray = new char[3];

    public Code(){
    }

    public Code(String c){

        charArray = c.toCharArray();
    }

    public String codeAsString(){
        String s = new String(charArray);
        return(s);
    }

    public void getRandomCode(){
        charArray = "VGRY".toCharArray();
        //charArray = SecretCodeGenerator.getInstance().getNewSecretCode().toCharArray();
    }

}
