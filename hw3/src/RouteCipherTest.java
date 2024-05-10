public class RouteCipherTest {
    public static void main(String[] args) {
        RouteCipher cipher = new RouteCipher(-5);
        String plaintext = "ABORTTHEMISSIONYOUHAVEBEENSPOTTED";
        String ciphertext = cipher.encrypt(plaintext);
        System.out.println("Encrypted text: " + ciphertext);

        String decryptedText = cipher.decrypt(ciphertext);
        System.out.println("Decrypted text: " + decryptedText);
    }
}
