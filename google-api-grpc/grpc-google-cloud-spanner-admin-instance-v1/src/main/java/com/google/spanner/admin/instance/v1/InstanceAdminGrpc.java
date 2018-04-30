package com.google.spanner.admin.instance.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Cloud Spanner Instance Admin API
 * The Cloud Spanner Instance Admin API can be used to create, delete,
 * modify and list instances. Instances are dedicated Cloud Spanner serving
 * and storage resources to be used by Cloud Spanner databases.
 * Each instance has a "configuration", which dictates where the
 * serving resources for the Cloud Spanner instance are located (e.g.,
 * US-central, Europe). Configurations are created by Google based on
 * resource availability.
 * Cloud Spanner billing is based on the instances that exist and their
 * sizes. After an instance exists, there are no additional
 * per-database or per-operation charges for use of the instance
 * (though there may be additional network bandwidth charges).
 * Instances offer isolation: problems with databases in one instance
 * will not affect other instances. However, within an instance
 * databases can affect each other. For example, if one database in an
 * instance receives a lot of requests and consumes most of the
 * instance resources, fewer resources are available for other
 * databases in that instance, and their performance may suffer.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/spanner/admin/instance/v1/spanner_instance_admin.proto")
public final class InstanceAdminGrpc {

  private InstanceAdminGrpc() {}

  public static final String SERVICE_NAME = "google.spanner.admin.instance.v1.InstanceAdmin";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListInstanceConfigsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.spanner.admin.instance.v1.ListInstanceConfigsRequest,
      com.google.spanner.admin.instance.v1.ListInstanceConfigsResponse> METHOD_LIST_INSTANCE_CONFIGS = getListInstanceConfigsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.spanner.admin.instance.v1.ListInstanceConfigsRequest,
      com.google.spanner.admin.instance.v1.ListInstanceConfigsResponse> getListInstanceConfigsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.spanner.admin.instance.v1.ListInstanceConfigsRequest,
      com.google.spanner.admin.instance.v1.ListInstanceConfigsResponse> getListInstanceConfigsMethod() {
    return getListInstanceConfigsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.spanner.admin.instance.v1.ListInstanceConfigsRequest,
      com.google.spanner.admin.instance.v1.ListInstanceConfigsResponse> getListInstanceConfigsMethodHelper() {
    io.grpc.MethodDescriptor<com.google.spanner.admin.instance.v1.ListInstanceConfigsRequest, com.google.spanner.admin.instance.v1.ListInstanceConfigsResponse> getListInstanceConfigsMethod;
    if ((getListInstanceConfigsMethod = InstanceAdminGrpc.getListInstanceConfigsMethod) == null) {
      synchronized (InstanceAdminGrpc.class) {
        if ((getListInstanceConfigsMethod = InstanceAdminGrpc.getListInstanceConfigsMethod) == null) {
          InstanceAdminGrpc.getListInstanceConfigsMethod = getListInstanceConfigsMethod = 
              io.grpc.MethodDescriptor.<com.google.spanner.admin.instance.v1.ListInstanceConfigsRequest, com.google.spanner.admin.instance.v1.ListInstanceConfigsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.spanner.admin.instance.v1.InstanceAdmin", "ListInstanceConfigs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.spanner.admin.instance.v1.ListInstanceConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.spanner.admin.instance.v1.ListInstanceConfigsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new InstanceAdminMethodDescriptorSupplier("ListInstanceConfigs"))
                  .build();
          }
        }
     }
     return getListInstanceConfigsMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetInstanceConfigMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.spanner.admin.instance.v1.GetInstanceConfigRequest,
      com.google.spanner.admin.instance.v1.InstanceConfig> METHOD_GET_INSTANCE_CONFIG = getGetInstanceConfigMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.spanner.admin.instance.v1.GetInstanceConfigRequest,
      com.google.spanner.admin.instance.v1.InstanceConfig> getGetInstanceConfigMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.spanner.admin.instance.v1.GetInstanceConfigRequest,
      com.google.spanner.admin.instance.v1.InstanceConfig> getGetInstanceConfigMethod() {
    return getGetInstanceConfigMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.spanner.admin.instance.v1.GetInstanceConfigRequest,
      com.google.spanner.admin.instance.v1.InstanceConfig> getGetInstanceConfigMethodHelper() {
    io.grpc.MethodDescriptor<com.google.spanner.admin.instance.v1.GetInstanceConfigRequest, com.google.spanner.admin.instance.v1.InstanceConfig> getGetInstanceConfigMethod;
    if ((getGetInstanceConfigMethod = InstanceAdminGrpc.getGetInstanceConfigMethod) == null) {
      synchronized (InstanceAdminGrpc.class) {
        if ((getGetInstanceConfigMethod = InstanceAdminGrpc.getGetInstanceConfigMethod) == null) {
          InstanceAdminGrpc.getGetInstanceConfigMethod = getGetInstanceConfigMethod = 
              io.grpc.MethodDescriptor.<com.google.spanner.admin.instance.v1.GetInstanceConfigRequest, com.google.spanner.admin.instance.v1.InstanceConfig>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.spanner.admin.instance.v1.InstanceAdmin", "GetInstanceConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.spanner.admin.instance.v1.GetInstanceConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.spanner.admin.instance.v1.InstanceConfig.getDefaultInstance()))
                  .setSchemaDescriptor(new InstanceAdminMethodDescriptorSupplier("GetInstanceConfig"))
                  .build();
          }
        }
     }
     return getGetInstanceConfigMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListInstancesMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.spanner.admin.instance.v1.ListInstancesRequest,
      com.google.spanner.admin.instance.v1.ListInstancesResponse> METHOD_LIST_INSTANCES = getListInstancesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.spanner.admin.instance.v1.ListInstancesRequest,
      com.google.spanner.admin.instance.v1.ListInstancesResponse> getListInstancesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.spanner.admin.instance.v1.ListInstancesRequest,
      com.google.spanner.admin.instance.v1.ListInstancesResponse> getListInstancesMethod() {
    return getListInstancesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.spanner.admin.instance.v1.ListInstancesRequest,
      com.google.spanner.admin.instance.v1.ListInstancesResponse> getListInstancesMethodHelper() {
    io.grpc.MethodDescriptor<com.google.spanner.admin.instance.v1.ListInstancesRequest, com.google.spanner.admin.instance.v1.ListInstancesResponse> getListInstancesMethod;
    if ((getListInstancesMethod = InstanceAdminGrpc.getListInstancesMethod) == null) {
      synchronized (InstanceAdminGrpc.class) {
        if ((getListInstancesMethod = InstanceAdminGrpc.getListInstancesMethod) == null) {
          InstanceAdminGrpc.getListInstancesMethod = getListInstancesMethod = 
              io.grpc.MethodDescriptor.<com.google.spanner.admin.instance.v1.ListInstancesRequest, com.google.spanner.admin.instance.v1.ListInstancesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.spanner.admin.instance.v1.InstanceAdmin", "ListInstances"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.spanner.admin.instance.v1.ListInstancesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.spanner.admin.instance.v1.ListInstancesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new InstanceAdminMethodDescriptorSupplier("ListInstances"))
                  .build();
          }
        }
     }
     return getListInstancesMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetInstanceMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.spanner.admin.instance.v1.GetInstanceRequest,
      com.google.spanner.admin.instance.v1.Instance> METHOD_GET_INSTANCE = getGetInstanceMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.spanner.admin.instance.v1.GetInstanceRequest,
      com.google.spanner.admin.instance.v1.Instance> getGetInstanceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.spanner.admin.instance.v1.GetInstanceRequest,
      com.google.spanner.admin.instance.v1.Instance> getGetInstanceMethod() {
    return getGetInstanceMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.spanner.admin.instance.v1.GetInstanceRequest,
      com.google.spanner.admin.instance.v1.Instance> getGetInstanceMethodHelper() {
    io.grpc.MethodDescriptor<com.google.spanner.admin.instance.v1.GetInstanceRequest, com.google.spanner.admin.instance.v1.Instance> getGetInstanceMethod;
    if ((getGetInstanceMethod = InstanceAdminGrpc.getGetInstanceMethod) == null) {
      synchronized (InstanceAdminGrpc.class) {
        if ((getGetInstanceMethod = InstanceAdminGrpc.getGetInstanceMethod) == null) {
          InstanceAdminGrpc.getGetInstanceMethod = getGetInstanceMethod = 
              io.grpc.MethodDescriptor.<com.google.spanner.admin.instance.v1.GetInstanceRequest, com.google.spanner.admin.instance.v1.Instance>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.spanner.admin.instance.v1.InstanceAdmin", "GetInstance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.spanner.admin.instance.v1.GetInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.spanner.admin.instance.v1.Instance.getDefaultInstance()))
                  .setSchemaDescriptor(new InstanceAdminMethodDescriptorSupplier("GetInstance"))
                  .build();
          }
        }
     }
     return getGetInstanceMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateInstanceMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.spanner.admin.instance.v1.CreateInstanceRequest,
      com.google.longrunning.Operation> METHOD_CREATE_INSTANCE = getCreateInstanceMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.spanner.admin.instance.v1.CreateInstanceRequest,
      com.google.longrunning.Operation> getCreateInstanceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.spanner.admin.instance.v1.CreateInstanceRequest,
      com.google.longrunning.Operation> getCreateInstanceMethod() {
    return getCreateInstanceMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.spanner.admin.instance.v1.CreateInstanceRequest,
      com.google.longrunning.Operation> getCreateInstanceMethodHelper() {
    io.grpc.MethodDescriptor<com.google.spanner.admin.instance.v1.CreateInstanceRequest, com.google.longrunning.Operation> getCreateInstanceMethod;
    if ((getCreateInstanceMethod = InstanceAdminGrpc.getCreateInstanceMethod) == null) {
      synchronized (InstanceAdminGrpc.class) {
        if ((getCreateInstanceMethod = InstanceAdminGrpc.getCreateInstanceMethod) == null) {
          InstanceAdminGrpc.getCreateInstanceMethod = getCreateInstanceMethod = 
              io.grpc.MethodDescriptor.<com.google.spanner.admin.instance.v1.CreateInstanceRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.spanner.admin.instance.v1.InstanceAdmin", "CreateInstance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.spanner.admin.instance.v1.CreateInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
                  .setSchemaDescriptor(new InstanceAdminMethodDescriptorSupplier("CreateInstance"))
                  .build();
          }
        }
     }
     return getCreateInstanceMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateInstanceMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.spanner.admin.instance.v1.UpdateInstanceRequest,
      com.google.longrunning.Operation> METHOD_UPDATE_INSTANCE = getUpdateInstanceMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.spanner.admin.instance.v1.UpdateInstanceRequest,
      com.google.longrunning.Operation> getUpdateInstanceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.spanner.admin.instance.v1.UpdateInstanceRequest,
      com.google.longrunning.Operation> getUpdateInstanceMethod() {
    return getUpdateInstanceMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.spanner.admin.instance.v1.UpdateInstanceRequest,
      com.google.longrunning.Operation> getUpdateInstanceMethodHelper() {
    io.grpc.MethodDescriptor<com.google.spanner.admin.instance.v1.UpdateInstanceRequest, com.google.longrunning.Operation> getUpdateInstanceMethod;
    if ((getUpdateInstanceMethod = InstanceAdminGrpc.getUpdateInstanceMethod) == null) {
      synchronized (InstanceAdminGrpc.class) {
        if ((getUpdateInstanceMethod = InstanceAdminGrpc.getUpdateInstanceMethod) == null) {
          InstanceAdminGrpc.getUpdateInstanceMethod = getUpdateInstanceMethod = 
              io.grpc.MethodDescriptor.<com.google.spanner.admin.instance.v1.UpdateInstanceRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.spanner.admin.instance.v1.InstanceAdmin", "UpdateInstance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.spanner.admin.instance.v1.UpdateInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
                  .setSchemaDescriptor(new InstanceAdminMethodDescriptorSupplier("UpdateInstance"))
                  .build();
          }
        }
     }
     return getUpdateInstanceMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteInstanceMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.spanner.admin.instance.v1.DeleteInstanceRequest,
      com.google.protobuf.Empty> METHOD_DELETE_INSTANCE = getDeleteInstanceMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.spanner.admin.instance.v1.DeleteInstanceRequest,
      com.google.protobuf.Empty> getDeleteInstanceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.spanner.admin.instance.v1.DeleteInstanceRequest,
      com.google.protobuf.Empty> getDeleteInstanceMethod() {
    return getDeleteInstanceMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.spanner.admin.instance.v1.DeleteInstanceRequest,
      com.google.protobuf.Empty> getDeleteInstanceMethodHelper() {
    io.grpc.MethodDescriptor<com.google.spanner.admin.instance.v1.DeleteInstanceRequest, com.google.protobuf.Empty> getDeleteInstanceMethod;
    if ((getDeleteInstanceMethod = InstanceAdminGrpc.getDeleteInstanceMethod) == null) {
      synchronized (InstanceAdminGrpc.class) {
        if ((getDeleteInstanceMethod = InstanceAdminGrpc.getDeleteInstanceMethod) == null) {
          InstanceAdminGrpc.getDeleteInstanceMethod = getDeleteInstanceMethod = 
              io.grpc.MethodDescriptor.<com.google.spanner.admin.instance.v1.DeleteInstanceRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.spanner.admin.instance.v1.InstanceAdmin", "DeleteInstance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.spanner.admin.instance.v1.DeleteInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new InstanceAdminMethodDescriptorSupplier("DeleteInstance"))
                  .build();
          }
        }
     }
     return getDeleteInstanceMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSetIamPolicyMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest,
      com.google.iam.v1.Policy> METHOD_SET_IAM_POLICY = getSetIamPolicyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest,
      com.google.iam.v1.Policy> getSetIamPolicyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest,
      com.google.iam.v1.Policy> getSetIamPolicyMethod() {
    return getSetIamPolicyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest,
      com.google.iam.v1.Policy> getSetIamPolicyMethodHelper() {
    io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy> getSetIamPolicyMethod;
    if ((getSetIamPolicyMethod = InstanceAdminGrpc.getSetIamPolicyMethod) == null) {
      synchronized (InstanceAdminGrpc.class) {
        if ((getSetIamPolicyMethod = InstanceAdminGrpc.getSetIamPolicyMethod) == null) {
          InstanceAdminGrpc.getSetIamPolicyMethod = getSetIamPolicyMethod = 
              io.grpc.MethodDescriptor.<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.spanner.admin.instance.v1.InstanceAdmin", "SetIamPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.SetIamPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.Policy.getDefaultInstance()))
                  .setSchemaDescriptor(new InstanceAdminMethodDescriptorSupplier("SetIamPolicy"))
                  .build();
          }
        }
     }
     return getSetIamPolicyMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetIamPolicyMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest,
      com.google.iam.v1.Policy> METHOD_GET_IAM_POLICY = getGetIamPolicyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest,
      com.google.iam.v1.Policy> getGetIamPolicyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest,
      com.google.iam.v1.Policy> getGetIamPolicyMethod() {
    return getGetIamPolicyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest,
      com.google.iam.v1.Policy> getGetIamPolicyMethodHelper() {
    io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy> getGetIamPolicyMethod;
    if ((getGetIamPolicyMethod = InstanceAdminGrpc.getGetIamPolicyMethod) == null) {
      synchronized (InstanceAdminGrpc.class) {
        if ((getGetIamPolicyMethod = InstanceAdminGrpc.getGetIamPolicyMethod) == null) {
          InstanceAdminGrpc.getGetIamPolicyMethod = getGetIamPolicyMethod = 
              io.grpc.MethodDescriptor.<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.spanner.admin.instance.v1.InstanceAdmin", "GetIamPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.GetIamPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.Policy.getDefaultInstance()))
                  .setSchemaDescriptor(new InstanceAdminMethodDescriptorSupplier("GetIamPolicy"))
                  .build();
          }
        }
     }
     return getGetIamPolicyMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getTestIamPermissionsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.iam.v1.TestIamPermissionsRequest,
      com.google.iam.v1.TestIamPermissionsResponse> METHOD_TEST_IAM_PERMISSIONS = getTestIamPermissionsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1.TestIamPermissionsRequest,
      com.google.iam.v1.TestIamPermissionsResponse> getTestIamPermissionsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.iam.v1.TestIamPermissionsRequest,
      com.google.iam.v1.TestIamPermissionsResponse> getTestIamPermissionsMethod() {
    return getTestIamPermissionsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.iam.v1.TestIamPermissionsRequest,
      com.google.iam.v1.TestIamPermissionsResponse> getTestIamPermissionsMethodHelper() {
    io.grpc.MethodDescriptor<com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse> getTestIamPermissionsMethod;
    if ((getTestIamPermissionsMethod = InstanceAdminGrpc.getTestIamPermissionsMethod) == null) {
      synchronized (InstanceAdminGrpc.class) {
        if ((getTestIamPermissionsMethod = InstanceAdminGrpc.getTestIamPermissionsMethod) == null) {
          InstanceAdminGrpc.getTestIamPermissionsMethod = getTestIamPermissionsMethod = 
              io.grpc.MethodDescriptor.<com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.spanner.admin.instance.v1.InstanceAdmin", "TestIamPermissions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.TestIamPermissionsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new InstanceAdminMethodDescriptorSupplier("TestIamPermissions"))
                  .build();
          }
        }
     }
     return getTestIamPermissionsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static InstanceAdminStub newStub(io.grpc.Channel channel) {
    return new InstanceAdminStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static InstanceAdminBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new InstanceAdminBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static InstanceAdminFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new InstanceAdminFutureStub(channel);
  }

  /**
   * <pre>
   * Cloud Spanner Instance Admin API
   * The Cloud Spanner Instance Admin API can be used to create, delete,
   * modify and list instances. Instances are dedicated Cloud Spanner serving
   * and storage resources to be used by Cloud Spanner databases.
   * Each instance has a "configuration", which dictates where the
   * serving resources for the Cloud Spanner instance are located (e.g.,
   * US-central, Europe). Configurations are created by Google based on
   * resource availability.
   * Cloud Spanner billing is based on the instances that exist and their
   * sizes. After an instance exists, there are no additional
   * per-database or per-operation charges for use of the instance
   * (though there may be additional network bandwidth charges).
   * Instances offer isolation: problems with databases in one instance
   * will not affect other instances. However, within an instance
   * databases can affect each other. For example, if one database in an
   * instance receives a lot of requests and consumes most of the
   * instance resources, fewer resources are available for other
   * databases in that instance, and their performance may suffer.
   * </pre>
   */
  public static abstract class InstanceAdminImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Lists the supported instance configurations for a given project.
     * </pre>
     */
    public void listInstanceConfigs(com.google.spanner.admin.instance.v1.ListInstanceConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.admin.instance.v1.ListInstanceConfigsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListInstanceConfigsMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Gets information about a particular instance configuration.
     * </pre>
     */
    public void getInstanceConfig(com.google.spanner.admin.instance.v1.GetInstanceConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.admin.instance.v1.InstanceConfig> responseObserver) {
      asyncUnimplementedUnaryCall(getGetInstanceConfigMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Lists all instances in the given project.
     * </pre>
     */
    public void listInstances(com.google.spanner.admin.instance.v1.ListInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.admin.instance.v1.ListInstancesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListInstancesMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Gets information about a particular instance.
     * </pre>
     */
    public void getInstance(com.google.spanner.admin.instance.v1.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.admin.instance.v1.Instance> responseObserver) {
      asyncUnimplementedUnaryCall(getGetInstanceMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Creates an instance and begins preparing it to begin serving. The
     * returned [long-running operation][google.longrunning.Operation]
     * can be used to track the progress of preparing the new
     * instance. The instance name is assigned by the caller. If the
     * named instance already exists, `CreateInstance` returns
     * `ALREADY_EXISTS`.
     * Immediately upon completion of this request:
     *   * The instance is readable via the API, with all requested attributes
     *     but no allocated resources. Its state is `CREATING`.
     * Until completion of the returned operation:
     *   * Cancelling the operation renders the instance immediately unreadable
     *     via the API.
     *   * The instance can be deleted.
     *   * All other attempts to modify the instance are rejected.
     * Upon completion of the returned operation:
     *   * Billing for all successfully-allocated resources begins (some types
     *     may have lower than the requested levels).
     *   * Databases can be created in the instance.
     *   * The instance's allocated resource levels are readable via the API.
     *   * The instance's state becomes `READY`.
     * The returned [long-running operation][google.longrunning.Operation] will
     * have a name of the format `&lt;instance_name&gt;/operations/&lt;operation_id&gt;` and
     * can be used to track creation of the instance.  The
     * [metadata][google.longrunning.Operation.metadata] field type is
     * [CreateInstanceMetadata][google.spanner.admin.instance.v1.CreateInstanceMetadata].
     * The [response][google.longrunning.Operation.response] field type is
     * [Instance][google.spanner.admin.instance.v1.Instance], if successful.
     * </pre>
     */
    public void createInstance(com.google.spanner.admin.instance.v1.CreateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateInstanceMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Updates an instance, and begins allocating or releasing resources
     * as requested. The returned [long-running
     * operation][google.longrunning.Operation] can be used to track the
     * progress of updating the instance. If the named instance does not
     * exist, returns `NOT_FOUND`.
     * Immediately upon completion of this request:
     *   * For resource types for which a decrease in the instance's allocation
     *     has been requested, billing is based on the newly-requested level.
     * Until completion of the returned operation:
     *   * Cancelling the operation sets its metadata's
     *     [cancel_time][google.spanner.admin.instance.v1.UpdateInstanceMetadata.cancel_time], and begins
     *     restoring resources to their pre-request values. The operation
     *     is guaranteed to succeed at undoing all resource changes,
     *     after which point it terminates with a `CANCELLED` status.
     *   * All other attempts to modify the instance are rejected.
     *   * Reading the instance via the API continues to give the pre-request
     *     resource levels.
     * Upon completion of the returned operation:
     *   * Billing begins for all successfully-allocated resources (some types
     *     may have lower than the requested levels).
     *   * All newly-reserved resources are available for serving the instance's
     *     tables.
     *   * The instance's new resource levels are readable via the API.
     * The returned [long-running operation][google.longrunning.Operation] will
     * have a name of the format `&lt;instance_name&gt;/operations/&lt;operation_id&gt;` and
     * can be used to track the instance modification.  The
     * [metadata][google.longrunning.Operation.metadata] field type is
     * [UpdateInstanceMetadata][google.spanner.admin.instance.v1.UpdateInstanceMetadata].
     * The [response][google.longrunning.Operation.response] field type is
     * [Instance][google.spanner.admin.instance.v1.Instance], if successful.
     * Authorization requires `spanner.instances.update` permission on
     * resource [name][google.spanner.admin.instance.v1.Instance.name].
     * </pre>
     */
    public void updateInstance(com.google.spanner.admin.instance.v1.UpdateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateInstanceMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Deletes an instance.
     * Immediately upon completion of the request:
     *   * Billing ceases for all of the instance's reserved resources.
     * Soon afterward:
     *   * The instance and *all of its databases* immediately and
     *     irrevocably disappear from the API. All data in the databases
     *     is permanently deleted.
     * </pre>
     */
    public void deleteInstance(com.google.spanner.admin.instance.v1.DeleteInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteInstanceMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Sets the access control policy on an instance resource. Replaces any
     * existing policy.
     * Authorization requires `spanner.instances.setIamPolicy` on
     * [resource][google.iam.v1.SetIamPolicyRequest.resource].
     * </pre>
     */
    public void setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      asyncUnimplementedUnaryCall(getSetIamPolicyMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Gets the access control policy for an instance resource. Returns an empty
     * policy if an instance exists but does not have a policy set.
     * Authorization requires `spanner.instances.getIamPolicy` on
     * [resource][google.iam.v1.GetIamPolicyRequest.resource].
     * </pre>
     */
    public void getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      asyncUnimplementedUnaryCall(getGetIamPolicyMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Returns permissions that the caller has on the specified instance resource.
     * Attempting this RPC on a non-existent Cloud Spanner instance resource will
     * result in a NOT_FOUND error if the user has `spanner.instances.list`
     * permission on the containing Google Cloud Project. Otherwise returns an
     * empty set of permissions.
     * </pre>
     */
    public void testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getTestIamPermissionsMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListInstanceConfigsMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.spanner.admin.instance.v1.ListInstanceConfigsRequest,
                com.google.spanner.admin.instance.v1.ListInstanceConfigsResponse>(
                  this, METHODID_LIST_INSTANCE_CONFIGS)))
          .addMethod(
            getGetInstanceConfigMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.spanner.admin.instance.v1.GetInstanceConfigRequest,
                com.google.spanner.admin.instance.v1.InstanceConfig>(
                  this, METHODID_GET_INSTANCE_CONFIG)))
          .addMethod(
            getListInstancesMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.spanner.admin.instance.v1.ListInstancesRequest,
                com.google.spanner.admin.instance.v1.ListInstancesResponse>(
                  this, METHODID_LIST_INSTANCES)))
          .addMethod(
            getGetInstanceMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.spanner.admin.instance.v1.GetInstanceRequest,
                com.google.spanner.admin.instance.v1.Instance>(
                  this, METHODID_GET_INSTANCE)))
          .addMethod(
            getCreateInstanceMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.spanner.admin.instance.v1.CreateInstanceRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_INSTANCE)))
          .addMethod(
            getUpdateInstanceMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.spanner.admin.instance.v1.UpdateInstanceRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_INSTANCE)))
          .addMethod(
            getDeleteInstanceMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.spanner.admin.instance.v1.DeleteInstanceRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_INSTANCE)))
          .addMethod(
            getSetIamPolicyMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.v1.SetIamPolicyRequest,
                com.google.iam.v1.Policy>(
                  this, METHODID_SET_IAM_POLICY)))
          .addMethod(
            getGetIamPolicyMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.v1.GetIamPolicyRequest,
                com.google.iam.v1.Policy>(
                  this, METHODID_GET_IAM_POLICY)))
          .addMethod(
            getTestIamPermissionsMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.v1.TestIamPermissionsRequest,
                com.google.iam.v1.TestIamPermissionsResponse>(
                  this, METHODID_TEST_IAM_PERMISSIONS)))
          .build();
    }
  }

  /**
   * <pre>
   * Cloud Spanner Instance Admin API
   * The Cloud Spanner Instance Admin API can be used to create, delete,
   * modify and list instances. Instances are dedicated Cloud Spanner serving
   * and storage resources to be used by Cloud Spanner databases.
   * Each instance has a "configuration", which dictates where the
   * serving resources for the Cloud Spanner instance are located (e.g.,
   * US-central, Europe). Configurations are created by Google based on
   * resource availability.
   * Cloud Spanner billing is based on the instances that exist and their
   * sizes. After an instance exists, there are no additional
   * per-database or per-operation charges for use of the instance
   * (though there may be additional network bandwidth charges).
   * Instances offer isolation: problems with databases in one instance
   * will not affect other instances. However, within an instance
   * databases can affect each other. For example, if one database in an
   * instance receives a lot of requests and consumes most of the
   * instance resources, fewer resources are available for other
   * databases in that instance, and their performance may suffer.
   * </pre>
   */
  public static final class InstanceAdminStub extends io.grpc.stub.AbstractStub<InstanceAdminStub> {
    private InstanceAdminStub(io.grpc.Channel channel) {
      super(channel);
    }

    private InstanceAdminStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InstanceAdminStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new InstanceAdminStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists the supported instance configurations for a given project.
     * </pre>
     */
    public void listInstanceConfigs(com.google.spanner.admin.instance.v1.ListInstanceConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.admin.instance.v1.ListInstanceConfigsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListInstanceConfigsMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets information about a particular instance configuration.
     * </pre>
     */
    public void getInstanceConfig(com.google.spanner.admin.instance.v1.GetInstanceConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.admin.instance.v1.InstanceConfig> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetInstanceConfigMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists all instances in the given project.
     * </pre>
     */
    public void listInstances(com.google.spanner.admin.instance.v1.ListInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.admin.instance.v1.ListInstancesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListInstancesMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets information about a particular instance.
     * </pre>
     */
    public void getInstance(com.google.spanner.admin.instance.v1.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.spanner.admin.instance.v1.Instance> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetInstanceMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates an instance and begins preparing it to begin serving. The
     * returned [long-running operation][google.longrunning.Operation]
     * can be used to track the progress of preparing the new
     * instance. The instance name is assigned by the caller. If the
     * named instance already exists, `CreateInstance` returns
     * `ALREADY_EXISTS`.
     * Immediately upon completion of this request:
     *   * The instance is readable via the API, with all requested attributes
     *     but no allocated resources. Its state is `CREATING`.
     * Until completion of the returned operation:
     *   * Cancelling the operation renders the instance immediately unreadable
     *     via the API.
     *   * The instance can be deleted.
     *   * All other attempts to modify the instance are rejected.
     * Upon completion of the returned operation:
     *   * Billing for all successfully-allocated resources begins (some types
     *     may have lower than the requested levels).
     *   * Databases can be created in the instance.
     *   * The instance's allocated resource levels are readable via the API.
     *   * The instance's state becomes `READY`.
     * The returned [long-running operation][google.longrunning.Operation] will
     * have a name of the format `&lt;instance_name&gt;/operations/&lt;operation_id&gt;` and
     * can be used to track creation of the instance.  The
     * [metadata][google.longrunning.Operation.metadata] field type is
     * [CreateInstanceMetadata][google.spanner.admin.instance.v1.CreateInstanceMetadata].
     * The [response][google.longrunning.Operation.response] field type is
     * [Instance][google.spanner.admin.instance.v1.Instance], if successful.
     * </pre>
     */
    public void createInstance(com.google.spanner.admin.instance.v1.CreateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateInstanceMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates an instance, and begins allocating or releasing resources
     * as requested. The returned [long-running
     * operation][google.longrunning.Operation] can be used to track the
     * progress of updating the instance. If the named instance does not
     * exist, returns `NOT_FOUND`.
     * Immediately upon completion of this request:
     *   * For resource types for which a decrease in the instance's allocation
     *     has been requested, billing is based on the newly-requested level.
     * Until completion of the returned operation:
     *   * Cancelling the operation sets its metadata's
     *     [cancel_time][google.spanner.admin.instance.v1.UpdateInstanceMetadata.cancel_time], and begins
     *     restoring resources to their pre-request values. The operation
     *     is guaranteed to succeed at undoing all resource changes,
     *     after which point it terminates with a `CANCELLED` status.
     *   * All other attempts to modify the instance are rejected.
     *   * Reading the instance via the API continues to give the pre-request
     *     resource levels.
     * Upon completion of the returned operation:
     *   * Billing begins for all successfully-allocated resources (some types
     *     may have lower than the requested levels).
     *   * All newly-reserved resources are available for serving the instance's
     *     tables.
     *   * The instance's new resource levels are readable via the API.
     * The returned [long-running operation][google.longrunning.Operation] will
     * have a name of the format `&lt;instance_name&gt;/operations/&lt;operation_id&gt;` and
     * can be used to track the instance modification.  The
     * [metadata][google.longrunning.Operation.metadata] field type is
     * [UpdateInstanceMetadata][google.spanner.admin.instance.v1.UpdateInstanceMetadata].
     * The [response][google.longrunning.Operation.response] field type is
     * [Instance][google.spanner.admin.instance.v1.Instance], if successful.
     * Authorization requires `spanner.instances.update` permission on
     * resource [name][google.spanner.admin.instance.v1.Instance.name].
     * </pre>
     */
    public void updateInstance(com.google.spanner.admin.instance.v1.UpdateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateInstanceMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes an instance.
     * Immediately upon completion of the request:
     *   * Billing ceases for all of the instance's reserved resources.
     * Soon afterward:
     *   * The instance and *all of its databases* immediately and
     *     irrevocably disappear from the API. All data in the databases
     *     is permanently deleted.
     * </pre>
     */
    public void deleteInstance(com.google.spanner.admin.instance.v1.DeleteInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteInstanceMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Sets the access control policy on an instance resource. Replaces any
     * existing policy.
     * Authorization requires `spanner.instances.setIamPolicy` on
     * [resource][google.iam.v1.SetIamPolicyRequest.resource].
     * </pre>
     */
    public void setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetIamPolicyMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the access control policy for an instance resource. Returns an empty
     * policy if an instance exists but does not have a policy set.
     * Authorization requires `spanner.instances.getIamPolicy` on
     * [resource][google.iam.v1.GetIamPolicyRequest.resource].
     * </pre>
     */
    public void getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetIamPolicyMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns permissions that the caller has on the specified instance resource.
     * Attempting this RPC on a non-existent Cloud Spanner instance resource will
     * result in a NOT_FOUND error if the user has `spanner.instances.list`
     * permission on the containing Google Cloud Project. Otherwise returns an
     * empty set of permissions.
     * </pre>
     */
    public void testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Cloud Spanner Instance Admin API
   * The Cloud Spanner Instance Admin API can be used to create, delete,
   * modify and list instances. Instances are dedicated Cloud Spanner serving
   * and storage resources to be used by Cloud Spanner databases.
   * Each instance has a "configuration", which dictates where the
   * serving resources for the Cloud Spanner instance are located (e.g.,
   * US-central, Europe). Configurations are created by Google based on
   * resource availability.
   * Cloud Spanner billing is based on the instances that exist and their
   * sizes. After an instance exists, there are no additional
   * per-database or per-operation charges for use of the instance
   * (though there may be additional network bandwidth charges).
   * Instances offer isolation: problems with databases in one instance
   * will not affect other instances. However, within an instance
   * databases can affect each other. For example, if one database in an
   * instance receives a lot of requests and consumes most of the
   * instance resources, fewer resources are available for other
   * databases in that instance, and their performance may suffer.
   * </pre>
   */
  public static final class InstanceAdminBlockingStub extends io.grpc.stub.AbstractStub<InstanceAdminBlockingStub> {
    private InstanceAdminBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private InstanceAdminBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InstanceAdminBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new InstanceAdminBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists the supported instance configurations for a given project.
     * </pre>
     */
    public com.google.spanner.admin.instance.v1.ListInstanceConfigsResponse listInstanceConfigs(com.google.spanner.admin.instance.v1.ListInstanceConfigsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListInstanceConfigsMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets information about a particular instance configuration.
     * </pre>
     */
    public com.google.spanner.admin.instance.v1.InstanceConfig getInstanceConfig(com.google.spanner.admin.instance.v1.GetInstanceConfigRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetInstanceConfigMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists all instances in the given project.
     * </pre>
     */
    public com.google.spanner.admin.instance.v1.ListInstancesResponse listInstances(com.google.spanner.admin.instance.v1.ListInstancesRequest request) {
      return blockingUnaryCall(
          getChannel(), getListInstancesMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets information about a particular instance.
     * </pre>
     */
    public com.google.spanner.admin.instance.v1.Instance getInstance(com.google.spanner.admin.instance.v1.GetInstanceRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetInstanceMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates an instance and begins preparing it to begin serving. The
     * returned [long-running operation][google.longrunning.Operation]
     * can be used to track the progress of preparing the new
     * instance. The instance name is assigned by the caller. If the
     * named instance already exists, `CreateInstance` returns
     * `ALREADY_EXISTS`.
     * Immediately upon completion of this request:
     *   * The instance is readable via the API, with all requested attributes
     *     but no allocated resources. Its state is `CREATING`.
     * Until completion of the returned operation:
     *   * Cancelling the operation renders the instance immediately unreadable
     *     via the API.
     *   * The instance can be deleted.
     *   * All other attempts to modify the instance are rejected.
     * Upon completion of the returned operation:
     *   * Billing for all successfully-allocated resources begins (some types
     *     may have lower than the requested levels).
     *   * Databases can be created in the instance.
     *   * The instance's allocated resource levels are readable via the API.
     *   * The instance's state becomes `READY`.
     * The returned [long-running operation][google.longrunning.Operation] will
     * have a name of the format `&lt;instance_name&gt;/operations/&lt;operation_id&gt;` and
     * can be used to track creation of the instance.  The
     * [metadata][google.longrunning.Operation.metadata] field type is
     * [CreateInstanceMetadata][google.spanner.admin.instance.v1.CreateInstanceMetadata].
     * The [response][google.longrunning.Operation.response] field type is
     * [Instance][google.spanner.admin.instance.v1.Instance], if successful.
     * </pre>
     */
    public com.google.longrunning.Operation createInstance(com.google.spanner.admin.instance.v1.CreateInstanceRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateInstanceMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates an instance, and begins allocating or releasing resources
     * as requested. The returned [long-running
     * operation][google.longrunning.Operation] can be used to track the
     * progress of updating the instance. If the named instance does not
     * exist, returns `NOT_FOUND`.
     * Immediately upon completion of this request:
     *   * For resource types for which a decrease in the instance's allocation
     *     has been requested, billing is based on the newly-requested level.
     * Until completion of the returned operation:
     *   * Cancelling the operation sets its metadata's
     *     [cancel_time][google.spanner.admin.instance.v1.UpdateInstanceMetadata.cancel_time], and begins
     *     restoring resources to their pre-request values. The operation
     *     is guaranteed to succeed at undoing all resource changes,
     *     after which point it terminates with a `CANCELLED` status.
     *   * All other attempts to modify the instance are rejected.
     *   * Reading the instance via the API continues to give the pre-request
     *     resource levels.
     * Upon completion of the returned operation:
     *   * Billing begins for all successfully-allocated resources (some types
     *     may have lower than the requested levels).
     *   * All newly-reserved resources are available for serving the instance's
     *     tables.
     *   * The instance's new resource levels are readable via the API.
     * The returned [long-running operation][google.longrunning.Operation] will
     * have a name of the format `&lt;instance_name&gt;/operations/&lt;operation_id&gt;` and
     * can be used to track the instance modification.  The
     * [metadata][google.longrunning.Operation.metadata] field type is
     * [UpdateInstanceMetadata][google.spanner.admin.instance.v1.UpdateInstanceMetadata].
     * The [response][google.longrunning.Operation.response] field type is
     * [Instance][google.spanner.admin.instance.v1.Instance], if successful.
     * Authorization requires `spanner.instances.update` permission on
     * resource [name][google.spanner.admin.instance.v1.Instance.name].
     * </pre>
     */
    public com.google.longrunning.Operation updateInstance(com.google.spanner.admin.instance.v1.UpdateInstanceRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateInstanceMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes an instance.
     * Immediately upon completion of the request:
     *   * Billing ceases for all of the instance's reserved resources.
     * Soon afterward:
     *   * The instance and *all of its databases* immediately and
     *     irrevocably disappear from the API. All data in the databases
     *     is permanently deleted.
     * </pre>
     */
    public com.google.protobuf.Empty deleteInstance(com.google.spanner.admin.instance.v1.DeleteInstanceRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteInstanceMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Sets the access control policy on an instance resource. Replaces any
     * existing policy.
     * Authorization requires `spanner.instances.setIamPolicy` on
     * [resource][google.iam.v1.SetIamPolicyRequest.resource].
     * </pre>
     */
    public com.google.iam.v1.Policy setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetIamPolicyMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the access control policy for an instance resource. Returns an empty
     * policy if an instance exists but does not have a policy set.
     * Authorization requires `spanner.instances.getIamPolicy` on
     * [resource][google.iam.v1.GetIamPolicyRequest.resource].
     * </pre>
     */
    public com.google.iam.v1.Policy getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetIamPolicyMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns permissions that the caller has on the specified instance resource.
     * Attempting this RPC on a non-existent Cloud Spanner instance resource will
     * result in a NOT_FOUND error if the user has `spanner.instances.list`
     * permission on the containing Google Cloud Project. Otherwise returns an
     * empty set of permissions.
     * </pre>
     */
    public com.google.iam.v1.TestIamPermissionsResponse testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request) {
      return blockingUnaryCall(
          getChannel(), getTestIamPermissionsMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Cloud Spanner Instance Admin API
   * The Cloud Spanner Instance Admin API can be used to create, delete,
   * modify and list instances. Instances are dedicated Cloud Spanner serving
   * and storage resources to be used by Cloud Spanner databases.
   * Each instance has a "configuration", which dictates where the
   * serving resources for the Cloud Spanner instance are located (e.g.,
   * US-central, Europe). Configurations are created by Google based on
   * resource availability.
   * Cloud Spanner billing is based on the instances that exist and their
   * sizes. After an instance exists, there are no additional
   * per-database or per-operation charges for use of the instance
   * (though there may be additional network bandwidth charges).
   * Instances offer isolation: problems with databases in one instance
   * will not affect other instances. However, within an instance
   * databases can affect each other. For example, if one database in an
   * instance receives a lot of requests and consumes most of the
   * instance resources, fewer resources are available for other
   * databases in that instance, and their performance may suffer.
   * </pre>
   */
  public static final class InstanceAdminFutureStub extends io.grpc.stub.AbstractStub<InstanceAdminFutureStub> {
    private InstanceAdminFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private InstanceAdminFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InstanceAdminFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new InstanceAdminFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists the supported instance configurations for a given project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.spanner.admin.instance.v1.ListInstanceConfigsResponse> listInstanceConfigs(
        com.google.spanner.admin.instance.v1.ListInstanceConfigsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListInstanceConfigsMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets information about a particular instance configuration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.spanner.admin.instance.v1.InstanceConfig> getInstanceConfig(
        com.google.spanner.admin.instance.v1.GetInstanceConfigRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetInstanceConfigMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists all instances in the given project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.spanner.admin.instance.v1.ListInstancesResponse> listInstances(
        com.google.spanner.admin.instance.v1.ListInstancesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListInstancesMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets information about a particular instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.spanner.admin.instance.v1.Instance> getInstance(
        com.google.spanner.admin.instance.v1.GetInstanceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetInstanceMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates an instance and begins preparing it to begin serving. The
     * returned [long-running operation][google.longrunning.Operation]
     * can be used to track the progress of preparing the new
     * instance. The instance name is assigned by the caller. If the
     * named instance already exists, `CreateInstance` returns
     * `ALREADY_EXISTS`.
     * Immediately upon completion of this request:
     *   * The instance is readable via the API, with all requested attributes
     *     but no allocated resources. Its state is `CREATING`.
     * Until completion of the returned operation:
     *   * Cancelling the operation renders the instance immediately unreadable
     *     via the API.
     *   * The instance can be deleted.
     *   * All other attempts to modify the instance are rejected.
     * Upon completion of the returned operation:
     *   * Billing for all successfully-allocated resources begins (some types
     *     may have lower than the requested levels).
     *   * Databases can be created in the instance.
     *   * The instance's allocated resource levels are readable via the API.
     *   * The instance's state becomes `READY`.
     * The returned [long-running operation][google.longrunning.Operation] will
     * have a name of the format `&lt;instance_name&gt;/operations/&lt;operation_id&gt;` and
     * can be used to track creation of the instance.  The
     * [metadata][google.longrunning.Operation.metadata] field type is
     * [CreateInstanceMetadata][google.spanner.admin.instance.v1.CreateInstanceMetadata].
     * The [response][google.longrunning.Operation.response] field type is
     * [Instance][google.spanner.admin.instance.v1.Instance], if successful.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createInstance(
        com.google.spanner.admin.instance.v1.CreateInstanceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateInstanceMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates an instance, and begins allocating or releasing resources
     * as requested. The returned [long-running
     * operation][google.longrunning.Operation] can be used to track the
     * progress of updating the instance. If the named instance does not
     * exist, returns `NOT_FOUND`.
     * Immediately upon completion of this request:
     *   * For resource types for which a decrease in the instance's allocation
     *     has been requested, billing is based on the newly-requested level.
     * Until completion of the returned operation:
     *   * Cancelling the operation sets its metadata's
     *     [cancel_time][google.spanner.admin.instance.v1.UpdateInstanceMetadata.cancel_time], and begins
     *     restoring resources to their pre-request values. The operation
     *     is guaranteed to succeed at undoing all resource changes,
     *     after which point it terminates with a `CANCELLED` status.
     *   * All other attempts to modify the instance are rejected.
     *   * Reading the instance via the API continues to give the pre-request
     *     resource levels.
     * Upon completion of the returned operation:
     *   * Billing begins for all successfully-allocated resources (some types
     *     may have lower than the requested levels).
     *   * All newly-reserved resources are available for serving the instance's
     *     tables.
     *   * The instance's new resource levels are readable via the API.
     * The returned [long-running operation][google.longrunning.Operation] will
     * have a name of the format `&lt;instance_name&gt;/operations/&lt;operation_id&gt;` and
     * can be used to track the instance modification.  The
     * [metadata][google.longrunning.Operation.metadata] field type is
     * [UpdateInstanceMetadata][google.spanner.admin.instance.v1.UpdateInstanceMetadata].
     * The [response][google.longrunning.Operation.response] field type is
     * [Instance][google.spanner.admin.instance.v1.Instance], if successful.
     * Authorization requires `spanner.instances.update` permission on
     * resource [name][google.spanner.admin.instance.v1.Instance.name].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateInstance(
        com.google.spanner.admin.instance.v1.UpdateInstanceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateInstanceMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes an instance.
     * Immediately upon completion of the request:
     *   * Billing ceases for all of the instance's reserved resources.
     * Soon afterward:
     *   * The instance and *all of its databases* immediately and
     *     irrevocably disappear from the API. All data in the databases
     *     is permanently deleted.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteInstance(
        com.google.spanner.admin.instance.v1.DeleteInstanceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteInstanceMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Sets the access control policy on an instance resource. Replaces any
     * existing policy.
     * Authorization requires `spanner.instances.setIamPolicy` on
     * [resource][google.iam.v1.SetIamPolicyRequest.resource].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy> setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetIamPolicyMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the access control policy for an instance resource. Returns an empty
     * policy if an instance exists but does not have a policy set.
     * Authorization requires `spanner.instances.getIamPolicy` on
     * [resource][google.iam.v1.GetIamPolicyRequest.resource].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy> getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetIamPolicyMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns permissions that the caller has on the specified instance resource.
     * Attempting this RPC on a non-existent Cloud Spanner instance resource will
     * result in a NOT_FOUND error if the user has `spanner.instances.list`
     * permission on the containing Google Cloud Project. Otherwise returns an
     * empty set of permissions.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.TestIamPermissionsResponse> testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_INSTANCE_CONFIGS = 0;
  private static final int METHODID_GET_INSTANCE_CONFIG = 1;
  private static final int METHODID_LIST_INSTANCES = 2;
  private static final int METHODID_GET_INSTANCE = 3;
  private static final int METHODID_CREATE_INSTANCE = 4;
  private static final int METHODID_UPDATE_INSTANCE = 5;
  private static final int METHODID_DELETE_INSTANCE = 6;
  private static final int METHODID_SET_IAM_POLICY = 7;
  private static final int METHODID_GET_IAM_POLICY = 8;
  private static final int METHODID_TEST_IAM_PERMISSIONS = 9;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final InstanceAdminImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(InstanceAdminImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_INSTANCE_CONFIGS:
          serviceImpl.listInstanceConfigs((com.google.spanner.admin.instance.v1.ListInstanceConfigsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.spanner.admin.instance.v1.ListInstanceConfigsResponse>) responseObserver);
          break;
        case METHODID_GET_INSTANCE_CONFIG:
          serviceImpl.getInstanceConfig((com.google.spanner.admin.instance.v1.GetInstanceConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.spanner.admin.instance.v1.InstanceConfig>) responseObserver);
          break;
        case METHODID_LIST_INSTANCES:
          serviceImpl.listInstances((com.google.spanner.admin.instance.v1.ListInstancesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.spanner.admin.instance.v1.ListInstancesResponse>) responseObserver);
          break;
        case METHODID_GET_INSTANCE:
          serviceImpl.getInstance((com.google.spanner.admin.instance.v1.GetInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.spanner.admin.instance.v1.Instance>) responseObserver);
          break;
        case METHODID_CREATE_INSTANCE:
          serviceImpl.createInstance((com.google.spanner.admin.instance.v1.CreateInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_INSTANCE:
          serviceImpl.updateInstance((com.google.spanner.admin.instance.v1.UpdateInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_INSTANCE:
          serviceImpl.deleteInstance((com.google.spanner.admin.instance.v1.DeleteInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_SET_IAM_POLICY:
          serviceImpl.setIamPolicy((com.google.iam.v1.SetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_GET_IAM_POLICY:
          serviceImpl.getIamPolicy((com.google.iam.v1.GetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_TEST_IAM_PERMISSIONS:
          serviceImpl.testIamPermissions((com.google.iam.v1.TestIamPermissionsRequest) request,
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

  private static abstract class InstanceAdminBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    InstanceAdminBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.spanner.admin.instance.v1.SpannerInstanceAdminProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("InstanceAdmin");
    }
  }

  private static final class InstanceAdminFileDescriptorSupplier
      extends InstanceAdminBaseDescriptorSupplier {
    InstanceAdminFileDescriptorSupplier() {}
  }

  private static final class InstanceAdminMethodDescriptorSupplier
      extends InstanceAdminBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    InstanceAdminMethodDescriptorSupplier(String methodName) {
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
      synchronized (InstanceAdminGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new InstanceAdminFileDescriptorSupplier())
              .addMethod(getListInstanceConfigsMethodHelper())
              .addMethod(getGetInstanceConfigMethodHelper())
              .addMethod(getListInstancesMethodHelper())
              .addMethod(getGetInstanceMethodHelper())
              .addMethod(getCreateInstanceMethodHelper())
              .addMethod(getUpdateInstanceMethodHelper())
              .addMethod(getDeleteInstanceMethodHelper())
              .addMethod(getSetIamPolicyMethodHelper())
              .addMethod(getGetIamPolicyMethodHelper())
              .addMethod(getTestIamPermissionsMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
