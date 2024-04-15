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

package com.google.cloud.dataproc.v1.stub;

import static com.google.cloud.dataproc.v1.JobControllerClient.ListJobsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
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
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
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
 * gRPC stub implementation for the JobController service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcJobControllerStub extends JobControllerStub {
  private static final MethodDescriptor<SubmitJobRequest, Job> submitJobMethodDescriptor =
      MethodDescriptor.<SubmitJobRequest, Job>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dataproc.v1.JobController/SubmitJob")
          .setRequestMarshaller(ProtoUtils.marshaller(SubmitJobRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Job.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<SubmitJobRequest, Operation>
      submitJobAsOperationMethodDescriptor =
          MethodDescriptor.<SubmitJobRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataproc.v1.JobController/SubmitJobAsOperation")
              .setRequestMarshaller(ProtoUtils.marshaller(SubmitJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetJobRequest, Job> getJobMethodDescriptor =
      MethodDescriptor.<GetJobRequest, Job>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dataproc.v1.JobController/GetJob")
          .setRequestMarshaller(ProtoUtils.marshaller(GetJobRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Job.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListJobsRequest, ListJobsResponse>
      listJobsMethodDescriptor =
          MethodDescriptor.<ListJobsRequest, ListJobsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataproc.v1.JobController/ListJobs")
              .setRequestMarshaller(ProtoUtils.marshaller(ListJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListJobsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateJobRequest, Job> updateJobMethodDescriptor =
      MethodDescriptor.<UpdateJobRequest, Job>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dataproc.v1.JobController/UpdateJob")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateJobRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Job.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CancelJobRequest, Job> cancelJobMethodDescriptor =
      MethodDescriptor.<CancelJobRequest, Job>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dataproc.v1.JobController/CancelJob")
          .setRequestMarshaller(ProtoUtils.marshaller(CancelJobRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Job.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteJobRequest, Empty> deleteJobMethodDescriptor =
      MethodDescriptor.<DeleteJobRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dataproc.v1.JobController/DeleteJob")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteJobRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.v1.IAMPolicy/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
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
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcJobControllerStub create(JobControllerStubSettings settings)
      throws IOException {
    return new GrpcJobControllerStub(settings, ClientContext.create(settings));
  }

  public static final GrpcJobControllerStub create(ClientContext clientContext) throws IOException {
    return new GrpcJobControllerStub(JobControllerStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcJobControllerStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcJobControllerStub(
        JobControllerStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcJobControllerStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcJobControllerStub(JobControllerStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcJobControllerCallableFactory());
  }

  /**
   * Constructs an instance of GrpcJobControllerStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcJobControllerStub(
      JobControllerStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<SubmitJobRequest, Job> submitJobTransportSettings =
        GrpcCallSettings.<SubmitJobRequest, Job>newBuilder()
            .setMethodDescriptor(submitJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("project_id", String.valueOf(request.getProjectId()));
                  builder.add("region", String.valueOf(request.getRegion()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<SubmitJobRequest, Operation> submitJobAsOperationTransportSettings =
        GrpcCallSettings.<SubmitJobRequest, Operation>newBuilder()
            .setMethodDescriptor(submitJobAsOperationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("project_id", String.valueOf(request.getProjectId()));
                  builder.add("region", String.valueOf(request.getRegion()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetJobRequest, Job> getJobTransportSettings =
        GrpcCallSettings.<GetJobRequest, Job>newBuilder()
            .setMethodDescriptor(getJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("job_id", String.valueOf(request.getJobId()));
                  builder.add("project_id", String.valueOf(request.getProjectId()));
                  builder.add("region", String.valueOf(request.getRegion()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListJobsRequest, ListJobsResponse> listJobsTransportSettings =
        GrpcCallSettings.<ListJobsRequest, ListJobsResponse>newBuilder()
            .setMethodDescriptor(listJobsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("project_id", String.valueOf(request.getProjectId()));
                  builder.add("region", String.valueOf(request.getRegion()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateJobRequest, Job> updateJobTransportSettings =
        GrpcCallSettings.<UpdateJobRequest, Job>newBuilder()
            .setMethodDescriptor(updateJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("job_id", String.valueOf(request.getJobId()));
                  builder.add("project_id", String.valueOf(request.getProjectId()));
                  builder.add("region", String.valueOf(request.getRegion()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CancelJobRequest, Job> cancelJobTransportSettings =
        GrpcCallSettings.<CancelJobRequest, Job>newBuilder()
            .setMethodDescriptor(cancelJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("job_id", String.valueOf(request.getJobId()));
                  builder.add("project_id", String.valueOf(request.getProjectId()));
                  builder.add("region", String.valueOf(request.getRegion()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteJobRequest, Empty> deleteJobTransportSettings =
        GrpcCallSettings.<DeleteJobRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("job_id", String.valueOf(request.getJobId()));
                  builder.add("project_id", String.valueOf(request.getProjectId()));
                  builder.add("region", String.valueOf(request.getRegion()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
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
            operationsStub);
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
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
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
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
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
