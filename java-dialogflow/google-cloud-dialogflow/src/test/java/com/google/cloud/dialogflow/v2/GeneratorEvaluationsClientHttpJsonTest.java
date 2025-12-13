/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.dialogflow.v2;

import static com.google.cloud.dialogflow.v2.GeneratorEvaluationsClient.ListGeneratorEvaluationsPagedResponse;
import static com.google.cloud.dialogflow.v2.GeneratorEvaluationsClient.ListLocationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.dialogflow.v2.stub.HttpJsonGeneratorEvaluationsStub;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.Timestamp;
import java.io.IOException;
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
public class GeneratorEvaluationsClientHttpJsonTest {
  private static MockHttpService mockService;
  private static GeneratorEvaluationsClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonGeneratorEvaluationsStub.getMethodDescriptors(),
            GeneratorEvaluationsSettings.getDefaultEndpoint());
    GeneratorEvaluationsSettings settings =
        GeneratorEvaluationsSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                GeneratorEvaluationsSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = GeneratorEvaluationsClient.create(settings);
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
  public void createGeneratorEvaluationTest() throws Exception {
    GeneratorEvaluation expectedResponse =
        GeneratorEvaluation.newBuilder()
            .setName(
                GeneratorEvaluationName.of("[PROJECT]", "[LOCATION]", "[GENERATOR]", "[EVALUATION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setGeneratorEvaluationConfig(GeneratorEvaluationConfig.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setCompleteTime(Timestamp.newBuilder().build())
            .setInitialGenerator(Generator.newBuilder().build())
            .setEvaluationStatus(EvaluationStatus.newBuilder().build())
            .setSatisfiesPzs(true)
            .setSatisfiesPzi(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createGeneratorEvaluationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    GeneratorName parent = GeneratorName.of("[PROJECT]", "[LOCATION]", "[GENERATOR]");
    GeneratorEvaluation generatorEvaluation = GeneratorEvaluation.newBuilder().build();

    GeneratorEvaluation actualResponse =
        client.createGeneratorEvaluationAsync(parent, generatorEvaluation).get();
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
  public void createGeneratorEvaluationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GeneratorName parent = GeneratorName.of("[PROJECT]", "[LOCATION]", "[GENERATOR]");
      GeneratorEvaluation generatorEvaluation = GeneratorEvaluation.newBuilder().build();
      client.createGeneratorEvaluationAsync(parent, generatorEvaluation).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createGeneratorEvaluationTest2() throws Exception {
    GeneratorEvaluation expectedResponse =
        GeneratorEvaluation.newBuilder()
            .setName(
                GeneratorEvaluationName.of("[PROJECT]", "[LOCATION]", "[GENERATOR]", "[EVALUATION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setGeneratorEvaluationConfig(GeneratorEvaluationConfig.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setCompleteTime(Timestamp.newBuilder().build())
            .setInitialGenerator(Generator.newBuilder().build())
            .setEvaluationStatus(EvaluationStatus.newBuilder().build())
            .setSatisfiesPzs(true)
            .setSatisfiesPzi(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createGeneratorEvaluationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-1951/locations/location-1951/generators/generator-1951";
    GeneratorEvaluation generatorEvaluation = GeneratorEvaluation.newBuilder().build();

    GeneratorEvaluation actualResponse =
        client.createGeneratorEvaluationAsync(parent, generatorEvaluation).get();
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
  public void createGeneratorEvaluationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-1951/locations/location-1951/generators/generator-1951";
      GeneratorEvaluation generatorEvaluation = GeneratorEvaluation.newBuilder().build();
      client.createGeneratorEvaluationAsync(parent, generatorEvaluation).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getGeneratorEvaluationTest() throws Exception {
    GeneratorEvaluation expectedResponse =
        GeneratorEvaluation.newBuilder()
            .setName(
                GeneratorEvaluationName.of("[PROJECT]", "[LOCATION]", "[GENERATOR]", "[EVALUATION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setGeneratorEvaluationConfig(GeneratorEvaluationConfig.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setCompleteTime(Timestamp.newBuilder().build())
            .setInitialGenerator(Generator.newBuilder().build())
            .setEvaluationStatus(EvaluationStatus.newBuilder().build())
            .setSatisfiesPzs(true)
            .setSatisfiesPzi(true)
            .build();
    mockService.addResponse(expectedResponse);

    GeneratorEvaluationName name =
        GeneratorEvaluationName.of("[PROJECT]", "[LOCATION]", "[GENERATOR]", "[EVALUATION]");

    GeneratorEvaluation actualResponse = client.getGeneratorEvaluation(name);
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
  public void getGeneratorEvaluationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GeneratorEvaluationName name =
          GeneratorEvaluationName.of("[PROJECT]", "[LOCATION]", "[GENERATOR]", "[EVALUATION]");
      client.getGeneratorEvaluation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGeneratorEvaluationTest2() throws Exception {
    GeneratorEvaluation expectedResponse =
        GeneratorEvaluation.newBuilder()
            .setName(
                GeneratorEvaluationName.of("[PROJECT]", "[LOCATION]", "[GENERATOR]", "[EVALUATION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setGeneratorEvaluationConfig(GeneratorEvaluationConfig.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setCompleteTime(Timestamp.newBuilder().build())
            .setInitialGenerator(Generator.newBuilder().build())
            .setEvaluationStatus(EvaluationStatus.newBuilder().build())
            .setSatisfiesPzs(true)
            .setSatisfiesPzi(true)
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-3347/locations/location-3347/generators/generator-3347/evaluations/evaluation-3347";

    GeneratorEvaluation actualResponse = client.getGeneratorEvaluation(name);
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
  public void getGeneratorEvaluationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3347/locations/location-3347/generators/generator-3347/evaluations/evaluation-3347";
      client.getGeneratorEvaluation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGeneratorEvaluationsTest() throws Exception {
    GeneratorEvaluation responsesElement = GeneratorEvaluation.newBuilder().build();
    ListGeneratorEvaluationsResponse expectedResponse =
        ListGeneratorEvaluationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllGeneratorEvaluations(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    GeneratorName parent = GeneratorName.of("[PROJECT]", "[LOCATION]", "[GENERATOR]");

    ListGeneratorEvaluationsPagedResponse pagedListResponse =
        client.listGeneratorEvaluations(parent);

    List<GeneratorEvaluation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGeneratorEvaluationsList().get(0), resources.get(0));

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
  public void listGeneratorEvaluationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GeneratorName parent = GeneratorName.of("[PROJECT]", "[LOCATION]", "[GENERATOR]");
      client.listGeneratorEvaluations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGeneratorEvaluationsTest2() throws Exception {
    GeneratorEvaluation responsesElement = GeneratorEvaluation.newBuilder().build();
    ListGeneratorEvaluationsResponse expectedResponse =
        ListGeneratorEvaluationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllGeneratorEvaluations(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-1951/locations/location-1951/generators/generator-1951";

    ListGeneratorEvaluationsPagedResponse pagedListResponse =
        client.listGeneratorEvaluations(parent);

    List<GeneratorEvaluation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGeneratorEvaluationsList().get(0), resources.get(0));

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
  public void listGeneratorEvaluationsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-1951/locations/location-1951/generators/generator-1951";
      client.listGeneratorEvaluations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteGeneratorEvaluationTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    GeneratorEvaluationName name =
        GeneratorEvaluationName.of("[PROJECT]", "[LOCATION]", "[GENERATOR]", "[EVALUATION]");

    client.deleteGeneratorEvaluation(name);

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
  public void deleteGeneratorEvaluationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GeneratorEvaluationName name =
          GeneratorEvaluationName.of("[PROJECT]", "[LOCATION]", "[GENERATOR]", "[EVALUATION]");
      client.deleteGeneratorEvaluation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteGeneratorEvaluationTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-3347/locations/location-3347/generators/generator-3347/evaluations/evaluation-3347";

    client.deleteGeneratorEvaluation(name);

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
  public void deleteGeneratorEvaluationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3347/locations/location-3347/generators/generator-3347/evaluations/evaluation-3347";
      client.deleteGeneratorEvaluation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLocationsTest() throws Exception {
    Location responsesElement = Location.newBuilder().build();
    ListLocationsResponse expectedResponse =
        ListLocationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLocations(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("projects/project-3664")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

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
  public void listLocationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("projects/project-3664")
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listLocations(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLocationTest() throws Exception {
    Location expectedResponse =
        Location.newBuilder()
            .setName("name3373707")
            .setLocationId("locationId1541836720")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setMetadata(Any.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    GetLocationRequest request =
        GetLocationRequest.newBuilder()
            .setName("projects/project-9062/locations/location-9062")
            .build();

    Location actualResponse = client.getLocation(request);
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
  public void getLocationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetLocationRequest request =
          GetLocationRequest.newBuilder()
              .setName("projects/project-9062/locations/location-9062")
              .build();
      client.getLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
