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

package com.google.cloud.auditmanager.v1.stub;

import static com.google.cloud.auditmanager.v1.AuditManagerClient.ListAuditReportsPagedResponse;
import static com.google.cloud.auditmanager.v1.AuditManagerClient.ListControlsPagedResponse;
import static com.google.cloud.auditmanager.v1.AuditManagerClient.ListLocationsPagedResponse;
import static com.google.cloud.auditmanager.v1.AuditManagerClient.ListResourceEnrollmentStatusesPagedResponse;

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
import com.google.cloud.auditmanager.v1.AuditReport;
import com.google.cloud.auditmanager.v1.AuditScopeReport;
import com.google.cloud.auditmanager.v1.EnrollResourceRequest;
import com.google.cloud.auditmanager.v1.Enrollment;
import com.google.cloud.auditmanager.v1.GenerateAuditReportRequest;
import com.google.cloud.auditmanager.v1.GenerateAuditScopeReportRequest;
import com.google.cloud.auditmanager.v1.GetAuditReportRequest;
import com.google.cloud.auditmanager.v1.GetResourceEnrollmentStatusRequest;
import com.google.cloud.auditmanager.v1.ListAuditReportsRequest;
import com.google.cloud.auditmanager.v1.ListAuditReportsResponse;
import com.google.cloud.auditmanager.v1.ListControlsRequest;
import com.google.cloud.auditmanager.v1.ListControlsResponse;
import com.google.cloud.auditmanager.v1.ListResourceEnrollmentStatusesRequest;
import com.google.cloud.auditmanager.v1.ListResourceEnrollmentStatusesResponse;
import com.google.cloud.auditmanager.v1.OperationMetadata;
import com.google.cloud.auditmanager.v1.ResourceEnrollmentStatus;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
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
 * REST stub implementation for the AuditManager service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonAuditManagerStub extends AuditManagerStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(OperationMetadata.getDescriptor())
          .add(AuditReport.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<EnrollResourceRequest, Enrollment>
      enrollResourceMethodDescriptor =
          ApiMethodDescriptor.<EnrollResourceRequest, Enrollment>newBuilder()
              .setFullMethodName("google.cloud.auditmanager.v1.AuditManager/EnrollResource")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<EnrollResourceRequest>newBuilder()
                      .setPath(
                          "/v1/{scope=folders/*/locations/*}:enrollResource",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<EnrollResourceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "scope", request.getScope());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{scope=projects/*/locations/*}:enrollResource",
                          "/v1/{scope=organizations/*/locations/*}:enrollResource")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<EnrollResourceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearScope().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Enrollment>newBuilder()
                      .setDefaultInstance(Enrollment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GenerateAuditScopeReportRequest, AuditScopeReport>
      generateAuditScopeReportMethodDescriptor =
          ApiMethodDescriptor.<GenerateAuditScopeReportRequest, AuditScopeReport>newBuilder()
              .setFullMethodName(
                  "google.cloud.auditmanager.v1.AuditManager/GenerateAuditScopeReport")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GenerateAuditScopeReportRequest>newBuilder()
                      .setPath(
                          "/v1/{scope=folders/*/locations/*}/auditScopeReports:generate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateAuditScopeReportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "scope", request.getScope());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{scope=projects/*/locations/*}/auditScopeReports:generate")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateAuditScopeReportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearScope().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AuditScopeReport>newBuilder()
                      .setDefaultInstance(AuditScopeReport.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GenerateAuditReportRequest, Operation>
      generateAuditReportMethodDescriptor =
          ApiMethodDescriptor.<GenerateAuditReportRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.auditmanager.v1.AuditManager/GenerateAuditReport")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GenerateAuditReportRequest>newBuilder()
                      .setPath(
                          "/v1/{scope=folders/*/locations/*}/auditReports:generate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateAuditReportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "scope", request.getScope());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{scope=projects/*/locations/*}/auditReports:generate")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateAuditReportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearScope().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (GenerateAuditReportRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListAuditReportsRequest, ListAuditReportsResponse>
      listAuditReportsMethodDescriptor =
          ApiMethodDescriptor.<ListAuditReportsRequest, ListAuditReportsResponse>newBuilder()
              .setFullMethodName("google.cloud.auditmanager.v1.AuditManager/ListAuditReports")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAuditReportsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=organizations/*/locations/*}/auditReports",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAuditReportsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=folders/*/locations/*}/auditReports",
                          "/v1/{parent=projects/*/locations/*}/auditReports")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAuditReportsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAuditReportsResponse>newBuilder()
                      .setDefaultInstance(ListAuditReportsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetAuditReportRequest, AuditReport>
      getAuditReportMethodDescriptor =
          ApiMethodDescriptor.<GetAuditReportRequest, AuditReport>newBuilder()
              .setFullMethodName("google.cloud.auditmanager.v1.AuditManager/GetAuditReport")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAuditReportRequest>newBuilder()
                      .setPath(
                          "/v1/{name=folders/*/locations/*/auditReports/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAuditReportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/{name=projects/*/locations/*/auditReports/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAuditReportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AuditReport>newBuilder()
                      .setDefaultInstance(AuditReport.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GetResourceEnrollmentStatusRequest, ResourceEnrollmentStatus>
      getResourceEnrollmentStatusMethodDescriptor =
          ApiMethodDescriptor
              .<GetResourceEnrollmentStatusRequest, ResourceEnrollmentStatus>newBuilder()
              .setFullMethodName(
                  "google.cloud.auditmanager.v1.AuditManager/GetResourceEnrollmentStatus")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetResourceEnrollmentStatusRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/resourceEnrollmentStatuses/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetResourceEnrollmentStatusRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{name=folders/*/locations/*/resourceEnrollmentStatuses/*}",
                          "/v1/{name=organizations/*/locations/*/resourceEnrollmentStatuses/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetResourceEnrollmentStatusRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ResourceEnrollmentStatus>newBuilder()
                      .setDefaultInstance(ResourceEnrollmentStatus.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListResourceEnrollmentStatusesRequest, ListResourceEnrollmentStatusesResponse>
      listResourceEnrollmentStatusesMethodDescriptor =
          ApiMethodDescriptor
              .<ListResourceEnrollmentStatusesRequest, ListResourceEnrollmentStatusesResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.auditmanager.v1.AuditManager/ListResourceEnrollmentStatuses")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListResourceEnrollmentStatusesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=organizations/*/locations/*}/resourceEnrollmentStatuses",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListResourceEnrollmentStatusesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=folders/*/locations/*}/resourceEnrollmentStatuses")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListResourceEnrollmentStatusesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListResourceEnrollmentStatusesResponse>newBuilder()
                      .setDefaultInstance(
                          ListResourceEnrollmentStatusesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListControlsRequest, ListControlsResponse>
      listControlsMethodDescriptor =
          ApiMethodDescriptor.<ListControlsRequest, ListControlsResponse>newBuilder()
              .setFullMethodName("google.cloud.auditmanager.v1.AuditManager/ListControls")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListControlsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=organizations/*/locations/*/standards/*}/controls",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListControlsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=folders/*/locations/*/standards/*}/controls",
                          "/v1/{parent=projects/*/locations/*/standards/*}/controls")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListControlsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListControlsResponse>newBuilder()
                      .setDefaultInstance(ListControlsResponse.getDefaultInstance())
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
                          "/v1/{name=projects/*}/locations",
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
                          "/v1/{name=projects/*/locations/*}",
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

  private final UnaryCallable<EnrollResourceRequest, Enrollment> enrollResourceCallable;
  private final UnaryCallable<GenerateAuditScopeReportRequest, AuditScopeReport>
      generateAuditScopeReportCallable;
  private final UnaryCallable<GenerateAuditReportRequest, Operation> generateAuditReportCallable;
  private final OperationCallable<GenerateAuditReportRequest, AuditReport, OperationMetadata>
      generateAuditReportOperationCallable;
  private final UnaryCallable<ListAuditReportsRequest, ListAuditReportsResponse>
      listAuditReportsCallable;
  private final UnaryCallable<ListAuditReportsRequest, ListAuditReportsPagedResponse>
      listAuditReportsPagedCallable;
  private final UnaryCallable<GetAuditReportRequest, AuditReport> getAuditReportCallable;
  private final UnaryCallable<GetResourceEnrollmentStatusRequest, ResourceEnrollmentStatus>
      getResourceEnrollmentStatusCallable;
  private final UnaryCallable<
          ListResourceEnrollmentStatusesRequest, ListResourceEnrollmentStatusesResponse>
      listResourceEnrollmentStatusesCallable;
  private final UnaryCallable<
          ListResourceEnrollmentStatusesRequest, ListResourceEnrollmentStatusesPagedResponse>
      listResourceEnrollmentStatusesPagedCallable;
  private final UnaryCallable<ListControlsRequest, ListControlsResponse> listControlsCallable;
  private final UnaryCallable<ListControlsRequest, ListControlsPagedResponse>
      listControlsPagedCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAuditManagerStub create(AuditManagerStubSettings settings)
      throws IOException {
    return new HttpJsonAuditManagerStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAuditManagerStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonAuditManagerStub(
        AuditManagerStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonAuditManagerStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAuditManagerStub(
        AuditManagerStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAuditManagerStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonAuditManagerStub(AuditManagerStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonAuditManagerCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAuditManagerStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonAuditManagerStub(
      AuditManagerStubSettings settings,
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
                        .setPost("/v1/{name=projects/*/locations/*/operations/*}:cancel")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setPost(
                                    "/v1/{name=organizations/*/locations/*/operations/*}:cancel")
                                .build())
                        .build())
                .put(
                    "google.longrunning.Operations.DeleteOperation",
                    HttpRule.newBuilder()
                        .setDelete("/v1/{name=projects/*/locations/*/operations/*}")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setDelete("/v1/{name=organizations/*/locations/*/operations/*}")
                                .build())
                        .build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*/operations/*}")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1/{name=organizations/*/locations/*/operations/*}")
                                .build())
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*}/operations")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1/{name=organizations/*/locations/*}/operations")
                                .build())
                        .build())
                .build());

    HttpJsonCallSettings<EnrollResourceRequest, Enrollment> enrollResourceTransportSettings =
        HttpJsonCallSettings.<EnrollResourceRequest, Enrollment>newBuilder()
            .setMethodDescriptor(enrollResourceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("scope", String.valueOf(request.getScope()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GenerateAuditScopeReportRequest, AuditScopeReport>
        generateAuditScopeReportTransportSettings =
            HttpJsonCallSettings.<GenerateAuditScopeReportRequest, AuditScopeReport>newBuilder()
                .setMethodDescriptor(generateAuditScopeReportMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("scope", String.valueOf(request.getScope()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GenerateAuditReportRequest, Operation>
        generateAuditReportTransportSettings =
            HttpJsonCallSettings.<GenerateAuditReportRequest, Operation>newBuilder()
                .setMethodDescriptor(generateAuditReportMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("scope", String.valueOf(request.getScope()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListAuditReportsRequest, ListAuditReportsResponse>
        listAuditReportsTransportSettings =
            HttpJsonCallSettings.<ListAuditReportsRequest, ListAuditReportsResponse>newBuilder()
                .setMethodDescriptor(listAuditReportsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetAuditReportRequest, AuditReport> getAuditReportTransportSettings =
        HttpJsonCallSettings.<GetAuditReportRequest, AuditReport>newBuilder()
            .setMethodDescriptor(getAuditReportMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetResourceEnrollmentStatusRequest, ResourceEnrollmentStatus>
        getResourceEnrollmentStatusTransportSettings =
            HttpJsonCallSettings
                .<GetResourceEnrollmentStatusRequest, ResourceEnrollmentStatus>newBuilder()
                .setMethodDescriptor(getResourceEnrollmentStatusMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            ListResourceEnrollmentStatusesRequest, ListResourceEnrollmentStatusesResponse>
        listResourceEnrollmentStatusesTransportSettings =
            HttpJsonCallSettings
                .<ListResourceEnrollmentStatusesRequest, ListResourceEnrollmentStatusesResponse>
                    newBuilder()
                .setMethodDescriptor(listResourceEnrollmentStatusesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListControlsRequest, ListControlsResponse> listControlsTransportSettings =
        HttpJsonCallSettings.<ListControlsRequest, ListControlsResponse>newBuilder()
            .setMethodDescriptor(listControlsMethodDescriptor)
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

    this.enrollResourceCallable =
        callableFactory.createUnaryCallable(
            enrollResourceTransportSettings, settings.enrollResourceSettings(), clientContext);
    this.generateAuditScopeReportCallable =
        callableFactory.createUnaryCallable(
            generateAuditScopeReportTransportSettings,
            settings.generateAuditScopeReportSettings(),
            clientContext);
    this.generateAuditReportCallable =
        callableFactory.createUnaryCallable(
            generateAuditReportTransportSettings,
            settings.generateAuditReportSettings(),
            clientContext);
    this.generateAuditReportOperationCallable =
        callableFactory.createOperationCallable(
            generateAuditReportTransportSettings,
            settings.generateAuditReportOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listAuditReportsCallable =
        callableFactory.createUnaryCallable(
            listAuditReportsTransportSettings, settings.listAuditReportsSettings(), clientContext);
    this.listAuditReportsPagedCallable =
        callableFactory.createPagedCallable(
            listAuditReportsTransportSettings, settings.listAuditReportsSettings(), clientContext);
    this.getAuditReportCallable =
        callableFactory.createUnaryCallable(
            getAuditReportTransportSettings, settings.getAuditReportSettings(), clientContext);
    this.getResourceEnrollmentStatusCallable =
        callableFactory.createUnaryCallable(
            getResourceEnrollmentStatusTransportSettings,
            settings.getResourceEnrollmentStatusSettings(),
            clientContext);
    this.listResourceEnrollmentStatusesCallable =
        callableFactory.createUnaryCallable(
            listResourceEnrollmentStatusesTransportSettings,
            settings.listResourceEnrollmentStatusesSettings(),
            clientContext);
    this.listResourceEnrollmentStatusesPagedCallable =
        callableFactory.createPagedCallable(
            listResourceEnrollmentStatusesTransportSettings,
            settings.listResourceEnrollmentStatusesSettings(),
            clientContext);
    this.listControlsCallable =
        callableFactory.createUnaryCallable(
            listControlsTransportSettings, settings.listControlsSettings(), clientContext);
    this.listControlsPagedCallable =
        callableFactory.createPagedCallable(
            listControlsTransportSettings, settings.listControlsSettings(), clientContext);
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
    methodDescriptors.add(enrollResourceMethodDescriptor);
    methodDescriptors.add(generateAuditScopeReportMethodDescriptor);
    methodDescriptors.add(generateAuditReportMethodDescriptor);
    methodDescriptors.add(listAuditReportsMethodDescriptor);
    methodDescriptors.add(getAuditReportMethodDescriptor);
    methodDescriptors.add(getResourceEnrollmentStatusMethodDescriptor);
    methodDescriptors.add(listResourceEnrollmentStatusesMethodDescriptor);
    methodDescriptors.add(listControlsMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<EnrollResourceRequest, Enrollment> enrollResourceCallable() {
    return enrollResourceCallable;
  }

  @Override
  public UnaryCallable<GenerateAuditScopeReportRequest, AuditScopeReport>
      generateAuditScopeReportCallable() {
    return generateAuditScopeReportCallable;
  }

  @Override
  public UnaryCallable<GenerateAuditReportRequest, Operation> generateAuditReportCallable() {
    return generateAuditReportCallable;
  }

  @Override
  public OperationCallable<GenerateAuditReportRequest, AuditReport, OperationMetadata>
      generateAuditReportOperationCallable() {
    return generateAuditReportOperationCallable;
  }

  @Override
  public UnaryCallable<ListAuditReportsRequest, ListAuditReportsResponse>
      listAuditReportsCallable() {
    return listAuditReportsCallable;
  }

  @Override
  public UnaryCallable<ListAuditReportsRequest, ListAuditReportsPagedResponse>
      listAuditReportsPagedCallable() {
    return listAuditReportsPagedCallable;
  }

  @Override
  public UnaryCallable<GetAuditReportRequest, AuditReport> getAuditReportCallable() {
    return getAuditReportCallable;
  }

  @Override
  public UnaryCallable<GetResourceEnrollmentStatusRequest, ResourceEnrollmentStatus>
      getResourceEnrollmentStatusCallable() {
    return getResourceEnrollmentStatusCallable;
  }

  @Override
  public UnaryCallable<
          ListResourceEnrollmentStatusesRequest, ListResourceEnrollmentStatusesResponse>
      listResourceEnrollmentStatusesCallable() {
    return listResourceEnrollmentStatusesCallable;
  }

  @Override
  public UnaryCallable<
          ListResourceEnrollmentStatusesRequest, ListResourceEnrollmentStatusesPagedResponse>
      listResourceEnrollmentStatusesPagedCallable() {
    return listResourceEnrollmentStatusesPagedCallable;
  }

  @Override
  public UnaryCallable<ListControlsRequest, ListControlsResponse> listControlsCallable() {
    return listControlsCallable;
  }

  @Override
  public UnaryCallable<ListControlsRequest, ListControlsPagedResponse> listControlsPagedCallable() {
    return listControlsPagedCallable;
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
