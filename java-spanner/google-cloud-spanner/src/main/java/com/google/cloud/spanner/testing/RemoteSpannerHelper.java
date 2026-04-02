/*
 * Copyright 2017 Google LLC
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

package com.google.cloud.spanner.testing;

import com.google.api.client.util.BackOff;
import com.google.api.client.util.ExponentialBackOff;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.spanner.BatchClient;
import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.InstanceId;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.SpannerOptions;
import com.google.common.collect.Iterables;
import com.google.spanner.admin.database.v1.CreateDatabaseMetadata;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Utility that provides access to a Cloud Spanner instance to use for tests, and allows uniquely
 * named test databases to be created within that instance.
 */
public class RemoteSpannerHelper {
  private static final Logger logger = Logger.getLogger(RemoteSpannerHelper.class.getName());

  private final SpannerOptions options;
  private final Spanner client;
  private final InstanceId instanceId;
  private static final AtomicInteger dbSeq = new AtomicInteger();
  private static final int dbPrefix = new Random().nextInt(Integer.MAX_VALUE);
  private static final AtomicInteger dbRoleSeq = new AtomicInteger();
  ;
  private static int dbRolePrefix = new Random().nextInt(Integer.MAX_VALUE);
  private static final AtomicInteger backupSeq = new AtomicInteger();
  private static final int backupPrefix = new Random().nextInt(Integer.MAX_VALUE);
  private final List<DatabaseId> databaseIds = new ArrayList<>();

  protected RemoteSpannerHelper(SpannerOptions options, InstanceId instanceId, Spanner client) {
    this.options = options;
    this.instanceId = instanceId;
    this.client = client;
  }

  public SpannerOptions getOptions() {
    return options;
  }

  /**
   * Checks whether the emulator is being used.
   *
   * @deprecated use {@link EmulatorSpannerHelper#isUsingEmulator()} instead.
   * @return true if the emulator is being used. Returns false otherwise.
   */
  @Deprecated
  public boolean isEmulator() {
    return EmulatorSpannerHelper.isUsingEmulator();
  }

  public Spanner getClient() {
    return client;
  }

  public DatabaseClient getDatabaseClient(Database db) {
    return getClient().getDatabaseClient(db.getId());
  }

  public BatchClient getBatchClient(Database db) {
    return getClient().getBatchClient(db.getId());
  }

  public InstanceId getInstanceId() {
    return instanceId;
  }

  /**
   * Creates a test database defined by {@code statements}. A {@code CREATE DATABASE ...} statement
   * should not be included; an appropriate name will be chosen and the statement generated
   * accordingly.
   */
  public Database createTestDatabase(String... statements) throws SpannerException {
    return createTestDatabase(Dialect.GOOGLE_STANDARD_SQL, Arrays.asList(statements));
  }

  /**
   * Returns a database id which is guaranteed to be unique within the context of this environment.
   */
  public String getUniqueDatabaseId() {
    return String.format("testdb_%d_%04d", dbPrefix, dbSeq.incrementAndGet());
  }

  /**
   * Returns a database role name which is guaranteed to be unique within the context of this
   * environment.
   */
  public String getUniqueDatabaseRole() {
    return String.format("testdbrole_%d_%04d", dbRolePrefix, dbRoleSeq.incrementAndGet());
  }

  /**
   * Returns a backup id which is guaranteed to be unique within the context of this environment.
   */
  public String getUniqueBackupId() {
    return String.format("testbck_%06d_%04d", backupPrefix, backupSeq.incrementAndGet());
  }

  /**
   * Creates a test database defined by {@code statements} in the test instance. A {@code CREATE
   * DATABASE ...} statement should not be included; an appropriate name will be chosen and the
   * statement generated accordingly.
   */
  public Database createTestDatabase(Dialect dialect, Iterable<String> statements)
      throws SpannerException {
    String dbId = getUniqueDatabaseId();
    DatabaseId databaseId = DatabaseId.of(instanceId.getProject(), instanceId.getInstance(), dbId);
    Database databaseToCreate =
        client.getDatabaseAdminClient().newDatabaseBuilder(databaseId).setDialect(dialect).build();
    try {
      Iterable<String> ddlStatements =
          dialect == Dialect.POSTGRESQL ? Collections.emptyList() : statements;
      Database db = null;
      final int maxAttempts = 20;
      BackOff backOff =
          new ExponentialBackOff.Builder()
              .setInitialIntervalMillis(10_000)
              .setMaxIntervalMillis(60_000)
              .setMaxElapsedTimeMillis(120_000)
              .build();
      for (int attempts = 0; attempts < maxAttempts; attempts++) {
        try {
          OperationFuture<Database, CreateDatabaseMetadata> op =
              client.getDatabaseAdminClient().createDatabase(databaseToCreate, ddlStatements);
          db = op.get();
          break;
        } catch (ExecutionException executionException) {
          SpannerException spannerException =
              SpannerExceptionFactory.asSpannerException(executionException.getCause());
          if (spannerException.getErrorCode() != ErrorCode.RESOURCE_EXHAUSTED) {
            throw executionException;
          }
        } catch (SpannerException spannerException) {
          if (spannerException.getErrorCode() != ErrorCode.RESOURCE_EXHAUSTED) {
            throw spannerException;
          }
        }
        long sleep = backOff.nextBackOffMillis();
        if (sleep > 0L) {
          Thread.sleep(sleep);
        }
      }
      if (db == null) {
        throw SpannerExceptionFactory.newSpannerException(
            ErrorCode.RESOURCE_EXHAUSTED,
            String.format("Failed to create test database after %d attempts", maxAttempts));
      }
      if (dialect == Dialect.POSTGRESQL && Iterables.size(statements) > 0) {
        client
            .getDatabaseAdminClient()
            .updateDatabaseDdl(instanceId.getInstance(), dbId, statements, null)
            .get();
      }
      logger.log(Level.FINE, "Created test database {0}", db.getId());
      return db;
    } catch (Exception e) {
      throw SpannerExceptionFactory.newSpannerException(e);
    } finally {
      databaseIds.add(databaseId);
    }
  }

  public Database createTestDatabase(Iterable<String> statements) throws SpannerException {
    return createTestDatabase(Dialect.GOOGLE_STANDARD_SQL, statements);
  }

  /** Deletes all the databases created via {@code createTestDatabase}. Shuts down the client. */
  public void cleanUp() {
    // Drop all the databases we created explicitly.
    int numDropped = 0;
    for (DatabaseId databaseId : databaseIds) {
      try {
        logger.log(Level.INFO, "Dropping test database {0}", databaseId);
        client
            .getDatabaseAdminClient()
            .dropDatabase(databaseId.getInstanceId().getInstance(), databaseId.getDatabase());
        ++numDropped;
      } catch (Throwable e) {
        logger.log(Level.SEVERE, "Failed to drop test database " + databaseId, e);
      }
    }
    logger.log(Level.INFO, "Dropped {0} test database(s)", numDropped);
  }

  /**
   * Creates a {@code RemoteSpannerHelper} bound to the given instance ID. All databases created
   * using this will be created in the given instance.
   */
  public static RemoteSpannerHelper create(InstanceId instanceId) {
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId(instanceId.getProject())
            .setAutoThrottleAdministrativeRequests()
            .setTrackTransactionStarter()
            .build();
    Spanner client = options.getService();
    return new RemoteSpannerHelper(options, instanceId, client);
  }

  /**
   * Creates a {@code RemoteSpannerHelper} for the given option and bound to the given instance ID.
   * All databases created using this will be created in the given instance.
   */
  public static RemoteSpannerHelper create(SpannerOptions options, InstanceId instanceId) {
    Spanner client = options.getService();
    return new RemoteSpannerHelper(options, instanceId, client);
  }
}
