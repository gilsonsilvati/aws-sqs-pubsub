package br.com.sqs;

import br.com.sqs.consumer.MyRecord;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AwsSqsPubsubApplication implements CommandLineRunner {

    private static final String SQS = "https://localhost.localstack.cloud:4566/000000000000/minha-fila";

    private SqsTemplate sqsTemplate;

    public AwsSqsPubsubApplication(SqsTemplate sqsTemplate) {
        this.sqsTemplate = sqsTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(AwsSqsPubsubApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        sqsTemplate.send(SQS, new MyRecord(":::: meu valor de start ::::"));
    }
}
