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

package com.google.cloud.bigquery.datapolicies.v2beta1.stub;

import static com.google.cloud.bigquery.datapolicies.v2beta1.DataPolicyServiceClient.ListDataPoliciesPagedResponse;

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
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigquery.datapolicies.v2beta1.AddGranteesRequest;
import com.google.cloud.bigquery.datapolicies.v2beta1.CreateDataPolicyRequest;
import com.google.cloud.bigquery.datapolicies.v2beta1.DataPolicy;
import com.google.cloud.bigquery.datapolicies.v2beta1.DeleteDataPolicyRequest;
import com.google.cloud.bigquery.datapolicies.v2beta1.GetDataPolicyRequest;
import com.google.cloud.bigquery.datapolicies.v2beta1.ListDataPoliciesRequest;
import com.google.cloud.bigquery.datapolicies.v2beta1.ListDataPoliciesResponse;
import com.google.cloud.bigquery.datapolicies.v2beta1.RemoveGranteesRequest;
import com.google.cloud.bigquery.datapolicies.v2beta1.UpdateDataPolicyRequest;
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
 * REST stub implementation for the DataPolicyService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonDataPolicyServiceStub extends DataPolicyServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateDataPolicyRequest, DataPolicy>
      createDataPolicyMethodDescriptor =
          ApiMethodDescriptor.<CreateDataPolicyRequest, DataPolicy>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.datapolicies.v2beta1.DataPolicyService/CreateDataPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDataPolicyRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{parent=projects/*/locations/*}/dataPolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDataPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDataPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DataPolicy>newBuilder()
                      .setDefaultInstance(DataPolicy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<AddGranteesRequest, DataPolicy>
      addGranteesMethodDescriptor =
          ApiMethodDescriptor.<AddGranteesRequest, DataPolicy>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.datapolicies.v2beta1.DataPolicyService/AddGrantees")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AddGranteesRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{dataPolicy=projects/*/locations/*/dataPolicies/*}:addGrantees",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AddGranteesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "dataPolicy", request.getDataPolicy());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AddGranteesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearDataPolicy().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DataPolicy>newBuilder()
                      .setDefaultInstance(DataPolicy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RemoveGranteesRequest, DataPolicy>
      removeGranteesMethodDescriptor =
          ApiMethodDescriptor.<RemoveGranteesRequest, DataPolicy>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.datapolicies.v2beta1.DataPolicyService/RemoveGrantees")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RemoveGranteesRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{dataPolicy=projects/*/locations/*/dataPolicies/*}:removeGrantees",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveGranteesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "dataPolicy", request.getDataPolicy());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveGranteesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearDataPolicy().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DataPolicy>newBuilder()
                      .setDefaultInstance(DataPolicy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateDataPolicyRequest, DataPolicy>
      updateDataPolicyMethodDescriptor =
          ApiMethodDescriptor.<UpdateDataPolicyRequest, DataPolicy>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.datapolicies.v2beta1.DataPolicyService/UpdateDataPolicy")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDataPolicyRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{dataPolicy.name=projects/*/locations/*/dataPolicies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDataPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "dataPolicy.name", request.getDataPolicy().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDataPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("dataPolicy", request.getDataPolicy(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DataPolicy>newBuilder()
                      .setDefaultInstance(DataPolicy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteDataPolicyRequest, Empty>
      deleteDataPolicyMethodDescriptor =
          ApiMethodDescriptor.<DeleteDataPolicyRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.datapolicies.v2beta1.DataPolicyService/DeleteDataPolicy")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDataPolicyRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{name=projects/*/locations/*/dataPolicies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDataPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDataPolicyRequest> serializer =
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

  private static final ApiMethodDescriptor<GetDataPolicyRequest, DataPolicy>
      getDataPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetDataPolicyRequest, DataPolicy>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.datapolicies.v2beta1.DataPolicyService/GetDataPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDataPolicyRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{name=projects/*/locations/*/dataPolicies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDataPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDataPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DataPolicy>newBuilder()
                      .setDefaultInstance(DataPolicy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListDataPoliciesRequest, ListDataPoliciesResponse>
      listDataPoliciesMethodDescriptor =
          ApiMethodDescriptor.<ListDataPoliciesRequest, ListDataPoliciesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.datapolicies.v2beta1.DataPolicyService/ListDataPolicies")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDataPoliciesRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{parent=projects/*/locations/*}/dataPolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDataPoliciesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDataPoliciesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListDataPoliciesResponse>newBuilder()
                      .setDefaultInstance(ListDataPoliciesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetIamPolicyRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.datapolicies.v2beta1.DataPolicyService/GetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{resource=projects/*/locations/*/dataPolicies/*}:getIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
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
                  "google.cloud.bigquery.datapolicies.v2beta1.DataPolicyService/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{resource=projects/*/locations/*/dataPolicies/*}:setIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
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
                  "google.cloud.bigquery.datapolicies.v2beta1.DataPolicyService/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{resource=projects/*/locations/*/dataPolicies/*}:testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
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

  private final UnaryCallable<CreateDataPolicyRequest, DataPolicy> createDataPolicyCallable;
  private final UnaryCallable<AddGranteesRequest, DataPolicy> addGranteesCallable;
  private final UnaryCallable<RemoveGranteesRequest, DataPolicy> removeGranteesCallable;
  private final UnaryCallable<UpdateDataPolicyRequest, DataPolicy> updateDataPolicyCallable;
  private final UnaryCallable<DeleteDataPolicyRequest, Empty> deleteDataPolicyCallable;
  private final UnaryCallable<GetDataPolicyRequest, DataPolicy> getDataPolicyCallable;
  private final UnaryCallable<ListDataPoliciesRequest, ListDataPoliciesResponse>
      listDataPoliciesCallable;
  private final UnaryCallable<ListDataPoliciesRequest, ListDataPoliciesPagedResponse>
      listDataPoliciesPagedCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonDataPolicyServiceStub create(DataPolicyServiceStubSettings settings)
      throws IOException {
    return new HttpJsonDataPolicyServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonDataPolicyServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonDataPolicyServiceStub(
        DataPolicyServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonDataPolicyServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonDataPolicyServiceStub(
        DataPolicyServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonDataPolicyServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDataPolicyServiceStub(
      DataPolicyServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonDataPolicyServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonDataPolicyServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDataPolicyServiceStub(
      DataPolicyServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateDataPolicyRequest, DataPolicy> createDataPolicyTransportSettings =
        HttpJsonCallSettings.<CreateDataPolicyRequest, DataPolicy>newBuilder()
            .setMethodDescriptor(createDataPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<AddGranteesRequest, DataPolicy> addGranteesTransportSettings =
        HttpJsonCallSettings.<AddGranteesRequest, DataPolicy>newBuilder()
            .setMethodDescriptor(addGranteesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("data_policy", String.valueOf(request.getDataPolicy()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<RemoveGranteesRequest, DataPolicy> removeGranteesTransportSettings =
        HttpJsonCallSettings.<RemoveGranteesRequest, DataPolicy>newBuilder()
            .setMethodDescriptor(removeGranteesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("data_policy", String.valueOf(request.getDataPolicy()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateDataPolicyRequest, DataPolicy> updateDataPolicyTransportSettings =
        HttpJsonCallSettings.<UpdateDataPolicyRequest, DataPolicy>newBuilder()
            .setMethodDescriptor(updateDataPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "data_policy.name", String.valueOf(request.getDataPolicy().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteDataPolicyRequest, Empty> deleteDataPolicyTransportSettings =
        HttpJsonCallSettings.<DeleteDataPolicyRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDataPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetDataPolicyRequest, DataPolicy> getDataPolicyTransportSettings =
        HttpJsonCallSettings.<GetDataPolicyRequest, DataPolicy>newBuilder()
            .setMethodDescriptor(getDataPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListDataPoliciesRequest, ListDataPoliciesResponse>
        listDataPoliciesTransportSettings =
            HttpJsonCallSettings.<ListDataPoliciesRequest, ListDataPoliciesResponse>newBuilder()
                .setMethodDescriptor(listDataPoliciesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .build();

    this.createDataPolicyCallable =
        callableFactory.createUnaryCallable(
            createDataPolicyTransportSettings, settings.createDataPolicySettings(), clientContext);
    this.addGranteesCallable =
        callableFactory.createUnaryCallable(
            addGranteesTransportSettings, settings.addGranteesSettings(), clientContext);
    this.removeGranteesCallable =
        callableFactory.createUnaryCallable(
            removeGranteesTransportSettings, settings.removeGranteesSettings(), clientContext);
    this.updateDataPolicyCallable =
        callableFactory.createUnaryCallable(
            updateDataPolicyTransportSettings, settings.updateDataPolicySettings(), clientContext);
    this.deleteDataPolicyCallable =
        callableFactory.createUnaryCallable(
            deleteDataPolicyTransportSettings, settings.deleteDataPolicySettings(), clientContext);
    this.getDataPolicyCallable =
        callableFactory.createUnaryCallable(
            getDataPolicyTransportSettings, settings.getDataPolicySettings(), clientContext);
    this.listDataPoliciesCallable =
        callableFactory.createUnaryCallable(
            listDataPoliciesTransportSettings, settings.listDataPoliciesSettings(), clientContext);
    this.listDataPoliciesPagedCallable =
        callableFactory.createPagedCallable(
            listDataPoliciesTransportSettings, settings.listDataPoliciesSettings(), clientContext);
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
    methodDescriptors.add(createDataPolicyMethodDescriptor);
    methodDescriptors.add(addGranteesMethodDescriptor);
    methodDescriptors.add(removeGranteesMethodDescriptor);
    methodDescriptors.add(updateDataPolicyMethodDescriptor);
    methodDescriptors.add(deleteDataPolicyMethodDescriptor);
    methodDescriptors.add(getDataPolicyMethodDescriptor);
    methodDescriptors.add(listDataPoliciesMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateDataPolicyRequest, DataPolicy> createDataPolicyCallable() {
    return createDataPolicyCallable;
  }

  @Override
  public UnaryCallable<AddGranteesRequest, DataPolicy> addGranteesCallable() {
    return addGranteesCallable;
  }

  @Override
  public UnaryCallable<RemoveGranteesRequest, DataPolicy> removeGranteesCallable() {
    return removeGranteesCallable;
  }

  @Override
  public UnaryCallable<UpdateDataPolicyRequest, DataPolicy> updateDataPolicyCallable() {
    return updateDataPolicyCallable;
  }

  @Override
  public UnaryCallable<DeleteDataPolicyRequest, Empty> deleteDataPolicyCallable() {
    return deleteDataPolicyCallable;
  }

  @Override
  public UnaryCallable<GetDataPolicyRequest, DataPolicy> getDataPolicyCallable() {
    return getDataPolicyCallable;
  }

  @Override
  public UnaryCallable<ListDataPoliciesRequest, ListDataPoliciesResponse>
      listDataPoliciesCallable() {
    return listDataPoliciesCallable;
  }

  @Override
  public UnaryCallable<ListDataPoliciesRequest, ListDataPoliciesPagedResponse>
      listDataPoliciesPagedCallable() {
    return listDataPoliciesPagedCallable;
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
