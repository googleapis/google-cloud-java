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

package com.google.cloud.discoveryengine.v1;

import com.google.api.HttpBody;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
public class UserEventServiceClientTest {
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private static MockUserEventService mockUserEventService;
  private LocalChannelProvider channelProvider;
  private UserEventServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockUserEventService = new MockUserEventService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockUserEventService, mockLocations));
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
  public void writeUserEventTest() throws Exception {
    UserEvent expectedResponse =
        UserEvent.newBuilder()
            .setEventType("eventType31430900")
            .setConversionType("conversionType989646192")
            .setUserPseudoId("userPseudoId-1155274652")
            .setEngine(
                EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]").toString())
            .setDataStore(
                DataStoreName.ofProjectLocationDataStoreName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                    .toString())
            .setEventTime(Timestamp.newBuilder().build())
            .setUserInfo(UserInfo.newBuilder().build())
            .setDirectUserRequest(true)
            .setSessionId("sessionId607796817")
            .setPageInfo(PageInfo.newBuilder().build())
            .setAttributionToken("attributionToken104706234")
            .setFilter("filter-1274492040")
            .addAllDocuments(new ArrayList<DocumentInfo>())
            .setPanel(PanelInfo.newBuilder().build())
            .setSearchInfo(SearchInfo.newBuilder().build())
            .setCompletionInfo(CompletionInfo.newBuilder().build())
            .setTransactionInfo(TransactionInfo.newBuilder().build())
            .addAllTagIds(new ArrayList<String>())
            .addAllPromotionIds(new ArrayList<String>())
            .putAllAttributes(new HashMap<String, CustomAttribute>())
            .setMediaInfo(MediaInfo.newBuilder().build())
            .addAllPanels(new ArrayList<PanelInfo>())
            .build();
    mockUserEventService.addResponse(expectedResponse);

    WriteUserEventRequest request =
        WriteUserEventRequest.newBuilder()
            .setParent(
                DataStoreName.ofProjectLocationDataStoreName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                    .toString())
            .setUserEvent(UserEvent.newBuilder().build())
            .setWriteAsync(true)
            .build();

    UserEvent actualResponse = client.writeUserEvent(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockUserEventService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    WriteUserEventRequest actualRequest = ((WriteUserEventRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getUserEvent(), actualRequest.getUserEvent());
    Assert.assertEquals(request.getWriteAsync(), actualRequest.getWriteAsync());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void writeUserEventExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUserEventService.addException(exception);

    try {
      WriteUserEventRequest request =
          WriteUserEventRequest.newBuilder()
              .setParent(
                  DataStoreName.ofProjectLocationDataStoreName(
                          "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                      .toString())
              .setUserEvent(UserEvent.newBuilder().build())
              .setWriteAsync(true)
              .build();
      client.writeUserEvent(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void collectUserEventTest() throws Exception {
    HttpBody expectedResponse =
        HttpBody.newBuilder()
            .setContentType("contentType-389131437")
            .setData(ByteString.EMPTY)
            .addAllExtensions(new ArrayList<Any>())
            .build();
    mockUserEventService.addResponse(expectedResponse);

    CollectUserEventRequest request =
        CollectUserEventRequest.newBuilder()
            .setParent(
                DataStoreName.ofProjectLocationDataStoreName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                    .toString())
            .setUserEvent("userEvent315571599")
            .setUri("uri116076")
            .setEts(100772)
            .build();

    HttpBody actualResponse = client.collectUserEvent(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockUserEventService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CollectUserEventRequest actualRequest = ((CollectUserEventRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getUserEvent(), actualRequest.getUserEvent());
    Assert.assertEquals(request.getUri(), actualRequest.getUri());
    Assert.assertEquals(request.getEts(), actualRequest.getEts());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void collectUserEventExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUserEventService.addException(exception);

    try {
      CollectUserEventRequest request =
          CollectUserEventRequest.newBuilder()
              .setParent(
                  DataStoreName.ofProjectLocationDataStoreName(
                          "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                      .toString())
              .setUserEvent("userEvent315571599")
              .setUri("uri116076")
              .setEts(100772)
              .build();
      client.collectUserEvent(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void purgeUserEventsTest() throws Exception {
    PurgeUserEventsResponse expectedResponse =
        PurgeUserEventsResponse.newBuilder().setPurgeCount(575305851).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("purgeUserEventsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockUserEventService.addResponse(resultOperation);

    PurgeUserEventsRequest request =
        PurgeUserEventsRequest.newBuilder()
            .setParent(
                DataStoreName.ofProjectLocationDataStoreName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                    .toString())
            .setFilter("filter-1274492040")
            .setForce(true)
            .build();

    PurgeUserEventsResponse actualResponse = client.purgeUserEventsAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockUserEventService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PurgeUserEventsRequest actualRequest = ((PurgeUserEventsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getForce(), actualRequest.getForce());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void purgeUserEventsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUserEventService.addException(exception);

    try {
      PurgeUserEventsRequest request =
          PurgeUserEventsRequest.newBuilder()
              .setParent(
                  DataStoreName.ofProjectLocationDataStoreName(
                          "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                      .toString())
              .setFilter("filter-1274492040")
              .setForce(true)
              .build();
      client.purgeUserEventsAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void importUserEventsTest() throws Exception {
    ImportUserEventsResponse expectedResponse =
        ImportUserEventsResponse.newBuilder()
            .addAllErrorSamples(new ArrayList<Status>())
            .setErrorConfig(ImportErrorConfig.newBuilder().build())
            .setJoinedEventsCount(-720068705)
            .setUnjoinedEventsCount(512159846)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importUserEventsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockUserEventService.addResponse(resultOperation);

    ImportUserEventsRequest request =
        ImportUserEventsRequest.newBuilder()
            .setParent(
                DataStoreName.ofProjectLocationDataStoreName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                    .toString())
            .setErrorConfig(ImportErrorConfig.newBuilder().build())
            .build();

    ImportUserEventsResponse actualResponse = client.importUserEventsAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockUserEventService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportUserEventsRequest actualRequest = ((ImportUserEventsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInlineSource(), actualRequest.getInlineSource());
    Assert.assertEquals(request.getGcsSource(), actualRequest.getGcsSource());
    Assert.assertEquals(request.getBigquerySource(), actualRequest.getBigquerySource());
    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getErrorConfig(), actualRequest.getErrorConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importUserEventsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUserEventService.addException(exception);

    try {
      ImportUserEventsRequest request =
          ImportUserEventsRequest.newBuilder()
              .setParent(
                  DataStoreName.ofProjectLocationDataStoreName(
                          "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                      .toString())
              .setErrorConfig(ImportErrorConfig.newBuilder().build())
              .build();
      client.importUserEventsAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
