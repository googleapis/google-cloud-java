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
package com.google.cloud.bigtable.admin.v2.models;

import static com.google.cloud.bigtable.admin.v2.models.GCRules.GCRULES;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.threeten.bp.Duration;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.bigtable.admin.v2.CheckConsistencyRequest;
import com.google.bigtable.admin.v2.GcRule;
import com.google.bigtable.admin.v2.GcRule.RuleCase;
import com.google.bigtable.admin.v2.GenerateConsistencyTokenResponse;
import com.google.bigtable.admin.v2.Table.ClusterState.ReplicationState;
import com.google.bigtable.admin.v2.TableName;
import com.google.cloud.bigtable.admin.v2.TableAdminClient;
import com.google.cloud.bigtable.admin.v2.models.GCRules.GCRule;
import com.google.cloud.bigtable.admin.v2.models.GCRules.IntersectionRule;
import com.google.cloud.bigtable.admin.v2.models.GCRules.UnionRule;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;

/** Bigtable Table admin response wrappers */
@BetaApi
public class TableAdminResponses {
  private TableAdminResponses() {}

  /**
   * Converts the protocol buffer table to a simpler Table model with only the required elements
   *
   * @param table - Protobuf table
   * @return Table response wrapper
   */
  @InternalApi
  public static Table convertTable(com.google.bigtable.admin.v2.Table table) {
    return new Table(table);
  }

  /**
   * Converts the protocol buffer response to a simpler ConsistencyToken which can be passed back as
   * is.
   *
   * @param tokenResponse - Protobuf ConsistencyTokenResponse
   * @return ConsistencyToken response wrapper
   */
  @InternalApi
  public static ConsistencyToken convertTokenResponse(
      GenerateConsistencyTokenResponse tokenResponse) {
    return new ConsistencyToken(tokenResponse);
  }

  /**
   * Converts the protocol buffer response to a simpler ClusterState model with only required
   * elements
   *
   * @param clusterStatesMap - Protobuf clusterStatesMap
   */
  @InternalApi
  public static Map<String, ClusterState> convertClusterStates(
      Map<String, com.google.bigtable.admin.v2.Table.ClusterState> clusterStatesMap) {
    Map<String, ClusterState> clusterStates = new HashMap<>();

    for (Entry<String, com.google.bigtable.admin.v2.Table.ClusterState> entry :
        clusterStatesMap.entrySet()) {
      clusterStates.put(entry.getKey(), new ClusterState(entry.getKey(), entry.getValue()));
    }
    return clusterStates;
  }

  /**
   * Converts the protocol buffer response to a simpler ColumnFamily model with only required
   * elements
   *
   * @param columnFamiliesMap - Protobuf columnFamiliesMap
   */
  @InternalApi
  public static Map<String, ColumnFamily> convertColumnFamilies(
      Map<String, com.google.bigtable.admin.v2.ColumnFamily> columnFamiliesMap) {
    Map<String, ColumnFamily> columnFamilies = new HashMap<>();

    for (Entry<String, com.google.bigtable.admin.v2.ColumnFamily> entry :
        columnFamiliesMap.entrySet()) {
      columnFamilies.put(entry.getKey(), new ColumnFamily(entry.getKey(), entry.getValue()));
    }
    return columnFamilies;
  }

  /** Wrapper for {@link Table} protocol buffer object */
  public static final class Table {
    private final TableName tableName;
    private final Map<String, ClusterState> clusterStates;
    private final Map<String, ColumnFamily> columnFamilies;

    private Table(com.google.bigtable.admin.v2.Table table) {
      Preconditions.checkNotNull(table);
      this.tableName = TableName.parse(table.getName());
      this.clusterStates = convertClusterStates(table.getClusterStatesMap());
      this.columnFamilies = convertColumnFamilies(table.getColumnFamiliesMap());
    }

    /**
     * Gets the unique name of the table in the format:
     * projects/{project}/instances/{instance}/tables/{tableId}
     */
    public TableName getTableName() {
      return tableName;
    }

    /**
     * Returns state of the table by clusters in the instance as map of clusterId and {@link
     * ClusterState}
     */
    public Map<String, ClusterState> getClusterStatesMap() {
      return clusterStates;
    }

    /**
     * Returns a map of columfamilies in the table keyed by columnfamily and name
     */
    public Map<String, ColumnFamily> getColumnFamiliesMap() {
      return columnFamilies;
    }

    /**
     * Returns state of the table by clusters in the instance as a Collection
     */
    public Collection<ClusterState> getClusterStates() {
      return clusterStates.values();
    }

    /**
     * Returns all columnfamilies in the table as a Collection
     */
    public Collection<ColumnFamily> getColumnFamiles() {
      return columnFamilies.values();
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("tableName", tableName)
          .add("clusterStates", getClusterStates())
          .add("columnFamiles", getColumnFamiles())
          .toString();
    }
  }

  /** Wrapper for {@link ClusterState} protocol buffer object */
  public static final class ClusterState {
    private final String id;
    private final ReplicationState replicationState;

    private ClusterState(String id, com.google.bigtable.admin.v2.Table.ClusterState clusterState) {
      this.id = id;
      replicationState = clusterState.getReplicationState();
    }

    /**
     * Gets the cluster Id
     */
    public String getId() {
      return id;
    }

    /**
     * Gets the ReplicationState of the table for this cluster
     */
    public ReplicationState getReplicationState() {
      return replicationState;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("is", id)
          .add("replicationState", replicationState)
          .toString();
    }
  }

  /** Wrapper for {@link ColumnFamily} protocol buffer object */
  public static final class ColumnFamily {
    private final String id;
    private GCRule gCRule = GCRULES.defaultRule();

    private ColumnFamily(String id, com.google.bigtable.admin.v2.ColumnFamily cf) {
      Preconditions.checkNotNull(id);
      Preconditions.checkNotNull(cf);
      this.id = id;

      if (cf.getGcRule() != null) {
        this.gCRule = convertGcRule(cf.getGcRule());
      }
    }

    /**
     * Gets the columnfamily name
     */
    public String getId() {
      return id;
    }

    /**
     * Get's the GCRule configured for the columnfamily
     */
    public GCRule getGCRule() {
      return gCRule;
    }

    /**
     * Returns true if a GCRule has been configured for the family
     */
    public boolean hasGcRule() {
      return !RuleCase.RULE_NOT_SET.equals(gCRule.toProto().getRuleCase());
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this).add("id", id).add("gCRule", gCRule).toString();
    }

    private GCRule convertGcRule(GcRule source) {
      switch (source.getRuleCase()) {
        case MAX_AGE:
          return GCRULES.maxAge(
              Duration.ofSeconds(source.getMaxAge().getSeconds(), source.getMaxAge().getNanos()));

        case MAX_NUM_VERSIONS:
          return GCRULES.maxVersions(source.getMaxNumVersions());

        case INTERSECTION:
          IntersectionRule intersection = GCRules.GCRULES.intersection();
          for (GcRule rule : source.getIntersection().getRulesList()) {
            intersection.rule(convertGcRule(rule));
          }
          return intersection;

        case UNION:
          UnionRule union = GCRules.GCRULES.union();
          for (GcRule rule : source.getUnion().getRulesList()) {
            union.rule(convertGcRule(rule));
          }
          return union;

        default:
          return GCRULES.defaultRule();
      }
    }
  }

  /**
   * Wrapper for {@link GenerateConsistencyTokenResponse#getConsistencyToken()}
   *
   * <p>Cannot be created. They are obtained by invoking {@link
   * TableAdminClient#generateConsistencyToken(String)}
   */
  public static final class ConsistencyToken {
    private final String token;

    private ConsistencyToken(GenerateConsistencyTokenResponse resp) {
      this.token = resp.getConsistencyToken();
    }

    @InternalApi
    public CheckConsistencyRequest toProto(String tableName) {
      return CheckConsistencyRequest.newBuilder()
          .setName(tableName)
          .setConsistencyToken(token)
          .build();
    }

    @VisibleForTesting
    String getToken() {
      return token;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this).add("token", token).toString();
    }
  }
}
