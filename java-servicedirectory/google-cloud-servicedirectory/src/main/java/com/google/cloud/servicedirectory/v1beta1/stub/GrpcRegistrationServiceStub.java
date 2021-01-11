/*
 * Copyright 2020 Google LLC
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
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
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
import com.google.common.collect.ImmutableMap;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
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
 * gRPC stub implementation for the RegistrationService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcRegistrationServiceStub extends RegistrationServiceStub {
  private static final MethodDescriptor<CreateNamespaceRequest, Namespace>
      createNamespaceMethodDescriptor =
          MethodDescriptor.<CreateNamespaceRequest, Namespace>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.servicedirectory.v1beta1.RegistrationService/CreateNamespace")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateNamespaceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Namespace.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListNamespacesRequest, ListNamespacesResponse>
      listNamespacesMethodDescriptor =
          MethodDescriptor.<ListNamespacesRequest, ListNamespacesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.servicedirectory.v1beta1.RegistrationService/ListNamespaces")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListNamespacesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListNamespacesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetNamespaceRequest, Namespace>
      getNamespaceMethodDescriptor =
          MethodDescriptor.<GetNamespaceRequest, Namespace>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.servicedirectory.v1beta1.RegistrationService/GetNamespace")
              .setRequestMarshaller(ProtoUtils.marshaller(GetNamespaceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Namespace.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateNamespaceRequest, Namespace>
      updateNamespaceMethodDescriptor =
          MethodDescriptor.<UpdateNamespaceRequest, Namespace>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.servicedirectory.v1beta1.RegistrationService/UpdateNamespace")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateNamespaceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Namespace.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteNamespaceRequest, Empty>
      deleteNamespaceMethodDescriptor =
          MethodDescriptor.<DeleteNamespaceRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.servicedirectory.v1beta1.RegistrationService/DeleteNamespace")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteNamespaceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateServiceRequest, Service>
      createServiceMethodDescriptor =
          MethodDescriptor.<CreateServiceRequest, Service>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.servicedirectory.v1beta1.RegistrationService/CreateService")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Service.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListServicesRequest, ListServicesResponse>
      listServicesMethodDescriptor =
          MethodDescriptor.<ListServicesRequest, ListServicesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.servicedirectory.v1beta1.RegistrationService/ListServices")
              .setRequestMarshaller(ProtoUtils.marshaller(ListServicesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListServicesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetServiceRequest, Service> getServiceMethodDescriptor =
      MethodDescriptor.<GetServiceRequest, Service>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.servicedirectory.v1beta1.RegistrationService/GetService")
          .setRequestMarshaller(ProtoUtils.marshaller(GetServiceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Service.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateServiceRequest, Service>
      updateServiceMethodDescriptor =
          MethodDescriptor.<UpdateServiceRequest, Service>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.servicedirectory.v1beta1.RegistrationService/UpdateService")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Service.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteServiceRequest, Empty> deleteServiceMethodDescriptor =
      MethodDescriptor.<DeleteServiceRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.servicedirectory.v1beta1.RegistrationService/DeleteService")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteServiceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateEndpointRequest, Endpoint>
      createEndpointMethodDescriptor =
          MethodDescriptor.<CreateEndpointRequest, Endpoint>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.servicedirectory.v1beta1.RegistrationService/CreateEndpoint")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateEndpointRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Endpoint.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListEndpointsRequest, ListEndpointsResponse>
      listEndpointsMethodDescriptor =
          MethodDescriptor.<ListEndpointsRequest, ListEndpointsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.servicedirectory.v1beta1.RegistrationService/ListEndpoints")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListEndpointsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListEndpointsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetEndpointRequest, Endpoint> getEndpointMethodDescriptor =
      MethodDescriptor.<GetEndpointRequest, Endpoint>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.servicedirectory.v1beta1.RegistrationService/GetEndpoint")
          .setRequestMarshaller(ProtoUtils.marshaller(GetEndpointRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Endpoint.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateEndpointRequest, Endpoint>
      updateEndpointMethodDescriptor =
          MethodDescriptor.<UpdateEndpointRequest, Endpoint>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.servicedirectory.v1beta1.RegistrationService/UpdateEndpoint")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateEndpointRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Endpoint.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteEndpointRequest, Empty>
      deleteEndpointMethodDescriptor =
          MethodDescriptor.<DeleteEndpointRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.servicedirectory.v1beta1.RegistrationService/DeleteEndpoint")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteEndpointRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.servicedirectory.v1beta1.RegistrationService/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.servicedirectory.v1beta1.RegistrationService/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.servicedirectory.v1beta1.RegistrationService/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
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
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcRegistrationServiceStub create(RegistrationServiceStubSettings settings)
      throws IOException {
    return new GrpcRegistrationServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcRegistrationServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcRegistrationServiceStub(
        RegistrationServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcRegistrationServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcRegistrationServiceStub(
        RegistrationServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcRegistrationServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcRegistrationServiceStub(
      RegistrationServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcRegistrationServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcRegistrationServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcRegistrationServiceStub(
      RegistrationServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateNamespaceRequest, Namespace> createNamespaceTransportSettings =
        GrpcCallSettings.<CreateNamespaceRequest, Namespace>newBuilder()
            .setMethodDescriptor(createNamespaceMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateNamespaceRequest>() {
                  @Override
                  public Map<String, String> extract(CreateNamespaceRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListNamespacesRequest, ListNamespacesResponse>
        listNamespacesTransportSettings =
            GrpcCallSettings.<ListNamespacesRequest, ListNamespacesResponse>newBuilder()
                .setMethodDescriptor(listNamespacesMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListNamespacesRequest>() {
                      @Override
                      public Map<String, String> extract(ListNamespacesRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<GetNamespaceRequest, Namespace> getNamespaceTransportSettings =
        GrpcCallSettings.<GetNamespaceRequest, Namespace>newBuilder()
            .setMethodDescriptor(getNamespaceMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetNamespaceRequest>() {
                  @Override
                  public Map<String, String> extract(GetNamespaceRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateNamespaceRequest, Namespace> updateNamespaceTransportSettings =
        GrpcCallSettings.<UpdateNamespaceRequest, Namespace>newBuilder()
            .setMethodDescriptor(updateNamespaceMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateNamespaceRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateNamespaceRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("namespace.name", String.valueOf(request.getNamespace().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteNamespaceRequest, Empty> deleteNamespaceTransportSettings =
        GrpcCallSettings.<DeleteNamespaceRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteNamespaceMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteNamespaceRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteNamespaceRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateServiceRequest, Service> createServiceTransportSettings =
        GrpcCallSettings.<CreateServiceRequest, Service>newBuilder()
            .setMethodDescriptor(createServiceMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateServiceRequest>() {
                  @Override
                  public Map<String, String> extract(CreateServiceRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListServicesRequest, ListServicesResponse> listServicesTransportSettings =
        GrpcCallSettings.<ListServicesRequest, ListServicesResponse>newBuilder()
            .setMethodDescriptor(listServicesMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListServicesRequest>() {
                  @Override
                  public Map<String, String> extract(ListServicesRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetServiceRequest, Service> getServiceTransportSettings =
        GrpcCallSettings.<GetServiceRequest, Service>newBuilder()
            .setMethodDescriptor(getServiceMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetServiceRequest>() {
                  @Override
                  public Map<String, String> extract(GetServiceRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateServiceRequest, Service> updateServiceTransportSettings =
        GrpcCallSettings.<UpdateServiceRequest, Service>newBuilder()
            .setMethodDescriptor(updateServiceMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateServiceRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateServiceRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("service.name", String.valueOf(request.getService().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteServiceRequest, Empty> deleteServiceTransportSettings =
        GrpcCallSettings.<DeleteServiceRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteServiceMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteServiceRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteServiceRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateEndpointRequest, Endpoint> createEndpointTransportSettings =
        GrpcCallSettings.<CreateEndpointRequest, Endpoint>newBuilder()
            .setMethodDescriptor(createEndpointMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateEndpointRequest>() {
                  @Override
                  public Map<String, String> extract(CreateEndpointRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListEndpointsRequest, ListEndpointsResponse> listEndpointsTransportSettings =
        GrpcCallSettings.<ListEndpointsRequest, ListEndpointsResponse>newBuilder()
            .setMethodDescriptor(listEndpointsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListEndpointsRequest>() {
                  @Override
                  public Map<String, String> extract(ListEndpointsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetEndpointRequest, Endpoint> getEndpointTransportSettings =
        GrpcCallSettings.<GetEndpointRequest, Endpoint>newBuilder()
            .setMethodDescriptor(getEndpointMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetEndpointRequest>() {
                  @Override
                  public Map<String, String> extract(GetEndpointRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateEndpointRequest, Endpoint> updateEndpointTransportSettings =
        GrpcCallSettings.<UpdateEndpointRequest, Endpoint>newBuilder()
            .setMethodDescriptor(updateEndpointMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateEndpointRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateEndpointRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("endpoint.name", String.valueOf(request.getEndpoint().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteEndpointRequest, Empty> deleteEndpointTransportSettings =
        GrpcCallSettings.<DeleteEndpointRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteEndpointMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteEndpointRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteEndpointRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetIamPolicyRequest>() {
                  @Override
                  public Map<String, String> extract(GetIamPolicyRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("resource", String.valueOf(request.getResource()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<SetIamPolicyRequest>() {
                  @Override
                  public Map<String, String> extract(SetIamPolicyRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("resource", String.valueOf(request.getResource()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<TestIamPermissionsRequest>() {
                      @Override
                      public Map<String, String> extract(TestIamPermissionsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("resource", String.valueOf(request.getResource()));
                        return params.build();
                      }
                    })
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

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  public UnaryCallable<CreateNamespaceRequest, Namespace> createNamespaceCallable() {
    return createNamespaceCallable;
  }

  public UnaryCallable<ListNamespacesRequest, ListNamespacesResponse> listNamespacesCallable() {
    return listNamespacesCallable;
  }

  public UnaryCallable<ListNamespacesRequest, ListNamespacesPagedResponse>
      listNamespacesPagedCallable() {
    return listNamespacesPagedCallable;
  }

  public UnaryCallable<GetNamespaceRequest, Namespace> getNamespaceCallable() {
    return getNamespaceCallable;
  }

  public UnaryCallable<UpdateNamespaceRequest, Namespace> updateNamespaceCallable() {
    return updateNamespaceCallable;
  }

  public UnaryCallable<DeleteNamespaceRequest, Empty> deleteNamespaceCallable() {
    return deleteNamespaceCallable;
  }

  public UnaryCallable<CreateServiceRequest, Service> createServiceCallable() {
    return createServiceCallable;
  }

  public UnaryCallable<ListServicesRequest, ListServicesResponse> listServicesCallable() {
    return listServicesCallable;
  }

  public UnaryCallable<ListServicesRequest, ListServicesPagedResponse> listServicesPagedCallable() {
    return listServicesPagedCallable;
  }

  public UnaryCallable<GetServiceRequest, Service> getServiceCallable() {
    return getServiceCallable;
  }

  public UnaryCallable<UpdateServiceRequest, Service> updateServiceCallable() {
    return updateServiceCallable;
  }

  public UnaryCallable<DeleteServiceRequest, Empty> deleteServiceCallable() {
    return deleteServiceCallable;
  }

  public UnaryCallable<CreateEndpointRequest, Endpoint> createEndpointCallable() {
    return createEndpointCallable;
  }

  public UnaryCallable<ListEndpointsRequest, ListEndpointsResponse> listEndpointsCallable() {
    return listEndpointsCallable;
  }

  public UnaryCallable<ListEndpointsRequest, ListEndpointsPagedResponse>
      listEndpointsPagedCallable() {
    return listEndpointsPagedCallable;
  }

  public UnaryCallable<GetEndpointRequest, Endpoint> getEndpointCallable() {
    return getEndpointCallable;
  }

  public UnaryCallable<UpdateEndpointRequest, Endpoint> updateEndpointCallable() {
    return updateEndpointCallable;
  }

  public UnaryCallable<DeleteEndpointRequest, Empty> deleteEndpointCallable() {
    return deleteEndpointCallable;
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
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
