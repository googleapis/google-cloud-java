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

package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.NetworkAttachmentsClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.NetworkAttachmentsClient.ListPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AggregatedListNetworkAttachmentsRequest;
import com.google.cloud.compute.v1.DeleteNetworkAttachmentRequest;
import com.google.cloud.compute.v1.GetIamPolicyNetworkAttachmentRequest;
import com.google.cloud.compute.v1.GetNetworkAttachmentRequest;
import com.google.cloud.compute.v1.InsertNetworkAttachmentRequest;
import com.google.cloud.compute.v1.ListNetworkAttachmentsRequest;
import com.google.cloud.compute.v1.NetworkAttachment;
import com.google.cloud.compute.v1.NetworkAttachmentAggregatedList;
import com.google.cloud.compute.v1.NetworkAttachmentList;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.SetIamPolicyNetworkAttachmentRequest;
import com.google.cloud.compute.v1.TestIamPermissionsNetworkAttachmentRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the NetworkAttachments service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class NetworkAttachmentsStub implements BackgroundResource {

  public UnaryCallable<AggregatedListNetworkAttachmentsRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListPagedCallable()");
  }

  public UnaryCallable<AggregatedListNetworkAttachmentsRequest, NetworkAttachmentAggregatedList>
      aggregatedListCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListCallable()");
  }

  public OperationCallable<DeleteNetworkAttachmentRequest, Operation, Operation>
      deleteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteOperationCallable()");
  }

  public UnaryCallable<DeleteNetworkAttachmentRequest, Operation> deleteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCallable()");
  }

  public UnaryCallable<GetNetworkAttachmentRequest, NetworkAttachment> getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public UnaryCallable<GetIamPolicyNetworkAttachmentRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public OperationCallable<InsertNetworkAttachmentRequest, Operation, Operation>
      insertOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: insertOperationCallable()");
  }

  public UnaryCallable<InsertNetworkAttachmentRequest, Operation> insertCallable() {
    throw new UnsupportedOperationException("Not implemented: insertCallable()");
  }

  public UnaryCallable<ListNetworkAttachmentsRequest, ListPagedResponse> listPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPagedCallable()");
  }

  public UnaryCallable<ListNetworkAttachmentsRequest, NetworkAttachmentList> listCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallable()");
  }

  public UnaryCallable<SetIamPolicyNetworkAttachmentRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<TestIamPermissionsNetworkAttachmentRequest, TestPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
