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

import static com.google.cloud.cloudsecuritycompliance.v1.AuditClient.ListFrameworkAuditsPagedResponse;
import static com.google.cloud.cloudsecuritycompliance.v1.AuditClient.ListLocationsPagedResponse;

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
import com.google.cloud.cloudsecuritycompliance.v1.CreateFrameworkAuditRequest;
import com.google.cloud.cloudsecuritycompliance.v1.FrameworkAudit;
import com.google.cloud.cloudsecuritycompliance.v1.GenerateFrameworkAuditScopeReportRequest;
import com.google.cloud.cloudsecuritycompliance.v1.GenerateFrameworkAuditScopeReportResponse;
import com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkAuditRequest;
import com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkAuditsRequest;
import com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkAuditsResponse;
import com.google.cloud.cloudsecuritycompliance.v1.OperationMetadata;
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
 * REST stub implementation for the Audit service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonAuditStub extends AuditStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(FrameworkAudit.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<
          GenerateFrameworkAuditScopeReportRequest, GenerateFrameworkAuditScopeReportResponse>
      generateFrameworkAuditScopeReportMethodDescriptor =
          ApiMethodDescriptor
              .<GenerateFrameworkAuditScopeReportRequest, GenerateFrameworkAuditScopeReportResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.cloudsecuritycompliance.v1.Audit/GenerateFrameworkAuditScopeReport")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<GenerateFrameworkAuditScopeReportRequest>newBuilder()
                      .setPath(
                          "/v1/{scope=folders/*/locations/*}/frameworkAuditScopeReports:generateFrameworkAuditScopeReport",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateFrameworkAuditScopeReportRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "scope", request.getScope());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{scope=projects/*/locations/*}/frameworkAuditScopeReports:generateFrameworkAuditScopeReport",
                          "/v1/{scope=organizations/*/locations/*}/frameworkAuditScopeReports:generateFrameworkAuditScopeReport")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateFrameworkAuditScopeReportRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearScope().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GenerateFrameworkAuditScopeReportResponse>newBuilder()
                      .setDefaultInstance(
                          GenerateFrameworkAuditScopeReportResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateFrameworkAuditRequest, Operation>
      createFrameworkAuditMethodDescriptor =
          ApiMethodDescriptor.<CreateFrameworkAuditRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.cloudsecuritycompliance.v1.Audit/CreateFrameworkAudit")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateFrameworkAuditRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=organizations/*/locations/*}/frameworkAudits",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateFrameworkAuditRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=folders/*/locations/*}/frameworkAudits",
                          "/v1/{parent=projects/*/locations/*}/frameworkAudits")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateFrameworkAuditRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "frameworkAuditId", request.getFrameworkAuditId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("frameworkAudit", request.getFrameworkAudit(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateFrameworkAuditRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListFrameworkAuditsRequest, ListFrameworkAuditsResponse>
      listFrameworkAuditsMethodDescriptor =
          ApiMethodDescriptor.<ListFrameworkAuditsRequest, ListFrameworkAuditsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.cloudsecuritycompliance.v1.Audit/ListFrameworkAudits")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListFrameworkAuditsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=organizations/*/locations/*}/frameworkAudits",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListFrameworkAuditsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=folders/*/locations/*}/frameworkAudits",
                          "/v1/{parent=projects/*/locations/*}/frameworkAudits")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListFrameworkAuditsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListFrameworkAuditsResponse>newBuilder()
                      .setDefaultInstance(ListFrameworkAuditsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetFrameworkAuditRequest, FrameworkAudit>
      getFrameworkAuditMethodDescriptor =
          ApiMethodDescriptor.<GetFrameworkAuditRequest, FrameworkAudit>newBuilder()
              .setFullMethodName("google.cloud.cloudsecuritycompliance.v1.Audit/GetFrameworkAudit")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetFrameworkAuditRequest>newBuilder()
                      .setPath(
                          "/v1/{name=organizations/*/locations/*/frameworkAudits/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetFrameworkAuditRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{name=folders/*/locations/*/frameworkAudits/*}",
                          "/v1/{name=projects/*/locations/*/frameworkAudits/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetFrameworkAuditRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FrameworkAudit>newBuilder()
                      .setDefaultInstance(FrameworkAudit.getDefaultInstance())
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

  private final UnaryCallable<
          GenerateFrameworkAuditScopeReportRequest, GenerateFrameworkAuditScopeReportResponse>
      generateFrameworkAuditScopeReportCallable;
  private final UnaryCallable<CreateFrameworkAuditRequest, Operation> createFrameworkAuditCallable;
  private final OperationCallable<CreateFrameworkAuditRequest, FrameworkAudit, OperationMetadata>
      createFrameworkAuditOperationCallable;
  private final UnaryCallable<ListFrameworkAuditsRequest, ListFrameworkAuditsResponse>
      listFrameworkAuditsCallable;
  private final UnaryCallable<ListFrameworkAuditsRequest, ListFrameworkAuditsPagedResponse>
      listFrameworkAuditsPagedCallable;
  private final UnaryCallable<GetFrameworkAuditRequest, FrameworkAudit> getFrameworkAuditCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAuditStub create(AuditStubSettings settings) throws IOException {
    return new HttpJsonAuditStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAuditStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonAuditStub(AuditStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonAuditStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAuditStub(
        AuditStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAuditStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonAuditStub(AuditStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonAuditCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAuditStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonAuditStub(
      AuditStubSettings settings,
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

    HttpJsonCallSettings<
            GenerateFrameworkAuditScopeReportRequest, GenerateFrameworkAuditScopeReportResponse>
        generateFrameworkAuditScopeReportTransportSettings =
            HttpJsonCallSettings
                .<GenerateFrameworkAuditScopeReportRequest,
                    GenerateFrameworkAuditScopeReportResponse>
                    newBuilder()
                .setMethodDescriptor(generateFrameworkAuditScopeReportMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("scope", String.valueOf(request.getScope()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateFrameworkAuditRequest, Operation>
        createFrameworkAuditTransportSettings =
            HttpJsonCallSettings.<CreateFrameworkAuditRequest, Operation>newBuilder()
                .setMethodDescriptor(createFrameworkAuditMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListFrameworkAuditsRequest, ListFrameworkAuditsResponse>
        listFrameworkAuditsTransportSettings =
            HttpJsonCallSettings
                .<ListFrameworkAuditsRequest, ListFrameworkAuditsResponse>newBuilder()
                .setMethodDescriptor(listFrameworkAuditsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetFrameworkAuditRequest, FrameworkAudit>
        getFrameworkAuditTransportSettings =
            HttpJsonCallSettings.<GetFrameworkAuditRequest, FrameworkAudit>newBuilder()
                .setMethodDescriptor(getFrameworkAuditMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
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

    this.generateFrameworkAuditScopeReportCallable =
        callableFactory.createUnaryCallable(
            generateFrameworkAuditScopeReportTransportSettings,
            settings.generateFrameworkAuditScopeReportSettings(),
            clientContext);
    this.createFrameworkAuditCallable =
        callableFactory.createUnaryCallable(
            createFrameworkAuditTransportSettings,
            settings.createFrameworkAuditSettings(),
            clientContext);
    this.createFrameworkAuditOperationCallable =
        callableFactory.createOperationCallable(
            createFrameworkAuditTransportSettings,
            settings.createFrameworkAuditOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listFrameworkAuditsCallable =
        callableFactory.createUnaryCallable(
            listFrameworkAuditsTransportSettings,
            settings.listFrameworkAuditsSettings(),
            clientContext);
    this.listFrameworkAuditsPagedCallable =
        callableFactory.createPagedCallable(
            listFrameworkAuditsTransportSettings,
            settings.listFrameworkAuditsSettings(),
            clientContext);
    this.getFrameworkAuditCallable =
        callableFactory.createUnaryCallable(
            getFrameworkAuditTransportSettings,
            settings.getFrameworkAuditSettings(),
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
    methodDescriptors.add(generateFrameworkAuditScopeReportMethodDescriptor);
    methodDescriptors.add(createFrameworkAuditMethodDescriptor);
    methodDescriptors.add(listFrameworkAuditsMethodDescriptor);
    methodDescriptors.add(getFrameworkAuditMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<
          GenerateFrameworkAuditScopeReportRequest, GenerateFrameworkAuditScopeReportResponse>
      generateFrameworkAuditScopeReportCallable() {
    return generateFrameworkAuditScopeReportCallable;
  }

  @Override
  public UnaryCallable<CreateFrameworkAuditRequest, Operation> createFrameworkAuditCallable() {
    return createFrameworkAuditCallable;
  }

  @Override
  public OperationCallable<CreateFrameworkAuditRequest, FrameworkAudit, OperationMetadata>
      createFrameworkAuditOperationCallable() {
    return createFrameworkAuditOperationCallable;
  }

  @Override
  public UnaryCallable<ListFrameworkAuditsRequest, ListFrameworkAuditsResponse>
      listFrameworkAuditsCallable() {
    return listFrameworkAuditsCallable;
  }

  @Override
  public UnaryCallable<ListFrameworkAuditsRequest, ListFrameworkAuditsPagedResponse>
      listFrameworkAuditsPagedCallable() {
    return listFrameworkAuditsPagedCallable;
  }

  @Override
  public UnaryCallable<GetFrameworkAuditRequest, FrameworkAudit> getFrameworkAuditCallable() {
    return getFrameworkAuditCallable;
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
