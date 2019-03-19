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
 * A service that handles profile management, including profile CRUD,
 * enumeration and search.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/cloud/talent/v4beta1/profile_service.proto")
public final class ProfileServiceGrpc {

  private ProfileServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.talent.v4beta1.ProfileService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListProfilesMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.ListProfilesRequest,
          com.google.cloud.talent.v4beta1.ListProfilesResponse>
      METHOD_LIST_PROFILES = getListProfilesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.ListProfilesRequest,
          com.google.cloud.talent.v4beta1.ListProfilesResponse>
      getListProfilesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.ListProfilesRequest,
          com.google.cloud.talent.v4beta1.ListProfilesResponse>
      getListProfilesMethod() {
    return getListProfilesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.ListProfilesRequest,
          com.google.cloud.talent.v4beta1.ListProfilesResponse>
      getListProfilesMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.talent.v4beta1.ListProfilesRequest,
            com.google.cloud.talent.v4beta1.ListProfilesResponse>
        getListProfilesMethod;
    if ((getListProfilesMethod = ProfileServiceGrpc.getListProfilesMethod) == null) {
      synchronized (ProfileServiceGrpc.class) {
        if ((getListProfilesMethod = ProfileServiceGrpc.getListProfilesMethod) == null) {
          ProfileServiceGrpc.getListProfilesMethod =
              getListProfilesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.talent.v4beta1.ListProfilesRequest,
                          com.google.cloud.talent.v4beta1.ListProfilesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.talent.v4beta1.ProfileService", "ListProfiles"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.ListProfilesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.ListProfilesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProfileServiceMethodDescriptorSupplier("ListProfiles"))
                      .build();
        }
      }
    }
    return getListProfilesMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateProfileMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.CreateProfileRequest,
          com.google.cloud.talent.v4beta1.Profile>
      METHOD_CREATE_PROFILE = getCreateProfileMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.CreateProfileRequest,
          com.google.cloud.talent.v4beta1.Profile>
      getCreateProfileMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.CreateProfileRequest,
          com.google.cloud.talent.v4beta1.Profile>
      getCreateProfileMethod() {
    return getCreateProfileMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.CreateProfileRequest,
          com.google.cloud.talent.v4beta1.Profile>
      getCreateProfileMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.talent.v4beta1.CreateProfileRequest,
            com.google.cloud.talent.v4beta1.Profile>
        getCreateProfileMethod;
    if ((getCreateProfileMethod = ProfileServiceGrpc.getCreateProfileMethod) == null) {
      synchronized (ProfileServiceGrpc.class) {
        if ((getCreateProfileMethod = ProfileServiceGrpc.getCreateProfileMethod) == null) {
          ProfileServiceGrpc.getCreateProfileMethod =
              getCreateProfileMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.talent.v4beta1.CreateProfileRequest,
                          com.google.cloud.talent.v4beta1.Profile>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.talent.v4beta1.ProfileService", "CreateProfile"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.CreateProfileRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.Profile.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProfileServiceMethodDescriptorSupplier("CreateProfile"))
                      .build();
        }
      }
    }
    return getCreateProfileMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetProfileMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.GetProfileRequest,
          com.google.cloud.talent.v4beta1.Profile>
      METHOD_GET_PROFILE = getGetProfileMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.GetProfileRequest,
          com.google.cloud.talent.v4beta1.Profile>
      getGetProfileMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.GetProfileRequest,
          com.google.cloud.talent.v4beta1.Profile>
      getGetProfileMethod() {
    return getGetProfileMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.GetProfileRequest,
          com.google.cloud.talent.v4beta1.Profile>
      getGetProfileMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.talent.v4beta1.GetProfileRequest,
            com.google.cloud.talent.v4beta1.Profile>
        getGetProfileMethod;
    if ((getGetProfileMethod = ProfileServiceGrpc.getGetProfileMethod) == null) {
      synchronized (ProfileServiceGrpc.class) {
        if ((getGetProfileMethod = ProfileServiceGrpc.getGetProfileMethod) == null) {
          ProfileServiceGrpc.getGetProfileMethod =
              getGetProfileMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.talent.v4beta1.GetProfileRequest,
                          com.google.cloud.talent.v4beta1.Profile>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.talent.v4beta1.ProfileService", "GetProfile"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.GetProfileRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.Profile.getDefaultInstance()))
                      .setSchemaDescriptor(new ProfileServiceMethodDescriptorSupplier("GetProfile"))
                      .build();
        }
      }
    }
    return getGetProfileMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateProfileMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.UpdateProfileRequest,
          com.google.cloud.talent.v4beta1.Profile>
      METHOD_UPDATE_PROFILE = getUpdateProfileMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.UpdateProfileRequest,
          com.google.cloud.talent.v4beta1.Profile>
      getUpdateProfileMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.UpdateProfileRequest,
          com.google.cloud.talent.v4beta1.Profile>
      getUpdateProfileMethod() {
    return getUpdateProfileMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.UpdateProfileRequest,
          com.google.cloud.talent.v4beta1.Profile>
      getUpdateProfileMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.talent.v4beta1.UpdateProfileRequest,
            com.google.cloud.talent.v4beta1.Profile>
        getUpdateProfileMethod;
    if ((getUpdateProfileMethod = ProfileServiceGrpc.getUpdateProfileMethod) == null) {
      synchronized (ProfileServiceGrpc.class) {
        if ((getUpdateProfileMethod = ProfileServiceGrpc.getUpdateProfileMethod) == null) {
          ProfileServiceGrpc.getUpdateProfileMethod =
              getUpdateProfileMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.talent.v4beta1.UpdateProfileRequest,
                          com.google.cloud.talent.v4beta1.Profile>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.talent.v4beta1.ProfileService", "UpdateProfile"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.UpdateProfileRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.Profile.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProfileServiceMethodDescriptorSupplier("UpdateProfile"))
                      .build();
        }
      }
    }
    return getUpdateProfileMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteProfileMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.DeleteProfileRequest, com.google.protobuf.Empty>
      METHOD_DELETE_PROFILE = getDeleteProfileMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.DeleteProfileRequest, com.google.protobuf.Empty>
      getDeleteProfileMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.DeleteProfileRequest, com.google.protobuf.Empty>
      getDeleteProfileMethod() {
    return getDeleteProfileMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.DeleteProfileRequest, com.google.protobuf.Empty>
      getDeleteProfileMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.talent.v4beta1.DeleteProfileRequest, com.google.protobuf.Empty>
        getDeleteProfileMethod;
    if ((getDeleteProfileMethod = ProfileServiceGrpc.getDeleteProfileMethod) == null) {
      synchronized (ProfileServiceGrpc.class) {
        if ((getDeleteProfileMethod = ProfileServiceGrpc.getDeleteProfileMethod) == null) {
          ProfileServiceGrpc.getDeleteProfileMethod =
              getDeleteProfileMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.talent.v4beta1.DeleteProfileRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.talent.v4beta1.ProfileService", "DeleteProfile"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.DeleteProfileRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProfileServiceMethodDescriptorSupplier("DeleteProfile"))
                      .build();
        }
      }
    }
    return getDeleteProfileMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSearchProfilesMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.SearchProfilesRequest,
          com.google.cloud.talent.v4beta1.SearchProfilesResponse>
      METHOD_SEARCH_PROFILES = getSearchProfilesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.SearchProfilesRequest,
          com.google.cloud.talent.v4beta1.SearchProfilesResponse>
      getSearchProfilesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.SearchProfilesRequest,
          com.google.cloud.talent.v4beta1.SearchProfilesResponse>
      getSearchProfilesMethod() {
    return getSearchProfilesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.SearchProfilesRequest,
          com.google.cloud.talent.v4beta1.SearchProfilesResponse>
      getSearchProfilesMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.talent.v4beta1.SearchProfilesRequest,
            com.google.cloud.talent.v4beta1.SearchProfilesResponse>
        getSearchProfilesMethod;
    if ((getSearchProfilesMethod = ProfileServiceGrpc.getSearchProfilesMethod) == null) {
      synchronized (ProfileServiceGrpc.class) {
        if ((getSearchProfilesMethod = ProfileServiceGrpc.getSearchProfilesMethod) == null) {
          ProfileServiceGrpc.getSearchProfilesMethod =
              getSearchProfilesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.talent.v4beta1.SearchProfilesRequest,
                          com.google.cloud.talent.v4beta1.SearchProfilesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.talent.v4beta1.ProfileService", "SearchProfiles"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.SearchProfilesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.SearchProfilesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProfileServiceMethodDescriptorSupplier("SearchProfiles"))
                      .build();
        }
      }
    }
    return getSearchProfilesMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ProfileServiceStub newStub(io.grpc.Channel channel) {
    return new ProfileServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProfileServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new ProfileServiceBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ProfileServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    return new ProfileServiceFutureStub(channel);
  }

  /**
   *
   *
   * <pre>
   * A service that handles profile management, including profile CRUD,
   * enumeration and search.
   * </pre>
   */
  public abstract static class ProfileServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Lists profiles by filter. The order is unspecified.
     * </pre>
     */
    public void listProfiles(
        com.google.cloud.talent.v4beta1.ListProfilesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.ListProfilesResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListProfilesMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates and returns a new profile.
     * </pre>
     */
    public void createProfile(
        com.google.cloud.talent.v4beta1.CreateProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.Profile> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateProfileMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the specified profile.
     * </pre>
     */
    public void getProfile(
        com.google.cloud.talent.v4beta1.GetProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.Profile> responseObserver) {
      asyncUnimplementedUnaryCall(getGetProfileMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified profile and returns the updated result.
     * </pre>
     */
    public void updateProfile(
        com.google.cloud.talent.v4beta1.UpdateProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.Profile> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateProfileMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified profile.
     * </pre>
     */
    public void deleteProfile(
        com.google.cloud.talent.v4beta1.DeleteProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteProfileMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches for profiles within a tenant.
     * For example, search by raw queries "software engineer in Mountain View" or
     * search by structured filters (location filter, education filter, etc.).
     * See
     * [SearchProfilesRequest][google.cloud.talent.v4beta1.SearchProfilesRequest]
     * for more information.
     * </pre>
     */
    public void searchProfiles(
        com.google.cloud.talent.v4beta1.SearchProfilesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.SearchProfilesResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getSearchProfilesMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListProfilesMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.talent.v4beta1.ListProfilesRequest,
                      com.google.cloud.talent.v4beta1.ListProfilesResponse>(
                      this, METHODID_LIST_PROFILES)))
          .addMethod(
              getCreateProfileMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.talent.v4beta1.CreateProfileRequest,
                      com.google.cloud.talent.v4beta1.Profile>(this, METHODID_CREATE_PROFILE)))
          .addMethod(
              getGetProfileMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.talent.v4beta1.GetProfileRequest,
                      com.google.cloud.talent.v4beta1.Profile>(this, METHODID_GET_PROFILE)))
          .addMethod(
              getUpdateProfileMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.talent.v4beta1.UpdateProfileRequest,
                      com.google.cloud.talent.v4beta1.Profile>(this, METHODID_UPDATE_PROFILE)))
          .addMethod(
              getDeleteProfileMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.talent.v4beta1.DeleteProfileRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_PROFILE)))
          .addMethod(
              getSearchProfilesMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.talent.v4beta1.SearchProfilesRequest,
                      com.google.cloud.talent.v4beta1.SearchProfilesResponse>(
                      this, METHODID_SEARCH_PROFILES)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * A service that handles profile management, including profile CRUD,
   * enumeration and search.
   * </pre>
   */
  public static final class ProfileServiceStub
      extends io.grpc.stub.AbstractStub<ProfileServiceStub> {
    private ProfileServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProfileServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProfileServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProfileServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists profiles by filter. The order is unspecified.
     * </pre>
     */
    public void listProfiles(
        com.google.cloud.talent.v4beta1.ListProfilesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.ListProfilesResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListProfilesMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates and returns a new profile.
     * </pre>
     */
    public void createProfile(
        com.google.cloud.talent.v4beta1.CreateProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.Profile> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateProfileMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the specified profile.
     * </pre>
     */
    public void getProfile(
        com.google.cloud.talent.v4beta1.GetProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.Profile> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetProfileMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified profile and returns the updated result.
     * </pre>
     */
    public void updateProfile(
        com.google.cloud.talent.v4beta1.UpdateProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.Profile> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateProfileMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified profile.
     * </pre>
     */
    public void deleteProfile(
        com.google.cloud.talent.v4beta1.DeleteProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteProfileMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches for profiles within a tenant.
     * For example, search by raw queries "software engineer in Mountain View" or
     * search by structured filters (location filter, education filter, etc.).
     * See
     * [SearchProfilesRequest][google.cloud.talent.v4beta1.SearchProfilesRequest]
     * for more information.
     * </pre>
     */
    public void searchProfiles(
        com.google.cloud.talent.v4beta1.SearchProfilesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.SearchProfilesResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSearchProfilesMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * A service that handles profile management, including profile CRUD,
   * enumeration and search.
   * </pre>
   */
  public static final class ProfileServiceBlockingStub
      extends io.grpc.stub.AbstractStub<ProfileServiceBlockingStub> {
    private ProfileServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProfileServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProfileServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProfileServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists profiles by filter. The order is unspecified.
     * </pre>
     */
    public com.google.cloud.talent.v4beta1.ListProfilesResponse listProfiles(
        com.google.cloud.talent.v4beta1.ListProfilesRequest request) {
      return blockingUnaryCall(
          getChannel(), getListProfilesMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates and returns a new profile.
     * </pre>
     */
    public com.google.cloud.talent.v4beta1.Profile createProfile(
        com.google.cloud.talent.v4beta1.CreateProfileRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateProfileMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the specified profile.
     * </pre>
     */
    public com.google.cloud.talent.v4beta1.Profile getProfile(
        com.google.cloud.talent.v4beta1.GetProfileRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetProfileMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified profile and returns the updated result.
     * </pre>
     */
    public com.google.cloud.talent.v4beta1.Profile updateProfile(
        com.google.cloud.talent.v4beta1.UpdateProfileRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateProfileMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified profile.
     * </pre>
     */
    public com.google.protobuf.Empty deleteProfile(
        com.google.cloud.talent.v4beta1.DeleteProfileRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteProfileMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Searches for profiles within a tenant.
     * For example, search by raw queries "software engineer in Mountain View" or
     * search by structured filters (location filter, education filter, etc.).
     * See
     * [SearchProfilesRequest][google.cloud.talent.v4beta1.SearchProfilesRequest]
     * for more information.
     * </pre>
     */
    public com.google.cloud.talent.v4beta1.SearchProfilesResponse searchProfiles(
        com.google.cloud.talent.v4beta1.SearchProfilesRequest request) {
      return blockingUnaryCall(
          getChannel(), getSearchProfilesMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * A service that handles profile management, including profile CRUD,
   * enumeration and search.
   * </pre>
   */
  public static final class ProfileServiceFutureStub
      extends io.grpc.stub.AbstractStub<ProfileServiceFutureStub> {
    private ProfileServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProfileServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProfileServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProfileServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists profiles by filter. The order is unspecified.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.talent.v4beta1.ListProfilesResponse>
        listProfiles(com.google.cloud.talent.v4beta1.ListProfilesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListProfilesMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates and returns a new profile.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.talent.v4beta1.Profile>
        createProfile(com.google.cloud.talent.v4beta1.CreateProfileRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateProfileMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the specified profile.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.talent.v4beta1.Profile>
        getProfile(com.google.cloud.talent.v4beta1.GetProfileRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetProfileMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified profile and returns the updated result.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.talent.v4beta1.Profile>
        updateProfile(com.google.cloud.talent.v4beta1.UpdateProfileRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateProfileMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified profile.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteProfile(com.google.cloud.talent.v4beta1.DeleteProfileRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteProfileMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Searches for profiles within a tenant.
     * For example, search by raw queries "software engineer in Mountain View" or
     * search by structured filters (location filter, education filter, etc.).
     * See
     * [SearchProfilesRequest][google.cloud.talent.v4beta1.SearchProfilesRequest]
     * for more information.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.talent.v4beta1.SearchProfilesResponse>
        searchProfiles(com.google.cloud.talent.v4beta1.SearchProfilesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSearchProfilesMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_PROFILES = 0;
  private static final int METHODID_CREATE_PROFILE = 1;
  private static final int METHODID_GET_PROFILE = 2;
  private static final int METHODID_UPDATE_PROFILE = 3;
  private static final int METHODID_DELETE_PROFILE = 4;
  private static final int METHODID_SEARCH_PROFILES = 5;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ProfileServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ProfileServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_PROFILES:
          serviceImpl.listProfiles(
              (com.google.cloud.talent.v4beta1.ListProfilesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.ListProfilesResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_PROFILE:
          serviceImpl.createProfile(
              (com.google.cloud.talent.v4beta1.CreateProfileRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.Profile>)
                  responseObserver);
          break;
        case METHODID_GET_PROFILE:
          serviceImpl.getProfile(
              (com.google.cloud.talent.v4beta1.GetProfileRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.Profile>)
                  responseObserver);
          break;
        case METHODID_UPDATE_PROFILE:
          serviceImpl.updateProfile(
              (com.google.cloud.talent.v4beta1.UpdateProfileRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.Profile>)
                  responseObserver);
          break;
        case METHODID_DELETE_PROFILE:
          serviceImpl.deleteProfile(
              (com.google.cloud.talent.v4beta1.DeleteProfileRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_SEARCH_PROFILES:
          serviceImpl.searchProfiles(
              (com.google.cloud.talent.v4beta1.SearchProfilesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.SearchProfilesResponse>)
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

  private abstract static class ProfileServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProfileServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.talent.v4beta1.ProfileServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ProfileService");
    }
  }

  private static final class ProfileServiceFileDescriptorSupplier
      extends ProfileServiceBaseDescriptorSupplier {
    ProfileServiceFileDescriptorSupplier() {}
  }

  private static final class ProfileServiceMethodDescriptorSupplier
      extends ProfileServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ProfileServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ProfileServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ProfileServiceFileDescriptorSupplier())
                      .addMethod(getListProfilesMethodHelper())
                      .addMethod(getCreateProfileMethodHelper())
                      .addMethod(getGetProfileMethodHelper())
                      .addMethod(getUpdateProfileMethodHelper())
                      .addMethod(getDeleteProfileMethodHelper())
                      .addMethod(getSearchProfilesMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
