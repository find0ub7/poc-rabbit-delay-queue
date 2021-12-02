package poc.rabbit.producer.delay;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/poc/rabbit/messages")
@RequiredArgsConstructor
public class ProducerController {

    private final RabbitProducer rabbitProducer;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void send(@RequestBody String message) {
        rabbitProducer.send(message);
    }
}
