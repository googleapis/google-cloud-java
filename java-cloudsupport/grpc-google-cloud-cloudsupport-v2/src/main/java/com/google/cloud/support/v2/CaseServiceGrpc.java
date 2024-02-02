/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.support.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * A service to manage Google Cloud support cases.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/support/v2/case_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CaseServiceGrpc {

  private CaseServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.support.v2.CaseService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.support.v2.GetCaseRequest, com.google.cloud.support.v2.Case>
      getGetCaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCase",
      requestType = com.google.cloud.support.v2.GetCaseRequest.class,
      responseType = com.google.cloud.support.v2.Case.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.support.v2.GetCaseRequest, com.google.cloud.support.v2.Case>
      getGetCaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.support.v2.GetCaseRequest, com.google.cloud.support.v2.Case>
        getGetCaseMethod;
    if ((getGetCaseMethod = CaseServiceGrpc.getGetCaseMethod) == null) {
      synchronized (CaseServiceGrpc.class) {
        if ((getGetCaseMethod = CaseServiceGrpc.getGetCaseMethod) == null) {
          CaseServiceGrpc.getGetCaseMethod =
              getGetCaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.support.v2.GetCaseRequest,
                          com.google.cloud.support.v2.Case>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCase"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.support.v2.GetCaseRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.support.v2.Case.getDefaultInstance()))
                      .setSchemaDescriptor(new CaseServiceMethodDescriptorSupplier("GetCase"))
                      .build();
        }
      }
    }
    return getGetCaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.support.v2.ListCasesRequest,
          com.google.cloud.support.v2.ListCasesResponse>
      getListCasesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCases",
      requestType = com.google.cloud.support.v2.ListCasesRequest.class,
      responseType = com.google.cloud.support.v2.ListCasesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.support.v2.ListCasesRequest,
          com.google.cloud.support.v2.ListCasesResponse>
      getListCasesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.support.v2.ListCasesRequest,
            com.google.cloud.support.v2.ListCasesResponse>
        getListCasesMethod;
    if ((getListCasesMethod = CaseServiceGrpc.getListCasesMethod) == null) {
      synchronized (CaseServiceGrpc.class) {
        if ((getListCasesMethod = CaseServiceGrpc.getListCasesMethod) == null) {
          CaseServiceGrpc.getListCasesMethod =
              getListCasesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.support.v2.ListCasesRequest,
                          com.google.cloud.support.v2.ListCasesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListCases"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.support.v2.ListCasesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.support.v2.ListCasesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new CaseServiceMethodDescriptorSupplier("ListCases"))
                      .build();
        }
      }
    }
    return getListCasesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.support.v2.SearchCasesRequest,
          com.google.cloud.support.v2.SearchCasesResponse>
      getSearchCasesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchCases",
      requestType = com.google.cloud.support.v2.SearchCasesRequest.class,
      responseType = com.google.cloud.support.v2.SearchCasesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.support.v2.SearchCasesRequest,
          com.google.cloud.support.v2.SearchCasesResponse>
      getSearchCasesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.support.v2.SearchCasesRequest,
            com.google.cloud.support.v2.SearchCasesResponse>
        getSearchCasesMethod;
    if ((getSearchCasesMethod = CaseServiceGrpc.getSearchCasesMethod) == null) {
      synchronized (CaseServiceGrpc.class) {
        if ((getSearchCasesMethod = CaseServiceGrpc.getSearchCasesMethod) == null) {
          CaseServiceGrpc.getSearchCasesMethod =
              getSearchCasesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.support.v2.SearchCasesRequest,
                          com.google.cloud.support.v2.SearchCasesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchCases"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.support.v2.SearchCasesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.support.v2.SearchCasesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new CaseServiceMethodDescriptorSupplier("SearchCases"))
                      .build();
        }
      }
    }
    return getSearchCasesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.support.v2.CreateCaseRequest, com.google.cloud.support.v2.Case>
      getCreateCaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCase",
      requestType = com.google.cloud.support.v2.CreateCaseRequest.class,
      responseType = com.google.cloud.support.v2.Case.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.support.v2.CreateCaseRequest, com.google.cloud.support.v2.Case>
      getCreateCaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.support.v2.CreateCaseRequest, com.google.cloud.support.v2.Case>
        getCreateCaseMethod;
    if ((getCreateCaseMethod = CaseServiceGrpc.getCreateCaseMethod) == null) {
      synchronized (CaseServiceGrpc.class) {
        if ((getCreateCaseMethod = CaseServiceGrpc.getCreateCaseMethod) == null) {
          CaseServiceGrpc.getCreateCaseMethod =
              getCreateCaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.support.v2.CreateCaseRequest,
                          com.google.cloud.support.v2.Case>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateCase"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.support.v2.CreateCaseRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.support.v2.Case.getDefaultInstance()))
                      .setSchemaDescriptor(new CaseServiceMethodDescriptorSupplier("CreateCase"))
                      .build();
        }
      }
    }
    return getCreateCaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.support.v2.UpdateCaseRequest, com.google.cloud.support.v2.Case>
      getUpdateCaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCase",
      requestType = com.google.cloud.support.v2.UpdateCaseRequest.class,
      responseType = com.google.cloud.support.v2.Case.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.support.v2.UpdateCaseRequest, com.google.cloud.support.v2.Case>
      getUpdateCaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.support.v2.UpdateCaseRequest, com.google.cloud.support.v2.Case>
        getUpdateCaseMethod;
    if ((getUpdateCaseMethod = CaseServiceGrpc.getUpdateCaseMethod) == null) {
      synchronized (CaseServiceGrpc.class) {
        if ((getUpdateCaseMethod = CaseServiceGrpc.getUpdateCaseMethod) == null) {
          CaseServiceGrpc.getUpdateCaseMethod =
              getUpdateCaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.support.v2.UpdateCaseRequest,
                          com.google.cloud.support.v2.Case>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCase"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.support.v2.UpdateCaseRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.support.v2.Case.getDefaultInstance()))
                      .setSchemaDescriptor(new CaseServiceMethodDescriptorSupplier("UpdateCase"))
                      .build();
        }
      }
    }
    return getUpdateCaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.support.v2.EscalateCaseRequest, com.google.cloud.support.v2.Case>
      getEscalateCaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EscalateCase",
      requestType = com.google.cloud.support.v2.EscalateCaseRequest.class,
      responseType = com.google.cloud.support.v2.Case.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.support.v2.EscalateCaseRequest, com.google.cloud.support.v2.Case>
      getEscalateCaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.support.v2.EscalateCaseRequest, com.google.cloud.support.v2.Case>
        getEscalateCaseMethod;
    if ((getEscalateCaseMethod = CaseServiceGrpc.getEscalateCaseMethod) == null) {
      synchronized (CaseServiceGrpc.class) {
        if ((getEscalateCaseMethod = CaseServiceGrpc.getEscalateCaseMethod) == null) {
          CaseServiceGrpc.getEscalateCaseMethod =
              getEscalateCaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.support.v2.EscalateCaseRequest,
                          com.google.cloud.support.v2.Case>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EscalateCase"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.support.v2.EscalateCaseRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.support.v2.Case.getDefaultInstance()))
                      .setSchemaDescriptor(new CaseServiceMethodDescriptorSupplier("EscalateCase"))
                      .build();
        }
      }
    }
    return getEscalateCaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.support.v2.CloseCaseRequest, com.google.cloud.support.v2.Case>
      getCloseCaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CloseCase",
      requestType = com.google.cloud.support.v2.CloseCaseRequest.class,
      responseType = com.google.cloud.support.v2.Case.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.support.v2.CloseCaseRequest, com.google.cloud.support.v2.Case>
      getCloseCaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.support.v2.CloseCaseRequest, com.google.cloud.support.v2.Case>
        getCloseCaseMethod;
    if ((getCloseCaseMethod = CaseServiceGrpc.getCloseCaseMethod) == null) {
      synchronized (CaseServiceGrpc.class) {
        if ((getCloseCaseMethod = CaseServiceGrpc.getCloseCaseMethod) == null) {
          CaseServiceGrpc.getCloseCaseMethod =
              getCloseCaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.support.v2.CloseCaseRequest,
                          com.google.cloud.support.v2.Case>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CloseCase"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.support.v2.CloseCaseRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.support.v2.Case.getDefaultInstance()))
                      .setSchemaDescriptor(new CaseServiceMethodDescriptorSupplier("CloseCase"))
                      .build();
        }
      }
    }
    return getCloseCaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.support.v2.SearchCaseClassificationsRequest,
          com.google.cloud.support.v2.SearchCaseClassificationsResponse>
      getSearchCaseClassificationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchCaseClassifications",
      requestType = com.google.cloud.support.v2.SearchCaseClassificationsRequest.class,
      responseType = com.google.cloud.support.v2.SearchCaseClassificationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.support.v2.SearchCaseClassificationsRequest,
          com.google.cloud.support.v2.SearchCaseClassificationsResponse>
      getSearchCaseClassificationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.support.v2.SearchCaseClassificationsRequest,
            com.google.cloud.support.v2.SearchCaseClassificationsResponse>
        getSearchCaseClassificationsMethod;
    if ((getSearchCaseClassificationsMethod = CaseServiceGrpc.getSearchCaseClassificationsMethod)
        == null) {
      synchronized (CaseServiceGrpc.class) {
        if ((getSearchCaseClassificationsMethod =
                CaseServiceGrpc.getSearchCaseClassificationsMethod)
            == null) {
          CaseServiceGrpc.getSearchCaseClassificationsMethod =
              getSearchCaseClassificationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.support.v2.SearchCaseClassificationsRequest,
                          com.google.cloud.support.v2.SearchCaseClassificationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SearchCaseClassifications"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.support.v2.SearchCaseClassificationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.support.v2.SearchCaseClassificationsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CaseServiceMethodDescriptorSupplier("SearchCaseClassifications"))
                      .build();
        }
      }
    }
    return getSearchCaseClassificationsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static CaseServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CaseServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CaseServiceStub>() {
          @java.lang.Override
          public CaseServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CaseServiceStub(channel, callOptions);
          }
        };
    return CaseServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CaseServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CaseServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CaseServiceBlockingStub>() {
          @java.lang.Override
          public CaseServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CaseServiceBlockingStub(channel, callOptions);
          }
        };
    return CaseServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static CaseServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CaseServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CaseServiceFutureStub>() {
          @java.lang.Override
          public CaseServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CaseServiceFutureStub(channel, callOptions);
          }
        };
    return CaseServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * A service to manage Google Cloud support cases.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Retrieve the specified case.
     * </pre>
     */
    default void getCase(
        com.google.cloud.support.v2.GetCaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.support.v2.Case> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve all cases under the specified parent.
     * Note: Listing cases under an Organization returns only the cases directly
     * parented by that organization. To retrieve all cases under an organization,
     * including cases parented by projects under that organization, use
     * `cases.search`.
     * </pre>
     */
    default void listCases(
        com.google.cloud.support.v2.ListCasesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.support.v2.ListCasesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListCasesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Search cases using the specified query.
     * </pre>
     */
    default void searchCases(
        com.google.cloud.support.v2.SearchCasesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.support.v2.SearchCasesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchCasesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new case and associate it with the given Google Cloud Resource.
     * The case object must have the following fields set: `display_name`,
     * `description`, `classification`, and `priority`.
     * </pre>
     */
    default void createCase(
        com.google.cloud.support.v2.CreateCaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.support.v2.Case> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateCaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update the specified case. Only a subset of fields can be updated.
     * </pre>
     */
    default void updateCase(
        com.google.cloud.support.v2.UpdateCaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.support.v2.Case> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateCaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Escalate a case. Escalating a case will initiate the Google Cloud Support
     * escalation management process.
     * This operation is only available to certain Customer Care tiers. Go to
     * https://cloud.google.com/support and look for 'Technical support
     * escalations' in the feature list to find out which tiers are able to
     * perform escalations.
     * </pre>
     */
    default void escalateCase(
        com.google.cloud.support.v2.EscalateCaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.support.v2.Case> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getEscalateCaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Close the specified case.
     * </pre>
     */
    default void closeCase(
        com.google.cloud.support.v2.CloseCaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.support.v2.Case> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCloseCaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve valid classifications to be used when creating a support case.
     * The classications are hierarchical, with each classification containing
     * all levels of the hierarchy, separated by " &gt; ". For example "Technical
     * Issue &gt; Compute &gt; Compute Engine".
     * </pre>
     */
    default void searchCaseClassifications(
        com.google.cloud.support.v2.SearchCaseClassificationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.support.v2.SearchCaseClassificationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchCaseClassificationsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CaseService.
   *
   * <pre>
   * A service to manage Google Cloud support cases.
   * </pre>
   */
  public abstract static class CaseServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return CaseServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CaseService.
   *
   * <pre>
   * A service to manage Google Cloud support cases.
   * </pre>
   */
  public static final class CaseServiceStub
      extends io.grpc.stub.AbstractAsyncStub<CaseServiceStub> {
    private CaseServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CaseServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CaseServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieve the specified case.
     * </pre>
     */
    public void getCase(
        com.google.cloud.support.v2.GetCaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.support.v2.Case> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCaseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve all cases under the specified parent.
     * Note: Listing cases under an Organization returns only the cases directly
     * parented by that organization. To retrieve all cases under an organization,
     * including cases parented by projects under that organization, use
     * `cases.search`.
     * </pre>
     */
    public void listCases(
        com.google.cloud.support.v2.ListCasesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.support.v2.ListCasesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCasesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Search cases using the specified query.
     * </pre>
     */
    public void searchCases(
        com.google.cloud.support.v2.SearchCasesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.support.v2.SearchCasesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchCasesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new case and associate it with the given Google Cloud Resource.
     * The case object must have the following fields set: `display_name`,
     * `description`, `classification`, and `priority`.
     * </pre>
     */
    public void createCase(
        com.google.cloud.support.v2.CreateCaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.support.v2.Case> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCaseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update the specified case. Only a subset of fields can be updated.
     * </pre>
     */
    public void updateCase(
        com.google.cloud.support.v2.UpdateCaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.support.v2.Case> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCaseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Escalate a case. Escalating a case will initiate the Google Cloud Support
     * escalation management process.
     * This operation is only available to certain Customer Care tiers. Go to
     * https://cloud.google.com/support and look for 'Technical support
     * escalations' in the feature list to find out which tiers are able to
     * perform escalations.
     * </pre>
     */
    public void escalateCase(
        com.google.cloud.support.v2.EscalateCaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.support.v2.Case> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEscalateCaseMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Close the specified case.
     * </pre>
     */
    public void closeCase(
        com.google.cloud.support.v2.CloseCaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.support.v2.Case> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCloseCaseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve valid classifications to be used when creating a support case.
     * The classications are hierarchical, with each classification containing
     * all levels of the hierarchy, separated by " &gt; ". For example "Technical
     * Issue &gt; Compute &gt; Compute Engine".
     * </pre>
     */
    public void searchCaseClassifications(
        com.google.cloud.support.v2.SearchCaseClassificationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.support.v2.SearchCaseClassificationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchCaseClassificationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CaseService.
   *
   * <pre>
   * A service to manage Google Cloud support cases.
   * </pre>
   */
  public static final class CaseServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CaseServiceBlockingStub> {
    private CaseServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CaseServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CaseServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieve the specified case.
     * </pre>
     */
    public com.google.cloud.support.v2.Case getCase(
        com.google.cloud.support.v2.GetCaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve all cases under the specified parent.
     * Note: Listing cases under an Organization returns only the cases directly
     * parented by that organization. To retrieve all cases under an organization,
     * including cases parented by projects under that organization, use
     * `cases.search`.
     * </pre>
     */
    public com.google.cloud.support.v2.ListCasesResponse listCases(
        com.google.cloud.support.v2.ListCasesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCasesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Search cases using the specified query.
     * </pre>
     */
    public com.google.cloud.support.v2.SearchCasesResponse searchCases(
        com.google.cloud.support.v2.SearchCasesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchCasesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new case and associate it with the given Google Cloud Resource.
     * The case object must have the following fields set: `display_name`,
     * `description`, `classification`, and `priority`.
     * </pre>
     */
    public com.google.cloud.support.v2.Case createCase(
        com.google.cloud.support.v2.CreateCaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update the specified case. Only a subset of fields can be updated.
     * </pre>
     */
    public com.google.cloud.support.v2.Case updateCase(
        com.google.cloud.support.v2.UpdateCaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Escalate a case. Escalating a case will initiate the Google Cloud Support
     * escalation management process.
     * This operation is only available to certain Customer Care tiers. Go to
     * https://cloud.google.com/support and look for 'Technical support
     * escalations' in the feature list to find out which tiers are able to
     * perform escalations.
     * </pre>
     */
    public com.google.cloud.support.v2.Case escalateCase(
        com.google.cloud.support.v2.EscalateCaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEscalateCaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Close the specified case.
     * </pre>
     */
    public com.google.cloud.support.v2.Case closeCase(
        com.google.cloud.support.v2.CloseCaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCloseCaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve valid classifications to be used when creating a support case.
     * The classications are hierarchical, with each classification containing
     * all levels of the hierarchy, separated by " &gt; ". For example "Technical
     * Issue &gt; Compute &gt; Compute Engine".
     * </pre>
     */
    public com.google.cloud.support.v2.SearchCaseClassificationsResponse searchCaseClassifications(
        com.google.cloud.support.v2.SearchCaseClassificationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchCaseClassificationsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CaseService.
   *
   * <pre>
   * A service to manage Google Cloud support cases.
   * </pre>
   */
  public static final class CaseServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<CaseServiceFutureStub> {
    private CaseServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CaseServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CaseServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieve the specified case.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.support.v2.Case>
        getCase(com.google.cloud.support.v2.GetCaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve all cases under the specified parent.
     * Note: Listing cases under an Organization returns only the cases directly
     * parented by that organization. To retrieve all cases under an organization,
     * including cases parented by projects under that organization, use
     * `cases.search`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.support.v2.ListCasesResponse>
        listCases(com.google.cloud.support.v2.ListCasesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCasesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Search cases using the specified query.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.support.v2.SearchCasesResponse>
        searchCases(com.google.cloud.support.v2.SearchCasesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchCasesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new case and associate it with the given Google Cloud Resource.
     * The case object must have the following fields set: `display_name`,
     * `description`, `classification`, and `priority`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.support.v2.Case>
        createCase(com.google.cloud.support.v2.CreateCaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update the specified case. Only a subset of fields can be updated.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.support.v2.Case>
        updateCase(com.google.cloud.support.v2.UpdateCaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Escalate a case. Escalating a case will initiate the Google Cloud Support
     * escalation management process.
     * This operation is only available to certain Customer Care tiers. Go to
     * https://cloud.google.com/support and look for 'Technical support
     * escalations' in the feature list to find out which tiers are able to
     * perform escalations.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.support.v2.Case>
        escalateCase(com.google.cloud.support.v2.EscalateCaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEscalateCaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Close the specified case.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.support.v2.Case>
        closeCase(com.google.cloud.support.v2.CloseCaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCloseCaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve valid classifications to be used when creating a support case.
     * The classications are hierarchical, with each classification containing
     * all levels of the hierarchy, separated by " &gt; ". For example "Technical
     * Issue &gt; Compute &gt; Compute Engine".
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.support.v2.SearchCaseClassificationsResponse>
        searchCaseClassifications(
            com.google.cloud.support.v2.SearchCaseClassificationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchCaseClassificationsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_CASE = 0;
  private static final int METHODID_LIST_CASES = 1;
  private static final int METHODID_SEARCH_CASES = 2;
  private static final int METHODID_CREATE_CASE = 3;
  private static final int METHODID_UPDATE_CASE = 4;
  private static final int METHODID_ESCALATE_CASE = 5;
  private static final int METHODID_CLOSE_CASE = 6;
  private static final int METHODID_SEARCH_CASE_CLASSIFICATIONS = 7;

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
        case METHODID_GET_CASE:
          serviceImpl.getCase(
              (com.google.cloud.support.v2.GetCaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.support.v2.Case>) responseObserver);
          break;
        case METHODID_LIST_CASES:
          serviceImpl.listCases(
              (com.google.cloud.support.v2.ListCasesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.support.v2.ListCasesResponse>)
                  responseObserver);
          break;
        case METHODID_SEARCH_CASES:
          serviceImpl.searchCases(
              (com.google.cloud.support.v2.SearchCasesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.support.v2.SearchCasesResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_CASE:
          serviceImpl.createCase(
              (com.google.cloud.support.v2.CreateCaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.support.v2.Case>) responseObserver);
          break;
        case METHODID_UPDATE_CASE:
          serviceImpl.updateCase(
              (com.google.cloud.support.v2.UpdateCaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.support.v2.Case>) responseObserver);
          break;
        case METHODID_ESCALATE_CASE:
          serviceImpl.escalateCase(
              (com.google.cloud.support.v2.EscalateCaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.support.v2.Case>) responseObserver);
          break;
        case METHODID_CLOSE_CASE:
          serviceImpl.closeCase(
              (com.google.cloud.support.v2.CloseCaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.support.v2.Case>) responseObserver);
          break;
        case METHODID_SEARCH_CASE_CLASSIFICATIONS:
          serviceImpl.searchCaseClassifications(
              (com.google.cloud.support.v2.SearchCaseClassificationsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.support.v2.SearchCaseClassificationsResponse>)
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
            getGetCaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.support.v2.GetCaseRequest, com.google.cloud.support.v2.Case>(
                    service, METHODID_GET_CASE)))
        .addMethod(
            getListCasesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.support.v2.ListCasesRequest,
                    com.google.cloud.support.v2.ListCasesResponse>(service, METHODID_LIST_CASES)))
        .addMethod(
            getSearchCasesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.support.v2.SearchCasesRequest,
                    com.google.cloud.support.v2.SearchCasesResponse>(
                    service, METHODID_SEARCH_CASES)))
        .addMethod(
            getCreateCaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.support.v2.CreateCaseRequest,
                    com.google.cloud.support.v2.Case>(service, METHODID_CREATE_CASE)))
        .addMethod(
            getUpdateCaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.support.v2.UpdateCaseRequest,
                    com.google.cloud.support.v2.Case>(service, METHODID_UPDATE_CASE)))
        .addMethod(
            getEscalateCaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.support.v2.EscalateCaseRequest,
                    com.google.cloud.support.v2.Case>(service, METHODID_ESCALATE_CASE)))
        .addMethod(
            getCloseCaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.support.v2.CloseCaseRequest, com.google.cloud.support.v2.Case>(
                    service, METHODID_CLOSE_CASE)))
        .addMethod(
            getSearchCaseClassificationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.support.v2.SearchCaseClassificationsRequest,
                    com.google.cloud.support.v2.SearchCaseClassificationsResponse>(
                    service, METHODID_SEARCH_CASE_CLASSIFICATIONS)))
        .build();
  }

  private abstract static class CaseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CaseServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.support.v2.CaseServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CaseService");
    }
  }

  private static final class CaseServiceFileDescriptorSupplier
      extends CaseServiceBaseDescriptorSupplier {
    CaseServiceFileDescriptorSupplier() {}
  }

  private static final class CaseServiceMethodDescriptorSupplier
      extends CaseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CaseServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (CaseServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new CaseServiceFileDescriptorSupplier())
                      .addMethod(getGetCaseMethod())
                      .addMethod(getListCasesMethod())
                      .addMethod(getSearchCasesMethod())
                      .addMethod(getCreateCaseMethod())
                      .addMethod(getUpdateCaseMethod())
                      .addMethod(getEscalateCaseMethod())
                      .addMethod(getCloseCaseMethod())
                      .addMethod(getSearchCaseClassificationsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
