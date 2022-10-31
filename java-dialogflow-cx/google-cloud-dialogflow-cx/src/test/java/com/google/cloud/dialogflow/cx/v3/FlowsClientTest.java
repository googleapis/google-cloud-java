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

package com.google.cloud.dialogflow.cx.v3;

import static com.google.cloud.dialogflow.cx.v3.FlowsClient.ListFlowsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3.FlowsClient.ListLocationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
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
public class FlowsClientTest {
  private static MockFlows mockFlows;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private FlowsClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockFlows = new MockFlows();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockFlows, mockLocations));
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
    FlowsSettings settings =
        FlowsSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = FlowsClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createFlowTest() throws Exception {
    Flow expectedResponse =
        Flow.newBuilder()
            .setName(FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllTransitionRoutes(new ArrayList<TransitionRoute>())
            .addAllEventHandlers(new ArrayList<EventHandler>())
            .addAllTransitionRouteGroups(new ArrayList<String>())
            .setNluSettings(NluSettings.newBuilder().build())
            .build();
    mockFlows.addResponse(expectedResponse);

    AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
    Flow flow = Flow.newBuilder().build();

    Flow actualResponse = client.createFlow(parent, flow);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFlows.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateFlowRequest actualRequest = ((CreateFlowRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(flow, actualRequest.getFlow());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createFlowExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFlows.addException(exception);

    try {
      AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
      Flow flow = Flow.newBuilder().build();
      client.createFlow(parent, flow);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createFlowTest2() throws Exception {
    Flow expectedResponse =
        Flow.newBuilder()
            .setName(FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllTransitionRoutes(new ArrayList<TransitionRoute>())
            .addAllEventHandlers(new ArrayList<EventHandler>())
            .addAllTransitionRouteGroups(new ArrayList<String>())
            .setNluSettings(NluSettings.newBuilder().build())
            .build();
    mockFlows.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Flow flow = Flow.newBuilder().build();

    Flow actualResponse = client.createFlow(parent, flow);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFlows.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateFlowRequest actualRequest = ((CreateFlowRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(flow, actualRequest.getFlow());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createFlowExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFlows.addException(exception);

    try {
      String parent = "parent-995424086";
      Flow flow = Flow.newBuilder().build();
      client.createFlow(parent, flow);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteFlowTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockFlows.addResponse(expectedResponse);

    FlowName name = FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]");

    client.deleteFlow(name);

    List<AbstractMessage> actualRequests = mockFlows.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteFlowRequest actualRequest = ((DeleteFlowRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteFlowExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFlows.addException(exception);

    try {
      FlowName name = FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]");
      client.deleteFlow(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteFlowTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockFlows.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteFlow(name);

    List<AbstractMessage> actualRequests = mockFlows.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteFlowRequest actualRequest = ((DeleteFlowRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteFlowExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFlows.addException(exception);

    try {
      String name = "name3373707";
      client.deleteFlow(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFlowsTest() throws Exception {
    Flow responsesElement = Flow.newBuilder().build();
    ListFlowsResponse expectedResponse =
        ListFlowsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFlows(Arrays.asList(responsesElement))
            .build();
    mockFlows.addResponse(expectedResponse);

    AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");

    ListFlowsPagedResponse pagedListResponse = client.listFlows(parent);

    List<Flow> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFlowsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockFlows.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFlowsRequest actualRequest = ((ListFlowsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFlowsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFlows.addException(exception);

    try {
      AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
      client.listFlows(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFlowsTest2() throws Exception {
    Flow responsesElement = Flow.newBuilder().build();
    ListFlowsResponse expectedResponse =
        ListFlowsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFlows(Arrays.asList(responsesElement))
            .build();
    mockFlows.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListFlowsPagedResponse pagedListResponse = client.listFlows(parent);

    List<Flow> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFlowsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockFlows.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFlowsRequest actualRequest = ((ListFlowsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFlowsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFlows.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listFlows(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFlowTest() throws Exception {
    Flow expectedResponse =
        Flow.newBuilder()
            .setName(FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllTransitionRoutes(new ArrayList<TransitionRoute>())
            .addAllEventHandlers(new ArrayList<EventHandler>())
            .addAllTransitionRouteGroups(new ArrayList<String>())
            .setNluSettings(NluSettings.newBuilder().build())
            .build();
    mockFlows.addResponse(expectedResponse);

    FlowName name = FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]");

    Flow actualResponse = client.getFlow(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFlows.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFlowRequest actualRequest = ((GetFlowRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFlowExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFlows.addException(exception);

    try {
      FlowName name = FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]");
      client.getFlow(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFlowTest2() throws Exception {
    Flow expectedResponse =
        Flow.newBuilder()
            .setName(FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllTransitionRoutes(new ArrayList<TransitionRoute>())
            .addAllEventHandlers(new ArrayList<EventHandler>())
            .addAllTransitionRouteGroups(new ArrayList<String>())
            .setNluSettings(NluSettings.newBuilder().build())
            .build();
    mockFlows.addResponse(expectedResponse);

    String name = "name3373707";

    Flow actualResponse = client.getFlow(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFlows.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFlowRequest actualRequest = ((GetFlowRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFlowExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFlows.addException(exception);

    try {
      String name = "name3373707";
      client.getFlow(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateFlowTest() throws Exception {
    Flow expectedResponse =
        Flow.newBuilder()
            .setName(FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllTransitionRoutes(new ArrayList<TransitionRoute>())
            .addAllEventHandlers(new ArrayList<EventHandler>())
            .addAllTransitionRouteGroups(new ArrayList<String>())
            .setNluSettings(NluSettings.newBuilder().build())
            .build();
    mockFlows.addResponse(expectedResponse);

    Flow flow = Flow.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Flow actualResponse = client.updateFlow(flow, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFlows.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateFlowRequest actualRequest = ((UpdateFlowRequest) actualRequests.get(0));

    Assert.assertEquals(flow, actualRequest.getFlow());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateFlowExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFlows.addException(exception);

    try {
      Flow flow = Flow.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateFlow(flow, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void trainFlowTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("trainFlowTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockFlows.addResponse(resultOperation);

    FlowName name = FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]");

    client.trainFlowAsync(name).get();

    List<AbstractMessage> actualRequests = mockFlows.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TrainFlowRequest actualRequest = ((TrainFlowRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void trainFlowExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFlows.addException(exception);

    try {
      FlowName name = FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]");
      client.trainFlowAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void trainFlowTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("trainFlowTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockFlows.addResponse(resultOperation);

    String name = "name3373707";

    client.trainFlowAsync(name).get();

    List<AbstractMessage> actualRequests = mockFlows.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TrainFlowRequest actualRequest = ((TrainFlowRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void trainFlowExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFlows.addException(exception);

    try {
      String name = "name3373707";
      client.trainFlowAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void validateFlowTest() throws Exception {
    FlowValidationResult expectedResponse =
        FlowValidationResult.newBuilder()
            .setName(
                FlowValidationResultName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]")
                    .toString())
            .addAllValidationMessages(new ArrayList<ValidationMessage>())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockFlows.addResponse(expectedResponse);

    ValidateFlowRequest request =
        ValidateFlowRequest.newBuilder()
            .setName(FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]").toString())
            .setLanguageCode("languageCode-2092349083")
            .build();

    FlowValidationResult actualResponse = client.validateFlow(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFlows.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ValidateFlowRequest actualRequest = ((ValidateFlowRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getLanguageCode(), actualRequest.getLanguageCode());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void validateFlowExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFlows.addException(exception);

    try {
      ValidateFlowRequest request =
          ValidateFlowRequest.newBuilder()
              .setName(FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]").toString())
              .setLanguageCode("languageCode-2092349083")
              .build();
      client.validateFlow(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFlowValidationResultTest() throws Exception {
    FlowValidationResult expectedResponse =
        FlowValidationResult.newBuilder()
            .setName(
                FlowValidationResultName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]")
                    .toString())
            .addAllValidationMessages(new ArrayList<ValidationMessage>())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockFlows.addResponse(expectedResponse);

    FlowValidationResultName name =
        FlowValidationResultName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]");

    FlowValidationResult actualResponse = client.getFlowValidationResult(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFlows.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFlowValidationResultRequest actualRequest =
        ((GetFlowValidationResultRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFlowValidationResultExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFlows.addException(exception);

    try {
      FlowValidationResultName name =
          FlowValidationResultName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]");
      client.getFlowValidationResult(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFlowValidationResultTest2() throws Exception {
    FlowValidationResult expectedResponse =
        FlowValidationResult.newBuilder()
            .setName(
                FlowValidationResultName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]")
                    .toString())
            .addAllValidationMessages(new ArrayList<ValidationMessage>())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockFlows.addResponse(expectedResponse);

    String name = "name3373707";

    FlowValidationResult actualResponse = client.getFlowValidationResult(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFlows.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFlowValidationResultRequest actualRequest =
        ((GetFlowValidationResultRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFlowValidationResultExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFlows.addException(exception);

    try {
      String name = "name3373707";
      client.getFlowValidationResult(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void importFlowTest() throws Exception {
    ImportFlowResponse expectedResponse =
        ImportFlowResponse.newBuilder()
            .setFlow(FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]").toString())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importFlowTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockFlows.addResponse(resultOperation);

    ImportFlowRequest request =
        ImportFlowRequest.newBuilder()
            .setParent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
            .build();

    ImportFlowResponse actualResponse = client.importFlowAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFlows.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportFlowRequest actualRequest = ((ImportFlowRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getFlowUri(), actualRequest.getFlowUri());
    Assert.assertEquals(request.getFlowContent(), actualRequest.getFlowContent());
    Assert.assertEquals(request.getImportOption(), actualRequest.getImportOption());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importFlowExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFlows.addException(exception);

    try {
      ImportFlowRequest request =
          ImportFlowRequest.newBuilder()
              .setParent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
              .build();
      client.importFlowAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void exportFlowTest() throws Exception {
    ExportFlowResponse expectedResponse = ExportFlowResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportFlowTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockFlows.addResponse(resultOperation);

    ExportFlowRequest request =
        ExportFlowRequest.newBuilder()
            .setName(FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]").toString())
            .setFlowUri("flowUri-765815458")
            .setIncludeReferencedFlows(true)
            .build();

    ExportFlowResponse actualResponse = client.exportFlowAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFlows.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportFlowRequest actualRequest = ((ExportFlowRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getFlowUri(), actualRequest.getFlowUri());
    Assert.assertEquals(
        request.getIncludeReferencedFlows(), actualRequest.getIncludeReferencedFlows());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportFlowExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFlows.addException(exception);

    try {
      ExportFlowRequest request =
          ExportFlowRequest.newBuilder()
              .setName(FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]").toString())
              .setFlowUri("flowUri-765815458")
              .setIncludeReferencedFlows(true)
              .build();
      client.exportFlowAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockLocations.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("name3373707")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLocationsRequest actualRequest = ((ListLocationsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLocationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("name3373707")
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
    mockLocations.addResponse(expectedResponse);

    GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();

    Location actualResponse = client.getLocation(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLocationRequest actualRequest = ((GetLocationRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLocationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
      client.getLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
