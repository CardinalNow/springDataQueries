package com.csg.springdata.config;

import com.csg.springdata.SpringDataApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by rogerbowman on 11/9/15.
 */
@Configuration
@SpringApplicationConfiguration(classes = {SpringDataApplication.class })
public class TestConfig {

}
