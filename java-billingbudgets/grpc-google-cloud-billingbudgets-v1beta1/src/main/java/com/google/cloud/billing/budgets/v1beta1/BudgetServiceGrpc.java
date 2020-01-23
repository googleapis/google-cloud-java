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
package com.google.cloud.billing.budgets.v1beta1;

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
 * BudgetService stores Cloud Billing budgets, which define a
 * budget plan and rules to execute as we track spend against that plan.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/cloud/billing/budgets/v1beta1/budget_service.proto")
public final class BudgetServiceGrpc {

  private BudgetServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.billing.budgets.v1beta1.BudgetService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateBudgetMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.billing.budgets.v1beta1.CreateBudgetRequest,
          com.google.cloud.billing.budgets.v1beta1.Budget>
      METHOD_CREATE_BUDGET = getCreateBudgetMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.billing.budgets.v1beta1.CreateBudgetRequest,
          com.google.cloud.billing.budgets.v1beta1.Budget>
      getCreateBudgetMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.billing.budgets.v1beta1.CreateBudgetRequest,
          com.google.cloud.billing.budgets.v1beta1.Budget>
      getCreateBudgetMethod() {
    return getCreateBudgetMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.billing.budgets.v1beta1.CreateBudgetRequest,
          com.google.cloud.billing.budgets.v1beta1.Budget>
      getCreateBudgetMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.billing.budgets.v1beta1.CreateBudgetRequest,
            com.google.cloud.billing.budgets.v1beta1.Budget>
        getCreateBudgetMethod;
    if ((getCreateBudgetMethod = BudgetServiceGrpc.getCreateBudgetMethod) == null) {
      synchronized (BudgetServiceGrpc.class) {
        if ((getCreateBudgetMethod = BudgetServiceGrpc.getCreateBudgetMethod) == null) {
          BudgetServiceGrpc.getCreateBudgetMethod =
              getCreateBudgetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.billing.budgets.v1beta1.CreateBudgetRequest,
                          com.google.cloud.billing.budgets.v1beta1.Budget>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.billing.budgets.v1beta1.BudgetService", "CreateBudget"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.billing.budgets.v1beta1.CreateBudgetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.billing.budgets.v1beta1.Budget.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BudgetServiceMethodDescriptorSupplier("CreateBudget"))
                      .build();
        }
      }
    }
    return getCreateBudgetMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateBudgetMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.billing.budgets.v1beta1.UpdateBudgetRequest,
          com.google.cloud.billing.budgets.v1beta1.Budget>
      METHOD_UPDATE_BUDGET = getUpdateBudgetMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.billing.budgets.v1beta1.UpdateBudgetRequest,
          com.google.cloud.billing.budgets.v1beta1.Budget>
      getUpdateBudgetMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.billing.budgets.v1beta1.UpdateBudgetRequest,
          com.google.cloud.billing.budgets.v1beta1.Budget>
      getUpdateBudgetMethod() {
    return getUpdateBudgetMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.billing.budgets.v1beta1.UpdateBudgetRequest,
          com.google.cloud.billing.budgets.v1beta1.Budget>
      getUpdateBudgetMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.billing.budgets.v1beta1.UpdateBudgetRequest,
            com.google.cloud.billing.budgets.v1beta1.Budget>
        getUpdateBudgetMethod;
    if ((getUpdateBudgetMethod = BudgetServiceGrpc.getUpdateBudgetMethod) == null) {
      synchronized (BudgetServiceGrpc.class) {
        if ((getUpdateBudgetMethod = BudgetServiceGrpc.getUpdateBudgetMethod) == null) {
          BudgetServiceGrpc.getUpdateBudgetMethod =
              getUpdateBudgetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.billing.budgets.v1beta1.UpdateBudgetRequest,
                          com.google.cloud.billing.budgets.v1beta1.Budget>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.billing.budgets.v1beta1.BudgetService", "UpdateBudget"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.billing.budgets.v1beta1.UpdateBudgetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.billing.budgets.v1beta1.Budget.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BudgetServiceMethodDescriptorSupplier("UpdateBudget"))
                      .build();
        }
      }
    }
    return getUpdateBudgetMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetBudgetMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.billing.budgets.v1beta1.GetBudgetRequest,
          com.google.cloud.billing.budgets.v1beta1.Budget>
      METHOD_GET_BUDGET = getGetBudgetMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.billing.budgets.v1beta1.GetBudgetRequest,
          com.google.cloud.billing.budgets.v1beta1.Budget>
      getGetBudgetMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.billing.budgets.v1beta1.GetBudgetRequest,
          com.google.cloud.billing.budgets.v1beta1.Budget>
      getGetBudgetMethod() {
    return getGetBudgetMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.billing.budgets.v1beta1.GetBudgetRequest,
          com.google.cloud.billing.budgets.v1beta1.Budget>
      getGetBudgetMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.billing.budgets.v1beta1.GetBudgetRequest,
            com.google.cloud.billing.budgets.v1beta1.Budget>
        getGetBudgetMethod;
    if ((getGetBudgetMethod = BudgetServiceGrpc.getGetBudgetMethod) == null) {
      synchronized (BudgetServiceGrpc.class) {
        if ((getGetBudgetMethod = BudgetServiceGrpc.getGetBudgetMethod) == null) {
          BudgetServiceGrpc.getGetBudgetMethod =
              getGetBudgetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.billing.budgets.v1beta1.GetBudgetRequest,
                          com.google.cloud.billing.budgets.v1beta1.Budget>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.billing.budgets.v1beta1.BudgetService", "GetBudget"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.billing.budgets.v1beta1.GetBudgetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.billing.budgets.v1beta1.Budget.getDefaultInstance()))
                      .setSchemaDescriptor(new BudgetServiceMethodDescriptorSupplier("GetBudget"))
                      .build();
        }
      }
    }
    return getGetBudgetMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListBudgetsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.billing.budgets.v1beta1.ListBudgetsRequest,
          com.google.cloud.billing.budgets.v1beta1.ListBudgetsResponse>
      METHOD_LIST_BUDGETS = getListBudgetsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.billing.budgets.v1beta1.ListBudgetsRequest,
          com.google.cloud.billing.budgets.v1beta1.ListBudgetsResponse>
      getListBudgetsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.billing.budgets.v1beta1.ListBudgetsRequest,
          com.google.cloud.billing.budgets.v1beta1.ListBudgetsResponse>
      getListBudgetsMethod() {
    return getListBudgetsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.billing.budgets.v1beta1.ListBudgetsRequest,
          com.google.cloud.billing.budgets.v1beta1.ListBudgetsResponse>
      getListBudgetsMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.billing.budgets.v1beta1.ListBudgetsRequest,
            com.google.cloud.billing.budgets.v1beta1.ListBudgetsResponse>
        getListBudgetsMethod;
    if ((getListBudgetsMethod = BudgetServiceGrpc.getListBudgetsMethod) == null) {
      synchronized (BudgetServiceGrpc.class) {
        if ((getListBudgetsMethod = BudgetServiceGrpc.getListBudgetsMethod) == null) {
          BudgetServiceGrpc.getListBudgetsMethod =
              getListBudgetsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.billing.budgets.v1beta1.ListBudgetsRequest,
                          com.google.cloud.billing.budgets.v1beta1.ListBudgetsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.billing.budgets.v1beta1.BudgetService", "ListBudgets"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.billing.budgets.v1beta1.ListBudgetsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.billing.budgets.v1beta1.ListBudgetsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new BudgetServiceMethodDescriptorSupplier("ListBudgets"))
                      .build();
        }
      }
    }
    return getListBudgetsMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteBudgetMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.billing.budgets.v1beta1.DeleteBudgetRequest, com.google.protobuf.Empty>
      METHOD_DELETE_BUDGET = getDeleteBudgetMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.billing.budgets.v1beta1.DeleteBudgetRequest, com.google.protobuf.Empty>
      getDeleteBudgetMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.billing.budgets.v1beta1.DeleteBudgetRequest, com.google.protobuf.Empty>
      getDeleteBudgetMethod() {
    return getDeleteBudgetMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.billing.budgets.v1beta1.DeleteBudgetRequest, com.google.protobuf.Empty>
      getDeleteBudgetMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.billing.budgets.v1beta1.DeleteBudgetRequest, com.google.protobuf.Empty>
        getDeleteBudgetMethod;
    if ((getDeleteBudgetMethod = BudgetServiceGrpc.getDeleteBudgetMethod) == null) {
      synchronized (BudgetServiceGrpc.class) {
        if ((getDeleteBudgetMethod = BudgetServiceGrpc.getDeleteBudgetMethod) == null) {
          BudgetServiceGrpc.getDeleteBudgetMethod =
              getDeleteBudgetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.billing.budgets.v1beta1.DeleteBudgetRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.billing.budgets.v1beta1.BudgetService", "DeleteBudget"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.billing.budgets.v1beta1.DeleteBudgetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BudgetServiceMethodDescriptorSupplier("DeleteBudget"))
                      .build();
        }
      }
    }
    return getDeleteBudgetMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static BudgetServiceStub newStub(io.grpc.Channel channel) {
    return new BudgetServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BudgetServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new BudgetServiceBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static BudgetServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    return new BudgetServiceFutureStub(channel);
  }

  /**
   *
   *
   * <pre>
   * BudgetService stores Cloud Billing budgets, which define a
   * budget plan and rules to execute as we track spend against that plan.
   * </pre>
   */
  public abstract static class BudgetServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates a new budget. See
     * &lt;a href="https://cloud.google.com/billing/quotas"&gt;Quotas and limits&lt;/a&gt;
     * for more information on the limits of the number of budgets you can create.
     * </pre>
     */
    public void createBudget(
        com.google.cloud.billing.budgets.v1beta1.CreateBudgetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.billing.budgets.v1beta1.Budget>
            responseObserver) {
      asyncUnimplementedUnaryCall(getCreateBudgetMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a budget and returns the updated budget.
     * </pre>
     */
    public void updateBudget(
        com.google.cloud.billing.budgets.v1beta1.UpdateBudgetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.billing.budgets.v1beta1.Budget>
            responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateBudgetMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a budget.
     * </pre>
     */
    public void getBudget(
        com.google.cloud.billing.budgets.v1beta1.GetBudgetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.billing.budgets.v1beta1.Budget>
            responseObserver) {
      asyncUnimplementedUnaryCall(getGetBudgetMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of budgets for a billing account.
     * </pre>
     */
    public void listBudgets(
        com.google.cloud.billing.budgets.v1beta1.ListBudgetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.billing.budgets.v1beta1.ListBudgetsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListBudgetsMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a budget. Returns successfully if already deleted.
     * </pre>
     */
    public void deleteBudget(
        com.google.cloud.billing.budgets.v1beta1.DeleteBudgetRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteBudgetMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateBudgetMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.billing.budgets.v1beta1.CreateBudgetRequest,
                      com.google.cloud.billing.budgets.v1beta1.Budget>(
                      this, METHODID_CREATE_BUDGET)))
          .addMethod(
              getUpdateBudgetMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.billing.budgets.v1beta1.UpdateBudgetRequest,
                      com.google.cloud.billing.budgets.v1beta1.Budget>(
                      this, METHODID_UPDATE_BUDGET)))
          .addMethod(
              getGetBudgetMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.billing.budgets.v1beta1.GetBudgetRequest,
                      com.google.cloud.billing.budgets.v1beta1.Budget>(this, METHODID_GET_BUDGET)))
          .addMethod(
              getListBudgetsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.billing.budgets.v1beta1.ListBudgetsRequest,
                      com.google.cloud.billing.budgets.v1beta1.ListBudgetsResponse>(
                      this, METHODID_LIST_BUDGETS)))
          .addMethod(
              getDeleteBudgetMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.billing.budgets.v1beta1.DeleteBudgetRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_BUDGET)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * BudgetService stores Cloud Billing budgets, which define a
   * budget plan and rules to execute as we track spend against that plan.
   * </pre>
   */
  public static final class BudgetServiceStub extends io.grpc.stub.AbstractStub<BudgetServiceStub> {
    private BudgetServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BudgetServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BudgetServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BudgetServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new budget. See
     * &lt;a href="https://cloud.google.com/billing/quotas"&gt;Quotas and limits&lt;/a&gt;
     * for more information on the limits of the number of budgets you can create.
     * </pre>
     */
    public void createBudget(
        com.google.cloud.billing.budgets.v1beta1.CreateBudgetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.billing.budgets.v1beta1.Budget>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateBudgetMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a budget and returns the updated budget.
     * </pre>
     */
    public void updateBudget(
        com.google.cloud.billing.budgets.v1beta1.UpdateBudgetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.billing.budgets.v1beta1.Budget>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateBudgetMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a budget.
     * </pre>
     */
    public void getBudget(
        com.google.cloud.billing.budgets.v1beta1.GetBudgetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.billing.budgets.v1beta1.Budget>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetBudgetMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of budgets for a billing account.
     * </pre>
     */
    public void listBudgets(
        com.google.cloud.billing.budgets.v1beta1.ListBudgetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.billing.budgets.v1beta1.ListBudgetsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListBudgetsMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a budget. Returns successfully if already deleted.
     * </pre>
     */
    public void deleteBudget(
        com.google.cloud.billing.budgets.v1beta1.DeleteBudgetRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteBudgetMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * BudgetService stores Cloud Billing budgets, which define a
   * budget plan and rules to execute as we track spend against that plan.
   * </pre>
   */
  public static final class BudgetServiceBlockingStub
      extends io.grpc.stub.AbstractStub<BudgetServiceBlockingStub> {
    private BudgetServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BudgetServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BudgetServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BudgetServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new budget. See
     * &lt;a href="https://cloud.google.com/billing/quotas"&gt;Quotas and limits&lt;/a&gt;
     * for more information on the limits of the number of budgets you can create.
     * </pre>
     */
    public com.google.cloud.billing.budgets.v1beta1.Budget createBudget(
        com.google.cloud.billing.budgets.v1beta1.CreateBudgetRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateBudgetMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a budget and returns the updated budget.
     * </pre>
     */
    public com.google.cloud.billing.budgets.v1beta1.Budget updateBudget(
        com.google.cloud.billing.budgets.v1beta1.UpdateBudgetRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateBudgetMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a budget.
     * </pre>
     */
    public com.google.cloud.billing.budgets.v1beta1.Budget getBudget(
        com.google.cloud.billing.budgets.v1beta1.GetBudgetRequest request) {
      return blockingUnaryCall(getChannel(), getGetBudgetMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of budgets for a billing account.
     * </pre>
     */
    public com.google.cloud.billing.budgets.v1beta1.ListBudgetsResponse listBudgets(
        com.google.cloud.billing.budgets.v1beta1.ListBudgetsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListBudgetsMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a budget. Returns successfully if already deleted.
     * </pre>
     */
    public com.google.protobuf.Empty deleteBudget(
        com.google.cloud.billing.budgets.v1beta1.DeleteBudgetRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteBudgetMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * BudgetService stores Cloud Billing budgets, which define a
   * budget plan and rules to execute as we track spend against that plan.
   * </pre>
   */
  public static final class BudgetServiceFutureStub
      extends io.grpc.stub.AbstractStub<BudgetServiceFutureStub> {
    private BudgetServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BudgetServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BudgetServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BudgetServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new budget. See
     * &lt;a href="https://cloud.google.com/billing/quotas"&gt;Quotas and limits&lt;/a&gt;
     * for more information on the limits of the number of budgets you can create.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.billing.budgets.v1beta1.Budget>
        createBudget(com.google.cloud.billing.budgets.v1beta1.CreateBudgetRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateBudgetMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a budget and returns the updated budget.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.billing.budgets.v1beta1.Budget>
        updateBudget(com.google.cloud.billing.budgets.v1beta1.UpdateBudgetRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateBudgetMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a budget.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.billing.budgets.v1beta1.Budget>
        getBudget(com.google.cloud.billing.budgets.v1beta1.GetBudgetRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetBudgetMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of budgets for a billing account.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.billing.budgets.v1beta1.ListBudgetsResponse>
        listBudgets(com.google.cloud.billing.budgets.v1beta1.ListBudgetsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListBudgetsMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a budget. Returns successfully if already deleted.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteBudget(com.google.cloud.billing.budgets.v1beta1.DeleteBudgetRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteBudgetMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_BUDGET = 0;
  private static final int METHODID_UPDATE_BUDGET = 1;
  private static final int METHODID_GET_BUDGET = 2;
  private static final int METHODID_LIST_BUDGETS = 3;
  private static final int METHODID_DELETE_BUDGET = 4;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
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
          serviceImpl.createBudget(
              (com.google.cloud.billing.budgets.v1beta1.CreateBudgetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.billing.budgets.v1beta1.Budget>)
                  responseObserver);
          break;
        case METHODID_UPDATE_BUDGET:
          serviceImpl.updateBudget(
              (com.google.cloud.billing.budgets.v1beta1.UpdateBudgetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.billing.budgets.v1beta1.Budget>)
                  responseObserver);
          break;
        case METHODID_GET_BUDGET:
          serviceImpl.getBudget(
              (com.google.cloud.billing.budgets.v1beta1.GetBudgetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.billing.budgets.v1beta1.Budget>)
                  responseObserver);
          break;
        case METHODID_LIST_BUDGETS:
          serviceImpl.listBudgets(
              (com.google.cloud.billing.budgets.v1beta1.ListBudgetsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.billing.budgets.v1beta1.ListBudgetsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_BUDGET:
          serviceImpl.deleteBudget(
              (com.google.cloud.billing.budgets.v1beta1.DeleteBudgetRequest) request,
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

  private abstract static class BudgetServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
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
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new BudgetServiceFileDescriptorSupplier())
                      .addMethod(getCreateBudgetMethodHelper())
                      .addMethod(getUpdateBudgetMethodHelper())
                      .addMethod(getGetBudgetMethodHelper())
                      .addMethod(getListBudgetsMethodHelper())
                      .addMethod(getDeleteBudgetMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
