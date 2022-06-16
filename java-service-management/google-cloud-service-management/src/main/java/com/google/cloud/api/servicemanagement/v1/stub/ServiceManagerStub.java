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

package com.google.cloud.api.servicemanagement.v1.stub;

import static com.google.cloud.api.servicemanagement.v1.ServiceManagerClient.ListServiceConfigsPagedResponse;
import static com.google.cloud.api.servicemanagement.v1.ServiceManagerClient.ListServiceRolloutsPagedResponse;
import static com.google.cloud.api.servicemanagement.v1.ServiceManagerClient.ListServicesPagedResponse;

import com.google.api.Service;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.servicemanagement.v1.CreateServiceConfigRequest;
import com.google.api.servicemanagement.v1.CreateServiceRequest;
import com.google.api.servicemanagement.v1.CreateServiceRolloutRequest;
import com.google.api.servicemanagement.v1.DeleteServiceRequest;
import com.google.api.servicemanagement.v1.GenerateConfigReportRequest;
import com.google.api.servicemanagement.v1.GenerateConfigReportResponse;
import com.google.api.servicemanagement.v1.GetServiceConfigRequest;
import com.google.api.servicemanagement.v1.GetServiceRequest;
import com.google.api.servicemanagement.v1.GetServiceRolloutRequest;
import com.google.api.servicemanagement.v1.ListServiceConfigsRequest;
import com.google.api.servicemanagement.v1.ListServiceConfigsResponse;
import com.google.api.servicemanagement.v1.ListServiceRolloutsRequest;
import com.google.api.servicemanagement.v1.ListServiceRolloutsResponse;
import com.google.api.servicemanagement.v1.ListServicesRequest;
import com.google.api.servicemanagement.v1.ListServicesResponse;
import com.google.api.servicemanagement.v1.ManagedService;
import com.google.api.servicemanagement.v1.OperationMetadata;
import com.google.api.servicemanagement.v1.Rollout;
import com.google.api.servicemanagement.v1.SubmitConfigSourceRequest;
import com.google.api.servicemanagement.v1.SubmitConfigSourceResponse;
import com.google.api.servicemanagement.v1.UndeleteServiceRequest;
import com.google.api.servicemanagement.v1.UndeleteServiceResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ServiceManager service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ServiceManagerStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListServicesRequest, ListServicesPagedResponse> listServicesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listServicesPagedCallable()");
  }

  public UnaryCallable<ListServicesRequest, ListServicesResponse> listServicesCallable() {
    throw new UnsupportedOperationException("Not implemented: listServicesCallable()");
  }

  public UnaryCallable<GetServiceRequest, ManagedService> getServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: getServiceCallable()");
  }

  public OperationCallable<CreateServiceRequest, ManagedService, OperationMetadata>
      createServiceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createServiceOperationCallable()");
  }

  public UnaryCallable<CreateServiceRequest, Operation> createServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: createServiceCallable()");
  }

  public OperationCallable<DeleteServiceRequest, Empty, OperationMetadata>
      deleteServiceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteServiceOperationCallable()");
  }

  public UnaryCallable<DeleteServiceRequest, Operation> deleteServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteServiceCallable()");
  }

  public OperationCallable<UndeleteServiceRequest, UndeleteServiceResponse, OperationMetadata>
      undeleteServiceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: undeleteServiceOperationCallable()");
  }

  public UnaryCallable<UndeleteServiceRequest, Operation> undeleteServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: undeleteServiceCallable()");
  }

  public UnaryCallable<ListServiceConfigsRequest, ListServiceConfigsPagedResponse>
      listServiceConfigsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listServiceConfigsPagedCallable()");
  }

  public UnaryCallable<ListServiceConfigsRequest, ListServiceConfigsResponse>
      listServiceConfigsCallable() {
    throw new UnsupportedOperationException("Not implemented: listServiceConfigsCallable()");
  }

  public UnaryCallable<GetServiceConfigRequest, Service> getServiceConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: getServiceConfigCallable()");
  }

  public UnaryCallable<CreateServiceConfigRequest, Service> createServiceConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: createServiceConfigCallable()");
  }

  public OperationCallable<SubmitConfigSourceRequest, SubmitConfigSourceResponse, OperationMetadata>
      submitConfigSourceOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: submitConfigSourceOperationCallable()");
  }

  public UnaryCallable<SubmitConfigSourceRequest, Operation> submitConfigSourceCallable() {
    throw new UnsupportedOperationException("Not implemented: submitConfigSourceCallable()");
  }

  public UnaryCallable<ListServiceRolloutsRequest, ListServiceRolloutsPagedResponse>
      listServiceRolloutsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listServiceRolloutsPagedCallable()");
  }

  public UnaryCallable<ListServiceRolloutsRequest, ListServiceRolloutsResponse>
      listServiceRolloutsCallable() {
    throw new UnsupportedOperationException("Not implemented: listServiceRolloutsCallable()");
  }

  public UnaryCallable<GetServiceRolloutRequest, Rollout> getServiceRolloutCallable() {
    throw new UnsupportedOperationException("Not implemented: getServiceRolloutCallable()");
  }

  public OperationCallable<CreateServiceRolloutRequest, Rollout, OperationMetadata>
      createServiceRolloutOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createServiceRolloutOperationCallable()");
  }

  public UnaryCallable<CreateServiceRolloutRequest, Operation> createServiceRolloutCallable() {
    throw new UnsupportedOperationException("Not implemented: createServiceRolloutCallable()");
  }

  public UnaryCallable<GenerateConfigReportRequest, GenerateConfigReportResponse>
      generateConfigReportCallable() {
    throw new UnsupportedOperationException("Not implemented: generateConfigReportCallable()");
  }

  @Override
  public abstract void close();
}
