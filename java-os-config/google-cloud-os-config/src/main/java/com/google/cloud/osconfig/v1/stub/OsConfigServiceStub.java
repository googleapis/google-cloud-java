/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.osconfig.v1.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.osconfig.v1.PatchDeployments.CreatePatchDeploymentRequest;
import com.google.cloud.osconfig.v1.PatchDeployments.DeletePatchDeploymentRequest;
import com.google.cloud.osconfig.v1.PatchDeployments.GetPatchDeploymentRequest;
import com.google.cloud.osconfig.v1.PatchDeployments.ListPatchDeploymentsRequest;
import com.google.cloud.osconfig.v1.PatchDeployments.ListPatchDeploymentsResponse;
import com.google.cloud.osconfig.v1.PatchDeployments.PatchDeployment;
import com.google.cloud.osconfig.v1.PatchJobs.CancelPatchJobRequest;
import com.google.cloud.osconfig.v1.PatchJobs.ExecutePatchJobRequest;
import com.google.cloud.osconfig.v1.PatchJobs.GetPatchJobRequest;
import com.google.cloud.osconfig.v1.PatchJobs.ListPatchJobInstanceDetailsRequest;
import com.google.cloud.osconfig.v1.PatchJobs.ListPatchJobInstanceDetailsResponse;
import com.google.cloud.osconfig.v1.PatchJobs.ListPatchJobsRequest;
import com.google.cloud.osconfig.v1.PatchJobs.ListPatchJobsResponse;
import com.google.cloud.osconfig.v1.PatchJobs.PatchJob;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for Cloud OS Config API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class OsConfigServiceStub implements BackgroundResource {

  public UnaryCallable<ExecutePatchJobRequest, PatchJob> executePatchJobCallable() {
    throw new UnsupportedOperationException("Not implemented: executePatchJobCallable()");
  }

  public UnaryCallable<GetPatchJobRequest, PatchJob> getPatchJobCallable() {
    throw new UnsupportedOperationException("Not implemented: getPatchJobCallable()");
  }

  public UnaryCallable<CancelPatchJobRequest, PatchJob> cancelPatchJobCallable() {
    throw new UnsupportedOperationException("Not implemented: cancelPatchJobCallable()");
  }

  public UnaryCallable<ListPatchJobsRequest, ListPatchJobsResponse> listPatchJobsCallable() {
    throw new UnsupportedOperationException("Not implemented: listPatchJobsCallable()");
  }

  public UnaryCallable<ListPatchJobInstanceDetailsRequest, ListPatchJobInstanceDetailsResponse>
      listPatchJobInstanceDetailsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listPatchJobInstanceDetailsCallable()");
  }

  public UnaryCallable<CreatePatchDeploymentRequest, PatchDeployment>
      createPatchDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: createPatchDeploymentCallable()");
  }

  public UnaryCallable<GetPatchDeploymentRequest, PatchDeployment> getPatchDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: getPatchDeploymentCallable()");
  }

  public UnaryCallable<ListPatchDeploymentsRequest, ListPatchDeploymentsResponse>
      listPatchDeploymentsCallable() {
    throw new UnsupportedOperationException("Not implemented: listPatchDeploymentsCallable()");
  }

  public UnaryCallable<DeletePatchDeploymentRequest, Empty> deletePatchDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: deletePatchDeploymentCallable()");
  }

  @Override
  public abstract void close();
}
