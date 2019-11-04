/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.NodeGroupClient.AggregatedListNodeGroupsPagedResponse;
import static com.google.cloud.compute.v1.NodeGroupClient.ListNodeGroupsPagedResponse;
import static com.google.cloud.compute.v1.NodeGroupClient.ListNodesNodeGroupsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AddNodesNodeGroupHttpRequest;
import com.google.cloud.compute.v1.AggregatedListNodeGroupsHttpRequest;
import com.google.cloud.compute.v1.DeleteNodeGroupHttpRequest;
import com.google.cloud.compute.v1.DeleteNodesNodeGroupHttpRequest;
import com.google.cloud.compute.v1.GetIamPolicyNodeGroupHttpRequest;
import com.google.cloud.compute.v1.GetNodeGroupHttpRequest;
import com.google.cloud.compute.v1.InsertNodeGroupHttpRequest;
import com.google.cloud.compute.v1.ListNodeGroupsHttpRequest;
import com.google.cloud.compute.v1.ListNodesNodeGroupsHttpRequest;
import com.google.cloud.compute.v1.NodeGroup;
import com.google.cloud.compute.v1.NodeGroupAggregatedList;
import com.google.cloud.compute.v1.NodeGroupList;
import com.google.cloud.compute.v1.NodeGroupsListNodes;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.SetIamPolicyNodeGroupHttpRequest;
import com.google.cloud.compute.v1.SetNodeTemplateNodeGroupHttpRequest;
import com.google.cloud.compute.v1.TestIamPermissionsNodeGroupHttpRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class NodeGroupStub implements BackgroundResource {

  @BetaApi
  public UnaryCallable<AddNodesNodeGroupHttpRequest, Operation> addNodesNodeGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: addNodesNodeGroupCallable()");
  }

  @BetaApi
  public UnaryCallable<AggregatedListNodeGroupsHttpRequest, AggregatedListNodeGroupsPagedResponse>
      aggregatedListNodeGroupsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: aggregatedListNodeGroupsPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<AggregatedListNodeGroupsHttpRequest, NodeGroupAggregatedList>
      aggregatedListNodeGroupsCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListNodeGroupsCallable()");
  }

  @BetaApi
  public UnaryCallable<DeleteNodeGroupHttpRequest, Operation> deleteNodeGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteNodeGroupCallable()");
  }

  @BetaApi
  public UnaryCallable<DeleteNodesNodeGroupHttpRequest, Operation> deleteNodesNodeGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteNodesNodeGroupCallable()");
  }

  @BetaApi
  public UnaryCallable<GetNodeGroupHttpRequest, NodeGroup> getNodeGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: getNodeGroupCallable()");
  }

  @BetaApi
  public UnaryCallable<GetIamPolicyNodeGroupHttpRequest, Policy> getIamPolicyNodeGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyNodeGroupCallable()");
  }

  @BetaApi
  public UnaryCallable<InsertNodeGroupHttpRequest, Operation> insertNodeGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: insertNodeGroupCallable()");
  }

  @BetaApi
  public UnaryCallable<ListNodeGroupsHttpRequest, ListNodeGroupsPagedResponse>
      listNodeGroupsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listNodeGroupsPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<ListNodeGroupsHttpRequest, NodeGroupList> listNodeGroupsCallable() {
    throw new UnsupportedOperationException("Not implemented: listNodeGroupsCallable()");
  }

  @BetaApi
  public UnaryCallable<ListNodesNodeGroupsHttpRequest, ListNodesNodeGroupsPagedResponse>
      listNodesNodeGroupsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listNodesNodeGroupsPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<ListNodesNodeGroupsHttpRequest, NodeGroupsListNodes>
      listNodesNodeGroupsCallable() {
    throw new UnsupportedOperationException("Not implemented: listNodesNodeGroupsCallable()");
  }

  @BetaApi
  public UnaryCallable<SetIamPolicyNodeGroupHttpRequest, Policy> setIamPolicyNodeGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyNodeGroupCallable()");
  }

  @BetaApi
  public UnaryCallable<SetNodeTemplateNodeGroupHttpRequest, Operation>
      setNodeTemplateNodeGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: setNodeTemplateNodeGroupCallable()");
  }

  @BetaApi
  public UnaryCallable<TestIamPermissionsNodeGroupHttpRequest, TestPermissionsResponse>
      testIamPermissionsNodeGroupCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: testIamPermissionsNodeGroupCallable()");
  }

  @Override
  public abstract void close();
}
