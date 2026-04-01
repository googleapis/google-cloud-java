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
package com.google.showcase.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * A service to facilitate running discrete sets of tests
 * against Showcase.
 * Adding this comment with special characters for comment formatting tests:
 * 1. (abra-&gt;kadabra-&gt;alakazam)
 * 2) [Nonsense][]: `pokemon/&#42;&#47;psychic/&#42;`
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class TestingGrpc {

  private TestingGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.showcase.v1beta1.Testing";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.CreateSessionRequest, com.google.showcase.v1beta1.Session>
      getCreateSessionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSession",
      requestType = com.google.showcase.v1beta1.CreateSessionRequest.class,
      responseType = com.google.showcase.v1beta1.Session.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.CreateSessionRequest, com.google.showcase.v1beta1.Session>
      getCreateSessionMethod() {
    io.grpc.MethodDescriptor<
            com.google.showcase.v1beta1.CreateSessionRequest, com.google.showcase.v1beta1.Session>
        getCreateSessionMethod;
    if ((getCreateSessionMethod = TestingGrpc.getCreateSessionMethod) == null) {
      synchronized (TestingGrpc.class) {
        if ((getCreateSessionMethod = TestingGrpc.getCreateSessionMethod) == null) {
          TestingGrpc.getCreateSessionMethod =
              getCreateSessionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.showcase.v1beta1.CreateSessionRequest,
                          com.google.showcase.v1beta1.Session>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSession"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.CreateSessionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.Session.getDefaultInstance()))
                      .setSchemaDescriptor(new TestingMethodDescriptorSupplier("CreateSession"))
                      .build();
        }
      }
    }
    return getCreateSessionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.GetSessionRequest, com.google.showcase.v1beta1.Session>
      getGetSessionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSession",
      requestType = com.google.showcase.v1beta1.GetSessionRequest.class,
      responseType = com.google.showcase.v1beta1.Session.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.GetSessionRequest, com.google.showcase.v1beta1.Session>
      getGetSessionMethod() {
    io.grpc.MethodDescriptor<
            com.google.showcase.v1beta1.GetSessionRequest, com.google.showcase.v1beta1.Session>
        getGetSessionMethod;
    if ((getGetSessionMethod = TestingGrpc.getGetSessionMethod) == null) {
      synchronized (TestingGrpc.class) {
        if ((getGetSessionMethod = TestingGrpc.getGetSessionMethod) == null) {
          TestingGrpc.getGetSessionMethod =
              getGetSessionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.showcase.v1beta1.GetSessionRequest,
                          com.google.showcase.v1beta1.Session>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSession"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.GetSessionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.Session.getDefaultInstance()))
                      .setSchemaDescriptor(new TestingMethodDescriptorSupplier("GetSession"))
                      .build();
        }
      }
    }
    return getGetSessionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.ListSessionsRequest,
          com.google.showcase.v1beta1.ListSessionsResponse>
      getListSessionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSessions",
      requestType = com.google.showcase.v1beta1.ListSessionsRequest.class,
      responseType = com.google.showcase.v1beta1.ListSessionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.ListSessionsRequest,
          com.google.showcase.v1beta1.ListSessionsResponse>
      getListSessionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.showcase.v1beta1.ListSessionsRequest,
            com.google.showcase.v1beta1.ListSessionsResponse>
        getListSessionsMethod;
    if ((getListSessionsMethod = TestingGrpc.getListSessionsMethod) == null) {
      synchronized (TestingGrpc.class) {
        if ((getListSessionsMethod = TestingGrpc.getListSessionsMethod) == null) {
          TestingGrpc.getListSessionsMethod =
              getListSessionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.showcase.v1beta1.ListSessionsRequest,
                          com.google.showcase.v1beta1.ListSessionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSessions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.ListSessionsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.ListSessionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new TestingMethodDescriptorSupplier("ListSessions"))
                      .build();
        }
      }
    }
    return getListSessionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.DeleteSessionRequest, com.google.protobuf.Empty>
      getDeleteSessionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSession",
      requestType = com.google.showcase.v1beta1.DeleteSessionRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.DeleteSessionRequest, com.google.protobuf.Empty>
      getDeleteSessionMethod() {
    io.grpc.MethodDescriptor<
            com.google.showcase.v1beta1.DeleteSessionRequest, com.google.protobuf.Empty>
        getDeleteSessionMethod;
    if ((getDeleteSessionMethod = TestingGrpc.getDeleteSessionMethod) == null) {
      synchronized (TestingGrpc.class) {
        if ((getDeleteSessionMethod = TestingGrpc.getDeleteSessionMethod) == null) {
          TestingGrpc.getDeleteSessionMethod =
              getDeleteSessionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.showcase.v1beta1.DeleteSessionRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteSession"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.DeleteSessionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new TestingMethodDescriptorSupplier("DeleteSession"))
                      .build();
        }
      }
    }
    return getDeleteSessionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.ReportSessionRequest,
          com.google.showcase.v1beta1.ReportSessionResponse>
      getReportSessionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReportSession",
      requestType = com.google.showcase.v1beta1.ReportSessionRequest.class,
      responseType = com.google.showcase.v1beta1.ReportSessionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.ReportSessionRequest,
          com.google.showcase.v1beta1.ReportSessionResponse>
      getReportSessionMethod() {
    io.grpc.MethodDescriptor<
            com.google.showcase.v1beta1.ReportSessionRequest,
            com.google.showcase.v1beta1.ReportSessionResponse>
        getReportSessionMethod;
    if ((getReportSessionMethod = TestingGrpc.getReportSessionMethod) == null) {
      synchronized (TestingGrpc.class) {
        if ((getReportSessionMethod = TestingGrpc.getReportSessionMethod) == null) {
          TestingGrpc.getReportSessionMethod =
              getReportSessionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.showcase.v1beta1.ReportSessionRequest,
                          com.google.showcase.v1beta1.ReportSessionResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReportSession"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.ReportSessionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.ReportSessionResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new TestingMethodDescriptorSupplier("ReportSession"))
                      .build();
        }
      }
    }
    return getReportSessionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.ListTestsRequest,
          com.google.showcase.v1beta1.ListTestsResponse>
      getListTestsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTests",
      requestType = com.google.showcase.v1beta1.ListTestsRequest.class,
      responseType = com.google.showcase.v1beta1.ListTestsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.ListTestsRequest,
          com.google.showcase.v1beta1.ListTestsResponse>
      getListTestsMethod() {
    io.grpc.MethodDescriptor<
            com.google.showcase.v1beta1.ListTestsRequest,
            com.google.showcase.v1beta1.ListTestsResponse>
        getListTestsMethod;
    if ((getListTestsMethod = TestingGrpc.getListTestsMethod) == null) {
      synchronized (TestingGrpc.class) {
        if ((getListTestsMethod = TestingGrpc.getListTestsMethod) == null) {
          TestingGrpc.getListTestsMethod =
              getListTestsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.showcase.v1beta1.ListTestsRequest,
                          com.google.showcase.v1beta1.ListTestsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTests"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.ListTestsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.ListTestsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new TestingMethodDescriptorSupplier("ListTests"))
                      .build();
        }
      }
    }
    return getListTestsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.DeleteTestRequest, com.google.protobuf.Empty>
      getDeleteTestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTest",
      requestType = com.google.showcase.v1beta1.DeleteTestRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.DeleteTestRequest, com.google.protobuf.Empty>
      getDeleteTestMethod() {
    io.grpc.MethodDescriptor<
            com.google.showcase.v1beta1.DeleteTestRequest, com.google.protobuf.Empty>
        getDeleteTestMethod;
    if ((getDeleteTestMethod = TestingGrpc.getDeleteTestMethod) == null) {
      synchronized (TestingGrpc.class) {
        if ((getDeleteTestMethod = TestingGrpc.getDeleteTestMethod) == null) {
          TestingGrpc.getDeleteTestMethod =
              getDeleteTestMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.showcase.v1beta1.DeleteTestRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteTest"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.DeleteTestRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new TestingMethodDescriptorSupplier("DeleteTest"))
                      .build();
        }
      }
    }
    return getDeleteTestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.VerifyTestRequest,
          com.google.showcase.v1beta1.VerifyTestResponse>
      getVerifyTestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "VerifyTest",
      requestType = com.google.showcase.v1beta1.VerifyTestRequest.class,
      responseType = com.google.showcase.v1beta1.VerifyTestResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.VerifyTestRequest,
          com.google.showcase.v1beta1.VerifyTestResponse>
      getVerifyTestMethod() {
    io.grpc.MethodDescriptor<
            com.google.showcase.v1beta1.VerifyTestRequest,
            com.google.showcase.v1beta1.VerifyTestResponse>
        getVerifyTestMethod;
    if ((getVerifyTestMethod = TestingGrpc.getVerifyTestMethod) == null) {
      synchronized (TestingGrpc.class) {
        if ((getVerifyTestMethod = TestingGrpc.getVerifyTestMethod) == null) {
          TestingGrpc.getVerifyTestMethod =
              getVerifyTestMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.showcase.v1beta1.VerifyTestRequest,
                          com.google.showcase.v1beta1.VerifyTestResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "VerifyTest"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.VerifyTestRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.VerifyTestResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new TestingMethodDescriptorSupplier("VerifyTest"))
                      .build();
        }
      }
    }
    return getVerifyTestMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static TestingStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TestingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TestingStub>() {
          @java.lang.Override
          public TestingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TestingStub(channel, callOptions);
          }
        };
    return TestingStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static TestingBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TestingBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TestingBlockingV2Stub>() {
          @java.lang.Override
          public TestingBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TestingBlockingV2Stub(channel, callOptions);
          }
        };
    return TestingBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TestingBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TestingBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TestingBlockingStub>() {
          @java.lang.Override
          public TestingBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TestingBlockingStub(channel, callOptions);
          }
        };
    return TestingBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static TestingFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TestingFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TestingFutureStub>() {
          @java.lang.Override
          public TestingFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TestingFutureStub(channel, callOptions);
          }
        };
    return TestingFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * A service to facilitate running discrete sets of tests
   * against Showcase.
   * Adding this comment with special characters for comment formatting tests:
   * 1. (abra-&gt;kadabra-&gt;alakazam)
   * 2) [Nonsense][]: `pokemon/&#42;&#47;psychic/&#42;`
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a new testing session.
     * Adding this comment with special characters for comment formatting tests:
     * 1. (abra-&gt;kadabra-&gt;alakazam)
     * 2) [Nonsense][]: `pokemon/&#42;&#47;psychic/&#42;`
     * </pre>
     */
    default void createSession(
        com.google.showcase.v1beta1.CreateSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.Session> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSessionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a testing session.
     * </pre>
     */
    default void getSession(
        com.google.showcase.v1beta1.GetSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.Session> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSessionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the current test sessions.
     * </pre>
     */
    default void listSessions(
        com.google.showcase.v1beta1.ListSessionsRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.ListSessionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSessionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a test session.
     * </pre>
     */
    default void deleteSession(
        com.google.showcase.v1beta1.DeleteSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteSessionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Report on the status of a session.
     * This generates a report detailing which tests have been completed,
     * and an overall rollup.
     * </pre>
     */
    default void reportSession(
        com.google.showcase.v1beta1.ReportSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.ReportSessionResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getReportSessionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List the tests of a sessesion.
     * </pre>
     */
    default void listTests(
        com.google.showcase.v1beta1.ListTestsRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.ListTestsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListTestsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Explicitly decline to implement a test.
     * This removes the test from subsequent `ListTests` calls, and
     * attempting to do the test will error.
     * This method will error if attempting to delete a required test.
     * </pre>
     */
    default void deleteTest(
        com.google.showcase.v1beta1.DeleteTestRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteTestMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Register a response to a test.
     * In cases where a test involves registering a final answer at the
     * end of the test, this method provides the means to do so.
     * </pre>
     */
    default void verifyTest(
        com.google.showcase.v1beta1.VerifyTestRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.VerifyTestResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getVerifyTestMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Testing.
   *
   * <pre>
   * A service to facilitate running discrete sets of tests
   * against Showcase.
   * Adding this comment with special characters for comment formatting tests:
   * 1. (abra-&gt;kadabra-&gt;alakazam)
   * 2) [Nonsense][]: `pokemon/&#42;&#47;psychic/&#42;`
   * </pre>
   */
  public abstract static class TestingImplBase implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return TestingGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Testing.
   *
   * <pre>
   * A service to facilitate running discrete sets of tests
   * against Showcase.
   * Adding this comment with special characters for comment formatting tests:
   * 1. (abra-&gt;kadabra-&gt;alakazam)
   * 2) [Nonsense][]: `pokemon/&#42;&#47;psychic/&#42;`
   * </pre>
   */
  public static final class TestingStub extends io.grpc.stub.AbstractAsyncStub<TestingStub> {
    private TestingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TestingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TestingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new testing session.
     * Adding this comment with special characters for comment formatting tests:
     * 1. (abra-&gt;kadabra-&gt;alakazam)
     * 2) [Nonsense][]: `pokemon/&#42;&#47;psychic/&#42;`
     * </pre>
     */
    public void createSession(
        com.google.showcase.v1beta1.CreateSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.Session> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSessionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a testing session.
     * </pre>
     */
    public void getSession(
        com.google.showcase.v1beta1.GetSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.Session> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSessionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the current test sessions.
     * </pre>
     */
    public void listSessions(
        com.google.showcase.v1beta1.ListSessionsRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.ListSessionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSessionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a test session.
     * </pre>
     */
    public void deleteSession(
        com.google.showcase.v1beta1.DeleteSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSessionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Report on the status of a session.
     * This generates a report detailing which tests have been completed,
     * and an overall rollup.
     * </pre>
     */
    public void reportSession(
        com.google.showcase.v1beta1.ReportSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.ReportSessionResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReportSessionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List the tests of a sessesion.
     * </pre>
     */
    public void listTests(
        com.google.showcase.v1beta1.ListTestsRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.ListTestsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTestsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Explicitly decline to implement a test.
     * This removes the test from subsequent `ListTests` calls, and
     * attempting to do the test will error.
     * This method will error if attempting to delete a required test.
     * </pre>
     */
    public void deleteTest(
        com.google.showcase.v1beta1.DeleteTestRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTestMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Register a response to a test.
     * In cases where a test involves registering a final answer at the
     * end of the test, this method provides the means to do so.
     * </pre>
     */
    public void verifyTest(
        com.google.showcase.v1beta1.VerifyTestRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.VerifyTestResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getVerifyTestMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Testing.
   *
   * <pre>
   * A service to facilitate running discrete sets of tests
   * against Showcase.
   * Adding this comment with special characters for comment formatting tests:
   * 1. (abra-&gt;kadabra-&gt;alakazam)
   * 2) [Nonsense][]: `pokemon/&#42;&#47;psychic/&#42;`
   * </pre>
   */
  public static final class TestingBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<TestingBlockingV2Stub> {
    private TestingBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TestingBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TestingBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new testing session.
     * Adding this comment with special characters for comment formatting tests:
     * 1. (abra-&gt;kadabra-&gt;alakazam)
     * 2) [Nonsense][]: `pokemon/&#42;&#47;psychic/&#42;`
     * </pre>
     */
    public com.google.showcase.v1beta1.Session createSession(
        com.google.showcase.v1beta1.CreateSessionRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a testing session.
     * </pre>
     */
    public com.google.showcase.v1beta1.Session getSession(
        com.google.showcase.v1beta1.GetSessionRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the current test sessions.
     * </pre>
     */
    public com.google.showcase.v1beta1.ListSessionsResponse listSessions(
        com.google.showcase.v1beta1.ListSessionsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListSessionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a test session.
     * </pre>
     */
    public com.google.protobuf.Empty deleteSession(
        com.google.showcase.v1beta1.DeleteSessionRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Report on the status of a session.
     * This generates a report detailing which tests have been completed,
     * and an overall rollup.
     * </pre>
     */
    public com.google.showcase.v1beta1.ReportSessionResponse reportSession(
        com.google.showcase.v1beta1.ReportSessionRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getReportSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List the tests of a sessesion.
     * </pre>
     */
    public com.google.showcase.v1beta1.ListTestsResponse listTests(
        com.google.showcase.v1beta1.ListTestsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListTestsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Explicitly decline to implement a test.
     * This removes the test from subsequent `ListTests` calls, and
     * attempting to do the test will error.
     * This method will error if attempting to delete a required test.
     * </pre>
     */
    public com.google.protobuf.Empty deleteTest(
        com.google.showcase.v1beta1.DeleteTestRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteTestMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Register a response to a test.
     * In cases where a test involves registering a final answer at the
     * end of the test, this method provides the means to do so.
     * </pre>
     */
    public com.google.showcase.v1beta1.VerifyTestResponse verifyTest(
        com.google.showcase.v1beta1.VerifyTestRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getVerifyTestMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service Testing.
   *
   * <pre>
   * A service to facilitate running discrete sets of tests
   * against Showcase.
   * Adding this comment with special characters for comment formatting tests:
   * 1. (abra-&gt;kadabra-&gt;alakazam)
   * 2) [Nonsense][]: `pokemon/&#42;&#47;psychic/&#42;`
   * </pre>
   */
  public static final class TestingBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<TestingBlockingStub> {
    private TestingBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TestingBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TestingBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new testing session.
     * Adding this comment with special characters for comment formatting tests:
     * 1. (abra-&gt;kadabra-&gt;alakazam)
     * 2) [Nonsense][]: `pokemon/&#42;&#47;psychic/&#42;`
     * </pre>
     */
    public com.google.showcase.v1beta1.Session createSession(
        com.google.showcase.v1beta1.CreateSessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a testing session.
     * </pre>
     */
    public com.google.showcase.v1beta1.Session getSession(
        com.google.showcase.v1beta1.GetSessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the current test sessions.
     * </pre>
     */
    public com.google.showcase.v1beta1.ListSessionsResponse listSessions(
        com.google.showcase.v1beta1.ListSessionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSessionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a test session.
     * </pre>
     */
    public com.google.protobuf.Empty deleteSession(
        com.google.showcase.v1beta1.DeleteSessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Report on the status of a session.
     * This generates a report detailing which tests have been completed,
     * and an overall rollup.
     * </pre>
     */
    public com.google.showcase.v1beta1.ReportSessionResponse reportSession(
        com.google.showcase.v1beta1.ReportSessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReportSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List the tests of a sessesion.
     * </pre>
     */
    public com.google.showcase.v1beta1.ListTestsResponse listTests(
        com.google.showcase.v1beta1.ListTestsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTestsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Explicitly decline to implement a test.
     * This removes the test from subsequent `ListTests` calls, and
     * attempting to do the test will error.
     * This method will error if attempting to delete a required test.
     * </pre>
     */
    public com.google.protobuf.Empty deleteTest(
        com.google.showcase.v1beta1.DeleteTestRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTestMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Register a response to a test.
     * In cases where a test involves registering a final answer at the
     * end of the test, this method provides the means to do so.
     * </pre>
     */
    public com.google.showcase.v1beta1.VerifyTestResponse verifyTest(
        com.google.showcase.v1beta1.VerifyTestRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getVerifyTestMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Testing.
   *
   * <pre>
   * A service to facilitate running discrete sets of tests
   * against Showcase.
   * Adding this comment with special characters for comment formatting tests:
   * 1. (abra-&gt;kadabra-&gt;alakazam)
   * 2) [Nonsense][]: `pokemon/&#42;&#47;psychic/&#42;`
   * </pre>
   */
  public static final class TestingFutureStub
      extends io.grpc.stub.AbstractFutureStub<TestingFutureStub> {
    private TestingFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TestingFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TestingFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new testing session.
     * Adding this comment with special characters for comment formatting tests:
     * 1. (abra-&gt;kadabra-&gt;alakazam)
     * 2) [Nonsense][]: `pokemon/&#42;&#47;psychic/&#42;`
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.showcase.v1beta1.Session>
        createSession(com.google.showcase.v1beta1.CreateSessionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSessionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a testing session.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.showcase.v1beta1.Session>
        getSession(com.google.showcase.v1beta1.GetSessionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSessionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the current test sessions.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.showcase.v1beta1.ListSessionsResponse>
        listSessions(com.google.showcase.v1beta1.ListSessionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSessionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a test session.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteSession(com.google.showcase.v1beta1.DeleteSessionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSessionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Report on the status of a session.
     * This generates a report detailing which tests have been completed,
     * and an overall rollup.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.showcase.v1beta1.ReportSessionResponse>
        reportSession(com.google.showcase.v1beta1.ReportSessionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReportSessionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List the tests of a sessesion.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.showcase.v1beta1.ListTestsResponse>
        listTests(com.google.showcase.v1beta1.ListTestsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTestsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Explicitly decline to implement a test.
     * This removes the test from subsequent `ListTests` calls, and
     * attempting to do the test will error.
     * This method will error if attempting to delete a required test.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteTest(
        com.google.showcase.v1beta1.DeleteTestRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTestMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Register a response to a test.
     * In cases where a test involves registering a final answer at the
     * end of the test, this method provides the means to do so.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.showcase.v1beta1.VerifyTestResponse>
        verifyTest(com.google.showcase.v1beta1.VerifyTestRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getVerifyTestMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_SESSION = 0;
  private static final int METHODID_GET_SESSION = 1;
  private static final int METHODID_LIST_SESSIONS = 2;
  private static final int METHODID_DELETE_SESSION = 3;
  private static final int METHODID_REPORT_SESSION = 4;
  private static final int METHODID_LIST_TESTS = 5;
  private static final int METHODID_DELETE_TEST = 6;
  private static final int METHODID_VERIFY_TEST = 7;

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
        case METHODID_CREATE_SESSION:
          serviceImpl.createSession(
              (com.google.showcase.v1beta1.CreateSessionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.Session>) responseObserver);
          break;
        case METHODID_GET_SESSION:
          serviceImpl.getSession(
              (com.google.showcase.v1beta1.GetSessionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.Session>) responseObserver);
          break;
        case METHODID_LIST_SESSIONS:
          serviceImpl.listSessions(
              (com.google.showcase.v1beta1.ListSessionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.ListSessionsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_SESSION:
          serviceImpl.deleteSession(
              (com.google.showcase.v1beta1.DeleteSessionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_REPORT_SESSION:
          serviceImpl.reportSession(
              (com.google.showcase.v1beta1.ReportSessionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.ReportSessionResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_TESTS:
          serviceImpl.listTests(
              (com.google.showcase.v1beta1.ListTestsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.ListTestsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_TEST:
          serviceImpl.deleteTest(
              (com.google.showcase.v1beta1.DeleteTestRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_VERIFY_TEST:
          serviceImpl.verifyTest(
              (com.google.showcase.v1beta1.VerifyTestRequest) request,
              (io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.VerifyTestResponse>)
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
            getCreateSessionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.showcase.v1beta1.CreateSessionRequest,
                    com.google.showcase.v1beta1.Session>(service, METHODID_CREATE_SESSION)))
        .addMethod(
            getGetSessionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.showcase.v1beta1.GetSessionRequest,
                    com.google.showcase.v1beta1.Session>(service, METHODID_GET_SESSION)))
        .addMethod(
            getListSessionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.showcase.v1beta1.ListSessionsRequest,
                    com.google.showcase.v1beta1.ListSessionsResponse>(
                    service, METHODID_LIST_SESSIONS)))
        .addMethod(
            getDeleteSessionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.showcase.v1beta1.DeleteSessionRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_SESSION)))
        .addMethod(
            getReportSessionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.showcase.v1beta1.ReportSessionRequest,
                    com.google.showcase.v1beta1.ReportSessionResponse>(
                    service, METHODID_REPORT_SESSION)))
        .addMethod(
            getListTestsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.showcase.v1beta1.ListTestsRequest,
                    com.google.showcase.v1beta1.ListTestsResponse>(service, METHODID_LIST_TESTS)))
        .addMethod(
            getDeleteTestMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.showcase.v1beta1.DeleteTestRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_TEST)))
        .addMethod(
            getVerifyTestMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.showcase.v1beta1.VerifyTestRequest,
                    com.google.showcase.v1beta1.VerifyTestResponse>(service, METHODID_VERIFY_TEST)))
        .build();
  }

  private abstract static class TestingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TestingBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.showcase.v1beta1.TestingOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Testing");
    }
  }

  private static final class TestingFileDescriptorSupplier extends TestingBaseDescriptorSupplier {
    TestingFileDescriptorSupplier() {}
  }

  private static final class TestingMethodDescriptorSupplier extends TestingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    TestingMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (TestingGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new TestingFileDescriptorSupplier())
                      .addMethod(getCreateSessionMethod())
                      .addMethod(getGetSessionMethod())
                      .addMethod(getListSessionsMethod())
                      .addMethod(getDeleteSessionMethod())
                      .addMethod(getReportSessionMethod())
                      .addMethod(getListTestsMethod())
                      .addMethod(getDeleteTestMethod())
                      .addMethod(getVerifyTestMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
