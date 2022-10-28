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
 * REST stub implementation for the ApiGatewayService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonApiGatewayServiceStub extends ApiGatewayServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(OperationMetadata.getDescriptor())
          .add(Empty.getDescriptor())
          .add(Gateway.getDescriptor())
          .add(ApiConfig.getDescriptor())
          .add(Api.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListGatewaysRequest, ListGatewaysResponse>
      listGatewaysMethodDescriptor =
          ApiMethodDescriptor.<ListGatewaysRequest, ListGatewaysResponse>newBuilder()
              .setFullMethodName("google.cloud.apigateway.v1.ApiGatewayService/ListGateways")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListGatewaysRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/gateways",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListGatewaysRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListGatewaysRequest> serializer =
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
                  ProtoMessageResponseParser.<ListGatewaysResponse>newBuilder()
                      .setDefaultInstance(ListGatewaysResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetGatewayRequest, Gateway> getGatewayMethodDescriptor =
      ApiMethodDescriptor.<GetGatewayRequest, Gateway>newBuilder()
          .setFullMethodName("google.cloud.apigateway.v1.ApiGatewayService/GetGateway")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetGatewayRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/gateways/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetGatewayRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetGatewayRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Gateway>newBuilder()
                  .setDefaultInstance(Gateway.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateGatewayRequest, Operation>
      createGatewayMethodDescriptor =
          ApiMethodDescriptor.<CreateGatewayRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.apigateway.v1.ApiGatewayService/CreateGateway")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateGatewayRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/gateways",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateGatewayRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateGatewayRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "gatewayId", request.getGatewayId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("gateway", request.getGateway(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateGatewayRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateGatewayRequest, Operation>
      updateGatewayMethodDescriptor =
          ApiMethodDescriptor.<UpdateGatewayRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.apigateway.v1.ApiGatewayService/UpdateGateway")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateGatewayRequest>newBuilder()
                      .setPath(
                          "/v1/{gateway.name=projects/*/locations/*/gateways/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateGatewayRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "gateway.name", request.getGateway().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateGatewayRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("gateway", request.getGateway(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateGatewayRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteGatewayRequest, Operation>
      deleteGatewayMethodDescriptor =
          ApiMethodDescriptor.<DeleteGatewayRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.apigateway.v1.ApiGatewayService/DeleteGateway")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteGatewayRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/gateways/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteGatewayRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteGatewayRequest> serializer =
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
                  (DeleteGatewayRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListApisRequest, ListApisResponse>
      listApisMethodDescriptor =
          ApiMethodDescriptor.<ListApisRequest, ListApisResponse>newBuilder()
              .setFullMethodName("google.cloud.apigateway.v1.ApiGatewayService/ListApis")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListApisRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/apis",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListApisRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListApisRequest> serializer =
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
                  ProtoMessageResponseParser.<ListApisResponse>newBuilder()
                      .setDefaultInstance(ListApisResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetApiRequest, Api> getApiMethodDescriptor =
      ApiMethodDescriptor.<GetApiRequest, Api>newBuilder()
          .setFullMethodName("google.cloud.apigateway.v1.ApiGatewayService/GetApi")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetApiRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/apis/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetApiRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetApiRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Api>newBuilder()
                  .setDefaultInstance(Api.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateApiRequest, Operation> createApiMethodDescriptor =
      ApiMethodDescriptor.<CreateApiRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.apigateway.v1.ApiGatewayService/CreateApi")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CreateApiRequest>newBuilder()
                  .setPath(
                      "/v1/{parent=projects/*/locations/*}/apis",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CreateApiRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "parent", request.getParent());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CreateApiRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "apiId", request.getApiId());
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("api", request.getApi(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .setOperationSnapshotFactory(
              (CreateApiRequest request, Operation response) ->
                  HttpJsonOperationSnapshot.create(response))
          .build();

  private static final ApiMethodDescriptor<UpdateApiRequest, Operation> updateApiMethodDescriptor =
      ApiMethodDescriptor.<UpdateApiRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.apigateway.v1.ApiGatewayService/UpdateApi")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateApiRequest>newBuilder()
                  .setPath(
                      "/v1/{api.name=projects/*/locations/*/apis/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateApiRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "api.name", request.getApi().getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateApiRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("api", request.getApi(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .setOperationSnapshotFactory(
              (UpdateApiRequest request, Operation response) ->
                  HttpJsonOperationSnapshot.create(response))
          .build();

  private static final ApiMethodDescriptor<DeleteApiRequest, Operation> deleteApiMethodDescriptor =
      ApiMethodDescriptor.<DeleteApiRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.apigateway.v1.ApiGatewayService/DeleteApi")
          .setHttpMethod("DELETE")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteApiRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/apis/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteApiRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteApiRequest> serializer =
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
              (DeleteApiRequest request, Operation response) ->
                  HttpJsonOperationSnapshot.create(response))
          .build();

  private static final ApiMethodDescriptor<ListApiConfigsRequest, ListApiConfigsResponse>
      listApiConfigsMethodDescriptor =
          ApiMethodDescriptor.<ListApiConfigsRequest, ListApiConfigsResponse>newBuilder()
              .setFullMethodName("google.cloud.apigateway.v1.ApiGatewayService/ListApiConfigs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListApiConfigsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/apis/*}/configs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListApiConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListApiConfigsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListApiConfigsResponse>newBuilder()
                      .setDefaultInstance(ListApiConfigsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetApiConfigRequest, ApiConfig>
      getApiConfigMethodDescriptor =
          ApiMethodDescriptor.<GetApiConfigRequest, ApiConfig>newBuilder()
              .setFullMethodName("google.cloud.apigateway.v1.ApiGatewayService/GetApiConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetApiConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/apis/*/configs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetApiConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetApiConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "view", request.getViewValue());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ApiConfig>newBuilder()
                      .setDefaultInstance(ApiConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateApiConfigRequest, Operation>
      createApiConfigMethodDescriptor =
          ApiMethodDescriptor.<CreateApiConfigRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.apigateway.v1.ApiGatewayService/CreateApiConfig")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateApiConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/apis/*}/configs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateApiConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateApiConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "apiConfigId", request.getApiConfigId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("apiConfig", request.getApiConfig(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateApiConfigRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateApiConfigRequest, Operation>
      updateApiConfigMethodDescriptor =
          ApiMethodDescriptor.<UpdateApiConfigRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.apigateway.v1.ApiGatewayService/UpdateApiConfig")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateApiConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{apiConfig.name=projects/*/locations/*/apis/*/configs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateApiConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "apiConfig.name", request.getApiConfig().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateApiConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("apiConfig", request.getApiConfig(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateApiConfigRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteApiConfigRequest, Operation>
      deleteApiConfigMethodDescriptor =
          ApiMethodDescriptor.<DeleteApiConfigRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.apigateway.v1.ApiGatewayService/DeleteApiConfig")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteApiConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/apis/*/configs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteApiConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteApiConfigRequest> serializer =
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
                  (DeleteApiConfigRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
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
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonApiGatewayServiceStub create(ApiGatewayServiceStubSettings settings)
      throws IOException {
    return new HttpJsonApiGatewayServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonApiGatewayServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonApiGatewayServiceStub(
        ApiGatewayServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonApiGatewayServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonApiGatewayServiceStub(
        ApiGatewayServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonApiGatewayServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonApiGatewayServiceStub(
      ApiGatewayServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonApiGatewayServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonApiGatewayServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonApiGatewayServiceStub(
      ApiGatewayServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<ListGatewaysRequest, ListGatewaysResponse> listGatewaysTransportSettings =
        HttpJsonCallSettings.<ListGatewaysRequest, ListGatewaysResponse>newBuilder()
            .setMethodDescriptor(listGatewaysMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetGatewayRequest, Gateway> getGatewayTransportSettings =
        HttpJsonCallSettings.<GetGatewayRequest, Gateway>newBuilder()
            .setMethodDescriptor(getGatewayMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateGatewayRequest, Operation> createGatewayTransportSettings =
        HttpJsonCallSettings.<CreateGatewayRequest, Operation>newBuilder()
            .setMethodDescriptor(createGatewayMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateGatewayRequest, Operation> updateGatewayTransportSettings =
        HttpJsonCallSettings.<UpdateGatewayRequest, Operation>newBuilder()
            .setMethodDescriptor(updateGatewayMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteGatewayRequest, Operation> deleteGatewayTransportSettings =
        HttpJsonCallSettings.<DeleteGatewayRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteGatewayMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListApisRequest, ListApisResponse> listApisTransportSettings =
        HttpJsonCallSettings.<ListApisRequest, ListApisResponse>newBuilder()
            .setMethodDescriptor(listApisMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetApiRequest, Api> getApiTransportSettings =
        HttpJsonCallSettings.<GetApiRequest, Api>newBuilder()
            .setMethodDescriptor(getApiMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateApiRequest, Operation> createApiTransportSettings =
        HttpJsonCallSettings.<CreateApiRequest, Operation>newBuilder()
            .setMethodDescriptor(createApiMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateApiRequest, Operation> updateApiTransportSettings =
        HttpJsonCallSettings.<UpdateApiRequest, Operation>newBuilder()
            .setMethodDescriptor(updateApiMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteApiRequest, Operation> deleteApiTransportSettings =
        HttpJsonCallSettings.<DeleteApiRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteApiMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListApiConfigsRequest, ListApiConfigsResponse>
        listApiConfigsTransportSettings =
            HttpJsonCallSettings.<ListApiConfigsRequest, ListApiConfigsResponse>newBuilder()
                .setMethodDescriptor(listApiConfigsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetApiConfigRequest, ApiConfig> getApiConfigTransportSettings =
        HttpJsonCallSettings.<GetApiConfigRequest, ApiConfig>newBuilder()
            .setMethodDescriptor(getApiConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateApiConfigRequest, Operation> createApiConfigTransportSettings =
        HttpJsonCallSettings.<CreateApiConfigRequest, Operation>newBuilder()
            .setMethodDescriptor(createApiConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateApiConfigRequest, Operation> updateApiConfigTransportSettings =
        HttpJsonCallSettings.<UpdateApiConfigRequest, Operation>newBuilder()
            .setMethodDescriptor(updateApiConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteApiConfigRequest, Operation> deleteApiConfigTransportSettings =
        HttpJsonCallSettings.<DeleteApiConfigRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteApiConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
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
            httpJsonOperationsStub);
    this.updateGatewayCallable =
        callableFactory.createUnaryCallable(
            updateGatewayTransportSettings, settings.updateGatewaySettings(), clientContext);
    this.updateGatewayOperationCallable =
        callableFactory.createOperationCallable(
            updateGatewayTransportSettings,
            settings.updateGatewayOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteGatewayCallable =
        callableFactory.createUnaryCallable(
            deleteGatewayTransportSettings, settings.deleteGatewaySettings(), clientContext);
    this.deleteGatewayOperationCallable =
        callableFactory.createOperationCallable(
            deleteGatewayTransportSettings,
            settings.deleteGatewayOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
    this.updateApiCallable =
        callableFactory.createUnaryCallable(
            updateApiTransportSettings, settings.updateApiSettings(), clientContext);
    this.updateApiOperationCallable =
        callableFactory.createOperationCallable(
            updateApiTransportSettings,
            settings.updateApiOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteApiCallable =
        callableFactory.createUnaryCallable(
            deleteApiTransportSettings, settings.deleteApiSettings(), clientContext);
    this.deleteApiOperationCallable =
        callableFactory.createOperationCallable(
            deleteApiTransportSettings,
            settings.deleteApiOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
    this.updateApiConfigCallable =
        callableFactory.createUnaryCallable(
            updateApiConfigTransportSettings, settings.updateApiConfigSettings(), clientContext);
    this.updateApiConfigOperationCallable =
        callableFactory.createOperationCallable(
            updateApiConfigTransportSettings,
            settings.updateApiConfigOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteApiConfigCallable =
        callableFactory.createUnaryCallable(
            deleteApiConfigTransportSettings, settings.deleteApiConfigSettings(), clientContext);
    this.deleteApiConfigOperationCallable =
        callableFactory.createOperationCallable(
            deleteApiConfigTransportSettings,
            settings.deleteApiConfigOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listGatewaysMethodDescriptor);
    methodDescriptors.add(getGatewayMethodDescriptor);
    methodDescriptors.add(createGatewayMethodDescriptor);
    methodDescriptors.add(updateGatewayMethodDescriptor);
    methodDescriptors.add(deleteGatewayMethodDescriptor);
    methodDescriptors.add(listApisMethodDescriptor);
    methodDescriptors.add(getApiMethodDescriptor);
    methodDescriptors.add(createApiMethodDescriptor);
    methodDescriptors.add(updateApiMethodDescriptor);
    methodDescriptors.add(deleteApiMethodDescriptor);
    methodDescriptors.add(listApiConfigsMethodDescriptor);
    methodDescriptors.add(getApiConfigMethodDescriptor);
    methodDescriptors.add(createApiConfigMethodDescriptor);
    methodDescriptors.add(updateApiConfigMethodDescriptor);
    methodDescriptors.add(deleteApiConfigMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
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
