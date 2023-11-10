package com.wsms.schools.repository;

import com.wsms.schools.entity.AccountBalance;
import com.wsms.schools.constant.StudentClassConstant;
import com.wsms.schools.dto.response.SchoolApiErrorResponse;
import com.wsms.schools.entity.Student;
import com.wsms.schools.enums.SchoolError;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class RepositoryService implements RepositoryServiceI {
    private final StudentRepository studentRepository;
    private final AccountRepository accountRepository;

    @Override
    public Either<SchoolApiErrorResponse, List<Student>> getStudents(String assignedClass) {
        var response = studentRepository.findByEntryClassAssigned(assignedClass);
        if (response.isEmpty()) {
            return Either.left(StudentClassConstant.getSchoolApiErrorResponse(
                    SchoolError.CLASS_EMPTY_ERROR.getDescription(),
                    SchoolError.CLASS_EMPTY_ERROR.getCode(), "class has no students or wrong class parameters was supplied"));
        }
        return Either.right(response);
    }

    @Override
    public String getStudentBalance(String id) {
        var balance = accountRepository.findById(id).map(AccountBalance::getBalance);
        if (balance.isPresent()) {
            return String.valueOf(balance.get());
        }
        return "processing error";
    }
}
