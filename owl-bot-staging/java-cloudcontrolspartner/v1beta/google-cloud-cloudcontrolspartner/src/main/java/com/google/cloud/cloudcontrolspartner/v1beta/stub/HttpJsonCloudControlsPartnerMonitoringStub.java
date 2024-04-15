/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.cloudcontrolspartner.v1beta.stub;

import static com.google.cloud.cloudcontrolspartner.v1beta.CloudControlsPartnerMonitoringClient.ListViolationsPagedResponse;

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
import com.google.cloud.cloudcontrolspartner.v1beta.GetViolationRequest;
import com.google.cloud.cloudcontrolspartner.v1beta.ListViolationsRequest;
import com.google.cloud.cloudcontrolspartner.v1beta.ListViolationsResponse;
import com.google.cloud.cloudcontrolspartner.v1beta.Violation;
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
 * REST stub implementation for the CloudControlsPartnerMonitoring service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonCloudControlsPartnerMonitoringStub extends CloudControlsPartnerMonitoringStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<ListViolationsRequest, ListViolationsResponse>
      listViolationsMethodDescriptor =
          ApiMethodDescriptor.<ListViolationsRequest, ListViolationsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.cloudcontrolspartner.v1beta.CloudControlsPartnerMonitoring/ListViolations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListViolationsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=organizations/*/locations/*/customers/*/workloads/*}/violations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListViolationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListViolationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "interval", request.getInterval());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListViolationsResponse>newBuilder()
                      .setDefaultInstance(ListViolationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetViolationRequest, Violation>
      getViolationMethodDescriptor =
          ApiMethodDescriptor.<GetViolationRequest, Violation>newBuilder()
              .setFullMethodName(
                  "google.cloud.cloudcontrolspartner.v1beta.CloudControlsPartnerMonitoring/GetViolation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetViolationRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=organizations/*/locations/*/customers/*/workloads/*/violations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetViolationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetViolationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Violation>newBuilder()
                      .setDefaultInstance(Violation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListViolationsRequest, ListViolationsResponse> listViolationsCallable;
  private final UnaryCallable<ListViolationsRequest, ListViolationsPagedResponse>
      listViolationsPagedCallable;
  private final UnaryCallable<GetViolationRequest, Violation> getViolationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonCloudControlsPartnerMonitoringStub create(
      CloudControlsPartnerMonitoringStubSettings settings) throws IOException {
    return new HttpJsonCloudControlsPartnerMonitoringStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonCloudControlsPartnerMonitoringStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonCloudControlsPartnerMonitoringStub(
        CloudControlsPartnerMonitoringStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonCloudControlsPartnerMonitoringStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonCloudControlsPartnerMonitoringStub(
        CloudControlsPartnerMonitoringStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonCloudControlsPartnerMonitoringStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonCloudControlsPartnerMonitoringStub(
      CloudControlsPartnerMonitoringStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonCloudControlsPartnerMonitoringCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonCloudControlsPartnerMonitoringStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonCloudControlsPartnerMonitoringStub(
      CloudControlsPartnerMonitoringStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ListViolationsRequest, ListViolationsResponse>
        listViolationsTransportSettings =
            HttpJsonCallSettings.<ListViolationsRequest, ListViolationsResponse>newBuilder()
                .setMethodDescriptor(listViolationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetViolationRequest, Violation> getViolationTransportSettings =
        HttpJsonCallSettings.<GetViolationRequest, Violation>newBuilder()
            .setMethodDescriptor(getViolationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.listViolationsCallable =
        callableFactory.createUnaryCallable(
            listViolationsTransportSettings, settings.listViolationsSettings(), clientContext);
    this.listViolationsPagedCallable =
        callableFactory.createPagedCallable(
            listViolationsTransportSettings, settings.listViolationsSettings(), clientContext);
    this.getViolationCallable =
        callableFactory.createUnaryCallable(
            getViolationTransportSettings, settings.getViolationSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listViolationsMethodDescriptor);
    methodDescriptors.add(getViolationMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<ListViolationsRequest, ListViolationsResponse> listViolationsCallable() {
    return listViolationsCallable;
  }

  @Override
  public UnaryCallable<ListViolationsRequest, ListViolationsPagedResponse>
      listViolationsPagedCallable() {
    return listViolationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetViolationRequest, Violation> getViolationCallable() {
    return getViolationCallable;
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
