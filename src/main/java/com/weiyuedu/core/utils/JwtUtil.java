package com.weiyuedu.core.utils;
import java.util.Date;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.weiyuedu.core.module.portal.pojo.User;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSONObject;
import com.weiyuedu.core.constants.JwtConstant;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

    /**
     * 由字符串生成加密key
     * @return
     */
    private static SecretKey generalKey(){
        String stringKey = JwtConstant.JWT_SECRET;
        byte[] encodedKey = Base64.decodeBase64(stringKey);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    /**
     * 创建jwt
     * @param id
     * @param user
     * @param ttlMillis
     * @return
     * @throws Exception
     */
    public static String createJWT(String id, User user, long ttlMillis) throws Exception {
        String subject = generalSubject(user);
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        SecretKey key = generalKey();
        JwtBuilder builder = Jwts.builder()
                .setId(id)
                .setIssuedAt(now)
                .setSubject(subject)
                .signWith(signatureAlgorithm, key);
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }
        return builder.compact();
    }

    /**
     * 解密jwt
     * @param jwt
     * @return
     * @throws Exception
     */
    public static Claims parseJWT(String jwt) throws Exception{
        SecretKey key = generalKey();
        Claims claims = Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(jwt).getBody();
        return claims;
    }

    /**
     * 生成subject信息
     * @param user
     * @return
     */
    private static String generalSubject(User user){
        JSONObject jo = new JSONObject();
        jo.put("userinfo", user);
        return jo.toJSONString();
    }

//    /**
//     * 测试token加密解密
//     * @param args
//     * @throws Exception
//     */
//    public static void main(String[] args) throws Exception {
//        String subject = JwtUtil.generalSubject(1);
//        String token = JwtUtil.createJWT(JwtConstant.JWT_ID, 1, JwtConstant.JWT_TTL);
//        System.out.println(token);
//        Claims claims = JwtUtil.parseJWT(token);
//        String subject1 = claims.getSubject();
//        System.out.println(subject1);
//    }
}