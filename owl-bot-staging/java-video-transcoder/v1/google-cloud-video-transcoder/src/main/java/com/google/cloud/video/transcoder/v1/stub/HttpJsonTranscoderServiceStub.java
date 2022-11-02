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

package com.google.cloud.video.transcoder.v1.stub;

import static com.google.cloud.video.transcoder.v1.TranscoderServiceClient.ListJobTemplatesPagedResponse;
import static com.google.cloud.video.transcoder.v1.TranscoderServiceClient.ListJobsPagedResponse;

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
import com.google.cloud.video.transcoder.v1.CreateJobRequest;
import com.google.cloud.video.transcoder.v1.CreateJobTemplateRequest;
import com.google.cloud.video.transcoder.v1.DeleteJobRequest;
import com.google.cloud.video.transcoder.v1.DeleteJobTemplateRequest;
import com.google.cloud.video.transcoder.v1.GetJobRequest;
import com.google.cloud.video.transcoder.v1.GetJobTemplateRequest;
import com.google.cloud.video.transcoder.v1.Job;
import com.google.cloud.video.transcoder.v1.JobTemplate;
import com.google.cloud.video.transcoder.v1.ListJobTemplatesRequest;
import com.google.cloud.video.transcoder.v1.ListJobTemplatesResponse;
import com.google.cloud.video.transcoder.v1.ListJobsRequest;
import com.google.cloud.video.transcoder.v1.ListJobsResponse;
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
 * REST stub implementation for the TranscoderService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonTranscoderServiceStub extends TranscoderServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateJobRequest, Job> createJobMethodDescriptor =
      ApiMethodDescriptor.<CreateJobRequest, Job>newBuilder()
          .setFullMethodName("google.cloud.video.transcoder.v1.TranscoderService/CreateJob")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CreateJobRequest>newBuilder()
                  .setPath(
                      "/v1/{parent=projects/*/locations/*}/jobs",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CreateJobRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "parent", request.getParent());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CreateJobRequest> serializer =
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
              .setFullMethodName("google.cloud.video.transcoder.v1.TranscoderService/ListJobs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListJobsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/jobs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListJobsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListJobsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
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

  private static final ApiMethodDescriptor<GetJobRequest, Job> getJobMethodDescriptor =
      ApiMethodDescriptor.<GetJobRequest, Job>newBuilder()
          .setFullMethodName("google.cloud.video.transcoder.v1.TranscoderService/GetJob")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetJobRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/jobs/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetJobRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
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

  private static final ApiMethodDescriptor<DeleteJobRequest, Empty> deleteJobMethodDescriptor =
      ApiMethodDescriptor.<DeleteJobRequest, Empty>newBuilder()
          .setFullMethodName("google.cloud.video.transcoder.v1.TranscoderService/DeleteJob")
          .setHttpMethod("DELETE")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteJobRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/jobs/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteJobRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteJobRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "allowMissing", request.getAllowMissing());
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

  private static final ApiMethodDescriptor<CreateJobTemplateRequest, JobTemplate>
      createJobTemplateMethodDescriptor =
          ApiMethodDescriptor.<CreateJobTemplateRequest, JobTemplate>newBuilder()
              .setFullMethodName(
                  "google.cloud.video.transcoder.v1.TranscoderService/CreateJobTemplate")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateJobTemplateRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/jobTemplates",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateJobTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateJobTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "jobTemplateId", request.getJobTemplateId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("jobTemplate", request.getJobTemplate(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<JobTemplate>newBuilder()
                      .setDefaultInstance(JobTemplate.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListJobTemplatesRequest, ListJobTemplatesResponse>
      listJobTemplatesMethodDescriptor =
          ApiMethodDescriptor.<ListJobTemplatesRequest, ListJobTemplatesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.video.transcoder.v1.TranscoderService/ListJobTemplates")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListJobTemplatesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/jobTemplates",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListJobTemplatesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListJobTemplatesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListJobTemplatesResponse>newBuilder()
                      .setDefaultInstance(ListJobTemplatesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetJobTemplateRequest, JobTemplate>
      getJobTemplateMethodDescriptor =
          ApiMethodDescriptor.<GetJobTemplateRequest, JobTemplate>newBuilder()
              .setFullMethodName(
                  "google.cloud.video.transcoder.v1.TranscoderService/GetJobTemplate")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetJobTemplateRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/jobTemplates/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetJobTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetJobTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<JobTemplate>newBuilder()
                      .setDefaultInstance(JobTemplate.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteJobTemplateRequest, Empty>
      deleteJobTemplateMethodDescriptor =
          ApiMethodDescriptor.<DeleteJobTemplateRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.video.transcoder.v1.TranscoderService/DeleteJobTemplate")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteJobTemplateRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/jobTemplates/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteJobTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteJobTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
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
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonTranscoderServiceStub create(TranscoderServiceStubSettings settings)
      throws IOException {
    return new HttpJsonTranscoderServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonTranscoderServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonTranscoderServiceStub(
        TranscoderServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonTranscoderServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonTranscoderServiceStub(
        TranscoderServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonTranscoderServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonTranscoderServiceStub(
      TranscoderServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonTranscoderServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonTranscoderServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonTranscoderServiceStub(
      TranscoderServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateJobRequest, Job> createJobTransportSettings =
        HttpJsonCallSettings.<CreateJobRequest, Job>newBuilder()
            .setMethodDescriptor(createJobMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListJobsRequest, ListJobsResponse> listJobsTransportSettings =
        HttpJsonCallSettings.<ListJobsRequest, ListJobsResponse>newBuilder()
            .setMethodDescriptor(listJobsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetJobRequest, Job> getJobTransportSettings =
        HttpJsonCallSettings.<GetJobRequest, Job>newBuilder()
            .setMethodDescriptor(getJobMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteJobRequest, Empty> deleteJobTransportSettings =
        HttpJsonCallSettings.<DeleteJobRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteJobMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateJobTemplateRequest, JobTemplate> createJobTemplateTransportSettings =
        HttpJsonCallSettings.<CreateJobTemplateRequest, JobTemplate>newBuilder()
            .setMethodDescriptor(createJobTemplateMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListJobTemplatesRequest, ListJobTemplatesResponse>
        listJobTemplatesTransportSettings =
            HttpJsonCallSettings.<ListJobTemplatesRequest, ListJobTemplatesResponse>newBuilder()
                .setMethodDescriptor(listJobTemplatesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetJobTemplateRequest, JobTemplate> getJobTemplateTransportSettings =
        HttpJsonCallSettings.<GetJobTemplateRequest, JobTemplate>newBuilder()
            .setMethodDescriptor(getJobTemplateMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteJobTemplateRequest, Empty> deleteJobTemplateTransportSettings =
        HttpJsonCallSettings.<DeleteJobTemplateRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteJobTemplateMethodDescriptor)
            .setTypeRegistry(typeRegistry)
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

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createJobMethodDescriptor);
    methodDescriptors.add(listJobsMethodDescriptor);
    methodDescriptors.add(getJobMethodDescriptor);
    methodDescriptors.add(deleteJobMethodDescriptor);
    methodDescriptors.add(createJobTemplateMethodDescriptor);
    methodDescriptors.add(listJobTemplatesMethodDescriptor);
    methodDescriptors.add(getJobTemplateMethodDescriptor);
    methodDescriptors.add(deleteJobTemplateMethodDescriptor);
    return methodDescriptors;
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
