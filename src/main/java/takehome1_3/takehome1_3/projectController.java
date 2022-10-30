/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package takehome1_3.takehome1_3;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author rozan
 */

@Controller
public class projectController {
    @RequestMapping ("/inputData")
    public String getData(HttpServletRequest data, Model discountprocess){
    String InputName = data.getParameter("nama");
    String InputPrice = data.getParameter("harga");
    String InputQTY = data.getParameter("jlh");
    String Diskon = "";

        
        
    Double iPrice = Double.valueOf(InputPrice);
    Double iTotal = Double.valueOf(InputQTY);
    Double PriceTotal = iPrice * iTotal;
    Double getTotal = null;
    
    if (PriceTotal < 10000)
        {
            getTotal = PriceTotal - (0 * PriceTotal/100);
            Diskon = "0%";
        }
      else if (PriceTotal >= 10000 && PriceTotal < 50000)
        {
            getTotal = PriceTotal - (5 * PriceTotal/100);
            Diskon = "5%";
        }
      else 
        {
            getTotal = PriceTotal - (10 * PriceTotal/100);
            Diskon = "10%";
        }

    Double tDiskon = PriceTotal - getTotal;
    
    discountprocess.addAttribute("nama", InputName);
    discountprocess.addAttribute("harga", InputPrice);
    discountprocess.addAttribute("jlh", InputQTY);
    discountprocess.addAttribute("totald", getTotal);
    discountprocess.addAttribute("Diskon", Diskon);
    discountprocess.addAttribute("tDiskon", tDiskon);
    discountprocess.addAttribute("total", PriceTotal);
    
    return "home";
    }
}
