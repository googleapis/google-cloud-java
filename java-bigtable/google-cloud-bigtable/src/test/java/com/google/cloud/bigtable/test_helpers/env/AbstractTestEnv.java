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

import com.google.cloud.bigtable.admin.v2.BigtableInstanceAdminClient;
import com.google.cloud.bigtable.admin.v2.BigtableInstanceAdminSettings;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminSettings;
import com.google.cloud.bigtable.admin.v2.models.Cluster;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Defines the interface of a target environment.
 *
 * <p>This allows for integration tests to run against either production or an emulator.
 */
public abstract class AbstractTestEnv {
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
}
