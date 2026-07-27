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
public class SqlDatabasesServiceClientTest {
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private static MockSqlDatabasesService mockSqlDatabasesService;
  private LocalChannelProvider channelProvider;
  private SqlDatabasesServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockSqlDatabasesService = new MockSqlDatabasesService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockSqlDatabasesService, mockLocations));
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
    SqlDatabasesServiceSettings settings =
        SqlDatabasesServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SqlDatabasesServiceClient.create(settings);
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
    mockSqlDatabasesService.addResponse(expectedResponse);

    SqlDatabasesDeleteRequest request =
        SqlDatabasesDeleteRequest.newBuilder()
            .setDatabase("database1789464955")
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .build();

    Operation actualResponse = client.delete(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlDatabasesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlDatabasesDeleteRequest actualRequest = ((SqlDatabasesDeleteRequest) actualRequests.get(0));

    Assert.assertEquals(request.getDatabase(), actualRequest.getDatabase());
    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlDatabasesService.addException(exception);

    try {
      SqlDatabasesDeleteRequest request =
          SqlDatabasesDeleteRequest.newBuilder()
              .setDatabase("database1789464955")
              .setInstance("instance555127957")
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
    Database expectedResponse =
        Database.newBuilder()
            .setKind("kind3292052")
            .setCharset("charset739074380")
            .setCollation("collation1880293257")
            .setEtag("etag3123477")
            .setName("name3373707")
            .setInstance("instance555127957")
            .setSelfLink("selfLink1191800166")
            .setProject("project-309310695")
            .build();
    mockSqlDatabasesService.addResponse(expectedResponse);

    SqlDatabasesGetRequest request =
        SqlDatabasesGetRequest.newBuilder()
            .setDatabase("database1789464955")
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .build();

    Database actualResponse = client.get(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlDatabasesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlDatabasesGetRequest actualRequest = ((SqlDatabasesGetRequest) actualRequests.get(0));

    Assert.assertEquals(request.getDatabase(), actualRequest.getDatabase());
    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlDatabasesService.addException(exception);

    try {
      SqlDatabasesGetRequest request =
          SqlDatabasesGetRequest.newBuilder()
              .setDatabase("database1789464955")
              .setInstance("instance555127957")
              .setProject("project-309310695")
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
    mockSqlDatabasesService.addResponse(expectedResponse);

    SqlDatabasesInsertRequest request =
        SqlDatabasesInsertRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .setBody(Database.newBuilder().build())
            .build();

    Operation actualResponse = client.insert(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlDatabasesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlDatabasesInsertRequest actualRequest = ((SqlDatabasesInsertRequest) actualRequests.get(0));

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
    mockSqlDatabasesService.addException(exception);

    try {
      SqlDatabasesInsertRequest request =
          SqlDatabasesInsertRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .setBody(Database.newBuilder().build())
              .build();
      client.insert(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTest() throws Exception {
    DatabasesListResponse expectedResponse =
        DatabasesListResponse.newBuilder()
            .setKind("kind3292052")
            .addAllItems(new ArrayList<Database>())
            .build();
    mockSqlDatabasesService.addResponse(expectedResponse);

    SqlDatabasesListRequest request =
        SqlDatabasesListRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .build();

    DatabasesListResponse actualResponse = client.list(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlDatabasesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlDatabasesListRequest actualRequest = ((SqlDatabasesListRequest) actualRequests.get(0));

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
    mockSqlDatabasesService.addException(exception);

    try {
      SqlDatabasesListRequest request =
          SqlDatabasesListRequest.newBuilder()
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
  public void patchTest() throws Exception {
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
    mockSqlDatabasesService.addResponse(expectedResponse);

    SqlDatabasesUpdateRequest request =
        SqlDatabasesUpdateRequest.newBuilder()
            .setDatabase("database1789464955")
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .setBody(Database.newBuilder().build())
            .build();

    Operation actualResponse = client.patch(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlDatabasesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlDatabasesUpdateRequest actualRequest = ((SqlDatabasesUpdateRequest) actualRequests.get(0));

    Assert.assertEquals(request.getDatabase(), actualRequest.getDatabase());
    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertEquals(request.getBody(), actualRequest.getBody());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void patchExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlDatabasesService.addException(exception);

    try {
      SqlDatabasesUpdateRequest request =
          SqlDatabasesUpdateRequest.newBuilder()
              .setDatabase("database1789464955")
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .setBody(Database.newBuilder().build())
              .build();
      client.patch(request);
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
    mockSqlDatabasesService.addResponse(expectedResponse);

    SqlDatabasesUpdateRequest request =
        SqlDatabasesUpdateRequest.newBuilder()
            .setDatabase("database1789464955")
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .setBody(Database.newBuilder().build())
            .build();

    Operation actualResponse = client.update(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlDatabasesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlDatabasesUpdateRequest actualRequest = ((SqlDatabasesUpdateRequest) actualRequests.get(0));

    Assert.assertEquals(request.getDatabase(), actualRequest.getDatabase());
    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertEquals(request.getBody(), actualRequest.getBody());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlDatabasesService.addException(exception);

    try {
      SqlDatabasesUpdateRequest request =
          SqlDatabasesUpdateRequest.newBuilder()
              .setDatabase("database1789464955")
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .setBody(Database.newBuilder().build())
              .build();
      client.update(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
