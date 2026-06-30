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

package com.google.cloud.spanner.admin.database.v1;

import static com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient.ListBackupOperationsPagedResponse;
import static com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient.ListBackupSchedulesPagedResponse;
import static com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient.ListBackupsPagedResponse;
import static com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient.ListDatabaseOperationsPagedResponse;
import static com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient.ListDatabaseRolesPagedResponse;
import static com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient.ListDatabasesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.resourcenames.ResourceName;
import com.google.common.collect.Lists;
import com.google.iam.v1.AuditConfig;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.Duration;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import com.google.spanner.admin.database.v1.AddSplitPointsRequest;
import com.google.spanner.admin.database.v1.AddSplitPointsResponse;
import com.google.spanner.admin.database.v1.Backup;
import com.google.spanner.admin.database.v1.BackupInstancePartition;
import com.google.spanner.admin.database.v1.BackupName;
import com.google.spanner.admin.database.v1.BackupSchedule;
import com.google.spanner.admin.database.v1.BackupScheduleName;
import com.google.spanner.admin.database.v1.BackupScheduleSpec;
import com.google.spanner.admin.database.v1.CopyBackupRequest;
import com.google.spanner.admin.database.v1.CreateBackupEncryptionConfig;
import com.google.spanner.admin.database.v1.CreateBackupRequest;
import com.google.spanner.admin.database.v1.CreateBackupScheduleRequest;
import com.google.spanner.admin.database.v1.CreateDatabaseRequest;
import com.google.spanner.admin.database.v1.Database;
import com.google.spanner.admin.database.v1.DatabaseDialect;
import com.google.spanner.admin.database.v1.DatabaseName;
import com.google.spanner.admin.database.v1.DatabaseRole;
import com.google.spanner.admin.database.v1.DeleteBackupRequest;
import com.google.spanner.admin.database.v1.DeleteBackupScheduleRequest;
import com.google.spanner.admin.database.v1.DropDatabaseRequest;
import com.google.spanner.admin.database.v1.EncryptionConfig;
import com.google.spanner.admin.database.v1.EncryptionInfo;
import com.google.spanner.admin.database.v1.GetBackupRequest;
import com.google.spanner.admin.database.v1.GetBackupScheduleRequest;
import com.google.spanner.admin.database.v1.GetDatabaseDdlRequest;
import com.google.spanner.admin.database.v1.GetDatabaseDdlResponse;
import com.google.spanner.admin.database.v1.GetDatabaseRequest;
import com.google.spanner.admin.database.v1.InstanceName;
import com.google.spanner.admin.database.v1.InternalUpdateGraphOperationRequest;
import com.google.spanner.admin.database.v1.InternalUpdateGraphOperationResponse;
import com.google.spanner.admin.database.v1.ListBackupOperationsRequest;
import com.google.spanner.admin.database.v1.ListBackupOperationsResponse;
import com.google.spanner.admin.database.v1.ListBackupSchedulesRequest;
import com.google.spanner.admin.database.v1.ListBackupSchedulesResponse;
import com.google.spanner.admin.database.v1.ListBackupsRequest;
import com.google.spanner.admin.database.v1.ListBackupsResponse;
import com.google.spanner.admin.database.v1.ListDatabaseOperationsRequest;
import com.google.spanner.admin.database.v1.ListDatabaseOperationsResponse;
import com.google.spanner.admin.database.v1.ListDatabaseRolesRequest;
import com.google.spanner.admin.database.v1.ListDatabaseRolesResponse;
import com.google.spanner.admin.database.v1.ListDatabasesRequest;
import com.google.spanner.admin.database.v1.ListDatabasesResponse;
import com.google.spanner.admin.database.v1.RestoreDatabaseRequest;
import com.google.spanner.admin.database.v1.RestoreInfo;
import com.google.spanner.admin.database.v1.SplitPoints;
import com.google.spanner.admin.database.v1.UpdateBackupRequest;
import com.google.spanner.admin.database.v1.UpdateBackupScheduleRequest;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlRequest;
import com.google.spanner.admin.database.v1.UpdateDatabaseRequest;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
public class DatabaseAdminClientTest {
  private static MockDatabaseAdmin mockDatabaseAdmin;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DatabaseAdminClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDatabaseAdmin = new MockDatabaseAdmin();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockDatabaseAdmin));
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
    DatabaseAdminSettings settings =
        DatabaseAdminSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DatabaseAdminClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listDatabasesTest() throws Exception {
    Database responsesElement = Database.newBuilder().build();
    ListDatabasesResponse expectedResponse =
        ListDatabasesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDatabases(Arrays.asList(responsesElement))
            .build();
    mockDatabaseAdmin.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");

    ListDatabasesPagedResponse pagedListResponse = client.listDatabases(parent);

    List<Database> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDatabasesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDatabasesRequest actualRequest = ((ListDatabasesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDatabasesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatabaseAdmin.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
      client.listDatabases(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDatabasesTest2() throws Exception {
    Database responsesElement = Database.newBuilder().build();
    ListDatabasesResponse expectedResponse =
        ListDatabasesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDatabases(Arrays.asList(responsesElement))
            .build();
    mockDatabaseAdmin.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDatabasesPagedResponse pagedListResponse = client.listDatabases(parent);

    List<Database> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDatabasesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDatabasesRequest actualRequest = ((ListDatabasesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDatabasesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatabaseAdmin.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDatabases(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDatabaseTest() throws Exception {
    Database expectedResponse =
        Database.newBuilder()
            .setName(DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setRestoreInfo(RestoreInfo.newBuilder().build())
            .setEncryptionConfig(EncryptionConfig.newBuilder().build())
            .addAllEncryptionInfo(new ArrayList<EncryptionInfo>())
            .setVersionRetentionPeriod("versionRetentionPeriod-629783929")
            .setEarliestVersionTime(Timestamp.newBuilder().build())
            .setDefaultLeader("defaultLeader759009962")
            .setDatabaseDialect(DatabaseDialect.forNumber(0))
            .setEnableDropProtection(true)
            .setReconciling(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDatabaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDatabaseAdmin.addResponse(resultOperation);

    InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
    String createStatement = "createStatement744686547";

    Database actualResponse = client.createDatabaseAsync(parent, createStatement).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDatabaseRequest actualRequest = ((CreateDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(createStatement, actualRequest.getCreateStatement());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDatabaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatabaseAdmin.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
      String createStatement = "createStatement744686547";
      client.createDatabaseAsync(parent, createStatement).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createDatabaseTest2() throws Exception {
    Database expectedResponse =
        Database.newBuilder()
            .setName(DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setRestoreInfo(RestoreInfo.newBuilder().build())
            .setEncryptionConfig(EncryptionConfig.newBuilder().build())
            .addAllEncryptionInfo(new ArrayList<EncryptionInfo>())
            .setVersionRetentionPeriod("versionRetentionPeriod-629783929")
            .setEarliestVersionTime(Timestamp.newBuilder().build())
            .setDefaultLeader("defaultLeader759009962")
            .setDatabaseDialect(DatabaseDialect.forNumber(0))
            .setEnableDropProtection(true)
            .setReconciling(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDatabaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDatabaseAdmin.addResponse(resultOperation);

    String parent = "parent-995424086";
    String createStatement = "createStatement744686547";

    Database actualResponse = client.createDatabaseAsync(parent, createStatement).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDatabaseRequest actualRequest = ((CreateDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(createStatement, actualRequest.getCreateStatement());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDatabaseExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatabaseAdmin.addException(exception);

    try {
      String parent = "parent-995424086";
      String createStatement = "createStatement744686547";
      client.createDatabaseAsync(parent, createStatement).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getDatabaseTest() throws Exception {
    Database expectedResponse =
        Database.newBuilder()
            .setName(DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setRestoreInfo(RestoreInfo.newBuilder().build())
            .setEncryptionConfig(EncryptionConfig.newBuilder().build())
            .addAllEncryptionInfo(new ArrayList<EncryptionInfo>())
            .setVersionRetentionPeriod("versionRetentionPeriod-629783929")
            .setEarliestVersionTime(Timestamp.newBuilder().build())
            .setDefaultLeader("defaultLeader759009962")
            .setDatabaseDialect(DatabaseDialect.forNumber(0))
            .setEnableDropProtection(true)
            .setReconciling(true)
            .build();
    mockDatabaseAdmin.addResponse(expectedResponse);

    DatabaseName name = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");

    Database actualResponse = client.getDatabase(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDatabaseRequest actualRequest = ((GetDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDatabaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatabaseAdmin.addException(exception);

    try {
      DatabaseName name = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
      client.getDatabase(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDatabaseTest2() throws Exception {
    Database expectedResponse =
        Database.newBuilder()
            .setName(DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setRestoreInfo(RestoreInfo.newBuilder().build())
            .setEncryptionConfig(EncryptionConfig.newBuilder().build())
            .addAllEncryptionInfo(new ArrayList<EncryptionInfo>())
            .setVersionRetentionPeriod("versionRetentionPeriod-629783929")
            .setEarliestVersionTime(Timestamp.newBuilder().build())
            .setDefaultLeader("defaultLeader759009962")
            .setDatabaseDialect(DatabaseDialect.forNumber(0))
            .setEnableDropProtection(true)
            .setReconciling(true)
            .build();
    mockDatabaseAdmin.addResponse(expectedResponse);

    String name = "name3373707";

    Database actualResponse = client.getDatabase(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDatabaseRequest actualRequest = ((GetDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDatabaseExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatabaseAdmin.addException(exception);

    try {
      String name = "name3373707";
      client.getDatabase(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateDatabaseTest() throws Exception {
    Database expectedResponse =
        Database.newBuilder()
            .setName(DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setRestoreInfo(RestoreInfo.newBuilder().build())
            .setEncryptionConfig(EncryptionConfig.newBuilder().build())
            .addAllEncryptionInfo(new ArrayList<EncryptionInfo>())
            .setVersionRetentionPeriod("versionRetentionPeriod-629783929")
            .setEarliestVersionTime(Timestamp.newBuilder().build())
            .setDefaultLeader("defaultLeader759009962")
            .setDatabaseDialect(DatabaseDialect.forNumber(0))
            .setEnableDropProtection(true)
            .setReconciling(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateDatabaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDatabaseAdmin.addResponse(resultOperation);

    Database database = Database.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Database actualResponse = client.updateDatabaseAsync(database, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDatabaseRequest actualRequest = ((UpdateDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(database, actualRequest.getDatabase());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDatabaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatabaseAdmin.addException(exception);

    try {
      Database database = Database.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDatabaseAsync(database, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateDatabaseDdlTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateDatabaseDdlTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDatabaseAdmin.addResponse(resultOperation);

    DatabaseName database = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
    List<String> statements = new ArrayList<>();

    client.updateDatabaseDdlAsync(database, statements).get();

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDatabaseDdlRequest actualRequest = ((UpdateDatabaseDdlRequest) actualRequests.get(0));

    Assert.assertEquals(database.toString(), actualRequest.getDatabase());
    Assert.assertEquals(statements, actualRequest.getStatementsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDatabaseDdlExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatabaseAdmin.addException(exception);

    try {
      DatabaseName database = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
      List<String> statements = new ArrayList<>();
      client.updateDatabaseDdlAsync(database, statements).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateDatabaseDdlTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateDatabaseDdlTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDatabaseAdmin.addResponse(resultOperation);

    String database = "database1789464955";
    List<String> statements = new ArrayList<>();

    client.updateDatabaseDdlAsync(database, statements).get();

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDatabaseDdlRequest actualRequest = ((UpdateDatabaseDdlRequest) actualRequests.get(0));

    Assert.assertEquals(database, actualRequest.getDatabase());
    Assert.assertEquals(statements, actualRequest.getStatementsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDatabaseDdlExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatabaseAdmin.addException(exception);

    try {
      String database = "database1789464955";
      List<String> statements = new ArrayList<>();
      client.updateDatabaseDdlAsync(database, statements).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void dropDatabaseTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDatabaseAdmin.addResponse(expectedResponse);

    DatabaseName database = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");

    client.dropDatabase(database);

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DropDatabaseRequest actualRequest = ((DropDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(database.toString(), actualRequest.getDatabase());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void dropDatabaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatabaseAdmin.addException(exception);

    try {
      DatabaseName database = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
      client.dropDatabase(database);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void dropDatabaseTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDatabaseAdmin.addResponse(expectedResponse);

    String database = "database1789464955";

    client.dropDatabase(database);

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DropDatabaseRequest actualRequest = ((DropDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(database, actualRequest.getDatabase());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void dropDatabaseExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatabaseAdmin.addException(exception);

    try {
      String database = "database1789464955";
      client.dropDatabase(database);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDatabaseDdlTest() throws Exception {
    GetDatabaseDdlResponse expectedResponse =
        GetDatabaseDdlResponse.newBuilder()
            .addAllStatements(new ArrayList<String>())
            .setProtoDescriptors(ByteString.EMPTY)
            .build();
    mockDatabaseAdmin.addResponse(expectedResponse);

    DatabaseName database = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");

    GetDatabaseDdlResponse actualResponse = client.getDatabaseDdl(database);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDatabaseDdlRequest actualRequest = ((GetDatabaseDdlRequest) actualRequests.get(0));

    Assert.assertEquals(database.toString(), actualRequest.getDatabase());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDatabaseDdlExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatabaseAdmin.addException(exception);

    try {
      DatabaseName database = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
      client.getDatabaseDdl(database);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDatabaseDdlTest2() throws Exception {
    GetDatabaseDdlResponse expectedResponse =
        GetDatabaseDdlResponse.newBuilder()
            .addAllStatements(new ArrayList<String>())
            .setProtoDescriptors(ByteString.EMPTY)
            .build();
    mockDatabaseAdmin.addResponse(expectedResponse);

    String database = "database1789464955";

    GetDatabaseDdlResponse actualResponse = client.getDatabaseDdl(database);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDatabaseDdlRequest actualRequest = ((GetDatabaseDdlRequest) actualRequests.get(0));

    Assert.assertEquals(database, actualRequest.getDatabase());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDatabaseDdlExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatabaseAdmin.addException(exception);

    try {
      String database = "database1789464955";
      client.getDatabaseDdl(database);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockDatabaseAdmin.addResponse(expectedResponse);

    ResourceName resource = BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]");
    Policy policy = Policy.newBuilder().build();

    Policy actualResponse = client.setIamPolicy(resource, policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = ((SetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(resource.toString(), actualRequest.getResource());
    Assert.assertEquals(policy, actualRequest.getPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatabaseAdmin.addException(exception);

    try {
      ResourceName resource = BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]");
      Policy policy = Policy.newBuilder().build();
      client.setIamPolicy(resource, policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setIamPolicyTest2() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockDatabaseAdmin.addResponse(expectedResponse);

    String resource = "resource-341064690";
    Policy policy = Policy.newBuilder().build();

    Policy actualResponse = client.setIamPolicy(resource, policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = ((SetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(resource, actualRequest.getResource());
    Assert.assertEquals(policy, actualRequest.getPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setIamPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatabaseAdmin.addException(exception);

    try {
      String resource = "resource-341064690";
      Policy policy = Policy.newBuilder().build();
      client.setIamPolicy(resource, policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockDatabaseAdmin.addResponse(expectedResponse);

    ResourceName resource = BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]");

    Policy actualResponse = client.getIamPolicy(resource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = ((GetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(resource.toString(), actualRequest.getResource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatabaseAdmin.addException(exception);

    try {
      ResourceName resource = BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]");
      client.getIamPolicy(resource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIamPolicyTest2() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockDatabaseAdmin.addResponse(expectedResponse);

    String resource = "resource-341064690";

    Policy actualResponse = client.getIamPolicy(resource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = ((GetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(resource, actualRequest.getResource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIamPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatabaseAdmin.addException(exception);

    try {
      String resource = "resource-341064690";
      client.getIamPolicy(resource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void testIamPermissionsTest() throws Exception {
    TestIamPermissionsResponse expectedResponse =
        TestIamPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockDatabaseAdmin.addResponse(expectedResponse);

    ResourceName resource = BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]");
    List<String> permissions = new ArrayList<>();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(resource, permissions);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = ((TestIamPermissionsRequest) actualRequests.get(0));

    Assert.assertEquals(resource.toString(), actualRequest.getResource());
    Assert.assertEquals(permissions, actualRequest.getPermissionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void testIamPermissionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatabaseAdmin.addException(exception);

    try {
      ResourceName resource = BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]");
      List<String> permissions = new ArrayList<>();
      client.testIamPermissions(resource, permissions);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void testIamPermissionsTest2() throws Exception {
    TestIamPermissionsResponse expectedResponse =
        TestIamPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockDatabaseAdmin.addResponse(expectedResponse);

    String resource = "resource-341064690";
    List<String> permissions = new ArrayList<>();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(resource, permissions);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = ((TestIamPermissionsRequest) actualRequests.get(0));

    Assert.assertEquals(resource, actualRequest.getResource());
    Assert.assertEquals(permissions, actualRequest.getPermissionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void testIamPermissionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatabaseAdmin.addException(exception);

    try {
      String resource = "resource-341064690";
      List<String> permissions = new ArrayList<>();
      client.testIamPermissions(resource, permissions);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createBackupTest() throws Exception {
    Backup expectedResponse =
        Backup.newBuilder()
            .setDatabase(DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString())
            .setVersionTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setName(BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setSizeBytes(-1796325715)
            .setFreeableSizeBytes(1302251206)
            .setExclusiveSizeBytes(-1085921554)
            .addAllReferencingDatabases(new ArrayList<String>())
            .setEncryptionInfo(EncryptionInfo.newBuilder().build())
            .addAllEncryptionInformation(new ArrayList<EncryptionInfo>())
            .setDatabaseDialect(DatabaseDialect.forNumber(0))
            .addAllReferencingBackups(new ArrayList<String>())
            .setMaxExpireTime(Timestamp.newBuilder().build())
            .addAllBackupSchedules(new ArrayList<String>())
            .setIncrementalBackupChainId("incrementalBackupChainId1926005216")
            .setOldestVersionTime(Timestamp.newBuilder().build())
            .addAllInstancePartitions(new ArrayList<BackupInstancePartition>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createBackupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDatabaseAdmin.addResponse(resultOperation);

    InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
    Backup backup = Backup.newBuilder().build();
    String backupId = "backupId2121930365";

    Backup actualResponse = client.createBackupAsync(parent, backup, backupId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
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
    mockDatabaseAdmin.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
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
            .setDatabase(DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString())
            .setVersionTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setName(BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setSizeBytes(-1796325715)
            .setFreeableSizeBytes(1302251206)
            .setExclusiveSizeBytes(-1085921554)
            .addAllReferencingDatabases(new ArrayList<String>())
            .setEncryptionInfo(EncryptionInfo.newBuilder().build())
            .addAllEncryptionInformation(new ArrayList<EncryptionInfo>())
            .setDatabaseDialect(DatabaseDialect.forNumber(0))
            .addAllReferencingBackups(new ArrayList<String>())
            .setMaxExpireTime(Timestamp.newBuilder().build())
            .addAllBackupSchedules(new ArrayList<String>())
            .setIncrementalBackupChainId("incrementalBackupChainId1926005216")
            .setOldestVersionTime(Timestamp.newBuilder().build())
            .addAllInstancePartitions(new ArrayList<BackupInstancePartition>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createBackupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDatabaseAdmin.addResponse(resultOperation);

    String parent = "parent-995424086";
    Backup backup = Backup.newBuilder().build();
    String backupId = "backupId2121930365";

    Backup actualResponse = client.createBackupAsync(parent, backup, backupId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
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
    mockDatabaseAdmin.addException(exception);

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
  public void copyBackupTest() throws Exception {
    Backup expectedResponse =
        Backup.newBuilder()
            .setDatabase(DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString())
            .setVersionTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setName(BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setSizeBytes(-1796325715)
            .setFreeableSizeBytes(1302251206)
            .setExclusiveSizeBytes(-1085921554)
            .addAllReferencingDatabases(new ArrayList<String>())
            .setEncryptionInfo(EncryptionInfo.newBuilder().build())
            .addAllEncryptionInformation(new ArrayList<EncryptionInfo>())
            .setDatabaseDialect(DatabaseDialect.forNumber(0))
            .addAllReferencingBackups(new ArrayList<String>())
            .setMaxExpireTime(Timestamp.newBuilder().build())
            .addAllBackupSchedules(new ArrayList<String>())
            .setIncrementalBackupChainId("incrementalBackupChainId1926005216")
            .setOldestVersionTime(Timestamp.newBuilder().build())
            .addAllInstancePartitions(new ArrayList<BackupInstancePartition>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("copyBackupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDatabaseAdmin.addResponse(resultOperation);

    InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
    String backupId = "backupId2121930365";
    BackupName sourceBackup = BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]");
    Timestamp expireTime = Timestamp.newBuilder().build();

    Backup actualResponse =
        client.copyBackupAsync(parent, backupId, sourceBackup, expireTime).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CopyBackupRequest actualRequest = ((CopyBackupRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(backupId, actualRequest.getBackupId());
    Assert.assertEquals(sourceBackup.toString(), actualRequest.getSourceBackup());
    Assert.assertEquals(expireTime, actualRequest.getExpireTime());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void copyBackupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatabaseAdmin.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
      String backupId = "backupId2121930365";
      BackupName sourceBackup = BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]");
      Timestamp expireTime = Timestamp.newBuilder().build();
      client.copyBackupAsync(parent, backupId, sourceBackup, expireTime).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void copyBackupTest2() throws Exception {
    Backup expectedResponse =
        Backup.newBuilder()
            .setDatabase(DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString())
            .setVersionTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setName(BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setSizeBytes(-1796325715)
            .setFreeableSizeBytes(1302251206)
            .setExclusiveSizeBytes(-1085921554)
            .addAllReferencingDatabases(new ArrayList<String>())
            .setEncryptionInfo(EncryptionInfo.newBuilder().build())
            .addAllEncryptionInformation(new ArrayList<EncryptionInfo>())
            .setDatabaseDialect(DatabaseDialect.forNumber(0))
            .addAllReferencingBackups(new ArrayList<String>())
            .setMaxExpireTime(Timestamp.newBuilder().build())
            .addAllBackupSchedules(new ArrayList<String>())
            .setIncrementalBackupChainId("incrementalBackupChainId1926005216")
            .setOldestVersionTime(Timestamp.newBuilder().build())
            .addAllInstancePartitions(new ArrayList<BackupInstancePartition>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("copyBackupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDatabaseAdmin.addResponse(resultOperation);

    InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
    String backupId = "backupId2121930365";
    String sourceBackup = "sourceBackup823134653";
    Timestamp expireTime = Timestamp.newBuilder().build();

    Backup actualResponse =
        client.copyBackupAsync(parent, backupId, sourceBackup, expireTime).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CopyBackupRequest actualRequest = ((CopyBackupRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(backupId, actualRequest.getBackupId());
    Assert.assertEquals(sourceBackup, actualRequest.getSourceBackup());
    Assert.assertEquals(expireTime, actualRequest.getExpireTime());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void copyBackupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatabaseAdmin.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
      String backupId = "backupId2121930365";
      String sourceBackup = "sourceBackup823134653";
      Timestamp expireTime = Timestamp.newBuilder().build();
      client.copyBackupAsync(parent, backupId, sourceBackup, expireTime).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void copyBackupTest3() throws Exception {
    Backup expectedResponse =
        Backup.newBuilder()
            .setDatabase(DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString())
            .setVersionTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setName(BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setSizeBytes(-1796325715)
            .setFreeableSizeBytes(1302251206)
            .setExclusiveSizeBytes(-1085921554)
            .addAllReferencingDatabases(new ArrayList<String>())
            .setEncryptionInfo(EncryptionInfo.newBuilder().build())
            .addAllEncryptionInformation(new ArrayList<EncryptionInfo>())
            .setDatabaseDialect(DatabaseDialect.forNumber(0))
            .addAllReferencingBackups(new ArrayList<String>())
            .setMaxExpireTime(Timestamp.newBuilder().build())
            .addAllBackupSchedules(new ArrayList<String>())
            .setIncrementalBackupChainId("incrementalBackupChainId1926005216")
            .setOldestVersionTime(Timestamp.newBuilder().build())
            .addAllInstancePartitions(new ArrayList<BackupInstancePartition>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("copyBackupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDatabaseAdmin.addResponse(resultOperation);

    String parent = "parent-995424086";
    String backupId = "backupId2121930365";
    BackupName sourceBackup = BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]");
    Timestamp expireTime = Timestamp.newBuilder().build();

    Backup actualResponse =
        client.copyBackupAsync(parent, backupId, sourceBackup, expireTime).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CopyBackupRequest actualRequest = ((CopyBackupRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(backupId, actualRequest.getBackupId());
    Assert.assertEquals(sourceBackup.toString(), actualRequest.getSourceBackup());
    Assert.assertEquals(expireTime, actualRequest.getExpireTime());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void copyBackupExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatabaseAdmin.addException(exception);

    try {
      String parent = "parent-995424086";
      String backupId = "backupId2121930365";
      BackupName sourceBackup = BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]");
      Timestamp expireTime = Timestamp.newBuilder().build();
      client.copyBackupAsync(parent, backupId, sourceBackup, expireTime).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void copyBackupTest4() throws Exception {
    Backup expectedResponse =
        Backup.newBuilder()
            .setDatabase(DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString())
            .setVersionTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setName(BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setSizeBytes(-1796325715)
            .setFreeableSizeBytes(1302251206)
            .setExclusiveSizeBytes(-1085921554)
            .addAllReferencingDatabases(new ArrayList<String>())
            .setEncryptionInfo(EncryptionInfo.newBuilder().build())
            .addAllEncryptionInformation(new ArrayList<EncryptionInfo>())
            .setDatabaseDialect(DatabaseDialect.forNumber(0))
            .addAllReferencingBackups(new ArrayList<String>())
            .setMaxExpireTime(Timestamp.newBuilder().build())
            .addAllBackupSchedules(new ArrayList<String>())
            .setIncrementalBackupChainId("incrementalBackupChainId1926005216")
            .setOldestVersionTime(Timestamp.newBuilder().build())
            .addAllInstancePartitions(new ArrayList<BackupInstancePartition>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("copyBackupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDatabaseAdmin.addResponse(resultOperation);

    String parent = "parent-995424086";
    String backupId = "backupId2121930365";
    String sourceBackup = "sourceBackup823134653";
    Timestamp expireTime = Timestamp.newBuilder().build();

    Backup actualResponse =
        client.copyBackupAsync(parent, backupId, sourceBackup, expireTime).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CopyBackupRequest actualRequest = ((CopyBackupRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(backupId, actualRequest.getBackupId());
    Assert.assertEquals(sourceBackup, actualRequest.getSourceBackup());
    Assert.assertEquals(expireTime, actualRequest.getExpireTime());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void copyBackupExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatabaseAdmin.addException(exception);

    try {
      String parent = "parent-995424086";
      String backupId = "backupId2121930365";
      String sourceBackup = "sourceBackup823134653";
      Timestamp expireTime = Timestamp.newBuilder().build();
      client.copyBackupAsync(parent, backupId, sourceBackup, expireTime).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getBackupTest() throws Exception {
    Backup expectedResponse =
        Backup.newBuilder()
            .setDatabase(DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString())
            .setVersionTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setName(BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setSizeBytes(-1796325715)
            .setFreeableSizeBytes(1302251206)
            .setExclusiveSizeBytes(-1085921554)
            .addAllReferencingDatabases(new ArrayList<String>())
            .setEncryptionInfo(EncryptionInfo.newBuilder().build())
            .addAllEncryptionInformation(new ArrayList<EncryptionInfo>())
            .setDatabaseDialect(DatabaseDialect.forNumber(0))
            .addAllReferencingBackups(new ArrayList<String>())
            .setMaxExpireTime(Timestamp.newBuilder().build())
            .addAllBackupSchedules(new ArrayList<String>())
            .setIncrementalBackupChainId("incrementalBackupChainId1926005216")
            .setOldestVersionTime(Timestamp.newBuilder().build())
            .addAllInstancePartitions(new ArrayList<BackupInstancePartition>())
            .build();
    mockDatabaseAdmin.addResponse(expectedResponse);

    BackupName name = BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]");

    Backup actualResponse = client.getBackup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
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
    mockDatabaseAdmin.addException(exception);

    try {
      BackupName name = BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]");
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
            .setDatabase(DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString())
            .setVersionTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setName(BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setSizeBytes(-1796325715)
            .setFreeableSizeBytes(1302251206)
            .setExclusiveSizeBytes(-1085921554)
            .addAllReferencingDatabases(new ArrayList<String>())
            .setEncryptionInfo(EncryptionInfo.newBuilder().build())
            .addAllEncryptionInformation(new ArrayList<EncryptionInfo>())
            .setDatabaseDialect(DatabaseDialect.forNumber(0))
            .addAllReferencingBackups(new ArrayList<String>())
            .setMaxExpireTime(Timestamp.newBuilder().build())
            .addAllBackupSchedules(new ArrayList<String>())
            .setIncrementalBackupChainId("incrementalBackupChainId1926005216")
            .setOldestVersionTime(Timestamp.newBuilder().build())
            .addAllInstancePartitions(new ArrayList<BackupInstancePartition>())
            .build();
    mockDatabaseAdmin.addResponse(expectedResponse);

    String name = "name3373707";

    Backup actualResponse = client.getBackup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
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
    mockDatabaseAdmin.addException(exception);

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
            .setDatabase(DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString())
            .setVersionTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setName(BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setSizeBytes(-1796325715)
            .setFreeableSizeBytes(1302251206)
            .setExclusiveSizeBytes(-1085921554)
            .addAllReferencingDatabases(new ArrayList<String>())
            .setEncryptionInfo(EncryptionInfo.newBuilder().build())
            .addAllEncryptionInformation(new ArrayList<EncryptionInfo>())
            .setDatabaseDialect(DatabaseDialect.forNumber(0))
            .addAllReferencingBackups(new ArrayList<String>())
            .setMaxExpireTime(Timestamp.newBuilder().build())
            .addAllBackupSchedules(new ArrayList<String>())
            .setIncrementalBackupChainId("incrementalBackupChainId1926005216")
            .setOldestVersionTime(Timestamp.newBuilder().build())
            .addAllInstancePartitions(new ArrayList<BackupInstancePartition>())
            .build();
    mockDatabaseAdmin.addResponse(expectedResponse);

    Backup backup = Backup.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Backup actualResponse = client.updateBackup(backup, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
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
    mockDatabaseAdmin.addException(exception);

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
    Empty expectedResponse = Empty.newBuilder().build();
    mockDatabaseAdmin.addResponse(expectedResponse);

    BackupName name = BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]");

    client.deleteBackup(name);

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
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
    mockDatabaseAdmin.addException(exception);

    try {
      BackupName name = BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]");
      client.deleteBackup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteBackupTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDatabaseAdmin.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteBackup(name);

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
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
    mockDatabaseAdmin.addException(exception);

    try {
      String name = "name3373707";
      client.deleteBackup(name);
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
    mockDatabaseAdmin.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");

    ListBackupsPagedResponse pagedListResponse = client.listBackups(parent);

    List<Backup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
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
    mockDatabaseAdmin.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
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
    mockDatabaseAdmin.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListBackupsPagedResponse pagedListResponse = client.listBackups(parent);

    List<Backup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
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
    mockDatabaseAdmin.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listBackups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void restoreDatabaseTest() throws Exception {
    Database expectedResponse =
        Database.newBuilder()
            .setName(DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setRestoreInfo(RestoreInfo.newBuilder().build())
            .setEncryptionConfig(EncryptionConfig.newBuilder().build())
            .addAllEncryptionInfo(new ArrayList<EncryptionInfo>())
            .setVersionRetentionPeriod("versionRetentionPeriod-629783929")
            .setEarliestVersionTime(Timestamp.newBuilder().build())
            .setDefaultLeader("defaultLeader759009962")
            .setDatabaseDialect(DatabaseDialect.forNumber(0))
            .setEnableDropProtection(true)
            .setReconciling(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("restoreDatabaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDatabaseAdmin.addResponse(resultOperation);

    InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
    String databaseId = "databaseId1688905718";
    BackupName backup = BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]");

    Database actualResponse = client.restoreDatabaseAsync(parent, databaseId, backup).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RestoreDatabaseRequest actualRequest = ((RestoreDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(databaseId, actualRequest.getDatabaseId());
    Assert.assertEquals(backup.toString(), actualRequest.getBackup());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void restoreDatabaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatabaseAdmin.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
      String databaseId = "databaseId1688905718";
      BackupName backup = BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]");
      client.restoreDatabaseAsync(parent, databaseId, backup).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void restoreDatabaseTest2() throws Exception {
    Database expectedResponse =
        Database.newBuilder()
            .setName(DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setRestoreInfo(RestoreInfo.newBuilder().build())
            .setEncryptionConfig(EncryptionConfig.newBuilder().build())
            .addAllEncryptionInfo(new ArrayList<EncryptionInfo>())
            .setVersionRetentionPeriod("versionRetentionPeriod-629783929")
            .setEarliestVersionTime(Timestamp.newBuilder().build())
            .setDefaultLeader("defaultLeader759009962")
            .setDatabaseDialect(DatabaseDialect.forNumber(0))
            .setEnableDropProtection(true)
            .setReconciling(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("restoreDatabaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDatabaseAdmin.addResponse(resultOperation);

    InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
    String databaseId = "databaseId1688905718";
    String backup = "backup-1396673086";

    Database actualResponse = client.restoreDatabaseAsync(parent, databaseId, backup).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RestoreDatabaseRequest actualRequest = ((RestoreDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(databaseId, actualRequest.getDatabaseId());
    Assert.assertEquals(backup, actualRequest.getBackup());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void restoreDatabaseExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatabaseAdmin.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
      String databaseId = "databaseId1688905718";
      String backup = "backup-1396673086";
      client.restoreDatabaseAsync(parent, databaseId, backup).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void restoreDatabaseTest3() throws Exception {
    Database expectedResponse =
        Database.newBuilder()
            .setName(DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setRestoreInfo(RestoreInfo.newBuilder().build())
            .setEncryptionConfig(EncryptionConfig.newBuilder().build())
            .addAllEncryptionInfo(new ArrayList<EncryptionInfo>())
            .setVersionRetentionPeriod("versionRetentionPeriod-629783929")
            .setEarliestVersionTime(Timestamp.newBuilder().build())
            .setDefaultLeader("defaultLeader759009962")
            .setDatabaseDialect(DatabaseDialect.forNumber(0))
            .setEnableDropProtection(true)
            .setReconciling(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("restoreDatabaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDatabaseAdmin.addResponse(resultOperation);

    String parent = "parent-995424086";
    String databaseId = "databaseId1688905718";
    BackupName backup = BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]");

    Database actualResponse = client.restoreDatabaseAsync(parent, databaseId, backup).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RestoreDatabaseRequest actualRequest = ((RestoreDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(databaseId, actualRequest.getDatabaseId());
    Assert.assertEquals(backup.toString(), actualRequest.getBackup());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void restoreDatabaseExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatabaseAdmin.addException(exception);

    try {
      String parent = "parent-995424086";
      String databaseId = "databaseId1688905718";
      BackupName backup = BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]");
      client.restoreDatabaseAsync(parent, databaseId, backup).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void restoreDatabaseTest4() throws Exception {
    Database expectedResponse =
        Database.newBuilder()
            .setName(DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setRestoreInfo(RestoreInfo.newBuilder().build())
            .setEncryptionConfig(EncryptionConfig.newBuilder().build())
            .addAllEncryptionInfo(new ArrayList<EncryptionInfo>())
            .setVersionRetentionPeriod("versionRetentionPeriod-629783929")
            .setEarliestVersionTime(Timestamp.newBuilder().build())
            .setDefaultLeader("defaultLeader759009962")
            .setDatabaseDialect(DatabaseDialect.forNumber(0))
            .setEnableDropProtection(true)
            .setReconciling(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("restoreDatabaseTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDatabaseAdmin.addResponse(resultOperation);

    String parent = "parent-995424086";
    String databaseId = "databaseId1688905718";
    String backup = "backup-1396673086";

    Database actualResponse = client.restoreDatabaseAsync(parent, databaseId, backup).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RestoreDatabaseRequest actualRequest = ((RestoreDatabaseRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(databaseId, actualRequest.getDatabaseId());
    Assert.assertEquals(backup, actualRequest.getBackup());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void restoreDatabaseExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatabaseAdmin.addException(exception);

    try {
      String parent = "parent-995424086";
      String databaseId = "databaseId1688905718";
      String backup = "backup-1396673086";
      client.restoreDatabaseAsync(parent, databaseId, backup).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listDatabaseOperationsTest() throws Exception {
    Operation responsesElement = Operation.newBuilder().build();
    ListDatabaseOperationsResponse expectedResponse =
        ListDatabaseOperationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllOperations(Arrays.asList(responsesElement))
            .build();
    mockDatabaseAdmin.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");

    ListDatabaseOperationsPagedResponse pagedListResponse = client.listDatabaseOperations(parent);

    List<Operation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOperationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDatabaseOperationsRequest actualRequest =
        ((ListDatabaseOperationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDatabaseOperationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatabaseAdmin.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
      client.listDatabaseOperations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDatabaseOperationsTest2() throws Exception {
    Operation responsesElement = Operation.newBuilder().build();
    ListDatabaseOperationsResponse expectedResponse =
        ListDatabaseOperationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllOperations(Arrays.asList(responsesElement))
            .build();
    mockDatabaseAdmin.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDatabaseOperationsPagedResponse pagedListResponse = client.listDatabaseOperations(parent);

    List<Operation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOperationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDatabaseOperationsRequest actualRequest =
        ((ListDatabaseOperationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDatabaseOperationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatabaseAdmin.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDatabaseOperations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBackupOperationsTest() throws Exception {
    Operation responsesElement = Operation.newBuilder().build();
    ListBackupOperationsResponse expectedResponse =
        ListBackupOperationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllOperations(Arrays.asList(responsesElement))
            .build();
    mockDatabaseAdmin.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");

    ListBackupOperationsPagedResponse pagedListResponse = client.listBackupOperations(parent);

    List<Operation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOperationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBackupOperationsRequest actualRequest =
        ((ListBackupOperationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBackupOperationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatabaseAdmin.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
      client.listBackupOperations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBackupOperationsTest2() throws Exception {
    Operation responsesElement = Operation.newBuilder().build();
    ListBackupOperationsResponse expectedResponse =
        ListBackupOperationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllOperations(Arrays.asList(responsesElement))
            .build();
    mockDatabaseAdmin.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListBackupOperationsPagedResponse pagedListResponse = client.listBackupOperations(parent);

    List<Operation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOperationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBackupOperationsRequest actualRequest =
        ((ListBackupOperationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBackupOperationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatabaseAdmin.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listBackupOperations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDatabaseRolesTest() throws Exception {
    DatabaseRole responsesElement = DatabaseRole.newBuilder().build();
    ListDatabaseRolesResponse expectedResponse =
        ListDatabaseRolesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDatabaseRoles(Arrays.asList(responsesElement))
            .build();
    mockDatabaseAdmin.addResponse(expectedResponse);

    DatabaseName parent = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");

    ListDatabaseRolesPagedResponse pagedListResponse = client.listDatabaseRoles(parent);

    List<DatabaseRole> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDatabaseRolesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDatabaseRolesRequest actualRequest = ((ListDatabaseRolesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDatabaseRolesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatabaseAdmin.addException(exception);

    try {
      DatabaseName parent = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
      client.listDatabaseRoles(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDatabaseRolesTest2() throws Exception {
    DatabaseRole responsesElement = DatabaseRole.newBuilder().build();
    ListDatabaseRolesResponse expectedResponse =
        ListDatabaseRolesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDatabaseRoles(Arrays.asList(responsesElement))
            .build();
    mockDatabaseAdmin.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDatabaseRolesPagedResponse pagedListResponse = client.listDatabaseRoles(parent);

    List<DatabaseRole> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDatabaseRolesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDatabaseRolesRequest actualRequest = ((ListDatabaseRolesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDatabaseRolesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatabaseAdmin.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDatabaseRoles(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void addSplitPointsTest() throws Exception {
    AddSplitPointsResponse expectedResponse = AddSplitPointsResponse.newBuilder().build();
    mockDatabaseAdmin.addResponse(expectedResponse);

    DatabaseName database = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
    List<SplitPoints> splitPoints = new ArrayList<>();

    AddSplitPointsResponse actualResponse = client.addSplitPoints(database, splitPoints);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AddSplitPointsRequest actualRequest = ((AddSplitPointsRequest) actualRequests.get(0));

    Assert.assertEquals(database.toString(), actualRequest.getDatabase());
    Assert.assertEquals(splitPoints, actualRequest.getSplitPointsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void addSplitPointsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatabaseAdmin.addException(exception);

    try {
      DatabaseName database = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
      List<SplitPoints> splitPoints = new ArrayList<>();
      client.addSplitPoints(database, splitPoints);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void addSplitPointsTest2() throws Exception {
    AddSplitPointsResponse expectedResponse = AddSplitPointsResponse.newBuilder().build();
    mockDatabaseAdmin.addResponse(expectedResponse);

    String database = "database1789464955";
    List<SplitPoints> splitPoints = new ArrayList<>();

    AddSplitPointsResponse actualResponse = client.addSplitPoints(database, splitPoints);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AddSplitPointsRequest actualRequest = ((AddSplitPointsRequest) actualRequests.get(0));

    Assert.assertEquals(database, actualRequest.getDatabase());
    Assert.assertEquals(splitPoints, actualRequest.getSplitPointsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void addSplitPointsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatabaseAdmin.addException(exception);

    try {
      String database = "database1789464955";
      List<SplitPoints> splitPoints = new ArrayList<>();
      client.addSplitPoints(database, splitPoints);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createBackupScheduleTest() throws Exception {
    BackupSchedule expectedResponse =
        BackupSchedule.newBuilder()
            .setName(
                BackupScheduleName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SCHEDULE]")
                    .toString())
            .setSpec(BackupScheduleSpec.newBuilder().build())
            .setRetentionDuration(Duration.newBuilder().build())
            .setEncryptionConfig(CreateBackupEncryptionConfig.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockDatabaseAdmin.addResponse(expectedResponse);

    DatabaseName parent = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
    BackupSchedule backupSchedule = BackupSchedule.newBuilder().build();
    String backupScheduleId = "backupScheduleId1704974708";

    BackupSchedule actualResponse =
        client.createBackupSchedule(parent, backupSchedule, backupScheduleId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBackupScheduleRequest actualRequest =
        ((CreateBackupScheduleRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(backupSchedule, actualRequest.getBackupSchedule());
    Assert.assertEquals(backupScheduleId, actualRequest.getBackupScheduleId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBackupScheduleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatabaseAdmin.addException(exception);

    try {
      DatabaseName parent = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
      BackupSchedule backupSchedule = BackupSchedule.newBuilder().build();
      String backupScheduleId = "backupScheduleId1704974708";
      client.createBackupSchedule(parent, backupSchedule, backupScheduleId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createBackupScheduleTest2() throws Exception {
    BackupSchedule expectedResponse =
        BackupSchedule.newBuilder()
            .setName(
                BackupScheduleName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SCHEDULE]")
                    .toString())
            .setSpec(BackupScheduleSpec.newBuilder().build())
            .setRetentionDuration(Duration.newBuilder().build())
            .setEncryptionConfig(CreateBackupEncryptionConfig.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockDatabaseAdmin.addResponse(expectedResponse);

    String parent = "parent-995424086";
    BackupSchedule backupSchedule = BackupSchedule.newBuilder().build();
    String backupScheduleId = "backupScheduleId1704974708";

    BackupSchedule actualResponse =
        client.createBackupSchedule(parent, backupSchedule, backupScheduleId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBackupScheduleRequest actualRequest =
        ((CreateBackupScheduleRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(backupSchedule, actualRequest.getBackupSchedule());
    Assert.assertEquals(backupScheduleId, actualRequest.getBackupScheduleId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBackupScheduleExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatabaseAdmin.addException(exception);

    try {
      String parent = "parent-995424086";
      BackupSchedule backupSchedule = BackupSchedule.newBuilder().build();
      String backupScheduleId = "backupScheduleId1704974708";
      client.createBackupSchedule(parent, backupSchedule, backupScheduleId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBackupScheduleTest() throws Exception {
    BackupSchedule expectedResponse =
        BackupSchedule.newBuilder()
            .setName(
                BackupScheduleName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SCHEDULE]")
                    .toString())
            .setSpec(BackupScheduleSpec.newBuilder().build())
            .setRetentionDuration(Duration.newBuilder().build())
            .setEncryptionConfig(CreateBackupEncryptionConfig.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockDatabaseAdmin.addResponse(expectedResponse);

    BackupScheduleName name =
        BackupScheduleName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SCHEDULE]");

    BackupSchedule actualResponse = client.getBackupSchedule(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBackupScheduleRequest actualRequest = ((GetBackupScheduleRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBackupScheduleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatabaseAdmin.addException(exception);

    try {
      BackupScheduleName name =
          BackupScheduleName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SCHEDULE]");
      client.getBackupSchedule(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBackupScheduleTest2() throws Exception {
    BackupSchedule expectedResponse =
        BackupSchedule.newBuilder()
            .setName(
                BackupScheduleName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SCHEDULE]")
                    .toString())
            .setSpec(BackupScheduleSpec.newBuilder().build())
            .setRetentionDuration(Duration.newBuilder().build())
            .setEncryptionConfig(CreateBackupEncryptionConfig.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockDatabaseAdmin.addResponse(expectedResponse);

    String name = "name3373707";

    BackupSchedule actualResponse = client.getBackupSchedule(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBackupScheduleRequest actualRequest = ((GetBackupScheduleRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBackupScheduleExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatabaseAdmin.addException(exception);

    try {
      String name = "name3373707";
      client.getBackupSchedule(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateBackupScheduleTest() throws Exception {
    BackupSchedule expectedResponse =
        BackupSchedule.newBuilder()
            .setName(
                BackupScheduleName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SCHEDULE]")
                    .toString())
            .setSpec(BackupScheduleSpec.newBuilder().build())
            .setRetentionDuration(Duration.newBuilder().build())
            .setEncryptionConfig(CreateBackupEncryptionConfig.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockDatabaseAdmin.addResponse(expectedResponse);

    BackupSchedule backupSchedule = BackupSchedule.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    BackupSchedule actualResponse = client.updateBackupSchedule(backupSchedule, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateBackupScheduleRequest actualRequest =
        ((UpdateBackupScheduleRequest) actualRequests.get(0));

    Assert.assertEquals(backupSchedule, actualRequest.getBackupSchedule());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateBackupScheduleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatabaseAdmin.addException(exception);

    try {
      BackupSchedule backupSchedule = BackupSchedule.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateBackupSchedule(backupSchedule, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteBackupScheduleTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDatabaseAdmin.addResponse(expectedResponse);

    BackupScheduleName name =
        BackupScheduleName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SCHEDULE]");

    client.deleteBackupSchedule(name);

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteBackupScheduleRequest actualRequest =
        ((DeleteBackupScheduleRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteBackupScheduleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatabaseAdmin.addException(exception);

    try {
      BackupScheduleName name =
          BackupScheduleName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SCHEDULE]");
      client.deleteBackupSchedule(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteBackupScheduleTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDatabaseAdmin.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteBackupSchedule(name);

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteBackupScheduleRequest actualRequest =
        ((DeleteBackupScheduleRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteBackupScheduleExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatabaseAdmin.addException(exception);

    try {
      String name = "name3373707";
      client.deleteBackupSchedule(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBackupSchedulesTest() throws Exception {
    BackupSchedule responsesElement = BackupSchedule.newBuilder().build();
    ListBackupSchedulesResponse expectedResponse =
        ListBackupSchedulesResponse.newBuilder()
            .setNextPageToken("")
            .addAllBackupSchedules(Arrays.asList(responsesElement))
            .build();
    mockDatabaseAdmin.addResponse(expectedResponse);

    DatabaseName parent = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");

    ListBackupSchedulesPagedResponse pagedListResponse = client.listBackupSchedules(parent);

    List<BackupSchedule> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupSchedulesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBackupSchedulesRequest actualRequest = ((ListBackupSchedulesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBackupSchedulesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatabaseAdmin.addException(exception);

    try {
      DatabaseName parent = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
      client.listBackupSchedules(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBackupSchedulesTest2() throws Exception {
    BackupSchedule responsesElement = BackupSchedule.newBuilder().build();
    ListBackupSchedulesResponse expectedResponse =
        ListBackupSchedulesResponse.newBuilder()
            .setNextPageToken("")
            .addAllBackupSchedules(Arrays.asList(responsesElement))
            .build();
    mockDatabaseAdmin.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListBackupSchedulesPagedResponse pagedListResponse = client.listBackupSchedules(parent);

    List<BackupSchedule> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBackupSchedulesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBackupSchedulesRequest actualRequest = ((ListBackupSchedulesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBackupSchedulesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatabaseAdmin.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listBackupSchedules(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void internalUpdateGraphOperationTest() throws Exception {
    InternalUpdateGraphOperationResponse expectedResponse =
        InternalUpdateGraphOperationResponse.newBuilder().build();
    mockDatabaseAdmin.addResponse(expectedResponse);

    DatabaseName database = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
    String operationId = "operationId129704162";

    InternalUpdateGraphOperationResponse actualResponse =
        client.internalUpdateGraphOperation(database, operationId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    InternalUpdateGraphOperationRequest actualRequest =
        ((InternalUpdateGraphOperationRequest) actualRequests.get(0));

    Assert.assertEquals(database.toString(), actualRequest.getDatabase());
    Assert.assertEquals(operationId, actualRequest.getOperationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void internalUpdateGraphOperationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatabaseAdmin.addException(exception);

    try {
      DatabaseName database = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
      String operationId = "operationId129704162";
      client.internalUpdateGraphOperation(database, operationId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void internalUpdateGraphOperationTest2() throws Exception {
    InternalUpdateGraphOperationResponse expectedResponse =
        InternalUpdateGraphOperationResponse.newBuilder().build();
    mockDatabaseAdmin.addResponse(expectedResponse);

    String database = "database1789464955";
    String operationId = "operationId129704162";

    InternalUpdateGraphOperationResponse actualResponse =
        client.internalUpdateGraphOperation(database, operationId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatabaseAdmin.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    InternalUpdateGraphOperationRequest actualRequest =
        ((InternalUpdateGraphOperationRequest) actualRequests.get(0));

    Assert.assertEquals(database, actualRequest.getDatabase());
    Assert.assertEquals(operationId, actualRequest.getOperationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void internalUpdateGraphOperationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatabaseAdmin.addException(exception);

    try {
      String database = "database1789464955";
      String operationId = "operationId129704162";
      client.internalUpdateGraphOperation(database, operationId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
