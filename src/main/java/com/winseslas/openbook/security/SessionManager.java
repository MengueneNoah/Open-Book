package com.winseslas.openbook.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Gestionnaire de session pour les servlets Java.
 * Utilise la classe HttpServletRequest pour manipuler les sessions.
 * 
 * Pour utiliser cette classe, assurez-vous que vous avez une dépendance vers javax.servlet.http.HttpServletRequest et javax.servlet.http.HttpSession dans votre projet.
 * 
 * Exemple d'utilisation :
 * 
 * SessionManager.setSessionAttribute(request, "username", "john.doe");
 * String username = (String) SessionManager.getSessionAttribute(request, "username");
 * SessionManager.removeSessionAttribute(request, "username");
 * SessionManager.invalidateSession(request);
 * 
 * @author Winseslas
 */
public class SessionManager {

    /**
     * Définit un attribut de session.
     * 
     * @param request HttpServletRequest de la requête en cours
     * @param attributeName nom de l'attribut de session
     * @param attributeValue valeur de l'attribut de session
     */
    public static void setSessionAttribute(HttpServletRequest request, String attributeName, Object attributeValue) {
        HttpSession session = request.getSession(true);
        session.setAttribute(attributeName, attributeValue);
    }

    /**
     * Récupère la valeur d'un attribut de session.
     * 
     * @param request HttpServletRequest de la requête en cours
     * @param attributeName nom de l'attribut de session
     * @return la valeur de l'attribut de session, ou null si l'attribut n'existe pas
     */
    public static Object getSessionAttribute(HttpServletRequest request, String attributeName) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return null;
        }
        return session.getAttribute(attributeName);
    }

    /**
     * Supprime un attribut de session.
     * 
     * @param request HttpServletRequest de la requête en cours
     * @param attributeName nom de l'attribut de session
     */
    public static void removeSessionAttribute(HttpServletRequest request, String attributeName) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute(attributeName);
        }
    }

    /**
     * Invalide la session en cours.
     * 
     * @param request HttpServletRequest de la requête en cours
     */
    public static void invalidateSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }

}
