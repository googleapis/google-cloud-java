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

package com.google.cloud.cloudsecuritycompliance.v1.stub;

import static com.google.cloud.cloudsecuritycompliance.v1.MonitoringClient.ListControlComplianceSummariesPagedResponse;
import static com.google.cloud.cloudsecuritycompliance.v1.MonitoringClient.ListFindingSummariesPagedResponse;
import static com.google.cloud.cloudsecuritycompliance.v1.MonitoringClient.ListFrameworkComplianceSummariesPagedResponse;
import static com.google.cloud.cloudsecuritycompliance.v1.MonitoringClient.ListLocationsPagedResponse;

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
import com.google.cloud.cloudsecuritycompliance.v1.AggregateFrameworkComplianceReportRequest;
import com.google.cloud.cloudsecuritycompliance.v1.AggregateFrameworkComplianceReportResponse;
import com.google.cloud.cloudsecuritycompliance.v1.FetchFrameworkComplianceReportRequest;
import com.google.cloud.cloudsecuritycompliance.v1.FrameworkComplianceReport;
import com.google.cloud.cloudsecuritycompliance.v1.ListControlComplianceSummariesRequest;
import com.google.cloud.cloudsecuritycompliance.v1.ListControlComplianceSummariesResponse;
import com.google.cloud.cloudsecuritycompliance.v1.ListFindingSummariesRequest;
import com.google.cloud.cloudsecuritycompliance.v1.ListFindingSummariesResponse;
import com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkComplianceSummariesRequest;
import com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkComplianceSummariesResponse;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * REST stub implementation for the Monitoring service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonMonitoringStub extends MonitoringStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<
          ListFrameworkComplianceSummariesRequest, ListFrameworkComplianceSummariesResponse>
      listFrameworkComplianceSummariesMethodDescriptor =
          ApiMethodDescriptor
              .<ListFrameworkComplianceSummariesRequest, ListFrameworkComplianceSummariesResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.cloudsecuritycompliance.v1.Monitoring/ListFrameworkComplianceSummaries")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListFrameworkComplianceSummariesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=organizations/*/locations/*}/frameworkComplianceSummaries",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListFrameworkComplianceSummariesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=folders/*/locations/*}/frameworkComplianceSummaries",
                          "/v1/{parent=projects/*/locations/*}/frameworkComplianceSummaries")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListFrameworkComplianceSummariesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListFrameworkComplianceSummariesResponse>newBuilder()
                      .setDefaultInstance(
                          ListFrameworkComplianceSummariesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListFindingSummariesRequest, ListFindingSummariesResponse>
      listFindingSummariesMethodDescriptor =
          ApiMethodDescriptor
              .<ListFindingSummariesRequest, ListFindingSummariesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.cloudsecuritycompliance.v1.Monitoring/ListFindingSummaries")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListFindingSummariesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=organizations/*/locations/*}/findingSummaries",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListFindingSummariesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=folders/*/locations/*}/findingSummaries",
                          "/v1/{parent=projects/*/locations/*}/findingSummaries")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListFindingSummariesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "endTime", request.getEndTime());
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListFindingSummariesResponse>newBuilder()
                      .setDefaultInstance(ListFindingSummariesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          FetchFrameworkComplianceReportRequest, FrameworkComplianceReport>
      fetchFrameworkComplianceReportMethodDescriptor =
          ApiMethodDescriptor
              .<FetchFrameworkComplianceReportRequest, FrameworkComplianceReport>newBuilder()
              .setFullMethodName(
                  "google.cloud.cloudsecuritycompliance.v1.Monitoring/FetchFrameworkComplianceReport")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FetchFrameworkComplianceReportRequest>newBuilder()
                      .setPath(
                          "/v1/{name=organizations/*/locations/*/frameworkComplianceReports/*}:fetch",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FetchFrameworkComplianceReportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{name=folders/*/locations/*/frameworkComplianceReports/*}:fetch",
                          "/v1/{name=projects/*/locations/*/frameworkComplianceReports/*}:fetch")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FetchFrameworkComplianceReportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "endTime", request.getEndTime());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FrameworkComplianceReport>newBuilder()
                      .setDefaultInstance(FrameworkComplianceReport.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListControlComplianceSummariesRequest, ListControlComplianceSummariesResponse>
      listControlComplianceSummariesMethodDescriptor =
          ApiMethodDescriptor
              .<ListControlComplianceSummariesRequest, ListControlComplianceSummariesResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.cloudsecuritycompliance.v1.Monitoring/ListControlComplianceSummaries")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListControlComplianceSummariesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=organizations/*/locations/*/frameworkComplianceReports/*}/controlComplianceSummaries",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListControlComplianceSummariesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=folders/*/locations/*/frameworkComplianceReports/*}/controlComplianceSummaries",
                          "/v1/{parent=projects/*/locations/*/frameworkComplianceReports/*}/controlComplianceSummaries")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListControlComplianceSummariesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "endTime", request.getEndTime());
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListControlComplianceSummariesResponse>newBuilder()
                      .setDefaultInstance(
                          ListControlComplianceSummariesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          AggregateFrameworkComplianceReportRequest, AggregateFrameworkComplianceReportResponse>
      aggregateFrameworkComplianceReportMethodDescriptor =
          ApiMethodDescriptor
              .<AggregateFrameworkComplianceReportRequest,
                  AggregateFrameworkComplianceReportResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.cloudsecuritycompliance.v1.Monitoring/AggregateFrameworkComplianceReport")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<AggregateFrameworkComplianceReportRequest>newBuilder()
                      .setPath(
                          "/v1/{name=organizations/*/locations/*/frameworkComplianceReports/*}:aggregate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AggregateFrameworkComplianceReportRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{name=folders/*/locations/*/frameworkComplianceReports/*}:aggregate",
                          "/v1/{name=projects/*/locations/*/frameworkComplianceReports/*}:aggregate")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AggregateFrameworkComplianceReportRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "interval", request.getInterval());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<AggregateFrameworkComplianceReportResponse>newBuilder()
                      .setDefaultInstance(
                          AggregateFrameworkComplianceReportResponse.getDefaultInstance())
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
          ListFrameworkComplianceSummariesRequest, ListFrameworkComplianceSummariesResponse>
      listFrameworkComplianceSummariesCallable;
  private final UnaryCallable<
          ListFrameworkComplianceSummariesRequest, ListFrameworkComplianceSummariesPagedResponse>
      listFrameworkComplianceSummariesPagedCallable;
  private final UnaryCallable<ListFindingSummariesRequest, ListFindingSummariesResponse>
      listFindingSummariesCallable;
  private final UnaryCallable<ListFindingSummariesRequest, ListFindingSummariesPagedResponse>
      listFindingSummariesPagedCallable;
  private final UnaryCallable<FetchFrameworkComplianceReportRequest, FrameworkComplianceReport>
      fetchFrameworkComplianceReportCallable;
  private final UnaryCallable<
          ListControlComplianceSummariesRequest, ListControlComplianceSummariesResponse>
      listControlComplianceSummariesCallable;
  private final UnaryCallable<
          ListControlComplianceSummariesRequest, ListControlComplianceSummariesPagedResponse>
      listControlComplianceSummariesPagedCallable;
  private final UnaryCallable<
          AggregateFrameworkComplianceReportRequest, AggregateFrameworkComplianceReportResponse>
      aggregateFrameworkComplianceReportCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonMonitoringStub create(MonitoringStubSettings settings)
      throws IOException {
    return new HttpJsonMonitoringStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonMonitoringStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonMonitoringStub(
        MonitoringStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonMonitoringStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonMonitoringStub(
        MonitoringStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonMonitoringStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonMonitoringStub(MonitoringStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonMonitoringCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonMonitoringStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonMonitoringStub(
      MonitoringStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<
            ListFrameworkComplianceSummariesRequest, ListFrameworkComplianceSummariesResponse>
        listFrameworkComplianceSummariesTransportSettings =
            HttpJsonCallSettings
                .<ListFrameworkComplianceSummariesRequest, ListFrameworkComplianceSummariesResponse>
                    newBuilder()
                .setMethodDescriptor(listFrameworkComplianceSummariesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListFindingSummariesRequest, ListFindingSummariesResponse>
        listFindingSummariesTransportSettings =
            HttpJsonCallSettings
                .<ListFindingSummariesRequest, ListFindingSummariesResponse>newBuilder()
                .setMethodDescriptor(listFindingSummariesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<FetchFrameworkComplianceReportRequest, FrameworkComplianceReport>
        fetchFrameworkComplianceReportTransportSettings =
            HttpJsonCallSettings
                .<FetchFrameworkComplianceReportRequest, FrameworkComplianceReport>newBuilder()
                .setMethodDescriptor(fetchFrameworkComplianceReportMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            ListControlComplianceSummariesRequest, ListControlComplianceSummariesResponse>
        listControlComplianceSummariesTransportSettings =
            HttpJsonCallSettings
                .<ListControlComplianceSummariesRequest, ListControlComplianceSummariesResponse>
                    newBuilder()
                .setMethodDescriptor(listControlComplianceSummariesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            AggregateFrameworkComplianceReportRequest, AggregateFrameworkComplianceReportResponse>
        aggregateFrameworkComplianceReportTransportSettings =
            HttpJsonCallSettings
                .<AggregateFrameworkComplianceReportRequest,
                    AggregateFrameworkComplianceReportResponse>
                    newBuilder()
                .setMethodDescriptor(aggregateFrameworkComplianceReportMethodDescriptor)
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

    this.listFrameworkComplianceSummariesCallable =
        callableFactory.createUnaryCallable(
            listFrameworkComplianceSummariesTransportSettings,
            settings.listFrameworkComplianceSummariesSettings(),
            clientContext);
    this.listFrameworkComplianceSummariesPagedCallable =
        callableFactory.createPagedCallable(
            listFrameworkComplianceSummariesTransportSettings,
            settings.listFrameworkComplianceSummariesSettings(),
            clientContext);
    this.listFindingSummariesCallable =
        callableFactory.createUnaryCallable(
            listFindingSummariesTransportSettings,
            settings.listFindingSummariesSettings(),
            clientContext);
    this.listFindingSummariesPagedCallable =
        callableFactory.createPagedCallable(
            listFindingSummariesTransportSettings,
            settings.listFindingSummariesSettings(),
            clientContext);
    this.fetchFrameworkComplianceReportCallable =
        callableFactory.createUnaryCallable(
            fetchFrameworkComplianceReportTransportSettings,
            settings.fetchFrameworkComplianceReportSettings(),
            clientContext);
    this.listControlComplianceSummariesCallable =
        callableFactory.createUnaryCallable(
            listControlComplianceSummariesTransportSettings,
            settings.listControlComplianceSummariesSettings(),
            clientContext);
    this.listControlComplianceSummariesPagedCallable =
        callableFactory.createPagedCallable(
            listControlComplianceSummariesTransportSettings,
            settings.listControlComplianceSummariesSettings(),
            clientContext);
    this.aggregateFrameworkComplianceReportCallable =
        callableFactory.createUnaryCallable(
            aggregateFrameworkComplianceReportTransportSettings,
            settings.aggregateFrameworkComplianceReportSettings(),
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
    methodDescriptors.add(listFrameworkComplianceSummariesMethodDescriptor);
    methodDescriptors.add(listFindingSummariesMethodDescriptor);
    methodDescriptors.add(fetchFrameworkComplianceReportMethodDescriptor);
    methodDescriptors.add(listControlComplianceSummariesMethodDescriptor);
    methodDescriptors.add(aggregateFrameworkComplianceReportMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<
          ListFrameworkComplianceSummariesRequest, ListFrameworkComplianceSummariesResponse>
      listFrameworkComplianceSummariesCallable() {
    return listFrameworkComplianceSummariesCallable;
  }

  @Override
  public UnaryCallable<
          ListFrameworkComplianceSummariesRequest, ListFrameworkComplianceSummariesPagedResponse>
      listFrameworkComplianceSummariesPagedCallable() {
    return listFrameworkComplianceSummariesPagedCallable;
  }

  @Override
  public UnaryCallable<ListFindingSummariesRequest, ListFindingSummariesResponse>
      listFindingSummariesCallable() {
    return listFindingSummariesCallable;
  }

  @Override
  public UnaryCallable<ListFindingSummariesRequest, ListFindingSummariesPagedResponse>
      listFindingSummariesPagedCallable() {
    return listFindingSummariesPagedCallable;
  }

  @Override
  public UnaryCallable<FetchFrameworkComplianceReportRequest, FrameworkComplianceReport>
      fetchFrameworkComplianceReportCallable() {
    return fetchFrameworkComplianceReportCallable;
  }

  @Override
  public UnaryCallable<
          ListControlComplianceSummariesRequest, ListControlComplianceSummariesResponse>
      listControlComplianceSummariesCallable() {
    return listControlComplianceSummariesCallable;
  }

  @Override
  public UnaryCallable<
          ListControlComplianceSummariesRequest, ListControlComplianceSummariesPagedResponse>
      listControlComplianceSummariesPagedCallable() {
    return listControlComplianceSummariesPagedCallable;
  }

  @Override
  public UnaryCallable<
          AggregateFrameworkComplianceReportRequest, AggregateFrameworkComplianceReportResponse>
      aggregateFrameworkComplianceReportCallable() {
    return aggregateFrameworkComplianceReportCallable;
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
