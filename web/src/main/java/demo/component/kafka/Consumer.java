package demo.component.kafka;

import demo.component.kafka.config.KafkaConfig;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @KafkaListener(id = KafkaConfig.EVENT_TOPIC_GROUP, topics = {KafkaConfig.EVENT_TOPIC})
    public void receiveEvent(Bar bar) {
        System.out.println(bar.getBrand());
    }

    @KafkaListener(id = KafkaConfig.WORK_DATA_TOPIC_GROUP, topics = {KafkaConfig.WORK_DATA_TOPIC})
    public void receiveEnergy(Bar bar) {
        System.out.println(bar.getBrand());
    }
}
