package software.ulpgc.kata5;

import spark.Spark;

public class Main {
    public static void main(String[] args) {
        CommandExecutor.add("isNarcissistic", new IsNarcissisticCommand());
        Spark.port(8080);
        Spark.get("/isNarcissistic", ((request, response) -> CommandExecutor.with(request, response).execute("isNarcissistic")));

    }
}
