package utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

@SuppressWarnings("restriction")
public class PasswordEncryption {

	public static String encryptXOR(String message, String key) {
		try {
			if (message == null || key == null)
				return null;
			char[] keys = key.toCharArray();
			char[] mesg = message.toCharArray();
			int ml = mesg.length;
			int kl = keys.length;
			char[] newmsg = new char[ml];
			for (int i = 0; i < ml; i++) {
				newmsg[i] = (char) (mesg[i] ^ keys[i % kl]);
			}
			// mesg = null;
			// keys = null;
			return new BASE64Encoder().encodeBuffer(new String(newmsg).getBytes());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String decryptXOR(String message, String key) {
		try {
			if (message == null || key == null)
				return null;
			BASE64Decoder decoder = new BASE64Decoder();
			char[] keys = key.toCharArray();
			char[] mesg = new String(decoder.decodeBuffer(message)).toCharArray();
			int ml = mesg.length;
			int kl = keys.length;
			char[] newmsg = new char[ml];
			for (int i = 0; i < ml; i++) {
				newmsg[i] = (char) (mesg[i] ^ keys[i % kl]);
			}
			// mesg = null;
			// keys = null;
			return new String(newmsg);
		} catch (Exception e) {
			return null;
		}
	}

	/*
	 * public static void main(String[] args) { // TODO Auto-generated method stub
	 * String strToEncode = "Shyam@1166"; String key = "Siri4ever"; //String
	 * strEncryptedString =
	 * "PwcaCjguXV5VXQ==";//PasswordEncryption.encryptXOR(strToEncode, key); String
	 * strEncryptedString = PasswordEncryption.encryptXOR(strToEncode, key);
	 * System.out.println("Encrypted string: " + strEncryptedString); String
	 * decodedPwd = PasswordEncryption.decryptXOR(strEncryptedString, key);
	 * System.out.println("Decrypted string: " + decodedPwd); }
	 */
}