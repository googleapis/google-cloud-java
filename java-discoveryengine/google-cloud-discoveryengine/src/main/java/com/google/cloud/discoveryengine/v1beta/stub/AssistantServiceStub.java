/*
 * Copyright 2026 Google LLC
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

import static com.google.cloud.discoveryengine.v1beta.AssistantServiceClient.ListAssistantsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1beta.Assistant;
import com.google.cloud.discoveryengine.v1beta.CreateAssistantRequest;
import com.google.cloud.discoveryengine.v1beta.DeleteAssistantRequest;
import com.google.cloud.discoveryengine.v1beta.GetAssistantRequest;
import com.google.cloud.discoveryengine.v1beta.ListAssistantsRequest;
import com.google.cloud.discoveryengine.v1beta.ListAssistantsResponse;
import com.google.cloud.discoveryengine.v1beta.StreamAssistRequest;
import com.google.cloud.discoveryengine.v1beta.StreamAssistResponse;
import com.google.cloud.discoveryengine.v1beta.UpdateAssistantRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the AssistantService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public abstract class AssistantServiceStub implements BackgroundResource {

  public ServerStreamingCallable<StreamAssistRequest, StreamAssistResponse> streamAssistCallable() {
    throw new UnsupportedOperationException("Not implemented: streamAssistCallable()");
  }

  public UnaryCallable<CreateAssistantRequest, Assistant> createAssistantCallable() {
    throw new UnsupportedOperationException("Not implemented: createAssistantCallable()");
  }

  public UnaryCallable<DeleteAssistantRequest, Empty> deleteAssistantCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAssistantCallable()");
  }

  public UnaryCallable<UpdateAssistantRequest, Assistant> updateAssistantCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAssistantCallable()");
  }

  public UnaryCallable<GetAssistantRequest, Assistant> getAssistantCallable() {
    throw new UnsupportedOperationException("Not implemented: getAssistantCallable()");
  }

  public UnaryCallable<ListAssistantsRequest, ListAssistantsPagedResponse>
      listAssistantsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAssistantsPagedCallable()");
  }

  public UnaryCallable<ListAssistantsRequest, ListAssistantsResponse> listAssistantsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAssistantsCallable()");
  }

  @Override
  public abstract void close();
}
