/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.discoveryengine.v1;

import static com.google.cloud.discoveryengine.v1.SchemaServiceClient.ListSchemasPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class SchemaServiceClientTest {
  private static MockLocations mockLocations;
  private static MockSchemaService mockSchemaService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private SchemaServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockSchemaService = new MockSchemaService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockSchemaService, mockLocations));
    mockServiceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    mockServiceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    mockServiceHelper.reset();
    channelProvider = mockServiceHelper.createChannelProvider();
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
  public void getSchemaTest() throws Exception {
    Schema expectedResponse =
        Schema.newBuilder()
            .setName(
                SchemaName.ofProjectLocationDataStoreSchemaName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SCHEMA]")
                    .toString())
            .build();
    mockSchemaService.addResponse(expectedResponse);

    SchemaName name =
        SchemaName.ofProjectLocationDataStoreSchemaName(
            "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SCHEMA]");

    Schema actualResponse = client.getSchema(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSchemaService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSchemaRequest actualRequest = ((GetSchemaRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSchemaExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSchemaService.addException(exception);

    try {
      SchemaName name =
          SchemaName.ofProjectLocationDataStoreSchemaName(
              "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SCHEMA]");
      client.getSchema(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSchemaTest2() throws Exception {
    Schema expectedResponse =
        Schema.newBuilder()
            .setName(
                SchemaName.ofProjectLocationDataStoreSchemaName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SCHEMA]")
                    .toString())
            .build();
    mockSchemaService.addResponse(expectedResponse);

    String name = "name3373707";

    Schema actualResponse = client.getSchema(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSchemaService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSchemaRequest actualRequest = ((GetSchemaRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSchemaExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSchemaService.addException(exception);

    try {
      String name = "name3373707";
      client.getSchema(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSchemasTest() throws Exception {
    Schema responsesElement = Schema.newBuilder().build();
    ListSchemasResponse expectedResponse =
        ListSchemasResponse.newBuilder()
            .setNextPageToken("")
            .addAllSchemas(Arrays.asList(responsesElement))
            .build();
    mockSchemaService.addResponse(expectedResponse);

    DataStoreName parent =
        DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");

    ListSchemasPagedResponse pagedListResponse = client.listSchemas(parent);

    List<Schema> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSchemasList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSchemaService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSchemasRequest actualRequest = ((ListSchemasRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSchemasExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSchemaService.addException(exception);

    try {
      DataStoreName parent =
          DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");
      client.listSchemas(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSchemasTest2() throws Exception {
    Schema responsesElement = Schema.newBuilder().build();
    ListSchemasResponse expectedResponse =
        ListSchemasResponse.newBuilder()
            .setNextPageToken("")
            .addAllSchemas(Arrays.asList(responsesElement))
            .build();
    mockSchemaService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListSchemasPagedResponse pagedListResponse = client.listSchemas(parent);

    List<Schema> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSchemasList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSchemaService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSchemasRequest actualRequest = ((ListSchemasRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSchemasExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSchemaService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listSchemas(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSchemaTest() throws Exception {
    Schema expectedResponse =
        Schema.newBuilder()
            .setName(
                SchemaName.ofProjectLocationDataStoreSchemaName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SCHEMA]")
                    .toString())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createSchemaTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSchemaService.addResponse(resultOperation);

    DataStoreName parent =
        DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");
    Schema schema = Schema.newBuilder().build();
    String schemaId = "schemaId-697673060";

    Schema actualResponse = client.createSchemaAsync(parent, schema, schemaId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSchemaService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSchemaRequest actualRequest = ((CreateSchemaRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(schema, actualRequest.getSchema());
    Assert.assertEquals(schemaId, actualRequest.getSchemaId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSchemaExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSchemaService.addException(exception);

    try {
      DataStoreName parent =
          DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");
      Schema schema = Schema.newBuilder().build();
      String schemaId = "schemaId-697673060";
      client.createSchemaAsync(parent, schema, schemaId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createSchemaTest2() throws Exception {
    Schema expectedResponse =
        Schema.newBuilder()
            .setName(
                SchemaName.ofProjectLocationDataStoreSchemaName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SCHEMA]")
                    .toString())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createSchemaTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSchemaService.addResponse(resultOperation);

    String parent = "parent-995424086";
    Schema schema = Schema.newBuilder().build();
    String schemaId = "schemaId-697673060";

    Schema actualResponse = client.createSchemaAsync(parent, schema, schemaId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSchemaService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSchemaRequest actualRequest = ((CreateSchemaRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(schema, actualRequest.getSchema());
    Assert.assertEquals(schemaId, actualRequest.getSchemaId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSchemaExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSchemaService.addException(exception);

    try {
      String parent = "parent-995424086";
      Schema schema = Schema.newBuilder().build();
      String schemaId = "schemaId-697673060";
      client.createSchemaAsync(parent, schema, schemaId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateSchemaTest() throws Exception {
    Schema expectedResponse =
        Schema.newBuilder()
            .setName(
                SchemaName.ofProjectLocationDataStoreSchemaName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SCHEMA]")
                    .toString())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateSchemaTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSchemaService.addResponse(resultOperation);

    UpdateSchemaRequest request =
        UpdateSchemaRequest.newBuilder()
            .setSchema(Schema.newBuilder().build())
            .setAllowMissing(true)
            .build();

    Schema actualResponse = client.updateSchemaAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSchemaService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSchemaRequest actualRequest = ((UpdateSchemaRequest) actualRequests.get(0));

    Assert.assertEquals(request.getSchema(), actualRequest.getSchema());
    Assert.assertEquals(request.getAllowMissing(), actualRequest.getAllowMissing());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSchemaExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSchemaService.addException(exception);

    try {
      UpdateSchemaRequest request =
          UpdateSchemaRequest.newBuilder()
              .setSchema(Schema.newBuilder().build())
              .setAllowMissing(true)
              .build();
      client.updateSchemaAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteSchemaTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteSchemaTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSchemaService.addResponse(resultOperation);

    SchemaName name =
        SchemaName.ofProjectLocationDataStoreSchemaName(
            "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SCHEMA]");

    client.deleteSchemaAsync(name).get();

    List<AbstractMessage> actualRequests = mockSchemaService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSchemaRequest actualRequest = ((DeleteSchemaRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSchemaExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSchemaService.addException(exception);

    try {
      SchemaName name =
          SchemaName.ofProjectLocationDataStoreSchemaName(
              "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SCHEMA]");
      client.deleteSchemaAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteSchemaTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteSchemaTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSchemaService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteSchemaAsync(name).get();

    List<AbstractMessage> actualRequests = mockSchemaService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSchemaRequest actualRequest = ((DeleteSchemaRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSchemaExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSchemaService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteSchemaAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
