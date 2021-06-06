package com.prepare.employee;

import com.prepare.employee.DataBaseConnection.EmployeeEntity;
import com.prepare.employee.Exceptions.CustomExceptions;
import com.prepare.employee.Repositories.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class EmployeeRepositoryTest {
    @Autowired
    EmployeeRepository employeeRepository;
//@DirtiesContext
    @Test
    @Transactional //This will ensure that the changes made during the test gets rolled back
    public void test1() {
        //Builder
        EmployeeEntity employeeEntity = EmployeeEntity.builder()
                .name("Prakhar")
                .address("Basti")
                .departmentId(9)
                .managerId(60)
                .salary(3000000)
                .build();
        EmployeeEntity response = employeeRepository.save(employeeEntity);
        EmployeeEntity response2 = employeeRepository.findById(response.getId()).orElseThrow(()->new CustomExceptions("Nhi mila"));
        assertEquals(response.getName(),response2.getName(),"Response Id not same");
    }


}
