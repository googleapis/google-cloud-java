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

package com.google.cloud.dialogflow.cx.v3.stub;

import static com.google.cloud.dialogflow.cx.v3.SessionEntityTypesClient.ListSessionEntityTypesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.cx.v3.CreateSessionEntityTypeRequest;
import com.google.cloud.dialogflow.cx.v3.DeleteSessionEntityTypeRequest;
import com.google.cloud.dialogflow.cx.v3.GetSessionEntityTypeRequest;
import com.google.cloud.dialogflow.cx.v3.ListSessionEntityTypesRequest;
import com.google.cloud.dialogflow.cx.v3.ListSessionEntityTypesResponse;
import com.google.cloud.dialogflow.cx.v3.SessionEntityType;
import com.google.cloud.dialogflow.cx.v3.UpdateSessionEntityTypeRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the SessionEntityTypes service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class SessionEntityTypesStub implements BackgroundResource {

  public UnaryCallable<ListSessionEntityTypesRequest, ListSessionEntityTypesPagedResponse>
      listSessionEntityTypesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listSessionEntityTypesPagedCallable()");
  }

  public UnaryCallable<ListSessionEntityTypesRequest, ListSessionEntityTypesResponse>
      listSessionEntityTypesCallable() {
    throw new UnsupportedOperationException("Not implemented: listSessionEntityTypesCallable()");
  }

  public UnaryCallable<GetSessionEntityTypeRequest, SessionEntityType>
      getSessionEntityTypeCallable() {
    throw new UnsupportedOperationException("Not implemented: getSessionEntityTypeCallable()");
  }

  public UnaryCallable<CreateSessionEntityTypeRequest, SessionEntityType>
      createSessionEntityTypeCallable() {
    throw new UnsupportedOperationException("Not implemented: createSessionEntityTypeCallable()");
  }

  public UnaryCallable<UpdateSessionEntityTypeRequest, SessionEntityType>
      updateSessionEntityTypeCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSessionEntityTypeCallable()");
  }

  public UnaryCallable<DeleteSessionEntityTypeRequest, Empty> deleteSessionEntityTypeCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSessionEntityTypeCallable()");
  }

  @Override
  public abstract void close();
}
