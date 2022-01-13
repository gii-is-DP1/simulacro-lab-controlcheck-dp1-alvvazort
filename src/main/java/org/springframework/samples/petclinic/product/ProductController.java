package org.springframework.samples.petclinic.product;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
    private static final String VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM = "products/createOrUpdateProductForm";

    @Autowired
    ProductService productService;

    
    
    @GetMapping(path = "/create")
	public String initCreationForm(Product product, ModelMap model) {
		model.put("productType", productService.getAllProductTypes());
        model.put("product", new Product());
		return VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM;
	}
    @PostMapping(path = "/create")
	public String processCreationForm(@Valid Product product, BindingResult result, ModelMap model) {		
		if (result.hasErrors()) {
			model.put("product", product);
            model.put("types", productService.getAllProductTypes());
			return "welcome";
		}
		else {
            productService.save(product);
            model.put("message", "Product succesfully saved");
            return "welcome";
		}
	}
}
