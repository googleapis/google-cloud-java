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
public class SqlBackupRunsServiceClientTest {
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private static MockSqlBackupRunsService mockSqlBackupRunsService;
  private LocalChannelProvider channelProvider;
  private SqlBackupRunsServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockSqlBackupRunsService = new MockSqlBackupRunsService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockSqlBackupRunsService, mockLocations));
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
    SqlBackupRunsServiceSettings settings =
        SqlBackupRunsServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SqlBackupRunsServiceClient.create(settings);
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
    mockSqlBackupRunsService.addResponse(expectedResponse);

    SqlBackupRunsDeleteRequest request =
        SqlBackupRunsDeleteRequest.newBuilder()
            .setId(3355)
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .build();

    Operation actualResponse = client.delete(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlBackupRunsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlBackupRunsDeleteRequest actualRequest = ((SqlBackupRunsDeleteRequest) actualRequests.get(0));

    Assert.assertEquals(request.getId(), actualRequest.getId());
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
    mockSqlBackupRunsService.addException(exception);

    try {
      SqlBackupRunsDeleteRequest request =
          SqlBackupRunsDeleteRequest.newBuilder()
              .setId(3355)
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
    BackupRun expectedResponse =
        BackupRun.newBuilder()
            .setKind("kind3292052")
            .setStatus(SqlBackupRunStatus.forNumber(0))
            .setEnqueuedTime(Timestamp.newBuilder().build())
            .setId(3355)
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setError(OperationError.newBuilder().build())
            .setType(SqlBackupRunType.forNumber(0))
            .setDescription("description-1724546052")
            .setWindowStartTime(Timestamp.newBuilder().build())
            .setInstance("instance555127957")
            .setSelfLink("selfLink1191800166")
            .setLocation("location1901043637")
            .setDatabaseVersion(SqlDatabaseVersion.forNumber(0))
            .setDiskEncryptionConfiguration(DiskEncryptionConfiguration.newBuilder().build())
            .setDiskEncryptionStatus(DiskEncryptionStatus.newBuilder().build())
            .setBackupKind(SqlBackupKind.forNumber(0))
            .setTimeZone("timeZone-2077180903")
            .setMaxChargeableBytes(-1424371595)
            .build();
    mockSqlBackupRunsService.addResponse(expectedResponse);

    SqlBackupRunsGetRequest request =
        SqlBackupRunsGetRequest.newBuilder()
            .setId(3355)
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .build();

    BackupRun actualResponse = client.get(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlBackupRunsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlBackupRunsGetRequest actualRequest = ((SqlBackupRunsGetRequest) actualRequests.get(0));

    Assert.assertEquals(request.getId(), actualRequest.getId());
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
    mockSqlBackupRunsService.addException(exception);

    try {
      SqlBackupRunsGetRequest request =
          SqlBackupRunsGetRequest.newBuilder()
              .setId(3355)
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
    mockSqlBackupRunsService.addResponse(expectedResponse);

    SqlBackupRunsInsertRequest request =
        SqlBackupRunsInsertRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .setBody(BackupRun.newBuilder().build())
            .build();

    Operation actualResponse = client.insert(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlBackupRunsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlBackupRunsInsertRequest actualRequest = ((SqlBackupRunsInsertRequest) actualRequests.get(0));

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
    mockSqlBackupRunsService.addException(exception);

    try {
      SqlBackupRunsInsertRequest request =
          SqlBackupRunsInsertRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .setBody(BackupRun.newBuilder().build())
              .build();
      client.insert(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTest() throws Exception {
    BackupRunsListResponse expectedResponse =
        BackupRunsListResponse.newBuilder()
            .setKind("kind3292052")
            .addAllItems(new ArrayList<BackupRun>())
            .setNextPageToken("nextPageToken-1386094857")
            .build();
    mockSqlBackupRunsService.addResponse(expectedResponse);

    SqlBackupRunsListRequest request =
        SqlBackupRunsListRequest.newBuilder()
            .setInstance("instance555127957")
            .setMaxResults(1128457243)
            .setPageToken("pageToken873572522")
            .setProject("project-309310695")
            .build();

    BackupRunsListResponse actualResponse = client.list(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlBackupRunsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlBackupRunsListRequest actualRequest = ((SqlBackupRunsListRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getMaxResults(), actualRequest.getMaxResults());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlBackupRunsService.addException(exception);

    try {
      SqlBackupRunsListRequest request =
          SqlBackupRunsListRequest.newBuilder()
              .setInstance("instance555127957")
              .setMaxResults(1128457243)
              .setPageToken("pageToken873572522")
              .setProject("project-309310695")
              .build();
      client.list(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
