package org.example.clztoolsconsole;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.example.clztoolsconsole.**.mapper")
public class ClztoolsConsoleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClztoolsConsoleApplication.class, args);
    }

}
