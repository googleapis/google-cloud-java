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

package com.google.cloud.apihub.v1;

import static com.google.cloud.apihub.v1.RuntimeProjectAttachmentServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.apihub.v1.RuntimeProjectAttachmentServiceClient.ListRuntimeProjectAttachmentsPagedResponse;

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
import com.google.protobuf.Empty;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
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
public class RuntimeProjectAttachmentServiceClientTest {
  private static MockLocations mockLocations;
  private static MockRuntimeProjectAttachmentService mockRuntimeProjectAttachmentService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private RuntimeProjectAttachmentServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockRuntimeProjectAttachmentService = new MockRuntimeProjectAttachmentService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockRuntimeProjectAttachmentService, mockLocations));
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
    RuntimeProjectAttachmentServiceSettings settings =
        RuntimeProjectAttachmentServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = RuntimeProjectAttachmentServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createRuntimeProjectAttachmentTest() throws Exception {
    RuntimeProjectAttachment expectedResponse =
        RuntimeProjectAttachment.newBuilder()
            .setName(
                RuntimeProjectAttachmentName.of(
                        "[PROJECT]", "[LOCATION]", "[RUNTIME_PROJECT_ATTACHMENT]")
                    .toString())
            .setRuntimeProject("runtimeProject-58847199")
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockRuntimeProjectAttachmentService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    RuntimeProjectAttachment runtimeProjectAttachment =
        RuntimeProjectAttachment.newBuilder().build();
    String runtimeProjectAttachmentId = "runtimeProjectAttachmentId-753213345";

    RuntimeProjectAttachment actualResponse =
        client.createRuntimeProjectAttachment(
            parent, runtimeProjectAttachment, runtimeProjectAttachmentId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRuntimeProjectAttachmentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateRuntimeProjectAttachmentRequest actualRequest =
        ((CreateRuntimeProjectAttachmentRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(runtimeProjectAttachment, actualRequest.getRuntimeProjectAttachment());
    Assert.assertEquals(runtimeProjectAttachmentId, actualRequest.getRuntimeProjectAttachmentId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createRuntimeProjectAttachmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRuntimeProjectAttachmentService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      RuntimeProjectAttachment runtimeProjectAttachment =
          RuntimeProjectAttachment.newBuilder().build();
      String runtimeProjectAttachmentId = "runtimeProjectAttachmentId-753213345";
      client.createRuntimeProjectAttachment(
          parent, runtimeProjectAttachment, runtimeProjectAttachmentId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createRuntimeProjectAttachmentTest2() throws Exception {
    RuntimeProjectAttachment expectedResponse =
        RuntimeProjectAttachment.newBuilder()
            .setName(
                RuntimeProjectAttachmentName.of(
                        "[PROJECT]", "[LOCATION]", "[RUNTIME_PROJECT_ATTACHMENT]")
                    .toString())
            .setRuntimeProject("runtimeProject-58847199")
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockRuntimeProjectAttachmentService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    RuntimeProjectAttachment runtimeProjectAttachment =
        RuntimeProjectAttachment.newBuilder().build();
    String runtimeProjectAttachmentId = "runtimeProjectAttachmentId-753213345";

    RuntimeProjectAttachment actualResponse =
        client.createRuntimeProjectAttachment(
            parent, runtimeProjectAttachment, runtimeProjectAttachmentId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRuntimeProjectAttachmentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateRuntimeProjectAttachmentRequest actualRequest =
        ((CreateRuntimeProjectAttachmentRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(runtimeProjectAttachment, actualRequest.getRuntimeProjectAttachment());
    Assert.assertEquals(runtimeProjectAttachmentId, actualRequest.getRuntimeProjectAttachmentId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createRuntimeProjectAttachmentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRuntimeProjectAttachmentService.addException(exception);

    try {
      String parent = "parent-995424086";
      RuntimeProjectAttachment runtimeProjectAttachment =
          RuntimeProjectAttachment.newBuilder().build();
      String runtimeProjectAttachmentId = "runtimeProjectAttachmentId-753213345";
      client.createRuntimeProjectAttachment(
          parent, runtimeProjectAttachment, runtimeProjectAttachmentId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRuntimeProjectAttachmentTest() throws Exception {
    RuntimeProjectAttachment expectedResponse =
        RuntimeProjectAttachment.newBuilder()
            .setName(
                RuntimeProjectAttachmentName.of(
                        "[PROJECT]", "[LOCATION]", "[RUNTIME_PROJECT_ATTACHMENT]")
                    .toString())
            .setRuntimeProject("runtimeProject-58847199")
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockRuntimeProjectAttachmentService.addResponse(expectedResponse);

    RuntimeProjectAttachmentName name =
        RuntimeProjectAttachmentName.of("[PROJECT]", "[LOCATION]", "[RUNTIME_PROJECT_ATTACHMENT]");

    RuntimeProjectAttachment actualResponse = client.getRuntimeProjectAttachment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRuntimeProjectAttachmentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRuntimeProjectAttachmentRequest actualRequest =
        ((GetRuntimeProjectAttachmentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRuntimeProjectAttachmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRuntimeProjectAttachmentService.addException(exception);

    try {
      RuntimeProjectAttachmentName name =
          RuntimeProjectAttachmentName.of(
              "[PROJECT]", "[LOCATION]", "[RUNTIME_PROJECT_ATTACHMENT]");
      client.getRuntimeProjectAttachment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRuntimeProjectAttachmentTest2() throws Exception {
    RuntimeProjectAttachment expectedResponse =
        RuntimeProjectAttachment.newBuilder()
            .setName(
                RuntimeProjectAttachmentName.of(
                        "[PROJECT]", "[LOCATION]", "[RUNTIME_PROJECT_ATTACHMENT]")
                    .toString())
            .setRuntimeProject("runtimeProject-58847199")
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockRuntimeProjectAttachmentService.addResponse(expectedResponse);

    String name = "name3373707";

    RuntimeProjectAttachment actualResponse = client.getRuntimeProjectAttachment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRuntimeProjectAttachmentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRuntimeProjectAttachmentRequest actualRequest =
        ((GetRuntimeProjectAttachmentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRuntimeProjectAttachmentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRuntimeProjectAttachmentService.addException(exception);

    try {
      String name = "name3373707";
      client.getRuntimeProjectAttachment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRuntimeProjectAttachmentsTest() throws Exception {
    RuntimeProjectAttachment responsesElement = RuntimeProjectAttachment.newBuilder().build();
    ListRuntimeProjectAttachmentsResponse expectedResponse =
        ListRuntimeProjectAttachmentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRuntimeProjectAttachments(Arrays.asList(responsesElement))
            .build();
    mockRuntimeProjectAttachmentService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListRuntimeProjectAttachmentsPagedResponse pagedListResponse =
        client.listRuntimeProjectAttachments(parent);

    List<RuntimeProjectAttachment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getRuntimeProjectAttachmentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRuntimeProjectAttachmentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRuntimeProjectAttachmentsRequest actualRequest =
        ((ListRuntimeProjectAttachmentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRuntimeProjectAttachmentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRuntimeProjectAttachmentService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listRuntimeProjectAttachments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRuntimeProjectAttachmentsTest2() throws Exception {
    RuntimeProjectAttachment responsesElement = RuntimeProjectAttachment.newBuilder().build();
    ListRuntimeProjectAttachmentsResponse expectedResponse =
        ListRuntimeProjectAttachmentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRuntimeProjectAttachments(Arrays.asList(responsesElement))
            .build();
    mockRuntimeProjectAttachmentService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListRuntimeProjectAttachmentsPagedResponse pagedListResponse =
        client.listRuntimeProjectAttachments(parent);

    List<RuntimeProjectAttachment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getRuntimeProjectAttachmentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRuntimeProjectAttachmentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRuntimeProjectAttachmentsRequest actualRequest =
        ((ListRuntimeProjectAttachmentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRuntimeProjectAttachmentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRuntimeProjectAttachmentService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listRuntimeProjectAttachments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteRuntimeProjectAttachmentTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockRuntimeProjectAttachmentService.addResponse(expectedResponse);

    RuntimeProjectAttachmentName name =
        RuntimeProjectAttachmentName.of("[PROJECT]", "[LOCATION]", "[RUNTIME_PROJECT_ATTACHMENT]");

    client.deleteRuntimeProjectAttachment(name);

    List<AbstractMessage> actualRequests = mockRuntimeProjectAttachmentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRuntimeProjectAttachmentRequest actualRequest =
        ((DeleteRuntimeProjectAttachmentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRuntimeProjectAttachmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRuntimeProjectAttachmentService.addException(exception);

    try {
      RuntimeProjectAttachmentName name =
          RuntimeProjectAttachmentName.of(
              "[PROJECT]", "[LOCATION]", "[RUNTIME_PROJECT_ATTACHMENT]");
      client.deleteRuntimeProjectAttachment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteRuntimeProjectAttachmentTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockRuntimeProjectAttachmentService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteRuntimeProjectAttachment(name);

    List<AbstractMessage> actualRequests = mockRuntimeProjectAttachmentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRuntimeProjectAttachmentRequest actualRequest =
        ((DeleteRuntimeProjectAttachmentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRuntimeProjectAttachmentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRuntimeProjectAttachmentService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteRuntimeProjectAttachment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void lookupRuntimeProjectAttachmentTest() throws Exception {
    LookupRuntimeProjectAttachmentResponse expectedResponse =
        LookupRuntimeProjectAttachmentResponse.newBuilder()
            .setRuntimeProjectAttachment(RuntimeProjectAttachment.newBuilder().build())
            .build();
    mockRuntimeProjectAttachmentService.addResponse(expectedResponse);

    LocationName name = LocationName.of("[PROJECT]", "[LOCATION]");

    LookupRuntimeProjectAttachmentResponse actualResponse =
        client.lookupRuntimeProjectAttachment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRuntimeProjectAttachmentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LookupRuntimeProjectAttachmentRequest actualRequest =
        ((LookupRuntimeProjectAttachmentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void lookupRuntimeProjectAttachmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRuntimeProjectAttachmentService.addException(exception);

    try {
      LocationName name = LocationName.of("[PROJECT]", "[LOCATION]");
      client.lookupRuntimeProjectAttachment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void lookupRuntimeProjectAttachmentTest2() throws Exception {
    LookupRuntimeProjectAttachmentResponse expectedResponse =
        LookupRuntimeProjectAttachmentResponse.newBuilder()
            .setRuntimeProjectAttachment(RuntimeProjectAttachment.newBuilder().build())
            .build();
    mockRuntimeProjectAttachmentService.addResponse(expectedResponse);

    String name = "name3373707";

    LookupRuntimeProjectAttachmentResponse actualResponse =
        client.lookupRuntimeProjectAttachment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRuntimeProjectAttachmentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LookupRuntimeProjectAttachmentRequest actualRequest =
        ((LookupRuntimeProjectAttachmentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void lookupRuntimeProjectAttachmentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRuntimeProjectAttachmentService.addException(exception);

    try {
      String name = "name3373707";
      client.lookupRuntimeProjectAttachment(name);
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
