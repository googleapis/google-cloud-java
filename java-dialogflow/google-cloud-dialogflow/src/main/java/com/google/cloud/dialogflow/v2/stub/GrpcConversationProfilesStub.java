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

import static com.google.cloud.dialogflow.v2.ConversationProfilesClient.ListConversationProfilesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2.ConversationProfile;
import com.google.cloud.dialogflow.v2.CreateConversationProfileRequest;
import com.google.cloud.dialogflow.v2.DeleteConversationProfileRequest;
import com.google.cloud.dialogflow.v2.GetConversationProfileRequest;
import com.google.cloud.dialogflow.v2.ListConversationProfilesRequest;
import com.google.cloud.dialogflow.v2.ListConversationProfilesResponse;
import com.google.cloud.dialogflow.v2.UpdateConversationProfileRequest;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the ConversationProfiles service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcConversationProfilesStub extends ConversationProfilesStub {
  private static final MethodDescriptor<
          ListConversationProfilesRequest, ListConversationProfilesResponse>
      listConversationProfilesMethodDescriptor =
          MethodDescriptor
              .<ListConversationProfilesRequest, ListConversationProfilesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dialogflow.v2.ConversationProfiles/ListConversationProfiles")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListConversationProfilesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListConversationProfilesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetConversationProfileRequest, ConversationProfile>
      getConversationProfileMethodDescriptor =
          MethodDescriptor.<GetConversationProfileRequest, ConversationProfile>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dialogflow.v2.ConversationProfiles/GetConversationProfile")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetConversationProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ConversationProfile.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateConversationProfileRequest, ConversationProfile>
      createConversationProfileMethodDescriptor =
          MethodDescriptor.<CreateConversationProfileRequest, ConversationProfile>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dialogflow.v2.ConversationProfiles/CreateConversationProfile")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateConversationProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ConversationProfile.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateConversationProfileRequest, ConversationProfile>
      updateConversationProfileMethodDescriptor =
          MethodDescriptor.<UpdateConversationProfileRequest, ConversationProfile>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dialogflow.v2.ConversationProfiles/UpdateConversationProfile")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateConversationProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ConversationProfile.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteConversationProfileRequest, Empty>
      deleteConversationProfileMethodDescriptor =
          MethodDescriptor.<DeleteConversationProfileRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dialogflow.v2.ConversationProfiles/DeleteConversationProfile")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteConversationProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListConversationProfilesRequest, ListConversationProfilesResponse>
      listConversationProfilesCallable;
  private final UnaryCallable<
          ListConversationProfilesRequest, ListConversationProfilesPagedResponse>
      listConversationProfilesPagedCallable;
  private final UnaryCallable<GetConversationProfileRequest, ConversationProfile>
      getConversationProfileCallable;
  private final UnaryCallable<CreateConversationProfileRequest, ConversationProfile>
      createConversationProfileCallable;
  private final UnaryCallable<UpdateConversationProfileRequest, ConversationProfile>
      updateConversationProfileCallable;
  private final UnaryCallable<DeleteConversationProfileRequest, Empty>
      deleteConversationProfileCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcConversationProfilesStub create(ConversationProfilesStubSettings settings)
      throws IOException {
    return new GrpcConversationProfilesStub(settings, ClientContext.create(settings));
  }

  public static final GrpcConversationProfilesStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcConversationProfilesStub(
        ConversationProfilesStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcConversationProfilesStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcConversationProfilesStub(
        ConversationProfilesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcConversationProfilesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcConversationProfilesStub(
      ConversationProfilesStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcConversationProfilesCallableFactory());
  }

  /**
   * Constructs an instance of GrpcConversationProfilesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcConversationProfilesStub(
      ConversationProfilesStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListConversationProfilesRequest, ListConversationProfilesResponse>
        listConversationProfilesTransportSettings =
            GrpcCallSettings
                .<ListConversationProfilesRequest, ListConversationProfilesResponse>newBuilder()
                .setMethodDescriptor(listConversationProfilesMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListConversationProfilesRequest>() {
                      @Override
                      public Map<String, String> extract(ListConversationProfilesRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<GetConversationProfileRequest, ConversationProfile>
        getConversationProfileTransportSettings =
            GrpcCallSettings.<GetConversationProfileRequest, ConversationProfile>newBuilder()
                .setMethodDescriptor(getConversationProfileMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<GetConversationProfileRequest>() {
                      @Override
                      public Map<String, String> extract(GetConversationProfileRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<CreateConversationProfileRequest, ConversationProfile>
        createConversationProfileTransportSettings =
            GrpcCallSettings.<CreateConversationProfileRequest, ConversationProfile>newBuilder()
                .setMethodDescriptor(createConversationProfileMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<CreateConversationProfileRequest>() {
                      @Override
                      public Map<String, String> extract(CreateConversationProfileRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<UpdateConversationProfileRequest, ConversationProfile>
        updateConversationProfileTransportSettings =
            GrpcCallSettings.<UpdateConversationProfileRequest, ConversationProfile>newBuilder()
                .setMethodDescriptor(updateConversationProfileMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<UpdateConversationProfileRequest>() {
                      @Override
                      public Map<String, String> extract(UpdateConversationProfileRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put(
                            "conversation_profile.name",
                            String.valueOf(request.getConversationProfile().getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<DeleteConversationProfileRequest, Empty>
        deleteConversationProfileTransportSettings =
            GrpcCallSettings.<DeleteConversationProfileRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteConversationProfileMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<DeleteConversationProfileRequest>() {
                      @Override
                      public Map<String, String> extract(DeleteConversationProfileRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();

    this.listConversationProfilesCallable =
        callableFactory.createUnaryCallable(
            listConversationProfilesTransportSettings,
            settings.listConversationProfilesSettings(),
            clientContext);
    this.listConversationProfilesPagedCallable =
        callableFactory.createPagedCallable(
            listConversationProfilesTransportSettings,
            settings.listConversationProfilesSettings(),
            clientContext);
    this.getConversationProfileCallable =
        callableFactory.createUnaryCallable(
            getConversationProfileTransportSettings,
            settings.getConversationProfileSettings(),
            clientContext);
    this.createConversationProfileCallable =
        callableFactory.createUnaryCallable(
            createConversationProfileTransportSettings,
            settings.createConversationProfileSettings(),
            clientContext);
    this.updateConversationProfileCallable =
        callableFactory.createUnaryCallable(
            updateConversationProfileTransportSettings,
            settings.updateConversationProfileSettings(),
            clientContext);
    this.deleteConversationProfileCallable =
        callableFactory.createUnaryCallable(
            deleteConversationProfileTransportSettings,
            settings.deleteConversationProfileSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListConversationProfilesRequest, ListConversationProfilesResponse>
      listConversationProfilesCallable() {
    return listConversationProfilesCallable;
  }

  @Override
  public UnaryCallable<ListConversationProfilesRequest, ListConversationProfilesPagedResponse>
      listConversationProfilesPagedCallable() {
    return listConversationProfilesPagedCallable;
  }

  @Override
  public UnaryCallable<GetConversationProfileRequest, ConversationProfile>
      getConversationProfileCallable() {
    return getConversationProfileCallable;
  }

  @Override
  public UnaryCallable<CreateConversationProfileRequest, ConversationProfile>
      createConversationProfileCallable() {
    return createConversationProfileCallable;
  }

  @Override
  public UnaryCallable<UpdateConversationProfileRequest, ConversationProfile>
      updateConversationProfileCallable() {
    return updateConversationProfileCallable;
  }

  @Override
  public UnaryCallable<DeleteConversationProfileRequest, Empty>
      deleteConversationProfileCallable() {
    return deleteConversationProfileCallable;
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
