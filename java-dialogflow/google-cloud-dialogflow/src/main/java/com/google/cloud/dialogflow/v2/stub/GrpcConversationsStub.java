/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.dialogflow.v2.stub;

import static com.google.cloud.dialogflow.v2.ConversationsClient.ListConversationsPagedResponse;
import static com.google.cloud.dialogflow.v2.ConversationsClient.ListMessagesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2.CompleteConversationRequest;
import com.google.cloud.dialogflow.v2.Conversation;
import com.google.cloud.dialogflow.v2.CreateConversationRequest;
import com.google.cloud.dialogflow.v2.GetConversationRequest;
import com.google.cloud.dialogflow.v2.ListConversationsRequest;
import com.google.cloud.dialogflow.v2.ListConversationsResponse;
import com.google.cloud.dialogflow.v2.ListMessagesRequest;
import com.google.cloud.dialogflow.v2.ListMessagesResponse;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Conversations service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcConversationsStub extends ConversationsStub {
  private static final MethodDescriptor<CreateConversationRequest, Conversation>
      createConversationMethodDescriptor =
          MethodDescriptor.<CreateConversationRequest, Conversation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2.Conversations/CreateConversation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateConversationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Conversation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListConversationsRequest, ListConversationsResponse>
      listConversationsMethodDescriptor =
          MethodDescriptor.<ListConversationsRequest, ListConversationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2.Conversations/ListConversations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListConversationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListConversationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetConversationRequest, Conversation>
      getConversationMethodDescriptor =
          MethodDescriptor.<GetConversationRequest, Conversation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2.Conversations/GetConversation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetConversationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Conversation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CompleteConversationRequest, Conversation>
      completeConversationMethodDescriptor =
          MethodDescriptor.<CompleteConversationRequest, Conversation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2.Conversations/CompleteConversation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CompleteConversationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Conversation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListMessagesRequest, ListMessagesResponse>
      listMessagesMethodDescriptor =
          MethodDescriptor.<ListMessagesRequest, ListMessagesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2.Conversations/ListMessages")
              .setRequestMarshaller(ProtoUtils.marshaller(ListMessagesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListMessagesResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateConversationRequest, Conversation> createConversationCallable;
  private final UnaryCallable<ListConversationsRequest, ListConversationsResponse>
      listConversationsCallable;
  private final UnaryCallable<ListConversationsRequest, ListConversationsPagedResponse>
      listConversationsPagedCallable;
  private final UnaryCallable<GetConversationRequest, Conversation> getConversationCallable;
  private final UnaryCallable<CompleteConversationRequest, Conversation>
      completeConversationCallable;
  private final UnaryCallable<ListMessagesRequest, ListMessagesResponse> listMessagesCallable;
  private final UnaryCallable<ListMessagesRequest, ListMessagesPagedResponse>
      listMessagesPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcConversationsStub create(ConversationsStubSettings settings)
      throws IOException {
    return new GrpcConversationsStub(settings, ClientContext.create(settings));
  }

  public static final GrpcConversationsStub create(ClientContext clientContext) throws IOException {
    return new GrpcConversationsStub(ConversationsStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcConversationsStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcConversationsStub(
        ConversationsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcConversationsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcConversationsStub(ConversationsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcConversationsCallableFactory());
  }

  /**
   * Constructs an instance of GrpcConversationsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcConversationsStub(
      ConversationsStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateConversationRequest, Conversation> createConversationTransportSettings =
        GrpcCallSettings.<CreateConversationRequest, Conversation>newBuilder()
            .setMethodDescriptor(createConversationMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateConversationRequest>() {
                  @Override
                  public Map<String, String> extract(CreateConversationRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListConversationsRequest, ListConversationsResponse>
        listConversationsTransportSettings =
            GrpcCallSettings.<ListConversationsRequest, ListConversationsResponse>newBuilder()
                .setMethodDescriptor(listConversationsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListConversationsRequest>() {
                      @Override
                      public Map<String, String> extract(ListConversationsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<GetConversationRequest, Conversation> getConversationTransportSettings =
        GrpcCallSettings.<GetConversationRequest, Conversation>newBuilder()
            .setMethodDescriptor(getConversationMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetConversationRequest>() {
                  @Override
                  public Map<String, String> extract(GetConversationRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CompleteConversationRequest, Conversation>
        completeConversationTransportSettings =
            GrpcCallSettings.<CompleteConversationRequest, Conversation>newBuilder()
                .setMethodDescriptor(completeConversationMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<CompleteConversationRequest>() {
                      @Override
                      public Map<String, String> extract(CompleteConversationRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<ListMessagesRequest, ListMessagesResponse> listMessagesTransportSettings =
        GrpcCallSettings.<ListMessagesRequest, ListMessagesResponse>newBuilder()
            .setMethodDescriptor(listMessagesMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListMessagesRequest>() {
                  @Override
                  public Map<String, String> extract(ListMessagesRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();

    this.createConversationCallable =
        callableFactory.createUnaryCallable(
            createConversationTransportSettings,
            settings.createConversationSettings(),
            clientContext);
    this.listConversationsCallable =
        callableFactory.createUnaryCallable(
            listConversationsTransportSettings,
            settings.listConversationsSettings(),
            clientContext);
    this.listConversationsPagedCallable =
        callableFactory.createPagedCallable(
            listConversationsTransportSettings,
            settings.listConversationsSettings(),
            clientContext);
    this.getConversationCallable =
        callableFactory.createUnaryCallable(
            getConversationTransportSettings, settings.getConversationSettings(), clientContext);
    this.completeConversationCallable =
        callableFactory.createUnaryCallable(
            completeConversationTransportSettings,
            settings.completeConversationSettings(),
            clientContext);
    this.listMessagesCallable =
        callableFactory.createUnaryCallable(
            listMessagesTransportSettings, settings.listMessagesSettings(), clientContext);
    this.listMessagesPagedCallable =
        callableFactory.createPagedCallable(
            listMessagesTransportSettings, settings.listMessagesSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateConversationRequest, Conversation> createConversationCallable() {
    return createConversationCallable;
  }

  @Override
  public UnaryCallable<ListConversationsRequest, ListConversationsResponse>
      listConversationsCallable() {
    return listConversationsCallable;
  }

  @Override
  public UnaryCallable<ListConversationsRequest, ListConversationsPagedResponse>
      listConversationsPagedCallable() {
    return listConversationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetConversationRequest, Conversation> getConversationCallable() {
    return getConversationCallable;
  }

  @Override
  public UnaryCallable<CompleteConversationRequest, Conversation> completeConversationCallable() {
    return completeConversationCallable;
  }

  @Override
  public UnaryCallable<ListMessagesRequest, ListMessagesResponse> listMessagesCallable() {
    return listMessagesCallable;
  }

  @Override
  public UnaryCallable<ListMessagesRequest, ListMessagesPagedResponse> listMessagesPagedCallable() {
    return listMessagesPagedCallable;
  }

  @Override
  public final void close() {
    shutdown();
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
