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

import com.google.api.core.ApiFuture;
import com.google.api.gax.rpc.NotFoundException;
import com.google.cloud.bigtable.admin.v2.BigtableInstanceAdminClient;
import com.google.cloud.bigtable.admin.v2.BigtableInstanceAdminSettings;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminSettings;
import com.google.cloud.bigtable.admin.v2.models.AppProfile;
import com.google.cloud.bigtable.admin.v2.models.Cluster;
import com.google.cloud.bigtable.admin.v2.models.Instance;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import org.threeten.bp.Instant;
import org.threeten.bp.temporal.ChronoUnit;

/**
 * Defines the interface of a target environment.
 *
 * <p>This allows for integration tests to run against either production or an emulator.
 */
public abstract class AbstractTestEnv {

  /**
   * Used for temporary resources created in tests. It will be combined with timestamp and a counter
   * to create unique names which can be garbage collected.
   */
  private static final String PREFIX = "temp-";

  private static final AtomicInteger prefixCounter = new AtomicInteger(0);
  private static final int SUFFIX = new Random().nextInt(Integer.MAX_VALUE);

  private String primaryClusterId = null;

  public enum ConnectionMode {
    DEFAULT,
    REQUIRE_CFE,
    REQUIRE_DIRECT_PATH,
    REQUIRE_DIRECT_PATH_IPV4
  }

  abstract void start() throws Exception;

  abstract void stop() throws Exception;

  public abstract BigtableDataClient getDataClient();

  public abstract BigtableDataClient getDataClientForInstance(String instanceId) throws IOException;

  public abstract BigtableTableAdminClient getTableAdminClient();

  public abstract BigtableTableAdminClient getTableAdminClientForInstance(String instanceId)
      throws IOException;

  public abstract BigtableInstanceAdminClient getInstanceAdminClient();

  public abstract BigtableDataSettings getDataClientSettings();

  public abstract BigtableInstanceAdminSettings getInstanceAdminClientSettings();

  public abstract BigtableTableAdminSettings getTableAdminSettings();

  public abstract String getProjectId();

  public abstract String getInstanceId();

  /** Try to guess the primary cluster id */
  public synchronized String getPrimaryClusterId() {
    if (primaryClusterId != null) {
      return primaryClusterId;
    }

    List<Cluster> clusters = getInstanceAdminClient().listClusters(getInstanceId());
    Map<String, Cluster> byId = new HashMap<>();
    for (Cluster cluster : clusters) {
      byId.put(cluster.getId(), cluster);
    }

    Cluster cluster = null;

    cluster = byId.get(getInstanceId());
    if (cluster == null) {
      // gcloud-devel setup
      cluster = byId.get(getInstanceId() + "-cluster");
    }
    if (cluster == null) {
      cluster = byId.get(getInstanceId() + "-c0");
    }
    primaryClusterId =
        Preconditions.checkNotNull(
                cluster,
                "Failed to guess the primary cluster for projects/%s/instances/%s",
                getProjectId(),
                getInstanceId())
            .getId();
    return primaryClusterId;
  }

  public abstract String getTableId();

  public abstract String getKmsKeyName();

  public String getFamilyId() {
    return "cf";
  }

  public String newPrefix() {
    return newPrefix(Instant.now());
  }

  private static String newPrefix(Instant instant) {
    // Sortable resource prefix - time, process identifier, serial counterck
    return String.format(
        "%s-%x-%x", newTimePrefix(instant), SUFFIX, prefixCounter.getAndIncrement());
  }

  private static String newTimePrefix(Instant instant) {
    return String.format(PREFIX + "08%x", instant.getEpochSecond());
  }

  public boolean isInstanceAdminSupported() {
    return true;
  }

  public ConnectionMode getConnectionMode() {
    String modeStr =
        MoreObjects.firstNonNull(
            System.getProperty("bigtable.connection-mode"), ConnectionMode.DEFAULT.name());

    return ConnectionMode.valueOf(modeStr);
  }

  public boolean shouldWaitForCmekKeyStatusUpdate() {
    return Boolean.getBoolean("bigtable.wait-for-cmek-key-status");
  }

  public String getPrimaryZone() {
    return "us-central1-b";
  }

  public String getSecondaryZone() {
    return "us-east1-b";
  }

  /**
   * Returns test zones that can be used for intra-region testing. This might overlap with primary
   * and secondary zones
   */
  public List<String> getMultipleZonesInSameRegion() {
    return ImmutableList.of("us-east1-b", "us-east1-c");
  }

  void cleanUpStale() throws ExecutionException, InterruptedException, IOException {
    String stalePrefix = newPrefix(Instant.now().minus(1, ChronoUnit.DAYS));

    cleanupStaleTables(stalePrefix);
    if (isInstanceAdminSupported()) {
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
    for (String tableId : getTableAdminClient().listTables()) {
      if (!tableId.startsWith(PREFIX)) {
        continue;
      }
      if (stalePrefix.compareTo(tableId) > 0) {
        try {
          getTableAdminClient().deleteTable(tableId);
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
    for (AppProfile appProfile : getInstanceAdminClient().listAppProfiles(getInstanceId())) {
      if (!appProfile.getId().startsWith(PREFIX)) {
        continue;
      }
      boolean isNewerThanStale = appProfile.getId().compareTo(stalePrefix) > 0;
      if (isNewerThanStale) {
        continue;
      }
      try {
        getInstanceAdminClient().deleteAppProfile(getInstanceId(), appProfile.getId(), true);
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
    for (Cluster cluster : getInstanceAdminClient().listClusters(getInstanceId())) {
      if (!cluster.getId().startsWith(PREFIX)) {
        continue;
      }
      boolean isNewerThanStale = cluster.getId().compareTo(stalePrefix) > 0;
      if (isNewerThanStale) {
        continue;
      }

      try {
        deleteBackups(getTableAdminClient(), cluster.getId());
      } catch (NotFoundException ignored) {
      }

      try {
        getInstanceAdminClient().deleteCluster(getInstanceId(), cluster.getId());
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
    for (Instance instance : getInstanceAdminClient().listInstances()) {
      if (!instance.getId().startsWith(PREFIX)) {
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
        getTableAdminSettings().toBuilder().setInstanceId(instanceId).build();

    // Delete all child resources (backups & clusters) that wont be automatically deleted
    try (BigtableTableAdminClient tableAdmin = BigtableTableAdminClient.create(settings)) {
      List<Cluster> clusters = getInstanceAdminClient().listClusters(instanceId);

      boolean isFirstCluster = true;

      for (Cluster cluster : clusters) {
        deleteBackups(tableAdmin, cluster.getId());
        // Skip the first cluster so that it can be delete by deleteInstance (instances can't exist
        // without clusters)
        if (!isFirstCluster) {
          try {
            getInstanceAdminClient().deleteCluster(instanceId, cluster.getId());
          } catch (NotFoundException ignored) {

          }
        }
        isFirstCluster = false;
      }
    }

    // Delete everything else
    try {
      getInstanceAdminClient().deleteInstance(instanceId);
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
}
