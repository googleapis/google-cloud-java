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

import static com.google.dataflow.v1beta3.JobsV1Beta3Client.AggregatedListJobsPagedResponse;
import static com.google.dataflow.v1beta3.JobsV1Beta3Client.ListJobsPagedResponse;

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
import com.google.dataflow.v1beta3.CreateJobRequest;
import com.google.dataflow.v1beta3.GetJobRequest;
import com.google.dataflow.v1beta3.Job;
import com.google.dataflow.v1beta3.ListJobsRequest;
import com.google.dataflow.v1beta3.ListJobsResponse;
import com.google.dataflow.v1beta3.Snapshot;
import com.google.dataflow.v1beta3.SnapshotJobRequest;
import com.google.dataflow.v1beta3.UpdateJobRequest;
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
 * REST stub implementation for the JobsV1Beta3 service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonJobsV1Beta3Stub extends JobsV1Beta3Stub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateJobRequest, Job> createJobMethodDescriptor =
      ApiMethodDescriptor.<CreateJobRequest, Job>newBuilder()
          .setFullMethodName("google.dataflow.v1beta3.JobsV1Beta3/CreateJob")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CreateJobRequest>newBuilder()
                  .setPath(
                      "/v1b3/projects/{projectId}/locations/{location}/jobs",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CreateJobRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "location", request.getLocation());
                        serializer.putPathParam(fields, "projectId", request.getProjectId());
                        return fields;
                      })
                  .setAdditionalPaths("/v1b3/projects/{projectId}/jobs")
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CreateJobRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "replaceJobId", request.getReplaceJobId());
                        serializer.putQueryParam(fields, "view", request.getView());
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("job", request.getJob(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Job>newBuilder()
                  .setDefaultInstance(Job.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<GetJobRequest, Job> getJobMethodDescriptor =
      ApiMethodDescriptor.<GetJobRequest, Job>newBuilder()
          .setFullMethodName("google.dataflow.v1beta3.JobsV1Beta3/GetJob")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetJobRequest>newBuilder()
                  .setPath(
                      "/v1b3/projects/{projectId}/locations/{location}/jobs/{jobId}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetJobRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "jobId", request.getJobId());
                        serializer.putPathParam(fields, "location", request.getLocation());
                        serializer.putPathParam(fields, "projectId", request.getProjectId());
                        return fields;
                      })
                  .setAdditionalPaths("/v1b3/projects/{projectId}/jobs/{jobId}")
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetJobRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "view", request.getView());
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Job>newBuilder()
                  .setDefaultInstance(Job.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<UpdateJobRequest, Job> updateJobMethodDescriptor =
      ApiMethodDescriptor.<UpdateJobRequest, Job>newBuilder()
          .setFullMethodName("google.dataflow.v1beta3.JobsV1Beta3/UpdateJob")
          .setHttpMethod("PUT")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateJobRequest>newBuilder()
                  .setPath(
                      "/v1b3/projects/{projectId}/locations/{location}/jobs/{jobId}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateJobRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "jobId", request.getJobId());
                        serializer.putPathParam(fields, "location", request.getLocation());
                        serializer.putPathParam(fields, "projectId", request.getProjectId());
                        return fields;
                      })
                  .setAdditionalPaths("/v1b3/projects/{projectId}/jobs/{jobId}")
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateJobRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("job", request.getJob(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Job>newBuilder()
                  .setDefaultInstance(Job.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListJobsRequest, ListJobsResponse>
      listJobsMethodDescriptor =
          ApiMethodDescriptor.<ListJobsRequest, ListJobsResponse>newBuilder()
              .setFullMethodName("google.dataflow.v1beta3.JobsV1Beta3/ListJobs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListJobsRequest>newBuilder()
                      .setPath(
                          "/v1b3/projects/{projectId}/locations/{location}/jobs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListJobsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "location", request.getLocation());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            return fields;
                          })
                      .setAdditionalPaths("/v1b3/projects/{projectId}/jobs")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListJobsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "view", request.getView());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListJobsResponse>newBuilder()
                      .setDefaultInstance(ListJobsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListJobsRequest, ListJobsResponse>
      aggregatedListJobsMethodDescriptor =
          ApiMethodDescriptor.<ListJobsRequest, ListJobsResponse>newBuilder()
              .setFullMethodName("google.dataflow.v1beta3.JobsV1Beta3/AggregatedListJobs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListJobsRequest>newBuilder()
                      .setPath(
                          "/v1b3/projects/{projectId}/jobs:aggregated",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListJobsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListJobsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "location", request.getLocation());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "view", request.getView());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListJobsResponse>newBuilder()
                      .setDefaultInstance(ListJobsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SnapshotJobRequest, Snapshot>
      snapshotJobMethodDescriptor =
          ApiMethodDescriptor.<SnapshotJobRequest, Snapshot>newBuilder()
              .setFullMethodName("google.dataflow.v1beta3.JobsV1Beta3/SnapshotJob")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SnapshotJobRequest>newBuilder()
                      .setPath(
                          "/v1b3/projects/{projectId}/locations/{location}/jobs/{jobId}:snapshot",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SnapshotJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "jobId", request.getJobId());
                            serializer.putPathParam(fields, "location", request.getLocation());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            return fields;
                          })
                      .setAdditionalPaths("/v1b3/projects/{projectId}/jobs/{jobId}:snapshot")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SnapshotJobRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request.toBuilder()
                                          .clearJobId()
                                          .clearLocation()
                                          .clearProjectId()
                                          .build(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Snapshot>newBuilder()
                      .setDefaultInstance(Snapshot.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateJobRequest, Job> createJobCallable;
  private final UnaryCallable<GetJobRequest, Job> getJobCallable;
  private final UnaryCallable<UpdateJobRequest, Job> updateJobCallable;
  private final UnaryCallable<ListJobsRequest, ListJobsResponse> listJobsCallable;
  private final UnaryCallable<ListJobsRequest, ListJobsPagedResponse> listJobsPagedCallable;
  private final UnaryCallable<ListJobsRequest, ListJobsResponse> aggregatedListJobsCallable;
  private final UnaryCallable<ListJobsRequest, AggregatedListJobsPagedResponse>
      aggregatedListJobsPagedCallable;
  private final UnaryCallable<SnapshotJobRequest, Snapshot> snapshotJobCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonJobsV1Beta3Stub create(JobsV1Beta3StubSettings settings)
      throws IOException {
    return new HttpJsonJobsV1Beta3Stub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonJobsV1Beta3Stub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonJobsV1Beta3Stub(
        JobsV1Beta3StubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonJobsV1Beta3Stub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonJobsV1Beta3Stub(
        JobsV1Beta3StubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonJobsV1Beta3Stub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonJobsV1Beta3Stub(JobsV1Beta3StubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonJobsV1Beta3CallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonJobsV1Beta3Stub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonJobsV1Beta3Stub(
      JobsV1Beta3StubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateJobRequest, Job> createJobTransportSettings =
        HttpJsonCallSettings.<CreateJobRequest, Job>newBuilder()
            .setMethodDescriptor(createJobMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetJobRequest, Job> getJobTransportSettings =
        HttpJsonCallSettings.<GetJobRequest, Job>newBuilder()
            .setMethodDescriptor(getJobMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateJobRequest, Job> updateJobTransportSettings =
        HttpJsonCallSettings.<UpdateJobRequest, Job>newBuilder()
            .setMethodDescriptor(updateJobMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListJobsRequest, ListJobsResponse> listJobsTransportSettings =
        HttpJsonCallSettings.<ListJobsRequest, ListJobsResponse>newBuilder()
            .setMethodDescriptor(listJobsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListJobsRequest, ListJobsResponse> aggregatedListJobsTransportSettings =
        HttpJsonCallSettings.<ListJobsRequest, ListJobsResponse>newBuilder()
            .setMethodDescriptor(aggregatedListJobsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SnapshotJobRequest, Snapshot> snapshotJobTransportSettings =
        HttpJsonCallSettings.<SnapshotJobRequest, Snapshot>newBuilder()
            .setMethodDescriptor(snapshotJobMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.createJobCallable =
        callableFactory.createUnaryCallable(
            createJobTransportSettings, settings.createJobSettings(), clientContext);
    this.getJobCallable =
        callableFactory.createUnaryCallable(
            getJobTransportSettings, settings.getJobSettings(), clientContext);
    this.updateJobCallable =
        callableFactory.createUnaryCallable(
            updateJobTransportSettings, settings.updateJobSettings(), clientContext);
    this.listJobsCallable =
        callableFactory.createUnaryCallable(
            listJobsTransportSettings, settings.listJobsSettings(), clientContext);
    this.listJobsPagedCallable =
        callableFactory.createPagedCallable(
            listJobsTransportSettings, settings.listJobsSettings(), clientContext);
    this.aggregatedListJobsCallable =
        callableFactory.createUnaryCallable(
            aggregatedListJobsTransportSettings,
            settings.aggregatedListJobsSettings(),
            clientContext);
    this.aggregatedListJobsPagedCallable =
        callableFactory.createPagedCallable(
            aggregatedListJobsTransportSettings,
            settings.aggregatedListJobsSettings(),
            clientContext);
    this.snapshotJobCallable =
        callableFactory.createUnaryCallable(
            snapshotJobTransportSettings, settings.snapshotJobSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createJobMethodDescriptor);
    methodDescriptors.add(getJobMethodDescriptor);
    methodDescriptors.add(updateJobMethodDescriptor);
    methodDescriptors.add(listJobsMethodDescriptor);
    methodDescriptors.add(aggregatedListJobsMethodDescriptor);
    methodDescriptors.add(snapshotJobMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateJobRequest, Job> createJobCallable() {
    return createJobCallable;
  }

  @Override
  public UnaryCallable<GetJobRequest, Job> getJobCallable() {
    return getJobCallable;
  }

  @Override
  public UnaryCallable<UpdateJobRequest, Job> updateJobCallable() {
    return updateJobCallable;
  }

  @Override
  public UnaryCallable<ListJobsRequest, ListJobsResponse> listJobsCallable() {
    return listJobsCallable;
  }

  @Override
  public UnaryCallable<ListJobsRequest, ListJobsPagedResponse> listJobsPagedCallable() {
    return listJobsPagedCallable;
  }

  @Override
  public UnaryCallable<ListJobsRequest, ListJobsResponse> aggregatedListJobsCallable() {
    return aggregatedListJobsCallable;
  }

  @Override
  public UnaryCallable<ListJobsRequest, AggregatedListJobsPagedResponse>
      aggregatedListJobsPagedCallable() {
    return aggregatedListJobsPagedCallable;
  }

  @Override
  public UnaryCallable<SnapshotJobRequest, Snapshot> snapshotJobCallable() {
    return snapshotJobCallable;
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
