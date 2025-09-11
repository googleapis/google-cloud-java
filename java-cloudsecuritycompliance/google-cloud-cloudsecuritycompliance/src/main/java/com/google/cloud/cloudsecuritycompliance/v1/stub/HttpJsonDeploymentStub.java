/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.cloudsecuritycompliance.v1.stub;

import static com.google.cloud.cloudsecuritycompliance.v1.DeploymentClient.ListCloudControlDeploymentsPagedResponse;
import static com.google.cloud.cloudsecuritycompliance.v1.DeploymentClient.ListFrameworkDeploymentsPagedResponse;
import static com.google.cloud.cloudsecuritycompliance.v1.DeploymentClient.ListLocationsPagedResponse;

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
import com.google.cloud.cloudsecuritycompliance.v1.CloudControlDeployment;
import com.google.cloud.cloudsecuritycompliance.v1.CreateFrameworkDeploymentRequest;
import com.google.cloud.cloudsecuritycompliance.v1.DeleteFrameworkDeploymentRequest;
import com.google.cloud.cloudsecuritycompliance.v1.FrameworkDeployment;
import com.google.cloud.cloudsecuritycompliance.v1.GetCloudControlDeploymentRequest;
import com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkDeploymentRequest;
import com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlDeploymentsRequest;
import com.google.cloud.cloudsecuritycompliance.v1.ListCloudControlDeploymentsResponse;
import com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkDeploymentsRequest;
import com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkDeploymentsResponse;
import com.google.cloud.cloudsecuritycompliance.v1.OperationMetadata;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * REST stub implementation for the Deployment service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonDeploymentStub extends DeploymentStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(FrameworkDeployment.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateFrameworkDeploymentRequest, Operation>
      createFrameworkDeploymentMethodDescriptor =
          ApiMethodDescriptor.<CreateFrameworkDeploymentRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.cloudsecuritycompliance.v1.Deployment/CreateFrameworkDeployment")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateFrameworkDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=organizations/*/locations/*}/frameworkDeployments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateFrameworkDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateFrameworkDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields,
                                "frameworkDeploymentId",
                                request.getFrameworkDeploymentId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "frameworkDeployment",
                                      request.getFrameworkDeployment(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateFrameworkDeploymentRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteFrameworkDeploymentRequest, Operation>
      deleteFrameworkDeploymentMethodDescriptor =
          ApiMethodDescriptor.<DeleteFrameworkDeploymentRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.cloudsecuritycompliance.v1.Deployment/DeleteFrameworkDeployment")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteFrameworkDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=organizations/*/locations/*/frameworkDeployments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteFrameworkDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteFrameworkDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "etag", request.getEtag());
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
                  (DeleteFrameworkDeploymentRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetFrameworkDeploymentRequest, FrameworkDeployment>
      getFrameworkDeploymentMethodDescriptor =
          ApiMethodDescriptor.<GetFrameworkDeploymentRequest, FrameworkDeployment>newBuilder()
              .setFullMethodName(
                  "google.cloud.cloudsecuritycompliance.v1.Deployment/GetFrameworkDeployment")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetFrameworkDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=organizations/*/locations/*/frameworkDeployments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetFrameworkDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetFrameworkDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FrameworkDeployment>newBuilder()
                      .setDefaultInstance(FrameworkDeployment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListFrameworkDeploymentsRequest, ListFrameworkDeploymentsResponse>
      listFrameworkDeploymentsMethodDescriptor =
          ApiMethodDescriptor
              .<ListFrameworkDeploymentsRequest, ListFrameworkDeploymentsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.cloudsecuritycompliance.v1.Deployment/ListFrameworkDeployments")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListFrameworkDeploymentsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=organizations/*/locations/*}/frameworkDeployments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListFrameworkDeploymentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListFrameworkDeploymentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListFrameworkDeploymentsResponse>newBuilder()
                      .setDefaultInstance(ListFrameworkDeploymentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetCloudControlDeploymentRequest, CloudControlDeployment>
      getCloudControlDeploymentMethodDescriptor =
          ApiMethodDescriptor.<GetCloudControlDeploymentRequest, CloudControlDeployment>newBuilder()
              .setFullMethodName(
                  "google.cloud.cloudsecuritycompliance.v1.Deployment/GetCloudControlDeployment")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCloudControlDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=organizations/*/locations/*/cloudControlDeployments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetCloudControlDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetCloudControlDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CloudControlDeployment>newBuilder()
                      .setDefaultInstance(CloudControlDeployment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListCloudControlDeploymentsRequest, ListCloudControlDeploymentsResponse>
      listCloudControlDeploymentsMethodDescriptor =
          ApiMethodDescriptor
              .<ListCloudControlDeploymentsRequest, ListCloudControlDeploymentsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.cloudsecuritycompliance.v1.Deployment/ListCloudControlDeployments")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCloudControlDeploymentsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=organizations/*/locations/*}/cloudControlDeployments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCloudControlDeploymentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCloudControlDeploymentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListCloudControlDeploymentsResponse>newBuilder()
                      .setDefaultInstance(ListCloudControlDeploymentsResponse.getDefaultInstance())
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
                          "/v1/{name=organizations/*}/locations",
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
                          "/v1/{name=organizations/*/locations/*}",
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

  private final UnaryCallable<CreateFrameworkDeploymentRequest, Operation>
      createFrameworkDeploymentCallable;
  private final OperationCallable<
          CreateFrameworkDeploymentRequest, FrameworkDeployment, OperationMetadata>
      createFrameworkDeploymentOperationCallable;
  private final UnaryCallable<DeleteFrameworkDeploymentRequest, Operation>
      deleteFrameworkDeploymentCallable;
  private final OperationCallable<DeleteFrameworkDeploymentRequest, Empty, OperationMetadata>
      deleteFrameworkDeploymentOperationCallable;
  private final UnaryCallable<GetFrameworkDeploymentRequest, FrameworkDeployment>
      getFrameworkDeploymentCallable;
  private final UnaryCallable<ListFrameworkDeploymentsRequest, ListFrameworkDeploymentsResponse>
      listFrameworkDeploymentsCallable;
  private final UnaryCallable<
          ListFrameworkDeploymentsRequest, ListFrameworkDeploymentsPagedResponse>
      listFrameworkDeploymentsPagedCallable;
  private final UnaryCallable<GetCloudControlDeploymentRequest, CloudControlDeployment>
      getCloudControlDeploymentCallable;
  private final UnaryCallable<
          ListCloudControlDeploymentsRequest, ListCloudControlDeploymentsResponse>
      listCloudControlDeploymentsCallable;
  private final UnaryCallable<
          ListCloudControlDeploymentsRequest, ListCloudControlDeploymentsPagedResponse>
      listCloudControlDeploymentsPagedCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonDeploymentStub create(DeploymentStubSettings settings)
      throws IOException {
    return new HttpJsonDeploymentStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonDeploymentStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonDeploymentStub(
        DeploymentStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonDeploymentStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonDeploymentStub(
        DeploymentStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonDeploymentStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonDeploymentStub(DeploymentStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonDeploymentCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonDeploymentStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonDeploymentStub(
      DeploymentStubSettings settings,
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
                    "google.longrunning.Operations.CancelOperation",
                    HttpRule.newBuilder()
                        .setPost("/v1/{name=organizations/*/locations/*/operations/*}:cancel")
                        .build())
                .put(
                    "google.longrunning.Operations.DeleteOperation",
                    HttpRule.newBuilder()
                        .setDelete("/v1/{name=organizations/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=organizations/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=organizations/*/locations/*}/operations")
                        .build())
                .build());

    HttpJsonCallSettings<CreateFrameworkDeploymentRequest, Operation>
        createFrameworkDeploymentTransportSettings =
            HttpJsonCallSettings.<CreateFrameworkDeploymentRequest, Operation>newBuilder()
                .setMethodDescriptor(createFrameworkDeploymentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteFrameworkDeploymentRequest, Operation>
        deleteFrameworkDeploymentTransportSettings =
            HttpJsonCallSettings.<DeleteFrameworkDeploymentRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteFrameworkDeploymentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetFrameworkDeploymentRequest, FrameworkDeployment>
        getFrameworkDeploymentTransportSettings =
            HttpJsonCallSettings.<GetFrameworkDeploymentRequest, FrameworkDeployment>newBuilder()
                .setMethodDescriptor(getFrameworkDeploymentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListFrameworkDeploymentsRequest, ListFrameworkDeploymentsResponse>
        listFrameworkDeploymentsTransportSettings =
            HttpJsonCallSettings
                .<ListFrameworkDeploymentsRequest, ListFrameworkDeploymentsResponse>newBuilder()
                .setMethodDescriptor(listFrameworkDeploymentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetCloudControlDeploymentRequest, CloudControlDeployment>
        getCloudControlDeploymentTransportSettings =
            HttpJsonCallSettings
                .<GetCloudControlDeploymentRequest, CloudControlDeployment>newBuilder()
                .setMethodDescriptor(getCloudControlDeploymentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListCloudControlDeploymentsRequest, ListCloudControlDeploymentsResponse>
        listCloudControlDeploymentsTransportSettings =
            HttpJsonCallSettings
                .<ListCloudControlDeploymentsRequest, ListCloudControlDeploymentsResponse>
                    newBuilder()
                .setMethodDescriptor(listCloudControlDeploymentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        HttpJsonCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.createFrameworkDeploymentCallable =
        callableFactory.createUnaryCallable(
            createFrameworkDeploymentTransportSettings,
            settings.createFrameworkDeploymentSettings(),
            clientContext);
    this.createFrameworkDeploymentOperationCallable =
        callableFactory.createOperationCallable(
            createFrameworkDeploymentTransportSettings,
            settings.createFrameworkDeploymentOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteFrameworkDeploymentCallable =
        callableFactory.createUnaryCallable(
            deleteFrameworkDeploymentTransportSettings,
            settings.deleteFrameworkDeploymentSettings(),
            clientContext);
    this.deleteFrameworkDeploymentOperationCallable =
        callableFactory.createOperationCallable(
            deleteFrameworkDeploymentTransportSettings,
            settings.deleteFrameworkDeploymentOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getFrameworkDeploymentCallable =
        callableFactory.createUnaryCallable(
            getFrameworkDeploymentTransportSettings,
            settings.getFrameworkDeploymentSettings(),
            clientContext);
    this.listFrameworkDeploymentsCallable =
        callableFactory.createUnaryCallable(
            listFrameworkDeploymentsTransportSettings,
            settings.listFrameworkDeploymentsSettings(),
            clientContext);
    this.listFrameworkDeploymentsPagedCallable =
        callableFactory.createPagedCallable(
            listFrameworkDeploymentsTransportSettings,
            settings.listFrameworkDeploymentsSettings(),
            clientContext);
    this.getCloudControlDeploymentCallable =
        callableFactory.createUnaryCallable(
            getCloudControlDeploymentTransportSettings,
            settings.getCloudControlDeploymentSettings(),
            clientContext);
    this.listCloudControlDeploymentsCallable =
        callableFactory.createUnaryCallable(
            listCloudControlDeploymentsTransportSettings,
            settings.listCloudControlDeploymentsSettings(),
            clientContext);
    this.listCloudControlDeploymentsPagedCallable =
        callableFactory.createPagedCallable(
            listCloudControlDeploymentsTransportSettings,
            settings.listCloudControlDeploymentsSettings(),
            clientContext);
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
    methodDescriptors.add(createFrameworkDeploymentMethodDescriptor);
    methodDescriptors.add(deleteFrameworkDeploymentMethodDescriptor);
    methodDescriptors.add(getFrameworkDeploymentMethodDescriptor);
    methodDescriptors.add(listFrameworkDeploymentsMethodDescriptor);
    methodDescriptors.add(getCloudControlDeploymentMethodDescriptor);
    methodDescriptors.add(listCloudControlDeploymentsMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<CreateFrameworkDeploymentRequest, Operation>
      createFrameworkDeploymentCallable() {
    return createFrameworkDeploymentCallable;
  }

  @Override
  public OperationCallable<CreateFrameworkDeploymentRequest, FrameworkDeployment, OperationMetadata>
      createFrameworkDeploymentOperationCallable() {
    return createFrameworkDeploymentOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteFrameworkDeploymentRequest, Operation>
      deleteFrameworkDeploymentCallable() {
    return deleteFrameworkDeploymentCallable;
  }

  @Override
  public OperationCallable<DeleteFrameworkDeploymentRequest, Empty, OperationMetadata>
      deleteFrameworkDeploymentOperationCallable() {
    return deleteFrameworkDeploymentOperationCallable;
  }

  @Override
  public UnaryCallable<GetFrameworkDeploymentRequest, FrameworkDeployment>
      getFrameworkDeploymentCallable() {
    return getFrameworkDeploymentCallable;
  }

  @Override
  public UnaryCallable<ListFrameworkDeploymentsRequest, ListFrameworkDeploymentsResponse>
      listFrameworkDeploymentsCallable() {
    return listFrameworkDeploymentsCallable;
  }

  @Override
  public UnaryCallable<ListFrameworkDeploymentsRequest, ListFrameworkDeploymentsPagedResponse>
      listFrameworkDeploymentsPagedCallable() {
    return listFrameworkDeploymentsPagedCallable;
  }

  @Override
  public UnaryCallable<GetCloudControlDeploymentRequest, CloudControlDeployment>
      getCloudControlDeploymentCallable() {
    return getCloudControlDeploymentCallable;
  }

  @Override
  public UnaryCallable<ListCloudControlDeploymentsRequest, ListCloudControlDeploymentsResponse>
      listCloudControlDeploymentsCallable() {
    return listCloudControlDeploymentsCallable;
  }

  @Override
  public UnaryCallable<ListCloudControlDeploymentsRequest, ListCloudControlDeploymentsPagedResponse>
      listCloudControlDeploymentsPagedCallable() {
    return listCloudControlDeploymentsPagedCallable;
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
