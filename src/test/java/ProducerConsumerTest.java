import com.effort.demo.jms.ProduceService;
import com.effort.demo.thirdapi.ApiServices;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.IOException;
import java.util.function.Function;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:applicationContext.xml")
public class ProducerConsumerTest {

    @Autowired
    private ProduceService produceServiceImpl;
    @Autowired
    private ProduceService produceServiceImpl2;
    @Autowired
    private ProduceService produceServiceImplTopic;

    @Test
    public void testSessionAwareMessageListener() {
        produceServiceImpl2.sendMessage("good morning");
    }

    @Test
    public void testGeneralMessageListener() {
        produceServiceImpl.sendMessage("ni hao");
    }

    @Test
    public void tsestTopicMessageListener() {
        produceServiceImplTopic.sendMessage("topic queue");
    }

    @Test
    public void testLamab() {
        Function<Integer, Integer> f1 = i -> i + 1;
        System.out.println(f1.apply(1));

        System.out.println();
    }

    @Test
    public void testSdk() throws IOException {
        JSONObject object = new JSONObject();
        object.put("name", "8986031749203068295");

        Object o = ApiServices.updateStation(object);
        System.out.println(o);
    }
}