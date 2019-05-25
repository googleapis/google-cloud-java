package com.google.cloud.talent.v4beta1;

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
 * A service that handles company management, including CRUD and enumeration.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/cloud/talent/v4beta1/company_service.proto")
public final class CompanyServiceGrpc {

  private CompanyServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.talent.v4beta1.CompanyService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateCompanyMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.CreateCompanyRequest,
          com.google.cloud.talent.v4beta1.Company>
      METHOD_CREATE_COMPANY = getCreateCompanyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.CreateCompanyRequest,
          com.google.cloud.talent.v4beta1.Company>
      getCreateCompanyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.CreateCompanyRequest,
          com.google.cloud.talent.v4beta1.Company>
      getCreateCompanyMethod() {
    return getCreateCompanyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.CreateCompanyRequest,
          com.google.cloud.talent.v4beta1.Company>
      getCreateCompanyMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.talent.v4beta1.CreateCompanyRequest,
            com.google.cloud.talent.v4beta1.Company>
        getCreateCompanyMethod;
    if ((getCreateCompanyMethod = CompanyServiceGrpc.getCreateCompanyMethod) == null) {
      synchronized (CompanyServiceGrpc.class) {
        if ((getCreateCompanyMethod = CompanyServiceGrpc.getCreateCompanyMethod) == null) {
          CompanyServiceGrpc.getCreateCompanyMethod =
              getCreateCompanyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.talent.v4beta1.CreateCompanyRequest,
                          com.google.cloud.talent.v4beta1.Company>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.talent.v4beta1.CompanyService", "CreateCompany"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.CreateCompanyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.Company.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CompanyServiceMethodDescriptorSupplier("CreateCompany"))
                      .build();
        }
      }
    }
    return getCreateCompanyMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetCompanyMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.GetCompanyRequest,
          com.google.cloud.talent.v4beta1.Company>
      METHOD_GET_COMPANY = getGetCompanyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.GetCompanyRequest,
          com.google.cloud.talent.v4beta1.Company>
      getGetCompanyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.GetCompanyRequest,
          com.google.cloud.talent.v4beta1.Company>
      getGetCompanyMethod() {
    return getGetCompanyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.GetCompanyRequest,
          com.google.cloud.talent.v4beta1.Company>
      getGetCompanyMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.talent.v4beta1.GetCompanyRequest,
            com.google.cloud.talent.v4beta1.Company>
        getGetCompanyMethod;
    if ((getGetCompanyMethod = CompanyServiceGrpc.getGetCompanyMethod) == null) {
      synchronized (CompanyServiceGrpc.class) {
        if ((getGetCompanyMethod = CompanyServiceGrpc.getGetCompanyMethod) == null) {
          CompanyServiceGrpc.getGetCompanyMethod =
              getGetCompanyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.talent.v4beta1.GetCompanyRequest,
                          com.google.cloud.talent.v4beta1.Company>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.talent.v4beta1.CompanyService", "GetCompany"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.GetCompanyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.Company.getDefaultInstance()))
                      .setSchemaDescriptor(new CompanyServiceMethodDescriptorSupplier("GetCompany"))
                      .build();
        }
      }
    }
    return getGetCompanyMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateCompanyMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.UpdateCompanyRequest,
          com.google.cloud.talent.v4beta1.Company>
      METHOD_UPDATE_COMPANY = getUpdateCompanyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.UpdateCompanyRequest,
          com.google.cloud.talent.v4beta1.Company>
      getUpdateCompanyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.UpdateCompanyRequest,
          com.google.cloud.talent.v4beta1.Company>
      getUpdateCompanyMethod() {
    return getUpdateCompanyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.UpdateCompanyRequest,
          com.google.cloud.talent.v4beta1.Company>
      getUpdateCompanyMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.talent.v4beta1.UpdateCompanyRequest,
            com.google.cloud.talent.v4beta1.Company>
        getUpdateCompanyMethod;
    if ((getUpdateCompanyMethod = CompanyServiceGrpc.getUpdateCompanyMethod) == null) {
      synchronized (CompanyServiceGrpc.class) {
        if ((getUpdateCompanyMethod = CompanyServiceGrpc.getUpdateCompanyMethod) == null) {
          CompanyServiceGrpc.getUpdateCompanyMethod =
              getUpdateCompanyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.talent.v4beta1.UpdateCompanyRequest,
                          com.google.cloud.talent.v4beta1.Company>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.talent.v4beta1.CompanyService", "UpdateCompany"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.UpdateCompanyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.Company.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CompanyServiceMethodDescriptorSupplier("UpdateCompany"))
                      .build();
        }
      }
    }
    return getUpdateCompanyMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteCompanyMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.DeleteCompanyRequest, com.google.protobuf.Empty>
      METHOD_DELETE_COMPANY = getDeleteCompanyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.DeleteCompanyRequest, com.google.protobuf.Empty>
      getDeleteCompanyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.DeleteCompanyRequest, com.google.protobuf.Empty>
      getDeleteCompanyMethod() {
    return getDeleteCompanyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.DeleteCompanyRequest, com.google.protobuf.Empty>
      getDeleteCompanyMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.talent.v4beta1.DeleteCompanyRequest, com.google.protobuf.Empty>
        getDeleteCompanyMethod;
    if ((getDeleteCompanyMethod = CompanyServiceGrpc.getDeleteCompanyMethod) == null) {
      synchronized (CompanyServiceGrpc.class) {
        if ((getDeleteCompanyMethod = CompanyServiceGrpc.getDeleteCompanyMethod) == null) {
          CompanyServiceGrpc.getDeleteCompanyMethod =
              getDeleteCompanyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.talent.v4beta1.DeleteCompanyRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.talent.v4beta1.CompanyService", "DeleteCompany"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.DeleteCompanyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CompanyServiceMethodDescriptorSupplier("DeleteCompany"))
                      .build();
        }
      }
    }
    return getDeleteCompanyMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListCompaniesMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.ListCompaniesRequest,
          com.google.cloud.talent.v4beta1.ListCompaniesResponse>
      METHOD_LIST_COMPANIES = getListCompaniesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.ListCompaniesRequest,
          com.google.cloud.talent.v4beta1.ListCompaniesResponse>
      getListCompaniesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.ListCompaniesRequest,
          com.google.cloud.talent.v4beta1.ListCompaniesResponse>
      getListCompaniesMethod() {
    return getListCompaniesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.ListCompaniesRequest,
          com.google.cloud.talent.v4beta1.ListCompaniesResponse>
      getListCompaniesMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.talent.v4beta1.ListCompaniesRequest,
            com.google.cloud.talent.v4beta1.ListCompaniesResponse>
        getListCompaniesMethod;
    if ((getListCompaniesMethod = CompanyServiceGrpc.getListCompaniesMethod) == null) {
      synchronized (CompanyServiceGrpc.class) {
        if ((getListCompaniesMethod = CompanyServiceGrpc.getListCompaniesMethod) == null) {
          CompanyServiceGrpc.getListCompaniesMethod =
              getListCompaniesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.talent.v4beta1.ListCompaniesRequest,
                          com.google.cloud.talent.v4beta1.ListCompaniesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.talent.v4beta1.CompanyService", "ListCompanies"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.ListCompaniesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.ListCompaniesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CompanyServiceMethodDescriptorSupplier("ListCompanies"))
                      .build();
        }
      }
    }
    return getListCompaniesMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static CompanyServiceStub newStub(io.grpc.Channel channel) {
    return new CompanyServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CompanyServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new CompanyServiceBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static CompanyServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    return new CompanyServiceFutureStub(channel);
  }

  /**
   *
   *
   * <pre>
   * A service that handles company management, including CRUD and enumeration.
   * </pre>
   */
  public abstract static class CompanyServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates a new company entity.
     * </pre>
     */
    public void createCompany(
        com.google.cloud.talent.v4beta1.CreateCompanyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.Company> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateCompanyMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves specified company.
     * </pre>
     */
    public void getCompany(
        com.google.cloud.talent.v4beta1.GetCompanyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.Company> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCompanyMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates specified company.
     * </pre>
     */
    public void updateCompany(
        com.google.cloud.talent.v4beta1.UpdateCompanyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.Company> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateCompanyMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes specified company.
     * Prerequisite: The company has no jobs associated with it.
     * </pre>
     */
    public void deleteCompany(
        com.google.cloud.talent.v4beta1.DeleteCompanyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteCompanyMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all companies associated with the project.
     * </pre>
     */
    public void listCompanies(
        com.google.cloud.talent.v4beta1.ListCompaniesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.ListCompaniesResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListCompaniesMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateCompanyMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.talent.v4beta1.CreateCompanyRequest,
                      com.google.cloud.talent.v4beta1.Company>(this, METHODID_CREATE_COMPANY)))
          .addMethod(
              getGetCompanyMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.talent.v4beta1.GetCompanyRequest,
                      com.google.cloud.talent.v4beta1.Company>(this, METHODID_GET_COMPANY)))
          .addMethod(
              getUpdateCompanyMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.talent.v4beta1.UpdateCompanyRequest,
                      com.google.cloud.talent.v4beta1.Company>(this, METHODID_UPDATE_COMPANY)))
          .addMethod(
              getDeleteCompanyMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.talent.v4beta1.DeleteCompanyRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_COMPANY)))
          .addMethod(
              getListCompaniesMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.talent.v4beta1.ListCompaniesRequest,
                      com.google.cloud.talent.v4beta1.ListCompaniesResponse>(
                      this, METHODID_LIST_COMPANIES)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * A service that handles company management, including CRUD and enumeration.
   * </pre>
   */
  public static final class CompanyServiceStub
      extends io.grpc.stub.AbstractStub<CompanyServiceStub> {
    private CompanyServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CompanyServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CompanyServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CompanyServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new company entity.
     * </pre>
     */
    public void createCompany(
        com.google.cloud.talent.v4beta1.CreateCompanyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.Company> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateCompanyMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves specified company.
     * </pre>
     */
    public void getCompany(
        com.google.cloud.talent.v4beta1.GetCompanyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.Company> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCompanyMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates specified company.
     * </pre>
     */
    public void updateCompany(
        com.google.cloud.talent.v4beta1.UpdateCompanyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.Company> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateCompanyMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes specified company.
     * Prerequisite: The company has no jobs associated with it.
     * </pre>
     */
    public void deleteCompany(
        com.google.cloud.talent.v4beta1.DeleteCompanyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteCompanyMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all companies associated with the project.
     * </pre>
     */
    public void listCompanies(
        com.google.cloud.talent.v4beta1.ListCompaniesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.ListCompaniesResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListCompaniesMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * A service that handles company management, including CRUD and enumeration.
   * </pre>
   */
  public static final class CompanyServiceBlockingStub
      extends io.grpc.stub.AbstractStub<CompanyServiceBlockingStub> {
    private CompanyServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CompanyServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CompanyServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CompanyServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new company entity.
     * </pre>
     */
    public com.google.cloud.talent.v4beta1.Company createCompany(
        com.google.cloud.talent.v4beta1.CreateCompanyRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateCompanyMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves specified company.
     * </pre>
     */
    public com.google.cloud.talent.v4beta1.Company getCompany(
        com.google.cloud.talent.v4beta1.GetCompanyRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetCompanyMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates specified company.
     * </pre>
     */
    public com.google.cloud.talent.v4beta1.Company updateCompany(
        com.google.cloud.talent.v4beta1.UpdateCompanyRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateCompanyMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes specified company.
     * Prerequisite: The company has no jobs associated with it.
     * </pre>
     */
    public com.google.protobuf.Empty deleteCompany(
        com.google.cloud.talent.v4beta1.DeleteCompanyRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteCompanyMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all companies associated with the project.
     * </pre>
     */
    public com.google.cloud.talent.v4beta1.ListCompaniesResponse listCompanies(
        com.google.cloud.talent.v4beta1.ListCompaniesRequest request) {
      return blockingUnaryCall(
          getChannel(), getListCompaniesMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * A service that handles company management, including CRUD and enumeration.
   * </pre>
   */
  public static final class CompanyServiceFutureStub
      extends io.grpc.stub.AbstractStub<CompanyServiceFutureStub> {
    private CompanyServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CompanyServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CompanyServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CompanyServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new company entity.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.talent.v4beta1.Company>
        createCompany(com.google.cloud.talent.v4beta1.CreateCompanyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateCompanyMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves specified company.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.talent.v4beta1.Company>
        getCompany(com.google.cloud.talent.v4beta1.GetCompanyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetCompanyMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates specified company.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.talent.v4beta1.Company>
        updateCompany(com.google.cloud.talent.v4beta1.UpdateCompanyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateCompanyMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes specified company.
     * Prerequisite: The company has no jobs associated with it.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteCompany(com.google.cloud.talent.v4beta1.DeleteCompanyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteCompanyMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all companies associated with the project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.talent.v4beta1.ListCompaniesResponse>
        listCompanies(com.google.cloud.talent.v4beta1.ListCompaniesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListCompaniesMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_COMPANY = 0;
  private static final int METHODID_GET_COMPANY = 1;
  private static final int METHODID_UPDATE_COMPANY = 2;
  private static final int METHODID_DELETE_COMPANY = 3;
  private static final int METHODID_LIST_COMPANIES = 4;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CompanyServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CompanyServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_COMPANY:
          serviceImpl.createCompany(
              (com.google.cloud.talent.v4beta1.CreateCompanyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.Company>)
                  responseObserver);
          break;
        case METHODID_GET_COMPANY:
          serviceImpl.getCompany(
              (com.google.cloud.talent.v4beta1.GetCompanyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.Company>)
                  responseObserver);
          break;
        case METHODID_UPDATE_COMPANY:
          serviceImpl.updateCompany(
              (com.google.cloud.talent.v4beta1.UpdateCompanyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.Company>)
                  responseObserver);
          break;
        case METHODID_DELETE_COMPANY:
          serviceImpl.deleteCompany(
              (com.google.cloud.talent.v4beta1.DeleteCompanyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_COMPANIES:
          serviceImpl.listCompanies(
              (com.google.cloud.talent.v4beta1.ListCompaniesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.ListCompaniesResponse>)
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

  private abstract static class CompanyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CompanyServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.talent.v4beta1.CompanyServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CompanyService");
    }
  }

  private static final class CompanyServiceFileDescriptorSupplier
      extends CompanyServiceBaseDescriptorSupplier {
    CompanyServiceFileDescriptorSupplier() {}
  }

  private static final class CompanyServiceMethodDescriptorSupplier
      extends CompanyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CompanyServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CompanyServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new CompanyServiceFileDescriptorSupplier())
                      .addMethod(getCreateCompanyMethodHelper())
                      .addMethod(getGetCompanyMethodHelper())
                      .addMethod(getUpdateCompanyMethodHelper())
                      .addMethod(getDeleteCompanyMethodHelper())
                      .addMethod(getListCompaniesMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
