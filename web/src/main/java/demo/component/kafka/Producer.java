package demo.component.kafka;

import demo.component.kafka.config.KafkaConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Producer {

    @Autowired
    private KafkaTemplate<Object, Object> template;

    @PostMapping("sendEvent")
    public void sendMessage(@RequestBody Bar bar) {
        template.send(KafkaConfig.EVENT_TOPIC, bar);
    }

    @PostMapping("sendEnergy")
    public void sendEnergy(@RequestBody Bar bar) {
        template.send(KafkaConfig.WORK_DATA_TOPIC, bar);
    }
}
