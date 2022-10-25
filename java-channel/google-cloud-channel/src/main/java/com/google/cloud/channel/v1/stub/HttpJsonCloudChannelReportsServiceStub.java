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

package com.google.cloud.channel.v1.stub;

import static com.google.cloud.channel.v1.CloudChannelReportsServiceClient.FetchReportResultsPagedResponse;
import static com.google.cloud.channel.v1.CloudChannelReportsServiceClient.ListReportsPagedResponse;

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
import com.google.cloud.channel.v1.FetchReportResultsRequest;
import com.google.cloud.channel.v1.FetchReportResultsResponse;
import com.google.cloud.channel.v1.ListReportsRequest;
import com.google.cloud.channel.v1.ListReportsResponse;
import com.google.cloud.channel.v1.OperationMetadata;
import com.google.cloud.channel.v1.RunReportJobRequest;
import com.google.cloud.channel.v1.RunReportJobResponse;
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
 * REST stub implementation for the CloudChannelReportsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonCloudChannelReportsServiceStub extends CloudChannelReportsServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(RunReportJobResponse.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<RunReportJobRequest, Operation>
      runReportJobMethodDescriptor =
          ApiMethodDescriptor.<RunReportJobRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.channel.v1.CloudChannelReportsService/RunReportJob")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RunReportJobRequest>newBuilder()
                      .setPath(
                          "/v1/{name=accounts/*/reports/*}:run",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RunReportJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RunReportJobRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (RunReportJobRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<FetchReportResultsRequest, FetchReportResultsResponse>
      fetchReportResultsMethodDescriptor =
          ApiMethodDescriptor.<FetchReportResultsRequest, FetchReportResultsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.channel.v1.CloudChannelReportsService/FetchReportResults")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FetchReportResultsRequest>newBuilder()
                      .setPath(
                          "/v1/{reportJob=accounts/*/reportJobs/*}:fetchReportResults",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FetchReportResultsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "reportJob", request.getReportJob());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FetchReportResultsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearReportJob().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FetchReportResultsResponse>newBuilder()
                      .setDefaultInstance(FetchReportResultsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListReportsRequest, ListReportsResponse>
      listReportsMethodDescriptor =
          ApiMethodDescriptor.<ListReportsRequest, ListReportsResponse>newBuilder()
              .setFullMethodName("google.cloud.channel.v1.CloudChannelReportsService/ListReports")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListReportsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=accounts/*}/reports",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListReportsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListReportsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "languageCode", request.getLanguageCode());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListReportsResponse>newBuilder()
                      .setDefaultInstance(ListReportsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<RunReportJobRequest, Operation> runReportJobCallable;
  private final OperationCallable<RunReportJobRequest, RunReportJobResponse, OperationMetadata>
      runReportJobOperationCallable;
  private final UnaryCallable<FetchReportResultsRequest, FetchReportResultsResponse>
      fetchReportResultsCallable;
  private final UnaryCallable<FetchReportResultsRequest, FetchReportResultsPagedResponse>
      fetchReportResultsPagedCallable;
  private final UnaryCallable<ListReportsRequest, ListReportsResponse> listReportsCallable;
  private final UnaryCallable<ListReportsRequest, ListReportsPagedResponse>
      listReportsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonCloudChannelReportsServiceStub create(
      CloudChannelReportsServiceStubSettings settings) throws IOException {
    return new HttpJsonCloudChannelReportsServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonCloudChannelReportsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonCloudChannelReportsServiceStub(
        CloudChannelReportsServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonCloudChannelReportsServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonCloudChannelReportsServiceStub(
        CloudChannelReportsServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonCloudChannelReportsServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonCloudChannelReportsServiceStub(
      CloudChannelReportsServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonCloudChannelReportsServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonCloudChannelReportsServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonCloudChannelReportsServiceStub(
      CloudChannelReportsServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<RunReportJobRequest, Operation> runReportJobTransportSettings =
        HttpJsonCallSettings.<RunReportJobRequest, Operation>newBuilder()
            .setMethodDescriptor(runReportJobMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<FetchReportResultsRequest, FetchReportResultsResponse>
        fetchReportResultsTransportSettings =
            HttpJsonCallSettings.<FetchReportResultsRequest, FetchReportResultsResponse>newBuilder()
                .setMethodDescriptor(fetchReportResultsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListReportsRequest, ListReportsResponse> listReportsTransportSettings =
        HttpJsonCallSettings.<ListReportsRequest, ListReportsResponse>newBuilder()
            .setMethodDescriptor(listReportsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.runReportJobCallable =
        callableFactory.createUnaryCallable(
            runReportJobTransportSettings, settings.runReportJobSettings(), clientContext);
    this.runReportJobOperationCallable =
        callableFactory.createOperationCallable(
            runReportJobTransportSettings,
            settings.runReportJobOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.fetchReportResultsCallable =
        callableFactory.createUnaryCallable(
            fetchReportResultsTransportSettings,
            settings.fetchReportResultsSettings(),
            clientContext);
    this.fetchReportResultsPagedCallable =
        callableFactory.createPagedCallable(
            fetchReportResultsTransportSettings,
            settings.fetchReportResultsSettings(),
            clientContext);
    this.listReportsCallable =
        callableFactory.createUnaryCallable(
            listReportsTransportSettings, settings.listReportsSettings(), clientContext);
    this.listReportsPagedCallable =
        callableFactory.createPagedCallable(
            listReportsTransportSettings, settings.listReportsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(runReportJobMethodDescriptor);
    methodDescriptors.add(fetchReportResultsMethodDescriptor);
    methodDescriptors.add(listReportsMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<RunReportJobRequest, Operation> runReportJobCallable() {
    return runReportJobCallable;
  }

  @Override
  public OperationCallable<RunReportJobRequest, RunReportJobResponse, OperationMetadata>
      runReportJobOperationCallable() {
    return runReportJobOperationCallable;
  }

  @Override
  public UnaryCallable<FetchReportResultsRequest, FetchReportResultsResponse>
      fetchReportResultsCallable() {
    return fetchReportResultsCallable;
  }

  @Override
  public UnaryCallable<FetchReportResultsRequest, FetchReportResultsPagedResponse>
      fetchReportResultsPagedCallable() {
    return fetchReportResultsPagedCallable;
  }

  @Override
  public UnaryCallable<ListReportsRequest, ListReportsResponse> listReportsCallable() {
    return listReportsCallable;
  }

  @Override
  public UnaryCallable<ListReportsRequest, ListReportsPagedResponse> listReportsPagedCallable() {
    return listReportsPagedCallable;
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
