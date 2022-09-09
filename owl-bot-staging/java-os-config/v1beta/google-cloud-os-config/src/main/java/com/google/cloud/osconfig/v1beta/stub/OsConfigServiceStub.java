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

package com.google.cloud.osconfig.v1beta.stub;

import static com.google.cloud.osconfig.v1beta.OsConfigServiceClient.ListGuestPoliciesPagedResponse;
import static com.google.cloud.osconfig.v1beta.OsConfigServiceClient.ListPatchDeploymentsPagedResponse;
import static com.google.cloud.osconfig.v1beta.OsConfigServiceClient.ListPatchJobInstanceDetailsPagedResponse;
import static com.google.cloud.osconfig.v1beta.OsConfigServiceClient.ListPatchJobsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.osconfig.v1beta.GuestPolicies;
import com.google.cloud.osconfig.v1beta.PatchDeployments;
import com.google.cloud.osconfig.v1beta.PatchJobs;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the OsConfigService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class OsConfigServiceStub implements BackgroundResource {

  public UnaryCallable<PatchJobs.ExecutePatchJobRequest, PatchJobs.PatchJob>
      executePatchJobCallable() {
    throw new UnsupportedOperationException("Not implemented: executePatchJobCallable()");
  }

  public UnaryCallable<PatchJobs.GetPatchJobRequest, PatchJobs.PatchJob> getPatchJobCallable() {
    throw new UnsupportedOperationException("Not implemented: getPatchJobCallable()");
  }

  public UnaryCallable<PatchJobs.CancelPatchJobRequest, PatchJobs.PatchJob>
      cancelPatchJobCallable() {
    throw new UnsupportedOperationException("Not implemented: cancelPatchJobCallable()");
  }

  public UnaryCallable<PatchJobs.ListPatchJobsRequest, ListPatchJobsPagedResponse>
      listPatchJobsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPatchJobsPagedCallable()");
  }

  public UnaryCallable<PatchJobs.ListPatchJobsRequest, PatchJobs.ListPatchJobsResponse>
      listPatchJobsCallable() {
    throw new UnsupportedOperationException("Not implemented: listPatchJobsCallable()");
  }

  public UnaryCallable<
          PatchJobs.ListPatchJobInstanceDetailsRequest, ListPatchJobInstanceDetailsPagedResponse>
      listPatchJobInstanceDetailsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listPatchJobInstanceDetailsPagedCallable()");
  }

  public UnaryCallable<
          PatchJobs.ListPatchJobInstanceDetailsRequest,
          PatchJobs.ListPatchJobInstanceDetailsResponse>
      listPatchJobInstanceDetailsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listPatchJobInstanceDetailsCallable()");
  }

  public UnaryCallable<
          PatchDeployments.CreatePatchDeploymentRequest, PatchDeployments.PatchDeployment>
      createPatchDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: createPatchDeploymentCallable()");
  }

  public UnaryCallable<PatchDeployments.GetPatchDeploymentRequest, PatchDeployments.PatchDeployment>
      getPatchDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: getPatchDeploymentCallable()");
  }

  public UnaryCallable<
          PatchDeployments.ListPatchDeploymentsRequest, ListPatchDeploymentsPagedResponse>
      listPatchDeploymentsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPatchDeploymentsPagedCallable()");
  }

  public UnaryCallable<
          PatchDeployments.ListPatchDeploymentsRequest,
          PatchDeployments.ListPatchDeploymentsResponse>
      listPatchDeploymentsCallable() {
    throw new UnsupportedOperationException("Not implemented: listPatchDeploymentsCallable()");
  }

  public UnaryCallable<PatchDeployments.DeletePatchDeploymentRequest, Empty>
      deletePatchDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: deletePatchDeploymentCallable()");
  }

  public UnaryCallable<
          PatchDeployments.UpdatePatchDeploymentRequest, PatchDeployments.PatchDeployment>
      updatePatchDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: updatePatchDeploymentCallable()");
  }

  public UnaryCallable<
          PatchDeployments.PausePatchDeploymentRequest, PatchDeployments.PatchDeployment>
      pausePatchDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: pausePatchDeploymentCallable()");
  }

  public UnaryCallable<
          PatchDeployments.ResumePatchDeploymentRequest, PatchDeployments.PatchDeployment>
      resumePatchDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: resumePatchDeploymentCallable()");
  }

  public UnaryCallable<GuestPolicies.CreateGuestPolicyRequest, GuestPolicies.GuestPolicy>
      createGuestPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: createGuestPolicyCallable()");
  }

  public UnaryCallable<GuestPolicies.GetGuestPolicyRequest, GuestPolicies.GuestPolicy>
      getGuestPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getGuestPolicyCallable()");
  }

  public UnaryCallable<GuestPolicies.ListGuestPoliciesRequest, ListGuestPoliciesPagedResponse>
      listGuestPoliciesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listGuestPoliciesPagedCallable()");
  }

  public UnaryCallable<
          GuestPolicies.ListGuestPoliciesRequest, GuestPolicies.ListGuestPoliciesResponse>
      listGuestPoliciesCallable() {
    throw new UnsupportedOperationException("Not implemented: listGuestPoliciesCallable()");
  }

  public UnaryCallable<GuestPolicies.UpdateGuestPolicyRequest, GuestPolicies.GuestPolicy>
      updateGuestPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: updateGuestPolicyCallable()");
  }

  public UnaryCallable<GuestPolicies.DeleteGuestPolicyRequest, Empty> deleteGuestPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteGuestPolicyCallable()");
  }

  public UnaryCallable<
          GuestPolicies.LookupEffectiveGuestPolicyRequest, GuestPolicies.EffectiveGuestPolicy>
      lookupEffectiveGuestPolicyCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: lookupEffectiveGuestPolicyCallable()");
  }

  @Override
  public abstract void close();
}
