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

package com.google.cloud.dataplex.v1.stub;

import static com.google.cloud.dataplex.v1.DataTaxonomyServiceClient.ListDataAttributeBindingsPagedResponse;
import static com.google.cloud.dataplex.v1.DataTaxonomyServiceClient.ListDataAttributesPagedResponse;
import static com.google.cloud.dataplex.v1.DataTaxonomyServiceClient.ListDataTaxonomiesPagedResponse;
import static com.google.cloud.dataplex.v1.DataTaxonomyServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataplex.v1.CreateDataAttributeBindingRequest;
import com.google.cloud.dataplex.v1.CreateDataAttributeRequest;
import com.google.cloud.dataplex.v1.CreateDataTaxonomyRequest;
import com.google.cloud.dataplex.v1.DataAttribute;
import com.google.cloud.dataplex.v1.DataAttributeBinding;
import com.google.cloud.dataplex.v1.DataTaxonomy;
import com.google.cloud.dataplex.v1.DeleteDataAttributeBindingRequest;
import com.google.cloud.dataplex.v1.DeleteDataAttributeRequest;
import com.google.cloud.dataplex.v1.DeleteDataTaxonomyRequest;
import com.google.cloud.dataplex.v1.GetDataAttributeBindingRequest;
import com.google.cloud.dataplex.v1.GetDataAttributeRequest;
import com.google.cloud.dataplex.v1.GetDataTaxonomyRequest;
import com.google.cloud.dataplex.v1.ListDataAttributeBindingsRequest;
import com.google.cloud.dataplex.v1.ListDataAttributeBindingsResponse;
import com.google.cloud.dataplex.v1.ListDataAttributesRequest;
import com.google.cloud.dataplex.v1.ListDataAttributesResponse;
import com.google.cloud.dataplex.v1.ListDataTaxonomiesRequest;
import com.google.cloud.dataplex.v1.ListDataTaxonomiesResponse;
import com.google.cloud.dataplex.v1.OperationMetadata;
import com.google.cloud.dataplex.v1.UpdateDataAttributeBindingRequest;
import com.google.cloud.dataplex.v1.UpdateDataAttributeRequest;
import com.google.cloud.dataplex.v1.UpdateDataTaxonomyRequest;
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
 * Base stub class for the DataTaxonomyService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 *
 * @deprecated This class is deprecated and will be removed in the next major version update.
 */
@Deprecated
@Generated("by gapic-generator-java")
public abstract class DataTaxonomyServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  @Deprecated
  public OperationCallable<CreateDataTaxonomyRequest, DataTaxonomy, OperationMetadata>
      createDataTaxonomyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createDataTaxonomyOperationCallable()");
  }

  @Deprecated
  public UnaryCallable<CreateDataTaxonomyRequest, Operation> createDataTaxonomyCallable() {
    throw new UnsupportedOperationException("Not implemented: createDataTaxonomyCallable()");
  }

  @Deprecated
  public OperationCallable<UpdateDataTaxonomyRequest, DataTaxonomy, OperationMetadata>
      updateDataTaxonomyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateDataTaxonomyOperationCallable()");
  }

  @Deprecated
  public UnaryCallable<UpdateDataTaxonomyRequest, Operation> updateDataTaxonomyCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDataTaxonomyCallable()");
  }

  @Deprecated
  public OperationCallable<DeleteDataTaxonomyRequest, Empty, OperationMetadata>
      deleteDataTaxonomyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteDataTaxonomyOperationCallable()");
  }

  @Deprecated
  public UnaryCallable<DeleteDataTaxonomyRequest, Operation> deleteDataTaxonomyCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDataTaxonomyCallable()");
  }

  @Deprecated
  public UnaryCallable<ListDataTaxonomiesRequest, ListDataTaxonomiesPagedResponse>
      listDataTaxonomiesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataTaxonomiesPagedCallable()");
  }

  @Deprecated
  public UnaryCallable<ListDataTaxonomiesRequest, ListDataTaxonomiesResponse>
      listDataTaxonomiesCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataTaxonomiesCallable()");
  }

  @Deprecated
  public UnaryCallable<GetDataTaxonomyRequest, DataTaxonomy> getDataTaxonomyCallable() {
    throw new UnsupportedOperationException("Not implemented: getDataTaxonomyCallable()");
  }

  @Deprecated
  public OperationCallable<
          CreateDataAttributeBindingRequest, DataAttributeBinding, OperationMetadata>
      createDataAttributeBindingOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createDataAttributeBindingOperationCallable()");
  }

  @Deprecated
  public UnaryCallable<CreateDataAttributeBindingRequest, Operation>
      createDataAttributeBindingCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createDataAttributeBindingCallable()");
  }

  @Deprecated
  public OperationCallable<
          UpdateDataAttributeBindingRequest, DataAttributeBinding, OperationMetadata>
      updateDataAttributeBindingOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateDataAttributeBindingOperationCallable()");
  }

  @Deprecated
  public UnaryCallable<UpdateDataAttributeBindingRequest, Operation>
      updateDataAttributeBindingCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateDataAttributeBindingCallable()");
  }

  @Deprecated
  public OperationCallable<DeleteDataAttributeBindingRequest, Empty, OperationMetadata>
      deleteDataAttributeBindingOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteDataAttributeBindingOperationCallable()");
  }

  @Deprecated
  public UnaryCallable<DeleteDataAttributeBindingRequest, Operation>
      deleteDataAttributeBindingCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteDataAttributeBindingCallable()");
  }

  @Deprecated
  public UnaryCallable<ListDataAttributeBindingsRequest, ListDataAttributeBindingsPagedResponse>
      listDataAttributeBindingsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listDataAttributeBindingsPagedCallable()");
  }

  @Deprecated
  public UnaryCallable<ListDataAttributeBindingsRequest, ListDataAttributeBindingsResponse>
      listDataAttributeBindingsCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataAttributeBindingsCallable()");
  }

  @Deprecated
  public UnaryCallable<GetDataAttributeBindingRequest, DataAttributeBinding>
      getDataAttributeBindingCallable() {
    throw new UnsupportedOperationException("Not implemented: getDataAttributeBindingCallable()");
  }

  @Deprecated
  public OperationCallable<CreateDataAttributeRequest, DataAttribute, OperationMetadata>
      createDataAttributeOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createDataAttributeOperationCallable()");
  }

  @Deprecated
  public UnaryCallable<CreateDataAttributeRequest, Operation> createDataAttributeCallable() {
    throw new UnsupportedOperationException("Not implemented: createDataAttributeCallable()");
  }

  @Deprecated
  public OperationCallable<UpdateDataAttributeRequest, DataAttribute, OperationMetadata>
      updateDataAttributeOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateDataAttributeOperationCallable()");
  }

  @Deprecated
  public UnaryCallable<UpdateDataAttributeRequest, Operation> updateDataAttributeCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDataAttributeCallable()");
  }

  @Deprecated
  public OperationCallable<DeleteDataAttributeRequest, Empty, OperationMetadata>
      deleteDataAttributeOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteDataAttributeOperationCallable()");
  }

  @Deprecated
  public UnaryCallable<DeleteDataAttributeRequest, Operation> deleteDataAttributeCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDataAttributeCallable()");
  }

  @Deprecated
  public UnaryCallable<ListDataAttributesRequest, ListDataAttributesPagedResponse>
      listDataAttributesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataAttributesPagedCallable()");
  }

  @Deprecated
  public UnaryCallable<ListDataAttributesRequest, ListDataAttributesResponse>
      listDataAttributesCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataAttributesCallable()");
  }

  @Deprecated
  public UnaryCallable<GetDataAttributeRequest, DataAttribute> getDataAttributeCallable() {
    throw new UnsupportedOperationException("Not implemented: getDataAttributeCallable()");
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
