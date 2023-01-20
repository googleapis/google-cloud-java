package com.google.appengine.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Firewall resources are used to define a collection of access control rules
 * for an Application. Each rule is defined with a position which specifies
 * the rule's order in the sequence of rules, an IP range to be matched against
 * requests, and an action to take upon matching requests.
 * Every request is evaluated against the Firewall rules in priority order.
 * Processesing stops at the first rule which matches the request's IP address.
 * A final rule always specifies an action that applies to all remaining
 * IP addresses. The default final rule for a newly-created application will be
 * set to "allow" if not otherwise specified by the user.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/appengine/v1/appengine.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FirewallGrpc {

  private FirewallGrpc() {}

  public static final String SERVICE_NAME = "google.appengine.v1.Firewall";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.appengine.v1.ListIngressRulesRequest,
      com.google.appengine.v1.ListIngressRulesResponse> getListIngressRulesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListIngressRules",
      requestType = com.google.appengine.v1.ListIngressRulesRequest.class,
      responseType = com.google.appengine.v1.ListIngressRulesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.appengine.v1.ListIngressRulesRequest,
      com.google.appengine.v1.ListIngressRulesResponse> getListIngressRulesMethod() {
    io.grpc.MethodDescriptor<com.google.appengine.v1.ListIngressRulesRequest, com.google.appengine.v1.ListIngressRulesResponse> getListIngressRulesMethod;
    if ((getListIngressRulesMethod = FirewallGrpc.getListIngressRulesMethod) == null) {
      synchronized (FirewallGrpc.class) {
        if ((getListIngressRulesMethod = FirewallGrpc.getListIngressRulesMethod) == null) {
          FirewallGrpc.getListIngressRulesMethod = getListIngressRulesMethod =
              io.grpc.MethodDescriptor.<com.google.appengine.v1.ListIngressRulesRequest, com.google.appengine.v1.ListIngressRulesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListIngressRules"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.appengine.v1.ListIngressRulesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.appengine.v1.ListIngressRulesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FirewallMethodDescriptorSupplier("ListIngressRules"))
              .build();
        }
      }
    }
    return getListIngressRulesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.appengine.v1.BatchUpdateIngressRulesRequest,
      com.google.appengine.v1.BatchUpdateIngressRulesResponse> getBatchUpdateIngressRulesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchUpdateIngressRules",
      requestType = com.google.appengine.v1.BatchUpdateIngressRulesRequest.class,
      responseType = com.google.appengine.v1.BatchUpdateIngressRulesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.appengine.v1.BatchUpdateIngressRulesRequest,
      com.google.appengine.v1.BatchUpdateIngressRulesResponse> getBatchUpdateIngressRulesMethod() {
    io.grpc.MethodDescriptor<com.google.appengine.v1.BatchUpdateIngressRulesRequest, com.google.appengine.v1.BatchUpdateIngressRulesResponse> getBatchUpdateIngressRulesMethod;
    if ((getBatchUpdateIngressRulesMethod = FirewallGrpc.getBatchUpdateIngressRulesMethod) == null) {
      synchronized (FirewallGrpc.class) {
        if ((getBatchUpdateIngressRulesMethod = FirewallGrpc.getBatchUpdateIngressRulesMethod) == null) {
          FirewallGrpc.getBatchUpdateIngressRulesMethod = getBatchUpdateIngressRulesMethod =
              io.grpc.MethodDescriptor.<com.google.appengine.v1.BatchUpdateIngressRulesRequest, com.google.appengine.v1.BatchUpdateIngressRulesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchUpdateIngressRules"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.appengine.v1.BatchUpdateIngressRulesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.appengine.v1.BatchUpdateIngressRulesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FirewallMethodDescriptorSupplier("BatchUpdateIngressRules"))
              .build();
        }
      }
    }
    return getBatchUpdateIngressRulesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.appengine.v1.CreateIngressRuleRequest,
      com.google.appengine.v1.firewall.FirewallRule> getCreateIngressRuleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateIngressRule",
      requestType = com.google.appengine.v1.CreateIngressRuleRequest.class,
      responseType = com.google.appengine.v1.firewall.FirewallRule.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.appengine.v1.CreateIngressRuleRequest,
      com.google.appengine.v1.firewall.FirewallRule> getCreateIngressRuleMethod() {
    io.grpc.MethodDescriptor<com.google.appengine.v1.CreateIngressRuleRequest, com.google.appengine.v1.firewall.FirewallRule> getCreateIngressRuleMethod;
    if ((getCreateIngressRuleMethod = FirewallGrpc.getCreateIngressRuleMethod) == null) {
      synchronized (FirewallGrpc.class) {
        if ((getCreateIngressRuleMethod = FirewallGrpc.getCreateIngressRuleMethod) == null) {
          FirewallGrpc.getCreateIngressRuleMethod = getCreateIngressRuleMethod =
              io.grpc.MethodDescriptor.<com.google.appengine.v1.CreateIngressRuleRequest, com.google.appengine.v1.firewall.FirewallRule>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateIngressRule"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.appengine.v1.CreateIngressRuleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.appengine.v1.firewall.FirewallRule.getDefaultInstance()))
              .setSchemaDescriptor(new FirewallMethodDescriptorSupplier("CreateIngressRule"))
              .build();
        }
      }
    }
    return getCreateIngressRuleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.appengine.v1.GetIngressRuleRequest,
      com.google.appengine.v1.firewall.FirewallRule> getGetIngressRuleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIngressRule",
      requestType = com.google.appengine.v1.GetIngressRuleRequest.class,
      responseType = com.google.appengine.v1.firewall.FirewallRule.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.appengine.v1.GetIngressRuleRequest,
      com.google.appengine.v1.firewall.FirewallRule> getGetIngressRuleMethod() {
    io.grpc.MethodDescriptor<com.google.appengine.v1.GetIngressRuleRequest, com.google.appengine.v1.firewall.FirewallRule> getGetIngressRuleMethod;
    if ((getGetIngressRuleMethod = FirewallGrpc.getGetIngressRuleMethod) == null) {
      synchronized (FirewallGrpc.class) {
        if ((getGetIngressRuleMethod = FirewallGrpc.getGetIngressRuleMethod) == null) {
          FirewallGrpc.getGetIngressRuleMethod = getGetIngressRuleMethod =
              io.grpc.MethodDescriptor.<com.google.appengine.v1.GetIngressRuleRequest, com.google.appengine.v1.firewall.FirewallRule>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIngressRule"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.appengine.v1.GetIngressRuleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.appengine.v1.firewall.FirewallRule.getDefaultInstance()))
              .setSchemaDescriptor(new FirewallMethodDescriptorSupplier("GetIngressRule"))
              .build();
        }
      }
    }
    return getGetIngressRuleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.appengine.v1.UpdateIngressRuleRequest,
      com.google.appengine.v1.firewall.FirewallRule> getUpdateIngressRuleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateIngressRule",
      requestType = com.google.appengine.v1.UpdateIngressRuleRequest.class,
      responseType = com.google.appengine.v1.firewall.FirewallRule.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.appengine.v1.UpdateIngressRuleRequest,
      com.google.appengine.v1.firewall.FirewallRule> getUpdateIngressRuleMethod() {
    io.grpc.MethodDescriptor<com.google.appengine.v1.UpdateIngressRuleRequest, com.google.appengine.v1.firewall.FirewallRule> getUpdateIngressRuleMethod;
    if ((getUpdateIngressRuleMethod = FirewallGrpc.getUpdateIngressRuleMethod) == null) {
      synchronized (FirewallGrpc.class) {
        if ((getUpdateIngressRuleMethod = FirewallGrpc.getUpdateIngressRuleMethod) == null) {
          FirewallGrpc.getUpdateIngressRuleMethod = getUpdateIngressRuleMethod =
              io.grpc.MethodDescriptor.<com.google.appengine.v1.UpdateIngressRuleRequest, com.google.appengine.v1.firewall.FirewallRule>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateIngressRule"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.appengine.v1.UpdateIngressRuleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.appengine.v1.firewall.FirewallRule.getDefaultInstance()))
              .setSchemaDescriptor(new FirewallMethodDescriptorSupplier("UpdateIngressRule"))
              .build();
        }
      }
    }
    return getUpdateIngressRuleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.appengine.v1.DeleteIngressRuleRequest,
      com.google.protobuf.Empty> getDeleteIngressRuleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteIngressRule",
      requestType = com.google.appengine.v1.DeleteIngressRuleRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.appengine.v1.DeleteIngressRuleRequest,
      com.google.protobuf.Empty> getDeleteIngressRuleMethod() {
    io.grpc.MethodDescriptor<com.google.appengine.v1.DeleteIngressRuleRequest, com.google.protobuf.Empty> getDeleteIngressRuleMethod;
    if ((getDeleteIngressRuleMethod = FirewallGrpc.getDeleteIngressRuleMethod) == null) {
      synchronized (FirewallGrpc.class) {
        if ((getDeleteIngressRuleMethod = FirewallGrpc.getDeleteIngressRuleMethod) == null) {
          FirewallGrpc.getDeleteIngressRuleMethod = getDeleteIngressRuleMethod =
              io.grpc.MethodDescriptor.<com.google.appengine.v1.DeleteIngressRuleRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteIngressRule"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.appengine.v1.DeleteIngressRuleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new FirewallMethodDescriptorSupplier("DeleteIngressRule"))
              .build();
        }
      }
    }
    return getDeleteIngressRuleMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FirewallStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FirewallStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FirewallStub>() {
        @java.lang.Override
        public FirewallStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FirewallStub(channel, callOptions);
        }
      };
    return FirewallStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FirewallBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FirewallBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FirewallBlockingStub>() {
        @java.lang.Override
        public FirewallBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FirewallBlockingStub(channel, callOptions);
        }
      };
    return FirewallBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FirewallFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FirewallFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FirewallFutureStub>() {
        @java.lang.Override
        public FirewallFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FirewallFutureStub(channel, callOptions);
        }
      };
    return FirewallFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Firewall resources are used to define a collection of access control rules
   * for an Application. Each rule is defined with a position which specifies
   * the rule's order in the sequence of rules, an IP range to be matched against
   * requests, and an action to take upon matching requests.
   * Every request is evaluated against the Firewall rules in priority order.
   * Processesing stops at the first rule which matches the request's IP address.
   * A final rule always specifies an action that applies to all remaining
   * IP addresses. The default final rule for a newly-created application will be
   * set to "allow" if not otherwise specified by the user.
   * </pre>
   */
  public static abstract class FirewallImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Lists the firewall rules of an application.
     * </pre>
     */
    public void listIngressRules(com.google.appengine.v1.ListIngressRulesRequest request,
        io.grpc.stub.StreamObserver<com.google.appengine.v1.ListIngressRulesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListIngressRulesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Replaces the entire firewall ruleset in one bulk operation. This overrides
     * and replaces the rules of an existing firewall with the new rules.
     * If the final rule does not match traffic with the '*' wildcard IP range,
     * then an "allow all" rule is explicitly added to the end of the list.
     * </pre>
     */
    public void batchUpdateIngressRules(com.google.appengine.v1.BatchUpdateIngressRulesRequest request,
        io.grpc.stub.StreamObserver<com.google.appengine.v1.BatchUpdateIngressRulesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBatchUpdateIngressRulesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a firewall rule for the application.
     * </pre>
     */
    public void createIngressRule(com.google.appengine.v1.CreateIngressRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.appengine.v1.firewall.FirewallRule> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateIngressRuleMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets the specified firewall rule.
     * </pre>
     */
    public void getIngressRule(com.google.appengine.v1.GetIngressRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.appengine.v1.firewall.FirewallRule> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetIngressRuleMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates the specified firewall rule.
     * </pre>
     */
    public void updateIngressRule(com.google.appengine.v1.UpdateIngressRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.appengine.v1.firewall.FirewallRule> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateIngressRuleMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes the specified firewall rule.
     * </pre>
     */
    public void deleteIngressRule(com.google.appengine.v1.DeleteIngressRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteIngressRuleMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListIngressRulesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.appengine.v1.ListIngressRulesRequest,
                com.google.appengine.v1.ListIngressRulesResponse>(
                  this, METHODID_LIST_INGRESS_RULES)))
          .addMethod(
            getBatchUpdateIngressRulesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.appengine.v1.BatchUpdateIngressRulesRequest,
                com.google.appengine.v1.BatchUpdateIngressRulesResponse>(
                  this, METHODID_BATCH_UPDATE_INGRESS_RULES)))
          .addMethod(
            getCreateIngressRuleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.appengine.v1.CreateIngressRuleRequest,
                com.google.appengine.v1.firewall.FirewallRule>(
                  this, METHODID_CREATE_INGRESS_RULE)))
          .addMethod(
            getGetIngressRuleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.appengine.v1.GetIngressRuleRequest,
                com.google.appengine.v1.firewall.FirewallRule>(
                  this, METHODID_GET_INGRESS_RULE)))
          .addMethod(
            getUpdateIngressRuleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.appengine.v1.UpdateIngressRuleRequest,
                com.google.appengine.v1.firewall.FirewallRule>(
                  this, METHODID_UPDATE_INGRESS_RULE)))
          .addMethod(
            getDeleteIngressRuleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.appengine.v1.DeleteIngressRuleRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_INGRESS_RULE)))
          .build();
    }
  }

  /**
   * <pre>
   * Firewall resources are used to define a collection of access control rules
   * for an Application. Each rule is defined with a position which specifies
   * the rule's order in the sequence of rules, an IP range to be matched against
   * requests, and an action to take upon matching requests.
   * Every request is evaluated against the Firewall rules in priority order.
   * Processesing stops at the first rule which matches the request's IP address.
   * A final rule always specifies an action that applies to all remaining
   * IP addresses. The default final rule for a newly-created application will be
   * set to "allow" if not otherwise specified by the user.
   * </pre>
   */
  public static final class FirewallStub extends io.grpc.stub.AbstractAsyncStub<FirewallStub> {
    private FirewallStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FirewallStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FirewallStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists the firewall rules of an application.
     * </pre>
     */
    public void listIngressRules(com.google.appengine.v1.ListIngressRulesRequest request,
        io.grpc.stub.StreamObserver<com.google.appengine.v1.ListIngressRulesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListIngressRulesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Replaces the entire firewall ruleset in one bulk operation. This overrides
     * and replaces the rules of an existing firewall with the new rules.
     * If the final rule does not match traffic with the '*' wildcard IP range,
     * then an "allow all" rule is explicitly added to the end of the list.
     * </pre>
     */
    public void batchUpdateIngressRules(com.google.appengine.v1.BatchUpdateIngressRulesRequest request,
        io.grpc.stub.StreamObserver<com.google.appengine.v1.BatchUpdateIngressRulesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchUpdateIngressRulesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a firewall rule for the application.
     * </pre>
     */
    public void createIngressRule(com.google.appengine.v1.CreateIngressRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.appengine.v1.firewall.FirewallRule> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateIngressRuleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the specified firewall rule.
     * </pre>
     */
    public void getIngressRule(com.google.appengine.v1.GetIngressRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.appengine.v1.firewall.FirewallRule> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIngressRuleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the specified firewall rule.
     * </pre>
     */
    public void updateIngressRule(com.google.appengine.v1.UpdateIngressRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.appengine.v1.firewall.FirewallRule> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateIngressRuleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes the specified firewall rule.
     * </pre>
     */
    public void deleteIngressRule(com.google.appengine.v1.DeleteIngressRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteIngressRuleMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Firewall resources are used to define a collection of access control rules
   * for an Application. Each rule is defined with a position which specifies
   * the rule's order in the sequence of rules, an IP range to be matched against
   * requests, and an action to take upon matching requests.
   * Every request is evaluated against the Firewall rules in priority order.
   * Processesing stops at the first rule which matches the request's IP address.
   * A final rule always specifies an action that applies to all remaining
   * IP addresses. The default final rule for a newly-created application will be
   * set to "allow" if not otherwise specified by the user.
   * </pre>
   */
  public static final class FirewallBlockingStub extends io.grpc.stub.AbstractBlockingStub<FirewallBlockingStub> {
    private FirewallBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FirewallBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FirewallBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists the firewall rules of an application.
     * </pre>
     */
    public com.google.appengine.v1.ListIngressRulesResponse listIngressRules(com.google.appengine.v1.ListIngressRulesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListIngressRulesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Replaces the entire firewall ruleset in one bulk operation. This overrides
     * and replaces the rules of an existing firewall with the new rules.
     * If the final rule does not match traffic with the '*' wildcard IP range,
     * then an "allow all" rule is explicitly added to the end of the list.
     * </pre>
     */
    public com.google.appengine.v1.BatchUpdateIngressRulesResponse batchUpdateIngressRules(com.google.appengine.v1.BatchUpdateIngressRulesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchUpdateIngressRulesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a firewall rule for the application.
     * </pre>
     */
    public com.google.appengine.v1.firewall.FirewallRule createIngressRule(com.google.appengine.v1.CreateIngressRuleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateIngressRuleMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the specified firewall rule.
     * </pre>
     */
    public com.google.appengine.v1.firewall.FirewallRule getIngressRule(com.google.appengine.v1.GetIngressRuleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIngressRuleMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the specified firewall rule.
     * </pre>
     */
    public com.google.appengine.v1.firewall.FirewallRule updateIngressRule(com.google.appengine.v1.UpdateIngressRuleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateIngressRuleMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes the specified firewall rule.
     * </pre>
     */
    public com.google.protobuf.Empty deleteIngressRule(com.google.appengine.v1.DeleteIngressRuleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteIngressRuleMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Firewall resources are used to define a collection of access control rules
   * for an Application. Each rule is defined with a position which specifies
   * the rule's order in the sequence of rules, an IP range to be matched against
   * requests, and an action to take upon matching requests.
   * Every request is evaluated against the Firewall rules in priority order.
   * Processesing stops at the first rule which matches the request's IP address.
   * A final rule always specifies an action that applies to all remaining
   * IP addresses. The default final rule for a newly-created application will be
   * set to "allow" if not otherwise specified by the user.
   * </pre>
   */
  public static final class FirewallFutureStub extends io.grpc.stub.AbstractFutureStub<FirewallFutureStub> {
    private FirewallFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FirewallFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FirewallFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists the firewall rules of an application.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.appengine.v1.ListIngressRulesResponse> listIngressRules(
        com.google.appengine.v1.ListIngressRulesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListIngressRulesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Replaces the entire firewall ruleset in one bulk operation. This overrides
     * and replaces the rules of an existing firewall with the new rules.
     * If the final rule does not match traffic with the '*' wildcard IP range,
     * then an "allow all" rule is explicitly added to the end of the list.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.appengine.v1.BatchUpdateIngressRulesResponse> batchUpdateIngressRules(
        com.google.appengine.v1.BatchUpdateIngressRulesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchUpdateIngressRulesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a firewall rule for the application.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.appengine.v1.firewall.FirewallRule> createIngressRule(
        com.google.appengine.v1.CreateIngressRuleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateIngressRuleMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the specified firewall rule.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.appengine.v1.firewall.FirewallRule> getIngressRule(
        com.google.appengine.v1.GetIngressRuleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIngressRuleMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the specified firewall rule.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.appengine.v1.firewall.FirewallRule> updateIngressRule(
        com.google.appengine.v1.UpdateIngressRuleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateIngressRuleMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes the specified firewall rule.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteIngressRule(
        com.google.appengine.v1.DeleteIngressRuleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteIngressRuleMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_INGRESS_RULES = 0;
  private static final int METHODID_BATCH_UPDATE_INGRESS_RULES = 1;
  private static final int METHODID_CREATE_INGRESS_RULE = 2;
  private static final int METHODID_GET_INGRESS_RULE = 3;
  private static final int METHODID_UPDATE_INGRESS_RULE = 4;
  private static final int METHODID_DELETE_INGRESS_RULE = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FirewallImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FirewallImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_INGRESS_RULES:
          serviceImpl.listIngressRules((com.google.appengine.v1.ListIngressRulesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.appengine.v1.ListIngressRulesResponse>) responseObserver);
          break;
        case METHODID_BATCH_UPDATE_INGRESS_RULES:
          serviceImpl.batchUpdateIngressRules((com.google.appengine.v1.BatchUpdateIngressRulesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.appengine.v1.BatchUpdateIngressRulesResponse>) responseObserver);
          break;
        case METHODID_CREATE_INGRESS_RULE:
          serviceImpl.createIngressRule((com.google.appengine.v1.CreateIngressRuleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.appengine.v1.firewall.FirewallRule>) responseObserver);
          break;
        case METHODID_GET_INGRESS_RULE:
          serviceImpl.getIngressRule((com.google.appengine.v1.GetIngressRuleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.appengine.v1.firewall.FirewallRule>) responseObserver);
          break;
        case METHODID_UPDATE_INGRESS_RULE:
          serviceImpl.updateIngressRule((com.google.appengine.v1.UpdateIngressRuleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.appengine.v1.firewall.FirewallRule>) responseObserver);
          break;
        case METHODID_DELETE_INGRESS_RULE:
          serviceImpl.deleteIngressRule((com.google.appengine.v1.DeleteIngressRuleRequest) request,
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

  private static abstract class FirewallBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FirewallBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.appengine.v1.AppengineProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Firewall");
    }
  }

  private static final class FirewallFileDescriptorSupplier
      extends FirewallBaseDescriptorSupplier {
    FirewallFileDescriptorSupplier() {}
  }

  private static final class FirewallMethodDescriptorSupplier
      extends FirewallBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FirewallMethodDescriptorSupplier(String methodName) {
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
      synchronized (FirewallGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FirewallFileDescriptorSupplier())
              .addMethod(getListIngressRulesMethod())
              .addMethod(getBatchUpdateIngressRulesMethod())
              .addMethod(getCreateIngressRuleMethod())
              .addMethod(getGetIngressRuleMethod())
              .addMethod(getUpdateIngressRuleMethod())
              .addMethod(getDeleteIngressRuleMethod())
              .build();
        }
      }
    }
    return result;
  }
}
