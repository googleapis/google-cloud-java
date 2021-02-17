/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.video.transcoder.v1beta1.stub;

import static com.google.cloud.video.transcoder.v1beta1.TranscoderServiceClient.ListJobTemplatesPagedResponse;
import static com.google.cloud.video.transcoder.v1beta1.TranscoderServiceClient.ListJobsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.video.transcoder.v1beta1.CreateJobRequest;
import com.google.cloud.video.transcoder.v1beta1.CreateJobTemplateRequest;
import com.google.cloud.video.transcoder.v1beta1.DeleteJobRequest;
import com.google.cloud.video.transcoder.v1beta1.DeleteJobTemplateRequest;
import com.google.cloud.video.transcoder.v1beta1.GetJobRequest;
import com.google.cloud.video.transcoder.v1beta1.GetJobTemplateRequest;
import com.google.cloud.video.transcoder.v1beta1.Job;
import com.google.cloud.video.transcoder.v1beta1.JobTemplate;
import com.google.cloud.video.transcoder.v1beta1.ListJobTemplatesRequest;
import com.google.cloud.video.transcoder.v1beta1.ListJobTemplatesResponse;
import com.google.cloud.video.transcoder.v1beta1.ListJobsRequest;
import com.google.cloud.video.transcoder.v1beta1.ListJobsResponse;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the TranscoderService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcTranscoderServiceStub extends TranscoderServiceStub {
  private static final MethodDescriptor<CreateJobRequest, Job> createJobMethodDescriptor =
      MethodDescriptor.<CreateJobRequest, Job>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.video.transcoder.v1beta1.TranscoderService/CreateJob")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateJobRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Job.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListJobsRequest, ListJobsResponse>
      listJobsMethodDescriptor =
          MethodDescriptor.<ListJobsRequest, ListJobsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.video.transcoder.v1beta1.TranscoderService/ListJobs")
              .setRequestMarshaller(ProtoUtils.marshaller(ListJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListJobsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetJobRequest, Job> getJobMethodDescriptor =
      MethodDescriptor.<GetJobRequest, Job>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.video.transcoder.v1beta1.TranscoderService/GetJob")
          .setRequestMarshaller(ProtoUtils.marshaller(GetJobRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Job.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteJobRequest, Empty> deleteJobMethodDescriptor =
      MethodDescriptor.<DeleteJobRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.video.transcoder.v1beta1.TranscoderService/DeleteJob")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteJobRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateJobTemplateRequest, JobTemplate>
      createJobTemplateMethodDescriptor =
          MethodDescriptor.<CreateJobTemplateRequest, JobTemplate>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.video.transcoder.v1beta1.TranscoderService/CreateJobTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateJobTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(JobTemplate.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListJobTemplatesRequest, ListJobTemplatesResponse>
      listJobTemplatesMethodDescriptor =
          MethodDescriptor.<ListJobTemplatesRequest, ListJobTemplatesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.video.transcoder.v1beta1.TranscoderService/ListJobTemplates")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListJobTemplatesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListJobTemplatesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetJobTemplateRequest, JobTemplate>
      getJobTemplateMethodDescriptor =
          MethodDescriptor.<GetJobTemplateRequest, JobTemplate>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.video.transcoder.v1beta1.TranscoderService/GetJobTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetJobTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(JobTemplate.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteJobTemplateRequest, Empty>
      deleteJobTemplateMethodDescriptor =
          MethodDescriptor.<DeleteJobTemplateRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.video.transcoder.v1beta1.TranscoderService/DeleteJobTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteJobTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateJobRequest, Job> createJobCallable;
  private final UnaryCallable<ListJobsRequest, ListJobsResponse> listJobsCallable;
  private final UnaryCallable<ListJobsRequest, ListJobsPagedResponse> listJobsPagedCallable;
  private final UnaryCallable<GetJobRequest, Job> getJobCallable;
  private final UnaryCallable<DeleteJobRequest, Empty> deleteJobCallable;
  private final UnaryCallable<CreateJobTemplateRequest, JobTemplate> createJobTemplateCallable;
  private final UnaryCallable<ListJobTemplatesRequest, ListJobTemplatesResponse>
      listJobTemplatesCallable;
  private final UnaryCallable<ListJobTemplatesRequest, ListJobTemplatesPagedResponse>
      listJobTemplatesPagedCallable;
  private final UnaryCallable<GetJobTemplateRequest, JobTemplate> getJobTemplateCallable;
  private final UnaryCallable<DeleteJobTemplateRequest, Empty> deleteJobTemplateCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcTranscoderServiceStub create(TranscoderServiceStubSettings settings)
      throws IOException {
    return new GrpcTranscoderServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcTranscoderServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcTranscoderServiceStub(
        TranscoderServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcTranscoderServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcTranscoderServiceStub(
        TranscoderServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcTranscoderServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcTranscoderServiceStub(
      TranscoderServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcTranscoderServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcTranscoderServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcTranscoderServiceStub(
      TranscoderServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateJobRequest, Job> createJobTransportSettings =
        GrpcCallSettings.<CreateJobRequest, Job>newBuilder()
            .setMethodDescriptor(createJobMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateJobRequest>() {
                  @Override
                  public Map<String, String> extract(CreateJobRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListJobsRequest, ListJobsResponse> listJobsTransportSettings =
        GrpcCallSettings.<ListJobsRequest, ListJobsResponse>newBuilder()
            .setMethodDescriptor(listJobsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListJobsRequest>() {
                  @Override
                  public Map<String, String> extract(ListJobsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetJobRequest, Job> getJobTransportSettings =
        GrpcCallSettings.<GetJobRequest, Job>newBuilder()
            .setMethodDescriptor(getJobMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetJobRequest>() {
                  @Override
                  public Map<String, String> extract(GetJobRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteJobRequest, Empty> deleteJobTransportSettings =
        GrpcCallSettings.<DeleteJobRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteJobMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteJobRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteJobRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateJobTemplateRequest, JobTemplate> createJobTemplateTransportSettings =
        GrpcCallSettings.<CreateJobTemplateRequest, JobTemplate>newBuilder()
            .setMethodDescriptor(createJobTemplateMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateJobTemplateRequest>() {
                  @Override
                  public Map<String, String> extract(CreateJobTemplateRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListJobTemplatesRequest, ListJobTemplatesResponse>
        listJobTemplatesTransportSettings =
            GrpcCallSettings.<ListJobTemplatesRequest, ListJobTemplatesResponse>newBuilder()
                .setMethodDescriptor(listJobTemplatesMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListJobTemplatesRequest>() {
                      @Override
                      public Map<String, String> extract(ListJobTemplatesRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<GetJobTemplateRequest, JobTemplate> getJobTemplateTransportSettings =
        GrpcCallSettings.<GetJobTemplateRequest, JobTemplate>newBuilder()
            .setMethodDescriptor(getJobTemplateMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetJobTemplateRequest>() {
                  @Override
                  public Map<String, String> extract(GetJobTemplateRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteJobTemplateRequest, Empty> deleteJobTemplateTransportSettings =
        GrpcCallSettings.<DeleteJobTemplateRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteJobTemplateMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteJobTemplateRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteJobTemplateRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();

    this.createJobCallable =
        callableFactory.createUnaryCallable(
            createJobTransportSettings, settings.createJobSettings(), clientContext);
    this.listJobsCallable =
        callableFactory.createUnaryCallable(
            listJobsTransportSettings, settings.listJobsSettings(), clientContext);
    this.listJobsPagedCallable =
        callableFactory.createPagedCallable(
            listJobsTransportSettings, settings.listJobsSettings(), clientContext);
    this.getJobCallable =
        callableFactory.createUnaryCallable(
            getJobTransportSettings, settings.getJobSettings(), clientContext);
    this.deleteJobCallable =
        callableFactory.createUnaryCallable(
            deleteJobTransportSettings, settings.deleteJobSettings(), clientContext);
    this.createJobTemplateCallable =
        callableFactory.createUnaryCallable(
            createJobTemplateTransportSettings,
            settings.createJobTemplateSettings(),
            clientContext);
    this.listJobTemplatesCallable =
        callableFactory.createUnaryCallable(
            listJobTemplatesTransportSettings, settings.listJobTemplatesSettings(), clientContext);
    this.listJobTemplatesPagedCallable =
        callableFactory.createPagedCallable(
            listJobTemplatesTransportSettings, settings.listJobTemplatesSettings(), clientContext);
    this.getJobTemplateCallable =
        callableFactory.createUnaryCallable(
            getJobTemplateTransportSettings, settings.getJobTemplateSettings(), clientContext);
    this.deleteJobTemplateCallable =
        callableFactory.createUnaryCallable(
            deleteJobTemplateTransportSettings,
            settings.deleteJobTemplateSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateJobRequest, Job> createJobCallable() {
    return createJobCallable;
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
  public UnaryCallable<GetJobRequest, Job> getJobCallable() {
    return getJobCallable;
  }

  @Override
  public UnaryCallable<DeleteJobRequest, Empty> deleteJobCallable() {
    return deleteJobCallable;
  }

  @Override
  public UnaryCallable<CreateJobTemplateRequest, JobTemplate> createJobTemplateCallable() {
    return createJobTemplateCallable;
  }

  @Override
  public UnaryCallable<ListJobTemplatesRequest, ListJobTemplatesResponse>
      listJobTemplatesCallable() {
    return listJobTemplatesCallable;
  }

  @Override
  public UnaryCallable<ListJobTemplatesRequest, ListJobTemplatesPagedResponse>
      listJobTemplatesPagedCallable() {
    return listJobTemplatesPagedCallable;
  }

  @Override
  public UnaryCallable<GetJobTemplateRequest, JobTemplate> getJobTemplateCallable() {
    return getJobTemplateCallable;
  }

  @Override
  public UnaryCallable<DeleteJobTemplateRequest, Empty> deleteJobTemplateCallable() {
    return deleteJobTemplateCallable;
  }

  @Override
  public final void close() {
    shutdown();
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
