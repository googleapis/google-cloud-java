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

package com.google.devicesandservices.health.v4.stub;

import static com.google.devicesandservices.health.v4.DataSubscriptionServiceClient.ListSubscribersPagedResponse;

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
import com.google.devicesandservices.health.v4.CreateSubscriberMetadata;
import com.google.devicesandservices.health.v4.CreateSubscriberRequest;
import com.google.devicesandservices.health.v4.DeleteSubscriberMetadata;
import com.google.devicesandservices.health.v4.DeleteSubscriberRequest;
import com.google.devicesandservices.health.v4.ListSubscribersRequest;
import com.google.devicesandservices.health.v4.ListSubscribersResponse;
import com.google.devicesandservices.health.v4.Subscriber;
import com.google.devicesandservices.health.v4.UpdateSubscriberMetadata;
import com.google.devicesandservices.health.v4.UpdateSubscriberRequest;
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
 * REST stub implementation for the DataSubscriptionService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonDataSubscriptionServiceStub extends DataSubscriptionServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(DeleteSubscriberMetadata.getDescriptor())
          .add(UpdateSubscriberMetadata.getDescriptor())
          .add(Subscriber.getDescriptor())
          .add(CreateSubscriberMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateSubscriberRequest, Operation>
      createSubscriberMethodDescriptor =
          ApiMethodDescriptor.<CreateSubscriberRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.devicesandservices.health.v4.DataSubscriptionService/CreateSubscriber")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateSubscriberRequest>newBuilder()
                      .setPath(
                          "/v4/{parent=projects/*}/subscribers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSubscriberRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSubscriberRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "subscriberId", request.getSubscriberId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("subscriber", request.getSubscriber(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateSubscriberRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListSubscribersRequest, ListSubscribersResponse>
      listSubscribersMethodDescriptor =
          ApiMethodDescriptor.<ListSubscribersRequest, ListSubscribersResponse>newBuilder()
              .setFullMethodName(
                  "google.devicesandservices.health.v4.DataSubscriptionService/ListSubscribers")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSubscribersRequest>newBuilder()
                      .setPath(
                          "/v4/{parent=projects/*}/subscribers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSubscribersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSubscribersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListSubscribersResponse>newBuilder()
                      .setDefaultInstance(ListSubscribersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateSubscriberRequest, Operation>
      updateSubscriberMethodDescriptor =
          ApiMethodDescriptor.<UpdateSubscriberRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.devicesandservices.health.v4.DataSubscriptionService/UpdateSubscriber")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateSubscriberRequest>newBuilder()
                      .setPath(
                          "/v4/{subscriber.name=projects/*/subscribers/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSubscriberRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "subscriber.name", request.getSubscriber().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSubscriberRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("subscriber", request.getSubscriber(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateSubscriberRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteSubscriberRequest, Operation>
      deleteSubscriberMethodDescriptor =
          ApiMethodDescriptor.<DeleteSubscriberRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.devicesandservices.health.v4.DataSubscriptionService/DeleteSubscriber")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteSubscriberRequest>newBuilder()
                      .setPath(
                          "/v4/{name=projects/*/subscribers/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSubscriberRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSubscriberRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
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
                  (DeleteSubscriberRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private final UnaryCallable<CreateSubscriberRequest, Operation> createSubscriberCallable;
  private final OperationCallable<CreateSubscriberRequest, Subscriber, CreateSubscriberMetadata>
      createSubscriberOperationCallable;
  private final UnaryCallable<ListSubscribersRequest, ListSubscribersResponse>
      listSubscribersCallable;
  private final UnaryCallable<ListSubscribersRequest, ListSubscribersPagedResponse>
      listSubscribersPagedCallable;
  private final UnaryCallable<UpdateSubscriberRequest, Operation> updateSubscriberCallable;
  private final OperationCallable<UpdateSubscriberRequest, Subscriber, UpdateSubscriberMetadata>
      updateSubscriberOperationCallable;
  private final UnaryCallable<DeleteSubscriberRequest, Operation> deleteSubscriberCallable;
  private final OperationCallable<DeleteSubscriberRequest, Empty, DeleteSubscriberMetadata>
      deleteSubscriberOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonDataSubscriptionServiceStub create(
      DataSubscriptionServiceStubSettings settings) throws IOException {
    return new HttpJsonDataSubscriptionServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonDataSubscriptionServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonDataSubscriptionServiceStub(
        DataSubscriptionServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonDataSubscriptionServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonDataSubscriptionServiceStub(
        DataSubscriptionServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonDataSubscriptionServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDataSubscriptionServiceStub(
      DataSubscriptionServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonDataSubscriptionServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonDataSubscriptionServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDataSubscriptionServiceStub(
      DataSubscriptionServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<CreateSubscriberRequest, Operation> createSubscriberTransportSettings =
        HttpJsonCallSettings.<CreateSubscriberRequest, Operation>newBuilder()
            .setMethodDescriptor(createSubscriberMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<ListSubscribersRequest, ListSubscribersResponse>
        listSubscribersTransportSettings =
            HttpJsonCallSettings.<ListSubscribersRequest, ListSubscribersResponse>newBuilder()
                .setMethodDescriptor(listSubscribersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<UpdateSubscriberRequest, Operation> updateSubscriberTransportSettings =
        HttpJsonCallSettings.<UpdateSubscriberRequest, Operation>newBuilder()
            .setMethodDescriptor(updateSubscriberMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("subscriber.name", String.valueOf(request.getSubscriber().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteSubscriberRequest, Operation> deleteSubscriberTransportSettings =
        HttpJsonCallSettings.<DeleteSubscriberRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteSubscriberMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();

    this.createSubscriberCallable =
        callableFactory.createUnaryCallable(
            createSubscriberTransportSettings, settings.createSubscriberSettings(), clientContext);
    this.createSubscriberOperationCallable =
        callableFactory.createOperationCallable(
            createSubscriberTransportSettings,
            settings.createSubscriberOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listSubscribersCallable =
        callableFactory.createUnaryCallable(
            listSubscribersTransportSettings, settings.listSubscribersSettings(), clientContext);
    this.listSubscribersPagedCallable =
        callableFactory.createPagedCallable(
            listSubscribersTransportSettings, settings.listSubscribersSettings(), clientContext);
    this.updateSubscriberCallable =
        callableFactory.createUnaryCallable(
            updateSubscriberTransportSettings, settings.updateSubscriberSettings(), clientContext);
    this.updateSubscriberOperationCallable =
        callableFactory.createOperationCallable(
            updateSubscriberTransportSettings,
            settings.updateSubscriberOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteSubscriberCallable =
        callableFactory.createUnaryCallable(
            deleteSubscriberTransportSettings, settings.deleteSubscriberSettings(), clientContext);
    this.deleteSubscriberOperationCallable =
        callableFactory.createOperationCallable(
            deleteSubscriberTransportSettings,
            settings.deleteSubscriberOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createSubscriberMethodDescriptor);
    methodDescriptors.add(listSubscribersMethodDescriptor);
    methodDescriptors.add(updateSubscriberMethodDescriptor);
    methodDescriptors.add(deleteSubscriberMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<CreateSubscriberRequest, Operation> createSubscriberCallable() {
    return createSubscriberCallable;
  }

  @Override
  public OperationCallable<CreateSubscriberRequest, Subscriber, CreateSubscriberMetadata>
      createSubscriberOperationCallable() {
    return createSubscriberOperationCallable;
  }

  @Override
  public UnaryCallable<ListSubscribersRequest, ListSubscribersResponse> listSubscribersCallable() {
    return listSubscribersCallable;
  }

  @Override
  public UnaryCallable<ListSubscribersRequest, ListSubscribersPagedResponse>
      listSubscribersPagedCallable() {
    return listSubscribersPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateSubscriberRequest, Operation> updateSubscriberCallable() {
    return updateSubscriberCallable;
  }

  @Override
  public OperationCallable<UpdateSubscriberRequest, Subscriber, UpdateSubscriberMetadata>
      updateSubscriberOperationCallable() {
    return updateSubscriberOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteSubscriberRequest, Operation> deleteSubscriberCallable() {
    return deleteSubscriberCallable;
  }

  @Override
  public OperationCallable<DeleteSubscriberRequest, Empty, DeleteSubscriberMetadata>
      deleteSubscriberOperationCallable() {
    return deleteSubscriberOperationCallable;
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
