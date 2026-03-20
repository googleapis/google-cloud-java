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

package com.google.cloud.vectorsearch.v1.stub;

import static com.google.cloud.vectorsearch.v1.DataObjectServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.vectorsearch.v1.BatchCreateDataObjectsRequest;
import com.google.cloud.vectorsearch.v1.BatchCreateDataObjectsResponse;
import com.google.cloud.vectorsearch.v1.BatchDeleteDataObjectsRequest;
import com.google.cloud.vectorsearch.v1.BatchUpdateDataObjectsRequest;
import com.google.cloud.vectorsearch.v1.BatchUpdateDataObjectsResponse;
import com.google.cloud.vectorsearch.v1.CreateDataObjectRequest;
import com.google.cloud.vectorsearch.v1.DataObject;
import com.google.cloud.vectorsearch.v1.DeleteDataObjectRequest;
import com.google.cloud.vectorsearch.v1.GetDataObjectRequest;
import com.google.cloud.vectorsearch.v1.UpdateDataObjectRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the DataObjectService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class DataObjectServiceStub implements BackgroundResource {

  public UnaryCallable<CreateDataObjectRequest, DataObject> createDataObjectCallable() {
    throw new UnsupportedOperationException("Not implemented: createDataObjectCallable()");
  }

  public UnaryCallable<BatchCreateDataObjectsRequest, BatchCreateDataObjectsResponse>
      batchCreateDataObjectsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchCreateDataObjectsCallable()");
  }

  public UnaryCallable<GetDataObjectRequest, DataObject> getDataObjectCallable() {
    throw new UnsupportedOperationException("Not implemented: getDataObjectCallable()");
  }

  public UnaryCallable<UpdateDataObjectRequest, DataObject> updateDataObjectCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDataObjectCallable()");
  }

  public UnaryCallable<BatchUpdateDataObjectsRequest, BatchUpdateDataObjectsResponse>
      batchUpdateDataObjectsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchUpdateDataObjectsCallable()");
  }

  public UnaryCallable<DeleteDataObjectRequest, Empty> deleteDataObjectCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDataObjectCallable()");
  }

  public UnaryCallable<BatchDeleteDataObjectsRequest, Empty> batchDeleteDataObjectsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchDeleteDataObjectsCallable()");
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
