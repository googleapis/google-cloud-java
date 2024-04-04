/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.discoveryengine.v1alpha.stub;

import com.google.api.HttpRule;
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
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1alpha.EstimateDataSizeMetadata;
import com.google.cloud.discoveryengine.v1alpha.EstimateDataSizeRequest;
import com.google.cloud.discoveryengine.v1alpha.EstimateDataSizeResponse;
import com.google.common.collect.ImmutableMap;
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
 * REST stub implementation for the EstimateBillingService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonEstimateBillingServiceStub extends EstimateBillingServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(EstimateDataSizeMetadata.getDescriptor())
          .add(EstimateDataSizeResponse.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<EstimateDataSizeRequest, Operation>
      estimateDataSizeMethodDescriptor =
          ApiMethodDescriptor.<EstimateDataSizeRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.EstimateBillingService/EstimateDataSize")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<EstimateDataSizeRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{location=projects/*/locations/*}:estimateDataSize",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<EstimateDataSizeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "location", request.getLocation());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<EstimateDataSizeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearLocation().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (EstimateDataSizeRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private final UnaryCallable<EstimateDataSizeRequest, Operation> estimateDataSizeCallable;
  private final OperationCallable<
          EstimateDataSizeRequest, EstimateDataSizeResponse, EstimateDataSizeMetadata>
      estimateDataSizeOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonEstimateBillingServiceStub create(
      EstimateBillingServiceStubSettings settings) throws IOException {
    return new HttpJsonEstimateBillingServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonEstimateBillingServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonEstimateBillingServiceStub(
        EstimateBillingServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonEstimateBillingServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonEstimateBillingServiceStub(
        EstimateBillingServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonEstimateBillingServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonEstimateBillingServiceStub(
      EstimateBillingServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonEstimateBillingServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonEstimateBillingServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonEstimateBillingServiceStub(
      EstimateBillingServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(
            clientContext,
            callableFactory,
            typeRegistry,
            ImmutableMap.<String, HttpRule>builder()
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet(
                            "/v1alpha/{name=projects/*/locations/*/collections/*/dataConnector/operations/*}")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/branches/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/models/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/schemas/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/siteSearchEngine/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/siteSearchEngine/targetSites/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/engines/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/dataStores/*/branches/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/dataStores/*/models/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/dataStores/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/evaluations/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1alpha/{name=projects/*/locations/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1alpha/{name=projects/*/operations/*}")
                                .build())
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet(
                            "/v1alpha/{name=projects/*/locations/*/collections/*/dataConnector}/operations")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/branches/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/models/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/schemas/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/siteSearchEngine/targetSites}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/siteSearchEngine}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/engines/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/dataStores/*/branches/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/dataStores/*/models/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/dataStores/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1alpha/{name=projects/*/locations/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1alpha/{name=projects/*}/operations")
                                .build())
                        .build())
                .build());

    HttpJsonCallSettings<EstimateDataSizeRequest, Operation> estimateDataSizeTransportSettings =
        HttpJsonCallSettings.<EstimateDataSizeRequest, Operation>newBuilder()
            .setMethodDescriptor(estimateDataSizeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("location", String.valueOf(request.getLocation()));
                  return builder.build();
                })
            .build();

    this.estimateDataSizeCallable =
        callableFactory.createUnaryCallable(
            estimateDataSizeTransportSettings, settings.estimateDataSizeSettings(), clientContext);
    this.estimateDataSizeOperationCallable =
        callableFactory.createOperationCallable(
            estimateDataSizeTransportSettings,
            settings.estimateDataSizeOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(estimateDataSizeMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<EstimateDataSizeRequest, Operation> estimateDataSizeCallable() {
    return estimateDataSizeCallable;
  }

  @Override
  public OperationCallable<
          EstimateDataSizeRequest, EstimateDataSizeResponse, EstimateDataSizeMetadata>
      estimateDataSizeOperationCallable() {
    return estimateDataSizeOperationCallable;
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
