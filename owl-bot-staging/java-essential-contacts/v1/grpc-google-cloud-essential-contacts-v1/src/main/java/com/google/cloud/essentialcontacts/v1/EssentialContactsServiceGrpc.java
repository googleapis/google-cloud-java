package com.google.cloud.essentialcontacts.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Manages contacts for important Google Cloud notifications.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/essentialcontacts/v1/service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class EssentialContactsServiceGrpc {

  private EssentialContactsServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.essentialcontacts.v1.EssentialContactsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.essentialcontacts.v1.CreateContactRequest,
      com.google.cloud.essentialcontacts.v1.Contact> getCreateContactMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateContact",
      requestType = com.google.cloud.essentialcontacts.v1.CreateContactRequest.class,
      responseType = com.google.cloud.essentialcontacts.v1.Contact.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.essentialcontacts.v1.CreateContactRequest,
      com.google.cloud.essentialcontacts.v1.Contact> getCreateContactMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.essentialcontacts.v1.CreateContactRequest, com.google.cloud.essentialcontacts.v1.Contact> getCreateContactMethod;
    if ((getCreateContactMethod = EssentialContactsServiceGrpc.getCreateContactMethod) == null) {
      synchronized (EssentialContactsServiceGrpc.class) {
        if ((getCreateContactMethod = EssentialContactsServiceGrpc.getCreateContactMethod) == null) {
          EssentialContactsServiceGrpc.getCreateContactMethod = getCreateContactMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.essentialcontacts.v1.CreateContactRequest, com.google.cloud.essentialcontacts.v1.Contact>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateContact"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.essentialcontacts.v1.CreateContactRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.essentialcontacts.v1.Contact.getDefaultInstance()))
              .setSchemaDescriptor(new EssentialContactsServiceMethodDescriptorSupplier("CreateContact"))
              .build();
        }
      }
    }
    return getCreateContactMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.essentialcontacts.v1.UpdateContactRequest,
      com.google.cloud.essentialcontacts.v1.Contact> getUpdateContactMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateContact",
      requestType = com.google.cloud.essentialcontacts.v1.UpdateContactRequest.class,
      responseType = com.google.cloud.essentialcontacts.v1.Contact.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.essentialcontacts.v1.UpdateContactRequest,
      com.google.cloud.essentialcontacts.v1.Contact> getUpdateContactMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.essentialcontacts.v1.UpdateContactRequest, com.google.cloud.essentialcontacts.v1.Contact> getUpdateContactMethod;
    if ((getUpdateContactMethod = EssentialContactsServiceGrpc.getUpdateContactMethod) == null) {
      synchronized (EssentialContactsServiceGrpc.class) {
        if ((getUpdateContactMethod = EssentialContactsServiceGrpc.getUpdateContactMethod) == null) {
          EssentialContactsServiceGrpc.getUpdateContactMethod = getUpdateContactMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.essentialcontacts.v1.UpdateContactRequest, com.google.cloud.essentialcontacts.v1.Contact>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateContact"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.essentialcontacts.v1.UpdateContactRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.essentialcontacts.v1.Contact.getDefaultInstance()))
              .setSchemaDescriptor(new EssentialContactsServiceMethodDescriptorSupplier("UpdateContact"))
              .build();
        }
      }
    }
    return getUpdateContactMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.essentialcontacts.v1.ListContactsRequest,
      com.google.cloud.essentialcontacts.v1.ListContactsResponse> getListContactsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListContacts",
      requestType = com.google.cloud.essentialcontacts.v1.ListContactsRequest.class,
      responseType = com.google.cloud.essentialcontacts.v1.ListContactsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.essentialcontacts.v1.ListContactsRequest,
      com.google.cloud.essentialcontacts.v1.ListContactsResponse> getListContactsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.essentialcontacts.v1.ListContactsRequest, com.google.cloud.essentialcontacts.v1.ListContactsResponse> getListContactsMethod;
    if ((getListContactsMethod = EssentialContactsServiceGrpc.getListContactsMethod) == null) {
      synchronized (EssentialContactsServiceGrpc.class) {
        if ((getListContactsMethod = EssentialContactsServiceGrpc.getListContactsMethod) == null) {
          EssentialContactsServiceGrpc.getListContactsMethod = getListContactsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.essentialcontacts.v1.ListContactsRequest, com.google.cloud.essentialcontacts.v1.ListContactsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListContacts"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.essentialcontacts.v1.ListContactsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.essentialcontacts.v1.ListContactsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EssentialContactsServiceMethodDescriptorSupplier("ListContacts"))
              .build();
        }
      }
    }
    return getListContactsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.essentialcontacts.v1.GetContactRequest,
      com.google.cloud.essentialcontacts.v1.Contact> getGetContactMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetContact",
      requestType = com.google.cloud.essentialcontacts.v1.GetContactRequest.class,
      responseType = com.google.cloud.essentialcontacts.v1.Contact.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.essentialcontacts.v1.GetContactRequest,
      com.google.cloud.essentialcontacts.v1.Contact> getGetContactMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.essentialcontacts.v1.GetContactRequest, com.google.cloud.essentialcontacts.v1.Contact> getGetContactMethod;
    if ((getGetContactMethod = EssentialContactsServiceGrpc.getGetContactMethod) == null) {
      synchronized (EssentialContactsServiceGrpc.class) {
        if ((getGetContactMethod = EssentialContactsServiceGrpc.getGetContactMethod) == null) {
          EssentialContactsServiceGrpc.getGetContactMethod = getGetContactMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.essentialcontacts.v1.GetContactRequest, com.google.cloud.essentialcontacts.v1.Contact>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetContact"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.essentialcontacts.v1.GetContactRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.essentialcontacts.v1.Contact.getDefaultInstance()))
              .setSchemaDescriptor(new EssentialContactsServiceMethodDescriptorSupplier("GetContact"))
              .build();
        }
      }
    }
    return getGetContactMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.essentialcontacts.v1.DeleteContactRequest,
      com.google.protobuf.Empty> getDeleteContactMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteContact",
      requestType = com.google.cloud.essentialcontacts.v1.DeleteContactRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.essentialcontacts.v1.DeleteContactRequest,
      com.google.protobuf.Empty> getDeleteContactMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.essentialcontacts.v1.DeleteContactRequest, com.google.protobuf.Empty> getDeleteContactMethod;
    if ((getDeleteContactMethod = EssentialContactsServiceGrpc.getDeleteContactMethod) == null) {
      synchronized (EssentialContactsServiceGrpc.class) {
        if ((getDeleteContactMethod = EssentialContactsServiceGrpc.getDeleteContactMethod) == null) {
          EssentialContactsServiceGrpc.getDeleteContactMethod = getDeleteContactMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.essentialcontacts.v1.DeleteContactRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteContact"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.essentialcontacts.v1.DeleteContactRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new EssentialContactsServiceMethodDescriptorSupplier("DeleteContact"))
              .build();
        }
      }
    }
    return getDeleteContactMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.essentialcontacts.v1.ComputeContactsRequest,
      com.google.cloud.essentialcontacts.v1.ComputeContactsResponse> getComputeContactsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ComputeContacts",
      requestType = com.google.cloud.essentialcontacts.v1.ComputeContactsRequest.class,
      responseType = com.google.cloud.essentialcontacts.v1.ComputeContactsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.essentialcontacts.v1.ComputeContactsRequest,
      com.google.cloud.essentialcontacts.v1.ComputeContactsResponse> getComputeContactsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.essentialcontacts.v1.ComputeContactsRequest, com.google.cloud.essentialcontacts.v1.ComputeContactsResponse> getComputeContactsMethod;
    if ((getComputeContactsMethod = EssentialContactsServiceGrpc.getComputeContactsMethod) == null) {
      synchronized (EssentialContactsServiceGrpc.class) {
        if ((getComputeContactsMethod = EssentialContactsServiceGrpc.getComputeContactsMethod) == null) {
          EssentialContactsServiceGrpc.getComputeContactsMethod = getComputeContactsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.essentialcontacts.v1.ComputeContactsRequest, com.google.cloud.essentialcontacts.v1.ComputeContactsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ComputeContacts"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.essentialcontacts.v1.ComputeContactsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.essentialcontacts.v1.ComputeContactsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EssentialContactsServiceMethodDescriptorSupplier("ComputeContacts"))
              .build();
        }
      }
    }
    return getComputeContactsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.essentialcontacts.v1.SendTestMessageRequest,
      com.google.protobuf.Empty> getSendTestMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendTestMessage",
      requestType = com.google.cloud.essentialcontacts.v1.SendTestMessageRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.essentialcontacts.v1.SendTestMessageRequest,
      com.google.protobuf.Empty> getSendTestMessageMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.essentialcontacts.v1.SendTestMessageRequest, com.google.protobuf.Empty> getSendTestMessageMethod;
    if ((getSendTestMessageMethod = EssentialContactsServiceGrpc.getSendTestMessageMethod) == null) {
      synchronized (EssentialContactsServiceGrpc.class) {
        if ((getSendTestMessageMethod = EssentialContactsServiceGrpc.getSendTestMessageMethod) == null) {
          EssentialContactsServiceGrpc.getSendTestMessageMethod = getSendTestMessageMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.essentialcontacts.v1.SendTestMessageRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendTestMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.essentialcontacts.v1.SendTestMessageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new EssentialContactsServiceMethodDescriptorSupplier("SendTestMessage"))
              .build();
        }
      }
    }
    return getSendTestMessageMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EssentialContactsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EssentialContactsServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EssentialContactsServiceStub>() {
        @java.lang.Override
        public EssentialContactsServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EssentialContactsServiceStub(channel, callOptions);
        }
      };
    return EssentialContactsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EssentialContactsServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EssentialContactsServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EssentialContactsServiceBlockingStub>() {
        @java.lang.Override
        public EssentialContactsServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EssentialContactsServiceBlockingStub(channel, callOptions);
        }
      };
    return EssentialContactsServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EssentialContactsServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EssentialContactsServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EssentialContactsServiceFutureStub>() {
        @java.lang.Override
        public EssentialContactsServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EssentialContactsServiceFutureStub(channel, callOptions);
        }
      };
    return EssentialContactsServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Manages contacts for important Google Cloud notifications.
   * </pre>
   */
  public static abstract class EssentialContactsServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Adds a new contact for a resource.
     * </pre>
     */
    public void createContact(com.google.cloud.essentialcontacts.v1.CreateContactRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.essentialcontacts.v1.Contact> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateContactMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates a contact.
     * Note: A contact's email address cannot be changed.
     * </pre>
     */
    public void updateContact(com.google.cloud.essentialcontacts.v1.UpdateContactRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.essentialcontacts.v1.Contact> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateContactMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists the contacts that have been set on a resource.
     * </pre>
     */
    public void listContacts(com.google.cloud.essentialcontacts.v1.ListContactsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.essentialcontacts.v1.ListContactsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListContactsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets a single contact.
     * </pre>
     */
    public void getContact(com.google.cloud.essentialcontacts.v1.GetContactRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.essentialcontacts.v1.Contact> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetContactMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a contact.
     * </pre>
     */
    public void deleteContact(com.google.cloud.essentialcontacts.v1.DeleteContactRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteContactMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists all contacts for the resource that are subscribed to the
     * specified notification categories, including contacts inherited from
     * any parent resources.
     * </pre>
     */
    public void computeContacts(com.google.cloud.essentialcontacts.v1.ComputeContactsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.essentialcontacts.v1.ComputeContactsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getComputeContactsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Allows a contact admin to send a test message to contact to verify that it
     * has been configured correctly.
     * </pre>
     */
    public void sendTestMessage(com.google.cloud.essentialcontacts.v1.SendTestMessageRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendTestMessageMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateContactMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.essentialcontacts.v1.CreateContactRequest,
                com.google.cloud.essentialcontacts.v1.Contact>(
                  this, METHODID_CREATE_CONTACT)))
          .addMethod(
            getUpdateContactMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.essentialcontacts.v1.UpdateContactRequest,
                com.google.cloud.essentialcontacts.v1.Contact>(
                  this, METHODID_UPDATE_CONTACT)))
          .addMethod(
            getListContactsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.essentialcontacts.v1.ListContactsRequest,
                com.google.cloud.essentialcontacts.v1.ListContactsResponse>(
                  this, METHODID_LIST_CONTACTS)))
          .addMethod(
            getGetContactMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.essentialcontacts.v1.GetContactRequest,
                com.google.cloud.essentialcontacts.v1.Contact>(
                  this, METHODID_GET_CONTACT)))
          .addMethod(
            getDeleteContactMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.essentialcontacts.v1.DeleteContactRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_CONTACT)))
          .addMethod(
            getComputeContactsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.essentialcontacts.v1.ComputeContactsRequest,
                com.google.cloud.essentialcontacts.v1.ComputeContactsResponse>(
                  this, METHODID_COMPUTE_CONTACTS)))
          .addMethod(
            getSendTestMessageMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.essentialcontacts.v1.SendTestMessageRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_SEND_TEST_MESSAGE)))
          .build();
    }
  }

  /**
   * <pre>
   * Manages contacts for important Google Cloud notifications.
   * </pre>
   */
  public static final class EssentialContactsServiceStub extends io.grpc.stub.AbstractAsyncStub<EssentialContactsServiceStub> {
    private EssentialContactsServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EssentialContactsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EssentialContactsServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Adds a new contact for a resource.
     * </pre>
     */
    public void createContact(com.google.cloud.essentialcontacts.v1.CreateContactRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.essentialcontacts.v1.Contact> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateContactMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates a contact.
     * Note: A contact's email address cannot be changed.
     * </pre>
     */
    public void updateContact(com.google.cloud.essentialcontacts.v1.UpdateContactRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.essentialcontacts.v1.Contact> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateContactMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists the contacts that have been set on a resource.
     * </pre>
     */
    public void listContacts(com.google.cloud.essentialcontacts.v1.ListContactsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.essentialcontacts.v1.ListContactsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListContactsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a single contact.
     * </pre>
     */
    public void getContact(com.google.cloud.essentialcontacts.v1.GetContactRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.essentialcontacts.v1.Contact> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetContactMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a contact.
     * </pre>
     */
    public void deleteContact(com.google.cloud.essentialcontacts.v1.DeleteContactRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteContactMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists all contacts for the resource that are subscribed to the
     * specified notification categories, including contacts inherited from
     * any parent resources.
     * </pre>
     */
    public void computeContacts(com.google.cloud.essentialcontacts.v1.ComputeContactsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.essentialcontacts.v1.ComputeContactsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getComputeContactsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Allows a contact admin to send a test message to contact to verify that it
     * has been configured correctly.
     * </pre>
     */
    public void sendTestMessage(com.google.cloud.essentialcontacts.v1.SendTestMessageRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendTestMessageMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Manages contacts for important Google Cloud notifications.
   * </pre>
   */
  public static final class EssentialContactsServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<EssentialContactsServiceBlockingStub> {
    private EssentialContactsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EssentialContactsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EssentialContactsServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Adds a new contact for a resource.
     * </pre>
     */
    public com.google.cloud.essentialcontacts.v1.Contact createContact(com.google.cloud.essentialcontacts.v1.CreateContactRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateContactMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates a contact.
     * Note: A contact's email address cannot be changed.
     * </pre>
     */
    public com.google.cloud.essentialcontacts.v1.Contact updateContact(com.google.cloud.essentialcontacts.v1.UpdateContactRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateContactMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists the contacts that have been set on a resource.
     * </pre>
     */
    public com.google.cloud.essentialcontacts.v1.ListContactsResponse listContacts(com.google.cloud.essentialcontacts.v1.ListContactsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListContactsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a single contact.
     * </pre>
     */
    public com.google.cloud.essentialcontacts.v1.Contact getContact(com.google.cloud.essentialcontacts.v1.GetContactRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetContactMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a contact.
     * </pre>
     */
    public com.google.protobuf.Empty deleteContact(com.google.cloud.essentialcontacts.v1.DeleteContactRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteContactMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists all contacts for the resource that are subscribed to the
     * specified notification categories, including contacts inherited from
     * any parent resources.
     * </pre>
     */
    public com.google.cloud.essentialcontacts.v1.ComputeContactsResponse computeContacts(com.google.cloud.essentialcontacts.v1.ComputeContactsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getComputeContactsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Allows a contact admin to send a test message to contact to verify that it
     * has been configured correctly.
     * </pre>
     */
    public com.google.protobuf.Empty sendTestMessage(com.google.cloud.essentialcontacts.v1.SendTestMessageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendTestMessageMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Manages contacts for important Google Cloud notifications.
   * </pre>
   */
  public static final class EssentialContactsServiceFutureStub extends io.grpc.stub.AbstractFutureStub<EssentialContactsServiceFutureStub> {
    private EssentialContactsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EssentialContactsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EssentialContactsServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Adds a new contact for a resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.essentialcontacts.v1.Contact> createContact(
        com.google.cloud.essentialcontacts.v1.CreateContactRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateContactMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates a contact.
     * Note: A contact's email address cannot be changed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.essentialcontacts.v1.Contact> updateContact(
        com.google.cloud.essentialcontacts.v1.UpdateContactRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateContactMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists the contacts that have been set on a resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.essentialcontacts.v1.ListContactsResponse> listContacts(
        com.google.cloud.essentialcontacts.v1.ListContactsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListContactsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a single contact.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.essentialcontacts.v1.Contact> getContact(
        com.google.cloud.essentialcontacts.v1.GetContactRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetContactMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a contact.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteContact(
        com.google.cloud.essentialcontacts.v1.DeleteContactRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteContactMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists all contacts for the resource that are subscribed to the
     * specified notification categories, including contacts inherited from
     * any parent resources.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.essentialcontacts.v1.ComputeContactsResponse> computeContacts(
        com.google.cloud.essentialcontacts.v1.ComputeContactsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getComputeContactsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Allows a contact admin to send a test message to contact to verify that it
     * has been configured correctly.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> sendTestMessage(
        com.google.cloud.essentialcontacts.v1.SendTestMessageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendTestMessageMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_CONTACT = 0;
  private static final int METHODID_UPDATE_CONTACT = 1;
  private static final int METHODID_LIST_CONTACTS = 2;
  private static final int METHODID_GET_CONTACT = 3;
  private static final int METHODID_DELETE_CONTACT = 4;
  private static final int METHODID_COMPUTE_CONTACTS = 5;
  private static final int METHODID_SEND_TEST_MESSAGE = 6;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EssentialContactsServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EssentialContactsServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_CONTACT:
          serviceImpl.createContact((com.google.cloud.essentialcontacts.v1.CreateContactRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.essentialcontacts.v1.Contact>) responseObserver);
          break;
        case METHODID_UPDATE_CONTACT:
          serviceImpl.updateContact((com.google.cloud.essentialcontacts.v1.UpdateContactRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.essentialcontacts.v1.Contact>) responseObserver);
          break;
        case METHODID_LIST_CONTACTS:
          serviceImpl.listContacts((com.google.cloud.essentialcontacts.v1.ListContactsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.essentialcontacts.v1.ListContactsResponse>) responseObserver);
          break;
        case METHODID_GET_CONTACT:
          serviceImpl.getContact((com.google.cloud.essentialcontacts.v1.GetContactRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.essentialcontacts.v1.Contact>) responseObserver);
          break;
        case METHODID_DELETE_CONTACT:
          serviceImpl.deleteContact((com.google.cloud.essentialcontacts.v1.DeleteContactRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_COMPUTE_CONTACTS:
          serviceImpl.computeContacts((com.google.cloud.essentialcontacts.v1.ComputeContactsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.essentialcontacts.v1.ComputeContactsResponse>) responseObserver);
          break;
        case METHODID_SEND_TEST_MESSAGE:
          serviceImpl.sendTestMessage((com.google.cloud.essentialcontacts.v1.SendTestMessageRequest) request,
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

  private static abstract class EssentialContactsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EssentialContactsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.essentialcontacts.v1.Service.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EssentialContactsService");
    }
  }

  private static final class EssentialContactsServiceFileDescriptorSupplier
      extends EssentialContactsServiceBaseDescriptorSupplier {
    EssentialContactsServiceFileDescriptorSupplier() {}
  }

  private static final class EssentialContactsServiceMethodDescriptorSupplier
      extends EssentialContactsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    EssentialContactsServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (EssentialContactsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EssentialContactsServiceFileDescriptorSupplier())
              .addMethod(getCreateContactMethod())
              .addMethod(getUpdateContactMethod())
              .addMethod(getListContactsMethod())
              .addMethod(getGetContactMethod())
              .addMethod(getDeleteContactMethod())
              .addMethod(getComputeContactsMethod())
              .addMethod(getSendTestMessageMethod())
              .build();
        }
      }
    }
    return result;
  }
}
