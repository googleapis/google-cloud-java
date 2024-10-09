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

package com.google.cloud.commerce.consumer.procurement.v1;

import static com.google.cloud.commerce.consumer.procurement.v1.LicenseManagementServiceClient.EnumerateLicensedUsersPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.FieldMask;
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
public class LicenseManagementServiceClientTest {
  private static MockLicenseManagementService mockLicenseManagementService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private LicenseManagementServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockLicenseManagementService = new MockLicenseManagementService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockLicenseManagementService));
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
    LicenseManagementServiceSettings settings =
        LicenseManagementServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = LicenseManagementServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getLicensePoolTest() throws Exception {
    LicensePool expectedResponse =
        LicensePool.newBuilder()
            .setName("name3373707")
            .setLicenseAssignmentProtocol(AssignmentProtocol.newBuilder().build())
            .setAvailableLicenseCount(387091611)
            .setTotalLicenseCount(-834147882)
            .build();
    mockLicenseManagementService.addResponse(expectedResponse);

    String name = "name3373707";

    LicensePool actualResponse = client.getLicensePool(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLicenseManagementService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLicensePoolRequest actualRequest = ((GetLicensePoolRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLicensePoolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLicenseManagementService.addException(exception);

    try {
      String name = "name3373707";
      client.getLicensePool(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateLicensePoolTest() throws Exception {
    LicensePool expectedResponse =
        LicensePool.newBuilder()
            .setName("name3373707")
            .setLicenseAssignmentProtocol(AssignmentProtocol.newBuilder().build())
            .setAvailableLicenseCount(387091611)
            .setTotalLicenseCount(-834147882)
            .build();
    mockLicenseManagementService.addResponse(expectedResponse);

    LicensePool licensePool = LicensePool.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    LicensePool actualResponse = client.updateLicensePool(licensePool, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLicenseManagementService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateLicensePoolRequest actualRequest = ((UpdateLicensePoolRequest) actualRequests.get(0));

    Assert.assertEquals(licensePool, actualRequest.getLicensePool());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateLicensePoolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLicenseManagementService.addException(exception);

    try {
      LicensePool licensePool = LicensePool.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateLicensePool(licensePool, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void assignTest() throws Exception {
    AssignResponse expectedResponse = AssignResponse.newBuilder().build();
    mockLicenseManagementService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    List<String> usernames = new ArrayList<>();

    AssignResponse actualResponse = client.assign(parent, usernames);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLicenseManagementService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AssignRequest actualRequest = ((AssignRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(usernames, actualRequest.getUsernamesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void assignExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLicenseManagementService.addException(exception);

    try {
      String parent = "parent-995424086";
      List<String> usernames = new ArrayList<>();
      client.assign(parent, usernames);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void unassignTest() throws Exception {
    UnassignResponse expectedResponse = UnassignResponse.newBuilder().build();
    mockLicenseManagementService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    List<String> usernames = new ArrayList<>();

    UnassignResponse actualResponse = client.unassign(parent, usernames);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLicenseManagementService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UnassignRequest actualRequest = ((UnassignRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(usernames, actualRequest.getUsernamesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void unassignExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLicenseManagementService.addException(exception);

    try {
      String parent = "parent-995424086";
      List<String> usernames = new ArrayList<>();
      client.unassign(parent, usernames);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void enumerateLicensedUsersTest() throws Exception {
    LicensedUser responsesElement = LicensedUser.newBuilder().build();
    EnumerateLicensedUsersResponse expectedResponse =
        EnumerateLicensedUsersResponse.newBuilder()
            .setNextPageToken("")
            .addAllLicensedUsers(Arrays.asList(responsesElement))
            .build();
    mockLicenseManagementService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    EnumerateLicensedUsersPagedResponse pagedListResponse = client.enumerateLicensedUsers(parent);

    List<LicensedUser> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLicensedUsersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLicenseManagementService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    EnumerateLicensedUsersRequest actualRequest =
        ((EnumerateLicensedUsersRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void enumerateLicensedUsersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLicenseManagementService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.enumerateLicensedUsers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
