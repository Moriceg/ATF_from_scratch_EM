package com.atf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.atf")
@EnableTransactionManagement(proxyTargetClass = true)
public class AppConfig {

}
