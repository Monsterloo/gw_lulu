
package com.junlon.common.base.utils.rsa;

import com.junlon.common.base.utils.string.StringUtil;

import javax.crypto.Cipher;
import java.io.*;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/** */

/**
 * <p>
 * RSA公钥/私钥/签名工具包
 * </p>
 * <p>
 * 罗纳德·李维斯特（Ron [R]ivest）、阿迪·萨莫尔（Adi [S]hamir）和伦纳德·阿德曼（Leonard [A]dleman）
 * </p>
 * <p>
 * 字符串格式的密钥在未在特殊说明情况下都为BASE64编码格式<br/>
 * 由于非对称加密速度极其缓慢，一般文件不使用它来加密而是使用对称加密，<br/>
 * 非对称加密算法可以用来对对称加密的密钥加密，这样保证密钥的安全也就保证了数据的安全
 * </p>
 * 
 * @author IceWee
 * @date 2012-4-26
 * @version 1.0
 */
public class RSAUtils {

	public static final String ENCODING = "UTF-8";
	
	/***
	 * deviceType 是安卓
	 */
	public static final String ANDROID = "android";
	
    /** */
    /**
     * 加密算法RSA
     */
    public static final String KEY_ALGORITHM = "RSA";

    /** */
    /**
     * 签名算法
     */
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";
    
    /** */
    /**
     * 获取公钥的key
     */
    private static final String PUBLIC_KEY = "RSAPublicKey";
    
    /**
     * 获取公钥的key对应的Encoded值
     */
    public static final String PUBLIC_KEY_VALUE = "publicEncoded";

    /** */
    /**
     * 获取私钥的key
     */
    private static final String PRIVATE_KEY = "RSAPrivateKey";
    
    /**
     * 获取私钥的key对应的Encoded值
     */
    public static final String PRIVATE_KEY_VALUE = "privateEncoded";

    /** */
    /**
     * RSA最大加密明文大小
     */
    private static final int MAX_ENCRYPT_BLOCK = 116;

    /** */
    /**
     * RSA最大解密密文大小
     */
    private static final int MAX_DECRYPT_BLOCK = 128;

    /**
	 * 获取RSA私钥串
	 * 
	 * @param in
	 *            RSA私钥证书文件流
	 * @param fileSuffix
	 *            RSA私钥名称，决定编码类型|PFX、JKS、PEM...
	 * @param password
	 *            RSA私钥保护密钥|口令
	 * @param keyAlgorithm
	 *            密钥算法
	 * @return RSA私钥对象
	 * @throws Exception
	 */
	public static String getRSAPrivateKeyByFileSuffix(InputStream in, String fileSuffix, String password, String keyAlgorithm)
			throws Exception {
		String keyType = "";
		if ("keystore".equalsIgnoreCase(fileSuffix)) {
			keyType = "JKS";
		} else if ("pfx".equalsIgnoreCase(fileSuffix) || "p12".equalsIgnoreCase(fileSuffix)) {
			keyType = "PKCS12";
		} else if ("jck".equalsIgnoreCase(fileSuffix)) {
			keyType = "JCEKS";
		} else if ("pem".equalsIgnoreCase(fileSuffix) || "pkcs8".equalsIgnoreCase(fileSuffix)) {
			keyType = "PKCS8";
		} /*else if ("pkcs1".equalsIgnoreCase(fileSuffix)) {
			keyType = "PKCS1";
		} */else {
			keyType = "JKS";
		}

		try {
			PrivateKey priKey = null;
			if ("JKS".equals(keyType) || "PKCS12".equals(keyType) || "JCEKS".equals(keyType)) {
				KeyStore ks = KeyStore.getInstance(keyType);
				if (password != null) {
					char[] cPasswd = password.toCharArray();
					ks.load(in, cPasswd);
					Enumeration<String> aliasenum = ks.aliases();
					String keyAlias = null;
					while (aliasenum.hasMoreElements()) {
						keyAlias = (String) aliasenum.nextElement();
						priKey = (PrivateKey) ks.getKey(keyAlias, cPasswd);
						if (priKey != null)
							break;
					}
				}
			} else {
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				StringBuilder sb = new StringBuilder();
				String readLine = null;
				while ((readLine = br.readLine()) != null) {
					if (readLine.charAt(0) == '-') {
						continue;
					} else {
						sb.append(readLine);
						sb.append('\r');
					}
				}
				if ("PKCS8".equals(keyType)) {
					//org.apache.commons.codec.binary.Base64
					PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.decode(sb.toString()));
					KeyFactory keyFactory = KeyFactory.getInstance(keyAlgorithm);
					priKey = keyFactory.generatePrivate(priPKCS8);
				} /*else if ("PKCS1".equals(keyType)) {
					RSAPrivateKeyStructure asn1PrivKey = new RSAPrivateKeyStructure((ASN1Sequence) ASN1Sequence.fromByteArray(sb.toString().getBytes()));
					KeySpec rsaPrivKeySpec = new RSAPrivateKeySpec(asn1PrivKey.getModulus(), asn1PrivKey.getPrivateExponent());
					KeyFactory keyFactory = KeyFactory.getInstance(keyAlgorithm);
					priKey = keyFactory.generatePrivate(rsaPrivKeySpec);
				}*/
			}

			return Base64.encode(priKey.getEncoded());
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("私钥路径文件不存在");
		} catch (KeyStoreException e) {
			throw new KeyStoreException("获取KeyStore对象异常");
		} catch (IOException e) {
			throw new IOException("读取私钥异常");
		} catch (NoSuchAlgorithmException e) {
			throw new NoSuchAlgorithmException("生成私钥对象异常");
		} catch (CertificateException e) {
			throw new CertificateException("加载私钥密码异常");
		} catch (UnrecoverableKeyException e) {
			throw new UnrecoverableKeyException("生成私钥对象异常");
		} catch (InvalidKeySpecException e) {
			throw new InvalidKeySpecException("生成私钥对象异常");
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
			}
		}
	}
    
    /** */
    /**
     * <p>
     * 生成密钥对(公钥和私钥)
     * </p>
     * 
     * @return
     * @throws Exception
     */
    public static Map<String, Object> genKeyPair() throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGen.initialize(1024);
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        Map<String, Object> keyMap = new HashMap<String, Object>(2);
        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);
        
        keyMap.put(PUBLIC_KEY_VALUE, Base64.encode(publicKey.getEncoded()));
        keyMap.put(PRIVATE_KEY_VALUE, Base64.encode(privateKey.getEncoded()));
        return keyMap;
    }

  /* static {
       try {
           Map<String, Object> keyMap = RSAUtils.genKeyPair();
          String publicKey = RSAUtils.getPublicKey(keyMap);
          String privateKey = RSAUtils.getPrivateKey(keyMap);
           System.err.println("公钥: \n\r" + publicKey);
           System.err.println("私钥： \n\r" + privateKey);
       } catch (Exception e) {
           e.printStackTrace();
       }
   }*/
   
    
    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
		String str = "88800000000000014581141116331.021机票http://shop.yqifu.com:8081/return_url.jsphttp://shop.yqifu.com:8081/notify_url.jsp302";
		String certStr = "MIIExjCCA66gAwIBAgIUQ6pRaeKVBUDV8e2H/uIGf2zKjkYwDQYJKoZIhvcNAQEFBQAwUTEYMBYGA1UEAwwPaG5fdG9wY2FfdXNlcmNhMRgwFgYDVQQLDA/mtYvor5Xpg6jor5XnlKgxGzAZBgNVBAoMEuWkqeivmuWuieS/oeivleeUqDAeFw0xNjAzMTUwNzQzMjNaFw0xNjA0MTQwNzQzMjNaMG8xGzAZBgNVBAMMEua1i+ivleWVhuaIt+i0puWPtzEUMBIGA1UECwwLaG5fdG9wY2FfcmExFDASBgNVBAoMC2huX3RvcGNhX3JhMSQwIgYJKoZIhvcNAQkBDBUxMjg4ODg4ODg4QGd6enl6ei5jb20wggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQDPpeFTr4igDF7GMIeMQkoDTmpcD1m80xJR0XPO/R8UMVXQplqQf7AsuGMV9Teb2uisMjrADE7qxvpFIWUy887+cnqEz0xLiw/2hsq8j9Twlsicm9buEYSuIc+W3XgVW4iOTrrN6T5hOXbWiwJqa6D0LK0jXOlqB2QS5F9UV9kl9q9ZJ3kvk/CcwTeUCNfx0FOZh7ietltfy3TSltGTNVLFtSo1AhZxsH4dITLKW/q8l63dYRLuB84f+SI7Nd8ErfcDWzlVDkUbp9IJS8Yw0ictGcVPlNuKb43oa+yX6E1+8hPy6XbqZ69N3bNzHOTh/2LPwXWryLEAUBIvAtNbY+L1AgMBAAGjggF2MIIBcjAJBgNVHRMEAjAAMAsGA1UdDwQEAwIFoDCBgwYIKwYBBQUHAQEEdzB1MHMGCCsGAQUFBzAChmdodHRwOi8vdG9wY2Euc3ppdHJ1cy5jb20uY24vdXNlckVucm9sbC9jYUNlcnQ/Y2VydFNlcmlhbE51bWJlcj02MEZGNUREMTI4QjlENDA3QzA2QUE1MDg0M0E4MjdENTY3NzNGNUE5MGgGA1UdLgRhMF8wXaBboFmGV2h0dHA6Ly90b3BjYS5zeml0cnVzLmNvbS5jbi9wdWJsaWMvaXRydXNjcmw/Q0E9NjBGRjVERDEyOEI5RDQwN0MwNkFBNTA4NDNBODI3RDU2NzczRjVBOTBoBgNVHR8EYTBfMF2gW6BZhldodHRwOi8vdG9wY2Euc3ppdHJ1cy5jb20uY24vcHVibGljL2l0cnVzY3JsP0NBPTYwRkY1REQxMjhCOUQ0MDdDMDZBQTUwODQzQTgyN0Q1Njc3M0Y1QTkwDQYJKoZIhvcNAQEFBQADggEBAFRnmrqRHbkXl5DXdggujtQPzAUscHdnBi0ui6WoQDyEc61saWe9vRNb25mNSfkUq2UMwnl+8ffDWU2OKZFkm1k9UAtB0RuzW5avE7lsImUYnjEGBmlqqZEtryar6b1iP+dlk1qy96YThtPo5w+SwvYqA3Tp5Ix7rOJ5oHyCcWe5UpiL9Laz9iMGIDs8yG6qioF49boddExqyjhuuV/BGmS8bRfg86pSoKX+LdB1PcA3zh8e6oVdwnUm8BFC7869aVHoEbUfR195EiDcw57wjWQnTiG3WolsvEE4htYNt6vFh+FGIwMsrbx8DTADeTUBnh5zKhNvOTo5wtqYruxR8ww=";
		try {
			String privateStr = getRSAPrivateKeyByFileSuffix(new FileInputStream("G:/rsa_private_pkcs8.pem"), "pem", "", "RSA");
			System.out.println(privateStr);
			//String ss2 = new String(encryptByPrivateKey("laich".getBytes(), DEFAULT_PRIVATE_KEY));
			/*String ss = Base64.encode(encryptByPublicKey("laich".getBytes(), DEFAULT_PUBLIC_KEY,null));
			byte[] bb = decryptByPrivateKey(Base64.decode(ss), DEFAULT_PRIVATE_KEY);
			String ss = Base64.encode(encryptByPrivateKey("123=喀喀喀为&lai=赖春华&laich赶快i哦".getBytes(), DEFAULT_PRIVATE_KEY));
			byte[] bb = decryptByPublicKey(Base64.decode(ss), DEFAULT_PUBLIC_KEY);*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    /** */
    /**
     * <p>
     * 用私钥对信息生成数字签名
     * </p>
     * 
     * @param data 已加密数据
     * @param privateKey 私钥(BASE64编码)
     * @return
     * @throws Exception
     */
    public static String sign(byte[] data, String privateKey) throws Exception {
        byte[] keyBytes = Base64.decode(privateKey);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PrivateKey privateK = keyFactory.generatePrivate(pkcs8KeySpec);
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initSign(privateK);
        signature.update(data);
        return Base64.encode(signature.sign());
    }
    
    /** */
    /**
     * <p>
     * 校验数字签名
     * </p>
     * 
     * @param data 已加密数据
     * @param publicKey 公钥(BASE64编码)
     * @param sign 数字签名
     * @param keyType 编码格式
     * @return
     * @throws Exception
     */
    public static boolean verify(byte[] data, String publicKey, String sign, String keyType)
            throws Exception {
		if ("PKCS12".equals(keyType)) {
			return verify(data, publicKey, sign);
		} else if ("X.509".equals(keyType)) {
			byte[] keyBytes = Base64.decode(publicKey);
			CertificateFactory factory = CertificateFactory.getInstance(keyType);
			Certificate cert = factory.generateCertificate(new ByteArrayInputStream(keyBytes));
			PublicKey pubKey = cert.getPublicKey();
			Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
	        signature.initVerify(pubKey);
	        signature.update(data);
	        return signature.verify(Base64.decode(sign));
		}
		throw new Exception("==>校验数字签名：未知的证书公钥编码格式！");
    }

    /** */
    /**
     * <p>
     * 校验数字签名
     * </p>
     * 
     * @param data 已加密数据
     * @param publicKey 公钥(BASE64编码)
     * @param sign 数字签名
     * @return
     * @throws Exception
     */
    public static boolean verify(byte[] data, String publicKey, String sign)
            throws Exception {
        byte[] keyBytes = Base64.decode(publicKey);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PublicKey publicK = keyFactory.generatePublic(keySpec);
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initVerify(publicK);
        signature.update(data);
        return signature.verify(Base64.decode(sign));
    }

    /** */
    /**
     * <P>
     * 私钥解密
     * </p>
     * 
     * @param encryptedData 已加密数据
     * @param privateKey 私钥(BASE64编码)
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPrivateKey(byte[] encryptedData, String privateKey)
            throws Exception {
        byte[] keyBytes = Base64.decode(privateKey);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateK);
        int inputLen = encryptedData.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段解密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_DECRYPT_BLOCK;
        }
        byte[] decryptedData = out.toByteArray();
        out.close();
        return decryptedData;
    }

    /** */
    /**
     * <p>
     * 公钥解密
     * </p>
     * 
     * @param encryptedData 已加密数据
     * @param publicKey 公钥(BASE64编码)
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPublicKey(byte[] encryptedData, String publicKey)
            throws Exception {
        byte[] keyBytes = Base64.decode(publicKey);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key publicK = keyFactory.generatePublic(x509KeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, publicK);
        int inputLen = encryptedData.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段解密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_DECRYPT_BLOCK;
        }
        byte[] decryptedData = out.toByteArray();
        out.close();
        return decryptedData;
    }

    /** */
    /**
     * <p>
     * 公钥加密
     * </p>
     * 
     * @param data 源数据
     * @param publicKey 公钥(BASE64编码)
     * @param deviceType 类型(IOS还是android)
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPublicKey(byte[] data, String publicKey, String deviceType)
            throws Exception {
        byte[] keyBytes = Base64.decode(publicKey);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key publicK = keyFactory.generatePublic(x509KeySpec);
        // 对数据加密
        Cipher cipher = null;
        if(StringUtil.isNotBlank(deviceType)&& deviceType.toLowerCase().equals(ANDROID)){
        	// 如果是安卓机
        	cipher = Cipher.getInstance("RSA/ECB/NoPadding");
        }else{
        	cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        }
        cipher.init(Cipher.ENCRYPT_MODE, publicK);
        int inputLen = data.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段加密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(data, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_ENCRYPT_BLOCK;
        }
        byte[] encryptedData = out.toByteArray();
        out.close();
        return encryptedData;
    }

    /** */
    /**
     * <p>
     * 私钥加密
     * </p>
     * 
     * @param data 源数据
     * @param privateKey 私钥(BASE64编码)
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPrivateKey(byte[] data, String privateKey)
            throws Exception {
        byte[] keyBytes = Base64.decode(privateKey);
        // 实例化PKCS8EncodedKeySpec对象
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        // 实例化KeyFactory对象，并指定RSA算法
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, privateK);
        int inputLen = data.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段加密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(data, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_ENCRYPT_BLOCK;
        }
        byte[] encryptedData = out.toByteArray();
        out.close();
        return encryptedData;
    }

    /** */
    /**
     * <p>
     * 获取私钥
     * </p>
     * 
     * @param keyMap 密钥对
     * @return
     * @throws Exception
     */
    public static String getPrivateKey(Map<String, Object> keyMap)
            throws Exception {
        Key key = (Key) keyMap.get(PRIVATE_KEY);
        return Base64.encode(key.getEncoded());
    }

    /** */
    /**
     * <p>
     * 获取公钥
     * </p>
     * 
     * @param keyMap 密钥对
     * @return
     * @throws Exception
     */
    public static String getPublicKey(Map<String, Object> keyMap)
            throws Exception {
        Key key = (Key) keyMap.get(PUBLIC_KEY);
        return Base64.encode(key.getEncoded());
    }

}
