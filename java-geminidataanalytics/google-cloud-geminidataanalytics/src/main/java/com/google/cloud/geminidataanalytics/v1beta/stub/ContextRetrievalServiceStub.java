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

package com.google.cloud.geminidataanalytics.v1beta.stub;

import static com.google.cloud.geminidataanalytics.v1beta.ContextRetrievalServiceClient.ListLocationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryRecentRelevantTablesRequest;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryRecentRelevantTablesResponse;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextRequest;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextResponse;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextsFromRecentTablesRequest;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextsFromRecentTablesResponse;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextsRequest;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextsResponse;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableSuggestedDescriptionsRequest;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableSuggestedDescriptionsResponse;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableSuggestedExamplesRequest;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableSuggestedExamplesResponse;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ContextRetrievalService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class ContextRetrievalServiceStub implements BackgroundResource {

  public UnaryCallable<RetrieveBigQueryTableContextRequest, RetrieveBigQueryTableContextResponse>
      retrieveBigQueryTableContextCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: retrieveBigQueryTableContextCallable()");
  }

  public UnaryCallable<RetrieveBigQueryTableContextsRequest, RetrieveBigQueryTableContextsResponse>
      retrieveBigQueryTableContextsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: retrieveBigQueryTableContextsCallable()");
  }

  public UnaryCallable<
          RetrieveBigQueryTableContextsFromRecentTablesRequest,
          RetrieveBigQueryTableContextsFromRecentTablesResponse>
      retrieveBigQueryTableContextsFromRecentTablesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: retrieveBigQueryTableContextsFromRecentTablesCallable()");
  }

  public UnaryCallable<
          RetrieveBigQueryTableSuggestedDescriptionsRequest,
          RetrieveBigQueryTableSuggestedDescriptionsResponse>
      retrieveBigQueryTableSuggestedDescriptionsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: retrieveBigQueryTableSuggestedDescriptionsCallable()");
  }

  public UnaryCallable<
          RetrieveBigQueryTableSuggestedExamplesRequest,
          RetrieveBigQueryTableSuggestedExamplesResponse>
      retrieveBigQueryTableSuggestedExamplesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: retrieveBigQueryTableSuggestedExamplesCallable()");
  }

  public UnaryCallable<
          RetrieveBigQueryRecentRelevantTablesRequest, RetrieveBigQueryRecentRelevantTablesResponse>
      retrieveBigQueryRecentRelevantTablesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: retrieveBigQueryRecentRelevantTablesCallable()");
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
