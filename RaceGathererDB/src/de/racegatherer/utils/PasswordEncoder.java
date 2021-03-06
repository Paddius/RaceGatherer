/**
 * File Name : PasswordEncoder.java 
 * Created on: 1 Jul 2010 
 * Created by: Ashish Shukla 
 * Orange Hut Solution Limited. 
 * http://www.orangehut.com
 */


package de.racegatherer.utils;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.log4j.Logger;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @author Ashish Shukla
 * 
 */
public class PasswordEncoder {
    /**
     * Logger for this class
     */
    private static final Logger log = Logger.getLogger(PasswordEncoder.class);

    private static PasswordEncoder instance;
    
    public static String salt = "3dasdasfdasdasASDFASDf32f3qdfaw2";

    /**
     * Count for the number of time to hash, 
     * more you hash more difficult it would be for the attacker 
     */
    private final static int ITERATION_COUNT = 5;

    /**
     * Empty Constructor
     */
    private PasswordEncoder() {
    }

    /**
     * @return
     * @author Ashish Shukla
     */
    public static synchronized PasswordEncoder getInstance() {
	if (log.isDebugEnabled()) {
	    log.debug("getInstance() - start");
	}

	if (instance == null) {
	    PasswordEncoder returnPasswordEncoder = new PasswordEncoder();
	    log.info("New instance created");
	    if (log.isDebugEnabled()) {
		log.debug("getInstance() - end");
	    }
	    return returnPasswordEncoder;
	} else {
	    if (log.isDebugEnabled()) {
		log.debug("getInstance() - end");
	    }
	    return instance;
	}
    }
    
    /**
     * 
     * @param password
     * @param saltKey
     * @return
     * @throws NoSuchAlgorithmException
     * @throws IOException
     * @author Ashish Shukla
     */
    public synchronized String encode(String password, String saltKey)
	    throws NoSuchAlgorithmException, IOException {
	if (log.isDebugEnabled()) {
	    log.debug("encode(String, String) - start");
	}

	String encodedPassword = null;
	byte[] salt = base64ToByte(saltKey);

	MessageDigest digest = MessageDigest.getInstance("SHA-256");
	digest.reset();
	digest.update(salt);

	byte[] btPass = digest.digest(password.getBytes("UTF-8"));
	for (int i = 0; i < ITERATION_COUNT; i++) {
	    digest.reset();
	    btPass = digest.digest(btPass);
	}

	encodedPassword = byteToBase64(btPass);

	if (log.isDebugEnabled()) {
	    log.debug("encode(String, String) - end");
	}
	return encodedPassword;
    }

    /**
     * @param str
     * @return byte[]
     * @throws IOException
     */
    private byte[] base64ToByte(String str) throws IOException {
	if (log.isDebugEnabled()) {
	    log.debug("base64ToByte(String) - start");
	}

	BASE64Decoder decoder = new BASE64Decoder();
	byte[] returnbyteArray = decoder.decodeBuffer(str);
	if (log.isDebugEnabled()) {
	    log.debug("base64ToByte(String) - end");
	}
	return returnbyteArray;
    }

    /**
     * @param bt
     * @return String
     * @throws IOException
     */
    private String byteToBase64(byte[] bt) {
	if (log.isDebugEnabled()) {
	    log.debug("byteToBase64(byte[]) - start");
	}

	BASE64Encoder endecoder = new BASE64Encoder();
	String returnString = endecoder.encode(bt);
	if (log.isDebugEnabled()) {
	    log.debug("byteToBase64(byte[]) - end");
	}
	return returnString;
    }

    public static String getSalt() {
        return salt;
    }    
}
