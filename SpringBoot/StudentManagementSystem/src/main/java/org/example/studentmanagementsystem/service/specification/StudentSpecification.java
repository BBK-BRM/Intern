package org.example.studentmanagementsystem.service.specification;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.criteria.Predicate;
import org.example.studentmanagementsystem.entity.StudentEntity;
import org.example.studentmanagementsystem.payload.request.StudentDataRequest;
import org.springframework.data.jpa.domain.Specification;

public class StudentSpecification {
    public static Specification<StudentEntity> studentFilter(StudentDataRequest request){
        return ((root, query, criteriaBuilder) -> {
            Predicate finalPredicate = criteriaBuilder.conjunction();

            if (StringUtils.isNotBlank(request.getSearchText())) {
                Predicate searchTextPredicate = criteriaBuilder.or(
                        criteriaBuilder.like(criteriaBuilder.lower(root
                                .get("studentName")), likePattern(request.getSearchText()
                                .toLowerCase())));
                finalPredicate = criteriaBuilder.and(finalPredicate, searchTextPredicate);
            }
            return finalPredicate;
        });
    }
    private static String likePattern (String text){
        return "%"+text+"%";
    }
}
