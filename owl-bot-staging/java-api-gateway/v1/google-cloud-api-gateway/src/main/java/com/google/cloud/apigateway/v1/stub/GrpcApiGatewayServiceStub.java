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

package com.google.cloud.apigateway.v1.stub;

import static com.google.cloud.apigateway.v1.ApiGatewayServiceClient.ListApiConfigsPagedResponse;
import static com.google.cloud.apigateway.v1.ApiGatewayServiceClient.ListApisPagedResponse;
import static com.google.cloud.apigateway.v1.ApiGatewayServiceClient.ListGatewaysPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.apigateway.v1.Api;
import com.google.cloud.apigateway.v1.ApiConfig;
import com.google.cloud.apigateway.v1.CreateApiConfigRequest;
import com.google.cloud.apigateway.v1.CreateApiRequest;
import com.google.cloud.apigateway.v1.CreateGatewayRequest;
import com.google.cloud.apigateway.v1.DeleteApiConfigRequest;
import com.google.cloud.apigateway.v1.DeleteApiRequest;
import com.google.cloud.apigateway.v1.DeleteGatewayRequest;
import com.google.cloud.apigateway.v1.Gateway;
import com.google.cloud.apigateway.v1.GetApiConfigRequest;
import com.google.cloud.apigateway.v1.GetApiRequest;
import com.google.cloud.apigateway.v1.GetGatewayRequest;
import com.google.cloud.apigateway.v1.ListApiConfigsRequest;
import com.google.cloud.apigateway.v1.ListApiConfigsResponse;
import com.google.cloud.apigateway.v1.ListApisRequest;
import com.google.cloud.apigateway.v1.ListApisResponse;
import com.google.cloud.apigateway.v1.ListGatewaysRequest;
import com.google.cloud.apigateway.v1.ListGatewaysResponse;
import com.google.cloud.apigateway.v1.OperationMetadata;
import com.google.cloud.apigateway.v1.UpdateApiConfigRequest;
import com.google.cloud.apigateway.v1.UpdateApiRequest;
import com.google.cloud.apigateway.v1.UpdateGatewayRequest;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
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
 * gRPC stub implementation for the ApiGatewayService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcApiGatewayServiceStub extends ApiGatewayServiceStub {
  private static final MethodDescriptor<ListGatewaysRequest, ListGatewaysResponse>
      listGatewaysMethodDescriptor =
          MethodDescriptor.<ListGatewaysRequest, ListGatewaysResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apigateway.v1.ApiGatewayService/ListGateways")
              .setRequestMarshaller(ProtoUtils.marshaller(ListGatewaysRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListGatewaysResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetGatewayRequest, Gateway> getGatewayMethodDescriptor =
      MethodDescriptor.<GetGatewayRequest, Gateway>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.apigateway.v1.ApiGatewayService/GetGateway")
          .setRequestMarshaller(ProtoUtils.marshaller(GetGatewayRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Gateway.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateGatewayRequest, Operation>
      createGatewayMethodDescriptor =
          MethodDescriptor.<CreateGatewayRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apigateway.v1.ApiGatewayService/CreateGateway")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateGatewayRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateGatewayRequest, Operation>
      updateGatewayMethodDescriptor =
          MethodDescriptor.<UpdateGatewayRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apigateway.v1.ApiGatewayService/UpdateGateway")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateGatewayRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteGatewayRequest, Operation>
      deleteGatewayMethodDescriptor =
          MethodDescriptor.<DeleteGatewayRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apigateway.v1.ApiGatewayService/DeleteGateway")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteGatewayRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListApisRequest, ListApisResponse>
      listApisMethodDescriptor =
          MethodDescriptor.<ListApisRequest, ListApisResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apigateway.v1.ApiGatewayService/ListApis")
              .setRequestMarshaller(ProtoUtils.marshaller(ListApisRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListApisResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetApiRequest, Api> getApiMethodDescriptor =
      MethodDescriptor.<GetApiRequest, Api>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.apigateway.v1.ApiGatewayService/GetApi")
          .setRequestMarshaller(ProtoUtils.marshaller(GetApiRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Api.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateApiRequest, Operation> createApiMethodDescriptor =
      MethodDescriptor.<CreateApiRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.apigateway.v1.ApiGatewayService/CreateApi")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateApiRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateApiRequest, Operation> updateApiMethodDescriptor =
      MethodDescriptor.<UpdateApiRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.apigateway.v1.ApiGatewayService/UpdateApi")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateApiRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteApiRequest, Operation> deleteApiMethodDescriptor =
      MethodDescriptor.<DeleteApiRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.apigateway.v1.ApiGatewayService/DeleteApi")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteApiRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListApiConfigsRequest, ListApiConfigsResponse>
      listApiConfigsMethodDescriptor =
          MethodDescriptor.<ListApiConfigsRequest, ListApiConfigsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apigateway.v1.ApiGatewayService/ListApiConfigs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListApiConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListApiConfigsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetApiConfigRequest, ApiConfig>
      getApiConfigMethodDescriptor =
          MethodDescriptor.<GetApiConfigRequest, ApiConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apigateway.v1.ApiGatewayService/GetApiConfig")
              .setRequestMarshaller(ProtoUtils.marshaller(GetApiConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ApiConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateApiConfigRequest, Operation>
      createApiConfigMethodDescriptor =
          MethodDescriptor.<CreateApiConfigRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apigateway.v1.ApiGatewayService/CreateApiConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateApiConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateApiConfigRequest, Operation>
      updateApiConfigMethodDescriptor =
          MethodDescriptor.<UpdateApiConfigRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apigateway.v1.ApiGatewayService/UpdateApiConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateApiConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteApiConfigRequest, Operation>
      deleteApiConfigMethodDescriptor =
          MethodDescriptor.<DeleteApiConfigRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apigateway.v1.ApiGatewayService/DeleteApiConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteApiConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListGatewaysRequest, ListGatewaysResponse> listGatewaysCallable;
  private final UnaryCallable<ListGatewaysRequest, ListGatewaysPagedResponse>
      listGatewaysPagedCallable;
  private final UnaryCallable<GetGatewayRequest, Gateway> getGatewayCallable;
  private final UnaryCallable<CreateGatewayRequest, Operation> createGatewayCallable;
  private final OperationCallable<CreateGatewayRequest, Gateway, OperationMetadata>
      createGatewayOperationCallable;
  private final UnaryCallable<UpdateGatewayRequest, Operation> updateGatewayCallable;
  private final OperationCallable<UpdateGatewayRequest, Gateway, OperationMetadata>
      updateGatewayOperationCallable;
  private final UnaryCallable<DeleteGatewayRequest, Operation> deleteGatewayCallable;
  private final OperationCallable<DeleteGatewayRequest, Empty, OperationMetadata>
      deleteGatewayOperationCallable;
  private final UnaryCallable<ListApisRequest, ListApisResponse> listApisCallable;
  private final UnaryCallable<ListApisRequest, ListApisPagedResponse> listApisPagedCallable;
  private final UnaryCallable<GetApiRequest, Api> getApiCallable;
  private final UnaryCallable<CreateApiRequest, Operation> createApiCallable;
  private final OperationCallable<CreateApiRequest, Api, OperationMetadata>
      createApiOperationCallable;
  private final UnaryCallable<UpdateApiRequest, Operation> updateApiCallable;
  private final OperationCallable<UpdateApiRequest, Api, OperationMetadata>
      updateApiOperationCallable;
  private final UnaryCallable<DeleteApiRequest, Operation> deleteApiCallable;
  private final OperationCallable<DeleteApiRequest, Empty, OperationMetadata>
      deleteApiOperationCallable;
  private final UnaryCallable<ListApiConfigsRequest, ListApiConfigsResponse> listApiConfigsCallable;
  private final UnaryCallable<ListApiConfigsRequest, ListApiConfigsPagedResponse>
      listApiConfigsPagedCallable;
  private final UnaryCallable<GetApiConfigRequest, ApiConfig> getApiConfigCallable;
  private final UnaryCallable<CreateApiConfigRequest, Operation> createApiConfigCallable;
  private final OperationCallable<CreateApiConfigRequest, ApiConfig, OperationMetadata>
      createApiConfigOperationCallable;
  private final UnaryCallable<UpdateApiConfigRequest, Operation> updateApiConfigCallable;
  private final OperationCallable<UpdateApiConfigRequest, ApiConfig, OperationMetadata>
      updateApiConfigOperationCallable;
  private final UnaryCallable<DeleteApiConfigRequest, Operation> deleteApiConfigCallable;
  private final OperationCallable<DeleteApiConfigRequest, Empty, OperationMetadata>
      deleteApiConfigOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcApiGatewayServiceStub create(ApiGatewayServiceStubSettings settings)
      throws IOException {
    return new GrpcApiGatewayServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcApiGatewayServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcApiGatewayServiceStub(
        ApiGatewayServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcApiGatewayServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcApiGatewayServiceStub(
        ApiGatewayServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcApiGatewayServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcApiGatewayServiceStub(
      ApiGatewayServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcApiGatewayServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcApiGatewayServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcApiGatewayServiceStub(
      ApiGatewayServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListGatewaysRequest, ListGatewaysResponse> listGatewaysTransportSettings =
        GrpcCallSettings.<ListGatewaysRequest, ListGatewaysResponse>newBuilder()
            .setMethodDescriptor(listGatewaysMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetGatewayRequest, Gateway> getGatewayTransportSettings =
        GrpcCallSettings.<GetGatewayRequest, Gateway>newBuilder()
            .setMethodDescriptor(getGatewayMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateGatewayRequest, Operation> createGatewayTransportSettings =
        GrpcCallSettings.<CreateGatewayRequest, Operation>newBuilder()
            .setMethodDescriptor(createGatewayMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateGatewayRequest, Operation> updateGatewayTransportSettings =
        GrpcCallSettings.<UpdateGatewayRequest, Operation>newBuilder()
            .setMethodDescriptor(updateGatewayMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("gateway.name", String.valueOf(request.getGateway().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteGatewayRequest, Operation> deleteGatewayTransportSettings =
        GrpcCallSettings.<DeleteGatewayRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteGatewayMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListApisRequest, ListApisResponse> listApisTransportSettings =
        GrpcCallSettings.<ListApisRequest, ListApisResponse>newBuilder()
            .setMethodDescriptor(listApisMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetApiRequest, Api> getApiTransportSettings =
        GrpcCallSettings.<GetApiRequest, Api>newBuilder()
            .setMethodDescriptor(getApiMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateApiRequest, Operation> createApiTransportSettings =
        GrpcCallSettings.<CreateApiRequest, Operation>newBuilder()
            .setMethodDescriptor(createApiMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateApiRequest, Operation> updateApiTransportSettings =
        GrpcCallSettings.<UpdateApiRequest, Operation>newBuilder()
            .setMethodDescriptor(updateApiMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("api.name", String.valueOf(request.getApi().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteApiRequest, Operation> deleteApiTransportSettings =
        GrpcCallSettings.<DeleteApiRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteApiMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListApiConfigsRequest, ListApiConfigsResponse>
        listApiConfigsTransportSettings =
            GrpcCallSettings.<ListApiConfigsRequest, ListApiConfigsResponse>newBuilder()
                .setMethodDescriptor(listApiConfigsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetApiConfigRequest, ApiConfig> getApiConfigTransportSettings =
        GrpcCallSettings.<GetApiConfigRequest, ApiConfig>newBuilder()
            .setMethodDescriptor(getApiConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateApiConfigRequest, Operation> createApiConfigTransportSettings =
        GrpcCallSettings.<CreateApiConfigRequest, Operation>newBuilder()
            .setMethodDescriptor(createApiConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateApiConfigRequest, Operation> updateApiConfigTransportSettings =
        GrpcCallSettings.<UpdateApiConfigRequest, Operation>newBuilder()
            .setMethodDescriptor(updateApiConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("api_config.name", String.valueOf(request.getApiConfig().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteApiConfigRequest, Operation> deleteApiConfigTransportSettings =
        GrpcCallSettings.<DeleteApiConfigRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteApiConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();

    this.listGatewaysCallable =
        callableFactory.createUnaryCallable(
            listGatewaysTransportSettings, settings.listGatewaysSettings(), clientContext);
    this.listGatewaysPagedCallable =
        callableFactory.createPagedCallable(
            listGatewaysTransportSettings, settings.listGatewaysSettings(), clientContext);
    this.getGatewayCallable =
        callableFactory.createUnaryCallable(
            getGatewayTransportSettings, settings.getGatewaySettings(), clientContext);
    this.createGatewayCallable =
        callableFactory.createUnaryCallable(
            createGatewayTransportSettings, settings.createGatewaySettings(), clientContext);
    this.createGatewayOperationCallable =
        callableFactory.createOperationCallable(
            createGatewayTransportSettings,
            settings.createGatewayOperationSettings(),
            clientContext,
            operationsStub);
    this.updateGatewayCallable =
        callableFactory.createUnaryCallable(
            updateGatewayTransportSettings, settings.updateGatewaySettings(), clientContext);
    this.updateGatewayOperationCallable =
        callableFactory.createOperationCallable(
            updateGatewayTransportSettings,
            settings.updateGatewayOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteGatewayCallable =
        callableFactory.createUnaryCallable(
            deleteGatewayTransportSettings, settings.deleteGatewaySettings(), clientContext);
    this.deleteGatewayOperationCallable =
        callableFactory.createOperationCallable(
            deleteGatewayTransportSettings,
            settings.deleteGatewayOperationSettings(),
            clientContext,
            operationsStub);
    this.listApisCallable =
        callableFactory.createUnaryCallable(
            listApisTransportSettings, settings.listApisSettings(), clientContext);
    this.listApisPagedCallable =
        callableFactory.createPagedCallable(
            listApisTransportSettings, settings.listApisSettings(), clientContext);
    this.getApiCallable =
        callableFactory.createUnaryCallable(
            getApiTransportSettings, settings.getApiSettings(), clientContext);
    this.createApiCallable =
        callableFactory.createUnaryCallable(
            createApiTransportSettings, settings.createApiSettings(), clientContext);
    this.createApiOperationCallable =
        callableFactory.createOperationCallable(
            createApiTransportSettings,
            settings.createApiOperationSettings(),
            clientContext,
            operationsStub);
    this.updateApiCallable =
        callableFactory.createUnaryCallable(
            updateApiTransportSettings, settings.updateApiSettings(), clientContext);
    this.updateApiOperationCallable =
        callableFactory.createOperationCallable(
            updateApiTransportSettings,
            settings.updateApiOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteApiCallable =
        callableFactory.createUnaryCallable(
            deleteApiTransportSettings, settings.deleteApiSettings(), clientContext);
    this.deleteApiOperationCallable =
        callableFactory.createOperationCallable(
            deleteApiTransportSettings,
            settings.deleteApiOperationSettings(),
            clientContext,
            operationsStub);
    this.listApiConfigsCallable =
        callableFactory.createUnaryCallable(
            listApiConfigsTransportSettings, settings.listApiConfigsSettings(), clientContext);
    this.listApiConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listApiConfigsTransportSettings, settings.listApiConfigsSettings(), clientContext);
    this.getApiConfigCallable =
        callableFactory.createUnaryCallable(
            getApiConfigTransportSettings, settings.getApiConfigSettings(), clientContext);
    this.createApiConfigCallable =
        callableFactory.createUnaryCallable(
            createApiConfigTransportSettings, settings.createApiConfigSettings(), clientContext);
    this.createApiConfigOperationCallable =
        callableFactory.createOperationCallable(
            createApiConfigTransportSettings,
            settings.createApiConfigOperationSettings(),
            clientContext,
            operationsStub);
    this.updateApiConfigCallable =
        callableFactory.createUnaryCallable(
            updateApiConfigTransportSettings, settings.updateApiConfigSettings(), clientContext);
    this.updateApiConfigOperationCallable =
        callableFactory.createOperationCallable(
            updateApiConfigTransportSettings,
            settings.updateApiConfigOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteApiConfigCallable =
        callableFactory.createUnaryCallable(
            deleteApiConfigTransportSettings, settings.deleteApiConfigSettings(), clientContext);
    this.deleteApiConfigOperationCallable =
        callableFactory.createOperationCallable(
            deleteApiConfigTransportSettings,
            settings.deleteApiConfigOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListGatewaysRequest, ListGatewaysResponse> listGatewaysCallable() {
    return listGatewaysCallable;
  }

  @Override
  public UnaryCallable<ListGatewaysRequest, ListGatewaysPagedResponse> listGatewaysPagedCallable() {
    return listGatewaysPagedCallable;
  }

  @Override
  public UnaryCallable<GetGatewayRequest, Gateway> getGatewayCallable() {
    return getGatewayCallable;
  }

  @Override
  public UnaryCallable<CreateGatewayRequest, Operation> createGatewayCallable() {
    return createGatewayCallable;
  }

  @Override
  public OperationCallable<CreateGatewayRequest, Gateway, OperationMetadata>
      createGatewayOperationCallable() {
    return createGatewayOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateGatewayRequest, Operation> updateGatewayCallable() {
    return updateGatewayCallable;
  }

  @Override
  public OperationCallable<UpdateGatewayRequest, Gateway, OperationMetadata>
      updateGatewayOperationCallable() {
    return updateGatewayOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteGatewayRequest, Operation> deleteGatewayCallable() {
    return deleteGatewayCallable;
  }

  @Override
  public OperationCallable<DeleteGatewayRequest, Empty, OperationMetadata>
      deleteGatewayOperationCallable() {
    return deleteGatewayOperationCallable;
  }

  @Override
  public UnaryCallable<ListApisRequest, ListApisResponse> listApisCallable() {
    return listApisCallable;
  }

  @Override
  public UnaryCallable<ListApisRequest, ListApisPagedResponse> listApisPagedCallable() {
    return listApisPagedCallable;
  }

  @Override
  public UnaryCallable<GetApiRequest, Api> getApiCallable() {
    return getApiCallable;
  }

  @Override
  public UnaryCallable<CreateApiRequest, Operation> createApiCallable() {
    return createApiCallable;
  }

  @Override
  public OperationCallable<CreateApiRequest, Api, OperationMetadata> createApiOperationCallable() {
    return createApiOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateApiRequest, Operation> updateApiCallable() {
    return updateApiCallable;
  }

  @Override
  public OperationCallable<UpdateApiRequest, Api, OperationMetadata> updateApiOperationCallable() {
    return updateApiOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteApiRequest, Operation> deleteApiCallable() {
    return deleteApiCallable;
  }

  @Override
  public OperationCallable<DeleteApiRequest, Empty, OperationMetadata>
      deleteApiOperationCallable() {
    return deleteApiOperationCallable;
  }

  @Override
  public UnaryCallable<ListApiConfigsRequest, ListApiConfigsResponse> listApiConfigsCallable() {
    return listApiConfigsCallable;
  }

  @Override
  public UnaryCallable<ListApiConfigsRequest, ListApiConfigsPagedResponse>
      listApiConfigsPagedCallable() {
    return listApiConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<GetApiConfigRequest, ApiConfig> getApiConfigCallable() {
    return getApiConfigCallable;
  }

  @Override
  public UnaryCallable<CreateApiConfigRequest, Operation> createApiConfigCallable() {
    return createApiConfigCallable;
  }

  @Override
  public OperationCallable<CreateApiConfigRequest, ApiConfig, OperationMetadata>
      createApiConfigOperationCallable() {
    return createApiConfigOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateApiConfigRequest, Operation> updateApiConfigCallable() {
    return updateApiConfigCallable;
  }

  @Override
  public OperationCallable<UpdateApiConfigRequest, ApiConfig, OperationMetadata>
      updateApiConfigOperationCallable() {
    return updateApiConfigOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteApiConfigRequest, Operation> deleteApiConfigCallable() {
    return deleteApiConfigCallable;
  }

  @Override
  public OperationCallable<DeleteApiConfigRequest, Empty, OperationMetadata>
      deleteApiConfigOperationCallable() {
    return deleteApiConfigOperationCallable;
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
