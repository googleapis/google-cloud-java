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

package com.google.cloud.chronicle.v1.stub;

import static com.google.cloud.chronicle.v1.FindingsRefinementServiceClient.ListAllFindingsRefinementDeploymentsPagedResponse;
import static com.google.cloud.chronicle.v1.FindingsRefinementServiceClient.ListFindingsRefinementsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.chronicle.v1.ComputeAllFindingsRefinementActivitiesRequest;
import com.google.cloud.chronicle.v1.ComputeAllFindingsRefinementActivitiesResponse;
import com.google.cloud.chronicle.v1.ComputeFindingsRefinementActivityRequest;
import com.google.cloud.chronicle.v1.ComputeFindingsRefinementActivityResponse;
import com.google.cloud.chronicle.v1.CreateFindingsRefinementRequest;
import com.google.cloud.chronicle.v1.FindingsRefinement;
import com.google.cloud.chronicle.v1.FindingsRefinementDeployment;
import com.google.cloud.chronicle.v1.GetFindingsRefinementDeploymentRequest;
import com.google.cloud.chronicle.v1.GetFindingsRefinementRequest;
import com.google.cloud.chronicle.v1.ListAllFindingsRefinementDeploymentsRequest;
import com.google.cloud.chronicle.v1.ListAllFindingsRefinementDeploymentsResponse;
import com.google.cloud.chronicle.v1.ListFindingsRefinementsRequest;
import com.google.cloud.chronicle.v1.ListFindingsRefinementsResponse;
import com.google.cloud.chronicle.v1.UpdateFindingsRefinementDeploymentRequest;
import com.google.cloud.chronicle.v1.UpdateFindingsRefinementRequest;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the FindingsRefinementService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public abstract class FindingsRefinementServiceStub implements BackgroundResource {

  public UnaryCallable<GetFindingsRefinementRequest, FindingsRefinement>
      getFindingsRefinementCallable() {
    throw new UnsupportedOperationException("Not implemented: getFindingsRefinementCallable()");
  }

  public UnaryCallable<ListFindingsRefinementsRequest, ListFindingsRefinementsPagedResponse>
      listFindingsRefinementsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listFindingsRefinementsPagedCallable()");
  }

  public UnaryCallable<ListFindingsRefinementsRequest, ListFindingsRefinementsResponse>
      listFindingsRefinementsCallable() {
    throw new UnsupportedOperationException("Not implemented: listFindingsRefinementsCallable()");
  }

  public UnaryCallable<CreateFindingsRefinementRequest, FindingsRefinement>
      createFindingsRefinementCallable() {
    throw new UnsupportedOperationException("Not implemented: createFindingsRefinementCallable()");
  }

  public UnaryCallable<UpdateFindingsRefinementRequest, FindingsRefinement>
      updateFindingsRefinementCallable() {
    throw new UnsupportedOperationException("Not implemented: updateFindingsRefinementCallable()");
  }

  public UnaryCallable<GetFindingsRefinementDeploymentRequest, FindingsRefinementDeployment>
      getFindingsRefinementDeploymentCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getFindingsRefinementDeploymentCallable()");
  }

  public UnaryCallable<UpdateFindingsRefinementDeploymentRequest, FindingsRefinementDeployment>
      updateFindingsRefinementDeploymentCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateFindingsRefinementDeploymentCallable()");
  }

  public UnaryCallable<
          ListAllFindingsRefinementDeploymentsRequest,
          ListAllFindingsRefinementDeploymentsPagedResponse>
      listAllFindingsRefinementDeploymentsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listAllFindingsRefinementDeploymentsPagedCallable()");
  }

  public UnaryCallable<
          ListAllFindingsRefinementDeploymentsRequest, ListAllFindingsRefinementDeploymentsResponse>
      listAllFindingsRefinementDeploymentsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listAllFindingsRefinementDeploymentsCallable()");
  }

  public UnaryCallable<
          ComputeFindingsRefinementActivityRequest, ComputeFindingsRefinementActivityResponse>
      computeFindingsRefinementActivityCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: computeFindingsRefinementActivityCallable()");
  }

  public UnaryCallable<
          ComputeAllFindingsRefinementActivitiesRequest,
          ComputeAllFindingsRefinementActivitiesResponse>
      computeAllFindingsRefinementActivitiesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: computeAllFindingsRefinementActivitiesCallable()");
  }

  @Override
  public abstract void close();
}
