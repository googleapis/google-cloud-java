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

package com.google.cloud.dataplex.v1.stub;

import static com.google.cloud.dataplex.v1.DataProductServiceClient.ListDataAssetsPagedResponse;
import static com.google.cloud.dataplex.v1.DataProductServiceClient.ListDataProductsPagedResponse;
import static com.google.cloud.dataplex.v1.DataProductServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataplex.v1.CreateDataAssetRequest;
import com.google.cloud.dataplex.v1.CreateDataProductRequest;
import com.google.cloud.dataplex.v1.DataAsset;
import com.google.cloud.dataplex.v1.DataProduct;
import com.google.cloud.dataplex.v1.DeleteDataAssetRequest;
import com.google.cloud.dataplex.v1.DeleteDataProductRequest;
import com.google.cloud.dataplex.v1.GetDataAssetRequest;
import com.google.cloud.dataplex.v1.GetDataProductRequest;
import com.google.cloud.dataplex.v1.ListDataAssetsRequest;
import com.google.cloud.dataplex.v1.ListDataAssetsResponse;
import com.google.cloud.dataplex.v1.ListDataProductsRequest;
import com.google.cloud.dataplex.v1.ListDataProductsResponse;
import com.google.cloud.dataplex.v1.OperationMetadata;
import com.google.cloud.dataplex.v1.UpdateDataAssetRequest;
import com.google.cloud.dataplex.v1.UpdateDataProductRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the DataProductService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class DataProductServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public OperationCallable<CreateDataProductRequest, DataProduct, OperationMetadata>
      createDataProductOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createDataProductOperationCallable()");
  }

  public UnaryCallable<CreateDataProductRequest, Operation> createDataProductCallable() {
    throw new UnsupportedOperationException("Not implemented: createDataProductCallable()");
  }

  public OperationCallable<DeleteDataProductRequest, Empty, OperationMetadata>
      deleteDataProductOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteDataProductOperationCallable()");
  }

  public UnaryCallable<DeleteDataProductRequest, Operation> deleteDataProductCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDataProductCallable()");
  }

  public UnaryCallable<GetDataProductRequest, DataProduct> getDataProductCallable() {
    throw new UnsupportedOperationException("Not implemented: getDataProductCallable()");
  }

  public UnaryCallable<ListDataProductsRequest, ListDataProductsPagedResponse>
      listDataProductsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataProductsPagedCallable()");
  }

  public UnaryCallable<ListDataProductsRequest, ListDataProductsResponse>
      listDataProductsCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataProductsCallable()");
  }

  public OperationCallable<UpdateDataProductRequest, DataProduct, OperationMetadata>
      updateDataProductOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateDataProductOperationCallable()");
  }

  public UnaryCallable<UpdateDataProductRequest, Operation> updateDataProductCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDataProductCallable()");
  }

  public OperationCallable<CreateDataAssetRequest, DataAsset, OperationMetadata>
      createDataAssetOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createDataAssetOperationCallable()");
  }

  public UnaryCallable<CreateDataAssetRequest, Operation> createDataAssetCallable() {
    throw new UnsupportedOperationException("Not implemented: createDataAssetCallable()");
  }

  public OperationCallable<UpdateDataAssetRequest, DataAsset, OperationMetadata>
      updateDataAssetOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDataAssetOperationCallable()");
  }

  public UnaryCallable<UpdateDataAssetRequest, Operation> updateDataAssetCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDataAssetCallable()");
  }

  public OperationCallable<DeleteDataAssetRequest, Empty, OperationMetadata>
      deleteDataAssetOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDataAssetOperationCallable()");
  }

  public UnaryCallable<DeleteDataAssetRequest, Operation> deleteDataAssetCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDataAssetCallable()");
  }

  public UnaryCallable<GetDataAssetRequest, DataAsset> getDataAssetCallable() {
    throw new UnsupportedOperationException("Not implemented: getDataAssetCallable()");
  }

  public UnaryCallable<ListDataAssetsRequest, ListDataAssetsPagedResponse>
      listDataAssetsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataAssetsPagedCallable()");
  }

  public UnaryCallable<ListDataAssetsRequest, ListDataAssetsResponse> listDataAssetsCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataAssetsCallable()");
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

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
