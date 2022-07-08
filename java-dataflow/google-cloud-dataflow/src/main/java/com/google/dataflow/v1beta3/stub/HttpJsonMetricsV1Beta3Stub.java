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

package com.google.dataflow.v1beta3.stub;

import static com.google.dataflow.v1beta3.MetricsV1Beta3Client.GetJobExecutionDetailsPagedResponse;
import static com.google.dataflow.v1beta3.MetricsV1Beta3Client.GetStageExecutionDetailsPagedResponse;

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
import com.google.api.gax.rpc.UnaryCallable;
import com.google.dataflow.v1beta3.GetJobExecutionDetailsRequest;
import com.google.dataflow.v1beta3.GetJobMetricsRequest;
import com.google.dataflow.v1beta3.GetStageExecutionDetailsRequest;
import com.google.dataflow.v1beta3.JobExecutionDetails;
import com.google.dataflow.v1beta3.JobMetrics;
import com.google.dataflow.v1beta3.StageExecutionDetails;
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
 * REST stub implementation for the MetricsV1Beta3 service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonMetricsV1Beta3Stub extends MetricsV1Beta3Stub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetJobMetricsRequest, JobMetrics>
      getJobMetricsMethodDescriptor =
          ApiMethodDescriptor.<GetJobMetricsRequest, JobMetrics>newBuilder()
              .setFullMethodName("google.dataflow.v1beta3.MetricsV1Beta3/GetJobMetrics")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetJobMetricsRequest>newBuilder()
                      .setPath(
                          "/v1b3/projects/{projectId}/locations/{location}/jobs/{jobId}/metrics",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetJobMetricsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "jobId", request.getJobId());
                            serializer.putPathParam(fields, "location", request.getLocation());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            return fields;
                          })
                      .setAdditionalPaths("/v1b3/projects/{projectId}/jobs/{jobId}/metrics")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetJobMetricsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "startTime", request.getStartTime());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<JobMetrics>newBuilder()
                      .setDefaultInstance(JobMetrics.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetJobExecutionDetailsRequest, JobExecutionDetails>
      getJobExecutionDetailsMethodDescriptor =
          ApiMethodDescriptor.<GetJobExecutionDetailsRequest, JobExecutionDetails>newBuilder()
              .setFullMethodName("google.dataflow.v1beta3.MetricsV1Beta3/GetJobExecutionDetails")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetJobExecutionDetailsRequest>newBuilder()
                      .setPath(
                          "/v1b3/projects/{projectId}/locations/{location}/jobs/{jobId}/executionDetails",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetJobExecutionDetailsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "jobId", request.getJobId());
                            serializer.putPathParam(fields, "location", request.getLocation());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetJobExecutionDetailsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<JobExecutionDetails>newBuilder()
                      .setDefaultInstance(JobExecutionDetails.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetStageExecutionDetailsRequest, StageExecutionDetails>
      getStageExecutionDetailsMethodDescriptor =
          ApiMethodDescriptor.<GetStageExecutionDetailsRequest, StageExecutionDetails>newBuilder()
              .setFullMethodName("google.dataflow.v1beta3.MetricsV1Beta3/GetStageExecutionDetails")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetStageExecutionDetailsRequest>newBuilder()
                      .setPath(
                          "/v1b3/projects/{projectId}/locations/{location}/jobs/{jobId}/stages/{stageId}/executionDetails",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetStageExecutionDetailsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "jobId", request.getJobId());
                            serializer.putPathParam(fields, "location", request.getLocation());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            serializer.putPathParam(fields, "stageId", request.getStageId());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetStageExecutionDetailsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "endTime", request.getEndTime());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "startTime", request.getStartTime());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<StageExecutionDetails>newBuilder()
                      .setDefaultInstance(StageExecutionDetails.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetJobMetricsRequest, JobMetrics> getJobMetricsCallable;
  private final UnaryCallable<GetJobExecutionDetailsRequest, JobExecutionDetails>
      getJobExecutionDetailsCallable;
  private final UnaryCallable<GetJobExecutionDetailsRequest, GetJobExecutionDetailsPagedResponse>
      getJobExecutionDetailsPagedCallable;
  private final UnaryCallable<GetStageExecutionDetailsRequest, StageExecutionDetails>
      getStageExecutionDetailsCallable;
  private final UnaryCallable<
          GetStageExecutionDetailsRequest, GetStageExecutionDetailsPagedResponse>
      getStageExecutionDetailsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonMetricsV1Beta3Stub create(MetricsV1Beta3StubSettings settings)
      throws IOException {
    return new HttpJsonMetricsV1Beta3Stub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonMetricsV1Beta3Stub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonMetricsV1Beta3Stub(
        MetricsV1Beta3StubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonMetricsV1Beta3Stub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonMetricsV1Beta3Stub(
        MetricsV1Beta3StubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonMetricsV1Beta3Stub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonMetricsV1Beta3Stub(
      MetricsV1Beta3StubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonMetricsV1Beta3CallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonMetricsV1Beta3Stub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonMetricsV1Beta3Stub(
      MetricsV1Beta3StubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetJobMetricsRequest, JobMetrics> getJobMetricsTransportSettings =
        HttpJsonCallSettings.<GetJobMetricsRequest, JobMetrics>newBuilder()
            .setMethodDescriptor(getJobMetricsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetJobExecutionDetailsRequest, JobExecutionDetails>
        getJobExecutionDetailsTransportSettings =
            HttpJsonCallSettings.<GetJobExecutionDetailsRequest, JobExecutionDetails>newBuilder()
                .setMethodDescriptor(getJobExecutionDetailsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetStageExecutionDetailsRequest, StageExecutionDetails>
        getStageExecutionDetailsTransportSettings =
            HttpJsonCallSettings
                .<GetStageExecutionDetailsRequest, StageExecutionDetails>newBuilder()
                .setMethodDescriptor(getStageExecutionDetailsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.getJobMetricsCallable =
        callableFactory.createUnaryCallable(
            getJobMetricsTransportSettings, settings.getJobMetricsSettings(), clientContext);
    this.getJobExecutionDetailsCallable =
        callableFactory.createUnaryCallable(
            getJobExecutionDetailsTransportSettings,
            settings.getJobExecutionDetailsSettings(),
            clientContext);
    this.getJobExecutionDetailsPagedCallable =
        callableFactory.createPagedCallable(
            getJobExecutionDetailsTransportSettings,
            settings.getJobExecutionDetailsSettings(),
            clientContext);
    this.getStageExecutionDetailsCallable =
        callableFactory.createUnaryCallable(
            getStageExecutionDetailsTransportSettings,
            settings.getStageExecutionDetailsSettings(),
            clientContext);
    this.getStageExecutionDetailsPagedCallable =
        callableFactory.createPagedCallable(
            getStageExecutionDetailsTransportSettings,
            settings.getStageExecutionDetailsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getJobMetricsMethodDescriptor);
    methodDescriptors.add(getJobExecutionDetailsMethodDescriptor);
    methodDescriptors.add(getStageExecutionDetailsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetJobMetricsRequest, JobMetrics> getJobMetricsCallable() {
    return getJobMetricsCallable;
  }

  @Override
  public UnaryCallable<GetJobExecutionDetailsRequest, JobExecutionDetails>
      getJobExecutionDetailsCallable() {
    return getJobExecutionDetailsCallable;
  }

  @Override
  public UnaryCallable<GetJobExecutionDetailsRequest, GetJobExecutionDetailsPagedResponse>
      getJobExecutionDetailsPagedCallable() {
    return getJobExecutionDetailsPagedCallable;
  }

  @Override
  public UnaryCallable<GetStageExecutionDetailsRequest, StageExecutionDetails>
      getStageExecutionDetailsCallable() {
    return getStageExecutionDetailsCallable;
  }

  @Override
  public UnaryCallable<GetStageExecutionDetailsRequest, GetStageExecutionDetailsPagedResponse>
      getStageExecutionDetailsPagedCallable() {
    return getStageExecutionDetailsPagedCallable;
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
