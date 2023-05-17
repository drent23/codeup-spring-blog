package com.codeup.codeupspringblog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class MathController {
    @GetMapping("/add/{num1}/{num2}")
    @ResponseBody
    public String addNums(@PathVariable int num1,@PathVariable int num2) {
        return num1 + " + " + num2 + " = " + (num1 + num2);
    }
    @GetMapping("/subtract/{num1}/{num2}")
    @ResponseBody
    public String subtractNums(@PathVariable int num1,@PathVariable int num2) {
        return num1 + " - " + num2 + " = " + (num1 - num2);
    }
    @GetMapping("/multiply/{num1}/{num2}")
    @ResponseBody
    public String multiplyNums(@PathVariable int num1,@PathVariable int num2) {
        return num1 + " x " + num2 + " = " + (num1 * num2);
    }
    @GetMapping("/divide/{num1}/{num2}")
    @ResponseBody
    public String divideNums(@PathVariable int num1,@PathVariable int num2) {
        return num1 + " / " + num2 + " = " + (num1 / num2);
    }
    @GetMapping("/remainder/{num1}/{num2}")
    @ResponseBody
    public String modNums(@PathVariable int num1,@PathVariable int num2) {
        return "The remainder of " + num1 + " divided by " + num2 + " is " + num1 % num2;
    }
}
