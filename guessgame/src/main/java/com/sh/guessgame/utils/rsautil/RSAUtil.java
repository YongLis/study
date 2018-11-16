package com.sh.guessgame.utils.rsautil;

import java.beans.PropertyDescriptor;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.crypto.Cipher;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sh.guessgame.utils.common.ObjectUtil;
import com.sh.guessgame.utils.common.SecurityField;
import com.sh.guessgame.utils.common.StringUtil;
import com.sh.guessgame.utils.exception.GameException;



/**
 * RSA加解密工具栏
 */
public class RSAUtil {

    private static final String ALGORITHM = "RSA";

    private static final Logger LOGGER = LoggerFactory.getLogger(RSAUtil.class);
    private static final String PUBLIC_KEY = "RSAPublicKey";
    private static final String PRIVATE_KEY = "RSAPrivateKey";
    static {
        Security.addProvider(new BouncyCastleProvider());
    }
	
	 public static Map<String, Object> genKeyPair() throws Exception {
	        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(ALGORITHM);
	        keyPairGen.initialize(2048);
	        KeyPair keyPair = keyPairGen.generateKeyPair();
	        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
	        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
	        Map<String, Object> keyMap = new HashMap<String, Object>(2);
	        keyMap.put(PUBLIC_KEY, publicKey);
	        keyMap.put(PRIVATE_KEY, privateKey);
	        return keyMap;
	    }
    /**
     * getPublicKey  X509
     *
     * @param algorithm
     * @param bysKey
     * @return
     * @throws NoSuchAlgorithmException
     * @throws Exception
     */
    private static PublicKey getPublicKeyFromX509(String algorithm, String bysKey)
            throws NoSuchAlgorithmException,
            Exception {
        byte[] decodedKey = Base64.decode(bysKey);
        X509EncodedKeySpec x509 = new X509EncodedKeySpec(decodedKey);

        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
        return keyFactory.generatePublic(x509);
    }

    /**
     * getPublicKey  Hex
     *
     * @param algorithm
     * @param exponent
     * @return
     * @throws NoSuchAlgorithmException
     * @throws Exception
     */
    private static PublicKey getPublicKeyFromHex(String algorithm, String modulus, String exponent) throws NoSuchAlgorithmException, Exception {
        KeyFactory factory = KeyFactory.getInstance(algorithm);
        BigInteger n = new BigInteger(modulus, 16);
        BigInteger e = new BigInteger(exponent);
        RSAPublicKeySpec spec = new RSAPublicKeySpec(n, e);
        return factory.generatePublic(spec);
    }
    
    /**
     * @param content
     * @param modulus
     * @param exponent
     * @return
     */
    public static String encryptByHex(String content, String modulus, String exponent) {
        String encryptData = null;
        ByteArrayOutputStream bout = null;
        try {
            PublicKey pubKey = getPublicKeyFromHex(ALGORITHM, modulus, exponent);
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding", "BC");
            cipher.init(Cipher.ENCRYPT_MODE, pubKey);

            byte plaintext[] = content.getBytes("UTF-8");
            final int blockSize = cipher.getBlockSize();
            bout = new ByteArrayOutputStream();

            for (int i = 0; i < plaintext.length; i += blockSize) {
                bout.write(cipher.doFinal(plaintext, i,
                        plaintext.length - i < blockSize ? plaintext.length - i : blockSize));
            }
            encryptData = Base64.encode(bout.toByteArray());
            return encryptData;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            if (bout != null) {
                try {
                    bout.close();
                } catch (IOException e) {
                    LOGGER.error(e.getMessage(), e);
                }
                bout = null;
            }
        }
        return encryptData;
    }

    /**
     * getPrivateKey  Hex
     *
     * @param algorithm
     * @param exponent
     * @return
     * @throws NoSuchAlgorithmException
     * @throws Exception
     */
    private static PrivateKey getPrivateKeyFromHex(String algorithm, String modulus, String exponent) throws NoSuchAlgorithmException, Exception {
        KeyFactory factory = KeyFactory.getInstance(algorithm);
        BigInteger n = new BigInteger(modulus, 16);
        BigInteger e = new BigInteger(exponent, 16);
        RSAPrivateKeySpec spec = new RSAPrivateKeySpec(n, e);
        return factory.generatePrivate(spec);
    }

    public static String decryptByHex(String content, String modulus, String exponent) {
        ByteArrayOutputStream bout = null;
        String decryptData = null;

        try {
            PrivateKey privateKey = getPrivateKeyFromHex(ALGORITHM, modulus, exponent);
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding", "BC");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);

            byte plaintext[] = Base64.decode(content);

            final int blockSize = cipher.getBlockSize();
            bout = new ByteArrayOutputStream();
            for (int i = 0; i < plaintext.length; i += blockSize) {
                bout.write(cipher.doFinal(plaintext, i,
                        plaintext.length - i < blockSize ? plaintext.length - i : blockSize));
            }
            decryptData = new String(bout.toByteArray(), "UTF-8");
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            if (bout != null) {
                try {
                    bout.close();
                } catch (IOException e) {
                    LOGGER.error(e.getMessage(), e);
                }
                bout = null;
            }
        }

        return decryptData;
    }


    public static String encrypt(String content, String publicKey) {
        String encryptData = null;
        ByteArrayOutputStream bout = null;

        try {
            PublicKey pubkey = getPublicKeyFromX509(ALGORITHM, publicKey);

            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding", "BC");
            cipher.init(Cipher.ENCRYPT_MODE, pubkey);

            byte plaintext[] = content.getBytes("UTF-8");

            final int blockSize = cipher.getBlockSize();
            bout = new ByteArrayOutputStream();

            for (int i = 0; i < plaintext.length; i += blockSize) {
                bout.write(cipher.doFinal(plaintext, i,
                        plaintext.length - i < blockSize ? plaintext.length - i : blockSize));
            }
            // byte[] output = cipher.doFinal( plaintext );

            encryptData = new String(Base64.encode(bout.toByteArray()));

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            if (bout != null) {
                try {
                    bout.close();
                } catch (IOException e) {
                    LOGGER.error(e.getMessage(), e);
                }
                bout = null;
            }
        }

        return encryptData;
    }

    public static String decrypt(String content, String privateKeyStr) {
        ByteArrayOutputStream bout = null;
        String decryptData = null;

        try {
            PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.decode(privateKeyStr));
            KeyFactory keyf = KeyFactory.getInstance("RSA");
            PrivateKey privateKey = keyf.generatePrivate(priPKCS8);

            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding", "BC");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);

            byte plaintext[] = Base64.decode(content);// content.getBytes("UTF-8");
            // byte[] output = cipher.doFinal( plaintext );

            final int blockSize = cipher.getBlockSize();
            bout = new ByteArrayOutputStream();

            for (int i = 0; i < plaintext.length; i += blockSize) {
                bout.write(cipher.doFinal(plaintext, i,
                        plaintext.length - i < blockSize ? plaintext.length - i : blockSize));
            }
            // byte[] output = cipher.doFinal( plaintext );

            decryptData = new String(bout.toByteArray(), "UTF-8");
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            if (bout != null) {
                try {
                    bout.close();
                } catch (IOException e) {
                    LOGGER.error(e.getMessage(), e);
                }
                bout = null;
            }
        }

        return decryptData;
    }

    public static final String SIGN_ALGORITHMS = "SHA256WithRSA";

    public static String sign(String content, String privateKey) {
        String charset = "utf-8";
        try {
            PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.decode(privateKey));
            KeyFactory keyf = KeyFactory.getInstance("RSA");
            PrivateKey priKey = keyf.generatePrivate(priPKCS8);

            Signature signature = Signature
                    .getInstance(SIGN_ALGORITHMS);

            signature.initSign(priKey);
            signature.update(content.getBytes(charset));

            byte[] signed = signature.sign();
            String   sign = new String(Base64.encode(signed));
            sign = StringUtils.removeEnd(sign, "\r\n");
            return sign;
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage(), e);
        }

        return null;
    }

    public static boolean doCheck(String content, String sign, String publicKey,String encode) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] encodedKey = Base64.decode(publicKey);
            PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));

            Signature signature = Signature
                    .getInstance(SIGN_ALGORITHMS);

            signature.initVerify(pubKey);
            signature.update(content.getBytes(encode));

            boolean bverify = signature.verify(Base64.decode(sign));
            return bverify;

        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage(), e);
        }

        return false;
    }
    public static String getSignContent(Map<String, String> sortedParams) {
		StringBuffer content = new StringBuffer();
		List<String> keys = new ArrayList<String>(sortedParams.keySet());
		Collections.sort(keys);
		int index = 0;
		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			String value = sortedParams.get(key);
			if (StringUtil.areNotEmpty(key, value)) {
				content.append((index == 0 ? "" : "&") + key + "=" + value);
				index++;
			}
		}
		return content.toString();
	}
    public static <T> T encryptSecurityField(T model, String publicKey) throws GameException{
        return invokeCryptionService(model, publicKey, true);
    }

    public static <T> T decryptSecurityField(T model, String privateKey) throws GameException{
        return invokeCryptionService(model, privateKey, false);
    }

    private static <T> T invokeCryptionService(T model, String key, boolean isEncrypt) throws GameException{
        if (model == null) {
            return null;
        }
        // Clone会更好
        T clone = (T) ObjectUtil.build(model.getClass(), model);
        Map<String, String> contents = new HashMap<String, String>();
        List<Field> fields = new ArrayList<Field>(Arrays.asList(model.getClass().getDeclaredFields()));
        // 往父类查询一级，防止父类有SecurityField的情况
        fields.addAll(new ArrayList<Field>(Arrays.asList(model.getClass().getSuperclass().getDeclaredFields())));
        try {
            for (Field field : fields) {
                if (isSecurityField(field)) {
                    String fieldValue = getFieldValue(model, field.getName());
                    if(StringUtils.isNotEmpty(fieldValue)) {
                        contents.put(field.getName(), fieldValue);
                    }
                }
            }

            if (contents.size() > 0) {
                Map<String, String> results = null;
                if (isEncrypt) {
                    results = encryptEnhanced(key, contents);
                } else {
                    results = decryptEnhanced(key, contents);
                }
                for (String fieldName : results.keySet()) {
                    setFieldValue(clone, fieldName, results.get(fieldName));
                }
            }
        } catch (GameException ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new GameException(isEncrypt ? "加密失败" : "解密失败");
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new GameException(isEncrypt ? "加密失败" : "解密失败");
        }
        return clone;
    }

    private static Map<String, String> encryptEnhanced(String publicKey, Map<String, String> contents) {
        Iterator<String> its = contents.keySet().iterator();
        if (StringUtils.isEmpty(publicKey)) {
            throw new GameException("公钥为空");
        }
        Map<String, String> map = new HashMap<String, String>();
        while (its.hasNext()) {
            String key = its.next();
            String content = contents.get(key);
            String result = doEncrypt(content, publicKey);
            if (StringUtils.isNotEmpty(content) && StringUtils.isEmpty(result)) {
                throw new GameException("加密失败");
            }
            map.put(key, result);
        }
        return map;
    }

    private static String doEncrypt(String content, String key) {
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        return encrypt(content, key);
    }


    private static String doDecrypt(String content, String key) {
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        return decrypt(content, key);
    }

    private static Map<String, String> decryptEnhanced(String privateKey, Map<String, String> contents) {
        Iterator<String> its = contents.keySet().iterator();
        if (StringUtils.isEmpty(privateKey)) {
            throw new GameException("私钥为空");
        }
        Map<String, String> map = new HashMap<String, String>();
        while (its.hasNext()) {
            String key = its.next();
            String content = contents.get(key);
            String result = doDecrypt(content, privateKey);
            if (StringUtils.isNotEmpty(content) && StringUtils.isEmpty(result)) {
                throw new GameException("解密失败");
            }
            map.put(key, result);
        }
        return map;
    }

    private static boolean isSecurityField(Field field) {
        return field.getAnnotation(SecurityField.class) != null;
    }

    private static <T>  String getFieldValue(T model, String fieldName) throws Exception {
        PropertyDescriptor propertyDescriptor = PropertyUtils.getPropertyDescriptor(model, fieldName);
        Method reader = propertyDescriptor.getReadMethod();
        Object valueObject = reader.invoke(model);
        String value = valueObject == null ? "" : valueObject.toString();
        return value;
    }

    private static <T> void setFieldValue(T model, String fieldName, String fieldValue) throws Exception {
        PropertyDescriptor propertyDescriptor = PropertyUtils.getPropertyDescriptor(model, fieldName);
        Method writer = propertyDescriptor.getWriteMethod();
        writer.invoke(model, fieldValue);
    }
}
