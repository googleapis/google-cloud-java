/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package pubsub;

import static com.google.common.truth.Truth.assertThat;
import static junit.framework.TestCase.assertNotNull;

import com.google.api.gax.rpc.NotFoundException;
import com.google.cloud.pubsub.v1.SchemaServiceClient;
import com.google.cloud.pubsub.v1.SubscriptionAdminClient;
import com.google.cloud.pubsub.v1.TopicAdminClient;
import com.google.cloud.testing.junit4.MultipleAttemptsRule;
import com.google.pubsub.v1.Encoding;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.pubsub.v1.Schema;
import com.google.pubsub.v1.SchemaName;
import com.google.pubsub.v1.TopicName;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.UUID;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class SchemaIT {
  private ByteArrayOutputStream bout;
  private PrintStream out;

  private static final String projectId = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static String _suffix;
  private static String avroTopicId;
  private static String protoTopicId;
  private static String protoTopicWithRevisionsId;
  private static String avroSubscriptionId;
  private static String protoSubscriptionId;
  private static String avroSchemaId;
  private static String protoSchemaId;

  ClassLoader classLoader = getClass().getClassLoader();
  File avscFile = new File(classLoader.getResource("us-states.avsc").getFile());
  String absoluteAvscFilePath = avscFile.getAbsolutePath();
  File avscRevisionFile = new File(classLoader.getResource("us-states-plus.avsc").getFile());
  String absoluteAvscRevisionFilePath = avscRevisionFile.getAbsolutePath();

  File protoFile = new File(classLoader.getResource("us-states-plus.proto").getFile());
  String absoluteProtoFilePath = protoFile.getAbsolutePath();
  File protoRevisionFile = new File(classLoader.getResource("us-states.proto").getFile());
  String absoluteProtoRevisionFilePath = protoFile.getAbsolutePath();

  private static TopicName avroTopicName;
  private static TopicName protoTopicName;
  private static TopicName protoTopicWithRevisionsName;
  private static ProjectSubscriptionName avroSubscriptionName;
  private static ProjectSubscriptionName protoSubscriptionName;
  private static SchemaName avroSchemaName;
  private static SchemaName protoSchemaName;

  private static void requireEnvVar(String varName) {
    assertNotNull(
        "Environment variable " + varName + " is required to perform these tests.",
        System.getenv(varName));
  }

  @Rule public Timeout globalTimeout = Timeout.seconds(600); // 10 minute timeout
  @Rule public MultipleAttemptsRule retryRule = new MultipleAttemptsRule(/* maxAttemptCount= */ 3);

  @Before
  public void setUp() {
    _suffix = UUID.randomUUID().toString();
    avroTopicId = "avro-topic-" + _suffix;
    protoTopicId = "proto-topic-" + _suffix;
    protoTopicWithRevisionsId = "proto-topic-with-revisions-" + _suffix;
    avroSubscriptionId = "avro-subscription-" + _suffix;
    protoSubscriptionId = "proto-subscription-" + _suffix;
    avroSchemaId = "avro-schema-" + _suffix;
    protoSchemaId = "proto-schema-" + _suffix;
    avroTopicName = TopicName.of(projectId, avroTopicId);
    protoTopicName = TopicName.of(projectId, protoTopicId);
    protoTopicWithRevisionsName = TopicName.of(projectId, protoTopicWithRevisionsId);
    avroSubscriptionName = ProjectSubscriptionName.of(projectId, avroSubscriptionId);
    protoSubscriptionName = ProjectSubscriptionName.of(projectId, protoSubscriptionId);
    avroSchemaName = SchemaName.of(projectId, avroSchemaId);
    protoSchemaName = SchemaName.of(projectId, protoSchemaId);
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
  }

  @After
  public void tearDown() throws Exception {
    // Delete the schemas if they have not been cleaned up.
    try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
      try {
        schemaServiceClient.deleteSchema(protoSchemaName);
      } catch (NotFoundException ignored) {
        // Ignore this as resources may have already been cleaned up.
      }
      try {
        schemaServiceClient.deleteSchema(avroSchemaName);
      } catch (NotFoundException ignored) {
        // Ignore this as resources may have already been cleaned up.
      }
    }

    // Delete the subscriptions.
    try (SubscriptionAdminClient subscriptionAdmin = SubscriptionAdminClient.create()) {
      try {
        subscriptionAdmin.deleteSubscription(avroSubscriptionName.toString());
      } catch (NotFoundException ignored) {
        // Ignore this as resources may have already been cleaned up.
      }
      try {
        subscriptionAdmin.deleteSubscription(protoSubscriptionName.toString());
      } catch (NotFoundException ignored) {
        // Ignore this as resources may have already been cleaned up.
      }
    }

    // Delete the topics.
    try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
      try {
        topicAdminClient.deleteTopic(avroTopicName.toString());
      } catch (NotFoundException ignored) {
        // Ignore this as resources may have already been cleaned up.
      }
      try {
        topicAdminClient.deleteTopic(protoTopicName.toString());
      } catch (NotFoundException ignored) {
        // Ignore this as resources may have already been cleaned up.
      }
      try {
        topicAdminClient.deleteTopic(protoTopicWithRevisionsName.toString());
      } catch (NotFoundException ignored) {
        // Ignore this as resources may have already been cleaned up.
      }
    }
    System.setOut(null);
  }

  @Test
  public void testSchema() throws Exception {
    // Test creating Avro schema.
    Schema avroSchema =
        CreateAvroSchemaExample.createAvroSchemaExample(
            projectId, avroSchemaId, absoluteAvscFilePath);
    assertThat(bout.toString()).contains("Created a schema using an Avro schema:");
    assertThat(bout.toString()).contains(avroSchemaName.toString());

    bout.reset();
    // Test committing Avro schema.
    CommitAvroSchemaExample.commitAvroSchemaExample(
        projectId, avroSchemaId, absoluteAvscRevisionFilePath);
    assertThat(bout.toString()).contains("Committed a schema using an Avro schema:");
    assertThat(bout.toString()).contains(avroSchemaName.toString());

    bout.reset();
    // Test creating Proto schema.
    final Schema protoSchema =
        CreateProtoSchemaExample.createProtoSchemaExample(
            projectId, protoSchemaId, absoluteProtoFilePath);
    assertThat(bout.toString()).contains("Created a schema using a protobuf schema:");
    assertThat(bout.toString()).contains(protoSchemaName.toString());

    bout.reset();
    // Test committing Proto schema.
    final Schema protoSchemaRevision =
        CommitProtoSchemaExample.commitProtoSchemaExample(
            projectId, protoSchemaId, absoluteProtoRevisionFilePath);
    assertThat(bout.toString()).contains("Committed a schema using a protobuf schema:");
    assertThat(bout.toString()).contains(protoSchemaName.toString());

    bout.reset();
    // Test rolling back a schema.
    RollbackSchemaExample.rollbackSchemaExample(
        projectId, protoSchemaId, protoSchema.getRevisionId());
    assertThat(bout.toString()).contains("Rolled back a schema:");
    assertThat(bout.toString()).contains(protoSchemaName.toString());

    bout.reset();
    // Test getting a schema.
    GetSchemaExample.getSchemaExample(projectId, avroSchemaId);
    assertThat(bout.toString()).contains("Got a schema:");
    assertThat(bout.toString()).contains(avroSchemaName.toString());

    bout.reset();
    // Test getting a schema revision.
    GetSchemaRevisionExample.getSchemaRevisionExample(
        projectId, protoSchemaId + "@" + protoSchemaRevision.getRevisionId());
    assertThat(bout.toString()).contains("Got a schema:");
    assertThat(bout.toString()).contains(protoSchemaName.toString());

    bout.reset();
    // Test listing schemas.
    ListSchemasExample.listSchemasExample(projectId);
    assertThat(bout.toString()).contains("Listed schemas.");
    assertThat(bout.toString()).contains(avroSchemaName.toString());

    bout.reset();
    // Test listing schema revisions.
    ListSchemaRevisionsExample.listSchemaRevisionsExample(projectId, protoSchemaId);
    assertThat(bout.toString()).contains("Listed schema revisions.");
    assertThat(bout.toString()).contains(protoSchemaName.toString());

    bout.reset();
    // Test creating a topic with an Avro schema with BINARY encoding.
    CreateTopicWithSchemaExample.createTopicWithSchemaExample(
        projectId, avroTopicId, avroSchemaId, Encoding.BINARY);
    assertThat(bout.toString()).contains("Created topic with schema: " + avroTopicName.toString());

    bout.reset();
    // Test creating a topic with a proto schema with JSON encoding.
    CreateTopicWithSchemaExample.createTopicWithSchemaExample(
        projectId, protoTopicId, protoSchemaId, Encoding.JSON);
    assertThat(bout.toString()).contains("Created topic with schema: " + protoTopicName.toString());

    bout.reset();
    // Test creating a topic with a proto schema with revisions specified.
    CreateTopicWithSchemaRevisionsExample.createTopicWithSchemaRevisionsExample(
        projectId,
        protoTopicWithRevisionsId,
        protoSchemaId,
        protoSchema.getRevisionId(),
        protoSchemaRevision.getRevisionId(),
        Encoding.BINARY);
    assertThat(bout.toString())
        .contains("Created topic with schema: " + protoTopicWithRevisionsName.toString());

    bout.reset();
    // Attach a default pull subscription to each topic.
    CreatePullSubscriptionExample.createPullSubscriptionExample(
        projectId, avroSubscriptionId, avroTopicId);
    CreatePullSubscriptionExample.createPullSubscriptionExample(
        projectId, protoSubscriptionId, protoTopicId);

    bout.reset();
    // Test publishing BINARY-encoded Avro records.
    PublishAvroRecordsExample.publishAvroRecordsExample(projectId, avroTopicId);
    assertThat(bout.toString()).contains("Preparing a BINARY encoder...");
    assertThat(bout.toString()).contains("Published message ID:");

    bout.reset();
    // Test publishing JSON-encoded proto messages.
    PublishProtobufMessagesExample.publishProtobufMessagesExample(projectId, protoTopicId);
    assertThat(bout.toString()).contains("Publishing a JSON-formatted message:");
    assertThat(bout.toString()).contains("Published message ID:");

    bout.reset();
    // Test receiving BINARY-encoded Avro records.
    SubscribeWithAvroSchemaRevisionsExample.subscribeWithAvroSchemaRevisionsExample(
        projectId, avroSubscriptionId);
    assertThat(bout.toString()).contains("Receiving a binary-encoded message:");
    assertThat(bout.toString()).contains(" is abbreviated as ");

    bout.reset();
    // Test publishing BINARY-encoded Avro records.
    PublishAvroRecordsExample.publishAvroRecordsExample(projectId, avroTopicId);
    assertThat(bout.toString()).contains("Preparing a BINARY encoder...");
    assertThat(bout.toString()).contains("Published message ID:");

    bout.reset();
    // Test receiving BINARY-encoded Avro records.
    SubscribeWithAvroSchemaExample.subscribeWithAvroSchemaExample(projectId, avroSubscriptionId);
    assertThat(bout.toString()).contains("Receiving a binary-encoded message:");
    assertThat(bout.toString()).contains(" is abbreviated as ");

    bout.reset();
    // Test receiving JSON-encoded proto messages.
    SubscribeWithProtoSchemaExample.subscribeWithProtoSchemaExample(projectId, protoSubscriptionId);
    assertThat(bout.toString()).contains("Received a JSON-formatted message:");
    assertThat(bout.toString()).contains("Ack'ed the message");

    bout.reset();
    // Test updating a topic schema settings
    UpdateTopicSchemaExample.updateTopicSchemaExample(
        projectId,
        protoTopicWithRevisionsId,
        protoSchemaRevision.getRevisionId(),
        protoSchemaRevision.getRevisionId());
    assertThat(bout.toString())
        .contains("Updated topic with schema: " + protoTopicWithRevisionsName.toString());

    bout.reset();
    // Test deleting a schema revision.
    DeleteSchemaRevisionExample.deleteSchemaRevisionExample(
        projectId, protoSchemaId + "@" + protoSchemaRevision.getRevisionId());
    assertThat(bout.toString()).contains("Deleted a schema revision:");
    assertThat(bout.toString()).contains(protoSchemaName.toString());

    bout.reset();
    // Test deleting a schema.
    DeleteSchemaExample.deleteSchemaExample(projectId, avroSchemaId);
    assertThat(bout.toString()).contains("Deleted a schema:");
    assertThat(bout.toString()).contains(avroSchemaName.toString());
  }
}
