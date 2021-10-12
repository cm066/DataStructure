package com.cm;

import com.cm.entity.Course;
import com.cm.mapper.CourseMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingJdbcApplicationTest {

    @Autowired
    private CourseMapper courseMapper;
    @Test
    public void test1(){
        Course course = new Course();
        course.setCname("java");
        course.setUserId(100L);
        course.setCstatus("normal");
        courseMapper.insert(course);
    }
}
