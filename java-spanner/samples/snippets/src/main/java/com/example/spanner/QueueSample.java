/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.spanner;

import com.google.cloud.ByteArray;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseAdminClient;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Key;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.Value;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ExecutionException;

public class QueueSample {

// [START spanner_create_database_with_queue]
  static void createQueueDatabase(DatabaseAdminClient dbAdminClient, String instanceId, String databaseId) throws ExecutionException, InterruptedException {
    System.out.println("Creating database with a queue...");
    Database database =
        dbAdminClient
            .createDatabase(
                instanceId,
                databaseId,
                Collections.singletonList(
                    "CREATE Queue MyQueue ("
                        + "  Id INT64 NOT NULL,"
                        + "  Payload BYTES(MAX) NOT NULL,"
                        + ") PRIMARY KEY (Id), OPTIONS (receive_mode = 'PULL')"))
            .get();
    System.out.println("Created database [" + database.getId() + "]");
  }
// [END spanner_create_database_with_queue]

// [START spanner_send_to_queue_with_mutation_api]
  static void sendToQueueWithMutation(DatabaseClient dbClient) {
    System.out.println("Sending a message to queue using Mutation API...");
    dbClient.write(
        Collections.singletonList(
            Mutation.newSendBuilder("MyQueue")
                .setKey(Key.of(1L))
                .setPayload(Value.bytes(ByteArray.copyFrom("message1")))
                .build()));
    System.out.println("Message sent.");
  }
// [END spanner_send_to_queue_with_mutation_api]

// [START spanner_send_to_queue_with_sql_api]
  static void sendToQueueWithSql(DatabaseClient dbClient) {
    System.out.println("Sending a message to queue using SQL API...");
    dbClient.readWriteTransaction().run(
        transaction -> {
          transaction.executeUpdate(
              Statement.of("INSERT INTO MyQueue (Id, Payload) VALUES (2, B'message2')"));
          return null;
        });
    System.out.println("Message sent.");
  }
// [END spanner_send_to_queue_with_sql_api]

// [START spanner_send_to_queue_with_mutation_api_in_future]
  static void sendToQueueWithMutationInFuture(DatabaseClient dbClient) {
    System.out.println("Sending a message to queue using Mutation API in the future...");
    Instant futureTime = Instant.now().plus(Duration.ofMinutes(10));
    dbClient.write(
        Collections.singletonList(
            Mutation.newSendBuilder("MyQueue")
                .setKey(Key.of(3L))
                .setPayload(Value.bytes(ByteArray.copyFrom("message3")))
                .setDeliveryTime(futureTime)
                .build()));
    System.out.println("Message scheduled for future delivery.");
  }
// [END spanner_send_to_queue_with_mutation_api_in_future]

// [START spanner_send_to_queue_with_sql_api_in_future]
  static void sendToQueueWithSqlInFuture(DatabaseClient dbClient) {
    System.out.println("Sending a message to queue using SQL API in the future...");
    Instant futureTime = Instant.now().plus(Duration.ofMinutes(10));
    dbClient.readWriteTransaction().run(
        transaction -> {
          transaction.executeUpdate(
              Statement.newBuilder("INSERT INTO MyQueue (Id, Payload, enqueued_time) VALUES (4, B'message4', @deliveryTime)")
                  .bind("deliveryTime").to(Value.timestamp(Timestamp.ofTimeSecondsAndNanos(futureTime.getEpochSecond(), futureTime.getNano())))
                  .build());
          return null;
        });
    System.out.println("Message scheduled for future delivery.");
  }
// [END spanner_send_to_queue_with_sql_api_in_future]

// [START spanner_ack_queue_message_with_mutation_api]
  static void ackMessageWithMutation(DatabaseClient dbClient) {
    System.out.println("Acknowledging a message using Mutation API...");
    dbClient.write(
        Collections.singletonList(
            Mutation.newAckBuilder("MyQueue")
                .setKey(Key.of(1L))
                .build()));
    System.out.println("Message acknowledged.");
  }
// [END spanner_ack_queue_message_with_mutation_api]

// [START spanner_ack_queue_message_with_sql_api]
  static void ackMessageWithSql(DatabaseClient dbClient) {
    System.out.println("Acknowledging a message using SQL API with ASSERT_ROWS_MODIFIED...");
    dbClient.readWriteTransaction().run(
        transaction -> {
          transaction.executeUpdate(
              Statement.of("DELETE FROM MyQueue WHERE Id = 2 ASSERT_ROWS_MODIFIED 1"));
          return null;
        });
    System.out.println("Message acknowledged.");
  }
// [END spanner_ack_queue_message_with_sql_api]

// [START spanner_delete_queue_message_with_sql_api]
  static void deleteMessageWithSql(DatabaseClient dbClient) {
    System.out.println("Deleting a message using SQL API...");
    dbClient.readWriteTransaction().run(
        transaction -> {
          transaction.executeUpdate(
              Statement.of("DELETE FROM MyQueue WHERE Id = 3"));
          return null;
        });
    System.out.println("Message deleted.");
  }
// [END spanner_delete_queue_message_with_sql_api]

// [START spanner_send_and_receive_queue_message_with_sql_api]
  static void sendAndReceiveWithSql(DatabaseClient dbClient) {
    System.out.println("Sending and receiving a message using SQL API...");
    dbClient.readWriteTransaction().run(
        transaction -> {
          transaction.executeUpdate(
              Statement.of("INSERT INTO MyQueue (Id, Payload) VALUES (5, B'message5')"));
          return null;
        });
    
    System.out.println("Receiving message from queue (max_duration 1min)...");
    try (ResultSet resultSet = dbClient.singleUse().executeQuery(
        Statement.of("SELECT * FROM READ_MyQueue(max_duration => '1m')"))) {
      if (resultSet.next()) {
        System.out.println("Received message ID: " + resultSet.getLong("Id"));
      } else {
        System.out.println("No messages received.");
      }
    }
  }
// [END spanner_send_and_receive_queue_message_with_sql_api]

  public static void main(String[] args) throws Exception {
    if (args.length != 3) {
      System.err.println("Usage: QueueSample <projectId> <instanceId> <databaseId>");
      return;
    }
    String projectId = args[0];
    String instanceId = args[1];
    String databaseId = args[2];

    try (Spanner spanner = SpannerOptions.newBuilder().setProjectId(projectId).build().getService()) {
      DatabaseAdminClient dbAdminClient = spanner.getDatabaseAdminClient();
      createQueueDatabase(dbAdminClient, instanceId, databaseId);

      DatabaseClient dbClient = spanner.getDatabaseClient(DatabaseId.of(projectId, instanceId, databaseId));
      
      sendToQueueWithMutation(dbClient);
      sendToQueueWithSql(dbClient);
      sendToQueueWithMutationInFuture(dbClient);
      sendToQueueWithSqlInFuture(dbClient);
      
      ackMessageWithMutation(dbClient);
      ackMessageWithSql(dbClient);
      deleteMessageWithSql(dbClient);
      
      sendAndReceiveWithSql(dbClient);
    }
  }
}
