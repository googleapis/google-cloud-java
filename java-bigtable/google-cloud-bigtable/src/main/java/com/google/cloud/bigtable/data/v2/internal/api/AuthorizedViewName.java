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
package com.google.cloud.bigtable.data.v2.internal.api;

import com.google.auto.value.AutoValue;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import java.util.List;

@AutoValue
public abstract class AuthorizedViewName {

  public abstract String getProjectId();

  public abstract String getInstanceId();

  public abstract String getTableId();

  public abstract String getAuthorizedViewId();

  public InstanceName getInstanceName() {
    return InstanceName.builder()
        .setProjectId(getProjectId())
        .setInstanceId(getInstanceId())
        .build();
  }

  public TableName getTableName() {
    return TableName.builder()
        .setProjectId(getProjectId())
        .setInstanceId(getInstanceId())
        .setTableId(getTableId())
        .build();
  }

  @Override
  public final String toString() {
    return String.format("%s/authorizedViews/%s", getTableName(), getAuthorizedViewId());
  }

  public static AuthorizedViewName of(
      String projectId, String instanceId, String tableId, String viewId) {
    return builder()
        .setProjectId(projectId)
        .setInstanceId(instanceId)
        .setTableId(tableId)
        .setAuthorizedViewId(viewId)
        .build();
  }

  public static Builder builder() {
    return new AutoValue_AuthorizedViewName.Builder();
  }

  public static AuthorizedViewName parse(String name) {
    List<String> parts = Splitter.on('/').splitToList(name);
    Preconditions.checkArgument(parts.size() == 8, "Invalid authorized view name: %s", name);
    Preconditions.checkArgument(
        "projects".equals(parts.get(0)),
        "Invalid authorized view name: %s, must start with projects/",
        name);
    Preconditions.checkArgument(
        !parts.get(1).isEmpty(), "Invalid authorized view name %s, must have a project id", name);
    Preconditions.checkArgument(
        "instances".equals(parts.get(2)),
        "Invalid authorized view name: %s, must start with projects/$PROJECT_ID/instances/",
        name);
    Preconditions.checkArgument(
        !parts.get(3).isEmpty(), "Invalid authorized view name %s, must have an instance id", name);
    Preconditions.checkArgument(
        "tables".equals(parts.get(4)),
        "Invalid authorized view name: %s, must start with"
            + " projects/$PROJECT_ID/instances/$INSTANCE_ID/tables",
        name);
    Preconditions.checkArgument(
        !parts.get(5).isEmpty(), "Invalid authorized view name %s, must have table id", name);
    Preconditions.checkArgument(
        "authorizedViews".equals(parts.get(6)),
        "Invalid authorized view name: %s, must start with"
            + " projects/$PROJECT_ID/instances/$INSTANCE_ID/tables/$TABLE_ID/authorizedViews",
        name);
    Preconditions.checkArgument(
        !parts.get(7).isEmpty(),
        "Invalid authorized view name %s, must have authorized view id",
        name);

    return builder()
        .setProjectId(parts.get(1))
        .setInstanceId(parts.get(3))
        .setTableId(parts.get(5))
        .setAuthorizedViewId(parts.get(7))
        .build();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setProjectId(String projectId);

    public abstract Builder setInstanceId(String instanceId);

    public abstract Builder setTableId(String tableId);

    public abstract Builder setAuthorizedViewId(String viewId);

    public abstract AuthorizedViewName build();
  }
}
