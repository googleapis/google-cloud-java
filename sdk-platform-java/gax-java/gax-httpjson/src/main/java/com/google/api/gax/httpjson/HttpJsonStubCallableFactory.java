/*
 * Copyright 2018 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.httpjson;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.BatchingCallSettings;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.ServerStreamingCallSettings;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StreamingCallSettings;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;

public interface HttpJsonStubCallableFactory<
    OperationT, OperationsStub extends BackgroundResource> {

  /**
   * Create a callable object with http/json-specific functionality. Designed for use by generated
   * code.
   *
   * @param httpJsonCallSettings the http/json call settings
   * @param callSettings {@link UnaryCallSettings} to configure the method-level settings with
   * @param clientContext {@link ClientContext} to use to connect to the service
   * @return {@link UnaryCallable} callable object
   */
  <RequestT, ResponseT> UnaryCallable<RequestT, ResponseT> createUnaryCallable(
      HttpJsonCallSettings<RequestT, ResponseT> httpJsonCallSettings,
      UnaryCallSettings<RequestT, ResponseT> callSettings,
      ClientContext clientContext);

  /**
   * Create a paged callable object that represents a paged API method. Designed for use by
   * generated code.
   *
   * @param httpJsonCallSettings the http/json call settings
   * @param pagedCallSettings {@link PagedCallSettings} to configure the paged settings with
   * @param clientContext {@link ClientContext} to use to connect to the service
   * @return {@link UnaryCallable} callable object
   */
  <RequestT, ResponseT, PagedListResponseT>
      UnaryCallable<RequestT, PagedListResponseT> createPagedCallable(
          HttpJsonCallSettings<RequestT, ResponseT> httpJsonCallSettings,
          PagedCallSettings<RequestT, ResponseT, PagedListResponseT> pagedCallSettings,
          ClientContext clientContext);

  /**
   * Create a callable object that represents a batching API method. Designed for use by generated
   * code.
   *
   * @param httpJsonCallSettings the http/json call settings
   * @param batchingCallSettings {@link BatchingCallSettings} to configure the batching related
   *     settings with
   * @param clientContext {@link ClientContext} to use to connect to the service
   * @return {@link UnaryCallable} callable object
   */
  <RequestT, ResponseT> UnaryCallable<RequestT, ResponseT> createBatchingCallable(
      HttpJsonCallSettings<RequestT, ResponseT> httpJsonCallSettings,
      BatchingCallSettings<RequestT, ResponseT> batchingCallSettings,
      ClientContext clientContext);

  /**
   * Creates a callable object that represents a long-running operation. Designed for use by
   * generated code.
   *
   * @param httpJsonCallSettings the http/json call settings
   * @param operationCallSettings {@link OperationCallSettings} to configure the method-level
   *     settings with
   * @param clientContext {@link ClientContext} to use to connect to the service
   * @param operationsStub opertation stub to use to poll for updates on the Operation
   * @return {@link OperationCallable} callable object
   */
  <RequestT, ResponseT, MetadataT>
      OperationCallable<RequestT, ResponseT, MetadataT> createOperationCallable(
          HttpJsonCallSettings<RequestT, OperationT> httpJsonCallSettings,
          OperationCallSettings<RequestT, ResponseT, MetadataT> operationCallSettings,
          ClientContext clientContext,
          OperationsStub operationsStub);

  /**
   * Create a server-streaming callable with. Designed for use by generated code.
   *
   * @param httpJsonCallSettings the gRPC call settings
   * @param callSettings {@link StreamingCallSettings} to configure the method-level settings with.
   * @param clientContext {@link ClientContext} to use to connect to the service.
   */
  default <RequestT, ResponseT>
      ServerStreamingCallable<RequestT, ResponseT> createServerStreamingCallable(
          HttpJsonCallSettings<RequestT, ResponseT> httpJsonCallSettings,
          ServerStreamingCallSettings<RequestT, ResponseT> callSettings,
          ClientContext clientContext) {
    return HttpJsonCallableFactory.createServerStreamingCallable(
        httpJsonCallSettings, callSettings, clientContext);
  }
}
