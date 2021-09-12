package com.spike.processor.config;

import com.spike.common.dto.Domain;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class StreamProcessorConfig {

    @Bean
    public Function<KStream<String, Domain>, KStream<String, Domain>> processDomainStream(){
        return domainKStream -> domainKStream.filter((key, domain) -> !domain.getIsDead());
    }
}
