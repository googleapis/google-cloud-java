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

package com.google.cloud.cloudsecuritycompliance.v1.stub;

import static com.google.cloud.cloudsecuritycompliance.v1.ConfigClient.ListCloudControlsPagedResponse;
import static com.google.cloud.cloudsecuritycompliance.v1.ConfigClient.ListFrameworksPagedResponse;
import static com.google.cloud.cloudsecuritycompliance.v1.ConfigClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.cloudsecuritycompliance.v1.CloudControl;
import com.google.cloud.cloudsecuritycompliance.v1.CreateCloudControlRequest;
import com.google.cloud.cloudsecuritycompliance.v1.CreateFrameworkRequest;
import com.google.cloud.cloudsecuritycompliance.v1.DeleteCloudControlRequest;
import com.google.cloud.cloudsecuritycompliance.v1.DeleteFrameworkRequest;
import com.google.cloud.cloudsecuritycompliance.v1.Framework;
import com.google.cloud.cloudsecuritycompliance.v1.GetCloudControlRequest;
import com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkRequest;
import com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlsRequest;
import com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlsResponse;
import com.google.cloud.cloudsecuritycompliance.v1.ListFrameworksRequest;
import com.google.cloud.cloudsecuritycompliance.v1.ListFrameworksResponse;
import com.google.cloud.cloudsecuritycompliance.v1.UpdateCloudControlRequest;
import com.google.cloud.cloudsecuritycompliance.v1.UpdateFrameworkRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Config service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ConfigStub implements BackgroundResource {

  public UnaryCallable<ListFrameworksRequest, ListFrameworksPagedResponse>
      listFrameworksPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listFrameworksPagedCallable()");
  }

  public UnaryCallable<ListFrameworksRequest, ListFrameworksResponse> listFrameworksCallable() {
    throw new UnsupportedOperationException("Not implemented: listFrameworksCallable()");
  }

  public UnaryCallable<GetFrameworkRequest, Framework> getFrameworkCallable() {
    throw new UnsupportedOperationException("Not implemented: getFrameworkCallable()");
  }

  public UnaryCallable<CreateFrameworkRequest, Framework> createFrameworkCallable() {
    throw new UnsupportedOperationException("Not implemented: createFrameworkCallable()");
  }

  public UnaryCallable<UpdateFrameworkRequest, Framework> updateFrameworkCallable() {
    throw new UnsupportedOperationException("Not implemented: updateFrameworkCallable()");
  }

  public UnaryCallable<DeleteFrameworkRequest, Empty> deleteFrameworkCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteFrameworkCallable()");
  }

  public UnaryCallable<ListCloudControlsRequest, ListCloudControlsPagedResponse>
      listCloudControlsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listCloudControlsPagedCallable()");
  }

  public UnaryCallable<ListCloudControlsRequest, ListCloudControlsResponse>
      listCloudControlsCallable() {
    throw new UnsupportedOperationException("Not implemented: listCloudControlsCallable()");
  }

  public UnaryCallable<GetCloudControlRequest, CloudControl> getCloudControlCallable() {
    throw new UnsupportedOperationException("Not implemented: getCloudControlCallable()");
  }

  public UnaryCallable<CreateCloudControlRequest, CloudControl> createCloudControlCallable() {
    throw new UnsupportedOperationException("Not implemented: createCloudControlCallable()");
  }

  public UnaryCallable<UpdateCloudControlRequest, CloudControl> updateCloudControlCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCloudControlCallable()");
  }

  public UnaryCallable<DeleteCloudControlRequest, Empty> deleteCloudControlCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCloudControlCallable()");
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
