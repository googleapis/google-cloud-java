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
package com.google.cloud.recommendationengine.v1beta1;

import static com.google.cloud.recommendationengine.v1beta1.PredictionApiKeyRegistryClient.ListPredictionApiKeyRegistrationsPagedResponse;

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
public class PredictionApiKeyRegistryClientTest {
  private static MockCatalogService mockCatalogService;
  private static MockPredictionApiKeyRegistry mockPredictionApiKeyRegistry;
  private static MockPredictionService mockPredictionService;
  private static MockUserEventService mockUserEventService;
  private static MockServiceHelper serviceHelper;
  private PredictionApiKeyRegistryClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockCatalogService = new MockCatalogService();
    mockPredictionApiKeyRegistry = new MockPredictionApiKeyRegistry();
    mockPredictionService = new MockPredictionService();
    mockUserEventService = new MockUserEventService();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(
                mockCatalogService,
                mockPredictionApiKeyRegistry,
                mockPredictionService,
                mockUserEventService));
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
    PredictionApiKeyRegistrySettings settings =
        PredictionApiKeyRegistrySettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = PredictionApiKeyRegistryClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void createPredictionApiKeyRegistrationTest() {
    String apiKey = "apiKey-800085318";
    PredictionApiKeyRegistration expectedResponse =
        PredictionApiKeyRegistration.newBuilder().setApiKey(apiKey).build();
    mockPredictionApiKeyRegistry.addResponse(expectedResponse);

    String formattedParent =
        PredictionApiKeyRegistryClient.formatEventStoreName(
            "[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
    PredictionApiKeyRegistration predictionApiKeyRegistration =
        PredictionApiKeyRegistration.newBuilder().build();

    PredictionApiKeyRegistration actualResponse =
        client.createPredictionApiKeyRegistration(formattedParent, predictionApiKeyRegistration);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPredictionApiKeyRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePredictionApiKeyRegistrationRequest actualRequest =
        (CreatePredictionApiKeyRegistrationRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
    Assert.assertEquals(
        predictionApiKeyRegistration, actualRequest.getPredictionApiKeyRegistration());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createPredictionApiKeyRegistrationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPredictionApiKeyRegistry.addException(exception);

    try {
      String formattedParent =
          PredictionApiKeyRegistryClient.formatEventStoreName(
              "[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
      PredictionApiKeyRegistration predictionApiKeyRegistration =
          PredictionApiKeyRegistration.newBuilder().build();

      client.createPredictionApiKeyRegistration(formattedParent, predictionApiKeyRegistration);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listPredictionApiKeyRegistrationsTest() {
    String nextPageToken = "";
    PredictionApiKeyRegistration predictionApiKeyRegistrationsElement =
        PredictionApiKeyRegistration.newBuilder().build();
    List<PredictionApiKeyRegistration> predictionApiKeyRegistrations =
        Arrays.asList(predictionApiKeyRegistrationsElement);
    ListPredictionApiKeyRegistrationsResponse expectedResponse =
        ListPredictionApiKeyRegistrationsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllPredictionApiKeyRegistrations(predictionApiKeyRegistrations)
            .build();
    mockPredictionApiKeyRegistry.addResponse(expectedResponse);

    String formattedParent =
        PredictionApiKeyRegistryClient.formatEventStoreName(
            "[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");

    ListPredictionApiKeyRegistrationsPagedResponse pagedListResponse =
        client.listPredictionApiKeyRegistrations(formattedParent);

    List<PredictionApiKeyRegistration> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getPredictionApiKeyRegistrationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPredictionApiKeyRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPredictionApiKeyRegistrationsRequest actualRequest =
        (ListPredictionApiKeyRegistrationsRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listPredictionApiKeyRegistrationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPredictionApiKeyRegistry.addException(exception);

    try {
      String formattedParent =
          PredictionApiKeyRegistryClient.formatEventStoreName(
              "[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");

      client.listPredictionApiKeyRegistrations(formattedParent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deletePredictionApiKeyRegistrationTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockPredictionApiKeyRegistry.addResponse(expectedResponse);

    String formattedName =
        PredictionApiKeyRegistryClient.formatPredictionApiKeyRegistrationName(
            "[PROJECT]",
            "[LOCATION]",
            "[CATALOG]",
            "[EVENT_STORE]",
            "[PREDICTION_API_KEY_REGISTRATION]");

    client.deletePredictionApiKeyRegistration(formattedName);

    List<AbstractMessage> actualRequests = mockPredictionApiKeyRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePredictionApiKeyRegistrationRequest actualRequest =
        (DeletePredictionApiKeyRegistrationRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deletePredictionApiKeyRegistrationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPredictionApiKeyRegistry.addException(exception);

    try {
      String formattedName =
          PredictionApiKeyRegistryClient.formatPredictionApiKeyRegistrationName(
              "[PROJECT]",
              "[LOCATION]",
              "[CATALOG]",
              "[EVENT_STORE]",
              "[PREDICTION_API_KEY_REGISTRATION]");

      client.deletePredictionApiKeyRegistration(formattedName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
