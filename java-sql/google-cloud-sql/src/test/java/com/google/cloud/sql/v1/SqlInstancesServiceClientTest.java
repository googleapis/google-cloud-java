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
import com.google.protobuf.BoolValue;
import com.google.protobuf.Duration;
import com.google.protobuf.Int64Value;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
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
public class SqlInstancesServiceClientTest {
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private static MockSqlInstancesService mockSqlInstancesService;
  private LocalChannelProvider channelProvider;
  private SqlInstancesServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockSqlInstancesService = new MockSqlInstancesService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockSqlInstancesService, mockLocations));
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
    SqlInstancesServiceSettings settings =
        SqlInstancesServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SqlInstancesServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void addServerCaTest() throws Exception {
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
    mockSqlInstancesService.addResponse(expectedResponse);

    SqlInstancesAddServerCaRequest request =
        SqlInstancesAddServerCaRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .build();

    Operation actualResponse = client.addServerCa(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlInstancesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlInstancesAddServerCaRequest actualRequest =
        ((SqlInstancesAddServerCaRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void addServerCaExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlInstancesService.addException(exception);

    try {
      SqlInstancesAddServerCaRequest request =
          SqlInstancesAddServerCaRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .build();
      client.addServerCa(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void addServerCertificateTest() throws Exception {
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
    mockSqlInstancesService.addResponse(expectedResponse);

    SqlInstancesAddServerCertificateRequest request =
        SqlInstancesAddServerCertificateRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .build();

    Operation actualResponse = client.addServerCertificate(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlInstancesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlInstancesAddServerCertificateRequest actualRequest =
        ((SqlInstancesAddServerCertificateRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void addServerCertificateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlInstancesService.addException(exception);

    try {
      SqlInstancesAddServerCertificateRequest request =
          SqlInstancesAddServerCertificateRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .build();
      client.addServerCertificate(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void addEntraIdCertificateTest() throws Exception {
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
    mockSqlInstancesService.addResponse(expectedResponse);

    SqlInstancesAddEntraIdCertificateRequest request =
        SqlInstancesAddEntraIdCertificateRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .build();

    Operation actualResponse = client.addEntraIdCertificate(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlInstancesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlInstancesAddEntraIdCertificateRequest actualRequest =
        ((SqlInstancesAddEntraIdCertificateRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void addEntraIdCertificateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlInstancesService.addException(exception);

    try {
      SqlInstancesAddEntraIdCertificateRequest request =
          SqlInstancesAddEntraIdCertificateRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .build();
      client.addEntraIdCertificate(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void cloneTest() throws Exception {
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
    mockSqlInstancesService.addResponse(expectedResponse);

    SqlInstancesCloneRequest request =
        SqlInstancesCloneRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .setBody(InstancesCloneRequest.newBuilder().build())
            .build();

    Operation actualResponse = client.clone(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlInstancesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlInstancesCloneRequest actualRequest = ((SqlInstancesCloneRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertEquals(request.getBody(), actualRequest.getBody());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void cloneExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlInstancesService.addException(exception);

    try {
      SqlInstancesCloneRequest request =
          SqlInstancesCloneRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .setBody(InstancesCloneRequest.newBuilder().build())
              .build();
      client.clone(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
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
    mockSqlInstancesService.addResponse(expectedResponse);

    SqlInstancesDeleteRequest request =
        SqlInstancesDeleteRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .setEnableFinalBackup(true)
            .setFinalBackupDescription("finalBackupDescription-293551612")
            .build();

    Operation actualResponse = client.delete(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlInstancesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlInstancesDeleteRequest actualRequest = ((SqlInstancesDeleteRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertEquals(request.getEnableFinalBackup(), actualRequest.getEnableFinalBackup());
    Assert.assertEquals(request.getFinalBackupTtlDays(), actualRequest.getFinalBackupTtlDays());
    Assert.assertEquals(
        request.getFinalBackupExpiryTime(), actualRequest.getFinalBackupExpiryTime());
    Assert.assertEquals(
        request.getFinalBackupDescription(), actualRequest.getFinalBackupDescription());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlInstancesService.addException(exception);

    try {
      SqlInstancesDeleteRequest request =
          SqlInstancesDeleteRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .setEnableFinalBackup(true)
              .setFinalBackupDescription("finalBackupDescription-293551612")
              .build();
      client.delete(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void demoteMasterTest() throws Exception {
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
    mockSqlInstancesService.addResponse(expectedResponse);

    SqlInstancesDemoteMasterRequest request =
        SqlInstancesDemoteMasterRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .setBody(InstancesDemoteMasterRequest.newBuilder().build())
            .build();

    Operation actualResponse = client.demoteMaster(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlInstancesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlInstancesDemoteMasterRequest actualRequest =
        ((SqlInstancesDemoteMasterRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertEquals(request.getBody(), actualRequest.getBody());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void demoteMasterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlInstancesService.addException(exception);

    try {
      SqlInstancesDemoteMasterRequest request =
          SqlInstancesDemoteMasterRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .setBody(InstancesDemoteMasterRequest.newBuilder().build())
              .build();
      client.demoteMaster(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void demoteTest() throws Exception {
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
    mockSqlInstancesService.addResponse(expectedResponse);

    SqlInstancesDemoteRequest request =
        SqlInstancesDemoteRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .setBody(InstancesDemoteRequest.newBuilder().build())
            .build();

    Operation actualResponse = client.demote(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlInstancesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlInstancesDemoteRequest actualRequest = ((SqlInstancesDemoteRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertEquals(request.getBody(), actualRequest.getBody());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void demoteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlInstancesService.addException(exception);

    try {
      SqlInstancesDemoteRequest request =
          SqlInstancesDemoteRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .setBody(InstancesDemoteRequest.newBuilder().build())
              .build();
      client.demote(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void exportTest() throws Exception {
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
    mockSqlInstancesService.addResponse(expectedResponse);

    SqlInstancesExportRequest request =
        SqlInstancesExportRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .setBody(InstancesExportRequest.newBuilder().build())
            .build();

    Operation actualResponse = client.export(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlInstancesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlInstancesExportRequest actualRequest = ((SqlInstancesExportRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertEquals(request.getBody(), actualRequest.getBody());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlInstancesService.addException(exception);

    try {
      SqlInstancesExportRequest request =
          SqlInstancesExportRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .setBody(InstancesExportRequest.newBuilder().build())
              .build();
      client.export(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void failoverTest() throws Exception {
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
    mockSqlInstancesService.addResponse(expectedResponse);

    SqlInstancesFailoverRequest request =
        SqlInstancesFailoverRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .setBody(InstancesFailoverRequest.newBuilder().build())
            .build();

    Operation actualResponse = client.failover(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlInstancesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlInstancesFailoverRequest actualRequest =
        ((SqlInstancesFailoverRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertEquals(request.getBody(), actualRequest.getBody());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void failoverExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlInstancesService.addException(exception);

    try {
      SqlInstancesFailoverRequest request =
          SqlInstancesFailoverRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .setBody(InstancesFailoverRequest.newBuilder().build())
              .build();
      client.failover(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void reencryptTest() throws Exception {
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
    mockSqlInstancesService.addResponse(expectedResponse);

    SqlInstancesReencryptRequest request =
        SqlInstancesReencryptRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .setBody(InstancesReencryptRequest.newBuilder().build())
            .build();

    Operation actualResponse = client.reencrypt(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlInstancesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlInstancesReencryptRequest actualRequest =
        ((SqlInstancesReencryptRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertEquals(request.getBody(), actualRequest.getBody());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void reencryptExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlInstancesService.addException(exception);

    try {
      SqlInstancesReencryptRequest request =
          SqlInstancesReencryptRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .setBody(InstancesReencryptRequest.newBuilder().build())
              .build();
      client.reencrypt(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTest() throws Exception {
    DatabaseInstance expectedResponse =
        DatabaseInstance.newBuilder()
            .setKind("kind3292052")
            .setDatabaseVersion(SqlDatabaseVersion.forNumber(0))
            .setSettings(Settings.newBuilder().build())
            .setEtag("etag3123477")
            .setFailoverReplica(DatabaseInstance.SqlFailoverReplica.newBuilder().build())
            .setMasterInstanceName("masterInstanceName2132225090")
            .addAllReplicaNames(new ArrayList<String>())
            .setMaxDiskSize(Int64Value.newBuilder().build())
            .setCurrentDiskSize(Int64Value.newBuilder().build())
            .addAllIpAddresses(new ArrayList<IpMapping>())
            .setServerCaCert(SslCert.newBuilder().build())
            .setInstanceType(SqlInstanceType.forNumber(0))
            .setProject("project-309310695")
            .setIpv6Address("ipv6Address1372169229")
            .setServiceAccountEmailAddress("serviceAccountEmailAddress245216912")
            .setOnPremisesConfiguration(OnPremisesConfiguration.newBuilder().build())
            .setReplicaConfiguration(ReplicaConfiguration.newBuilder().build())
            .setBackendType(SqlBackendType.forNumber(0))
            .setSelfLink("selfLink1191800166")
            .addAllSuspensionReason(new ArrayList<SqlSuspensionReason>())
            .setConnectionName("connectionName1270009481")
            .setName("name3373707")
            .setRegion("region-934795532")
            .setGceZone("gceZone-146048427")
            .setSecondaryGceZone("secondaryGceZone227989057")
            .setDiskEncryptionConfiguration(DiskEncryptionConfiguration.newBuilder().build())
            .setDiskEncryptionStatus(DiskEncryptionStatus.newBuilder().build())
            .setRootPassword("rootPassword1669569949")
            .setScheduledMaintenance(DatabaseInstance.SqlScheduledMaintenance.newBuilder().build())
            .setSatisfiesPzs(BoolValue.newBuilder().build())
            .setDatabaseInstalledVersion("databaseInstalledVersion-808517735")
            .setOutOfDiskReport(DatabaseInstance.SqlOutOfDiskReport.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllAvailableMaintenanceVersions(new ArrayList<String>())
            .setMaintenanceVersion("maintenanceVersion1355658821")
            .addAllUpgradableDatabaseVersions(new ArrayList<AvailableDatabaseVersion>())
            .setPscServiceAttachmentLink("pscServiceAttachmentLink-321045774")
            .setDnsName("dnsName1813886804")
            .setPrimaryDnsName("primaryDnsName330291954")
            .setWriteEndpoint("writeEndpoint-105280876")
            .setReplicationCluster(ReplicationCluster.newBuilder().build())
            .setGeminiConfig(GeminiInstanceConfig.newBuilder().build())
            .setSatisfiesPzi(BoolValue.newBuilder().build())
            .setSwitchTransactionLogsToCloudStorageEnabled(BoolValue.newBuilder().build())
            .setIncludeReplicasForMajorVersionUpgrade(BoolValue.newBuilder().build())
            .putAllTags(new HashMap<String, String>())
            .setNodeCount(1539922066)
            .addAllNodes(new ArrayList<DatabaseInstance.PoolNodeConfig>())
            .addAllDnsNames(new ArrayList<DnsNameMapping>())
            .setDatabaseCenterIntegrationEnabled(BoolValue.newBuilder().build())
            .build();
    mockSqlInstancesService.addResponse(expectedResponse);

    SqlInstancesGetRequest request =
        SqlInstancesGetRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .build();

    DatabaseInstance actualResponse = client.get(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlInstancesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlInstancesGetRequest actualRequest = ((SqlInstancesGetRequest) actualRequests.get(0));

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
    mockSqlInstancesService.addException(exception);

    try {
      SqlInstancesGetRequest request =
          SqlInstancesGetRequest.newBuilder()
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
  public void import_Test() throws Exception {
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
    mockSqlInstancesService.addResponse(expectedResponse);

    SqlInstancesImportRequest request =
        SqlInstancesImportRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .setBody(InstancesImportRequest.newBuilder().build())
            .build();

    Operation actualResponse = client.import_(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlInstancesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlInstancesImportRequest actualRequest = ((SqlInstancesImportRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertEquals(request.getBody(), actualRequest.getBody());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void import_ExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlInstancesService.addException(exception);

    try {
      SqlInstancesImportRequest request =
          SqlInstancesImportRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .setBody(InstancesImportRequest.newBuilder().build())
              .build();
      client.import_(request);
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
    mockSqlInstancesService.addResponse(expectedResponse);

    SqlInstancesInsertRequest request =
        SqlInstancesInsertRequest.newBuilder()
            .setProject("project-309310695")
            .setBody(DatabaseInstance.newBuilder().build())
            .build();

    Operation actualResponse = client.insert(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlInstancesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlInstancesInsertRequest actualRequest = ((SqlInstancesInsertRequest) actualRequests.get(0));

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
    mockSqlInstancesService.addException(exception);

    try {
      SqlInstancesInsertRequest request =
          SqlInstancesInsertRequest.newBuilder()
              .setProject("project-309310695")
              .setBody(DatabaseInstance.newBuilder().build())
              .build();
      client.insert(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTest() throws Exception {
    InstancesListResponse expectedResponse =
        InstancesListResponse.newBuilder()
            .setKind("kind3292052")
            .addAllWarnings(new ArrayList<ApiWarning>())
            .addAllItems(new ArrayList<DatabaseInstance>())
            .setNextPageToken("nextPageToken-1386094857")
            .build();
    mockSqlInstancesService.addResponse(expectedResponse);

    SqlInstancesListRequest request =
        SqlInstancesListRequest.newBuilder()
            .setFilter("filter-1274492040")
            .setMaxResults(1128457243)
            .setPageToken("pageToken873572522")
            .setProject("project-309310695")
            .build();

    InstancesListResponse actualResponse = client.list(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlInstancesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlInstancesListRequest actualRequest = ((SqlInstancesListRequest) actualRequests.get(0));

    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
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
    mockSqlInstancesService.addException(exception);

    try {
      SqlInstancesListRequest request =
          SqlInstancesListRequest.newBuilder()
              .setFilter("filter-1274492040")
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

  @Test
  public void listServerCasTest() throws Exception {
    InstancesListServerCasResponse expectedResponse =
        InstancesListServerCasResponse.newBuilder()
            .addAllCerts(new ArrayList<SslCert>())
            .setActiveVersion("activeVersion-827825422")
            .setKind("kind3292052")
            .build();
    mockSqlInstancesService.addResponse(expectedResponse);

    SqlInstancesListServerCasRequest request =
        SqlInstancesListServerCasRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .build();

    InstancesListServerCasResponse actualResponse = client.listServerCas(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlInstancesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlInstancesListServerCasRequest actualRequest =
        ((SqlInstancesListServerCasRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listServerCasExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlInstancesService.addException(exception);

    try {
      SqlInstancesListServerCasRequest request =
          SqlInstancesListServerCasRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .build();
      client.listServerCas(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listServerCertificatesTest() throws Exception {
    InstancesListServerCertificatesResponse expectedResponse =
        InstancesListServerCertificatesResponse.newBuilder()
            .addAllCaCerts(new ArrayList<SslCert>())
            .addAllServerCerts(new ArrayList<SslCert>())
            .setActiveVersion("activeVersion-827825422")
            .setKind("kind3292052")
            .build();
    mockSqlInstancesService.addResponse(expectedResponse);

    SqlInstancesListServerCertificatesRequest request =
        SqlInstancesListServerCertificatesRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .build();

    InstancesListServerCertificatesResponse actualResponse = client.listServerCertificates(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlInstancesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlInstancesListServerCertificatesRequest actualRequest =
        ((SqlInstancesListServerCertificatesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listServerCertificatesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlInstancesService.addException(exception);

    try {
      SqlInstancesListServerCertificatesRequest request =
          SqlInstancesListServerCertificatesRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .build();
      client.listServerCertificates(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEntraIdCertificatesTest() throws Exception {
    InstancesListEntraIdCertificatesResponse expectedResponse =
        InstancesListEntraIdCertificatesResponse.newBuilder()
            .addAllCerts(new ArrayList<SslCert>())
            .setActiveVersion("activeVersion-827825422")
            .setKind("kind3292052")
            .build();
    mockSqlInstancesService.addResponse(expectedResponse);

    SqlInstancesListEntraIdCertificatesRequest request =
        SqlInstancesListEntraIdCertificatesRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .build();

    InstancesListEntraIdCertificatesResponse actualResponse =
        client.listEntraIdCertificates(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlInstancesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlInstancesListEntraIdCertificatesRequest actualRequest =
        ((SqlInstancesListEntraIdCertificatesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEntraIdCertificatesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlInstancesService.addException(exception);

    try {
      SqlInstancesListEntraIdCertificatesRequest request =
          SqlInstancesListEntraIdCertificatesRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .build();
      client.listEntraIdCertificates(request);
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
    mockSqlInstancesService.addResponse(expectedResponse);

    SqlInstancesPatchRequest request =
        SqlInstancesPatchRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .setReconcilePscNetworking(true)
            .setReconcilePscNetworkingForce(true)
            .setBody(DatabaseInstance.newBuilder().build())
            .build();

    Operation actualResponse = client.patch(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlInstancesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlInstancesPatchRequest actualRequest = ((SqlInstancesPatchRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertEquals(
        request.getReconcilePscNetworking(), actualRequest.getReconcilePscNetworking());
    Assert.assertEquals(
        request.getReconcilePscNetworkingForce(), actualRequest.getReconcilePscNetworkingForce());
    Assert.assertEquals(request.getBody(), actualRequest.getBody());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void patchExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlInstancesService.addException(exception);

    try {
      SqlInstancesPatchRequest request =
          SqlInstancesPatchRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .setReconcilePscNetworking(true)
              .setReconcilePscNetworkingForce(true)
              .setBody(DatabaseInstance.newBuilder().build())
              .build();
      client.patch(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void promoteReplicaTest() throws Exception {
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
    mockSqlInstancesService.addResponse(expectedResponse);

    SqlInstancesPromoteReplicaRequest request =
        SqlInstancesPromoteReplicaRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .setFailover(true)
            .build();

    Operation actualResponse = client.promoteReplica(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlInstancesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlInstancesPromoteReplicaRequest actualRequest =
        ((SqlInstancesPromoteReplicaRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertEquals(request.getFailover(), actualRequest.getFailover());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void promoteReplicaExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlInstancesService.addException(exception);

    try {
      SqlInstancesPromoteReplicaRequest request =
          SqlInstancesPromoteReplicaRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .setFailover(true)
              .build();
      client.promoteReplica(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void switchoverTest() throws Exception {
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
    mockSqlInstancesService.addResponse(expectedResponse);

    SqlInstancesSwitchoverRequest request =
        SqlInstancesSwitchoverRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .setDbTimeout(Duration.newBuilder().build())
            .build();

    Operation actualResponse = client.switchover(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlInstancesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlInstancesSwitchoverRequest actualRequest =
        ((SqlInstancesSwitchoverRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertEquals(request.getDbTimeout(), actualRequest.getDbTimeout());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void switchoverExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlInstancesService.addException(exception);

    try {
      SqlInstancesSwitchoverRequest request =
          SqlInstancesSwitchoverRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .setDbTimeout(Duration.newBuilder().build())
              .build();
      client.switchover(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void resetSslConfigTest() throws Exception {
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
    mockSqlInstancesService.addResponse(expectedResponse);

    SqlInstancesResetSslConfigRequest request =
        SqlInstancesResetSslConfigRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .build();

    Operation actualResponse = client.resetSslConfig(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlInstancesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlInstancesResetSslConfigRequest actualRequest =
        ((SqlInstancesResetSslConfigRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertEquals(request.getMode(), actualRequest.getMode());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void resetSslConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlInstancesService.addException(exception);

    try {
      SqlInstancesResetSslConfigRequest request =
          SqlInstancesResetSslConfigRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .build();
      client.resetSslConfig(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void restartTest() throws Exception {
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
    mockSqlInstancesService.addResponse(expectedResponse);

    SqlInstancesRestartRequest request =
        SqlInstancesRestartRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .build();

    Operation actualResponse = client.restart(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlInstancesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlInstancesRestartRequest actualRequest = ((SqlInstancesRestartRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void restartExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlInstancesService.addException(exception);

    try {
      SqlInstancesRestartRequest request =
          SqlInstancesRestartRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .build();
      client.restart(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void restoreBackupTest() throws Exception {
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
    mockSqlInstancesService.addResponse(expectedResponse);

    SqlInstancesRestoreBackupRequest request =
        SqlInstancesRestoreBackupRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .setBody(InstancesRestoreBackupRequest.newBuilder().build())
            .build();

    Operation actualResponse = client.restoreBackup(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlInstancesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlInstancesRestoreBackupRequest actualRequest =
        ((SqlInstancesRestoreBackupRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertEquals(request.getBody(), actualRequest.getBody());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void restoreBackupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlInstancesService.addException(exception);

    try {
      SqlInstancesRestoreBackupRequest request =
          SqlInstancesRestoreBackupRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .setBody(InstancesRestoreBackupRequest.newBuilder().build())
              .build();
      client.restoreBackup(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void rotateServerCaTest() throws Exception {
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
    mockSqlInstancesService.addResponse(expectedResponse);

    SqlInstancesRotateServerCaRequest request =
        SqlInstancesRotateServerCaRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .setBody(InstancesRotateServerCaRequest.newBuilder().build())
            .build();

    Operation actualResponse = client.rotateServerCa(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlInstancesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlInstancesRotateServerCaRequest actualRequest =
        ((SqlInstancesRotateServerCaRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertEquals(request.getBody(), actualRequest.getBody());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void rotateServerCaExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlInstancesService.addException(exception);

    try {
      SqlInstancesRotateServerCaRequest request =
          SqlInstancesRotateServerCaRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .setBody(InstancesRotateServerCaRequest.newBuilder().build())
              .build();
      client.rotateServerCa(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void rotateServerCertificateTest() throws Exception {
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
    mockSqlInstancesService.addResponse(expectedResponse);

    SqlInstancesRotateServerCertificateRequest request =
        SqlInstancesRotateServerCertificateRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .setBody(InstancesRotateServerCertificateRequest.newBuilder().build())
            .build();

    Operation actualResponse = client.rotateServerCertificate(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlInstancesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlInstancesRotateServerCertificateRequest actualRequest =
        ((SqlInstancesRotateServerCertificateRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertEquals(request.getBody(), actualRequest.getBody());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void rotateServerCertificateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlInstancesService.addException(exception);

    try {
      SqlInstancesRotateServerCertificateRequest request =
          SqlInstancesRotateServerCertificateRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .setBody(InstancesRotateServerCertificateRequest.newBuilder().build())
              .build();
      client.rotateServerCertificate(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void rotateEntraIdCertificateTest() throws Exception {
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
    mockSqlInstancesService.addResponse(expectedResponse);

    SqlInstancesRotateEntraIdCertificateRequest request =
        SqlInstancesRotateEntraIdCertificateRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .setBody(InstancesRotateEntraIdCertificateRequest.newBuilder().build())
            .build();

    Operation actualResponse = client.rotateEntraIdCertificate(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlInstancesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlInstancesRotateEntraIdCertificateRequest actualRequest =
        ((SqlInstancesRotateEntraIdCertificateRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertEquals(request.getBody(), actualRequest.getBody());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void rotateEntraIdCertificateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlInstancesService.addException(exception);

    try {
      SqlInstancesRotateEntraIdCertificateRequest request =
          SqlInstancesRotateEntraIdCertificateRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .setBody(InstancesRotateEntraIdCertificateRequest.newBuilder().build())
              .build();
      client.rotateEntraIdCertificate(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void startReplicaTest() throws Exception {
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
    mockSqlInstancesService.addResponse(expectedResponse);

    SqlInstancesStartReplicaRequest request =
        SqlInstancesStartReplicaRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .build();

    Operation actualResponse = client.startReplica(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlInstancesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlInstancesStartReplicaRequest actualRequest =
        ((SqlInstancesStartReplicaRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void startReplicaExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlInstancesService.addException(exception);

    try {
      SqlInstancesStartReplicaRequest request =
          SqlInstancesStartReplicaRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .build();
      client.startReplica(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void stopReplicaTest() throws Exception {
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
    mockSqlInstancesService.addResponse(expectedResponse);

    SqlInstancesStopReplicaRequest request =
        SqlInstancesStopReplicaRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .build();

    Operation actualResponse = client.stopReplica(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlInstancesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlInstancesStopReplicaRequest actualRequest =
        ((SqlInstancesStopReplicaRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void stopReplicaExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlInstancesService.addException(exception);

    try {
      SqlInstancesStopReplicaRequest request =
          SqlInstancesStopReplicaRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .build();
      client.stopReplica(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void truncateLogTest() throws Exception {
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
    mockSqlInstancesService.addResponse(expectedResponse);

    SqlInstancesTruncateLogRequest request =
        SqlInstancesTruncateLogRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .setBody(InstancesTruncateLogRequest.newBuilder().build())
            .build();

    Operation actualResponse = client.truncateLog(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlInstancesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlInstancesTruncateLogRequest actualRequest =
        ((SqlInstancesTruncateLogRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertEquals(request.getBody(), actualRequest.getBody());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void truncateLogExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlInstancesService.addException(exception);

    try {
      SqlInstancesTruncateLogRequest request =
          SqlInstancesTruncateLogRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .setBody(InstancesTruncateLogRequest.newBuilder().build())
              .build();
      client.truncateLog(request);
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
    mockSqlInstancesService.addResponse(expectedResponse);

    SqlInstancesUpdateRequest request =
        SqlInstancesUpdateRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .setBody(DatabaseInstance.newBuilder().build())
            .build();

    Operation actualResponse = client.update(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlInstancesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlInstancesUpdateRequest actualRequest = ((SqlInstancesUpdateRequest) actualRequests.get(0));

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
    mockSqlInstancesService.addException(exception);

    try {
      SqlInstancesUpdateRequest request =
          SqlInstancesUpdateRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .setBody(DatabaseInstance.newBuilder().build())
              .build();
      client.update(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEphemeralTest() throws Exception {
    SslCert expectedResponse =
        SslCert.newBuilder()
            .setKind("kind3292052")
            .setCertSerialNumber("certSerialNumber1709590177")
            .setCert("cert3050020")
            .setCreateTime(Timestamp.newBuilder().build())
            .setCommonName("commonName1184312086")
            .setExpirationTime(Timestamp.newBuilder().build())
            .setSha1Fingerprint("sha1Fingerprint163009183")
            .setInstance("instance555127957")
            .setSelfLink("selfLink1191800166")
            .build();
    mockSqlInstancesService.addResponse(expectedResponse);

    SqlInstancesCreateEphemeralCertRequest request =
        SqlInstancesCreateEphemeralCertRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .setBody(SslCertsCreateEphemeralRequest.newBuilder().build())
            .build();

    SslCert actualResponse = client.createEphemeral(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlInstancesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlInstancesCreateEphemeralCertRequest actualRequest =
        ((SqlInstancesCreateEphemeralCertRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertEquals(request.getBody(), actualRequest.getBody());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEphemeralExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlInstancesService.addException(exception);

    try {
      SqlInstancesCreateEphemeralCertRequest request =
          SqlInstancesCreateEphemeralCertRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .setBody(SslCertsCreateEphemeralRequest.newBuilder().build())
              .build();
      client.createEphemeral(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void rescheduleMaintenanceTest() throws Exception {
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
    mockSqlInstancesService.addResponse(expectedResponse);

    SqlInstancesRescheduleMaintenanceRequest request =
        SqlInstancesRescheduleMaintenanceRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .setBody(SqlInstancesRescheduleMaintenanceRequestBody.newBuilder().build())
            .build();

    Operation actualResponse = client.rescheduleMaintenance(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlInstancesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlInstancesRescheduleMaintenanceRequest actualRequest =
        ((SqlInstancesRescheduleMaintenanceRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertEquals(request.getBody(), actualRequest.getBody());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void rescheduleMaintenanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlInstancesService.addException(exception);

    try {
      SqlInstancesRescheduleMaintenanceRequest request =
          SqlInstancesRescheduleMaintenanceRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .setBody(SqlInstancesRescheduleMaintenanceRequestBody.newBuilder().build())
              .build();
      client.rescheduleMaintenance(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void verifyExternalSyncSettingsTest() throws Exception {
    SqlInstancesVerifyExternalSyncSettingsResponse expectedResponse =
        SqlInstancesVerifyExternalSyncSettingsResponse.newBuilder()
            .setKind("kind3292052")
            .addAllErrors(new ArrayList<SqlExternalSyncSettingError>())
            .addAllWarnings(new ArrayList<SqlExternalSyncSettingError>())
            .build();
    mockSqlInstancesService.addResponse(expectedResponse);

    SqlInstancesVerifyExternalSyncSettingsRequest request =
        SqlInstancesVerifyExternalSyncSettingsRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .setVerifyConnectionOnly(true)
            .setVerifyReplicationOnly(true)
            .setSyncParallelLevel(ExternalSyncParallelLevel.forNumber(0))
            .addAllSelectedObjects(new ArrayList<ExternalSyncSelectedObject>())
            .build();

    SqlInstancesVerifyExternalSyncSettingsResponse actualResponse =
        client.verifyExternalSyncSettings(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlInstancesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlInstancesVerifyExternalSyncSettingsRequest actualRequest =
        ((SqlInstancesVerifyExternalSyncSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertEquals(request.getVerifyConnectionOnly(), actualRequest.getVerifyConnectionOnly());
    Assert.assertEquals(request.getSyncMode(), actualRequest.getSyncMode());
    Assert.assertEquals(
        request.getVerifyReplicationOnly(), actualRequest.getVerifyReplicationOnly());
    Assert.assertEquals(request.getMysqlSyncConfig(), actualRequest.getMysqlSyncConfig());
    Assert.assertEquals(request.getMigrationType(), actualRequest.getMigrationType());
    Assert.assertEquals(request.getSyncParallelLevel(), actualRequest.getSyncParallelLevel());
    Assert.assertEquals(request.getSelectedObjectsList(), actualRequest.getSelectedObjectsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void verifyExternalSyncSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlInstancesService.addException(exception);

    try {
      SqlInstancesVerifyExternalSyncSettingsRequest request =
          SqlInstancesVerifyExternalSyncSettingsRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .setVerifyConnectionOnly(true)
              .setVerifyReplicationOnly(true)
              .setSyncParallelLevel(ExternalSyncParallelLevel.forNumber(0))
              .addAllSelectedObjects(new ArrayList<ExternalSyncSelectedObject>())
              .build();
      client.verifyExternalSyncSettings(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void startExternalSyncTest() throws Exception {
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
    mockSqlInstancesService.addResponse(expectedResponse);

    SqlInstancesStartExternalSyncRequest request =
        SqlInstancesStartExternalSyncRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .setSkipVerification(true)
            .setSyncParallelLevel(ExternalSyncParallelLevel.forNumber(0))
            .setReplicaOverwriteEnabled(true)
            .build();

    Operation actualResponse = client.startExternalSync(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlInstancesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlInstancesStartExternalSyncRequest actualRequest =
        ((SqlInstancesStartExternalSyncRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertEquals(request.getSyncMode(), actualRequest.getSyncMode());
    Assert.assertEquals(request.getSkipVerification(), actualRequest.getSkipVerification());
    Assert.assertEquals(request.getMysqlSyncConfig(), actualRequest.getMysqlSyncConfig());
    Assert.assertEquals(request.getSyncParallelLevel(), actualRequest.getSyncParallelLevel());
    Assert.assertEquals(request.getMigrationType(), actualRequest.getMigrationType());
    Assert.assertEquals(
        request.getReplicaOverwriteEnabled(), actualRequest.getReplicaOverwriteEnabled());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void startExternalSyncExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlInstancesService.addException(exception);

    try {
      SqlInstancesStartExternalSyncRequest request =
          SqlInstancesStartExternalSyncRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .setSkipVerification(true)
              .setSyncParallelLevel(ExternalSyncParallelLevel.forNumber(0))
              .setReplicaOverwriteEnabled(true)
              .build();
      client.startExternalSync(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void performDiskShrinkTest() throws Exception {
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
    mockSqlInstancesService.addResponse(expectedResponse);

    SqlInstancesPerformDiskShrinkRequest request =
        SqlInstancesPerformDiskShrinkRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .setBody(PerformDiskShrinkContext.newBuilder().build())
            .build();

    Operation actualResponse = client.performDiskShrink(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlInstancesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlInstancesPerformDiskShrinkRequest actualRequest =
        ((SqlInstancesPerformDiskShrinkRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertEquals(request.getBody(), actualRequest.getBody());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void performDiskShrinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlInstancesService.addException(exception);

    try {
      SqlInstancesPerformDiskShrinkRequest request =
          SqlInstancesPerformDiskShrinkRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .setBody(PerformDiskShrinkContext.newBuilder().build())
              .build();
      client.performDiskShrink(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDiskShrinkConfigTest() throws Exception {
    SqlInstancesGetDiskShrinkConfigResponse expectedResponse =
        SqlInstancesGetDiskShrinkConfigResponse.newBuilder()
            .setKind("kind3292052")
            .setMinimalTargetSizeGb(-1076246647)
            .setMessage("message954925063")
            .build();
    mockSqlInstancesService.addResponse(expectedResponse);

    SqlInstancesGetDiskShrinkConfigRequest request =
        SqlInstancesGetDiskShrinkConfigRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .build();

    SqlInstancesGetDiskShrinkConfigResponse actualResponse = client.getDiskShrinkConfig(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlInstancesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlInstancesGetDiskShrinkConfigRequest actualRequest =
        ((SqlInstancesGetDiskShrinkConfigRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDiskShrinkConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlInstancesService.addException(exception);

    try {
      SqlInstancesGetDiskShrinkConfigRequest request =
          SqlInstancesGetDiskShrinkConfigRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .build();
      client.getDiskShrinkConfig(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void resetReplicaSizeTest() throws Exception {
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
    mockSqlInstancesService.addResponse(expectedResponse);

    SqlInstancesResetReplicaSizeRequest request =
        SqlInstancesResetReplicaSizeRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .build();

    Operation actualResponse = client.resetReplicaSize(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlInstancesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlInstancesResetReplicaSizeRequest actualRequest =
        ((SqlInstancesResetReplicaSizeRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void resetReplicaSizeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlInstancesService.addException(exception);

    try {
      SqlInstancesResetReplicaSizeRequest request =
          SqlInstancesResetReplicaSizeRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .build();
      client.resetReplicaSize(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLatestRecoveryTimeTest() throws Exception {
    SqlInstancesGetLatestRecoveryTimeResponse expectedResponse =
        SqlInstancesGetLatestRecoveryTimeResponse.newBuilder()
            .setKind("kind3292052")
            .setLatestRecoveryTime(Timestamp.newBuilder().build())
            .setEarliestRecoveryTime(Timestamp.newBuilder().build())
            .build();
    mockSqlInstancesService.addResponse(expectedResponse);

    SqlInstancesGetLatestRecoveryTimeRequest request =
        SqlInstancesGetLatestRecoveryTimeRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .setSourceInstanceDeletionTime(Timestamp.newBuilder().build())
            .build();

    SqlInstancesGetLatestRecoveryTimeResponse actualResponse =
        client.getLatestRecoveryTime(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlInstancesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlInstancesGetLatestRecoveryTimeRequest actualRequest =
        ((SqlInstancesGetLatestRecoveryTimeRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertEquals(
        request.getSourceInstanceDeletionTime(), actualRequest.getSourceInstanceDeletionTime());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLatestRecoveryTimeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlInstancesService.addException(exception);

    try {
      SqlInstancesGetLatestRecoveryTimeRequest request =
          SqlInstancesGetLatestRecoveryTimeRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .setSourceInstanceDeletionTime(Timestamp.newBuilder().build())
              .build();
      client.getLatestRecoveryTime(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void executeSqlTest() throws Exception {
    SqlInstancesExecuteSqlResponse expectedResponse =
        SqlInstancesExecuteSqlResponse.newBuilder()
            .addAllMessages(new ArrayList<SqlInstancesExecuteSqlResponse.Message>())
            .setMetadata(Metadata.newBuilder().build())
            .addAllResults(new ArrayList<QueryResult>())
            .setStatus(Status.newBuilder().build())
            .build();
    mockSqlInstancesService.addResponse(expectedResponse);

    SqlInstancesExecuteSqlRequest request =
        SqlInstancesExecuteSqlRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .setBody(ExecuteSqlPayload.newBuilder().build())
            .build();

    SqlInstancesExecuteSqlResponse actualResponse = client.executeSql(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlInstancesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlInstancesExecuteSqlRequest actualRequest =
        ((SqlInstancesExecuteSqlRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertEquals(request.getBody(), actualRequest.getBody());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void executeSqlExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlInstancesService.addException(exception);

    try {
      SqlInstancesExecuteSqlRequest request =
          SqlInstancesExecuteSqlRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .setBody(ExecuteSqlPayload.newBuilder().build())
              .build();
      client.executeSql(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void acquireSsrsLeaseTest() throws Exception {
    SqlInstancesAcquireSsrsLeaseResponse expectedResponse =
        SqlInstancesAcquireSsrsLeaseResponse.newBuilder()
            .setOperationId("operationId129704162")
            .build();
    mockSqlInstancesService.addResponse(expectedResponse);

    SqlInstancesAcquireSsrsLeaseRequest request =
        SqlInstancesAcquireSsrsLeaseRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .setBody(InstancesAcquireSsrsLeaseRequest.newBuilder().build())
            .build();

    SqlInstancesAcquireSsrsLeaseResponse actualResponse = client.acquireSsrsLease(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlInstancesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlInstancesAcquireSsrsLeaseRequest actualRequest =
        ((SqlInstancesAcquireSsrsLeaseRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertEquals(request.getBody(), actualRequest.getBody());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void acquireSsrsLeaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlInstancesService.addException(exception);

    try {
      SqlInstancesAcquireSsrsLeaseRequest request =
          SqlInstancesAcquireSsrsLeaseRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .setBody(InstancesAcquireSsrsLeaseRequest.newBuilder().build())
              .build();
      client.acquireSsrsLease(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void releaseSsrsLeaseTest() throws Exception {
    SqlInstancesReleaseSsrsLeaseResponse expectedResponse =
        SqlInstancesReleaseSsrsLeaseResponse.newBuilder()
            .setOperationId("operationId129704162")
            .build();
    mockSqlInstancesService.addResponse(expectedResponse);

    SqlInstancesReleaseSsrsLeaseRequest request =
        SqlInstancesReleaseSsrsLeaseRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .build();

    SqlInstancesReleaseSsrsLeaseResponse actualResponse = client.releaseSsrsLease(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlInstancesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlInstancesReleaseSsrsLeaseRequest actualRequest =
        ((SqlInstancesReleaseSsrsLeaseRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void releaseSsrsLeaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlInstancesService.addException(exception);

    try {
      SqlInstancesReleaseSsrsLeaseRequest request =
          SqlInstancesReleaseSsrsLeaseRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .build();
      client.releaseSsrsLease(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void preCheckMajorVersionUpgradeTest() throws Exception {
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
    mockSqlInstancesService.addResponse(expectedResponse);

    SqlInstancesPreCheckMajorVersionUpgradeRequest request =
        SqlInstancesPreCheckMajorVersionUpgradeRequest.newBuilder()
            .setInstance("instance555127957")
            .setProject("project-309310695")
            .setBody(InstancesPreCheckMajorVersionUpgradeRequest.newBuilder().build())
            .build();

    Operation actualResponse = client.preCheckMajorVersionUpgrade(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlInstancesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlInstancesPreCheckMajorVersionUpgradeRequest actualRequest =
        ((SqlInstancesPreCheckMajorVersionUpgradeRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInstance(), actualRequest.getInstance());
    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertEquals(request.getBody(), actualRequest.getBody());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void preCheckMajorVersionUpgradeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlInstancesService.addException(exception);

    try {
      SqlInstancesPreCheckMajorVersionUpgradeRequest request =
          SqlInstancesPreCheckMajorVersionUpgradeRequest.newBuilder()
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .setBody(InstancesPreCheckMajorVersionUpgradeRequest.newBuilder().build())
              .build();
      client.preCheckMajorVersionUpgrade(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void pointInTimeRestoreTest() throws Exception {
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
    mockSqlInstancesService.addResponse(expectedResponse);

    SqlInstancesPointInTimeRestoreRequest request =
        SqlInstancesPointInTimeRestoreRequest.newBuilder()
            .setParent("parent-995424086")
            .setContext(PointInTimeRestoreContext.newBuilder().build())
            .build();

    Operation actualResponse = client.pointInTimeRestore(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlInstancesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SqlInstancesPointInTimeRestoreRequest actualRequest =
        ((SqlInstancesPointInTimeRestoreRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getContext(), actualRequest.getContext());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void pointInTimeRestoreExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlInstancesService.addException(exception);

    try {
      SqlInstancesPointInTimeRestoreRequest request =
          SqlInstancesPointInTimeRestoreRequest.newBuilder()
              .setParent("parent-995424086")
              .setContext(PointInTimeRestoreContext.newBuilder().build())
              .build();
      client.pointInTimeRestore(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
