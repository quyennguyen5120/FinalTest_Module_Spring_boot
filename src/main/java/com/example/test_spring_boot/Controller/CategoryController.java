package com.example.test_spring_boot.Controller;

import com.example.test_spring_boot.Dto.CategoryDto;
import com.example.test_spring_boot.Entity.CategoryEntity;
import com.example.test_spring_boot.Repository.CategoryRepository;
import com.example.test_spring_boot.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryService categoryService;

    @Secured({"ROLE_ADMIN"})
    @GetMapping("/index")
    public String categoryIndex(Model model, HttpServletRequest request){
        List<CategoryDto> categoryEntities = categoryRepository.getAllDto();
        model.addAttribute("Categories", categoryEntities);
        model.addAttribute("categoryDto", new CategoryDto());
        HttpSession session = request.getSession();
        String uzxc = session.getAttribute("nameUser").toString();
        model.addAttribute("nameUser", uzxc);
        return "view_admin/category/index";
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping("/create_update_category")
    public String createCategory(CategoryDto dto){
        categoryService.createOrUpdate(dto);
        return "redirect:/category/index";
    }
    @Secured({"ROLE_ADMIN"})
    @GetMapping("/remove_cateogry/{id}")
    public String removeCategory(@PathVariable("id") Long id){
        if(id != null)
            categoryRepository.deleteById(id);
        return "redirect:/category/index";
    }
    @Secured({"ROLE_ADMIN"})
    @GetMapping("/category_detail/{id}")
    public String getCategory(@PathVariable("id") Long id, Model model){
        CategoryEntity category = categoryRepository.findById(id).get();
        model.addAttribute("categoryDto", new CategoryDto(category));
        return "view_admin/category/categoryDetail";
    }
}
