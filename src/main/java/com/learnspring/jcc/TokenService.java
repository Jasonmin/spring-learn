package com.learnspring.jcc;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;
import java.io.UnsupportedEncodingException;


/**
 * @author jinbin
 * @date 2018-07-08 21:04
 */
@Service("TokenService")
public class TokenService {
    public String getToken(JUser user) {
        String token="";
//        token= JWT.create().withAudience(user.getId())// 将 user id 保存到 token 里面
//                .sign(Algorithm.HMAC256(user.getPassword()));// 以 password 作为 token 的密钥
//        return token;

        String secret = "jwtTokenSecretZhou";
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            // 附带username信息
            return JWT.create()
                    .withClaim("username", user.getUsername())
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }
}
