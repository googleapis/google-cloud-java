package com.google.cloud.securesourcemanager.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Secure Source Manager API
 * Access Secure Source Manager instances, resources, and repositories.
 * This API is split across two servers: the Control Plane and the Data Plane.
 * Data Plane endpoints are hosted directly by your Secure Source Manager
 * instance, so you must connect to your instance's API hostname to access
 * them. The API hostname looks like the following:
 *    https://[instance-id]-[project-number]-api.[location].sourcemanager.dev
 * For example,
 *    https://my-instance-702770452863-api.us-central1.sourcemanager.dev
 * Data Plane endpoints are denoted with **Host: Data Plane**.
 * All other endpoints are found in the normal Cloud API location, namely,
 * `securcesourcemanager.googleapis.com`.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/securesourcemanager/v1/secure_source_manager.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SecureSourceManagerGrpc {

  private SecureSourceManagerGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.securesourcemanager.v1.SecureSourceManager";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securesourcemanager.v1.ListInstancesRequest,
      com.google.cloud.securesourcemanager.v1.ListInstancesResponse> getListInstancesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListInstances",
      requestType = com.google.cloud.securesourcemanager.v1.ListInstancesRequest.class,
      responseType = com.google.cloud.securesourcemanager.v1.ListInstancesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securesourcemanager.v1.ListInstancesRequest,
      com.google.cloud.securesourcemanager.v1.ListInstancesResponse> getListInstancesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securesourcemanager.v1.ListInstancesRequest, com.google.cloud.securesourcemanager.v1.ListInstancesResponse> getListInstancesMethod;
    if ((getListInstancesMethod = SecureSourceManagerGrpc.getListInstancesMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getListInstancesMethod = SecureSourceManagerGrpc.getListInstancesMethod) == null) {
          SecureSourceManagerGrpc.getListInstancesMethod = getListInstancesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securesourcemanager.v1.ListInstancesRequest, com.google.cloud.securesourcemanager.v1.ListInstancesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListInstances"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securesourcemanager.v1.ListInstancesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securesourcemanager.v1.ListInstancesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SecureSourceManagerMethodDescriptorSupplier("ListInstances"))
              .build();
        }
      }
    }
    return getListInstancesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securesourcemanager.v1.GetInstanceRequest,
      com.google.cloud.securesourcemanager.v1.Instance> getGetInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetInstance",
      requestType = com.google.cloud.securesourcemanager.v1.GetInstanceRequest.class,
      responseType = com.google.cloud.securesourcemanager.v1.Instance.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securesourcemanager.v1.GetInstanceRequest,
      com.google.cloud.securesourcemanager.v1.Instance> getGetInstanceMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securesourcemanager.v1.GetInstanceRequest, com.google.cloud.securesourcemanager.v1.Instance> getGetInstanceMethod;
    if ((getGetInstanceMethod = SecureSourceManagerGrpc.getGetInstanceMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getGetInstanceMethod = SecureSourceManagerGrpc.getGetInstanceMethod) == null) {
          SecureSourceManagerGrpc.getGetInstanceMethod = getGetInstanceMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securesourcemanager.v1.GetInstanceRequest, com.google.cloud.securesourcemanager.v1.Instance>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetInstance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securesourcemanager.v1.GetInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securesourcemanager.v1.Instance.getDefaultInstance()))
              .setSchemaDescriptor(new SecureSourceManagerMethodDescriptorSupplier("GetInstance"))
              .build();
        }
      }
    }
    return getGetInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securesourcemanager.v1.CreateInstanceRequest,
      com.google.longrunning.Operation> getCreateInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateInstance",
      requestType = com.google.cloud.securesourcemanager.v1.CreateInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securesourcemanager.v1.CreateInstanceRequest,
      com.google.longrunning.Operation> getCreateInstanceMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securesourcemanager.v1.CreateInstanceRequest, com.google.longrunning.Operation> getCreateInstanceMethod;
    if ((getCreateInstanceMethod = SecureSourceManagerGrpc.getCreateInstanceMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getCreateInstanceMethod = SecureSourceManagerGrpc.getCreateInstanceMethod) == null) {
          SecureSourceManagerGrpc.getCreateInstanceMethod = getCreateInstanceMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securesourcemanager.v1.CreateInstanceRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateInstance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securesourcemanager.v1.CreateInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new SecureSourceManagerMethodDescriptorSupplier("CreateInstance"))
              .build();
        }
      }
    }
    return getCreateInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securesourcemanager.v1.DeleteInstanceRequest,
      com.google.longrunning.Operation> getDeleteInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteInstance",
      requestType = com.google.cloud.securesourcemanager.v1.DeleteInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securesourcemanager.v1.DeleteInstanceRequest,
      com.google.longrunning.Operation> getDeleteInstanceMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securesourcemanager.v1.DeleteInstanceRequest, com.google.longrunning.Operation> getDeleteInstanceMethod;
    if ((getDeleteInstanceMethod = SecureSourceManagerGrpc.getDeleteInstanceMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getDeleteInstanceMethod = SecureSourceManagerGrpc.getDeleteInstanceMethod) == null) {
          SecureSourceManagerGrpc.getDeleteInstanceMethod = getDeleteInstanceMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securesourcemanager.v1.DeleteInstanceRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteInstance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securesourcemanager.v1.DeleteInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new SecureSourceManagerMethodDescriptorSupplier("DeleteInstance"))
              .build();
        }
      }
    }
    return getDeleteInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securesourcemanager.v1.ListRepositoriesRequest,
      com.google.cloud.securesourcemanager.v1.ListRepositoriesResponse> getListRepositoriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRepositories",
      requestType = com.google.cloud.securesourcemanager.v1.ListRepositoriesRequest.class,
      responseType = com.google.cloud.securesourcemanager.v1.ListRepositoriesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securesourcemanager.v1.ListRepositoriesRequest,
      com.google.cloud.securesourcemanager.v1.ListRepositoriesResponse> getListRepositoriesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securesourcemanager.v1.ListRepositoriesRequest, com.google.cloud.securesourcemanager.v1.ListRepositoriesResponse> getListRepositoriesMethod;
    if ((getListRepositoriesMethod = SecureSourceManagerGrpc.getListRepositoriesMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getListRepositoriesMethod = SecureSourceManagerGrpc.getListRepositoriesMethod) == null) {
          SecureSourceManagerGrpc.getListRepositoriesMethod = getListRepositoriesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securesourcemanager.v1.ListRepositoriesRequest, com.google.cloud.securesourcemanager.v1.ListRepositoriesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListRepositories"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securesourcemanager.v1.ListRepositoriesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securesourcemanager.v1.ListRepositoriesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SecureSourceManagerMethodDescriptorSupplier("ListRepositories"))
              .build();
        }
      }
    }
    return getListRepositoriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securesourcemanager.v1.GetRepositoryRequest,
      com.google.cloud.securesourcemanager.v1.Repository> getGetRepositoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRepository",
      requestType = com.google.cloud.securesourcemanager.v1.GetRepositoryRequest.class,
      responseType = com.google.cloud.securesourcemanager.v1.Repository.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securesourcemanager.v1.GetRepositoryRequest,
      com.google.cloud.securesourcemanager.v1.Repository> getGetRepositoryMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securesourcemanager.v1.GetRepositoryRequest, com.google.cloud.securesourcemanager.v1.Repository> getGetRepositoryMethod;
    if ((getGetRepositoryMethod = SecureSourceManagerGrpc.getGetRepositoryMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getGetRepositoryMethod = SecureSourceManagerGrpc.getGetRepositoryMethod) == null) {
          SecureSourceManagerGrpc.getGetRepositoryMethod = getGetRepositoryMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securesourcemanager.v1.GetRepositoryRequest, com.google.cloud.securesourcemanager.v1.Repository>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRepository"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securesourcemanager.v1.GetRepositoryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securesourcemanager.v1.Repository.getDefaultInstance()))
              .setSchemaDescriptor(new SecureSourceManagerMethodDescriptorSupplier("GetRepository"))
              .build();
        }
      }
    }
    return getGetRepositoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securesourcemanager.v1.CreateRepositoryRequest,
      com.google.longrunning.Operation> getCreateRepositoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRepository",
      requestType = com.google.cloud.securesourcemanager.v1.CreateRepositoryRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securesourcemanager.v1.CreateRepositoryRequest,
      com.google.longrunning.Operation> getCreateRepositoryMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securesourcemanager.v1.CreateRepositoryRequest, com.google.longrunning.Operation> getCreateRepositoryMethod;
    if ((getCreateRepositoryMethod = SecureSourceManagerGrpc.getCreateRepositoryMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getCreateRepositoryMethod = SecureSourceManagerGrpc.getCreateRepositoryMethod) == null) {
          SecureSourceManagerGrpc.getCreateRepositoryMethod = getCreateRepositoryMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securesourcemanager.v1.CreateRepositoryRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateRepository"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securesourcemanager.v1.CreateRepositoryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new SecureSourceManagerMethodDescriptorSupplier("CreateRepository"))
              .build();
        }
      }
    }
    return getCreateRepositoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securesourcemanager.v1.DeleteRepositoryRequest,
      com.google.longrunning.Operation> getDeleteRepositoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteRepository",
      requestType = com.google.cloud.securesourcemanager.v1.DeleteRepositoryRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securesourcemanager.v1.DeleteRepositoryRequest,
      com.google.longrunning.Operation> getDeleteRepositoryMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securesourcemanager.v1.DeleteRepositoryRequest, com.google.longrunning.Operation> getDeleteRepositoryMethod;
    if ((getDeleteRepositoryMethod = SecureSourceManagerGrpc.getDeleteRepositoryMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getDeleteRepositoryMethod = SecureSourceManagerGrpc.getDeleteRepositoryMethod) == null) {
          SecureSourceManagerGrpc.getDeleteRepositoryMethod = getDeleteRepositoryMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securesourcemanager.v1.DeleteRepositoryRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteRepository"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securesourcemanager.v1.DeleteRepositoryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new SecureSourceManagerMethodDescriptorSupplier("DeleteRepository"))
              .build();
        }
      }
    }
    return getDeleteRepositoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest,
      com.google.iam.v1.Policy> getGetIamPolicyRepoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIamPolicyRepo",
      requestType = com.google.iam.v1.GetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest,
      com.google.iam.v1.Policy> getGetIamPolicyRepoMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy> getGetIamPolicyRepoMethod;
    if ((getGetIamPolicyRepoMethod = SecureSourceManagerGrpc.getGetIamPolicyRepoMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getGetIamPolicyRepoMethod = SecureSourceManagerGrpc.getGetIamPolicyRepoMethod) == null) {
          SecureSourceManagerGrpc.getGetIamPolicyRepoMethod = getGetIamPolicyRepoMethod =
              io.grpc.MethodDescriptor.<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIamPolicyRepo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.GetIamPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.Policy.getDefaultInstance()))
              .setSchemaDescriptor(new SecureSourceManagerMethodDescriptorSupplier("GetIamPolicyRepo"))
              .build();
        }
      }
    }
    return getGetIamPolicyRepoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest,
      com.google.iam.v1.Policy> getSetIamPolicyRepoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetIamPolicyRepo",
      requestType = com.google.iam.v1.SetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest,
      com.google.iam.v1.Policy> getSetIamPolicyRepoMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy> getSetIamPolicyRepoMethod;
    if ((getSetIamPolicyRepoMethod = SecureSourceManagerGrpc.getSetIamPolicyRepoMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getSetIamPolicyRepoMethod = SecureSourceManagerGrpc.getSetIamPolicyRepoMethod) == null) {
          SecureSourceManagerGrpc.getSetIamPolicyRepoMethod = getSetIamPolicyRepoMethod =
              io.grpc.MethodDescriptor.<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetIamPolicyRepo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.SetIamPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.Policy.getDefaultInstance()))
              .setSchemaDescriptor(new SecureSourceManagerMethodDescriptorSupplier("SetIamPolicyRepo"))
              .build();
        }
      }
    }
    return getSetIamPolicyRepoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1.TestIamPermissionsRequest,
      com.google.iam.v1.TestIamPermissionsResponse> getTestIamPermissionsRepoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TestIamPermissionsRepo",
      requestType = com.google.iam.v1.TestIamPermissionsRequest.class,
      responseType = com.google.iam.v1.TestIamPermissionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.v1.TestIamPermissionsRequest,
      com.google.iam.v1.TestIamPermissionsResponse> getTestIamPermissionsRepoMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse> getTestIamPermissionsRepoMethod;
    if ((getTestIamPermissionsRepoMethod = SecureSourceManagerGrpc.getTestIamPermissionsRepoMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getTestIamPermissionsRepoMethod = SecureSourceManagerGrpc.getTestIamPermissionsRepoMethod) == null) {
          SecureSourceManagerGrpc.getTestIamPermissionsRepoMethod = getTestIamPermissionsRepoMethod =
              io.grpc.MethodDescriptor.<com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TestIamPermissionsRepo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.TestIamPermissionsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SecureSourceManagerMethodDescriptorSupplier("TestIamPermissionsRepo"))
              .build();
        }
      }
    }
    return getTestIamPermissionsRepoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SecureSourceManagerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SecureSourceManagerStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SecureSourceManagerStub>() {
        @java.lang.Override
        public SecureSourceManagerStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SecureSourceManagerStub(channel, callOptions);
        }
      };
    return SecureSourceManagerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SecureSourceManagerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SecureSourceManagerBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SecureSourceManagerBlockingStub>() {
        @java.lang.Override
        public SecureSourceManagerBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SecureSourceManagerBlockingStub(channel, callOptions);
        }
      };
    return SecureSourceManagerBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SecureSourceManagerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SecureSourceManagerFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SecureSourceManagerFutureStub>() {
        @java.lang.Override
        public SecureSourceManagerFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SecureSourceManagerFutureStub(channel, callOptions);
        }
      };
    return SecureSourceManagerFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Secure Source Manager API
   * Access Secure Source Manager instances, resources, and repositories.
   * This API is split across two servers: the Control Plane and the Data Plane.
   * Data Plane endpoints are hosted directly by your Secure Source Manager
   * instance, so you must connect to your instance's API hostname to access
   * them. The API hostname looks like the following:
   *    https://[instance-id]-[project-number]-api.[location].sourcemanager.dev
   * For example,
   *    https://my-instance-702770452863-api.us-central1.sourcemanager.dev
   * Data Plane endpoints are denoted with **Host: Data Plane**.
   * All other endpoints are found in the normal Cloud API location, namely,
   * `securcesourcemanager.googleapis.com`.
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Lists Instances in a given project and location.
     * </pre>
     */
    default void listInstances(com.google.cloud.securesourcemanager.v1.ListInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securesourcemanager.v1.ListInstancesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListInstancesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single instance.
     * </pre>
     */
    default void getInstance(com.google.cloud.securesourcemanager.v1.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securesourcemanager.v1.Instance> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetInstanceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new instance in a given project and location.
     * </pre>
     */
    default void createInstance(com.google.cloud.securesourcemanager.v1.CreateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateInstanceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a single instance.
     * </pre>
     */
    default void deleteInstance(com.google.cloud.securesourcemanager.v1.DeleteInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteInstanceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists Repositories in a given project and location.
     * **Host: Data Plane**
     * </pre>
     */
    default void listRepositories(com.google.cloud.securesourcemanager.v1.ListRepositoriesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securesourcemanager.v1.ListRepositoriesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListRepositoriesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets metadata of a repository.
     * **Host: Data Plane**
     * </pre>
     */
    default void getRepository(com.google.cloud.securesourcemanager.v1.GetRepositoryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securesourcemanager.v1.Repository> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetRepositoryMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new repository in a given project and location.
     * **Host: Data Plane**
     * </pre>
     */
    default void createRepository(com.google.cloud.securesourcemanager.v1.CreateRepositoryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateRepositoryMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a Repository.
     * **Host: Data Plane**
     * </pre>
     */
    default void deleteRepository(com.google.cloud.securesourcemanager.v1.DeleteRepositoryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteRepositoryMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get IAM policy for a repository.
     * </pre>
     */
    default void getIamPolicyRepo(com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetIamPolicyRepoMethod(), responseObserver);
    }

    /**
     * <pre>
     * Set IAM policy on a repository.
     * </pre>
     */
    default void setIamPolicyRepo(com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetIamPolicyRepoMethod(), responseObserver);
    }

    /**
     * <pre>
     * Test IAM permissions on a repository.
     * IAM permission checks are not required on this method.
     * </pre>
     */
    default void testIamPermissionsRepo(com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTestIamPermissionsRepoMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SecureSourceManager.
   * <pre>
   * Secure Source Manager API
   * Access Secure Source Manager instances, resources, and repositories.
   * This API is split across two servers: the Control Plane and the Data Plane.
   * Data Plane endpoints are hosted directly by your Secure Source Manager
   * instance, so you must connect to your instance's API hostname to access
   * them. The API hostname looks like the following:
   *    https://[instance-id]-[project-number]-api.[location].sourcemanager.dev
   * For example,
   *    https://my-instance-702770452863-api.us-central1.sourcemanager.dev
   * Data Plane endpoints are denoted with **Host: Data Plane**.
   * All other endpoints are found in the normal Cloud API location, namely,
   * `securcesourcemanager.googleapis.com`.
   * </pre>
   */
  public static abstract class SecureSourceManagerImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return SecureSourceManagerGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SecureSourceManager.
   * <pre>
   * Secure Source Manager API
   * Access Secure Source Manager instances, resources, and repositories.
   * This API is split across two servers: the Control Plane and the Data Plane.
   * Data Plane endpoints are hosted directly by your Secure Source Manager
   * instance, so you must connect to your instance's API hostname to access
   * them. The API hostname looks like the following:
   *    https://[instance-id]-[project-number]-api.[location].sourcemanager.dev
   * For example,
   *    https://my-instance-702770452863-api.us-central1.sourcemanager.dev
   * Data Plane endpoints are denoted with **Host: Data Plane**.
   * All other endpoints are found in the normal Cloud API location, namely,
   * `securcesourcemanager.googleapis.com`.
   * </pre>
   */
  public static final class SecureSourceManagerStub
      extends io.grpc.stub.AbstractAsyncStub<SecureSourceManagerStub> {
    private SecureSourceManagerStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecureSourceManagerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SecureSourceManagerStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists Instances in a given project and location.
     * </pre>
     */
    public void listInstances(com.google.cloud.securesourcemanager.v1.ListInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securesourcemanager.v1.ListInstancesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListInstancesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single instance.
     * </pre>
     */
    public void getInstance(com.google.cloud.securesourcemanager.v1.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securesourcemanager.v1.Instance> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetInstanceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new instance in a given project and location.
     * </pre>
     */
    public void createInstance(com.google.cloud.securesourcemanager.v1.CreateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateInstanceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a single instance.
     * </pre>
     */
    public void deleteInstance(com.google.cloud.securesourcemanager.v1.DeleteInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteInstanceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists Repositories in a given project and location.
     * **Host: Data Plane**
     * </pre>
     */
    public void listRepositories(com.google.cloud.securesourcemanager.v1.ListRepositoriesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securesourcemanager.v1.ListRepositoriesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRepositoriesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets metadata of a repository.
     * **Host: Data Plane**
     * </pre>
     */
    public void getRepository(com.google.cloud.securesourcemanager.v1.GetRepositoryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securesourcemanager.v1.Repository> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRepositoryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new repository in a given project and location.
     * **Host: Data Plane**
     * </pre>
     */
    public void createRepository(com.google.cloud.securesourcemanager.v1.CreateRepositoryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateRepositoryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a Repository.
     * **Host: Data Plane**
     * </pre>
     */
    public void deleteRepository(com.google.cloud.securesourcemanager.v1.DeleteRepositoryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteRepositoryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get IAM policy for a repository.
     * </pre>
     */
    public void getIamPolicyRepo(com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIamPolicyRepoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Set IAM policy on a repository.
     * </pre>
     */
    public void setIamPolicyRepo(com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetIamPolicyRepoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Test IAM permissions on a repository.
     * IAM permission checks are not required on this method.
     * </pre>
     */
    public void testIamPermissionsRepo(com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTestIamPermissionsRepoMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SecureSourceManager.
   * <pre>
   * Secure Source Manager API
   * Access Secure Source Manager instances, resources, and repositories.
   * This API is split across two servers: the Control Plane and the Data Plane.
   * Data Plane endpoints are hosted directly by your Secure Source Manager
   * instance, so you must connect to your instance's API hostname to access
   * them. The API hostname looks like the following:
   *    https://[instance-id]-[project-number]-api.[location].sourcemanager.dev
   * For example,
   *    https://my-instance-702770452863-api.us-central1.sourcemanager.dev
   * Data Plane endpoints are denoted with **Host: Data Plane**.
   * All other endpoints are found in the normal Cloud API location, namely,
   * `securcesourcemanager.googleapis.com`.
   * </pre>
   */
  public static final class SecureSourceManagerBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SecureSourceManagerBlockingStub> {
    private SecureSourceManagerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecureSourceManagerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SecureSourceManagerBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists Instances in a given project and location.
     * </pre>
     */
    public com.google.cloud.securesourcemanager.v1.ListInstancesResponse listInstances(com.google.cloud.securesourcemanager.v1.ListInstancesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListInstancesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets details of a single instance.
     * </pre>
     */
    public com.google.cloud.securesourcemanager.v1.Instance getInstance(com.google.cloud.securesourcemanager.v1.GetInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetInstanceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new instance in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createInstance(com.google.cloud.securesourcemanager.v1.CreateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateInstanceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a single instance.
     * </pre>
     */
    public com.google.longrunning.Operation deleteInstance(com.google.cloud.securesourcemanager.v1.DeleteInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteInstanceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists Repositories in a given project and location.
     * **Host: Data Plane**
     * </pre>
     */
    public com.google.cloud.securesourcemanager.v1.ListRepositoriesResponse listRepositories(com.google.cloud.securesourcemanager.v1.ListRepositoriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRepositoriesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets metadata of a repository.
     * **Host: Data Plane**
     * </pre>
     */
    public com.google.cloud.securesourcemanager.v1.Repository getRepository(com.google.cloud.securesourcemanager.v1.GetRepositoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRepositoryMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new repository in a given project and location.
     * **Host: Data Plane**
     * </pre>
     */
    public com.google.longrunning.Operation createRepository(com.google.cloud.securesourcemanager.v1.CreateRepositoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateRepositoryMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a Repository.
     * **Host: Data Plane**
     * </pre>
     */
    public com.google.longrunning.Operation deleteRepository(com.google.cloud.securesourcemanager.v1.DeleteRepositoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteRepositoryMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get IAM policy for a repository.
     * </pre>
     */
    public com.google.iam.v1.Policy getIamPolicyRepo(com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIamPolicyRepoMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Set IAM policy on a repository.
     * </pre>
     */
    public com.google.iam.v1.Policy setIamPolicyRepo(com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetIamPolicyRepoMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Test IAM permissions on a repository.
     * IAM permission checks are not required on this method.
     * </pre>
     */
    public com.google.iam.v1.TestIamPermissionsResponse testIamPermissionsRepo(com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTestIamPermissionsRepoMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SecureSourceManager.
   * <pre>
   * Secure Source Manager API
   * Access Secure Source Manager instances, resources, and repositories.
   * This API is split across two servers: the Control Plane and the Data Plane.
   * Data Plane endpoints are hosted directly by your Secure Source Manager
   * instance, so you must connect to your instance's API hostname to access
   * them. The API hostname looks like the following:
   *    https://[instance-id]-[project-number]-api.[location].sourcemanager.dev
   * For example,
   *    https://my-instance-702770452863-api.us-central1.sourcemanager.dev
   * Data Plane endpoints are denoted with **Host: Data Plane**.
   * All other endpoints are found in the normal Cloud API location, namely,
   * `securcesourcemanager.googleapis.com`.
   * </pre>
   */
  public static final class SecureSourceManagerFutureStub
      extends io.grpc.stub.AbstractFutureStub<SecureSourceManagerFutureStub> {
    private SecureSourceManagerFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecureSourceManagerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SecureSourceManagerFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists Instances in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.securesourcemanager.v1.ListInstancesResponse> listInstances(
        com.google.cloud.securesourcemanager.v1.ListInstancesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListInstancesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets details of a single instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.securesourcemanager.v1.Instance> getInstance(
        com.google.cloud.securesourcemanager.v1.GetInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetInstanceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new instance in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createInstance(
        com.google.cloud.securesourcemanager.v1.CreateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateInstanceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a single instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteInstance(
        com.google.cloud.securesourcemanager.v1.DeleteInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteInstanceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists Repositories in a given project and location.
     * **Host: Data Plane**
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.securesourcemanager.v1.ListRepositoriesResponse> listRepositories(
        com.google.cloud.securesourcemanager.v1.ListRepositoriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRepositoriesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets metadata of a repository.
     * **Host: Data Plane**
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.securesourcemanager.v1.Repository> getRepository(
        com.google.cloud.securesourcemanager.v1.GetRepositoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRepositoryMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new repository in a given project and location.
     * **Host: Data Plane**
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createRepository(
        com.google.cloud.securesourcemanager.v1.CreateRepositoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateRepositoryMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a Repository.
     * **Host: Data Plane**
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteRepository(
        com.google.cloud.securesourcemanager.v1.DeleteRepositoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteRepositoryMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get IAM policy for a repository.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy> getIamPolicyRepo(
        com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIamPolicyRepoMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Set IAM policy on a repository.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy> setIamPolicyRepo(
        com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetIamPolicyRepoMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Test IAM permissions on a repository.
     * IAM permission checks are not required on this method.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.TestIamPermissionsResponse> testIamPermissionsRepo(
        com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTestIamPermissionsRepoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_INSTANCES = 0;
  private static final int METHODID_GET_INSTANCE = 1;
  private static final int METHODID_CREATE_INSTANCE = 2;
  private static final int METHODID_DELETE_INSTANCE = 3;
  private static final int METHODID_LIST_REPOSITORIES = 4;
  private static final int METHODID_GET_REPOSITORY = 5;
  private static final int METHODID_CREATE_REPOSITORY = 6;
  private static final int METHODID_DELETE_REPOSITORY = 7;
  private static final int METHODID_GET_IAM_POLICY_REPO = 8;
  private static final int METHODID_SET_IAM_POLICY_REPO = 9;
  private static final int METHODID_TEST_IAM_PERMISSIONS_REPO = 10;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
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
        case METHODID_LIST_INSTANCES:
          serviceImpl.listInstances((com.google.cloud.securesourcemanager.v1.ListInstancesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securesourcemanager.v1.ListInstancesResponse>) responseObserver);
          break;
        case METHODID_GET_INSTANCE:
          serviceImpl.getInstance((com.google.cloud.securesourcemanager.v1.GetInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securesourcemanager.v1.Instance>) responseObserver);
          break;
        case METHODID_CREATE_INSTANCE:
          serviceImpl.createInstance((com.google.cloud.securesourcemanager.v1.CreateInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_INSTANCE:
          serviceImpl.deleteInstance((com.google.cloud.securesourcemanager.v1.DeleteInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_REPOSITORIES:
          serviceImpl.listRepositories((com.google.cloud.securesourcemanager.v1.ListRepositoriesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securesourcemanager.v1.ListRepositoriesResponse>) responseObserver);
          break;
        case METHODID_GET_REPOSITORY:
          serviceImpl.getRepository((com.google.cloud.securesourcemanager.v1.GetRepositoryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securesourcemanager.v1.Repository>) responseObserver);
          break;
        case METHODID_CREATE_REPOSITORY:
          serviceImpl.createRepository((com.google.cloud.securesourcemanager.v1.CreateRepositoryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_REPOSITORY:
          serviceImpl.deleteRepository((com.google.cloud.securesourcemanager.v1.DeleteRepositoryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_IAM_POLICY_REPO:
          serviceImpl.getIamPolicyRepo((com.google.iam.v1.GetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_SET_IAM_POLICY_REPO:
          serviceImpl.setIamPolicyRepo((com.google.iam.v1.SetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_TEST_IAM_PERMISSIONS_REPO:
          serviceImpl.testIamPermissionsRepo((com.google.iam.v1.TestIamPermissionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>) responseObserver);
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
          getListInstancesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.securesourcemanager.v1.ListInstancesRequest,
              com.google.cloud.securesourcemanager.v1.ListInstancesResponse>(
                service, METHODID_LIST_INSTANCES)))
        .addMethod(
          getGetInstanceMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.securesourcemanager.v1.GetInstanceRequest,
              com.google.cloud.securesourcemanager.v1.Instance>(
                service, METHODID_GET_INSTANCE)))
        .addMethod(
          getCreateInstanceMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.securesourcemanager.v1.CreateInstanceRequest,
              com.google.longrunning.Operation>(
                service, METHODID_CREATE_INSTANCE)))
        .addMethod(
          getDeleteInstanceMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.securesourcemanager.v1.DeleteInstanceRequest,
              com.google.longrunning.Operation>(
                service, METHODID_DELETE_INSTANCE)))
        .addMethod(
          getListRepositoriesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.securesourcemanager.v1.ListRepositoriesRequest,
              com.google.cloud.securesourcemanager.v1.ListRepositoriesResponse>(
                service, METHODID_LIST_REPOSITORIES)))
        .addMethod(
          getGetRepositoryMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.securesourcemanager.v1.GetRepositoryRequest,
              com.google.cloud.securesourcemanager.v1.Repository>(
                service, METHODID_GET_REPOSITORY)))
        .addMethod(
          getCreateRepositoryMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.securesourcemanager.v1.CreateRepositoryRequest,
              com.google.longrunning.Operation>(
                service, METHODID_CREATE_REPOSITORY)))
        .addMethod(
          getDeleteRepositoryMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.securesourcemanager.v1.DeleteRepositoryRequest,
              com.google.longrunning.Operation>(
                service, METHODID_DELETE_REPOSITORY)))
        .addMethod(
          getGetIamPolicyRepoMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.iam.v1.GetIamPolicyRequest,
              com.google.iam.v1.Policy>(
                service, METHODID_GET_IAM_POLICY_REPO)))
        .addMethod(
          getSetIamPolicyRepoMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.iam.v1.SetIamPolicyRequest,
              com.google.iam.v1.Policy>(
                service, METHODID_SET_IAM_POLICY_REPO)))
        .addMethod(
          getTestIamPermissionsRepoMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.iam.v1.TestIamPermissionsRequest,
              com.google.iam.v1.TestIamPermissionsResponse>(
                service, METHODID_TEST_IAM_PERMISSIONS_REPO)))
        .build();
  }

  private static abstract class SecureSourceManagerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SecureSourceManagerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.securesourcemanager.v1.SecureSourceManagerProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SecureSourceManager");
    }
  }

  private static final class SecureSourceManagerFileDescriptorSupplier
      extends SecureSourceManagerBaseDescriptorSupplier {
    SecureSourceManagerFileDescriptorSupplier() {}
  }

  private static final class SecureSourceManagerMethodDescriptorSupplier
      extends SecureSourceManagerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SecureSourceManagerMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SecureSourceManagerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SecureSourceManagerFileDescriptorSupplier())
              .addMethod(getListInstancesMethod())
              .addMethod(getGetInstanceMethod())
              .addMethod(getCreateInstanceMethod())
              .addMethod(getDeleteInstanceMethod())
              .addMethod(getListRepositoriesMethod())
              .addMethod(getGetRepositoryMethod())
              .addMethod(getCreateRepositoryMethod())
              .addMethod(getDeleteRepositoryMethod())
              .addMethod(getGetIamPolicyRepoMethod())
              .addMethod(getSetIamPolicyRepoMethod())
              .addMethod(getTestIamPermissionsRepoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
