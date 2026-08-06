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

package com.google.showcase.v1beta1.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ResumableUploadCallable;
import com.google.showcase.v1beta1.EchoRequest;
import com.google.showcase.v1beta1.EchoResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for resumable uploads in the Echo service API.
 *
 * <p>This stub contains only the Scotty resumable upload RPCs and is meant to be instantiated
 * inside both the standard gRPC and HTTP/JSON stubs without incurring the overhead of
 * loading all standard RPC callables.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonEchoResumableUploadStub extends EchoStub {
  private static final ApiMethodDescriptor<EchoRequest, EchoResponse>
      echoResumableUploadMethodDescriptor =
          ApiMethodDescriptor.<EchoRequest, EchoResponse>newBuilder()
              .setFullMethodName("google.showcase.v1beta1.Echo/EchoResumableUpload")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<EchoRequest>newBuilder()
                      .setPath("/v1beta1/echo:resumable", request -> new HashMap<>())
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<EchoResponse>newBuilder()
                      .setDefaultInstance(EchoResponse.getDefaultInstance())
                      .build())
              .build();

  private final ResumableUploadCallable<EchoRequest, EchoResponse> resumableUploadCallable;
  private final BackgroundResource backgroundResources;

  public static final HttpJsonEchoResumableUploadStub create(
      EchoStubSettings settings, ClientContext clientContext) throws IOException {
    return new HttpJsonEchoResumableUploadStub(settings, clientContext);
  }

  protected HttpJsonEchoResumableUploadStub(EchoStubSettings settings, ClientContext clientContext)
      throws IOException {
    this.backgroundResources =
        new BackgroundResourceAggregation(
            Collections.singletonList(clientContext.getTransportChannel()));

    HttpJsonCallSettings<EchoRequest, EchoResponse> resumableUploadTransportSettings =
        HttpJsonCallSettings.<EchoRequest, EchoResponse>newBuilder()
            .setMethodDescriptor(echoResumableUploadMethodDescriptor)
            .build();
    this.resumableUploadCallable =
        HttpJsonCallableFactory.createResumableUploadCallable(
            resumableUploadTransportSettings, settings.resumableUploadSettings(), clientContext);
  }

  @Override
  public ResumableUploadCallable<EchoRequest, EchoResponse> resumableUploadCallable() {
    return resumableUploadCallable;
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}
