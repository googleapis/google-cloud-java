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

package com.google.storage.control.v2.stub;

import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.httpjson.longrunning.stub.HttpJsonOperationsStub;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.TypeRegistry;
import com.google.storage.control.v2.AnywhereCache;
import com.google.storage.control.v2.CreateAnywhereCacheMetadata;
import com.google.storage.control.v2.CreateAnywhereCacheRequest;
import com.google.storage.control.v2.CreateFolderRequest;
import com.google.storage.control.v2.CreateManagedFolderRequest;
import com.google.storage.control.v2.DeleteFolderRecursiveMetadata;
import com.google.storage.control.v2.DeleteFolderRecursiveRequest;
import com.google.storage.control.v2.DeleteFolderRequest;
import com.google.storage.control.v2.DeleteManagedFolderRequest;
import com.google.storage.control.v2.DisableAnywhereCacheRequest;
import com.google.storage.control.v2.Folder;
import com.google.storage.control.v2.GetAnywhereCacheRequest;
import com.google.storage.control.v2.GetFolderIntelligenceConfigRequest;
import com.google.storage.control.v2.GetFolderRequest;
import com.google.storage.control.v2.GetManagedFolderRequest;
import com.google.storage.control.v2.GetOrganizationIntelligenceConfigRequest;
import com.google.storage.control.v2.GetProjectIntelligenceConfigRequest;
import com.google.storage.control.v2.GetStorageLayoutRequest;
import com.google.storage.control.v2.IntelligenceConfig;
import com.google.storage.control.v2.ListAnywhereCachesRequest;
import com.google.storage.control.v2.ListAnywhereCachesResponse;
import com.google.storage.control.v2.ListFoldersRequest;
import com.google.storage.control.v2.ListFoldersResponse;
import com.google.storage.control.v2.ListManagedFoldersRequest;
import com.google.storage.control.v2.ListManagedFoldersResponse;
import com.google.storage.control.v2.ManagedFolder;
import com.google.storage.control.v2.PauseAnywhereCacheRequest;
import com.google.storage.control.v2.RenameFolderMetadata;
import com.google.storage.control.v2.RenameFolderRequest;
import com.google.storage.control.v2.ResumeAnywhereCacheRequest;
import com.google.storage.control.v2.StorageLayout;
import com.google.storage.control.v2.UpdateAnywhereCacheMetadata;
import com.google.storage.control.v2.UpdateAnywhereCacheRequest;
import com.google.storage.control.v2.UpdateFolderIntelligenceConfigRequest;
import com.google.storage.control.v2.UpdateOrganizationIntelligenceConfigRequest;
import com.google.storage.control.v2.UpdateProjectIntelligenceConfigRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the StorageControl service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonStorageControlStub extends StorageControlStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(RenameFolderMetadata.getDescriptor())
          .add(Folder.getDescriptor())
          .add(AnywhereCache.getDescriptor())
          .add(UpdateAnywhereCacheMetadata.getDescriptor())
          .add(DeleteFolderRecursiveMetadata.getDescriptor())
          .add(CreateAnywhereCacheMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<GetProjectIntelligenceConfigRequest, IntelligenceConfig>
      getProjectIntelligenceConfigMethodDescriptor =
          ApiMethodDescriptor.<GetProjectIntelligenceConfigRequest, IntelligenceConfig>newBuilder()
              .setFullMethodName(
                  "google.storage.control.v2.StorageControl/GetProjectIntelligenceConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetProjectIntelligenceConfigRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/intelligenceConfig}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetProjectIntelligenceConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetProjectIntelligenceConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<IntelligenceConfig>newBuilder()
                      .setDefaultInstance(IntelligenceConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          UpdateProjectIntelligenceConfigRequest, IntelligenceConfig>
      updateProjectIntelligenceConfigMethodDescriptor =
          ApiMethodDescriptor
              .<UpdateProjectIntelligenceConfigRequest, IntelligenceConfig>newBuilder()
              .setFullMethodName(
                  "google.storage.control.v2.StorageControl/UpdateProjectIntelligenceConfig")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateProjectIntelligenceConfigRequest>newBuilder()
                      .setPath(
                          "/v2/{intelligenceConfig.name=projects/*/locations/*/intelligenceConfig}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateProjectIntelligenceConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "intelligenceConfig.name",
                                request.getIntelligenceConfig().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateProjectIntelligenceConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "intelligenceConfig", request.getIntelligenceConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<IntelligenceConfig>newBuilder()
                      .setDefaultInstance(IntelligenceConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetFolderIntelligenceConfigRequest, IntelligenceConfig>
      getFolderIntelligenceConfigMethodDescriptor =
          ApiMethodDescriptor.<GetFolderIntelligenceConfigRequest, IntelligenceConfig>newBuilder()
              .setFullMethodName(
                  "google.storage.control.v2.StorageControl/GetFolderIntelligenceConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetFolderIntelligenceConfigRequest>newBuilder()
                      .setPath(
                          "/v2/{name=folders/*/locations/*/intelligenceConfig}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetFolderIntelligenceConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetFolderIntelligenceConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<IntelligenceConfig>newBuilder()
                      .setDefaultInstance(IntelligenceConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          UpdateFolderIntelligenceConfigRequest, IntelligenceConfig>
      updateFolderIntelligenceConfigMethodDescriptor =
          ApiMethodDescriptor
              .<UpdateFolderIntelligenceConfigRequest, IntelligenceConfig>newBuilder()
              .setFullMethodName(
                  "google.storage.control.v2.StorageControl/UpdateFolderIntelligenceConfig")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateFolderIntelligenceConfigRequest>newBuilder()
                      .setPath(
                          "/v2/{intelligenceConfig.name=folders/*/locations/*/intelligenceConfig}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateFolderIntelligenceConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "intelligenceConfig.name",
                                request.getIntelligenceConfig().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateFolderIntelligenceConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "intelligenceConfig", request.getIntelligenceConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<IntelligenceConfig>newBuilder()
                      .setDefaultInstance(IntelligenceConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GetOrganizationIntelligenceConfigRequest, IntelligenceConfig>
      getOrganizationIntelligenceConfigMethodDescriptor =
          ApiMethodDescriptor
              .<GetOrganizationIntelligenceConfigRequest, IntelligenceConfig>newBuilder()
              .setFullMethodName(
                  "google.storage.control.v2.StorageControl/GetOrganizationIntelligenceConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<GetOrganizationIntelligenceConfigRequest>newBuilder()
                      .setPath(
                          "/v2/{name=organizations/*/locations/*/intelligenceConfig}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetOrganizationIntelligenceConfigRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetOrganizationIntelligenceConfigRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<IntelligenceConfig>newBuilder()
                      .setDefaultInstance(IntelligenceConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          UpdateOrganizationIntelligenceConfigRequest, IntelligenceConfig>
      updateOrganizationIntelligenceConfigMethodDescriptor =
          ApiMethodDescriptor
              .<UpdateOrganizationIntelligenceConfigRequest, IntelligenceConfig>newBuilder()
              .setFullMethodName(
                  "google.storage.control.v2.StorageControl/UpdateOrganizationIntelligenceConfig")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<UpdateOrganizationIntelligenceConfigRequest>newBuilder()
                      .setPath(
                          "/v2/{intelligenceConfig.name=organizations/*/locations/*/intelligenceConfig}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateOrganizationIntelligenceConfigRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "intelligenceConfig.name",
                                request.getIntelligenceConfig().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateOrganizationIntelligenceConfigRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "intelligenceConfig", request.getIntelligenceConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<IntelligenceConfig>newBuilder()
                      .setDefaultInstance(IntelligenceConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetProjectIntelligenceConfigRequest, IntelligenceConfig>
      getProjectIntelligenceConfigCallable;
  private final UnaryCallable<UpdateProjectIntelligenceConfigRequest, IntelligenceConfig>
      updateProjectIntelligenceConfigCallable;
  private final UnaryCallable<GetFolderIntelligenceConfigRequest, IntelligenceConfig>
      getFolderIntelligenceConfigCallable;
  private final UnaryCallable<UpdateFolderIntelligenceConfigRequest, IntelligenceConfig>
      updateFolderIntelligenceConfigCallable;
  private final UnaryCallable<GetOrganizationIntelligenceConfigRequest, IntelligenceConfig>
      getOrganizationIntelligenceConfigCallable;
  private final UnaryCallable<UpdateOrganizationIntelligenceConfigRequest, IntelligenceConfig>
      updateOrganizationIntelligenceConfigCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonStorageControlStub create(StorageControlStubSettings settings)
      throws IOException {
    return new HttpJsonStorageControlStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonStorageControlStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonStorageControlStub(
        StorageControlStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonStorageControlStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonStorageControlStub(
        StorageControlStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonStorageControlStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonStorageControlStub(
      StorageControlStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonStorageControlCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonStorageControlStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonStorageControlStub(
      StorageControlStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<GetProjectIntelligenceConfigRequest, IntelligenceConfig>
        getProjectIntelligenceConfigTransportSettings =
            HttpJsonCallSettings
                .<GetProjectIntelligenceConfigRequest, IntelligenceConfig>newBuilder()
                .setMethodDescriptor(getProjectIntelligenceConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<UpdateProjectIntelligenceConfigRequest, IntelligenceConfig>
        updateProjectIntelligenceConfigTransportSettings =
            HttpJsonCallSettings
                .<UpdateProjectIntelligenceConfigRequest, IntelligenceConfig>newBuilder()
                .setMethodDescriptor(updateProjectIntelligenceConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "intelligence_config.name",
                          String.valueOf(request.getIntelligenceConfig().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetFolderIntelligenceConfigRequest, IntelligenceConfig>
        getFolderIntelligenceConfigTransportSettings =
            HttpJsonCallSettings
                .<GetFolderIntelligenceConfigRequest, IntelligenceConfig>newBuilder()
                .setMethodDescriptor(getFolderIntelligenceConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<UpdateFolderIntelligenceConfigRequest, IntelligenceConfig>
        updateFolderIntelligenceConfigTransportSettings =
            HttpJsonCallSettings
                .<UpdateFolderIntelligenceConfigRequest, IntelligenceConfig>newBuilder()
                .setMethodDescriptor(updateFolderIntelligenceConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "intelligence_config.name",
                          String.valueOf(request.getIntelligenceConfig().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetOrganizationIntelligenceConfigRequest, IntelligenceConfig>
        getOrganizationIntelligenceConfigTransportSettings =
            HttpJsonCallSettings
                .<GetOrganizationIntelligenceConfigRequest, IntelligenceConfig>newBuilder()
                .setMethodDescriptor(getOrganizationIntelligenceConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<UpdateOrganizationIntelligenceConfigRequest, IntelligenceConfig>
        updateOrganizationIntelligenceConfigTransportSettings =
            HttpJsonCallSettings
                .<UpdateOrganizationIntelligenceConfigRequest, IntelligenceConfig>newBuilder()
                .setMethodDescriptor(updateOrganizationIntelligenceConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "intelligence_config.name",
                          String.valueOf(request.getIntelligenceConfig().getName()));
                      return builder.build();
                    })
                .build();

    this.getProjectIntelligenceConfigCallable =
        callableFactory.createUnaryCallable(
            getProjectIntelligenceConfigTransportSettings,
            settings.getProjectIntelligenceConfigSettings(),
            clientContext);
    this.updateProjectIntelligenceConfigCallable =
        callableFactory.createUnaryCallable(
            updateProjectIntelligenceConfigTransportSettings,
            settings.updateProjectIntelligenceConfigSettings(),
            clientContext);
    this.getFolderIntelligenceConfigCallable =
        callableFactory.createUnaryCallable(
            getFolderIntelligenceConfigTransportSettings,
            settings.getFolderIntelligenceConfigSettings(),
            clientContext);
    this.updateFolderIntelligenceConfigCallable =
        callableFactory.createUnaryCallable(
            updateFolderIntelligenceConfigTransportSettings,
            settings.updateFolderIntelligenceConfigSettings(),
            clientContext);
    this.getOrganizationIntelligenceConfigCallable =
        callableFactory.createUnaryCallable(
            getOrganizationIntelligenceConfigTransportSettings,
            settings.getOrganizationIntelligenceConfigSettings(),
            clientContext);
    this.updateOrganizationIntelligenceConfigCallable =
        callableFactory.createUnaryCallable(
            updateOrganizationIntelligenceConfigTransportSettings,
            settings.updateOrganizationIntelligenceConfigSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getProjectIntelligenceConfigMethodDescriptor);
    methodDescriptors.add(updateProjectIntelligenceConfigMethodDescriptor);
    methodDescriptors.add(getFolderIntelligenceConfigMethodDescriptor);
    methodDescriptors.add(updateFolderIntelligenceConfigMethodDescriptor);
    methodDescriptors.add(getOrganizationIntelligenceConfigMethodDescriptor);
    methodDescriptors.add(updateOrganizationIntelligenceConfigMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<GetProjectIntelligenceConfigRequest, IntelligenceConfig>
      getProjectIntelligenceConfigCallable() {
    return getProjectIntelligenceConfigCallable;
  }

  @Override
  public UnaryCallable<UpdateProjectIntelligenceConfigRequest, IntelligenceConfig>
      updateProjectIntelligenceConfigCallable() {
    return updateProjectIntelligenceConfigCallable;
  }

  @Override
  public UnaryCallable<GetFolderIntelligenceConfigRequest, IntelligenceConfig>
      getFolderIntelligenceConfigCallable() {
    return getFolderIntelligenceConfigCallable;
  }

  @Override
  public UnaryCallable<UpdateFolderIntelligenceConfigRequest, IntelligenceConfig>
      updateFolderIntelligenceConfigCallable() {
    return updateFolderIntelligenceConfigCallable;
  }

  @Override
  public UnaryCallable<GetOrganizationIntelligenceConfigRequest, IntelligenceConfig>
      getOrganizationIntelligenceConfigCallable() {
    return getOrganizationIntelligenceConfigCallable;
  }

  @Override
  public UnaryCallable<UpdateOrganizationIntelligenceConfigRequest, IntelligenceConfig>
      updateOrganizationIntelligenceConfigCallable() {
    return updateOrganizationIntelligenceConfigCallable;
  }

  @Override
  public UnaryCallable<CreateFolderRequest, Folder> createFolderCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createFolderCallable(). REST transport is not implemented for this method"
            + " yet.");
  }

  @Override
  public UnaryCallable<DeleteFolderRequest, Empty> deleteFolderCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteFolderCallable(). REST transport is not implemented for this method"
            + " yet.");
  }

  @Override
  public UnaryCallable<GetFolderRequest, Folder> getFolderCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getFolderCallable(). REST transport is not implemented for this method"
            + " yet.");
  }

  @Override
  public UnaryCallable<ListFoldersRequest, ListFoldersResponse> listFoldersCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listFoldersCallable(). REST transport is not implemented for this method"
            + " yet.");
  }

  @Override
  public UnaryCallable<RenameFolderRequest, Operation> renameFolderCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: renameFolderCallable(). REST transport is not implemented for this method"
            + " yet.");
  }

  @Override
  public UnaryCallable<DeleteFolderRecursiveRequest, Operation> deleteFolderRecursiveCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteFolderRecursiveCallable(). REST transport is not implemented for"
            + " this method yet.");
  }

  @Override
  public UnaryCallable<GetStorageLayoutRequest, StorageLayout> getStorageLayoutCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getStorageLayoutCallable(). REST transport is not implemented for this"
            + " method yet.");
  }

  @Override
  public UnaryCallable<CreateManagedFolderRequest, ManagedFolder> createManagedFolderCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createManagedFolderCallable(). REST transport is not implemented for this"
            + " method yet.");
  }

  @Override
  public UnaryCallable<DeleteManagedFolderRequest, Empty> deleteManagedFolderCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteManagedFolderCallable(). REST transport is not implemented for this"
            + " method yet.");
  }

  @Override
  public UnaryCallable<GetManagedFolderRequest, ManagedFolder> getManagedFolderCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getManagedFolderCallable(). REST transport is not implemented for this"
            + " method yet.");
  }

  @Override
  public UnaryCallable<ListManagedFoldersRequest, ListManagedFoldersResponse>
      listManagedFoldersCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listManagedFoldersCallable(). REST transport is not implemented for this"
            + " method yet.");
  }

  @Override
  public UnaryCallable<CreateAnywhereCacheRequest, Operation> createAnywhereCacheCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createAnywhereCacheCallable(). REST transport is not implemented for this"
            + " method yet.");
  }

  @Override
  public UnaryCallable<UpdateAnywhereCacheRequest, Operation> updateAnywhereCacheCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateAnywhereCacheCallable(). REST transport is not implemented for this"
            + " method yet.");
  }

  @Override
  public UnaryCallable<DisableAnywhereCacheRequest, AnywhereCache> disableAnywhereCacheCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: disableAnywhereCacheCallable(). REST transport is not implemented for"
            + " this method yet.");
  }

  @Override
  public UnaryCallable<PauseAnywhereCacheRequest, AnywhereCache> pauseAnywhereCacheCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: pauseAnywhereCacheCallable(). REST transport is not implemented for this"
            + " method yet.");
  }

  @Override
  public UnaryCallable<ResumeAnywhereCacheRequest, AnywhereCache> resumeAnywhereCacheCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: resumeAnywhereCacheCallable(). REST transport is not implemented for this"
            + " method yet.");
  }

  @Override
  public UnaryCallable<GetAnywhereCacheRequest, AnywhereCache> getAnywhereCacheCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getAnywhereCacheCallable(). REST transport is not implemented for this"
            + " method yet.");
  }

  @Override
  public UnaryCallable<ListAnywhereCachesRequest, ListAnywhereCachesResponse>
      listAnywhereCachesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listAnywhereCachesCallable(). REST transport is not implemented for this"
            + " method yet.");
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getIamPolicyCallable(). REST transport is not implemented for this method"
            + " yet.");
  }

  @Override
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: setIamPolicyCallable(). REST transport is not implemented for this method"
            + " yet.");
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: testIamPermissionsCallable(). REST transport is not implemented for this"
            + " method yet.");
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
