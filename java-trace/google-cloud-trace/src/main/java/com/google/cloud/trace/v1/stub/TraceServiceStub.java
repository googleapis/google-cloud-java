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

package com.google.cloud.trace.v1.stub;

import static com.google.cloud.trace.v1.TraceServiceClient.ListTracesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.devtools.cloudtrace.v1.GetTraceRequest;
import com.google.devtools.cloudtrace.v1.ListTracesRequest;
import com.google.devtools.cloudtrace.v1.ListTracesResponse;
import com.google.devtools.cloudtrace.v1.PatchTracesRequest;
import com.google.devtools.cloudtrace.v1.Trace;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the TraceService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class TraceServiceStub implements BackgroundResource {

  public UnaryCallable<ListTracesRequest, ListTracesPagedResponse> listTracesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listTracesPagedCallable()");
  }

  public UnaryCallable<ListTracesRequest, ListTracesResponse> listTracesCallable() {
    throw new UnsupportedOperationException("Not implemented: listTracesCallable()");
  }

  public UnaryCallable<GetTraceRequest, Trace> getTraceCallable() {
    throw new UnsupportedOperationException("Not implemented: getTraceCallable()");
  }

  public UnaryCallable<PatchTracesRequest, Empty> patchTracesCallable() {
    throw new UnsupportedOperationException("Not implemented: patchTracesCallable()");
  }

  @Override
  public abstract void close();
}
