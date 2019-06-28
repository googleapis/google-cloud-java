package com.google.cloud.iam.credentials.v1;

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
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/iam/credentials/v1/iamcredentials.proto")
public final class IAMCredentialsGrpc {

  private IAMCredentialsGrpc() {}

  public static final String SERVICE_NAME = "google.iam.credentials.v1.IAMCredentials";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGenerateAccessTokenMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.iam.credentials.v1.GenerateAccessTokenRequest,
          com.google.cloud.iam.credentials.v1.GenerateAccessTokenResponse>
      METHOD_GENERATE_ACCESS_TOKEN = getGenerateAccessTokenMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.iam.credentials.v1.GenerateAccessTokenRequest,
          com.google.cloud.iam.credentials.v1.GenerateAccessTokenResponse>
      getGenerateAccessTokenMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.iam.credentials.v1.GenerateAccessTokenRequest,
          com.google.cloud.iam.credentials.v1.GenerateAccessTokenResponse>
      getGenerateAccessTokenMethod() {
    return getGenerateAccessTokenMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.iam.credentials.v1.GenerateAccessTokenRequest,
          com.google.cloud.iam.credentials.v1.GenerateAccessTokenResponse>
      getGenerateAccessTokenMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.iam.credentials.v1.GenerateAccessTokenRequest,
            com.google.cloud.iam.credentials.v1.GenerateAccessTokenResponse>
        getGenerateAccessTokenMethod;
    if ((getGenerateAccessTokenMethod = IAMCredentialsGrpc.getGenerateAccessTokenMethod) == null) {
      synchronized (IAMCredentialsGrpc.class) {
        if ((getGenerateAccessTokenMethod = IAMCredentialsGrpc.getGenerateAccessTokenMethod)
            == null) {
          IAMCredentialsGrpc.getGenerateAccessTokenMethod =
              getGenerateAccessTokenMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.iam.credentials.v1.GenerateAccessTokenRequest,
                          com.google.cloud.iam.credentials.v1.GenerateAccessTokenResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.iam.credentials.v1.IAMCredentials", "GenerateAccessToken"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iam.credentials.v1.GenerateAccessTokenRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iam.credentials.v1.GenerateAccessTokenResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IAMCredentialsMethodDescriptorSupplier("GenerateAccessToken"))
                      .build();
        }
      }
    }
    return getGenerateAccessTokenMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGenerateIdTokenMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.iam.credentials.v1.GenerateIdTokenRequest,
          com.google.cloud.iam.credentials.v1.GenerateIdTokenResponse>
      METHOD_GENERATE_ID_TOKEN = getGenerateIdTokenMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.iam.credentials.v1.GenerateIdTokenRequest,
          com.google.cloud.iam.credentials.v1.GenerateIdTokenResponse>
      getGenerateIdTokenMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.iam.credentials.v1.GenerateIdTokenRequest,
          com.google.cloud.iam.credentials.v1.GenerateIdTokenResponse>
      getGenerateIdTokenMethod() {
    return getGenerateIdTokenMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.iam.credentials.v1.GenerateIdTokenRequest,
          com.google.cloud.iam.credentials.v1.GenerateIdTokenResponse>
      getGenerateIdTokenMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.iam.credentials.v1.GenerateIdTokenRequest,
            com.google.cloud.iam.credentials.v1.GenerateIdTokenResponse>
        getGenerateIdTokenMethod;
    if ((getGenerateIdTokenMethod = IAMCredentialsGrpc.getGenerateIdTokenMethod) == null) {
      synchronized (IAMCredentialsGrpc.class) {
        if ((getGenerateIdTokenMethod = IAMCredentialsGrpc.getGenerateIdTokenMethod) == null) {
          IAMCredentialsGrpc.getGenerateIdTokenMethod =
              getGenerateIdTokenMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.iam.credentials.v1.GenerateIdTokenRequest,
                          com.google.cloud.iam.credentials.v1.GenerateIdTokenResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.iam.credentials.v1.IAMCredentials", "GenerateIdToken"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iam.credentials.v1.GenerateIdTokenRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iam.credentials.v1.GenerateIdTokenResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IAMCredentialsMethodDescriptorSupplier("GenerateIdToken"))
                      .build();
        }
      }
    }
    return getGenerateIdTokenMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSignBlobMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.iam.credentials.v1.SignBlobRequest,
          com.google.cloud.iam.credentials.v1.SignBlobResponse>
      METHOD_SIGN_BLOB = getSignBlobMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.iam.credentials.v1.SignBlobRequest,
          com.google.cloud.iam.credentials.v1.SignBlobResponse>
      getSignBlobMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.iam.credentials.v1.SignBlobRequest,
          com.google.cloud.iam.credentials.v1.SignBlobResponse>
      getSignBlobMethod() {
    return getSignBlobMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.iam.credentials.v1.SignBlobRequest,
          com.google.cloud.iam.credentials.v1.SignBlobResponse>
      getSignBlobMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.iam.credentials.v1.SignBlobRequest,
            com.google.cloud.iam.credentials.v1.SignBlobResponse>
        getSignBlobMethod;
    if ((getSignBlobMethod = IAMCredentialsGrpc.getSignBlobMethod) == null) {
      synchronized (IAMCredentialsGrpc.class) {
        if ((getSignBlobMethod = IAMCredentialsGrpc.getSignBlobMethod) == null) {
          IAMCredentialsGrpc.getSignBlobMethod =
              getSignBlobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.iam.credentials.v1.SignBlobRequest,
                          com.google.cloud.iam.credentials.v1.SignBlobResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.iam.credentials.v1.IAMCredentials", "SignBlob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iam.credentials.v1.SignBlobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iam.credentials.v1.SignBlobResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new IAMCredentialsMethodDescriptorSupplier("SignBlob"))
                      .build();
        }
      }
    }
    return getSignBlobMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSignJwtMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.iam.credentials.v1.SignJwtRequest,
          com.google.cloud.iam.credentials.v1.SignJwtResponse>
      METHOD_SIGN_JWT = getSignJwtMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.iam.credentials.v1.SignJwtRequest,
          com.google.cloud.iam.credentials.v1.SignJwtResponse>
      getSignJwtMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.iam.credentials.v1.SignJwtRequest,
          com.google.cloud.iam.credentials.v1.SignJwtResponse>
      getSignJwtMethod() {
    return getSignJwtMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.iam.credentials.v1.SignJwtRequest,
          com.google.cloud.iam.credentials.v1.SignJwtResponse>
      getSignJwtMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.iam.credentials.v1.SignJwtRequest,
            com.google.cloud.iam.credentials.v1.SignJwtResponse>
        getSignJwtMethod;
    if ((getSignJwtMethod = IAMCredentialsGrpc.getSignJwtMethod) == null) {
      synchronized (IAMCredentialsGrpc.class) {
        if ((getSignJwtMethod = IAMCredentialsGrpc.getSignJwtMethod) == null) {
          IAMCredentialsGrpc.getSignJwtMethod =
              getSignJwtMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.iam.credentials.v1.SignJwtRequest,
                          com.google.cloud.iam.credentials.v1.SignJwtResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.iam.credentials.v1.IAMCredentials", "SignJwt"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iam.credentials.v1.SignJwtRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iam.credentials.v1.SignJwtResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new IAMCredentialsMethodDescriptorSupplier("SignJwt"))
                      .build();
        }
      }
    }
    return getSignJwtMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static IAMCredentialsStub newStub(io.grpc.Channel channel) {
    return new IAMCredentialsStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static IAMCredentialsBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new IAMCredentialsBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static IAMCredentialsFutureStub newFutureStub(io.grpc.Channel channel) {
    return new IAMCredentialsFutureStub(channel);
  }

  /**
   *
   *
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
  public abstract static class IAMCredentialsImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Generates an OAuth 2.0 access token for a service account.
     * </pre>
     */
    public void generateAccessToken(
        com.google.cloud.iam.credentials.v1.GenerateAccessTokenRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iam.credentials.v1.GenerateAccessTokenResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getGenerateAccessTokenMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generates an OpenID Connect ID token for a service account.
     * </pre>
     */
    public void generateIdToken(
        com.google.cloud.iam.credentials.v1.GenerateIdTokenRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iam.credentials.v1.GenerateIdTokenResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getGenerateIdTokenMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Signs a blob using a service account's system-managed private key.
     * </pre>
     */
    public void signBlob(
        com.google.cloud.iam.credentials.v1.SignBlobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iam.credentials.v1.SignBlobResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getSignBlobMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Signs a JWT using a service account's system-managed private key.
     * </pre>
     */
    public void signJwt(
        com.google.cloud.iam.credentials.v1.SignJwtRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iam.credentials.v1.SignJwtResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getSignJwtMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getGenerateAccessTokenMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.iam.credentials.v1.GenerateAccessTokenRequest,
                      com.google.cloud.iam.credentials.v1.GenerateAccessTokenResponse>(
                      this, METHODID_GENERATE_ACCESS_TOKEN)))
          .addMethod(
              getGenerateIdTokenMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.iam.credentials.v1.GenerateIdTokenRequest,
                      com.google.cloud.iam.credentials.v1.GenerateIdTokenResponse>(
                      this, METHODID_GENERATE_ID_TOKEN)))
          .addMethod(
              getSignBlobMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.iam.credentials.v1.SignBlobRequest,
                      com.google.cloud.iam.credentials.v1.SignBlobResponse>(
                      this, METHODID_SIGN_BLOB)))
          .addMethod(
              getSignJwtMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.iam.credentials.v1.SignJwtRequest,
                      com.google.cloud.iam.credentials.v1.SignJwtResponse>(
                      this, METHODID_SIGN_JWT)))
          .build();
    }
  }

  /**
   *
   *
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
  public static final class IAMCredentialsStub
      extends io.grpc.stub.AbstractStub<IAMCredentialsStub> {
    private IAMCredentialsStub(io.grpc.Channel channel) {
      super(channel);
    }

    private IAMCredentialsStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IAMCredentialsStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IAMCredentialsStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Generates an OAuth 2.0 access token for a service account.
     * </pre>
     */
    public void generateAccessToken(
        com.google.cloud.iam.credentials.v1.GenerateAccessTokenRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iam.credentials.v1.GenerateAccessTokenResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGenerateAccessTokenMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generates an OpenID Connect ID token for a service account.
     * </pre>
     */
    public void generateIdToken(
        com.google.cloud.iam.credentials.v1.GenerateIdTokenRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iam.credentials.v1.GenerateIdTokenResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGenerateIdTokenMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Signs a blob using a service account's system-managed private key.
     * </pre>
     */
    public void signBlob(
        com.google.cloud.iam.credentials.v1.SignBlobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iam.credentials.v1.SignBlobResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSignBlobMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Signs a JWT using a service account's system-managed private key.
     * </pre>
     */
    public void signJwt(
        com.google.cloud.iam.credentials.v1.SignJwtRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iam.credentials.v1.SignJwtResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSignJwtMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
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
  public static final class IAMCredentialsBlockingStub
      extends io.grpc.stub.AbstractStub<IAMCredentialsBlockingStub> {
    private IAMCredentialsBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private IAMCredentialsBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IAMCredentialsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IAMCredentialsBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Generates an OAuth 2.0 access token for a service account.
     * </pre>
     */
    public com.google.cloud.iam.credentials.v1.GenerateAccessTokenResponse generateAccessToken(
        com.google.cloud.iam.credentials.v1.GenerateAccessTokenRequest request) {
      return blockingUnaryCall(
          getChannel(), getGenerateAccessTokenMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Generates an OpenID Connect ID token for a service account.
     * </pre>
     */
    public com.google.cloud.iam.credentials.v1.GenerateIdTokenResponse generateIdToken(
        com.google.cloud.iam.credentials.v1.GenerateIdTokenRequest request) {
      return blockingUnaryCall(
          getChannel(), getGenerateIdTokenMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Signs a blob using a service account's system-managed private key.
     * </pre>
     */
    public com.google.cloud.iam.credentials.v1.SignBlobResponse signBlob(
        com.google.cloud.iam.credentials.v1.SignBlobRequest request) {
      return blockingUnaryCall(getChannel(), getSignBlobMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Signs a JWT using a service account's system-managed private key.
     * </pre>
     */
    public com.google.cloud.iam.credentials.v1.SignJwtResponse signJwt(
        com.google.cloud.iam.credentials.v1.SignJwtRequest request) {
      return blockingUnaryCall(getChannel(), getSignJwtMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   *
   *
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
  public static final class IAMCredentialsFutureStub
      extends io.grpc.stub.AbstractStub<IAMCredentialsFutureStub> {
    private IAMCredentialsFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private IAMCredentialsFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IAMCredentialsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IAMCredentialsFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Generates an OAuth 2.0 access token for a service account.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.iam.credentials.v1.GenerateAccessTokenResponse>
        generateAccessToken(
            com.google.cloud.iam.credentials.v1.GenerateAccessTokenRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGenerateAccessTokenMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Generates an OpenID Connect ID token for a service account.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.iam.credentials.v1.GenerateIdTokenResponse>
        generateIdToken(com.google.cloud.iam.credentials.v1.GenerateIdTokenRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGenerateIdTokenMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Signs a blob using a service account's system-managed private key.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.iam.credentials.v1.SignBlobResponse>
        signBlob(com.google.cloud.iam.credentials.v1.SignBlobRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSignBlobMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Signs a JWT using a service account's system-managed private key.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.iam.credentials.v1.SignJwtResponse>
        signJwt(com.google.cloud.iam.credentials.v1.SignJwtRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSignJwtMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GENERATE_ACCESS_TOKEN = 0;
  private static final int METHODID_GENERATE_ID_TOKEN = 1;
  private static final int METHODID_SIGN_BLOB = 2;
  private static final int METHODID_SIGN_JWT = 3;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
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
          serviceImpl.generateAccessToken(
              (com.google.cloud.iam.credentials.v1.GenerateAccessTokenRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.iam.credentials.v1.GenerateAccessTokenResponse>)
                  responseObserver);
          break;
        case METHODID_GENERATE_ID_TOKEN:
          serviceImpl.generateIdToken(
              (com.google.cloud.iam.credentials.v1.GenerateIdTokenRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.iam.credentials.v1.GenerateIdTokenResponse>)
                  responseObserver);
          break;
        case METHODID_SIGN_BLOB:
          serviceImpl.signBlob(
              (com.google.cloud.iam.credentials.v1.SignBlobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.iam.credentials.v1.SignBlobResponse>)
                  responseObserver);
          break;
        case METHODID_SIGN_JWT:
          serviceImpl.signJwt(
              (com.google.cloud.iam.credentials.v1.SignJwtRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.iam.credentials.v1.SignJwtResponse>)
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

  private abstract static class IAMCredentialsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
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
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new IAMCredentialsFileDescriptorSupplier())
                      .addMethod(getGenerateAccessTokenMethodHelper())
                      .addMethod(getGenerateIdTokenMethodHelper())
                      .addMethod(getSignBlobMethodHelper())
                      .addMethod(getSignJwtMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
