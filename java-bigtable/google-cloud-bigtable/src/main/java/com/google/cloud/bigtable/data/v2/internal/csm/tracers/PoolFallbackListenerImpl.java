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
package com.google.cloud.bigtable.data.v2.internal.csm.tracers;

import com.google.cloud.bigtable.data.v2.internal.csm.MetricRegistry.RecorderRegistry;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.ClientInfo;

public class PoolFallbackListenerImpl implements PoolFallbackListener {
  private final RecorderRegistry registry;
  private final ClientInfo clientInfo;

  public PoolFallbackListenerImpl(RecorderRegistry registry, ClientInfo clientInfo) {
    this.registry = registry;
    this.clientInfo = clientInfo;
  }

  @Override
  public void onFallback(String from, String to, ChannelFallbackReason reason) {
    registry.channelFallbackCount.record(clientInfo, 1, from, to, reason);
  }
}
