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

package com.google.cloud.vectorsearch.v1beta.stub;

import static com.google.cloud.vectorsearch.v1beta.DataObjectSearchServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.vectorsearch.v1beta.DataObjectSearchServiceClient.QueryDataObjectsPagedResponse;
import static com.google.cloud.vectorsearch.v1beta.DataObjectSearchServiceClient.SearchDataObjectsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.vectorsearch.v1beta.AggregateDataObjectsRequest;
import com.google.cloud.vectorsearch.v1beta.AggregateDataObjectsResponse;
import com.google.cloud.vectorsearch.v1beta.BatchSearchDataObjectsRequest;
import com.google.cloud.vectorsearch.v1beta.BatchSearchDataObjectsResponse;
import com.google.cloud.vectorsearch.v1beta.QueryDataObjectsRequest;
import com.google.cloud.vectorsearch.v1beta.QueryDataObjectsResponse;
import com.google.cloud.vectorsearch.v1beta.SearchDataObjectsRequest;
import com.google.cloud.vectorsearch.v1beta.SearchDataObjectsResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the DataObjectSearchService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class DataObjectSearchServiceStub implements BackgroundResource {

  public UnaryCallable<SearchDataObjectsRequest, SearchDataObjectsPagedResponse>
      searchDataObjectsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: searchDataObjectsPagedCallable()");
  }

  public UnaryCallable<SearchDataObjectsRequest, SearchDataObjectsResponse>
      searchDataObjectsCallable() {
    throw new UnsupportedOperationException("Not implemented: searchDataObjectsCallable()");
  }

  public UnaryCallable<QueryDataObjectsRequest, QueryDataObjectsPagedResponse>
      queryDataObjectsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: queryDataObjectsPagedCallable()");
  }

  public UnaryCallable<QueryDataObjectsRequest, QueryDataObjectsResponse>
      queryDataObjectsCallable() {
    throw new UnsupportedOperationException("Not implemented: queryDataObjectsCallable()");
  }

  public UnaryCallable<AggregateDataObjectsRequest, AggregateDataObjectsResponse>
      aggregateDataObjectsCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregateDataObjectsCallable()");
  }

  public UnaryCallable<BatchSearchDataObjectsRequest, BatchSearchDataObjectsResponse>
      batchSearchDataObjectsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchSearchDataObjectsCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsPagedCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsCallable()");
  }

  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    throw new UnsupportedOperationException("Not implemented: getLocationCallable()");
  }

  @Override
  public abstract void close();
}
