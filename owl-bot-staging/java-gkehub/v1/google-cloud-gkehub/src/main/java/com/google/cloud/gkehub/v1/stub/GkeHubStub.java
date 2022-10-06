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

package com.google.cloud.gkehub.v1.stub;

import static com.google.cloud.gkehub.v1.GkeHubClient.ListFeaturesPagedResponse;
import static com.google.cloud.gkehub.v1.GkeHubClient.ListMembershipsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.gkehub.v1.CreateFeatureRequest;
import com.google.cloud.gkehub.v1.CreateMembershipRequest;
import com.google.cloud.gkehub.v1.DeleteFeatureRequest;
import com.google.cloud.gkehub.v1.DeleteMembershipRequest;
import com.google.cloud.gkehub.v1.Feature;
import com.google.cloud.gkehub.v1.GenerateConnectManifestRequest;
import com.google.cloud.gkehub.v1.GenerateConnectManifestResponse;
import com.google.cloud.gkehub.v1.GetFeatureRequest;
import com.google.cloud.gkehub.v1.GetMembershipRequest;
import com.google.cloud.gkehub.v1.ListFeaturesRequest;
import com.google.cloud.gkehub.v1.ListFeaturesResponse;
import com.google.cloud.gkehub.v1.ListMembershipsRequest;
import com.google.cloud.gkehub.v1.ListMembershipsResponse;
import com.google.cloud.gkehub.v1.Membership;
import com.google.cloud.gkehub.v1.OperationMetadata;
import com.google.cloud.gkehub.v1.UpdateFeatureRequest;
import com.google.cloud.gkehub.v1.UpdateMembershipRequest;
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

  public UnaryCallable<ListFeaturesRequest, ListFeaturesPagedResponse> listFeaturesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listFeaturesPagedCallable()");
  }

  public UnaryCallable<ListFeaturesRequest, ListFeaturesResponse> listFeaturesCallable() {
    throw new UnsupportedOperationException("Not implemented: listFeaturesCallable()");
  }

  public UnaryCallable<GetMembershipRequest, Membership> getMembershipCallable() {
    throw new UnsupportedOperationException("Not implemented: getMembershipCallable()");
  }

  public UnaryCallable<GetFeatureRequest, Feature> getFeatureCallable() {
    throw new UnsupportedOperationException("Not implemented: getFeatureCallable()");
  }

  public OperationCallable<CreateMembershipRequest, Membership, OperationMetadata>
      createMembershipOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createMembershipOperationCallable()");
  }

  public UnaryCallable<CreateMembershipRequest, Operation> createMembershipCallable() {
    throw new UnsupportedOperationException("Not implemented: createMembershipCallable()");
  }

  public OperationCallable<CreateFeatureRequest, Feature, OperationMetadata>
      createFeatureOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createFeatureOperationCallable()");
  }

  public UnaryCallable<CreateFeatureRequest, Operation> createFeatureCallable() {
    throw new UnsupportedOperationException("Not implemented: createFeatureCallable()");
  }

  public OperationCallable<DeleteMembershipRequest, Empty, OperationMetadata>
      deleteMembershipOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteMembershipOperationCallable()");
  }

  public UnaryCallable<DeleteMembershipRequest, Operation> deleteMembershipCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteMembershipCallable()");
  }

  public OperationCallable<DeleteFeatureRequest, Empty, OperationMetadata>
      deleteFeatureOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteFeatureOperationCallable()");
  }

  public UnaryCallable<DeleteFeatureRequest, Operation> deleteFeatureCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteFeatureCallable()");
  }

  public OperationCallable<UpdateMembershipRequest, Membership, OperationMetadata>
      updateMembershipOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateMembershipOperationCallable()");
  }

  public UnaryCallable<UpdateMembershipRequest, Operation> updateMembershipCallable() {
    throw new UnsupportedOperationException("Not implemented: updateMembershipCallable()");
  }

  public OperationCallable<UpdateFeatureRequest, Feature, OperationMetadata>
      updateFeatureOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateFeatureOperationCallable()");
  }

  public UnaryCallable<UpdateFeatureRequest, Operation> updateFeatureCallable() {
    throw new UnsupportedOperationException("Not implemented: updateFeatureCallable()");
  }

  public UnaryCallable<GenerateConnectManifestRequest, GenerateConnectManifestResponse>
      generateConnectManifestCallable() {
    throw new UnsupportedOperationException("Not implemented: generateConnectManifestCallable()");
  }

  @Override
  public abstract void close();
}
