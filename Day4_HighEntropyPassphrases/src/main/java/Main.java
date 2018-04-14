public class Main {

    public static void main(String args[]){
        var passphraseValidator = new PassphraseValidator();
        long result = passphraseValidator.getNumberOfValidPassphrases("inputFile");
        System.out.println(result);
    }
}
