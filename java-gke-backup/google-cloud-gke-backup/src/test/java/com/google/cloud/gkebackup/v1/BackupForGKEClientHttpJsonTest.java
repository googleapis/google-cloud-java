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
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.gkebackup.v1.stub.HttpJsonBackupForGKEStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class BackupForGKEClientHttpJsonTest {
  private static MockHttpService mockService;
  private static BackupForGKEClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonBackupForGKEStub.getMethodDescriptors(),
            BackupForGKESettings.getDefaultEndpoint());
    BackupForGKESettings settings =
        BackupForGKESettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                BackupForGKESettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = BackupForGKEClient.create(settings);
  }

  @AfterClass
  public static void stopServer() {
    client.close();
  }

  @Before
  public void setUp() {}

  @After
  public void tearDown() throws Exception {
    mockService.reset();
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
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    BackupPlan backupPlan = BackupPlan.newBuilder().build();
    String backupPlanId = "backupPlanId-84871546";

    BackupPlan actualResponse =
        client.createBackupPlanAsync(parent, backupPlan, backupPlanId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createBackupPlanExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      BackupPlan backupPlan = BackupPlan.newBuilder().build();
      String backupPlanId = "backupPlanId-84871546";
      client.createBackupPlanAsync(parent, backupPlan, backupPlanId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    BackupPlan backupPlan = BackupPlan.newBuilder().build();
    String backupPlanId = "backupPlanId-84871546";

    BackupPlan actualResponse =
        client.createBackupPlanAsync(parent, backupPlan, backupPlanId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createBackupPlanExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      BackupPlan backupPlan = BackupPlan.newBuilder().build();
      String backupPlanId = "backupPlanId-84871546";
      client.createBackupPlanAsync(parent, backupPlan, backupPlanId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListBackupPlansPagedResponse pagedListResponse = client.listBackupPlans(parent);

    List<BackupPlan> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupPlansList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listBackupPlansExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListBackupPlansPagedResponse pagedListResponse = client.listBackupPlans(parent);

    List<BackupPlan> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupPlansList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listBackupPlansExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
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
    mockService.addResponse(expectedResponse);

    BackupPlanName name = BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]");

    BackupPlan actualResponse = client.getBackupPlan(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getBackupPlanExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-3970/locations/location-3970/backupPlans/backupPlan-3970";

    BackupPlan actualResponse = client.getBackupPlan(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getBackupPlanExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-3970/locations/location-3970/backupPlans/backupPlan-3970";
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
    mockService.addResponse(resultOperation);

    BackupPlan backupPlan =
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
    FieldMask updateMask = FieldMask.newBuilder().build();

    BackupPlan actualResponse = client.updateBackupPlanAsync(backupPlan, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateBackupPlanExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BackupPlan backupPlan =
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
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateBackupPlanAsync(backupPlan, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    BackupPlanName name = BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]");

    client.deleteBackupPlanAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteBackupPlanExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BackupPlanName name = BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]");
      client.deleteBackupPlanAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String name = "projects/project-3970/locations/location-3970/backupPlans/backupPlan-3970";

    client.deleteBackupPlanAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteBackupPlanExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-3970/locations/location-3970/backupPlans/backupPlan-3970";
      client.deleteBackupPlanAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    BackupPlanName parent = BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]");
    Backup backup = Backup.newBuilder().build();
    String backupId = "backupId2121930365";

    Backup actualResponse = client.createBackupAsync(parent, backup, backupId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createBackupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BackupPlanName parent = BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]");
      Backup backup = Backup.newBuilder().build();
      String backupId = "backupId2121930365";
      client.createBackupAsync(parent, backup, backupId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String parent = "projects/project-4819/locations/location-4819/backupPlans/backupPlan-4819";
    Backup backup = Backup.newBuilder().build();
    String backupId = "backupId2121930365";

    Backup actualResponse = client.createBackupAsync(parent, backup, backupId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createBackupExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-4819/locations/location-4819/backupPlans/backupPlan-4819";
      Backup backup = Backup.newBuilder().build();
      String backupId = "backupId2121930365";
      client.createBackupAsync(parent, backup, backupId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    BackupPlanName parent = BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]");

    ListBackupsPagedResponse pagedListResponse = client.listBackups(parent);

    List<Backup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listBackupsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-4819/locations/location-4819/backupPlans/backupPlan-4819";

    ListBackupsPagedResponse pagedListResponse = client.listBackups(parent);

    List<Backup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listBackupsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-4819/locations/location-4819/backupPlans/backupPlan-4819";
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
    mockService.addResponse(expectedResponse);

    BackupName name = BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]");

    Backup actualResponse = client.getBackup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getBackupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-4101/locations/location-4101/backupPlans/backupPlan-4101/backups/backup-4101";

    Backup actualResponse = client.getBackup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getBackupExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4101/locations/location-4101/backupPlans/backupPlan-4101/backups/backup-4101";
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
    mockService.addResponse(resultOperation);

    Backup backup =
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
    FieldMask updateMask = FieldMask.newBuilder().build();

    Backup actualResponse = client.updateBackupAsync(backup, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateBackupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Backup backup =
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
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateBackupAsync(backup, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    BackupName name = BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]");

    client.deleteBackupAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteBackupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BackupName name = BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]");
      client.deleteBackupAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-4101/locations/location-4101/backupPlans/backupPlan-4101/backups/backup-4101";

    client.deleteBackupAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteBackupExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4101/locations/location-4101/backupPlans/backupPlan-4101/backups/backup-4101";
      client.deleteBackupAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    BackupName parent = BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]");

    ListVolumeBackupsPagedResponse pagedListResponse = client.listVolumeBackups(parent);

    List<VolumeBackup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVolumeBackupsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listVolumeBackupsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-634/locations/location-634/backupPlans/backupPlan-634/backups/backup-634";

    ListVolumeBackupsPagedResponse pagedListResponse = client.listVolumeBackups(parent);

    List<VolumeBackup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVolumeBackupsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listVolumeBackupsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-634/locations/location-634/backupPlans/backupPlan-634/backups/backup-634";
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
    mockService.addResponse(expectedResponse);

    VolumeBackupName name =
        VolumeBackupName.of(
            "[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]", "[VOLUME_BACKUP]");

    VolumeBackup actualResponse = client.getVolumeBackup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getVolumeBackupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-222/locations/location-222/backupPlans/backupPlan-222/backups/backup-222/volumeBackups/volumeBackup-222";

    VolumeBackup actualResponse = client.getVolumeBackup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getVolumeBackupExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-222/locations/location-222/backupPlans/backupPlan-222/backups/backup-222/volumeBackups/volumeBackup-222";
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
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    RestorePlan restorePlan = RestorePlan.newBuilder().build();
    String restorePlanId = "restorePlanId-857896366";

    RestorePlan actualResponse =
        client.createRestorePlanAsync(parent, restorePlan, restorePlanId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createRestorePlanExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      RestorePlan restorePlan = RestorePlan.newBuilder().build();
      String restorePlanId = "restorePlanId-857896366";
      client.createRestorePlanAsync(parent, restorePlan, restorePlanId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    RestorePlan restorePlan = RestorePlan.newBuilder().build();
    String restorePlanId = "restorePlanId-857896366";

    RestorePlan actualResponse =
        client.createRestorePlanAsync(parent, restorePlan, restorePlanId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createRestorePlanExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      RestorePlan restorePlan = RestorePlan.newBuilder().build();
      String restorePlanId = "restorePlanId-857896366";
      client.createRestorePlanAsync(parent, restorePlan, restorePlanId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListRestorePlansPagedResponse pagedListResponse = client.listRestorePlans(parent);

    List<RestorePlan> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRestorePlansList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listRestorePlansExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListRestorePlansPagedResponse pagedListResponse = client.listRestorePlans(parent);

    List<RestorePlan> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRestorePlansList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listRestorePlansExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
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
    mockService.addResponse(expectedResponse);

    RestorePlanName name = RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]");

    RestorePlan actualResponse = client.getRestorePlan(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getRestorePlanExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-4908/locations/location-4908/restorePlans/restorePlan-4908";

    RestorePlan actualResponse = client.getRestorePlan(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getRestorePlanExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4908/locations/location-4908/restorePlans/restorePlan-4908";
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
    mockService.addResponse(resultOperation);

    RestorePlan restorePlan =
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
    FieldMask updateMask = FieldMask.newBuilder().build();

    RestorePlan actualResponse = client.updateRestorePlanAsync(restorePlan, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateRestorePlanExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RestorePlan restorePlan =
          RestorePlan.newBuilder()
              .setName(RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]").toString())
              .setUid("uid115792")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setDescription("description-1724546052")
              .setBackupPlan(
                  BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
              .setCluster("cluster872092154")
              .setRestoreConfig(RestoreConfig.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .setEtag("etag3123477")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateRestorePlanAsync(restorePlan, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    RestorePlanName name = RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]");

    client.deleteRestorePlanAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteRestorePlanExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RestorePlanName name = RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]");
      client.deleteRestorePlanAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String name = "projects/project-4908/locations/location-4908/restorePlans/restorePlan-4908";

    client.deleteRestorePlanAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteRestorePlanExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4908/locations/location-4908/restorePlans/restorePlan-4908";
      client.deleteRestorePlanAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    RestorePlanName parent = RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]");
    Restore restore = Restore.newBuilder().build();
    String restoreId = "restoreId-1845465015";

    Restore actualResponse = client.createRestoreAsync(parent, restore, restoreId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createRestoreExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RestorePlanName parent = RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]");
      Restore restore = Restore.newBuilder().build();
      String restoreId = "restoreId-1845465015";
      client.createRestoreAsync(parent, restore, restoreId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String parent = "projects/project-6563/locations/location-6563/restorePlans/restorePlan-6563";
    Restore restore = Restore.newBuilder().build();
    String restoreId = "restoreId-1845465015";

    Restore actualResponse = client.createRestoreAsync(parent, restore, restoreId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createRestoreExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-6563/locations/location-6563/restorePlans/restorePlan-6563";
      Restore restore = Restore.newBuilder().build();
      String restoreId = "restoreId-1845465015";
      client.createRestoreAsync(parent, restore, restoreId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    RestorePlanName parent = RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]");

    ListRestoresPagedResponse pagedListResponse = client.listRestores(parent);

    List<Restore> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRestoresList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listRestoresExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-6563/locations/location-6563/restorePlans/restorePlan-6563";

    ListRestoresPagedResponse pagedListResponse = client.listRestores(parent);

    List<Restore> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRestoresList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listRestoresExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-6563/locations/location-6563/restorePlans/restorePlan-6563";
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
    mockService.addResponse(expectedResponse);

    RestoreName name = RestoreName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]");

    Restore actualResponse = client.getRestore(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getRestoreExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-77/locations/location-77/restorePlans/restorePlan-77/restores/restore-77";

    Restore actualResponse = client.getRestore(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getRestoreExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-77/locations/location-77/restorePlans/restorePlan-77/restores/restore-77";
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
    mockService.addResponse(resultOperation);

    Restore restore =
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
    FieldMask updateMask = FieldMask.newBuilder().build();

    Restore actualResponse = client.updateRestoreAsync(restore, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateRestoreExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Restore restore =
          Restore.newBuilder()
              .setName(
                  RestoreName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]")
                      .toString())
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
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateRestoreAsync(restore, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    RestoreName name = RestoreName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]");

    client.deleteRestoreAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteRestoreExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RestoreName name = RestoreName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]");
      client.deleteRestoreAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-77/locations/location-77/restorePlans/restorePlan-77/restores/restore-77";

    client.deleteRestoreAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteRestoreExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-77/locations/location-77/restorePlans/restorePlan-77/restores/restore-77";
      client.deleteRestoreAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    RestoreName parent = RestoreName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]");

    ListVolumeRestoresPagedResponse pagedListResponse = client.listVolumeRestores(parent);

    List<VolumeRestore> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVolumeRestoresList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listVolumeRestoresExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-1186/locations/location-1186/restorePlans/restorePlan-1186/restores/restore-1186";

    ListVolumeRestoresPagedResponse pagedListResponse = client.listVolumeRestores(parent);

    List<VolumeRestore> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVolumeRestoresList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listVolumeRestoresExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-1186/locations/location-1186/restorePlans/restorePlan-1186/restores/restore-1186";
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
    mockService.addResponse(expectedResponse);

    VolumeRestoreName name =
        VolumeRestoreName.of(
            "[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]", "[VOLUME_RESTORE]");

    VolumeRestore actualResponse = client.getVolumeRestore(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getVolumeRestoreExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-5658/locations/location-5658/restorePlans/restorePlan-5658/restores/restore-5658/volumeRestores/volumeRestore-5658";

    VolumeRestore actualResponse = client.getVolumeRestore(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getVolumeRestoreExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5658/locations/location-5658/restorePlans/restorePlan-5658/restores/restore-5658/volumeRestores/volumeRestore-5658";
      client.getVolumeRestore(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
