package com.sinvay.boot.response.options.autoload;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * TODO
 *
 * @author pizzalord
 * @since 1.0
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "sinvay.response")
public class OptionsConfig {
    private List<AutoOption> options;
}
