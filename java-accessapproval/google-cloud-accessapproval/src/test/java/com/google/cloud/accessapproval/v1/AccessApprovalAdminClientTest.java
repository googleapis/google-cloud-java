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
public class AccessApprovalAdminClientTest {
  private static MockAccessApproval mockAccessApproval;
  private static MockServiceHelper serviceHelper;
  private AccessApprovalAdminClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockAccessApproval = new MockAccessApproval();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockAccessApproval));
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
  @SuppressWarnings("all")
  public void listApprovalRequestsTest() {
    String nextPageToken = "";
    ApprovalRequest approvalRequestsElement = ApprovalRequest.newBuilder().build();
    List<ApprovalRequest> approvalRequests = Arrays.asList(approvalRequestsElement);
    ListApprovalRequestsResponse expectedResponse =
        ListApprovalRequestsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllApprovalRequests(approvalRequests)
            .build();
    mockAccessApproval.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListApprovalRequestsPagedResponse pagedListResponse = client.listApprovalRequests(parent);

    List<ApprovalRequest> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getApprovalRequestsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAccessApproval.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListApprovalRequestsMessage actualRequest = (ListApprovalRequestsMessage) actualRequests.get(0);

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listApprovalRequestsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAccessApproval.addException(exception);

    try {
      String parent = "parent-995424086";

      client.listApprovalRequests(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getApprovalRequestTest() {
    String name2 = "name2-1052831874";
    String requestedResourceName = "requestedResourceName-1409378037";
    ApprovalRequest expectedResponse =
        ApprovalRequest.newBuilder()
            .setName(name2)
            .setRequestedResourceName(requestedResourceName)
            .build();
    mockAccessApproval.addResponse(expectedResponse);

    String name = "name3373707";

    ApprovalRequest actualResponse = client.getApprovalRequest(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccessApproval.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetApprovalRequestMessage actualRequest = (GetApprovalRequestMessage) actualRequests.get(0);

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getApprovalRequestExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAccessApproval.addException(exception);

    try {
      String name = "name3373707";

      client.getApprovalRequest(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void approveApprovalRequestTest() {
    String name = "name3373707";
    String requestedResourceName = "requestedResourceName-1409378037";
    ApprovalRequest expectedResponse =
        ApprovalRequest.newBuilder()
            .setName(name)
            .setRequestedResourceName(requestedResourceName)
            .build();
    mockAccessApproval.addResponse(expectedResponse);

    ApproveApprovalRequestMessage request = ApproveApprovalRequestMessage.newBuilder().build();

    ApprovalRequest actualResponse = client.approveApprovalRequest(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccessApproval.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ApproveApprovalRequestMessage actualRequest =
        (ApproveApprovalRequestMessage) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void approveApprovalRequestExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAccessApproval.addException(exception);

    try {
      ApproveApprovalRequestMessage request = ApproveApprovalRequestMessage.newBuilder().build();

      client.approveApprovalRequest(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void dismissApprovalRequestTest() {
    String name = "name3373707";
    String requestedResourceName = "requestedResourceName-1409378037";
    ApprovalRequest expectedResponse =
        ApprovalRequest.newBuilder()
            .setName(name)
            .setRequestedResourceName(requestedResourceName)
            .build();
    mockAccessApproval.addResponse(expectedResponse);

    DismissApprovalRequestMessage request = DismissApprovalRequestMessage.newBuilder().build();

    ApprovalRequest actualResponse = client.dismissApprovalRequest(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccessApproval.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DismissApprovalRequestMessage actualRequest =
        (DismissApprovalRequestMessage) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void dismissApprovalRequestExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAccessApproval.addException(exception);

    try {
      DismissApprovalRequestMessage request = DismissApprovalRequestMessage.newBuilder().build();

      client.dismissApprovalRequest(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getAccessApprovalSettingsTest() {
    String name2 = "name2-1052831874";
    boolean enrolledAncestor = false;
    AccessApprovalSettings expectedResponse =
        AccessApprovalSettings.newBuilder()
            .setName(name2)
            .setEnrolledAncestor(enrolledAncestor)
            .build();
    mockAccessApproval.addResponse(expectedResponse);

    String name = "name3373707";

    AccessApprovalSettings actualResponse = client.getAccessApprovalSettings(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccessApproval.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAccessApprovalSettingsMessage actualRequest =
        (GetAccessApprovalSettingsMessage) actualRequests.get(0);

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getAccessApprovalSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAccessApproval.addException(exception);

    try {
      String name = "name3373707";

      client.getAccessApprovalSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateAccessApprovalSettingsTest() {
    String name = "name3373707";
    boolean enrolledAncestor = false;
    AccessApprovalSettings expectedResponse =
        AccessApprovalSettings.newBuilder()
            .setName(name)
            .setEnrolledAncestor(enrolledAncestor)
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
        (UpdateAccessApprovalSettingsMessage) actualRequests.get(0);

    Assert.assertEquals(settings, actualRequest.getSettings());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateAccessApprovalSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAccessApproval.addException(exception);

    try {
      AccessApprovalSettings settings = AccessApprovalSettings.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateAccessApprovalSettings(settings, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteAccessApprovalSettingsTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAccessApproval.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteAccessApprovalSettings(name);

    List<AbstractMessage> actualRequests = mockAccessApproval.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAccessApprovalSettingsMessage actualRequest =
        (DeleteAccessApprovalSettingsMessage) actualRequests.get(0);

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteAccessApprovalSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockAccessApproval.addException(exception);

    try {
      String name = "name3373707";

      client.deleteAccessApprovalSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
