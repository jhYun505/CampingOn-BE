package site.campingon.campingon.common.oauth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;
import site.campingon.campingon.common.oauth.service.CustomOAuth2UserService;

@Controller
@RequiredArgsConstructor
public class TestController {

    private final CustomOAuth2UserService customOAuth2UserService;

    @GetMapping("/")
    @ResponseBody
    public String home() {
        return "home";
    }

    @GetMapping("/oauth/success")
    @ResponseBody
    public String success() {
        return "oauth google login success";
    }

    @GetMapping("/oauth/fail")
    @ResponseBody
    public String fail() {
        return "access denied";
    }

    @GetMapping("/oauth/logout/success")
    @ResponseBody
    public String logoutSuccess() {
        return "oauth google logout success";
    }

    @GetMapping("/oauth/logout")
    @ResponseBody
    public RedirectView logout(@AuthenticationPrincipal CustomOAuth2User customOAuth2User) {
        if (customOAuth2User != null) {
            customOAuth2UserService.deleteGoogleAccount(customOAuth2User);
        }

        return new RedirectView("/oauth/logout/success");
    }

}
