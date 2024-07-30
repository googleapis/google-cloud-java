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

package com.google.cloud.privilegedaccessmanager.v1;

import static com.google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManagerClient.ListEntitlementsPagedResponse;
import static com.google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManagerClient.ListGrantsPagedResponse;
import static com.google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManagerClient.ListLocationsPagedResponse;
import static com.google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManagerClient.SearchEntitlementsPagedResponse;
import static com.google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManagerClient.SearchGrantsPagedResponse;

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
import com.google.protobuf.Duration;
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
public class PrivilegedAccessManagerClientTest {
  private static MockLocations mockLocations;
  private static MockPrivilegedAccessManager mockPrivilegedAccessManager;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private PrivilegedAccessManagerClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockPrivilegedAccessManager = new MockPrivilegedAccessManager();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockPrivilegedAccessManager, mockLocations));
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
    PrivilegedAccessManagerSettings settings =
        PrivilegedAccessManagerSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = PrivilegedAccessManagerClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void checkOnboardingStatusTest() throws Exception {
    CheckOnboardingStatusResponse expectedResponse =
        CheckOnboardingStatusResponse.newBuilder()
            .setServiceAccount("serviceAccount1079137720")
            .addAllFindings(new ArrayList<CheckOnboardingStatusResponse.Finding>())
            .build();
    mockPrivilegedAccessManager.addResponse(expectedResponse);

    CheckOnboardingStatusRequest request =
        CheckOnboardingStatusRequest.newBuilder()
            .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .build();

    CheckOnboardingStatusResponse actualResponse = client.checkOnboardingStatus(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPrivilegedAccessManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CheckOnboardingStatusRequest actualRequest =
        ((CheckOnboardingStatusRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void checkOnboardingStatusExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPrivilegedAccessManager.addException(exception);

    try {
      CheckOnboardingStatusRequest request =
          CheckOnboardingStatusRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .build();
      client.checkOnboardingStatus(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEntitlementsTest() throws Exception {
    Entitlement responsesElement = Entitlement.newBuilder().build();
    ListEntitlementsResponse expectedResponse =
        ListEntitlementsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEntitlements(Arrays.asList(responsesElement))
            .build();
    mockPrivilegedAccessManager.addResponse(expectedResponse);

    FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");

    ListEntitlementsPagedResponse pagedListResponse = client.listEntitlements(parent);

    List<Entitlement> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEntitlementsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPrivilegedAccessManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEntitlementsRequest actualRequest = ((ListEntitlementsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEntitlementsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPrivilegedAccessManager.addException(exception);

    try {
      FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
      client.listEntitlements(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEntitlementsTest2() throws Exception {
    Entitlement responsesElement = Entitlement.newBuilder().build();
    ListEntitlementsResponse expectedResponse =
        ListEntitlementsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEntitlements(Arrays.asList(responsesElement))
            .build();
    mockPrivilegedAccessManager.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListEntitlementsPagedResponse pagedListResponse = client.listEntitlements(parent);

    List<Entitlement> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEntitlementsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPrivilegedAccessManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEntitlementsRequest actualRequest = ((ListEntitlementsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEntitlementsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPrivilegedAccessManager.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listEntitlements(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEntitlementsTest3() throws Exception {
    Entitlement responsesElement = Entitlement.newBuilder().build();
    ListEntitlementsResponse expectedResponse =
        ListEntitlementsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEntitlements(Arrays.asList(responsesElement))
            .build();
    mockPrivilegedAccessManager.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListEntitlementsPagedResponse pagedListResponse = client.listEntitlements(parent);

    List<Entitlement> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEntitlementsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPrivilegedAccessManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEntitlementsRequest actualRequest = ((ListEntitlementsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEntitlementsExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPrivilegedAccessManager.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listEntitlements(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEntitlementsTest4() throws Exception {
    Entitlement responsesElement = Entitlement.newBuilder().build();
    ListEntitlementsResponse expectedResponse =
        ListEntitlementsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEntitlements(Arrays.asList(responsesElement))
            .build();
    mockPrivilegedAccessManager.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListEntitlementsPagedResponse pagedListResponse = client.listEntitlements(parent);

    List<Entitlement> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEntitlementsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPrivilegedAccessManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEntitlementsRequest actualRequest = ((ListEntitlementsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEntitlementsExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPrivilegedAccessManager.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listEntitlements(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchEntitlementsTest() throws Exception {
    Entitlement responsesElement = Entitlement.newBuilder().build();
    SearchEntitlementsResponse expectedResponse =
        SearchEntitlementsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEntitlements(Arrays.asList(responsesElement))
            .build();
    mockPrivilegedAccessManager.addResponse(expectedResponse);

    SearchEntitlementsRequest request =
        SearchEntitlementsRequest.newBuilder()
            .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    SearchEntitlementsPagedResponse pagedListResponse = client.searchEntitlements(request);

    List<Entitlement> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEntitlementsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPrivilegedAccessManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchEntitlementsRequest actualRequest = ((SearchEntitlementsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getCallerAccessType(), actualRequest.getCallerAccessType());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchEntitlementsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPrivilegedAccessManager.addException(exception);

    try {
      SearchEntitlementsRequest request =
          SearchEntitlementsRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.searchEntitlements(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEntitlementTest() throws Exception {
    Entitlement expectedResponse =
        Entitlement.newBuilder()
            .setName(
                EntitlementName.ofProjectLocationEntitlementName(
                        "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllEligibleUsers(new ArrayList<AccessControlEntry>())
            .setApprovalWorkflow(ApprovalWorkflow.newBuilder().build())
            .setPrivilegedAccess(PrivilegedAccess.newBuilder().build())
            .setMaxRequestDuration(Duration.newBuilder().build())
            .setRequesterJustificationConfig(
                Entitlement.RequesterJustificationConfig.newBuilder().build())
            .setAdditionalNotificationTargets(
                Entitlement.AdditionalNotificationTargets.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockPrivilegedAccessManager.addResponse(expectedResponse);

    EntitlementName name =
        EntitlementName.ofProjectLocationEntitlementName(
            "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]");

    Entitlement actualResponse = client.getEntitlement(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPrivilegedAccessManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEntitlementRequest actualRequest = ((GetEntitlementRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEntitlementExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPrivilegedAccessManager.addException(exception);

    try {
      EntitlementName name =
          EntitlementName.ofProjectLocationEntitlementName(
              "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]");
      client.getEntitlement(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEntitlementTest2() throws Exception {
    Entitlement expectedResponse =
        Entitlement.newBuilder()
            .setName(
                EntitlementName.ofProjectLocationEntitlementName(
                        "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllEligibleUsers(new ArrayList<AccessControlEntry>())
            .setApprovalWorkflow(ApprovalWorkflow.newBuilder().build())
            .setPrivilegedAccess(PrivilegedAccess.newBuilder().build())
            .setMaxRequestDuration(Duration.newBuilder().build())
            .setRequesterJustificationConfig(
                Entitlement.RequesterJustificationConfig.newBuilder().build())
            .setAdditionalNotificationTargets(
                Entitlement.AdditionalNotificationTargets.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockPrivilegedAccessManager.addResponse(expectedResponse);

    String name = "name3373707";

    Entitlement actualResponse = client.getEntitlement(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPrivilegedAccessManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEntitlementRequest actualRequest = ((GetEntitlementRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEntitlementExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPrivilegedAccessManager.addException(exception);

    try {
      String name = "name3373707";
      client.getEntitlement(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEntitlementTest() throws Exception {
    Entitlement expectedResponse =
        Entitlement.newBuilder()
            .setName(
                EntitlementName.ofProjectLocationEntitlementName(
                        "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllEligibleUsers(new ArrayList<AccessControlEntry>())
            .setApprovalWorkflow(ApprovalWorkflow.newBuilder().build())
            .setPrivilegedAccess(PrivilegedAccess.newBuilder().build())
            .setMaxRequestDuration(Duration.newBuilder().build())
            .setRequesterJustificationConfig(
                Entitlement.RequesterJustificationConfig.newBuilder().build())
            .setAdditionalNotificationTargets(
                Entitlement.AdditionalNotificationTargets.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEntitlementTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockPrivilegedAccessManager.addResponse(resultOperation);

    FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
    Entitlement entitlement = Entitlement.newBuilder().build();
    String entitlementId = "entitlementId-1302274264";

    Entitlement actualResponse =
        client.createEntitlementAsync(parent, entitlement, entitlementId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPrivilegedAccessManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEntitlementRequest actualRequest = ((CreateEntitlementRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(entitlement, actualRequest.getEntitlement());
    Assert.assertEquals(entitlementId, actualRequest.getEntitlementId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEntitlementExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPrivilegedAccessManager.addException(exception);

    try {
      FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
      Entitlement entitlement = Entitlement.newBuilder().build();
      String entitlementId = "entitlementId-1302274264";
      client.createEntitlementAsync(parent, entitlement, entitlementId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createEntitlementTest2() throws Exception {
    Entitlement expectedResponse =
        Entitlement.newBuilder()
            .setName(
                EntitlementName.ofProjectLocationEntitlementName(
                        "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllEligibleUsers(new ArrayList<AccessControlEntry>())
            .setApprovalWorkflow(ApprovalWorkflow.newBuilder().build())
            .setPrivilegedAccess(PrivilegedAccess.newBuilder().build())
            .setMaxRequestDuration(Duration.newBuilder().build())
            .setRequesterJustificationConfig(
                Entitlement.RequesterJustificationConfig.newBuilder().build())
            .setAdditionalNotificationTargets(
                Entitlement.AdditionalNotificationTargets.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEntitlementTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockPrivilegedAccessManager.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Entitlement entitlement = Entitlement.newBuilder().build();
    String entitlementId = "entitlementId-1302274264";

    Entitlement actualResponse =
        client.createEntitlementAsync(parent, entitlement, entitlementId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPrivilegedAccessManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEntitlementRequest actualRequest = ((CreateEntitlementRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(entitlement, actualRequest.getEntitlement());
    Assert.assertEquals(entitlementId, actualRequest.getEntitlementId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEntitlementExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPrivilegedAccessManager.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Entitlement entitlement = Entitlement.newBuilder().build();
      String entitlementId = "entitlementId-1302274264";
      client.createEntitlementAsync(parent, entitlement, entitlementId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createEntitlementTest3() throws Exception {
    Entitlement expectedResponse =
        Entitlement.newBuilder()
            .setName(
                EntitlementName.ofProjectLocationEntitlementName(
                        "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllEligibleUsers(new ArrayList<AccessControlEntry>())
            .setApprovalWorkflow(ApprovalWorkflow.newBuilder().build())
            .setPrivilegedAccess(PrivilegedAccess.newBuilder().build())
            .setMaxRequestDuration(Duration.newBuilder().build())
            .setRequesterJustificationConfig(
                Entitlement.RequesterJustificationConfig.newBuilder().build())
            .setAdditionalNotificationTargets(
                Entitlement.AdditionalNotificationTargets.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEntitlementTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockPrivilegedAccessManager.addResponse(resultOperation);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
    Entitlement entitlement = Entitlement.newBuilder().build();
    String entitlementId = "entitlementId-1302274264";

    Entitlement actualResponse =
        client.createEntitlementAsync(parent, entitlement, entitlementId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPrivilegedAccessManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEntitlementRequest actualRequest = ((CreateEntitlementRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(entitlement, actualRequest.getEntitlement());
    Assert.assertEquals(entitlementId, actualRequest.getEntitlementId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEntitlementExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPrivilegedAccessManager.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      Entitlement entitlement = Entitlement.newBuilder().build();
      String entitlementId = "entitlementId-1302274264";
      client.createEntitlementAsync(parent, entitlement, entitlementId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createEntitlementTest4() throws Exception {
    Entitlement expectedResponse =
        Entitlement.newBuilder()
            .setName(
                EntitlementName.ofProjectLocationEntitlementName(
                        "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllEligibleUsers(new ArrayList<AccessControlEntry>())
            .setApprovalWorkflow(ApprovalWorkflow.newBuilder().build())
            .setPrivilegedAccess(PrivilegedAccess.newBuilder().build())
            .setMaxRequestDuration(Duration.newBuilder().build())
            .setRequesterJustificationConfig(
                Entitlement.RequesterJustificationConfig.newBuilder().build())
            .setAdditionalNotificationTargets(
                Entitlement.AdditionalNotificationTargets.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEntitlementTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockPrivilegedAccessManager.addResponse(resultOperation);

    String parent = "parent-995424086";
    Entitlement entitlement = Entitlement.newBuilder().build();
    String entitlementId = "entitlementId-1302274264";

    Entitlement actualResponse =
        client.createEntitlementAsync(parent, entitlement, entitlementId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPrivilegedAccessManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEntitlementRequest actualRequest = ((CreateEntitlementRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(entitlement, actualRequest.getEntitlement());
    Assert.assertEquals(entitlementId, actualRequest.getEntitlementId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEntitlementExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPrivilegedAccessManager.addException(exception);

    try {
      String parent = "parent-995424086";
      Entitlement entitlement = Entitlement.newBuilder().build();
      String entitlementId = "entitlementId-1302274264";
      client.createEntitlementAsync(parent, entitlement, entitlementId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteEntitlementTest() throws Exception {
    Entitlement expectedResponse =
        Entitlement.newBuilder()
            .setName(
                EntitlementName.ofProjectLocationEntitlementName(
                        "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllEligibleUsers(new ArrayList<AccessControlEntry>())
            .setApprovalWorkflow(ApprovalWorkflow.newBuilder().build())
            .setPrivilegedAccess(PrivilegedAccess.newBuilder().build())
            .setMaxRequestDuration(Duration.newBuilder().build())
            .setRequesterJustificationConfig(
                Entitlement.RequesterJustificationConfig.newBuilder().build())
            .setAdditionalNotificationTargets(
                Entitlement.AdditionalNotificationTargets.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteEntitlementTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockPrivilegedAccessManager.addResponse(resultOperation);

    EntitlementName name =
        EntitlementName.ofProjectLocationEntitlementName(
            "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]");

    Entitlement actualResponse = client.deleteEntitlementAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPrivilegedAccessManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEntitlementRequest actualRequest = ((DeleteEntitlementRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEntitlementExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPrivilegedAccessManager.addException(exception);

    try {
      EntitlementName name =
          EntitlementName.ofProjectLocationEntitlementName(
              "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]");
      client.deleteEntitlementAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteEntitlementTest2() throws Exception {
    Entitlement expectedResponse =
        Entitlement.newBuilder()
            .setName(
                EntitlementName.ofProjectLocationEntitlementName(
                        "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllEligibleUsers(new ArrayList<AccessControlEntry>())
            .setApprovalWorkflow(ApprovalWorkflow.newBuilder().build())
            .setPrivilegedAccess(PrivilegedAccess.newBuilder().build())
            .setMaxRequestDuration(Duration.newBuilder().build())
            .setRequesterJustificationConfig(
                Entitlement.RequesterJustificationConfig.newBuilder().build())
            .setAdditionalNotificationTargets(
                Entitlement.AdditionalNotificationTargets.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteEntitlementTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockPrivilegedAccessManager.addResponse(resultOperation);

    String name = "name3373707";

    Entitlement actualResponse = client.deleteEntitlementAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPrivilegedAccessManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEntitlementRequest actualRequest = ((DeleteEntitlementRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEntitlementExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPrivilegedAccessManager.addException(exception);

    try {
      String name = "name3373707";
      client.deleteEntitlementAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateEntitlementTest() throws Exception {
    Entitlement expectedResponse =
        Entitlement.newBuilder()
            .setName(
                EntitlementName.ofProjectLocationEntitlementName(
                        "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllEligibleUsers(new ArrayList<AccessControlEntry>())
            .setApprovalWorkflow(ApprovalWorkflow.newBuilder().build())
            .setPrivilegedAccess(PrivilegedAccess.newBuilder().build())
            .setMaxRequestDuration(Duration.newBuilder().build())
            .setRequesterJustificationConfig(
                Entitlement.RequesterJustificationConfig.newBuilder().build())
            .setAdditionalNotificationTargets(
                Entitlement.AdditionalNotificationTargets.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateEntitlementTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockPrivilegedAccessManager.addResponse(resultOperation);

    Entitlement entitlement = Entitlement.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Entitlement actualResponse = client.updateEntitlementAsync(entitlement, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPrivilegedAccessManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateEntitlementRequest actualRequest = ((UpdateEntitlementRequest) actualRequests.get(0));

    Assert.assertEquals(entitlement, actualRequest.getEntitlement());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateEntitlementExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPrivilegedAccessManager.addException(exception);

    try {
      Entitlement entitlement = Entitlement.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateEntitlementAsync(entitlement, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listGrantsTest() throws Exception {
    Grant responsesElement = Grant.newBuilder().build();
    ListGrantsResponse expectedResponse =
        ListGrantsResponse.newBuilder()
            .setNextPageToken("")
            .addAllGrants(Arrays.asList(responsesElement))
            .build();
    mockPrivilegedAccessManager.addResponse(expectedResponse);

    EntitlementName parent =
        EntitlementName.ofProjectLocationEntitlementName(
            "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]");

    ListGrantsPagedResponse pagedListResponse = client.listGrants(parent);

    List<Grant> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGrantsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPrivilegedAccessManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGrantsRequest actualRequest = ((ListGrantsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGrantsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPrivilegedAccessManager.addException(exception);

    try {
      EntitlementName parent =
          EntitlementName.ofProjectLocationEntitlementName(
              "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]");
      client.listGrants(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGrantsTest2() throws Exception {
    Grant responsesElement = Grant.newBuilder().build();
    ListGrantsResponse expectedResponse =
        ListGrantsResponse.newBuilder()
            .setNextPageToken("")
            .addAllGrants(Arrays.asList(responsesElement))
            .build();
    mockPrivilegedAccessManager.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListGrantsPagedResponse pagedListResponse = client.listGrants(parent);

    List<Grant> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGrantsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPrivilegedAccessManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGrantsRequest actualRequest = ((ListGrantsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGrantsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPrivilegedAccessManager.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listGrants(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchGrantsTest() throws Exception {
    Grant responsesElement = Grant.newBuilder().build();
    SearchGrantsResponse expectedResponse =
        SearchGrantsResponse.newBuilder()
            .setNextPageToken("")
            .addAllGrants(Arrays.asList(responsesElement))
            .build();
    mockPrivilegedAccessManager.addResponse(expectedResponse);

    SearchGrantsRequest request =
        SearchGrantsRequest.newBuilder()
            .setParent(
                EntitlementName.ofProjectLocationEntitlementName(
                        "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]")
                    .toString())
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    SearchGrantsPagedResponse pagedListResponse = client.searchGrants(request);

    List<Grant> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGrantsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPrivilegedAccessManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchGrantsRequest actualRequest = ((SearchGrantsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getCallerRelationship(), actualRequest.getCallerRelationship());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchGrantsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPrivilegedAccessManager.addException(exception);

    try {
      SearchGrantsRequest request =
          SearchGrantsRequest.newBuilder()
              .setParent(
                  EntitlementName.ofProjectLocationEntitlementName(
                          "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]")
                      .toString())
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.searchGrants(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGrantTest() throws Exception {
    Grant expectedResponse =
        Grant.newBuilder()
            .setName(
                GrantName.ofProjectLocationEntitlementGrantName(
                        "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]", "[GRANT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setRequester("requester693933948")
            .setRequestedDuration(Duration.newBuilder().build())
            .setJustification(Justification.newBuilder().build())
            .setTimeline(Grant.Timeline.newBuilder().build())
            .setPrivilegedAccess(PrivilegedAccess.newBuilder().build())
            .setAuditTrail(Grant.AuditTrail.newBuilder().build())
            .addAllAdditionalEmailRecipients(new ArrayList<String>())
            .setExternallyModified(true)
            .build();
    mockPrivilegedAccessManager.addResponse(expectedResponse);

    GrantName name =
        GrantName.ofProjectLocationEntitlementGrantName(
            "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]", "[GRANT]");

    Grant actualResponse = client.getGrant(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPrivilegedAccessManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGrantRequest actualRequest = ((GetGrantRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGrantExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPrivilegedAccessManager.addException(exception);

    try {
      GrantName name =
          GrantName.ofProjectLocationEntitlementGrantName(
              "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]", "[GRANT]");
      client.getGrant(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGrantTest2() throws Exception {
    Grant expectedResponse =
        Grant.newBuilder()
            .setName(
                GrantName.ofProjectLocationEntitlementGrantName(
                        "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]", "[GRANT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setRequester("requester693933948")
            .setRequestedDuration(Duration.newBuilder().build())
            .setJustification(Justification.newBuilder().build())
            .setTimeline(Grant.Timeline.newBuilder().build())
            .setPrivilegedAccess(PrivilegedAccess.newBuilder().build())
            .setAuditTrail(Grant.AuditTrail.newBuilder().build())
            .addAllAdditionalEmailRecipients(new ArrayList<String>())
            .setExternallyModified(true)
            .build();
    mockPrivilegedAccessManager.addResponse(expectedResponse);

    String name = "name3373707";

    Grant actualResponse = client.getGrant(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPrivilegedAccessManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGrantRequest actualRequest = ((GetGrantRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGrantExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPrivilegedAccessManager.addException(exception);

    try {
      String name = "name3373707";
      client.getGrant(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createGrantTest() throws Exception {
    Grant expectedResponse =
        Grant.newBuilder()
            .setName(
                GrantName.ofProjectLocationEntitlementGrantName(
                        "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]", "[GRANT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setRequester("requester693933948")
            .setRequestedDuration(Duration.newBuilder().build())
            .setJustification(Justification.newBuilder().build())
            .setTimeline(Grant.Timeline.newBuilder().build())
            .setPrivilegedAccess(PrivilegedAccess.newBuilder().build())
            .setAuditTrail(Grant.AuditTrail.newBuilder().build())
            .addAllAdditionalEmailRecipients(new ArrayList<String>())
            .setExternallyModified(true)
            .build();
    mockPrivilegedAccessManager.addResponse(expectedResponse);

    EntitlementName parent =
        EntitlementName.ofProjectLocationEntitlementName(
            "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]");
    Grant grant = Grant.newBuilder().build();

    Grant actualResponse = client.createGrant(parent, grant);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPrivilegedAccessManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGrantRequest actualRequest = ((CreateGrantRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(grant, actualRequest.getGrant());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createGrantExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPrivilegedAccessManager.addException(exception);

    try {
      EntitlementName parent =
          EntitlementName.ofProjectLocationEntitlementName(
              "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]");
      Grant grant = Grant.newBuilder().build();
      client.createGrant(parent, grant);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createGrantTest2() throws Exception {
    Grant expectedResponse =
        Grant.newBuilder()
            .setName(
                GrantName.ofProjectLocationEntitlementGrantName(
                        "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]", "[GRANT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setRequester("requester693933948")
            .setRequestedDuration(Duration.newBuilder().build())
            .setJustification(Justification.newBuilder().build())
            .setTimeline(Grant.Timeline.newBuilder().build())
            .setPrivilegedAccess(PrivilegedAccess.newBuilder().build())
            .setAuditTrail(Grant.AuditTrail.newBuilder().build())
            .addAllAdditionalEmailRecipients(new ArrayList<String>())
            .setExternallyModified(true)
            .build();
    mockPrivilegedAccessManager.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Grant grant = Grant.newBuilder().build();

    Grant actualResponse = client.createGrant(parent, grant);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPrivilegedAccessManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGrantRequest actualRequest = ((CreateGrantRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(grant, actualRequest.getGrant());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createGrantExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPrivilegedAccessManager.addException(exception);

    try {
      String parent = "parent-995424086";
      Grant grant = Grant.newBuilder().build();
      client.createGrant(parent, grant);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void approveGrantTest() throws Exception {
    Grant expectedResponse =
        Grant.newBuilder()
            .setName(
                GrantName.ofProjectLocationEntitlementGrantName(
                        "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]", "[GRANT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setRequester("requester693933948")
            .setRequestedDuration(Duration.newBuilder().build())
            .setJustification(Justification.newBuilder().build())
            .setTimeline(Grant.Timeline.newBuilder().build())
            .setPrivilegedAccess(PrivilegedAccess.newBuilder().build())
            .setAuditTrail(Grant.AuditTrail.newBuilder().build())
            .addAllAdditionalEmailRecipients(new ArrayList<String>())
            .setExternallyModified(true)
            .build();
    mockPrivilegedAccessManager.addResponse(expectedResponse);

    ApproveGrantRequest request =
        ApproveGrantRequest.newBuilder()
            .setName(
                GrantName.ofProjectLocationEntitlementGrantName(
                        "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]", "[GRANT]")
                    .toString())
            .setReason("reason-934964668")
            .build();

    Grant actualResponse = client.approveGrant(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPrivilegedAccessManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ApproveGrantRequest actualRequest = ((ApproveGrantRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getReason(), actualRequest.getReason());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void approveGrantExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPrivilegedAccessManager.addException(exception);

    try {
      ApproveGrantRequest request =
          ApproveGrantRequest.newBuilder()
              .setName(
                  GrantName.ofProjectLocationEntitlementGrantName(
                          "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]", "[GRANT]")
                      .toString())
              .setReason("reason-934964668")
              .build();
      client.approveGrant(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void denyGrantTest() throws Exception {
    Grant expectedResponse =
        Grant.newBuilder()
            .setName(
                GrantName.ofProjectLocationEntitlementGrantName(
                        "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]", "[GRANT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setRequester("requester693933948")
            .setRequestedDuration(Duration.newBuilder().build())
            .setJustification(Justification.newBuilder().build())
            .setTimeline(Grant.Timeline.newBuilder().build())
            .setPrivilegedAccess(PrivilegedAccess.newBuilder().build())
            .setAuditTrail(Grant.AuditTrail.newBuilder().build())
            .addAllAdditionalEmailRecipients(new ArrayList<String>())
            .setExternallyModified(true)
            .build();
    mockPrivilegedAccessManager.addResponse(expectedResponse);

    DenyGrantRequest request =
        DenyGrantRequest.newBuilder()
            .setName(
                GrantName.ofProjectLocationEntitlementGrantName(
                        "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]", "[GRANT]")
                    .toString())
            .setReason("reason-934964668")
            .build();

    Grant actualResponse = client.denyGrant(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPrivilegedAccessManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DenyGrantRequest actualRequest = ((DenyGrantRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getReason(), actualRequest.getReason());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void denyGrantExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPrivilegedAccessManager.addException(exception);

    try {
      DenyGrantRequest request =
          DenyGrantRequest.newBuilder()
              .setName(
                  GrantName.ofProjectLocationEntitlementGrantName(
                          "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]", "[GRANT]")
                      .toString())
              .setReason("reason-934964668")
              .build();
      client.denyGrant(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void revokeGrantTest() throws Exception {
    Grant expectedResponse =
        Grant.newBuilder()
            .setName(
                GrantName.ofProjectLocationEntitlementGrantName(
                        "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]", "[GRANT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setRequester("requester693933948")
            .setRequestedDuration(Duration.newBuilder().build())
            .setJustification(Justification.newBuilder().build())
            .setTimeline(Grant.Timeline.newBuilder().build())
            .setPrivilegedAccess(PrivilegedAccess.newBuilder().build())
            .setAuditTrail(Grant.AuditTrail.newBuilder().build())
            .addAllAdditionalEmailRecipients(new ArrayList<String>())
            .setExternallyModified(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("revokeGrantTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockPrivilegedAccessManager.addResponse(resultOperation);

    RevokeGrantRequest request =
        RevokeGrantRequest.newBuilder()
            .setName(
                GrantName.ofProjectLocationEntitlementGrantName(
                        "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]", "[GRANT]")
                    .toString())
            .setReason("reason-934964668")
            .build();

    Grant actualResponse = client.revokeGrantAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPrivilegedAccessManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RevokeGrantRequest actualRequest = ((RevokeGrantRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getReason(), actualRequest.getReason());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void revokeGrantExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPrivilegedAccessManager.addException(exception);

    try {
      RevokeGrantRequest request =
          RevokeGrantRequest.newBuilder()
              .setName(
                  GrantName.ofProjectLocationEntitlementGrantName(
                          "[PROJECT]", "[LOCATION]", "[ENTITLEMENT]", "[GRANT]")
                      .toString())
              .setReason("reason-934964668")
              .build();
      client.revokeGrantAsync(request).get();
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
