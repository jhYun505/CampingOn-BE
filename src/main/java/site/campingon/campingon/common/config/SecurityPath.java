package site.campingon.campingon.common.config;

public class SecurityPath {

    // permitAll
    public static final String[] PUBLIC_ENDPOINTS = {
        "/api/signup",
        "/api/login",
        "/api/token/refresh",
        "/api/users/check-duplicate",
        "/",
        "/api/mongo/camps/search",
        "/api/camps/*/available",
        "/api/camps/*",
        "/api/keywords"
    };


    // hasRole("USER")
    public static final String[] USER_ENDPOINTS = {
        "/api/camps/matched",
        "/api/users/me/bookmarked",
        "/api/users/me/*",
        "/api/users/me",
        "/api/reservations/**",
        "/api/camps/*/bookmarks",
        "/api/logout"
    };

    // hasRole("ADMIN")
    public static final String[] ADMIN_ENDPOINTS = {
        "/api/admin/**",
        "/api/keywords/**",
        "/api/basedList/**",
        "/api/imageList/**"

    };
}
