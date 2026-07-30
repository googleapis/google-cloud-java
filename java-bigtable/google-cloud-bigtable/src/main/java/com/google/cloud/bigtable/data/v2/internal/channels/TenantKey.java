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

package com.google.cloud.bigtable.data.v2.internal.channels;

import com.google.cloud.bigtable.data.v2.internal.api.InstanceName;
import java.util.Objects;

/**
 * Identifies a single (instanceName, appProfileId) tenant within a shared channel pool. Used as the
 * tenant dimension of a {@link RouteKey} in {@link ChannelPoolDpImpl}.
 */
public final class TenantKey {
  /** Sentinel used when no tenant is stamped (single-tenant / sessions-disabled clients). */
  public static final TenantKey UNKNOWN = new TenantKey(InstanceName.of("", ""), "");

  private final InstanceName instanceName;
  private final String appProfileId;

  public TenantKey(InstanceName instanceName, String appProfileId) {
    this.instanceName = instanceName;
    this.appProfileId = appProfileId == null ? "" : appProfileId;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof TenantKey)) return false;
    TenantKey other = (TenantKey) o;
    return Objects.equals(instanceName, other.instanceName)
        && Objects.equals(appProfileId, other.appProfileId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(instanceName, appProfileId);
  }

  @Override
  public String toString() {
    return instanceName + "/" + appProfileId;
  }
}
