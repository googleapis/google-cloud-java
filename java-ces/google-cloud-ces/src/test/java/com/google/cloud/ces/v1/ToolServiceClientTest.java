/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.ces.v1;

import static com.google.cloud.ces.v1.ToolServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Struct;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
public class ToolServiceClientTest {
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private static MockToolService mockToolService;
  private LocalChannelProvider channelProvider;
  private ToolServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockToolService = new MockToolService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockToolService, mockLocations));
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
    ToolServiceSettings settings =
        ToolServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ToolServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void executeToolTest() throws Exception {
    ExecuteToolResponse expectedResponse =
        ExecuteToolResponse.newBuilder().setResponse(Struct.newBuilder().build()).build();
    mockToolService.addResponse(expectedResponse);

    ExecuteToolRequest request =
        ExecuteToolRequest.newBuilder()
            .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
            .setArgs(Struct.newBuilder().build())
            .build();

    ExecuteToolResponse actualResponse = client.executeTool(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockToolService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExecuteToolRequest actualRequest = ((ExecuteToolRequest) actualRequests.get(0));

    Assert.assertEquals(request.getTool(), actualRequest.getTool());
    Assert.assertEquals(request.getToolsetTool(), actualRequest.getToolsetTool());
    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getArgs(), actualRequest.getArgs());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void executeToolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockToolService.addException(exception);

    try {
      ExecuteToolRequest request =
          ExecuteToolRequest.newBuilder()
              .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
              .setArgs(Struct.newBuilder().build())
              .build();
      client.executeTool(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void retrieveToolSchemaTest() throws Exception {
    RetrieveToolSchemaResponse expectedResponse =
        RetrieveToolSchemaResponse.newBuilder()
            .setInputSchema(Schema.newBuilder().build())
            .setOutputSchema(Schema.newBuilder().build())
            .build();
    mockToolService.addResponse(expectedResponse);

    RetrieveToolSchemaRequest request =
        RetrieveToolSchemaRequest.newBuilder()
            .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
            .build();

    RetrieveToolSchemaResponse actualResponse = client.retrieveToolSchema(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockToolService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RetrieveToolSchemaRequest actualRequest = ((RetrieveToolSchemaRequest) actualRequests.get(0));

    Assert.assertEquals(request.getTool(), actualRequest.getTool());
    Assert.assertEquals(request.getToolsetTool(), actualRequest.getToolsetTool());
    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void retrieveToolSchemaExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockToolService.addException(exception);

    try {
      RetrieveToolSchemaRequest request =
          RetrieveToolSchemaRequest.newBuilder()
              .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
              .build();
      client.retrieveToolSchema(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void retrieveToolsTest() throws Exception {
    RetrieveToolsResponse expectedResponse =
        RetrieveToolsResponse.newBuilder().addAllTools(new ArrayList<Tool>()).build();
    mockToolService.addResponse(expectedResponse);

    RetrieveToolsRequest request =
        RetrieveToolsRequest.newBuilder()
            .setToolset(ToolsetName.of("[PROJECT]", "[LOCATION]", "[APP]", "[TOOLSET]").toString())
            .addAllToolIds(new ArrayList<String>())
            .build();

    RetrieveToolsResponse actualResponse = client.retrieveTools(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockToolService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RetrieveToolsRequest actualRequest = ((RetrieveToolsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getToolset(), actualRequest.getToolset());
    Assert.assertEquals(request.getToolIdsList(), actualRequest.getToolIdsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void retrieveToolsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockToolService.addException(exception);

    try {
      RetrieveToolsRequest request =
          RetrieveToolsRequest.newBuilder()
              .setToolset(
                  ToolsetName.of("[PROJECT]", "[LOCATION]", "[APP]", "[TOOLSET]").toString())
              .addAllToolIds(new ArrayList<String>())
              .build();
      client.retrieveTools(request);
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
