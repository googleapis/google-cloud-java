package com.google.cloud.dialogflow.v2beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 *
 *
 * <pre>
 * A context represents additional information included with user input or with
 * an intent returned by the Dialogflow API. Contexts are helpful for
 * differentiating user input which may be vague or have a different meaning
 * depending on additional details from your application such as user setting
 * and preferences, previous user input, where the user is in your application,
 * geographic location, and so on.
 * You can include contexts as input parameters of a
 * [DetectIntent][google.cloud.dialogflow.v2beta1.Sessions.DetectIntent] (or
 * [StreamingDetectIntent][google.cloud.dialogflow.v2beta1.Sessions.StreamingDetectIntent]) request,
 * or as output contexts included in the returned intent.
 * Contexts expire when an intent is matched, after the number of `DetectIntent`
 * requests specified by the `lifespan_count` parameter, or after 20 minutes
 * if no intents are matched for a `DetectIntent` request.
 * For more information about contexts, see the
 * [Dialogflow
 * documentation](https://cloud.google.com/dialogflow/docs/contexts-overview).
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/cloud/dialogflow/v2beta1/context.proto")
public final class ContextsGrpc {

  private ContextsGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.dialogflow.v2beta1.Contexts";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListContextsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.ListContextsRequest,
          com.google.cloud.dialogflow.v2beta1.ListContextsResponse>
      METHOD_LIST_CONTEXTS = getListContextsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.ListContextsRequest,
          com.google.cloud.dialogflow.v2beta1.ListContextsResponse>
      getListContextsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.ListContextsRequest,
          com.google.cloud.dialogflow.v2beta1.ListContextsResponse>
      getListContextsMethod() {
    return getListContextsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.ListContextsRequest,
          com.google.cloud.dialogflow.v2beta1.ListContextsResponse>
      getListContextsMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.ListContextsRequest,
            com.google.cloud.dialogflow.v2beta1.ListContextsResponse>
        getListContextsMethod;
    if ((getListContextsMethod = ContextsGrpc.getListContextsMethod) == null) {
      synchronized (ContextsGrpc.class) {
        if ((getListContextsMethod = ContextsGrpc.getListContextsMethod) == null) {
          ContextsGrpc.getListContextsMethod =
              getListContextsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.ListContextsRequest,
                          com.google.cloud.dialogflow.v2beta1.ListContextsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.dialogflow.v2beta1.Contexts", "ListContexts"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.ListContextsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.ListContextsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new ContextsMethodDescriptorSupplier("ListContexts"))
                      .build();
        }
      }
    }
    return getListContextsMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetContextMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.GetContextRequest,
          com.google.cloud.dialogflow.v2beta1.Context>
      METHOD_GET_CONTEXT = getGetContextMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.GetContextRequest,
          com.google.cloud.dialogflow.v2beta1.Context>
      getGetContextMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.GetContextRequest,
          com.google.cloud.dialogflow.v2beta1.Context>
      getGetContextMethod() {
    return getGetContextMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.GetContextRequest,
          com.google.cloud.dialogflow.v2beta1.Context>
      getGetContextMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.GetContextRequest,
            com.google.cloud.dialogflow.v2beta1.Context>
        getGetContextMethod;
    if ((getGetContextMethod = ContextsGrpc.getGetContextMethod) == null) {
      synchronized (ContextsGrpc.class) {
        if ((getGetContextMethod = ContextsGrpc.getGetContextMethod) == null) {
          ContextsGrpc.getGetContextMethod =
              getGetContextMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.GetContextRequest,
                          com.google.cloud.dialogflow.v2beta1.Context>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.dialogflow.v2beta1.Contexts", "GetContext"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.GetContextRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.Context.getDefaultInstance()))
                      .setSchemaDescriptor(new ContextsMethodDescriptorSupplier("GetContext"))
                      .build();
        }
      }
    }
    return getGetContextMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateContextMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.CreateContextRequest,
          com.google.cloud.dialogflow.v2beta1.Context>
      METHOD_CREATE_CONTEXT = getCreateContextMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.CreateContextRequest,
          com.google.cloud.dialogflow.v2beta1.Context>
      getCreateContextMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.CreateContextRequest,
          com.google.cloud.dialogflow.v2beta1.Context>
      getCreateContextMethod() {
    return getCreateContextMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.CreateContextRequest,
          com.google.cloud.dialogflow.v2beta1.Context>
      getCreateContextMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.CreateContextRequest,
            com.google.cloud.dialogflow.v2beta1.Context>
        getCreateContextMethod;
    if ((getCreateContextMethod = ContextsGrpc.getCreateContextMethod) == null) {
      synchronized (ContextsGrpc.class) {
        if ((getCreateContextMethod = ContextsGrpc.getCreateContextMethod) == null) {
          ContextsGrpc.getCreateContextMethod =
              getCreateContextMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.CreateContextRequest,
                          com.google.cloud.dialogflow.v2beta1.Context>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.dialogflow.v2beta1.Contexts", "CreateContext"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.CreateContextRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.Context.getDefaultInstance()))
                      .setSchemaDescriptor(new ContextsMethodDescriptorSupplier("CreateContext"))
                      .build();
        }
      }
    }
    return getCreateContextMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateContextMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.UpdateContextRequest,
          com.google.cloud.dialogflow.v2beta1.Context>
      METHOD_UPDATE_CONTEXT = getUpdateContextMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.UpdateContextRequest,
          com.google.cloud.dialogflow.v2beta1.Context>
      getUpdateContextMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.UpdateContextRequest,
          com.google.cloud.dialogflow.v2beta1.Context>
      getUpdateContextMethod() {
    return getUpdateContextMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.UpdateContextRequest,
          com.google.cloud.dialogflow.v2beta1.Context>
      getUpdateContextMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.UpdateContextRequest,
            com.google.cloud.dialogflow.v2beta1.Context>
        getUpdateContextMethod;
    if ((getUpdateContextMethod = ContextsGrpc.getUpdateContextMethod) == null) {
      synchronized (ContextsGrpc.class) {
        if ((getUpdateContextMethod = ContextsGrpc.getUpdateContextMethod) == null) {
          ContextsGrpc.getUpdateContextMethod =
              getUpdateContextMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.UpdateContextRequest,
                          com.google.cloud.dialogflow.v2beta1.Context>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.dialogflow.v2beta1.Contexts", "UpdateContext"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.UpdateContextRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.Context.getDefaultInstance()))
                      .setSchemaDescriptor(new ContextsMethodDescriptorSupplier("UpdateContext"))
                      .build();
        }
      }
    }
    return getUpdateContextMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteContextMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.DeleteContextRequest, com.google.protobuf.Empty>
      METHOD_DELETE_CONTEXT = getDeleteContextMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.DeleteContextRequest, com.google.protobuf.Empty>
      getDeleteContextMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.DeleteContextRequest, com.google.protobuf.Empty>
      getDeleteContextMethod() {
    return getDeleteContextMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.DeleteContextRequest, com.google.protobuf.Empty>
      getDeleteContextMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.DeleteContextRequest, com.google.protobuf.Empty>
        getDeleteContextMethod;
    if ((getDeleteContextMethod = ContextsGrpc.getDeleteContextMethod) == null) {
      synchronized (ContextsGrpc.class) {
        if ((getDeleteContextMethod = ContextsGrpc.getDeleteContextMethod) == null) {
          ContextsGrpc.getDeleteContextMethod =
              getDeleteContextMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.DeleteContextRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.dialogflow.v2beta1.Contexts", "DeleteContext"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.DeleteContextRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new ContextsMethodDescriptorSupplier("DeleteContext"))
                      .build();
        }
      }
    }
    return getDeleteContextMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteAllContextsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.DeleteAllContextsRequest, com.google.protobuf.Empty>
      METHOD_DELETE_ALL_CONTEXTS = getDeleteAllContextsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.DeleteAllContextsRequest, com.google.protobuf.Empty>
      getDeleteAllContextsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.DeleteAllContextsRequest, com.google.protobuf.Empty>
      getDeleteAllContextsMethod() {
    return getDeleteAllContextsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.DeleteAllContextsRequest, com.google.protobuf.Empty>
      getDeleteAllContextsMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.DeleteAllContextsRequest, com.google.protobuf.Empty>
        getDeleteAllContextsMethod;
    if ((getDeleteAllContextsMethod = ContextsGrpc.getDeleteAllContextsMethod) == null) {
      synchronized (ContextsGrpc.class) {
        if ((getDeleteAllContextsMethod = ContextsGrpc.getDeleteAllContextsMethod) == null) {
          ContextsGrpc.getDeleteAllContextsMethod =
              getDeleteAllContextsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.DeleteAllContextsRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.dialogflow.v2beta1.Contexts", "DeleteAllContexts"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.DeleteAllContextsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContextsMethodDescriptorSupplier("DeleteAllContexts"))
                      .build();
        }
      }
    }
    return getDeleteAllContextsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ContextsStub newStub(io.grpc.Channel channel) {
    return new ContextsStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ContextsBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new ContextsBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ContextsFutureStub newFutureStub(io.grpc.Channel channel) {
    return new ContextsFutureStub(channel);
  }

  /**
   *
   *
   * <pre>
   * A context represents additional information included with user input or with
   * an intent returned by the Dialogflow API. Contexts are helpful for
   * differentiating user input which may be vague or have a different meaning
   * depending on additional details from your application such as user setting
   * and preferences, previous user input, where the user is in your application,
   * geographic location, and so on.
   * You can include contexts as input parameters of a
   * [DetectIntent][google.cloud.dialogflow.v2beta1.Sessions.DetectIntent] (or
   * [StreamingDetectIntent][google.cloud.dialogflow.v2beta1.Sessions.StreamingDetectIntent]) request,
   * or as output contexts included in the returned intent.
   * Contexts expire when an intent is matched, after the number of `DetectIntent`
   * requests specified by the `lifespan_count` parameter, or after 20 minutes
   * if no intents are matched for a `DetectIntent` request.
   * For more information about contexts, see the
   * [Dialogflow
   * documentation](https://cloud.google.com/dialogflow/docs/contexts-overview).
   * </pre>
   */
  public abstract static class ContextsImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Returns the list of all contexts in the specified session.
     * </pre>
     */
    public void listContexts(
        com.google.cloud.dialogflow.v2beta1.ListContextsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.ListContextsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListContextsMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified context.
     * </pre>
     */
    public void getContext(
        com.google.cloud.dialogflow.v2beta1.GetContextRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.Context> responseObserver) {
      asyncUnimplementedUnaryCall(getGetContextMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a context.
     * If the specified context already exists, overrides the context.
     * </pre>
     */
    public void createContext(
        com.google.cloud.dialogflow.v2beta1.CreateContextRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.Context> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateContextMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified context.
     * </pre>
     */
    public void updateContext(
        com.google.cloud.dialogflow.v2beta1.UpdateContextRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.Context> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateContextMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified context.
     * </pre>
     */
    public void deleteContext(
        com.google.cloud.dialogflow.v2beta1.DeleteContextRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteContextMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes all active contexts in the specified session.
     * </pre>
     */
    public void deleteAllContexts(
        com.google.cloud.dialogflow.v2beta1.DeleteAllContextsRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteAllContextsMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListContextsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2beta1.ListContextsRequest,
                      com.google.cloud.dialogflow.v2beta1.ListContextsResponse>(
                      this, METHODID_LIST_CONTEXTS)))
          .addMethod(
              getGetContextMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2beta1.GetContextRequest,
                      com.google.cloud.dialogflow.v2beta1.Context>(this, METHODID_GET_CONTEXT)))
          .addMethod(
              getCreateContextMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2beta1.CreateContextRequest,
                      com.google.cloud.dialogflow.v2beta1.Context>(this, METHODID_CREATE_CONTEXT)))
          .addMethod(
              getUpdateContextMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2beta1.UpdateContextRequest,
                      com.google.cloud.dialogflow.v2beta1.Context>(this, METHODID_UPDATE_CONTEXT)))
          .addMethod(
              getDeleteContextMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2beta1.DeleteContextRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_CONTEXT)))
          .addMethod(
              getDeleteAllContextsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2beta1.DeleteAllContextsRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_ALL_CONTEXTS)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * A context represents additional information included with user input or with
   * an intent returned by the Dialogflow API. Contexts are helpful for
   * differentiating user input which may be vague or have a different meaning
   * depending on additional details from your application such as user setting
   * and preferences, previous user input, where the user is in your application,
   * geographic location, and so on.
   * You can include contexts as input parameters of a
   * [DetectIntent][google.cloud.dialogflow.v2beta1.Sessions.DetectIntent] (or
   * [StreamingDetectIntent][google.cloud.dialogflow.v2beta1.Sessions.StreamingDetectIntent]) request,
   * or as output contexts included in the returned intent.
   * Contexts expire when an intent is matched, after the number of `DetectIntent`
   * requests specified by the `lifespan_count` parameter, or after 20 minutes
   * if no intents are matched for a `DetectIntent` request.
   * For more information about contexts, see the
   * [Dialogflow
   * documentation](https://cloud.google.com/dialogflow/docs/contexts-overview).
   * </pre>
   */
  public static final class ContextsStub extends io.grpc.stub.AbstractStub<ContextsStub> {
    private ContextsStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ContextsStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ContextsStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ContextsStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all contexts in the specified session.
     * </pre>
     */
    public void listContexts(
        com.google.cloud.dialogflow.v2beta1.ListContextsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.ListContextsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListContextsMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified context.
     * </pre>
     */
    public void getContext(
        com.google.cloud.dialogflow.v2beta1.GetContextRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.Context> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetContextMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a context.
     * If the specified context already exists, overrides the context.
     * </pre>
     */
    public void createContext(
        com.google.cloud.dialogflow.v2beta1.CreateContextRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.Context> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateContextMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified context.
     * </pre>
     */
    public void updateContext(
        com.google.cloud.dialogflow.v2beta1.UpdateContextRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.Context> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateContextMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified context.
     * </pre>
     */
    public void deleteContext(
        com.google.cloud.dialogflow.v2beta1.DeleteContextRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteContextMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes all active contexts in the specified session.
     * </pre>
     */
    public void deleteAllContexts(
        com.google.cloud.dialogflow.v2beta1.DeleteAllContextsRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteAllContextsMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * A context represents additional information included with user input or with
   * an intent returned by the Dialogflow API. Contexts are helpful for
   * differentiating user input which may be vague or have a different meaning
   * depending on additional details from your application such as user setting
   * and preferences, previous user input, where the user is in your application,
   * geographic location, and so on.
   * You can include contexts as input parameters of a
   * [DetectIntent][google.cloud.dialogflow.v2beta1.Sessions.DetectIntent] (or
   * [StreamingDetectIntent][google.cloud.dialogflow.v2beta1.Sessions.StreamingDetectIntent]) request,
   * or as output contexts included in the returned intent.
   * Contexts expire when an intent is matched, after the number of `DetectIntent`
   * requests specified by the `lifespan_count` parameter, or after 20 minutes
   * if no intents are matched for a `DetectIntent` request.
   * For more information about contexts, see the
   * [Dialogflow
   * documentation](https://cloud.google.com/dialogflow/docs/contexts-overview).
   * </pre>
   */
  public static final class ContextsBlockingStub
      extends io.grpc.stub.AbstractStub<ContextsBlockingStub> {
    private ContextsBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ContextsBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ContextsBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ContextsBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all contexts in the specified session.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2beta1.ListContextsResponse listContexts(
        com.google.cloud.dialogflow.v2beta1.ListContextsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListContextsMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified context.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2beta1.Context getContext(
        com.google.cloud.dialogflow.v2beta1.GetContextRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetContextMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a context.
     * If the specified context already exists, overrides the context.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2beta1.Context createContext(
        com.google.cloud.dialogflow.v2beta1.CreateContextRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateContextMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified context.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2beta1.Context updateContext(
        com.google.cloud.dialogflow.v2beta1.UpdateContextRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateContextMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified context.
     * </pre>
     */
    public com.google.protobuf.Empty deleteContext(
        com.google.cloud.dialogflow.v2beta1.DeleteContextRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteContextMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes all active contexts in the specified session.
     * </pre>
     */
    public com.google.protobuf.Empty deleteAllContexts(
        com.google.cloud.dialogflow.v2beta1.DeleteAllContextsRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteAllContextsMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * A context represents additional information included with user input or with
   * an intent returned by the Dialogflow API. Contexts are helpful for
   * differentiating user input which may be vague or have a different meaning
   * depending on additional details from your application such as user setting
   * and preferences, previous user input, where the user is in your application,
   * geographic location, and so on.
   * You can include contexts as input parameters of a
   * [DetectIntent][google.cloud.dialogflow.v2beta1.Sessions.DetectIntent] (or
   * [StreamingDetectIntent][google.cloud.dialogflow.v2beta1.Sessions.StreamingDetectIntent]) request,
   * or as output contexts included in the returned intent.
   * Contexts expire when an intent is matched, after the number of `DetectIntent`
   * requests specified by the `lifespan_count` parameter, or after 20 minutes
   * if no intents are matched for a `DetectIntent` request.
   * For more information about contexts, see the
   * [Dialogflow
   * documentation](https://cloud.google.com/dialogflow/docs/contexts-overview).
   * </pre>
   */
  public static final class ContextsFutureStub
      extends io.grpc.stub.AbstractStub<ContextsFutureStub> {
    private ContextsFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ContextsFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ContextsFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ContextsFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all contexts in the specified session.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2beta1.ListContextsResponse>
        listContexts(com.google.cloud.dialogflow.v2beta1.ListContextsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListContextsMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified context.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2beta1.Context>
        getContext(com.google.cloud.dialogflow.v2beta1.GetContextRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetContextMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a context.
     * If the specified context already exists, overrides the context.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2beta1.Context>
        createContext(com.google.cloud.dialogflow.v2beta1.CreateContextRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateContextMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified context.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2beta1.Context>
        updateContext(com.google.cloud.dialogflow.v2beta1.UpdateContextRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateContextMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified context.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteContext(com.google.cloud.dialogflow.v2beta1.DeleteContextRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteContextMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes all active contexts in the specified session.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteAllContexts(com.google.cloud.dialogflow.v2beta1.DeleteAllContextsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteAllContextsMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_CONTEXTS = 0;
  private static final int METHODID_GET_CONTEXT = 1;
  private static final int METHODID_CREATE_CONTEXT = 2;
  private static final int METHODID_UPDATE_CONTEXT = 3;
  private static final int METHODID_DELETE_CONTEXT = 4;
  private static final int METHODID_DELETE_ALL_CONTEXTS = 5;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ContextsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ContextsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_CONTEXTS:
          serviceImpl.listContexts(
              (com.google.cloud.dialogflow.v2beta1.ListContextsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.dialogflow.v2beta1.ListContextsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_CONTEXT:
          serviceImpl.getContext(
              (com.google.cloud.dialogflow.v2beta1.GetContextRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.Context>)
                  responseObserver);
          break;
        case METHODID_CREATE_CONTEXT:
          serviceImpl.createContext(
              (com.google.cloud.dialogflow.v2beta1.CreateContextRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.Context>)
                  responseObserver);
          break;
        case METHODID_UPDATE_CONTEXT:
          serviceImpl.updateContext(
              (com.google.cloud.dialogflow.v2beta1.UpdateContextRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.Context>)
                  responseObserver);
          break;
        case METHODID_DELETE_CONTEXT:
          serviceImpl.deleteContext(
              (com.google.cloud.dialogflow.v2beta1.DeleteContextRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_DELETE_ALL_CONTEXTS:
          serviceImpl.deleteAllContexts(
              (com.google.cloud.dialogflow.v2beta1.DeleteAllContextsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
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

  private abstract static class ContextsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ContextsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dialogflow.v2beta1.ContextProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Contexts");
    }
  }

  private static final class ContextsFileDescriptorSupplier extends ContextsBaseDescriptorSupplier {
    ContextsFileDescriptorSupplier() {}
  }

  private static final class ContextsMethodDescriptorSupplier extends ContextsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ContextsMethodDescriptorSupplier(String methodName) {
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
      synchronized (ContextsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ContextsFileDescriptorSupplier())
                      .addMethod(getListContextsMethodHelper())
                      .addMethod(getGetContextMethodHelper())
                      .addMethod(getCreateContextMethodHelper())
                      .addMethod(getUpdateContextMethodHelper())
                      .addMethod(getDeleteContextMethodHelper())
                      .addMethod(getDeleteAllContextsMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
