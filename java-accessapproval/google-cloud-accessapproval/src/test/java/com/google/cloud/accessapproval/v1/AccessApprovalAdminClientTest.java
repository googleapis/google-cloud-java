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

package com.google.cloud.accessapproval.v1;

import static com.google.cloud.accessapproval.v1.AccessApprovalAdminClient.ListApprovalRequestsPagedResponse;

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
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
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
public class AccessApprovalAdminClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockAccessApproval mockAccessApproval;
  private AccessApprovalAdminClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockAccessApproval = new MockAccessApproval();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockAccessApproval));
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
    AccessApprovalAdminSettings settings =
        AccessApprovalAdminSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AccessApprovalAdminClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listApprovalRequestsTest() throws Exception {
    ApprovalRequest responsesElement = ApprovalRequest.newBuilder().build();
    ListApprovalRequestsResponse expectedResponse =
        ListApprovalRequestsResponse.newBuilder()
            .setNextPageToken("")
            .addAllApprovalRequests(Arrays.asList(responsesElement))
            .build();
    mockAccessApproval.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListApprovalRequestsPagedResponse pagedListResponse = client.listApprovalRequests(parent);

    List<ApprovalRequest> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getApprovalRequestsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAccessApproval.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListApprovalRequestsMessage actualRequest =
        ((ListApprovalRequestsMessage) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listApprovalRequestsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessApproval.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listApprovalRequests(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getApprovalRequestTest() throws Exception {
    ApprovalRequest expectedResponse =
        ApprovalRequest.newBuilder()
            .setName("name3373707")
            .setRequestedResourceName("requested_resource_name-1409378037")
            .setRequestedResourceProperties(ResourceProperties.newBuilder().build())
            .setRequestedReason(AccessReason.newBuilder().build())
            .setRequestedLocations(AccessLocations.newBuilder().build())
            .setRequestTime(Timestamp.newBuilder().build())
            .setRequestedExpiration(Timestamp.newBuilder().build())
            .build();
    mockAccessApproval.addResponse(expectedResponse);

    String name = "name3373707";

    ApprovalRequest actualResponse = client.getApprovalRequest(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccessApproval.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetApprovalRequestMessage actualRequest = ((GetApprovalRequestMessage) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getApprovalRequestExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessApproval.addException(exception);

    try {
      String name = "name3373707";
      client.getApprovalRequest(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void approveApprovalRequestTest() throws Exception {
    ApprovalRequest expectedResponse =
        ApprovalRequest.newBuilder()
            .setName("name3373707")
            .setRequestedResourceName("requested_resource_name-1409378037")
            .setRequestedResourceProperties(ResourceProperties.newBuilder().build())
            .setRequestedReason(AccessReason.newBuilder().build())
            .setRequestedLocations(AccessLocations.newBuilder().build())
            .setRequestTime(Timestamp.newBuilder().build())
            .setRequestedExpiration(Timestamp.newBuilder().build())
            .build();
    mockAccessApproval.addResponse(expectedResponse);

    ApproveApprovalRequestMessage request =
        ApproveApprovalRequestMessage.newBuilder()
            .setName("name3373707")
            .setExpireTime(Timestamp.newBuilder().build())
            .build();

    ApprovalRequest actualResponse = client.approveApprovalRequest(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccessApproval.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ApproveApprovalRequestMessage actualRequest =
        ((ApproveApprovalRequestMessage) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getExpireTime(), actualRequest.getExpireTime());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void approveApprovalRequestExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessApproval.addException(exception);

    try {
      ApproveApprovalRequestMessage request =
          ApproveApprovalRequestMessage.newBuilder()
              .setName("name3373707")
              .setExpireTime(Timestamp.newBuilder().build())
              .build();
      client.approveApprovalRequest(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void dismissApprovalRequestTest() throws Exception {
    ApprovalRequest expectedResponse =
        ApprovalRequest.newBuilder()
            .setName("name3373707")
            .setRequestedResourceName("requested_resource_name-1409378037")
            .setRequestedResourceProperties(ResourceProperties.newBuilder().build())
            .setRequestedReason(AccessReason.newBuilder().build())
            .setRequestedLocations(AccessLocations.newBuilder().build())
            .setRequestTime(Timestamp.newBuilder().build())
            .setRequestedExpiration(Timestamp.newBuilder().build())
            .build();
    mockAccessApproval.addResponse(expectedResponse);

    DismissApprovalRequestMessage request =
        DismissApprovalRequestMessage.newBuilder().setName("name3373707").build();

    ApprovalRequest actualResponse = client.dismissApprovalRequest(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccessApproval.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DismissApprovalRequestMessage actualRequest =
        ((DismissApprovalRequestMessage) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void dismissApprovalRequestExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessApproval.addException(exception);

    try {
      DismissApprovalRequestMessage request =
          DismissApprovalRequestMessage.newBuilder().setName("name3373707").build();
      client.dismissApprovalRequest(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAccessApprovalSettingsTest() throws Exception {
    AccessApprovalSettings expectedResponse =
        AccessApprovalSettings.newBuilder()
            .setName("name3373707")
            .addAllNotificationEmails(new ArrayList<String>())
            .addAllEnrolledServices(new ArrayList<EnrolledService>())
            .setEnrolledAncestor(true)
            .build();
    mockAccessApproval.addResponse(expectedResponse);

    String name = "name3373707";

    AccessApprovalSettings actualResponse = client.getAccessApprovalSettings(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccessApproval.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAccessApprovalSettingsMessage actualRequest =
        ((GetAccessApprovalSettingsMessage) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAccessApprovalSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessApproval.addException(exception);

    try {
      String name = "name3373707";
      client.getAccessApprovalSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateAccessApprovalSettingsTest() throws Exception {
    AccessApprovalSettings expectedResponse =
        AccessApprovalSettings.newBuilder()
            .setName("name3373707")
            .addAllNotificationEmails(new ArrayList<String>())
            .addAllEnrolledServices(new ArrayList<EnrolledService>())
            .setEnrolledAncestor(true)
            .build();
    mockAccessApproval.addResponse(expectedResponse);

    AccessApprovalSettings settings = AccessApprovalSettings.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    AccessApprovalSettings actualResponse =
        client.updateAccessApprovalSettings(settings, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccessApproval.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAccessApprovalSettingsMessage actualRequest =
        ((UpdateAccessApprovalSettingsMessage) actualRequests.get(0));

    Assert.assertEquals(settings, actualRequest.getSettings());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateAccessApprovalSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessApproval.addException(exception);

    try {
      AccessApprovalSettings settings = AccessApprovalSettings.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAccessApprovalSettings(settings, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAccessApprovalSettingsTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAccessApproval.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteAccessApprovalSettings(name);

    List<AbstractMessage> actualRequests = mockAccessApproval.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAccessApprovalSettingsMessage actualRequest =
        ((DeleteAccessApprovalSettingsMessage) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAccessApprovalSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessApproval.addException(exception);

    try {
      String name = "name3373707";
      client.deleteAccessApprovalSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
