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

package com.google.shopping.merchant.productstudio.v1alpha.stub;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.TypeRegistry;
import com.google.shopping.merchant.productstudio.v1alpha.GenerateProductImageBackgroundRequest;
import com.google.shopping.merchant.productstudio.v1alpha.GenerateProductImageBackgroundResponse;
import com.google.shopping.merchant.productstudio.v1alpha.RemoveProductImageBackgroundRequest;
import com.google.shopping.merchant.productstudio.v1alpha.RemoveProductImageBackgroundResponse;
import com.google.shopping.merchant.productstudio.v1alpha.UpscaleProductImageRequest;
import com.google.shopping.merchant.productstudio.v1alpha.UpscaleProductImageResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the ImageService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonImageServiceStub extends ImageServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<
          GenerateProductImageBackgroundRequest, GenerateProductImageBackgroundResponse>
      generateProductImageBackgroundMethodDescriptor =
          ApiMethodDescriptor
              .<GenerateProductImageBackgroundRequest, GenerateProductImageBackgroundResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.productstudio.v1alpha.ImageService/GenerateProductImageBackground")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GenerateProductImageBackgroundRequest>newBuilder()
                      .setPath(
                          "/productstudio/v1alpha/{name=accounts/*}/generatedImages:generateProductImageBackground",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateProductImageBackgroundRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateProductImageBackgroundRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GenerateProductImageBackgroundResponse>newBuilder()
                      .setDefaultInstance(
                          GenerateProductImageBackgroundResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          RemoveProductImageBackgroundRequest, RemoveProductImageBackgroundResponse>
      removeProductImageBackgroundMethodDescriptor =
          ApiMethodDescriptor
              .<RemoveProductImageBackgroundRequest, RemoveProductImageBackgroundResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.productstudio.v1alpha.ImageService/RemoveProductImageBackground")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RemoveProductImageBackgroundRequest>newBuilder()
                      .setPath(
                          "/productstudio/v1alpha/{name=accounts/*}/generatedImages:removeProductImageBackground",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveProductImageBackgroundRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveProductImageBackgroundRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RemoveProductImageBackgroundResponse>newBuilder()
                      .setDefaultInstance(RemoveProductImageBackgroundResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpscaleProductImageRequest, UpscaleProductImageResponse>
      upscaleProductImageMethodDescriptor =
          ApiMethodDescriptor.<UpscaleProductImageRequest, UpscaleProductImageResponse>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.productstudio.v1alpha.ImageService/UpscaleProductImage")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpscaleProductImageRequest>newBuilder()
                      .setPath(
                          "/productstudio/v1alpha/{name=accounts/*}/generatedImages:upscaleProductImage",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpscaleProductImageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpscaleProductImageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UpscaleProductImageResponse>newBuilder()
                      .setDefaultInstance(UpscaleProductImageResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<
          GenerateProductImageBackgroundRequest, GenerateProductImageBackgroundResponse>
      generateProductImageBackgroundCallable;
  private final UnaryCallable<
          RemoveProductImageBackgroundRequest, RemoveProductImageBackgroundResponse>
      removeProductImageBackgroundCallable;
  private final UnaryCallable<UpscaleProductImageRequest, UpscaleProductImageResponse>
      upscaleProductImageCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonImageServiceStub create(ImageServiceStubSettings settings)
      throws IOException {
    return new HttpJsonImageServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonImageServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonImageServiceStub(
        ImageServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonImageServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonImageServiceStub(
        ImageServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonImageServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonImageServiceStub(ImageServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonImageServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonImageServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonImageServiceStub(
      ImageServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<
            GenerateProductImageBackgroundRequest, GenerateProductImageBackgroundResponse>
        generateProductImageBackgroundTransportSettings =
            HttpJsonCallSettings
                .<GenerateProductImageBackgroundRequest, GenerateProductImageBackgroundResponse>
                    newBuilder()
                .setMethodDescriptor(generateProductImageBackgroundMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<RemoveProductImageBackgroundRequest, RemoveProductImageBackgroundResponse>
        removeProductImageBackgroundTransportSettings =
            HttpJsonCallSettings
                .<RemoveProductImageBackgroundRequest, RemoveProductImageBackgroundResponse>
                    newBuilder()
                .setMethodDescriptor(removeProductImageBackgroundMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpscaleProductImageRequest, UpscaleProductImageResponse>
        upscaleProductImageTransportSettings =
            HttpJsonCallSettings
                .<UpscaleProductImageRequest, UpscaleProductImageResponse>newBuilder()
                .setMethodDescriptor(upscaleProductImageMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();

    this.generateProductImageBackgroundCallable =
        callableFactory.createUnaryCallable(
            generateProductImageBackgroundTransportSettings,
            settings.generateProductImageBackgroundSettings(),
            clientContext);
    this.removeProductImageBackgroundCallable =
        callableFactory.createUnaryCallable(
            removeProductImageBackgroundTransportSettings,
            settings.removeProductImageBackgroundSettings(),
            clientContext);
    this.upscaleProductImageCallable =
        callableFactory.createUnaryCallable(
            upscaleProductImageTransportSettings,
            settings.upscaleProductImageSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(generateProductImageBackgroundMethodDescriptor);
    methodDescriptors.add(removeProductImageBackgroundMethodDescriptor);
    methodDescriptors.add(upscaleProductImageMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<
          GenerateProductImageBackgroundRequest, GenerateProductImageBackgroundResponse>
      generateProductImageBackgroundCallable() {
    return generateProductImageBackgroundCallable;
  }

  @Override
  public UnaryCallable<RemoveProductImageBackgroundRequest, RemoveProductImageBackgroundResponse>
      removeProductImageBackgroundCallable() {
    return removeProductImageBackgroundCallable;
  }

  @Override
  public UnaryCallable<UpscaleProductImageRequest, UpscaleProductImageResponse>
      upscaleProductImageCallable() {
    return upscaleProductImageCallable;
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
