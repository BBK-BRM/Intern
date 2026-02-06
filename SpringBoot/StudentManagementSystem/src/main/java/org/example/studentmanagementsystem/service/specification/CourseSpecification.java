package org.example.studentmanagementsystem.service.specification;

import org.example.studentmanagementsystem.entity.CourseEntity;
import org.example.studentmanagementsystem.payload.request.CourseDataRequest;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

public class CourseSpecification {
    public static Specification<CourseEntity> courseFilter(CourseDataRequest request){
        return (root, query, criteriaBuilder) ->{
            if (Objects.nonNull(request.getSearchText())) {
                return criteriaBuilder.equal(root.get("courseName"),request.getSearchText());
            }
            return null;
        };
    }
}