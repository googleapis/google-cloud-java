/*
 * Copyright 2026 Google LLC
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
package com.google.cloud.dataplex.v1;


/**
 *
 *
 * <pre>
 * ContentService manages Notebook and SQL Scripts for Dataplex Universal
 * Catalog.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class ContentServiceGrpc {

  private ContentServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.dataplex.v1.ContentService";

  // Static method descriptors that strictly reflect the proto.
  /** Creates a new async stub that supports all call types for the service */
  public static ContentServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ContentServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ContentServiceStub>() {
          @java.lang.Override
          public ContentServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ContentServiceStub(channel, callOptions);
          }
        };
    return ContentServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static ContentServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ContentServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ContentServiceBlockingV2Stub>() {
          @java.lang.Override
          public ContentServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ContentServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return ContentServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ContentServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ContentServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ContentServiceBlockingStub>() {
          @java.lang.Override
          public ContentServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ContentServiceBlockingStub(channel, callOptions);
          }
        };
    return ContentServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ContentServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ContentServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ContentServiceFutureStub>() {
          @java.lang.Override
          public ContentServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ContentServiceFutureStub(channel, callOptions);
          }
        };
    return ContentServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * ContentService manages Notebook and SQL Scripts for Dataplex Universal
   * Catalog.
   * </pre>
   */
  public interface AsyncService {}

  /**
   * Base class for the server implementation of the service ContentService.
   *
   * <pre>
   * ContentService manages Notebook and SQL Scripts for Dataplex Universal
   * Catalog.
   * </pre>
   */
  public abstract static class ContentServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ContentServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ContentService.
   *
   * <pre>
   * ContentService manages Notebook and SQL Scripts for Dataplex Universal
   * Catalog.
   * </pre>
   */
  public static final class ContentServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ContentServiceStub> {
    private ContentServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ContentServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ContentServiceStub(channel, callOptions);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ContentService.
   *
   * <pre>
   * ContentService manages Notebook and SQL Scripts for Dataplex Universal
   * Catalog.
   * </pre>
   */
  public static final class ContentServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<ContentServiceBlockingV2Stub> {
    private ContentServiceBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ContentServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ContentServiceBlockingV2Stub(channel, callOptions);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service ContentService.
   *
   * <pre>
   * ContentService manages Notebook and SQL Scripts for Dataplex Universal
   * Catalog.
   * </pre>
   */
  public static final class ContentServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ContentServiceBlockingStub> {
    private ContentServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ContentServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ContentServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ContentService.
   *
   * <pre>
   * ContentService manages Notebook and SQL Scripts for Dataplex Universal
   * Catalog.
   * </pre>
   */
  public static final class ContentServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ContentServiceFutureStub> {
    private ContentServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ContentServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ContentServiceFutureStub(channel, callOptions);
    }
  }

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
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor()).build();
  }

  private abstract static class ContentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ContentServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dataplex.v1.ContentProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ContentService");
    }
  }

  private static final class ContentServiceFileDescriptorSupplier
      extends ContentServiceBaseDescriptorSupplier {
    ContentServiceFileDescriptorSupplier() {}
  }

  private static final class ContentServiceMethodDescriptorSupplier
      extends ContentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ContentServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ContentServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ContentServiceFileDescriptorSupplier())
                      .build();
        }
      }
    }
    return result;
  }
}
