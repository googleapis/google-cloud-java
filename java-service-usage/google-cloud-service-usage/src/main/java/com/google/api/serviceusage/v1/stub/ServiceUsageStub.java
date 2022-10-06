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

package com.google.api.serviceusage.v1.stub;

import static com.google.api.serviceusage.v1.ServiceUsageClient.ListServicesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.serviceusage.v1.BatchEnableServicesRequest;
import com.google.api.serviceusage.v1.BatchEnableServicesResponse;
import com.google.api.serviceusage.v1.BatchGetServicesRequest;
import com.google.api.serviceusage.v1.BatchGetServicesResponse;
import com.google.api.serviceusage.v1.DisableServiceRequest;
import com.google.api.serviceusage.v1.DisableServiceResponse;
import com.google.api.serviceusage.v1.EnableServiceRequest;
import com.google.api.serviceusage.v1.EnableServiceResponse;
import com.google.api.serviceusage.v1.GetServiceRequest;
import com.google.api.serviceusage.v1.ListServicesRequest;
import com.google.api.serviceusage.v1.ListServicesResponse;
import com.google.api.serviceusage.v1.OperationMetadata;
import com.google.api.serviceusage.v1.Service;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ServiceUsage service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ServiceUsageStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public OperationCallable<EnableServiceRequest, EnableServiceResponse, OperationMetadata>
      enableServiceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: enableServiceOperationCallable()");
  }

  public UnaryCallable<EnableServiceRequest, Operation> enableServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: enableServiceCallable()");
  }

  public OperationCallable<DisableServiceRequest, DisableServiceResponse, OperationMetadata>
      disableServiceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: disableServiceOperationCallable()");
  }

  public UnaryCallable<DisableServiceRequest, Operation> disableServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: disableServiceCallable()");
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

  public OperationCallable<
          BatchEnableServicesRequest, BatchEnableServicesResponse, OperationMetadata>
      batchEnableServicesOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchEnableServicesOperationCallable()");
  }

  public UnaryCallable<BatchEnableServicesRequest, Operation> batchEnableServicesCallable() {
    throw new UnsupportedOperationException("Not implemented: batchEnableServicesCallable()");
  }

  public UnaryCallable<BatchGetServicesRequest, BatchGetServicesResponse>
      batchGetServicesCallable() {
    throw new UnsupportedOperationException("Not implemented: batchGetServicesCallable()");
  }

  @Override
  public abstract void close();
}
