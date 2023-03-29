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

package com.google.cloud.vision.v1p4beta1.stub;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonOperationSnapshot;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.httpjson.longrunning.stub.HttpJsonOperationsStub;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.vision.v1p4beta1.AsyncBatchAnnotateFilesRequest;
import com.google.cloud.vision.v1p4beta1.AsyncBatchAnnotateFilesResponse;
import com.google.cloud.vision.v1p4beta1.AsyncBatchAnnotateImagesRequest;
import com.google.cloud.vision.v1p4beta1.AsyncBatchAnnotateImagesResponse;
import com.google.cloud.vision.v1p4beta1.BatchAnnotateFilesRequest;
import com.google.cloud.vision.v1p4beta1.BatchAnnotateFilesResponse;
import com.google.cloud.vision.v1p4beta1.BatchAnnotateImagesRequest;
import com.google.cloud.vision.v1p4beta1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1p4beta1.OperationMetadata;
import com.google.longrunning.Operation;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the ImageAnnotator service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonImageAnnotatorStub extends ImageAnnotatorStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(OperationMetadata.getDescriptor())
          .add(AsyncBatchAnnotateFilesResponse.getDescriptor())
          .add(AsyncBatchAnnotateImagesResponse.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<BatchAnnotateImagesRequest, BatchAnnotateImagesResponse>
      batchAnnotateImagesMethodDescriptor =
          ApiMethodDescriptor.<BatchAnnotateImagesRequest, BatchAnnotateImagesResponse>newBuilder()
              .setFullMethodName("google.cloud.vision.v1p4beta1.ImageAnnotator/BatchAnnotateImages")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchAnnotateImagesRequest>newBuilder()
                      .setPath(
                          "/v1p4beta1/images:annotate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchAnnotateImagesRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchAnnotateImagesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchAnnotateImagesResponse>newBuilder()
                      .setDefaultInstance(BatchAnnotateImagesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<BatchAnnotateFilesRequest, BatchAnnotateFilesResponse>
      batchAnnotateFilesMethodDescriptor =
          ApiMethodDescriptor.<BatchAnnotateFilesRequest, BatchAnnotateFilesResponse>newBuilder()
              .setFullMethodName("google.cloud.vision.v1p4beta1.ImageAnnotator/BatchAnnotateFiles")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchAnnotateFilesRequest>newBuilder()
                      .setPath(
                          "/v1p4beta1/files:annotate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchAnnotateFilesRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchAnnotateFilesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchAnnotateFilesResponse>newBuilder()
                      .setDefaultInstance(BatchAnnotateFilesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<AsyncBatchAnnotateImagesRequest, Operation>
      asyncBatchAnnotateImagesMethodDescriptor =
          ApiMethodDescriptor.<AsyncBatchAnnotateImagesRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.vision.v1p4beta1.ImageAnnotator/AsyncBatchAnnotateImages")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AsyncBatchAnnotateImagesRequest>newBuilder()
                      .setPath(
                          "/v1p4beta1/images:asyncBatchAnnotate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AsyncBatchAnnotateImagesRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AsyncBatchAnnotateImagesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (AsyncBatchAnnotateImagesRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<AsyncBatchAnnotateFilesRequest, Operation>
      asyncBatchAnnotateFilesMethodDescriptor =
          ApiMethodDescriptor.<AsyncBatchAnnotateFilesRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.vision.v1p4beta1.ImageAnnotator/AsyncBatchAnnotateFiles")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AsyncBatchAnnotateFilesRequest>newBuilder()
                      .setPath(
                          "/v1p4beta1/files:asyncBatchAnnotate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AsyncBatchAnnotateFilesRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AsyncBatchAnnotateFilesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (AsyncBatchAnnotateFilesRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private final UnaryCallable<BatchAnnotateImagesRequest, BatchAnnotateImagesResponse>
      batchAnnotateImagesCallable;
  private final UnaryCallable<BatchAnnotateFilesRequest, BatchAnnotateFilesResponse>
      batchAnnotateFilesCallable;
  private final UnaryCallable<AsyncBatchAnnotateImagesRequest, Operation>
      asyncBatchAnnotateImagesCallable;
  private final OperationCallable<
          AsyncBatchAnnotateImagesRequest, AsyncBatchAnnotateImagesResponse, OperationMetadata>
      asyncBatchAnnotateImagesOperationCallable;
  private final UnaryCallable<AsyncBatchAnnotateFilesRequest, Operation>
      asyncBatchAnnotateFilesCallable;
  private final OperationCallable<
          AsyncBatchAnnotateFilesRequest, AsyncBatchAnnotateFilesResponse, OperationMetadata>
      asyncBatchAnnotateFilesOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonImageAnnotatorStub create(ImageAnnotatorStubSettings settings)
      throws IOException {
    return new HttpJsonImageAnnotatorStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonImageAnnotatorStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonImageAnnotatorStub(
        ImageAnnotatorStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonImageAnnotatorStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonImageAnnotatorStub(
        ImageAnnotatorStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonImageAnnotatorStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonImageAnnotatorStub(
      ImageAnnotatorStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonImageAnnotatorCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonImageAnnotatorStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonImageAnnotatorStub(
      ImageAnnotatorStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<BatchAnnotateImagesRequest, BatchAnnotateImagesResponse>
        batchAnnotateImagesTransportSettings =
            HttpJsonCallSettings
                .<BatchAnnotateImagesRequest, BatchAnnotateImagesResponse>newBuilder()
                .setMethodDescriptor(batchAnnotateImagesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<BatchAnnotateFilesRequest, BatchAnnotateFilesResponse>
        batchAnnotateFilesTransportSettings =
            HttpJsonCallSettings.<BatchAnnotateFilesRequest, BatchAnnotateFilesResponse>newBuilder()
                .setMethodDescriptor(batchAnnotateFilesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<AsyncBatchAnnotateImagesRequest, Operation>
        asyncBatchAnnotateImagesTransportSettings =
            HttpJsonCallSettings.<AsyncBatchAnnotateImagesRequest, Operation>newBuilder()
                .setMethodDescriptor(asyncBatchAnnotateImagesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<AsyncBatchAnnotateFilesRequest, Operation>
        asyncBatchAnnotateFilesTransportSettings =
            HttpJsonCallSettings.<AsyncBatchAnnotateFilesRequest, Operation>newBuilder()
                .setMethodDescriptor(asyncBatchAnnotateFilesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.batchAnnotateImagesCallable =
        callableFactory.createUnaryCallable(
            batchAnnotateImagesTransportSettings,
            settings.batchAnnotateImagesSettings(),
            clientContext);
    this.batchAnnotateFilesCallable =
        callableFactory.createUnaryCallable(
            batchAnnotateFilesTransportSettings,
            settings.batchAnnotateFilesSettings(),
            clientContext);
    this.asyncBatchAnnotateImagesCallable =
        callableFactory.createUnaryCallable(
            asyncBatchAnnotateImagesTransportSettings,
            settings.asyncBatchAnnotateImagesSettings(),
            clientContext);
    this.asyncBatchAnnotateImagesOperationCallable =
        callableFactory.createOperationCallable(
            asyncBatchAnnotateImagesTransportSettings,
            settings.asyncBatchAnnotateImagesOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.asyncBatchAnnotateFilesCallable =
        callableFactory.createUnaryCallable(
            asyncBatchAnnotateFilesTransportSettings,
            settings.asyncBatchAnnotateFilesSettings(),
            clientContext);
    this.asyncBatchAnnotateFilesOperationCallable =
        callableFactory.createOperationCallable(
            asyncBatchAnnotateFilesTransportSettings,
            settings.asyncBatchAnnotateFilesOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(batchAnnotateImagesMethodDescriptor);
    methodDescriptors.add(batchAnnotateFilesMethodDescriptor);
    methodDescriptors.add(asyncBatchAnnotateImagesMethodDescriptor);
    methodDescriptors.add(asyncBatchAnnotateFilesMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<BatchAnnotateImagesRequest, BatchAnnotateImagesResponse>
      batchAnnotateImagesCallable() {
    return batchAnnotateImagesCallable;
  }

  @Override
  public UnaryCallable<BatchAnnotateFilesRequest, BatchAnnotateFilesResponse>
      batchAnnotateFilesCallable() {
    return batchAnnotateFilesCallable;
  }

  @Override
  public UnaryCallable<AsyncBatchAnnotateImagesRequest, Operation>
      asyncBatchAnnotateImagesCallable() {
    return asyncBatchAnnotateImagesCallable;
  }

  @Override
  public OperationCallable<
          AsyncBatchAnnotateImagesRequest, AsyncBatchAnnotateImagesResponse, OperationMetadata>
      asyncBatchAnnotateImagesOperationCallable() {
    return asyncBatchAnnotateImagesOperationCallable;
  }

  @Override
  public UnaryCallable<AsyncBatchAnnotateFilesRequest, Operation>
      asyncBatchAnnotateFilesCallable() {
    return asyncBatchAnnotateFilesCallable;
  }

  @Override
  public OperationCallable<
          AsyncBatchAnnotateFilesRequest, AsyncBatchAnnotateFilesResponse, OperationMetadata>
      asyncBatchAnnotateFilesOperationCallable() {
    return asyncBatchAnnotateFilesOperationCallable;
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
