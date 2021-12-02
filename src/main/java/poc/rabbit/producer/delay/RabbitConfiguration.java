package poc.rabbit.producer.delay;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitConfiguration {

    @Bean
    public TopicExchange esperaExchange() {
        return new TopicExchange("espera-exchange");
    }

    @Bean
    public Queue filaEspera() {
        Map<String, Object> arguments = new HashMap<>();
        arguments.put("x-dead-letter-exchange", "espera-exchange");
        arguments.put("x-dead-letter-routing-key", "fila-consumo.rk");
        arguments.put("x-message-ttl", 10000);

        return QueueBuilder.durable("fila-espera")
                .withArguments(arguments)
                .build();
    }

    @Bean
    public Queue filaConsumo() {
        return QueueBuilder.durable("fila-consumo").build();
    }

    @Bean
    public Binding filaEsperaBinding(final Queue filaEspera, final TopicExchange esperaExchange) {
        return BindingBuilder.bind(filaEspera).to(esperaExchange)
                .with("fila-espera.rk");
    }

    @Bean
    public Binding filaConsumoBinding(final Queue filaConsumo, final TopicExchange esperaExchange) {
        return BindingBuilder.bind(filaConsumo).to(esperaExchange)
                .with("fila-consumo.rk");
    }
}
