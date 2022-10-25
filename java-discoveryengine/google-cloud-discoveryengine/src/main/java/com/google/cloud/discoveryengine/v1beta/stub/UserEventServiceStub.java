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

package com.google.cloud.discoveryengine.v1beta.stub;

import com.google.api.HttpBody;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1beta.CollectUserEventRequest;
import com.google.cloud.discoveryengine.v1beta.ImportUserEventsMetadata;
import com.google.cloud.discoveryengine.v1beta.ImportUserEventsRequest;
import com.google.cloud.discoveryengine.v1beta.ImportUserEventsResponse;
import com.google.cloud.discoveryengine.v1beta.UserEvent;
import com.google.cloud.discoveryengine.v1beta.WriteUserEventRequest;
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
