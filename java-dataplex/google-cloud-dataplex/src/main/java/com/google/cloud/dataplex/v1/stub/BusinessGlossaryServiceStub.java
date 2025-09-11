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

import static com.google.cloud.dataplex.v1.BusinessGlossaryServiceClient.ListGlossariesPagedResponse;
import static com.google.cloud.dataplex.v1.BusinessGlossaryServiceClient.ListGlossaryCategoriesPagedResponse;
import static com.google.cloud.dataplex.v1.BusinessGlossaryServiceClient.ListGlossaryTermsPagedResponse;
import static com.google.cloud.dataplex.v1.BusinessGlossaryServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataplex.v1.CreateGlossaryCategoryRequest;
import com.google.cloud.dataplex.v1.CreateGlossaryRequest;
import com.google.cloud.dataplex.v1.CreateGlossaryTermRequest;
import com.google.cloud.dataplex.v1.DeleteGlossaryCategoryRequest;
import com.google.cloud.dataplex.v1.DeleteGlossaryRequest;
import com.google.cloud.dataplex.v1.DeleteGlossaryTermRequest;
import com.google.cloud.dataplex.v1.GetGlossaryCategoryRequest;
import com.google.cloud.dataplex.v1.GetGlossaryRequest;
import com.google.cloud.dataplex.v1.GetGlossaryTermRequest;
import com.google.cloud.dataplex.v1.Glossary;
import com.google.cloud.dataplex.v1.GlossaryCategory;
import com.google.cloud.dataplex.v1.GlossaryTerm;
import com.google.cloud.dataplex.v1.ListGlossariesRequest;
import com.google.cloud.dataplex.v1.ListGlossariesResponse;
import com.google.cloud.dataplex.v1.ListGlossaryCategoriesRequest;
import com.google.cloud.dataplex.v1.ListGlossaryCategoriesResponse;
import com.google.cloud.dataplex.v1.ListGlossaryTermsRequest;
import com.google.cloud.dataplex.v1.ListGlossaryTermsResponse;
import com.google.cloud.dataplex.v1.OperationMetadata;
import com.google.cloud.dataplex.v1.UpdateGlossaryCategoryRequest;
import com.google.cloud.dataplex.v1.UpdateGlossaryRequest;
import com.google.cloud.dataplex.v1.UpdateGlossaryTermRequest;
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
 * Base stub class for the BusinessGlossaryService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class BusinessGlossaryServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public OperationCallable<CreateGlossaryRequest, Glossary, OperationMetadata>
      createGlossaryOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createGlossaryOperationCallable()");
  }

  public UnaryCallable<CreateGlossaryRequest, Operation> createGlossaryCallable() {
    throw new UnsupportedOperationException("Not implemented: createGlossaryCallable()");
  }

  public OperationCallable<UpdateGlossaryRequest, Glossary, OperationMetadata>
      updateGlossaryOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateGlossaryOperationCallable()");
  }

  public UnaryCallable<UpdateGlossaryRequest, Operation> updateGlossaryCallable() {
    throw new UnsupportedOperationException("Not implemented: updateGlossaryCallable()");
  }

  public OperationCallable<DeleteGlossaryRequest, Empty, OperationMetadata>
      deleteGlossaryOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteGlossaryOperationCallable()");
  }

  public UnaryCallable<DeleteGlossaryRequest, Operation> deleteGlossaryCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteGlossaryCallable()");
  }

  public UnaryCallable<GetGlossaryRequest, Glossary> getGlossaryCallable() {
    throw new UnsupportedOperationException("Not implemented: getGlossaryCallable()");
  }

  public UnaryCallable<ListGlossariesRequest, ListGlossariesPagedResponse>
      listGlossariesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listGlossariesPagedCallable()");
  }

  public UnaryCallable<ListGlossariesRequest, ListGlossariesResponse> listGlossariesCallable() {
    throw new UnsupportedOperationException("Not implemented: listGlossariesCallable()");
  }

  public UnaryCallable<CreateGlossaryCategoryRequest, GlossaryCategory>
      createGlossaryCategoryCallable() {
    throw new UnsupportedOperationException("Not implemented: createGlossaryCategoryCallable()");
  }

  public UnaryCallable<UpdateGlossaryCategoryRequest, GlossaryCategory>
      updateGlossaryCategoryCallable() {
    throw new UnsupportedOperationException("Not implemented: updateGlossaryCategoryCallable()");
  }

  public UnaryCallable<DeleteGlossaryCategoryRequest, Empty> deleteGlossaryCategoryCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteGlossaryCategoryCallable()");
  }

  public UnaryCallable<GetGlossaryCategoryRequest, GlossaryCategory> getGlossaryCategoryCallable() {
    throw new UnsupportedOperationException("Not implemented: getGlossaryCategoryCallable()");
  }

  public UnaryCallable<ListGlossaryCategoriesRequest, ListGlossaryCategoriesPagedResponse>
      listGlossaryCategoriesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listGlossaryCategoriesPagedCallable()");
  }

  public UnaryCallable<ListGlossaryCategoriesRequest, ListGlossaryCategoriesResponse>
      listGlossaryCategoriesCallable() {
    throw new UnsupportedOperationException("Not implemented: listGlossaryCategoriesCallable()");
  }

  public UnaryCallable<CreateGlossaryTermRequest, GlossaryTerm> createGlossaryTermCallable() {
    throw new UnsupportedOperationException("Not implemented: createGlossaryTermCallable()");
  }

  public UnaryCallable<UpdateGlossaryTermRequest, GlossaryTerm> updateGlossaryTermCallable() {
    throw new UnsupportedOperationException("Not implemented: updateGlossaryTermCallable()");
  }

  public UnaryCallable<DeleteGlossaryTermRequest, Empty> deleteGlossaryTermCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteGlossaryTermCallable()");
  }

  public UnaryCallable<GetGlossaryTermRequest, GlossaryTerm> getGlossaryTermCallable() {
    throw new UnsupportedOperationException("Not implemented: getGlossaryTermCallable()");
  }

  public UnaryCallable<ListGlossaryTermsRequest, ListGlossaryTermsPagedResponse>
      listGlossaryTermsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listGlossaryTermsPagedCallable()");
  }

  public UnaryCallable<ListGlossaryTermsRequest, ListGlossaryTermsResponse>
      listGlossaryTermsCallable() {
    throw new UnsupportedOperationException("Not implemented: listGlossaryTermsCallable()");
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
