package helloobjects;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloObjectsController {

  private List<Item> items;

  public HelloObjectsController() {
    this.items = new ArrayList<>();
    this.items.add(new Item("Wizard hat", "pointy"));
    this.items.add(new Item("Party hat", "groovy"));
  }

  // Make here a method that handles a GET-type request coming to the root path
  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("list", items);
    return "index";
  }

  // Älä koske tähän metodiin -- tutustumme tiedon lisäämiseen hieman myöhemmin.
  @PostMapping("/")
  public String post(@RequestParam String name, @RequestParam String type) {
    this.items.add(new Item(name.trim(), type.trim()));
    return "redirect:/";
  }
}
