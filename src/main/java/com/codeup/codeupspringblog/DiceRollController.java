package com.codeup.codeupspringblog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Random;
@Controller
public class DiceRollController {
    @GetMapping("/roll-dice")
    public String diceRoll() {
        return "diceRoll";
    }
    @GetMapping("/roll-dice/{n}")
        public String rollDice(@PathVariable int n, Model model) {
        Random randomRoll = new Random();
        int diceRoll = randomRoll.nextInt(6) + 1;
        model.addAttribute("diceRoll", diceRoll);
        model.addAttribute("numGuess", n);
        if(n == diceRoll) {
            model.addAttribute("message", "You guessed correctly!");
        } else {
            model.addAttribute("message", "Incorrect guess.  Please try again.");
        }
        return "diceRoll";
    }
}
