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

package com.google.cloud.saasplatform.saasservicemgmt.v1beta1.stub;

import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasRolloutsClient.ListLocationsPagedResponse;
import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasRolloutsClient.ListRolloutKindsPagedResponse;
import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasRolloutsClient.ListRolloutsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateRolloutKindRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateRolloutRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteRolloutKindRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteRolloutRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetRolloutKindRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetRolloutRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutKindsRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutKindsResponse;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutsRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutsResponse;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Rollout;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.RolloutKind;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateRolloutKindRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateRolloutRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the SaasRollouts service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class SaasRolloutsStub implements BackgroundResource {

  public UnaryCallable<ListRolloutsRequest, ListRolloutsPagedResponse> listRolloutsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listRolloutsPagedCallable()");
  }

  public UnaryCallable<ListRolloutsRequest, ListRolloutsResponse> listRolloutsCallable() {
    throw new UnsupportedOperationException("Not implemented: listRolloutsCallable()");
  }

  public UnaryCallable<GetRolloutRequest, Rollout> getRolloutCallable() {
    throw new UnsupportedOperationException("Not implemented: getRolloutCallable()");
  }

  public UnaryCallable<CreateRolloutRequest, Rollout> createRolloutCallable() {
    throw new UnsupportedOperationException("Not implemented: createRolloutCallable()");
  }

  public UnaryCallable<UpdateRolloutRequest, Rollout> updateRolloutCallable() {
    throw new UnsupportedOperationException("Not implemented: updateRolloutCallable()");
  }

  public UnaryCallable<DeleteRolloutRequest, Empty> deleteRolloutCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteRolloutCallable()");
  }

  public UnaryCallable<ListRolloutKindsRequest, ListRolloutKindsPagedResponse>
      listRolloutKindsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listRolloutKindsPagedCallable()");
  }

  public UnaryCallable<ListRolloutKindsRequest, ListRolloutKindsResponse>
      listRolloutKindsCallable() {
    throw new UnsupportedOperationException("Not implemented: listRolloutKindsCallable()");
  }

  public UnaryCallable<GetRolloutKindRequest, RolloutKind> getRolloutKindCallable() {
    throw new UnsupportedOperationException("Not implemented: getRolloutKindCallable()");
  }

  public UnaryCallable<CreateRolloutKindRequest, RolloutKind> createRolloutKindCallable() {
    throw new UnsupportedOperationException("Not implemented: createRolloutKindCallable()");
  }

  public UnaryCallable<UpdateRolloutKindRequest, RolloutKind> updateRolloutKindCallable() {
    throw new UnsupportedOperationException("Not implemented: updateRolloutKindCallable()");
  }

  public UnaryCallable<DeleteRolloutKindRequest, Empty> deleteRolloutKindCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteRolloutKindCallable()");
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
