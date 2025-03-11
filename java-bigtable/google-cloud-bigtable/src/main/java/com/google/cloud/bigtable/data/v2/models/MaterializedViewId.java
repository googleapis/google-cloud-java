/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigtable.data.v2.models;

import com.google.api.core.InternalApi;
import com.google.auto.value.AutoValue;
import com.google.cloud.bigtable.data.v2.internal.NameUtil;
import com.google.common.base.Preconditions;

/**
 * An implementation of a {@link TargetId} for materialized views.
 *
 * <p>See {@link com.google.cloud.bigtable.admin.v2.models.MaterializedView} for more details about
 * an materialized view.
 */
@AutoValue
public abstract class MaterializedViewId implements TargetId {
  /** Constructs a new MaterializedViewId object from the specified materializedViewId. */
  public static MaterializedViewId of(String materializedViewId) {
    Preconditions.checkNotNull(materializedViewId, "materialized view id can't be null.");
    return new AutoValue_MaterializedViewId(materializedViewId);
  }

  abstract String getMaterializedViewId();

  @Override
  @InternalApi
  public String toResourceName(String projectId, String instanceId) {
    return NameUtil.formatMaterializedViewName(projectId, instanceId, getMaterializedViewId());
  }

  @Override
  @InternalApi
  public boolean scopedForAuthorizedView() {
    return false;
  }

  @Override
  @InternalApi
  public boolean scopedForMaterializedView() {
    return true;
  }
}
