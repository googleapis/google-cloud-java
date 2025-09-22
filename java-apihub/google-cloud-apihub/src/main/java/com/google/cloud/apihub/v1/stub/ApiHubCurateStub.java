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

package com.google.cloud.apihub.v1.stub;

import static com.google.cloud.apihub.v1.ApiHubCurateClient.ListCurationsPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubCurateClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.apihub.v1.CreateCurationRequest;
import com.google.cloud.apihub.v1.Curation;
import com.google.cloud.apihub.v1.DeleteCurationRequest;
import com.google.cloud.apihub.v1.GetCurationRequest;
import com.google.cloud.apihub.v1.ListCurationsRequest;
import com.google.cloud.apihub.v1.ListCurationsResponse;
import com.google.cloud.apihub.v1.UpdateCurationRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ApiHubCurate service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ApiHubCurateStub implements BackgroundResource {

  public UnaryCallable<CreateCurationRequest, Curation> createCurationCallable() {
    throw new UnsupportedOperationException("Not implemented: createCurationCallable()");
  }

  public UnaryCallable<GetCurationRequest, Curation> getCurationCallable() {
    throw new UnsupportedOperationException("Not implemented: getCurationCallable()");
  }

  public UnaryCallable<ListCurationsRequest, ListCurationsPagedResponse>
      listCurationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listCurationsPagedCallable()");
  }

  public UnaryCallable<ListCurationsRequest, ListCurationsResponse> listCurationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listCurationsCallable()");
  }

  public UnaryCallable<UpdateCurationRequest, Curation> updateCurationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCurationCallable()");
  }

  public UnaryCallable<DeleteCurationRequest, Empty> deleteCurationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCurationCallable()");
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
