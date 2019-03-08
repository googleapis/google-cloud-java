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

import static com.google.cloud.compute.v1.NodeTypeClient.AggregatedListNodeTypesPagedResponse;
import static com.google.cloud.compute.v1.NodeTypeClient.ListNodeTypesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AggregatedListNodeTypesHttpRequest;
import com.google.cloud.compute.v1.GetNodeTypeHttpRequest;
import com.google.cloud.compute.v1.ListNodeTypesHttpRequest;
import com.google.cloud.compute.v1.NodeType;
import com.google.cloud.compute.v1.NodeTypeAggregatedList;
import com.google.cloud.compute.v1.NodeTypeList;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class NodeTypeStub implements BackgroundResource {

  @BetaApi
  public UnaryCallable<AggregatedListNodeTypesHttpRequest, AggregatedListNodeTypesPagedResponse>
      aggregatedListNodeTypesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: aggregatedListNodeTypesPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<AggregatedListNodeTypesHttpRequest, NodeTypeAggregatedList>
      aggregatedListNodeTypesCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListNodeTypesCallable()");
  }

  @BetaApi
  public UnaryCallable<GetNodeTypeHttpRequest, NodeType> getNodeTypeCallable() {
    throw new UnsupportedOperationException("Not implemented: getNodeTypeCallable()");
  }

  @BetaApi
  public UnaryCallable<ListNodeTypesHttpRequest, ListNodeTypesPagedResponse>
      listNodeTypesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listNodeTypesPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<ListNodeTypesHttpRequest, NodeTypeList> listNodeTypesCallable() {
    throw new UnsupportedOperationException("Not implemented: listNodeTypesCallable()");
  }

  @Override
  public abstract void close();
}
