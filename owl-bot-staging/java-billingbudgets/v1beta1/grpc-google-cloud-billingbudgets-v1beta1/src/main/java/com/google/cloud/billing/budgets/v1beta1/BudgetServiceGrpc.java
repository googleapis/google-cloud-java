package com.google.cloud.billing.budgets.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * BudgetService stores Cloud Billing budgets, which define a
 * budget plan and rules to execute as we track spend against that plan.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/billing/budgets/v1beta1/budget_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class BudgetServiceGrpc {

  private BudgetServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.billing.budgets.v1beta1.BudgetService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.billing.budgets.v1beta1.CreateBudgetRequest,
      com.google.cloud.billing.budgets.v1beta1.Budget> getCreateBudgetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateBudget",
      requestType = com.google.cloud.billing.budgets.v1beta1.CreateBudgetRequest.class,
      responseType = com.google.cloud.billing.budgets.v1beta1.Budget.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.billing.budgets.v1beta1.CreateBudgetRequest,
      com.google.cloud.billing.budgets.v1beta1.Budget> getCreateBudgetMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.billing.budgets.v1beta1.CreateBudgetRequest, com.google.cloud.billing.budgets.v1beta1.Budget> getCreateBudgetMethod;
    if ((getCreateBudgetMethod = BudgetServiceGrpc.getCreateBudgetMethod) == null) {
      synchronized (BudgetServiceGrpc.class) {
        if ((getCreateBudgetMethod = BudgetServiceGrpc.getCreateBudgetMethod) == null) {
          BudgetServiceGrpc.getCreateBudgetMethod = getCreateBudgetMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.billing.budgets.v1beta1.CreateBudgetRequest, com.google.cloud.billing.budgets.v1beta1.Budget>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateBudget"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.billing.budgets.v1beta1.CreateBudgetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.billing.budgets.v1beta1.Budget.getDefaultInstance()))
              .setSchemaDescriptor(new BudgetServiceMethodDescriptorSupplier("CreateBudget"))
              .build();
        }
      }
    }
    return getCreateBudgetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.billing.budgets.v1beta1.UpdateBudgetRequest,
      com.google.cloud.billing.budgets.v1beta1.Budget> getUpdateBudgetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateBudget",
      requestType = com.google.cloud.billing.budgets.v1beta1.UpdateBudgetRequest.class,
      responseType = com.google.cloud.billing.budgets.v1beta1.Budget.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.billing.budgets.v1beta1.UpdateBudgetRequest,
      com.google.cloud.billing.budgets.v1beta1.Budget> getUpdateBudgetMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.billing.budgets.v1beta1.UpdateBudgetRequest, com.google.cloud.billing.budgets.v1beta1.Budget> getUpdateBudgetMethod;
    if ((getUpdateBudgetMethod = BudgetServiceGrpc.getUpdateBudgetMethod) == null) {
      synchronized (BudgetServiceGrpc.class) {
        if ((getUpdateBudgetMethod = BudgetServiceGrpc.getUpdateBudgetMethod) == null) {
          BudgetServiceGrpc.getUpdateBudgetMethod = getUpdateBudgetMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.billing.budgets.v1beta1.UpdateBudgetRequest, com.google.cloud.billing.budgets.v1beta1.Budget>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateBudget"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.billing.budgets.v1beta1.UpdateBudgetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.billing.budgets.v1beta1.Budget.getDefaultInstance()))
              .setSchemaDescriptor(new BudgetServiceMethodDescriptorSupplier("UpdateBudget"))
              .build();
        }
      }
    }
    return getUpdateBudgetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.billing.budgets.v1beta1.GetBudgetRequest,
      com.google.cloud.billing.budgets.v1beta1.Budget> getGetBudgetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBudget",
      requestType = com.google.cloud.billing.budgets.v1beta1.GetBudgetRequest.class,
      responseType = com.google.cloud.billing.budgets.v1beta1.Budget.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.billing.budgets.v1beta1.GetBudgetRequest,
      com.google.cloud.billing.budgets.v1beta1.Budget> getGetBudgetMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.billing.budgets.v1beta1.GetBudgetRequest, com.google.cloud.billing.budgets.v1beta1.Budget> getGetBudgetMethod;
    if ((getGetBudgetMethod = BudgetServiceGrpc.getGetBudgetMethod) == null) {
      synchronized (BudgetServiceGrpc.class) {
        if ((getGetBudgetMethod = BudgetServiceGrpc.getGetBudgetMethod) == null) {
          BudgetServiceGrpc.getGetBudgetMethod = getGetBudgetMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.billing.budgets.v1beta1.GetBudgetRequest, com.google.cloud.billing.budgets.v1beta1.Budget>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBudget"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.billing.budgets.v1beta1.GetBudgetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.billing.budgets.v1beta1.Budget.getDefaultInstance()))
              .setSchemaDescriptor(new BudgetServiceMethodDescriptorSupplier("GetBudget"))
              .build();
        }
      }
    }
    return getGetBudgetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.billing.budgets.v1beta1.ListBudgetsRequest,
      com.google.cloud.billing.budgets.v1beta1.ListBudgetsResponse> getListBudgetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBudgets",
      requestType = com.google.cloud.billing.budgets.v1beta1.ListBudgetsRequest.class,
      responseType = com.google.cloud.billing.budgets.v1beta1.ListBudgetsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.billing.budgets.v1beta1.ListBudgetsRequest,
      com.google.cloud.billing.budgets.v1beta1.ListBudgetsResponse> getListBudgetsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.billing.budgets.v1beta1.ListBudgetsRequest, com.google.cloud.billing.budgets.v1beta1.ListBudgetsResponse> getListBudgetsMethod;
    if ((getListBudgetsMethod = BudgetServiceGrpc.getListBudgetsMethod) == null) {
      synchronized (BudgetServiceGrpc.class) {
        if ((getListBudgetsMethod = BudgetServiceGrpc.getListBudgetsMethod) == null) {
          BudgetServiceGrpc.getListBudgetsMethod = getListBudgetsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.billing.budgets.v1beta1.ListBudgetsRequest, com.google.cloud.billing.budgets.v1beta1.ListBudgetsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListBudgets"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.billing.budgets.v1beta1.ListBudgetsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.billing.budgets.v1beta1.ListBudgetsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new BudgetServiceMethodDescriptorSupplier("ListBudgets"))
              .build();
        }
      }
    }
    return getListBudgetsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.billing.budgets.v1beta1.DeleteBudgetRequest,
      com.google.protobuf.Empty> getDeleteBudgetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteBudget",
      requestType = com.google.cloud.billing.budgets.v1beta1.DeleteBudgetRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.billing.budgets.v1beta1.DeleteBudgetRequest,
      com.google.protobuf.Empty> getDeleteBudgetMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.billing.budgets.v1beta1.DeleteBudgetRequest, com.google.protobuf.Empty> getDeleteBudgetMethod;
    if ((getDeleteBudgetMethod = BudgetServiceGrpc.getDeleteBudgetMethod) == null) {
      synchronized (BudgetServiceGrpc.class) {
        if ((getDeleteBudgetMethod = BudgetServiceGrpc.getDeleteBudgetMethod) == null) {
          BudgetServiceGrpc.getDeleteBudgetMethod = getDeleteBudgetMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.billing.budgets.v1beta1.DeleteBudgetRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteBudget"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.billing.budgets.v1beta1.DeleteBudgetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new BudgetServiceMethodDescriptorSupplier("DeleteBudget"))
              .build();
        }
      }
    }
    return getDeleteBudgetMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BudgetServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BudgetServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BudgetServiceStub>() {
        @java.lang.Override
        public BudgetServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BudgetServiceStub(channel, callOptions);
        }
      };
    return BudgetServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BudgetServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BudgetServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BudgetServiceBlockingStub>() {
        @java.lang.Override
        public BudgetServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BudgetServiceBlockingStub(channel, callOptions);
        }
      };
    return BudgetServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BudgetServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BudgetServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BudgetServiceFutureStub>() {
        @java.lang.Override
        public BudgetServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BudgetServiceFutureStub(channel, callOptions);
        }
      };
    return BudgetServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * BudgetService stores Cloud Billing budgets, which define a
   * budget plan and rules to execute as we track spend against that plan.
   * </pre>
   */
  public static abstract class BudgetServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Creates a new budget. See
     * [Quotas and limits](https://cloud.google.com/billing/quotas)
     * for more information on the limits of the number of budgets you can create.
     * </pre>
     */
    public void createBudget(com.google.cloud.billing.budgets.v1beta1.CreateBudgetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.billing.budgets.v1beta1.Budget> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateBudgetMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates a budget and returns the updated budget.
     * WARNING: There are some fields exposed on the Google Cloud Console that
     * aren't available on this API. Budget fields that are not exposed in
     * this API will not be changed by this method.
     * </pre>
     */
    public void updateBudget(com.google.cloud.billing.budgets.v1beta1.UpdateBudgetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.billing.budgets.v1beta1.Budget> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateBudgetMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns a budget.
     * WARNING: There are some fields exposed on the Google Cloud Console that
     * aren't available on this API. When reading from the API, you will not
     * see these fields in the return value, though they may have been set
     * in the Cloud Console.
     * </pre>
     */
    public void getBudget(com.google.cloud.billing.budgets.v1beta1.GetBudgetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.billing.budgets.v1beta1.Budget> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetBudgetMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns a list of budgets for a billing account.
     * WARNING: There are some fields exposed on the Google Cloud Console that
     * aren't available on this API. When reading from the API, you will not
     * see these fields in the return value, though they may have been set
     * in the Cloud Console.
     * </pre>
     */
    public void listBudgets(com.google.cloud.billing.budgets.v1beta1.ListBudgetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.billing.budgets.v1beta1.ListBudgetsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListBudgetsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a budget. Returns successfully if already deleted.
     * </pre>
     */
    public void deleteBudget(com.google.cloud.billing.budgets.v1beta1.DeleteBudgetRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteBudgetMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateBudgetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.billing.budgets.v1beta1.CreateBudgetRequest,
                com.google.cloud.billing.budgets.v1beta1.Budget>(
                  this, METHODID_CREATE_BUDGET)))
          .addMethod(
            getUpdateBudgetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.billing.budgets.v1beta1.UpdateBudgetRequest,
                com.google.cloud.billing.budgets.v1beta1.Budget>(
                  this, METHODID_UPDATE_BUDGET)))
          .addMethod(
            getGetBudgetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.billing.budgets.v1beta1.GetBudgetRequest,
                com.google.cloud.billing.budgets.v1beta1.Budget>(
                  this, METHODID_GET_BUDGET)))
          .addMethod(
            getListBudgetsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.billing.budgets.v1beta1.ListBudgetsRequest,
                com.google.cloud.billing.budgets.v1beta1.ListBudgetsResponse>(
                  this, METHODID_LIST_BUDGETS)))
          .addMethod(
            getDeleteBudgetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.billing.budgets.v1beta1.DeleteBudgetRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_BUDGET)))
          .build();
    }
  }

  /**
   * <pre>
   * BudgetService stores Cloud Billing budgets, which define a
   * budget plan and rules to execute as we track spend against that plan.
   * </pre>
   */
  public static final class BudgetServiceStub extends io.grpc.stub.AbstractAsyncStub<BudgetServiceStub> {
    private BudgetServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BudgetServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BudgetServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a new budget. See
     * [Quotas and limits](https://cloud.google.com/billing/quotas)
     * for more information on the limits of the number of budgets you can create.
     * </pre>
     */
    public void createBudget(com.google.cloud.billing.budgets.v1beta1.CreateBudgetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.billing.budgets.v1beta1.Budget> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateBudgetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates a budget and returns the updated budget.
     * WARNING: There are some fields exposed on the Google Cloud Console that
     * aren't available on this API. Budget fields that are not exposed in
     * this API will not be changed by this method.
     * </pre>
     */
    public void updateBudget(com.google.cloud.billing.budgets.v1beta1.UpdateBudgetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.billing.budgets.v1beta1.Budget> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateBudgetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns a budget.
     * WARNING: There are some fields exposed on the Google Cloud Console that
     * aren't available on this API. When reading from the API, you will not
     * see these fields in the return value, though they may have been set
     * in the Cloud Console.
     * </pre>
     */
    public void getBudget(com.google.cloud.billing.budgets.v1beta1.GetBudgetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.billing.budgets.v1beta1.Budget> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBudgetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns a list of budgets for a billing account.
     * WARNING: There are some fields exposed on the Google Cloud Console that
     * aren't available on this API. When reading from the API, you will not
     * see these fields in the return value, though they may have been set
     * in the Cloud Console.
     * </pre>
     */
    public void listBudgets(com.google.cloud.billing.budgets.v1beta1.ListBudgetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.billing.budgets.v1beta1.ListBudgetsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListBudgetsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a budget. Returns successfully if already deleted.
     * </pre>
     */
    public void deleteBudget(com.google.cloud.billing.budgets.v1beta1.DeleteBudgetRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteBudgetMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * BudgetService stores Cloud Billing budgets, which define a
   * budget plan and rules to execute as we track spend against that plan.
   * </pre>
   */
  public static final class BudgetServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<BudgetServiceBlockingStub> {
    private BudgetServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BudgetServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BudgetServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a new budget. See
     * [Quotas and limits](https://cloud.google.com/billing/quotas)
     * for more information on the limits of the number of budgets you can create.
     * </pre>
     */
    public com.google.cloud.billing.budgets.v1beta1.Budget createBudget(com.google.cloud.billing.budgets.v1beta1.CreateBudgetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateBudgetMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates a budget and returns the updated budget.
     * WARNING: There are some fields exposed on the Google Cloud Console that
     * aren't available on this API. Budget fields that are not exposed in
     * this API will not be changed by this method.
     * </pre>
     */
    public com.google.cloud.billing.budgets.v1beta1.Budget updateBudget(com.google.cloud.billing.budgets.v1beta1.UpdateBudgetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateBudgetMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns a budget.
     * WARNING: There are some fields exposed on the Google Cloud Console that
     * aren't available on this API. When reading from the API, you will not
     * see these fields in the return value, though they may have been set
     * in the Cloud Console.
     * </pre>
     */
    public com.google.cloud.billing.budgets.v1beta1.Budget getBudget(com.google.cloud.billing.budgets.v1beta1.GetBudgetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBudgetMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns a list of budgets for a billing account.
     * WARNING: There are some fields exposed on the Google Cloud Console that
     * aren't available on this API. When reading from the API, you will not
     * see these fields in the return value, though they may have been set
     * in the Cloud Console.
     * </pre>
     */
    public com.google.cloud.billing.budgets.v1beta1.ListBudgetsResponse listBudgets(com.google.cloud.billing.budgets.v1beta1.ListBudgetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBudgetsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a budget. Returns successfully if already deleted.
     * </pre>
     */
    public com.google.protobuf.Empty deleteBudget(com.google.cloud.billing.budgets.v1beta1.DeleteBudgetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteBudgetMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * BudgetService stores Cloud Billing budgets, which define a
   * budget plan and rules to execute as we track spend against that plan.
   * </pre>
   */
  public static final class BudgetServiceFutureStub extends io.grpc.stub.AbstractFutureStub<BudgetServiceFutureStub> {
    private BudgetServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BudgetServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BudgetServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a new budget. See
     * [Quotas and limits](https://cloud.google.com/billing/quotas)
     * for more information on the limits of the number of budgets you can create.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.billing.budgets.v1beta1.Budget> createBudget(
        com.google.cloud.billing.budgets.v1beta1.CreateBudgetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateBudgetMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates a budget and returns the updated budget.
     * WARNING: There are some fields exposed on the Google Cloud Console that
     * aren't available on this API. Budget fields that are not exposed in
     * this API will not be changed by this method.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.billing.budgets.v1beta1.Budget> updateBudget(
        com.google.cloud.billing.budgets.v1beta1.UpdateBudgetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateBudgetMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns a budget.
     * WARNING: There are some fields exposed on the Google Cloud Console that
     * aren't available on this API. When reading from the API, you will not
     * see these fields in the return value, though they may have been set
     * in the Cloud Console.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.billing.budgets.v1beta1.Budget> getBudget(
        com.google.cloud.billing.budgets.v1beta1.GetBudgetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBudgetMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns a list of budgets for a billing account.
     * WARNING: There are some fields exposed on the Google Cloud Console that
     * aren't available on this API. When reading from the API, you will not
     * see these fields in the return value, though they may have been set
     * in the Cloud Console.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.billing.budgets.v1beta1.ListBudgetsResponse> listBudgets(
        com.google.cloud.billing.budgets.v1beta1.ListBudgetsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListBudgetsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a budget. Returns successfully if already deleted.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteBudget(
        com.google.cloud.billing.budgets.v1beta1.DeleteBudgetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteBudgetMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_BUDGET = 0;
  private static final int METHODID_UPDATE_BUDGET = 1;
  private static final int METHODID_GET_BUDGET = 2;
  private static final int METHODID_LIST_BUDGETS = 3;
  private static final int METHODID_DELETE_BUDGET = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BudgetServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BudgetServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_BUDGET:
          serviceImpl.createBudget((com.google.cloud.billing.budgets.v1beta1.CreateBudgetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.billing.budgets.v1beta1.Budget>) responseObserver);
          break;
        case METHODID_UPDATE_BUDGET:
          serviceImpl.updateBudget((com.google.cloud.billing.budgets.v1beta1.UpdateBudgetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.billing.budgets.v1beta1.Budget>) responseObserver);
          break;
        case METHODID_GET_BUDGET:
          serviceImpl.getBudget((com.google.cloud.billing.budgets.v1beta1.GetBudgetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.billing.budgets.v1beta1.Budget>) responseObserver);
          break;
        case METHODID_LIST_BUDGETS:
          serviceImpl.listBudgets((com.google.cloud.billing.budgets.v1beta1.ListBudgetsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.billing.budgets.v1beta1.ListBudgetsResponse>) responseObserver);
          break;
        case METHODID_DELETE_BUDGET:
          serviceImpl.deleteBudget((com.google.cloud.billing.budgets.v1beta1.DeleteBudgetRequest) request,
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

  private static abstract class BudgetServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BudgetServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.billing.budgets.v1beta1.BudgetServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BudgetService");
    }
  }

  private static final class BudgetServiceFileDescriptorSupplier
      extends BudgetServiceBaseDescriptorSupplier {
    BudgetServiceFileDescriptorSupplier() {}
  }

  private static final class BudgetServiceMethodDescriptorSupplier
      extends BudgetServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BudgetServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (BudgetServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BudgetServiceFileDescriptorSupplier())
              .addMethod(getCreateBudgetMethod())
              .addMethod(getUpdateBudgetMethod())
              .addMethod(getGetBudgetMethod())
              .addMethod(getListBudgetsMethod())
              .addMethod(getDeleteBudgetMethod())
              .build();
        }
      }
    }
    return result;
  }
}
