/*
 * Copyright 2025 Google LLC
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
package com.google.cloud.resourcemanager.v3;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Allows users to manage their organization resources.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/resourcemanager/v3/organizations.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class OrganizationsGrpc {

  private OrganizationsGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.resourcemanager.v3.Organizations";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.GetOrganizationRequest,
          com.google.cloud.resourcemanager.v3.Organization>
      getGetOrganizationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetOrganization",
      requestType = com.google.cloud.resourcemanager.v3.GetOrganizationRequest.class,
      responseType = com.google.cloud.resourcemanager.v3.Organization.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.GetOrganizationRequest,
          com.google.cloud.resourcemanager.v3.Organization>
      getGetOrganizationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.resourcemanager.v3.GetOrganizationRequest,
            com.google.cloud.resourcemanager.v3.Organization>
        getGetOrganizationMethod;
    if ((getGetOrganizationMethod = OrganizationsGrpc.getGetOrganizationMethod) == null) {
      synchronized (OrganizationsGrpc.class) {
        if ((getGetOrganizationMethod = OrganizationsGrpc.getGetOrganizationMethod) == null) {
          OrganizationsGrpc.getGetOrganizationMethod =
              getGetOrganizationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.resourcemanager.v3.GetOrganizationRequest,
                          com.google.cloud.resourcemanager.v3.Organization>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetOrganization"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.resourcemanager.v3.GetOrganizationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.resourcemanager.v3.Organization
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OrganizationsMethodDescriptorSupplier("GetOrganization"))
                      .build();
        }
      }
    }
    return getGetOrganizationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.SearchOrganizationsRequest,
          com.google.cloud.resourcemanager.v3.SearchOrganizationsResponse>
      getSearchOrganizationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchOrganizations",
      requestType = com.google.cloud.resourcemanager.v3.SearchOrganizationsRequest.class,
      responseType = com.google.cloud.resourcemanager.v3.SearchOrganizationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.SearchOrganizationsRequest,
          com.google.cloud.resourcemanager.v3.SearchOrganizationsResponse>
      getSearchOrganizationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.resourcemanager.v3.SearchOrganizationsRequest,
            com.google.cloud.resourcemanager.v3.SearchOrganizationsResponse>
        getSearchOrganizationsMethod;
    if ((getSearchOrganizationsMethod = OrganizationsGrpc.getSearchOrganizationsMethod) == null) {
      synchronized (OrganizationsGrpc.class) {
        if ((getSearchOrganizationsMethod = OrganizationsGrpc.getSearchOrganizationsMethod)
            == null) {
          OrganizationsGrpc.getSearchOrganizationsMethod =
              getSearchOrganizationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.resourcemanager.v3.SearchOrganizationsRequest,
                          com.google.cloud.resourcemanager.v3.SearchOrganizationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SearchOrganizations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.resourcemanager.v3.SearchOrganizationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.resourcemanager.v3.SearchOrganizationsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OrganizationsMethodDescriptorSupplier("SearchOrganizations"))
                      .build();
        }
      }
    }
    return getSearchOrganizationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      getGetIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIamPolicy",
      requestType = com.google.iam.v1.GetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      getGetIamPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
        getGetIamPolicyMethod;
    if ((getGetIamPolicyMethod = OrganizationsGrpc.getGetIamPolicyMethod) == null) {
      synchronized (OrganizationsGrpc.class) {
        if ((getGetIamPolicyMethod = OrganizationsGrpc.getGetIamPolicyMethod) == null) {
          OrganizationsGrpc.getGetIamPolicyMethod =
              getGetIamPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIamPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.GetIamPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.Policy.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OrganizationsMethodDescriptorSupplier("GetIamPolicy"))
                      .build();
        }
      }
    }
    return getGetIamPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      getSetIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetIamPolicy",
      requestType = com.google.iam.v1.SetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      getSetIamPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
        getSetIamPolicyMethod;
    if ((getSetIamPolicyMethod = OrganizationsGrpc.getSetIamPolicyMethod) == null) {
      synchronized (OrganizationsGrpc.class) {
        if ((getSetIamPolicyMethod = OrganizationsGrpc.getSetIamPolicyMethod) == null) {
          OrganizationsGrpc.getSetIamPolicyMethod =
              getSetIamPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetIamPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.SetIamPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.Policy.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OrganizationsMethodDescriptorSupplier("SetIamPolicy"))
                      .build();
        }
      }
    }
    return getSetIamPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      getTestIamPermissionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TestIamPermissions",
      requestType = com.google.iam.v1.TestIamPermissionsRequest.class,
      responseType = com.google.iam.v1.TestIamPermissionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      getTestIamPermissionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.iam.v1.TestIamPermissionsRequest,
            com.google.iam.v1.TestIamPermissionsResponse>
        getTestIamPermissionsMethod;
    if ((getTestIamPermissionsMethod = OrganizationsGrpc.getTestIamPermissionsMethod) == null) {
      synchronized (OrganizationsGrpc.class) {
        if ((getTestIamPermissionsMethod = OrganizationsGrpc.getTestIamPermissionsMethod) == null) {
          OrganizationsGrpc.getTestIamPermissionsMethod =
              getTestIamPermissionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.TestIamPermissionsRequest,
                          com.google.iam.v1.TestIamPermissionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TestIamPermissions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.TestIamPermissionsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.TestIamPermissionsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OrganizationsMethodDescriptorSupplier("TestIamPermissions"))
                      .build();
        }
      }
    }
    return getTestIamPermissionsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static OrganizationsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OrganizationsStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<OrganizationsStub>() {
          @java.lang.Override
          public OrganizationsStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new OrganizationsStub(channel, callOptions);
          }
        };
    return OrganizationsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static OrganizationsBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OrganizationsBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<OrganizationsBlockingStub>() {
          @java.lang.Override
          public OrganizationsBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new OrganizationsBlockingStub(channel, callOptions);
          }
        };
    return OrganizationsBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static OrganizationsFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OrganizationsFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<OrganizationsFutureStub>() {
          @java.lang.Override
          public OrganizationsFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new OrganizationsFutureStub(channel, callOptions);
          }
        };
    return OrganizationsFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Allows users to manage their organization resources.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Fetches an organization resource identified by the specified resource name.
     * </pre>
     */
    default void getOrganization(
        com.google.cloud.resourcemanager.v3.GetOrganizationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.resourcemanager.v3.Organization>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetOrganizationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches organization resources that are visible to the user and satisfy
     * the specified filter. This method returns organizations in an unspecified
     * order. New organizations do not necessarily appear at the end of the
     * results, and may take a small amount of time to appear.
     * Search will only return organizations on which the user has the permission
     * `resourcemanager.organizations.get`
     * </pre>
     */
    default void searchOrganizations(
        com.google.cloud.resourcemanager.v3.SearchOrganizationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.resourcemanager.v3.SearchOrganizationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchOrganizationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy for an organization resource. The policy may
     * be empty if no such policy or resource exists. The `resource` field should
     * be the organization's resource name, for example: "organizations/123".
     * Authorization requires the IAM permission
     * `resourcemanager.organizations.getIamPolicy` on the specified organization.
     * </pre>
     */
    default void getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetIamPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy on an organization resource. Replaces any
     * existing policy. The `resource` field should be the organization's resource
     * name, for example: "organizations/123".
     * Authorization requires the IAM permission
     * `resourcemanager.organizations.setIamPolicy` on the specified organization.
     * </pre>
     */
    default void setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSetIamPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the permissions that a caller has on the specified organization.
     * The `resource` field should be the organization's resource name,
     * for example: "organizations/123".
     * There are no permissions required for making this API call.
     * </pre>
     */
    default void testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getTestIamPermissionsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Organizations.
   *
   * <pre>
   * Allows users to manage their organization resources.
   * </pre>
   */
  public abstract static class OrganizationsImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return OrganizationsGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Organizations.
   *
   * <pre>
   * Allows users to manage their organization resources.
   * </pre>
   */
  public static final class OrganizationsStub
      extends io.grpc.stub.AbstractAsyncStub<OrganizationsStub> {
    private OrganizationsStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrganizationsStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OrganizationsStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Fetches an organization resource identified by the specified resource name.
     * </pre>
     */
    public void getOrganization(
        com.google.cloud.resourcemanager.v3.GetOrganizationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.resourcemanager.v3.Organization>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetOrganizationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches organization resources that are visible to the user and satisfy
     * the specified filter. This method returns organizations in an unspecified
     * order. New organizations do not necessarily appear at the end of the
     * results, and may take a small amount of time to appear.
     * Search will only return organizations on which the user has the permission
     * `resourcemanager.organizations.get`
     * </pre>
     */
    public void searchOrganizations(
        com.google.cloud.resourcemanager.v3.SearchOrganizationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.resourcemanager.v3.SearchOrganizationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchOrganizationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy for an organization resource. The policy may
     * be empty if no such policy or resource exists. The `resource` field should
     * be the organization's resource name, for example: "organizations/123".
     * Authorization requires the IAM permission
     * `resourcemanager.organizations.getIamPolicy` on the specified organization.
     * </pre>
     */
    public void getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy on an organization resource. Replaces any
     * existing policy. The `resource` field should be the organization's resource
     * name, for example: "organizations/123".
     * Authorization requires the IAM permission
     * `resourcemanager.organizations.setIamPolicy` on the specified organization.
     * </pre>
     */
    public void setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the permissions that a caller has on the specified organization.
     * The `resource` field should be the organization's resource name,
     * for example: "organizations/123".
     * There are no permissions required for making this API call.
     * </pre>
     */
    public void testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Organizations.
   *
   * <pre>
   * Allows users to manage their organization resources.
   * </pre>
   */
  public static final class OrganizationsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<OrganizationsBlockingStub> {
    private OrganizationsBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrganizationsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OrganizationsBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Fetches an organization resource identified by the specified resource name.
     * </pre>
     */
    public com.google.cloud.resourcemanager.v3.Organization getOrganization(
        com.google.cloud.resourcemanager.v3.GetOrganizationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetOrganizationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Searches organization resources that are visible to the user and satisfy
     * the specified filter. This method returns organizations in an unspecified
     * order. New organizations do not necessarily appear at the end of the
     * results, and may take a small amount of time to appear.
     * Search will only return organizations on which the user has the permission
     * `resourcemanager.organizations.get`
     * </pre>
     */
    public com.google.cloud.resourcemanager.v3.SearchOrganizationsResponse searchOrganizations(
        com.google.cloud.resourcemanager.v3.SearchOrganizationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchOrganizationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy for an organization resource. The policy may
     * be empty if no such policy or resource exists. The `resource` field should
     * be the organization's resource name, for example: "organizations/123".
     * Authorization requires the IAM permission
     * `resourcemanager.organizations.getIamPolicy` on the specified organization.
     * </pre>
     */
    public com.google.iam.v1.Policy getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy on an organization resource. Replaces any
     * existing policy. The `resource` field should be the organization's resource
     * name, for example: "organizations/123".
     * Authorization requires the IAM permission
     * `resourcemanager.organizations.setIamPolicy` on the specified organization.
     * </pre>
     */
    public com.google.iam.v1.Policy setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the permissions that a caller has on the specified organization.
     * The `resource` field should be the organization's resource name,
     * for example: "organizations/123".
     * There are no permissions required for making this API call.
     * </pre>
     */
    public com.google.iam.v1.TestIamPermissionsResponse testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTestIamPermissionsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Organizations.
   *
   * <pre>
   * Allows users to manage their organization resources.
   * </pre>
   */
  public static final class OrganizationsFutureStub
      extends io.grpc.stub.AbstractFutureStub<OrganizationsFutureStub> {
    private OrganizationsFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrganizationsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OrganizationsFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Fetches an organization resource identified by the specified resource name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.resourcemanager.v3.Organization>
        getOrganization(com.google.cloud.resourcemanager.v3.GetOrganizationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetOrganizationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Searches organization resources that are visible to the user and satisfy
     * the specified filter. This method returns organizations in an unspecified
     * order. New organizations do not necessarily appear at the end of the
     * results, and may take a small amount of time to appear.
     * Search will only return organizations on which the user has the permission
     * `resourcemanager.organizations.get`
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.resourcemanager.v3.SearchOrganizationsResponse>
        searchOrganizations(
            com.google.cloud.resourcemanager.v3.SearchOrganizationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchOrganizationsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy for an organization resource. The policy may
     * be empty if no such policy or resource exists. The `resource` field should
     * be the organization's resource name, for example: "organizations/123".
     * Authorization requires the IAM permission
     * `resourcemanager.organizations.getIamPolicy` on the specified organization.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy>
        getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy on an organization resource. Replaces any
     * existing policy. The `resource` field should be the organization's resource
     * name, for example: "organizations/123".
     * Authorization requires the IAM permission
     * `resourcemanager.organizations.setIamPolicy` on the specified organization.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy>
        setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the permissions that a caller has on the specified organization.
     * The `resource` field should be the organization's resource name,
     * for example: "organizations/123".
     * There are no permissions required for making this API call.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.iam.v1.TestIamPermissionsResponse>
        testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ORGANIZATION = 0;
  private static final int METHODID_SEARCH_ORGANIZATIONS = 1;
  private static final int METHODID_GET_IAM_POLICY = 2;
  private static final int METHODID_SET_IAM_POLICY = 3;
  private static final int METHODID_TEST_IAM_PERMISSIONS = 4;

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
        case METHODID_GET_ORGANIZATION:
          serviceImpl.getOrganization(
              (com.google.cloud.resourcemanager.v3.GetOrganizationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.resourcemanager.v3.Organization>)
                  responseObserver);
          break;
        case METHODID_SEARCH_ORGANIZATIONS:
          serviceImpl.searchOrganizations(
              (com.google.cloud.resourcemanager.v3.SearchOrganizationsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.resourcemanager.v3.SearchOrganizationsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_IAM_POLICY:
          serviceImpl.getIamPolicy(
              (com.google.iam.v1.GetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_SET_IAM_POLICY:
          serviceImpl.setIamPolicy(
              (com.google.iam.v1.SetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_TEST_IAM_PERMISSIONS:
          serviceImpl.testIamPermissions(
              (com.google.iam.v1.TestIamPermissionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>)
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
            getGetOrganizationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.resourcemanager.v3.GetOrganizationRequest,
                    com.google.cloud.resourcemanager.v3.Organization>(
                    service, METHODID_GET_ORGANIZATION)))
        .addMethod(
            getSearchOrganizationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.resourcemanager.v3.SearchOrganizationsRequest,
                    com.google.cloud.resourcemanager.v3.SearchOrganizationsResponse>(
                    service, METHODID_SEARCH_ORGANIZATIONS)))
        .addMethod(
            getGetIamPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>(
                    service, METHODID_GET_IAM_POLICY)))
        .addMethod(
            getSetIamPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>(
                    service, METHODID_SET_IAM_POLICY)))
        .addMethod(
            getTestIamPermissionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.iam.v1.TestIamPermissionsRequest,
                    com.google.iam.v1.TestIamPermissionsResponse>(
                    service, METHODID_TEST_IAM_PERMISSIONS)))
        .build();
  }

  private abstract static class OrganizationsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    OrganizationsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.resourcemanager.v3.OrganizationsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Organizations");
    }
  }

  private static final class OrganizationsFileDescriptorSupplier
      extends OrganizationsBaseDescriptorSupplier {
    OrganizationsFileDescriptorSupplier() {}
  }

  private static final class OrganizationsMethodDescriptorSupplier
      extends OrganizationsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    OrganizationsMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (OrganizationsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new OrganizationsFileDescriptorSupplier())
                      .addMethod(getGetOrganizationMethod())
                      .addMethod(getSearchOrganizationsMethod())
                      .addMethod(getGetIamPolicyMethod())
                      .addMethod(getSetIamPolicyMethod())
                      .addMethod(getTestIamPermissionsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
