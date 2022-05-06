package com.example.test_spring_boot.Service;

import com.example.test_spring_boot.Dto.ProductHistoryDto;
import com.example.test_spring_boot.Dto.SearchDto.SearchReportDto;
import com.example.test_spring_boot.Entity.ProductHistory;

import java.text.ParseException;
import java.util.List;

public interface ProductHistoryService {

    List<ProductHistoryDto> getBySearch(SearchReportDto searchReportDto) throws ParseException;
}
