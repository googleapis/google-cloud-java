/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.analytics.data.v1alpha.stub;

import com.google.analytics.data.v1alpha.RunFunnelReportRequest;
import com.google.analytics.data.v1alpha.RunFunnelReportResponse;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the AlphaAnalyticsData service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class AlphaAnalyticsDataStub implements BackgroundResource {

  public UnaryCallable<RunFunnelReportRequest, RunFunnelReportResponse> runFunnelReportCallable() {
    throw new UnsupportedOperationException("Not implemented: runFunnelReportCallable()");
  }

  @Override
  public abstract void close();
}
