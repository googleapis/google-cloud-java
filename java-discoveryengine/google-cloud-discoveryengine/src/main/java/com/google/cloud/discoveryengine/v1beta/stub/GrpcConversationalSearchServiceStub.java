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

package com.google.cloud.discoveryengine.v1beta.stub;

import static com.google.cloud.discoveryengine.v1beta.ConversationalSearchServiceClient.ListConversationsPagedResponse;
import static com.google.cloud.discoveryengine.v1beta.ConversationalSearchServiceClient.ListSessionsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1beta.Answer;
import com.google.cloud.discoveryengine.v1beta.AnswerQueryRequest;
import com.google.cloud.discoveryengine.v1beta.AnswerQueryResponse;
import com.google.cloud.discoveryengine.v1beta.Conversation;
import com.google.cloud.discoveryengine.v1beta.ConverseConversationRequest;
import com.google.cloud.discoveryengine.v1beta.ConverseConversationResponse;
import com.google.cloud.discoveryengine.v1beta.CreateConversationRequest;
import com.google.cloud.discoveryengine.v1beta.CreateSessionRequest;
import com.google.cloud.discoveryengine.v1beta.DeleteConversationRequest;
import com.google.cloud.discoveryengine.v1beta.DeleteSessionRequest;
import com.google.cloud.discoveryengine.v1beta.GetAnswerRequest;
import com.google.cloud.discoveryengine.v1beta.GetConversationRequest;
import com.google.cloud.discoveryengine.v1beta.GetSessionRequest;
import com.google.cloud.discoveryengine.v1beta.ListConversationsRequest;
import com.google.cloud.discoveryengine.v1beta.ListConversationsResponse;
import com.google.cloud.discoveryengine.v1beta.ListSessionsRequest;
import com.google.cloud.discoveryengine.v1beta.ListSessionsResponse;
import com.google.cloud.discoveryengine.v1beta.Session;
import com.google.cloud.discoveryengine.v1beta.UpdateConversationRequest;
import com.google.cloud.discoveryengine.v1beta.UpdateSessionRequest;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the ConversationalSearchService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcConversationalSearchServiceStub extends ConversationalSearchServiceStub {
  private static final MethodDescriptor<ConverseConversationRequest, ConverseConversationResponse>
      converseConversationMethodDescriptor =
          MethodDescriptor.<ConverseConversationRequest, ConverseConversationResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.ConversationalSearchService/ConverseConversation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ConverseConversationRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ConverseConversationResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateConversationRequest, Conversation>
      createConversationMethodDescriptor =
          MethodDescriptor.<CreateConversationRequest, Conversation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.ConversationalSearchService/CreateConversation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateConversationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Conversation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteConversationRequest, Empty>
      deleteConversationMethodDescriptor =
          MethodDescriptor.<DeleteConversationRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.ConversationalSearchService/DeleteConversation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteConversationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateConversationRequest, Conversation>
      updateConversationMethodDescriptor =
          MethodDescriptor.<UpdateConversationRequest, Conversation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.ConversationalSearchService/UpdateConversation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateConversationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Conversation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetConversationRequest, Conversation>
      getConversationMethodDescriptor =
          MethodDescriptor.<GetConversationRequest, Conversation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.ConversationalSearchService/GetConversation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetConversationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Conversation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListConversationsRequest, ListConversationsResponse>
      listConversationsMethodDescriptor =
          MethodDescriptor.<ListConversationsRequest, ListConversationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.ConversationalSearchService/ListConversations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListConversationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListConversationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<AnswerQueryRequest, AnswerQueryResponse>
      answerQueryMethodDescriptor =
          MethodDescriptor.<AnswerQueryRequest, AnswerQueryResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.ConversationalSearchService/AnswerQuery")
              .setRequestMarshaller(ProtoUtils.marshaller(AnswerQueryRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AnswerQueryResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetAnswerRequest, Answer> getAnswerMethodDescriptor =
      MethodDescriptor.<GetAnswerRequest, Answer>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.discoveryengine.v1beta.ConversationalSearchService/GetAnswer")
          .setRequestMarshaller(ProtoUtils.marshaller(GetAnswerRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Answer.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateSessionRequest, Session>
      createSessionMethodDescriptor =
          MethodDescriptor.<CreateSessionRequest, Session>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.ConversationalSearchService/CreateSession")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateSessionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Session.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteSessionRequest, Empty> deleteSessionMethodDescriptor =
      MethodDescriptor.<DeleteSessionRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.discoveryengine.v1beta.ConversationalSearchService/DeleteSession")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteSessionRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateSessionRequest, Session>
      updateSessionMethodDescriptor =
          MethodDescriptor.<UpdateSessionRequest, Session>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.ConversationalSearchService/UpdateSession")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateSessionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Session.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetSessionRequest, Session> getSessionMethodDescriptor =
      MethodDescriptor.<GetSessionRequest, Session>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.discoveryengine.v1beta.ConversationalSearchService/GetSession")
          .setRequestMarshaller(ProtoUtils.marshaller(GetSessionRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Session.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListSessionsRequest, ListSessionsResponse>
      listSessionsMethodDescriptor =
          MethodDescriptor.<ListSessionsRequest, ListSessionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.ConversationalSearchService/ListSessions")
              .setRequestMarshaller(ProtoUtils.marshaller(ListSessionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSessionsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<ConverseConversationRequest, ConverseConversationResponse>
      converseConversationCallable;
  private final UnaryCallable<CreateConversationRequest, Conversation> createConversationCallable;
  private final UnaryCallable<DeleteConversationRequest, Empty> deleteConversationCallable;
  private final UnaryCallable<UpdateConversationRequest, Conversation> updateConversationCallable;
  private final UnaryCallable<GetConversationRequest, Conversation> getConversationCallable;
  private final UnaryCallable<ListConversationsRequest, ListConversationsResponse>
      listConversationsCallable;
  private final UnaryCallable<ListConversationsRequest, ListConversationsPagedResponse>
      listConversationsPagedCallable;
  private final UnaryCallable<AnswerQueryRequest, AnswerQueryResponse> answerQueryCallable;
  private final UnaryCallable<GetAnswerRequest, Answer> getAnswerCallable;
  private final UnaryCallable<CreateSessionRequest, Session> createSessionCallable;
  private final UnaryCallable<DeleteSessionRequest, Empty> deleteSessionCallable;
  private final UnaryCallable<UpdateSessionRequest, Session> updateSessionCallable;
  private final UnaryCallable<GetSessionRequest, Session> getSessionCallable;
  private final UnaryCallable<ListSessionsRequest, ListSessionsResponse> listSessionsCallable;
  private final UnaryCallable<ListSessionsRequest, ListSessionsPagedResponse>
      listSessionsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcConversationalSearchServiceStub create(
      ConversationalSearchServiceStubSettings settings) throws IOException {
    return new GrpcConversationalSearchServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcConversationalSearchServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcConversationalSearchServiceStub(
        ConversationalSearchServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcConversationalSearchServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcConversationalSearchServiceStub(
        ConversationalSearchServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcConversationalSearchServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcConversationalSearchServiceStub(
      ConversationalSearchServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcConversationalSearchServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcConversationalSearchServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcConversationalSearchServiceStub(
      ConversationalSearchServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ConverseConversationRequest, ConverseConversationResponse>
        converseConversationTransportSettings =
            GrpcCallSettings.<ConverseConversationRequest, ConverseConversationResponse>newBuilder()
                .setMethodDescriptor(converseConversationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateConversationRequest, Conversation> createConversationTransportSettings =
        GrpcCallSettings.<CreateConversationRequest, Conversation>newBuilder()
            .setMethodDescriptor(createConversationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteConversationRequest, Empty> deleteConversationTransportSettings =
        GrpcCallSettings.<DeleteConversationRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteConversationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateConversationRequest, Conversation> updateConversationTransportSettings =
        GrpcCallSettings.<UpdateConversationRequest, Conversation>newBuilder()
            .setMethodDescriptor(updateConversationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "conversation.name", String.valueOf(request.getConversation().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetConversationRequest, Conversation> getConversationTransportSettings =
        GrpcCallSettings.<GetConversationRequest, Conversation>newBuilder()
            .setMethodDescriptor(getConversationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListConversationsRequest, ListConversationsResponse>
        listConversationsTransportSettings =
            GrpcCallSettings.<ListConversationsRequest, ListConversationsResponse>newBuilder()
                .setMethodDescriptor(listConversationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<AnswerQueryRequest, AnswerQueryResponse> answerQueryTransportSettings =
        GrpcCallSettings.<AnswerQueryRequest, AnswerQueryResponse>newBuilder()
            .setMethodDescriptor(answerQueryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("serving_config", String.valueOf(request.getServingConfig()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetAnswerRequest, Answer> getAnswerTransportSettings =
        GrpcCallSettings.<GetAnswerRequest, Answer>newBuilder()
            .setMethodDescriptor(getAnswerMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateSessionRequest, Session> createSessionTransportSettings =
        GrpcCallSettings.<CreateSessionRequest, Session>newBuilder()
            .setMethodDescriptor(createSessionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteSessionRequest, Empty> deleteSessionTransportSettings =
        GrpcCallSettings.<DeleteSessionRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteSessionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateSessionRequest, Session> updateSessionTransportSettings =
        GrpcCallSettings.<UpdateSessionRequest, Session>newBuilder()
            .setMethodDescriptor(updateSessionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("session.name", String.valueOf(request.getSession().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetSessionRequest, Session> getSessionTransportSettings =
        GrpcCallSettings.<GetSessionRequest, Session>newBuilder()
            .setMethodDescriptor(getSessionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListSessionsRequest, ListSessionsResponse> listSessionsTransportSettings =
        GrpcCallSettings.<ListSessionsRequest, ListSessionsResponse>newBuilder()
            .setMethodDescriptor(listSessionsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();

    this.converseConversationCallable =
        callableFactory.createUnaryCallable(
            converseConversationTransportSettings,
            settings.converseConversationSettings(),
            clientContext);
    this.createConversationCallable =
        callableFactory.createUnaryCallable(
            createConversationTransportSettings,
            settings.createConversationSettings(),
            clientContext);
    this.deleteConversationCallable =
        callableFactory.createUnaryCallable(
            deleteConversationTransportSettings,
            settings.deleteConversationSettings(),
            clientContext);
    this.updateConversationCallable =
        callableFactory.createUnaryCallable(
            updateConversationTransportSettings,
            settings.updateConversationSettings(),
            clientContext);
    this.getConversationCallable =
        callableFactory.createUnaryCallable(
            getConversationTransportSettings, settings.getConversationSettings(), clientContext);
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
    this.answerQueryCallable =
        callableFactory.createUnaryCallable(
            answerQueryTransportSettings, settings.answerQuerySettings(), clientContext);
    this.getAnswerCallable =
        callableFactory.createUnaryCallable(
            getAnswerTransportSettings, settings.getAnswerSettings(), clientContext);
    this.createSessionCallable =
        callableFactory.createUnaryCallable(
            createSessionTransportSettings, settings.createSessionSettings(), clientContext);
    this.deleteSessionCallable =
        callableFactory.createUnaryCallable(
            deleteSessionTransportSettings, settings.deleteSessionSettings(), clientContext);
    this.updateSessionCallable =
        callableFactory.createUnaryCallable(
            updateSessionTransportSettings, settings.updateSessionSettings(), clientContext);
    this.getSessionCallable =
        callableFactory.createUnaryCallable(
            getSessionTransportSettings, settings.getSessionSettings(), clientContext);
    this.listSessionsCallable =
        callableFactory.createUnaryCallable(
            listSessionsTransportSettings, settings.listSessionsSettings(), clientContext);
    this.listSessionsPagedCallable =
        callableFactory.createPagedCallable(
            listSessionsTransportSettings, settings.listSessionsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ConverseConversationRequest, ConverseConversationResponse>
      converseConversationCallable() {
    return converseConversationCallable;
  }

  @Override
  public UnaryCallable<CreateConversationRequest, Conversation> createConversationCallable() {
    return createConversationCallable;
  }

  @Override
  public UnaryCallable<DeleteConversationRequest, Empty> deleteConversationCallable() {
    return deleteConversationCallable;
  }

  @Override
  public UnaryCallable<UpdateConversationRequest, Conversation> updateConversationCallable() {
    return updateConversationCallable;
  }

  @Override
  public UnaryCallable<GetConversationRequest, Conversation> getConversationCallable() {
    return getConversationCallable;
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
  public UnaryCallable<AnswerQueryRequest, AnswerQueryResponse> answerQueryCallable() {
    return answerQueryCallable;
  }

  @Override
  public UnaryCallable<GetAnswerRequest, Answer> getAnswerCallable() {
    return getAnswerCallable;
  }

  @Override
  public UnaryCallable<CreateSessionRequest, Session> createSessionCallable() {
    return createSessionCallable;
  }

  @Override
  public UnaryCallable<DeleteSessionRequest, Empty> deleteSessionCallable() {
    return deleteSessionCallable;
  }

  @Override
  public UnaryCallable<UpdateSessionRequest, Session> updateSessionCallable() {
    return updateSessionCallable;
  }

  @Override
  public UnaryCallable<GetSessionRequest, Session> getSessionCallable() {
    return getSessionCallable;
  }

  @Override
  public UnaryCallable<ListSessionsRequest, ListSessionsResponse> listSessionsCallable() {
    return listSessionsCallable;
  }

  @Override
  public UnaryCallable<ListSessionsRequest, ListSessionsPagedResponse> listSessionsPagedCallable() {
    return listSessionsPagedCallable;
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
