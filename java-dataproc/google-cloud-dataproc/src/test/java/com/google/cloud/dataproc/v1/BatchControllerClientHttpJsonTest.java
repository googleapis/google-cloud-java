/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.dataproc.v1;

import static com.google.cloud.dataproc.v1.BatchControllerClient.ListBatchesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.dataproc.v1.stub.HttpJsonBatchControllerStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class BatchControllerClientHttpJsonTest {
  private static MockHttpService mockService;
  private static BatchControllerClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonBatchControllerStub.getMethodDescriptors(),
            BatchControllerSettings.getDefaultEndpoint());
    BatchControllerSettings settings =
        BatchControllerSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                BatchControllerSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = BatchControllerClient.create(settings);
  }

  @AfterClass
  public static void stopServer() {
    client.close();
  }

  @Before
  public void setUp() {}

  @After
  public void tearDown() throws Exception {
    mockService.reset();
  }

  @Test
  public void createBatchTest() throws Exception {
    Batch expectedResponse =
        Batch.newBuilder()
            .setName(BatchName.of("[PROJECT]", "[LOCATION]", "[BATCH]").toString())
            .setUuid("uuid3601339")
            .setCreateTime(Timestamp.newBuilder().build())
            .setRuntimeInfo(RuntimeInfo.newBuilder().build())
            .setStateMessage("stateMessage1128185398")
            .setStateTime(Timestamp.newBuilder().build())
            .setCreator("creator1028554796")
            .putAllLabels(new HashMap<String, String>())
            .setRuntimeConfig(RuntimeConfig.newBuilder().build())
            .setEnvironmentConfig(EnvironmentConfig.newBuilder().build())
            .setOperation("operation1662702951")
            .addAllStateHistory(new ArrayList<Batch.StateHistory>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createBatchTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Batch batch = Batch.newBuilder().build();
    String batchId = "batchId-331744779";

    Batch actualResponse = client.createBatchAsync(parent, batch, batchId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createBatchExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Batch batch = Batch.newBuilder().build();
      String batchId = "batchId-331744779";
      client.createBatchAsync(parent, batch, batchId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createBatchTest2() throws Exception {
    Batch expectedResponse =
        Batch.newBuilder()
            .setName(BatchName.of("[PROJECT]", "[LOCATION]", "[BATCH]").toString())
            .setUuid("uuid3601339")
            .setCreateTime(Timestamp.newBuilder().build())
            .setRuntimeInfo(RuntimeInfo.newBuilder().build())
            .setStateMessage("stateMessage1128185398")
            .setStateTime(Timestamp.newBuilder().build())
            .setCreator("creator1028554796")
            .putAllLabels(new HashMap<String, String>())
            .setRuntimeConfig(RuntimeConfig.newBuilder().build())
            .setEnvironmentConfig(EnvironmentConfig.newBuilder().build())
            .setOperation("operation1662702951")
            .addAllStateHistory(new ArrayList<Batch.StateHistory>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createBatchTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    Batch batch = Batch.newBuilder().build();
    String batchId = "batchId-331744779";

    Batch actualResponse = client.createBatchAsync(parent, batch, batchId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createBatchExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      Batch batch = Batch.newBuilder().build();
      String batchId = "batchId-331744779";
      client.createBatchAsync(parent, batch, batchId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getBatchTest() throws Exception {
    Batch expectedResponse =
        Batch.newBuilder()
            .setName(BatchName.of("[PROJECT]", "[LOCATION]", "[BATCH]").toString())
            .setUuid("uuid3601339")
            .setCreateTime(Timestamp.newBuilder().build())
            .setRuntimeInfo(RuntimeInfo.newBuilder().build())
            .setStateMessage("stateMessage1128185398")
            .setStateTime(Timestamp.newBuilder().build())
            .setCreator("creator1028554796")
            .putAllLabels(new HashMap<String, String>())
            .setRuntimeConfig(RuntimeConfig.newBuilder().build())
            .setEnvironmentConfig(EnvironmentConfig.newBuilder().build())
            .setOperation("operation1662702951")
            .addAllStateHistory(new ArrayList<Batch.StateHistory>())
            .build();
    mockService.addResponse(expectedResponse);

    BatchName name = BatchName.of("[PROJECT]", "[LOCATION]", "[BATCH]");

    Batch actualResponse = client.getBatch(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getBatchExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BatchName name = BatchName.of("[PROJECT]", "[LOCATION]", "[BATCH]");
      client.getBatch(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBatchTest2() throws Exception {
    Batch expectedResponse =
        Batch.newBuilder()
            .setName(BatchName.of("[PROJECT]", "[LOCATION]", "[BATCH]").toString())
            .setUuid("uuid3601339")
            .setCreateTime(Timestamp.newBuilder().build())
            .setRuntimeInfo(RuntimeInfo.newBuilder().build())
            .setStateMessage("stateMessage1128185398")
            .setStateTime(Timestamp.newBuilder().build())
            .setCreator("creator1028554796")
            .putAllLabels(new HashMap<String, String>())
            .setRuntimeConfig(RuntimeConfig.newBuilder().build())
            .setEnvironmentConfig(EnvironmentConfig.newBuilder().build())
            .setOperation("operation1662702951")
            .addAllStateHistory(new ArrayList<Batch.StateHistory>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-1682/locations/location-1682/batches/batche-1682";

    Batch actualResponse = client.getBatch(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getBatchExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1682/locations/location-1682/batches/batche-1682";
      client.getBatch(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBatchesTest() throws Exception {
    Batch responsesElement = Batch.newBuilder().build();
    ListBatchesResponse expectedResponse =
        ListBatchesResponse.newBuilder()
            .setNextPageToken("")
            .addAllBatches(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListBatchesPagedResponse pagedListResponse = client.listBatches(parent);

    List<Batch> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBatchesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listBatchesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listBatches(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBatchesTest2() throws Exception {
    Batch responsesElement = Batch.newBuilder().build();
    ListBatchesResponse expectedResponse =
        ListBatchesResponse.newBuilder()
            .setNextPageToken("")
            .addAllBatches(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListBatchesPagedResponse pagedListResponse = client.listBatches(parent);

    List<Batch> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBatchesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listBatchesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listBatches(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteBatchTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    BatchName name = BatchName.of("[PROJECT]", "[LOCATION]", "[BATCH]");

    client.deleteBatch(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteBatchExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BatchName name = BatchName.of("[PROJECT]", "[LOCATION]", "[BATCH]");
      client.deleteBatch(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteBatchTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-1682/locations/location-1682/batches/batche-1682";

    client.deleteBatch(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteBatchExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1682/locations/location-1682/batches/batche-1682";
      client.deleteBatch(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
