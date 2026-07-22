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

import io.grpc.CallOptions;

/** CallOptions keys used by {@link ChannelPoolDpImpl} for tenant-aware stream placement. */
public final class ChannelPoolOptions {
  /**
   * Identifies the tenant (instanceName + appProfileId) for a session stream request. Set by
   * TableBase before constructing SessionPoolImpl so that the channel pool can route streams to the
   * correct AFE when multiple tenants share a pool. Defaults to {@link TenantKey#UNKNOWN} for
   * single-tenant clients.
   */
  public static final CallOptions.Key<TenantKey> TENANT_KEY_OPTION =
      CallOptions.Key.createWithDefault("bigtable.tenantKey", TenantKey.UNKNOWN);

  private ChannelPoolOptions() {}
}
