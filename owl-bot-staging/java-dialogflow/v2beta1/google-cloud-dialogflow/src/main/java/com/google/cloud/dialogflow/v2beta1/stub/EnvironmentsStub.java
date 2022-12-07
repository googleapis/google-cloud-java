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

package com.google.cloud.dialogflow.v2beta1.stub;

import static com.google.cloud.dialogflow.v2beta1.EnvironmentsClient.GetEnvironmentHistoryPagedResponse;
import static com.google.cloud.dialogflow.v2beta1.EnvironmentsClient.ListEnvironmentsPagedResponse;
import static com.google.cloud.dialogflow.v2beta1.EnvironmentsClient.ListLocationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2beta1.CreateEnvironmentRequest;
import com.google.cloud.dialogflow.v2beta1.DeleteEnvironmentRequest;
import com.google.cloud.dialogflow.v2beta1.Environment;
import com.google.cloud.dialogflow.v2beta1.EnvironmentHistory;
import com.google.cloud.dialogflow.v2beta1.GetEnvironmentHistoryRequest;
import com.google.cloud.dialogflow.v2beta1.GetEnvironmentRequest;
import com.google.cloud.dialogflow.v2beta1.ListEnvironmentsRequest;
import com.google.cloud.dialogflow.v2beta1.ListEnvironmentsResponse;
import com.google.cloud.dialogflow.v2beta1.UpdateEnvironmentRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Environments service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class EnvironmentsStub implements BackgroundResource {

  public UnaryCallable<ListEnvironmentsRequest, ListEnvironmentsPagedResponse>
      listEnvironmentsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listEnvironmentsPagedCallable()");
  }

  public UnaryCallable<ListEnvironmentsRequest, ListEnvironmentsResponse>
      listEnvironmentsCallable() {
    throw new UnsupportedOperationException("Not implemented: listEnvironmentsCallable()");
  }

  public UnaryCallable<GetEnvironmentRequest, Environment> getEnvironmentCallable() {
    throw new UnsupportedOperationException("Not implemented: getEnvironmentCallable()");
  }

  public UnaryCallable<CreateEnvironmentRequest, Environment> createEnvironmentCallable() {
    throw new UnsupportedOperationException("Not implemented: createEnvironmentCallable()");
  }

  public UnaryCallable<UpdateEnvironmentRequest, Environment> updateEnvironmentCallable() {
    throw new UnsupportedOperationException("Not implemented: updateEnvironmentCallable()");
  }

  public UnaryCallable<DeleteEnvironmentRequest, Empty> deleteEnvironmentCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteEnvironmentCallable()");
  }

  public UnaryCallable<GetEnvironmentHistoryRequest, GetEnvironmentHistoryPagedResponse>
      getEnvironmentHistoryPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getEnvironmentHistoryPagedCallable()");
  }

  public UnaryCallable<GetEnvironmentHistoryRequest, EnvironmentHistory>
      getEnvironmentHistoryCallable() {
    throw new UnsupportedOperationException("Not implemented: getEnvironmentHistoryCallable()");
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
