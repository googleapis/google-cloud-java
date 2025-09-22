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

package com.google.cloud.locationfinder.v1.stub;

import static com.google.cloud.locationfinder.v1.CloudLocationFinderClient.ListCloudLocationsPagedResponse;
import static com.google.cloud.locationfinder.v1.CloudLocationFinderClient.SearchCloudLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.locationfinder.v1.CloudLocation;
import com.google.cloud.locationfinder.v1.GetCloudLocationRequest;
import com.google.cloud.locationfinder.v1.ListCloudLocationsRequest;
import com.google.cloud.locationfinder.v1.ListCloudLocationsResponse;
import com.google.cloud.locationfinder.v1.SearchCloudLocationsRequest;
import com.google.cloud.locationfinder.v1.SearchCloudLocationsResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the CloudLocationFinder service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class CloudLocationFinderStub implements BackgroundResource {

  public UnaryCallable<ListCloudLocationsRequest, ListCloudLocationsPagedResponse>
      listCloudLocationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listCloudLocationsPagedCallable()");
  }

  public UnaryCallable<ListCloudLocationsRequest, ListCloudLocationsResponse>
      listCloudLocationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listCloudLocationsCallable()");
  }

  public UnaryCallable<GetCloudLocationRequest, CloudLocation> getCloudLocationCallable() {
    throw new UnsupportedOperationException("Not implemented: getCloudLocationCallable()");
  }

  public UnaryCallable<SearchCloudLocationsRequest, SearchCloudLocationsPagedResponse>
      searchCloudLocationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: searchCloudLocationsPagedCallable()");
  }

  public UnaryCallable<SearchCloudLocationsRequest, SearchCloudLocationsResponse>
      searchCloudLocationsCallable() {
    throw new UnsupportedOperationException("Not implemented: searchCloudLocationsCallable()");
  }

  @Override
  public abstract void close();
}
