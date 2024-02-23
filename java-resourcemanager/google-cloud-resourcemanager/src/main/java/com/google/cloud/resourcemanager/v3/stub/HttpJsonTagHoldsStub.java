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

package com.google.cloud.resourcemanager.v3.stub;

import static com.google.cloud.resourcemanager.v3.TagHoldsClient.ListTagHoldsPagedResponse;

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
import com.google.cloud.resourcemanager.v3.CreateTagHoldMetadata;
import com.google.cloud.resourcemanager.v3.CreateTagHoldRequest;
import com.google.cloud.resourcemanager.v3.DeleteTagHoldMetadata;
import com.google.cloud.resourcemanager.v3.DeleteTagHoldRequest;
import com.google.cloud.resourcemanager.v3.ListTagHoldsRequest;
import com.google.cloud.resourcemanager.v3.ListTagHoldsResponse;
import com.google.cloud.resourcemanager.v3.TagHold;
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
 * REST stub implementation for the TagHolds service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonTagHoldsStub extends TagHoldsStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(CreateTagHoldMetadata.getDescriptor())
          .add(TagHold.getDescriptor())
          .add(DeleteTagHoldMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateTagHoldRequest, Operation>
      createTagHoldMethodDescriptor =
          ApiMethodDescriptor.<CreateTagHoldRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.resourcemanager.v3.TagHolds/CreateTagHold")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateTagHoldRequest>newBuilder()
                      .setPath(
                          "/v3/{parent=tagValues/*}/tagHolds",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateTagHoldRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateTagHoldRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("tagHold", request.getTagHold(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateTagHoldRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteTagHoldRequest, Operation>
      deleteTagHoldMethodDescriptor =
          ApiMethodDescriptor.<DeleteTagHoldRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.resourcemanager.v3.TagHolds/DeleteTagHold")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteTagHoldRequest>newBuilder()
                      .setPath(
                          "/v3/{name=tagValues/*/tagHolds/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteTagHoldRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteTagHoldRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteTagHoldRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListTagHoldsRequest, ListTagHoldsResponse>
      listTagHoldsMethodDescriptor =
          ApiMethodDescriptor.<ListTagHoldsRequest, ListTagHoldsResponse>newBuilder()
              .setFullMethodName("google.cloud.resourcemanager.v3.TagHolds/ListTagHolds")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListTagHoldsRequest>newBuilder()
                      .setPath(
                          "/v3/{parent=tagValues/*}/tagHolds",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListTagHoldsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListTagHoldsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListTagHoldsResponse>newBuilder()
                      .setDefaultInstance(ListTagHoldsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateTagHoldRequest, Operation> createTagHoldCallable;
  private final OperationCallable<CreateTagHoldRequest, TagHold, CreateTagHoldMetadata>
      createTagHoldOperationCallable;
  private final UnaryCallable<DeleteTagHoldRequest, Operation> deleteTagHoldCallable;
  private final OperationCallable<DeleteTagHoldRequest, Empty, DeleteTagHoldMetadata>
      deleteTagHoldOperationCallable;
  private final UnaryCallable<ListTagHoldsRequest, ListTagHoldsResponse> listTagHoldsCallable;
  private final UnaryCallable<ListTagHoldsRequest, ListTagHoldsPagedResponse>
      listTagHoldsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonTagHoldsStub create(TagHoldsStubSettings settings)
      throws IOException {
    return new HttpJsonTagHoldsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonTagHoldsStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonTagHoldsStub(
        TagHoldsStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonTagHoldsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonTagHoldsStub(
        TagHoldsStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonTagHoldsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonTagHoldsStub(TagHoldsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonTagHoldsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonTagHoldsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonTagHoldsStub(
      TagHoldsStubSettings settings,
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
                    HttpRule.newBuilder().setGet("/v3/{name=operations/**}").build())
                .build());

    HttpJsonCallSettings<CreateTagHoldRequest, Operation> createTagHoldTransportSettings =
        HttpJsonCallSettings.<CreateTagHoldRequest, Operation>newBuilder()
            .setMethodDescriptor(createTagHoldMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteTagHoldRequest, Operation> deleteTagHoldTransportSettings =
        HttpJsonCallSettings.<DeleteTagHoldRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteTagHoldMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListTagHoldsRequest, ListTagHoldsResponse> listTagHoldsTransportSettings =
        HttpJsonCallSettings.<ListTagHoldsRequest, ListTagHoldsResponse>newBuilder()
            .setMethodDescriptor(listTagHoldsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();

    this.createTagHoldCallable =
        callableFactory.createUnaryCallable(
            createTagHoldTransportSettings, settings.createTagHoldSettings(), clientContext);
    this.createTagHoldOperationCallable =
        callableFactory.createOperationCallable(
            createTagHoldTransportSettings,
            settings.createTagHoldOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteTagHoldCallable =
        callableFactory.createUnaryCallable(
            deleteTagHoldTransportSettings, settings.deleteTagHoldSettings(), clientContext);
    this.deleteTagHoldOperationCallable =
        callableFactory.createOperationCallable(
            deleteTagHoldTransportSettings,
            settings.deleteTagHoldOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listTagHoldsCallable =
        callableFactory.createUnaryCallable(
            listTagHoldsTransportSettings, settings.listTagHoldsSettings(), clientContext);
    this.listTagHoldsPagedCallable =
        callableFactory.createPagedCallable(
            listTagHoldsTransportSettings, settings.listTagHoldsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createTagHoldMethodDescriptor);
    methodDescriptors.add(deleteTagHoldMethodDescriptor);
    methodDescriptors.add(listTagHoldsMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<CreateTagHoldRequest, Operation> createTagHoldCallable() {
    return createTagHoldCallable;
  }

  @Override
  public OperationCallable<CreateTagHoldRequest, TagHold, CreateTagHoldMetadata>
      createTagHoldOperationCallable() {
    return createTagHoldOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteTagHoldRequest, Operation> deleteTagHoldCallable() {
    return deleteTagHoldCallable;
  }

  @Override
  public OperationCallable<DeleteTagHoldRequest, Empty, DeleteTagHoldMetadata>
      deleteTagHoldOperationCallable() {
    return deleteTagHoldOperationCallable;
  }

  @Override
  public UnaryCallable<ListTagHoldsRequest, ListTagHoldsResponse> listTagHoldsCallable() {
    return listTagHoldsCallable;
  }

  @Override
  public UnaryCallable<ListTagHoldsRequest, ListTagHoldsPagedResponse> listTagHoldsPagedCallable() {
    return listTagHoldsPagedCallable;
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
