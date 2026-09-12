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
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallContext;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonCallableFactory;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.ManagedHttpJsonChannel;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ResumableUploadCallable;
import com.google.common.collect.Maps;
import com.google.protobuf.TypeRegistry;
import com.google.showcase.v1beta1.UploadMediaRequest;
import com.google.showcase.v1beta1.UploadMediaResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub transport for the resumable upload methods of ResumableUploadService.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@InternalApi
@NullMarked
@BetaApi
public class HttpJsonResumableUploadServiceResumableUploadStub implements BackgroundResource {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<UploadMediaRequest, UploadMediaResponse>
      uploadMediaStartUploadMethodDescriptor =
          ApiMethodDescriptor.<UploadMediaRequest, UploadMediaResponse>newBuilder()
              .setFullMethodName("google.showcase.v1beta1.ResumableUploadService/UploadMedia")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UploadMediaRequest>newBuilder()
                      .setPath(
                          "/resumable/upload/v1beta1/files:upload",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UploadMediaRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UploadMediaRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UploadMediaResponse>newBuilder()
                      .setDefaultInstance(UploadMediaResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final BackgroundResource backgroundResources;
  private final ResumableUploadCallable<UploadMediaRequest, UploadMediaResponse>
      uploadMediaCallable;

  public static HttpJsonResumableUploadServiceResumableUploadStub create(
      ClientContext clientContext, ResumableUploadServiceStubSettings settings) {
    return new HttpJsonResumableUploadServiceResumableUploadStub(clientContext, settings);
  }

  /**
   * Constructs an instance from the given client context, deriving a dedicated HTTP/JSON client
   * context for the upload transport.
   *
   * <p>Resumable uploads always execute over HTTP/JSON, so the upload stub stands up its own
   * transport channel instead of sharing the caller's. Credentials, headers, executor and clock are
   * inherited from the given client context. The returned stub is registered as a background
   * resource of the caller and is closed with it.
   */
  public static HttpJsonResumableUploadServiceResumableUploadStub createFrom(
      ClientContext clientContext, ResumableUploadServiceStubSettings settings) {
    String uploadEndpoint =
        clientContext.getEndpoint() != null ? clientContext.getEndpoint() : settings.getEndpoint();
    ManagedHttpJsonChannel httpJsonManagedChannel =
        ManagedHttpJsonChannel.newBuilder()
            .setEndpoint(uploadEndpoint)
            .setExecutor(clientContext.getExecutor())
            .build();
    HttpJsonTransportChannel httpJsonTransportChannel =
        HttpJsonTransportChannel.create(httpJsonManagedChannel);
    Map<String, String> uploadHeaders =
        new HashMap<>(
            ResumableUploadServiceStubSettings.defaultHttpJsonApiClientHeaderProviderBuilder()
                .build()
                .getHeaders());
    uploadHeaders.putAll(clientContext.getHeaders());
    ClientContext httpJsonClientContext =
        ClientContext.newBuilder()
            .setCredentials(clientContext.getCredentials())
            .setEndpoint(uploadEndpoint)
            .setExecutor(clientContext.getExecutor())
            .setClock(clientContext.getClock())
            .setTransportChannel(httpJsonTransportChannel)
            .setDefaultCallContext(
                HttpJsonCallContext.createDefault()
                    .withTransportChannel(httpJsonTransportChannel)
                    .withCredentials(clientContext.getCredentials())
                    .withExtraHeaders(
                        Maps.transformValues(
                            uploadHeaders, value -> Collections.singletonList(value))))
            .setBackgroundResources(Arrays.asList(httpJsonTransportChannel))
            .build();
    return create(httpJsonClientContext, settings);
  }

  /**
   * Constructs an instance of HttpJsonResumableUploadServiceResumableUploadStub, using the given
   * settings. This is protected so that it is easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected HttpJsonResumableUploadServiceResumableUploadStub(
      ClientContext clientContext, ResumableUploadServiceStubSettings settings) {
    HttpJsonCallSettings<UploadMediaRequest, UploadMediaResponse> uploadMediaTransportSettings =
        HttpJsonCallSettings.<UploadMediaRequest, UploadMediaResponse>newBuilder()
            .setMethodDescriptor(uploadMediaStartUploadMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    this.uploadMediaCallable =
        HttpJsonCallableFactory.createResumableUploadCallable(
            uploadMediaTransportSettings, settings.uploadMediaSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(uploadMediaStartUploadMethodDescriptor);
    return methodDescriptors;
  }

  public ResumableUploadCallable<UploadMediaRequest, UploadMediaResponse> uploadMediaCallable() {
    return uploadMediaCallable;
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
