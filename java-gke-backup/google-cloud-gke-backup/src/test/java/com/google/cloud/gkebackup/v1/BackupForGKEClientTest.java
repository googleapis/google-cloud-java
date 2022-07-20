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

package com.google.cloud.gkebackup.v1;

import static com.google.cloud.gkebackup.v1.BackupForGKEClient.ListBackupPlansPagedResponse;
import static com.google.cloud.gkebackup.v1.BackupForGKEClient.ListBackupsPagedResponse;
import static com.google.cloud.gkebackup.v1.BackupForGKEClient.ListRestorePlansPagedResponse;
import static com.google.cloud.gkebackup.v1.BackupForGKEClient.ListRestoresPagedResponse;
import static com.google.cloud.gkebackup.v1.BackupForGKEClient.ListVolumeBackupsPagedResponse;
import static com.google.cloud.gkebackup.v1.BackupForGKEClient.ListVolumeRestoresPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
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
public class BackupForGKEClientTest {
  private static MockBackupForGKE mockBackupForGKE;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private BackupForGKEClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockBackupForGKE = new MockBackupForGKE();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockBackupForGKE));
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
    BackupForGKESettings settings =
        BackupForGKESettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = BackupForGKEClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createBackupPlanTest() throws Exception {
    BackupPlan expectedResponse =
        BackupPlan.newBuilder()
            .setName(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setCluster("cluster872092154")
            .setRetentionPolicy(BackupPlan.RetentionPolicy.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setBackupSchedule(BackupPlan.Schedule.newBuilder().build())
            .setEtag("etag3123477")
            .setDeactivated(true)
            .setBackupConfig(BackupPlan.BackupConfig.newBuilder().build())
            .setProtectedPodCount(-1494678716)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createBackupPlanTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBackupForGKE.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    BackupPlan backupPlan = BackupPlan.newBuilder().build();
    String backupPlanId = "backupPlanId-84871546";

    BackupPlan actualResponse =
        client.createBackupPlanAsync(parent, backupPlan, backupPlanId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupForGKE.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBackupPlanRequest actualRequest = ((CreateBackupPlanRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(backupPlan, actualRequest.getBackupPlan());
    Assert.assertEquals(backupPlanId, actualRequest.getBackupPlanId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBackupPlanExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupForGKE.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      BackupPlan backupPlan = BackupPlan.newBuilder().build();
      String backupPlanId = "backupPlanId-84871546";
      client.createBackupPlanAsync(parent, backupPlan, backupPlanId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createBackupPlanTest2() throws Exception {
    BackupPlan expectedResponse =
        BackupPlan.newBuilder()
            .setName(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setCluster("cluster872092154")
            .setRetentionPolicy(BackupPlan.RetentionPolicy.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setBackupSchedule(BackupPlan.Schedule.newBuilder().build())
            .setEtag("etag3123477")
            .setDeactivated(true)
            .setBackupConfig(BackupPlan.BackupConfig.newBuilder().build())
            .setProtectedPodCount(-1494678716)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createBackupPlanTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBackupForGKE.addResponse(resultOperation);

    String parent = "parent-995424086";
    BackupPlan backupPlan = BackupPlan.newBuilder().build();
    String backupPlanId = "backupPlanId-84871546";

    BackupPlan actualResponse =
        client.createBackupPlanAsync(parent, backupPlan, backupPlanId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupForGKE.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBackupPlanRequest actualRequest = ((CreateBackupPlanRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(backupPlan, actualRequest.getBackupPlan());
    Assert.assertEquals(backupPlanId, actualRequest.getBackupPlanId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBackupPlanExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupForGKE.addException(exception);

    try {
      String parent = "parent-995424086";
      BackupPlan backupPlan = BackupPlan.newBuilder().build();
      String backupPlanId = "backupPlanId-84871546";
      client.createBackupPlanAsync(parent, backupPlan, backupPlanId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listBackupPlansTest() throws Exception {
    BackupPlan responsesElement = BackupPlan.newBuilder().build();
    ListBackupPlansResponse expectedResponse =
        ListBackupPlansResponse.newBuilder()
            .setNextPageToken("")
            .addAllBackupPlans(Arrays.asList(responsesElement))
            .build();
    mockBackupForGKE.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListBackupPlansPagedResponse pagedListResponse = client.listBackupPlans(parent);

    List<BackupPlan> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupPlansList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBackupForGKE.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBackupPlansRequest actualRequest = ((ListBackupPlansRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBackupPlansExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupForGKE.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listBackupPlans(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBackupPlansTest2() throws Exception {
    BackupPlan responsesElement = BackupPlan.newBuilder().build();
    ListBackupPlansResponse expectedResponse =
        ListBackupPlansResponse.newBuilder()
            .setNextPageToken("")
            .addAllBackupPlans(Arrays.asList(responsesElement))
            .build();
    mockBackupForGKE.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListBackupPlansPagedResponse pagedListResponse = client.listBackupPlans(parent);

    List<BackupPlan> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupPlansList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBackupForGKE.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBackupPlansRequest actualRequest = ((ListBackupPlansRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBackupPlansExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupForGKE.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listBackupPlans(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBackupPlanTest() throws Exception {
    BackupPlan expectedResponse =
        BackupPlan.newBuilder()
            .setName(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setCluster("cluster872092154")
            .setRetentionPolicy(BackupPlan.RetentionPolicy.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setBackupSchedule(BackupPlan.Schedule.newBuilder().build())
            .setEtag("etag3123477")
            .setDeactivated(true)
            .setBackupConfig(BackupPlan.BackupConfig.newBuilder().build())
            .setProtectedPodCount(-1494678716)
            .build();
    mockBackupForGKE.addResponse(expectedResponse);

    BackupPlanName name = BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]");

    BackupPlan actualResponse = client.getBackupPlan(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupForGKE.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBackupPlanRequest actualRequest = ((GetBackupPlanRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBackupPlanExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupForGKE.addException(exception);

    try {
      BackupPlanName name = BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]");
      client.getBackupPlan(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBackupPlanTest2() throws Exception {
    BackupPlan expectedResponse =
        BackupPlan.newBuilder()
            .setName(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setCluster("cluster872092154")
            .setRetentionPolicy(BackupPlan.RetentionPolicy.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setBackupSchedule(BackupPlan.Schedule.newBuilder().build())
            .setEtag("etag3123477")
            .setDeactivated(true)
            .setBackupConfig(BackupPlan.BackupConfig.newBuilder().build())
            .setProtectedPodCount(-1494678716)
            .build();
    mockBackupForGKE.addResponse(expectedResponse);

    String name = "name3373707";

    BackupPlan actualResponse = client.getBackupPlan(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupForGKE.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBackupPlanRequest actualRequest = ((GetBackupPlanRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBackupPlanExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupForGKE.addException(exception);

    try {
      String name = "name3373707";
      client.getBackupPlan(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateBackupPlanTest() throws Exception {
    BackupPlan expectedResponse =
        BackupPlan.newBuilder()
            .setName(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setCluster("cluster872092154")
            .setRetentionPolicy(BackupPlan.RetentionPolicy.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setBackupSchedule(BackupPlan.Schedule.newBuilder().build())
            .setEtag("etag3123477")
            .setDeactivated(true)
            .setBackupConfig(BackupPlan.BackupConfig.newBuilder().build())
            .setProtectedPodCount(-1494678716)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateBackupPlanTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBackupForGKE.addResponse(resultOperation);

    BackupPlan backupPlan = BackupPlan.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    BackupPlan actualResponse = client.updateBackupPlanAsync(backupPlan, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupForGKE.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateBackupPlanRequest actualRequest = ((UpdateBackupPlanRequest) actualRequests.get(0));

    Assert.assertEquals(backupPlan, actualRequest.getBackupPlan());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateBackupPlanExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupForGKE.addException(exception);

    try {
      BackupPlan backupPlan = BackupPlan.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateBackupPlanAsync(backupPlan, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteBackupPlanTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteBackupPlanTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBackupForGKE.addResponse(resultOperation);

    BackupPlanName name = BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]");

    client.deleteBackupPlanAsync(name).get();

    List<AbstractMessage> actualRequests = mockBackupForGKE.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteBackupPlanRequest actualRequest = ((DeleteBackupPlanRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteBackupPlanExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupForGKE.addException(exception);

    try {
      BackupPlanName name = BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]");
      client.deleteBackupPlanAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteBackupPlanTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteBackupPlanTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBackupForGKE.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteBackupPlanAsync(name).get();

    List<AbstractMessage> actualRequests = mockBackupForGKE.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteBackupPlanRequest actualRequest = ((DeleteBackupPlanRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteBackupPlanExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupForGKE.addException(exception);

    try {
      String name = "name3373707";
      client.deleteBackupPlanAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createBackupTest() throws Exception {
    Backup expectedResponse =
        Backup.newBuilder()
            .setName(
                BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setManual(true)
            .putAllLabels(new HashMap<String, String>())
            .setDeleteLockDays(-1638724265)
            .setDeleteLockExpireTime(Timestamp.newBuilder().build())
            .setRetainDays(-1380805807)
            .setRetainExpireTime(Timestamp.newBuilder().build())
            .setEncryptionKey(EncryptionKey.newBuilder().build())
            .setContainsVolumeData(true)
            .setContainsSecrets(true)
            .setClusterMetadata(Backup.ClusterMetadata.newBuilder().build())
            .setStateReason("stateReason1148834357")
            .setCompleteTime(Timestamp.newBuilder().build())
            .setResourceCount(287552926)
            .setVolumeCount(-1362665558)
            .setSizeBytes(-1796325715)
            .setEtag("etag3123477")
            .setDescription("description-1724546052")
            .setPodCount(977657493)
            .setConfigBackupSizeBytes(-606785139)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createBackupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBackupForGKE.addResponse(resultOperation);

    BackupPlanName parent = BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]");
    Backup backup = Backup.newBuilder().build();
    String backupId = "backupId2121930365";

    Backup actualResponse = client.createBackupAsync(parent, backup, backupId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupForGKE.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBackupRequest actualRequest = ((CreateBackupRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(backup, actualRequest.getBackup());
    Assert.assertEquals(backupId, actualRequest.getBackupId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBackupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupForGKE.addException(exception);

    try {
      BackupPlanName parent = BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]");
      Backup backup = Backup.newBuilder().build();
      String backupId = "backupId2121930365";
      client.createBackupAsync(parent, backup, backupId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createBackupTest2() throws Exception {
    Backup expectedResponse =
        Backup.newBuilder()
            .setName(
                BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setManual(true)
            .putAllLabels(new HashMap<String, String>())
            .setDeleteLockDays(-1638724265)
            .setDeleteLockExpireTime(Timestamp.newBuilder().build())
            .setRetainDays(-1380805807)
            .setRetainExpireTime(Timestamp.newBuilder().build())
            .setEncryptionKey(EncryptionKey.newBuilder().build())
            .setContainsVolumeData(true)
            .setContainsSecrets(true)
            .setClusterMetadata(Backup.ClusterMetadata.newBuilder().build())
            .setStateReason("stateReason1148834357")
            .setCompleteTime(Timestamp.newBuilder().build())
            .setResourceCount(287552926)
            .setVolumeCount(-1362665558)
            .setSizeBytes(-1796325715)
            .setEtag("etag3123477")
            .setDescription("description-1724546052")
            .setPodCount(977657493)
            .setConfigBackupSizeBytes(-606785139)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createBackupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBackupForGKE.addResponse(resultOperation);

    String parent = "parent-995424086";
    Backup backup = Backup.newBuilder().build();
    String backupId = "backupId2121930365";

    Backup actualResponse = client.createBackupAsync(parent, backup, backupId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupForGKE.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBackupRequest actualRequest = ((CreateBackupRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(backup, actualRequest.getBackup());
    Assert.assertEquals(backupId, actualRequest.getBackupId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBackupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupForGKE.addException(exception);

    try {
      String parent = "parent-995424086";
      Backup backup = Backup.newBuilder().build();
      String backupId = "backupId2121930365";
      client.createBackupAsync(parent, backup, backupId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockBackupForGKE.addResponse(expectedResponse);

    BackupPlanName parent = BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]");

    ListBackupsPagedResponse pagedListResponse = client.listBackups(parent);

    List<Backup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBackupForGKE.getRequests();
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
    mockBackupForGKE.addException(exception);

    try {
      BackupPlanName parent = BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]");
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
    mockBackupForGKE.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListBackupsPagedResponse pagedListResponse = client.listBackups(parent);

    List<Backup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBackupForGKE.getRequests();
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
    mockBackupForGKE.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listBackups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBackupTest() throws Exception {
    Backup expectedResponse =
        Backup.newBuilder()
            .setName(
                BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setManual(true)
            .putAllLabels(new HashMap<String, String>())
            .setDeleteLockDays(-1638724265)
            .setDeleteLockExpireTime(Timestamp.newBuilder().build())
            .setRetainDays(-1380805807)
            .setRetainExpireTime(Timestamp.newBuilder().build())
            .setEncryptionKey(EncryptionKey.newBuilder().build())
            .setContainsVolumeData(true)
            .setContainsSecrets(true)
            .setClusterMetadata(Backup.ClusterMetadata.newBuilder().build())
            .setStateReason("stateReason1148834357")
            .setCompleteTime(Timestamp.newBuilder().build())
            .setResourceCount(287552926)
            .setVolumeCount(-1362665558)
            .setSizeBytes(-1796325715)
            .setEtag("etag3123477")
            .setDescription("description-1724546052")
            .setPodCount(977657493)
            .setConfigBackupSizeBytes(-606785139)
            .build();
    mockBackupForGKE.addResponse(expectedResponse);

    BackupName name = BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]");

    Backup actualResponse = client.getBackup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupForGKE.getRequests();
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
    mockBackupForGKE.addException(exception);

    try {
      BackupName name = BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]");
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
            .setName(
                BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setManual(true)
            .putAllLabels(new HashMap<String, String>())
            .setDeleteLockDays(-1638724265)
            .setDeleteLockExpireTime(Timestamp.newBuilder().build())
            .setRetainDays(-1380805807)
            .setRetainExpireTime(Timestamp.newBuilder().build())
            .setEncryptionKey(EncryptionKey.newBuilder().build())
            .setContainsVolumeData(true)
            .setContainsSecrets(true)
            .setClusterMetadata(Backup.ClusterMetadata.newBuilder().build())
            .setStateReason("stateReason1148834357")
            .setCompleteTime(Timestamp.newBuilder().build())
            .setResourceCount(287552926)
            .setVolumeCount(-1362665558)
            .setSizeBytes(-1796325715)
            .setEtag("etag3123477")
            .setDescription("description-1724546052")
            .setPodCount(977657493)
            .setConfigBackupSizeBytes(-606785139)
            .build();
    mockBackupForGKE.addResponse(expectedResponse);

    String name = "name3373707";

    Backup actualResponse = client.getBackup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupForGKE.getRequests();
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
    mockBackupForGKE.addException(exception);

    try {
      String name = "name3373707";
      client.getBackup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateBackupTest() throws Exception {
    Backup expectedResponse =
        Backup.newBuilder()
            .setName(
                BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setManual(true)
            .putAllLabels(new HashMap<String, String>())
            .setDeleteLockDays(-1638724265)
            .setDeleteLockExpireTime(Timestamp.newBuilder().build())
            .setRetainDays(-1380805807)
            .setRetainExpireTime(Timestamp.newBuilder().build())
            .setEncryptionKey(EncryptionKey.newBuilder().build())
            .setContainsVolumeData(true)
            .setContainsSecrets(true)
            .setClusterMetadata(Backup.ClusterMetadata.newBuilder().build())
            .setStateReason("stateReason1148834357")
            .setCompleteTime(Timestamp.newBuilder().build())
            .setResourceCount(287552926)
            .setVolumeCount(-1362665558)
            .setSizeBytes(-1796325715)
            .setEtag("etag3123477")
            .setDescription("description-1724546052")
            .setPodCount(977657493)
            .setConfigBackupSizeBytes(-606785139)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateBackupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBackupForGKE.addResponse(resultOperation);

    Backup backup = Backup.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Backup actualResponse = client.updateBackupAsync(backup, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupForGKE.getRequests();
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
    mockBackupForGKE.addException(exception);

    try {
      Backup backup = Backup.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateBackupAsync(backup, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteBackupTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteBackupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBackupForGKE.addResponse(resultOperation);

    BackupName name = BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]");

    client.deleteBackupAsync(name).get();

    List<AbstractMessage> actualRequests = mockBackupForGKE.getRequests();
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
    mockBackupForGKE.addException(exception);

    try {
      BackupName name = BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]");
      client.deleteBackupAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteBackupTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteBackupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBackupForGKE.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteBackupAsync(name).get();

    List<AbstractMessage> actualRequests = mockBackupForGKE.getRequests();
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
    mockBackupForGKE.addException(exception);

    try {
      String name = "name3373707";
      client.deleteBackupAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listVolumeBackupsTest() throws Exception {
    VolumeBackup responsesElement = VolumeBackup.newBuilder().build();
    ListVolumeBackupsResponse expectedResponse =
        ListVolumeBackupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllVolumeBackups(Arrays.asList(responsesElement))
            .build();
    mockBackupForGKE.addResponse(expectedResponse);

    BackupName parent = BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]");

    ListVolumeBackupsPagedResponse pagedListResponse = client.listVolumeBackups(parent);

    List<VolumeBackup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVolumeBackupsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBackupForGKE.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListVolumeBackupsRequest actualRequest = ((ListVolumeBackupsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listVolumeBackupsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupForGKE.addException(exception);

    try {
      BackupName parent = BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]");
      client.listVolumeBackups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listVolumeBackupsTest2() throws Exception {
    VolumeBackup responsesElement = VolumeBackup.newBuilder().build();
    ListVolumeBackupsResponse expectedResponse =
        ListVolumeBackupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllVolumeBackups(Arrays.asList(responsesElement))
            .build();
    mockBackupForGKE.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListVolumeBackupsPagedResponse pagedListResponse = client.listVolumeBackups(parent);

    List<VolumeBackup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVolumeBackupsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBackupForGKE.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListVolumeBackupsRequest actualRequest = ((ListVolumeBackupsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listVolumeBackupsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupForGKE.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listVolumeBackups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getVolumeBackupTest() throws Exception {
    VolumeBackup expectedResponse =
        VolumeBackup.newBuilder()
            .setName(
                VolumeBackupName.of(
                        "[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]", "[VOLUME_BACKUP]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSourcePvc(NamespacedName.newBuilder().build())
            .setVolumeBackupHandle("volumeBackupHandle190274244")
            .setStorageBytes(2035244455)
            .setDiskSizeBytes(-275393905)
            .setCompleteTime(Timestamp.newBuilder().build())
            .setStateMessage("stateMessage1128185398")
            .setEtag("etag3123477")
            .build();
    mockBackupForGKE.addResponse(expectedResponse);

    VolumeBackupName name =
        VolumeBackupName.of(
            "[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]", "[VOLUME_BACKUP]");

    VolumeBackup actualResponse = client.getVolumeBackup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupForGKE.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetVolumeBackupRequest actualRequest = ((GetVolumeBackupRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getVolumeBackupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupForGKE.addException(exception);

    try {
      VolumeBackupName name =
          VolumeBackupName.of(
              "[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]", "[VOLUME_BACKUP]");
      client.getVolumeBackup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getVolumeBackupTest2() throws Exception {
    VolumeBackup expectedResponse =
        VolumeBackup.newBuilder()
            .setName(
                VolumeBackupName.of(
                        "[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]", "[VOLUME_BACKUP]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSourcePvc(NamespacedName.newBuilder().build())
            .setVolumeBackupHandle("volumeBackupHandle190274244")
            .setStorageBytes(2035244455)
            .setDiskSizeBytes(-275393905)
            .setCompleteTime(Timestamp.newBuilder().build())
            .setStateMessage("stateMessage1128185398")
            .setEtag("etag3123477")
            .build();
    mockBackupForGKE.addResponse(expectedResponse);

    String name = "name3373707";

    VolumeBackup actualResponse = client.getVolumeBackup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupForGKE.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetVolumeBackupRequest actualRequest = ((GetVolumeBackupRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getVolumeBackupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupForGKE.addException(exception);

    try {
      String name = "name3373707";
      client.getVolumeBackup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createRestorePlanTest() throws Exception {
    RestorePlan expectedResponse =
        RestorePlan.newBuilder()
            .setName(RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setBackupPlan(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
            .setCluster("cluster872092154")
            .setRestoreConfig(RestoreConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createRestorePlanTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBackupForGKE.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    RestorePlan restorePlan = RestorePlan.newBuilder().build();
    String restorePlanId = "restorePlanId-857896366";

    RestorePlan actualResponse =
        client.createRestorePlanAsync(parent, restorePlan, restorePlanId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupForGKE.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateRestorePlanRequest actualRequest = ((CreateRestorePlanRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(restorePlan, actualRequest.getRestorePlan());
    Assert.assertEquals(restorePlanId, actualRequest.getRestorePlanId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createRestorePlanExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupForGKE.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      RestorePlan restorePlan = RestorePlan.newBuilder().build();
      String restorePlanId = "restorePlanId-857896366";
      client.createRestorePlanAsync(parent, restorePlan, restorePlanId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createRestorePlanTest2() throws Exception {
    RestorePlan expectedResponse =
        RestorePlan.newBuilder()
            .setName(RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setBackupPlan(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
            .setCluster("cluster872092154")
            .setRestoreConfig(RestoreConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createRestorePlanTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBackupForGKE.addResponse(resultOperation);

    String parent = "parent-995424086";
    RestorePlan restorePlan = RestorePlan.newBuilder().build();
    String restorePlanId = "restorePlanId-857896366";

    RestorePlan actualResponse =
        client.createRestorePlanAsync(parent, restorePlan, restorePlanId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupForGKE.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateRestorePlanRequest actualRequest = ((CreateRestorePlanRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(restorePlan, actualRequest.getRestorePlan());
    Assert.assertEquals(restorePlanId, actualRequest.getRestorePlanId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createRestorePlanExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupForGKE.addException(exception);

    try {
      String parent = "parent-995424086";
      RestorePlan restorePlan = RestorePlan.newBuilder().build();
      String restorePlanId = "restorePlanId-857896366";
      client.createRestorePlanAsync(parent, restorePlan, restorePlanId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listRestorePlansTest() throws Exception {
    RestorePlan responsesElement = RestorePlan.newBuilder().build();
    ListRestorePlansResponse expectedResponse =
        ListRestorePlansResponse.newBuilder()
            .setNextPageToken("")
            .addAllRestorePlans(Arrays.asList(responsesElement))
            .build();
    mockBackupForGKE.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListRestorePlansPagedResponse pagedListResponse = client.listRestorePlans(parent);

    List<RestorePlan> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRestorePlansList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBackupForGKE.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRestorePlansRequest actualRequest = ((ListRestorePlansRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRestorePlansExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupForGKE.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listRestorePlans(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRestorePlansTest2() throws Exception {
    RestorePlan responsesElement = RestorePlan.newBuilder().build();
    ListRestorePlansResponse expectedResponse =
        ListRestorePlansResponse.newBuilder()
            .setNextPageToken("")
            .addAllRestorePlans(Arrays.asList(responsesElement))
            .build();
    mockBackupForGKE.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListRestorePlansPagedResponse pagedListResponse = client.listRestorePlans(parent);

    List<RestorePlan> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRestorePlansList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBackupForGKE.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRestorePlansRequest actualRequest = ((ListRestorePlansRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRestorePlansExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupForGKE.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listRestorePlans(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRestorePlanTest() throws Exception {
    RestorePlan expectedResponse =
        RestorePlan.newBuilder()
            .setName(RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setBackupPlan(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
            .setCluster("cluster872092154")
            .setRestoreConfig(RestoreConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .build();
    mockBackupForGKE.addResponse(expectedResponse);

    RestorePlanName name = RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]");

    RestorePlan actualResponse = client.getRestorePlan(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupForGKE.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRestorePlanRequest actualRequest = ((GetRestorePlanRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRestorePlanExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupForGKE.addException(exception);

    try {
      RestorePlanName name = RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]");
      client.getRestorePlan(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRestorePlanTest2() throws Exception {
    RestorePlan expectedResponse =
        RestorePlan.newBuilder()
            .setName(RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setBackupPlan(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
            .setCluster("cluster872092154")
            .setRestoreConfig(RestoreConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .build();
    mockBackupForGKE.addResponse(expectedResponse);

    String name = "name3373707";

    RestorePlan actualResponse = client.getRestorePlan(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupForGKE.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRestorePlanRequest actualRequest = ((GetRestorePlanRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRestorePlanExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupForGKE.addException(exception);

    try {
      String name = "name3373707";
      client.getRestorePlan(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateRestorePlanTest() throws Exception {
    RestorePlan expectedResponse =
        RestorePlan.newBuilder()
            .setName(RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setBackupPlan(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
            .setCluster("cluster872092154")
            .setRestoreConfig(RestoreConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateRestorePlanTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBackupForGKE.addResponse(resultOperation);

    RestorePlan restorePlan = RestorePlan.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    RestorePlan actualResponse = client.updateRestorePlanAsync(restorePlan, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupForGKE.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateRestorePlanRequest actualRequest = ((UpdateRestorePlanRequest) actualRequests.get(0));

    Assert.assertEquals(restorePlan, actualRequest.getRestorePlan());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateRestorePlanExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupForGKE.addException(exception);

    try {
      RestorePlan restorePlan = RestorePlan.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateRestorePlanAsync(restorePlan, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteRestorePlanTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteRestorePlanTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBackupForGKE.addResponse(resultOperation);

    RestorePlanName name = RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]");

    client.deleteRestorePlanAsync(name).get();

    List<AbstractMessage> actualRequests = mockBackupForGKE.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRestorePlanRequest actualRequest = ((DeleteRestorePlanRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRestorePlanExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupForGKE.addException(exception);

    try {
      RestorePlanName name = RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]");
      client.deleteRestorePlanAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteRestorePlanTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteRestorePlanTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBackupForGKE.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteRestorePlanAsync(name).get();

    List<AbstractMessage> actualRequests = mockBackupForGKE.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRestorePlanRequest actualRequest = ((DeleteRestorePlanRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRestorePlanExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupForGKE.addException(exception);

    try {
      String name = "name3373707";
      client.deleteRestorePlanAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createRestoreTest() throws Exception {
    Restore expectedResponse =
        Restore.newBuilder()
            .setName(
                RestoreName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setBackup(
                BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]").toString())
            .setCluster("cluster872092154")
            .setRestoreConfig(RestoreConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setStateReason("stateReason1148834357")
            .setCompleteTime(Timestamp.newBuilder().build())
            .setResourcesRestoredCount(882879616)
            .setResourcesExcludedCount(-338652236)
            .setResourcesFailedCount(217904743)
            .setVolumesRestoredCount(1005533068)
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createRestoreTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBackupForGKE.addResponse(resultOperation);

    RestorePlanName parent = RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]");
    Restore restore = Restore.newBuilder().build();
    String restoreId = "restoreId-1845465015";

    Restore actualResponse = client.createRestoreAsync(parent, restore, restoreId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupForGKE.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateRestoreRequest actualRequest = ((CreateRestoreRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(restore, actualRequest.getRestore());
    Assert.assertEquals(restoreId, actualRequest.getRestoreId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createRestoreExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupForGKE.addException(exception);

    try {
      RestorePlanName parent = RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]");
      Restore restore = Restore.newBuilder().build();
      String restoreId = "restoreId-1845465015";
      client.createRestoreAsync(parent, restore, restoreId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createRestoreTest2() throws Exception {
    Restore expectedResponse =
        Restore.newBuilder()
            .setName(
                RestoreName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setBackup(
                BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]").toString())
            .setCluster("cluster872092154")
            .setRestoreConfig(RestoreConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setStateReason("stateReason1148834357")
            .setCompleteTime(Timestamp.newBuilder().build())
            .setResourcesRestoredCount(882879616)
            .setResourcesExcludedCount(-338652236)
            .setResourcesFailedCount(217904743)
            .setVolumesRestoredCount(1005533068)
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createRestoreTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBackupForGKE.addResponse(resultOperation);

    String parent = "parent-995424086";
    Restore restore = Restore.newBuilder().build();
    String restoreId = "restoreId-1845465015";

    Restore actualResponse = client.createRestoreAsync(parent, restore, restoreId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupForGKE.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateRestoreRequest actualRequest = ((CreateRestoreRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(restore, actualRequest.getRestore());
    Assert.assertEquals(restoreId, actualRequest.getRestoreId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createRestoreExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupForGKE.addException(exception);

    try {
      String parent = "parent-995424086";
      Restore restore = Restore.newBuilder().build();
      String restoreId = "restoreId-1845465015";
      client.createRestoreAsync(parent, restore, restoreId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listRestoresTest() throws Exception {
    Restore responsesElement = Restore.newBuilder().build();
    ListRestoresResponse expectedResponse =
        ListRestoresResponse.newBuilder()
            .setNextPageToken("")
            .addAllRestores(Arrays.asList(responsesElement))
            .build();
    mockBackupForGKE.addResponse(expectedResponse);

    RestorePlanName parent = RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]");

    ListRestoresPagedResponse pagedListResponse = client.listRestores(parent);

    List<Restore> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRestoresList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBackupForGKE.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRestoresRequest actualRequest = ((ListRestoresRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRestoresExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupForGKE.addException(exception);

    try {
      RestorePlanName parent = RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]");
      client.listRestores(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRestoresTest2() throws Exception {
    Restore responsesElement = Restore.newBuilder().build();
    ListRestoresResponse expectedResponse =
        ListRestoresResponse.newBuilder()
            .setNextPageToken("")
            .addAllRestores(Arrays.asList(responsesElement))
            .build();
    mockBackupForGKE.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListRestoresPagedResponse pagedListResponse = client.listRestores(parent);

    List<Restore> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRestoresList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBackupForGKE.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRestoresRequest actualRequest = ((ListRestoresRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRestoresExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupForGKE.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listRestores(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRestoreTest() throws Exception {
    Restore expectedResponse =
        Restore.newBuilder()
            .setName(
                RestoreName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setBackup(
                BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]").toString())
            .setCluster("cluster872092154")
            .setRestoreConfig(RestoreConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setStateReason("stateReason1148834357")
            .setCompleteTime(Timestamp.newBuilder().build())
            .setResourcesRestoredCount(882879616)
            .setResourcesExcludedCount(-338652236)
            .setResourcesFailedCount(217904743)
            .setVolumesRestoredCount(1005533068)
            .setEtag("etag3123477")
            .build();
    mockBackupForGKE.addResponse(expectedResponse);

    RestoreName name = RestoreName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]");

    Restore actualResponse = client.getRestore(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupForGKE.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRestoreRequest actualRequest = ((GetRestoreRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRestoreExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupForGKE.addException(exception);

    try {
      RestoreName name = RestoreName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]");
      client.getRestore(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRestoreTest2() throws Exception {
    Restore expectedResponse =
        Restore.newBuilder()
            .setName(
                RestoreName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setBackup(
                BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]").toString())
            .setCluster("cluster872092154")
            .setRestoreConfig(RestoreConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setStateReason("stateReason1148834357")
            .setCompleteTime(Timestamp.newBuilder().build())
            .setResourcesRestoredCount(882879616)
            .setResourcesExcludedCount(-338652236)
            .setResourcesFailedCount(217904743)
            .setVolumesRestoredCount(1005533068)
            .setEtag("etag3123477")
            .build();
    mockBackupForGKE.addResponse(expectedResponse);

    String name = "name3373707";

    Restore actualResponse = client.getRestore(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupForGKE.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRestoreRequest actualRequest = ((GetRestoreRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRestoreExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupForGKE.addException(exception);

    try {
      String name = "name3373707";
      client.getRestore(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateRestoreTest() throws Exception {
    Restore expectedResponse =
        Restore.newBuilder()
            .setName(
                RestoreName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setBackup(
                BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]").toString())
            .setCluster("cluster872092154")
            .setRestoreConfig(RestoreConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setStateReason("stateReason1148834357")
            .setCompleteTime(Timestamp.newBuilder().build())
            .setResourcesRestoredCount(882879616)
            .setResourcesExcludedCount(-338652236)
            .setResourcesFailedCount(217904743)
            .setVolumesRestoredCount(1005533068)
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateRestoreTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBackupForGKE.addResponse(resultOperation);

    Restore restore = Restore.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Restore actualResponse = client.updateRestoreAsync(restore, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupForGKE.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateRestoreRequest actualRequest = ((UpdateRestoreRequest) actualRequests.get(0));

    Assert.assertEquals(restore, actualRequest.getRestore());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateRestoreExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupForGKE.addException(exception);

    try {
      Restore restore = Restore.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateRestoreAsync(restore, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteRestoreTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteRestoreTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBackupForGKE.addResponse(resultOperation);

    RestoreName name = RestoreName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]");

    client.deleteRestoreAsync(name).get();

    List<AbstractMessage> actualRequests = mockBackupForGKE.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRestoreRequest actualRequest = ((DeleteRestoreRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRestoreExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupForGKE.addException(exception);

    try {
      RestoreName name = RestoreName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]");
      client.deleteRestoreAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteRestoreTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteRestoreTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBackupForGKE.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteRestoreAsync(name).get();

    List<AbstractMessage> actualRequests = mockBackupForGKE.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRestoreRequest actualRequest = ((DeleteRestoreRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRestoreExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupForGKE.addException(exception);

    try {
      String name = "name3373707";
      client.deleteRestoreAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listVolumeRestoresTest() throws Exception {
    VolumeRestore responsesElement = VolumeRestore.newBuilder().build();
    ListVolumeRestoresResponse expectedResponse =
        ListVolumeRestoresResponse.newBuilder()
            .setNextPageToken("")
            .addAllVolumeRestores(Arrays.asList(responsesElement))
            .build();
    mockBackupForGKE.addResponse(expectedResponse);

    RestoreName parent = RestoreName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]");

    ListVolumeRestoresPagedResponse pagedListResponse = client.listVolumeRestores(parent);

    List<VolumeRestore> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVolumeRestoresList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBackupForGKE.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListVolumeRestoresRequest actualRequest = ((ListVolumeRestoresRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listVolumeRestoresExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupForGKE.addException(exception);

    try {
      RestoreName parent = RestoreName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]");
      client.listVolumeRestores(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listVolumeRestoresTest2() throws Exception {
    VolumeRestore responsesElement = VolumeRestore.newBuilder().build();
    ListVolumeRestoresResponse expectedResponse =
        ListVolumeRestoresResponse.newBuilder()
            .setNextPageToken("")
            .addAllVolumeRestores(Arrays.asList(responsesElement))
            .build();
    mockBackupForGKE.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListVolumeRestoresPagedResponse pagedListResponse = client.listVolumeRestores(parent);

    List<VolumeRestore> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVolumeRestoresList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBackupForGKE.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListVolumeRestoresRequest actualRequest = ((ListVolumeRestoresRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listVolumeRestoresExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupForGKE.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listVolumeRestores(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getVolumeRestoreTest() throws Exception {
    VolumeRestore expectedResponse =
        VolumeRestore.newBuilder()
            .setName(
                VolumeRestoreName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[RESTORE_PLAN]",
                        "[RESTORE]",
                        "[VOLUME_RESTORE]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setVolumeBackup("volumeBackup2099842428")
            .setTargetPvc(NamespacedName.newBuilder().build())
            .setVolumeHandle("volumeHandle-2023029278")
            .setCompleteTime(Timestamp.newBuilder().build())
            .setStateMessage("stateMessage1128185398")
            .setEtag("etag3123477")
            .build();
    mockBackupForGKE.addResponse(expectedResponse);

    VolumeRestoreName name =
        VolumeRestoreName.of(
            "[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]", "[VOLUME_RESTORE]");

    VolumeRestore actualResponse = client.getVolumeRestore(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupForGKE.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetVolumeRestoreRequest actualRequest = ((GetVolumeRestoreRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getVolumeRestoreExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupForGKE.addException(exception);

    try {
      VolumeRestoreName name =
          VolumeRestoreName.of(
              "[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]", "[VOLUME_RESTORE]");
      client.getVolumeRestore(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getVolumeRestoreTest2() throws Exception {
    VolumeRestore expectedResponse =
        VolumeRestore.newBuilder()
            .setName(
                VolumeRestoreName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[RESTORE_PLAN]",
                        "[RESTORE]",
                        "[VOLUME_RESTORE]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setVolumeBackup("volumeBackup2099842428")
            .setTargetPvc(NamespacedName.newBuilder().build())
            .setVolumeHandle("volumeHandle-2023029278")
            .setCompleteTime(Timestamp.newBuilder().build())
            .setStateMessage("stateMessage1128185398")
            .setEtag("etag3123477")
            .build();
    mockBackupForGKE.addResponse(expectedResponse);

    String name = "name3373707";

    VolumeRestore actualResponse = client.getVolumeRestore(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBackupForGKE.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetVolumeRestoreRequest actualRequest = ((GetVolumeRestoreRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getVolumeRestoreExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBackupForGKE.addException(exception);

    try {
      String name = "name3373707";
      client.getVolumeRestore(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
