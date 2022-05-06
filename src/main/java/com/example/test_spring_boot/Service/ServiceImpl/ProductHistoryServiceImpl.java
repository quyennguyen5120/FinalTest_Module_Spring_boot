package com.example.test_spring_boot.Service.ServiceImpl;

import com.example.test_spring_boot.Dto.ProductDto;
import com.example.test_spring_boot.Dto.ProductHistoryDto;
import com.example.test_spring_boot.Dto.SearchDto.SearchReportDto;
import com.example.test_spring_boot.Repository.ProductHistoryRepostiory;
import com.example.test_spring_boot.Service.ProductHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ProductHistoryServiceImpl implements ProductHistoryService {

    @Autowired
    ProductHistoryRepostiory productHistoryRepostioryl;

    @Autowired
    EntityManager manager;


    @Override
    public List<ProductHistoryDto> getBySearch(SearchReportDto searchDto) throws ParseException {
        int pageIndex = searchDto.getPageIndex();
//        int pageSize = searchDto.getPageSize();
        int pageSize = 999999;
        if (pageIndex > 0)
            pageIndex = pageIndex - 1;
        else
            pageIndex = 0;

        String sql = "select new com.example.test_spring_boot.Dto.ProductHistoryDto(p) from ProductHistory p where (1=1)";
        String whereClause = "";

        if (searchDto.getCategoryId() != null && searchDto.getCategoryId() > 0) {
            whereClause += " and p.productEntity.categoryEntity.id =:categoryId ";
        }
        if(searchDto.getRating() != null && searchDto.getRating()>0){
            whereClause += " and p.productEntity.reviewEntity.rating =:rating ";
        }
        if(searchDto.getLstCategory() != null && searchDto.getLstCategory().size()>0){
            whereClause += " and p.productEntity.categoryEntity.id in :lstCategory ";
        }
        if(searchDto.getLstStar() != null && searchDto.getLstStar().size()>0){
            whereClause += " and p.productEntity.reviewEntity.rating in :lstStar ";
        }
        if(searchDto.getTextSearch() != null && searchDto.getTextSearch() != ""){
            whereClause += " and p.userEntity.fullname LIKE :textSearch ";
        }
        if(searchDto.getFromDate() != null && searchDto.getFromDate() != ""){
            whereClause += " and p.CreateDate >= :fromDate ";
        }
        if(searchDto.getToDate() != null && searchDto.getToDate() != ""){
            whereClause += " and p.CreateDate <= :toDate ";
        }

        sql += whereClause;
        Query q = manager.createQuery(sql, ProductHistoryDto.class);

        if (searchDto.getCategoryId() != null && searchDto.getCategoryId() > 0) {
            q.setParameter("categoryId", searchDto.getCategoryId());
        }
        if(searchDto.getRating() != null && searchDto.getRating()>0){
            q.setParameter("rating", searchDto.getRating());
        }
        if(searchDto.getLstCategory() != null && searchDto.getLstCategory().size()>0){
            q.setParameter("lstCategory", searchDto.getLstCategory());
        }
        if(searchDto.getLstStar() != null && searchDto.getLstStar().size()>0){
            q.setParameter("lstStar", searchDto.getLstStar());
        }
        if(searchDto.getTextSearch() != null && searchDto.getTextSearch() != ""){
            q.setParameter("textSearch", "%"+searchDto.getTextSearch()+"%");
        }
        if(searchDto.getFromDate() != null && searchDto.getFromDate() != ""){
            String format = "yyyy-MM-dd HH:mm";
            SimpleDateFormat df = new SimpleDateFormat(format);
            Date from = df.parse(searchDto.getFromDate().replace("T", " "));
            q.setParameter("fromDate", from);
        }
        if(searchDto.getToDate() != null && searchDto.getToDate() != ""){
            String format = "yyyy-MM-dd HH:mm";
            SimpleDateFormat df = new SimpleDateFormat(format);
            Date to = df.parse(searchDto.getToDate().replace("T", " "));
            q.setParameter("toDate", to);
        }

        q.setFirstResult((pageIndex) * pageSize);
        q.setMaxResults(pageSize);

        List<ProductHistoryDto> lstProduct = q.getResultList();
        return lstProduct;
    }
}
