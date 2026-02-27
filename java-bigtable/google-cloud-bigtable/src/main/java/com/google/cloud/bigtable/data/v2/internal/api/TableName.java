/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.bigtable.data.v2.internal.api;

import com.google.auto.value.AutoValue;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import java.util.List;

@AutoValue
public abstract class TableName {
  public abstract String getProjectId();

  public abstract String getInstanceId();

  public abstract String getTableId();

  public InstanceName getInstanceName() {
    return InstanceName.builder()
        .setProjectId(getProjectId())
        .setInstanceId(getInstanceId())
        .build();
  }

  @Override
  public final String toString() {
    return String.format("%s/tables/%s", getInstanceName(), getTableId());
  }

  public static Builder builder() {
    return new AutoValue_TableName.Builder();
  }

  public static TableName parse(String name) {
    List<String> parts = Splitter.on('/').splitToList(name);
    Preconditions.checkArgument(parts.size() == 6, "Invalid table name: %s", name);
    Preconditions.checkArgument(
        "projects".equals(parts.get(0)), "Invalid table name: %s, must start with projects/", name);
    Preconditions.checkArgument(
        !parts.get(1).isEmpty(), "Invalid table name %s, must have a project id", name);
    Preconditions.checkArgument(
        "instances".equals(parts.get(2)),
        "Invalid table name: %s, must start with projects/$PROJECT_ID/instances/",
        name);
    Preconditions.checkArgument(
        !parts.get(3).isEmpty(), "Invalid table name %s, must have an instance id", name);
    Preconditions.checkArgument(
        "tables".equals(parts.get(4)),
        "Invalid table name: %s, must start with"
            + " projects/$PROJECT_ID/instances/$INSTANCE_ID/tables",
        name);
    Preconditions.checkArgument(
        !parts.get(5).isEmpty(), "Invalid table name %s, must have table id", name);

    return builder()
        .setProjectId(parts.get(1))
        .setInstanceId(parts.get(3))
        .setTableId(parts.get(5))
        .build();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setProjectId(String projectId);

    public abstract Builder setInstanceId(String instanceId);

    public abstract Builder setTableId(String tableId);

    public abstract TableName build();
  }
}
