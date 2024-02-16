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

package com.google.maps.mapsplatformdatasets.v1alpha.stub;

import static com.google.maps.mapsplatformdatasets.v1alpha.MapsPlatformDatasetsV1AlphaClient.ListDatasetVersionsPagedResponse;
import static com.google.maps.mapsplatformdatasets.v1alpha.MapsPlatformDatasetsV1AlphaClient.ListDatasetsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.maps.mapsplatformdatasets.v1alpha.CreateDatasetRequest;
import com.google.maps.mapsplatformdatasets.v1alpha.Dataset;
import com.google.maps.mapsplatformdatasets.v1alpha.DeleteDatasetRequest;
import com.google.maps.mapsplatformdatasets.v1alpha.DeleteDatasetVersionRequest;
import com.google.maps.mapsplatformdatasets.v1alpha.GetDatasetRequest;
import com.google.maps.mapsplatformdatasets.v1alpha.ListDatasetVersionsRequest;
import com.google.maps.mapsplatformdatasets.v1alpha.ListDatasetVersionsResponse;
import com.google.maps.mapsplatformdatasets.v1alpha.ListDatasetsRequest;
import com.google.maps.mapsplatformdatasets.v1alpha.ListDatasetsResponse;
import com.google.maps.mapsplatformdatasets.v1alpha.UpdateDatasetMetadataRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the MapsPlatformDatasetsV1Alpha service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class MapsPlatformDatasetsV1AlphaStub implements BackgroundResource {

  public UnaryCallable<CreateDatasetRequest, Dataset> createDatasetCallable() {
    throw new UnsupportedOperationException("Not implemented: createDatasetCallable()");
  }

  public UnaryCallable<UpdateDatasetMetadataRequest, Dataset> updateDatasetMetadataCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDatasetMetadataCallable()");
  }

  public UnaryCallable<GetDatasetRequest, Dataset> getDatasetCallable() {
    throw new UnsupportedOperationException("Not implemented: getDatasetCallable()");
  }

  public UnaryCallable<ListDatasetVersionsRequest, ListDatasetVersionsPagedResponse>
      listDatasetVersionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDatasetVersionsPagedCallable()");
  }

  public UnaryCallable<ListDatasetVersionsRequest, ListDatasetVersionsResponse>
      listDatasetVersionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listDatasetVersionsCallable()");
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

  public UnaryCallable<DeleteDatasetVersionRequest, Empty> deleteDatasetVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDatasetVersionCallable()");
  }

  @Override
  public abstract void close();
}
