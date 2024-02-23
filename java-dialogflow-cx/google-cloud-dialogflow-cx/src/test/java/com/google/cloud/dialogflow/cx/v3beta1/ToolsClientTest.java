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

package com.google.cloud.dialogflow.cx.v3beta1;

import static com.google.cloud.dialogflow.cx.v3beta1.ToolsClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3beta1.ToolsClient.ListToolsPagedResponse;

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
public class ToolsClientTest {
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private static MockTools mockTools;
  private LocalChannelProvider channelProvider;
  private ToolsClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockTools = new MockTools();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockTools, mockLocations));
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
    ToolsSettings settings =
        ToolsSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ToolsClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createToolTest() throws Exception {
    Tool expectedResponse =
        Tool.newBuilder()
            .setName(ToolName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[TOOL]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllActions(new ArrayList<String>())
            .addAllSchemas(new ArrayList<String>())
            .build();
    mockTools.addResponse(expectedResponse);

    AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
    Tool tool = Tool.newBuilder().build();

    Tool actualResponse = client.createTool(parent, tool);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTools.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateToolRequest actualRequest = ((CreateToolRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(tool, actualRequest.getTool());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createToolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTools.addException(exception);

    try {
      AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
      Tool tool = Tool.newBuilder().build();
      client.createTool(parent, tool);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createToolTest2() throws Exception {
    Tool expectedResponse =
        Tool.newBuilder()
            .setName(ToolName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[TOOL]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllActions(new ArrayList<String>())
            .addAllSchemas(new ArrayList<String>())
            .build();
    mockTools.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Tool tool = Tool.newBuilder().build();

    Tool actualResponse = client.createTool(parent, tool);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTools.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateToolRequest actualRequest = ((CreateToolRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(tool, actualRequest.getTool());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createToolExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTools.addException(exception);

    try {
      String parent = "parent-995424086";
      Tool tool = Tool.newBuilder().build();
      client.createTool(parent, tool);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listToolsTest() throws Exception {
    Tool responsesElement = Tool.newBuilder().build();
    ListToolsResponse expectedResponse =
        ListToolsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTools(Arrays.asList(responsesElement))
            .build();
    mockTools.addResponse(expectedResponse);

    AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");

    ListToolsPagedResponse pagedListResponse = client.listTools(parent);

    List<Tool> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getToolsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTools.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListToolsRequest actualRequest = ((ListToolsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listToolsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTools.addException(exception);

    try {
      AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
      client.listTools(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listToolsTest2() throws Exception {
    Tool responsesElement = Tool.newBuilder().build();
    ListToolsResponse expectedResponse =
        ListToolsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTools(Arrays.asList(responsesElement))
            .build();
    mockTools.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListToolsPagedResponse pagedListResponse = client.listTools(parent);

    List<Tool> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getToolsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTools.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListToolsRequest actualRequest = ((ListToolsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listToolsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTools.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listTools(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void exportToolsTest() throws Exception {
    ExportToolsResponse expectedResponse = ExportToolsResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportToolsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockTools.addResponse(resultOperation);

    ExportToolsRequest request =
        ExportToolsRequest.newBuilder()
            .setParent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
            .addAllTools(new ArrayList<String>())
            .build();

    ExportToolsResponse actualResponse = client.exportToolsAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTools.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportToolsRequest actualRequest = ((ExportToolsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getToolsList(), actualRequest.getToolsList());
    Assert.assertEquals(request.getToolsUri(), actualRequest.getToolsUri());
    Assert.assertEquals(request.getToolsContentInline(), actualRequest.getToolsContentInline());
    Assert.assertEquals(request.getDataFormat(), actualRequest.getDataFormat());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportToolsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTools.addException(exception);

    try {
      ExportToolsRequest request =
          ExportToolsRequest.newBuilder()
              .setParent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
              .addAllTools(new ArrayList<String>())
              .build();
      client.exportToolsAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getToolTest() throws Exception {
    Tool expectedResponse =
        Tool.newBuilder()
            .setName(ToolName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[TOOL]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllActions(new ArrayList<String>())
            .addAllSchemas(new ArrayList<String>())
            .build();
    mockTools.addResponse(expectedResponse);

    ToolName name = ToolName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[TOOL]");

    Tool actualResponse = client.getTool(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTools.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetToolRequest actualRequest = ((GetToolRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getToolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTools.addException(exception);

    try {
      ToolName name = ToolName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[TOOL]");
      client.getTool(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getToolTest2() throws Exception {
    Tool expectedResponse =
        Tool.newBuilder()
            .setName(ToolName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[TOOL]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllActions(new ArrayList<String>())
            .addAllSchemas(new ArrayList<String>())
            .build();
    mockTools.addResponse(expectedResponse);

    String name = "name3373707";

    Tool actualResponse = client.getTool(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTools.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetToolRequest actualRequest = ((GetToolRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getToolExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTools.addException(exception);

    try {
      String name = "name3373707";
      client.getTool(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateToolTest() throws Exception {
    Tool expectedResponse =
        Tool.newBuilder()
            .setName(ToolName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[TOOL]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllActions(new ArrayList<String>())
            .addAllSchemas(new ArrayList<String>())
            .build();
    mockTools.addResponse(expectedResponse);

    Tool tool = Tool.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Tool actualResponse = client.updateTool(tool, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTools.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateToolRequest actualRequest = ((UpdateToolRequest) actualRequests.get(0));

    Assert.assertEquals(tool, actualRequest.getTool());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateToolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTools.addException(exception);

    try {
      Tool tool = Tool.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateTool(tool, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteToolTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockTools.addResponse(expectedResponse);

    ToolName name = ToolName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[TOOL]");

    client.deleteTool(name);

    List<AbstractMessage> actualRequests = mockTools.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteToolRequest actualRequest = ((DeleteToolRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteToolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTools.addException(exception);

    try {
      ToolName name = ToolName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[TOOL]");
      client.deleteTool(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteToolTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockTools.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteTool(name);

    List<AbstractMessage> actualRequests = mockTools.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteToolRequest actualRequest = ((DeleteToolRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteToolExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTools.addException(exception);

    try {
      String name = "name3373707";
      client.deleteTool(name);
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
