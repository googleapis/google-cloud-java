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

import static com.google.cloud.compute.v1.ServiceAttachmentsClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.ServiceAttachmentsClient.ListPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AggregatedListServiceAttachmentsRequest;
import com.google.cloud.compute.v1.DeleteServiceAttachmentRequest;
import com.google.cloud.compute.v1.GetIamPolicyServiceAttachmentRequest;
import com.google.cloud.compute.v1.GetServiceAttachmentRequest;
import com.google.cloud.compute.v1.InsertServiceAttachmentRequest;
import com.google.cloud.compute.v1.ListServiceAttachmentsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchServiceAttachmentRequest;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.ServiceAttachment;
import com.google.cloud.compute.v1.ServiceAttachmentAggregatedList;
import com.google.cloud.compute.v1.ServiceAttachmentList;
import com.google.cloud.compute.v1.SetIamPolicyServiceAttachmentRequest;
import com.google.cloud.compute.v1.TestIamPermissionsServiceAttachmentRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ServiceAttachments service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ServiceAttachmentsStub implements BackgroundResource {

  public UnaryCallable<AggregatedListServiceAttachmentsRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListPagedCallable()");
  }

  public UnaryCallable<AggregatedListServiceAttachmentsRequest, ServiceAttachmentAggregatedList>
      aggregatedListCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListCallable()");
  }

  public OperationCallable<DeleteServiceAttachmentRequest, Operation, Operation>
      deleteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteOperationCallable()");
  }

  public UnaryCallable<DeleteServiceAttachmentRequest, Operation> deleteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCallable()");
  }

  public UnaryCallable<GetServiceAttachmentRequest, ServiceAttachment> getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public UnaryCallable<GetIamPolicyServiceAttachmentRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public OperationCallable<InsertServiceAttachmentRequest, Operation, Operation>
      insertOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: insertOperationCallable()");
  }

  public UnaryCallable<InsertServiceAttachmentRequest, Operation> insertCallable() {
    throw new UnsupportedOperationException("Not implemented: insertCallable()");
  }

  public UnaryCallable<ListServiceAttachmentsRequest, ListPagedResponse> listPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPagedCallable()");
  }

  public UnaryCallable<ListServiceAttachmentsRequest, ServiceAttachmentList> listCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallable()");
  }

  public OperationCallable<PatchServiceAttachmentRequest, Operation, Operation>
      patchOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: patchOperationCallable()");
  }

  public UnaryCallable<PatchServiceAttachmentRequest, Operation> patchCallable() {
    throw new UnsupportedOperationException("Not implemented: patchCallable()");
  }

  public UnaryCallable<SetIamPolicyServiceAttachmentRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<TestIamPermissionsServiceAttachmentRequest, TestPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
