package edu.hhu.xulifeng.microvideo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableAsync
@EnableWebMvc
@EnableCaching
@SpringBootApplication
@EnableTransactionManagement
public class MicroVideoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroVideoApplication.class, args);
    }

}
