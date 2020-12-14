/*
 * Copyright 2020 Google LLC
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
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class PredictionApiKeyRegistryClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockPredictionApiKeyRegistry mockPredictionApiKeyRegistry;
  private PredictionApiKeyRegistryClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockPredictionApiKeyRegistry = new MockPredictionApiKeyRegistry();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockPredictionApiKeyRegistry));
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
  public void createPredictionApiKeyRegistrationTest() throws Exception {
    PredictionApiKeyRegistration expectedResponse =
        PredictionApiKeyRegistration.newBuilder().setApiKey("apiKey-1411301915").build();
    mockPredictionApiKeyRegistry.addResponse(expectedResponse);

    EventStoreName parent =
        EventStoreName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
    PredictionApiKeyRegistration predictionApiKeyRegistration =
        PredictionApiKeyRegistration.newBuilder().build();

    PredictionApiKeyRegistration actualResponse =
        client.createPredictionApiKeyRegistration(parent, predictionApiKeyRegistration);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPredictionApiKeyRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePredictionApiKeyRegistrationRequest actualRequest =
        ((CreatePredictionApiKeyRegistrationRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(
        predictionApiKeyRegistration, actualRequest.getPredictionApiKeyRegistration());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPredictionApiKeyRegistrationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPredictionApiKeyRegistry.addException(exception);

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
    mockPredictionApiKeyRegistry.addResponse(expectedResponse);

    String parent = "parent-995424086";
    PredictionApiKeyRegistration predictionApiKeyRegistration =
        PredictionApiKeyRegistration.newBuilder().build();

    PredictionApiKeyRegistration actualResponse =
        client.createPredictionApiKeyRegistration(parent, predictionApiKeyRegistration);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPredictionApiKeyRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePredictionApiKeyRegistrationRequest actualRequest =
        ((CreatePredictionApiKeyRegistrationRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(
        predictionApiKeyRegistration, actualRequest.getPredictionApiKeyRegistration());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPredictionApiKeyRegistrationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPredictionApiKeyRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockPredictionApiKeyRegistry.addResponse(expectedResponse);

    EventStoreName parent =
        EventStoreName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");

    ListPredictionApiKeyRegistrationsPagedResponse pagedListResponse =
        client.listPredictionApiKeyRegistrations(parent);

    List<PredictionApiKeyRegistration> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getPredictionApiKeyRegistrationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPredictionApiKeyRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPredictionApiKeyRegistrationsRequest actualRequest =
        ((ListPredictionApiKeyRegistrationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPredictionApiKeyRegistrationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPredictionApiKeyRegistry.addException(exception);

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
    mockPredictionApiKeyRegistry.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListPredictionApiKeyRegistrationsPagedResponse pagedListResponse =
        client.listPredictionApiKeyRegistrations(parent);

    List<PredictionApiKeyRegistration> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getPredictionApiKeyRegistrationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPredictionApiKeyRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPredictionApiKeyRegistrationsRequest actualRequest =
        ((ListPredictionApiKeyRegistrationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPredictionApiKeyRegistrationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPredictionApiKeyRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listPredictionApiKeyRegistrations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePredictionApiKeyRegistrationTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockPredictionApiKeyRegistry.addResponse(expectedResponse);

    PredictionApiKeyRegistrationName name =
        PredictionApiKeyRegistrationName.of(
            "[PROJECT]",
            "[LOCATION]",
            "[CATALOG]",
            "[EVENT_STORE]",
            "[PREDICTION_API_KEY_REGISTRATION]");

    client.deletePredictionApiKeyRegistration(name);

    List<AbstractMessage> actualRequests = mockPredictionApiKeyRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePredictionApiKeyRegistrationRequest actualRequest =
        ((DeletePredictionApiKeyRegistrationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePredictionApiKeyRegistrationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPredictionApiKeyRegistry.addException(exception);

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
    mockPredictionApiKeyRegistry.addResponse(expectedResponse);

    String name = "name3373707";

    client.deletePredictionApiKeyRegistration(name);

    List<AbstractMessage> actualRequests = mockPredictionApiKeyRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePredictionApiKeyRegistrationRequest actualRequest =
        ((DeletePredictionApiKeyRegistrationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePredictionApiKeyRegistrationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPredictionApiKeyRegistry.addException(exception);

    try {
      String name = "name3373707";
      client.deletePredictionApiKeyRegistration(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
