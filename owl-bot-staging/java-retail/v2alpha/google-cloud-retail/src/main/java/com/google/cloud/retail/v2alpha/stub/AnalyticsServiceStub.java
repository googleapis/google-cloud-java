/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.retail.v2alpha.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.retail.v2alpha.ExportAnalyticsMetricsRequest;
import com.google.cloud.retail.v2alpha.ExportAnalyticsMetricsResponse;
import com.google.cloud.retail.v2alpha.ExportMetadata;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the AnalyticsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class AnalyticsServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public OperationCallable<
          ExportAnalyticsMetricsRequest, ExportAnalyticsMetricsResponse, ExportMetadata>
      exportAnalyticsMetricsOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: exportAnalyticsMetricsOperationCallable()");
  }

  public UnaryCallable<ExportAnalyticsMetricsRequest, Operation> exportAnalyticsMetricsCallable() {
    throw new UnsupportedOperationException("Not implemented: exportAnalyticsMetricsCallable()");
  }

  @Override
  public abstract void close();
}
