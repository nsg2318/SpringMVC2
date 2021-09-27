package hello.springmvc.basic;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//일반적인 Controller 는 뷰를 반환해야하므로 String반환을 기본적으로 뷰 이름으로 인식한다 그러나
//REST컨트롤러는 return을 String으로 했을 때 바로 그냥 그 스트링이 반환됨 그래서 간단하게 쓸 때 RESTController 씀
@Slf4j
@RestController
public class LogTestController {

//@SLf4j쓰면 밑에 줄 생략가능
//    private final Logger log = LoggerFactory.getLogger(LogTestController.class);


    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";

        //log.debug("data="+data); 이런식으로 작성하면 연산이 다 된 후 log.trace()실행되기 때문에 불필요한 리소스를 사용할 가능성이 존재한다.
        // 따라서 위 같이 로그 사용하지 말자
        log.trace("trace log={}", name);
        log.debug("debug log={}", name);
        log.info(" info log = {}", name);
        log.warn("warn log={}", name);
        log.error("error log={}", name);
        return "ok";
    }
}
