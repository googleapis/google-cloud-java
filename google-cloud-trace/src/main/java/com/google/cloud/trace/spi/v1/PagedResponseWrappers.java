/*
 * Copyright 2016, Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.trace.spi.v1;

import com.google.api.gax.grpc.CallContext;
import com.google.api.gax.grpc.PagedListDescriptor;
import com.google.api.gax.grpc.PagedListResponseImpl;
import com.google.api.gax.grpc.UnaryCallable;
import com.google.devtools.cloudtrace.v1.ListTracesRequest;
import com.google.devtools.cloudtrace.v1.ListTracesResponse;
import com.google.devtools.cloudtrace.v1.Trace;
import com.google.protobuf.ExperimentalApi;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Wrapper class to contain paged response types for page streaming methods. Each static class
 * inside this wrapper class is used as the return type of one of an API method that implements the
 * page streaming pattern.
 */
@Generated("by GAPIC")
@ExperimentalApi
public class PagedResponseWrappers {

  public static class ListTracesPagedResponse
      extends PagedListResponseImpl<ListTracesRequest, ListTracesResponse, Trace> {

    public ListTracesPagedResponse(
        UnaryCallable<ListTracesRequest, ListTracesResponse> callable,
        PagedListDescriptor<ListTracesRequest, ListTracesResponse, Trace> pageDescriptor,
        ListTracesRequest request,
        CallContext context) {
      super(callable, pageDescriptor, request, context);
    }
  }
}
