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

import static com.google.cloud.sql.v1.SqlBackupsServiceClient.ListBackupsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.BoolValue;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import com.google.type.Interval;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
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
public class SqlBackupsServiceClientTest {
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private static MockSqlBackupsService mockSqlBackupsService;
  private LocalChannelProvider channelProvider;
  private SqlBackupsServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockSqlBackupsService = new MockSqlBackupsService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockSqlBackupsService, mockLocations));
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
    SqlBackupsServiceSettings settings =
        SqlBackupsServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SqlBackupsServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createBackupTest() throws Exception {
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
    mockSqlBackupsService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    Backup backup = Backup.newBuilder().build();

    Operation actualResponse = client.createBackup(parent, backup);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlBackupsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBackupRequest actualRequest = ((CreateBackupRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(backup, actualRequest.getBackup());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBackupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlBackupsService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      Backup backup = Backup.newBuilder().build();
      client.createBackup(parent, backup);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createBackupTest2() throws Exception {
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
    mockSqlBackupsService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Backup backup = Backup.newBuilder().build();

    Operation actualResponse = client.createBackup(parent, backup);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlBackupsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBackupRequest actualRequest = ((CreateBackupRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(backup, actualRequest.getBackup());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBackupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlBackupsService.addException(exception);

    try {
      String parent = "parent-995424086";
      Backup backup = Backup.newBuilder().build();
      client.createBackup(parent, backup);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBackupTest() throws Exception {
    Backup expectedResponse =
        Backup.newBuilder()
            .setName(BackupName.of("[PROJECT]", "[BACKUP]").toString())
            .setKind("kind3292052")
            .setSelfLink("selfLink1191800166")
            .setDescription("description-1724546052")
            .setInstance("instance555127957")
            .setLocation("location1901043637")
            .setBackupInterval(Interval.newBuilder().build())
            .setError(OperationError.newBuilder().build())
            .setKmsKey("kmsKey-1127483058")
            .setKmsKeyVersion("kmsKeyVersion2084784042")
            .setBackupKind(SqlBackupKind.forNumber(0))
            .setTimeZone("timeZone-2077180903")
            .setDatabaseVersion(SqlDatabaseVersion.forNumber(0))
            .setMaxChargeableBytes(-1424371595)
            .setInstanceDeletionTime(Timestamp.newBuilder().build())
            .setInstanceSettings(DatabaseInstance.newBuilder().build())
            .setBackupRun("backupRun1355341161")
            .setSatisfiesPzs(BoolValue.newBuilder().build())
            .setSatisfiesPzi(BoolValue.newBuilder().build())
            .build();
    mockSqlBackupsService.addResponse(expectedResponse);

    BackupName name = BackupName.of("[PROJECT]", "[BACKUP]");

    Backup actualResponse = client.getBackup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlBackupsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBackupRequest actualRequest = ((GetBackupRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBackupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlBackupsService.addException(exception);

    try {
      BackupName name = BackupName.of("[PROJECT]", "[BACKUP]");
      client.getBackup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBackupTest2() throws Exception {
    Backup expectedResponse =
        Backup.newBuilder()
            .setName(BackupName.of("[PROJECT]", "[BACKUP]").toString())
            .setKind("kind3292052")
            .setSelfLink("selfLink1191800166")
            .setDescription("description-1724546052")
            .setInstance("instance555127957")
            .setLocation("location1901043637")
            .setBackupInterval(Interval.newBuilder().build())
            .setError(OperationError.newBuilder().build())
            .setKmsKey("kmsKey-1127483058")
            .setKmsKeyVersion("kmsKeyVersion2084784042")
            .setBackupKind(SqlBackupKind.forNumber(0))
            .setTimeZone("timeZone-2077180903")
            .setDatabaseVersion(SqlDatabaseVersion.forNumber(0))
            .setMaxChargeableBytes(-1424371595)
            .setInstanceDeletionTime(Timestamp.newBuilder().build())
            .setInstanceSettings(DatabaseInstance.newBuilder().build())
            .setBackupRun("backupRun1355341161")
            .setSatisfiesPzs(BoolValue.newBuilder().build())
            .setSatisfiesPzi(BoolValue.newBuilder().build())
            .build();
    mockSqlBackupsService.addResponse(expectedResponse);

    String name = "name3373707";

    Backup actualResponse = client.getBackup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlBackupsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBackupRequest actualRequest = ((GetBackupRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBackupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlBackupsService.addException(exception);

    try {
      String name = "name3373707";
      client.getBackup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBackupsTest() throws Exception {
    Backup responsesElement = Backup.newBuilder().build();
    ListBackupsResponse expectedResponse =
        ListBackupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBackups(Arrays.asList(responsesElement))
            .build();
    mockSqlBackupsService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListBackupsPagedResponse pagedListResponse = client.listBackups(parent);

    List<Backup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSqlBackupsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBackupsRequest actualRequest = ((ListBackupsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBackupsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlBackupsService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listBackups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBackupsTest2() throws Exception {
    Backup responsesElement = Backup.newBuilder().build();
    ListBackupsResponse expectedResponse =
        ListBackupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBackups(Arrays.asList(responsesElement))
            .build();
    mockSqlBackupsService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListBackupsPagedResponse pagedListResponse = client.listBackups(parent);

    List<Backup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSqlBackupsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBackupsRequest actualRequest = ((ListBackupsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBackupsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlBackupsService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listBackups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateBackupTest() throws Exception {
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
    mockSqlBackupsService.addResponse(expectedResponse);

    Backup backup = Backup.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Operation actualResponse = client.updateBackup(backup, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlBackupsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateBackupRequest actualRequest = ((UpdateBackupRequest) actualRequests.get(0));

    Assert.assertEquals(backup, actualRequest.getBackup());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateBackupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlBackupsService.addException(exception);

    try {
      Backup backup = Backup.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateBackup(backup, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteBackupTest() throws Exception {
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
    mockSqlBackupsService.addResponse(expectedResponse);

    BackupName name = BackupName.of("[PROJECT]", "[BACKUP]");

    Operation actualResponse = client.deleteBackup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlBackupsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteBackupRequest actualRequest = ((DeleteBackupRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteBackupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlBackupsService.addException(exception);

    try {
      BackupName name = BackupName.of("[PROJECT]", "[BACKUP]");
      client.deleteBackup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteBackupTest2() throws Exception {
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
    mockSqlBackupsService.addResponse(expectedResponse);

    String name = "name3373707";

    Operation actualResponse = client.deleteBackup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSqlBackupsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteBackupRequest actualRequest = ((DeleteBackupRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteBackupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlBackupsService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteBackup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
