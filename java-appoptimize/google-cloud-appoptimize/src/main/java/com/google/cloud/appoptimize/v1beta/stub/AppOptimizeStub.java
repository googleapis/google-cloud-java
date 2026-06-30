/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.appoptimize.v1beta.stub;

import static com.google.cloud.appoptimize.v1beta.AppOptimizeClient.ListLocationsPagedResponse;
import static com.google.cloud.appoptimize.v1beta.AppOptimizeClient.ListReportsPagedResponse;
import static com.google.cloud.appoptimize.v1beta.AppOptimizeClient.ReadReportPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.appoptimize.v1beta.CreateReportRequest;
import com.google.cloud.appoptimize.v1beta.DeleteReportRequest;
import com.google.cloud.appoptimize.v1beta.GetReportRequest;
import com.google.cloud.appoptimize.v1beta.ListReportsRequest;
import com.google.cloud.appoptimize.v1beta.ListReportsResponse;
import com.google.cloud.appoptimize.v1beta.OperationMetadata;
import com.google.cloud.appoptimize.v1beta.ReadReportRequest;
import com.google.cloud.appoptimize.v1beta.ReadReportResponse;
import com.google.cloud.appoptimize.v1beta.Report;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the AppOptimize service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class AppOptimizeStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public OperationCallable<CreateReportRequest, Report, OperationMetadata>
      createReportOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createReportOperationCallable()");
  }

  public UnaryCallable<CreateReportRequest, Operation> createReportCallable() {
    throw new UnsupportedOperationException("Not implemented: createReportCallable()");
  }

  public UnaryCallable<GetReportRequest, Report> getReportCallable() {
    throw new UnsupportedOperationException("Not implemented: getReportCallable()");
  }

  public UnaryCallable<ListReportsRequest, ListReportsPagedResponse> listReportsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listReportsPagedCallable()");
  }

  public UnaryCallable<ListReportsRequest, ListReportsResponse> listReportsCallable() {
    throw new UnsupportedOperationException("Not implemented: listReportsCallable()");
  }

  public UnaryCallable<DeleteReportRequest, Empty> deleteReportCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteReportCallable()");
  }

  public UnaryCallable<ReadReportRequest, ReadReportPagedResponse> readReportPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: readReportPagedCallable()");
  }

  public UnaryCallable<ReadReportRequest, ReadReportResponse> readReportCallable() {
    throw new UnsupportedOperationException("Not implemented: readReportCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsPagedCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsCallable()");
  }

  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    throw new UnsupportedOperationException("Not implemented: getLocationCallable()");
  }

  @Override
  public abstract void close();
}
