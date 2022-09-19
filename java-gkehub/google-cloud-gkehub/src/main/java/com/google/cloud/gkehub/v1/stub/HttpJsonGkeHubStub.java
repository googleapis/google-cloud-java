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

package com.google.cloud.gkehub.v1.stub;

import static com.google.cloud.gkehub.v1.GkeHubClient.ListFeaturesPagedResponse;
import static com.google.cloud.gkehub.v1.GkeHubClient.ListMembershipsPagedResponse;

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
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.gkehub.v1.CreateFeatureRequest;
import com.google.cloud.gkehub.v1.CreateMembershipRequest;
import com.google.cloud.gkehub.v1.DeleteFeatureRequest;
import com.google.cloud.gkehub.v1.DeleteMembershipRequest;
import com.google.cloud.gkehub.v1.Feature;
import com.google.cloud.gkehub.v1.GenerateConnectManifestRequest;
import com.google.cloud.gkehub.v1.GenerateConnectManifestResponse;
import com.google.cloud.gkehub.v1.GetFeatureRequest;
import com.google.cloud.gkehub.v1.GetMembershipRequest;
import com.google.cloud.gkehub.v1.ListFeaturesRequest;
import com.google.cloud.gkehub.v1.ListFeaturesResponse;
import com.google.cloud.gkehub.v1.ListMembershipsRequest;
import com.google.cloud.gkehub.v1.ListMembershipsResponse;
import com.google.cloud.gkehub.v1.Membership;
import com.google.cloud.gkehub.v1.OperationMetadata;
import com.google.cloud.gkehub.v1.UpdateFeatureRequest;
import com.google.cloud.gkehub.v1.UpdateMembershipRequest;
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
 * REST stub implementation for the GkeHub service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonGkeHubStub extends GkeHubStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(Feature.getDescriptor())
          .add(Membership.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListMembershipsRequest, ListMembershipsResponse>
      listMembershipsMethodDescriptor =
          ApiMethodDescriptor.<ListMembershipsRequest, ListMembershipsResponse>newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/ListMemberships")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListMembershipsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/memberships",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListMembershipsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListMembershipsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListMembershipsResponse>newBuilder()
                      .setDefaultInstance(ListMembershipsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListFeaturesRequest, ListFeaturesResponse>
      listFeaturesMethodDescriptor =
          ApiMethodDescriptor.<ListFeaturesRequest, ListFeaturesResponse>newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/ListFeatures")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListFeaturesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/features",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListFeaturesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListFeaturesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListFeaturesResponse>newBuilder()
                      .setDefaultInstance(ListFeaturesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetMembershipRequest, Membership>
      getMembershipMethodDescriptor =
          ApiMethodDescriptor.<GetMembershipRequest, Membership>newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/GetMembership")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetMembershipRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/memberships/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetMembershipRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetMembershipRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Membership>newBuilder()
                      .setDefaultInstance(Membership.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetFeatureRequest, Feature> getFeatureMethodDescriptor =
      ApiMethodDescriptor.<GetFeatureRequest, Feature>newBuilder()
          .setFullMethodName("google.cloud.gkehub.v1.GkeHub/GetFeature")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetFeatureRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/features/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetFeatureRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetFeatureRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Feature>newBuilder()
                  .setDefaultInstance(Feature.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateMembershipRequest, Operation>
      createMembershipMethodDescriptor =
          ApiMethodDescriptor.<CreateMembershipRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/CreateMembership")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateMembershipRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/memberships",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateMembershipRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateMembershipRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "membershipId", request.getMembershipId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("resource", request.getResource(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateMembershipRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateFeatureRequest, Operation>
      createFeatureMethodDescriptor =
          ApiMethodDescriptor.<CreateFeatureRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/CreateFeature")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateFeatureRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/features",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateFeatureRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateFeatureRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "featureId", request.getFeatureId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("resource", request.getResource(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateFeatureRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteMembershipRequest, Operation>
      deleteMembershipMethodDescriptor =
          ApiMethodDescriptor.<DeleteMembershipRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/DeleteMembership")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteMembershipRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/memberships/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteMembershipRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteMembershipRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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
                  (DeleteMembershipRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteFeatureRequest, Operation>
      deleteFeatureMethodDescriptor =
          ApiMethodDescriptor.<DeleteFeatureRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/DeleteFeature")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteFeatureRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/features/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteFeatureRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteFeatureRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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
                  (DeleteFeatureRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateMembershipRequest, Operation>
      updateMembershipMethodDescriptor =
          ApiMethodDescriptor.<UpdateMembershipRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/UpdateMembership")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateMembershipRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/memberships/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateMembershipRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateMembershipRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("resource", request.getResource(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateMembershipRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateFeatureRequest, Operation>
      updateFeatureMethodDescriptor =
          ApiMethodDescriptor.<UpdateFeatureRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/UpdateFeature")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateFeatureRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/features/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateFeatureRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateFeatureRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("resource", request.getResource(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateFeatureRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          GenerateConnectManifestRequest, GenerateConnectManifestResponse>
      generateConnectManifestMethodDescriptor =
          ApiMethodDescriptor
              .<GenerateConnectManifestRequest, GenerateConnectManifestResponse>newBuilder()
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/GenerateConnectManifest")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GenerateConnectManifestRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/memberships/*}:generateConnectManifest",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateConnectManifestRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateConnectManifestRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields,
                                "imagePullSecretContent",
                                request.getImagePullSecretContent());
                            serializer.putQueryParam(fields, "isUpgrade", request.getIsUpgrade());
                            serializer.putQueryParam(fields, "namespace", request.getNamespace());
                            serializer.putQueryParam(fields, "proxy", request.getProxy());
                            serializer.putQueryParam(fields, "registry", request.getRegistry());
                            serializer.putQueryParam(fields, "version", request.getVersion());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GenerateConnectManifestResponse>newBuilder()
                      .setDefaultInstance(GenerateConnectManifestResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListMembershipsRequest, ListMembershipsResponse>
      listMembershipsCallable;
  private final UnaryCallable<ListMembershipsRequest, ListMembershipsPagedResponse>
      listMembershipsPagedCallable;
  private final UnaryCallable<ListFeaturesRequest, ListFeaturesResponse> listFeaturesCallable;
  private final UnaryCallable<ListFeaturesRequest, ListFeaturesPagedResponse>
      listFeaturesPagedCallable;
  private final UnaryCallable<GetMembershipRequest, Membership> getMembershipCallable;
  private final UnaryCallable<GetFeatureRequest, Feature> getFeatureCallable;
  private final UnaryCallable<CreateMembershipRequest, Operation> createMembershipCallable;
  private final OperationCallable<CreateMembershipRequest, Membership, OperationMetadata>
      createMembershipOperationCallable;
  private final UnaryCallable<CreateFeatureRequest, Operation> createFeatureCallable;
  private final OperationCallable<CreateFeatureRequest, Feature, OperationMetadata>
      createFeatureOperationCallable;
  private final UnaryCallable<DeleteMembershipRequest, Operation> deleteMembershipCallable;
  private final OperationCallable<DeleteMembershipRequest, Empty, OperationMetadata>
      deleteMembershipOperationCallable;
  private final UnaryCallable<DeleteFeatureRequest, Operation> deleteFeatureCallable;
  private final OperationCallable<DeleteFeatureRequest, Empty, OperationMetadata>
      deleteFeatureOperationCallable;
  private final UnaryCallable<UpdateMembershipRequest, Operation> updateMembershipCallable;
  private final OperationCallable<UpdateMembershipRequest, Membership, OperationMetadata>
      updateMembershipOperationCallable;
  private final UnaryCallable<UpdateFeatureRequest, Operation> updateFeatureCallable;
  private final OperationCallable<UpdateFeatureRequest, Feature, OperationMetadata>
      updateFeatureOperationCallable;
  private final UnaryCallable<GenerateConnectManifestRequest, GenerateConnectManifestResponse>
      generateConnectManifestCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonGkeHubStub create(GkeHubStubSettings settings) throws IOException {
    return new HttpJsonGkeHubStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonGkeHubStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonGkeHubStub(GkeHubStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonGkeHubStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonGkeHubStub(
        GkeHubStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonGkeHubStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonGkeHubStub(GkeHubStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonGkeHubCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonGkeHubStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonGkeHubStub(
      GkeHubStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<ListMembershipsRequest, ListMembershipsResponse>
        listMembershipsTransportSettings =
            HttpJsonCallSettings.<ListMembershipsRequest, ListMembershipsResponse>newBuilder()
                .setMethodDescriptor(listMembershipsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListFeaturesRequest, ListFeaturesResponse> listFeaturesTransportSettings =
        HttpJsonCallSettings.<ListFeaturesRequest, ListFeaturesResponse>newBuilder()
            .setMethodDescriptor(listFeaturesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetMembershipRequest, Membership> getMembershipTransportSettings =
        HttpJsonCallSettings.<GetMembershipRequest, Membership>newBuilder()
            .setMethodDescriptor(getMembershipMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetFeatureRequest, Feature> getFeatureTransportSettings =
        HttpJsonCallSettings.<GetFeatureRequest, Feature>newBuilder()
            .setMethodDescriptor(getFeatureMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateMembershipRequest, Operation> createMembershipTransportSettings =
        HttpJsonCallSettings.<CreateMembershipRequest, Operation>newBuilder()
            .setMethodDescriptor(createMembershipMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateFeatureRequest, Operation> createFeatureTransportSettings =
        HttpJsonCallSettings.<CreateFeatureRequest, Operation>newBuilder()
            .setMethodDescriptor(createFeatureMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteMembershipRequest, Operation> deleteMembershipTransportSettings =
        HttpJsonCallSettings.<DeleteMembershipRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMembershipMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteFeatureRequest, Operation> deleteFeatureTransportSettings =
        HttpJsonCallSettings.<DeleteFeatureRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteFeatureMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateMembershipRequest, Operation> updateMembershipTransportSettings =
        HttpJsonCallSettings.<UpdateMembershipRequest, Operation>newBuilder()
            .setMethodDescriptor(updateMembershipMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateFeatureRequest, Operation> updateFeatureTransportSettings =
        HttpJsonCallSettings.<UpdateFeatureRequest, Operation>newBuilder()
            .setMethodDescriptor(updateFeatureMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GenerateConnectManifestRequest, GenerateConnectManifestResponse>
        generateConnectManifestTransportSettings =
            HttpJsonCallSettings
                .<GenerateConnectManifestRequest, GenerateConnectManifestResponse>newBuilder()
                .setMethodDescriptor(generateConnectManifestMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.listMembershipsCallable =
        callableFactory.createUnaryCallable(
            listMembershipsTransportSettings, settings.listMembershipsSettings(), clientContext);
    this.listMembershipsPagedCallable =
        callableFactory.createPagedCallable(
            listMembershipsTransportSettings, settings.listMembershipsSettings(), clientContext);
    this.listFeaturesCallable =
        callableFactory.createUnaryCallable(
            listFeaturesTransportSettings, settings.listFeaturesSettings(), clientContext);
    this.listFeaturesPagedCallable =
        callableFactory.createPagedCallable(
            listFeaturesTransportSettings, settings.listFeaturesSettings(), clientContext);
    this.getMembershipCallable =
        callableFactory.createUnaryCallable(
            getMembershipTransportSettings, settings.getMembershipSettings(), clientContext);
    this.getFeatureCallable =
        callableFactory.createUnaryCallable(
            getFeatureTransportSettings, settings.getFeatureSettings(), clientContext);
    this.createMembershipCallable =
        callableFactory.createUnaryCallable(
            createMembershipTransportSettings, settings.createMembershipSettings(), clientContext);
    this.createMembershipOperationCallable =
        callableFactory.createOperationCallable(
            createMembershipTransportSettings,
            settings.createMembershipOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.createFeatureCallable =
        callableFactory.createUnaryCallable(
            createFeatureTransportSettings, settings.createFeatureSettings(), clientContext);
    this.createFeatureOperationCallable =
        callableFactory.createOperationCallable(
            createFeatureTransportSettings,
            settings.createFeatureOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteMembershipCallable =
        callableFactory.createUnaryCallable(
            deleteMembershipTransportSettings, settings.deleteMembershipSettings(), clientContext);
    this.deleteMembershipOperationCallable =
        callableFactory.createOperationCallable(
            deleteMembershipTransportSettings,
            settings.deleteMembershipOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteFeatureCallable =
        callableFactory.createUnaryCallable(
            deleteFeatureTransportSettings, settings.deleteFeatureSettings(), clientContext);
    this.deleteFeatureOperationCallable =
        callableFactory.createOperationCallable(
            deleteFeatureTransportSettings,
            settings.deleteFeatureOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateMembershipCallable =
        callableFactory.createUnaryCallable(
            updateMembershipTransportSettings, settings.updateMembershipSettings(), clientContext);
    this.updateMembershipOperationCallable =
        callableFactory.createOperationCallable(
            updateMembershipTransportSettings,
            settings.updateMembershipOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateFeatureCallable =
        callableFactory.createUnaryCallable(
            updateFeatureTransportSettings, settings.updateFeatureSettings(), clientContext);
    this.updateFeatureOperationCallable =
        callableFactory.createOperationCallable(
            updateFeatureTransportSettings,
            settings.updateFeatureOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.generateConnectManifestCallable =
        callableFactory.createUnaryCallable(
            generateConnectManifestTransportSettings,
            settings.generateConnectManifestSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listMembershipsMethodDescriptor);
    methodDescriptors.add(listFeaturesMethodDescriptor);
    methodDescriptors.add(getMembershipMethodDescriptor);
    methodDescriptors.add(getFeatureMethodDescriptor);
    methodDescriptors.add(createMembershipMethodDescriptor);
    methodDescriptors.add(createFeatureMethodDescriptor);
    methodDescriptors.add(deleteMembershipMethodDescriptor);
    methodDescriptors.add(deleteFeatureMethodDescriptor);
    methodDescriptors.add(updateMembershipMethodDescriptor);
    methodDescriptors.add(updateFeatureMethodDescriptor);
    methodDescriptors.add(generateConnectManifestMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ListMembershipsRequest, ListMembershipsResponse> listMembershipsCallable() {
    return listMembershipsCallable;
  }

  @Override
  public UnaryCallable<ListMembershipsRequest, ListMembershipsPagedResponse>
      listMembershipsPagedCallable() {
    return listMembershipsPagedCallable;
  }

  @Override
  public UnaryCallable<ListFeaturesRequest, ListFeaturesResponse> listFeaturesCallable() {
    return listFeaturesCallable;
  }

  @Override
  public UnaryCallable<ListFeaturesRequest, ListFeaturesPagedResponse> listFeaturesPagedCallable() {
    return listFeaturesPagedCallable;
  }

  @Override
  public UnaryCallable<GetMembershipRequest, Membership> getMembershipCallable() {
    return getMembershipCallable;
  }

  @Override
  public UnaryCallable<GetFeatureRequest, Feature> getFeatureCallable() {
    return getFeatureCallable;
  }

  @Override
  public UnaryCallable<CreateMembershipRequest, Operation> createMembershipCallable() {
    return createMembershipCallable;
  }

  @Override
  public OperationCallable<CreateMembershipRequest, Membership, OperationMetadata>
      createMembershipOperationCallable() {
    return createMembershipOperationCallable;
  }

  @Override
  public UnaryCallable<CreateFeatureRequest, Operation> createFeatureCallable() {
    return createFeatureCallable;
  }

  @Override
  public OperationCallable<CreateFeatureRequest, Feature, OperationMetadata>
      createFeatureOperationCallable() {
    return createFeatureOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteMembershipRequest, Operation> deleteMembershipCallable() {
    return deleteMembershipCallable;
  }

  @Override
  public OperationCallable<DeleteMembershipRequest, Empty, OperationMetadata>
      deleteMembershipOperationCallable() {
    return deleteMembershipOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteFeatureRequest, Operation> deleteFeatureCallable() {
    return deleteFeatureCallable;
  }

  @Override
  public OperationCallable<DeleteFeatureRequest, Empty, OperationMetadata>
      deleteFeatureOperationCallable() {
    return deleteFeatureOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateMembershipRequest, Operation> updateMembershipCallable() {
    return updateMembershipCallable;
  }

  @Override
  public OperationCallable<UpdateMembershipRequest, Membership, OperationMetadata>
      updateMembershipOperationCallable() {
    return updateMembershipOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateFeatureRequest, Operation> updateFeatureCallable() {
    return updateFeatureCallable;
  }

  @Override
  public OperationCallable<UpdateFeatureRequest, Feature, OperationMetadata>
      updateFeatureOperationCallable() {
    return updateFeatureOperationCallable;
  }

  @Override
  public UnaryCallable<GenerateConnectManifestRequest, GenerateConnectManifestResponse>
      generateConnectManifestCallable() {
    return generateConnectManifestCallable;
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
