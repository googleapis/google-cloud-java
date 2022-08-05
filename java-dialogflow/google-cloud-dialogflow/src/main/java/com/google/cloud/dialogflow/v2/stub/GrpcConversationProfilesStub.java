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

package com.google.cloud.dialogflow.v2.stub;

import static com.google.cloud.dialogflow.v2.ConversationProfilesClient.ListConversationProfilesPagedResponse;
import static com.google.cloud.dialogflow.v2.ConversationProfilesClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2.ClearSuggestionFeatureConfigOperationMetadata;
import com.google.cloud.dialogflow.v2.ClearSuggestionFeatureConfigRequest;
import com.google.cloud.dialogflow.v2.ConversationProfile;
import com.google.cloud.dialogflow.v2.CreateConversationProfileRequest;
import com.google.cloud.dialogflow.v2.DeleteConversationProfileRequest;
import com.google.cloud.dialogflow.v2.GetConversationProfileRequest;
import com.google.cloud.dialogflow.v2.ListConversationProfilesRequest;
import com.google.cloud.dialogflow.v2.ListConversationProfilesResponse;
import com.google.cloud.dialogflow.v2.SetSuggestionFeatureConfigOperationMetadata;
import com.google.cloud.dialogflow.v2.SetSuggestionFeatureConfigRequest;
import com.google.cloud.dialogflow.v2.UpdateConversationProfileRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
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

  private static final MethodDescriptor<SetSuggestionFeatureConfigRequest, Operation>
      setSuggestionFeatureConfigMethodDescriptor =
          MethodDescriptor.<SetSuggestionFeatureConfigRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dialogflow.v2.ConversationProfiles/SetSuggestionFeatureConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SetSuggestionFeatureConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ClearSuggestionFeatureConfigRequest, Operation>
      clearSuggestionFeatureConfigMethodDescriptor =
          MethodDescriptor.<ClearSuggestionFeatureConfigRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dialogflow.v2.ConversationProfiles/ClearSuggestionFeatureConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ClearSuggestionFeatureConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          MethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLocationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLocationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
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
  private final UnaryCallable<SetSuggestionFeatureConfigRequest, Operation>
      setSuggestionFeatureConfigCallable;
  private final OperationCallable<
          SetSuggestionFeatureConfigRequest,
          ConversationProfile,
          SetSuggestionFeatureConfigOperationMetadata>
      setSuggestionFeatureConfigOperationCallable;
  private final UnaryCallable<ClearSuggestionFeatureConfigRequest, Operation>
      clearSuggestionFeatureConfigCallable;
  private final OperationCallable<
          ClearSuggestionFeatureConfigRequest,
          ConversationProfile,
          ClearSuggestionFeatureConfigOperationMetadata>
      clearSuggestionFeatureConfigOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

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
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetConversationProfileRequest, ConversationProfile>
        getConversationProfileTransportSettings =
            GrpcCallSettings.<GetConversationProfileRequest, ConversationProfile>newBuilder()
                .setMethodDescriptor(getConversationProfileMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateConversationProfileRequest, ConversationProfile>
        createConversationProfileTransportSettings =
            GrpcCallSettings.<CreateConversationProfileRequest, ConversationProfile>newBuilder()
                .setMethodDescriptor(createConversationProfileMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateConversationProfileRequest, ConversationProfile>
        updateConversationProfileTransportSettings =
            GrpcCallSettings.<UpdateConversationProfileRequest, ConversationProfile>newBuilder()
                .setMethodDescriptor(updateConversationProfileMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "conversation_profile.name",
                          String.valueOf(request.getConversationProfile().getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteConversationProfileRequest, Empty>
        deleteConversationProfileTransportSettings =
            GrpcCallSettings.<DeleteConversationProfileRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteConversationProfileMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<SetSuggestionFeatureConfigRequest, Operation>
        setSuggestionFeatureConfigTransportSettings =
            GrpcCallSettings.<SetSuggestionFeatureConfigRequest, Operation>newBuilder()
                .setMethodDescriptor(setSuggestionFeatureConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "conversation_profile", String.valueOf(request.getConversationProfile()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ClearSuggestionFeatureConfigRequest, Operation>
        clearSuggestionFeatureConfigTransportSettings =
            GrpcCallSettings.<ClearSuggestionFeatureConfigRequest, Operation>newBuilder()
                .setMethodDescriptor(clearSuggestionFeatureConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "conversation_profile", String.valueOf(request.getConversationProfile()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
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
    this.setSuggestionFeatureConfigCallable =
        callableFactory.createUnaryCallable(
            setSuggestionFeatureConfigTransportSettings,
            settings.setSuggestionFeatureConfigSettings(),
            clientContext);
    this.setSuggestionFeatureConfigOperationCallable =
        callableFactory.createOperationCallable(
            setSuggestionFeatureConfigTransportSettings,
            settings.setSuggestionFeatureConfigOperationSettings(),
            clientContext,
            operationsStub);
    this.clearSuggestionFeatureConfigCallable =
        callableFactory.createUnaryCallable(
            clearSuggestionFeatureConfigTransportSettings,
            settings.clearSuggestionFeatureConfigSettings(),
            clientContext);
    this.clearSuggestionFeatureConfigOperationCallable =
        callableFactory.createOperationCallable(
            clearSuggestionFeatureConfigTransportSettings,
            settings.clearSuggestionFeatureConfigOperationSettings(),
            clientContext,
            operationsStub);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);

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
  public UnaryCallable<SetSuggestionFeatureConfigRequest, Operation>
      setSuggestionFeatureConfigCallable() {
    return setSuggestionFeatureConfigCallable;
  }

  @Override
  public OperationCallable<
          SetSuggestionFeatureConfigRequest,
          ConversationProfile,
          SetSuggestionFeatureConfigOperationMetadata>
      setSuggestionFeatureConfigOperationCallable() {
    return setSuggestionFeatureConfigOperationCallable;
  }

  @Override
  public UnaryCallable<ClearSuggestionFeatureConfigRequest, Operation>
      clearSuggestionFeatureConfigCallable() {
    return clearSuggestionFeatureConfigCallable;
  }

  @Override
  public OperationCallable<
          ClearSuggestionFeatureConfigRequest,
          ConversationProfile,
          ClearSuggestionFeatureConfigOperationMetadata>
      clearSuggestionFeatureConfigOperationCallable() {
    return clearSuggestionFeatureConfigOperationCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
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
