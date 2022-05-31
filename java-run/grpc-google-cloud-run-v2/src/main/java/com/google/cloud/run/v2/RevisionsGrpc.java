/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.run.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Cloud Run Revision Control Plane API.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/run/v2/revision.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RevisionsGrpc {

  private RevisionsGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.run.v2.Revisions";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.GetRevisionRequest, com.google.cloud.run.v2.Revision>
      getGetRevisionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRevision",
      requestType = com.google.cloud.run.v2.GetRevisionRequest.class,
      responseType = com.google.cloud.run.v2.Revision.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.GetRevisionRequest, com.google.cloud.run.v2.Revision>
      getGetRevisionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.run.v2.GetRevisionRequest, com.google.cloud.run.v2.Revision>
        getGetRevisionMethod;
    if ((getGetRevisionMethod = RevisionsGrpc.getGetRevisionMethod) == null) {
      synchronized (RevisionsGrpc.class) {
        if ((getGetRevisionMethod = RevisionsGrpc.getGetRevisionMethod) == null) {
          RevisionsGrpc.getGetRevisionMethod =
              getGetRevisionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.run.v2.GetRevisionRequest,
                          com.google.cloud.run.v2.Revision>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRevision"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.run.v2.GetRevisionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.run.v2.Revision.getDefaultInstance()))
                      .setSchemaDescriptor(new RevisionsMethodDescriptorSupplier("GetRevision"))
                      .build();
        }
      }
    }
    return getGetRevisionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.ListRevisionsRequest,
          com.google.cloud.run.v2.ListRevisionsResponse>
      getListRevisionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRevisions",
      requestType = com.google.cloud.run.v2.ListRevisionsRequest.class,
      responseType = com.google.cloud.run.v2.ListRevisionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.ListRevisionsRequest,
          com.google.cloud.run.v2.ListRevisionsResponse>
      getListRevisionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.run.v2.ListRevisionsRequest,
            com.google.cloud.run.v2.ListRevisionsResponse>
        getListRevisionsMethod;
    if ((getListRevisionsMethod = RevisionsGrpc.getListRevisionsMethod) == null) {
      synchronized (RevisionsGrpc.class) {
        if ((getListRevisionsMethod = RevisionsGrpc.getListRevisionsMethod) == null) {
          RevisionsGrpc.getListRevisionsMethod =
              getListRevisionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.run.v2.ListRevisionsRequest,
                          com.google.cloud.run.v2.ListRevisionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListRevisions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.run.v2.ListRevisionsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.run.v2.ListRevisionsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new RevisionsMethodDescriptorSupplier("ListRevisions"))
                      .build();
        }
      }
    }
    return getListRevisionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.DeleteRevisionRequest, com.google.longrunning.Operation>
      getDeleteRevisionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteRevision",
      requestType = com.google.cloud.run.v2.DeleteRevisionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.DeleteRevisionRequest, com.google.longrunning.Operation>
      getDeleteRevisionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.run.v2.DeleteRevisionRequest, com.google.longrunning.Operation>
        getDeleteRevisionMethod;
    if ((getDeleteRevisionMethod = RevisionsGrpc.getDeleteRevisionMethod) == null) {
      synchronized (RevisionsGrpc.class) {
        if ((getDeleteRevisionMethod = RevisionsGrpc.getDeleteRevisionMethod) == null) {
          RevisionsGrpc.getDeleteRevisionMethod =
              getDeleteRevisionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.run.v2.DeleteRevisionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteRevision"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.run.v2.DeleteRevisionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new RevisionsMethodDescriptorSupplier("DeleteRevision"))
                      .build();
        }
      }
    }
    return getDeleteRevisionMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static RevisionsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RevisionsStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RevisionsStub>() {
          @java.lang.Override
          public RevisionsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RevisionsStub(channel, callOptions);
          }
        };
    return RevisionsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RevisionsBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RevisionsBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RevisionsBlockingStub>() {
          @java.lang.Override
          public RevisionsBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RevisionsBlockingStub(channel, callOptions);
          }
        };
    return RevisionsBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static RevisionsFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RevisionsFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RevisionsFutureStub>() {
          @java.lang.Override
          public RevisionsFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RevisionsFutureStub(channel, callOptions);
          }
        };
    return RevisionsFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Cloud Run Revision Control Plane API.
   * </pre>
   */
  public abstract static class RevisionsImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Gets information about a Revision.
     * </pre>
     */
    public void getRevision(
        com.google.cloud.run.v2.GetRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.run.v2.Revision> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetRevisionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List Revisions from a given Service, or from a given location.
     * </pre>
     */
    public void listRevisions(
        com.google.cloud.run.v2.ListRevisionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.run.v2.ListRevisionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListRevisionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a Revision.
     * </pre>
     */
    public void deleteRevision(
        com.google.cloud.run.v2.DeleteRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteRevisionMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getGetRevisionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.run.v2.GetRevisionRequest, com.google.cloud.run.v2.Revision>(
                      this, METHODID_GET_REVISION)))
          .addMethod(
              getListRevisionsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.run.v2.ListRevisionsRequest,
                      com.google.cloud.run.v2.ListRevisionsResponse>(
                      this, METHODID_LIST_REVISIONS)))
          .addMethod(
              getDeleteRevisionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.run.v2.DeleteRevisionRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_REVISION)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Cloud Run Revision Control Plane API.
   * </pre>
   */
  public static final class RevisionsStub extends io.grpc.stub.AbstractAsyncStub<RevisionsStub> {
    private RevisionsStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RevisionsStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RevisionsStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets information about a Revision.
     * </pre>
     */
    public void getRevision(
        com.google.cloud.run.v2.GetRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.run.v2.Revision> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRevisionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List Revisions from a given Service, or from a given location.
     * </pre>
     */
    public void listRevisions(
        com.google.cloud.run.v2.ListRevisionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.run.v2.ListRevisionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRevisionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a Revision.
     * </pre>
     */
    public void deleteRevision(
        com.google.cloud.run.v2.DeleteRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteRevisionMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Cloud Run Revision Control Plane API.
   * </pre>
   */
  public static final class RevisionsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<RevisionsBlockingStub> {
    private RevisionsBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RevisionsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RevisionsBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets information about a Revision.
     * </pre>
     */
    public com.google.cloud.run.v2.Revision getRevision(
        com.google.cloud.run.v2.GetRevisionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRevisionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List Revisions from a given Service, or from a given location.
     * </pre>
     */
    public com.google.cloud.run.v2.ListRevisionsResponse listRevisions(
        com.google.cloud.run.v2.ListRevisionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRevisionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a Revision.
     * </pre>
     */
    public com.google.longrunning.Operation deleteRevision(
        com.google.cloud.run.v2.DeleteRevisionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteRevisionMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Cloud Run Revision Control Plane API.
   * </pre>
   */
  public static final class RevisionsFutureStub
      extends io.grpc.stub.AbstractFutureStub<RevisionsFutureStub> {
    private RevisionsFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RevisionsFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RevisionsFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets information about a Revision.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.run.v2.Revision>
        getRevision(com.google.cloud.run.v2.GetRevisionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRevisionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List Revisions from a given Service, or from a given location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.run.v2.ListRevisionsResponse>
        listRevisions(com.google.cloud.run.v2.ListRevisionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRevisionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a Revision.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteRevision(com.google.cloud.run.v2.DeleteRevisionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteRevisionMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_REVISION = 0;
  private static final int METHODID_LIST_REVISIONS = 1;
  private static final int METHODID_DELETE_REVISION = 2;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RevisionsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RevisionsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_REVISION:
          serviceImpl.getRevision(
              (com.google.cloud.run.v2.GetRevisionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.run.v2.Revision>) responseObserver);
          break;
        case METHODID_LIST_REVISIONS:
          serviceImpl.listRevisions(
              (com.google.cloud.run.v2.ListRevisionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.run.v2.ListRevisionsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_REVISION:
          serviceImpl.deleteRevision(
              (com.google.cloud.run.v2.DeleteRevisionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
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

  private abstract static class RevisionsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RevisionsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.run.v2.RevisionProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Revisions");
    }
  }

  private static final class RevisionsFileDescriptorSupplier
      extends RevisionsBaseDescriptorSupplier {
    RevisionsFileDescriptorSupplier() {}
  }

  private static final class RevisionsMethodDescriptorSupplier
      extends RevisionsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RevisionsMethodDescriptorSupplier(String methodName) {
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
      synchronized (RevisionsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new RevisionsFileDescriptorSupplier())
                      .addMethod(getGetRevisionMethod())
                      .addMethod(getListRevisionsMethod())
                      .addMethod(getDeleteRevisionMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
