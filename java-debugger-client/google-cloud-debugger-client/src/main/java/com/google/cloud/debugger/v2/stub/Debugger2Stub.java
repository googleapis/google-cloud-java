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

package com.google.cloud.debugger.v2.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.devtools.clouddebugger.v2.DeleteBreakpointRequest;
import com.google.devtools.clouddebugger.v2.GetBreakpointRequest;
import com.google.devtools.clouddebugger.v2.GetBreakpointResponse;
import com.google.devtools.clouddebugger.v2.ListBreakpointsRequest;
import com.google.devtools.clouddebugger.v2.ListBreakpointsResponse;
import com.google.devtools.clouddebugger.v2.ListDebuggeesRequest;
import com.google.devtools.clouddebugger.v2.ListDebuggeesResponse;
import com.google.devtools.clouddebugger.v2.SetBreakpointRequest;
import com.google.devtools.clouddebugger.v2.SetBreakpointResponse;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Debugger2 service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class Debugger2Stub implements BackgroundResource {

  public UnaryCallable<SetBreakpointRequest, SetBreakpointResponse> setBreakpointCallable() {
    throw new UnsupportedOperationException("Not implemented: setBreakpointCallable()");
  }

  public UnaryCallable<GetBreakpointRequest, GetBreakpointResponse> getBreakpointCallable() {
    throw new UnsupportedOperationException("Not implemented: getBreakpointCallable()");
  }

  public UnaryCallable<DeleteBreakpointRequest, Empty> deleteBreakpointCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteBreakpointCallable()");
  }

  public UnaryCallable<ListBreakpointsRequest, ListBreakpointsResponse> listBreakpointsCallable() {
    throw new UnsupportedOperationException("Not implemented: listBreakpointsCallable()");
  }

  public UnaryCallable<ListDebuggeesRequest, ListDebuggeesResponse> listDebuggeesCallable() {
    throw new UnsupportedOperationException("Not implemented: listDebuggeesCallable()");
  }

  @Override
  public abstract void close();
}
