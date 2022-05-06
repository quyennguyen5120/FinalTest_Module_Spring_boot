package com.example.test_spring_boot.Service.ServiceImpl;

import com.example.test_spring_boot.Configuration.Security.UserDetailCustom;
import com.example.test_spring_boot.Dto.Func.ProductRating;
import com.example.test_spring_boot.Dto.Func.ReivewUserDto;
import com.example.test_spring_boot.Entity.PostEntity;
import com.example.test_spring_boot.Entity.ProductEntity;
import com.example.test_spring_boot.Entity.ReviewEntity;
import com.example.test_spring_boot.Entity.UserEntity;
import com.example.test_spring_boot.Repository.PostRepository;
import com.example.test_spring_boot.Repository.ProductRepository;
import com.example.test_spring_boot.Repository.ReviewRepository;
import com.example.test_spring_boot.Repository.UserRepository;
import com.example.test_spring_boot.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;


    @Override
    public void rating(ProductRating productRating) {
        for (Long idProduct : productRating.getIdProduct()){
            ProductEntity productEntity = productRepository.getById(idProduct);
            Integer ratingProduct = 0;
            if(productEntity.getReviewEntity() == null){
                ReviewEntity reviewEntity = new ReviewEntity();
                reviewEntity.setRating(productRating.getRate());
                productEntity.setReviewEntity(reviewEntity);
            }else{
                productEntity.getReviewEntity().setRating((ratingProduct + productRating.getRate()) / 2);
            }
            productRepository.save(productEntity);
        }
    }

    @Override
    public void postReview(ReivewUserDto reivewUserDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String roleA = authentication.getPrincipal().toString();
        if(roleA.equals("anonymousUser")){
            ProductEntity p = productRepository.getById(reivewUserDto.getIdProduct());
            ReviewEntity reviewEntity = p.getReviewEntity();
            if(reviewEntity == null){
                reviewEntity = new ReviewEntity();
                reviewEntity.setRating(0);
                p.setReviewEntity(reviewEntity);
                p = productRepository.save(p);
            }
            UserEntity userEntity = new UserEntity();
            userEntity.setFullname(reivewUserDto.getFullname());
            userEntity.setEmail(reivewUserDto.getEmail());
            userEntity = userRepository.save(userEntity);

            PostEntity postEntity = new PostEntity();
            postEntity.setContent(reivewUserDto.getContent());
            postEntity.setUserEntity(userEntity);
            postEntity.setReviewEntity(p.getReviewEntity());
            postRepository.save(postEntity);
        }
        if(!roleA.equals("anonymousUser")){
            UserDetailCustom ud =(UserDetailCustom) authentication.getPrincipal();
            ProductEntity p = productRepository.getById(reivewUserDto.getIdProduct());
            ReviewEntity reviewEntity = p.getReviewEntity();
            if(reviewEntity == null){
                reviewEntity = new ReviewEntity();
                reviewEntity.setRating(0);
                p.setReviewEntity(reviewEntity);
                p = productRepository.save(p);
            }
            UserEntity userEntity = userRepository.getByUsername(ud.getUsername());

            PostEntity postEntity = new PostEntity();
            postEntity.setContent(reivewUserDto.getContent());
            postEntity.setUserEntity(userEntity);
            postEntity.setReviewEntity(p.getReviewEntity());
            postRepository.save(postEntity);
        }
    }
}
