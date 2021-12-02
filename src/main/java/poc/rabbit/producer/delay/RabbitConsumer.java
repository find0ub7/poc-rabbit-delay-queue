package poc.rabbit.producer.delay;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class RabbitConsumer {

    @RabbitListener(queues = {"fila-consumo"})
    public void onMessage(String message) {
        log.info("Mensagem consumida: " + message);
    }
}
