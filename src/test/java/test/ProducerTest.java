package test;

import com.dmtrk.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dm on 12/29/17.
 */
public class ProducerTest {
    private static final Logger LOG = LoggerFactory.getLogger(ProducerTest.class);

    public static void main(String[] args) {
        List<Producer> producers = new ArrayList<>();
        try{
            producers.add(new Producer("Producer"+producers.size()));
            producers.add(new Producer("Producer"+producers.size()));
            //
            producers.forEach(Producer::start);


            for(int i=0; i<20; i++){
                Thread.sleep(5000);
            }

        }catch(Throwable t){
            LOG.error(t.getMessage(),t);
        }finally {
            producers.forEach(Producer::shutdown);
        }
    }
}
