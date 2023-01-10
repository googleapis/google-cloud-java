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
package com.google.devtools.clouddebugger.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The Controller service provides the API for orchestrating a collection of
 * debugger agents to perform debugging tasks. These agents are each attached
 * to a process of an application which may include one or more replicas.
 * The debugger agents register with the Controller to identify the application
 * being debugged, the Debuggee. All agents that register with the same data,
 * represent the same Debuggee, and are assigned the same `debuggee_id`.
 * The debugger agents call the Controller to retrieve  the list of active
 * Breakpoints. Agents with the same `debuggee_id` get the same breakpoints
 * list. An agent that can fulfill the breakpoint request updates the
 * Controller with the breakpoint result. The controller selects the first
 * result received and discards the rest of the results.
 * Agents that poll again for active breakpoints will no longer have
 * the completed breakpoint in the list and should remove that breakpoint from
 * their attached process.
 * The Controller service does not provide a way to retrieve the results of
 * a completed breakpoint. This functionality is available using the Debugger
 * service.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/devtools/clouddebugger/v2/controller.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class Controller2Grpc {

  private Controller2Grpc() {}

  public static final String SERVICE_NAME = "google.devtools.clouddebugger.v2.Controller2";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.clouddebugger.v2.RegisterDebuggeeRequest,
          com.google.devtools.clouddebugger.v2.RegisterDebuggeeResponse>
      getRegisterDebuggeeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RegisterDebuggee",
      requestType = com.google.devtools.clouddebugger.v2.RegisterDebuggeeRequest.class,
      responseType = com.google.devtools.clouddebugger.v2.RegisterDebuggeeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.clouddebugger.v2.RegisterDebuggeeRequest,
          com.google.devtools.clouddebugger.v2.RegisterDebuggeeResponse>
      getRegisterDebuggeeMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.clouddebugger.v2.RegisterDebuggeeRequest,
            com.google.devtools.clouddebugger.v2.RegisterDebuggeeResponse>
        getRegisterDebuggeeMethod;
    if ((getRegisterDebuggeeMethod = Controller2Grpc.getRegisterDebuggeeMethod) == null) {
      synchronized (Controller2Grpc.class) {
        if ((getRegisterDebuggeeMethod = Controller2Grpc.getRegisterDebuggeeMethod) == null) {
          Controller2Grpc.getRegisterDebuggeeMethod =
              getRegisterDebuggeeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.clouddebugger.v2.RegisterDebuggeeRequest,
                          com.google.devtools.clouddebugger.v2.RegisterDebuggeeResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RegisterDebuggee"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.clouddebugger.v2.RegisterDebuggeeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.clouddebugger.v2.RegisterDebuggeeResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new Controller2MethodDescriptorSupplier("RegisterDebuggee"))
                      .build();
        }
      }
    }
    return getRegisterDebuggeeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.clouddebugger.v2.ListActiveBreakpointsRequest,
          com.google.devtools.clouddebugger.v2.ListActiveBreakpointsResponse>
      getListActiveBreakpointsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListActiveBreakpoints",
      requestType = com.google.devtools.clouddebugger.v2.ListActiveBreakpointsRequest.class,
      responseType = com.google.devtools.clouddebugger.v2.ListActiveBreakpointsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.clouddebugger.v2.ListActiveBreakpointsRequest,
          com.google.devtools.clouddebugger.v2.ListActiveBreakpointsResponse>
      getListActiveBreakpointsMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.clouddebugger.v2.ListActiveBreakpointsRequest,
            com.google.devtools.clouddebugger.v2.ListActiveBreakpointsResponse>
        getListActiveBreakpointsMethod;
    if ((getListActiveBreakpointsMethod = Controller2Grpc.getListActiveBreakpointsMethod) == null) {
      synchronized (Controller2Grpc.class) {
        if ((getListActiveBreakpointsMethod = Controller2Grpc.getListActiveBreakpointsMethod)
            == null) {
          Controller2Grpc.getListActiveBreakpointsMethod =
              getListActiveBreakpointsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.clouddebugger.v2.ListActiveBreakpointsRequest,
                          com.google.devtools.clouddebugger.v2.ListActiveBreakpointsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListActiveBreakpoints"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.clouddebugger.v2.ListActiveBreakpointsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.clouddebugger.v2.ListActiveBreakpointsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new Controller2MethodDescriptorSupplier("ListActiveBreakpoints"))
                      .build();
        }
      }
    }
    return getListActiveBreakpointsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.clouddebugger.v2.UpdateActiveBreakpointRequest,
          com.google.devtools.clouddebugger.v2.UpdateActiveBreakpointResponse>
      getUpdateActiveBreakpointMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateActiveBreakpoint",
      requestType = com.google.devtools.clouddebugger.v2.UpdateActiveBreakpointRequest.class,
      responseType = com.google.devtools.clouddebugger.v2.UpdateActiveBreakpointResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.clouddebugger.v2.UpdateActiveBreakpointRequest,
          com.google.devtools.clouddebugger.v2.UpdateActiveBreakpointResponse>
      getUpdateActiveBreakpointMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.clouddebugger.v2.UpdateActiveBreakpointRequest,
            com.google.devtools.clouddebugger.v2.UpdateActiveBreakpointResponse>
        getUpdateActiveBreakpointMethod;
    if ((getUpdateActiveBreakpointMethod = Controller2Grpc.getUpdateActiveBreakpointMethod)
        == null) {
      synchronized (Controller2Grpc.class) {
        if ((getUpdateActiveBreakpointMethod = Controller2Grpc.getUpdateActiveBreakpointMethod)
            == null) {
          Controller2Grpc.getUpdateActiveBreakpointMethod =
              getUpdateActiveBreakpointMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.clouddebugger.v2.UpdateActiveBreakpointRequest,
                          com.google.devtools.clouddebugger.v2.UpdateActiveBreakpointResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateActiveBreakpoint"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.clouddebugger.v2.UpdateActiveBreakpointRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.clouddebugger.v2.UpdateActiveBreakpointResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new Controller2MethodDescriptorSupplier("UpdateActiveBreakpoint"))
                      .build();
        }
      }
    }
    return getUpdateActiveBreakpointMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static Controller2Stub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<Controller2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<Controller2Stub>() {
          @java.lang.Override
          public Controller2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new Controller2Stub(channel, callOptions);
          }
        };
    return Controller2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static Controller2BlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<Controller2BlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<Controller2BlockingStub>() {
          @java.lang.Override
          public Controller2BlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new Controller2BlockingStub(channel, callOptions);
          }
        };
    return Controller2BlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static Controller2FutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<Controller2FutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<Controller2FutureStub>() {
          @java.lang.Override
          public Controller2FutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new Controller2FutureStub(channel, callOptions);
          }
        };
    return Controller2FutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The Controller service provides the API for orchestrating a collection of
   * debugger agents to perform debugging tasks. These agents are each attached
   * to a process of an application which may include one or more replicas.
   * The debugger agents register with the Controller to identify the application
   * being debugged, the Debuggee. All agents that register with the same data,
   * represent the same Debuggee, and are assigned the same `debuggee_id`.
   * The debugger agents call the Controller to retrieve  the list of active
   * Breakpoints. Agents with the same `debuggee_id` get the same breakpoints
   * list. An agent that can fulfill the breakpoint request updates the
   * Controller with the breakpoint result. The controller selects the first
   * result received and discards the rest of the results.
   * Agents that poll again for active breakpoints will no longer have
   * the completed breakpoint in the list and should remove that breakpoint from
   * their attached process.
   * The Controller service does not provide a way to retrieve the results of
   * a completed breakpoint. This functionality is available using the Debugger
   * service.
   * </pre>
   */
  public abstract static class Controller2ImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Registers the debuggee with the controller service.
     * All agents attached to the same application must call this method with
     * exactly the same request content to get back the same stable `debuggee_id`.
     * Agents should call this method again whenever `google.rpc.Code.NOT_FOUND`
     * is returned from any controller method.
     * This protocol allows the controller service to disable debuggees, recover
     * from data loss, or change the `debuggee_id` format. Agents must handle
     * `debuggee_id` value changing upon re-registration.
     * </pre>
     */
    public void registerDebuggee(
        com.google.devtools.clouddebugger.v2.RegisterDebuggeeRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.clouddebugger.v2.RegisterDebuggeeResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRegisterDebuggeeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all active breakpoints for the debuggee.
     * The breakpoint specification (`location`, `condition`, and `expressions`
     * fields) is semantically immutable, although the field values may
     * change. For example, an agent may update the location line number
     * to reflect the actual line where the breakpoint was set, but this
     * doesn't change the breakpoint semantics.
     * This means that an agent does not need to check if a breakpoint has changed
     * when it encounters the same breakpoint on a successive call.
     * Moreover, an agent should remember the breakpoints that are completed
     * until the controller removes them from the active list to avoid
     * setting those breakpoints again.
     * </pre>
     */
    public void listActiveBreakpoints(
        com.google.devtools.clouddebugger.v2.ListActiveBreakpointsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.devtools.clouddebugger.v2.ListActiveBreakpointsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListActiveBreakpointsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the breakpoint state or mutable fields.
     * The entire Breakpoint message must be sent back to the controller service.
     * Updates to active breakpoint fields are only allowed if the new value
     * does not change the breakpoint specification. Updates to the `location`,
     * `condition` and `expressions` fields should not alter the breakpoint
     * semantics. These may only make changes such as canonicalizing a value
     * or snapping the location to the correct line of code.
     * </pre>
     */
    public void updateActiveBreakpoint(
        com.google.devtools.clouddebugger.v2.UpdateActiveBreakpointRequest request,
        io.grpc.stub.StreamObserver<
                com.google.devtools.clouddebugger.v2.UpdateActiveBreakpointResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateActiveBreakpointMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getRegisterDebuggeeMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.devtools.clouddebugger.v2.RegisterDebuggeeRequest,
                      com.google.devtools.clouddebugger.v2.RegisterDebuggeeResponse>(
                      this, METHODID_REGISTER_DEBUGGEE)))
          .addMethod(
              getListActiveBreakpointsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.devtools.clouddebugger.v2.ListActiveBreakpointsRequest,
                      com.google.devtools.clouddebugger.v2.ListActiveBreakpointsResponse>(
                      this, METHODID_LIST_ACTIVE_BREAKPOINTS)))
          .addMethod(
              getUpdateActiveBreakpointMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.devtools.clouddebugger.v2.UpdateActiveBreakpointRequest,
                      com.google.devtools.clouddebugger.v2.UpdateActiveBreakpointResponse>(
                      this, METHODID_UPDATE_ACTIVE_BREAKPOINT)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * The Controller service provides the API for orchestrating a collection of
   * debugger agents to perform debugging tasks. These agents are each attached
   * to a process of an application which may include one or more replicas.
   * The debugger agents register with the Controller to identify the application
   * being debugged, the Debuggee. All agents that register with the same data,
   * represent the same Debuggee, and are assigned the same `debuggee_id`.
   * The debugger agents call the Controller to retrieve  the list of active
   * Breakpoints. Agents with the same `debuggee_id` get the same breakpoints
   * list. An agent that can fulfill the breakpoint request updates the
   * Controller with the breakpoint result. The controller selects the first
   * result received and discards the rest of the results.
   * Agents that poll again for active breakpoints will no longer have
   * the completed breakpoint in the list and should remove that breakpoint from
   * their attached process.
   * The Controller service does not provide a way to retrieve the results of
   * a completed breakpoint. This functionality is available using the Debugger
   * service.
   * </pre>
   */
  public static final class Controller2Stub
      extends io.grpc.stub.AbstractAsyncStub<Controller2Stub> {
    private Controller2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Controller2Stub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new Controller2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Registers the debuggee with the controller service.
     * All agents attached to the same application must call this method with
     * exactly the same request content to get back the same stable `debuggee_id`.
     * Agents should call this method again whenever `google.rpc.Code.NOT_FOUND`
     * is returned from any controller method.
     * This protocol allows the controller service to disable debuggees, recover
     * from data loss, or change the `debuggee_id` format. Agents must handle
     * `debuggee_id` value changing upon re-registration.
     * </pre>
     */
    public void registerDebuggee(
        com.google.devtools.clouddebugger.v2.RegisterDebuggeeRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.clouddebugger.v2.RegisterDebuggeeResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRegisterDebuggeeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all active breakpoints for the debuggee.
     * The breakpoint specification (`location`, `condition`, and `expressions`
     * fields) is semantically immutable, although the field values may
     * change. For example, an agent may update the location line number
     * to reflect the actual line where the breakpoint was set, but this
     * doesn't change the breakpoint semantics.
     * This means that an agent does not need to check if a breakpoint has changed
     * when it encounters the same breakpoint on a successive call.
     * Moreover, an agent should remember the breakpoints that are completed
     * until the controller removes them from the active list to avoid
     * setting those breakpoints again.
     * </pre>
     */
    public void listActiveBreakpoints(
        com.google.devtools.clouddebugger.v2.ListActiveBreakpointsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.devtools.clouddebugger.v2.ListActiveBreakpointsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListActiveBreakpointsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the breakpoint state or mutable fields.
     * The entire Breakpoint message must be sent back to the controller service.
     * Updates to active breakpoint fields are only allowed if the new value
     * does not change the breakpoint specification. Updates to the `location`,
     * `condition` and `expressions` fields should not alter the breakpoint
     * semantics. These may only make changes such as canonicalizing a value
     * or snapping the location to the correct line of code.
     * </pre>
     */
    public void updateActiveBreakpoint(
        com.google.devtools.clouddebugger.v2.UpdateActiveBreakpointRequest request,
        io.grpc.stub.StreamObserver<
                com.google.devtools.clouddebugger.v2.UpdateActiveBreakpointResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateActiveBreakpointMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * The Controller service provides the API for orchestrating a collection of
   * debugger agents to perform debugging tasks. These agents are each attached
   * to a process of an application which may include one or more replicas.
   * The debugger agents register with the Controller to identify the application
   * being debugged, the Debuggee. All agents that register with the same data,
   * represent the same Debuggee, and are assigned the same `debuggee_id`.
   * The debugger agents call the Controller to retrieve  the list of active
   * Breakpoints. Agents with the same `debuggee_id` get the same breakpoints
   * list. An agent that can fulfill the breakpoint request updates the
   * Controller with the breakpoint result. The controller selects the first
   * result received and discards the rest of the results.
   * Agents that poll again for active breakpoints will no longer have
   * the completed breakpoint in the list and should remove that breakpoint from
   * their attached process.
   * The Controller service does not provide a way to retrieve the results of
   * a completed breakpoint. This functionality is available using the Debugger
   * service.
   * </pre>
   */
  public static final class Controller2BlockingStub
      extends io.grpc.stub.AbstractBlockingStub<Controller2BlockingStub> {
    private Controller2BlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Controller2BlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new Controller2BlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Registers the debuggee with the controller service.
     * All agents attached to the same application must call this method with
     * exactly the same request content to get back the same stable `debuggee_id`.
     * Agents should call this method again whenever `google.rpc.Code.NOT_FOUND`
     * is returned from any controller method.
     * This protocol allows the controller service to disable debuggees, recover
     * from data loss, or change the `debuggee_id` format. Agents must handle
     * `debuggee_id` value changing upon re-registration.
     * </pre>
     */
    public com.google.devtools.clouddebugger.v2.RegisterDebuggeeResponse registerDebuggee(
        com.google.devtools.clouddebugger.v2.RegisterDebuggeeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRegisterDebuggeeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all active breakpoints for the debuggee.
     * The breakpoint specification (`location`, `condition`, and `expressions`
     * fields) is semantically immutable, although the field values may
     * change. For example, an agent may update the location line number
     * to reflect the actual line where the breakpoint was set, but this
     * doesn't change the breakpoint semantics.
     * This means that an agent does not need to check if a breakpoint has changed
     * when it encounters the same breakpoint on a successive call.
     * Moreover, an agent should remember the breakpoints that are completed
     * until the controller removes them from the active list to avoid
     * setting those breakpoints again.
     * </pre>
     */
    public com.google.devtools.clouddebugger.v2.ListActiveBreakpointsResponse listActiveBreakpoints(
        com.google.devtools.clouddebugger.v2.ListActiveBreakpointsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListActiveBreakpointsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the breakpoint state or mutable fields.
     * The entire Breakpoint message must be sent back to the controller service.
     * Updates to active breakpoint fields are only allowed if the new value
     * does not change the breakpoint specification. Updates to the `location`,
     * `condition` and `expressions` fields should not alter the breakpoint
     * semantics. These may only make changes such as canonicalizing a value
     * or snapping the location to the correct line of code.
     * </pre>
     */
    public com.google.devtools.clouddebugger.v2.UpdateActiveBreakpointResponse
        updateActiveBreakpoint(
            com.google.devtools.clouddebugger.v2.UpdateActiveBreakpointRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateActiveBreakpointMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * The Controller service provides the API for orchestrating a collection of
   * debugger agents to perform debugging tasks. These agents are each attached
   * to a process of an application which may include one or more replicas.
   * The debugger agents register with the Controller to identify the application
   * being debugged, the Debuggee. All agents that register with the same data,
   * represent the same Debuggee, and are assigned the same `debuggee_id`.
   * The debugger agents call the Controller to retrieve  the list of active
   * Breakpoints. Agents with the same `debuggee_id` get the same breakpoints
   * list. An agent that can fulfill the breakpoint request updates the
   * Controller with the breakpoint result. The controller selects the first
   * result received and discards the rest of the results.
   * Agents that poll again for active breakpoints will no longer have
   * the completed breakpoint in the list and should remove that breakpoint from
   * their attached process.
   * The Controller service does not provide a way to retrieve the results of
   * a completed breakpoint. This functionality is available using the Debugger
   * service.
   * </pre>
   */
  public static final class Controller2FutureStub
      extends io.grpc.stub.AbstractFutureStub<Controller2FutureStub> {
    private Controller2FutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Controller2FutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new Controller2FutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Registers the debuggee with the controller service.
     * All agents attached to the same application must call this method with
     * exactly the same request content to get back the same stable `debuggee_id`.
     * Agents should call this method again whenever `google.rpc.Code.NOT_FOUND`
     * is returned from any controller method.
     * This protocol allows the controller service to disable debuggees, recover
     * from data loss, or change the `debuggee_id` format. Agents must handle
     * `debuggee_id` value changing upon re-registration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devtools.clouddebugger.v2.RegisterDebuggeeResponse>
        registerDebuggee(com.google.devtools.clouddebugger.v2.RegisterDebuggeeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRegisterDebuggeeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all active breakpoints for the debuggee.
     * The breakpoint specification (`location`, `condition`, and `expressions`
     * fields) is semantically immutable, although the field values may
     * change. For example, an agent may update the location line number
     * to reflect the actual line where the breakpoint was set, but this
     * doesn't change the breakpoint semantics.
     * This means that an agent does not need to check if a breakpoint has changed
     * when it encounters the same breakpoint on a successive call.
     * Moreover, an agent should remember the breakpoints that are completed
     * until the controller removes them from the active list to avoid
     * setting those breakpoints again.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devtools.clouddebugger.v2.ListActiveBreakpointsResponse>
        listActiveBreakpoints(
            com.google.devtools.clouddebugger.v2.ListActiveBreakpointsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListActiveBreakpointsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the breakpoint state or mutable fields.
     * The entire Breakpoint message must be sent back to the controller service.
     * Updates to active breakpoint fields are only allowed if the new value
     * does not change the breakpoint specification. Updates to the `location`,
     * `condition` and `expressions` fields should not alter the breakpoint
     * semantics. These may only make changes such as canonicalizing a value
     * or snapping the location to the correct line of code.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devtools.clouddebugger.v2.UpdateActiveBreakpointResponse>
        updateActiveBreakpoint(
            com.google.devtools.clouddebugger.v2.UpdateActiveBreakpointRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateActiveBreakpointMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REGISTER_DEBUGGEE = 0;
  private static final int METHODID_LIST_ACTIVE_BREAKPOINTS = 1;
  private static final int METHODID_UPDATE_ACTIVE_BREAKPOINT = 2;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final Controller2ImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(Controller2ImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REGISTER_DEBUGGEE:
          serviceImpl.registerDebuggee(
              (com.google.devtools.clouddebugger.v2.RegisterDebuggeeRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.devtools.clouddebugger.v2.RegisterDebuggeeResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_ACTIVE_BREAKPOINTS:
          serviceImpl.listActiveBreakpoints(
              (com.google.devtools.clouddebugger.v2.ListActiveBreakpointsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.devtools.clouddebugger.v2.ListActiveBreakpointsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_ACTIVE_BREAKPOINT:
          serviceImpl.updateActiveBreakpoint(
              (com.google.devtools.clouddebugger.v2.UpdateActiveBreakpointRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.devtools.clouddebugger.v2.UpdateActiveBreakpointResponse>)
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

  private abstract static class Controller2BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    Controller2BaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.devtools.clouddebugger.v2.ControllerProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Controller2");
    }
  }

  private static final class Controller2FileDescriptorSupplier
      extends Controller2BaseDescriptorSupplier {
    Controller2FileDescriptorSupplier() {}
  }

  private static final class Controller2MethodDescriptorSupplier
      extends Controller2BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    Controller2MethodDescriptorSupplier(String methodName) {
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
      synchronized (Controller2Grpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new Controller2FileDescriptorSupplier())
                      .addMethod(getRegisterDebuggeeMethod())
                      .addMethod(getListActiveBreakpointsMethod())
                      .addMethod(getUpdateActiveBreakpointMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
