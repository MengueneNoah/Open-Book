package com.winseslas.openbook.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Winseslas
 */
public class SessionManager {
    
    public static void setSessionAttribute(HttpServletRequest request, String attributeName, Object attributeValue)    
     {
        HttpSession session = request.getSession(true);
        session.setAttribute(attributeName, attributeValue);
    }
    
    public static Object getSessionAttribute(HttpServletRequest request, String attributeName) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return null;
        }
        return session.getAttribute(attributeName);
    }
    
    public static void removeSessionAttribute(HttpServletRequest request, String attributeName) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute(attributeName);
        }
    }
    
    public static void invalidateSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }
    
}
