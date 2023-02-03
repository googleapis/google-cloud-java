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

package com.google.cloud.gkemulticloud.v1.stub;

import static com.google.cloud.gkemulticloud.v1.AttachedClustersClient.ListAttachedClustersPagedResponse;

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
import com.google.cloud.gkemulticloud.v1.AttachedCluster;
import com.google.cloud.gkemulticloud.v1.AttachedServerConfig;
import com.google.cloud.gkemulticloud.v1.CreateAttachedClusterRequest;
import com.google.cloud.gkemulticloud.v1.DeleteAttachedClusterRequest;
import com.google.cloud.gkemulticloud.v1.GenerateAttachedClusterInstallManifestRequest;
import com.google.cloud.gkemulticloud.v1.GenerateAttachedClusterInstallManifestResponse;
import com.google.cloud.gkemulticloud.v1.GetAttachedClusterRequest;
import com.google.cloud.gkemulticloud.v1.GetAttachedServerConfigRequest;
import com.google.cloud.gkemulticloud.v1.ImportAttachedClusterRequest;
import com.google.cloud.gkemulticloud.v1.ListAttachedClustersRequest;
import com.google.cloud.gkemulticloud.v1.ListAttachedClustersResponse;
import com.google.cloud.gkemulticloud.v1.OperationMetadata;
import com.google.cloud.gkemulticloud.v1.UpdateAttachedClusterRequest;
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
 * REST stub implementation for the AttachedClusters service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonAttachedClustersStub extends AttachedClustersStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(AttachedCluster.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(Empty.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateAttachedClusterRequest, Operation>
      createAttachedClusterMethodDescriptor =
          ApiMethodDescriptor.<CreateAttachedClusterRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.gkemulticloud.v1.AttachedClusters/CreateAttachedCluster")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateAttachedClusterRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/attachedClusters",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAttachedClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAttachedClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "attachedClusterId", request.getAttachedClusterId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("attachedCluster", request.getAttachedCluster(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateAttachedClusterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateAttachedClusterRequest, Operation>
      updateAttachedClusterMethodDescriptor =
          ApiMethodDescriptor.<UpdateAttachedClusterRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.gkemulticloud.v1.AttachedClusters/UpdateAttachedCluster")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateAttachedClusterRequest>newBuilder()
                      .setPath(
                          "/v1/{attachedCluster.name=projects/*/locations/*/attachedClusters/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAttachedClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "attachedCluster.name",
                                request.getAttachedCluster().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAttachedClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("attachedCluster", request.getAttachedCluster(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateAttachedClusterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ImportAttachedClusterRequest, Operation>
      importAttachedClusterMethodDescriptor =
          ApiMethodDescriptor.<ImportAttachedClusterRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.gkemulticloud.v1.AttachedClusters/ImportAttachedCluster")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ImportAttachedClusterRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/attachedClusters:import",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ImportAttachedClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ImportAttachedClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ImportAttachedClusterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetAttachedClusterRequest, AttachedCluster>
      getAttachedClusterMethodDescriptor =
          ApiMethodDescriptor.<GetAttachedClusterRequest, AttachedCluster>newBuilder()
              .setFullMethodName(
                  "google.cloud.gkemulticloud.v1.AttachedClusters/GetAttachedCluster")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAttachedClusterRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/attachedClusters/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAttachedClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAttachedClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AttachedCluster>newBuilder()
                      .setDefaultInstance(AttachedCluster.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListAttachedClustersRequest, ListAttachedClustersResponse>
      listAttachedClustersMethodDescriptor =
          ApiMethodDescriptor
              .<ListAttachedClustersRequest, ListAttachedClustersResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.gkemulticloud.v1.AttachedClusters/ListAttachedClusters")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAttachedClustersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/attachedClusters",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAttachedClustersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAttachedClustersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAttachedClustersResponse>newBuilder()
                      .setDefaultInstance(ListAttachedClustersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteAttachedClusterRequest, Operation>
      deleteAttachedClusterMethodDescriptor =
          ApiMethodDescriptor.<DeleteAttachedClusterRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.gkemulticloud.v1.AttachedClusters/DeleteAttachedCluster")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteAttachedClusterRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/attachedClusters/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAttachedClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAttachedClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(
                                fields, "ignoreErrors", request.getIgnoreErrors());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
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
                  (DeleteAttachedClusterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetAttachedServerConfigRequest, AttachedServerConfig>
      getAttachedServerConfigMethodDescriptor =
          ApiMethodDescriptor.<GetAttachedServerConfigRequest, AttachedServerConfig>newBuilder()
              .setFullMethodName(
                  "google.cloud.gkemulticloud.v1.AttachedClusters/GetAttachedServerConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAttachedServerConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/attachedServerConfig}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAttachedServerConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAttachedServerConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AttachedServerConfig>newBuilder()
                      .setDefaultInstance(AttachedServerConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GenerateAttachedClusterInstallManifestRequest,
          GenerateAttachedClusterInstallManifestResponse>
      generateAttachedClusterInstallManifestMethodDescriptor =
          ApiMethodDescriptor
              .<GenerateAttachedClusterInstallManifestRequest,
                  GenerateAttachedClusterInstallManifestResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.gkemulticloud.v1.AttachedClusters/GenerateAttachedClusterInstallManifest")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<GenerateAttachedClusterInstallManifestRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}:generateAttachedClusterInstallManifest",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateAttachedClusterInstallManifestRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateAttachedClusterInstallManifestRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "attachedClusterId", request.getAttachedClusterId());
                            serializer.putQueryParam(
                                fields, "platformVersion", request.getPlatformVersion());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<GenerateAttachedClusterInstallManifestResponse>newBuilder()
                      .setDefaultInstance(
                          GenerateAttachedClusterInstallManifestResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateAttachedClusterRequest, Operation>
      createAttachedClusterCallable;
  private final OperationCallable<CreateAttachedClusterRequest, AttachedCluster, OperationMetadata>
      createAttachedClusterOperationCallable;
  private final UnaryCallable<UpdateAttachedClusterRequest, Operation>
      updateAttachedClusterCallable;
  private final OperationCallable<UpdateAttachedClusterRequest, AttachedCluster, OperationMetadata>
      updateAttachedClusterOperationCallable;
  private final UnaryCallable<ImportAttachedClusterRequest, Operation>
      importAttachedClusterCallable;
  private final OperationCallable<ImportAttachedClusterRequest, AttachedCluster, OperationMetadata>
      importAttachedClusterOperationCallable;
  private final UnaryCallable<GetAttachedClusterRequest, AttachedCluster>
      getAttachedClusterCallable;
  private final UnaryCallable<ListAttachedClustersRequest, ListAttachedClustersResponse>
      listAttachedClustersCallable;
  private final UnaryCallable<ListAttachedClustersRequest, ListAttachedClustersPagedResponse>
      listAttachedClustersPagedCallable;
  private final UnaryCallable<DeleteAttachedClusterRequest, Operation>
      deleteAttachedClusterCallable;
  private final OperationCallable<DeleteAttachedClusterRequest, Empty, OperationMetadata>
      deleteAttachedClusterOperationCallable;
  private final UnaryCallable<GetAttachedServerConfigRequest, AttachedServerConfig>
      getAttachedServerConfigCallable;
  private final UnaryCallable<
          GenerateAttachedClusterInstallManifestRequest,
          GenerateAttachedClusterInstallManifestResponse>
      generateAttachedClusterInstallManifestCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAttachedClustersStub create(AttachedClustersStubSettings settings)
      throws IOException {
    return new HttpJsonAttachedClustersStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAttachedClustersStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonAttachedClustersStub(
        AttachedClustersStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonAttachedClustersStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAttachedClustersStub(
        AttachedClustersStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAttachedClustersStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAttachedClustersStub(
      AttachedClustersStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonAttachedClustersCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAttachedClustersStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAttachedClustersStub(
      AttachedClustersStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<CreateAttachedClusterRequest, Operation>
        createAttachedClusterTransportSettings =
            HttpJsonCallSettings.<CreateAttachedClusterRequest, Operation>newBuilder()
                .setMethodDescriptor(createAttachedClusterMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateAttachedClusterRequest, Operation>
        updateAttachedClusterTransportSettings =
            HttpJsonCallSettings.<UpdateAttachedClusterRequest, Operation>newBuilder()
                .setMethodDescriptor(updateAttachedClusterMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ImportAttachedClusterRequest, Operation>
        importAttachedClusterTransportSettings =
            HttpJsonCallSettings.<ImportAttachedClusterRequest, Operation>newBuilder()
                .setMethodDescriptor(importAttachedClusterMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetAttachedClusterRequest, AttachedCluster>
        getAttachedClusterTransportSettings =
            HttpJsonCallSettings.<GetAttachedClusterRequest, AttachedCluster>newBuilder()
                .setMethodDescriptor(getAttachedClusterMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListAttachedClustersRequest, ListAttachedClustersResponse>
        listAttachedClustersTransportSettings =
            HttpJsonCallSettings
                .<ListAttachedClustersRequest, ListAttachedClustersResponse>newBuilder()
                .setMethodDescriptor(listAttachedClustersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteAttachedClusterRequest, Operation>
        deleteAttachedClusterTransportSettings =
            HttpJsonCallSettings.<DeleteAttachedClusterRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteAttachedClusterMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetAttachedServerConfigRequest, AttachedServerConfig>
        getAttachedServerConfigTransportSettings =
            HttpJsonCallSettings.<GetAttachedServerConfigRequest, AttachedServerConfig>newBuilder()
                .setMethodDescriptor(getAttachedServerConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<
            GenerateAttachedClusterInstallManifestRequest,
            GenerateAttachedClusterInstallManifestResponse>
        generateAttachedClusterInstallManifestTransportSettings =
            HttpJsonCallSettings
                .<GenerateAttachedClusterInstallManifestRequest,
                    GenerateAttachedClusterInstallManifestResponse>
                    newBuilder()
                .setMethodDescriptor(generateAttachedClusterInstallManifestMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.createAttachedClusterCallable =
        callableFactory.createUnaryCallable(
            createAttachedClusterTransportSettings,
            settings.createAttachedClusterSettings(),
            clientContext);
    this.createAttachedClusterOperationCallable =
        callableFactory.createOperationCallable(
            createAttachedClusterTransportSettings,
            settings.createAttachedClusterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateAttachedClusterCallable =
        callableFactory.createUnaryCallable(
            updateAttachedClusterTransportSettings,
            settings.updateAttachedClusterSettings(),
            clientContext);
    this.updateAttachedClusterOperationCallable =
        callableFactory.createOperationCallable(
            updateAttachedClusterTransportSettings,
            settings.updateAttachedClusterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.importAttachedClusterCallable =
        callableFactory.createUnaryCallable(
            importAttachedClusterTransportSettings,
            settings.importAttachedClusterSettings(),
            clientContext);
    this.importAttachedClusterOperationCallable =
        callableFactory.createOperationCallable(
            importAttachedClusterTransportSettings,
            settings.importAttachedClusterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getAttachedClusterCallable =
        callableFactory.createUnaryCallable(
            getAttachedClusterTransportSettings,
            settings.getAttachedClusterSettings(),
            clientContext);
    this.listAttachedClustersCallable =
        callableFactory.createUnaryCallable(
            listAttachedClustersTransportSettings,
            settings.listAttachedClustersSettings(),
            clientContext);
    this.listAttachedClustersPagedCallable =
        callableFactory.createPagedCallable(
            listAttachedClustersTransportSettings,
            settings.listAttachedClustersSettings(),
            clientContext);
    this.deleteAttachedClusterCallable =
        callableFactory.createUnaryCallable(
            deleteAttachedClusterTransportSettings,
            settings.deleteAttachedClusterSettings(),
            clientContext);
    this.deleteAttachedClusterOperationCallable =
        callableFactory.createOperationCallable(
            deleteAttachedClusterTransportSettings,
            settings.deleteAttachedClusterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getAttachedServerConfigCallable =
        callableFactory.createUnaryCallable(
            getAttachedServerConfigTransportSettings,
            settings.getAttachedServerConfigSettings(),
            clientContext);
    this.generateAttachedClusterInstallManifestCallable =
        callableFactory.createUnaryCallable(
            generateAttachedClusterInstallManifestTransportSettings,
            settings.generateAttachedClusterInstallManifestSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createAttachedClusterMethodDescriptor);
    methodDescriptors.add(updateAttachedClusterMethodDescriptor);
    methodDescriptors.add(importAttachedClusterMethodDescriptor);
    methodDescriptors.add(getAttachedClusterMethodDescriptor);
    methodDescriptors.add(listAttachedClustersMethodDescriptor);
    methodDescriptors.add(deleteAttachedClusterMethodDescriptor);
    methodDescriptors.add(getAttachedServerConfigMethodDescriptor);
    methodDescriptors.add(generateAttachedClusterInstallManifestMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<CreateAttachedClusterRequest, Operation> createAttachedClusterCallable() {
    return createAttachedClusterCallable;
  }

  @Override
  public OperationCallable<CreateAttachedClusterRequest, AttachedCluster, OperationMetadata>
      createAttachedClusterOperationCallable() {
    return createAttachedClusterOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateAttachedClusterRequest, Operation> updateAttachedClusterCallable() {
    return updateAttachedClusterCallable;
  }

  @Override
  public OperationCallable<UpdateAttachedClusterRequest, AttachedCluster, OperationMetadata>
      updateAttachedClusterOperationCallable() {
    return updateAttachedClusterOperationCallable;
  }

  @Override
  public UnaryCallable<ImportAttachedClusterRequest, Operation> importAttachedClusterCallable() {
    return importAttachedClusterCallable;
  }

  @Override
  public OperationCallable<ImportAttachedClusterRequest, AttachedCluster, OperationMetadata>
      importAttachedClusterOperationCallable() {
    return importAttachedClusterOperationCallable;
  }

  @Override
  public UnaryCallable<GetAttachedClusterRequest, AttachedCluster> getAttachedClusterCallable() {
    return getAttachedClusterCallable;
  }

  @Override
  public UnaryCallable<ListAttachedClustersRequest, ListAttachedClustersResponse>
      listAttachedClustersCallable() {
    return listAttachedClustersCallable;
  }

  @Override
  public UnaryCallable<ListAttachedClustersRequest, ListAttachedClustersPagedResponse>
      listAttachedClustersPagedCallable() {
    return listAttachedClustersPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteAttachedClusterRequest, Operation> deleteAttachedClusterCallable() {
    return deleteAttachedClusterCallable;
  }

  @Override
  public OperationCallable<DeleteAttachedClusterRequest, Empty, OperationMetadata>
      deleteAttachedClusterOperationCallable() {
    return deleteAttachedClusterOperationCallable;
  }

  @Override
  public UnaryCallable<GetAttachedServerConfigRequest, AttachedServerConfig>
      getAttachedServerConfigCallable() {
    return getAttachedServerConfigCallable;
  }

  @Override
  public UnaryCallable<
          GenerateAttachedClusterInstallManifestRequest,
          GenerateAttachedClusterInstallManifestResponse>
      generateAttachedClusterInstallManifestCallable() {
    return generateAttachedClusterInstallManifestCallable;
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
