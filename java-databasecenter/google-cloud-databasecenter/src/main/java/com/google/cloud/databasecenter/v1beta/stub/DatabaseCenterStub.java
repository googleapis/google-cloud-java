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

package com.google.cloud.databasecenter.v1beta.stub;

import static com.google.cloud.databasecenter.v1beta.DatabaseCenterClient.AggregateFleetPagedResponse;
import static com.google.cloud.databasecenter.v1beta.DatabaseCenterClient.QueryDatabaseResourceGroupsPagedResponse;
import static com.google.cloud.databasecenter.v1beta.DatabaseCenterClient.QueryIssuesPagedResponse;
import static com.google.cloud.databasecenter.v1beta.DatabaseCenterClient.QueryProductsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.databasecenter.v1beta.AggregateFleetRequest;
import com.google.cloud.databasecenter.v1beta.AggregateFleetResponse;
import com.google.cloud.databasecenter.v1beta.AggregateIssueStatsRequest;
import com.google.cloud.databasecenter.v1beta.AggregateIssueStatsResponse;
import com.google.cloud.databasecenter.v1beta.QueryDatabaseResourceGroupsRequest;
import com.google.cloud.databasecenter.v1beta.QueryDatabaseResourceGroupsResponse;
import com.google.cloud.databasecenter.v1beta.QueryIssuesRequest;
import com.google.cloud.databasecenter.v1beta.QueryIssuesResponse;
import com.google.cloud.databasecenter.v1beta.QueryProductsRequest;
import com.google.cloud.databasecenter.v1beta.QueryProductsResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the DatabaseCenter service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class DatabaseCenterStub implements BackgroundResource {

  public UnaryCallable<QueryProductsRequest, QueryProductsPagedResponse>
      queryProductsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: queryProductsPagedCallable()");
  }

  public UnaryCallable<QueryProductsRequest, QueryProductsResponse> queryProductsCallable() {
    throw new UnsupportedOperationException("Not implemented: queryProductsCallable()");
  }

  public UnaryCallable<AggregateFleetRequest, AggregateFleetPagedResponse>
      aggregateFleetPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregateFleetPagedCallable()");
  }

  public UnaryCallable<AggregateFleetRequest, AggregateFleetResponse> aggregateFleetCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregateFleetCallable()");
  }

  public UnaryCallable<QueryDatabaseResourceGroupsRequest, QueryDatabaseResourceGroupsPagedResponse>
      queryDatabaseResourceGroupsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: queryDatabaseResourceGroupsPagedCallable()");
  }

  public UnaryCallable<QueryDatabaseResourceGroupsRequest, QueryDatabaseResourceGroupsResponse>
      queryDatabaseResourceGroupsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: queryDatabaseResourceGroupsCallable()");
  }

  public UnaryCallable<AggregateIssueStatsRequest, AggregateIssueStatsResponse>
      aggregateIssueStatsCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregateIssueStatsCallable()");
  }

  public UnaryCallable<QueryIssuesRequest, QueryIssuesPagedResponse> queryIssuesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: queryIssuesPagedCallable()");
  }

  public UnaryCallable<QueryIssuesRequest, QueryIssuesResponse> queryIssuesCallable() {
    throw new UnsupportedOperationException("Not implemented: queryIssuesCallable()");
  }

  @Override
  public abstract void close();
}
