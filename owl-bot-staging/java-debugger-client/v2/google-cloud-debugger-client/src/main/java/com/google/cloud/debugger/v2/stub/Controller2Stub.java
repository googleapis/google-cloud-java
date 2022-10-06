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
import com.google.devtools.clouddebugger.v2.ListActiveBreakpointsRequest;
import com.google.devtools.clouddebugger.v2.ListActiveBreakpointsResponse;
import com.google.devtools.clouddebugger.v2.RegisterDebuggeeRequest;
import com.google.devtools.clouddebugger.v2.RegisterDebuggeeResponse;
import com.google.devtools.clouddebugger.v2.UpdateActiveBreakpointRequest;
import com.google.devtools.clouddebugger.v2.UpdateActiveBreakpointResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Controller2 service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class Controller2Stub implements BackgroundResource {

  public UnaryCallable<RegisterDebuggeeRequest, RegisterDebuggeeResponse>
      registerDebuggeeCallable() {
    throw new UnsupportedOperationException("Not implemented: registerDebuggeeCallable()");
  }

  public UnaryCallable<ListActiveBreakpointsRequest, ListActiveBreakpointsResponse>
      listActiveBreakpointsCallable() {
    throw new UnsupportedOperationException("Not implemented: listActiveBreakpointsCallable()");
  }

  public UnaryCallable<UpdateActiveBreakpointRequest, UpdateActiveBreakpointResponse>
      updateActiveBreakpointCallable() {
    throw new UnsupportedOperationException("Not implemented: updateActiveBreakpointCallable()");
  }

  @Override
  public abstract void close();
}
