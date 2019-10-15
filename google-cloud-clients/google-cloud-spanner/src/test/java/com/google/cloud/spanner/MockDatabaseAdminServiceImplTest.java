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
import com.google.api.gax.grpc.testing.MockGrpcService;
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
import com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient.ListDatabasesPagedResponse;
import com.google.cloud.spanner.admin.database.v1.DatabaseAdminSettings;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import com.google.spanner.admin.database.v1.CreateDatabaseMetadata;
import com.google.spanner.admin.database.v1.CreateDatabaseRequest;
import com.google.spanner.admin.database.v1.Database;
import com.google.spanner.admin.database.v1.GetDatabaseDdlResponse;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
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
import org.threeten.bp.Duration;

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
        new MockServiceHelper(
            "in-process-1", Arrays.<MockGrpcService>asList(mockOperations, mockDatabaseAdmin));
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
        .createDatabaseOperationSettings()
        .setPollingAlgorithm(
            OperationTimedPollAlgorithm.create(
                RetrySettings.newBuilder()
                    .setInitialRpcTimeout(Duration.ofMillis(20L))
                    .setInitialRetryDelay(Duration.ofMillis(10L))
                    .setMaxRetryDelay(Duration.ofMillis(150L))
                    .setMaxRpcTimeout(Duration.ofMillis(150L))
                    .setMaxAttempts(10)
                    .setTotalTimeout(Duration.ofMillis(5000L))
                    .setRetryDelayMultiplier(1.3)
                    .setRpcTimeoutMultiplier(1.3)
                    .build()));
    client = DatabaseAdminClient.create(settingsBuilder.build());
  }

  @After
  public void tearDown() throws Exception {
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
  }
}
