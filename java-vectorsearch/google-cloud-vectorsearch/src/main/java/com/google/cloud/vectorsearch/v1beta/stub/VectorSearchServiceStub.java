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

package com.google.cloud.vectorsearch.v1beta.stub;

import static com.google.cloud.vectorsearch.v1beta.VectorSearchServiceClient.ListCollectionsPagedResponse;
import static com.google.cloud.vectorsearch.v1beta.VectorSearchServiceClient.ListIndexesPagedResponse;
import static com.google.cloud.vectorsearch.v1beta.VectorSearchServiceClient.ListLocationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.vectorsearch.v1beta.Collection;
import com.google.cloud.vectorsearch.v1beta.CreateCollectionRequest;
import com.google.cloud.vectorsearch.v1beta.CreateIndexRequest;
import com.google.cloud.vectorsearch.v1beta.DeleteCollectionRequest;
import com.google.cloud.vectorsearch.v1beta.DeleteIndexRequest;
import com.google.cloud.vectorsearch.v1beta.ExportDataObjectsMetadata;
import com.google.cloud.vectorsearch.v1beta.ExportDataObjectsRequest;
import com.google.cloud.vectorsearch.v1beta.ExportDataObjectsResponse;
import com.google.cloud.vectorsearch.v1beta.GetCollectionRequest;
import com.google.cloud.vectorsearch.v1beta.GetIndexRequest;
import com.google.cloud.vectorsearch.v1beta.ImportDataObjectsMetadata;
import com.google.cloud.vectorsearch.v1beta.ImportDataObjectsRequest;
import com.google.cloud.vectorsearch.v1beta.ImportDataObjectsResponse;
import com.google.cloud.vectorsearch.v1beta.Index;
import com.google.cloud.vectorsearch.v1beta.ListCollectionsRequest;
import com.google.cloud.vectorsearch.v1beta.ListCollectionsResponse;
import com.google.cloud.vectorsearch.v1beta.ListIndexesRequest;
import com.google.cloud.vectorsearch.v1beta.ListIndexesResponse;
import com.google.cloud.vectorsearch.v1beta.OperationMetadata;
import com.google.cloud.vectorsearch.v1beta.UpdateCollectionRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the VectorSearchService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class VectorSearchServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListCollectionsRequest, ListCollectionsPagedResponse>
      listCollectionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listCollectionsPagedCallable()");
  }

  public UnaryCallable<ListCollectionsRequest, ListCollectionsResponse> listCollectionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listCollectionsCallable()");
  }

  public UnaryCallable<GetCollectionRequest, Collection> getCollectionCallable() {
    throw new UnsupportedOperationException("Not implemented: getCollectionCallable()");
  }

  public OperationCallable<CreateCollectionRequest, Collection, OperationMetadata>
      createCollectionOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createCollectionOperationCallable()");
  }

  public UnaryCallable<CreateCollectionRequest, Operation> createCollectionCallable() {
    throw new UnsupportedOperationException("Not implemented: createCollectionCallable()");
  }

  public OperationCallable<UpdateCollectionRequest, Collection, OperationMetadata>
      updateCollectionOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCollectionOperationCallable()");
  }

  public UnaryCallable<UpdateCollectionRequest, Operation> updateCollectionCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCollectionCallable()");
  }

  public OperationCallable<DeleteCollectionRequest, Empty, OperationMetadata>
      deleteCollectionOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCollectionOperationCallable()");
  }

  public UnaryCallable<DeleteCollectionRequest, Operation> deleteCollectionCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCollectionCallable()");
  }

  public UnaryCallable<ListIndexesRequest, ListIndexesPagedResponse> listIndexesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listIndexesPagedCallable()");
  }

  public UnaryCallable<ListIndexesRequest, ListIndexesResponse> listIndexesCallable() {
    throw new UnsupportedOperationException("Not implemented: listIndexesCallable()");
  }

  public UnaryCallable<GetIndexRequest, Index> getIndexCallable() {
    throw new UnsupportedOperationException("Not implemented: getIndexCallable()");
  }

  public OperationCallable<CreateIndexRequest, Index, OperationMetadata>
      createIndexOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createIndexOperationCallable()");
  }

  public UnaryCallable<CreateIndexRequest, Operation> createIndexCallable() {
    throw new UnsupportedOperationException("Not implemented: createIndexCallable()");
  }

  public OperationCallable<DeleteIndexRequest, Empty, OperationMetadata>
      deleteIndexOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteIndexOperationCallable()");
  }

  public UnaryCallable<DeleteIndexRequest, Operation> deleteIndexCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteIndexCallable()");
  }

  public OperationCallable<
          ImportDataObjectsRequest, ImportDataObjectsResponse, ImportDataObjectsMetadata>
      importDataObjectsOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: importDataObjectsOperationCallable()");
  }

  public UnaryCallable<ImportDataObjectsRequest, Operation> importDataObjectsCallable() {
    throw new UnsupportedOperationException("Not implemented: importDataObjectsCallable()");
  }

  public OperationCallable<
          ExportDataObjectsRequest, ExportDataObjectsResponse, ExportDataObjectsMetadata>
      exportDataObjectsOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: exportDataObjectsOperationCallable()");
  }

  public UnaryCallable<ExportDataObjectsRequest, Operation> exportDataObjectsCallable() {
    throw new UnsupportedOperationException("Not implemented: exportDataObjectsCallable()");
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
