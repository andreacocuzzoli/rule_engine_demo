package com.loyalty.Reward.configuration;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;

import java.io.IOException;
import java.util.Arrays;

@Configuration
public class DroolsConfiguration {
    //private static final String drlFile = "rules/PROMO_RULE.drl";
    private ResourceLoader resourceLoader;
    Logger logger = LoggerFactory.getLogger(DroolsConfiguration.class);

    private final KieServices kieServices = KieServices.Factory.get();

    @Bean
    public KieContainer getKieContainer() throws IOException {
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        Resource[] rulesList = ResourcePatternUtils.getResourcePatternResolver(resourceLoader).getResources("classpath*:/rules/*.drl");
        Arrays.stream(rulesList).forEach(x -> {
            try {
                 kieFileSystem.write(ResourceFactory.newFileResource(x.getFile()));
                 logger.info("Loaded rule {}",x.getFilename());
            } catch (IOException e) {
                logger.error("Error loading rule {}",x.getFilename());
                e.printStackTrace();
            }
        });
        KieBuilder kb = kieServices.newKieBuilder(kieFileSystem);
        kb.buildAll();
        KieModule kieModule = kb.getKieModule();
        return kieServices.newKieContainer(kieModule.getReleaseId());
    }
}