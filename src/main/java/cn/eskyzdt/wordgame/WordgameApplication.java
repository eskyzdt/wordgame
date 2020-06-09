package cn.eskyzdt.wordgame;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"cn.eskyzdt.wordgame.mapper.*"}) //这里扫描的是dao的接口层
public class WordgameApplication {

    public static void main(String[] args) {
        SpringApplication.run(WordgameApplication.class, args);
    }

}
