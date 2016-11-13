package thymeleafexamples.sfs.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;

import thymeleafexamples.sfs.business.entities.Order;
import thymeleafexamples.sfs.business.entities.OrderLine;
import thymeleafexamples.sfs.business.services.OrderService;

/**
 * Created by shower on 16-11-6.
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    public OrderController() {
        super();
    }

    @RequestMapping("/{orderId}")
    public String getOrder(@PathVariable int orderId, Model model) {
        model.addAttribute("orderlines", orderService.findById(orderId).getOrderLines());
        return "order";
    }

}
