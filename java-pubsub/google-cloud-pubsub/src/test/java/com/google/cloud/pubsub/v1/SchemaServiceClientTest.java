/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.pubsub.v1;

import static com.google.cloud.pubsub.v1.SchemaServiceClient.ListSchemasPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.pubsub.v1.CreateSchemaRequest;
import com.google.pubsub.v1.DeleteSchemaRequest;
import com.google.pubsub.v1.GetSchemaRequest;
import com.google.pubsub.v1.ListSchemasRequest;
import com.google.pubsub.v1.ListSchemasResponse;
import com.google.pubsub.v1.ProjectName;
import com.google.pubsub.v1.Schema;
import com.google.pubsub.v1.SchemaName;
import com.google.pubsub.v1.ValidateMessageRequest;
import com.google.pubsub.v1.ValidateMessageResponse;
import com.google.pubsub.v1.ValidateSchemaRequest;
import com.google.pubsub.v1.ValidateSchemaResponse;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class SchemaServiceClientTest {
  private static MockSchemaService mockSchemaService;
  private static MockPublisher mockPublisher;
  private static MockIAMPolicy mockIAMPolicy;
  private static MockSubscriber mockSubscriber;
  private static MockServiceHelper serviceHelper;
  private SchemaServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockSchemaService = new MockSchemaService();
    mockPublisher = new MockPublisher();
    mockIAMPolicy = new MockIAMPolicy();
    mockSubscriber = new MockSubscriber();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(
                mockSchemaService, mockPublisher, mockIAMPolicy, mockSubscriber));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    channelProvider = serviceHelper.createChannelProvider();
    SchemaServiceSettings settings =
        SchemaServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SchemaServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void createSchemaTest() {
    SchemaName name = SchemaName.of("[PROJECT]", "[SCHEMA]");
    String definition = "definition-1014418093";
    Schema expectedResponse =
        Schema.newBuilder().setName(name.toString()).setDefinition(definition).build();
    mockSchemaService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    Schema schema = Schema.newBuilder().build();
    String schemaId = "schemaId-153006983";

    Schema actualResponse = client.createSchema(parent, schema, schemaId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSchemaService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSchemaRequest actualRequest = (CreateSchemaRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
    Assert.assertEquals(schema, actualRequest.getSchema());
    Assert.assertEquals(schemaId, actualRequest.getSchemaId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createSchemaExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSchemaService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      Schema schema = Schema.newBuilder().build();
      String schemaId = "schemaId-153006983";

      client.createSchema(parent, schema, schemaId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getSchemaTest() {
    SchemaName name2 = SchemaName.of("[PROJECT]", "[SCHEMA]");
    String definition = "definition-1014418093";
    Schema expectedResponse =
        Schema.newBuilder().setName(name2.toString()).setDefinition(definition).build();
    mockSchemaService.addResponse(expectedResponse);

    SchemaName name = SchemaName.of("[PROJECT]", "[SCHEMA]");

    Schema actualResponse = client.getSchema(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSchemaService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSchemaRequest actualRequest = (GetSchemaRequest) actualRequests.get(0);

    Assert.assertEquals(name, SchemaName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getSchemaExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSchemaService.addException(exception);

    try {
      SchemaName name = SchemaName.of("[PROJECT]", "[SCHEMA]");

      client.getSchema(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listSchemasTest() {
    String nextPageToken = "";
    Schema schemasElement = Schema.newBuilder().build();
    List<Schema> schemas = Arrays.asList(schemasElement);
    ListSchemasResponse expectedResponse =
        ListSchemasResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllSchemas(schemas)
            .build();
    mockSchemaService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListSchemasPagedResponse pagedListResponse = client.listSchemas(parent);

    List<Schema> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSchemasList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSchemaService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSchemasRequest actualRequest = (ListSchemasRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listSchemasExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSchemaService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");

      client.listSchemas(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteSchemaTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSchemaService.addResponse(expectedResponse);

    SchemaName name = SchemaName.of("[PROJECT]", "[SCHEMA]");

    client.deleteSchema(name);

    List<AbstractMessage> actualRequests = mockSchemaService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSchemaRequest actualRequest = (DeleteSchemaRequest) actualRequests.get(0);

    Assert.assertEquals(name, SchemaName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteSchemaExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSchemaService.addException(exception);

    try {
      SchemaName name = SchemaName.of("[PROJECT]", "[SCHEMA]");

      client.deleteSchema(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void validateSchemaTest() {
    ValidateSchemaResponse expectedResponse = ValidateSchemaResponse.newBuilder().build();
    mockSchemaService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    Schema schema = Schema.newBuilder().build();

    ValidateSchemaResponse actualResponse = client.validateSchema(parent, schema);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSchemaService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ValidateSchemaRequest actualRequest = (ValidateSchemaRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
    Assert.assertEquals(schema, actualRequest.getSchema());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void validateSchemaExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSchemaService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      Schema schema = Schema.newBuilder().build();

      client.validateSchema(parent, schema);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void validateMessageTest() {
    ValidateMessageResponse expectedResponse = ValidateMessageResponse.newBuilder().build();
    mockSchemaService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    ValidateMessageRequest request =
        ValidateMessageRequest.newBuilder().setParent(parent.toString()).build();

    ValidateMessageResponse actualResponse = client.validateMessage(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSchemaService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ValidateMessageRequest actualRequest = (ValidateMessageRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void validateMessageExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSchemaService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      ValidateMessageRequest request =
          ValidateMessageRequest.newBuilder().setParent(parent.toString()).build();

      client.validateMessage(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
