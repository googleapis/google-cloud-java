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

package com.google.cloud.retail.v2.stub;

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
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.retail.v2.PredictRequest;
import com.google.cloud.retail.v2.PredictResponse;
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
 * REST stub implementation for the PredictionService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonPredictionServiceStub extends PredictionServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<PredictRequest, PredictResponse>
      predictMethodDescriptor =
          ApiMethodDescriptor.<PredictRequest, PredictResponse>newBuilder()
              .setFullMethodName("google.cloud.retail.v2.PredictionService/Predict")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PredictRequest>newBuilder()
                      .setPath(
                          "/v2/{placement=projects/*/locations/*/catalogs/*/placements/*}:predict",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PredictRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "placement", request.getPlacement());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{placement=projects/*/locations/*/catalogs/*/servingConfigs/*}:predict")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PredictRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearPlacement().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PredictResponse>newBuilder()
                      .setDefaultInstance(PredictResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<PredictRequest, PredictResponse> predictCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonPredictionServiceStub create(PredictionServiceStubSettings settings)
      throws IOException {
    return new HttpJsonPredictionServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonPredictionServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonPredictionServiceStub(
        PredictionServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonPredictionServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonPredictionServiceStub(
        PredictionServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonPredictionServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonPredictionServiceStub(
      PredictionServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonPredictionServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonPredictionServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonPredictionServiceStub(
      PredictionServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<PredictRequest, PredictResponse> predictTransportSettings =
        HttpJsonCallSettings.<PredictRequest, PredictResponse>newBuilder()
            .setMethodDescriptor(predictMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.predictCallable =
        callableFactory.createUnaryCallable(
            predictTransportSettings, settings.predictSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(predictMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<PredictRequest, PredictResponse> predictCallable() {
    return predictCallable;
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
