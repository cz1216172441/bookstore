package com.notalent.bookstore.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.notalent.bookstore.pojo.user.UserInfo;
import com.sun.istack.internal.Nullable;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Options;

import java.util.Date;

/**
 * Json Web Token Utils
 * JWT Utils
 * @author noTalent
 * @version 1.0
 * 2019.05.10
 */
public class JwtUtils {

    // token 过期时间
    public static final long EXPIRES = 60 * 60 * 1000;

    // token 发行人
    public static final String ISSUER = "auth0";

    // token 用户id
    public static final String USER_ID = "upload";

    // 获取令牌
    public static String getToken(UserInfo ui) {
        return getToken(ui, EXPIRES);
    }

    public static String getToken(UserInfo ui, Long expires) {
        if (expires != null) expires = EXPIRES;
        return JWT.create()
                .withIssuer(ISSUER)
                .withClaim(USER_ID, ui.getUserInfoId())
                .withExpiresAt(new Date(System.currentTimeMillis() + expires))
                .sign(Algorithm.HMAC256(ui.getPassword()));
    }

    // 验证令牌
    public static boolean verify(UserInfo ui, String token) {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(ui.getPassword()))
                .withClaim(USER_ID, ui.getUserInfoId())
                .build();
        try {
            jwtVerifier.verify(token);
            return true;
        } catch (JWTVerificationException exception) {
            return false;
        }
    }

    // 获取令牌中的用户id
    public static Integer getUserInfoId(String token) throws JWTDecodeException {
        return JWT.decode(token).getClaim(USER_ID).asInt();
    }

    // 获取token过期时间
    public static Date getExpires(String token) throws JWTDecodeException {
        return JWT.decode(token).getExpiresAt();
    }

}
