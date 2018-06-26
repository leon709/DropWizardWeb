package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityUtil {

	public static void main(String[] args) {
		String realPwd = "pi=3.141";
		String saltAndPwd = "STlHaCQXvkvwvfoU" + realPwd;

		String passwordHash = sha2sum(saltAndPwd);
		System.out.println(passwordHash);
		String dbPasswordHash = "eabbcef7f2cef16e8839fefb0dcf43714b1205d88bad6018103fd040b85f110a";

		System.out.println("Password Match: " + passwordHash.equals(dbPasswordHash));
		
		System.out.println(sha2sum("mLFWayPGaUActNIQ"+"leon709"));
	}

	public static String sha2sum(String s) {
		return sha2sum(s.getBytes());
	}

	public static String sha2sum(byte[] bytes) {
		return encodeHex(sha2Digest(bytes));
	}

	public static byte[] sha2Digest(byte[] bytes) {
		try {
			return MessageDigest.getInstance("SHA-256").digest(bytes);
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalStateException("SHA-256 algorithm not found");
		}
	}

	private static String encodeHex(byte[] bytes) {
		StringBuilder sb = new StringBuilder(bytes.length * 2);
		for (byte b : bytes) {
			sb.append(String.format("%02x", b & 0xff));
		}
		return sb.toString();
	}
}
