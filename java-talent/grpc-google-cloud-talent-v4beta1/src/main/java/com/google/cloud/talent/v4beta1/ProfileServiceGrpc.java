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
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/talent/v4beta1/profile_service.proto")
public final class ProfileServiceGrpc {

  private ProfileServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.talent.v4beta1.ProfileService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.ListProfilesRequest,
          com.google.cloud.talent.v4beta1.ListProfilesResponse>
      getListProfilesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListProfiles",
      requestType = com.google.cloud.talent.v4beta1.ListProfilesRequest.class,
      responseType = com.google.cloud.talent.v4beta1.ListProfilesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.ListProfilesRequest,
          com.google.cloud.talent.v4beta1.ListProfilesResponse>
      getListProfilesMethod() {
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
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListProfiles"))
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.CreateProfileRequest,
          com.google.cloud.talent.v4beta1.Profile>
      getCreateProfileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateProfile",
      requestType = com.google.cloud.talent.v4beta1.CreateProfileRequest.class,
      responseType = com.google.cloud.talent.v4beta1.Profile.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.CreateProfileRequest,
          com.google.cloud.talent.v4beta1.Profile>
      getCreateProfileMethod() {
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
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateProfile"))
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.GetProfileRequest,
          com.google.cloud.talent.v4beta1.Profile>
      getGetProfileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetProfile",
      requestType = com.google.cloud.talent.v4beta1.GetProfileRequest.class,
      responseType = com.google.cloud.talent.v4beta1.Profile.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.GetProfileRequest,
          com.google.cloud.talent.v4beta1.Profile>
      getGetProfileMethod() {
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
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetProfile"))
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.UpdateProfileRequest,
          com.google.cloud.talent.v4beta1.Profile>
      getUpdateProfileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateProfile",
      requestType = com.google.cloud.talent.v4beta1.UpdateProfileRequest.class,
      responseType = com.google.cloud.talent.v4beta1.Profile.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.UpdateProfileRequest,
          com.google.cloud.talent.v4beta1.Profile>
      getUpdateProfileMethod() {
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
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateProfile"))
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.DeleteProfileRequest, com.google.protobuf.Empty>
      getDeleteProfileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteProfile",
      requestType = com.google.cloud.talent.v4beta1.DeleteProfileRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.DeleteProfileRequest, com.google.protobuf.Empty>
      getDeleteProfileMethod() {
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
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteProfile"))
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.SearchProfilesRequest,
          com.google.cloud.talent.v4beta1.SearchProfilesResponse>
      getSearchProfilesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchProfiles",
      requestType = com.google.cloud.talent.v4beta1.SearchProfilesRequest.class,
      responseType = com.google.cloud.talent.v4beta1.SearchProfilesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.SearchProfilesRequest,
          com.google.cloud.talent.v4beta1.SearchProfilesResponse>
      getSearchProfilesMethod() {
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
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchProfiles"))
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
    io.grpc.stub.AbstractStub.StubFactory<ProfileServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ProfileServiceStub>() {
          @java.lang.Override
          public ProfileServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ProfileServiceStub(channel, callOptions);
          }
        };
    return ProfileServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProfileServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProfileServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ProfileServiceBlockingStub>() {
          @java.lang.Override
          public ProfileServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ProfileServiceBlockingStub(channel, callOptions);
          }
        };
    return ProfileServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ProfileServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProfileServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ProfileServiceFutureStub>() {
          @java.lang.Override
          public ProfileServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ProfileServiceFutureStub(channel, callOptions);
          }
        };
    return ProfileServiceFutureStub.newStub(factory, channel);
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
      asyncUnimplementedUnaryCall(getListProfilesMethod(), responseObserver);
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
      asyncUnimplementedUnaryCall(getCreateProfileMethod(), responseObserver);
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
      asyncUnimplementedUnaryCall(getGetProfileMethod(), responseObserver);
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
      asyncUnimplementedUnaryCall(getUpdateProfileMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified profile.
     * Prerequisite: The profile has no associated applications or assignments
     * associated.
     * </pre>
     */
    public void deleteProfile(
        com.google.cloud.talent.v4beta1.DeleteProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteProfileMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches for profiles within a tenant.
     * For example, search by raw queries "software engineer in Mountain View" or
     * search by structured filters (location filter, education filter, etc.).
     * See [SearchProfilesRequest][google.cloud.talent.v4beta1.SearchProfilesRequest] for more information.
     * </pre>
     */
    public void searchProfiles(
        com.google.cloud.talent.v4beta1.SearchProfilesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.SearchProfilesResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getSearchProfilesMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListProfilesMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.talent.v4beta1.ListProfilesRequest,
                      com.google.cloud.talent.v4beta1.ListProfilesResponse>(
                      this, METHODID_LIST_PROFILES)))
          .addMethod(
              getCreateProfileMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.talent.v4beta1.CreateProfileRequest,
                      com.google.cloud.talent.v4beta1.Profile>(this, METHODID_CREATE_PROFILE)))
          .addMethod(
              getGetProfileMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.talent.v4beta1.GetProfileRequest,
                      com.google.cloud.talent.v4beta1.Profile>(this, METHODID_GET_PROFILE)))
          .addMethod(
              getUpdateProfileMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.talent.v4beta1.UpdateProfileRequest,
                      com.google.cloud.talent.v4beta1.Profile>(this, METHODID_UPDATE_PROFILE)))
          .addMethod(
              getDeleteProfileMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.talent.v4beta1.DeleteProfileRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_PROFILE)))
          .addMethod(
              getSearchProfilesMethod(),
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
      extends io.grpc.stub.AbstractAsyncStub<ProfileServiceStub> {
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
          getChannel().newCall(getListProfilesMethod(), getCallOptions()),
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
          getChannel().newCall(getCreateProfileMethod(), getCallOptions()),
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
          getChannel().newCall(getGetProfileMethod(), getCallOptions()), request, responseObserver);
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
          getChannel().newCall(getUpdateProfileMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified profile.
     * Prerequisite: The profile has no associated applications or assignments
     * associated.
     * </pre>
     */
    public void deleteProfile(
        com.google.cloud.talent.v4beta1.DeleteProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteProfileMethod(), getCallOptions()),
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
     * See [SearchProfilesRequest][google.cloud.talent.v4beta1.SearchProfilesRequest] for more information.
     * </pre>
     */
    public void searchProfiles(
        com.google.cloud.talent.v4beta1.SearchProfilesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.SearchProfilesResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSearchProfilesMethod(), getCallOptions()),
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
      extends io.grpc.stub.AbstractBlockingStub<ProfileServiceBlockingStub> {
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
      return blockingUnaryCall(getChannel(), getListProfilesMethod(), getCallOptions(), request);
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
      return blockingUnaryCall(getChannel(), getCreateProfileMethod(), getCallOptions(), request);
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
      return blockingUnaryCall(getChannel(), getGetProfileMethod(), getCallOptions(), request);
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
      return blockingUnaryCall(getChannel(), getUpdateProfileMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified profile.
     * Prerequisite: The profile has no associated applications or assignments
     * associated.
     * </pre>
     */
    public com.google.protobuf.Empty deleteProfile(
        com.google.cloud.talent.v4beta1.DeleteProfileRequest request) {
      return blockingUnaryCall(getChannel(), getDeleteProfileMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Searches for profiles within a tenant.
     * For example, search by raw queries "software engineer in Mountain View" or
     * search by structured filters (location filter, education filter, etc.).
     * See [SearchProfilesRequest][google.cloud.talent.v4beta1.SearchProfilesRequest] for more information.
     * </pre>
     */
    public com.google.cloud.talent.v4beta1.SearchProfilesResponse searchProfiles(
        com.google.cloud.talent.v4beta1.SearchProfilesRequest request) {
      return blockingUnaryCall(getChannel(), getSearchProfilesMethod(), getCallOptions(), request);
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
      extends io.grpc.stub.AbstractFutureStub<ProfileServiceFutureStub> {
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
          getChannel().newCall(getListProfilesMethod(), getCallOptions()), request);
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
          getChannel().newCall(getCreateProfileMethod(), getCallOptions()), request);
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
          getChannel().newCall(getGetProfileMethod(), getCallOptions()), request);
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
          getChannel().newCall(getUpdateProfileMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified profile.
     * Prerequisite: The profile has no associated applications or assignments
     * associated.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteProfile(com.google.cloud.talent.v4beta1.DeleteProfileRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteProfileMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Searches for profiles within a tenant.
     * For example, search by raw queries "software engineer in Mountain View" or
     * search by structured filters (location filter, education filter, etc.).
     * See [SearchProfilesRequest][google.cloud.talent.v4beta1.SearchProfilesRequest] for more information.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.talent.v4beta1.SearchProfilesResponse>
        searchProfiles(com.google.cloud.talent.v4beta1.SearchProfilesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSearchProfilesMethod(), getCallOptions()), request);
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
                      .addMethod(getListProfilesMethod())
                      .addMethod(getCreateProfileMethod())
                      .addMethod(getGetProfileMethod())
                      .addMethod(getUpdateProfileMethod())
                      .addMethod(getDeleteProfileMethod())
                      .addMethod(getSearchProfilesMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
