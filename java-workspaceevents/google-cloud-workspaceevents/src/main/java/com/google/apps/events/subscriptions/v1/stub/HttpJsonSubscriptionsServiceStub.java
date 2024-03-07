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

package com.google.apps.events.subscriptions.v1.stub;

import static com.google.apps.events.subscriptions.v1.SubscriptionsServiceClient.ListSubscriptionsPagedResponse;

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
import com.google.apps.events.subscriptions.v1.CreateSubscriptionMetadata;
import com.google.apps.events.subscriptions.v1.CreateSubscriptionRequest;
import com.google.apps.events.subscriptions.v1.DeleteSubscriptionMetadata;
import com.google.apps.events.subscriptions.v1.DeleteSubscriptionRequest;
import com.google.apps.events.subscriptions.v1.GetSubscriptionRequest;
import com.google.apps.events.subscriptions.v1.ListSubscriptionsRequest;
import com.google.apps.events.subscriptions.v1.ListSubscriptionsResponse;
import com.google.apps.events.subscriptions.v1.ReactivateSubscriptionMetadata;
import com.google.apps.events.subscriptions.v1.ReactivateSubscriptionRequest;
import com.google.apps.events.subscriptions.v1.Subscription;
import com.google.apps.events.subscriptions.v1.UpdateSubscriptionMetadata;
import com.google.apps.events.subscriptions.v1.UpdateSubscriptionRequest;
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
 * REST stub implementation for the SubscriptionsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonSubscriptionsServiceStub extends SubscriptionsServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(Subscription.getDescriptor())
          .add(UpdateSubscriptionMetadata.getDescriptor())
          .add(CreateSubscriptionMetadata.getDescriptor())
          .add(DeleteSubscriptionMetadata.getDescriptor())
          .add(ReactivateSubscriptionMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateSubscriptionRequest, Operation>
      createSubscriptionMethodDescriptor =
          ApiMethodDescriptor.<CreateSubscriptionRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.apps.events.subscriptions.v1.SubscriptionsService/CreateSubscription")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateSubscriptionRequest>newBuilder()
                      .setPath(
                          "/v1/subscriptions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSubscriptionRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSubscriptionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("subscription", request.getSubscription(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateSubscriptionRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteSubscriptionRequest, Operation>
      deleteSubscriptionMethodDescriptor =
          ApiMethodDescriptor.<DeleteSubscriptionRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.apps.events.subscriptions.v1.SubscriptionsService/DeleteSubscription")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteSubscriptionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=subscriptions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSubscriptionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSubscriptionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
                            serializer.putQueryParam(fields, "etag", request.getEtag());
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
                  (DeleteSubscriptionRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetSubscriptionRequest, Subscription>
      getSubscriptionMethodDescriptor =
          ApiMethodDescriptor.<GetSubscriptionRequest, Subscription>newBuilder()
              .setFullMethodName(
                  "google.apps.events.subscriptions.v1.SubscriptionsService/GetSubscription")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetSubscriptionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=subscriptions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetSubscriptionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetSubscriptionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Subscription>newBuilder()
                      .setDefaultInstance(Subscription.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListSubscriptionsRequest, ListSubscriptionsResponse>
      listSubscriptionsMethodDescriptor =
          ApiMethodDescriptor.<ListSubscriptionsRequest, ListSubscriptionsResponse>newBuilder()
              .setFullMethodName(
                  "google.apps.events.subscriptions.v1.SubscriptionsService/ListSubscriptions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSubscriptionsRequest>newBuilder()
                      .setPath(
                          "/v1/subscriptions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSubscriptionsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSubscriptionsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListSubscriptionsResponse>newBuilder()
                      .setDefaultInstance(ListSubscriptionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateSubscriptionRequest, Operation>
      updateSubscriptionMethodDescriptor =
          ApiMethodDescriptor.<UpdateSubscriptionRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.apps.events.subscriptions.v1.SubscriptionsService/UpdateSubscription")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateSubscriptionRequest>newBuilder()
                      .setPath(
                          "/v1/{subscription.name=subscriptions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSubscriptionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "subscription.name", request.getSubscription().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSubscriptionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("subscription", request.getSubscription(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateSubscriptionRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ReactivateSubscriptionRequest, Operation>
      reactivateSubscriptionMethodDescriptor =
          ApiMethodDescriptor.<ReactivateSubscriptionRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.apps.events.subscriptions.v1.SubscriptionsService/ReactivateSubscription")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ReactivateSubscriptionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=subscriptions/*}:reactivate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ReactivateSubscriptionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ReactivateSubscriptionRequest> serializer =
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
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ReactivateSubscriptionRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private final UnaryCallable<CreateSubscriptionRequest, Operation> createSubscriptionCallable;
  private final OperationCallable<
          CreateSubscriptionRequest, Subscription, CreateSubscriptionMetadata>
      createSubscriptionOperationCallable;
  private final UnaryCallable<DeleteSubscriptionRequest, Operation> deleteSubscriptionCallable;
  private final OperationCallable<DeleteSubscriptionRequest, Empty, DeleteSubscriptionMetadata>
      deleteSubscriptionOperationCallable;
  private final UnaryCallable<GetSubscriptionRequest, Subscription> getSubscriptionCallable;
  private final UnaryCallable<ListSubscriptionsRequest, ListSubscriptionsResponse>
      listSubscriptionsCallable;
  private final UnaryCallable<ListSubscriptionsRequest, ListSubscriptionsPagedResponse>
      listSubscriptionsPagedCallable;
  private final UnaryCallable<UpdateSubscriptionRequest, Operation> updateSubscriptionCallable;
  private final OperationCallable<
          UpdateSubscriptionRequest, Subscription, UpdateSubscriptionMetadata>
      updateSubscriptionOperationCallable;
  private final UnaryCallable<ReactivateSubscriptionRequest, Operation>
      reactivateSubscriptionCallable;
  private final OperationCallable<
          ReactivateSubscriptionRequest, Subscription, ReactivateSubscriptionMetadata>
      reactivateSubscriptionOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonSubscriptionsServiceStub create(
      SubscriptionsServiceStubSettings settings) throws IOException {
    return new HttpJsonSubscriptionsServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonSubscriptionsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonSubscriptionsServiceStub(
        SubscriptionsServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonSubscriptionsServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonSubscriptionsServiceStub(
        SubscriptionsServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonSubscriptionsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSubscriptionsServiceStub(
      SubscriptionsServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonSubscriptionsServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonSubscriptionsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSubscriptionsServiceStub(
      SubscriptionsServiceStubSettings settings,
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
                    HttpRule.newBuilder().setGet("/v1/{name=operations/**}").build())
                .build());

    HttpJsonCallSettings<CreateSubscriptionRequest, Operation> createSubscriptionTransportSettings =
        HttpJsonCallSettings.<CreateSubscriptionRequest, Operation>newBuilder()
            .setMethodDescriptor(createSubscriptionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteSubscriptionRequest, Operation> deleteSubscriptionTransportSettings =
        HttpJsonCallSettings.<DeleteSubscriptionRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteSubscriptionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetSubscriptionRequest, Subscription> getSubscriptionTransportSettings =
        HttpJsonCallSettings.<GetSubscriptionRequest, Subscription>newBuilder()
            .setMethodDescriptor(getSubscriptionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListSubscriptionsRequest, ListSubscriptionsResponse>
        listSubscriptionsTransportSettings =
            HttpJsonCallSettings.<ListSubscriptionsRequest, ListSubscriptionsResponse>newBuilder()
                .setMethodDescriptor(listSubscriptionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateSubscriptionRequest, Operation> updateSubscriptionTransportSettings =
        HttpJsonCallSettings.<UpdateSubscriptionRequest, Operation>newBuilder()
            .setMethodDescriptor(updateSubscriptionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "subscription.name", String.valueOf(request.getSubscription().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ReactivateSubscriptionRequest, Operation>
        reactivateSubscriptionTransportSettings =
            HttpJsonCallSettings.<ReactivateSubscriptionRequest, Operation>newBuilder()
                .setMethodDescriptor(reactivateSubscriptionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();

    this.createSubscriptionCallable =
        callableFactory.createUnaryCallable(
            createSubscriptionTransportSettings,
            settings.createSubscriptionSettings(),
            clientContext);
    this.createSubscriptionOperationCallable =
        callableFactory.createOperationCallable(
            createSubscriptionTransportSettings,
            settings.createSubscriptionOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteSubscriptionCallable =
        callableFactory.createUnaryCallable(
            deleteSubscriptionTransportSettings,
            settings.deleteSubscriptionSettings(),
            clientContext);
    this.deleteSubscriptionOperationCallable =
        callableFactory.createOperationCallable(
            deleteSubscriptionTransportSettings,
            settings.deleteSubscriptionOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getSubscriptionCallable =
        callableFactory.createUnaryCallable(
            getSubscriptionTransportSettings, settings.getSubscriptionSettings(), clientContext);
    this.listSubscriptionsCallable =
        callableFactory.createUnaryCallable(
            listSubscriptionsTransportSettings,
            settings.listSubscriptionsSettings(),
            clientContext);
    this.listSubscriptionsPagedCallable =
        callableFactory.createPagedCallable(
            listSubscriptionsTransportSettings,
            settings.listSubscriptionsSettings(),
            clientContext);
    this.updateSubscriptionCallable =
        callableFactory.createUnaryCallable(
            updateSubscriptionTransportSettings,
            settings.updateSubscriptionSettings(),
            clientContext);
    this.updateSubscriptionOperationCallable =
        callableFactory.createOperationCallable(
            updateSubscriptionTransportSettings,
            settings.updateSubscriptionOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.reactivateSubscriptionCallable =
        callableFactory.createUnaryCallable(
            reactivateSubscriptionTransportSettings,
            settings.reactivateSubscriptionSettings(),
            clientContext);
    this.reactivateSubscriptionOperationCallable =
        callableFactory.createOperationCallable(
            reactivateSubscriptionTransportSettings,
            settings.reactivateSubscriptionOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createSubscriptionMethodDescriptor);
    methodDescriptors.add(deleteSubscriptionMethodDescriptor);
    methodDescriptors.add(getSubscriptionMethodDescriptor);
    methodDescriptors.add(listSubscriptionsMethodDescriptor);
    methodDescriptors.add(updateSubscriptionMethodDescriptor);
    methodDescriptors.add(reactivateSubscriptionMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<CreateSubscriptionRequest, Operation> createSubscriptionCallable() {
    return createSubscriptionCallable;
  }

  @Override
  public OperationCallable<CreateSubscriptionRequest, Subscription, CreateSubscriptionMetadata>
      createSubscriptionOperationCallable() {
    return createSubscriptionOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteSubscriptionRequest, Operation> deleteSubscriptionCallable() {
    return deleteSubscriptionCallable;
  }

  @Override
  public OperationCallable<DeleteSubscriptionRequest, Empty, DeleteSubscriptionMetadata>
      deleteSubscriptionOperationCallable() {
    return deleteSubscriptionOperationCallable;
  }

  @Override
  public UnaryCallable<GetSubscriptionRequest, Subscription> getSubscriptionCallable() {
    return getSubscriptionCallable;
  }

  @Override
  public UnaryCallable<ListSubscriptionsRequest, ListSubscriptionsResponse>
      listSubscriptionsCallable() {
    return listSubscriptionsCallable;
  }

  @Override
  public UnaryCallable<ListSubscriptionsRequest, ListSubscriptionsPagedResponse>
      listSubscriptionsPagedCallable() {
    return listSubscriptionsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateSubscriptionRequest, Operation> updateSubscriptionCallable() {
    return updateSubscriptionCallable;
  }

  @Override
  public OperationCallable<UpdateSubscriptionRequest, Subscription, UpdateSubscriptionMetadata>
      updateSubscriptionOperationCallable() {
    return updateSubscriptionOperationCallable;
  }

  @Override
  public UnaryCallable<ReactivateSubscriptionRequest, Operation> reactivateSubscriptionCallable() {
    return reactivateSubscriptionCallable;
  }

  @Override
  public OperationCallable<
          ReactivateSubscriptionRequest, Subscription, ReactivateSubscriptionMetadata>
      reactivateSubscriptionOperationCallable() {
    return reactivateSubscriptionOperationCallable;
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
