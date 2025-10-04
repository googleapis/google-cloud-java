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

package com.google.cloud.cloudsecuritycompliance.v1.stub;

import static com.google.cloud.cloudsecuritycompliance.v1.DeploymentClient.ListCloudControlDeploymentsPagedResponse;
import static com.google.cloud.cloudsecuritycompliance.v1.DeploymentClient.ListFrameworkDeploymentsPagedResponse;
import static com.google.cloud.cloudsecuritycompliance.v1.DeploymentClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.cloudsecuritycompliance.v1.CloudControlDeployment;
import com.google.cloud.cloudsecuritycompliance.v1.CreateFrameworkDeploymentRequest;
import com.google.cloud.cloudsecuritycompliance.v1.DeleteFrameworkDeploymentRequest;
import com.google.cloud.cloudsecuritycompliance.v1.FrameworkDeployment;
import com.google.cloud.cloudsecuritycompliance.v1.GetCloudControlDeploymentRequest;
import com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkDeploymentRequest;
import com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlDeploymentsRequest;
import com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlDeploymentsResponse;
import com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkDeploymentsRequest;
import com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkDeploymentsResponse;
import com.google.cloud.cloudsecuritycompliance.v1.OperationMetadata;
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
 * Base stub class for the Deployment service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class DeploymentStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public OperationCallable<CreateFrameworkDeploymentRequest, FrameworkDeployment, OperationMetadata>
      createFrameworkDeploymentOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createFrameworkDeploymentOperationCallable()");
  }

  public UnaryCallable<CreateFrameworkDeploymentRequest, Operation>
      createFrameworkDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: createFrameworkDeploymentCallable()");
  }

  public OperationCallable<DeleteFrameworkDeploymentRequest, Empty, OperationMetadata>
      deleteFrameworkDeploymentOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteFrameworkDeploymentOperationCallable()");
  }

  public UnaryCallable<DeleteFrameworkDeploymentRequest, Operation>
      deleteFrameworkDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteFrameworkDeploymentCallable()");
  }

  public UnaryCallable<GetFrameworkDeploymentRequest, FrameworkDeployment>
      getFrameworkDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: getFrameworkDeploymentCallable()");
  }

  public UnaryCallable<ListFrameworkDeploymentsRequest, ListFrameworkDeploymentsPagedResponse>
      listFrameworkDeploymentsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listFrameworkDeploymentsPagedCallable()");
  }

  public UnaryCallable<ListFrameworkDeploymentsRequest, ListFrameworkDeploymentsResponse>
      listFrameworkDeploymentsCallable() {
    throw new UnsupportedOperationException("Not implemented: listFrameworkDeploymentsCallable()");
  }

  public UnaryCallable<GetCloudControlDeploymentRequest, CloudControlDeployment>
      getCloudControlDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: getCloudControlDeploymentCallable()");
  }

  public UnaryCallable<ListCloudControlDeploymentsRequest, ListCloudControlDeploymentsPagedResponse>
      listCloudControlDeploymentsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listCloudControlDeploymentsPagedCallable()");
  }

  public UnaryCallable<ListCloudControlDeploymentsRequest, ListCloudControlDeploymentsResponse>
      listCloudControlDeploymentsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listCloudControlDeploymentsCallable()");
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
