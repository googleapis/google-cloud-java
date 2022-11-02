package com.google.cloud.run.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Cloud Run Job Control Plane API.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/run/v2/job.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class JobsGrpc {

  private JobsGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.run.v2.Jobs";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.run.v2.CreateJobRequest,
      com.google.longrunning.Operation> getCreateJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateJob",
      requestType = com.google.cloud.run.v2.CreateJobRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.run.v2.CreateJobRequest,
      com.google.longrunning.Operation> getCreateJobMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.run.v2.CreateJobRequest, com.google.longrunning.Operation> getCreateJobMethod;
    if ((getCreateJobMethod = JobsGrpc.getCreateJobMethod) == null) {
      synchronized (JobsGrpc.class) {
        if ((getCreateJobMethod = JobsGrpc.getCreateJobMethod) == null) {
          JobsGrpc.getCreateJobMethod = getCreateJobMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.run.v2.CreateJobRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateJob"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.run.v2.CreateJobRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new JobsMethodDescriptorSupplier("CreateJob"))
              .build();
        }
      }
    }
    return getCreateJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.run.v2.GetJobRequest,
      com.google.cloud.run.v2.Job> getGetJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetJob",
      requestType = com.google.cloud.run.v2.GetJobRequest.class,
      responseType = com.google.cloud.run.v2.Job.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.run.v2.GetJobRequest,
      com.google.cloud.run.v2.Job> getGetJobMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.run.v2.GetJobRequest, com.google.cloud.run.v2.Job> getGetJobMethod;
    if ((getGetJobMethod = JobsGrpc.getGetJobMethod) == null) {
      synchronized (JobsGrpc.class) {
        if ((getGetJobMethod = JobsGrpc.getGetJobMethod) == null) {
          JobsGrpc.getGetJobMethod = getGetJobMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.run.v2.GetJobRequest, com.google.cloud.run.v2.Job>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetJob"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.run.v2.GetJobRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.run.v2.Job.getDefaultInstance()))
              .setSchemaDescriptor(new JobsMethodDescriptorSupplier("GetJob"))
              .build();
        }
      }
    }
    return getGetJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.run.v2.ListJobsRequest,
      com.google.cloud.run.v2.ListJobsResponse> getListJobsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListJobs",
      requestType = com.google.cloud.run.v2.ListJobsRequest.class,
      responseType = com.google.cloud.run.v2.ListJobsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.run.v2.ListJobsRequest,
      com.google.cloud.run.v2.ListJobsResponse> getListJobsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.run.v2.ListJobsRequest, com.google.cloud.run.v2.ListJobsResponse> getListJobsMethod;
    if ((getListJobsMethod = JobsGrpc.getListJobsMethod) == null) {
      synchronized (JobsGrpc.class) {
        if ((getListJobsMethod = JobsGrpc.getListJobsMethod) == null) {
          JobsGrpc.getListJobsMethod = getListJobsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.run.v2.ListJobsRequest, com.google.cloud.run.v2.ListJobsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListJobs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.run.v2.ListJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.run.v2.ListJobsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new JobsMethodDescriptorSupplier("ListJobs"))
              .build();
        }
      }
    }
    return getListJobsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.run.v2.UpdateJobRequest,
      com.google.longrunning.Operation> getUpdateJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateJob",
      requestType = com.google.cloud.run.v2.UpdateJobRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.run.v2.UpdateJobRequest,
      com.google.longrunning.Operation> getUpdateJobMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.run.v2.UpdateJobRequest, com.google.longrunning.Operation> getUpdateJobMethod;
    if ((getUpdateJobMethod = JobsGrpc.getUpdateJobMethod) == null) {
      synchronized (JobsGrpc.class) {
        if ((getUpdateJobMethod = JobsGrpc.getUpdateJobMethod) == null) {
          JobsGrpc.getUpdateJobMethod = getUpdateJobMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.run.v2.UpdateJobRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateJob"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.run.v2.UpdateJobRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new JobsMethodDescriptorSupplier("UpdateJob"))
              .build();
        }
      }
    }
    return getUpdateJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.run.v2.DeleteJobRequest,
      com.google.longrunning.Operation> getDeleteJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteJob",
      requestType = com.google.cloud.run.v2.DeleteJobRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.run.v2.DeleteJobRequest,
      com.google.longrunning.Operation> getDeleteJobMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.run.v2.DeleteJobRequest, com.google.longrunning.Operation> getDeleteJobMethod;
    if ((getDeleteJobMethod = JobsGrpc.getDeleteJobMethod) == null) {
      synchronized (JobsGrpc.class) {
        if ((getDeleteJobMethod = JobsGrpc.getDeleteJobMethod) == null) {
          JobsGrpc.getDeleteJobMethod = getDeleteJobMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.run.v2.DeleteJobRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteJob"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.run.v2.DeleteJobRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new JobsMethodDescriptorSupplier("DeleteJob"))
              .build();
        }
      }
    }
    return getDeleteJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.run.v2.RunJobRequest,
      com.google.longrunning.Operation> getRunJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RunJob",
      requestType = com.google.cloud.run.v2.RunJobRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.run.v2.RunJobRequest,
      com.google.longrunning.Operation> getRunJobMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.run.v2.RunJobRequest, com.google.longrunning.Operation> getRunJobMethod;
    if ((getRunJobMethod = JobsGrpc.getRunJobMethod) == null) {
      synchronized (JobsGrpc.class) {
        if ((getRunJobMethod = JobsGrpc.getRunJobMethod) == null) {
          JobsGrpc.getRunJobMethod = getRunJobMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.run.v2.RunJobRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RunJob"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.run.v2.RunJobRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new JobsMethodDescriptorSupplier("RunJob"))
              .build();
        }
      }
    }
    return getRunJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest,
      com.google.iam.v1.Policy> getGetIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIamPolicy",
      requestType = com.google.iam.v1.GetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest,
      com.google.iam.v1.Policy> getGetIamPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy> getGetIamPolicyMethod;
    if ((getGetIamPolicyMethod = JobsGrpc.getGetIamPolicyMethod) == null) {
      synchronized (JobsGrpc.class) {
        if ((getGetIamPolicyMethod = JobsGrpc.getGetIamPolicyMethod) == null) {
          JobsGrpc.getGetIamPolicyMethod = getGetIamPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIamPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.GetIamPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.Policy.getDefaultInstance()))
              .setSchemaDescriptor(new JobsMethodDescriptorSupplier("GetIamPolicy"))
              .build();
        }
      }
    }
    return getGetIamPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest,
      com.google.iam.v1.Policy> getSetIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetIamPolicy",
      requestType = com.google.iam.v1.SetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest,
      com.google.iam.v1.Policy> getSetIamPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy> getSetIamPolicyMethod;
    if ((getSetIamPolicyMethod = JobsGrpc.getSetIamPolicyMethod) == null) {
      synchronized (JobsGrpc.class) {
        if ((getSetIamPolicyMethod = JobsGrpc.getSetIamPolicyMethod) == null) {
          JobsGrpc.getSetIamPolicyMethod = getSetIamPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetIamPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.SetIamPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.Policy.getDefaultInstance()))
              .setSchemaDescriptor(new JobsMethodDescriptorSupplier("SetIamPolicy"))
              .build();
        }
      }
    }
    return getSetIamPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1.TestIamPermissionsRequest,
      com.google.iam.v1.TestIamPermissionsResponse> getTestIamPermissionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TestIamPermissions",
      requestType = com.google.iam.v1.TestIamPermissionsRequest.class,
      responseType = com.google.iam.v1.TestIamPermissionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.v1.TestIamPermissionsRequest,
      com.google.iam.v1.TestIamPermissionsResponse> getTestIamPermissionsMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse> getTestIamPermissionsMethod;
    if ((getTestIamPermissionsMethod = JobsGrpc.getTestIamPermissionsMethod) == null) {
      synchronized (JobsGrpc.class) {
        if ((getTestIamPermissionsMethod = JobsGrpc.getTestIamPermissionsMethod) == null) {
          JobsGrpc.getTestIamPermissionsMethod = getTestIamPermissionsMethod =
              io.grpc.MethodDescriptor.<com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TestIamPermissions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.TestIamPermissionsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new JobsMethodDescriptorSupplier("TestIamPermissions"))
              .build();
        }
      }
    }
    return getTestIamPermissionsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static JobsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<JobsStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<JobsStub>() {
        @java.lang.Override
        public JobsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new JobsStub(channel, callOptions);
        }
      };
    return JobsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static JobsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<JobsBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<JobsBlockingStub>() {
        @java.lang.Override
        public JobsBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new JobsBlockingStub(channel, callOptions);
        }
      };
    return JobsBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static JobsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<JobsFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<JobsFutureStub>() {
        @java.lang.Override
        public JobsFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new JobsFutureStub(channel, callOptions);
        }
      };
    return JobsFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Cloud Run Job Control Plane API.
   * </pre>
   */
  public static abstract class JobsImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Creates a Job.
     * </pre>
     */
    public void createJob(com.google.cloud.run.v2.CreateJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateJobMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets information about a Job.
     * </pre>
     */
    public void getJob(com.google.cloud.run.v2.GetJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.run.v2.Job> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetJobMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists Jobs.
     * </pre>
     */
    public void listJobs(com.google.cloud.run.v2.ListJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.run.v2.ListJobsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListJobsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates a Job.
     * </pre>
     */
    public void updateJob(com.google.cloud.run.v2.UpdateJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateJobMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a Job.
     * </pre>
     */
    public void deleteJob(com.google.cloud.run.v2.DeleteJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteJobMethod(), responseObserver);
    }

    /**
     * <pre>
     * Triggers creation of a new Execution of this Job.
     * </pre>
     */
    public void runJob(com.google.cloud.run.v2.RunJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRunJobMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get the IAM Access Control policy currently in effect for the given Job.
     * This result does not include any inherited policies.
     * </pre>
     */
    public void getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetIamPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Sets the IAM Access control policy for the specified Job. Overwrites
     * any existing policy.
     * </pre>
     */
    public void setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetIamPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns permissions that a caller has on the specified Project.
     * There are no permissions required for making this API call.
     * </pre>
     */
    public void testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTestIamPermissionsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.run.v2.CreateJobRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_JOB)))
          .addMethod(
            getGetJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.run.v2.GetJobRequest,
                com.google.cloud.run.v2.Job>(
                  this, METHODID_GET_JOB)))
          .addMethod(
            getListJobsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.run.v2.ListJobsRequest,
                com.google.cloud.run.v2.ListJobsResponse>(
                  this, METHODID_LIST_JOBS)))
          .addMethod(
            getUpdateJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.run.v2.UpdateJobRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_JOB)))
          .addMethod(
            getDeleteJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.run.v2.DeleteJobRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_JOB)))
          .addMethod(
            getRunJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.run.v2.RunJobRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_RUN_JOB)))
          .addMethod(
            getGetIamPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.v1.GetIamPolicyRequest,
                com.google.iam.v1.Policy>(
                  this, METHODID_GET_IAM_POLICY)))
          .addMethod(
            getSetIamPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.v1.SetIamPolicyRequest,
                com.google.iam.v1.Policy>(
                  this, METHODID_SET_IAM_POLICY)))
          .addMethod(
            getTestIamPermissionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.v1.TestIamPermissionsRequest,
                com.google.iam.v1.TestIamPermissionsResponse>(
                  this, METHODID_TEST_IAM_PERMISSIONS)))
          .build();
    }
  }

  /**
   * <pre>
   * Cloud Run Job Control Plane API.
   * </pre>
   */
  public static final class JobsStub extends io.grpc.stub.AbstractAsyncStub<JobsStub> {
    private JobsStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JobsStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new JobsStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a Job.
     * </pre>
     */
    public void createJob(com.google.cloud.run.v2.CreateJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateJobMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets information about a Job.
     * </pre>
     */
    public void getJob(com.google.cloud.run.v2.GetJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.run.v2.Job> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetJobMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists Jobs.
     * </pre>
     */
    public void listJobs(com.google.cloud.run.v2.ListJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.run.v2.ListJobsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListJobsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates a Job.
     * </pre>
     */
    public void updateJob(com.google.cloud.run.v2.UpdateJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateJobMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a Job.
     * </pre>
     */
    public void deleteJob(com.google.cloud.run.v2.DeleteJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteJobMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Triggers creation of a new Execution of this Job.
     * </pre>
     */
    public void runJob(com.google.cloud.run.v2.RunJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRunJobMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get the IAM Access Control policy currently in effect for the given Job.
     * This result does not include any inherited policies.
     * </pre>
     */
    public void getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Sets the IAM Access control policy for the specified Job. Overwrites
     * any existing policy.
     * </pre>
     */
    public void setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns permissions that a caller has on the specified Project.
     * There are no permissions required for making this API call.
     * </pre>
     */
    public void testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Cloud Run Job Control Plane API.
   * </pre>
   */
  public static final class JobsBlockingStub extends io.grpc.stub.AbstractBlockingStub<JobsBlockingStub> {
    private JobsBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JobsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new JobsBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a Job.
     * </pre>
     */
    public com.google.longrunning.Operation createJob(com.google.cloud.run.v2.CreateJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateJobMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets information about a Job.
     * </pre>
     */
    public com.google.cloud.run.v2.Job getJob(com.google.cloud.run.v2.GetJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetJobMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists Jobs.
     * </pre>
     */
    public com.google.cloud.run.v2.ListJobsResponse listJobs(com.google.cloud.run.v2.ListJobsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListJobsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates a Job.
     * </pre>
     */
    public com.google.longrunning.Operation updateJob(com.google.cloud.run.v2.UpdateJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateJobMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a Job.
     * </pre>
     */
    public com.google.longrunning.Operation deleteJob(com.google.cloud.run.v2.DeleteJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteJobMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Triggers creation of a new Execution of this Job.
     * </pre>
     */
    public com.google.longrunning.Operation runJob(com.google.cloud.run.v2.RunJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRunJobMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get the IAM Access Control policy currently in effect for the given Job.
     * This result does not include any inherited policies.
     * </pre>
     */
    public com.google.iam.v1.Policy getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Sets the IAM Access control policy for the specified Job. Overwrites
     * any existing policy.
     * </pre>
     */
    public com.google.iam.v1.Policy setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns permissions that a caller has on the specified Project.
     * There are no permissions required for making this API call.
     * </pre>
     */
    public com.google.iam.v1.TestIamPermissionsResponse testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTestIamPermissionsMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Cloud Run Job Control Plane API.
   * </pre>
   */
  public static final class JobsFutureStub extends io.grpc.stub.AbstractFutureStub<JobsFutureStub> {
    private JobsFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JobsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new JobsFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a Job.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createJob(
        com.google.cloud.run.v2.CreateJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateJobMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets information about a Job.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.run.v2.Job> getJob(
        com.google.cloud.run.v2.GetJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetJobMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists Jobs.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.run.v2.ListJobsResponse> listJobs(
        com.google.cloud.run.v2.ListJobsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListJobsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates a Job.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateJob(
        com.google.cloud.run.v2.UpdateJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateJobMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a Job.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteJob(
        com.google.cloud.run.v2.DeleteJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteJobMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Triggers creation of a new Execution of this Job.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> runJob(
        com.google.cloud.run.v2.RunJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRunJobMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get the IAM Access Control policy currently in effect for the given Job.
     * This result does not include any inherited policies.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy> getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Sets the IAM Access control policy for the specified Job. Overwrites
     * any existing policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy> setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns permissions that a caller has on the specified Project.
     * There are no permissions required for making this API call.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.TestIamPermissionsResponse> testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_JOB = 0;
  private static final int METHODID_GET_JOB = 1;
  private static final int METHODID_LIST_JOBS = 2;
  private static final int METHODID_UPDATE_JOB = 3;
  private static final int METHODID_DELETE_JOB = 4;
  private static final int METHODID_RUN_JOB = 5;
  private static final int METHODID_GET_IAM_POLICY = 6;
  private static final int METHODID_SET_IAM_POLICY = 7;
  private static final int METHODID_TEST_IAM_PERMISSIONS = 8;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final JobsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(JobsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_JOB:
          serviceImpl.createJob((com.google.cloud.run.v2.CreateJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_JOB:
          serviceImpl.getJob((com.google.cloud.run.v2.GetJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.run.v2.Job>) responseObserver);
          break;
        case METHODID_LIST_JOBS:
          serviceImpl.listJobs((com.google.cloud.run.v2.ListJobsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.run.v2.ListJobsResponse>) responseObserver);
          break;
        case METHODID_UPDATE_JOB:
          serviceImpl.updateJob((com.google.cloud.run.v2.UpdateJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_JOB:
          serviceImpl.deleteJob((com.google.cloud.run.v2.DeleteJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_RUN_JOB:
          serviceImpl.runJob((com.google.cloud.run.v2.RunJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_IAM_POLICY:
          serviceImpl.getIamPolicy((com.google.iam.v1.GetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_SET_IAM_POLICY:
          serviceImpl.setIamPolicy((com.google.iam.v1.SetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_TEST_IAM_PERMISSIONS:
          serviceImpl.testIamPermissions((com.google.iam.v1.TestIamPermissionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class JobsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    JobsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.run.v2.JobProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Jobs");
    }
  }

  private static final class JobsFileDescriptorSupplier
      extends JobsBaseDescriptorSupplier {
    JobsFileDescriptorSupplier() {}
  }

  private static final class JobsMethodDescriptorSupplier
      extends JobsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    JobsMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (JobsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new JobsFileDescriptorSupplier())
              .addMethod(getCreateJobMethod())
              .addMethod(getGetJobMethod())
              .addMethod(getListJobsMethod())
              .addMethod(getUpdateJobMethod())
              .addMethod(getDeleteJobMethod())
              .addMethod(getRunJobMethod())
              .addMethod(getGetIamPolicyMethod())
              .addMethod(getSetIamPolicyMethod())
              .addMethod(getTestIamPermissionsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
