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

package com.google.cloud.dataproc.v1.stub;

import static com.google.cloud.dataproc.v1.JobControllerClient.ListJobsPagedResponse;

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
import com.google.cloud.dataproc.v1.CancelJobRequest;
import com.google.cloud.dataproc.v1.DeleteJobRequest;
import com.google.cloud.dataproc.v1.GetJobRequest;
import com.google.cloud.dataproc.v1.Job;
import com.google.cloud.dataproc.v1.JobMetadata;
import com.google.cloud.dataproc.v1.ListJobsRequest;
import com.google.cloud.dataproc.v1.ListJobsResponse;
import com.google.cloud.dataproc.v1.SubmitJobRequest;
import com.google.cloud.dataproc.v1.UpdateJobRequest;
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
 * REST stub implementation for the JobController service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonJobControllerStub extends JobControllerStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(JobMetadata.getDescriptor()).add(Job.getDescriptor()).build();

  private static final ApiMethodDescriptor<SubmitJobRequest, Job> submitJobMethodDescriptor =
      ApiMethodDescriptor.<SubmitJobRequest, Job>newBuilder()
          .setFullMethodName("google.cloud.dataproc.v1.JobController/SubmitJob")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<SubmitJobRequest>newBuilder()
                  .setPath(
                      "/v1/projects/{projectId}/regions/{region}/jobs:submit",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<SubmitJobRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "projectId", request.getProjectId());
                        serializer.putPathParam(fields, "region", request.getRegion());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<SubmitJobRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody(
                                  "*",
                                  request.toBuilder().clearProjectId().clearRegion().build(),
                                  false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Job>newBuilder()
                  .setDefaultInstance(Job.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<SubmitJobRequest, Operation>
      submitJobAsOperationMethodDescriptor =
          ApiMethodDescriptor.<SubmitJobRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dataproc.v1.JobController/SubmitJobAsOperation")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SubmitJobRequest>newBuilder()
                      .setPath(
                          "/v1/projects/{projectId}/regions/{region}/jobs:submitAsOperation",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SubmitJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SubmitJobRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request.toBuilder().clearProjectId().clearRegion().build(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (SubmitJobRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetJobRequest, Job> getJobMethodDescriptor =
      ApiMethodDescriptor.<GetJobRequest, Job>newBuilder()
          .setFullMethodName("google.cloud.dataproc.v1.JobController/GetJob")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetJobRequest>newBuilder()
                  .setPath(
                      "/v1/projects/{projectId}/regions/{region}/jobs/{jobId}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetJobRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "jobId", request.getJobId());
                        serializer.putPathParam(fields, "projectId", request.getProjectId());
                        serializer.putPathParam(fields, "region", request.getRegion());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetJobRequest> serializer =
                            ProtoRestSerializer.create();
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

  private static final ApiMethodDescriptor<ListJobsRequest, ListJobsResponse>
      listJobsMethodDescriptor =
          ApiMethodDescriptor.<ListJobsRequest, ListJobsResponse>newBuilder()
              .setFullMethodName("google.cloud.dataproc.v1.JobController/ListJobs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListJobsRequest>newBuilder()
                      .setPath(
                          "/v1/projects/{projectId}/regions/{region}/jobs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListJobsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListJobsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "clusterName", request.getClusterName());
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(
                                fields, "jobStateMatcher", request.getJobStateMatcherValue());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
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

  private static final ApiMethodDescriptor<UpdateJobRequest, Job> updateJobMethodDescriptor =
      ApiMethodDescriptor.<UpdateJobRequest, Job>newBuilder()
          .setFullMethodName("google.cloud.dataproc.v1.JobController/UpdateJob")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateJobRequest>newBuilder()
                  .setPath(
                      "/v1/projects/{projectId}/regions/{region}/jobs/{jobId}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateJobRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "jobId", request.getJobId());
                        serializer.putPathParam(fields, "projectId", request.getProjectId());
                        serializer.putPathParam(fields, "region", request.getRegion());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateJobRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
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

  private static final ApiMethodDescriptor<CancelJobRequest, Job> cancelJobMethodDescriptor =
      ApiMethodDescriptor.<CancelJobRequest, Job>newBuilder()
          .setFullMethodName("google.cloud.dataproc.v1.JobController/CancelJob")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CancelJobRequest>newBuilder()
                  .setPath(
                      "/v1/projects/{projectId}/regions/{region}/jobs/{jobId}:cancel",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CancelJobRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "jobId", request.getJobId());
                        serializer.putPathParam(fields, "projectId", request.getProjectId());
                        serializer.putPathParam(fields, "region", request.getRegion());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CancelJobRequest> serializer =
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
                                      .clearProjectId()
                                      .clearRegion()
                                      .build(),
                                  false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Job>newBuilder()
                  .setDefaultInstance(Job.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<DeleteJobRequest, Empty> deleteJobMethodDescriptor =
      ApiMethodDescriptor.<DeleteJobRequest, Empty>newBuilder()
          .setFullMethodName("google.cloud.dataproc.v1.JobController/DeleteJob")
          .setHttpMethod("DELETE")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteJobRequest>newBuilder()
                  .setPath(
                      "/v1/projects/{projectId}/regions/{region}/jobs/{jobId}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteJobRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "jobId", request.getJobId());
                        serializer.putPathParam(fields, "projectId", request.getProjectId());
                        serializer.putPathParam(fields, "region", request.getRegion());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteJobRequest> serializer =
                            ProtoRestSerializer.create();
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

  private final UnaryCallable<SubmitJobRequest, Job> submitJobCallable;
  private final UnaryCallable<SubmitJobRequest, Operation> submitJobAsOperationCallable;
  private final OperationCallable<SubmitJobRequest, Job, JobMetadata>
      submitJobAsOperationOperationCallable;
  private final UnaryCallable<GetJobRequest, Job> getJobCallable;
  private final UnaryCallable<ListJobsRequest, ListJobsResponse> listJobsCallable;
  private final UnaryCallable<ListJobsRequest, ListJobsPagedResponse> listJobsPagedCallable;
  private final UnaryCallable<UpdateJobRequest, Job> updateJobCallable;
  private final UnaryCallable<CancelJobRequest, Job> cancelJobCallable;
  private final UnaryCallable<DeleteJobRequest, Empty> deleteJobCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonJobControllerStub create(JobControllerStubSettings settings)
      throws IOException {
    return new HttpJsonJobControllerStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonJobControllerStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonJobControllerStub(
        JobControllerStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonJobControllerStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonJobControllerStub(
        JobControllerStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonJobControllerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonJobControllerStub(
      JobControllerStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonJobControllerCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonJobControllerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonJobControllerStub(
      JobControllerStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<SubmitJobRequest, Job> submitJobTransportSettings =
        HttpJsonCallSettings.<SubmitJobRequest, Job>newBuilder()
            .setMethodDescriptor(submitJobMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SubmitJobRequest, Operation> submitJobAsOperationTransportSettings =
        HttpJsonCallSettings.<SubmitJobRequest, Operation>newBuilder()
            .setMethodDescriptor(submitJobAsOperationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetJobRequest, Job> getJobTransportSettings =
        HttpJsonCallSettings.<GetJobRequest, Job>newBuilder()
            .setMethodDescriptor(getJobMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListJobsRequest, ListJobsResponse> listJobsTransportSettings =
        HttpJsonCallSettings.<ListJobsRequest, ListJobsResponse>newBuilder()
            .setMethodDescriptor(listJobsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateJobRequest, Job> updateJobTransportSettings =
        HttpJsonCallSettings.<UpdateJobRequest, Job>newBuilder()
            .setMethodDescriptor(updateJobMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CancelJobRequest, Job> cancelJobTransportSettings =
        HttpJsonCallSettings.<CancelJobRequest, Job>newBuilder()
            .setMethodDescriptor(cancelJobMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteJobRequest, Empty> deleteJobTransportSettings =
        HttpJsonCallSettings.<DeleteJobRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteJobMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.submitJobCallable =
        callableFactory.createUnaryCallable(
            submitJobTransportSettings, settings.submitJobSettings(), clientContext);
    this.submitJobAsOperationCallable =
        callableFactory.createUnaryCallable(
            submitJobAsOperationTransportSettings,
            settings.submitJobAsOperationSettings(),
            clientContext);
    this.submitJobAsOperationOperationCallable =
        callableFactory.createOperationCallable(
            submitJobAsOperationTransportSettings,
            settings.submitJobAsOperationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getJobCallable =
        callableFactory.createUnaryCallable(
            getJobTransportSettings, settings.getJobSettings(), clientContext);
    this.listJobsCallable =
        callableFactory.createUnaryCallable(
            listJobsTransportSettings, settings.listJobsSettings(), clientContext);
    this.listJobsPagedCallable =
        callableFactory.createPagedCallable(
            listJobsTransportSettings, settings.listJobsSettings(), clientContext);
    this.updateJobCallable =
        callableFactory.createUnaryCallable(
            updateJobTransportSettings, settings.updateJobSettings(), clientContext);
    this.cancelJobCallable =
        callableFactory.createUnaryCallable(
            cancelJobTransportSettings, settings.cancelJobSettings(), clientContext);
    this.deleteJobCallable =
        callableFactory.createUnaryCallable(
            deleteJobTransportSettings, settings.deleteJobSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(submitJobMethodDescriptor);
    methodDescriptors.add(submitJobAsOperationMethodDescriptor);
    methodDescriptors.add(getJobMethodDescriptor);
    methodDescriptors.add(listJobsMethodDescriptor);
    methodDescriptors.add(updateJobMethodDescriptor);
    methodDescriptors.add(cancelJobMethodDescriptor);
    methodDescriptors.add(deleteJobMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<SubmitJobRequest, Job> submitJobCallable() {
    return submitJobCallable;
  }

  @Override
  public UnaryCallable<SubmitJobRequest, Operation> submitJobAsOperationCallable() {
    return submitJobAsOperationCallable;
  }

  @Override
  public OperationCallable<SubmitJobRequest, Job, JobMetadata>
      submitJobAsOperationOperationCallable() {
    return submitJobAsOperationOperationCallable;
  }

  @Override
  public UnaryCallable<GetJobRequest, Job> getJobCallable() {
    return getJobCallable;
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
  public UnaryCallable<UpdateJobRequest, Job> updateJobCallable() {
    return updateJobCallable;
  }

  @Override
  public UnaryCallable<CancelJobRequest, Job> cancelJobCallable() {
    return cancelJobCallable;
  }

  @Override
  public UnaryCallable<DeleteJobRequest, Empty> deleteJobCallable() {
    return deleteJobCallable;
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
