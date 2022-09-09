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
 * REST stub implementation for the ConversationProfiles service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonConversationProfilesStub extends ConversationProfilesStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(SetSuggestionFeatureConfigOperationMetadata.getDescriptor())
          .add(ClearSuggestionFeatureConfigOperationMetadata.getDescriptor())
          .add(ConversationProfile.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<
          ListConversationProfilesRequest, ListConversationProfilesResponse>
      listConversationProfilesMethodDescriptor =
          ApiMethodDescriptor
              .<ListConversationProfilesRequest, ListConversationProfilesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.dialogflow.v2.ConversationProfiles/ListConversationProfiles")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListConversationProfilesRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*}/conversationProfiles",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListConversationProfilesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{parent=projects/*/locations/*}/conversationProfiles")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListConversationProfilesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListConversationProfilesResponse>newBuilder()
                      .setDefaultInstance(ListConversationProfilesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetConversationProfileRequest, ConversationProfile>
      getConversationProfileMethodDescriptor =
          ApiMethodDescriptor.<GetConversationProfileRequest, ConversationProfile>newBuilder()
              .setFullMethodName(
                  "google.cloud.dialogflow.v2.ConversationProfiles/GetConversationProfile")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetConversationProfileRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/conversationProfiles/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetConversationProfileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{name=projects/*/locations/*/conversationProfiles/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetConversationProfileRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ConversationProfile>newBuilder()
                      .setDefaultInstance(ConversationProfile.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateConversationProfileRequest, ConversationProfile>
      createConversationProfileMethodDescriptor =
          ApiMethodDescriptor.<CreateConversationProfileRequest, ConversationProfile>newBuilder()
              .setFullMethodName(
                  "google.cloud.dialogflow.v2.ConversationProfiles/CreateConversationProfile")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateConversationProfileRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*}/conversationProfiles",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateConversationProfileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{parent=projects/*/locations/*}/conversationProfiles")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateConversationProfileRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "conversationProfile",
                                      request.getConversationProfile(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ConversationProfile>newBuilder()
                      .setDefaultInstance(ConversationProfile.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateConversationProfileRequest, ConversationProfile>
      updateConversationProfileMethodDescriptor =
          ApiMethodDescriptor.<UpdateConversationProfileRequest, ConversationProfile>newBuilder()
              .setFullMethodName(
                  "google.cloud.dialogflow.v2.ConversationProfiles/UpdateConversationProfile")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateConversationProfileRequest>newBuilder()
                      .setPath(
                          "/v2/{conversationProfile.name=projects/*/conversationProfiles/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateConversationProfileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "conversationProfile.name",
                                request.getConversationProfile().getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{conversationProfile.name=projects/*/locations/*/conversationProfiles/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateConversationProfileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "conversationProfile",
                                      request.getConversationProfile(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ConversationProfile>newBuilder()
                      .setDefaultInstance(ConversationProfile.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteConversationProfileRequest, Empty>
      deleteConversationProfileMethodDescriptor =
          ApiMethodDescriptor.<DeleteConversationProfileRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.dialogflow.v2.ConversationProfiles/DeleteConversationProfile")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteConversationProfileRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/conversationProfiles/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteConversationProfileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{name=projects/*/locations/*/conversationProfiles/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteConversationProfileRequest> serializer =
                                ProtoRestSerializer.create();
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

  private static final ApiMethodDescriptor<SetSuggestionFeatureConfigRequest, Operation>
      setSuggestionFeatureConfigMethodDescriptor =
          ApiMethodDescriptor.<SetSuggestionFeatureConfigRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.dialogflow.v2.ConversationProfiles/SetSuggestionFeatureConfig")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetSuggestionFeatureConfigRequest>newBuilder()
                      .setPath(
                          "/v2/{conversationProfile=projects/*/conversationProfiles/*}:setSuggestionFeatureConfig",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetSuggestionFeatureConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "conversationProfile", request.getConversationProfile());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{conversationProfile=projects/*/locations/*/conversationProfiles/*}:setSuggestionFeatureConfig")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetSuggestionFeatureConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request.toBuilder().clearConversationProfile().build(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (SetSuggestionFeatureConfigRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ClearSuggestionFeatureConfigRequest, Operation>
      clearSuggestionFeatureConfigMethodDescriptor =
          ApiMethodDescriptor.<ClearSuggestionFeatureConfigRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.dialogflow.v2.ConversationProfiles/ClearSuggestionFeatureConfig")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ClearSuggestionFeatureConfigRequest>newBuilder()
                      .setPath(
                          "/v2/{conversationProfile=projects/*/conversationProfiles/*}:clearSuggestionFeatureConfig",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ClearSuggestionFeatureConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "conversationProfile", request.getConversationProfile());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{conversationProfile=projects/*/locations/*/conversationProfiles/*}:clearSuggestionFeatureConfig")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ClearSuggestionFeatureConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request.toBuilder().clearConversationProfile().build(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ClearSuggestionFeatureConfigRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          ApiMethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLocationsRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*}/locations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListLocationsResponse>newBuilder()
                      .setDefaultInstance(ListLocationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetLocationRequest, Location>
      getLocationMethodDescriptor =
          ApiMethodDescriptor.<GetLocationRequest, Location>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/GetLocation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLocationRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Location>newBuilder()
                      .setDefaultInstance(Location.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
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
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonConversationProfilesStub create(
      ConversationProfilesStubSettings settings) throws IOException {
    return new HttpJsonConversationProfilesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonConversationProfilesStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonConversationProfilesStub(
        ConversationProfilesStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonConversationProfilesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonConversationProfilesStub(
        ConversationProfilesStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonConversationProfilesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonConversationProfilesStub(
      ConversationProfilesStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonConversationProfilesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonConversationProfilesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonConversationProfilesStub(
      ConversationProfilesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<ListConversationProfilesRequest, ListConversationProfilesResponse>
        listConversationProfilesTransportSettings =
            HttpJsonCallSettings
                .<ListConversationProfilesRequest, ListConversationProfilesResponse>newBuilder()
                .setMethodDescriptor(listConversationProfilesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetConversationProfileRequest, ConversationProfile>
        getConversationProfileTransportSettings =
            HttpJsonCallSettings.<GetConversationProfileRequest, ConversationProfile>newBuilder()
                .setMethodDescriptor(getConversationProfileMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateConversationProfileRequest, ConversationProfile>
        createConversationProfileTransportSettings =
            HttpJsonCallSettings.<CreateConversationProfileRequest, ConversationProfile>newBuilder()
                .setMethodDescriptor(createConversationProfileMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateConversationProfileRequest, ConversationProfile>
        updateConversationProfileTransportSettings =
            HttpJsonCallSettings.<UpdateConversationProfileRequest, ConversationProfile>newBuilder()
                .setMethodDescriptor(updateConversationProfileMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteConversationProfileRequest, Empty>
        deleteConversationProfileTransportSettings =
            HttpJsonCallSettings.<DeleteConversationProfileRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteConversationProfileMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<SetSuggestionFeatureConfigRequest, Operation>
        setSuggestionFeatureConfigTransportSettings =
            HttpJsonCallSettings.<SetSuggestionFeatureConfigRequest, Operation>newBuilder()
                .setMethodDescriptor(setSuggestionFeatureConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ClearSuggestionFeatureConfigRequest, Operation>
        clearSuggestionFeatureConfigTransportSettings =
            HttpJsonCallSettings.<ClearSuggestionFeatureConfigRequest, Operation>newBuilder()
                .setMethodDescriptor(clearSuggestionFeatureConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        HttpJsonCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listConversationProfilesMethodDescriptor);
    methodDescriptors.add(getConversationProfileMethodDescriptor);
    methodDescriptors.add(createConversationProfileMethodDescriptor);
    methodDescriptors.add(updateConversationProfileMethodDescriptor);
    methodDescriptors.add(deleteConversationProfileMethodDescriptor);
    methodDescriptors.add(setSuggestionFeatureConfigMethodDescriptor);
    methodDescriptors.add(clearSuggestionFeatureConfigMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
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
