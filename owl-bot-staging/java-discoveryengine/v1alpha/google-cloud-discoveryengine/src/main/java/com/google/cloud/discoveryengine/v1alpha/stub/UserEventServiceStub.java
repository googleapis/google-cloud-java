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

package com.google.cloud.discoveryengine.v1alpha.stub;

import com.google.api.HttpBody;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1alpha.CollectUserEventRequest;
import com.google.cloud.discoveryengine.v1alpha.ImportUserEventsMetadata;
import com.google.cloud.discoveryengine.v1alpha.ImportUserEventsRequest;
import com.google.cloud.discoveryengine.v1alpha.ImportUserEventsResponse;
import com.google.cloud.discoveryengine.v1alpha.PurgeUserEventsMetadata;
import com.google.cloud.discoveryengine.v1alpha.PurgeUserEventsRequest;
import com.google.cloud.discoveryengine.v1alpha.PurgeUserEventsResponse;
import com.google.cloud.discoveryengine.v1alpha.UserEvent;
import com.google.cloud.discoveryengine.v1alpha.WriteUserEventRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the UserEventService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class UserEventServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<WriteUserEventRequest, UserEvent> writeUserEventCallable() {
    throw new UnsupportedOperationException("Not implemented: writeUserEventCallable()");
  }

  public UnaryCallable<CollectUserEventRequest, HttpBody> collectUserEventCallable() {
    throw new UnsupportedOperationException("Not implemented: collectUserEventCallable()");
  }

  public OperationCallable<PurgeUserEventsRequest, PurgeUserEventsResponse, PurgeUserEventsMetadata>
      purgeUserEventsOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: purgeUserEventsOperationCallable()");
  }

  public UnaryCallable<PurgeUserEventsRequest, Operation> purgeUserEventsCallable() {
    throw new UnsupportedOperationException("Not implemented: purgeUserEventsCallable()");
  }

  public OperationCallable<
          ImportUserEventsRequest, ImportUserEventsResponse, ImportUserEventsMetadata>
      importUserEventsOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: importUserEventsOperationCallable()");
  }

  public UnaryCallable<ImportUserEventsRequest, Operation> importUserEventsCallable() {
    throw new UnsupportedOperationException("Not implemented: importUserEventsCallable()");
  }

  @Override
  public abstract void close();
}
