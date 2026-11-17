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
import com.google.cloud.bigtable.admin.v2.BigtableInstanceAdminSettings;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminSettings;
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
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/**
 * Standalone utility to clean up stale test resources older than 24 hours across shared Bigtable
 * instances and dynamically created test instances in a project.
 */
public class StaleResourceCleaner {

  private static final Logger LOGGER = Logger.getLogger(StaleResourceCleaner.class.getName());

  static final String PROJECT_PROPERTY_NAME = "bigtable.project";
  static final String INSTANCES_PROPERTY_NAME = "bigtable.instances";
  static final String INSTANCE_PROPERTY_NAME = "bigtable.instance";
  static final String ADMIN_ENDPOINT_PROPERTY_NAME = "bigtable.admin-endpoint";
  static final String CFE_ADMIN_ENDPOINT_PROPERTY_NAME = "bigtable.cfe-admin-endpoint";

  @FunctionalInterface
  interface TableAdminFactory {
    BigtableTableAdminClient createForInstance(String instanceId) throws IOException;
  }

  private final BigtableInstanceAdminClient instanceAdmin;
  private final TableAdminFactory tableAdminFactory;
  private final List<String> sharedInstanceIds;

  StaleResourceCleaner(
      BigtableInstanceAdminClient instanceAdmin,
      TableAdminFactory tableAdminFactory,
      List<String> sharedInstanceIds) {
    this.instanceAdmin = instanceAdmin;
    this.tableAdminFactory = tableAdminFactory;
    this.sharedInstanceIds = sharedInstanceIds;
  }

  public static void main(String[] args)
      throws IOException, ExecutionException, InterruptedException {
    String projectId = System.getProperty(PROJECT_PROPERTY_NAME);
    if (Strings.isNullOrEmpty(projectId)) {
      throw new IllegalArgumentException(
          "Missing required system property: " + PROJECT_PROPERTY_NAME);
    }

    List<String> sharedInstanceIds =
        parseInstanceIds(
            System.getProperty(INSTANCES_PROPERTY_NAME),
            System.getProperty(INSTANCE_PROPERTY_NAME));

    String adminEndpoint =
        resolveAdminEndpoint(
            System.getProperty(ADMIN_ENDPOINT_PROPERTY_NAME),
            System.getProperty(CFE_ADMIN_ENDPOINT_PROPERTY_NAME));

    BigtableInstanceAdminSettings.Builder instanceAdminSettings =
        BigtableInstanceAdminSettings.newBuilder().setProjectId(projectId);
    if (!Strings.isNullOrEmpty(adminEndpoint)) {
      instanceAdminSettings.stubSettings().setEndpoint(adminEndpoint);
    }

    TableAdminFactory tableAdminFactory =
        instanceId -> {
          BigtableTableAdminSettings.Builder tableAdminSettings =
              BigtableTableAdminSettings.newBuilder()
                  .setProjectId(projectId)
                  .setInstanceId(instanceId);
          if (!Strings.isNullOrEmpty(adminEndpoint)) {
            tableAdminSettings.stubSettings().setEndpoint(adminEndpoint);
          }
          return BigtableTableAdminClient.create(tableAdminSettings.build());
        };

    try (BigtableInstanceAdminClient instanceAdmin =
        BigtableInstanceAdminClient.create(instanceAdminSettings.build())) {
      StaleResourceCleaner cleaner =
          new StaleResourceCleaner(instanceAdmin, tableAdminFactory, sharedInstanceIds);
      cleaner.cleanUp();
    }
  }

  static List<String> parseInstanceIds(
      @Nullable String instancesProp, @Nullable String instanceProp) {
    String raw = !Strings.isNullOrEmpty(instancesProp) ? instancesProp : instanceProp;
    if (Strings.isNullOrEmpty(raw)) {
      throw new IllegalArgumentException(
          "Missing required system property: "
              + INSTANCES_PROPERTY_NAME
              + " or "
              + INSTANCE_PROPERTY_NAME);
    }
    List<String> instanceIds = Splitter.on(',').trimResults().omitEmptyStrings().splitToList(raw);
    if (instanceIds.isEmpty()) {
      throw new IllegalArgumentException(
          "No instance IDs found in system property: "
              + INSTANCES_PROPERTY_NAME
              + " or "
              + INSTANCE_PROPERTY_NAME);
    }
    return instanceIds;
  }

  static String resolveAdminEndpoint(
      @Nullable String adminEndpoint, @Nullable String cfeAdminEndpoint) {
    if (!Strings.isNullOrEmpty(adminEndpoint)) {
      return adminEndpoint;
    }
    if (!Strings.isNullOrEmpty(cfeAdminEndpoint)) {
      return cfeAdminEndpoint;
    }
    return "";
  }

  static boolean isStale(String resourceId, String stalePrefix) {
    return resourceId.startsWith(PrefixGenerator.PREFIX) && resourceId.compareTo(stalePrefix) < 0;
  }

  public void cleanUp() throws IOException, ExecutionException, InterruptedException {
    String stalePrefix = PrefixGenerator.newTimePrefix(Instant.now().minus(1, ChronoUnit.DAYS));
    cleanUp(stalePrefix);
  }

  void cleanUp(String stalePrefix) throws IOException, ExecutionException, InterruptedException {
    LOGGER.info(
        "Starting stale resource cleanup with stalePrefix="
            + stalePrefix
            + " for shared instances="
            + sharedInstanceIds);
    for (String instanceId : sharedInstanceIds) {
      cleanUpSharedInstance(instanceId, stalePrefix);
    }
    cleanUpStaleInstances(stalePrefix);
  }

  void cleanUpSharedInstance(String instanceId, String stalePrefix)
      throws IOException, ExecutionException, InterruptedException {
    LOGGER.info("Cleaning up shared instance: " + instanceId);
    try (BigtableTableAdminClient tableAdmin = tableAdminFactory.createForInstance(instanceId)) {
      cleanUpStaleMaterializedViews(instanceId, stalePrefix);
      cleanUpStaleLogicalViews(instanceId, stalePrefix);
      cleanUpTablesAndAuthorizedViews(tableAdmin, stalePrefix);
      cleanUpStaleAppProfiles(instanceId, stalePrefix);
      cleanUpClustersAndBackups(instanceId, tableAdmin, stalePrefix);
    }
  }

  private void cleanUpStaleMaterializedViews(String instanceId, String stalePrefix) {
    for (MaterializedView view : instanceAdmin.listMaterializedViews(instanceId)) {
      if (!isStale(view.getId(), stalePrefix)) {
        continue;
      }
      LOGGER.info(
          "Deleting stale materialized view: " + view.getId() + " in instance " + instanceId);
      unprotectAndDeleteMaterializedView(instanceId, view);
    }
  }

  private void unprotectAndDeleteMaterializedView(String instanceId, MaterializedView view) {
    try {
      if (view.isDeletionProtected()) {
        instanceAdmin.updateMaterializedView(
            UpdateMaterializedViewRequest.of(instanceId, view.getId())
                .setDeletionProtection(false));
      }
      instanceAdmin.deleteMaterializedView(instanceId, view.getId());
    } catch (NotFoundException ignored) {
      // nothing to clean up, the materialized view was already deleted
    }
  }

  private void cleanUpStaleLogicalViews(String instanceId, String stalePrefix) {
    for (LogicalView view : instanceAdmin.listLogicalViews(instanceId)) {
      if (!isStale(view.getId(), stalePrefix)) {
        continue;
      }
      LOGGER.info("Deleting stale logical view: " + view.getId() + " in instance " + instanceId);
      unprotectAndDeleteLogicalView(instanceId, view);
    }
  }

  private void unprotectAndDeleteLogicalView(String instanceId, LogicalView view) {
    try {
      if (view.isDeletionProtected()) {
        instanceAdmin.updateLogicalView(
            UpdateLogicalViewRequest.of(instanceId, view.getId()).setDeletionProtection(false));
      }
      instanceAdmin.deleteLogicalView(instanceId, view.getId());
    } catch (NotFoundException ignored) {
      // nothing to clean up, the logical view was already deleted
    }
  }

  private void cleanUpTablesAndAuthorizedViews(
      BigtableTableAdminClient tableAdmin, String stalePrefix) {
    LOGGER.info("Start cleaning up stale tables with stalePrefix=" + stalePrefix);
    for (String tableId : tableAdmin.listTables()) {
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
        } catch (NotFoundException e) {
          LOGGER.log(Level.WARNING, "Deleting stale table failed: " + tableId, e);
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
      } catch (NotFoundException ignored) {
        // nothing to clean up, the view was already deleted
      }
    }
  }

  private void cleanUpStaleAuthorizedViewsOnPersistentTable(
      BigtableTableAdminClient tableAdmin, String tableId, String stalePrefix) {
    for (String viewId : tableAdmin.listAuthorizedViews(tableId)) {
      if (!isStale(viewId, stalePrefix)) {
        continue;
      }
      LOGGER.info("Deleting stale authorized view: " + viewId + " on persistent table: " + tableId);
      try {
        tableAdmin.updateAuthorizedView(
            UpdateAuthorizedViewRequest.of(tableId, viewId).setDeletionProtection(false));
        tableAdmin.deleteAuthorizedView(tableId, viewId);
      } catch (NotFoundException ignored) {
        // nothing to clean up, the view was already deleted
      }
    }
  }

  private void cleanUpStaleAppProfiles(String instanceId, String stalePrefix) {
    for (AppProfile appProfile : instanceAdmin.listAppProfiles(instanceId)) {
      if (!isStale(appProfile.getId(), stalePrefix)) {
        continue;
      }
      try {
        instanceAdmin.deleteAppProfile(instanceId, appProfile.getId(), true);
      } catch (NotFoundException ignored) {
        // nothing to clean up, the app profile was already deleted
      }
    }
  }

  private void cleanUpClustersAndBackups(
      String instanceId, BigtableTableAdminClient tableAdmin, String stalePrefix)
      throws ExecutionException, InterruptedException {
    for (Cluster cluster : instanceAdmin.listClusters(instanceId)) {
      if (!cluster.getId().startsWith(PrefixGenerator.PREFIX)) {
        try {
          deleteStaleBackups(tableAdmin, cluster.getId(), stalePrefix);
        } catch (NotFoundException ignored) {
          // nothing to clean up, the cluster or backup was already deleted
        }
        continue;
      }
      if (!isStale(cluster.getId(), stalePrefix)) {
        continue;
      }

      try {
        deleteAllBackups(tableAdmin, cluster.getId());
      } catch (NotFoundException ignored) {
        // nothing to clean up, the backup was already deleted
      }
      try {
        instanceAdmin.deleteCluster(instanceId, cluster.getId());
      } catch (NotFoundException ignored) {
        // nothing to clean up, the cluster was already deleted
      }
    }
  }

  private void cleanUpStaleInstances(String stalePrefix)
      throws IOException, ExecutionException, InterruptedException {
    for (Instance instance : instanceAdmin.listInstances()) {
      if (!isStale(instance.getId(), stalePrefix)) {
        continue;
      }
      prepInstanceForDelete(instance.getId());
      try {
        deleteInstance(instance.getId());
      } catch (NotFoundException ignored) {
        // nothing to clean up, the instance was already deleted
      }
    }
  }

  private void prepInstanceForDelete(String instanceId) {
    for (MaterializedView materializedView : instanceAdmin.listMaterializedViews(instanceId)) {
      unprotectAndDeleteMaterializedView(instanceId, materializedView);
    }
    for (LogicalView logicalView : instanceAdmin.listLogicalViews(instanceId)) {
      unprotectAndDeleteLogicalView(instanceId, logicalView);
    }
  }

  private void deleteInstance(String instanceId)
      throws IOException, ExecutionException, InterruptedException {
    try (BigtableTableAdminClient tableAdmin = tableAdminFactory.createForInstance(instanceId)) {
      List<Cluster> clusters = instanceAdmin.listClusters(instanceId);

      boolean isFirstCluster = true;

      for (Cluster cluster : clusters) {
        deleteAllBackups(tableAdmin, cluster.getId());
        // Skip the first cluster so that it can be deleted by deleteInstance (instances can't exist
        // without clusters)
        if (!isFirstCluster) {
          try {
            instanceAdmin.deleteCluster(instanceId, cluster.getId());
          } catch (NotFoundException ignored) {
            // nothing to clean up, the cluster was already deleted
          }
        }
        isFirstCluster = false;
      }
    }

    try {
      instanceAdmin.deleteInstance(instanceId);
    } catch (NotFoundException ignored) {
      // nothing to clean up, the instance was already deleted
    }
  }

  private void deleteAllBackups(BigtableTableAdminClient tableAdmin, String clusterId)
      throws ExecutionException, InterruptedException {
    List<ApiFuture<?>> futures = new ArrayList<>();

    for (String backupId : tableAdmin.listBackups(clusterId)) {
      ApiFuture<Void> f = tableAdmin.deleteBackupAsync(clusterId, backupId);
      futures.add(f);
    }

    awaitBackupDeletions(futures);
  }

  private void deleteStaleBackups(
      BigtableTableAdminClient tableAdmin, String clusterId, String stalePrefix)
      throws ExecutionException, InterruptedException {
    List<ApiFuture<?>> futures = new ArrayList<>();

    for (String backupId : tableAdmin.listBackups(clusterId)) {
      if (isStale(backupId, stalePrefix)) {
        ApiFuture<Void> f = tableAdmin.deleteBackupAsync(clusterId, backupId);
        futures.add(f);
      }
    }

    awaitBackupDeletions(futures);
  }

  private void awaitBackupDeletions(List<ApiFuture<?>> futures)
      throws ExecutionException, InterruptedException {
    for (ApiFuture<?> future : futures) {
      try {
        future.get();
      } catch (ExecutionException e) {
        if (e.getCause() instanceof NotFoundException) {
          continue;
        }
        throw e;
      }
    }
  }
}
