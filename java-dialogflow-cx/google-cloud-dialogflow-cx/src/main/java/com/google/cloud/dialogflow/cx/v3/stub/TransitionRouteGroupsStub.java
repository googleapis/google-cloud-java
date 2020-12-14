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

import static com.google.cloud.dialogflow.cx.v3.TransitionRouteGroupsClient.ListTransitionRouteGroupsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.cx.v3.CreateTransitionRouteGroupRequest;
import com.google.cloud.dialogflow.cx.v3.DeleteTransitionRouteGroupRequest;
import com.google.cloud.dialogflow.cx.v3.GetTransitionRouteGroupRequest;
import com.google.cloud.dialogflow.cx.v3.ListTransitionRouteGroupsRequest;
import com.google.cloud.dialogflow.cx.v3.ListTransitionRouteGroupsResponse;
import com.google.cloud.dialogflow.cx.v3.TransitionRouteGroup;
import com.google.cloud.dialogflow.cx.v3.UpdateTransitionRouteGroupRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the TransitionRouteGroups service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
public abstract class TransitionRouteGroupsStub implements BackgroundResource {

  public UnaryCallable<ListTransitionRouteGroupsRequest, ListTransitionRouteGroupsPagedResponse>
      listTransitionRouteGroupsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listTransitionRouteGroupsPagedCallable()");
  }

  public UnaryCallable<ListTransitionRouteGroupsRequest, ListTransitionRouteGroupsResponse>
      listTransitionRouteGroupsCallable() {
    throw new UnsupportedOperationException("Not implemented: listTransitionRouteGroupsCallable()");
  }

  public UnaryCallable<GetTransitionRouteGroupRequest, TransitionRouteGroup>
      getTransitionRouteGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: getTransitionRouteGroupCallable()");
  }

  public UnaryCallable<CreateTransitionRouteGroupRequest, TransitionRouteGroup>
      createTransitionRouteGroupCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createTransitionRouteGroupCallable()");
  }

  public UnaryCallable<UpdateTransitionRouteGroupRequest, TransitionRouteGroup>
      updateTransitionRouteGroupCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateTransitionRouteGroupCallable()");
  }

  public UnaryCallable<DeleteTransitionRouteGroupRequest, Empty>
      deleteTransitionRouteGroupCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteTransitionRouteGroupCallable()");
  }

  @Override
  public abstract void close();
}
