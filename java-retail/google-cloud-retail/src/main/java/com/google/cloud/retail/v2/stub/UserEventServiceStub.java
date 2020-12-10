/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.retail.v2.stub;

import com.google.api.HttpBody;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.retail.v2.CollectUserEventRequest;
import com.google.cloud.retail.v2.ImportMetadata;
import com.google.cloud.retail.v2.ImportUserEventsRequest;
import com.google.cloud.retail.v2.ImportUserEventsResponse;
import com.google.cloud.retail.v2.PurgeMetadata;
import com.google.cloud.retail.v2.PurgeUserEventsRequest;
import com.google.cloud.retail.v2.PurgeUserEventsResponse;
import com.google.cloud.retail.v2.RejoinUserEventsMetadata;
import com.google.cloud.retail.v2.RejoinUserEventsRequest;
import com.google.cloud.retail.v2.RejoinUserEventsResponse;
import com.google.cloud.retail.v2.UserEvent;
import com.google.cloud.retail.v2.WriteUserEventRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the UserEventService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
public abstract class UserEventServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<WriteUserEventRequest, UserEvent> writeUserEventCallable() {
    throw new UnsupportedOperationException("Not implemented: writeUserEventCallable()");
  }

  public UnaryCallable<CollectUserEventRequest, HttpBody> collectUserEventCallable() {
    throw new UnsupportedOperationException("Not implemented: collectUserEventCallable()");
  }

  public OperationCallable<PurgeUserEventsRequest, PurgeUserEventsResponse, PurgeMetadata>
      purgeUserEventsOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: purgeUserEventsOperationCallable()");
  }

  public UnaryCallable<PurgeUserEventsRequest, Operation> purgeUserEventsCallable() {
    throw new UnsupportedOperationException("Not implemented: purgeUserEventsCallable()");
  }

  public OperationCallable<ImportUserEventsRequest, ImportUserEventsResponse, ImportMetadata>
      importUserEventsOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: importUserEventsOperationCallable()");
  }

  public UnaryCallable<ImportUserEventsRequest, Operation> importUserEventsCallable() {
    throw new UnsupportedOperationException("Not implemented: importUserEventsCallable()");
  }

  public OperationCallable<
          RejoinUserEventsRequest, RejoinUserEventsResponse, RejoinUserEventsMetadata>
      rejoinUserEventsOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: rejoinUserEventsOperationCallable()");
  }

  public UnaryCallable<RejoinUserEventsRequest, Operation> rejoinUserEventsCallable() {
    throw new UnsupportedOperationException("Not implemented: rejoinUserEventsCallable()");
  }

  @Override
  public abstract void close();
}
