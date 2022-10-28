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

package com.google.cloud.talent.v4.stub;

import static com.google.cloud.talent.v4.JobServiceClient.ListJobsPagedResponse;

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
import com.google.cloud.talent.v4.BatchCreateJobsRequest;
import com.google.cloud.talent.v4.BatchCreateJobsResponse;
import com.google.cloud.talent.v4.BatchDeleteJobsRequest;
import com.google.cloud.talent.v4.BatchDeleteJobsResponse;
import com.google.cloud.talent.v4.BatchOperationMetadata;
import com.google.cloud.talent.v4.BatchUpdateJobsRequest;
import com.google.cloud.talent.v4.BatchUpdateJobsResponse;
import com.google.cloud.talent.v4.CreateJobRequest;
import com.google.cloud.talent.v4.DeleteJobRequest;
import com.google.cloud.talent.v4.GetJobRequest;
import com.google.cloud.talent.v4.Job;
import com.google.cloud.talent.v4.ListJobsRequest;
import com.google.cloud.talent.v4.ListJobsResponse;
import com.google.cloud.talent.v4.SearchJobsRequest;
import com.google.cloud.talent.v4.SearchJobsResponse;
import com.google.cloud.talent.v4.UpdateJobRequest;
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
 * REST stub implementation for the JobService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonJobServiceStub extends JobServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(BatchUpdateJobsResponse.getDescriptor())
          .add(BatchCreateJobsResponse.getDescriptor())
          .add(BatchOperationMetadata.getDescriptor())
          .add(BatchDeleteJobsResponse.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateJobRequest, Job> createJobMethodDescriptor =
      ApiMethodDescriptor.<CreateJobRequest, Job>newBuilder()
          .setFullMethodName("google.cloud.talent.v4.JobService/CreateJob")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CreateJobRequest>newBuilder()
                  .setPath(
                      "/v4/{parent=projects/*/tenants/*}/jobs",
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

  private static final ApiMethodDescriptor<BatchCreateJobsRequest, Operation>
      batchCreateJobsMethodDescriptor =
          ApiMethodDescriptor.<BatchCreateJobsRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.talent.v4.JobService/BatchCreateJobs")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchCreateJobsRequest>newBuilder()
                      .setPath(
                          "/v4/{parent=projects/*/tenants/*}/jobs:batchCreate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateJobsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateJobsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (BatchCreateJobsRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetJobRequest, Job> getJobMethodDescriptor =
      ApiMethodDescriptor.<GetJobRequest, Job>newBuilder()
          .setFullMethodName("google.cloud.talent.v4.JobService/GetJob")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetJobRequest>newBuilder()
                  .setPath(
                      "/v4/{name=projects/*/tenants/*/jobs/*}",
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

  private static final ApiMethodDescriptor<UpdateJobRequest, Job> updateJobMethodDescriptor =
      ApiMethodDescriptor.<UpdateJobRequest, Job>newBuilder()
          .setFullMethodName("google.cloud.talent.v4.JobService/UpdateJob")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateJobRequest>newBuilder()
                  .setPath(
                      "/v4/{job.name=projects/*/tenants/*/jobs/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateJobRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "job.name", request.getJob().getName());
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

  private static final ApiMethodDescriptor<BatchUpdateJobsRequest, Operation>
      batchUpdateJobsMethodDescriptor =
          ApiMethodDescriptor.<BatchUpdateJobsRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.talent.v4.JobService/BatchUpdateJobs")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchUpdateJobsRequest>newBuilder()
                      .setPath(
                          "/v4/{parent=projects/*/tenants/*}/jobs:batchUpdate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateJobsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateJobsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (BatchUpdateJobsRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteJobRequest, Empty> deleteJobMethodDescriptor =
      ApiMethodDescriptor.<DeleteJobRequest, Empty>newBuilder()
          .setFullMethodName("google.cloud.talent.v4.JobService/DeleteJob")
          .setHttpMethod("DELETE")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteJobRequest>newBuilder()
                  .setPath(
                      "/v4/{name=projects/*/tenants/*/jobs/*}",
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

  private static final ApiMethodDescriptor<BatchDeleteJobsRequest, Operation>
      batchDeleteJobsMethodDescriptor =
          ApiMethodDescriptor.<BatchDeleteJobsRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.talent.v4.JobService/BatchDeleteJobs")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchDeleteJobsRequest>newBuilder()
                      .setPath(
                          "/v4/{parent=projects/*/tenants/*}/jobs:batchDelete",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeleteJobsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeleteJobsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (BatchDeleteJobsRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListJobsRequest, ListJobsResponse>
      listJobsMethodDescriptor =
          ApiMethodDescriptor.<ListJobsRequest, ListJobsResponse>newBuilder()
              .setFullMethodName("google.cloud.talent.v4.JobService/ListJobs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListJobsRequest>newBuilder()
                      .setPath(
                          "/v4/{parent=projects/*/tenants/*}/jobs",
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
                            serializer.putQueryParam(fields, "jobView", request.getJobViewValue());
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

  private static final ApiMethodDescriptor<SearchJobsRequest, SearchJobsResponse>
      searchJobsMethodDescriptor =
          ApiMethodDescriptor.<SearchJobsRequest, SearchJobsResponse>newBuilder()
              .setFullMethodName("google.cloud.talent.v4.JobService/SearchJobs")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SearchJobsRequest>newBuilder()
                      .setPath(
                          "/v4/{parent=projects/*/tenants/*}/jobs:search",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SearchJobsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SearchJobsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchJobsResponse>newBuilder()
                      .setDefaultInstance(SearchJobsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SearchJobsRequest, SearchJobsResponse>
      searchJobsForAlertMethodDescriptor =
          ApiMethodDescriptor.<SearchJobsRequest, SearchJobsResponse>newBuilder()
              .setFullMethodName("google.cloud.talent.v4.JobService/SearchJobsForAlert")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SearchJobsRequest>newBuilder()
                      .setPath(
                          "/v4/{parent=projects/*/tenants/*}/jobs:searchForAlert",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SearchJobsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SearchJobsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchJobsResponse>newBuilder()
                      .setDefaultInstance(SearchJobsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateJobRequest, Job> createJobCallable;
  private final UnaryCallable<BatchCreateJobsRequest, Operation> batchCreateJobsCallable;
  private final OperationCallable<
          BatchCreateJobsRequest, BatchCreateJobsResponse, BatchOperationMetadata>
      batchCreateJobsOperationCallable;
  private final UnaryCallable<GetJobRequest, Job> getJobCallable;
  private final UnaryCallable<UpdateJobRequest, Job> updateJobCallable;
  private final UnaryCallable<BatchUpdateJobsRequest, Operation> batchUpdateJobsCallable;
  private final OperationCallable<
          BatchUpdateJobsRequest, BatchUpdateJobsResponse, BatchOperationMetadata>
      batchUpdateJobsOperationCallable;
  private final UnaryCallable<DeleteJobRequest, Empty> deleteJobCallable;
  private final UnaryCallable<BatchDeleteJobsRequest, Operation> batchDeleteJobsCallable;
  private final OperationCallable<
          BatchDeleteJobsRequest, BatchDeleteJobsResponse, BatchOperationMetadata>
      batchDeleteJobsOperationCallable;
  private final UnaryCallable<ListJobsRequest, ListJobsResponse> listJobsCallable;
  private final UnaryCallable<ListJobsRequest, ListJobsPagedResponse> listJobsPagedCallable;
  private final UnaryCallable<SearchJobsRequest, SearchJobsResponse> searchJobsCallable;
  private final UnaryCallable<SearchJobsRequest, SearchJobsResponse> searchJobsForAlertCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonJobServiceStub create(JobServiceStubSettings settings)
      throws IOException {
    return new HttpJsonJobServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonJobServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonJobServiceStub(
        JobServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonJobServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonJobServiceStub(
        JobServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonJobServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonJobServiceStub(JobServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonJobServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonJobServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonJobServiceStub(
      JobServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<CreateJobRequest, Job> createJobTransportSettings =
        HttpJsonCallSettings.<CreateJobRequest, Job>newBuilder()
            .setMethodDescriptor(createJobMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<BatchCreateJobsRequest, Operation> batchCreateJobsTransportSettings =
        HttpJsonCallSettings.<BatchCreateJobsRequest, Operation>newBuilder()
            .setMethodDescriptor(batchCreateJobsMethodDescriptor)
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
    HttpJsonCallSettings<BatchUpdateJobsRequest, Operation> batchUpdateJobsTransportSettings =
        HttpJsonCallSettings.<BatchUpdateJobsRequest, Operation>newBuilder()
            .setMethodDescriptor(batchUpdateJobsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteJobRequest, Empty> deleteJobTransportSettings =
        HttpJsonCallSettings.<DeleteJobRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteJobMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<BatchDeleteJobsRequest, Operation> batchDeleteJobsTransportSettings =
        HttpJsonCallSettings.<BatchDeleteJobsRequest, Operation>newBuilder()
            .setMethodDescriptor(batchDeleteJobsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListJobsRequest, ListJobsResponse> listJobsTransportSettings =
        HttpJsonCallSettings.<ListJobsRequest, ListJobsResponse>newBuilder()
            .setMethodDescriptor(listJobsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SearchJobsRequest, SearchJobsResponse> searchJobsTransportSettings =
        HttpJsonCallSettings.<SearchJobsRequest, SearchJobsResponse>newBuilder()
            .setMethodDescriptor(searchJobsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SearchJobsRequest, SearchJobsResponse>
        searchJobsForAlertTransportSettings =
            HttpJsonCallSettings.<SearchJobsRequest, SearchJobsResponse>newBuilder()
                .setMethodDescriptor(searchJobsForAlertMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.createJobCallable =
        callableFactory.createUnaryCallable(
            createJobTransportSettings, settings.createJobSettings(), clientContext);
    this.batchCreateJobsCallable =
        callableFactory.createUnaryCallable(
            batchCreateJobsTransportSettings, settings.batchCreateJobsSettings(), clientContext);
    this.batchCreateJobsOperationCallable =
        callableFactory.createOperationCallable(
            batchCreateJobsTransportSettings,
            settings.batchCreateJobsOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getJobCallable =
        callableFactory.createUnaryCallable(
            getJobTransportSettings, settings.getJobSettings(), clientContext);
    this.updateJobCallable =
        callableFactory.createUnaryCallable(
            updateJobTransportSettings, settings.updateJobSettings(), clientContext);
    this.batchUpdateJobsCallable =
        callableFactory.createUnaryCallable(
            batchUpdateJobsTransportSettings, settings.batchUpdateJobsSettings(), clientContext);
    this.batchUpdateJobsOperationCallable =
        callableFactory.createOperationCallable(
            batchUpdateJobsTransportSettings,
            settings.batchUpdateJobsOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteJobCallable =
        callableFactory.createUnaryCallable(
            deleteJobTransportSettings, settings.deleteJobSettings(), clientContext);
    this.batchDeleteJobsCallable =
        callableFactory.createUnaryCallable(
            batchDeleteJobsTransportSettings, settings.batchDeleteJobsSettings(), clientContext);
    this.batchDeleteJobsOperationCallable =
        callableFactory.createOperationCallable(
            batchDeleteJobsTransportSettings,
            settings.batchDeleteJobsOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listJobsCallable =
        callableFactory.createUnaryCallable(
            listJobsTransportSettings, settings.listJobsSettings(), clientContext);
    this.listJobsPagedCallable =
        callableFactory.createPagedCallable(
            listJobsTransportSettings, settings.listJobsSettings(), clientContext);
    this.searchJobsCallable =
        callableFactory.createUnaryCallable(
            searchJobsTransportSettings, settings.searchJobsSettings(), clientContext);
    this.searchJobsForAlertCallable =
        callableFactory.createUnaryCallable(
            searchJobsForAlertTransportSettings,
            settings.searchJobsForAlertSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createJobMethodDescriptor);
    methodDescriptors.add(batchCreateJobsMethodDescriptor);
    methodDescriptors.add(getJobMethodDescriptor);
    methodDescriptors.add(updateJobMethodDescriptor);
    methodDescriptors.add(batchUpdateJobsMethodDescriptor);
    methodDescriptors.add(deleteJobMethodDescriptor);
    methodDescriptors.add(batchDeleteJobsMethodDescriptor);
    methodDescriptors.add(listJobsMethodDescriptor);
    methodDescriptors.add(searchJobsMethodDescriptor);
    methodDescriptors.add(searchJobsForAlertMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<CreateJobRequest, Job> createJobCallable() {
    return createJobCallable;
  }

  @Override
  public UnaryCallable<BatchCreateJobsRequest, Operation> batchCreateJobsCallable() {
    return batchCreateJobsCallable;
  }

  @Override
  public OperationCallable<BatchCreateJobsRequest, BatchCreateJobsResponse, BatchOperationMetadata>
      batchCreateJobsOperationCallable() {
    return batchCreateJobsOperationCallable;
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
  public UnaryCallable<BatchUpdateJobsRequest, Operation> batchUpdateJobsCallable() {
    return batchUpdateJobsCallable;
  }

  @Override
  public OperationCallable<BatchUpdateJobsRequest, BatchUpdateJobsResponse, BatchOperationMetadata>
      batchUpdateJobsOperationCallable() {
    return batchUpdateJobsOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteJobRequest, Empty> deleteJobCallable() {
    return deleteJobCallable;
  }

  @Override
  public UnaryCallable<BatchDeleteJobsRequest, Operation> batchDeleteJobsCallable() {
    return batchDeleteJobsCallable;
  }

  @Override
  public OperationCallable<BatchDeleteJobsRequest, BatchDeleteJobsResponse, BatchOperationMetadata>
      batchDeleteJobsOperationCallable() {
    return batchDeleteJobsOperationCallable;
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
  public UnaryCallable<SearchJobsRequest, SearchJobsResponse> searchJobsCallable() {
    return searchJobsCallable;
  }

  @Override
  public UnaryCallable<SearchJobsRequest, SearchJobsResponse> searchJobsForAlertCallable() {
    return searchJobsForAlertCallable;
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
