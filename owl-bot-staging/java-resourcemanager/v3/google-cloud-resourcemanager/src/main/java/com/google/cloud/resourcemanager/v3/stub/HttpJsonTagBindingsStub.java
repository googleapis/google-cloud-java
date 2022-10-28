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

package com.google.cloud.resourcemanager.v3.stub;

import static com.google.cloud.resourcemanager.v3.TagBindingsClient.ListTagBindingsPagedResponse;

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
import com.google.cloud.resourcemanager.v3.CreateTagBindingMetadata;
import com.google.cloud.resourcemanager.v3.CreateTagBindingRequest;
import com.google.cloud.resourcemanager.v3.DeleteTagBindingMetadata;
import com.google.cloud.resourcemanager.v3.DeleteTagBindingRequest;
import com.google.cloud.resourcemanager.v3.ListTagBindingsRequest;
import com.google.cloud.resourcemanager.v3.ListTagBindingsResponse;
import com.google.cloud.resourcemanager.v3.TagBinding;
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
 * REST stub implementation for the TagBindings service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonTagBindingsStub extends TagBindingsStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(TagBinding.getDescriptor())
          .add(DeleteTagBindingMetadata.getDescriptor())
          .add(CreateTagBindingMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListTagBindingsRequest, ListTagBindingsResponse>
      listTagBindingsMethodDescriptor =
          ApiMethodDescriptor.<ListTagBindingsRequest, ListTagBindingsResponse>newBuilder()
              .setFullMethodName("google.cloud.resourcemanager.v3.TagBindings/ListTagBindings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListTagBindingsRequest>newBuilder()
                      .setPath(
                          "/v3/tagBindings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListTagBindingsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListTagBindingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListTagBindingsResponse>newBuilder()
                      .setDefaultInstance(ListTagBindingsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateTagBindingRequest, Operation>
      createTagBindingMethodDescriptor =
          ApiMethodDescriptor.<CreateTagBindingRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.resourcemanager.v3.TagBindings/CreateTagBinding")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateTagBindingRequest>newBuilder()
                      .setPath(
                          "/v3/tagBindings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateTagBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateTagBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("tagBinding", request.getTagBinding(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateTagBindingRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteTagBindingRequest, Operation>
      deleteTagBindingMethodDescriptor =
          ApiMethodDescriptor.<DeleteTagBindingRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.resourcemanager.v3.TagBindings/DeleteTagBinding")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteTagBindingRequest>newBuilder()
                      .setPath(
                          "/v3/{name=tagBindings/**}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteTagBindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteTagBindingRequest> serializer =
                                ProtoRestSerializer.create();
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
                  (DeleteTagBindingRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private final UnaryCallable<ListTagBindingsRequest, ListTagBindingsResponse>
      listTagBindingsCallable;
  private final UnaryCallable<ListTagBindingsRequest, ListTagBindingsPagedResponse>
      listTagBindingsPagedCallable;
  private final UnaryCallable<CreateTagBindingRequest, Operation> createTagBindingCallable;
  private final OperationCallable<CreateTagBindingRequest, TagBinding, CreateTagBindingMetadata>
      createTagBindingOperationCallable;
  private final UnaryCallable<DeleteTagBindingRequest, Operation> deleteTagBindingCallable;
  private final OperationCallable<DeleteTagBindingRequest, Empty, DeleteTagBindingMetadata>
      deleteTagBindingOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonTagBindingsStub create(TagBindingsStubSettings settings)
      throws IOException {
    return new HttpJsonTagBindingsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonTagBindingsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonTagBindingsStub(
        TagBindingsStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonTagBindingsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonTagBindingsStub(
        TagBindingsStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonTagBindingsStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonTagBindingsStub(TagBindingsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonTagBindingsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonTagBindingsStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonTagBindingsStub(
      TagBindingsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<ListTagBindingsRequest, ListTagBindingsResponse>
        listTagBindingsTransportSettings =
            HttpJsonCallSettings.<ListTagBindingsRequest, ListTagBindingsResponse>newBuilder()
                .setMethodDescriptor(listTagBindingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateTagBindingRequest, Operation> createTagBindingTransportSettings =
        HttpJsonCallSettings.<CreateTagBindingRequest, Operation>newBuilder()
            .setMethodDescriptor(createTagBindingMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteTagBindingRequest, Operation> deleteTagBindingTransportSettings =
        HttpJsonCallSettings.<DeleteTagBindingRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteTagBindingMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.listTagBindingsCallable =
        callableFactory.createUnaryCallable(
            listTagBindingsTransportSettings, settings.listTagBindingsSettings(), clientContext);
    this.listTagBindingsPagedCallable =
        callableFactory.createPagedCallable(
            listTagBindingsTransportSettings, settings.listTagBindingsSettings(), clientContext);
    this.createTagBindingCallable =
        callableFactory.createUnaryCallable(
            createTagBindingTransportSettings, settings.createTagBindingSettings(), clientContext);
    this.createTagBindingOperationCallable =
        callableFactory.createOperationCallable(
            createTagBindingTransportSettings,
            settings.createTagBindingOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteTagBindingCallable =
        callableFactory.createUnaryCallable(
            deleteTagBindingTransportSettings, settings.deleteTagBindingSettings(), clientContext);
    this.deleteTagBindingOperationCallable =
        callableFactory.createOperationCallable(
            deleteTagBindingTransportSettings,
            settings.deleteTagBindingOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listTagBindingsMethodDescriptor);
    methodDescriptors.add(createTagBindingMethodDescriptor);
    methodDescriptors.add(deleteTagBindingMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ListTagBindingsRequest, ListTagBindingsResponse> listTagBindingsCallable() {
    return listTagBindingsCallable;
  }

  @Override
  public UnaryCallable<ListTagBindingsRequest, ListTagBindingsPagedResponse>
      listTagBindingsPagedCallable() {
    return listTagBindingsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateTagBindingRequest, Operation> createTagBindingCallable() {
    return createTagBindingCallable;
  }

  @Override
  public OperationCallable<CreateTagBindingRequest, TagBinding, CreateTagBindingMetadata>
      createTagBindingOperationCallable() {
    return createTagBindingOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteTagBindingRequest, Operation> deleteTagBindingCallable() {
    return deleteTagBindingCallable;
  }

  @Override
  public OperationCallable<DeleteTagBindingRequest, Empty, DeleteTagBindingMetadata>
      deleteTagBindingOperationCallable() {
    return deleteTagBindingOperationCallable;
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
