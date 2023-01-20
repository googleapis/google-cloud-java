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

package com.google.cloud.automl.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.automl.v1.stub.HttpJsonPredictionServiceStub;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class PredictionServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static PredictionServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonPredictionServiceStub.getMethodDescriptors(),
            PredictionServiceSettings.getDefaultEndpoint());
    PredictionServiceSettings settings =
        PredictionServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                PredictionServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = PredictionServiceClient.create(settings);
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
  public void predictTest() throws Exception {
    PredictResponse expectedResponse =
        PredictResponse.newBuilder()
            .addAllPayload(new ArrayList<AnnotationPayload>())
            .setPreprocessedInput(ExamplePayload.newBuilder().build())
            .putAllMetadata(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
    ExamplePayload payload = ExamplePayload.newBuilder().build();
    Map<String, String> params = new HashMap<>();

    PredictResponse actualResponse = client.predict(name, payload, params);
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
  public void predictExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
      ExamplePayload payload = ExamplePayload.newBuilder().build();
      Map<String, String> params = new HashMap<>();
      client.predict(name, payload, params);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void predictTest2() throws Exception {
    PredictResponse expectedResponse =
        PredictResponse.newBuilder()
            .addAllPayload(new ArrayList<AnnotationPayload>())
            .setPreprocessedInput(ExamplePayload.newBuilder().build())
            .putAllMetadata(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-7594/locations/location-7594/models/model-7594";
    ExamplePayload payload = ExamplePayload.newBuilder().build();
    Map<String, String> params = new HashMap<>();

    PredictResponse actualResponse = client.predict(name, payload, params);
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
  public void predictExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-7594/locations/location-7594/models/model-7594";
      ExamplePayload payload = ExamplePayload.newBuilder().build();
      Map<String, String> params = new HashMap<>();
      client.predict(name, payload, params);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchPredictTest() throws Exception {
    BatchPredictResult expectedResponse =
        BatchPredictResult.newBuilder().putAllMetadata(new HashMap<String, String>()).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchPredictTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
    BatchPredictInputConfig inputConfig = BatchPredictInputConfig.newBuilder().build();
    BatchPredictOutputConfig outputConfig = BatchPredictOutputConfig.newBuilder().build();
    Map<String, String> params = new HashMap<>();

    BatchPredictResult actualResponse =
        client.batchPredictAsync(name, inputConfig, outputConfig, params).get();
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
  public void batchPredictExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
      BatchPredictInputConfig inputConfig = BatchPredictInputConfig.newBuilder().build();
      BatchPredictOutputConfig outputConfig = BatchPredictOutputConfig.newBuilder().build();
      Map<String, String> params = new HashMap<>();
      client.batchPredictAsync(name, inputConfig, outputConfig, params).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void batchPredictTest2() throws Exception {
    BatchPredictResult expectedResponse =
        BatchPredictResult.newBuilder().putAllMetadata(new HashMap<String, String>()).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchPredictTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-7594/locations/location-7594/models/model-7594";
    BatchPredictInputConfig inputConfig = BatchPredictInputConfig.newBuilder().build();
    BatchPredictOutputConfig outputConfig = BatchPredictOutputConfig.newBuilder().build();
    Map<String, String> params = new HashMap<>();

    BatchPredictResult actualResponse =
        client.batchPredictAsync(name, inputConfig, outputConfig, params).get();
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
  public void batchPredictExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-7594/locations/location-7594/models/model-7594";
      BatchPredictInputConfig inputConfig = BatchPredictInputConfig.newBuilder().build();
      BatchPredictOutputConfig outputConfig = BatchPredictOutputConfig.newBuilder().build();
      Map<String, String> params = new HashMap<>();
      client.batchPredictAsync(name, inputConfig, outputConfig, params).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }
}
