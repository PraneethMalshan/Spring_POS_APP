package lk.ijse.spring.config;

import lk.ijse.spring.advisor.AppWideExceptionHansler;
import lk.ijse.spring.controller.CustomerController;
import lk.ijse.spring.controller.ItemController;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = {CustomerController.class, ItemController.class, AppWideExceptionHansler.class})
public class WebAppConfig {

  /*  @Bean
    public ModelMapper modelMapper (){

        return new ModelMapper();
    }*/ //Dn meeka ayithi naha meyaata . meeka gihin daanawa web root config ekata

}
