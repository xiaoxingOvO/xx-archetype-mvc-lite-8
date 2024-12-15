#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;

/**
 * 启动类
 */
@SpringBootApplication
public class Application {

    private static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main( String[] args ) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        Environment env         = applicationContext.getEnvironment();
        logAppStartUp(env);
    }

    /**
     * 打印启动地址
     */
    private static void logAppStartUp(Environment env) {

        String name = Optional.ofNullable(env.getProperty("spring.application.name"))
            .orElse("");

        String protocol = Optional.ofNullable(env.getProperty("server.ssl.key-store")).map(key -> "https").orElse("http");

        String port = Optional.ofNullable(env.getProperty("server.port")).orElse("8080");

        String path = Optional
            .ofNullable(env.getProperty("server.servlet.context-path"))
            .filter(StringUtils::isNotBlank)
            .orElse("/");

        String ip = "localhost";
        try {
            ip = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            logger.warn("hostAddress 获取失败, 默认使用 localhost");
        }
        logger.info(
            "${symbol_escape}n"+"----------------------------------------------------------"+"${symbol_escape}n"+
                "${symbol_escape}tApplication {} is running! Access URLs:"+"${symbol_escape}n"+
                "${symbol_escape}tLocal: ${symbol_escape}t${symbol_escape}t{}://localhost:{}{}"+"${symbol_escape}n"+
                "${symbol_escape}tExternal: ${symbol_escape}t{}://{}:{}{}"+"${symbol_escape}n"+
                "${symbol_escape}tDocs: ${symbol_escape}t${symbol_escape}t{}://{}:{}{}{}"+"${symbol_escape}n"+
                "${symbol_escape}tProfile(s): ${symbol_escape}t{}"+"${symbol_escape}n"+
                "----------------------------------------------------------",
            name,
            protocol, port, path,
            protocol, ip, port, path,
            protocol, ip, port, path,"doc.html",
            env.getActiveProfiles().length == 0
                ? env.getDefaultProfiles()
                : env.getActiveProfiles()
        );
    }
}
