/*
 * Copyright 2026 Google LLC
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
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
import com.google.cloud.bigtable.admin.v2.models.AppProfile;
import com.google.cloud.bigtable.admin.v2.models.Cluster;
import com.google.cloud.bigtable.admin.v2.models.Instance;
import com.google.cloud.bigtable.admin.v2.models.LogicalView;
import com.google.cloud.bigtable.admin.v2.models.MaterializedView;
import com.google.cloud.bigtable.admin.v2.models.Table;
import com.google.cloud.bigtable.admin.v2.models.UpdateAuthorizedViewRequest;
import com.google.cloud.bigtable.admin.v2.models.UpdateLogicalViewRequest;
import com.google.cloud.bigtable.admin.v2.models.UpdateMaterializedViewRequest;
import com.google.cloud.bigtable.admin.v2.models.UpdateTableRequest;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Standalone utility to clean up stale test resources older than 24 hours in the configured {@link
 * CloudEnv} shared Bigtable instance as well as dynamically created test instances in the project.
 */
public class StaleResourceCleaner {

  private static final Logger LOGGER = Logger.getLogger(StaleResourceCleaner.class.getName());

  private final AbstractTestEnv testEnv;
  private final List<Throwable> errors = new ArrayList<>();

  StaleResourceCleaner(AbstractTestEnv testEnv) {
    this.testEnv = testEnv;
  }

  public static void main(String[] args) throws Exception {
    CloudEnv cloudEnv = CloudEnv.fromSystemProperties();
    cloudEnv.startAdminClients();
    try {
      new StaleResourceCleaner(cloudEnv).cleanUp();
    } finally {
      cloudEnv.stop();
    }
  }

  static boolean isStale(String resourceId, String stalePrefix) {
    return resourceId.startsWith(PrefixGenerator.PREFIX) && resourceId.compareTo(stalePrefix) < 0;
  }

  public void cleanUp() {
    String stalePrefix = PrefixGenerator.newTimePrefix(Instant.now().minus(1, ChronoUnit.DAYS));
    cleanUp(stalePrefix);
  }

  void cleanUp(String stalePrefix) {
    errors.clear();
    String instanceId = testEnv.getInstanceId();
    LOGGER.info(
        "Starting stale resource cleanup with stalePrefix="
            + stalePrefix
            + " for shared instance="
            + instanceId);
    cleanUpSharedInstance(instanceId, stalePrefix);
    cleanUpStaleInstances(stalePrefix);

    if (!errors.isEmpty()) {
      RuntimeException exception =
          new RuntimeException(
              "Stale resource cleanup encountered " + errors.size() + " error(s)", errors.get(0));
      for (int i = 1; i < errors.size(); i++) {
        exception.addSuppressed(errors.get(i));
      }
      throw exception;
    }
  }

  void cleanUpSharedInstance(String instanceId, String stalePrefix) {
    LOGGER.info("Cleaning up shared instance: " + instanceId);
    BigtableTableAdminClient tableAdmin = testEnv.getTableAdminClient();
    cleanUpStaleMaterializedViews(instanceId, stalePrefix);
    cleanUpStaleLogicalViews(instanceId, stalePrefix);
    cleanUpTablesAndAuthorizedViews(tableAdmin, stalePrefix);
    cleanUpStaleAppProfiles(instanceId, stalePrefix);
    cleanUpClustersAndBackups(instanceId, tableAdmin, stalePrefix);
  }

  private void cleanUpStaleMaterializedViews(String instanceId, String stalePrefix) {
    BigtableInstanceAdminClient instanceAdmin = testEnv.getInstanceAdminClient();
    List<MaterializedView> views;
    try {
      views = instanceAdmin.listMaterializedViews(instanceId);
    } catch (Exception e) {
      recordError("Failed to list materialized views in instance: " + instanceId, e);
      return;
    }
    for (MaterializedView view : views) {
      if (!isStale(view.getId(), stalePrefix)) {
        continue;
      }
      LOGGER.info(
          "Deleting stale materialized view: " + view.getId() + " in instance " + instanceId);
      unprotectAndDeleteMaterializedView(instanceId, view);
    }
  }

  private void unprotectAndDeleteMaterializedView(String instanceId, MaterializedView view) {
    BigtableInstanceAdminClient instanceAdmin = testEnv.getInstanceAdminClient();
    try {
      if (view.isDeletionProtected()) {
        instanceAdmin.updateMaterializedView(
            UpdateMaterializedViewRequest.of(instanceId, view.getId())
                .setDeletionProtection(false));
      }
      instanceAdmin.deleteMaterializedView(instanceId, view.getId());
    } catch (Exception e) {
      recordError(
          "Failed to delete stale materialized view: "
              + view.getId()
              + " in instance "
              + instanceId,
          e);
    }
  }

  private void cleanUpStaleLogicalViews(String instanceId, String stalePrefix) {
    BigtableInstanceAdminClient instanceAdmin = testEnv.getInstanceAdminClient();
    List<LogicalView> views;
    try {
      views = instanceAdmin.listLogicalViews(instanceId);
    } catch (Exception e) {
      recordError("Failed to list logical views in instance: " + instanceId, e);
      return;
    }
    for (LogicalView view : views) {
      if (!isStale(view.getId(), stalePrefix)) {
        continue;
      }
      LOGGER.info("Deleting stale logical view: " + view.getId() + " in instance " + instanceId);
      unprotectAndDeleteLogicalView(instanceId, view);
    }
  }

  private void unprotectAndDeleteLogicalView(String instanceId, LogicalView view) {
    BigtableInstanceAdminClient instanceAdmin = testEnv.getInstanceAdminClient();
    try {
      if (view.isDeletionProtected()) {
        instanceAdmin.updateLogicalView(
            UpdateLogicalViewRequest.of(instanceId, view.getId()).setDeletionProtection(false));
      }
      instanceAdmin.deleteLogicalView(instanceId, view.getId());
    } catch (Exception e) {
      recordError(
          "Failed to delete stale logical view: " + view.getId() + " in instance " + instanceId, e);
    }
  }

  private void cleanUpTablesAndAuthorizedViews(
      BigtableTableAdminClient tableAdmin, String stalePrefix) {
    LOGGER.info("Start cleaning up stale tables with stalePrefix=" + stalePrefix);
    List<String> tableIds;
    try {
      tableIds = tableAdmin.listTables();
    } catch (Exception e) {
      recordError("Failed to list tables", e);
      return;
    }
    for (String tableId : tableIds) {
      if (!tableId.startsWith(PrefixGenerator.PREFIX)) {
        cleanUpStaleAuthorizedViewsOnPersistentTable(tableAdmin, tableId, stalePrefix);
        continue;
      }
      if (isStale(tableId, stalePrefix)) {
        LOGGER.info("Preparing stale table for delete: " + tableId);
        try {
          prepTableForDelete(tableAdmin, tableId);
          LOGGER.info("Deleting stale table: " + tableId);
          tableAdmin.deleteTable(tableId);
        } catch (Exception e) {
          recordError("Deleting stale table failed: " + tableId, e);
        }
      }
    }
  }

  private void prepTableForDelete(BigtableTableAdminClient tableAdmin, String tableId) {
    Table table = tableAdmin.getTable(tableId);
    if (table.isDeletionProtected() || table.getChangeStreamRetention() != null) {
      tableAdmin.updateTable(
          UpdateTableRequest.of(tableId)
              .setDeletionProtection(false)
              .disableChangeStreamRetention());
    }

    for (String viewId : tableAdmin.listAuthorizedViews(tableId)) {
      try {
        tableAdmin.updateAuthorizedView(
            UpdateAuthorizedViewRequest.of(tableId, viewId).setDeletionProtection(false));
      } catch (Exception e) {
        recordError(
            "Failed to unprotect authorized view: " + viewId + " on stale table: " + tableId, e);
      }
    }
  }

  private void cleanUpStaleAuthorizedViewsOnPersistentTable(
      BigtableTableAdminClient tableAdmin, String tableId, String stalePrefix) {
    List<String> viewIds;
    try {
      viewIds = tableAdmin.listAuthorizedViews(tableId);
    } catch (Exception e) {
      recordError("Failed to list authorized views on persistent table: " + tableId, e);
      return;
    }
    for (String viewId : viewIds) {
      if (!isStale(viewId, stalePrefix)) {
        continue;
      }
      LOGGER.info("Deleting stale authorized view: " + viewId + " on persistent table: " + tableId);
      try {
        tableAdmin.updateAuthorizedView(
            UpdateAuthorizedViewRequest.of(tableId, viewId).setDeletionProtection(false));
        tableAdmin.deleteAuthorizedView(tableId, viewId);
      } catch (Exception e) {
        recordError(
            "Failed to delete stale authorized view: "
                + viewId
                + " on persistent table: "
                + tableId,
            e);
      }
    }
  }

  private void cleanUpStaleAppProfiles(String instanceId, String stalePrefix) {
    BigtableInstanceAdminClient instanceAdmin = testEnv.getInstanceAdminClient();
    List<AppProfile> appProfiles;
    try {
      appProfiles = instanceAdmin.listAppProfiles(instanceId);
    } catch (Exception e) {
      recordError("Failed to list app profiles in instance: " + instanceId, e);
      return;
    }
    for (AppProfile appProfile : appProfiles) {
      if (!isStale(appProfile.getId(), stalePrefix)) {
        continue;
      }
      try {
        instanceAdmin.deleteAppProfile(instanceId, appProfile.getId(), true);
      } catch (Exception e) {
        recordError(
            "Failed to delete stale app profile: "
                + appProfile.getId()
                + " in instance "
                + instanceId,
            e);
      }
    }
  }

  private void cleanUpClustersAndBackups(
      String instanceId, BigtableTableAdminClient tableAdmin, String stalePrefix) {
    BigtableInstanceAdminClient instanceAdmin = testEnv.getInstanceAdminClient();
    List<Cluster> clusters;
    try {
      clusters = instanceAdmin.listClusters(instanceId);
    } catch (Exception e) {
      recordError("Failed to list clusters in instance: " + instanceId, e);
      return;
    }
    for (Cluster cluster : clusters) {
      if (!cluster.getId().startsWith(PrefixGenerator.PREFIX)) {
        try {
          deleteStaleBackups(tableAdmin, cluster.getId(), stalePrefix);
        } catch (Exception e) {
          recordError("Failed to delete stale backups in cluster: " + cluster.getId(), e);
        }
        continue;
      }
      if (!isStale(cluster.getId(), stalePrefix)) {
        continue;
      }

      try {
        deleteAllBackups(tableAdmin, cluster.getId());
      } catch (Exception e) {
        recordError("Failed to delete backups in stale cluster: " + cluster.getId(), e);
      }
      try {
        instanceAdmin.deleteCluster(instanceId, cluster.getId());
      } catch (Exception e) {
        recordError(
            "Failed to delete stale cluster: " + cluster.getId() + " in instance " + instanceId, e);
      }
    }
  }

  private void cleanUpStaleInstances(String stalePrefix) {
    BigtableInstanceAdminClient instanceAdmin = testEnv.getInstanceAdminClient();
    List<Instance> instances;
    try {
      instances = instanceAdmin.listInstances();
    } catch (Exception e) {
      recordError("Failed to list instances", e);
      return;
    }
    for (Instance instance : instances) {
      if (!isStale(instance.getId(), stalePrefix)) {
        continue;
      }
      try {
        prepInstanceForDelete(instance.getId());
        deleteInstance(instance.getId());
      } catch (Exception e) {
        recordError("Failed to delete stale instance: " + instance.getId(), e);
      }
    }
  }

  private void prepInstanceForDelete(String instanceId) {
    BigtableInstanceAdminClient instanceAdmin = testEnv.getInstanceAdminClient();
    try {
      for (MaterializedView materializedView : instanceAdmin.listMaterializedViews(instanceId)) {
        unprotectAndDeleteMaterializedView(instanceId, materializedView);
      }
    } catch (NotFoundException e) {
      throw e;
    } catch (Exception e) {
      recordError("Failed to list materialized views in stale instance: " + instanceId, e);
    }
    try {
      for (LogicalView logicalView : instanceAdmin.listLogicalViews(instanceId)) {
        unprotectAndDeleteLogicalView(instanceId, logicalView);
      }
    } catch (NotFoundException e) {
      throw e;
    } catch (Exception e) {
      recordError("Failed to list logical views in stale instance: " + instanceId, e);
    }
  }

  private void deleteInstance(String instanceId) {
    BigtableInstanceAdminClient instanceAdmin = testEnv.getInstanceAdminClient();
    try (BigtableTableAdminClient tableAdmin = testEnv.getTableAdminClientForInstance(instanceId)) {
      List<Cluster> clusters = instanceAdmin.listClusters(instanceId);

      for (Cluster cluster : clusters) {
        try {
          deleteAllBackups(tableAdmin, cluster.getId());
        } catch (Exception e) {
          recordError(
              "Failed to delete backups in cluster "
                  + cluster.getId()
                  + " of stale instance "
                  + instanceId,
              e);
        }
      }
    } catch (Exception e) {
      recordError("Failed to clean up backups in stale instance: " + instanceId, e);
    }

    try {
      instanceAdmin.deleteInstance(instanceId);
    } catch (Exception e) {
      recordError("Failed to delete stale instance: " + instanceId, e);
    }
  }

  private void deleteAllBackups(BigtableTableAdminClient tableAdmin, String clusterId) {
    List<ApiFuture<?>> futures = new ArrayList<>();

    for (String backupId : tableAdmin.listBackups(clusterId)) {
      ApiFuture<Void> f = tableAdmin.deleteBackupAsync(clusterId, backupId);
      futures.add(f);
    }

    awaitBackupDeletions(futures, clusterId);
  }

  private void deleteStaleBackups(
      BigtableTableAdminClient tableAdmin, String clusterId, String stalePrefix) {
    List<ApiFuture<?>> futures = new ArrayList<>();

    for (String backupId : tableAdmin.listBackups(clusterId)) {
      if (isStale(backupId, stalePrefix)) {
        ApiFuture<Void> f = tableAdmin.deleteBackupAsync(clusterId, backupId);
        futures.add(f);
      }
    }

    awaitBackupDeletions(futures, clusterId);
  }

  private void awaitBackupDeletions(List<ApiFuture<?>> futures, String clusterId) {
    for (ApiFuture<?> future : futures) {
      try {
        future.get();
      } catch (ExecutionException e) {
        if (e.getCause() instanceof NotFoundException) {
          continue;
        }
        recordError("Failed to delete backup in cluster: " + clusterId, e);
      } catch (Exception e) {
        recordError("Failed to delete backup in cluster: " + clusterId, e);
      }
    }
  }

  private void recordError(String message, Exception e) {
    if (e instanceof NotFoundException) {
      return;
    }
    if (e instanceof InterruptedException) {
      Thread.currentThread().interrupt();
    }
    LOGGER.log(Level.WARNING, message, e);
    errors.add(e);
  }
}
