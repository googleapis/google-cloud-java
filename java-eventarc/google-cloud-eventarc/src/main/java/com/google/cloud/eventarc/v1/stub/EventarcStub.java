/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.eventarc.v1.stub;

import static com.google.cloud.eventarc.v1.EventarcClient.ListTriggersPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.eventarc.v1.CreateTriggerRequest;
import com.google.cloud.eventarc.v1.DeleteTriggerRequest;
import com.google.cloud.eventarc.v1.GetTriggerRequest;
import com.google.cloud.eventarc.v1.ListTriggersRequest;
import com.google.cloud.eventarc.v1.ListTriggersResponse;
import com.google.cloud.eventarc.v1.OperationMetadata;
import com.google.cloud.eventarc.v1.Trigger;
import com.google.cloud.eventarc.v1.UpdateTriggerRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Eventarc service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class EventarcStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<GetTriggerRequest, Trigger> getTriggerCallable() {
    throw new UnsupportedOperationException("Not implemented: getTriggerCallable()");
  }

  public UnaryCallable<ListTriggersRequest, ListTriggersPagedResponse> listTriggersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listTriggersPagedCallable()");
  }

  public UnaryCallable<ListTriggersRequest, ListTriggersResponse> listTriggersCallable() {
    throw new UnsupportedOperationException("Not implemented: listTriggersCallable()");
  }

  public OperationCallable<CreateTriggerRequest, Trigger, OperationMetadata>
      createTriggerOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createTriggerOperationCallable()");
  }

  public UnaryCallable<CreateTriggerRequest, Operation> createTriggerCallable() {
    throw new UnsupportedOperationException("Not implemented: createTriggerCallable()");
  }

  public OperationCallable<UpdateTriggerRequest, Trigger, OperationMetadata>
      updateTriggerOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateTriggerOperationCallable()");
  }

  public UnaryCallable<UpdateTriggerRequest, Operation> updateTriggerCallable() {
    throw new UnsupportedOperationException("Not implemented: updateTriggerCallable()");
  }

  public OperationCallable<DeleteTriggerRequest, Trigger, OperationMetadata>
      deleteTriggerOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTriggerOperationCallable()");
  }

  public UnaryCallable<DeleteTriggerRequest, Operation> deleteTriggerCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTriggerCallable()");
  }

  @Override
  public abstract void close();
}
