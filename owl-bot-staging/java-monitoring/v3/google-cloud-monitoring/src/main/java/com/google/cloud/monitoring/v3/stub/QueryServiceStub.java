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

package com.google.cloud.monitoring.v3.stub;

import static com.google.cloud.monitoring.v3.QueryServiceClient.QueryTimeSeriesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.monitoring.v3.QueryTimeSeriesRequest;
import com.google.monitoring.v3.QueryTimeSeriesResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the QueryService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class QueryServiceStub implements BackgroundResource {

  public UnaryCallable<QueryTimeSeriesRequest, QueryTimeSeriesPagedResponse>
      queryTimeSeriesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: queryTimeSeriesPagedCallable()");
  }

  public UnaryCallable<QueryTimeSeriesRequest, QueryTimeSeriesResponse> queryTimeSeriesCallable() {
    throw new UnsupportedOperationException("Not implemented: queryTimeSeriesCallable()");
  }

  @Override
  public abstract void close();
}
