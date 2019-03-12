package com.w15104.dataengine.study.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @author b13692
 * @time 9/19/17
 */
public class AESencrp {
	private static String ALGO = "AES";
	private static String ALGO_MODE = "AES/CBC/NoPadding";
	private static String akey = "qjhasddsdaa2.0";
	private static String aiv = "asdfdgfddssad.0";

	/**
	 * 功能描述：用来进行加密操作
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(String data) throws Exception {
		try {
			Cipher cipher = Cipher.getInstance(ALGO_MODE);
			int blockSize = cipher.getBlockSize();
			byte[] dataBytes = data.getBytes();
			int plaintextLength = dataBytes.length;
			if (plaintextLength % blockSize != 0) {
				plaintextLength = plaintextLength + (blockSize - plaintextLength % blockSize);
			}
			byte[] plaintext = new byte[plaintextLength];
			System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);
	
			SecretKeySpec keyspec = new SecretKeySpec(akey.getBytes("utf-8"), ALGO);
			IvParameterSpec ivspec = new IvParameterSpec(aiv.getBytes("utf-8"));
			cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
			byte[] encrypted = cipher.doFinal(plaintext);
			return new BASE64Encoder().encode(encrypted);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	* 功能描述：用来进行解密操作
	* @param encryptedData
	* @return
	* @throws Exception
	*/
	public static String decrypt(String encryptedData) throws Exception {
		try {
		byte[] encrypted = new BASE64Decoder().decodeBuffer(encryptedData);
			Cipher cipher = Cipher.getInstance(ALGO_MODE);
			SecretKeySpec keyspec = new SecretKeySpec(akey.getBytes("utf-8"), ALGO);
			IvParameterSpec ivspec = new IvParameterSpec(aiv.getBytes("utf-8"));

			cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
			byte[] original = cipher.doFinal(encrypted);
			return new String(original);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}