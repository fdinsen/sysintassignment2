package TaskHandlers;
import java.util.logging.Logger;
import org.camunda.bpm.client.ExternalTaskClient;
public class SendResponseWorker {
    private final static Logger LOGGER = Logger.getLogger(SendResponseWorker.class.getName());

    public static void main(String[] args) {
        ExternalTaskClient client = ExternalTaskClient.create()
                .baseUrl("http://localhost:8080/engine-rest")
                .asyncResponseTimeout(10000) // long polling timeout
                .build();

        // subscribe to an external task topic as specified in the process
        client.subscribe("SendResponseEmail")
                .lockDuration(1000) // the default lock duration is 20 seconds, but you can override this
                .handler((externalTask, externalTaskService) -> {
                    // Put your business logic here

                    // Get a process variable
                    String response = externalTask.getVariable("response");
                    String email = externalTask.getVariable("email");

                    System.out.println("ASNFOJASBNFPOIASPIFA");
                    LOGGER.info("RESPONSE: " + response);
                    LOGGER.info("EMAIL: " + email);

                    //TODO SEND EMAIL

                    // Complete the task
                    externalTaskService.complete(externalTask);
                })
                .open();
    }
}
