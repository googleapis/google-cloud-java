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

package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.InterconnectGroupsClient.ListPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.CreateMembersInterconnectGroupRequest;
import com.google.cloud.compute.v1.DeleteInterconnectGroupRequest;
import com.google.cloud.compute.v1.GetIamPolicyInterconnectGroupRequest;
import com.google.cloud.compute.v1.GetInterconnectGroupRequest;
import com.google.cloud.compute.v1.GetOperationalStatusInterconnectGroupRequest;
import com.google.cloud.compute.v1.InsertInterconnectGroupRequest;
import com.google.cloud.compute.v1.InterconnectGroup;
import com.google.cloud.compute.v1.InterconnectGroupsGetOperationalStatusResponse;
import com.google.cloud.compute.v1.InterconnectGroupsListResponse;
import com.google.cloud.compute.v1.ListInterconnectGroupsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchInterconnectGroupRequest;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.SetIamPolicyInterconnectGroupRequest;
import com.google.cloud.compute.v1.TestIamPermissionsInterconnectGroupRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the InterconnectGroups service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class InterconnectGroupsStub implements BackgroundResource {

  public OperationCallable<CreateMembersInterconnectGroupRequest, Operation, Operation>
      createMembersOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createMembersOperationCallable()");
  }

  public UnaryCallable<CreateMembersInterconnectGroupRequest, Operation> createMembersCallable() {
    throw new UnsupportedOperationException("Not implemented: createMembersCallable()");
  }

  public OperationCallable<DeleteInterconnectGroupRequest, Operation, Operation>
      deleteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteOperationCallable()");
  }

  public UnaryCallable<DeleteInterconnectGroupRequest, Operation> deleteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCallable()");
  }

  public UnaryCallable<GetInterconnectGroupRequest, InterconnectGroup> getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public UnaryCallable<GetIamPolicyInterconnectGroupRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<
          GetOperationalStatusInterconnectGroupRequest,
          InterconnectGroupsGetOperationalStatusResponse>
      getOperationalStatusCallable() {
    throw new UnsupportedOperationException("Not implemented: getOperationalStatusCallable()");
  }

  public OperationCallable<InsertInterconnectGroupRequest, Operation, Operation>
      insertOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: insertOperationCallable()");
  }

  public UnaryCallable<InsertInterconnectGroupRequest, Operation> insertCallable() {
    throw new UnsupportedOperationException("Not implemented: insertCallable()");
  }

  public UnaryCallable<ListInterconnectGroupsRequest, ListPagedResponse> listPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPagedCallable()");
  }

  public UnaryCallable<ListInterconnectGroupsRequest, InterconnectGroupsListResponse>
      listCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallable()");
  }

  public OperationCallable<PatchInterconnectGroupRequest, Operation, Operation>
      patchOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: patchOperationCallable()");
  }

  public UnaryCallable<PatchInterconnectGroupRequest, Operation> patchCallable() {
    throw new UnsupportedOperationException("Not implemented: patchCallable()");
  }

  public UnaryCallable<SetIamPolicyInterconnectGroupRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<TestIamPermissionsInterconnectGroupRequest, TestPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
