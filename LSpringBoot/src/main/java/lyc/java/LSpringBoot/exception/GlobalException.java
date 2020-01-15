package lyc.java.LSpringBoot.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public String runtimeExceptionFun() {
        return "全局捕获异常！";
    }
}
