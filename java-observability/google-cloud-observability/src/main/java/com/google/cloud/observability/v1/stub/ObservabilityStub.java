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

package com.google.cloud.observability.v1.stub;

import static com.google.cloud.observability.v1.ObservabilityClient.ListBucketsPagedResponse;
import static com.google.cloud.observability.v1.ObservabilityClient.ListDatasetsPagedResponse;
import static com.google.cloud.observability.v1.ObservabilityClient.ListLinksPagedResponse;
import static com.google.cloud.observability.v1.ObservabilityClient.ListLocationsPagedResponse;
import static com.google.cloud.observability.v1.ObservabilityClient.ListTraceScopesPagedResponse;
import static com.google.cloud.observability.v1.ObservabilityClient.ListViewsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.observability.v1.Bucket;
import com.google.cloud.observability.v1.CreateBucketRequest;
import com.google.cloud.observability.v1.CreateLinkRequest;
import com.google.cloud.observability.v1.CreateTraceScopeRequest;
import com.google.cloud.observability.v1.Dataset;
import com.google.cloud.observability.v1.DeleteLinkRequest;
import com.google.cloud.observability.v1.DeleteTraceScopeRequest;
import com.google.cloud.observability.v1.GetBucketRequest;
import com.google.cloud.observability.v1.GetDatasetRequest;
import com.google.cloud.observability.v1.GetLinkRequest;
import com.google.cloud.observability.v1.GetScopeRequest;
import com.google.cloud.observability.v1.GetSettingsRequest;
import com.google.cloud.observability.v1.GetTraceScopeRequest;
import com.google.cloud.observability.v1.GetViewRequest;
import com.google.cloud.observability.v1.Link;
import com.google.cloud.observability.v1.ListBucketsRequest;
import com.google.cloud.observability.v1.ListBucketsResponse;
import com.google.cloud.observability.v1.ListDatasetsRequest;
import com.google.cloud.observability.v1.ListDatasetsResponse;
import com.google.cloud.observability.v1.ListLinksRequest;
import com.google.cloud.observability.v1.ListLinksResponse;
import com.google.cloud.observability.v1.ListTraceScopesRequest;
import com.google.cloud.observability.v1.ListTraceScopesResponse;
import com.google.cloud.observability.v1.ListViewsRequest;
import com.google.cloud.observability.v1.ListViewsResponse;
import com.google.cloud.observability.v1.OperationMetadata;
import com.google.cloud.observability.v1.Scope;
import com.google.cloud.observability.v1.Settings;
import com.google.cloud.observability.v1.TraceScope;
import com.google.cloud.observability.v1.UpdateBucketRequest;
import com.google.cloud.observability.v1.UpdateLinkRequest;
import com.google.cloud.observability.v1.UpdateScopeRequest;
import com.google.cloud.observability.v1.UpdateSettingsRequest;
import com.google.cloud.observability.v1.UpdateTraceScopeRequest;
import com.google.cloud.observability.v1.View;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Observability service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public abstract class ObservabilityStub implements BackgroundResource {

  public @Nullable OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.@Nullable OperationsStub
      getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<GetScopeRequest, Scope> getScopeCallable() {
    throw new UnsupportedOperationException("Not implemented: getScopeCallable()");
  }

  public UnaryCallable<UpdateScopeRequest, Scope> updateScopeCallable() {
    throw new UnsupportedOperationException("Not implemented: updateScopeCallable()");
  }

  public UnaryCallable<GetBucketRequest, Bucket> getBucketCallable() {
    throw new UnsupportedOperationException("Not implemented: getBucketCallable()");
  }

  public UnaryCallable<ListBucketsRequest, ListBucketsPagedResponse> listBucketsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listBucketsPagedCallable()");
  }

  public UnaryCallable<ListBucketsRequest, ListBucketsResponse> listBucketsCallable() {
    throw new UnsupportedOperationException("Not implemented: listBucketsCallable()");
  }

  public OperationCallable<CreateBucketRequest, Bucket, OperationMetadata>
      createBucketOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createBucketOperationCallable()");
  }

  public UnaryCallable<CreateBucketRequest, Operation> createBucketCallable() {
    throw new UnsupportedOperationException("Not implemented: createBucketCallable()");
  }

  public OperationCallable<UpdateBucketRequest, Bucket, OperationMetadata>
      updateBucketOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateBucketOperationCallable()");
  }

  public UnaryCallable<UpdateBucketRequest, Operation> updateBucketCallable() {
    throw new UnsupportedOperationException("Not implemented: updateBucketCallable()");
  }

  public UnaryCallable<GetDatasetRequest, Dataset> getDatasetCallable() {
    throw new UnsupportedOperationException("Not implemented: getDatasetCallable()");
  }

  public UnaryCallable<ListDatasetsRequest, ListDatasetsPagedResponse> listDatasetsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDatasetsPagedCallable()");
  }

  public UnaryCallable<ListDatasetsRequest, ListDatasetsResponse> listDatasetsCallable() {
    throw new UnsupportedOperationException("Not implemented: listDatasetsCallable()");
  }

  public UnaryCallable<GetViewRequest, View> getViewCallable() {
    throw new UnsupportedOperationException("Not implemented: getViewCallable()");
  }

  public UnaryCallable<ListViewsRequest, ListViewsPagedResponse> listViewsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listViewsPagedCallable()");
  }

  public UnaryCallable<ListViewsRequest, ListViewsResponse> listViewsCallable() {
    throw new UnsupportedOperationException("Not implemented: listViewsCallable()");
  }

  public UnaryCallable<GetLinkRequest, Link> getLinkCallable() {
    throw new UnsupportedOperationException("Not implemented: getLinkCallable()");
  }

  public UnaryCallable<ListLinksRequest, ListLinksPagedResponse> listLinksPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLinksPagedCallable()");
  }

  public UnaryCallable<ListLinksRequest, ListLinksResponse> listLinksCallable() {
    throw new UnsupportedOperationException("Not implemented: listLinksCallable()");
  }

  public OperationCallable<CreateLinkRequest, Link, OperationMetadata>
      createLinkOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createLinkOperationCallable()");
  }

  public UnaryCallable<CreateLinkRequest, Operation> createLinkCallable() {
    throw new UnsupportedOperationException("Not implemented: createLinkCallable()");
  }

  public OperationCallable<UpdateLinkRequest, Link, OperationMetadata>
      updateLinkOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateLinkOperationCallable()");
  }

  public UnaryCallable<UpdateLinkRequest, Operation> updateLinkCallable() {
    throw new UnsupportedOperationException("Not implemented: updateLinkCallable()");
  }

  public OperationCallable<DeleteLinkRequest, Empty, OperationMetadata>
      deleteLinkOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteLinkOperationCallable()");
  }

  public UnaryCallable<DeleteLinkRequest, Operation> deleteLinkCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteLinkCallable()");
  }

  public UnaryCallable<GetTraceScopeRequest, TraceScope> getTraceScopeCallable() {
    throw new UnsupportedOperationException("Not implemented: getTraceScopeCallable()");
  }

  public UnaryCallable<ListTraceScopesRequest, ListTraceScopesPagedResponse>
      listTraceScopesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listTraceScopesPagedCallable()");
  }

  public UnaryCallable<ListTraceScopesRequest, ListTraceScopesResponse> listTraceScopesCallable() {
    throw new UnsupportedOperationException("Not implemented: listTraceScopesCallable()");
  }

  public UnaryCallable<CreateTraceScopeRequest, TraceScope> createTraceScopeCallable() {
    throw new UnsupportedOperationException("Not implemented: createTraceScopeCallable()");
  }

  public UnaryCallable<UpdateTraceScopeRequest, TraceScope> updateTraceScopeCallable() {
    throw new UnsupportedOperationException("Not implemented: updateTraceScopeCallable()");
  }

  public UnaryCallable<DeleteTraceScopeRequest, Empty> deleteTraceScopeCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTraceScopeCallable()");
  }

  public UnaryCallable<GetSettingsRequest, Settings> getSettingsCallable() {
    throw new UnsupportedOperationException("Not implemented: getSettingsCallable()");
  }

  public OperationCallable<UpdateSettingsRequest, Settings, OperationMetadata>
      updateSettingsOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSettingsOperationCallable()");
  }

  public UnaryCallable<UpdateSettingsRequest, Operation> updateSettingsCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSettingsCallable()");
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
