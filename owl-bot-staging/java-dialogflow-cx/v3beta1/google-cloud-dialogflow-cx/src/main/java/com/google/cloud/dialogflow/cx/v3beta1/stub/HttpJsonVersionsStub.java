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

package com.google.cloud.dialogflow.cx.v3beta1.stub;

import static com.google.cloud.dialogflow.cx.v3beta1.VersionsClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3beta1.VersionsClient.ListVersionsPagedResponse;

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
import com.google.cloud.dialogflow.cx.v3beta1.CompareVersionsRequest;
import com.google.cloud.dialogflow.cx.v3beta1.CompareVersionsResponse;
import com.google.cloud.dialogflow.cx.v3beta1.CreateVersionOperationMetadata;
import com.google.cloud.dialogflow.cx.v3beta1.CreateVersionRequest;
import com.google.cloud.dialogflow.cx.v3beta1.DeleteVersionRequest;
import com.google.cloud.dialogflow.cx.v3beta1.GetVersionRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListVersionsRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListVersionsResponse;
import com.google.cloud.dialogflow.cx.v3beta1.LoadVersionRequest;
import com.google.cloud.dialogflow.cx.v3beta1.UpdateVersionRequest;
import com.google.cloud.dialogflow.cx.v3beta1.Version;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.Struct;
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
 * REST stub implementation for the Versions service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonVersionsStub extends VersionsStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Version.getDescriptor())
          .add(Empty.getDescriptor())
          .add(CreateVersionOperationMetadata.getDescriptor())
          .add(Struct.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListVersionsRequest, ListVersionsResponse>
      listVersionsMethodDescriptor =
          ApiMethodDescriptor.<ListVersionsRequest, ListVersionsResponse>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Versions/ListVersions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListVersionsRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{parent=projects/*/locations/*/agents/*/flows/*}/versions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListVersionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListVersionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListVersionsResponse>newBuilder()
                      .setDefaultInstance(ListVersionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetVersionRequest, Version> getVersionMethodDescriptor =
      ApiMethodDescriptor.<GetVersionRequest, Version>newBuilder()
          .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Versions/GetVersion")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetVersionRequest>newBuilder()
                  .setPath(
                      "/v3beta1/{name=projects/*/locations/*/agents/*/flows/*/versions/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetVersionRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetVersionRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Version>newBuilder()
                  .setDefaultInstance(Version.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateVersionRequest, Operation>
      createVersionMethodDescriptor =
          ApiMethodDescriptor.<CreateVersionRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Versions/CreateVersion")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateVersionRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{parent=projects/*/locations/*/agents/*/flows/*}/versions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("version", request.getVersion(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateVersionRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateVersionRequest, Version>
      updateVersionMethodDescriptor =
          ApiMethodDescriptor.<UpdateVersionRequest, Version>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Versions/UpdateVersion")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateVersionRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{version.name=projects/*/locations/*/agents/*/flows/*/versions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "version.name", request.getVersion().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("version", request.getVersion(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Version>newBuilder()
                      .setDefaultInstance(Version.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteVersionRequest, Empty>
      deleteVersionMethodDescriptor =
          ApiMethodDescriptor.<DeleteVersionRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Versions/DeleteVersion")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteVersionRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{name=projects/*/locations/*/agents/*/flows/*/versions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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

  private static final ApiMethodDescriptor<LoadVersionRequest, Operation>
      loadVersionMethodDescriptor =
          ApiMethodDescriptor.<LoadVersionRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Versions/LoadVersion")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<LoadVersionRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{name=projects/*/locations/*/agents/*/flows/*/versions/*}:load",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<LoadVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<LoadVersionRequest> serializer =
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
                  (LoadVersionRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CompareVersionsRequest, CompareVersionsResponse>
      compareVersionsMethodDescriptor =
          ApiMethodDescriptor.<CompareVersionsRequest, CompareVersionsResponse>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Versions/CompareVersions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CompareVersionsRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{baseVersion=projects/*/locations/*/agents/*/flows/*/versions/*}:compareVersions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CompareVersionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "baseVersion", request.getBaseVersion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CompareVersionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*", request.toBuilder().clearBaseVersion().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CompareVersionsResponse>newBuilder()
                      .setDefaultInstance(CompareVersionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
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
                          "/v3beta1/{name=projects/*}/locations",
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                          "/v3beta1/{name=projects/*/locations/*}",
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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

  private final UnaryCallable<ListVersionsRequest, ListVersionsResponse> listVersionsCallable;
  private final UnaryCallable<ListVersionsRequest, ListVersionsPagedResponse>
      listVersionsPagedCallable;
  private final UnaryCallable<GetVersionRequest, Version> getVersionCallable;
  private final UnaryCallable<CreateVersionRequest, Operation> createVersionCallable;
  private final OperationCallable<CreateVersionRequest, Version, CreateVersionOperationMetadata>
      createVersionOperationCallable;
  private final UnaryCallable<UpdateVersionRequest, Version> updateVersionCallable;
  private final UnaryCallable<DeleteVersionRequest, Empty> deleteVersionCallable;
  private final UnaryCallable<LoadVersionRequest, Operation> loadVersionCallable;
  private final OperationCallable<LoadVersionRequest, Empty, Struct> loadVersionOperationCallable;
  private final UnaryCallable<CompareVersionsRequest, CompareVersionsResponse>
      compareVersionsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonVersionsStub create(VersionsStubSettings settings)
      throws IOException {
    return new HttpJsonVersionsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonVersionsStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonVersionsStub(
        VersionsStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonVersionsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonVersionsStub(
        VersionsStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonVersionsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonVersionsStub(VersionsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonVersionsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonVersionsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonVersionsStub(
      VersionsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<ListVersionsRequest, ListVersionsResponse> listVersionsTransportSettings =
        HttpJsonCallSettings.<ListVersionsRequest, ListVersionsResponse>newBuilder()
            .setMethodDescriptor(listVersionsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetVersionRequest, Version> getVersionTransportSettings =
        HttpJsonCallSettings.<GetVersionRequest, Version>newBuilder()
            .setMethodDescriptor(getVersionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateVersionRequest, Operation> createVersionTransportSettings =
        HttpJsonCallSettings.<CreateVersionRequest, Operation>newBuilder()
            .setMethodDescriptor(createVersionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateVersionRequest, Version> updateVersionTransportSettings =
        HttpJsonCallSettings.<UpdateVersionRequest, Version>newBuilder()
            .setMethodDescriptor(updateVersionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteVersionRequest, Empty> deleteVersionTransportSettings =
        HttpJsonCallSettings.<DeleteVersionRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteVersionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<LoadVersionRequest, Operation> loadVersionTransportSettings =
        HttpJsonCallSettings.<LoadVersionRequest, Operation>newBuilder()
            .setMethodDescriptor(loadVersionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CompareVersionsRequest, CompareVersionsResponse>
        compareVersionsTransportSettings =
            HttpJsonCallSettings.<CompareVersionsRequest, CompareVersionsResponse>newBuilder()
                .setMethodDescriptor(compareVersionsMethodDescriptor)
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

    this.listVersionsCallable =
        callableFactory.createUnaryCallable(
            listVersionsTransportSettings, settings.listVersionsSettings(), clientContext);
    this.listVersionsPagedCallable =
        callableFactory.createPagedCallable(
            listVersionsTransportSettings, settings.listVersionsSettings(), clientContext);
    this.getVersionCallable =
        callableFactory.createUnaryCallable(
            getVersionTransportSettings, settings.getVersionSettings(), clientContext);
    this.createVersionCallable =
        callableFactory.createUnaryCallable(
            createVersionTransportSettings, settings.createVersionSettings(), clientContext);
    this.createVersionOperationCallable =
        callableFactory.createOperationCallable(
            createVersionTransportSettings,
            settings.createVersionOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateVersionCallable =
        callableFactory.createUnaryCallable(
            updateVersionTransportSettings, settings.updateVersionSettings(), clientContext);
    this.deleteVersionCallable =
        callableFactory.createUnaryCallable(
            deleteVersionTransportSettings, settings.deleteVersionSettings(), clientContext);
    this.loadVersionCallable =
        callableFactory.createUnaryCallable(
            loadVersionTransportSettings, settings.loadVersionSettings(), clientContext);
    this.loadVersionOperationCallable =
        callableFactory.createOperationCallable(
            loadVersionTransportSettings,
            settings.loadVersionOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.compareVersionsCallable =
        callableFactory.createUnaryCallable(
            compareVersionsTransportSettings, settings.compareVersionsSettings(), clientContext);
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
    methodDescriptors.add(listVersionsMethodDescriptor);
    methodDescriptors.add(getVersionMethodDescriptor);
    methodDescriptors.add(createVersionMethodDescriptor);
    methodDescriptors.add(updateVersionMethodDescriptor);
    methodDescriptors.add(deleteVersionMethodDescriptor);
    methodDescriptors.add(loadVersionMethodDescriptor);
    methodDescriptors.add(compareVersionsMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ListVersionsRequest, ListVersionsResponse> listVersionsCallable() {
    return listVersionsCallable;
  }

  @Override
  public UnaryCallable<ListVersionsRequest, ListVersionsPagedResponse> listVersionsPagedCallable() {
    return listVersionsPagedCallable;
  }

  @Override
  public UnaryCallable<GetVersionRequest, Version> getVersionCallable() {
    return getVersionCallable;
  }

  @Override
  public UnaryCallable<CreateVersionRequest, Operation> createVersionCallable() {
    return createVersionCallable;
  }

  @Override
  public OperationCallable<CreateVersionRequest, Version, CreateVersionOperationMetadata>
      createVersionOperationCallable() {
    return createVersionOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateVersionRequest, Version> updateVersionCallable() {
    return updateVersionCallable;
  }

  @Override
  public UnaryCallable<DeleteVersionRequest, Empty> deleteVersionCallable() {
    return deleteVersionCallable;
  }

  @Override
  public UnaryCallable<LoadVersionRequest, Operation> loadVersionCallable() {
    return loadVersionCallable;
  }

  @Override
  public OperationCallable<LoadVersionRequest, Empty, Struct> loadVersionOperationCallable() {
    return loadVersionOperationCallable;
  }

  @Override
  public UnaryCallable<CompareVersionsRequest, CompareVersionsResponse> compareVersionsCallable() {
    return compareVersionsCallable;
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
