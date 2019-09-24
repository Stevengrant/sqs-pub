package sqs.clients;

import javax.swing.*;
import java.awt.event.ActionListener;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.SendMessageRequest;


public class Pub {
    private String queueUrl;
    public void publish(String message){
        SendMessageRequest send_msg_request = new SendMessageRequest()
                .withQueueUrl(queueUrl)
                .withMessageBody(message)
                .withDelaySeconds(5);

        final AmazonSQS sqs = AmazonSQSClientBuilder.defaultClient();
        sqs.sendMessage(send_msg_request);
    }
    public Pub (String queueUrl){
        this.queueUrl = queueUrl;

    }
}
