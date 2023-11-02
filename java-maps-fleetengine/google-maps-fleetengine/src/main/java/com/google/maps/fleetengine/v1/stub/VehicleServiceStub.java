/*
 * Copyright 2023 Google LLC
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

package google.maps.fleetengine.v1.stub;

import static google.maps.fleetengine.v1.VehicleServiceClient.ListVehiclesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import google.maps.fleetengine.v1.CreateVehicleRequest;
import google.maps.fleetengine.v1.GetVehicleRequest;
import google.maps.fleetengine.v1.ListVehiclesRequest;
import google.maps.fleetengine.v1.ListVehiclesResponse;
import google.maps.fleetengine.v1.SearchVehiclesRequest;
import google.maps.fleetengine.v1.SearchVehiclesResponse;
import google.maps.fleetengine.v1.UpdateVehicleAttributesRequest;
import google.maps.fleetengine.v1.UpdateVehicleAttributesResponse;
import google.maps.fleetengine.v1.UpdateVehicleLocationRequest;
import google.maps.fleetengine.v1.UpdateVehicleRequest;
import google.maps.fleetengine.v1.Vehicle;
import google.maps.fleetengine.v1.VehicleLocation;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the VehicleService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class VehicleServiceStub implements BackgroundResource {

  public UnaryCallable<CreateVehicleRequest, Vehicle> createVehicleCallable() {
    throw new UnsupportedOperationException("Not implemented: createVehicleCallable()");
  }

  public UnaryCallable<GetVehicleRequest, Vehicle> getVehicleCallable() {
    throw new UnsupportedOperationException("Not implemented: getVehicleCallable()");
  }

  public UnaryCallable<UpdateVehicleRequest, Vehicle> updateVehicleCallable() {
    throw new UnsupportedOperationException("Not implemented: updateVehicleCallable()");
  }

  @Deprecated
  public UnaryCallable<UpdateVehicleLocationRequest, VehicleLocation>
      updateVehicleLocationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateVehicleLocationCallable()");
  }

  public UnaryCallable<UpdateVehicleAttributesRequest, UpdateVehicleAttributesResponse>
      updateVehicleAttributesCallable() {
    throw new UnsupportedOperationException("Not implemented: updateVehicleAttributesCallable()");
  }

  public UnaryCallable<ListVehiclesRequest, ListVehiclesPagedResponse> listVehiclesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listVehiclesPagedCallable()");
  }

  public UnaryCallable<ListVehiclesRequest, ListVehiclesResponse> listVehiclesCallable() {
    throw new UnsupportedOperationException("Not implemented: listVehiclesCallable()");
  }

  public UnaryCallable<SearchVehiclesRequest, SearchVehiclesResponse> searchVehiclesCallable() {
    throw new UnsupportedOperationException("Not implemented: searchVehiclesCallable()");
  }

  @Deprecated
  public UnaryCallable<SearchVehiclesRequest, SearchVehiclesResponse>
      searchFuzzedVehiclesCallable() {
    throw new UnsupportedOperationException("Not implemented: searchFuzzedVehiclesCallable()");
  }

  @Override
  public abstract void close();
}
