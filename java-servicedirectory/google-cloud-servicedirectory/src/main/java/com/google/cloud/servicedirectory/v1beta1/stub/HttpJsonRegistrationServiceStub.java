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

package com.google.cloud.servicedirectory.v1beta1.stub;

import static com.google.cloud.servicedirectory.v1beta1.RegistrationServiceClient.ListEndpointsPagedResponse;
import static com.google.cloud.servicedirectory.v1beta1.RegistrationServiceClient.ListNamespacesPagedResponse;
import static com.google.cloud.servicedirectory.v1beta1.RegistrationServiceClient.ListServicesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.servicedirectory.v1beta1.CreateEndpointRequest;
import com.google.cloud.servicedirectory.v1beta1.CreateNamespaceRequest;
import com.google.cloud.servicedirectory.v1beta1.CreateServiceRequest;
import com.google.cloud.servicedirectory.v1beta1.DeleteEndpointRequest;
import com.google.cloud.servicedirectory.v1beta1.DeleteNamespaceRequest;
import com.google.cloud.servicedirectory.v1beta1.DeleteServiceRequest;
import com.google.cloud.servicedirectory.v1beta1.Endpoint;
import com.google.cloud.servicedirectory.v1beta1.GetEndpointRequest;
import com.google.cloud.servicedirectory.v1beta1.GetNamespaceRequest;
import com.google.cloud.servicedirectory.v1beta1.GetServiceRequest;
import com.google.cloud.servicedirectory.v1beta1.ListEndpointsRequest;
import com.google.cloud.servicedirectory.v1beta1.ListEndpointsResponse;
import com.google.cloud.servicedirectory.v1beta1.ListNamespacesRequest;
import com.google.cloud.servicedirectory.v1beta1.ListNamespacesResponse;
import com.google.cloud.servicedirectory.v1beta1.ListServicesRequest;
import com.google.cloud.servicedirectory.v1beta1.ListServicesResponse;
import com.google.cloud.servicedirectory.v1beta1.Namespace;
import com.google.cloud.servicedirectory.v1beta1.Service;
import com.google.cloud.servicedirectory.v1beta1.UpdateEndpointRequest;
import com.google.cloud.servicedirectory.v1beta1.UpdateNamespaceRequest;
import com.google.cloud.servicedirectory.v1beta1.UpdateServiceRequest;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
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
 * REST stub implementation for the RegistrationService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonRegistrationServiceStub extends RegistrationServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateNamespaceRequest, Namespace>
      createNamespaceMethodDescriptor =
          ApiMethodDescriptor.<CreateNamespaceRequest, Namespace>newBuilder()
              .setFullMethodName(
                  "google.cloud.servicedirectory.v1beta1.RegistrationService/CreateNamespace")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateNamespaceRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*}/namespaces",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateNamespaceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateNamespaceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "namespaceId", request.getNamespaceId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("namespace", request.getNamespace(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Namespace>newBuilder()
                      .setDefaultInstance(Namespace.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListNamespacesRequest, ListNamespacesResponse>
      listNamespacesMethodDescriptor =
          ApiMethodDescriptor.<ListNamespacesRequest, ListNamespacesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.servicedirectory.v1beta1.RegistrationService/ListNamespaces")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListNamespacesRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*}/namespaces",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListNamespacesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListNamespacesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListNamespacesResponse>newBuilder()
                      .setDefaultInstance(ListNamespacesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetNamespaceRequest, Namespace>
      getNamespaceMethodDescriptor =
          ApiMethodDescriptor.<GetNamespaceRequest, Namespace>newBuilder()
              .setFullMethodName(
                  "google.cloud.servicedirectory.v1beta1.RegistrationService/GetNamespace")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetNamespaceRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/namespaces/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetNamespaceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetNamespaceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Namespace>newBuilder()
                      .setDefaultInstance(Namespace.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateNamespaceRequest, Namespace>
      updateNamespaceMethodDescriptor =
          ApiMethodDescriptor.<UpdateNamespaceRequest, Namespace>newBuilder()
              .setFullMethodName(
                  "google.cloud.servicedirectory.v1beta1.RegistrationService/UpdateNamespace")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateNamespaceRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{namespace.name=projects/*/locations/*/namespaces/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateNamespaceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "namespace.name", request.getNamespace().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateNamespaceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("namespace", request.getNamespace(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Namespace>newBuilder()
                      .setDefaultInstance(Namespace.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteNamespaceRequest, Empty>
      deleteNamespaceMethodDescriptor =
          ApiMethodDescriptor.<DeleteNamespaceRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.servicedirectory.v1beta1.RegistrationService/DeleteNamespace")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteNamespaceRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/namespaces/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteNamespaceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteNamespaceRequest> serializer =
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

  private static final ApiMethodDescriptor<CreateServiceRequest, Service>
      createServiceMethodDescriptor =
          ApiMethodDescriptor.<CreateServiceRequest, Service>newBuilder()
              .setFullMethodName(
                  "google.cloud.servicedirectory.v1beta1.RegistrationService/CreateService")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateServiceRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*/namespaces/*}/services",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "serviceId", request.getServiceId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("service", request.getService(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Service>newBuilder()
                      .setDefaultInstance(Service.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListServicesRequest, ListServicesResponse>
      listServicesMethodDescriptor =
          ApiMethodDescriptor.<ListServicesRequest, ListServicesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.servicedirectory.v1beta1.RegistrationService/ListServices")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListServicesRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*/namespaces/*}/services",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListServicesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListServicesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListServicesResponse>newBuilder()
                      .setDefaultInstance(ListServicesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetServiceRequest, Service> getServiceMethodDescriptor =
      ApiMethodDescriptor.<GetServiceRequest, Service>newBuilder()
          .setFullMethodName("google.cloud.servicedirectory.v1beta1.RegistrationService/GetService")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetServiceRequest>newBuilder()
                  .setPath(
                      "/v1beta1/{name=projects/*/locations/*/namespaces/*/services/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetServiceRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetServiceRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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

  private static final ApiMethodDescriptor<UpdateServiceRequest, Service>
      updateServiceMethodDescriptor =
          ApiMethodDescriptor.<UpdateServiceRequest, Service>newBuilder()
              .setFullMethodName(
                  "google.cloud.servicedirectory.v1beta1.RegistrationService/UpdateService")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateServiceRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{service.name=projects/*/locations/*/namespaces/*/services/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "service.name", request.getService().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("service", request.getService(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Service>newBuilder()
                      .setDefaultInstance(Service.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteServiceRequest, Empty>
      deleteServiceMethodDescriptor =
          ApiMethodDescriptor.<DeleteServiceRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.servicedirectory.v1beta1.RegistrationService/DeleteService")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteServiceRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/namespaces/*/services/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteServiceRequest> serializer =
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

  private static final ApiMethodDescriptor<CreateEndpointRequest, Endpoint>
      createEndpointMethodDescriptor =
          ApiMethodDescriptor.<CreateEndpointRequest, Endpoint>newBuilder()
              .setFullMethodName(
                  "google.cloud.servicedirectory.v1beta1.RegistrationService/CreateEndpoint")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateEndpointRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*/namespaces/*/services/*}/endpoints",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEndpointRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEndpointRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "endpointId", request.getEndpointId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("endpoint", request.getEndpoint(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Endpoint>newBuilder()
                      .setDefaultInstance(Endpoint.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListEndpointsRequest, ListEndpointsResponse>
      listEndpointsMethodDescriptor =
          ApiMethodDescriptor.<ListEndpointsRequest, ListEndpointsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.servicedirectory.v1beta1.RegistrationService/ListEndpoints")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListEndpointsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*/namespaces/*/services/*}/endpoints",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListEndpointsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListEndpointsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListEndpointsResponse>newBuilder()
                      .setDefaultInstance(ListEndpointsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetEndpointRequest, Endpoint>
      getEndpointMethodDescriptor =
          ApiMethodDescriptor.<GetEndpointRequest, Endpoint>newBuilder()
              .setFullMethodName(
                  "google.cloud.servicedirectory.v1beta1.RegistrationService/GetEndpoint")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetEndpointRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/namespaces/*/services/*/endpoints/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetEndpointRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetEndpointRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Endpoint>newBuilder()
                      .setDefaultInstance(Endpoint.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateEndpointRequest, Endpoint>
      updateEndpointMethodDescriptor =
          ApiMethodDescriptor.<UpdateEndpointRequest, Endpoint>newBuilder()
              .setFullMethodName(
                  "google.cloud.servicedirectory.v1beta1.RegistrationService/UpdateEndpoint")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateEndpointRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{endpoint.name=projects/*/locations/*/namespaces/*/services/*/endpoints/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateEndpointRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "endpoint.name", request.getEndpoint().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateEndpointRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("endpoint", request.getEndpoint(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Endpoint>newBuilder()
                      .setDefaultInstance(Endpoint.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteEndpointRequest, Empty>
      deleteEndpointMethodDescriptor =
          ApiMethodDescriptor.<DeleteEndpointRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.servicedirectory.v1beta1.RegistrationService/DeleteEndpoint")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteEndpointRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/namespaces/*/services/*/endpoints/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEndpointRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEndpointRequest> serializer =
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

  private static final ApiMethodDescriptor<GetIamPolicyRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName(
                  "google.cloud.servicedirectory.v1beta1.RegistrationService/GetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{resource=projects/*/locations/*/namespaces/*}:getIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta1/{resource=projects/*/locations/*/namespaces/*/services/*}:getIamPolicy")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetIamPolicyRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName(
                  "google.cloud.servicedirectory.v1beta1.RegistrationService/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{resource=projects/*/locations/*/namespaces/*}:setIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta1/{resource=projects/*/locations/*/namespaces/*/services/*}:setIamPolicy")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.servicedirectory.v1beta1.RegistrationService/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{resource=projects/*/locations/*/namespaces/*}:testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta1/{resource=projects/*/locations/*/namespaces/*/services/*}:testIamPermissions")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TestIamPermissionsResponse>newBuilder()
                      .setDefaultInstance(TestIamPermissionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateNamespaceRequest, Namespace> createNamespaceCallable;
  private final UnaryCallable<ListNamespacesRequest, ListNamespacesResponse> listNamespacesCallable;
  private final UnaryCallable<ListNamespacesRequest, ListNamespacesPagedResponse>
      listNamespacesPagedCallable;
  private final UnaryCallable<GetNamespaceRequest, Namespace> getNamespaceCallable;
  private final UnaryCallable<UpdateNamespaceRequest, Namespace> updateNamespaceCallable;
  private final UnaryCallable<DeleteNamespaceRequest, Empty> deleteNamespaceCallable;
  private final UnaryCallable<CreateServiceRequest, Service> createServiceCallable;
  private final UnaryCallable<ListServicesRequest, ListServicesResponse> listServicesCallable;
  private final UnaryCallable<ListServicesRequest, ListServicesPagedResponse>
      listServicesPagedCallable;
  private final UnaryCallable<GetServiceRequest, Service> getServiceCallable;
  private final UnaryCallable<UpdateServiceRequest, Service> updateServiceCallable;
  private final UnaryCallable<DeleteServiceRequest, Empty> deleteServiceCallable;
  private final UnaryCallable<CreateEndpointRequest, Endpoint> createEndpointCallable;
  private final UnaryCallable<ListEndpointsRequest, ListEndpointsResponse> listEndpointsCallable;
  private final UnaryCallable<ListEndpointsRequest, ListEndpointsPagedResponse>
      listEndpointsPagedCallable;
  private final UnaryCallable<GetEndpointRequest, Endpoint> getEndpointCallable;
  private final UnaryCallable<UpdateEndpointRequest, Endpoint> updateEndpointCallable;
  private final UnaryCallable<DeleteEndpointRequest, Empty> deleteEndpointCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRegistrationServiceStub create(
      RegistrationServiceStubSettings settings) throws IOException {
    return new HttpJsonRegistrationServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRegistrationServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRegistrationServiceStub(
        RegistrationServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonRegistrationServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRegistrationServiceStub(
        RegistrationServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRegistrationServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegistrationServiceStub(
      RegistrationServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonRegistrationServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRegistrationServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegistrationServiceStub(
      RegistrationServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateNamespaceRequest, Namespace> createNamespaceTransportSettings =
        HttpJsonCallSettings.<CreateNamespaceRequest, Namespace>newBuilder()
            .setMethodDescriptor(createNamespaceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListNamespacesRequest, ListNamespacesResponse>
        listNamespacesTransportSettings =
            HttpJsonCallSettings.<ListNamespacesRequest, ListNamespacesResponse>newBuilder()
                .setMethodDescriptor(listNamespacesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetNamespaceRequest, Namespace> getNamespaceTransportSettings =
        HttpJsonCallSettings.<GetNamespaceRequest, Namespace>newBuilder()
            .setMethodDescriptor(getNamespaceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateNamespaceRequest, Namespace> updateNamespaceTransportSettings =
        HttpJsonCallSettings.<UpdateNamespaceRequest, Namespace>newBuilder()
            .setMethodDescriptor(updateNamespaceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteNamespaceRequest, Empty> deleteNamespaceTransportSettings =
        HttpJsonCallSettings.<DeleteNamespaceRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteNamespaceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateServiceRequest, Service> createServiceTransportSettings =
        HttpJsonCallSettings.<CreateServiceRequest, Service>newBuilder()
            .setMethodDescriptor(createServiceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListServicesRequest, ListServicesResponse> listServicesTransportSettings =
        HttpJsonCallSettings.<ListServicesRequest, ListServicesResponse>newBuilder()
            .setMethodDescriptor(listServicesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetServiceRequest, Service> getServiceTransportSettings =
        HttpJsonCallSettings.<GetServiceRequest, Service>newBuilder()
            .setMethodDescriptor(getServiceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateServiceRequest, Service> updateServiceTransportSettings =
        HttpJsonCallSettings.<UpdateServiceRequest, Service>newBuilder()
            .setMethodDescriptor(updateServiceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteServiceRequest, Empty> deleteServiceTransportSettings =
        HttpJsonCallSettings.<DeleteServiceRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteServiceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateEndpointRequest, Endpoint> createEndpointTransportSettings =
        HttpJsonCallSettings.<CreateEndpointRequest, Endpoint>newBuilder()
            .setMethodDescriptor(createEndpointMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListEndpointsRequest, ListEndpointsResponse>
        listEndpointsTransportSettings =
            HttpJsonCallSettings.<ListEndpointsRequest, ListEndpointsResponse>newBuilder()
                .setMethodDescriptor(listEndpointsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetEndpointRequest, Endpoint> getEndpointTransportSettings =
        HttpJsonCallSettings.<GetEndpointRequest, Endpoint>newBuilder()
            .setMethodDescriptor(getEndpointMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateEndpointRequest, Endpoint> updateEndpointTransportSettings =
        HttpJsonCallSettings.<UpdateEndpointRequest, Endpoint>newBuilder()
            .setMethodDescriptor(updateEndpointMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteEndpointRequest, Empty> deleteEndpointTransportSettings =
        HttpJsonCallSettings.<DeleteEndpointRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteEndpointMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.createNamespaceCallable =
        callableFactory.createUnaryCallable(
            createNamespaceTransportSettings, settings.createNamespaceSettings(), clientContext);
    this.listNamespacesCallable =
        callableFactory.createUnaryCallable(
            listNamespacesTransportSettings, settings.listNamespacesSettings(), clientContext);
    this.listNamespacesPagedCallable =
        callableFactory.createPagedCallable(
            listNamespacesTransportSettings, settings.listNamespacesSettings(), clientContext);
    this.getNamespaceCallable =
        callableFactory.createUnaryCallable(
            getNamespaceTransportSettings, settings.getNamespaceSettings(), clientContext);
    this.updateNamespaceCallable =
        callableFactory.createUnaryCallable(
            updateNamespaceTransportSettings, settings.updateNamespaceSettings(), clientContext);
    this.deleteNamespaceCallable =
        callableFactory.createUnaryCallable(
            deleteNamespaceTransportSettings, settings.deleteNamespaceSettings(), clientContext);
    this.createServiceCallable =
        callableFactory.createUnaryCallable(
            createServiceTransportSettings, settings.createServiceSettings(), clientContext);
    this.listServicesCallable =
        callableFactory.createUnaryCallable(
            listServicesTransportSettings, settings.listServicesSettings(), clientContext);
    this.listServicesPagedCallable =
        callableFactory.createPagedCallable(
            listServicesTransportSettings, settings.listServicesSettings(), clientContext);
    this.getServiceCallable =
        callableFactory.createUnaryCallable(
            getServiceTransportSettings, settings.getServiceSettings(), clientContext);
    this.updateServiceCallable =
        callableFactory.createUnaryCallable(
            updateServiceTransportSettings, settings.updateServiceSettings(), clientContext);
    this.deleteServiceCallable =
        callableFactory.createUnaryCallable(
            deleteServiceTransportSettings, settings.deleteServiceSettings(), clientContext);
    this.createEndpointCallable =
        callableFactory.createUnaryCallable(
            createEndpointTransportSettings, settings.createEndpointSettings(), clientContext);
    this.listEndpointsCallable =
        callableFactory.createUnaryCallable(
            listEndpointsTransportSettings, settings.listEndpointsSettings(), clientContext);
    this.listEndpointsPagedCallable =
        callableFactory.createPagedCallable(
            listEndpointsTransportSettings, settings.listEndpointsSettings(), clientContext);
    this.getEndpointCallable =
        callableFactory.createUnaryCallable(
            getEndpointTransportSettings, settings.getEndpointSettings(), clientContext);
    this.updateEndpointCallable =
        callableFactory.createUnaryCallable(
            updateEndpointTransportSettings, settings.updateEndpointSettings(), clientContext);
    this.deleteEndpointCallable =
        callableFactory.createUnaryCallable(
            deleteEndpointTransportSettings, settings.deleteEndpointSettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createNamespaceMethodDescriptor);
    methodDescriptors.add(listNamespacesMethodDescriptor);
    methodDescriptors.add(getNamespaceMethodDescriptor);
    methodDescriptors.add(updateNamespaceMethodDescriptor);
    methodDescriptors.add(deleteNamespaceMethodDescriptor);
    methodDescriptors.add(createServiceMethodDescriptor);
    methodDescriptors.add(listServicesMethodDescriptor);
    methodDescriptors.add(getServiceMethodDescriptor);
    methodDescriptors.add(updateServiceMethodDescriptor);
    methodDescriptors.add(deleteServiceMethodDescriptor);
    methodDescriptors.add(createEndpointMethodDescriptor);
    methodDescriptors.add(listEndpointsMethodDescriptor);
    methodDescriptors.add(getEndpointMethodDescriptor);
    methodDescriptors.add(updateEndpointMethodDescriptor);
    methodDescriptors.add(deleteEndpointMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateNamespaceRequest, Namespace> createNamespaceCallable() {
    return createNamespaceCallable;
  }

  @Override
  public UnaryCallable<ListNamespacesRequest, ListNamespacesResponse> listNamespacesCallable() {
    return listNamespacesCallable;
  }

  @Override
  public UnaryCallable<ListNamespacesRequest, ListNamespacesPagedResponse>
      listNamespacesPagedCallable() {
    return listNamespacesPagedCallable;
  }

  @Override
  public UnaryCallable<GetNamespaceRequest, Namespace> getNamespaceCallable() {
    return getNamespaceCallable;
  }

  @Override
  public UnaryCallable<UpdateNamespaceRequest, Namespace> updateNamespaceCallable() {
    return updateNamespaceCallable;
  }

  @Override
  public UnaryCallable<DeleteNamespaceRequest, Empty> deleteNamespaceCallable() {
    return deleteNamespaceCallable;
  }

  @Override
  public UnaryCallable<CreateServiceRequest, Service> createServiceCallable() {
    return createServiceCallable;
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
  public UnaryCallable<GetServiceRequest, Service> getServiceCallable() {
    return getServiceCallable;
  }

  @Override
  public UnaryCallable<UpdateServiceRequest, Service> updateServiceCallable() {
    return updateServiceCallable;
  }

  @Override
  public UnaryCallable<DeleteServiceRequest, Empty> deleteServiceCallable() {
    return deleteServiceCallable;
  }

  @Override
  public UnaryCallable<CreateEndpointRequest, Endpoint> createEndpointCallable() {
    return createEndpointCallable;
  }

  @Override
  public UnaryCallable<ListEndpointsRequest, ListEndpointsResponse> listEndpointsCallable() {
    return listEndpointsCallable;
  }

  @Override
  public UnaryCallable<ListEndpointsRequest, ListEndpointsPagedResponse>
      listEndpointsPagedCallable() {
    return listEndpointsPagedCallable;
  }

  @Override
  public UnaryCallable<GetEndpointRequest, Endpoint> getEndpointCallable() {
    return getEndpointCallable;
  }

  @Override
  public UnaryCallable<UpdateEndpointRequest, Endpoint> updateEndpointCallable() {
    return updateEndpointCallable;
  }

  @Override
  public UnaryCallable<DeleteEndpointRequest, Empty> deleteEndpointCallable() {
    return deleteEndpointCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
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
