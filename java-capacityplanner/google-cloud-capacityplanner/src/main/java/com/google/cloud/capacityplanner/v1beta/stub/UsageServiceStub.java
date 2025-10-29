/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.capacityplanner.v1beta.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.capacityplanner.v1beta.ExportForecastsRequest;
import com.google.cloud.capacityplanner.v1beta.ExportForecastsResponse;
import com.google.cloud.capacityplanner.v1beta.ExportReservationsUsageRequest;
import com.google.cloud.capacityplanner.v1beta.ExportReservationsUsageResponse;
import com.google.cloud.capacityplanner.v1beta.ExportUsageHistoriesRequest;
import com.google.cloud.capacityplanner.v1beta.ExportUsageHistoriesResponse;
import com.google.cloud.capacityplanner.v1beta.OperationMetadata;
import com.google.cloud.capacityplanner.v1beta.QueryForecastsRequest;
import com.google.cloud.capacityplanner.v1beta.QueryForecastsResponse;
import com.google.cloud.capacityplanner.v1beta.QueryReservationsRequest;
import com.google.cloud.capacityplanner.v1beta.QueryReservationsResponse;
import com.google.cloud.capacityplanner.v1beta.QueryUsageHistoriesRequest;
import com.google.cloud.capacityplanner.v1beta.QueryUsageHistoriesResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the UsageService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class UsageServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<QueryUsageHistoriesRequest, QueryUsageHistoriesResponse>
      queryUsageHistoriesCallable() {
    throw new UnsupportedOperationException("Not implemented: queryUsageHistoriesCallable()");
  }

  public UnaryCallable<QueryForecastsRequest, QueryForecastsResponse> queryForecastsCallable() {
    throw new UnsupportedOperationException("Not implemented: queryForecastsCallable()");
  }

  public UnaryCallable<QueryReservationsRequest, QueryReservationsResponse>
      queryReservationsCallable() {
    throw new UnsupportedOperationException("Not implemented: queryReservationsCallable()");
  }

  public OperationCallable<
          ExportUsageHistoriesRequest, ExportUsageHistoriesResponse, OperationMetadata>
      exportUsageHistoriesOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: exportUsageHistoriesOperationCallable()");
  }

  public UnaryCallable<ExportUsageHistoriesRequest, Operation> exportUsageHistoriesCallable() {
    throw new UnsupportedOperationException("Not implemented: exportUsageHistoriesCallable()");
  }

  public OperationCallable<ExportForecastsRequest, ExportForecastsResponse, OperationMetadata>
      exportForecastsOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: exportForecastsOperationCallable()");
  }

  public UnaryCallable<ExportForecastsRequest, Operation> exportForecastsCallable() {
    throw new UnsupportedOperationException("Not implemented: exportForecastsCallable()");
  }

  public OperationCallable<
          ExportReservationsUsageRequest, ExportReservationsUsageResponse, OperationMetadata>
      exportReservationsUsageOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: exportReservationsUsageOperationCallable()");
  }

  public UnaryCallable<ExportReservationsUsageRequest, Operation>
      exportReservationsUsageCallable() {
    throw new UnsupportedOperationException("Not implemented: exportReservationsUsageCallable()");
  }

  @Override
  public abstract void close();
}
