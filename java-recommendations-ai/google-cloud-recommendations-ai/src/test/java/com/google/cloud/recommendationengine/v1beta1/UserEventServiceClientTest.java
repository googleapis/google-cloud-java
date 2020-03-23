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

import static com.google.cloud.recommendationengine.v1beta1.UserEventServiceClient.ListUserEventsPagedResponse;

import com.google.api.HttpBody;
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
import com.google.protobuf.ByteString;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class UserEventServiceClientTest {
  private static MockCatalogService mockCatalogService;
  private static MockPredictionApiKeyRegistry mockPredictionApiKeyRegistry;
  private static MockPredictionService mockPredictionService;
  private static MockUserEventService mockUserEventService;
  private static MockServiceHelper serviceHelper;
  private UserEventServiceClient client;
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
    UserEventServiceSettings settings =
        UserEventServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = UserEventServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void writeUserEventTest() {
    String eventType = "eventType984376767";
    UserEvent expectedResponse = UserEvent.newBuilder().setEventType(eventType).build();
    mockUserEventService.addResponse(expectedResponse);

    String formattedParent =
        UserEventServiceClient.formatEventStoreName(
            "[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
    UserEvent userEvent = UserEvent.newBuilder().build();

    UserEvent actualResponse = client.writeUserEvent(formattedParent, userEvent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockUserEventService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    WriteUserEventRequest actualRequest = (WriteUserEventRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
    Assert.assertEquals(userEvent, actualRequest.getUserEvent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void writeUserEventExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockUserEventService.addException(exception);

    try {
      String formattedParent =
          UserEventServiceClient.formatEventStoreName(
              "[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
      UserEvent userEvent = UserEvent.newBuilder().build();

      client.writeUserEvent(formattedParent, userEvent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void collectUserEventTest() {
    String contentType = "contentType831846208";
    ByteString data = ByteString.copyFromUtf8("-86");
    HttpBody expectedResponse =
        HttpBody.newBuilder().setContentType(contentType).setData(data).build();
    mockUserEventService.addResponse(expectedResponse);

    String formattedParent =
        UserEventServiceClient.formatEventStoreName(
            "[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
    String userEvent = "userEvent1921940774";
    String uri = "uri116076";
    long ets = 100772L;

    HttpBody actualResponse = client.collectUserEvent(formattedParent, userEvent, uri, ets);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockUserEventService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CollectUserEventRequest actualRequest = (CollectUserEventRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
    Assert.assertEquals(userEvent, actualRequest.getUserEvent());
    Assert.assertEquals(uri, actualRequest.getUri());
    Assert.assertEquals(ets, actualRequest.getEts());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void collectUserEventExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockUserEventService.addException(exception);

    try {
      String formattedParent =
          UserEventServiceClient.formatEventStoreName(
              "[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
      String userEvent = "userEvent1921940774";
      String uri = "uri116076";
      long ets = 100772L;

      client.collectUserEvent(formattedParent, userEvent, uri, ets);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listUserEventsTest() {
    String nextPageToken = "";
    UserEvent userEventsElement = UserEvent.newBuilder().build();
    List<UserEvent> userEvents = Arrays.asList(userEventsElement);
    ListUserEventsResponse expectedResponse =
        ListUserEventsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllUserEvents(userEvents)
            .build();
    mockUserEventService.addResponse(expectedResponse);

    String formattedParent =
        UserEventServiceClient.formatEventStoreName(
            "[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
    String filter = "filter-1274492040";

    ListUserEventsPagedResponse pagedListResponse = client.listUserEvents(formattedParent, filter);

    List<UserEvent> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUserEventsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockUserEventService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListUserEventsRequest actualRequest = (ListUserEventsRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listUserEventsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockUserEventService.addException(exception);

    try {
      String formattedParent =
          UserEventServiceClient.formatEventStoreName(
              "[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
      String filter = "filter-1274492040";

      client.listUserEvents(formattedParent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void purgeUserEventsTest() throws Exception {
    long purgedEventsCount = 310774833L;
    PurgeUserEventsResponse expectedResponse =
        PurgeUserEventsResponse.newBuilder().setPurgedEventsCount(purgedEventsCount).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("purgeUserEventsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockUserEventService.addResponse(resultOperation);

    String formattedParent =
        UserEventServiceClient.formatEventStoreName(
            "[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
    String filter = "filter-1274492040";
    boolean force = false;

    PurgeUserEventsResponse actualResponse =
        client.purgeUserEventsAsync(formattedParent, filter, force).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockUserEventService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PurgeUserEventsRequest actualRequest = (PurgeUserEventsRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertEquals(force, actualRequest.getForce());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void purgeUserEventsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockUserEventService.addException(exception);

    try {
      String formattedParent =
          UserEventServiceClient.formatEventStoreName(
              "[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
      String filter = "filter-1274492040";
      boolean force = false;

      client.purgeUserEventsAsync(formattedParent, filter, force).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void importUserEventsTest() throws Exception {
    ImportUserEventsResponse expectedResponse = ImportUserEventsResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importUserEventsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockUserEventService.addResponse(resultOperation);

    String formattedParent =
        UserEventServiceClient.formatEventStoreName(
            "[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
    String requestId = "requestId37109963";
    InputConfig inputConfig = InputConfig.newBuilder().build();
    ImportErrorsConfig errorsConfig = ImportErrorsConfig.newBuilder().build();

    ImportUserEventsResponse actualResponse =
        client.importUserEventsAsync(formattedParent, requestId, inputConfig, errorsConfig).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockUserEventService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportUserEventsRequest actualRequest = (ImportUserEventsRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
    Assert.assertEquals(requestId, actualRequest.getRequestId());
    Assert.assertEquals(inputConfig, actualRequest.getInputConfig());
    Assert.assertEquals(errorsConfig, actualRequest.getErrorsConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void importUserEventsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockUserEventService.addException(exception);

    try {
      String formattedParent =
          UserEventServiceClient.formatEventStoreName(
              "[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
      String requestId = "requestId37109963";
      InputConfig inputConfig = InputConfig.newBuilder().build();
      ImportErrorsConfig errorsConfig = ImportErrorsConfig.newBuilder().build();

      client.importUserEventsAsync(formattedParent, requestId, inputConfig, errorsConfig).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
