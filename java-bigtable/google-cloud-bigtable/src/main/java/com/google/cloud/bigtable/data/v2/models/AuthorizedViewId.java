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
 * An implementation of a {@link TargetId} for authorized views.
 *
 * <p>See {@link com.google.cloud.bigtable.admin.v2.models.AuthorizedView} for more details about an
 * authorized view.
 */
@AutoValue
public abstract class AuthorizedViewId implements TargetId {
  /** Constructs a new AuthorizedViewId object from the specified tableId and authorizedViewId. */
  public static AuthorizedViewId of(String tableId, String authorizedViewId) {
    Preconditions.checkNotNull(tableId, "table id can't be null.");
    Preconditions.checkNotNull(authorizedViewId, "authorized view id can't be null.");
    return new AutoValue_AuthorizedViewId(tableId, authorizedViewId);
  }

  abstract String getTableId();

  abstract String getAuthorizedViewId();

  @Override
  @InternalApi
  public String toResourceName(String projectId, String instanceId) {
    return NameUtil.formatAuthorizedViewName(
        projectId, instanceId, getTableId(), getAuthorizedViewId());
  }

  @Override
  @InternalApi
  public boolean scopedForAuthorizedView() {
    return true;
  }
}
