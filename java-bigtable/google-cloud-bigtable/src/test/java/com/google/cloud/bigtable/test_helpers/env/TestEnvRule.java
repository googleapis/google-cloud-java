/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.bigtable.test_helpers.env;

import static com.google.common.truth.TruthJUnit.assume;

import com.google.api.core.ApiFuture;
import com.google.api.gax.rpc.NotFoundException;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminSettings;
import com.google.cloud.bigtable.admin.v2.models.AppProfile;
import com.google.cloud.bigtable.admin.v2.models.Cluster;
import com.google.cloud.bigtable.admin.v2.models.Instance;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.threeten.bp.Instant;
import org.threeten.bp.temporal.ChronoUnit;

/**
 * JUnit rule to start and stop the target test environment.
 *
 * <p>The environment can be specified via the system property {@code bigtable.env}. The choices
 * are:
 *
 * <ul>
 *   <li>{@code emulator}: uses the cbtemulator component that can be installed by gcloud
 *   <li>{@code prod}: uses a pre-existing production table. The target table is defined using
 *       system properties listed in {@link CloudEnv} and application default credentials
 *   <li>{@code direct_path}: uses a pre-existing table in the direct path test environment. The
 *       target table is defined using system properties listed in {@link CloudEnv} and application
 *       default credentials
 * </ul>
 *
 * <p>By default, {@code emulator} will be used
 *
 * <p>Also, when the system property {@code bigtable.grpc-log-dir} is set, it will enable fine
 * grained gRPC logging to the configured path.
 */
public class TestEnvRule implements TestRule {

  private static final Logger LOGGER = Logger.getLogger(TestEnvRule.class.getName());
  private static final Boolean BIGTABLE_ENABLE_VERBOSE_GRPC_LOGS =
      Boolean.getBoolean("bigtable.enable-grpc-logs");
  private static final String BIGTABLE_GRPC_LOG_DIR = System.getProperty("bigtable.grpc-log-dir");
  private static final String BIGTABLE_EMULATOR_HOST_ENV_VAR = "BIGTABLE_EMULATOR_HOST";
  private static final String ENV_PROPERTY = "bigtable.env";
  private static final String env = System.getProperty(ENV_PROPERTY, "emulator");

  private AbstractTestEnv testEnv;

  private Handler grpcLogHandler;
  private static final Set<String> GRPC_LOGGER_NAMES =
      ImmutableSet.of("io.grpc", "io.grpc.netty.shaded");

  @Override
  public Statement apply(final Statement base, final Description description) {
    return new Statement() {
      public void evaluate() throws Throwable {
        TestEnvRule.this.before(description);

        try {
          base.evaluate();
        } finally {
          TestEnvRule.this.after();
        }
      }
    };
  }

  protected void before(Description description) throws Throwable {
    assume()
        .withMessage(
            "Integration tests can't run with the BIGTABLE_EMULATOR_HOST environment variable set"
                + ". Please use the emulator-it maven profile instead")
        .that(System.getenv())
        .doesNotContainKey(BIGTABLE_EMULATOR_HOST_ENV_VAR);

    configureLogging(description);

    switch (env) {
      case "emulator":
        testEnv = EmulatorEnv.createBundled();
        break;
      case "cloud":
        testEnv = CloudEnv.fromSystemProperties();
        break;
      default:
        throw new IllegalArgumentException(
            String.format(
                "Unknown env: %s. Please set the system property %s to either 'emulator' or 'cloud'.",
                env, ENV_PROPERTY));
    }
    testEnv.start();
  }

  private void configureLogging(Description description) throws IOException {
    if (!BIGTABLE_ENABLE_VERBOSE_GRPC_LOGS) {
      return;
    }
    Preconditions.checkState(
        !Strings.isNullOrEmpty(BIGTABLE_GRPC_LOG_DIR),
        "The property "
            + BIGTABLE_GRPC_LOG_DIR
            + " must be set when verbose grpc logs are enabled");

    Files.createDirectories(Paths.get(BIGTABLE_GRPC_LOG_DIR));

    String basename =
        Joiner.on("-").useForNull("").join(description.getClassName(), description.getMethodName());
    Path logPath = Paths.get(BIGTABLE_GRPC_LOG_DIR, basename + ".log");

    grpcLogHandler = new FileHandler(logPath.toString());
    grpcLogHandler.setFormatter(new SimpleFormatter());
    grpcLogHandler.setLevel(Level.ALL);

    for (String grpcLoggerName : GRPC_LOGGER_NAMES) {
      Logger logger = Logger.getLogger(grpcLoggerName);
      logger.setLevel(Level.ALL);
      logger.addHandler(grpcLogHandler);
    }
  }

  private void after() {
    try {
      cleanUpStale();
    } catch (Exception e) {
      LOGGER.log(Level.WARNING, "Failed to cleanup environment", e);
    }

    try {
      testEnv.stop();
    } catch (Exception e) {
      LOGGER.log(Level.WARNING, "Failed to stop the environment", e);
    }
    testEnv = null;
    teardownLogging();
  }

  private void teardownLogging() {
    if (grpcLogHandler == null) {
      return;
    }

    for (String grpcLoggerName : GRPC_LOGGER_NAMES) {
      Logger.getLogger(grpcLoggerName).removeHandler(grpcLogHandler);
    }
    grpcLogHandler.flush();
    grpcLogHandler = null;
  }

  void cleanUpStale() throws ExecutionException, InterruptedException, IOException {
    // Sortable resource prefix - time, process identifier, serial counterck
    String stalePrefix = PrefixGenerator.newTimePrefix(Instant.now().minus(1, ChronoUnit.DAYS));

    cleanupStaleTables(stalePrefix);
    if (env().isInstanceAdminSupported()) {
      cleanUpStaleAppProfile(stalePrefix);
      cleanUpStaleClusters(stalePrefix);
      cleanUpStaleInstances(stalePrefix);
    }
  }

  /**
   * Clean up AppProfile that were dynamically created in the default instance that have been
   * orphaned.
   *
   * @param stalePrefix
   */
  private void cleanupStaleTables(String stalePrefix) {
    for (String tableId : env().getTableAdminClient().listTables()) {
      if (!tableId.startsWith(PrefixGenerator.PREFIX)) {
        continue;
      }
      if (stalePrefix.compareTo(tableId) > 0) {
        try {
          env().getTableAdminClient().deleteTable(tableId);
        } catch (NotFoundException ignored) {

        }
      }
    }
  }

  /**
   * Clean up AppProfile that were dynamically created in the default instance that have been
   * orphaned.
   *
   * @param stalePrefix
   */
  private void cleanUpStaleAppProfile(String stalePrefix) {
    for (AppProfile appProfile :
        env().getInstanceAdminClient().listAppProfiles(env().getInstanceId())) {
      if (!appProfile.getId().startsWith(PrefixGenerator.PREFIX)) {
        continue;
      }
      boolean isNewerThanStale = appProfile.getId().compareTo(stalePrefix) > 0;
      if (isNewerThanStale) {
        continue;
      }
      try {
        env()
            .getInstanceAdminClient()
            .deleteAppProfile(env().getInstanceId(), appProfile.getId(), true);
      } catch (NotFoundException ignored) {

      }
    }
  }

  /**
   * Clean up clusters that were dynamically created in the default instance that have been
   * orphaned.
   *
   * @param stalePrefix
   */
  private void cleanUpStaleClusters(String stalePrefix)
      throws ExecutionException, InterruptedException {
    for (Cluster cluster : env().getInstanceAdminClient().listClusters(env().getInstanceId())) {
      if (!cluster.getId().startsWith(PrefixGenerator.PREFIX)) {
        continue;
      }
      boolean isNewerThanStale = cluster.getId().compareTo(stalePrefix) > 0;
      if (isNewerThanStale) {
        continue;
      }

      try {
        deleteBackups(env().getTableAdminClient(), cluster.getId());
      } catch (NotFoundException ignored) {
      }
      try {
        env().getInstanceAdminClient().deleteCluster(env().getInstanceId(), cluster.getId());
      } catch (NotFoundException ignored) {
      }
    }
  }

  /**
   * Clean up dynamically created (non-default) instances that have been orphaned.
   *
   * @param stalePrefix
   */
  private void cleanUpStaleInstances(String stalePrefix)
      throws IOException, ExecutionException, InterruptedException {
    for (Instance instance : env().getInstanceAdminClient().listInstances()) {
      if (!instance.getId().startsWith(PrefixGenerator.PREFIX)) {
        continue;
      }
      boolean isNewerThanStale = instance.getId().compareTo(stalePrefix) > 0;
      if (isNewerThanStale) {
        continue;
      }
      try {
        deleteInstance(instance.getId());
      } catch (NotFoundException ignored) {

      }
    }
  }

  /** Delete an instance with all of its resources. */
  private void deleteInstance(String instanceId)
      throws IOException, ExecutionException, InterruptedException {
    BigtableTableAdminSettings settings =
        env().getTableAdminSettings().toBuilder().setInstanceId(instanceId).build();

    // Delete all child resources (backups & clusters) that wont be automatically deleted
    try (BigtableTableAdminClient tableAdmin = BigtableTableAdminClient.create(settings)) {
      List<Cluster> clusters = env().getInstanceAdminClient().listClusters(instanceId);

      boolean isFirstCluster = true;

      for (Cluster cluster : clusters) {
        deleteBackups(tableAdmin, cluster.getId());
        // Skip the first cluster so that it can be delete by deleteInstance (instances can't exist
        // without clusters)
        if (!isFirstCluster) {
          try {
            env().getInstanceAdminClient().deleteCluster(instanceId, cluster.getId());
          } catch (NotFoundException ignored) {

          }
        }
        isFirstCluster = false;
      }
    }

    // Delete everything else
    try {
      env().getInstanceAdminClient().deleteInstance(instanceId);
    } catch (NotFoundException ignored) {

    }
  }

  private void deleteBackups(BigtableTableAdminClient tableAdmin, String clusterId)
      throws ExecutionException, InterruptedException {
    List<ApiFuture<?>> futures = new ArrayList<>();

    for (String backupId : tableAdmin.listBackups(clusterId)) {
      ApiFuture<Void> f = tableAdmin.deleteBackupAsync(clusterId, backupId);
      futures.add(f);
    }

    for (ApiFuture<?> future : futures) {
      try {
        future.get();
      } catch (ExecutionException e) {
        // Ignore not found
        if (e.getCause() instanceof NotFoundException) {
          continue;
        }
        throw e;
      }
    }
  }

  public AbstractTestEnv env() {
    return testEnv;
  }
}
