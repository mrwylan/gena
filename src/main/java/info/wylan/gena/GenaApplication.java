package info.wylan.gena;

import com.vaadin.flow.component.page.AppShellConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.vaadin.flow.theme.Theme;

@SpringBootApplication
@Theme("gena")
public class GenaApplication implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(GenaApplication.class, args);
    }
}
