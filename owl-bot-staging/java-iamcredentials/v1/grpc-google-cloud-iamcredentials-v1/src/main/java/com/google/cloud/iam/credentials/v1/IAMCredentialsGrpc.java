package com.google.cloud.iam.credentials.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * A service account is a special type of Google account that belongs to your
 * application or a virtual machine (VM), instead of to an individual end user.
 * Your application assumes the identity of the service account to call Google
 * APIs, so that the users aren't directly involved.
 * Service account credentials are used to temporarily assume the identity
 * of the service account. Supported credential types include OAuth 2.0 access
 * tokens, OpenID Connect ID tokens, self-signed JSON Web Tokens (JWTs), and
 * more.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/iam/credentials/v1/iamcredentials.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class IAMCredentialsGrpc {

  private IAMCredentialsGrpc() {}

  public static final String SERVICE_NAME = "google.iam.credentials.v1.IAMCredentials";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.iam.credentials.v1.GenerateAccessTokenRequest,
      com.google.cloud.iam.credentials.v1.GenerateAccessTokenResponse> getGenerateAccessTokenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateAccessToken",
      requestType = com.google.cloud.iam.credentials.v1.GenerateAccessTokenRequest.class,
      responseType = com.google.cloud.iam.credentials.v1.GenerateAccessTokenResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.iam.credentials.v1.GenerateAccessTokenRequest,
      com.google.cloud.iam.credentials.v1.GenerateAccessTokenResponse> getGenerateAccessTokenMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.iam.credentials.v1.GenerateAccessTokenRequest, com.google.cloud.iam.credentials.v1.GenerateAccessTokenResponse> getGenerateAccessTokenMethod;
    if ((getGenerateAccessTokenMethod = IAMCredentialsGrpc.getGenerateAccessTokenMethod) == null) {
      synchronized (IAMCredentialsGrpc.class) {
        if ((getGenerateAccessTokenMethod = IAMCredentialsGrpc.getGenerateAccessTokenMethod) == null) {
          IAMCredentialsGrpc.getGenerateAccessTokenMethod = getGenerateAccessTokenMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.iam.credentials.v1.GenerateAccessTokenRequest, com.google.cloud.iam.credentials.v1.GenerateAccessTokenResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateAccessToken"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.iam.credentials.v1.GenerateAccessTokenRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.iam.credentials.v1.GenerateAccessTokenResponse.getDefaultInstance()))
              .setSchemaDescriptor(new IAMCredentialsMethodDescriptorSupplier("GenerateAccessToken"))
              .build();
        }
      }
    }
    return getGenerateAccessTokenMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.iam.credentials.v1.GenerateIdTokenRequest,
      com.google.cloud.iam.credentials.v1.GenerateIdTokenResponse> getGenerateIdTokenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateIdToken",
      requestType = com.google.cloud.iam.credentials.v1.GenerateIdTokenRequest.class,
      responseType = com.google.cloud.iam.credentials.v1.GenerateIdTokenResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.iam.credentials.v1.GenerateIdTokenRequest,
      com.google.cloud.iam.credentials.v1.GenerateIdTokenResponse> getGenerateIdTokenMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.iam.credentials.v1.GenerateIdTokenRequest, com.google.cloud.iam.credentials.v1.GenerateIdTokenResponse> getGenerateIdTokenMethod;
    if ((getGenerateIdTokenMethod = IAMCredentialsGrpc.getGenerateIdTokenMethod) == null) {
      synchronized (IAMCredentialsGrpc.class) {
        if ((getGenerateIdTokenMethod = IAMCredentialsGrpc.getGenerateIdTokenMethod) == null) {
          IAMCredentialsGrpc.getGenerateIdTokenMethod = getGenerateIdTokenMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.iam.credentials.v1.GenerateIdTokenRequest, com.google.cloud.iam.credentials.v1.GenerateIdTokenResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateIdToken"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.iam.credentials.v1.GenerateIdTokenRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.iam.credentials.v1.GenerateIdTokenResponse.getDefaultInstance()))
              .setSchemaDescriptor(new IAMCredentialsMethodDescriptorSupplier("GenerateIdToken"))
              .build();
        }
      }
    }
    return getGenerateIdTokenMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.iam.credentials.v1.SignBlobRequest,
      com.google.cloud.iam.credentials.v1.SignBlobResponse> getSignBlobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SignBlob",
      requestType = com.google.cloud.iam.credentials.v1.SignBlobRequest.class,
      responseType = com.google.cloud.iam.credentials.v1.SignBlobResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.iam.credentials.v1.SignBlobRequest,
      com.google.cloud.iam.credentials.v1.SignBlobResponse> getSignBlobMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.iam.credentials.v1.SignBlobRequest, com.google.cloud.iam.credentials.v1.SignBlobResponse> getSignBlobMethod;
    if ((getSignBlobMethod = IAMCredentialsGrpc.getSignBlobMethod) == null) {
      synchronized (IAMCredentialsGrpc.class) {
        if ((getSignBlobMethod = IAMCredentialsGrpc.getSignBlobMethod) == null) {
          IAMCredentialsGrpc.getSignBlobMethod = getSignBlobMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.iam.credentials.v1.SignBlobRequest, com.google.cloud.iam.credentials.v1.SignBlobResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SignBlob"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.iam.credentials.v1.SignBlobRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.iam.credentials.v1.SignBlobResponse.getDefaultInstance()))
              .setSchemaDescriptor(new IAMCredentialsMethodDescriptorSupplier("SignBlob"))
              .build();
        }
      }
    }
    return getSignBlobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.iam.credentials.v1.SignJwtRequest,
      com.google.cloud.iam.credentials.v1.SignJwtResponse> getSignJwtMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SignJwt",
      requestType = com.google.cloud.iam.credentials.v1.SignJwtRequest.class,
      responseType = com.google.cloud.iam.credentials.v1.SignJwtResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.iam.credentials.v1.SignJwtRequest,
      com.google.cloud.iam.credentials.v1.SignJwtResponse> getSignJwtMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.iam.credentials.v1.SignJwtRequest, com.google.cloud.iam.credentials.v1.SignJwtResponse> getSignJwtMethod;
    if ((getSignJwtMethod = IAMCredentialsGrpc.getSignJwtMethod) == null) {
      synchronized (IAMCredentialsGrpc.class) {
        if ((getSignJwtMethod = IAMCredentialsGrpc.getSignJwtMethod) == null) {
          IAMCredentialsGrpc.getSignJwtMethod = getSignJwtMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.iam.credentials.v1.SignJwtRequest, com.google.cloud.iam.credentials.v1.SignJwtResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SignJwt"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.iam.credentials.v1.SignJwtRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.iam.credentials.v1.SignJwtResponse.getDefaultInstance()))
              .setSchemaDescriptor(new IAMCredentialsMethodDescriptorSupplier("SignJwt"))
              .build();
        }
      }
    }
    return getSignJwtMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static IAMCredentialsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IAMCredentialsStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IAMCredentialsStub>() {
        @java.lang.Override
        public IAMCredentialsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IAMCredentialsStub(channel, callOptions);
        }
      };
    return IAMCredentialsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static IAMCredentialsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IAMCredentialsBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IAMCredentialsBlockingStub>() {
        @java.lang.Override
        public IAMCredentialsBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IAMCredentialsBlockingStub(channel, callOptions);
        }
      };
    return IAMCredentialsBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static IAMCredentialsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IAMCredentialsFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IAMCredentialsFutureStub>() {
        @java.lang.Override
        public IAMCredentialsFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IAMCredentialsFutureStub(channel, callOptions);
        }
      };
    return IAMCredentialsFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * A service account is a special type of Google account that belongs to your
   * application or a virtual machine (VM), instead of to an individual end user.
   * Your application assumes the identity of the service account to call Google
   * APIs, so that the users aren't directly involved.
   * Service account credentials are used to temporarily assume the identity
   * of the service account. Supported credential types include OAuth 2.0 access
   * tokens, OpenID Connect ID tokens, self-signed JSON Web Tokens (JWTs), and
   * more.
   * </pre>
   */
  public static abstract class IAMCredentialsImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Generates an OAuth 2.0 access token for a service account.
     * </pre>
     */
    public void generateAccessToken(com.google.cloud.iam.credentials.v1.GenerateAccessTokenRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iam.credentials.v1.GenerateAccessTokenResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGenerateAccessTokenMethod(), responseObserver);
    }

    /**
     * <pre>
     * Generates an OpenID Connect ID token for a service account.
     * </pre>
     */
    public void generateIdToken(com.google.cloud.iam.credentials.v1.GenerateIdTokenRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iam.credentials.v1.GenerateIdTokenResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGenerateIdTokenMethod(), responseObserver);
    }

    /**
     * <pre>
     * Signs a blob using a service account's system-managed private key.
     * </pre>
     */
    public void signBlob(com.google.cloud.iam.credentials.v1.SignBlobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iam.credentials.v1.SignBlobResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSignBlobMethod(), responseObserver);
    }

    /**
     * <pre>
     * Signs a JWT using a service account's system-managed private key.
     * </pre>
     */
    public void signJwt(com.google.cloud.iam.credentials.v1.SignJwtRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iam.credentials.v1.SignJwtResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSignJwtMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGenerateAccessTokenMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.iam.credentials.v1.GenerateAccessTokenRequest,
                com.google.cloud.iam.credentials.v1.GenerateAccessTokenResponse>(
                  this, METHODID_GENERATE_ACCESS_TOKEN)))
          .addMethod(
            getGenerateIdTokenMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.iam.credentials.v1.GenerateIdTokenRequest,
                com.google.cloud.iam.credentials.v1.GenerateIdTokenResponse>(
                  this, METHODID_GENERATE_ID_TOKEN)))
          .addMethod(
            getSignBlobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.iam.credentials.v1.SignBlobRequest,
                com.google.cloud.iam.credentials.v1.SignBlobResponse>(
                  this, METHODID_SIGN_BLOB)))
          .addMethod(
            getSignJwtMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.iam.credentials.v1.SignJwtRequest,
                com.google.cloud.iam.credentials.v1.SignJwtResponse>(
                  this, METHODID_SIGN_JWT)))
          .build();
    }
  }

  /**
   * <pre>
   * A service account is a special type of Google account that belongs to your
   * application or a virtual machine (VM), instead of to an individual end user.
   * Your application assumes the identity of the service account to call Google
   * APIs, so that the users aren't directly involved.
   * Service account credentials are used to temporarily assume the identity
   * of the service account. Supported credential types include OAuth 2.0 access
   * tokens, OpenID Connect ID tokens, self-signed JSON Web Tokens (JWTs), and
   * more.
   * </pre>
   */
  public static final class IAMCredentialsStub extends io.grpc.stub.AbstractAsyncStub<IAMCredentialsStub> {
    private IAMCredentialsStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IAMCredentialsStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IAMCredentialsStub(channel, callOptions);
    }

    /**
     * <pre>
     * Generates an OAuth 2.0 access token for a service account.
     * </pre>
     */
    public void generateAccessToken(com.google.cloud.iam.credentials.v1.GenerateAccessTokenRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iam.credentials.v1.GenerateAccessTokenResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateAccessTokenMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Generates an OpenID Connect ID token for a service account.
     * </pre>
     */
    public void generateIdToken(com.google.cloud.iam.credentials.v1.GenerateIdTokenRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iam.credentials.v1.GenerateIdTokenResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateIdTokenMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Signs a blob using a service account's system-managed private key.
     * </pre>
     */
    public void signBlob(com.google.cloud.iam.credentials.v1.SignBlobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iam.credentials.v1.SignBlobResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSignBlobMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Signs a JWT using a service account's system-managed private key.
     * </pre>
     */
    public void signJwt(com.google.cloud.iam.credentials.v1.SignJwtRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iam.credentials.v1.SignJwtResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSignJwtMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * A service account is a special type of Google account that belongs to your
   * application or a virtual machine (VM), instead of to an individual end user.
   * Your application assumes the identity of the service account to call Google
   * APIs, so that the users aren't directly involved.
   * Service account credentials are used to temporarily assume the identity
   * of the service account. Supported credential types include OAuth 2.0 access
   * tokens, OpenID Connect ID tokens, self-signed JSON Web Tokens (JWTs), and
   * more.
   * </pre>
   */
  public static final class IAMCredentialsBlockingStub extends io.grpc.stub.AbstractBlockingStub<IAMCredentialsBlockingStub> {
    private IAMCredentialsBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IAMCredentialsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IAMCredentialsBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Generates an OAuth 2.0 access token for a service account.
     * </pre>
     */
    public com.google.cloud.iam.credentials.v1.GenerateAccessTokenResponse generateAccessToken(com.google.cloud.iam.credentials.v1.GenerateAccessTokenRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateAccessTokenMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Generates an OpenID Connect ID token for a service account.
     * </pre>
     */
    public com.google.cloud.iam.credentials.v1.GenerateIdTokenResponse generateIdToken(com.google.cloud.iam.credentials.v1.GenerateIdTokenRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateIdTokenMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Signs a blob using a service account's system-managed private key.
     * </pre>
     */
    public com.google.cloud.iam.credentials.v1.SignBlobResponse signBlob(com.google.cloud.iam.credentials.v1.SignBlobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSignBlobMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Signs a JWT using a service account's system-managed private key.
     * </pre>
     */
    public com.google.cloud.iam.credentials.v1.SignJwtResponse signJwt(com.google.cloud.iam.credentials.v1.SignJwtRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSignJwtMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * A service account is a special type of Google account that belongs to your
   * application or a virtual machine (VM), instead of to an individual end user.
   * Your application assumes the identity of the service account to call Google
   * APIs, so that the users aren't directly involved.
   * Service account credentials are used to temporarily assume the identity
   * of the service account. Supported credential types include OAuth 2.0 access
   * tokens, OpenID Connect ID tokens, self-signed JSON Web Tokens (JWTs), and
   * more.
   * </pre>
   */
  public static final class IAMCredentialsFutureStub extends io.grpc.stub.AbstractFutureStub<IAMCredentialsFutureStub> {
    private IAMCredentialsFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IAMCredentialsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IAMCredentialsFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Generates an OAuth 2.0 access token for a service account.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.iam.credentials.v1.GenerateAccessTokenResponse> generateAccessToken(
        com.google.cloud.iam.credentials.v1.GenerateAccessTokenRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateAccessTokenMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Generates an OpenID Connect ID token for a service account.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.iam.credentials.v1.GenerateIdTokenResponse> generateIdToken(
        com.google.cloud.iam.credentials.v1.GenerateIdTokenRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateIdTokenMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Signs a blob using a service account's system-managed private key.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.iam.credentials.v1.SignBlobResponse> signBlob(
        com.google.cloud.iam.credentials.v1.SignBlobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSignBlobMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Signs a JWT using a service account's system-managed private key.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.iam.credentials.v1.SignJwtResponse> signJwt(
        com.google.cloud.iam.credentials.v1.SignJwtRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSignJwtMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GENERATE_ACCESS_TOKEN = 0;
  private static final int METHODID_GENERATE_ID_TOKEN = 1;
  private static final int METHODID_SIGN_BLOB = 2;
  private static final int METHODID_SIGN_JWT = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final IAMCredentialsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(IAMCredentialsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GENERATE_ACCESS_TOKEN:
          serviceImpl.generateAccessToken((com.google.cloud.iam.credentials.v1.GenerateAccessTokenRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.iam.credentials.v1.GenerateAccessTokenResponse>) responseObserver);
          break;
        case METHODID_GENERATE_ID_TOKEN:
          serviceImpl.generateIdToken((com.google.cloud.iam.credentials.v1.GenerateIdTokenRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.iam.credentials.v1.GenerateIdTokenResponse>) responseObserver);
          break;
        case METHODID_SIGN_BLOB:
          serviceImpl.signBlob((com.google.cloud.iam.credentials.v1.SignBlobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.iam.credentials.v1.SignBlobResponse>) responseObserver);
          break;
        case METHODID_SIGN_JWT:
          serviceImpl.signJwt((com.google.cloud.iam.credentials.v1.SignJwtRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.iam.credentials.v1.SignJwtResponse>) responseObserver);
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

  private static abstract class IAMCredentialsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    IAMCredentialsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.iam.credentials.v1.IAMCredentialsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("IAMCredentials");
    }
  }

  private static final class IAMCredentialsFileDescriptorSupplier
      extends IAMCredentialsBaseDescriptorSupplier {
    IAMCredentialsFileDescriptorSupplier() {}
  }

  private static final class IAMCredentialsMethodDescriptorSupplier
      extends IAMCredentialsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    IAMCredentialsMethodDescriptorSupplier(String methodName) {
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
      synchronized (IAMCredentialsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new IAMCredentialsFileDescriptorSupplier())
              .addMethod(getGenerateAccessTokenMethod())
              .addMethod(getGenerateIdTokenMethod())
              .addMethod(getSignBlobMethod())
              .addMethod(getSignJwtMethod())
              .build();
        }
      }
    }
    return result;
  }
}
