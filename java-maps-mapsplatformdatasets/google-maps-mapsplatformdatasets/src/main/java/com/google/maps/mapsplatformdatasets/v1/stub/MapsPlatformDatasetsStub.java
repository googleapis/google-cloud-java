/*
 * Copyright 2024 Google LLC
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

package com.google.maps.mapsplatformdatasets.v1.stub;

import static com.google.maps.mapsplatformdatasets.v1.MapsPlatformDatasetsClient.ListDatasetsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.maps.mapsplatformdatasets.v1.CreateDatasetRequest;
import com.google.maps.mapsplatformdatasets.v1.Dataset;
import com.google.maps.mapsplatformdatasets.v1.DeleteDatasetRequest;
import com.google.maps.mapsplatformdatasets.v1.GetDatasetRequest;
import com.google.maps.mapsplatformdatasets.v1.ListDatasetsRequest;
import com.google.maps.mapsplatformdatasets.v1.ListDatasetsResponse;
import com.google.maps.mapsplatformdatasets.v1.UpdateDatasetMetadataRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the MapsPlatformDatasets service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class MapsPlatformDatasetsStub implements BackgroundResource {

  public UnaryCallable<CreateDatasetRequest, Dataset> createDatasetCallable() {
    throw new UnsupportedOperationException("Not implemented: createDatasetCallable()");
  }

  public UnaryCallable<UpdateDatasetMetadataRequest, Dataset> updateDatasetMetadataCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDatasetMetadataCallable()");
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

  public UnaryCallable<DeleteDatasetRequest, Empty> deleteDatasetCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDatasetCallable()");
  }

  @Override
  public abstract void close();
}
