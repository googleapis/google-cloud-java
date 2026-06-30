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

package com.google.cloud.maintenance.api.v1.stub;

import static com.google.cloud.maintenance.api.v1.MaintenanceClient.ListLocationsPagedResponse;
import static com.google.cloud.maintenance.api.v1.MaintenanceClient.ListResourceMaintenancesPagedResponse;
import static com.google.cloud.maintenance.api.v1.MaintenanceClient.SummarizeMaintenancesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.maintenance.api.v1.GetResourceMaintenanceRequest;
import com.google.cloud.maintenance.api.v1.ListResourceMaintenancesRequest;
import com.google.cloud.maintenance.api.v1.ListResourceMaintenancesResponse;
import com.google.cloud.maintenance.api.v1.ResourceMaintenance;
import com.google.cloud.maintenance.api.v1.SummarizeMaintenancesRequest;
import com.google.cloud.maintenance.api.v1.SummarizeMaintenancesResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Maintenance service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class MaintenanceStub implements BackgroundResource {

  public UnaryCallable<SummarizeMaintenancesRequest, SummarizeMaintenancesPagedResponse>
      summarizeMaintenancesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: summarizeMaintenancesPagedCallable()");
  }

  public UnaryCallable<SummarizeMaintenancesRequest, SummarizeMaintenancesResponse>
      summarizeMaintenancesCallable() {
    throw new UnsupportedOperationException("Not implemented: summarizeMaintenancesCallable()");
  }

  public UnaryCallable<ListResourceMaintenancesRequest, ListResourceMaintenancesPagedResponse>
      listResourceMaintenancesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listResourceMaintenancesPagedCallable()");
  }

  public UnaryCallable<ListResourceMaintenancesRequest, ListResourceMaintenancesResponse>
      listResourceMaintenancesCallable() {
    throw new UnsupportedOperationException("Not implemented: listResourceMaintenancesCallable()");
  }

  public UnaryCallable<GetResourceMaintenanceRequest, ResourceMaintenance>
      getResourceMaintenanceCallable() {
    throw new UnsupportedOperationException("Not implemented: getResourceMaintenanceCallable()");
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
