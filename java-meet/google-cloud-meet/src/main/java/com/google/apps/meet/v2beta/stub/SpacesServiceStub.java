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

package com.google.apps.meet.v2beta.stub;

import static com.google.apps.meet.v2beta.SpacesServiceClient.ListMembersPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.apps.meet.v2beta.ConnectActiveConferenceRequest;
import com.google.apps.meet.v2beta.ConnectActiveConferenceResponse;
import com.google.apps.meet.v2beta.CreateMemberRequest;
import com.google.apps.meet.v2beta.CreateSpaceRequest;
import com.google.apps.meet.v2beta.DeleteMemberRequest;
import com.google.apps.meet.v2beta.EndActiveConferenceRequest;
import com.google.apps.meet.v2beta.GetMemberRequest;
import com.google.apps.meet.v2beta.GetSpaceRequest;
import com.google.apps.meet.v2beta.ListMembersRequest;
import com.google.apps.meet.v2beta.ListMembersResponse;
import com.google.apps.meet.v2beta.Member;
import com.google.apps.meet.v2beta.Space;
import com.google.apps.meet.v2beta.UpdateSpaceRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the SpacesService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class SpacesServiceStub implements BackgroundResource {

  public UnaryCallable<CreateSpaceRequest, Space> createSpaceCallable() {
    throw new UnsupportedOperationException("Not implemented: createSpaceCallable()");
  }

  public UnaryCallable<GetSpaceRequest, Space> getSpaceCallable() {
    throw new UnsupportedOperationException("Not implemented: getSpaceCallable()");
  }

  public UnaryCallable<UpdateSpaceRequest, Space> updateSpaceCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSpaceCallable()");
  }

  public UnaryCallable<ConnectActiveConferenceRequest, ConnectActiveConferenceResponse>
      connectActiveConferenceCallable() {
    throw new UnsupportedOperationException("Not implemented: connectActiveConferenceCallable()");
  }

  public UnaryCallable<EndActiveConferenceRequest, Empty> endActiveConferenceCallable() {
    throw new UnsupportedOperationException("Not implemented: endActiveConferenceCallable()");
  }

  public UnaryCallable<CreateMemberRequest, Member> createMemberCallable() {
    throw new UnsupportedOperationException("Not implemented: createMemberCallable()");
  }

  public UnaryCallable<GetMemberRequest, Member> getMemberCallable() {
    throw new UnsupportedOperationException("Not implemented: getMemberCallable()");
  }

  public UnaryCallable<ListMembersRequest, ListMembersPagedResponse> listMembersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listMembersPagedCallable()");
  }

  public UnaryCallable<ListMembersRequest, ListMembersResponse> listMembersCallable() {
    throw new UnsupportedOperationException("Not implemented: listMembersCallable()");
  }

  public UnaryCallable<DeleteMemberRequest, Empty> deleteMemberCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteMemberCallable()");
  }

  @Override
  public abstract void close();
}
