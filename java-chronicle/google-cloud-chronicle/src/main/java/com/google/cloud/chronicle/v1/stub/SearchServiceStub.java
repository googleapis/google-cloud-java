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

package com.google.cloud.chronicle.v1.stub;

import static com.google.cloud.chronicle.v1.SearchServiceClient.ListSearchedResultsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.chronicle.v1.ListSearchedResultsRequest;
import com.google.cloud.chronicle.v1.ListSearchedResultsResponse;
import com.google.cloud.chronicle.v1.SearchOperationMetadata;
import com.google.cloud.chronicle.v1.SearchRequest;
import com.google.cloud.chronicle.v1.SearchSession;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the SearchService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public abstract class SearchServiceStub implements BackgroundResource {

  public @Nullable OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.@Nullable OperationsStub
      getHttpJsonOperationsStub() {
    return null;
  }

  public OperationCallable<SearchRequest, SearchSession, SearchOperationMetadata>
      searchOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: searchOperationCallable()");
  }

  public UnaryCallable<SearchRequest, Operation> searchCallable() {
    throw new UnsupportedOperationException("Not implemented: searchCallable()");
  }

  public UnaryCallable<ListSearchedResultsRequest, ListSearchedResultsPagedResponse>
      listSearchedResultsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSearchedResultsPagedCallable()");
  }

  public UnaryCallable<ListSearchedResultsRequest, ListSearchedResultsResponse>
      listSearchedResultsCallable() {
    throw new UnsupportedOperationException("Not implemented: listSearchedResultsCallable()");
  }

  @Override
  public abstract void close();
}
