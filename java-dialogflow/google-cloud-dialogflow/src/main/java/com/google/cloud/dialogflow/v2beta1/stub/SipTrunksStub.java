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

package com.google.cloud.dialogflow.v2beta1.stub;

import static com.google.cloud.dialogflow.v2beta1.SipTrunksClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.v2beta1.SipTrunksClient.ListSipTrunksPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2beta1.CreateSipTrunkRequest;
import com.google.cloud.dialogflow.v2beta1.DeleteSipTrunkRequest;
import com.google.cloud.dialogflow.v2beta1.GetSipTrunkRequest;
import com.google.cloud.dialogflow.v2beta1.ListSipTrunksRequest;
import com.google.cloud.dialogflow.v2beta1.ListSipTrunksResponse;
import com.google.cloud.dialogflow.v2beta1.SipTrunk;
import com.google.cloud.dialogflow.v2beta1.UpdateSipTrunkRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the SipTrunks service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class SipTrunksStub implements BackgroundResource {

  public UnaryCallable<CreateSipTrunkRequest, SipTrunk> createSipTrunkCallable() {
    throw new UnsupportedOperationException("Not implemented: createSipTrunkCallable()");
  }

  public UnaryCallable<DeleteSipTrunkRequest, Empty> deleteSipTrunkCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSipTrunkCallable()");
  }

  public UnaryCallable<ListSipTrunksRequest, ListSipTrunksPagedResponse>
      listSipTrunksPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSipTrunksPagedCallable()");
  }

  public UnaryCallable<ListSipTrunksRequest, ListSipTrunksResponse> listSipTrunksCallable() {
    throw new UnsupportedOperationException("Not implemented: listSipTrunksCallable()");
  }

  public UnaryCallable<GetSipTrunkRequest, SipTrunk> getSipTrunkCallable() {
    throw new UnsupportedOperationException("Not implemented: getSipTrunkCallable()");
  }

  public UnaryCallable<UpdateSipTrunkRequest, SipTrunk> updateSipTrunkCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSipTrunkCallable()");
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
