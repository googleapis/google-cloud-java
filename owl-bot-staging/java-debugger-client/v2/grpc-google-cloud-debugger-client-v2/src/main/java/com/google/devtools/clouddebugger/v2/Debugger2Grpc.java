package com.google.devtools.clouddebugger.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * The Debugger service provides the API that allows users to collect run-time
 * information from a running application, without stopping or slowing it down
 * and without modifying its state.  An application may include one or
 * more replicated processes performing the same work.
 * A debugged application is represented using the Debuggee concept. The
 * Debugger service provides a way to query for available debuggees, but does
 * not provide a way to create one.  A debuggee is created using the Controller
 * service, usually by running a debugger agent with the application.
 * The Debugger service enables the client to set one or more Breakpoints on a
 * Debuggee and collect the results of the set Breakpoints.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/devtools/clouddebugger/v2/debugger.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class Debugger2Grpc {

  private Debugger2Grpc() {}

  public static final String SERVICE_NAME = "google.devtools.clouddebugger.v2.Debugger2";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.devtools.clouddebugger.v2.SetBreakpointRequest,
      com.google.devtools.clouddebugger.v2.SetBreakpointResponse> getSetBreakpointMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetBreakpoint",
      requestType = com.google.devtools.clouddebugger.v2.SetBreakpointRequest.class,
      responseType = com.google.devtools.clouddebugger.v2.SetBreakpointResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.devtools.clouddebugger.v2.SetBreakpointRequest,
      com.google.devtools.clouddebugger.v2.SetBreakpointResponse> getSetBreakpointMethod() {
    io.grpc.MethodDescriptor<com.google.devtools.clouddebugger.v2.SetBreakpointRequest, com.google.devtools.clouddebugger.v2.SetBreakpointResponse> getSetBreakpointMethod;
    if ((getSetBreakpointMethod = Debugger2Grpc.getSetBreakpointMethod) == null) {
      synchronized (Debugger2Grpc.class) {
        if ((getSetBreakpointMethod = Debugger2Grpc.getSetBreakpointMethod) == null) {
          Debugger2Grpc.getSetBreakpointMethod = getSetBreakpointMethod =
              io.grpc.MethodDescriptor.<com.google.devtools.clouddebugger.v2.SetBreakpointRequest, com.google.devtools.clouddebugger.v2.SetBreakpointResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetBreakpoint"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.devtools.clouddebugger.v2.SetBreakpointRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.devtools.clouddebugger.v2.SetBreakpointResponse.getDefaultInstance()))
              .setSchemaDescriptor(new Debugger2MethodDescriptorSupplier("SetBreakpoint"))
              .build();
        }
      }
    }
    return getSetBreakpointMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.devtools.clouddebugger.v2.GetBreakpointRequest,
      com.google.devtools.clouddebugger.v2.GetBreakpointResponse> getGetBreakpointMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBreakpoint",
      requestType = com.google.devtools.clouddebugger.v2.GetBreakpointRequest.class,
      responseType = com.google.devtools.clouddebugger.v2.GetBreakpointResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.devtools.clouddebugger.v2.GetBreakpointRequest,
      com.google.devtools.clouddebugger.v2.GetBreakpointResponse> getGetBreakpointMethod() {
    io.grpc.MethodDescriptor<com.google.devtools.clouddebugger.v2.GetBreakpointRequest, com.google.devtools.clouddebugger.v2.GetBreakpointResponse> getGetBreakpointMethod;
    if ((getGetBreakpointMethod = Debugger2Grpc.getGetBreakpointMethod) == null) {
      synchronized (Debugger2Grpc.class) {
        if ((getGetBreakpointMethod = Debugger2Grpc.getGetBreakpointMethod) == null) {
          Debugger2Grpc.getGetBreakpointMethod = getGetBreakpointMethod =
              io.grpc.MethodDescriptor.<com.google.devtools.clouddebugger.v2.GetBreakpointRequest, com.google.devtools.clouddebugger.v2.GetBreakpointResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBreakpoint"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.devtools.clouddebugger.v2.GetBreakpointRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.devtools.clouddebugger.v2.GetBreakpointResponse.getDefaultInstance()))
              .setSchemaDescriptor(new Debugger2MethodDescriptorSupplier("GetBreakpoint"))
              .build();
        }
      }
    }
    return getGetBreakpointMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.devtools.clouddebugger.v2.DeleteBreakpointRequest,
      com.google.protobuf.Empty> getDeleteBreakpointMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteBreakpoint",
      requestType = com.google.devtools.clouddebugger.v2.DeleteBreakpointRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.devtools.clouddebugger.v2.DeleteBreakpointRequest,
      com.google.protobuf.Empty> getDeleteBreakpointMethod() {
    io.grpc.MethodDescriptor<com.google.devtools.clouddebugger.v2.DeleteBreakpointRequest, com.google.protobuf.Empty> getDeleteBreakpointMethod;
    if ((getDeleteBreakpointMethod = Debugger2Grpc.getDeleteBreakpointMethod) == null) {
      synchronized (Debugger2Grpc.class) {
        if ((getDeleteBreakpointMethod = Debugger2Grpc.getDeleteBreakpointMethod) == null) {
          Debugger2Grpc.getDeleteBreakpointMethod = getDeleteBreakpointMethod =
              io.grpc.MethodDescriptor.<com.google.devtools.clouddebugger.v2.DeleteBreakpointRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteBreakpoint"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.devtools.clouddebugger.v2.DeleteBreakpointRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new Debugger2MethodDescriptorSupplier("DeleteBreakpoint"))
              .build();
        }
      }
    }
    return getDeleteBreakpointMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.devtools.clouddebugger.v2.ListBreakpointsRequest,
      com.google.devtools.clouddebugger.v2.ListBreakpointsResponse> getListBreakpointsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBreakpoints",
      requestType = com.google.devtools.clouddebugger.v2.ListBreakpointsRequest.class,
      responseType = com.google.devtools.clouddebugger.v2.ListBreakpointsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.devtools.clouddebugger.v2.ListBreakpointsRequest,
      com.google.devtools.clouddebugger.v2.ListBreakpointsResponse> getListBreakpointsMethod() {
    io.grpc.MethodDescriptor<com.google.devtools.clouddebugger.v2.ListBreakpointsRequest, com.google.devtools.clouddebugger.v2.ListBreakpointsResponse> getListBreakpointsMethod;
    if ((getListBreakpointsMethod = Debugger2Grpc.getListBreakpointsMethod) == null) {
      synchronized (Debugger2Grpc.class) {
        if ((getListBreakpointsMethod = Debugger2Grpc.getListBreakpointsMethod) == null) {
          Debugger2Grpc.getListBreakpointsMethod = getListBreakpointsMethod =
              io.grpc.MethodDescriptor.<com.google.devtools.clouddebugger.v2.ListBreakpointsRequest, com.google.devtools.clouddebugger.v2.ListBreakpointsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListBreakpoints"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.devtools.clouddebugger.v2.ListBreakpointsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.devtools.clouddebugger.v2.ListBreakpointsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new Debugger2MethodDescriptorSupplier("ListBreakpoints"))
              .build();
        }
      }
    }
    return getListBreakpointsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.devtools.clouddebugger.v2.ListDebuggeesRequest,
      com.google.devtools.clouddebugger.v2.ListDebuggeesResponse> getListDebuggeesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDebuggees",
      requestType = com.google.devtools.clouddebugger.v2.ListDebuggeesRequest.class,
      responseType = com.google.devtools.clouddebugger.v2.ListDebuggeesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.devtools.clouddebugger.v2.ListDebuggeesRequest,
      com.google.devtools.clouddebugger.v2.ListDebuggeesResponse> getListDebuggeesMethod() {
    io.grpc.MethodDescriptor<com.google.devtools.clouddebugger.v2.ListDebuggeesRequest, com.google.devtools.clouddebugger.v2.ListDebuggeesResponse> getListDebuggeesMethod;
    if ((getListDebuggeesMethod = Debugger2Grpc.getListDebuggeesMethod) == null) {
      synchronized (Debugger2Grpc.class) {
        if ((getListDebuggeesMethod = Debugger2Grpc.getListDebuggeesMethod) == null) {
          Debugger2Grpc.getListDebuggeesMethod = getListDebuggeesMethod =
              io.grpc.MethodDescriptor.<com.google.devtools.clouddebugger.v2.ListDebuggeesRequest, com.google.devtools.clouddebugger.v2.ListDebuggeesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDebuggees"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.devtools.clouddebugger.v2.ListDebuggeesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.devtools.clouddebugger.v2.ListDebuggeesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new Debugger2MethodDescriptorSupplier("ListDebuggees"))
              .build();
        }
      }
    }
    return getListDebuggeesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static Debugger2Stub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<Debugger2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<Debugger2Stub>() {
        @java.lang.Override
        public Debugger2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new Debugger2Stub(channel, callOptions);
        }
      };
    return Debugger2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static Debugger2BlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<Debugger2BlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<Debugger2BlockingStub>() {
        @java.lang.Override
        public Debugger2BlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new Debugger2BlockingStub(channel, callOptions);
        }
      };
    return Debugger2BlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static Debugger2FutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<Debugger2FutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<Debugger2FutureStub>() {
        @java.lang.Override
        public Debugger2FutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new Debugger2FutureStub(channel, callOptions);
        }
      };
    return Debugger2FutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * The Debugger service provides the API that allows users to collect run-time
   * information from a running application, without stopping or slowing it down
   * and without modifying its state.  An application may include one or
   * more replicated processes performing the same work.
   * A debugged application is represented using the Debuggee concept. The
   * Debugger service provides a way to query for available debuggees, but does
   * not provide a way to create one.  A debuggee is created using the Controller
   * service, usually by running a debugger agent with the application.
   * The Debugger service enables the client to set one or more Breakpoints on a
   * Debuggee and collect the results of the set Breakpoints.
   * </pre>
   */
  public static abstract class Debugger2ImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sets the breakpoint to the debuggee.
     * </pre>
     */
    public void setBreakpoint(com.google.devtools.clouddebugger.v2.SetBreakpointRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.clouddebugger.v2.SetBreakpointResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetBreakpointMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets breakpoint information.
     * </pre>
     */
    public void getBreakpoint(com.google.devtools.clouddebugger.v2.GetBreakpointRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.clouddebugger.v2.GetBreakpointResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetBreakpointMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes the breakpoint from the debuggee.
     * </pre>
     */
    public void deleteBreakpoint(com.google.devtools.clouddebugger.v2.DeleteBreakpointRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteBreakpointMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists all breakpoints for the debuggee.
     * </pre>
     */
    public void listBreakpoints(com.google.devtools.clouddebugger.v2.ListBreakpointsRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.clouddebugger.v2.ListBreakpointsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListBreakpointsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists all the debuggees that the user has access to.
     * </pre>
     */
    public void listDebuggees(com.google.devtools.clouddebugger.v2.ListDebuggeesRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.clouddebugger.v2.ListDebuggeesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListDebuggeesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSetBreakpointMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.devtools.clouddebugger.v2.SetBreakpointRequest,
                com.google.devtools.clouddebugger.v2.SetBreakpointResponse>(
                  this, METHODID_SET_BREAKPOINT)))
          .addMethod(
            getGetBreakpointMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.devtools.clouddebugger.v2.GetBreakpointRequest,
                com.google.devtools.clouddebugger.v2.GetBreakpointResponse>(
                  this, METHODID_GET_BREAKPOINT)))
          .addMethod(
            getDeleteBreakpointMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.devtools.clouddebugger.v2.DeleteBreakpointRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_BREAKPOINT)))
          .addMethod(
            getListBreakpointsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.devtools.clouddebugger.v2.ListBreakpointsRequest,
                com.google.devtools.clouddebugger.v2.ListBreakpointsResponse>(
                  this, METHODID_LIST_BREAKPOINTS)))
          .addMethod(
            getListDebuggeesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.devtools.clouddebugger.v2.ListDebuggeesRequest,
                com.google.devtools.clouddebugger.v2.ListDebuggeesResponse>(
                  this, METHODID_LIST_DEBUGGEES)))
          .build();
    }
  }

  /**
   * <pre>
   * The Debugger service provides the API that allows users to collect run-time
   * information from a running application, without stopping or slowing it down
   * and without modifying its state.  An application may include one or
   * more replicated processes performing the same work.
   * A debugged application is represented using the Debuggee concept. The
   * Debugger service provides a way to query for available debuggees, but does
   * not provide a way to create one.  A debuggee is created using the Controller
   * service, usually by running a debugger agent with the application.
   * The Debugger service enables the client to set one or more Breakpoints on a
   * Debuggee and collect the results of the set Breakpoints.
   * </pre>
   */
  public static final class Debugger2Stub extends io.grpc.stub.AbstractAsyncStub<Debugger2Stub> {
    private Debugger2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Debugger2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new Debugger2Stub(channel, callOptions);
    }

    /**
     * <pre>
     * Sets the breakpoint to the debuggee.
     * </pre>
     */
    public void setBreakpoint(com.google.devtools.clouddebugger.v2.SetBreakpointRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.clouddebugger.v2.SetBreakpointResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetBreakpointMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets breakpoint information.
     * </pre>
     */
    public void getBreakpoint(com.google.devtools.clouddebugger.v2.GetBreakpointRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.clouddebugger.v2.GetBreakpointResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBreakpointMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes the breakpoint from the debuggee.
     * </pre>
     */
    public void deleteBreakpoint(com.google.devtools.clouddebugger.v2.DeleteBreakpointRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteBreakpointMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists all breakpoints for the debuggee.
     * </pre>
     */
    public void listBreakpoints(com.google.devtools.clouddebugger.v2.ListBreakpointsRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.clouddebugger.v2.ListBreakpointsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListBreakpointsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists all the debuggees that the user has access to.
     * </pre>
     */
    public void listDebuggees(com.google.devtools.clouddebugger.v2.ListDebuggeesRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.clouddebugger.v2.ListDebuggeesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDebuggeesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The Debugger service provides the API that allows users to collect run-time
   * information from a running application, without stopping or slowing it down
   * and without modifying its state.  An application may include one or
   * more replicated processes performing the same work.
   * A debugged application is represented using the Debuggee concept. The
   * Debugger service provides a way to query for available debuggees, but does
   * not provide a way to create one.  A debuggee is created using the Controller
   * service, usually by running a debugger agent with the application.
   * The Debugger service enables the client to set one or more Breakpoints on a
   * Debuggee and collect the results of the set Breakpoints.
   * </pre>
   */
  public static final class Debugger2BlockingStub extends io.grpc.stub.AbstractBlockingStub<Debugger2BlockingStub> {
    private Debugger2BlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Debugger2BlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new Debugger2BlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sets the breakpoint to the debuggee.
     * </pre>
     */
    public com.google.devtools.clouddebugger.v2.SetBreakpointResponse setBreakpoint(com.google.devtools.clouddebugger.v2.SetBreakpointRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetBreakpointMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets breakpoint information.
     * </pre>
     */
    public com.google.devtools.clouddebugger.v2.GetBreakpointResponse getBreakpoint(com.google.devtools.clouddebugger.v2.GetBreakpointRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBreakpointMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes the breakpoint from the debuggee.
     * </pre>
     */
    public com.google.protobuf.Empty deleteBreakpoint(com.google.devtools.clouddebugger.v2.DeleteBreakpointRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteBreakpointMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists all breakpoints for the debuggee.
     * </pre>
     */
    public com.google.devtools.clouddebugger.v2.ListBreakpointsResponse listBreakpoints(com.google.devtools.clouddebugger.v2.ListBreakpointsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBreakpointsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists all the debuggees that the user has access to.
     * </pre>
     */
    public com.google.devtools.clouddebugger.v2.ListDebuggeesResponse listDebuggees(com.google.devtools.clouddebugger.v2.ListDebuggeesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDebuggeesMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The Debugger service provides the API that allows users to collect run-time
   * information from a running application, without stopping or slowing it down
   * and without modifying its state.  An application may include one or
   * more replicated processes performing the same work.
   * A debugged application is represented using the Debuggee concept. The
   * Debugger service provides a way to query for available debuggees, but does
   * not provide a way to create one.  A debuggee is created using the Controller
   * service, usually by running a debugger agent with the application.
   * The Debugger service enables the client to set one or more Breakpoints on a
   * Debuggee and collect the results of the set Breakpoints.
   * </pre>
   */
  public static final class Debugger2FutureStub extends io.grpc.stub.AbstractFutureStub<Debugger2FutureStub> {
    private Debugger2FutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Debugger2FutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new Debugger2FutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sets the breakpoint to the debuggee.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.devtools.clouddebugger.v2.SetBreakpointResponse> setBreakpoint(
        com.google.devtools.clouddebugger.v2.SetBreakpointRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetBreakpointMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets breakpoint information.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.devtools.clouddebugger.v2.GetBreakpointResponse> getBreakpoint(
        com.google.devtools.clouddebugger.v2.GetBreakpointRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBreakpointMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes the breakpoint from the debuggee.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteBreakpoint(
        com.google.devtools.clouddebugger.v2.DeleteBreakpointRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteBreakpointMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists all breakpoints for the debuggee.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.devtools.clouddebugger.v2.ListBreakpointsResponse> listBreakpoints(
        com.google.devtools.clouddebugger.v2.ListBreakpointsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListBreakpointsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists all the debuggees that the user has access to.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.devtools.clouddebugger.v2.ListDebuggeesResponse> listDebuggees(
        com.google.devtools.clouddebugger.v2.ListDebuggeesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDebuggeesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SET_BREAKPOINT = 0;
  private static final int METHODID_GET_BREAKPOINT = 1;
  private static final int METHODID_DELETE_BREAKPOINT = 2;
  private static final int METHODID_LIST_BREAKPOINTS = 3;
  private static final int METHODID_LIST_DEBUGGEES = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final Debugger2ImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(Debugger2ImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SET_BREAKPOINT:
          serviceImpl.setBreakpoint((com.google.devtools.clouddebugger.v2.SetBreakpointRequest) request,
              (io.grpc.stub.StreamObserver<com.google.devtools.clouddebugger.v2.SetBreakpointResponse>) responseObserver);
          break;
        case METHODID_GET_BREAKPOINT:
          serviceImpl.getBreakpoint((com.google.devtools.clouddebugger.v2.GetBreakpointRequest) request,
              (io.grpc.stub.StreamObserver<com.google.devtools.clouddebugger.v2.GetBreakpointResponse>) responseObserver);
          break;
        case METHODID_DELETE_BREAKPOINT:
          serviceImpl.deleteBreakpoint((com.google.devtools.clouddebugger.v2.DeleteBreakpointRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_BREAKPOINTS:
          serviceImpl.listBreakpoints((com.google.devtools.clouddebugger.v2.ListBreakpointsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.devtools.clouddebugger.v2.ListBreakpointsResponse>) responseObserver);
          break;
        case METHODID_LIST_DEBUGGEES:
          serviceImpl.listDebuggees((com.google.devtools.clouddebugger.v2.ListDebuggeesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.devtools.clouddebugger.v2.ListDebuggeesResponse>) responseObserver);
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

  private static abstract class Debugger2BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    Debugger2BaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.devtools.clouddebugger.v2.DebuggerProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Debugger2");
    }
  }

  private static final class Debugger2FileDescriptorSupplier
      extends Debugger2BaseDescriptorSupplier {
    Debugger2FileDescriptorSupplier() {}
  }

  private static final class Debugger2MethodDescriptorSupplier
      extends Debugger2BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    Debugger2MethodDescriptorSupplier(String methodName) {
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
      synchronized (Debugger2Grpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new Debugger2FileDescriptorSupplier())
              .addMethod(getSetBreakpointMethod())
              .addMethod(getGetBreakpointMethod())
              .addMethod(getDeleteBreakpointMethod())
              .addMethod(getListBreakpointsMethod())
              .addMethod(getListDebuggeesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
