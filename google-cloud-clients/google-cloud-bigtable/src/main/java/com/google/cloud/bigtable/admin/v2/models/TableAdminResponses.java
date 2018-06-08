/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.cloud.bigtable.admin.v2.models;

import static com.google.cloud.bigtable.admin.v2.models.GCRules.GCRULES;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.threeten.bp.Duration;
import com.google.bigtable.admin.v2.Table.ClusterState;
import com.google.bigtable.admin.v2.Table.ClusterState.ReplicationState;
import com.google.bigtable.admin.v2.Table.TimestampGranularity;
import com.google.bigtable.admin.v2.ColumnFamily;
import com.google.bigtable.admin.v2.GcRule;
import com.google.bigtable.admin.v2.GcRule.RuleCase;
import com.google.bigtable.admin.v2.GenerateConsistencyTokenResponse;
import com.google.bigtable.admin.v2.Table;
import com.google.bigtable.admin.v2.TableName;
import com.google.cloud.bigtable.admin.v2.models.GCRules.GCRule;
import com.google.cloud.bigtable.admin.v2.models.GCRules.IntersectionRule;
import com.google.cloud.bigtable.admin.v2.models.GCRules.UnionRule;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;

/**
 * Table admin response wrapper objects to limit exposure to the underlying protocol buffer objects
 */
public class TableAdminResponses {
  private TableAdminResponses() {}

  public static TableResponse convertTable(Table table) {
    return new TableResponse(table);
  }

  public static ConsistencyTokenResponse convertTokenResponse(
      GenerateConsistencyTokenResponse tokenResponse) {
    return new ConsistencyTokenResponse(tokenResponse);
  }

  /** Wrapper on {@link Table} protocol buffer object */
  public static final class TableResponse {
    private TableName tableName;
    private TimestampGranularity timestampGranularity;
    private Map<String, ClusterStateResponse> clusterStates = new HashMap<>();
    // TODO - fix spelling
    private Map<String, ColumnFamilyResponse> columnFamilies = new HashMap<>();

    private TableResponse(Table table) {
      Preconditions.checkNotNull(table);
      this.tableName = TableName.parse(table.getName());
      this.timestampGranularity = table.getGranularity();

      Map<String, ClusterState> clusterStatesMap = table.getClusterStatesMap();
      for (Entry<String, ClusterState> entry : clusterStatesMap.entrySet()) {
        clusterStates.put(
            entry.getKey(), new ClusterStateResponse(entry.getKey(), entry.getValue()));
      }

      Map<String, ColumnFamily> columnFamiliesMap = table.getColumnFamiliesMap();
      for (Entry<String, ColumnFamily> entry : columnFamiliesMap.entrySet()) {
        columnFamilies.put(
            entry.getKey(), new ColumnFamilyResponse(entry.getKey(), entry.getValue()));
      }
    }

    public TableName getTableName() {
      return tableName;
    }

    public TimestampGranularity getTimestampGranularity() {
      return timestampGranularity;
    }

    public Map<String, ClusterStateResponse> getClusterStatesMap() {
      return clusterStates;
    }

    public Map<String, ColumnFamilyResponse> getColumnFamiliesMap() {
      return columnFamilies;
    }

    public Collection<ClusterStateResponse> getClusterStates() {
      return clusterStates.values();
    }

    public Collection<ColumnFamilyResponse> getColumnFamiles() {
      return columnFamilies.values();
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("tableName", tableName)
          .add("timestampGranularity", timestampGranularity)
          .add("clusterStates", getClusterStates())
          .add("columnFamiles", getColumnFamiles())
          .toString();
    }
  }

  /** Wrapper on {@link ClusterStateResponse} protocol buffer object */
  public static final class ClusterStateResponse {
    private String id;
    private ReplicationState replicationState;

    private ClusterStateResponse(String id, ClusterState clusterState) {
      this.id = id;
      replicationState = clusterState.getReplicationState();
    }

    public String getId() {
      return id;
    }

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

  /** Wrapper on {@link ColumnFamily} protocol buffer object */
  public static final class ColumnFamilyResponse {
    private String id;
    private GCRule gCRule = GCRULES.defaulRule();

    private ColumnFamilyResponse(String id, ColumnFamily cf) {
      Preconditions.checkNotNull(id);
      Preconditions.checkNotNull(cf);
      this.id = id;

      if (cf.getGcRule() != null) {
        this.gCRule = convertGcRule(cf.getGcRule());
      }
    }

    public String getId() {
      return id;
    }

    public GcRule getGcRule() {
      // TODO: Exposing the protobuf to let users traverse the rule hierarchy as a quick hack
      // If hierarchy is actually limited in real use, it might have more options to consider
      return gCRule.toProto();
    }

    public boolean hasGcRule() {
      return !RuleCase.RULE_NOT_SET.equals(gCRule.toProto().getRuleCase());
    }

    public boolean hasUnion() {
      return gCRule.toProto().hasUnion();
    }

    public boolean hasIntersection() {
      return gCRule.toProto().hasIntersection();
    }

    public boolean hasMaxAge() {
      return gCRule.toProto().hasMaxAge();
    }

    @Override
    public String toString() {
      // TODO: fix inconsistent json format
      return MoreObjects.toStringHelper(this)
          .add("id", id)
          .add("gCRule", gCRule.toProto())
          .toString();
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
          return GCRULES.defaulRule();
      }
    }
  }

  /** Wrapper on {@link GenerateConsistencyTokenResponse#getConsistencyToken()} */
  public static final class ConsistencyTokenResponse {
    private String token;

    private ConsistencyTokenResponse(GenerateConsistencyTokenResponse resp) {
      this.token = resp.getConsistencyToken();
    }

    public String getToken() {
      return token;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this).add("token", token).toString();
    }
  }
}
