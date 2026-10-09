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

package com.google.apps.meet.v2.stub;

import static com.google.apps.meet.v2.SpacesServiceClient.ListMembersPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.apps.meet.v2.BatchUpdateMembersRequest;
import com.google.apps.meet.v2.BatchUpdateMembersResponse;
import com.google.apps.meet.v2.CreateMemberRequest;
import com.google.apps.meet.v2.CreateSpaceRequest;
import com.google.apps.meet.v2.DeleteMemberRequest;
import com.google.apps.meet.v2.EndActiveConferenceRequest;
import com.google.apps.meet.v2.GetMemberRequest;
import com.google.apps.meet.v2.GetSpaceRequest;
import com.google.apps.meet.v2.ListMembersRequest;
import com.google.apps.meet.v2.ListMembersResponse;
import com.google.apps.meet.v2.Member;
import com.google.apps.meet.v2.Space;
import com.google.apps.meet.v2.UpdateMemberRequest;
import com.google.apps.meet.v2.UpdateSpaceRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the SpacesService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
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

  public UnaryCallable<UpdateMemberRequest, Member> updateMemberCallable() {
    throw new UnsupportedOperationException("Not implemented: updateMemberCallable()");
  }

  public UnaryCallable<BatchUpdateMembersRequest, BatchUpdateMembersResponse>
      batchUpdateMembersCallable() {
    throw new UnsupportedOperationException("Not implemented: batchUpdateMembersCallable()");
  }

  @Override
  public abstract void close();
}
