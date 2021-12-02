package poc.rabbit.producer.delay;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RabbitProducer {

    private final RabbitMessagingTemplate rabbitTemplate;

    public void send(final String message) {
        log.info("Enviando mensagem para fila: " + message);
        rabbitTemplate.convertAndSend("espera-exchange", "fila-espera.rk", message);
    }
}
