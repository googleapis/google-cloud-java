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

package com.google.cloud.sql.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
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
public class SqlUsersServiceClientTest {
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private static MockSqlUsersService mockSqlUsersService;
  private LocalChannelProvider channelProvider;
  private SqlUsersServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockSqlUsersService = new MockSqlUsersService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockSqlUsersService, mockLocations));
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
    SqlUsersServiceSettings settings =
        SqlUsersServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SqlUsersServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void deleteTest() throws Exception {
    Operation expectedResponse =
        Operation.newBuilder()
            .setKind("kind3292052")
            .setTargetLink("targetLink486368555")
            .setUser("user3599307")
            .setInsertTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setError(OperationErrors.newBuilder().build())
            .setApiWarning(ApiWarning.newBuilder().build())
            .setImportContext(ImportContext.newBuilder().build())
            .setExportContext(ExportContext.newBuilder().build())
            .setBackupContext(BackupContext.newBuilder().build())
            .setPreCheckMajorVersionUpgradeContext(
                PreCheckMajorVersionUpgradeContext.newBuilder().build())
            .setName("name3373707")
            .setTargetId("targetId-441951604")
            .setSelfLink("selfLink1191800166")
            .setTargetProject("targetProject1994636360")
            .setAcquireSsrsLeaseContext(AcquireSsrsLeaseContext.newBuilder().build())
            .setSubOperationType(SqlSubOperationType.newBuilder().build())
            .build();
    mockSqlUsersService.addResponse(expectedResponse);

    SqlUsersDeleteRequest request =
        SqlUsersDeleteRequest.newBuilder()
            .setHost("host3208616")
            .setInstance("instance555127957")
            .setName("name3373707")
            .setProject("project-309310695")
            .build();

    Operation actualResponse = client.delete(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlUsersService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlUsersDeleteRequest actualRequest = ((SqlUsersDeleteRequest) actualRequests.get(0));

    Assert.assertEquals(request.getHost(), actualRequest.getHost());
    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlUsersService.addException(exception);

    try {
      SqlUsersDeleteRequest request =
          SqlUsersDeleteRequest.newBuilder()
              .setHost("host3208616")
              .setInstance("instance555127957")
              .setName("name3373707")
              .setProject("project-309310695")
              .build();
      client.delete(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTest() throws Exception {
    User expectedResponse =
        User.newBuilder()
            .setKind("kind3292052")
            .setPassword("password1216985755")
            .setEtag("etag3123477")
            .setName("name3373707")
            .setHost("host3208616")
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .setIamEmail("iamEmail1687646791")
            .setPasswordPolicy(UserPasswordValidationPolicy.newBuilder().build())
            .addAllDatabaseRoles(new ArrayList<String>())
            .addAllServerRoles(new ArrayList<String>())
            .build();
    mockSqlUsersService.addResponse(expectedResponse);

    SqlUsersGetRequest request =
        SqlUsersGetRequest.newBuilder()
            .setInstance("instance555127957")
            .setName("name3373707")
            .setProject("project-309310695")
            .setHost("host3208616")
            .build();

    User actualResponse = client.get(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlUsersService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlUsersGetRequest actualRequest = ((SqlUsersGetRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertEquals(request.getHost(), actualRequest.getHost());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlUsersService.addException(exception);

    try {
      SqlUsersGetRequest request =
          SqlUsersGetRequest.newBuilder()
              .setInstance("instance555127957")
              .setName("name3373707")
              .setProject("project-309310695")
              .setHost("host3208616")
              .build();
      client.get(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void insertTest() throws Exception {
    Operation expectedResponse =
        Operation.newBuilder()
            .setKind("kind3292052")
            .setTargetLink("targetLink486368555")
            .setUser("user3599307")
            .setInsertTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setError(OperationErrors.newBuilder().build())
            .setApiWarning(ApiWarning.newBuilder().build())
            .setImportContext(ImportContext.newBuilder().build())
            .setExportContext(ExportContext.newBuilder().build())
            .setBackupContext(BackupContext.newBuilder().build())
            .setPreCheckMajorVersionUpgradeContext(
                PreCheckMajorVersionUpgradeContext.newBuilder().build())
            .setName("name3373707")
            .setTargetId("targetId-441951604")
            .setSelfLink("selfLink1191800166")
            .setTargetProject("targetProject1994636360")
            .setAcquireSsrsLeaseContext(AcquireSsrsLeaseContext.newBuilder().build())
            .setSubOperationType(SqlSubOperationType.newBuilder().build())
            .build();
    mockSqlUsersService.addResponse(expectedResponse);

    SqlUsersInsertRequest request =
        SqlUsersInsertRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .setBody(User.newBuilder().build())
            .build();

    Operation actualResponse = client.insert(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlUsersService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlUsersInsertRequest actualRequest = ((SqlUsersInsertRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertEquals(request.getBody(), actualRequest.getBody());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void insertExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlUsersService.addException(exception);

    try {
      SqlUsersInsertRequest request =
          SqlUsersInsertRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .setBody(User.newBuilder().build())
              .build();
      client.insert(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTest() throws Exception {
    UsersListResponse expectedResponse =
        UsersListResponse.newBuilder()
            .setKind("kind3292052")
            .addAllItems(new ArrayList<User>())
            .setNextPageToken("nextPageToken-1386094857")
            .build();
    mockSqlUsersService.addResponse(expectedResponse);

    SqlUsersListRequest request =
        SqlUsersListRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .build();

    UsersListResponse actualResponse = client.list(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlUsersService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlUsersListRequest actualRequest = ((SqlUsersListRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlUsersService.addException(exception);

    try {
      SqlUsersListRequest request =
          SqlUsersListRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .build();
      client.list(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateTest() throws Exception {
    Operation expectedResponse =
        Operation.newBuilder()
            .setKind("kind3292052")
            .setTargetLink("targetLink486368555")
            .setUser("user3599307")
            .setInsertTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setError(OperationErrors.newBuilder().build())
            .setApiWarning(ApiWarning.newBuilder().build())
            .setImportContext(ImportContext.newBuilder().build())
            .setExportContext(ExportContext.newBuilder().build())
            .setBackupContext(BackupContext.newBuilder().build())
            .setPreCheckMajorVersionUpgradeContext(
                PreCheckMajorVersionUpgradeContext.newBuilder().build())
            .setName("name3373707")
            .setTargetId("targetId-441951604")
            .setSelfLink("selfLink1191800166")
            .setTargetProject("targetProject1994636360")
            .setAcquireSsrsLeaseContext(AcquireSsrsLeaseContext.newBuilder().build())
            .setSubOperationType(SqlSubOperationType.newBuilder().build())
            .build();
    mockSqlUsersService.addResponse(expectedResponse);

    SqlUsersUpdateRequest request =
        SqlUsersUpdateRequest.newBuilder()
            .setHost("host3208616")
            .setInstance("instance555127957")
            .setName("name3373707")
            .setProject("project-309310695")
            .addAllDatabaseRoles(new ArrayList<String>())
            .setRevokeExistingRoles(true)
            .addAllServerRoles(new ArrayList<String>())
            .setRevokeExistingServerRoles(true)
            .setBody(User.newBuilder().build())
            .build();

    Operation actualResponse = client.update(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlUsersService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlUsersUpdateRequest actualRequest = ((SqlUsersUpdateRequest) actualRequests.get(0));

    Assert.assertEquals(request.getHost(), actualRequest.getHost());
    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertEquals(request.getDatabaseRolesList(), actualRequest.getDatabaseRolesList());
    Assert.assertEquals(request.getRevokeExistingRoles(), actualRequest.getRevokeExistingRoles());
    Assert.assertEquals(request.getServerRolesList(), actualRequest.getServerRolesList());
    Assert.assertEquals(
        request.getRevokeExistingServerRoles(), actualRequest.getRevokeExistingServerRoles());
    Assert.assertEquals(request.getBody(), actualRequest.getBody());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlUsersService.addException(exception);

    try {
      SqlUsersUpdateRequest request =
          SqlUsersUpdateRequest.newBuilder()
              .setHost("host3208616")
              .setInstance("instance555127957")
              .setName("name3373707")
              .setProject("project-309310695")
              .addAllDatabaseRoles(new ArrayList<String>())
              .setRevokeExistingRoles(true)
              .addAllServerRoles(new ArrayList<String>())
              .setRevokeExistingServerRoles(true)
              .setBody(User.newBuilder().build())
              .build();
      client.update(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
