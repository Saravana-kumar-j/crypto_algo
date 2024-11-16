import java.security.*;
import java.util.Base64;
import javax.crypto.KeyAgreement;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;

public class DiffieHellman {
    public static void main(String[] args) {
        try {
            KeyPairGenerator aliceKeyPairGenerator = KeyPairGenerator.getInstance("DH");
            aliceKeyPairGenerator.initialize(2048); 
            KeyPair aliceKeyPair = aliceKeyPairGenerator.generateKeyPair();
        
            DHParameterSpec dhParams = ((DHPublicKey) aliceKeyPair.getPublic()).getParams();
            
            KeyPairGenerator bobKeyPairGenerator = KeyPairGenerator.getInstance("DH");
            bobKeyPairGenerator.initialize(dhParams);
            KeyPair bobKeyPair = bobKeyPairGenerator.generateKeyPair();

            KeyAgreement aliceKeyAgreement = KeyAgreement.getInstance("DH");
            aliceKeyAgreement.init(aliceKeyPair.getPrivate());

            KeyAgreement bobKeyAgreement = KeyAgreement.getInstance("DH");
            bobKeyAgreement.init(bobKeyPair.getPrivate());

            aliceKeyAgreement.doPhase(bobKeyPair.getPublic(), true);
            bobKeyAgreement.doPhase(aliceKeyPair.getPublic(), true);

            byte[] aliceSharedSecret = aliceKeyAgreement.generateSecret();
            byte[] bobSharedSecret = bobKeyAgreement.generateSecret();

            String aliceSharedSecretBase64 = Base64.getEncoder().encodeToString(aliceSharedSecret);
            String bobSharedSecretBase64 = Base64.getEncoder().encodeToString(bobSharedSecret);

            System.out.println("Alice's Shared Secret: " + aliceSharedSecretBase64+"\n");
            System.out.println("Bob's Shared Secret: " + bobSharedSecretBase64+"\n");

            if (aliceSharedSecretBase64.equals(bobSharedSecretBase64)) {
                System.out.println("Shared secret successfully established!");
            } else {
                System.out.println("Shared secrets do not match.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
