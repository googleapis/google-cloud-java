/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.cloudsecuritycompliance.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service describing handlers for resources
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/cloudsecuritycompliance/v1/audit.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AuditGrpc {

  private AuditGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.cloudsecuritycompliance.v1.Audit";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.GenerateFrameworkAuditScopeReportRequest,
          com.google.cloud.cloudsecuritycompliance.v1.GenerateFrameworkAuditScopeReportResponse>
      getGenerateFrameworkAuditScopeReportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateFrameworkAuditScopeReport",
      requestType =
          com.google.cloud.cloudsecuritycompliance.v1.GenerateFrameworkAuditScopeReportRequest
              .class,
      responseType =
          com.google.cloud.cloudsecuritycompliance.v1.GenerateFrameworkAuditScopeReportResponse
              .class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.GenerateFrameworkAuditScopeReportRequest,
          com.google.cloud.cloudsecuritycompliance.v1.GenerateFrameworkAuditScopeReportResponse>
      getGenerateFrameworkAuditScopeReportMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.cloudsecuritycompliance.v1.GenerateFrameworkAuditScopeReportRequest,
            com.google.cloud.cloudsecuritycompliance.v1.GenerateFrameworkAuditScopeReportResponse>
        getGenerateFrameworkAuditScopeReportMethod;
    if ((getGenerateFrameworkAuditScopeReportMethod =
            AuditGrpc.getGenerateFrameworkAuditScopeReportMethod)
        == null) {
      synchronized (AuditGrpc.class) {
        if ((getGenerateFrameworkAuditScopeReportMethod =
                AuditGrpc.getGenerateFrameworkAuditScopeReportMethod)
            == null) {
          AuditGrpc.getGenerateFrameworkAuditScopeReportMethod =
              getGenerateFrameworkAuditScopeReportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.cloudsecuritycompliance.v1
                              .GenerateFrameworkAuditScopeReportRequest,
                          com.google.cloud.cloudsecuritycompliance.v1
                              .GenerateFrameworkAuditScopeReportResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GenerateFrameworkAuditScopeReport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudsecuritycompliance.v1
                                  .GenerateFrameworkAuditScopeReportRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudsecuritycompliance.v1
                                  .GenerateFrameworkAuditScopeReportResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AuditMethodDescriptorSupplier("GenerateFrameworkAuditScopeReport"))
                      .build();
        }
      }
    }
    return getGenerateFrameworkAuditScopeReportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.CreateFrameworkAuditRequest,
          com.google.longrunning.Operation>
      getCreateFrameworkAuditMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateFrameworkAudit",
      requestType = com.google.cloud.cloudsecuritycompliance.v1.CreateFrameworkAuditRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.CreateFrameworkAuditRequest,
          com.google.longrunning.Operation>
      getCreateFrameworkAuditMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.cloudsecuritycompliance.v1.CreateFrameworkAuditRequest,
            com.google.longrunning.Operation>
        getCreateFrameworkAuditMethod;
    if ((getCreateFrameworkAuditMethod = AuditGrpc.getCreateFrameworkAuditMethod) == null) {
      synchronized (AuditGrpc.class) {
        if ((getCreateFrameworkAuditMethod = AuditGrpc.getCreateFrameworkAuditMethod) == null) {
          AuditGrpc.getCreateFrameworkAuditMethod =
              getCreateFrameworkAuditMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.cloudsecuritycompliance.v1.CreateFrameworkAuditRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateFrameworkAudit"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudsecuritycompliance.v1
                                  .CreateFrameworkAuditRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AuditMethodDescriptorSupplier("CreateFrameworkAudit"))
                      .build();
        }
      }
    }
    return getCreateFrameworkAuditMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkAuditsRequest,
          com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkAuditsResponse>
      getListFrameworkAuditsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFrameworkAudits",
      requestType = com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkAuditsRequest.class,
      responseType = com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkAuditsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkAuditsRequest,
          com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkAuditsResponse>
      getListFrameworkAuditsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkAuditsRequest,
            com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkAuditsResponse>
        getListFrameworkAuditsMethod;
    if ((getListFrameworkAuditsMethod = AuditGrpc.getListFrameworkAuditsMethod) == null) {
      synchronized (AuditGrpc.class) {
        if ((getListFrameworkAuditsMethod = AuditGrpc.getListFrameworkAuditsMethod) == null) {
          AuditGrpc.getListFrameworkAuditsMethod =
              getListFrameworkAuditsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkAuditsRequest,
                          com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkAuditsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListFrameworkAudits"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkAuditsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudsecuritycompliance.v1
                                  .ListFrameworkAuditsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new AuditMethodDescriptorSupplier("ListFrameworkAudits"))
                      .build();
        }
      }
    }
    return getListFrameworkAuditsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkAuditRequest,
          com.google.cloud.cloudsecuritycompliance.v1.FrameworkAudit>
      getGetFrameworkAuditMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFrameworkAudit",
      requestType = com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkAuditRequest.class,
      responseType = com.google.cloud.cloudsecuritycompliance.v1.FrameworkAudit.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkAuditRequest,
          com.google.cloud.cloudsecuritycompliance.v1.FrameworkAudit>
      getGetFrameworkAuditMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkAuditRequest,
            com.google.cloud.cloudsecuritycompliance.v1.FrameworkAudit>
        getGetFrameworkAuditMethod;
    if ((getGetFrameworkAuditMethod = AuditGrpc.getGetFrameworkAuditMethod) == null) {
      synchronized (AuditGrpc.class) {
        if ((getGetFrameworkAuditMethod = AuditGrpc.getGetFrameworkAuditMethod) == null) {
          AuditGrpc.getGetFrameworkAuditMethod =
              getGetFrameworkAuditMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkAuditRequest,
                          com.google.cloud.cloudsecuritycompliance.v1.FrameworkAudit>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetFrameworkAudit"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkAuditRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudsecuritycompliance.v1.FrameworkAudit
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new AuditMethodDescriptorSupplier("GetFrameworkAudit"))
                      .build();
        }
      }
    }
    return getGetFrameworkAuditMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AuditStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuditStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AuditStub>() {
          @java.lang.Override
          public AuditStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AuditStub(channel, callOptions);
          }
        };
    return AuditStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static AuditBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuditBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AuditBlockingV2Stub>() {
          @java.lang.Override
          public AuditBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AuditBlockingV2Stub(channel, callOptions);
          }
        };
    return AuditBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AuditBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuditBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AuditBlockingStub>() {
          @java.lang.Override
          public AuditBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AuditBlockingStub(channel, callOptions);
          }
        };
    return AuditBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AuditFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuditFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AuditFutureStub>() {
          @java.lang.Override
          public AuditFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AuditFutureStub(channel, callOptions);
          }
        };
    return AuditFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Generates an audit scope report for a framework.
     * </pre>
     */
    default void generateFrameworkAuditScopeReport(
        com.google.cloud.cloudsecuritycompliance.v1.GenerateFrameworkAuditScopeReportRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.cloudsecuritycompliance.v1
                    .GenerateFrameworkAuditScopeReportResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGenerateFrameworkAuditScopeReportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an audit scope report for a framework.
     * </pre>
     */
    default void createFrameworkAudit(
        com.google.cloud.cloudsecuritycompliance.v1.CreateFrameworkAuditRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateFrameworkAuditMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the framework audits for a given organization, folder, or project.
     * </pre>
     */
    default void listFrameworkAudits(
        com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkAuditsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkAuditsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListFrameworkAuditsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details for a framework audit.
     * </pre>
     */
    default void getFrameworkAudit(
        com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkAuditRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.cloudsecuritycompliance.v1.FrameworkAudit>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetFrameworkAuditMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Audit.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public abstract static class AuditImplBase implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return AuditGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Audit.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class AuditStub extends io.grpc.stub.AbstractAsyncStub<AuditStub> {
    private AuditStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuditStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuditStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Generates an audit scope report for a framework.
     * </pre>
     */
    public void generateFrameworkAuditScopeReport(
        com.google.cloud.cloudsecuritycompliance.v1.GenerateFrameworkAuditScopeReportRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.cloudsecuritycompliance.v1
                    .GenerateFrameworkAuditScopeReportResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateFrameworkAuditScopeReportMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an audit scope report for a framework.
     * </pre>
     */
    public void createFrameworkAudit(
        com.google.cloud.cloudsecuritycompliance.v1.CreateFrameworkAuditRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateFrameworkAuditMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the framework audits for a given organization, folder, or project.
     * </pre>
     */
    public void listFrameworkAudits(
        com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkAuditsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkAuditsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListFrameworkAuditsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details for a framework audit.
     * </pre>
     */
    public void getFrameworkAudit(
        com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkAuditRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.cloudsecuritycompliance.v1.FrameworkAudit>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFrameworkAuditMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Audit.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class AuditBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<AuditBlockingV2Stub> {
    private AuditBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuditBlockingV2Stub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuditBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Generates an audit scope report for a framework.
     * </pre>
     */
    public com.google.cloud.cloudsecuritycompliance.v1.GenerateFrameworkAuditScopeReportResponse
        generateFrameworkAuditScopeReport(
            com.google.cloud.cloudsecuritycompliance.v1.GenerateFrameworkAuditScopeReportRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateFrameworkAuditScopeReportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an audit scope report for a framework.
     * </pre>
     */
    public com.google.longrunning.Operation createFrameworkAudit(
        com.google.cloud.cloudsecuritycompliance.v1.CreateFrameworkAuditRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateFrameworkAuditMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the framework audits for a given organization, folder, or project.
     * </pre>
     */
    public com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkAuditsResponse
        listFrameworkAudits(
            com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkAuditsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFrameworkAuditsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details for a framework audit.
     * </pre>
     */
    public com.google.cloud.cloudsecuritycompliance.v1.FrameworkAudit getFrameworkAudit(
        com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkAuditRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFrameworkAuditMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service Audit.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class AuditBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AuditBlockingStub> {
    private AuditBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuditBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuditBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Generates an audit scope report for a framework.
     * </pre>
     */
    public com.google.cloud.cloudsecuritycompliance.v1.GenerateFrameworkAuditScopeReportResponse
        generateFrameworkAuditScopeReport(
            com.google.cloud.cloudsecuritycompliance.v1.GenerateFrameworkAuditScopeReportRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateFrameworkAuditScopeReportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an audit scope report for a framework.
     * </pre>
     */
    public com.google.longrunning.Operation createFrameworkAudit(
        com.google.cloud.cloudsecuritycompliance.v1.CreateFrameworkAuditRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateFrameworkAuditMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the framework audits for a given organization, folder, or project.
     * </pre>
     */
    public com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkAuditsResponse
        listFrameworkAudits(
            com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkAuditsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFrameworkAuditsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details for a framework audit.
     * </pre>
     */
    public com.google.cloud.cloudsecuritycompliance.v1.FrameworkAudit getFrameworkAudit(
        com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkAuditRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFrameworkAuditMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Audit.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class AuditFutureStub
      extends io.grpc.stub.AbstractFutureStub<AuditFutureStub> {
    private AuditFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuditFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuditFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Generates an audit scope report for a framework.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.cloudsecuritycompliance.v1.GenerateFrameworkAuditScopeReportResponse>
        generateFrameworkAuditScopeReport(
            com.google.cloud.cloudsecuritycompliance.v1.GenerateFrameworkAuditScopeReportRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateFrameworkAuditScopeReportMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Creates an audit scope report for a framework.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createFrameworkAudit(
            com.google.cloud.cloudsecuritycompliance.v1.CreateFrameworkAuditRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateFrameworkAuditMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the framework audits for a given organization, folder, or project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkAuditsResponse>
        listFrameworkAudits(
            com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkAuditsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListFrameworkAuditsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details for a framework audit.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.cloudsecuritycompliance.v1.FrameworkAudit>
        getFrameworkAudit(
            com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkAuditRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFrameworkAuditMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GENERATE_FRAMEWORK_AUDIT_SCOPE_REPORT = 0;
  private static final int METHODID_CREATE_FRAMEWORK_AUDIT = 1;
  private static final int METHODID_LIST_FRAMEWORK_AUDITS = 2;
  private static final int METHODID_GET_FRAMEWORK_AUDIT = 3;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GENERATE_FRAMEWORK_AUDIT_SCOPE_REPORT:
          serviceImpl.generateFrameworkAuditScopeReport(
              (com.google.cloud.cloudsecuritycompliance.v1.GenerateFrameworkAuditScopeReportRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.cloudsecuritycompliance.v1
                          .GenerateFrameworkAuditScopeReportResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_FRAMEWORK_AUDIT:
          serviceImpl.createFrameworkAudit(
              (com.google.cloud.cloudsecuritycompliance.v1.CreateFrameworkAuditRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_FRAMEWORK_AUDITS:
          serviceImpl.listFrameworkAudits(
              (com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkAuditsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkAuditsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_FRAMEWORK_AUDIT:
          serviceImpl.getFrameworkAudit(
              (com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkAuditRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.cloudsecuritycompliance.v1.FrameworkAudit>)
                  responseObserver);
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
            getGenerateFrameworkAuditScopeReportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.cloudsecuritycompliance.v1
                        .GenerateFrameworkAuditScopeReportRequest,
                    com.google.cloud.cloudsecuritycompliance.v1
                        .GenerateFrameworkAuditScopeReportResponse>(
                    service, METHODID_GENERATE_FRAMEWORK_AUDIT_SCOPE_REPORT)))
        .addMethod(
            getCreateFrameworkAuditMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.cloudsecuritycompliance.v1.CreateFrameworkAuditRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_FRAMEWORK_AUDIT)))
        .addMethod(
            getListFrameworkAuditsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkAuditsRequest,
                    com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkAuditsResponse>(
                    service, METHODID_LIST_FRAMEWORK_AUDITS)))
        .addMethod(
            getGetFrameworkAuditMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkAuditRequest,
                    com.google.cloud.cloudsecuritycompliance.v1.FrameworkAudit>(
                    service, METHODID_GET_FRAMEWORK_AUDIT)))
        .build();
  }

  private abstract static class AuditBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AuditBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.cloudsecuritycompliance.v1.AuditProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Audit");
    }
  }

  private static final class AuditFileDescriptorSupplier extends AuditBaseDescriptorSupplier {
    AuditFileDescriptorSupplier() {}
  }

  private static final class AuditMethodDescriptorSupplier extends AuditBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AuditMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AuditGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AuditFileDescriptorSupplier())
                      .addMethod(getGenerateFrameworkAuditScopeReportMethod())
                      .addMethod(getCreateFrameworkAuditMethod())
                      .addMethod(getListFrameworkAuditsMethod())
                      .addMethod(getGetFrameworkAuditMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
