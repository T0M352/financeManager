package tomaszmorgas.financemanager.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tomaszmorgas.financemanager.entity.DateRange;
import tomaszmorgas.financemanager.entity.FullProduct;
import tomaszmorgas.financemanager.entity.Product;
import tomaszmorgas.financemanager.service.ProductService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    ProductService productService;

    @Autowired
    ProductController(ProductService theProductService){
        productService = theProductService;
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("productId") int theId, Model model){
        Product product = productService.findById(theId);

        model.addAttribute("product", product);
        return "products/product-form";
    }

    @GetMapping("/menu")
    public String showMenu(Model model){
        return  "products/menuList";
    }

    @GetMapping("/list")
    public String listOfProducts(Model model){
        List<Product> listOfProducts = productService.findAll();
        List<FullProduct> resultList = new ArrayList<>();
        for(Product product : listOfProducts){
            resultList.add(new FullProduct(product));
        }
        Collections.sort(resultList, Collections.reverseOrder());
        model.addAttribute("products", resultList);

        return  "products/list-products";
    }


    @GetMapping("/showNotShippedYet")
    public String showNotShippedYet(Model model){
        List<Product> listOfProducts = productService.findAll();
        List<FullProduct> resultList = new ArrayList<>();
        for(Product product : listOfProducts){
            if(!product.isShipped())
                resultList.add(new FullProduct(product));
        }
        Collections.sort(resultList, Collections.reverseOrder());
        model.addAttribute("products", resultList);

        return  "products/list-products";
    }

    @GetMapping("/showTimeRangeListForm")
    public String showStatisticsForm(Model model){
        DateRange dateRange = new DateRange();
        model.addAttribute("dateRange", dateRange);
        return "products/statistics-form";
    }

    @GetMapping("/showStatisticTimeForm")
    public String showStatisticTimeForm(Model model){
        DateRange dateRange = new DateRange();
        model.addAttribute("dateRange", dateRange);
        return "products/info-statistics-form";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForADd(Model model){
        Product theProduct = new Product();
        theProduct.setTax(23);
        model.addAttribute("product", theProduct);
        return "products/product-form";
    }

    @PostMapping("/save")
    public String saveProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "products/product-form";
        else{
            productService.save(product);
            return "redirect:/products/list";
        }

    }

    @PostMapping("/showListOfDateRange")
    public String showListOfDateRange(@ModelAttribute("dateRange") DateRange dateRange, Model model){
            List<Product> listOfProducts = productService.findAll();
            List<FullProduct> resultList = new ArrayList<>();
            for(Product product : listOfProducts){
                if(product.getBuyDate().after(dateRange.getStartDate())
                        && product.getBuyDate().before(dateRange.getEndDate()))
                    resultList.add(new FullProduct(product));
            }
            model.addAttribute("products", resultList);
            return "products/list-products";

    }

    @PostMapping("/showStats")
    public String showStats(@ModelAttribute("dateRange") DateRange dateRange, Model model){
            List<Product> listOfProducts = productService.findAll();
            double sumKEaring = 0;
            double sumPrices = 0;
            double sumPricesNetto = 0;
            int count = 0;
            List<FullProduct> resultList = new ArrayList<>();
            for(Product product : listOfProducts){
                if(product.getBuyDate().after(dateRange.getStartDate())
                        && product.getBuyDate().before(dateRange.getEndDate()))
                    resultList.add(new FullProduct(product));
            }
            for(FullProduct pr : resultList){
                sumKEaring += pr.getkEarnings();
                sumPrices += pr.getFullPrice();
                sumPricesNetto += pr.getNettoPrice();
            }
            count = resultList.size();

            sumKEaring = Math.round(sumKEaring * 100.0) / 100.0;
            sumPrices = Math.round(sumPrices * 100.0) / 100.0;
            sumPricesNetto = Math.round(sumPricesNetto * 100.0) / 100.0;


            model.addAttribute("sumKEaring", sumKEaring);
            model.addAttribute("sumPrices", sumPrices);
            model.addAttribute("sumPricesNetto", sumPricesNetto);
            model.addAttribute("count", count);
            model.addAttribute("startDate", dateRange.getStartDate());
            model.addAttribute("endDate", dateRange.getEndDate());



            return "products/show-stats";

        

    }

    @GetMapping("/delete")
    public String delete(@RequestParam("productId") int theId){
        productService.deleteById(theId);
        return "redirect:/products/list";
    }
}
