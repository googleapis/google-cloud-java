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

import com.google.api.core.InternalApi;
import com.google.cloud.bigtable.data.v2.internal.csm.MetricRegistry;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.ClientInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.Util;
import com.google.cloud.bigtable.data.v2.internal.dp.DirectAccessInvestigator;
import com.google.common.base.Preconditions;

@InternalApi
public class DirectPathCompatibleTracerImpl implements DirectPathCompatibleTracer {
  private final ClientInfo clientInfo;
  private final MetricRegistry.RecorderRegistry recorder;

  public DirectPathCompatibleTracerImpl(
      ClientInfo clientInfo, MetricRegistry.RecorderRegistry recorder) {
    this.clientInfo = Preconditions.checkNotNull(clientInfo);
    this.recorder = Preconditions.checkNotNull(recorder);
  }

  @Override
  public void recordSuccess(Util.IpProtocol ipProtocol) {
    recorder.dpCompatGuage.recordSuccess(clientInfo, ipProtocol.getValue());
  }

  @Override
  public void recordFailure(DirectAccessInvestigator.FailureReason reason) {
    recorder.dpCompatGuage.recordFailure(clientInfo, reason);
  }
}
