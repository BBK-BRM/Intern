package org.example.studentmanagementsystem.service.specification;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.criteria.Predicate;
import org.example.studentmanagementsystem.entity.CourseEntity;
import org.example.studentmanagementsystem.payload.request.CourseDataRequest;
import org.springframework.data.jpa.domain.Specification;

public class CourseSpecification {
    public static Specification<CourseEntity> courseFilter(CourseDataRequest request){
        return (root, query, criteriaBuilder) ->{

            Predicate finalPredicate = criteriaBuilder.conjunction();

            if (StringUtils.isNotBlank(request.getSearchText())) {
                 Predicate searchPredicate = criteriaBuilder.or(
                         criteriaBuilder.like(
                                 criteriaBuilder.lower(root.get("courseName")),"%"+request.getSearchText().toLowerCase()+"%")
                 );
                 finalPredicate = criteriaBuilder.and(finalPredicate,searchPredicate);
            }

            return finalPredicate;
        };
    }
}