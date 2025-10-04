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

package com.google.cloud.discoveryengine.v1alpha.stub;

import static com.google.cloud.discoveryengine.v1alpha.SessionServiceClient.ListFilesPagedResponse;
import static com.google.cloud.discoveryengine.v1alpha.SessionServiceClient.ListSessionsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1alpha.CreateSessionRequest;
import com.google.cloud.discoveryengine.v1alpha.DeleteSessionRequest;
import com.google.cloud.discoveryengine.v1alpha.GetSessionRequest;
import com.google.cloud.discoveryengine.v1alpha.ListFilesRequest;
import com.google.cloud.discoveryengine.v1alpha.ListFilesResponse;
import com.google.cloud.discoveryengine.v1alpha.ListSessionsRequest;
import com.google.cloud.discoveryengine.v1alpha.ListSessionsResponse;
import com.google.cloud.discoveryengine.v1alpha.Session;
import com.google.cloud.discoveryengine.v1alpha.UpdateSessionRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the SessionService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class SessionServiceStub implements BackgroundResource {

  public UnaryCallable<CreateSessionRequest, Session> createSessionCallable() {
    throw new UnsupportedOperationException("Not implemented: createSessionCallable()");
  }

  public UnaryCallable<DeleteSessionRequest, Empty> deleteSessionCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSessionCallable()");
  }

  public UnaryCallable<UpdateSessionRequest, Session> updateSessionCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSessionCallable()");
  }

  public UnaryCallable<GetSessionRequest, Session> getSessionCallable() {
    throw new UnsupportedOperationException("Not implemented: getSessionCallable()");
  }

  public UnaryCallable<ListSessionsRequest, ListSessionsPagedResponse> listSessionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSessionsPagedCallable()");
  }

  public UnaryCallable<ListSessionsRequest, ListSessionsResponse> listSessionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listSessionsCallable()");
  }

  public UnaryCallable<ListFilesRequest, ListFilesPagedResponse> listFilesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listFilesPagedCallable()");
  }

  public UnaryCallable<ListFilesRequest, ListFilesResponse> listFilesCallable() {
    throw new UnsupportedOperationException("Not implemented: listFilesCallable()");
  }

  @Override
  public abstract void close();
}
