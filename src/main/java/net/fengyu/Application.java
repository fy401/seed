package net.fengyu;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class Application
{
    public static void main( String[] args )
    {
        SpringApplication application = new SpringApplication(Application.class);

        application.setBannerMode(Banner.Mode.CONSOLE);

        application.run(args);
    }
}
