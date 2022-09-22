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
  private static MockAccessApproval mockAccessApproval;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private AccessApprovalAdminClient client;

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

    FolderName parent = FolderName.of("[FOLDER]");

    ListApprovalRequestsPagedResponse pagedListResponse = client.listApprovalRequests(parent);

    List<ApprovalRequest> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getApprovalRequestsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAccessApproval.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListApprovalRequestsMessage actualRequest =
        ((ListApprovalRequestsMessage) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
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
      FolderName parent = FolderName.of("[FOLDER]");
      client.listApprovalRequests(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listApprovalRequestsTest2() throws Exception {
    ApprovalRequest responsesElement = ApprovalRequest.newBuilder().build();
    ListApprovalRequestsResponse expectedResponse =
        ListApprovalRequestsResponse.newBuilder()
            .setNextPageToken("")
            .addAllApprovalRequests(Arrays.asList(responsesElement))
            .build();
    mockAccessApproval.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");

    ListApprovalRequestsPagedResponse pagedListResponse = client.listApprovalRequests(parent);

    List<ApprovalRequest> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getApprovalRequestsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAccessApproval.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListApprovalRequestsMessage actualRequest =
        ((ListApprovalRequestsMessage) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listApprovalRequestsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessApproval.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      client.listApprovalRequests(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listApprovalRequestsTest3() throws Exception {
    ApprovalRequest responsesElement = ApprovalRequest.newBuilder().build();
    ListApprovalRequestsResponse expectedResponse =
        ListApprovalRequestsResponse.newBuilder()
            .setNextPageToken("")
            .addAllApprovalRequests(Arrays.asList(responsesElement))
            .build();
    mockAccessApproval.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListApprovalRequestsPagedResponse pagedListResponse = client.listApprovalRequests(parent);

    List<ApprovalRequest> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getApprovalRequestsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAccessApproval.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListApprovalRequestsMessage actualRequest =
        ((ListApprovalRequestsMessage) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listApprovalRequestsExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessApproval.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listApprovalRequests(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listApprovalRequestsTest4() throws Exception {
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
  public void listApprovalRequestsExceptionTest4() throws Exception {
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
            .setName(
                ApprovalRequestName.ofProjectApprovalRequestName("[PROJECT]", "[APPROVAL_REQUEST]")
                    .toString())
            .setRequestedResourceName("requestedResourceName-1218563513")
            .setRequestedResourceProperties(ResourceProperties.newBuilder().build())
            .setRequestedReason(AccessReason.newBuilder().build())
            .setRequestedLocations(AccessLocations.newBuilder().build())
            .setRequestTime(Timestamp.newBuilder().build())
            .setRequestedExpiration(Timestamp.newBuilder().build())
            .build();
    mockAccessApproval.addResponse(expectedResponse);

    ApprovalRequestName name =
        ApprovalRequestName.ofProjectApprovalRequestName("[PROJECT]", "[APPROVAL_REQUEST]");

    ApprovalRequest actualResponse = client.getApprovalRequest(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccessApproval.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetApprovalRequestMessage actualRequest = ((GetApprovalRequestMessage) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
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
      ApprovalRequestName name =
          ApprovalRequestName.ofProjectApprovalRequestName("[PROJECT]", "[APPROVAL_REQUEST]");
      client.getApprovalRequest(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getApprovalRequestTest2() throws Exception {
    ApprovalRequest expectedResponse =
        ApprovalRequest.newBuilder()
            .setName(
                ApprovalRequestName.ofProjectApprovalRequestName("[PROJECT]", "[APPROVAL_REQUEST]")
                    .toString())
            .setRequestedResourceName("requestedResourceName-1218563513")
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
  public void getApprovalRequestExceptionTest2() throws Exception {
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
            .setName(
                ApprovalRequestName.ofProjectApprovalRequestName("[PROJECT]", "[APPROVAL_REQUEST]")
                    .toString())
            .setRequestedResourceName("requestedResourceName-1218563513")
            .setRequestedResourceProperties(ResourceProperties.newBuilder().build())
            .setRequestedReason(AccessReason.newBuilder().build())
            .setRequestedLocations(AccessLocations.newBuilder().build())
            .setRequestTime(Timestamp.newBuilder().build())
            .setRequestedExpiration(Timestamp.newBuilder().build())
            .build();
    mockAccessApproval.addResponse(expectedResponse);

    ApproveApprovalRequestMessage request =
        ApproveApprovalRequestMessage.newBuilder()
            .setName(
                ApprovalRequestName.ofProjectApprovalRequestName("[PROJECT]", "[APPROVAL_REQUEST]")
                    .toString())
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
              .setName(
                  ApprovalRequestName.ofProjectApprovalRequestName(
                          "[PROJECT]", "[APPROVAL_REQUEST]")
                      .toString())
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
            .setName(
                ApprovalRequestName.ofProjectApprovalRequestName("[PROJECT]", "[APPROVAL_REQUEST]")
                    .toString())
            .setRequestedResourceName("requestedResourceName-1218563513")
            .setRequestedResourceProperties(ResourceProperties.newBuilder().build())
            .setRequestedReason(AccessReason.newBuilder().build())
            .setRequestedLocations(AccessLocations.newBuilder().build())
            .setRequestTime(Timestamp.newBuilder().build())
            .setRequestedExpiration(Timestamp.newBuilder().build())
            .build();
    mockAccessApproval.addResponse(expectedResponse);

    DismissApprovalRequestMessage request =
        DismissApprovalRequestMessage.newBuilder()
            .setName(
                ApprovalRequestName.ofProjectApprovalRequestName("[PROJECT]", "[APPROVAL_REQUEST]")
                    .toString())
            .build();

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
          DismissApprovalRequestMessage.newBuilder()
              .setName(
                  ApprovalRequestName.ofProjectApprovalRequestName(
                          "[PROJECT]", "[APPROVAL_REQUEST]")
                      .toString())
              .build();
      client.dismissApprovalRequest(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void invalidateApprovalRequestTest() throws Exception {
    ApprovalRequest expectedResponse =
        ApprovalRequest.newBuilder()
            .setName(
                ApprovalRequestName.ofProjectApprovalRequestName("[PROJECT]", "[APPROVAL_REQUEST]")
                    .toString())
            .setRequestedResourceName("requestedResourceName-1218563513")
            .setRequestedResourceProperties(ResourceProperties.newBuilder().build())
            .setRequestedReason(AccessReason.newBuilder().build())
            .setRequestedLocations(AccessLocations.newBuilder().build())
            .setRequestTime(Timestamp.newBuilder().build())
            .setRequestedExpiration(Timestamp.newBuilder().build())
            .build();
    mockAccessApproval.addResponse(expectedResponse);

    InvalidateApprovalRequestMessage request =
        InvalidateApprovalRequestMessage.newBuilder()
            .setName(
                ApprovalRequestName.ofProjectApprovalRequestName("[PROJECT]", "[APPROVAL_REQUEST]")
                    .toString())
            .build();

    ApprovalRequest actualResponse = client.invalidateApprovalRequest(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccessApproval.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    InvalidateApprovalRequestMessage actualRequest =
        ((InvalidateApprovalRequestMessage) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void invalidateApprovalRequestExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessApproval.addException(exception);

    try {
      InvalidateApprovalRequestMessage request =
          InvalidateApprovalRequestMessage.newBuilder()
              .setName(
                  ApprovalRequestName.ofProjectApprovalRequestName(
                          "[PROJECT]", "[APPROVAL_REQUEST]")
                      .toString())
              .build();
      client.invalidateApprovalRequest(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAccessApprovalSettingsTest() throws Exception {
    AccessApprovalSettings expectedResponse =
        AccessApprovalSettings.newBuilder()
            .setName(AccessApprovalSettingsName.ofProjectName("[PROJECT]").toString())
            .addAllNotificationEmails(new ArrayList<String>())
            .addAllEnrolledServices(new ArrayList<EnrolledService>())
            .setEnrolledAncestor(true)
            .setActiveKeyVersion("activeKeyVersion1352190239")
            .setAncestorHasActiveKeyVersion(true)
            .setInvalidKeyVersion(true)
            .build();
    mockAccessApproval.addResponse(expectedResponse);

    AccessApprovalSettingsName name = AccessApprovalSettingsName.ofProjectName("[PROJECT]");

    AccessApprovalSettings actualResponse = client.getAccessApprovalSettings(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccessApproval.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAccessApprovalSettingsMessage actualRequest =
        ((GetAccessApprovalSettingsMessage) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
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
      AccessApprovalSettingsName name = AccessApprovalSettingsName.ofProjectName("[PROJECT]");
      client.getAccessApprovalSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAccessApprovalSettingsTest2() throws Exception {
    AccessApprovalSettings expectedResponse =
        AccessApprovalSettings.newBuilder()
            .setName(AccessApprovalSettingsName.ofProjectName("[PROJECT]").toString())
            .addAllNotificationEmails(new ArrayList<String>())
            .addAllEnrolledServices(new ArrayList<EnrolledService>())
            .setEnrolledAncestor(true)
            .setActiveKeyVersion("activeKeyVersion1352190239")
            .setAncestorHasActiveKeyVersion(true)
            .setInvalidKeyVersion(true)
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
  public void getAccessApprovalSettingsExceptionTest2() throws Exception {
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
            .setName(AccessApprovalSettingsName.ofProjectName("[PROJECT]").toString())
            .addAllNotificationEmails(new ArrayList<String>())
            .addAllEnrolledServices(new ArrayList<EnrolledService>())
            .setEnrolledAncestor(true)
            .setActiveKeyVersion("activeKeyVersion1352190239")
            .setAncestorHasActiveKeyVersion(true)
            .setInvalidKeyVersion(true)
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

    AccessApprovalSettingsName name = AccessApprovalSettingsName.ofProjectName("[PROJECT]");

    client.deleteAccessApprovalSettings(name);

    List<AbstractMessage> actualRequests = mockAccessApproval.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAccessApprovalSettingsMessage actualRequest =
        ((DeleteAccessApprovalSettingsMessage) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
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
      AccessApprovalSettingsName name = AccessApprovalSettingsName.ofProjectName("[PROJECT]");
      client.deleteAccessApprovalSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAccessApprovalSettingsTest2() throws Exception {
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
  public void deleteAccessApprovalSettingsExceptionTest2() throws Exception {
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

  @Test
  public void getAccessApprovalServiceAccountTest() throws Exception {
    AccessApprovalServiceAccount expectedResponse =
        AccessApprovalServiceAccount.newBuilder()
            .setName("name3373707")
            .setAccountEmail("accountEmail1067197807")
            .build();
    mockAccessApproval.addResponse(expectedResponse);

    String name = "name3373707";

    AccessApprovalServiceAccount actualResponse = client.getAccessApprovalServiceAccount(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAccessApproval.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAccessApprovalServiceAccountMessage actualRequest =
        ((GetAccessApprovalServiceAccountMessage) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAccessApprovalServiceAccountExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAccessApproval.addException(exception);

    try {
      String name = "name3373707";
      client.getAccessApprovalServiceAccount(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
