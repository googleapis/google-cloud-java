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

package com.google.cloud.gkehub.v1alpha2.stub;

import static com.google.cloud.gkehub.v1alpha2.GkeHubClient.ListMembershipsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.gkehub.v1alpha2.CreateMembershipRequest;
import com.google.cloud.gkehub.v1alpha2.DeleteMembershipRequest;
import com.google.cloud.gkehub.v1alpha2.GenerateConnectManifestRequest;
import com.google.cloud.gkehub.v1alpha2.GenerateConnectManifestResponse;
import com.google.cloud.gkehub.v1alpha2.GetMembershipRequest;
import com.google.cloud.gkehub.v1alpha2.InitializeHubRequest;
import com.google.cloud.gkehub.v1alpha2.InitializeHubResponse;
import com.google.cloud.gkehub.v1alpha2.ListMembershipsRequest;
import com.google.cloud.gkehub.v1alpha2.ListMembershipsResponse;
import com.google.cloud.gkehub.v1alpha2.Membership;
import com.google.cloud.gkehub.v1alpha2.OperationMetadata;
import com.google.cloud.gkehub.v1alpha2.UpdateMembershipRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the GkeHub service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class GkeHubStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListMembershipsRequest, ListMembershipsPagedResponse>
      listMembershipsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listMembershipsPagedCallable()");
  }

  public UnaryCallable<ListMembershipsRequest, ListMembershipsResponse> listMembershipsCallable() {
    throw new UnsupportedOperationException("Not implemented: listMembershipsCallable()");
  }

  public UnaryCallable<GetMembershipRequest, Membership> getMembershipCallable() {
    throw new UnsupportedOperationException("Not implemented: getMembershipCallable()");
  }

  public OperationCallable<CreateMembershipRequest, Membership, OperationMetadata>
      createMembershipOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createMembershipOperationCallable()");
  }

  public UnaryCallable<CreateMembershipRequest, Operation> createMembershipCallable() {
    throw new UnsupportedOperationException("Not implemented: createMembershipCallable()");
  }

  public OperationCallable<DeleteMembershipRequest, Empty, OperationMetadata>
      deleteMembershipOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteMembershipOperationCallable()");
  }

  public UnaryCallable<DeleteMembershipRequest, Operation> deleteMembershipCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteMembershipCallable()");
  }

  public OperationCallable<UpdateMembershipRequest, Membership, OperationMetadata>
      updateMembershipOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateMembershipOperationCallable()");
  }

  public UnaryCallable<UpdateMembershipRequest, Operation> updateMembershipCallable() {
    throw new UnsupportedOperationException("Not implemented: updateMembershipCallable()");
  }

  public UnaryCallable<GenerateConnectManifestRequest, GenerateConnectManifestResponse>
      generateConnectManifestCallable() {
    throw new UnsupportedOperationException("Not implemented: generateConnectManifestCallable()");
  }

  public UnaryCallable<InitializeHubRequest, InitializeHubResponse> initializeHubCallable() {
    throw new UnsupportedOperationException("Not implemented: initializeHubCallable()");
  }

  @Override
  public abstract void close();
}
