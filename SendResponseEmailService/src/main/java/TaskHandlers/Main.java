package TaskHandlers;

public class Main {


    public static void main(String[] args) {

        SendResponseWorker sw = new SendResponseWorker();
        SendToManagerWorker sm = new SendToManagerWorker();

        sw.sendResponseWorker();
        sm.sendToManagerWorker();




    }
}
