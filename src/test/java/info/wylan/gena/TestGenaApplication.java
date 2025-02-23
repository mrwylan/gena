package info.wylan.gena;

import org.springframework.boot.SpringApplication;

public class TestGenaApplication {

    public static void main(String[] args) {
        SpringApplication.from(GenaApplication::main).with(TestcontainersConfiguration.class).run(args);
    }
}
