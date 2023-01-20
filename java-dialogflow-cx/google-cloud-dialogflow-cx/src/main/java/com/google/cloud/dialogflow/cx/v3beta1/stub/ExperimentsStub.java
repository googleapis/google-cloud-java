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

package com.google.cloud.dialogflow.cx.v3beta1.stub;

import static com.google.cloud.dialogflow.cx.v3beta1.ExperimentsClient.ListExperimentsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3beta1.ExperimentsClient.ListLocationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.cx.v3beta1.CreateExperimentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.DeleteExperimentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.Experiment;
import com.google.cloud.dialogflow.cx.v3beta1.GetExperimentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListExperimentsRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListExperimentsResponse;
import com.google.cloud.dialogflow.cx.v3beta1.StartExperimentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.StopExperimentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.UpdateExperimentRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Experiments service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class ExperimentsStub implements BackgroundResource {

  public UnaryCallable<ListExperimentsRequest, ListExperimentsPagedResponse>
      listExperimentsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listExperimentsPagedCallable()");
  }

  public UnaryCallable<ListExperimentsRequest, ListExperimentsResponse> listExperimentsCallable() {
    throw new UnsupportedOperationException("Not implemented: listExperimentsCallable()");
  }

  public UnaryCallable<GetExperimentRequest, Experiment> getExperimentCallable() {
    throw new UnsupportedOperationException("Not implemented: getExperimentCallable()");
  }

  public UnaryCallable<CreateExperimentRequest, Experiment> createExperimentCallable() {
    throw new UnsupportedOperationException("Not implemented: createExperimentCallable()");
  }

  public UnaryCallable<UpdateExperimentRequest, Experiment> updateExperimentCallable() {
    throw new UnsupportedOperationException("Not implemented: updateExperimentCallable()");
  }

  public UnaryCallable<DeleteExperimentRequest, Empty> deleteExperimentCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteExperimentCallable()");
  }

  public UnaryCallable<StartExperimentRequest, Experiment> startExperimentCallable() {
    throw new UnsupportedOperationException("Not implemented: startExperimentCallable()");
  }

  public UnaryCallable<StopExperimentRequest, Experiment> stopExperimentCallable() {
    throw new UnsupportedOperationException("Not implemented: stopExperimentCallable()");
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
