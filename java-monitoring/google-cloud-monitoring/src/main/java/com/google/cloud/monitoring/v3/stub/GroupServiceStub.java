/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.monitoring.v3.stub;

import static com.google.cloud.monitoring.v3.GroupServiceClient.ListGroupMembersPagedResponse;
import static com.google.cloud.monitoring.v3.GroupServiceClient.ListGroupsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.monitoring.v3.CreateGroupRequest;
import com.google.monitoring.v3.DeleteGroupRequest;
import com.google.monitoring.v3.GetGroupRequest;
import com.google.monitoring.v3.Group;
import com.google.monitoring.v3.ListGroupMembersRequest;
import com.google.monitoring.v3.ListGroupMembersResponse;
import com.google.monitoring.v3.ListGroupsRequest;
import com.google.monitoring.v3.ListGroupsResponse;
import com.google.monitoring.v3.UpdateGroupRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the GroupService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
public abstract class GroupServiceStub implements BackgroundResource {

  public UnaryCallable<ListGroupsRequest, ListGroupsPagedResponse> listGroupsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listGroupsPagedCallable()");
  }

  public UnaryCallable<ListGroupsRequest, ListGroupsResponse> listGroupsCallable() {
    throw new UnsupportedOperationException("Not implemented: listGroupsCallable()");
  }

  public UnaryCallable<GetGroupRequest, Group> getGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: getGroupCallable()");
  }

  public UnaryCallable<CreateGroupRequest, Group> createGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: createGroupCallable()");
  }

  public UnaryCallable<UpdateGroupRequest, Group> updateGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: updateGroupCallable()");
  }

  public UnaryCallable<DeleteGroupRequest, Empty> deleteGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteGroupCallable()");
  }

  public UnaryCallable<ListGroupMembersRequest, ListGroupMembersPagedResponse>
      listGroupMembersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listGroupMembersPagedCallable()");
  }

  public UnaryCallable<ListGroupMembersRequest, ListGroupMembersResponse>
      listGroupMembersCallable() {
    throw new UnsupportedOperationException("Not implemented: listGroupMembersCallable()");
  }

  @Override
  public abstract void close();
}
