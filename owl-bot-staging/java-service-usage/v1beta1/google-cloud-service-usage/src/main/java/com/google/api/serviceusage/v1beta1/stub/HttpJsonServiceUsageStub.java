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

package com.google.api.serviceusage.v1beta1.stub;

import static com.google.api.serviceusage.v1beta1.ServiceUsageClient.ListAdminOverridesPagedResponse;
import static com.google.api.serviceusage.v1beta1.ServiceUsageClient.ListConsumerOverridesPagedResponse;
import static com.google.api.serviceusage.v1beta1.ServiceUsageClient.ListConsumerQuotaMetricsPagedResponse;
import static com.google.api.serviceusage.v1beta1.ServiceUsageClient.ListServicesPagedResponse;

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
import com.google.api.serviceusage.v1beta1.BatchEnableServicesRequest;
import com.google.api.serviceusage.v1beta1.ConsumerQuotaLimit;
import com.google.api.serviceusage.v1beta1.ConsumerQuotaMetric;
import com.google.api.serviceusage.v1beta1.CreateAdminOverrideRequest;
import com.google.api.serviceusage.v1beta1.CreateConsumerOverrideRequest;
import com.google.api.serviceusage.v1beta1.DeleteAdminOverrideRequest;
import com.google.api.serviceusage.v1beta1.DeleteConsumerOverrideRequest;
import com.google.api.serviceusage.v1beta1.DisableServiceRequest;
import com.google.api.serviceusage.v1beta1.EnableServiceRequest;
import com.google.api.serviceusage.v1beta1.GenerateServiceIdentityRequest;
import com.google.api.serviceusage.v1beta1.GetConsumerQuotaLimitRequest;
import com.google.api.serviceusage.v1beta1.GetConsumerQuotaMetricRequest;
import com.google.api.serviceusage.v1beta1.GetServiceRequest;
import com.google.api.serviceusage.v1beta1.ImportAdminOverridesMetadata;
import com.google.api.serviceusage.v1beta1.ImportAdminOverridesRequest;
import com.google.api.serviceusage.v1beta1.ImportAdminOverridesResponse;
import com.google.api.serviceusage.v1beta1.ImportConsumerOverridesMetadata;
import com.google.api.serviceusage.v1beta1.ImportConsumerOverridesRequest;
import com.google.api.serviceusage.v1beta1.ImportConsumerOverridesResponse;
import com.google.api.serviceusage.v1beta1.ListAdminOverridesRequest;
import com.google.api.serviceusage.v1beta1.ListAdminOverridesResponse;
import com.google.api.serviceusage.v1beta1.ListConsumerOverridesRequest;
import com.google.api.serviceusage.v1beta1.ListConsumerOverridesResponse;
import com.google.api.serviceusage.v1beta1.ListConsumerQuotaMetricsRequest;
import com.google.api.serviceusage.v1beta1.ListConsumerQuotaMetricsResponse;
import com.google.api.serviceusage.v1beta1.ListServicesRequest;
import com.google.api.serviceusage.v1beta1.ListServicesResponse;
import com.google.api.serviceusage.v1beta1.OperationMetadata;
import com.google.api.serviceusage.v1beta1.QuotaOverride;
import com.google.api.serviceusage.v1beta1.Service;
import com.google.api.serviceusage.v1beta1.ServiceIdentity;
import com.google.api.serviceusage.v1beta1.UpdateAdminOverrideRequest;
import com.google.api.serviceusage.v1beta1.UpdateConsumerOverrideRequest;
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
 * REST stub implementation for the ServiceUsage service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonServiceUsageStub extends ServiceUsageStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(ServiceIdentity.getDescriptor())
          .add(ImportConsumerOverridesResponse.getDescriptor())
          .add(ImportAdminOverridesResponse.getDescriptor())
          .add(QuotaOverride.getDescriptor())
          .add(ImportAdminOverridesMetadata.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(ImportConsumerOverridesMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<EnableServiceRequest, Operation>
      enableServiceMethodDescriptor =
          ApiMethodDescriptor.<EnableServiceRequest, Operation>newBuilder()
              .setFullMethodName("google.api.serviceusage.v1beta1.ServiceUsage/EnableService")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<EnableServiceRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=*/*/services/*}:enable",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<EnableServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<EnableServiceRequest> serializer =
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
                  (EnableServiceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DisableServiceRequest, Operation>
      disableServiceMethodDescriptor =
          ApiMethodDescriptor.<DisableServiceRequest, Operation>newBuilder()
              .setFullMethodName("google.api.serviceusage.v1beta1.ServiceUsage/DisableService")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DisableServiceRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=*/*/services/*}:disable",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DisableServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DisableServiceRequest> serializer =
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
                  (DisableServiceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetServiceRequest, Service> getServiceMethodDescriptor =
      ApiMethodDescriptor.<GetServiceRequest, Service>newBuilder()
          .setFullMethodName("google.api.serviceusage.v1beta1.ServiceUsage/GetService")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetServiceRequest>newBuilder()
                  .setPath(
                      "/v1beta1/{name=*/*/services/*}",
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

  private static final ApiMethodDescriptor<ListServicesRequest, ListServicesResponse>
      listServicesMethodDescriptor =
          ApiMethodDescriptor.<ListServicesRequest, ListServicesResponse>newBuilder()
              .setFullMethodName("google.api.serviceusage.v1beta1.ServiceUsage/ListServices")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListServicesRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=*/*}/services",
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

  private static final ApiMethodDescriptor<BatchEnableServicesRequest, Operation>
      batchEnableServicesMethodDescriptor =
          ApiMethodDescriptor.<BatchEnableServicesRequest, Operation>newBuilder()
              .setFullMethodName("google.api.serviceusage.v1beta1.ServiceUsage/BatchEnableServices")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchEnableServicesRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=*/*}/services:batchEnable",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchEnableServicesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchEnableServicesRequest> serializer =
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
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (BatchEnableServicesRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          ListConsumerQuotaMetricsRequest, ListConsumerQuotaMetricsResponse>
      listConsumerQuotaMetricsMethodDescriptor =
          ApiMethodDescriptor
              .<ListConsumerQuotaMetricsRequest, ListConsumerQuotaMetricsResponse>newBuilder()
              .setFullMethodName(
                  "google.api.serviceusage.v1beta1.ServiceUsage/ListConsumerQuotaMetrics")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListConsumerQuotaMetricsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=*/*/services/*}/consumerQuotaMetrics",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListConsumerQuotaMetricsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListConsumerQuotaMetricsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "view", request.getViewValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListConsumerQuotaMetricsResponse>newBuilder()
                      .setDefaultInstance(ListConsumerQuotaMetricsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetConsumerQuotaMetricRequest, ConsumerQuotaMetric>
      getConsumerQuotaMetricMethodDescriptor =
          ApiMethodDescriptor.<GetConsumerQuotaMetricRequest, ConsumerQuotaMetric>newBuilder()
              .setFullMethodName(
                  "google.api.serviceusage.v1beta1.ServiceUsage/GetConsumerQuotaMetric")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetConsumerQuotaMetricRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=*/*/services/*/consumerQuotaMetrics/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetConsumerQuotaMetricRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetConsumerQuotaMetricRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "view", request.getViewValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ConsumerQuotaMetric>newBuilder()
                      .setDefaultInstance(ConsumerQuotaMetric.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetConsumerQuotaLimitRequest, ConsumerQuotaLimit>
      getConsumerQuotaLimitMethodDescriptor =
          ApiMethodDescriptor.<GetConsumerQuotaLimitRequest, ConsumerQuotaLimit>newBuilder()
              .setFullMethodName(
                  "google.api.serviceusage.v1beta1.ServiceUsage/GetConsumerQuotaLimit")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetConsumerQuotaLimitRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=*/*/services/*/consumerQuotaMetrics/*/limits/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetConsumerQuotaLimitRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetConsumerQuotaLimitRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "view", request.getViewValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ConsumerQuotaLimit>newBuilder()
                      .setDefaultInstance(ConsumerQuotaLimit.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateAdminOverrideRequest, Operation>
      createAdminOverrideMethodDescriptor =
          ApiMethodDescriptor.<CreateAdminOverrideRequest, Operation>newBuilder()
              .setFullMethodName("google.api.serviceusage.v1beta1.ServiceUsage/CreateAdminOverride")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateAdminOverrideRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=*/*/services/*/consumerQuotaMetrics/*/limits/*}/adminOverrides",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAdminOverrideRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAdminOverrideRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
                            serializer.putQueryParam(
                                fields, "forceOnly", request.getForceOnlyList());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("override", request.getOverride(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateAdminOverrideRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateAdminOverrideRequest, Operation>
      updateAdminOverrideMethodDescriptor =
          ApiMethodDescriptor.<UpdateAdminOverrideRequest, Operation>newBuilder()
              .setFullMethodName("google.api.serviceusage.v1beta1.ServiceUsage/UpdateAdminOverride")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateAdminOverrideRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=*/*/services/*/consumerQuotaMetrics/*/limits/*/adminOverrides/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAdminOverrideRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAdminOverrideRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
                            serializer.putQueryParam(
                                fields, "forceOnly", request.getForceOnlyList());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("override", request.getOverride(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateAdminOverrideRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteAdminOverrideRequest, Operation>
      deleteAdminOverrideMethodDescriptor =
          ApiMethodDescriptor.<DeleteAdminOverrideRequest, Operation>newBuilder()
              .setFullMethodName("google.api.serviceusage.v1beta1.ServiceUsage/DeleteAdminOverride")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteAdminOverrideRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=*/*/services/*/consumerQuotaMetrics/*/limits/*/adminOverrides/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAdminOverrideRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAdminOverrideRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
                            serializer.putQueryParam(
                                fields, "forceOnly", request.getForceOnlyList());
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
                  (DeleteAdminOverrideRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListAdminOverridesRequest, ListAdminOverridesResponse>
      listAdminOverridesMethodDescriptor =
          ApiMethodDescriptor.<ListAdminOverridesRequest, ListAdminOverridesResponse>newBuilder()
              .setFullMethodName("google.api.serviceusage.v1beta1.ServiceUsage/ListAdminOverrides")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAdminOverridesRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=*/*/services/*/consumerQuotaMetrics/*/limits/*}/adminOverrides",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAdminOverridesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAdminOverridesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAdminOverridesResponse>newBuilder()
                      .setDefaultInstance(ListAdminOverridesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ImportAdminOverridesRequest, Operation>
      importAdminOverridesMethodDescriptor =
          ApiMethodDescriptor.<ImportAdminOverridesRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.api.serviceusage.v1beta1.ServiceUsage/ImportAdminOverrides")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ImportAdminOverridesRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=*/*/services/*}/consumerQuotaMetrics:importAdminOverrides",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ImportAdminOverridesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ImportAdminOverridesRequest> serializer =
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
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ImportAdminOverridesRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateConsumerOverrideRequest, Operation>
      createConsumerOverrideMethodDescriptor =
          ApiMethodDescriptor.<CreateConsumerOverrideRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.api.serviceusage.v1beta1.ServiceUsage/CreateConsumerOverride")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateConsumerOverrideRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=*/*/services/*/consumerQuotaMetrics/*/limits/*}/consumerOverrides",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateConsumerOverrideRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateConsumerOverrideRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
                            serializer.putQueryParam(
                                fields, "forceOnly", request.getForceOnlyList());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("override", request.getOverride(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateConsumerOverrideRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateConsumerOverrideRequest, Operation>
      updateConsumerOverrideMethodDescriptor =
          ApiMethodDescriptor.<UpdateConsumerOverrideRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.api.serviceusage.v1beta1.ServiceUsage/UpdateConsumerOverride")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateConsumerOverrideRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=*/*/services/*/consumerQuotaMetrics/*/limits/*/consumerOverrides/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateConsumerOverrideRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateConsumerOverrideRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
                            serializer.putQueryParam(
                                fields, "forceOnly", request.getForceOnlyList());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("override", request.getOverride(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateConsumerOverrideRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteConsumerOverrideRequest, Operation>
      deleteConsumerOverrideMethodDescriptor =
          ApiMethodDescriptor.<DeleteConsumerOverrideRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.api.serviceusage.v1beta1.ServiceUsage/DeleteConsumerOverride")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteConsumerOverrideRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=*/*/services/*/consumerQuotaMetrics/*/limits/*/consumerOverrides/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteConsumerOverrideRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteConsumerOverrideRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
                            serializer.putQueryParam(
                                fields, "forceOnly", request.getForceOnlyList());
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
                  (DeleteConsumerOverrideRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          ListConsumerOverridesRequest, ListConsumerOverridesResponse>
      listConsumerOverridesMethodDescriptor =
          ApiMethodDescriptor
              .<ListConsumerOverridesRequest, ListConsumerOverridesResponse>newBuilder()
              .setFullMethodName(
                  "google.api.serviceusage.v1beta1.ServiceUsage/ListConsumerOverrides")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListConsumerOverridesRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=*/*/services/*/consumerQuotaMetrics/*/limits/*}/consumerOverrides",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListConsumerOverridesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListConsumerOverridesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListConsumerOverridesResponse>newBuilder()
                      .setDefaultInstance(ListConsumerOverridesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ImportConsumerOverridesRequest, Operation>
      importConsumerOverridesMethodDescriptor =
          ApiMethodDescriptor.<ImportConsumerOverridesRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.api.serviceusage.v1beta1.ServiceUsage/ImportConsumerOverrides")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ImportConsumerOverridesRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=*/*/services/*}/consumerQuotaMetrics:importConsumerOverrides",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ImportConsumerOverridesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ImportConsumerOverridesRequest> serializer =
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
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ImportConsumerOverridesRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GenerateServiceIdentityRequest, Operation>
      generateServiceIdentityMethodDescriptor =
          ApiMethodDescriptor.<GenerateServiceIdentityRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.api.serviceusage.v1beta1.ServiceUsage/GenerateServiceIdentity")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GenerateServiceIdentityRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=*/*/services/*}:generateServiceIdentity",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateServiceIdentityRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateServiceIdentityRequest> serializer =
                                ProtoRestSerializer.create();
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
                  (GenerateServiceIdentityRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private final UnaryCallable<EnableServiceRequest, Operation> enableServiceCallable;
  private final OperationCallable<EnableServiceRequest, Empty, OperationMetadata>
      enableServiceOperationCallable;
  private final UnaryCallable<DisableServiceRequest, Operation> disableServiceCallable;
  private final OperationCallable<DisableServiceRequest, Empty, OperationMetadata>
      disableServiceOperationCallable;
  private final UnaryCallable<GetServiceRequest, Service> getServiceCallable;
  private final UnaryCallable<ListServicesRequest, ListServicesResponse> listServicesCallable;
  private final UnaryCallable<ListServicesRequest, ListServicesPagedResponse>
      listServicesPagedCallable;
  private final UnaryCallable<BatchEnableServicesRequest, Operation> batchEnableServicesCallable;
  private final OperationCallable<BatchEnableServicesRequest, Empty, OperationMetadata>
      batchEnableServicesOperationCallable;
  private final UnaryCallable<ListConsumerQuotaMetricsRequest, ListConsumerQuotaMetricsResponse>
      listConsumerQuotaMetricsCallable;
  private final UnaryCallable<
          ListConsumerQuotaMetricsRequest, ListConsumerQuotaMetricsPagedResponse>
      listConsumerQuotaMetricsPagedCallable;
  private final UnaryCallable<GetConsumerQuotaMetricRequest, ConsumerQuotaMetric>
      getConsumerQuotaMetricCallable;
  private final UnaryCallable<GetConsumerQuotaLimitRequest, ConsumerQuotaLimit>
      getConsumerQuotaLimitCallable;
  private final UnaryCallable<CreateAdminOverrideRequest, Operation> createAdminOverrideCallable;
  private final OperationCallable<CreateAdminOverrideRequest, QuotaOverride, OperationMetadata>
      createAdminOverrideOperationCallable;
  private final UnaryCallable<UpdateAdminOverrideRequest, Operation> updateAdminOverrideCallable;
  private final OperationCallable<UpdateAdminOverrideRequest, QuotaOverride, OperationMetadata>
      updateAdminOverrideOperationCallable;
  private final UnaryCallable<DeleteAdminOverrideRequest, Operation> deleteAdminOverrideCallable;
  private final OperationCallable<DeleteAdminOverrideRequest, Empty, OperationMetadata>
      deleteAdminOverrideOperationCallable;
  private final UnaryCallable<ListAdminOverridesRequest, ListAdminOverridesResponse>
      listAdminOverridesCallable;
  private final UnaryCallable<ListAdminOverridesRequest, ListAdminOverridesPagedResponse>
      listAdminOverridesPagedCallable;
  private final UnaryCallable<ImportAdminOverridesRequest, Operation> importAdminOverridesCallable;
  private final OperationCallable<
          ImportAdminOverridesRequest, ImportAdminOverridesResponse, ImportAdminOverridesMetadata>
      importAdminOverridesOperationCallable;
  private final UnaryCallable<CreateConsumerOverrideRequest, Operation>
      createConsumerOverrideCallable;
  private final OperationCallable<CreateConsumerOverrideRequest, QuotaOverride, OperationMetadata>
      createConsumerOverrideOperationCallable;
  private final UnaryCallable<UpdateConsumerOverrideRequest, Operation>
      updateConsumerOverrideCallable;
  private final OperationCallable<UpdateConsumerOverrideRequest, QuotaOverride, OperationMetadata>
      updateConsumerOverrideOperationCallable;
  private final UnaryCallable<DeleteConsumerOverrideRequest, Operation>
      deleteConsumerOverrideCallable;
  private final OperationCallable<DeleteConsumerOverrideRequest, Empty, OperationMetadata>
      deleteConsumerOverrideOperationCallable;
  private final UnaryCallable<ListConsumerOverridesRequest, ListConsumerOverridesResponse>
      listConsumerOverridesCallable;
  private final UnaryCallable<ListConsumerOverridesRequest, ListConsumerOverridesPagedResponse>
      listConsumerOverridesPagedCallable;
  private final UnaryCallable<ImportConsumerOverridesRequest, Operation>
      importConsumerOverridesCallable;
  private final OperationCallable<
          ImportConsumerOverridesRequest,
          ImportConsumerOverridesResponse,
          ImportConsumerOverridesMetadata>
      importConsumerOverridesOperationCallable;
  private final UnaryCallable<GenerateServiceIdentityRequest, Operation>
      generateServiceIdentityCallable;
  private final OperationCallable<GenerateServiceIdentityRequest, ServiceIdentity, Empty>
      generateServiceIdentityOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonServiceUsageStub create(ServiceUsageStubSettings settings)
      throws IOException {
    return new HttpJsonServiceUsageStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonServiceUsageStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonServiceUsageStub(
        ServiceUsageStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonServiceUsageStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonServiceUsageStub(
        ServiceUsageStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonServiceUsageStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonServiceUsageStub(ServiceUsageStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonServiceUsageCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonServiceUsageStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonServiceUsageStub(
      ServiceUsageStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<EnableServiceRequest, Operation> enableServiceTransportSettings =
        HttpJsonCallSettings.<EnableServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(enableServiceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DisableServiceRequest, Operation> disableServiceTransportSettings =
        HttpJsonCallSettings.<DisableServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(disableServiceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetServiceRequest, Service> getServiceTransportSettings =
        HttpJsonCallSettings.<GetServiceRequest, Service>newBuilder()
            .setMethodDescriptor(getServiceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListServicesRequest, ListServicesResponse> listServicesTransportSettings =
        HttpJsonCallSettings.<ListServicesRequest, ListServicesResponse>newBuilder()
            .setMethodDescriptor(listServicesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<BatchEnableServicesRequest, Operation>
        batchEnableServicesTransportSettings =
            HttpJsonCallSettings.<BatchEnableServicesRequest, Operation>newBuilder()
                .setMethodDescriptor(batchEnableServicesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListConsumerQuotaMetricsRequest, ListConsumerQuotaMetricsResponse>
        listConsumerQuotaMetricsTransportSettings =
            HttpJsonCallSettings
                .<ListConsumerQuotaMetricsRequest, ListConsumerQuotaMetricsResponse>newBuilder()
                .setMethodDescriptor(listConsumerQuotaMetricsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetConsumerQuotaMetricRequest, ConsumerQuotaMetric>
        getConsumerQuotaMetricTransportSettings =
            HttpJsonCallSettings.<GetConsumerQuotaMetricRequest, ConsumerQuotaMetric>newBuilder()
                .setMethodDescriptor(getConsumerQuotaMetricMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetConsumerQuotaLimitRequest, ConsumerQuotaLimit>
        getConsumerQuotaLimitTransportSettings =
            HttpJsonCallSettings.<GetConsumerQuotaLimitRequest, ConsumerQuotaLimit>newBuilder()
                .setMethodDescriptor(getConsumerQuotaLimitMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateAdminOverrideRequest, Operation>
        createAdminOverrideTransportSettings =
            HttpJsonCallSettings.<CreateAdminOverrideRequest, Operation>newBuilder()
                .setMethodDescriptor(createAdminOverrideMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateAdminOverrideRequest, Operation>
        updateAdminOverrideTransportSettings =
            HttpJsonCallSettings.<UpdateAdminOverrideRequest, Operation>newBuilder()
                .setMethodDescriptor(updateAdminOverrideMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteAdminOverrideRequest, Operation>
        deleteAdminOverrideTransportSettings =
            HttpJsonCallSettings.<DeleteAdminOverrideRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteAdminOverrideMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListAdminOverridesRequest, ListAdminOverridesResponse>
        listAdminOverridesTransportSettings =
            HttpJsonCallSettings.<ListAdminOverridesRequest, ListAdminOverridesResponse>newBuilder()
                .setMethodDescriptor(listAdminOverridesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ImportAdminOverridesRequest, Operation>
        importAdminOverridesTransportSettings =
            HttpJsonCallSettings.<ImportAdminOverridesRequest, Operation>newBuilder()
                .setMethodDescriptor(importAdminOverridesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateConsumerOverrideRequest, Operation>
        createConsumerOverrideTransportSettings =
            HttpJsonCallSettings.<CreateConsumerOverrideRequest, Operation>newBuilder()
                .setMethodDescriptor(createConsumerOverrideMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateConsumerOverrideRequest, Operation>
        updateConsumerOverrideTransportSettings =
            HttpJsonCallSettings.<UpdateConsumerOverrideRequest, Operation>newBuilder()
                .setMethodDescriptor(updateConsumerOverrideMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteConsumerOverrideRequest, Operation>
        deleteConsumerOverrideTransportSettings =
            HttpJsonCallSettings.<DeleteConsumerOverrideRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteConsumerOverrideMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListConsumerOverridesRequest, ListConsumerOverridesResponse>
        listConsumerOverridesTransportSettings =
            HttpJsonCallSettings
                .<ListConsumerOverridesRequest, ListConsumerOverridesResponse>newBuilder()
                .setMethodDescriptor(listConsumerOverridesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ImportConsumerOverridesRequest, Operation>
        importConsumerOverridesTransportSettings =
            HttpJsonCallSettings.<ImportConsumerOverridesRequest, Operation>newBuilder()
                .setMethodDescriptor(importConsumerOverridesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GenerateServiceIdentityRequest, Operation>
        generateServiceIdentityTransportSettings =
            HttpJsonCallSettings.<GenerateServiceIdentityRequest, Operation>newBuilder()
                .setMethodDescriptor(generateServiceIdentityMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.enableServiceCallable =
        callableFactory.createUnaryCallable(
            enableServiceTransportSettings, settings.enableServiceSettings(), clientContext);
    this.enableServiceOperationCallable =
        callableFactory.createOperationCallable(
            enableServiceTransportSettings,
            settings.enableServiceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.disableServiceCallable =
        callableFactory.createUnaryCallable(
            disableServiceTransportSettings, settings.disableServiceSettings(), clientContext);
    this.disableServiceOperationCallable =
        callableFactory.createOperationCallable(
            disableServiceTransportSettings,
            settings.disableServiceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getServiceCallable =
        callableFactory.createUnaryCallable(
            getServiceTransportSettings, settings.getServiceSettings(), clientContext);
    this.listServicesCallable =
        callableFactory.createUnaryCallable(
            listServicesTransportSettings, settings.listServicesSettings(), clientContext);
    this.listServicesPagedCallable =
        callableFactory.createPagedCallable(
            listServicesTransportSettings, settings.listServicesSettings(), clientContext);
    this.batchEnableServicesCallable =
        callableFactory.createUnaryCallable(
            batchEnableServicesTransportSettings,
            settings.batchEnableServicesSettings(),
            clientContext);
    this.batchEnableServicesOperationCallable =
        callableFactory.createOperationCallable(
            batchEnableServicesTransportSettings,
            settings.batchEnableServicesOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listConsumerQuotaMetricsCallable =
        callableFactory.createUnaryCallable(
            listConsumerQuotaMetricsTransportSettings,
            settings.listConsumerQuotaMetricsSettings(),
            clientContext);
    this.listConsumerQuotaMetricsPagedCallable =
        callableFactory.createPagedCallable(
            listConsumerQuotaMetricsTransportSettings,
            settings.listConsumerQuotaMetricsSettings(),
            clientContext);
    this.getConsumerQuotaMetricCallable =
        callableFactory.createUnaryCallable(
            getConsumerQuotaMetricTransportSettings,
            settings.getConsumerQuotaMetricSettings(),
            clientContext);
    this.getConsumerQuotaLimitCallable =
        callableFactory.createUnaryCallable(
            getConsumerQuotaLimitTransportSettings,
            settings.getConsumerQuotaLimitSettings(),
            clientContext);
    this.createAdminOverrideCallable =
        callableFactory.createUnaryCallable(
            createAdminOverrideTransportSettings,
            settings.createAdminOverrideSettings(),
            clientContext);
    this.createAdminOverrideOperationCallable =
        callableFactory.createOperationCallable(
            createAdminOverrideTransportSettings,
            settings.createAdminOverrideOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateAdminOverrideCallable =
        callableFactory.createUnaryCallable(
            updateAdminOverrideTransportSettings,
            settings.updateAdminOverrideSettings(),
            clientContext);
    this.updateAdminOverrideOperationCallable =
        callableFactory.createOperationCallable(
            updateAdminOverrideTransportSettings,
            settings.updateAdminOverrideOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteAdminOverrideCallable =
        callableFactory.createUnaryCallable(
            deleteAdminOverrideTransportSettings,
            settings.deleteAdminOverrideSettings(),
            clientContext);
    this.deleteAdminOverrideOperationCallable =
        callableFactory.createOperationCallable(
            deleteAdminOverrideTransportSettings,
            settings.deleteAdminOverrideOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listAdminOverridesCallable =
        callableFactory.createUnaryCallable(
            listAdminOverridesTransportSettings,
            settings.listAdminOverridesSettings(),
            clientContext);
    this.listAdminOverridesPagedCallable =
        callableFactory.createPagedCallable(
            listAdminOverridesTransportSettings,
            settings.listAdminOverridesSettings(),
            clientContext);
    this.importAdminOverridesCallable =
        callableFactory.createUnaryCallable(
            importAdminOverridesTransportSettings,
            settings.importAdminOverridesSettings(),
            clientContext);
    this.importAdminOverridesOperationCallable =
        callableFactory.createOperationCallable(
            importAdminOverridesTransportSettings,
            settings.importAdminOverridesOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.createConsumerOverrideCallable =
        callableFactory.createUnaryCallable(
            createConsumerOverrideTransportSettings,
            settings.createConsumerOverrideSettings(),
            clientContext);
    this.createConsumerOverrideOperationCallable =
        callableFactory.createOperationCallable(
            createConsumerOverrideTransportSettings,
            settings.createConsumerOverrideOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateConsumerOverrideCallable =
        callableFactory.createUnaryCallable(
            updateConsumerOverrideTransportSettings,
            settings.updateConsumerOverrideSettings(),
            clientContext);
    this.updateConsumerOverrideOperationCallable =
        callableFactory.createOperationCallable(
            updateConsumerOverrideTransportSettings,
            settings.updateConsumerOverrideOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteConsumerOverrideCallable =
        callableFactory.createUnaryCallable(
            deleteConsumerOverrideTransportSettings,
            settings.deleteConsumerOverrideSettings(),
            clientContext);
    this.deleteConsumerOverrideOperationCallable =
        callableFactory.createOperationCallable(
            deleteConsumerOverrideTransportSettings,
            settings.deleteConsumerOverrideOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listConsumerOverridesCallable =
        callableFactory.createUnaryCallable(
            listConsumerOverridesTransportSettings,
            settings.listConsumerOverridesSettings(),
            clientContext);
    this.listConsumerOverridesPagedCallable =
        callableFactory.createPagedCallable(
            listConsumerOverridesTransportSettings,
            settings.listConsumerOverridesSettings(),
            clientContext);
    this.importConsumerOverridesCallable =
        callableFactory.createUnaryCallable(
            importConsumerOverridesTransportSettings,
            settings.importConsumerOverridesSettings(),
            clientContext);
    this.importConsumerOverridesOperationCallable =
        callableFactory.createOperationCallable(
            importConsumerOverridesTransportSettings,
            settings.importConsumerOverridesOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.generateServiceIdentityCallable =
        callableFactory.createUnaryCallable(
            generateServiceIdentityTransportSettings,
            settings.generateServiceIdentitySettings(),
            clientContext);
    this.generateServiceIdentityOperationCallable =
        callableFactory.createOperationCallable(
            generateServiceIdentityTransportSettings,
            settings.generateServiceIdentityOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(enableServiceMethodDescriptor);
    methodDescriptors.add(disableServiceMethodDescriptor);
    methodDescriptors.add(getServiceMethodDescriptor);
    methodDescriptors.add(listServicesMethodDescriptor);
    methodDescriptors.add(batchEnableServicesMethodDescriptor);
    methodDescriptors.add(listConsumerQuotaMetricsMethodDescriptor);
    methodDescriptors.add(getConsumerQuotaMetricMethodDescriptor);
    methodDescriptors.add(getConsumerQuotaLimitMethodDescriptor);
    methodDescriptors.add(createAdminOverrideMethodDescriptor);
    methodDescriptors.add(updateAdminOverrideMethodDescriptor);
    methodDescriptors.add(deleteAdminOverrideMethodDescriptor);
    methodDescriptors.add(listAdminOverridesMethodDescriptor);
    methodDescriptors.add(importAdminOverridesMethodDescriptor);
    methodDescriptors.add(createConsumerOverrideMethodDescriptor);
    methodDescriptors.add(updateConsumerOverrideMethodDescriptor);
    methodDescriptors.add(deleteConsumerOverrideMethodDescriptor);
    methodDescriptors.add(listConsumerOverridesMethodDescriptor);
    methodDescriptors.add(importConsumerOverridesMethodDescriptor);
    methodDescriptors.add(generateServiceIdentityMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<EnableServiceRequest, Operation> enableServiceCallable() {
    return enableServiceCallable;
  }

  @Override
  public OperationCallable<EnableServiceRequest, Empty, OperationMetadata>
      enableServiceOperationCallable() {
    return enableServiceOperationCallable;
  }

  @Override
  public UnaryCallable<DisableServiceRequest, Operation> disableServiceCallable() {
    return disableServiceCallable;
  }

  @Override
  public OperationCallable<DisableServiceRequest, Empty, OperationMetadata>
      disableServiceOperationCallable() {
    return disableServiceOperationCallable;
  }

  @Override
  public UnaryCallable<GetServiceRequest, Service> getServiceCallable() {
    return getServiceCallable;
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
  public UnaryCallable<BatchEnableServicesRequest, Operation> batchEnableServicesCallable() {
    return batchEnableServicesCallable;
  }

  @Override
  public OperationCallable<BatchEnableServicesRequest, Empty, OperationMetadata>
      batchEnableServicesOperationCallable() {
    return batchEnableServicesOperationCallable;
  }

  @Override
  public UnaryCallable<ListConsumerQuotaMetricsRequest, ListConsumerQuotaMetricsResponse>
      listConsumerQuotaMetricsCallable() {
    return listConsumerQuotaMetricsCallable;
  }

  @Override
  public UnaryCallable<ListConsumerQuotaMetricsRequest, ListConsumerQuotaMetricsPagedResponse>
      listConsumerQuotaMetricsPagedCallable() {
    return listConsumerQuotaMetricsPagedCallable;
  }

  @Override
  public UnaryCallable<GetConsumerQuotaMetricRequest, ConsumerQuotaMetric>
      getConsumerQuotaMetricCallable() {
    return getConsumerQuotaMetricCallable;
  }

  @Override
  public UnaryCallable<GetConsumerQuotaLimitRequest, ConsumerQuotaLimit>
      getConsumerQuotaLimitCallable() {
    return getConsumerQuotaLimitCallable;
  }

  @Override
  public UnaryCallable<CreateAdminOverrideRequest, Operation> createAdminOverrideCallable() {
    return createAdminOverrideCallable;
  }

  @Override
  public OperationCallable<CreateAdminOverrideRequest, QuotaOverride, OperationMetadata>
      createAdminOverrideOperationCallable() {
    return createAdminOverrideOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateAdminOverrideRequest, Operation> updateAdminOverrideCallable() {
    return updateAdminOverrideCallable;
  }

  @Override
  public OperationCallable<UpdateAdminOverrideRequest, QuotaOverride, OperationMetadata>
      updateAdminOverrideOperationCallable() {
    return updateAdminOverrideOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteAdminOverrideRequest, Operation> deleteAdminOverrideCallable() {
    return deleteAdminOverrideCallable;
  }

  @Override
  public OperationCallable<DeleteAdminOverrideRequest, Empty, OperationMetadata>
      deleteAdminOverrideOperationCallable() {
    return deleteAdminOverrideOperationCallable;
  }

  @Override
  public UnaryCallable<ListAdminOverridesRequest, ListAdminOverridesResponse>
      listAdminOverridesCallable() {
    return listAdminOverridesCallable;
  }

  @Override
  public UnaryCallable<ListAdminOverridesRequest, ListAdminOverridesPagedResponse>
      listAdminOverridesPagedCallable() {
    return listAdminOverridesPagedCallable;
  }

  @Override
  public UnaryCallable<ImportAdminOverridesRequest, Operation> importAdminOverridesCallable() {
    return importAdminOverridesCallable;
  }

  @Override
  public OperationCallable<
          ImportAdminOverridesRequest, ImportAdminOverridesResponse, ImportAdminOverridesMetadata>
      importAdminOverridesOperationCallable() {
    return importAdminOverridesOperationCallable;
  }

  @Override
  public UnaryCallable<CreateConsumerOverrideRequest, Operation> createConsumerOverrideCallable() {
    return createConsumerOverrideCallable;
  }

  @Override
  public OperationCallable<CreateConsumerOverrideRequest, QuotaOverride, OperationMetadata>
      createConsumerOverrideOperationCallable() {
    return createConsumerOverrideOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateConsumerOverrideRequest, Operation> updateConsumerOverrideCallable() {
    return updateConsumerOverrideCallable;
  }

  @Override
  public OperationCallable<UpdateConsumerOverrideRequest, QuotaOverride, OperationMetadata>
      updateConsumerOverrideOperationCallable() {
    return updateConsumerOverrideOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteConsumerOverrideRequest, Operation> deleteConsumerOverrideCallable() {
    return deleteConsumerOverrideCallable;
  }

  @Override
  public OperationCallable<DeleteConsumerOverrideRequest, Empty, OperationMetadata>
      deleteConsumerOverrideOperationCallable() {
    return deleteConsumerOverrideOperationCallable;
  }

  @Override
  public UnaryCallable<ListConsumerOverridesRequest, ListConsumerOverridesResponse>
      listConsumerOverridesCallable() {
    return listConsumerOverridesCallable;
  }

  @Override
  public UnaryCallable<ListConsumerOverridesRequest, ListConsumerOverridesPagedResponse>
      listConsumerOverridesPagedCallable() {
    return listConsumerOverridesPagedCallable;
  }

  @Override
  public UnaryCallable<ImportConsumerOverridesRequest, Operation>
      importConsumerOverridesCallable() {
    return importConsumerOverridesCallable;
  }

  @Override
  public OperationCallable<
          ImportConsumerOverridesRequest,
          ImportConsumerOverridesResponse,
          ImportConsumerOverridesMetadata>
      importConsumerOverridesOperationCallable() {
    return importConsumerOverridesOperationCallable;
  }

  @Override
  public UnaryCallable<GenerateServiceIdentityRequest, Operation>
      generateServiceIdentityCallable() {
    return generateServiceIdentityCallable;
  }

  @Override
  public OperationCallable<GenerateServiceIdentityRequest, ServiceIdentity, Empty>
      generateServiceIdentityOperationCallable() {
    return generateServiceIdentityOperationCallable;
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
