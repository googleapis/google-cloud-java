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

package com.google.cloud.retail.v2alpha.stub;

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
import com.google.cloud.retail.v2alpha.CreateMerchantCenterAccountLinkMetadata;
import com.google.cloud.retail.v2alpha.CreateMerchantCenterAccountLinkRequest;
import com.google.cloud.retail.v2alpha.DeleteMerchantCenterAccountLinkRequest;
import com.google.cloud.retail.v2alpha.ListMerchantCenterAccountLinksRequest;
import com.google.cloud.retail.v2alpha.ListMerchantCenterAccountLinksResponse;
import com.google.cloud.retail.v2alpha.MerchantCenterAccountLink;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
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
 * REST stub implementation for the MerchantCenterAccountLinkService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonMerchantCenterAccountLinkServiceStub
    extends MerchantCenterAccountLinkServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(CreateMerchantCenterAccountLinkMetadata.getDescriptor())
          .add(MerchantCenterAccountLink.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<
          ListMerchantCenterAccountLinksRequest, ListMerchantCenterAccountLinksResponse>
      listMerchantCenterAccountLinksMethodDescriptor =
          ApiMethodDescriptor
              .<ListMerchantCenterAccountLinksRequest, ListMerchantCenterAccountLinksResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.retail.v2alpha.MerchantCenterAccountLinkService/ListMerchantCenterAccountLinks")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListMerchantCenterAccountLinksRequest>newBuilder()
                      .setPath(
                          "/v2alpha/{parent=projects/*/locations/*/catalogs/*}/merchantCenterAccountLinks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListMerchantCenterAccountLinksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListMerchantCenterAccountLinksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListMerchantCenterAccountLinksResponse>newBuilder()
                      .setDefaultInstance(
                          ListMerchantCenterAccountLinksResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateMerchantCenterAccountLinkRequest, Operation>
      createMerchantCenterAccountLinkMethodDescriptor =
          ApiMethodDescriptor.<CreateMerchantCenterAccountLinkRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.retail.v2alpha.MerchantCenterAccountLinkService/CreateMerchantCenterAccountLink")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateMerchantCenterAccountLinkRequest>newBuilder()
                      .setPath(
                          "/v2alpha/{parent=projects/*/locations/*/catalogs/*}/merchantCenterAccountLinks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateMerchantCenterAccountLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateMerchantCenterAccountLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "merchantCenterAccountLink",
                                      request.getMerchantCenterAccountLink(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateMerchantCenterAccountLinkRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteMerchantCenterAccountLinkRequest, Empty>
      deleteMerchantCenterAccountLinkMethodDescriptor =
          ApiMethodDescriptor.<DeleteMerchantCenterAccountLinkRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.retail.v2alpha.MerchantCenterAccountLinkService/DeleteMerchantCenterAccountLink")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteMerchantCenterAccountLinkRequest>newBuilder()
                      .setPath(
                          "/v2alpha/{name=projects/*/locations/*/catalogs/*/merchantCenterAccountLinks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteMerchantCenterAccountLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteMerchantCenterAccountLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<
          ListMerchantCenterAccountLinksRequest, ListMerchantCenterAccountLinksResponse>
      listMerchantCenterAccountLinksCallable;
  private final UnaryCallable<CreateMerchantCenterAccountLinkRequest, Operation>
      createMerchantCenterAccountLinkCallable;
  private final OperationCallable<
          CreateMerchantCenterAccountLinkRequest,
          MerchantCenterAccountLink,
          CreateMerchantCenterAccountLinkMetadata>
      createMerchantCenterAccountLinkOperationCallable;
  private final UnaryCallable<DeleteMerchantCenterAccountLinkRequest, Empty>
      deleteMerchantCenterAccountLinkCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonMerchantCenterAccountLinkServiceStub create(
      MerchantCenterAccountLinkServiceStubSettings settings) throws IOException {
    return new HttpJsonMerchantCenterAccountLinkServiceStub(
        settings, ClientContext.create(settings));
  }

  public static final HttpJsonMerchantCenterAccountLinkServiceStub create(
      ClientContext clientContext) throws IOException {
    return new HttpJsonMerchantCenterAccountLinkServiceStub(
        MerchantCenterAccountLinkServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonMerchantCenterAccountLinkServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonMerchantCenterAccountLinkServiceStub(
        MerchantCenterAccountLinkServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonMerchantCenterAccountLinkServiceStub, using the given
   * settings. This is protected so that it is easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected HttpJsonMerchantCenterAccountLinkServiceStub(
      MerchantCenterAccountLinkServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonMerchantCenterAccountLinkServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonMerchantCenterAccountLinkServiceStub, using the given
   * settings. This is protected so that it is easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected HttpJsonMerchantCenterAccountLinkServiceStub(
      MerchantCenterAccountLinkServiceStubSettings settings,
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
                            "/v2alpha/{name=projects/*/locations/*/catalogs/*/branches/*/operations/*}")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v2alpha/{name=projects/*/locations/*/catalogs/*/branches/*/places/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v2alpha/{name=projects/*/locations/*/catalogs/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v2alpha/{name=projects/*/locations/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v2alpha/{name=projects/*/operations/*}")
                                .build())
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v2alpha/{name=projects/*/locations/*/catalogs/*}/operations")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v2alpha/{name=projects/*/locations/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v2alpha/{name=projects/*}/operations")
                                .build())
                        .build())
                .build());

    HttpJsonCallSettings<
            ListMerchantCenterAccountLinksRequest, ListMerchantCenterAccountLinksResponse>
        listMerchantCenterAccountLinksTransportSettings =
            HttpJsonCallSettings
                .<ListMerchantCenterAccountLinksRequest, ListMerchantCenterAccountLinksResponse>
                    newBuilder()
                .setMethodDescriptor(listMerchantCenterAccountLinksMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateMerchantCenterAccountLinkRequest, Operation>
        createMerchantCenterAccountLinkTransportSettings =
            HttpJsonCallSettings.<CreateMerchantCenterAccountLinkRequest, Operation>newBuilder()
                .setMethodDescriptor(createMerchantCenterAccountLinkMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteMerchantCenterAccountLinkRequest, Empty>
        deleteMerchantCenterAccountLinkTransportSettings =
            HttpJsonCallSettings.<DeleteMerchantCenterAccountLinkRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteMerchantCenterAccountLinkMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();

    this.listMerchantCenterAccountLinksCallable =
        callableFactory.createUnaryCallable(
            listMerchantCenterAccountLinksTransportSettings,
            settings.listMerchantCenterAccountLinksSettings(),
            clientContext);
    this.createMerchantCenterAccountLinkCallable =
        callableFactory.createUnaryCallable(
            createMerchantCenterAccountLinkTransportSettings,
            settings.createMerchantCenterAccountLinkSettings(),
            clientContext);
    this.createMerchantCenterAccountLinkOperationCallable =
        callableFactory.createOperationCallable(
            createMerchantCenterAccountLinkTransportSettings,
            settings.createMerchantCenterAccountLinkOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteMerchantCenterAccountLinkCallable =
        callableFactory.createUnaryCallable(
            deleteMerchantCenterAccountLinkTransportSettings,
            settings.deleteMerchantCenterAccountLinkSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listMerchantCenterAccountLinksMethodDescriptor);
    methodDescriptors.add(createMerchantCenterAccountLinkMethodDescriptor);
    methodDescriptors.add(deleteMerchantCenterAccountLinkMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<
          ListMerchantCenterAccountLinksRequest, ListMerchantCenterAccountLinksResponse>
      listMerchantCenterAccountLinksCallable() {
    return listMerchantCenterAccountLinksCallable;
  }

  @Override
  public UnaryCallable<CreateMerchantCenterAccountLinkRequest, Operation>
      createMerchantCenterAccountLinkCallable() {
    return createMerchantCenterAccountLinkCallable;
  }

  @Override
  public OperationCallable<
          CreateMerchantCenterAccountLinkRequest,
          MerchantCenterAccountLink,
          CreateMerchantCenterAccountLinkMetadata>
      createMerchantCenterAccountLinkOperationCallable() {
    return createMerchantCenterAccountLinkOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteMerchantCenterAccountLinkRequest, Empty>
      deleteMerchantCenterAccountLinkCallable() {
    return deleteMerchantCenterAccountLinkCallable;
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
