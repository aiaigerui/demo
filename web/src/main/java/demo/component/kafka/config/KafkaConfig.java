package demo.component.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.SeekToCurrentErrorHandler;
import org.springframework.kafka.support.converter.RecordMessageConverter;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.util.backoff.FixedBackOff;

@Configuration
public class KafkaConfig {

    public static final String EVENT_TOPIC_GROUP = "eventGroup";
    public static final String EVENT_TOPIC = "event";

    public static final String ENERGY_TOPIC_GROUP = "energyGroup";
    public static final String ENERGY_TOPIC = "energy";

    @Bean
    public NewTopic event() {
        return new NewTopic(EVENT_TOPIC, 2, (short) 2);
    }

    @Bean
    public NewTopic energy() {
        return new NewTopic(ENERGY_TOPIC, 2, (short) 2);
    }

    @Bean
    public SeekToCurrentErrorHandler errorHandler(KafkaTemplate<Object, Object> template) {
        return new SeekToCurrentErrorHandler(
                new DeadLetterPublishingRecoverer(template), new FixedBackOff(1000L, 2));
    }

    @Bean
    public RecordMessageConverter converter() {
        return new StringJsonMessageConverter();
    }
}
