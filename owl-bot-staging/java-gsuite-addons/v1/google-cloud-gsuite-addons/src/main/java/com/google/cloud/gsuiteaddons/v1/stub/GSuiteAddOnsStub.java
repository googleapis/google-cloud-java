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

package com.google.cloud.gsuiteaddons.v1.stub;

import static com.google.cloud.gsuiteaddons.v1.GSuiteAddOnsClient.ListDeploymentsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.gsuiteaddons.v1.Authorization;
import com.google.cloud.gsuiteaddons.v1.CreateDeploymentRequest;
import com.google.cloud.gsuiteaddons.v1.DeleteDeploymentRequest;
import com.google.cloud.gsuiteaddons.v1.Deployment;
import com.google.cloud.gsuiteaddons.v1.GetAuthorizationRequest;
import com.google.cloud.gsuiteaddons.v1.GetDeploymentRequest;
import com.google.cloud.gsuiteaddons.v1.GetInstallStatusRequest;
import com.google.cloud.gsuiteaddons.v1.InstallDeploymentRequest;
import com.google.cloud.gsuiteaddons.v1.InstallStatus;
import com.google.cloud.gsuiteaddons.v1.ListDeploymentsRequest;
import com.google.cloud.gsuiteaddons.v1.ListDeploymentsResponse;
import com.google.cloud.gsuiteaddons.v1.ReplaceDeploymentRequest;
import com.google.cloud.gsuiteaddons.v1.UninstallDeploymentRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the GSuiteAddOns service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class GSuiteAddOnsStub implements BackgroundResource {

  public UnaryCallable<GetAuthorizationRequest, Authorization> getAuthorizationCallable() {
    throw new UnsupportedOperationException("Not implemented: getAuthorizationCallable()");
  }

  public UnaryCallable<CreateDeploymentRequest, Deployment> createDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: createDeploymentCallable()");
  }

  public UnaryCallable<ReplaceDeploymentRequest, Deployment> replaceDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: replaceDeploymentCallable()");
  }

  public UnaryCallable<GetDeploymentRequest, Deployment> getDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: getDeploymentCallable()");
  }

  public UnaryCallable<ListDeploymentsRequest, ListDeploymentsPagedResponse>
      listDeploymentsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDeploymentsPagedCallable()");
  }

  public UnaryCallable<ListDeploymentsRequest, ListDeploymentsResponse> listDeploymentsCallable() {
    throw new UnsupportedOperationException("Not implemented: listDeploymentsCallable()");
  }

  public UnaryCallable<DeleteDeploymentRequest, Empty> deleteDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDeploymentCallable()");
  }

  public UnaryCallable<InstallDeploymentRequest, Empty> installDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: installDeploymentCallable()");
  }

  public UnaryCallable<UninstallDeploymentRequest, Empty> uninstallDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: uninstallDeploymentCallable()");
  }

  public UnaryCallable<GetInstallStatusRequest, InstallStatus> getInstallStatusCallable() {
    throw new UnsupportedOperationException("Not implemented: getInstallStatusCallable()");
  }

  @Override
  public abstract void close();
}
