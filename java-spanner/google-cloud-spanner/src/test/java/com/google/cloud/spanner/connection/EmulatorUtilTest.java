/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner.connection;

import static com.google.cloud.spanner.connection.EmulatorUtil.maybeCreateInstanceAndDatabase;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseAdminClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.Instance;
import com.google.cloud.spanner.InstanceAdminClient;
import com.google.cloud.spanner.InstanceConfigId;
import com.google.cloud.spanner.InstanceId;
import com.google.cloud.spanner.InstanceInfo;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.SpannerOptions;
import com.google.common.collect.ImmutableList;
import com.google.spanner.admin.database.v1.CreateDatabaseMetadata;
import com.google.spanner.admin.instance.v1.CreateInstanceMetadata;
import java.util.concurrent.ExecutionException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class EmulatorUtilTest {
  @Parameter public Dialect dialect;

  @Parameters(name = "dialect = {0}")
  public static Object[] data() {
    return Dialect.values();
  }

  @Test
  public void testCreateInstanceAndDatabase_bothSucceed()
      throws InterruptedException, ExecutionException {
    Spanner spanner = mock(Spanner.class);
    SpannerOptions options = mock(SpannerOptions.class);
    when(spanner.getOptions()).thenReturn(options);
    when(options.getCredentials()).thenReturn(NoCredentials.getInstance());

    InstanceAdminClient instanceClient = mock(InstanceAdminClient.class);
    @SuppressWarnings("unchecked")
    OperationFuture<Instance, CreateInstanceMetadata> instanceOperationFuture =
        mock(OperationFuture.class);

    when(spanner.getInstanceAdminClient()).thenReturn(instanceClient);
    when(instanceClient.createInstance(any(InstanceInfo.class)))
        .thenReturn(instanceOperationFuture);
    when(instanceOperationFuture.get()).thenReturn(mock(Instance.class));

    DatabaseAdminClient databaseClient = mock(DatabaseAdminClient.class);
    @SuppressWarnings("unchecked")
    OperationFuture<Database, CreateDatabaseMetadata> databaseOperationFuture =
        mock(OperationFuture.class);

    when(spanner.getDatabaseAdminClient()).thenReturn(databaseClient);
    when(databaseClient.createDatabase(
            eq("test-instance"),
            eq(dialect.createDatabaseStatementFor("test-database")),
            eq(dialect),
            eq(ImmutableList.of())))
        .thenReturn(databaseOperationFuture);
    when(databaseOperationFuture.get()).thenReturn(mock(Database.class));

    maybeCreateInstanceAndDatabase(
        spanner, DatabaseId.of("test-project", "test-instance", "test-database"), dialect);

    // Verify that both the instance and the database was created.
    verify(instanceClient)
        .createInstance(
            InstanceInfo.newBuilder(InstanceId.of("test-project", "test-instance"))
                .setDisplayName("Automatically Generated Test Instance")
                .setInstanceConfigId(InstanceConfigId.of("test-project", "emulator-config"))
                .setNodeCount(1)
                .build());
    verify(databaseClient)
        .createDatabase(
            "test-instance",
            dialect.createDatabaseStatementFor("test-database"),
            dialect,
            ImmutableList.of());
  }

  @Test
  public void testCreateInstanceAndDatabase_bothFailWithAlreadyExists()
      throws InterruptedException, ExecutionException {
    Spanner spanner = mock(Spanner.class);
    SpannerOptions options = mock(SpannerOptions.class);
    when(spanner.getOptions()).thenReturn(options);
    when(options.getCredentials()).thenReturn(NoCredentials.getInstance());

    InstanceAdminClient instanceClient = mock(InstanceAdminClient.class);
    @SuppressWarnings("unchecked")
    OperationFuture<Instance, CreateInstanceMetadata> instanceOperationFuture =
        mock(OperationFuture.class);

    when(spanner.getInstanceAdminClient()).thenReturn(instanceClient);
    when(instanceClient.createInstance(any(InstanceInfo.class)))
        .thenReturn(instanceOperationFuture);
    when(instanceOperationFuture.get())
        .thenThrow(
            new ExecutionException(
                SpannerExceptionFactory.newSpannerException(
                    ErrorCode.ALREADY_EXISTS, "Instance already exists")));

    DatabaseAdminClient databaseClient = mock(DatabaseAdminClient.class);
    @SuppressWarnings("unchecked")
    OperationFuture<Database, CreateDatabaseMetadata> databaseOperationFuture =
        mock(OperationFuture.class);

    when(spanner.getDatabaseAdminClient()).thenReturn(databaseClient);
    when(databaseClient.createDatabase(
            eq("test-instance"),
            eq(dialect.createDatabaseStatementFor("test-database")),
            eq(dialect),
            eq(ImmutableList.of())))
        .thenReturn(databaseOperationFuture);
    when(databaseOperationFuture.get())
        .thenThrow(
            new ExecutionException(
                SpannerExceptionFactory.newSpannerException(
                    ErrorCode.ALREADY_EXISTS, "Database already exists")));

    maybeCreateInstanceAndDatabase(
        spanner, DatabaseId.of("test-project", "test-instance", "test-database"), dialect);

    // Verify that both the instance and the database was created.
    verify(instanceClient)
        .createInstance(
            InstanceInfo.newBuilder(InstanceId.of("test-project", "test-instance"))
                .setDisplayName("Automatically Generated Test Instance")
                .setInstanceConfigId(InstanceConfigId.of("test-project", "emulator-config"))
                .setNodeCount(1)
                .build());
    verify(databaseClient)
        .createDatabase(
            "test-instance",
            dialect.createDatabaseStatementFor("test-database"),
            dialect,
            ImmutableList.of());
  }

  @Test
  public void testCreateInstanceAndDatabase_propagatesOtherErrorsOnInstanceCreation()
      throws InterruptedException, ExecutionException {
    Spanner spanner = mock(Spanner.class);
    SpannerOptions options = mock(SpannerOptions.class);
    when(spanner.getOptions()).thenReturn(options);
    when(options.getCredentials()).thenReturn(NoCredentials.getInstance());

    InstanceAdminClient instanceClient = mock(InstanceAdminClient.class);
    @SuppressWarnings("unchecked")
    OperationFuture<Instance, CreateInstanceMetadata> instanceOperationFuture =
        mock(OperationFuture.class);

    when(spanner.getInstanceAdminClient()).thenReturn(instanceClient);
    when(instanceClient.createInstance(any(InstanceInfo.class)))
        .thenReturn(instanceOperationFuture);
    when(instanceOperationFuture.get())
        .thenThrow(
            new ExecutionException(
                SpannerExceptionFactory.newSpannerException(
                    ErrorCode.INVALID_ARGUMENT, "Invalid instance options")));

    SpannerException exception =
        assertThrows(
            SpannerException.class,
            () ->
                maybeCreateInstanceAndDatabase(
                    spanner,
                    DatabaseId.of("test-project", "test-instance", "test-database"),
                    dialect));
    assertEquals(ErrorCode.INVALID_ARGUMENT, exception.getErrorCode());
  }

  @Test
  public void testCreateInstanceAndDatabase_propagatesInterruptsOnInstanceCreation()
      throws InterruptedException, ExecutionException {
    Spanner spanner = mock(Spanner.class);
    SpannerOptions options = mock(SpannerOptions.class);
    when(spanner.getOptions()).thenReturn(options);
    when(options.getCredentials()).thenReturn(NoCredentials.getInstance());

    InstanceAdminClient instanceClient = mock(InstanceAdminClient.class);
    @SuppressWarnings("unchecked")
    OperationFuture<Instance, CreateInstanceMetadata> instanceOperationFuture =
        mock(OperationFuture.class);

    when(spanner.getInstanceAdminClient()).thenReturn(instanceClient);
    when(instanceClient.createInstance(any(InstanceInfo.class)))
        .thenReturn(instanceOperationFuture);
    when(instanceOperationFuture.get()).thenThrow(new InterruptedException());

    SpannerException exception =
        assertThrows(
            SpannerException.class,
            () ->
                maybeCreateInstanceAndDatabase(
                    spanner,
                    DatabaseId.of("test-project", "test-instance", "test-database"),
                    dialect));
    assertEquals(ErrorCode.CANCELLED, exception.getErrorCode());
  }

  @Test
  public void testCreateInstanceAndDatabase_propagatesOtherErrorsOnDatabaseCreation()
      throws InterruptedException, ExecutionException {
    Spanner spanner = mock(Spanner.class);
    SpannerOptions options = mock(SpannerOptions.class);
    when(spanner.getOptions()).thenReturn(options);
    when(options.getCredentials()).thenReturn(NoCredentials.getInstance());

    InstanceAdminClient instanceClient = mock(InstanceAdminClient.class);
    @SuppressWarnings("unchecked")
    OperationFuture<Instance, CreateInstanceMetadata> instanceOperationFuture =
        mock(OperationFuture.class);

    when(spanner.getInstanceAdminClient()).thenReturn(instanceClient);
    when(instanceClient.createInstance(any(InstanceInfo.class)))
        .thenReturn(instanceOperationFuture);
    when(instanceOperationFuture.get()).thenReturn(mock(Instance.class));

    DatabaseAdminClient databaseClient = mock(DatabaseAdminClient.class);
    @SuppressWarnings("unchecked")
    OperationFuture<Database, CreateDatabaseMetadata> databaseOperationFuture =
        mock(OperationFuture.class);

    when(spanner.getDatabaseAdminClient()).thenReturn(databaseClient);
    when(databaseClient.createDatabase(
            eq("test-instance"),
            eq(dialect.createDatabaseStatementFor("test-database")),
            eq(dialect),
            eq(ImmutableList.of())))
        .thenReturn(databaseOperationFuture);
    when(databaseOperationFuture.get())
        .thenThrow(
            new ExecutionException(
                SpannerExceptionFactory.newSpannerException(
                    ErrorCode.INVALID_ARGUMENT, "Invalid database options")));

    SpannerException exception =
        assertThrows(
            SpannerException.class,
            () ->
                maybeCreateInstanceAndDatabase(
                    spanner,
                    DatabaseId.of("test-project", "test-instance", "test-database"),
                    dialect));
    assertEquals(ErrorCode.INVALID_ARGUMENT, exception.getErrorCode());
  }

  @Test
  public void testCreateInstanceAndDatabase_propagatesInterruptsOnDatabaseCreation()
      throws InterruptedException, ExecutionException {
    Spanner spanner = mock(Spanner.class);
    SpannerOptions options = mock(SpannerOptions.class);
    when(spanner.getOptions()).thenReturn(options);
    when(options.getCredentials()).thenReturn(NoCredentials.getInstance());

    InstanceAdminClient instanceClient = mock(InstanceAdminClient.class);
    @SuppressWarnings("unchecked")
    OperationFuture<Instance, CreateInstanceMetadata> instanceOperationFuture =
        mock(OperationFuture.class);

    when(spanner.getInstanceAdminClient()).thenReturn(instanceClient);
    when(instanceClient.createInstance(any(InstanceInfo.class)))
        .thenReturn(instanceOperationFuture);
    when(instanceOperationFuture.get()).thenReturn(mock(Instance.class));

    DatabaseAdminClient databaseClient = mock(DatabaseAdminClient.class);
    @SuppressWarnings("unchecked")
    OperationFuture<Database, CreateDatabaseMetadata> databaseOperationFuture =
        mock(OperationFuture.class);

    when(spanner.getDatabaseAdminClient()).thenReturn(databaseClient);
    when(databaseClient.createDatabase(
            eq("test-instance"),
            eq(dialect.createDatabaseStatementFor("test-database")),
            eq(dialect),
            eq(ImmutableList.of())))
        .thenReturn(databaseOperationFuture);
    when(databaseOperationFuture.get()).thenThrow(new InterruptedException());

    SpannerException exception =
        assertThrows(
            SpannerException.class,
            () ->
                maybeCreateInstanceAndDatabase(
                    spanner,
                    DatabaseId.of("test-project", "test-instance", "test-database"),
                    dialect));
    assertEquals(ErrorCode.CANCELLED, exception.getErrorCode());
  }
}
