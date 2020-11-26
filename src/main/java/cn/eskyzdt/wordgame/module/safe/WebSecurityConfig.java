//package cn.eskyzdt.wordgame.module.safe;
//
//import cn.eskyzdt.wordgame.module.utils.encrypt.EncryptUtil;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@EnableWebSecurity
//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
///*    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password(passwordEncoder().encode("admin"))
//                .roles("admin");
//    }*/
//
//    @Override
//    public void configure(WebSecurity web) {
//        web.ignoring().antMatchers("/webjars/**/*", "/**/*.css", "/**/*.js","/index.html");
//    }
//
//    // 注入密码加密器
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new EncryptUtil();
//    }
//}
