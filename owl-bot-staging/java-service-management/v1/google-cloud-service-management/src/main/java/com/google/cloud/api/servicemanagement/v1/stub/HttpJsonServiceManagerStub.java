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

package com.google.cloud.api.servicemanagement.v1.stub;

import static com.google.cloud.api.servicemanagement.v1.ServiceManagerClient.ListServiceConfigsPagedResponse;
import static com.google.cloud.api.servicemanagement.v1.ServiceManagerClient.ListServiceRolloutsPagedResponse;
import static com.google.cloud.api.servicemanagement.v1.ServiceManagerClient.ListServicesPagedResponse;

import com.google.api.Service;
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
import com.google.api.servicemanagement.v1.CreateServiceConfigRequest;
import com.google.api.servicemanagement.v1.CreateServiceRequest;
import com.google.api.servicemanagement.v1.CreateServiceRolloutRequest;
import com.google.api.servicemanagement.v1.DeleteServiceRequest;
import com.google.api.servicemanagement.v1.GenerateConfigReportRequest;
import com.google.api.servicemanagement.v1.GenerateConfigReportResponse;
import com.google.api.servicemanagement.v1.GetServiceConfigRequest;
import com.google.api.servicemanagement.v1.GetServiceRequest;
import com.google.api.servicemanagement.v1.GetServiceRolloutRequest;
import com.google.api.servicemanagement.v1.ListServiceConfigsRequest;
import com.google.api.servicemanagement.v1.ListServiceConfigsResponse;
import com.google.api.servicemanagement.v1.ListServiceRolloutsRequest;
import com.google.api.servicemanagement.v1.ListServiceRolloutsResponse;
import com.google.api.servicemanagement.v1.ListServicesRequest;
import com.google.api.servicemanagement.v1.ListServicesResponse;
import com.google.api.servicemanagement.v1.ManagedService;
import com.google.api.servicemanagement.v1.OperationMetadata;
import com.google.api.servicemanagement.v1.Rollout;
import com.google.api.servicemanagement.v1.SubmitConfigSourceRequest;
import com.google.api.servicemanagement.v1.SubmitConfigSourceResponse;
import com.google.api.servicemanagement.v1.UndeleteServiceRequest;
import com.google.api.servicemanagement.v1.UndeleteServiceResponse;
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
 * REST stub implementation for the ServiceManager service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonServiceManagerStub extends ServiceManagerStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(Rollout.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(UndeleteServiceResponse.getDescriptor())
          .add(SubmitConfigSourceResponse.getDescriptor())
          .add(ManagedService.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListServicesRequest, ListServicesResponse>
      listServicesMethodDescriptor =
          ApiMethodDescriptor.<ListServicesRequest, ListServicesResponse>newBuilder()
              .setFullMethodName("google.api.servicemanagement.v1.ServiceManager/ListServices")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListServicesRequest>newBuilder()
                      .setPath(
                          "/v1/services",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListServicesRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListServicesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "consumerId", request.getConsumerId());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(
                                fields, "producerProjectId", request.getProducerProjectId());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListServicesResponse>newBuilder()
                      .setDefaultInstance(ListServicesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetServiceRequest, ManagedService>
      getServiceMethodDescriptor =
          ApiMethodDescriptor.<GetServiceRequest, ManagedService>newBuilder()
              .setFullMethodName("google.api.servicemanagement.v1.ServiceManager/GetService")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetServiceRequest>newBuilder()
                      .setPath(
                          "/v1/services/{serviceName}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "serviceName", request.getServiceName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ManagedService>newBuilder()
                      .setDefaultInstance(ManagedService.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateServiceRequest, Operation>
      createServiceMethodDescriptor =
          ApiMethodDescriptor.<CreateServiceRequest, Operation>newBuilder()
              .setFullMethodName("google.api.servicemanagement.v1.ServiceManager/CreateService")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateServiceRequest>newBuilder()
                      .setPath(
                          "/v1/services",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("service", request.getService(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateServiceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteServiceRequest, Operation>
      deleteServiceMethodDescriptor =
          ApiMethodDescriptor.<DeleteServiceRequest, Operation>newBuilder()
              .setFullMethodName("google.api.servicemanagement.v1.ServiceManager/DeleteService")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteServiceRequest>newBuilder()
                      .setPath(
                          "/v1/services/{serviceName}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "serviceName", request.getServiceName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteServiceRequest> serializer =
                                ProtoRestSerializer.create();
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
                  (DeleteServiceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UndeleteServiceRequest, Operation>
      undeleteServiceMethodDescriptor =
          ApiMethodDescriptor.<UndeleteServiceRequest, Operation>newBuilder()
              .setFullMethodName("google.api.servicemanagement.v1.ServiceManager/UndeleteService")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UndeleteServiceRequest>newBuilder()
                      .setPath(
                          "/v1/services/{serviceName}:undelete",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UndeleteServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "serviceName", request.getServiceName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UndeleteServiceRequest> serializer =
                                ProtoRestSerializer.create();
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
                  (UndeleteServiceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListServiceConfigsRequest, ListServiceConfigsResponse>
      listServiceConfigsMethodDescriptor =
          ApiMethodDescriptor.<ListServiceConfigsRequest, ListServiceConfigsResponse>newBuilder()
              .setFullMethodName(
                  "google.api.servicemanagement.v1.ServiceManager/ListServiceConfigs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListServiceConfigsRequest>newBuilder()
                      .setPath(
                          "/v1/services/{serviceName}/configs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListServiceConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "serviceName", request.getServiceName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListServiceConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListServiceConfigsResponse>newBuilder()
                      .setDefaultInstance(ListServiceConfigsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetServiceConfigRequest, Service>
      getServiceConfigMethodDescriptor =
          ApiMethodDescriptor.<GetServiceConfigRequest, Service>newBuilder()
              .setFullMethodName("google.api.servicemanagement.v1.ServiceManager/GetServiceConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetServiceConfigRequest>newBuilder()
                      .setPath(
                          "/v1/services/{serviceName}/configs/{configId}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetServiceConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "configId", request.getConfigId());
                            serializer.putPathParam(
                                fields, "serviceName", request.getServiceName());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/services/{serviceName}/config")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetServiceConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "view", request.getView());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Service>newBuilder()
                      .setDefaultInstance(Service.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateServiceConfigRequest, Service>
      createServiceConfigMethodDescriptor =
          ApiMethodDescriptor.<CreateServiceConfigRequest, Service>newBuilder()
              .setFullMethodName(
                  "google.api.servicemanagement.v1.ServiceManager/CreateServiceConfig")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateServiceConfigRequest>newBuilder()
                      .setPath(
                          "/v1/services/{serviceName}/configs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateServiceConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "serviceName", request.getServiceName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateServiceConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("serviceConfig", request.getServiceConfig(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Service>newBuilder()
                      .setDefaultInstance(Service.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SubmitConfigSourceRequest, Operation>
      submitConfigSourceMethodDescriptor =
          ApiMethodDescriptor.<SubmitConfigSourceRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.api.servicemanagement.v1.ServiceManager/SubmitConfigSource")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SubmitConfigSourceRequest>newBuilder()
                      .setPath(
                          "/v1/services/{serviceName}/configs:submit",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SubmitConfigSourceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "serviceName", request.getServiceName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SubmitConfigSourceRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*", request.toBuilder().clearServiceName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (SubmitConfigSourceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListServiceRolloutsRequest, ListServiceRolloutsResponse>
      listServiceRolloutsMethodDescriptor =
          ApiMethodDescriptor.<ListServiceRolloutsRequest, ListServiceRolloutsResponse>newBuilder()
              .setFullMethodName(
                  "google.api.servicemanagement.v1.ServiceManager/ListServiceRollouts")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListServiceRolloutsRequest>newBuilder()
                      .setPath(
                          "/v1/services/{serviceName}/rollouts",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListServiceRolloutsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "serviceName", request.getServiceName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListServiceRolloutsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListServiceRolloutsResponse>newBuilder()
                      .setDefaultInstance(ListServiceRolloutsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetServiceRolloutRequest, Rollout>
      getServiceRolloutMethodDescriptor =
          ApiMethodDescriptor.<GetServiceRolloutRequest, Rollout>newBuilder()
              .setFullMethodName("google.api.servicemanagement.v1.ServiceManager/GetServiceRollout")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetServiceRolloutRequest>newBuilder()
                      .setPath(
                          "/v1/services/{serviceName}/rollouts/{rolloutId}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetServiceRolloutRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "rolloutId", request.getRolloutId());
                            serializer.putPathParam(
                                fields, "serviceName", request.getServiceName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetServiceRolloutRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Rollout>newBuilder()
                      .setDefaultInstance(Rollout.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateServiceRolloutRequest, Operation>
      createServiceRolloutMethodDescriptor =
          ApiMethodDescriptor.<CreateServiceRolloutRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.api.servicemanagement.v1.ServiceManager/CreateServiceRollout")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateServiceRolloutRequest>newBuilder()
                      .setPath(
                          "/v1/services/{serviceName}/rollouts",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateServiceRolloutRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "serviceName", request.getServiceName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateServiceRolloutRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("rollout", request.getRollout(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateServiceRolloutRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          GenerateConfigReportRequest, GenerateConfigReportResponse>
      generateConfigReportMethodDescriptor =
          ApiMethodDescriptor
              .<GenerateConfigReportRequest, GenerateConfigReportResponse>newBuilder()
              .setFullMethodName(
                  "google.api.servicemanagement.v1.ServiceManager/GenerateConfigReport")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GenerateConfigReportRequest>newBuilder()
                      .setPath(
                          "/v1/services:generateConfigReport",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateConfigReportRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateConfigReportRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GenerateConfigReportResponse>newBuilder()
                      .setDefaultInstance(GenerateConfigReportResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListServicesRequest, ListServicesResponse> listServicesCallable;
  private final UnaryCallable<ListServicesRequest, ListServicesPagedResponse>
      listServicesPagedCallable;
  private final UnaryCallable<GetServiceRequest, ManagedService> getServiceCallable;
  private final UnaryCallable<CreateServiceRequest, Operation> createServiceCallable;
  private final OperationCallable<CreateServiceRequest, ManagedService, OperationMetadata>
      createServiceOperationCallable;
  private final UnaryCallable<DeleteServiceRequest, Operation> deleteServiceCallable;
  private final OperationCallable<DeleteServiceRequest, Empty, OperationMetadata>
      deleteServiceOperationCallable;
  private final UnaryCallable<UndeleteServiceRequest, Operation> undeleteServiceCallable;
  private final OperationCallable<
          UndeleteServiceRequest, UndeleteServiceResponse, OperationMetadata>
      undeleteServiceOperationCallable;
  private final UnaryCallable<ListServiceConfigsRequest, ListServiceConfigsResponse>
      listServiceConfigsCallable;
  private final UnaryCallable<ListServiceConfigsRequest, ListServiceConfigsPagedResponse>
      listServiceConfigsPagedCallable;
  private final UnaryCallable<GetServiceConfigRequest, Service> getServiceConfigCallable;
  private final UnaryCallable<CreateServiceConfigRequest, Service> createServiceConfigCallable;
  private final UnaryCallable<SubmitConfigSourceRequest, Operation> submitConfigSourceCallable;
  private final OperationCallable<
          SubmitConfigSourceRequest, SubmitConfigSourceResponse, OperationMetadata>
      submitConfigSourceOperationCallable;
  private final UnaryCallable<ListServiceRolloutsRequest, ListServiceRolloutsResponse>
      listServiceRolloutsCallable;
  private final UnaryCallable<ListServiceRolloutsRequest, ListServiceRolloutsPagedResponse>
      listServiceRolloutsPagedCallable;
  private final UnaryCallable<GetServiceRolloutRequest, Rollout> getServiceRolloutCallable;
  private final UnaryCallable<CreateServiceRolloutRequest, Operation> createServiceRolloutCallable;
  private final OperationCallable<CreateServiceRolloutRequest, Rollout, OperationMetadata>
      createServiceRolloutOperationCallable;
  private final UnaryCallable<GenerateConfigReportRequest, GenerateConfigReportResponse>
      generateConfigReportCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonServiceManagerStub create(ServiceManagerStubSettings settings)
      throws IOException {
    return new HttpJsonServiceManagerStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonServiceManagerStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonServiceManagerStub(
        ServiceManagerStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonServiceManagerStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonServiceManagerStub(
        ServiceManagerStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonServiceManagerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonServiceManagerStub(
      ServiceManagerStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonServiceManagerCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonServiceManagerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonServiceManagerStub(
      ServiceManagerStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<ListServicesRequest, ListServicesResponse> listServicesTransportSettings =
        HttpJsonCallSettings.<ListServicesRequest, ListServicesResponse>newBuilder()
            .setMethodDescriptor(listServicesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetServiceRequest, ManagedService> getServiceTransportSettings =
        HttpJsonCallSettings.<GetServiceRequest, ManagedService>newBuilder()
            .setMethodDescriptor(getServiceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateServiceRequest, Operation> createServiceTransportSettings =
        HttpJsonCallSettings.<CreateServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(createServiceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteServiceRequest, Operation> deleteServiceTransportSettings =
        HttpJsonCallSettings.<DeleteServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteServiceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UndeleteServiceRequest, Operation> undeleteServiceTransportSettings =
        HttpJsonCallSettings.<UndeleteServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(undeleteServiceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListServiceConfigsRequest, ListServiceConfigsResponse>
        listServiceConfigsTransportSettings =
            HttpJsonCallSettings.<ListServiceConfigsRequest, ListServiceConfigsResponse>newBuilder()
                .setMethodDescriptor(listServiceConfigsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetServiceConfigRequest, Service> getServiceConfigTransportSettings =
        HttpJsonCallSettings.<GetServiceConfigRequest, Service>newBuilder()
            .setMethodDescriptor(getServiceConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateServiceConfigRequest, Service> createServiceConfigTransportSettings =
        HttpJsonCallSettings.<CreateServiceConfigRequest, Service>newBuilder()
            .setMethodDescriptor(createServiceConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SubmitConfigSourceRequest, Operation> submitConfigSourceTransportSettings =
        HttpJsonCallSettings.<SubmitConfigSourceRequest, Operation>newBuilder()
            .setMethodDescriptor(submitConfigSourceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListServiceRolloutsRequest, ListServiceRolloutsResponse>
        listServiceRolloutsTransportSettings =
            HttpJsonCallSettings
                .<ListServiceRolloutsRequest, ListServiceRolloutsResponse>newBuilder()
                .setMethodDescriptor(listServiceRolloutsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetServiceRolloutRequest, Rollout> getServiceRolloutTransportSettings =
        HttpJsonCallSettings.<GetServiceRolloutRequest, Rollout>newBuilder()
            .setMethodDescriptor(getServiceRolloutMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateServiceRolloutRequest, Operation>
        createServiceRolloutTransportSettings =
            HttpJsonCallSettings.<CreateServiceRolloutRequest, Operation>newBuilder()
                .setMethodDescriptor(createServiceRolloutMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GenerateConfigReportRequest, GenerateConfigReportResponse>
        generateConfigReportTransportSettings =
            HttpJsonCallSettings
                .<GenerateConfigReportRequest, GenerateConfigReportResponse>newBuilder()
                .setMethodDescriptor(generateConfigReportMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.listServicesCallable =
        callableFactory.createUnaryCallable(
            listServicesTransportSettings, settings.listServicesSettings(), clientContext);
    this.listServicesPagedCallable =
        callableFactory.createPagedCallable(
            listServicesTransportSettings, settings.listServicesSettings(), clientContext);
    this.getServiceCallable =
        callableFactory.createUnaryCallable(
            getServiceTransportSettings, settings.getServiceSettings(), clientContext);
    this.createServiceCallable =
        callableFactory.createUnaryCallable(
            createServiceTransportSettings, settings.createServiceSettings(), clientContext);
    this.createServiceOperationCallable =
        callableFactory.createOperationCallable(
            createServiceTransportSettings,
            settings.createServiceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteServiceCallable =
        callableFactory.createUnaryCallable(
            deleteServiceTransportSettings, settings.deleteServiceSettings(), clientContext);
    this.deleteServiceOperationCallable =
        callableFactory.createOperationCallable(
            deleteServiceTransportSettings,
            settings.deleteServiceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.undeleteServiceCallable =
        callableFactory.createUnaryCallable(
            undeleteServiceTransportSettings, settings.undeleteServiceSettings(), clientContext);
    this.undeleteServiceOperationCallable =
        callableFactory.createOperationCallable(
            undeleteServiceTransportSettings,
            settings.undeleteServiceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listServiceConfigsCallable =
        callableFactory.createUnaryCallable(
            listServiceConfigsTransportSettings,
            settings.listServiceConfigsSettings(),
            clientContext);
    this.listServiceConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listServiceConfigsTransportSettings,
            settings.listServiceConfigsSettings(),
            clientContext);
    this.getServiceConfigCallable =
        callableFactory.createUnaryCallable(
            getServiceConfigTransportSettings, settings.getServiceConfigSettings(), clientContext);
    this.createServiceConfigCallable =
        callableFactory.createUnaryCallable(
            createServiceConfigTransportSettings,
            settings.createServiceConfigSettings(),
            clientContext);
    this.submitConfigSourceCallable =
        callableFactory.createUnaryCallable(
            submitConfigSourceTransportSettings,
            settings.submitConfigSourceSettings(),
            clientContext);
    this.submitConfigSourceOperationCallable =
        callableFactory.createOperationCallable(
            submitConfigSourceTransportSettings,
            settings.submitConfigSourceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listServiceRolloutsCallable =
        callableFactory.createUnaryCallable(
            listServiceRolloutsTransportSettings,
            settings.listServiceRolloutsSettings(),
            clientContext);
    this.listServiceRolloutsPagedCallable =
        callableFactory.createPagedCallable(
            listServiceRolloutsTransportSettings,
            settings.listServiceRolloutsSettings(),
            clientContext);
    this.getServiceRolloutCallable =
        callableFactory.createUnaryCallable(
            getServiceRolloutTransportSettings,
            settings.getServiceRolloutSettings(),
            clientContext);
    this.createServiceRolloutCallable =
        callableFactory.createUnaryCallable(
            createServiceRolloutTransportSettings,
            settings.createServiceRolloutSettings(),
            clientContext);
    this.createServiceRolloutOperationCallable =
        callableFactory.createOperationCallable(
            createServiceRolloutTransportSettings,
            settings.createServiceRolloutOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.generateConfigReportCallable =
        callableFactory.createUnaryCallable(
            generateConfigReportTransportSettings,
            settings.generateConfigReportSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listServicesMethodDescriptor);
    methodDescriptors.add(getServiceMethodDescriptor);
    methodDescriptors.add(createServiceMethodDescriptor);
    methodDescriptors.add(deleteServiceMethodDescriptor);
    methodDescriptors.add(undeleteServiceMethodDescriptor);
    methodDescriptors.add(listServiceConfigsMethodDescriptor);
    methodDescriptors.add(getServiceConfigMethodDescriptor);
    methodDescriptors.add(createServiceConfigMethodDescriptor);
    methodDescriptors.add(submitConfigSourceMethodDescriptor);
    methodDescriptors.add(listServiceRolloutsMethodDescriptor);
    methodDescriptors.add(getServiceRolloutMethodDescriptor);
    methodDescriptors.add(createServiceRolloutMethodDescriptor);
    methodDescriptors.add(generateConfigReportMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ListServicesRequest, ListServicesResponse> listServicesCallable() {
    return listServicesCallable;
  }

  @Override
  public UnaryCallable<ListServicesRequest, ListServicesPagedResponse> listServicesPagedCallable() {
    return listServicesPagedCallable;
  }

  @Override
  public UnaryCallable<GetServiceRequest, ManagedService> getServiceCallable() {
    return getServiceCallable;
  }

  @Override
  public UnaryCallable<CreateServiceRequest, Operation> createServiceCallable() {
    return createServiceCallable;
  }

  @Override
  public OperationCallable<CreateServiceRequest, ManagedService, OperationMetadata>
      createServiceOperationCallable() {
    return createServiceOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteServiceRequest, Operation> deleteServiceCallable() {
    return deleteServiceCallable;
  }

  @Override
  public OperationCallable<DeleteServiceRequest, Empty, OperationMetadata>
      deleteServiceOperationCallable() {
    return deleteServiceOperationCallable;
  }

  @Override
  public UnaryCallable<UndeleteServiceRequest, Operation> undeleteServiceCallable() {
    return undeleteServiceCallable;
  }

  @Override
  public OperationCallable<UndeleteServiceRequest, UndeleteServiceResponse, OperationMetadata>
      undeleteServiceOperationCallable() {
    return undeleteServiceOperationCallable;
  }

  @Override
  public UnaryCallable<ListServiceConfigsRequest, ListServiceConfigsResponse>
      listServiceConfigsCallable() {
    return listServiceConfigsCallable;
  }

  @Override
  public UnaryCallable<ListServiceConfigsRequest, ListServiceConfigsPagedResponse>
      listServiceConfigsPagedCallable() {
    return listServiceConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<GetServiceConfigRequest, Service> getServiceConfigCallable() {
    return getServiceConfigCallable;
  }

  @Override
  public UnaryCallable<CreateServiceConfigRequest, Service> createServiceConfigCallable() {
    return createServiceConfigCallable;
  }

  @Override
  public UnaryCallable<SubmitConfigSourceRequest, Operation> submitConfigSourceCallable() {
    return submitConfigSourceCallable;
  }

  @Override
  public OperationCallable<SubmitConfigSourceRequest, SubmitConfigSourceResponse, OperationMetadata>
      submitConfigSourceOperationCallable() {
    return submitConfigSourceOperationCallable;
  }

  @Override
  public UnaryCallable<ListServiceRolloutsRequest, ListServiceRolloutsResponse>
      listServiceRolloutsCallable() {
    return listServiceRolloutsCallable;
  }

  @Override
  public UnaryCallable<ListServiceRolloutsRequest, ListServiceRolloutsPagedResponse>
      listServiceRolloutsPagedCallable() {
    return listServiceRolloutsPagedCallable;
  }

  @Override
  public UnaryCallable<GetServiceRolloutRequest, Rollout> getServiceRolloutCallable() {
    return getServiceRolloutCallable;
  }

  @Override
  public UnaryCallable<CreateServiceRolloutRequest, Operation> createServiceRolloutCallable() {
    return createServiceRolloutCallable;
  }

  @Override
  public OperationCallable<CreateServiceRolloutRequest, Rollout, OperationMetadata>
      createServiceRolloutOperationCallable() {
    return createServiceRolloutOperationCallable;
  }

  @Override
  public UnaryCallable<GenerateConfigReportRequest, GenerateConfigReportResponse>
      generateConfigReportCallable() {
    return generateConfigReportCallable;
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
