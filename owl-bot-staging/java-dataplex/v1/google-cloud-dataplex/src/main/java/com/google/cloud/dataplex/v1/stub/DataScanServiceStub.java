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

package com.google.cloud.dataplex.v1.stub;

import static com.google.cloud.dataplex.v1.DataScanServiceClient.ListDataScanJobsPagedResponse;
import static com.google.cloud.dataplex.v1.DataScanServiceClient.ListDataScansPagedResponse;
import static com.google.cloud.dataplex.v1.DataScanServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataplex.v1.CreateDataScanRequest;
import com.google.cloud.dataplex.v1.DataScan;
import com.google.cloud.dataplex.v1.DataScanJob;
import com.google.cloud.dataplex.v1.DeleteDataScanRequest;
import com.google.cloud.dataplex.v1.GetDataScanJobRequest;
import com.google.cloud.dataplex.v1.GetDataScanRequest;
import com.google.cloud.dataplex.v1.ListDataScanJobsRequest;
import com.google.cloud.dataplex.v1.ListDataScanJobsResponse;
import com.google.cloud.dataplex.v1.ListDataScansRequest;
import com.google.cloud.dataplex.v1.ListDataScansResponse;
import com.google.cloud.dataplex.v1.OperationMetadata;
import com.google.cloud.dataplex.v1.RunDataScanRequest;
import com.google.cloud.dataplex.v1.RunDataScanResponse;
import com.google.cloud.dataplex.v1.UpdateDataScanRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the DataScanService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class DataScanServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public OperationCallable<CreateDataScanRequest, DataScan, OperationMetadata>
      createDataScanOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createDataScanOperationCallable()");
  }

  public UnaryCallable<CreateDataScanRequest, Operation> createDataScanCallable() {
    throw new UnsupportedOperationException("Not implemented: createDataScanCallable()");
  }

  public OperationCallable<UpdateDataScanRequest, DataScan, OperationMetadata>
      updateDataScanOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDataScanOperationCallable()");
  }

  public UnaryCallable<UpdateDataScanRequest, Operation> updateDataScanCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDataScanCallable()");
  }

  public OperationCallable<DeleteDataScanRequest, Empty, OperationMetadata>
      deleteDataScanOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDataScanOperationCallable()");
  }

  public UnaryCallable<DeleteDataScanRequest, Operation> deleteDataScanCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDataScanCallable()");
  }

  public UnaryCallable<GetDataScanRequest, DataScan> getDataScanCallable() {
    throw new UnsupportedOperationException("Not implemented: getDataScanCallable()");
  }

  public UnaryCallable<ListDataScansRequest, ListDataScansPagedResponse>
      listDataScansPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataScansPagedCallable()");
  }

  public UnaryCallable<ListDataScansRequest, ListDataScansResponse> listDataScansCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataScansCallable()");
  }

  public UnaryCallable<RunDataScanRequest, RunDataScanResponse> runDataScanCallable() {
    throw new UnsupportedOperationException("Not implemented: runDataScanCallable()");
  }

  public UnaryCallable<GetDataScanJobRequest, DataScanJob> getDataScanJobCallable() {
    throw new UnsupportedOperationException("Not implemented: getDataScanJobCallable()");
  }

  public UnaryCallable<ListDataScanJobsRequest, ListDataScanJobsPagedResponse>
      listDataScanJobsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataScanJobsPagedCallable()");
  }

  public UnaryCallable<ListDataScanJobsRequest, ListDataScanJobsResponse>
      listDataScanJobsCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataScanJobsCallable()");
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
