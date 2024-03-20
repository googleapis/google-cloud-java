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

package com.google.cloud.dataplex.v1.stub;

import static com.google.cloud.dataplex.v1.CatalogServiceClient.ListAspectTypesPagedResponse;
import static com.google.cloud.dataplex.v1.CatalogServiceClient.ListEntriesPagedResponse;
import static com.google.cloud.dataplex.v1.CatalogServiceClient.ListEntryGroupsPagedResponse;
import static com.google.cloud.dataplex.v1.CatalogServiceClient.ListEntryTypesPagedResponse;
import static com.google.cloud.dataplex.v1.CatalogServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.dataplex.v1.CatalogServiceClient.SearchEntriesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataplex.v1.AspectType;
import com.google.cloud.dataplex.v1.CreateAspectTypeRequest;
import com.google.cloud.dataplex.v1.CreateEntryGroupRequest;
import com.google.cloud.dataplex.v1.CreateEntryRequest;
import com.google.cloud.dataplex.v1.CreateEntryTypeRequest;
import com.google.cloud.dataplex.v1.DeleteAspectTypeRequest;
import com.google.cloud.dataplex.v1.DeleteEntryGroupRequest;
import com.google.cloud.dataplex.v1.DeleteEntryRequest;
import com.google.cloud.dataplex.v1.DeleteEntryTypeRequest;
import com.google.cloud.dataplex.v1.Entry;
import com.google.cloud.dataplex.v1.EntryGroup;
import com.google.cloud.dataplex.v1.EntryType;
import com.google.cloud.dataplex.v1.GetAspectTypeRequest;
import com.google.cloud.dataplex.v1.GetEntryGroupRequest;
import com.google.cloud.dataplex.v1.GetEntryRequest;
import com.google.cloud.dataplex.v1.GetEntryTypeRequest;
import com.google.cloud.dataplex.v1.ListAspectTypesRequest;
import com.google.cloud.dataplex.v1.ListAspectTypesResponse;
import com.google.cloud.dataplex.v1.ListEntriesRequest;
import com.google.cloud.dataplex.v1.ListEntriesResponse;
import com.google.cloud.dataplex.v1.ListEntryGroupsRequest;
import com.google.cloud.dataplex.v1.ListEntryGroupsResponse;
import com.google.cloud.dataplex.v1.ListEntryTypesRequest;
import com.google.cloud.dataplex.v1.ListEntryTypesResponse;
import com.google.cloud.dataplex.v1.LookupEntryRequest;
import com.google.cloud.dataplex.v1.OperationMetadata;
import com.google.cloud.dataplex.v1.SearchEntriesRequest;
import com.google.cloud.dataplex.v1.SearchEntriesResponse;
import com.google.cloud.dataplex.v1.UpdateAspectTypeRequest;
import com.google.cloud.dataplex.v1.UpdateEntryGroupRequest;
import com.google.cloud.dataplex.v1.UpdateEntryRequest;
import com.google.cloud.dataplex.v1.UpdateEntryTypeRequest;
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
 * Base stub class for the CatalogService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class CatalogServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public OperationCallable<CreateEntryTypeRequest, EntryType, OperationMetadata>
      createEntryTypeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createEntryTypeOperationCallable()");
  }

  public UnaryCallable<CreateEntryTypeRequest, Operation> createEntryTypeCallable() {
    throw new UnsupportedOperationException("Not implemented: createEntryTypeCallable()");
  }

  public OperationCallable<UpdateEntryTypeRequest, EntryType, OperationMetadata>
      updateEntryTypeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateEntryTypeOperationCallable()");
  }

  public UnaryCallable<UpdateEntryTypeRequest, Operation> updateEntryTypeCallable() {
    throw new UnsupportedOperationException("Not implemented: updateEntryTypeCallable()");
  }

  public OperationCallable<DeleteEntryTypeRequest, Empty, OperationMetadata>
      deleteEntryTypeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteEntryTypeOperationCallable()");
  }

  public UnaryCallable<DeleteEntryTypeRequest, Operation> deleteEntryTypeCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteEntryTypeCallable()");
  }

  public UnaryCallable<ListEntryTypesRequest, ListEntryTypesPagedResponse>
      listEntryTypesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listEntryTypesPagedCallable()");
  }

  public UnaryCallable<ListEntryTypesRequest, ListEntryTypesResponse> listEntryTypesCallable() {
    throw new UnsupportedOperationException("Not implemented: listEntryTypesCallable()");
  }

  public UnaryCallable<GetEntryTypeRequest, EntryType> getEntryTypeCallable() {
    throw new UnsupportedOperationException("Not implemented: getEntryTypeCallable()");
  }

  public OperationCallable<CreateAspectTypeRequest, AspectType, OperationMetadata>
      createAspectTypeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createAspectTypeOperationCallable()");
  }

  public UnaryCallable<CreateAspectTypeRequest, Operation> createAspectTypeCallable() {
    throw new UnsupportedOperationException("Not implemented: createAspectTypeCallable()");
  }

  public OperationCallable<UpdateAspectTypeRequest, AspectType, OperationMetadata>
      updateAspectTypeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAspectTypeOperationCallable()");
  }

  public UnaryCallable<UpdateAspectTypeRequest, Operation> updateAspectTypeCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAspectTypeCallable()");
  }

  public OperationCallable<DeleteAspectTypeRequest, Empty, OperationMetadata>
      deleteAspectTypeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAspectTypeOperationCallable()");
  }

  public UnaryCallable<DeleteAspectTypeRequest, Operation> deleteAspectTypeCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAspectTypeCallable()");
  }

  public UnaryCallable<ListAspectTypesRequest, ListAspectTypesPagedResponse>
      listAspectTypesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAspectTypesPagedCallable()");
  }

  public UnaryCallable<ListAspectTypesRequest, ListAspectTypesResponse> listAspectTypesCallable() {
    throw new UnsupportedOperationException("Not implemented: listAspectTypesCallable()");
  }

  public UnaryCallable<GetAspectTypeRequest, AspectType> getAspectTypeCallable() {
    throw new UnsupportedOperationException("Not implemented: getAspectTypeCallable()");
  }

  public OperationCallable<CreateEntryGroupRequest, EntryGroup, OperationMetadata>
      createEntryGroupOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createEntryGroupOperationCallable()");
  }

  public UnaryCallable<CreateEntryGroupRequest, Operation> createEntryGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: createEntryGroupCallable()");
  }

  public OperationCallable<UpdateEntryGroupRequest, EntryGroup, OperationMetadata>
      updateEntryGroupOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateEntryGroupOperationCallable()");
  }

  public UnaryCallable<UpdateEntryGroupRequest, Operation> updateEntryGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: updateEntryGroupCallable()");
  }

  public OperationCallable<DeleteEntryGroupRequest, Empty, OperationMetadata>
      deleteEntryGroupOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteEntryGroupOperationCallable()");
  }

  public UnaryCallable<DeleteEntryGroupRequest, Operation> deleteEntryGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteEntryGroupCallable()");
  }

  public UnaryCallable<ListEntryGroupsRequest, ListEntryGroupsPagedResponse>
      listEntryGroupsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listEntryGroupsPagedCallable()");
  }

  public UnaryCallable<ListEntryGroupsRequest, ListEntryGroupsResponse> listEntryGroupsCallable() {
    throw new UnsupportedOperationException("Not implemented: listEntryGroupsCallable()");
  }

  public UnaryCallable<GetEntryGroupRequest, EntryGroup> getEntryGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: getEntryGroupCallable()");
  }

  public UnaryCallable<CreateEntryRequest, Entry> createEntryCallable() {
    throw new UnsupportedOperationException("Not implemented: createEntryCallable()");
  }

  public UnaryCallable<UpdateEntryRequest, Entry> updateEntryCallable() {
    throw new UnsupportedOperationException("Not implemented: updateEntryCallable()");
  }

  public UnaryCallable<DeleteEntryRequest, Entry> deleteEntryCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteEntryCallable()");
  }

  public UnaryCallable<ListEntriesRequest, ListEntriesPagedResponse> listEntriesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listEntriesPagedCallable()");
  }

  public UnaryCallable<ListEntriesRequest, ListEntriesResponse> listEntriesCallable() {
    throw new UnsupportedOperationException("Not implemented: listEntriesCallable()");
  }

  public UnaryCallable<GetEntryRequest, Entry> getEntryCallable() {
    throw new UnsupportedOperationException("Not implemented: getEntryCallable()");
  }

  public UnaryCallable<LookupEntryRequest, Entry> lookupEntryCallable() {
    throw new UnsupportedOperationException("Not implemented: lookupEntryCallable()");
  }

  public UnaryCallable<SearchEntriesRequest, SearchEntriesPagedResponse>
      searchEntriesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: searchEntriesPagedCallable()");
  }

  public UnaryCallable<SearchEntriesRequest, SearchEntriesResponse> searchEntriesCallable() {
    throw new UnsupportedOperationException("Not implemented: searchEntriesCallable()");
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
