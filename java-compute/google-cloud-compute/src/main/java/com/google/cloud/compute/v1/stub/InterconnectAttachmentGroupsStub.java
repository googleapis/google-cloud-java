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

import static com.google.cloud.compute.v1.InterconnectAttachmentGroupsClient.ListPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.DeleteInterconnectAttachmentGroupRequest;
import com.google.cloud.compute.v1.GetIamPolicyInterconnectAttachmentGroupRequest;
import com.google.cloud.compute.v1.GetInterconnectAttachmentGroupRequest;
import com.google.cloud.compute.v1.GetOperationalStatusInterconnectAttachmentGroupRequest;
import com.google.cloud.compute.v1.InsertInterconnectAttachmentGroupRequest;
import com.google.cloud.compute.v1.InterconnectAttachmentGroup;
import com.google.cloud.compute.v1.InterconnectAttachmentGroupsGetOperationalStatusResponse;
import com.google.cloud.compute.v1.InterconnectAttachmentGroupsListResponse;
import com.google.cloud.compute.v1.ListInterconnectAttachmentGroupsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchInterconnectAttachmentGroupRequest;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.SetIamPolicyInterconnectAttachmentGroupRequest;
import com.google.cloud.compute.v1.TestIamPermissionsInterconnectAttachmentGroupRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the InterconnectAttachmentGroups service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class InterconnectAttachmentGroupsStub implements BackgroundResource {

  public OperationCallable<DeleteInterconnectAttachmentGroupRequest, Operation, Operation>
      deleteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteOperationCallable()");
  }

  public UnaryCallable<DeleteInterconnectAttachmentGroupRequest, Operation> deleteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCallable()");
  }

  public UnaryCallable<GetInterconnectAttachmentGroupRequest, InterconnectAttachmentGroup>
      getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public UnaryCallable<GetIamPolicyInterconnectAttachmentGroupRequest, Policy>
      getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<
          GetOperationalStatusInterconnectAttachmentGroupRequest,
          InterconnectAttachmentGroupsGetOperationalStatusResponse>
      getOperationalStatusCallable() {
    throw new UnsupportedOperationException("Not implemented: getOperationalStatusCallable()");
  }

  public OperationCallable<InsertInterconnectAttachmentGroupRequest, Operation, Operation>
      insertOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: insertOperationCallable()");
  }

  public UnaryCallable<InsertInterconnectAttachmentGroupRequest, Operation> insertCallable() {
    throw new UnsupportedOperationException("Not implemented: insertCallable()");
  }

  public UnaryCallable<ListInterconnectAttachmentGroupsRequest, ListPagedResponse>
      listPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPagedCallable()");
  }

  public UnaryCallable<
          ListInterconnectAttachmentGroupsRequest, InterconnectAttachmentGroupsListResponse>
      listCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallable()");
  }

  public OperationCallable<PatchInterconnectAttachmentGroupRequest, Operation, Operation>
      patchOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: patchOperationCallable()");
  }

  public UnaryCallable<PatchInterconnectAttachmentGroupRequest, Operation> patchCallable() {
    throw new UnsupportedOperationException("Not implemented: patchCallable()");
  }

  public UnaryCallable<SetIamPolicyInterconnectAttachmentGroupRequest, Policy>
      setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<
          TestIamPermissionsInterconnectAttachmentGroupRequest, TestPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
