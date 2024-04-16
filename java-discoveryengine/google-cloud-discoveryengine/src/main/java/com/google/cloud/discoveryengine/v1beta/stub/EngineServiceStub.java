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

package com.google.cloud.discoveryengine.v1beta.stub;

import static com.google.cloud.discoveryengine.v1beta.EngineServiceClient.ListEnginesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1beta.CreateEngineMetadata;
import com.google.cloud.discoveryengine.v1beta.CreateEngineRequest;
import com.google.cloud.discoveryengine.v1beta.DeleteEngineMetadata;
import com.google.cloud.discoveryengine.v1beta.DeleteEngineRequest;
import com.google.cloud.discoveryengine.v1beta.Engine;
import com.google.cloud.discoveryengine.v1beta.GetEngineRequest;
import com.google.cloud.discoveryengine.v1beta.ListEnginesRequest;
import com.google.cloud.discoveryengine.v1beta.ListEnginesResponse;
import com.google.cloud.discoveryengine.v1beta.PauseEngineRequest;
import com.google.cloud.discoveryengine.v1beta.ResumeEngineRequest;
import com.google.cloud.discoveryengine.v1beta.TuneEngineMetadata;
import com.google.cloud.discoveryengine.v1beta.TuneEngineRequest;
import com.google.cloud.discoveryengine.v1beta.TuneEngineResponse;
import com.google.cloud.discoveryengine.v1beta.UpdateEngineRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the EngineService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class EngineServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public OperationCallable<CreateEngineRequest, Engine, CreateEngineMetadata>
      createEngineOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createEngineOperationCallable()");
  }

  public UnaryCallable<CreateEngineRequest, Operation> createEngineCallable() {
    throw new UnsupportedOperationException("Not implemented: createEngineCallable()");
  }

  public OperationCallable<DeleteEngineRequest, Empty, DeleteEngineMetadata>
      deleteEngineOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteEngineOperationCallable()");
  }

  public UnaryCallable<DeleteEngineRequest, Operation> deleteEngineCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteEngineCallable()");
  }

  public UnaryCallable<UpdateEngineRequest, Engine> updateEngineCallable() {
    throw new UnsupportedOperationException("Not implemented: updateEngineCallable()");
  }

  public UnaryCallable<GetEngineRequest, Engine> getEngineCallable() {
    throw new UnsupportedOperationException("Not implemented: getEngineCallable()");
  }

  public UnaryCallable<ListEnginesRequest, ListEnginesPagedResponse> listEnginesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listEnginesPagedCallable()");
  }

  public UnaryCallable<ListEnginesRequest, ListEnginesResponse> listEnginesCallable() {
    throw new UnsupportedOperationException("Not implemented: listEnginesCallable()");
  }

  public UnaryCallable<PauseEngineRequest, Engine> pauseEngineCallable() {
    throw new UnsupportedOperationException("Not implemented: pauseEngineCallable()");
  }

  public UnaryCallable<ResumeEngineRequest, Engine> resumeEngineCallable() {
    throw new UnsupportedOperationException("Not implemented: resumeEngineCallable()");
  }

  public OperationCallable<TuneEngineRequest, TuneEngineResponse, TuneEngineMetadata>
      tuneEngineOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: tuneEngineOperationCallable()");
  }

  public UnaryCallable<TuneEngineRequest, Operation> tuneEngineCallable() {
    throw new UnsupportedOperationException("Not implemented: tuneEngineCallable()");
  }

  @Override
  public abstract void close();
}
