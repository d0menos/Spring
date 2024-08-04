package ua.Ivan.springcourse.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage (@RequestParam(value = "name", required = false) String name,
                             @RequestParam(value = "surname", required = false)String surname, Model model)  {

        //System.out.println("Hello " + name + " " + surname);
        model.addAttribute("message", "Hello " + name + " " + surname);
        return "first/hello";
    }
    @GetMapping("/goodbye")
    public String goodbyePage () {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculatorPage (@RequestParam(value = "a",required = false)int a,
                                  @RequestParam(value = "b",required = false)int b,
                                  @RequestParam(value = "action",required = false)String action,Model model){

        double result;

        switch (action) {
            case "plus":
                result = a + b;
                break;
                case "minus":
                    result = a - b;
                    break;
                    case "multiply":
                        result = a * b;
                        break;
                        case "divide":
                            result = a / (double)b;
                            break;
            default:
                result = 0;


        }

        model.addAttribute("result", result);

        return "first/calculator";
    }
}
