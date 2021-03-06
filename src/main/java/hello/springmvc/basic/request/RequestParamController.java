package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username={}, age={}",username,age);

        response.getWriter().write("this is @Controller and void method. so i have to use response.getWriter()");
    }

    @ResponseBody // @Controller. must return ModelView, but this annotation can return String
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
        @RequestParam("username") String memberName,
        @RequestParam("age") int memberAge){

        log.info("membername={}, memberAge={}",memberName,memberAge);
        return "ok responsebody2";
    }


    @ResponseBody // @Controller. must return ModelView, but this annotation can return String
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age){

        log.info("membername={}, memberAge={}",username,age);
        return "ok responsebody3";
    }

    @ResponseBody // @Controller. must return ModelView, but this annotation can return String
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username,int age){ //단순 타입의 경우 @RequestParam도 생략 가능 ...
        log.info("membername={}, memberAge={}",username,age);
        return "ok responsebody4";
    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true) String username,
            @RequestParam(required = false) Integer age){
        log.info("membername={}, memberAge={}",username,age);
        return "ok responsebody4";
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamRequired(
            @RequestParam(defaultValue = "guest") String username,
            @RequestParam(defaultValue = "-1") int age){
        log.info("membername={}, memberAge={}",username,age);
        return "ok responsebody4";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap){
        log.info("membername={}, memberAge={}",paramMap.get("username"),paramMap.get("age"));
        return "ok responsebody4";
    }


    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData){
        log.info("{}",helloData);
        return "ok";
    }

    //스프링은 String, int, Integer 같은 단순 타입은 @RequestParam
    //직접 만든 객체는 @ModelAttribute
    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData){
        log.info("{}",helloData);
        return "ok";
    }


}
