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

package com.google.cloud.policysimulator.v1.stub;

import static com.google.cloud.policysimulator.v1.OrgPolicyViolationsPreviewServiceClient.ListOrgPolicyViolationsPagedResponse;
import static com.google.cloud.policysimulator.v1.OrgPolicyViolationsPreviewServiceClient.ListOrgPolicyViolationsPreviewsPagedResponse;

import com.google.api.HttpRule;
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
import com.google.cloud.policysimulator.v1.CreateOrgPolicyViolationsPreviewOperationMetadata;
import com.google.cloud.policysimulator.v1.CreateOrgPolicyViolationsPreviewRequest;
import com.google.cloud.policysimulator.v1.GetOrgPolicyViolationsPreviewRequest;
import com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsPreviewsRequest;
import com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsPreviewsResponse;
import com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsRequest;
import com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsResponse;
import com.google.cloud.policysimulator.v1.OrgPolicyViolationsPreview;
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
 * REST stub implementation for the OrgPolicyViolationsPreviewService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonOrgPolicyViolationsPreviewServiceStub
    extends OrgPolicyViolationsPreviewServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(CreateOrgPolicyViolationsPreviewOperationMetadata.getDescriptor())
          .add(OrgPolicyViolationsPreview.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<
          ListOrgPolicyViolationsPreviewsRequest, ListOrgPolicyViolationsPreviewsResponse>
      listOrgPolicyViolationsPreviewsMethodDescriptor =
          ApiMethodDescriptor
              .<ListOrgPolicyViolationsPreviewsRequest, ListOrgPolicyViolationsPreviewsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.policysimulator.v1.OrgPolicyViolationsPreviewService/ListOrgPolicyViolationsPreviews")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListOrgPolicyViolationsPreviewsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=organizations/*/locations/*}/orgPolicyViolationsPreviews",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListOrgPolicyViolationsPreviewsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListOrgPolicyViolationsPreviewsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListOrgPolicyViolationsPreviewsResponse>newBuilder()
                      .setDefaultInstance(
                          ListOrgPolicyViolationsPreviewsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GetOrgPolicyViolationsPreviewRequest, OrgPolicyViolationsPreview>
      getOrgPolicyViolationsPreviewMethodDescriptor =
          ApiMethodDescriptor
              .<GetOrgPolicyViolationsPreviewRequest, OrgPolicyViolationsPreview>newBuilder()
              .setFullMethodName(
                  "google.cloud.policysimulator.v1.OrgPolicyViolationsPreviewService/GetOrgPolicyViolationsPreview")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetOrgPolicyViolationsPreviewRequest>newBuilder()
                      .setPath(
                          "/v1/{name=organizations/*/locations/*/orgPolicyViolationsPreviews/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetOrgPolicyViolationsPreviewRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetOrgPolicyViolationsPreviewRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<OrgPolicyViolationsPreview>newBuilder()
                      .setDefaultInstance(OrgPolicyViolationsPreview.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateOrgPolicyViolationsPreviewRequest, Operation>
      createOrgPolicyViolationsPreviewMethodDescriptor =
          ApiMethodDescriptor.<CreateOrgPolicyViolationsPreviewRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.policysimulator.v1.OrgPolicyViolationsPreviewService/CreateOrgPolicyViolationsPreview")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateOrgPolicyViolationsPreviewRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=organizations/*/locations/*}/orgPolicyViolationsPreviews",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateOrgPolicyViolationsPreviewRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateOrgPolicyViolationsPreviewRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields,
                                "orgPolicyViolationsPreviewId",
                                request.getOrgPolicyViolationsPreviewId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "orgPolicyViolationsPreview",
                                      request.getOrgPolicyViolationsPreview(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateOrgPolicyViolationsPreviewRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          ListOrgPolicyViolationsRequest, ListOrgPolicyViolationsResponse>
      listOrgPolicyViolationsMethodDescriptor =
          ApiMethodDescriptor
              .<ListOrgPolicyViolationsRequest, ListOrgPolicyViolationsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.policysimulator.v1.OrgPolicyViolationsPreviewService/ListOrgPolicyViolations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListOrgPolicyViolationsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=organizations/*/locations/*/orgPolicyViolationsPreviews/*}/orgPolicyViolations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListOrgPolicyViolationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListOrgPolicyViolationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListOrgPolicyViolationsResponse>newBuilder()
                      .setDefaultInstance(ListOrgPolicyViolationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<
          ListOrgPolicyViolationsPreviewsRequest, ListOrgPolicyViolationsPreviewsResponse>
      listOrgPolicyViolationsPreviewsCallable;
  private final UnaryCallable<
          ListOrgPolicyViolationsPreviewsRequest, ListOrgPolicyViolationsPreviewsPagedResponse>
      listOrgPolicyViolationsPreviewsPagedCallable;
  private final UnaryCallable<GetOrgPolicyViolationsPreviewRequest, OrgPolicyViolationsPreview>
      getOrgPolicyViolationsPreviewCallable;
  private final UnaryCallable<CreateOrgPolicyViolationsPreviewRequest, Operation>
      createOrgPolicyViolationsPreviewCallable;
  private final OperationCallable<
          CreateOrgPolicyViolationsPreviewRequest,
          OrgPolicyViolationsPreview,
          CreateOrgPolicyViolationsPreviewOperationMetadata>
      createOrgPolicyViolationsPreviewOperationCallable;
  private final UnaryCallable<ListOrgPolicyViolationsRequest, ListOrgPolicyViolationsResponse>
      listOrgPolicyViolationsCallable;
  private final UnaryCallable<ListOrgPolicyViolationsRequest, ListOrgPolicyViolationsPagedResponse>
      listOrgPolicyViolationsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonOrgPolicyViolationsPreviewServiceStub create(
      OrgPolicyViolationsPreviewServiceStubSettings settings) throws IOException {
    return new HttpJsonOrgPolicyViolationsPreviewServiceStub(
        settings, ClientContext.create(settings));
  }

  public static final HttpJsonOrgPolicyViolationsPreviewServiceStub create(
      ClientContext clientContext) throws IOException {
    return new HttpJsonOrgPolicyViolationsPreviewServiceStub(
        OrgPolicyViolationsPreviewServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonOrgPolicyViolationsPreviewServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonOrgPolicyViolationsPreviewServiceStub(
        OrgPolicyViolationsPreviewServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonOrgPolicyViolationsPreviewServiceStub, using the given
   * settings. This is protected so that it is easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected HttpJsonOrgPolicyViolationsPreviewServiceStub(
      OrgPolicyViolationsPreviewServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonOrgPolicyViolationsPreviewServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonOrgPolicyViolationsPreviewServiceStub, using the given
   * settings. This is protected so that it is easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected HttpJsonOrgPolicyViolationsPreviewServiceStub(
      OrgPolicyViolationsPreviewServiceStubSettings settings,
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
                        .setGet("/v1/{name=operations/**}")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1/{name=projects/*/locations/*/replays/*/operations/**}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1/{name=folders/*/locations/*/replays/*/operations/**}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=organizations/*/locations/*/replays/*/operations/**}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/orgPolicyViolationsPreviews/*/operations/**}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=folders/*/locations/*/orgPolicyViolationsPreviews/*/operations/**}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=organizations/*/locations/*/orgPolicyViolationsPreviews/*/operations/**}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/accessPolicySimulations/*/operations/**}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=folders/*/locations/*/accessPolicySimulations/*/operations/**}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=organizations/*/locations/*/accessPolicySimulations/*/operations/**}")
                                .build())
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=operations}")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1/{name=projects/*/locations/*/replays/*/operations}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1/{name=folders/*/locations/*/replays/*/operations}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=organizations/*/locations/*/replays/*/operations}")
                                .build())
                        .build())
                .build());

    HttpJsonCallSettings<
            ListOrgPolicyViolationsPreviewsRequest, ListOrgPolicyViolationsPreviewsResponse>
        listOrgPolicyViolationsPreviewsTransportSettings =
            HttpJsonCallSettings
                .<ListOrgPolicyViolationsPreviewsRequest, ListOrgPolicyViolationsPreviewsResponse>
                    newBuilder()
                .setMethodDescriptor(listOrgPolicyViolationsPreviewsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetOrgPolicyViolationsPreviewRequest, OrgPolicyViolationsPreview>
        getOrgPolicyViolationsPreviewTransportSettings =
            HttpJsonCallSettings
                .<GetOrgPolicyViolationsPreviewRequest, OrgPolicyViolationsPreview>newBuilder()
                .setMethodDescriptor(getOrgPolicyViolationsPreviewMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateOrgPolicyViolationsPreviewRequest, Operation>
        createOrgPolicyViolationsPreviewTransportSettings =
            HttpJsonCallSettings.<CreateOrgPolicyViolationsPreviewRequest, Operation>newBuilder()
                .setMethodDescriptor(createOrgPolicyViolationsPreviewMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListOrgPolicyViolationsRequest, ListOrgPolicyViolationsResponse>
        listOrgPolicyViolationsTransportSettings =
            HttpJsonCallSettings
                .<ListOrgPolicyViolationsRequest, ListOrgPolicyViolationsResponse>newBuilder()
                .setMethodDescriptor(listOrgPolicyViolationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.listOrgPolicyViolationsPreviewsCallable =
        callableFactory.createUnaryCallable(
            listOrgPolicyViolationsPreviewsTransportSettings,
            settings.listOrgPolicyViolationsPreviewsSettings(),
            clientContext);
    this.listOrgPolicyViolationsPreviewsPagedCallable =
        callableFactory.createPagedCallable(
            listOrgPolicyViolationsPreviewsTransportSettings,
            settings.listOrgPolicyViolationsPreviewsSettings(),
            clientContext);
    this.getOrgPolicyViolationsPreviewCallable =
        callableFactory.createUnaryCallable(
            getOrgPolicyViolationsPreviewTransportSettings,
            settings.getOrgPolicyViolationsPreviewSettings(),
            clientContext);
    this.createOrgPolicyViolationsPreviewCallable =
        callableFactory.createUnaryCallable(
            createOrgPolicyViolationsPreviewTransportSettings,
            settings.createOrgPolicyViolationsPreviewSettings(),
            clientContext);
    this.createOrgPolicyViolationsPreviewOperationCallable =
        callableFactory.createOperationCallable(
            createOrgPolicyViolationsPreviewTransportSettings,
            settings.createOrgPolicyViolationsPreviewOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listOrgPolicyViolationsCallable =
        callableFactory.createUnaryCallable(
            listOrgPolicyViolationsTransportSettings,
            settings.listOrgPolicyViolationsSettings(),
            clientContext);
    this.listOrgPolicyViolationsPagedCallable =
        callableFactory.createPagedCallable(
            listOrgPolicyViolationsTransportSettings,
            settings.listOrgPolicyViolationsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listOrgPolicyViolationsPreviewsMethodDescriptor);
    methodDescriptors.add(getOrgPolicyViolationsPreviewMethodDescriptor);
    methodDescriptors.add(createOrgPolicyViolationsPreviewMethodDescriptor);
    methodDescriptors.add(listOrgPolicyViolationsMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<
          ListOrgPolicyViolationsPreviewsRequest, ListOrgPolicyViolationsPreviewsResponse>
      listOrgPolicyViolationsPreviewsCallable() {
    return listOrgPolicyViolationsPreviewsCallable;
  }

  @Override
  public UnaryCallable<
          ListOrgPolicyViolationsPreviewsRequest, ListOrgPolicyViolationsPreviewsPagedResponse>
      listOrgPolicyViolationsPreviewsPagedCallable() {
    return listOrgPolicyViolationsPreviewsPagedCallable;
  }

  @Override
  public UnaryCallable<GetOrgPolicyViolationsPreviewRequest, OrgPolicyViolationsPreview>
      getOrgPolicyViolationsPreviewCallable() {
    return getOrgPolicyViolationsPreviewCallable;
  }

  @Override
  public UnaryCallable<CreateOrgPolicyViolationsPreviewRequest, Operation>
      createOrgPolicyViolationsPreviewCallable() {
    return createOrgPolicyViolationsPreviewCallable;
  }

  @Override
  public OperationCallable<
          CreateOrgPolicyViolationsPreviewRequest,
          OrgPolicyViolationsPreview,
          CreateOrgPolicyViolationsPreviewOperationMetadata>
      createOrgPolicyViolationsPreviewOperationCallable() {
    return createOrgPolicyViolationsPreviewOperationCallable;
  }

  @Override
  public UnaryCallable<ListOrgPolicyViolationsRequest, ListOrgPolicyViolationsResponse>
      listOrgPolicyViolationsCallable() {
    return listOrgPolicyViolationsCallable;
  }

  @Override
  public UnaryCallable<ListOrgPolicyViolationsRequest, ListOrgPolicyViolationsPagedResponse>
      listOrgPolicyViolationsPagedCallable() {
    return listOrgPolicyViolationsPagedCallable;
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
