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

package com.google.cloud.recommendationengine.v1beta1;

import static com.google.cloud.recommendationengine.v1beta1.PredictionApiKeyRegistryClient.ListPredictionApiKeyRegistrationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.recommendationengine.v1beta1.stub.HttpJsonPredictionApiKeyRegistryStub;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class PredictionApiKeyRegistryClientHttpJsonTest {
  private static MockHttpService mockService;
  private static PredictionApiKeyRegistryClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonPredictionApiKeyRegistryStub.getMethodDescriptors(),
            PredictionApiKeyRegistrySettings.getDefaultEndpoint());
    PredictionApiKeyRegistrySettings settings =
        PredictionApiKeyRegistrySettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                PredictionApiKeyRegistrySettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = PredictionApiKeyRegistryClient.create(settings);
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
  public void createPredictionApiKeyRegistrationTest() throws Exception {
    PredictionApiKeyRegistration expectedResponse =
        PredictionApiKeyRegistration.newBuilder().setApiKey("apiKey-1411301915").build();
    mockService.addResponse(expectedResponse);

    EventStoreName parent =
        EventStoreName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
    PredictionApiKeyRegistration predictionApiKeyRegistration =
        PredictionApiKeyRegistration.newBuilder().build();

    PredictionApiKeyRegistration actualResponse =
        client.createPredictionApiKeyRegistration(parent, predictionApiKeyRegistration);
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
  public void createPredictionApiKeyRegistrationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EventStoreName parent =
          EventStoreName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
      PredictionApiKeyRegistration predictionApiKeyRegistration =
          PredictionApiKeyRegistration.newBuilder().build();
      client.createPredictionApiKeyRegistration(parent, predictionApiKeyRegistration);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPredictionApiKeyRegistrationTest2() throws Exception {
    PredictionApiKeyRegistration expectedResponse =
        PredictionApiKeyRegistration.newBuilder().setApiKey("apiKey-1411301915").build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-765/locations/location-765/catalogs/catalog-765/eventStores/eventStore-765";
    PredictionApiKeyRegistration predictionApiKeyRegistration =
        PredictionApiKeyRegistration.newBuilder().build();

    PredictionApiKeyRegistration actualResponse =
        client.createPredictionApiKeyRegistration(parent, predictionApiKeyRegistration);
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
  public void createPredictionApiKeyRegistrationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-765/locations/location-765/catalogs/catalog-765/eventStores/eventStore-765";
      PredictionApiKeyRegistration predictionApiKeyRegistration =
          PredictionApiKeyRegistration.newBuilder().build();
      client.createPredictionApiKeyRegistration(parent, predictionApiKeyRegistration);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPredictionApiKeyRegistrationsTest() throws Exception {
    PredictionApiKeyRegistration responsesElement =
        PredictionApiKeyRegistration.newBuilder().build();
    ListPredictionApiKeyRegistrationsResponse expectedResponse =
        ListPredictionApiKeyRegistrationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPredictionApiKeyRegistrations(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    EventStoreName parent =
        EventStoreName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");

    ListPredictionApiKeyRegistrationsPagedResponse pagedListResponse =
        client.listPredictionApiKeyRegistrations(parent);

    List<PredictionApiKeyRegistration> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getPredictionApiKeyRegistrationsList().get(0), resources.get(0));

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
  public void listPredictionApiKeyRegistrationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EventStoreName parent =
          EventStoreName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
      client.listPredictionApiKeyRegistrations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPredictionApiKeyRegistrationsTest2() throws Exception {
    PredictionApiKeyRegistration responsesElement =
        PredictionApiKeyRegistration.newBuilder().build();
    ListPredictionApiKeyRegistrationsResponse expectedResponse =
        ListPredictionApiKeyRegistrationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPredictionApiKeyRegistrations(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-765/locations/location-765/catalogs/catalog-765/eventStores/eventStore-765";

    ListPredictionApiKeyRegistrationsPagedResponse pagedListResponse =
        client.listPredictionApiKeyRegistrations(parent);

    List<PredictionApiKeyRegistration> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getPredictionApiKeyRegistrationsList().get(0), resources.get(0));

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
  public void listPredictionApiKeyRegistrationsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-765/locations/location-765/catalogs/catalog-765/eventStores/eventStore-765";
      client.listPredictionApiKeyRegistrations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePredictionApiKeyRegistrationTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    PredictionApiKeyRegistrationName name =
        PredictionApiKeyRegistrationName.of(
            "[PROJECT]",
            "[LOCATION]",
            "[CATALOG]",
            "[EVENT_STORE]",
            "[PREDICTION_API_KEY_REGISTRATION]");

    client.deletePredictionApiKeyRegistration(name);

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
  public void deletePredictionApiKeyRegistrationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PredictionApiKeyRegistrationName name =
          PredictionApiKeyRegistrationName.of(
              "[PROJECT]",
              "[LOCATION]",
              "[CATALOG]",
              "[EVENT_STORE]",
              "[PREDICTION_API_KEY_REGISTRATION]");
      client.deletePredictionApiKeyRegistration(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePredictionApiKeyRegistrationTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-76/locations/location-76/catalogs/catalog-76/eventStores/eventStore-76/predictionApiKeyRegistrations/predictionApiKeyRegistration-76";

    client.deletePredictionApiKeyRegistration(name);

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
  public void deletePredictionApiKeyRegistrationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-76/locations/location-76/catalogs/catalog-76/eventStores/eventStore-76/predictionApiKeyRegistrations/predictionApiKeyRegistration-76";
      client.deletePredictionApiKeyRegistration(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
