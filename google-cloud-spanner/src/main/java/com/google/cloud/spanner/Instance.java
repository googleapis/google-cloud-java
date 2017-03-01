/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

package com.google.cloud.spanner;

import com.google.cloud.Page;
import com.google.spanner.admin.database.v1.CreateDatabaseMetadata;
import com.google.spanner.admin.instance.v1.UpdateInstanceMetadata;
import java.util.Map;

/**
 * Represents a Cloud Spanner Instance. {@code Instance} adds a layer of service related
 * functionality over {@code InstanceInfo}.
 */
public class Instance extends InstanceInfo {

  /** Builder of {@code Instance}. */
  public static class Builder extends InstanceInfo.Builder {
    private final InstanceAdminClient instanceClient;
    private final DatabaseAdminClient dbClient;
    private final InstanceInfo.BuilderImpl infoBuilder;

    Builder(Instance instance) {
      this.instanceClient = instance.instanceClient;
      this.dbClient = instance.dbClient;
      this.infoBuilder = new InstanceInfo.BuilderImpl(instance);
    }

    Builder(InstanceAdminClient instanceClient, DatabaseAdminClient dbClient, InstanceId id) {
      this.instanceClient = instanceClient;
      this.dbClient = dbClient;
      this.infoBuilder = new InstanceInfo.BuilderImpl(id);
    }

    @Override
    public Builder setInstanceConfigId(InstanceConfigId instanceConfigId) {
      infoBuilder.setInstanceConfigId(instanceConfigId);
      return this;
    }

    @Override
    public Builder setDisplayName(String displayName) {
      infoBuilder.setDisplayName(displayName);
      return this;
    }

    @Override
    public Builder setNodeCount(int nodeCount) {
      infoBuilder.setNodeCount(nodeCount);
      return this;
    }

    @Override
    public Builder setState(State state) {
      infoBuilder.setState(state);
      return this;
    }

    @Override
    public Builder addLabel(String key, String value) {
      infoBuilder.addLabel(key, value);
      return this;
    }

    @Override
    public Builder putAllLabels(Map<String, String> labels) {
      infoBuilder.putAllLabels(labels);
      return this;
    }

    @Override
    public Instance build() {
      return new Instance(this);
    }
  }

  private final InstanceAdminClient instanceClient;
  private final DatabaseAdminClient dbClient;

  Instance(Builder builder) {
    super(builder.infoBuilder);
    this.instanceClient = builder.instanceClient;
    this.dbClient = builder.dbClient;
  }

  public Instance reload() {
    return instanceClient.getInstance(instanceId());
  }

  public void delete() {
    instanceClient.deleteInstance(instanceId());
  }

  public Operation<Instance, UpdateInstanceMetadata> update(
      InstanceInfo.InstanceField... fieldsToUpdate) {
    return instanceClient.updateInstance(this, fieldsToUpdate);
  }

  public Page<Database> listDatabases() {
    return dbClient.listDatabases(instanceId());
  }

  public Database getDatabase(String databaseId) {
    return dbClient.getDatabase(instanceId(), databaseId);
  }

  /**
   * Creates a new database in this instance.
   *
   * @param databaseId the id of the database which will be created. It must conform to the regular
   *     expression [a-z][a-z0-9_\-]*[a-z0-9] and be between 2 and 30 characters in length
   * @param statements DDL statements to run while creating the database, for example {@code CREATE
   *     TABLE MyTable ( ... )}. This should not include {@code CREATE DATABASE} statement.
   */
  public Operation<Database, CreateDatabaseMetadata> createDatabase(
      String databaseId, Iterable<String> statements) throws SpannerException {
    return dbClient.createDatabase(instanceId(), databaseId, statements);
  }

  private String instanceId() {
    return getId().getInstance();
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  static Instance fromProto(
      com.google.spanner.admin.instance.v1.Instance proto,
      InstanceAdminClient instanceClient,
      DatabaseAdminClient dbClient) {
    InstanceId id = InstanceId.of(proto.getName());
    Builder builder =
        new Builder(instanceClient, dbClient, id)
            .setInstanceConfigId(InstanceConfigId.of(proto.getConfig()))
            .setDisplayName(proto.getDisplayName())
            .setNodeCount(proto.getNodeCount());
    State state;
    switch (proto.getState()) {
      case STATE_UNSPECIFIED:
        state = State.UNSPECIFIED;
        break;
      case CREATING:
        state = State.CREATING;
        break;
      case READY:
        state = State.READY;
        break;
      default:
        throw new IllegalArgumentException("Unknown state:" + proto.getState());
    }
    builder.setState(state);
    builder.putAllLabels(proto.getLabelsMap());
    return builder.build();
  }
}
