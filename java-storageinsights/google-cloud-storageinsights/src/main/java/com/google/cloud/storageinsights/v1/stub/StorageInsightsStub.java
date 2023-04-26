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

package com.google.cloud.storageinsights.v1.stub;

import static com.google.cloud.storageinsights.v1.StorageInsightsClient.ListLocationsPagedResponse;
import static com.google.cloud.storageinsights.v1.StorageInsightsClient.ListReportConfigsPagedResponse;
import static com.google.cloud.storageinsights.v1.StorageInsightsClient.ListReportDetailsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.storageinsights.v1.CreateReportConfigRequest;
import com.google.cloud.storageinsights.v1.DeleteReportConfigRequest;
import com.google.cloud.storageinsights.v1.GetReportConfigRequest;
import com.google.cloud.storageinsights.v1.GetReportDetailRequest;
import com.google.cloud.storageinsights.v1.ListReportConfigsRequest;
import com.google.cloud.storageinsights.v1.ListReportConfigsResponse;
import com.google.cloud.storageinsights.v1.ListReportDetailsRequest;
import com.google.cloud.storageinsights.v1.ListReportDetailsResponse;
import com.google.cloud.storageinsights.v1.ReportConfig;
import com.google.cloud.storageinsights.v1.ReportDetail;
import com.google.cloud.storageinsights.v1.UpdateReportConfigRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the StorageInsights service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class StorageInsightsStub implements BackgroundResource {

  public UnaryCallable<ListReportConfigsRequest, ListReportConfigsPagedResponse>
      listReportConfigsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listReportConfigsPagedCallable()");
  }

  public UnaryCallable<ListReportConfigsRequest, ListReportConfigsResponse>
      listReportConfigsCallable() {
    throw new UnsupportedOperationException("Not implemented: listReportConfigsCallable()");
  }

  public UnaryCallable<GetReportConfigRequest, ReportConfig> getReportConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: getReportConfigCallable()");
  }

  public UnaryCallable<CreateReportConfigRequest, ReportConfig> createReportConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: createReportConfigCallable()");
  }

  public UnaryCallable<UpdateReportConfigRequest, ReportConfig> updateReportConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: updateReportConfigCallable()");
  }

  public UnaryCallable<DeleteReportConfigRequest, Empty> deleteReportConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteReportConfigCallable()");
  }

  public UnaryCallable<ListReportDetailsRequest, ListReportDetailsPagedResponse>
      listReportDetailsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listReportDetailsPagedCallable()");
  }

  public UnaryCallable<ListReportDetailsRequest, ListReportDetailsResponse>
      listReportDetailsCallable() {
    throw new UnsupportedOperationException("Not implemented: listReportDetailsCallable()");
  }

  public UnaryCallable<GetReportDetailRequest, ReportDetail> getReportDetailCallable() {
    throw new UnsupportedOperationException("Not implemented: getReportDetailCallable()");
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
