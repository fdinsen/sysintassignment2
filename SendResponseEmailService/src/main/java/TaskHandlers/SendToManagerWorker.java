package TaskHandlers;

import org.camunda.bpm.client.ExternalTaskClient;

import java.util.logging.Logger;

public class SendToManagerWorker {
    private final static Logger LOGGER = Logger.getLogger(SendToManagerWorker.class.getName());

    public SendToManagerWorker() {
    }

    public void sendToManagerWorker() {
        ExternalTaskClient client = ExternalTaskClient.create()
                .baseUrl("http://localhost:8080/engine-rest")
                .asyncResponseTimeout(10000) // long polling timeout
                .build();

        // subscribe to an external task topic as specified in the process
        // Ved ikke hvad varible i kalder den endnu
        client.subscribe("SendManagerEmail")
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
                    EmailWorker em = new EmailWorker();
                    em.sendMail(email, response);


                    // Complete the task
                    externalTaskService.complete(externalTask);
                })
                .open();
    }
}
