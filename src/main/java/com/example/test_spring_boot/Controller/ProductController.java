package com.example.test_spring_boot.Controller;

import com.example.test_spring_boot.Configuration.Oauth2.CustomOauth2User;
import com.example.test_spring_boot.Configuration.Security.UserDetailCustom;
import com.example.test_spring_boot.Dto.CartDto;
import com.example.test_spring_boot.Dto.CategoryDto;
import com.example.test_spring_boot.Dto.ProductDto;
import com.example.test_spring_boot.Dto.SearchDto.SearchReportDto;
import com.example.test_spring_boot.Entity.ProductEntity;
import com.example.test_spring_boot.Entity.ProductHistory;
import com.example.test_spring_boot.Entity.UserEntity;
import com.example.test_spring_boot.Repository.*;
import com.example.test_spring_boot.Service.MailService;
import com.example.test_spring_boot.Service.ProductHistoryService;
import com.example.test_spring_boot.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    MailService mailService;

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductHistoryRepostiory productHistoryRepostiory;

    @Autowired
    ProductHistoryService productHistoryService;

    @Secured({"ROLE_ADMIN"})
    @GetMapping("/index")
    public String productAdmin(Model model, HttpServletRequest request){
        model.addAttribute("lstProduct", productService.getByPage(0,10));
        model.addAttribute("categories", categoryRepository.getAllDto());
        model.addAttribute("productDto", new ProductDto());

        HttpSession session = request.getSession();
        String uzxc = session.getAttribute("nameUser").toString();
        model.addAttribute("nameUser", uzxc);
        return "view_admin/product/index";
    }
    @Secured({"ROLE_ADMIN"})
    @GetMapping("/product_detail/{id}")
    public String getProduct(Model model, @PathVariable("id") Long id, HttpServletRequest request){
        ProductDto getProduct = productRepository.getDtoById(id);
        if(getProduct == null){
            return "redirect:/product/index";
        }
        model.addAttribute("product",getProduct);
        List<CategoryDto> lstCategory = categoryRepository.getAllDto();
        model.addAttribute("categories",lstCategory);
        HttpSession session = request.getSession();
        String uzxc = session.getAttribute("nameUser").toString();
        model.addAttribute("nameUser", uzxc);
        return "view_admin/product/productDetail";
    }
    @Secured({"ROLE_ADMIN"})
    @PostMapping("/create_update_product")
    public String addUpdateProduct(ProductDto dto) throws IOException {
        productService.createOrUpdate(dto);
        return "redirect:/product/index";
    }

    @Secured({"ROLE_ADMIN"})
    @GetMapping("/remove_product/{id}")
    public String removeProduct(@PathVariable("id") Long id){
        productRepository.deleteById(id);
        return "redirect:/product/index";
    }

    @Secured({"ROLE_ADMIN"})
    @GetMapping("/report")
    public String redirectReport(Model model, HttpServletRequest request){
        model.addAttribute("categories", categoryRepository.getAllDto());
        HttpSession session = request.getSession();
        String uzxc = session.getAttribute("nameUser").toString();
        model.addAttribute("nameUser", uzxc);
        return "view_admin/report/index";
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping("/search_report_product")
    public ResponseEntity<?> reportProduct(Model model, SearchReportDto searchReportDto) throws ParseException {
        return ResponseEntity.ok(productHistoryService.getBySearch(searchReportDto));
    }

    //Admin and user
    @PostMapping("/search_report")
    public ResponseEntity<?> searchReport(Model model, SearchReportDto searchReportDto){
        return ResponseEntity.ok(productService.searchByDto(searchReportDto));
    }
    @PostMapping("/search_report_by_page")
    public ResponseEntity<?> searchReportByPage(Model model, SearchReportDto searchReportDto){
        return ResponseEntity.ok(productService.searchPageByDto(searchReportDto));
    }

///////////////////////////////////////Usser
    @GetMapping("/index_user")
    public String userIndex(Model model, HttpServletRequest request){
        model.addAttribute("categories", categoryRepository.getAllDto());
        HttpSession session = request.getSession();
        String uzxc = null;
        try{
            uzxc = session.getAttribute("nameUser").toString();
        }
        catch (Exception e){
            uzxc = null;
        }

        model.addAttribute("nameUser", uzxc);
        return "view_user/index";
    }

    @PostMapping("/add_cart/{id}")
    public ResponseEntity<?> addToCart(@PathVariable("id")Long id, HttpServletRequest request, CartDto cartDto){
        HttpSession session = request.getSession();
        List<CartDto> lstProduct = (List<CartDto>) session.getAttribute("cart");
        CartDto cartDto1 = null;
        if(lstProduct == null){
            lstProduct = new ArrayList<>();
            if(cartDto.getIdProduct() == null && cartDto.getTotalItem() == null){
                cartDto1 = new CartDto(id, 1);
                lstProduct.add(cartDto1);
            }
            else{
                lstProduct.add(cartDto);
            }

        }
        else{
            if(cartDto != null && cartDto.getTotalItem() != null && cartDto.getIdProduct() != null){
                cartDto1 = lstProduct.stream().filter(x->x.getIdProduct() == cartDto.getIdProduct()).findFirst().orElse(null);
                if(cartDto1 != null){
                    cartDto1.setTotalItem(cartDto1.getTotalItem() + cartDto.getTotalItem());
                }
                else {
                    cartDto1 = new CartDto(cartDto.getIdProduct(), cartDto.getTotalItem());
                    lstProduct.add(cartDto1);
                }
            }
            else{
                cartDto1 = lstProduct.stream().filter(x->x.getIdProduct() == id).findFirst().orElse(null);
                if(cartDto1 != null){
                    cartDto1.setTotalItem(cartDto1.getTotalItem() + 1);
                }
                else {
                    cartDto1 = new CartDto(id, 1);
                    lstProduct.add(cartDto1);
                }
            }
        }
        session.setAttribute("cart", lstProduct);
        return ResponseEntity.ok(true);
    }
    @GetMapping("/cart")
    public String gotoCart(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        List<CartDto> lstCart= (List<CartDto>) session.getAttribute("cart");
        List<ProductDto> lstProductDto = productService.getProductByCartDto(lstCart);
        model.addAttribute("lstProduct",lstProductDto);
        Double sumPrice = lstProductDto.stream().mapToDouble(o -> o.getPrice()).sum();
        model.addAttribute("sumPrice",sumPrice + 5D);
        return "view_user/cart";
    }
    @GetMapping("/product_detail_user/{id}")
    public String getProductByUser(Model model, @PathVariable("id") Long id, HttpServletRequest request){
        ProductDto getProduct = productRepository.getDtoById(id);
        if(getProduct == null){
            return "redirect:/product/index_user";
        }
        model.addAttribute("product",getProduct);
        List<CategoryDto> lstCategory = categoryRepository.getAllDto();
        model.addAttribute("categories",lstCategory);
        model.addAttribute("rate", getProduct.getRating());
        if(getProduct.getReviewDto() != null && getProduct.getReviewDto().getId() != null)
            model.addAttribute("posts", postRepository.getDtoByReviewId(getProduct.getReviewDto().getId()));
        HttpSession session = request.getSession();
        String uzxc = null;
        try{
            uzxc = session.getAttribute("nameUser").toString();
        }
        catch (Exception e){
            uzxc = null;
        }
        model.addAttribute("nameUser", uzxc);
        return "view_user/productDetail";
    }
    @GetMapping("/pay")
    public String pay(HttpServletRequest request, Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication.getPrincipal().toString() == "anonymousUser")
            return "payError";
        else{
            HttpSession session = request.getSession();
            List<CartDto> lstCart =(List<CartDto>) session.getAttribute("cart");
            CustomOauth2User oAuth2User = null;
            UserDetailCustom userDetailsCustom = null;
            String email = "";
            try{
                userDetailsCustom = (UserDetailCustom) authentication.getPrincipal();
                email = userDetailsCustom.getUsername();
            }
            catch (Exception e){
                if(userDetailsCustom == null){
                    oAuth2User = (CustomOauth2User) authentication.getPrincipal();
                    email = oAuth2User.getAttribute("email");
                }
            }
            UserEntity userEntity = userRepository.getByUsername(userDetailsCustom.getUsername());
            mailService.sendMail(userEntity.getEmail(), "Thanh toán thành công!!!",null,null,null,lstCart);
            List<Long> lstLong = new ArrayList<>();
            ProductHistory productHistory = null;
            for (CartDto cartDto : lstCart){
                ProductEntity p = productRepository.getById(cartDto.getIdProduct());
                productHistory = new ProductHistory();
                productHistory.setUserEntity(userEntity);
                productHistory.setProductEntity(p);
                productHistory.setTotalItem(cartDto.getTotalItem());
                productHistoryRepostiory.save(productHistory);
                lstLong.add(cartDto.getIdProduct());
            }
            model.addAttribute("idProducts", lstLong);
            session.setAttribute("cart", null);
            return "paySuccess";
        }
    }




}
