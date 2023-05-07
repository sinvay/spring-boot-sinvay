package com.sinvay.boot.authority.authentication;


import com.sinvay.boot.authority.user.AuthorizedUser;

import javax.servlet.http.HttpServletRequest;

/**
 * Authentication
 *
 * @author Xpizza
 * @since sinvay1.0
 */
public interface Authentication<U extends AuthorizedUser> {
    /**
     * authentication name
     *
     * @return
     */
    String authenticationName();

    /**
     * parse user from HttpServletRequest
     *
     * @param request
     * @return
     */
    U parseUser(HttpServletRequest request);

    /**
     * cache user
     *
     * @param user authorized user
     */
    void cacheUser(U user);
}
