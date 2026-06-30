/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.CancelledException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.cloud.spanner.OperationFutureUtil.FakeStatusCode;
import com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient;
import com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient.ListBackupOperationsPagedResponse;
import com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient.ListBackupsPagedResponse;
import com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient.ListDatabaseOperationsPagedResponse;
import com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient.ListDatabasesPagedResponse;
import com.google.cloud.spanner.admin.database.v1.DatabaseAdminSettings;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import com.google.spanner.admin.database.v1.Backup;
import com.google.spanner.admin.database.v1.CreateBackupMetadata;
import com.google.spanner.admin.database.v1.CreateBackupRequest;
import com.google.spanner.admin.database.v1.CreateDatabaseMetadata;
import com.google.spanner.admin.database.v1.CreateDatabaseRequest;
import com.google.spanner.admin.database.v1.Database;
import com.google.spanner.admin.database.v1.GetDatabaseDdlResponse;
import com.google.spanner.admin.database.v1.RestoreDatabaseMetadata;
import com.google.spanner.admin.database.v1.RestoreDatabaseRequest;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlRequest;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MockDatabaseAdminServiceImplTest {
  @Rule public ExpectedException exception = ExpectedException.none();

  private static class ApiExceptionMatcher extends BaseMatcher<Throwable> {
    private final StatusCode.Code expectedStatus;

    private static ApiExceptionMatcher forCode(StatusCode.Code status) {
      return new ApiExceptionMatcher(status);
    }

    private ApiExceptionMatcher(StatusCode.Code expectedStatus) {
      this.expectedStatus = checkNotNull(expectedStatus);
    }

    @Override
    public boolean matches(Object item) {
      ApiException ae = null;
      if (item instanceof ExecutionException) {
        ExecutionException e = (ExecutionException) item;
        if (e.getCause() instanceof ApiException) {
          ae = (ApiException) e.getCause();
        }
      } else if (item instanceof ApiException) {
        ae = (ApiException) item;
      }
      if (ae != null) {
        return ae.getStatusCode().getCode() == expectedStatus;
      }
      return false;
    }

    @Override
    public void describeTo(Description description) {
      description.appendText("ApiException[" + expectedStatus + "]");
    }
  }

  private static final String TEST_PARENT = "projects/my-project/instances/my-instance";
  private static final String TEST_DB_NAME = String.format("%s/databases/test-db", TEST_PARENT);
  private static final String TEST_BCK_NAME = String.format("%s/backups/test-bck", TEST_PARENT);
  private static MockOperationsServiceImpl mockOperations;
  private static MockDatabaseAdminServiceImpl mockDatabaseAdmin;
  private static MockServiceHelper serviceHelper;
  private DatabaseAdminClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockOperations = new MockOperationsServiceImpl();
    mockDatabaseAdmin = new MockDatabaseAdminServiceImpl(mockOperations);
    serviceHelper =
        new MockServiceHelper("in-process-1", Arrays.asList(mockOperations, mockDatabaseAdmin));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    channelProvider = serviceHelper.createChannelProvider();
    DatabaseAdminSettings.Builder settingsBuilder =
        DatabaseAdminSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create());
    settingsBuilder
        .createBackupOperationSettings()
        .setPollingAlgorithm(
            OperationTimedPollAlgorithm.create(
                RetrySettings.newBuilder()
                    .setInitialRpcTimeoutDuration(Duration.ofMillis(20L))
                    .setInitialRetryDelayDuration(Duration.ofMillis(10L))
                    .setMaxRetryDelayDuration(Duration.ofMillis(150L))
                    .setMaxRpcTimeoutDuration(Duration.ofMillis(150L))
                    .setMaxAttempts(10)
                    .setTotalTimeoutDuration(Duration.ofMillis(5000L))
                    .setRetryDelayMultiplier(1.3)
                    .setRpcTimeoutMultiplier(1.3)
                    .build()));
    settingsBuilder
        .createDatabaseOperationSettings()
        .setPollingAlgorithm(
            OperationTimedPollAlgorithm.create(
                RetrySettings.newBuilder()
                    .setInitialRpcTimeoutDuration(Duration.ofMillis(20L))
                    .setInitialRetryDelayDuration(Duration.ofMillis(10L))
                    .setMaxRetryDelayDuration(Duration.ofMillis(150L))
                    .setMaxRpcTimeoutDuration(Duration.ofMillis(150L))
                    .setMaxAttempts(10)
                    .setTotalTimeoutDuration(Duration.ofMillis(5000L))
                    .setRetryDelayMultiplier(1.3)
                    .setRpcTimeoutMultiplier(1.3)
                    .build()));
    settingsBuilder
        .restoreDatabaseOperationSettings()
        .setPollingAlgorithm(
            OperationTimedPollAlgorithm.create(
                RetrySettings.newBuilder()
                    .setInitialRpcTimeoutDuration(Duration.ofMillis(20L))
                    .setInitialRetryDelayDuration(Duration.ofMillis(10L))
                    .setMaxRetryDelayDuration(Duration.ofMillis(150L))
                    .setMaxRpcTimeoutDuration(Duration.ofMillis(150L))
                    .setMaxAttempts(10)
                    .setTotalTimeoutDuration(Duration.ofMillis(5000L))
                    .setRetryDelayMultiplier(1.3)
                    .setRpcTimeoutMultiplier(1.3)
                    .build()));
    client = DatabaseAdminClient.create(settingsBuilder.build());
  }

  @After
  public void tearDown() {
    client.close();
  }

  private Database createTestDb() {
    CreateDatabaseRequest request =
        CreateDatabaseRequest.newBuilder()
            .setCreateStatement("CREATE DATABASE `test-db`")
            .addAllExtraStatements(Arrays.asList("CREATE TABLE FOO", "CREATE TABLE BAR"))
            .setParent(TEST_PARENT)
            .build();
    OperationFuture<Database, CreateDatabaseMetadata> op =
        client.createDatabaseOperationCallable().futureCall(request);
    try {
      return op.get();
    } catch (ExecutionException e) {
      if (e.getCause() != null && e.getCause() instanceof RuntimeException) {
        throw (RuntimeException) e.getCause();
      }
      throw new RuntimeException(e);
    } catch (InterruptedException e) {
      throw new CancelledException(e, FakeStatusCode.of(Code.CANCELLED), false);
    }
  }

  @Test
  public void createDatabase() {
    Database db = createTestDb();
    assertThat(db.getName()).isEqualTo(TEST_DB_NAME);
  }

  @Test
  public void createDatabaseAlreadyExists() {
    createTestDb();
    exception.expect(ApiExceptionMatcher.forCode(StatusCode.Code.ALREADY_EXISTS));
    createTestDb();
  }

  @Test
  public void dropDatabase() {
    createTestDb();
    Database db = client.getDatabase(TEST_DB_NAME);
    assertThat(db.getName()).isEqualTo(TEST_DB_NAME);
    client.dropDatabase(TEST_DB_NAME);
    exception.expect(ApiExceptionMatcher.forCode(StatusCode.Code.NOT_FOUND));
    client.getDatabase(TEST_DB_NAME);
  }

  @Test
  public void dropDatabaseNotFound() {
    exception.expect(ApiExceptionMatcher.forCode(StatusCode.Code.NOT_FOUND));
    client.dropDatabase(TEST_DB_NAME);
  }

  @Test
  public void getDatabase() {
    createTestDb();
    Database db = client.getDatabase(TEST_DB_NAME);
    assertThat(db.getName()).isEqualTo(TEST_DB_NAME);
  }

  @Test
  public void getDatabaseNotFound() {
    exception.expect(ApiExceptionMatcher.forCode(StatusCode.Code.NOT_FOUND));
    client.getDatabase(TEST_DB_NAME);
  }

  @Test
  public void getDatabaseDdl() {
    createTestDb();
    GetDatabaseDdlResponse ddl = client.getDatabaseDdl(TEST_DB_NAME);
    assertThat(ddl.getStatementsList()).containsExactly("CREATE TABLE FOO", "CREATE TABLE BAR");
  }

  @Test
  public void getDatabaseDdlNotFound() {
    exception.expect(ApiExceptionMatcher.forCode(StatusCode.Code.NOT_FOUND));
    client.getDatabaseDdl(TEST_DB_NAME);
  }

  @Test
  public void listDatabases() {
    createTestDb();
    ListDatabasesPagedResponse response = client.listDatabases(TEST_PARENT);
    List<String> databases = new ArrayList<>();
    for (Database db : response.iterateAll()) {
      databases.add(db.getName());
    }
    assertThat(databases).containsExactly(TEST_DB_NAME);
  }

  @Test
  public void listDatabaseOperations() {
    createTestDb();
    ListDatabaseOperationsPagedResponse response = client.listDatabaseOperations(TEST_DB_NAME);
    List<Operation> operations = new ArrayList<>();
    for (Operation op : response.iterateAll()) {
      operations.add(op);
    }
    assertThat(operations).hasSize(1);
  }

  @Test
  public void updateDatabaseDdl() throws InterruptedException, ExecutionException {
    createTestDb();
    UpdateDatabaseDdlRequest request =
        UpdateDatabaseDdlRequest.newBuilder()
            .setDatabase(TEST_DB_NAME)
            .addAllStatements(Arrays.asList("CREATE TABLE BAZ", "DROP TABLE FOO"))
            .build();
    OperationFuture<Empty, UpdateDatabaseDdlMetadata> op =
        client.updateDatabaseDdlOperationCallable().futureCall(request);
    op.get();
    GetDatabaseDdlResponse response = client.getDatabaseDdl(TEST_DB_NAME);
    assertThat(response.getStatementsList())
        .containsExactly(
            "CREATE TABLE FOO", "CREATE TABLE BAR", "CREATE TABLE BAZ", "DROP TABLE FOO");
  }

  private Backup createTestBackup() {
    CreateBackupRequest request =
        CreateBackupRequest.newBuilder()
            .setBackupId("test-bck")
            .setBackup(
                Backup.newBuilder()
                    .setDatabase(TEST_DB_NAME)
                    .setExpireTime(
                        Timestamp.newBuilder()
                            .setSeconds(
                                System.currentTimeMillis() * 1000L
                                    + TimeUnit.MILLISECONDS.convert(7, TimeUnit.DAYS)))
                    .build())
            .setParent(TEST_PARENT)
            .build();
    OperationFuture<Backup, CreateBackupMetadata> op =
        client.createBackupOperationCallable().futureCall(request);
    try {
      return op.get();
    } catch (ExecutionException e) {
      if (e.getCause() != null && e.getCause() instanceof RuntimeException) {
        throw (RuntimeException) e.getCause();
      }
      throw new RuntimeException(e);
    } catch (InterruptedException e) {
      throw new CancelledException(e, FakeStatusCode.of(Code.CANCELLED), false);
    }
  }

  @Test
  public void createBackup() {
    createTestDb();
    Backup bck = createTestBackup();
    assertThat(bck.getName()).isEqualTo(TEST_BCK_NAME);
  }

  @Test
  public void createBackupAlreadyExists() {
    createTestDb();
    createTestBackup();
    exception.expect(ApiExceptionMatcher.forCode(StatusCode.Code.ALREADY_EXISTS));
    createTestBackup();
  }

  @Test
  public void createBackupDatabaseDoesNotExist() {
    exception.expect(ApiExceptionMatcher.forCode(StatusCode.Code.NOT_FOUND));
    createTestBackup();
  }

  @Test
  public void deleteBackup() {
    createTestDb();
    createTestBackup();
    Backup bck = client.getBackup(TEST_BCK_NAME);
    assertThat(bck.getName()).isEqualTo(TEST_BCK_NAME);
    client.deleteBackup(TEST_BCK_NAME);
    exception.expect(ApiExceptionMatcher.forCode(StatusCode.Code.NOT_FOUND));
    client.getBackup(TEST_BCK_NAME);
  }

  @Test
  public void deleteBackupNotFound() {
    exception.expect(ApiExceptionMatcher.forCode(StatusCode.Code.NOT_FOUND));
    client.deleteBackup(TEST_BCK_NAME);
  }

  @Test
  public void getBackup() {
    createTestDb();
    createTestBackup();
    Backup bck = client.getBackup(TEST_BCK_NAME);
    assertThat(bck.getName()).isEqualTo(TEST_BCK_NAME);
  }

  @Test
  public void getBackupNotFound() {
    exception.expect(ApiExceptionMatcher.forCode(StatusCode.Code.NOT_FOUND));
    client.getBackup(TEST_BCK_NAME);
  }

  @Test
  public void listBackups() {
    createTestDb();
    createTestBackup();
    ListBackupsPagedResponse response = client.listBackups(TEST_PARENT);
    List<String> backups = new ArrayList<>();
    for (Backup bck : response.iterateAll()) {
      backups.add(bck.getName());
    }
    assertThat(backups).containsExactly(TEST_BCK_NAME);
  }

  @Test
  public void listBackupOperations() {
    createTestDb();
    createTestBackup();
    ListBackupOperationsPagedResponse response = client.listBackupOperations(TEST_BCK_NAME);
    List<Operation> operations = new ArrayList<>();
    for (Operation op : response.iterateAll()) {
      operations.add(op);
    }
    assertThat(operations).hasSize(1);
  }

  @Test
  public void updateBackup() {
    createTestDb();
    Backup backup = createTestBackup();
    Backup toBeUpdated =
        backup.toBuilder().setExpireTime(Timestamp.newBuilder().setSeconds(1000L).build()).build();
    Backup updated =
        client.updateBackup(toBeUpdated, FieldMask.newBuilder().addPaths("expire_time").build());
    assertThat(updated.getExpireTime()).isEqualTo(toBeUpdated.getExpireTime());
    assertThat(backup.getExpireTime()).isNotEqualTo(updated.getExpireTime());
  }

  @Test
  public void restoreDatabase() throws InterruptedException, ExecutionException {
    createTestDb();
    createTestBackup();
    RestoreDatabaseRequest request =
        RestoreDatabaseRequest.newBuilder()
            .setBackup(TEST_BCK_NAME)
            .setDatabaseId("restored-db")
            .setParent(TEST_PARENT)
            .build();
    OperationFuture<Database, RestoreDatabaseMetadata> op =
        client.restoreDatabaseOperationCallable().futureCall(request);
    Database restoredDb = op.get();
    assertThat(restoredDb.getName())
        .isEqualTo(String.format("%s/databases/%s", TEST_PARENT, "restored-db"));
    assertThat(restoredDb.getRestoreInfo().getBackupInfo().getBackup()).isEqualTo(TEST_BCK_NAME);
    assertThat(restoredDb.getRestoreInfo().getBackupInfo().getSourceDatabase())
        .isEqualTo(TEST_DB_NAME);
  }

  @Test
  public void restoreDatabaseNotFound() throws InterruptedException, ExecutionException {
    createTestDb();
    RestoreDatabaseRequest request =
        RestoreDatabaseRequest.newBuilder()
            .setBackup(TEST_BCK_NAME)
            .setDatabaseId("restored-db")
            .setParent(TEST_PARENT)
            .build();
    OperationFuture<Database, RestoreDatabaseMetadata> op =
        client.restoreDatabaseOperationCallable().futureCall(request);
    exception.expect(ApiExceptionMatcher.forCode(StatusCode.Code.NOT_FOUND));
    op.get();
  }

  @Test
  public void restoreDatabaseAlreadyExists() throws InterruptedException, ExecutionException {
    createTestDb();
    createTestBackup();
    RestoreDatabaseRequest request =
        RestoreDatabaseRequest.newBuilder()
            .setBackup(TEST_BCK_NAME)
            .setDatabaseId("test-db")
            .setParent(TEST_PARENT)
            .build();
    OperationFuture<Database, RestoreDatabaseMetadata> op =
        client.restoreDatabaseOperationCallable().futureCall(request);
    exception.expect(ApiExceptionMatcher.forCode(StatusCode.Code.ALREADY_EXISTS));
    op.get();
  }

  @Test
  public void testIAMPolicy() {
    TestIamPermissionsResponse response =
        client.testIamPermissions(
            TestIamPermissionsRequest.newBuilder()
                .setResource(TEST_PARENT)
                .addPermissions("spanner.databases.select")
                .addPermissions("spanner.databases.write")
                .build());
    assertThat(response.getPermissionsList())
        .containsExactly("spanner.databases.select", "spanner.databases.write");

    GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder().setResource(TEST_PARENT).build();
    Policy policy = client.getIamPolicy(request);
    assertThat(policy).isNotNull();

    Policy newPolicy =
        Policy.newBuilder()
            .addBindings(
                Binding.newBuilder().setRole("roles/admin").addMembers("user:joe@example.com"))
            .setEtag(policy.getEtag())
            .build();
    client.setIamPolicy(
        SetIamPolicyRequest.newBuilder().setResource(TEST_PARENT).setPolicy(newPolicy).build());
    policy = client.getIamPolicy(TEST_PARENT);
    assertThat(policy).isEqualTo(newPolicy);

    response =
        client.testIamPermissions(
            TestIamPermissionsRequest.newBuilder()
                .setResource(TEST_PARENT)
                .addPermissions("spanner.databases.select")
                .addPermissions("spanner.databases.update")
                .build());
    assertThat(response.getPermissionsList())
        .containsExactly("spanner.databases.select", "spanner.databases.update");
  }
}
