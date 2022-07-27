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

import static com.google.cloud.compute.v1.NodeTypesClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.NodeTypesClient.ListPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AggregatedListNodeTypesRequest;
import com.google.cloud.compute.v1.GetNodeTypeRequest;
import com.google.cloud.compute.v1.ListNodeTypesRequest;
import com.google.cloud.compute.v1.NodeType;
import com.google.cloud.compute.v1.NodeTypeAggregatedList;
import com.google.cloud.compute.v1.NodeTypeList;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the NodeTypes service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class NodeTypesStub implements BackgroundResource {

  public UnaryCallable<AggregatedListNodeTypesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListPagedCallable()");
  }

  public UnaryCallable<AggregatedListNodeTypesRequest, NodeTypeAggregatedList>
      aggregatedListCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListCallable()");
  }

  public UnaryCallable<GetNodeTypeRequest, NodeType> getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public UnaryCallable<ListNodeTypesRequest, ListPagedResponse> listPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPagedCallable()");
  }

  public UnaryCallable<ListNodeTypesRequest, NodeTypeList> listCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallable()");
  }

  @Override
  public abstract void close();
}
