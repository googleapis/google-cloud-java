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

package com.google.cloud.cloudsecuritycompliance.v1.stub;

import static com.google.cloud.cloudsecuritycompliance.v1.MonitoringClient.ListControlComplianceSummariesPagedResponse;
import static com.google.cloud.cloudsecuritycompliance.v1.MonitoringClient.ListFindingSummariesPagedResponse;
import static com.google.cloud.cloudsecuritycompliance.v1.MonitoringClient.ListFrameworkComplianceSummariesPagedResponse;
import static com.google.cloud.cloudsecuritycompliance.v1.MonitoringClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.cloudsecuritycompliance.v1.AggregateFrameworkComplianceReportRequest;
import com.google.cloud.cloudsecuritycompliance.v1.AggregateFrameworkComplianceReportResponse;
import com.google.cloud.cloudsecuritycompliance.v1.FetchFrameworkComplianceReportRequest;
import com.google.cloud.cloudsecuritycompliance.v1.FrameworkComplianceReport;
import com.google.cloud.cloudsecuritycompliance.v1.ListControlComplianceSummariesRequest;
import com.google.cloud.cloudsecuritycompliance.v1.ListControlComplianceSummariesResponse;
import com.google.cloud.cloudsecuritycompliance.v1.ListFindingSummariesRequest;
import com.google.cloud.cloudsecuritycompliance.v1.ListFindingSummariesResponse;
import com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkComplianceSummariesRequest;
import com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkComplianceSummariesResponse;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Monitoring service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class MonitoringStub implements BackgroundResource {

  public UnaryCallable<
          ListFrameworkComplianceSummariesRequest, ListFrameworkComplianceSummariesPagedResponse>
      listFrameworkComplianceSummariesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listFrameworkComplianceSummariesPagedCallable()");
  }

  public UnaryCallable<
          ListFrameworkComplianceSummariesRequest, ListFrameworkComplianceSummariesResponse>
      listFrameworkComplianceSummariesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listFrameworkComplianceSummariesCallable()");
  }

  public UnaryCallable<ListFindingSummariesRequest, ListFindingSummariesPagedResponse>
      listFindingSummariesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listFindingSummariesPagedCallable()");
  }

  public UnaryCallable<ListFindingSummariesRequest, ListFindingSummariesResponse>
      listFindingSummariesCallable() {
    throw new UnsupportedOperationException("Not implemented: listFindingSummariesCallable()");
  }

  public UnaryCallable<FetchFrameworkComplianceReportRequest, FrameworkComplianceReport>
      fetchFrameworkComplianceReportCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: fetchFrameworkComplianceReportCallable()");
  }

  public UnaryCallable<
          ListControlComplianceSummariesRequest, ListControlComplianceSummariesPagedResponse>
      listControlComplianceSummariesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listControlComplianceSummariesPagedCallable()");
  }

  public UnaryCallable<
          ListControlComplianceSummariesRequest, ListControlComplianceSummariesResponse>
      listControlComplianceSummariesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listControlComplianceSummariesCallable()");
  }

  public UnaryCallable<
          AggregateFrameworkComplianceReportRequest, AggregateFrameworkComplianceReportResponse>
      aggregateFrameworkComplianceReportCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: aggregateFrameworkComplianceReportCallable()");
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
