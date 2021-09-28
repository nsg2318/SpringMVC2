package hello.springmvc.basic.request;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Slf4j
@RestController
public class RequestHeaderController {

    @RequestMapping("/headers")
    public String headers(HttpServletRequest request,
                   HttpServletResponse response,
                   HttpMethod httpMethod,  //GET, POST, ...
                   Locale locale, //언어 정보 ko_KR,eng 등등등등
                   @RequestHeader MultiValueMap<String, String> headerMap, // Header 정보 다 받기 (맵) 멀티벨류맵은 같은 키에 여러개를 받을 수 있음 그래서 같은 키를 .get하면 map으로 반환됨
                   @RequestHeader("host") String host,  // Header 정보 하나만 받기 (host는 필수 헤더임)
                   @CookieValue(value = "myCookie", required = false) String cookie // 쿠키 정보, required는 필수값인지
                   ){

        log.info("request={}", request);
        log.info("response={}", response);
        log.info("httpMethod={}", httpMethod);
        log.info("locale={}", locale);
        log.info("headerMap={}", headerMap);
        log.info("header host={}", host);
        log.info("myCookie={}", cookie);

        return "ok eyo";
    }
}
