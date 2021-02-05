/*
 * Copyright 2020 Google LLC
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

import static com.google.cloud.monitoring.v3.ServiceMonitoringServiceClient.ListServiceLevelObjectivesPagedResponse;
import static com.google.cloud.monitoring.v3.ServiceMonitoringServiceClient.ListServicesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.monitoring.v3.CreateServiceLevelObjectiveRequest;
import com.google.monitoring.v3.CreateServiceRequest;
import com.google.monitoring.v3.DeleteServiceLevelObjectiveRequest;
import com.google.monitoring.v3.DeleteServiceRequest;
import com.google.monitoring.v3.GetServiceLevelObjectiveRequest;
import com.google.monitoring.v3.GetServiceRequest;
import com.google.monitoring.v3.ListServiceLevelObjectivesRequest;
import com.google.monitoring.v3.ListServiceLevelObjectivesResponse;
import com.google.monitoring.v3.ListServicesRequest;
import com.google.monitoring.v3.ListServicesResponse;
import com.google.monitoring.v3.Service;
import com.google.monitoring.v3.ServiceLevelObjective;
import com.google.monitoring.v3.UpdateServiceLevelObjectiveRequest;
import com.google.monitoring.v3.UpdateServiceRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ServiceMonitoringService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ServiceMonitoringServiceStub implements BackgroundResource {

  public UnaryCallable<CreateServiceRequest, Service> createServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: createServiceCallable()");
  }

  public UnaryCallable<GetServiceRequest, Service> getServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: getServiceCallable()");
  }

  public UnaryCallable<ListServicesRequest, ListServicesPagedResponse> listServicesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listServicesPagedCallable()");
  }

  public UnaryCallable<ListServicesRequest, ListServicesResponse> listServicesCallable() {
    throw new UnsupportedOperationException("Not implemented: listServicesCallable()");
  }

  public UnaryCallable<UpdateServiceRequest, Service> updateServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: updateServiceCallable()");
  }

  public UnaryCallable<DeleteServiceRequest, Empty> deleteServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteServiceCallable()");
  }

  public UnaryCallable<CreateServiceLevelObjectiveRequest, ServiceLevelObjective>
      createServiceLevelObjectiveCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createServiceLevelObjectiveCallable()");
  }

  public UnaryCallable<GetServiceLevelObjectiveRequest, ServiceLevelObjective>
      getServiceLevelObjectiveCallable() {
    throw new UnsupportedOperationException("Not implemented: getServiceLevelObjectiveCallable()");
  }

  public UnaryCallable<ListServiceLevelObjectivesRequest, ListServiceLevelObjectivesPagedResponse>
      listServiceLevelObjectivesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listServiceLevelObjectivesPagedCallable()");
  }

  public UnaryCallable<ListServiceLevelObjectivesRequest, ListServiceLevelObjectivesResponse>
      listServiceLevelObjectivesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listServiceLevelObjectivesCallable()");
  }

  public UnaryCallable<UpdateServiceLevelObjectiveRequest, ServiceLevelObjective>
      updateServiceLevelObjectiveCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateServiceLevelObjectiveCallable()");
  }

  public UnaryCallable<DeleteServiceLevelObjectiveRequest, Empty>
      deleteServiceLevelObjectiveCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteServiceLevelObjectiveCallable()");
  }

  @Override
  public abstract void close();
}
