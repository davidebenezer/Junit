package com.luv2code.component;

import com.luv2code.component.models.CollegeStudent;
import com.luv2code.component.models.StudentGrades;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

@SpringBootTest
//@SpringBootTest(classes = MvcTestingExampleApplication.class)
public class ApplicationTest {

    @Autowired
    ApplicationContext context;
    @Autowired
    CollegeStudent collegeStudent;
    @Autowired
    StudentGrades studentGrades;

    @Value("${info.school.name}")
    private String schoolName;
    @Value("${info.app.name}")
    private String appName;
    @Value("${info.app.description}")
    private String appDescription;
    @Value("${info.app.version}")
    private String appVersion;

    public static int counter = 0;

    @BeforeEach
    public void beforeEachTest(){
        ++counter;
        System.out.println("Test\n******* \nschool:" +schoolName+ "\napp: "+ appName+ ", \napp description:"
        +appDescription+"\napp version:"+appVersion+ "\nTotal Test Executions:"+counter);
        collegeStudent.setFirstname("First");
        collegeStudent.setLastname("Last");
        collegeStudent.setEmailAddress("first.last@gmail.com");
        studentGrades.setMathGradeResults(Arrays.asList(100.0, 98.0, 67.0, 87.0));
        collegeStudent.setStudentGrades(studentGrades);
        System.out.println(collegeStudent);
    }
    @Test
    void assertGradeForStudents(){
        assertEquals(352.0, studentGrades.addGradeResultsForSingleClass(studentGrades.getMathGradeResults()));
    }

    @Test
    void compareGrades(){
        assertTrue(studentGrades.isGradeGreater(90, 70), "failure should be true");
        assertFalse(studentGrades.isGradeGreater(85, 90));
    }

    @Test
    void checkNulls(){
        assertNotNull(studentGrades.checkNull(collegeStudent.getStudentGrades().getMathGradeResults()));
    }

    @Test
    void createStudentWithoutGrades(){
        CollegeStudent collegeStudent2 = context.getBean("collegeStudent", CollegeStudent.class);
        collegeStudent2.setFirstname("FirstName2");
        collegeStudent2.setLastname("LastName2");
        collegeStudent2.setEmailAddress("first2last2@gmail.com");
        assertNotNull(collegeStudent2.getFirstname());
        assertNotNull(collegeStudent2.getLastname());
        assertNotNull(collegeStudent2.getEmailAddress());

        //check prototype
        assertNotSame(collegeStudent,collegeStudent2);
        assertNull(collegeStudent2.getStudentGrades());
    }

    @Test
    void testGradePointDetails(){
        assertAll("Testing All ",
                ()-> assertEquals(352, studentGrades.addGradeResultsForSingleClass(
                        collegeStudent.getStudentGrades().getMathGradeResults()
                )),
                ()-> assertEquals(88, studentGrades.findGradePointAverage(
                        collegeStudent.getStudentGrades().getMathGradeResults()
                )));
    }

}

