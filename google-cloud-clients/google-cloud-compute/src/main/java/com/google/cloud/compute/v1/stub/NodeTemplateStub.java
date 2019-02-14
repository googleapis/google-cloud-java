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

import static com.google.cloud.compute.v1.NodeTemplateClient.AggregatedListNodeTemplatesPagedResponse;
import static com.google.cloud.compute.v1.NodeTemplateClient.ListNodeTemplatesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AggregatedListNodeTemplatesHttpRequest;
import com.google.cloud.compute.v1.DeleteNodeTemplateHttpRequest;
import com.google.cloud.compute.v1.GetIamPolicyNodeTemplateHttpRequest;
import com.google.cloud.compute.v1.GetNodeTemplateHttpRequest;
import com.google.cloud.compute.v1.InsertNodeTemplateHttpRequest;
import com.google.cloud.compute.v1.ListNodeTemplatesHttpRequest;
import com.google.cloud.compute.v1.NodeTemplate;
import com.google.cloud.compute.v1.NodeTemplateAggregatedList;
import com.google.cloud.compute.v1.NodeTemplateList;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.SetIamPolicyNodeTemplateHttpRequest;
import com.google.cloud.compute.v1.TestIamPermissionsNodeTemplateHttpRequest;
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
public abstract class NodeTemplateStub implements BackgroundResource {

  @BetaApi
  public UnaryCallable<
          AggregatedListNodeTemplatesHttpRequest, AggregatedListNodeTemplatesPagedResponse>
      aggregatedListNodeTemplatesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: aggregatedListNodeTemplatesPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<AggregatedListNodeTemplatesHttpRequest, NodeTemplateAggregatedList>
      aggregatedListNodeTemplatesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: aggregatedListNodeTemplatesCallable()");
  }

  @BetaApi
  public UnaryCallable<DeleteNodeTemplateHttpRequest, Operation> deleteNodeTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteNodeTemplateCallable()");
  }

  @BetaApi
  public UnaryCallable<GetNodeTemplateHttpRequest, NodeTemplate> getNodeTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: getNodeTemplateCallable()");
  }

  @BetaApi
  public UnaryCallable<GetIamPolicyNodeTemplateHttpRequest, Policy>
      getIamPolicyNodeTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyNodeTemplateCallable()");
  }

  @BetaApi
  public UnaryCallable<InsertNodeTemplateHttpRequest, Operation> insertNodeTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: insertNodeTemplateCallable()");
  }

  @BetaApi
  public UnaryCallable<ListNodeTemplatesHttpRequest, ListNodeTemplatesPagedResponse>
      listNodeTemplatesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listNodeTemplatesPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<ListNodeTemplatesHttpRequest, NodeTemplateList> listNodeTemplatesCallable() {
    throw new UnsupportedOperationException("Not implemented: listNodeTemplatesCallable()");
  }

  @BetaApi
  public UnaryCallable<SetIamPolicyNodeTemplateHttpRequest, Policy>
      setIamPolicyNodeTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyNodeTemplateCallable()");
  }

  @BetaApi
  public UnaryCallable<TestIamPermissionsNodeTemplateHttpRequest, TestPermissionsResponse>
      testIamPermissionsNodeTemplateCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: testIamPermissionsNodeTemplateCallable()");
  }

  @Override
  public abstract void close();
}
