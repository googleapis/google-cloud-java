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

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
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
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the CloudChannelReportsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcCloudChannelReportsServiceStub extends CloudChannelReportsServiceStub {
  private static final MethodDescriptor<RunReportJobRequest, Operation>
      runReportJobMethodDescriptor =
          MethodDescriptor.<RunReportJobRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.channel.v1.CloudChannelReportsService/RunReportJob")
              .setRequestMarshaller(ProtoUtils.marshaller(RunReportJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<FetchReportResultsRequest, FetchReportResultsResponse>
      fetchReportResultsMethodDescriptor =
          MethodDescriptor.<FetchReportResultsRequest, FetchReportResultsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.channel.v1.CloudChannelReportsService/FetchReportResults")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(FetchReportResultsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(FetchReportResultsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListReportsRequest, ListReportsResponse>
      listReportsMethodDescriptor =
          MethodDescriptor.<ListReportsRequest, ListReportsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.channel.v1.CloudChannelReportsService/ListReports")
              .setRequestMarshaller(ProtoUtils.marshaller(ListReportsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListReportsResponse.getDefaultInstance()))
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
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcCloudChannelReportsServiceStub create(
      CloudChannelReportsServiceStubSettings settings) throws IOException {
    return new GrpcCloudChannelReportsServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcCloudChannelReportsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcCloudChannelReportsServiceStub(
        CloudChannelReportsServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcCloudChannelReportsServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcCloudChannelReportsServiceStub(
        CloudChannelReportsServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcCloudChannelReportsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcCloudChannelReportsServiceStub(
      CloudChannelReportsServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcCloudChannelReportsServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcCloudChannelReportsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcCloudChannelReportsServiceStub(
      CloudChannelReportsServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<RunReportJobRequest, Operation> runReportJobTransportSettings =
        GrpcCallSettings.<RunReportJobRequest, Operation>newBuilder()
            .setMethodDescriptor(runReportJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<FetchReportResultsRequest, FetchReportResultsResponse>
        fetchReportResultsTransportSettings =
            GrpcCallSettings.<FetchReportResultsRequest, FetchReportResultsResponse>newBuilder()
                .setMethodDescriptor(fetchReportResultsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("report_job", String.valueOf(request.getReportJob()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListReportsRequest, ListReportsResponse> listReportsTransportSettings =
        GrpcCallSettings.<ListReportsRequest, ListReportsResponse>newBuilder()
            .setMethodDescriptor(listReportsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();

    this.runReportJobCallable =
        callableFactory.createUnaryCallable(
            runReportJobTransportSettings, settings.runReportJobSettings(), clientContext);
    this.runReportJobOperationCallable =
        callableFactory.createOperationCallable(
            runReportJobTransportSettings,
            settings.runReportJobOperationSettings(),
            clientContext,
            operationsStub);
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

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
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
