package com.google.cloud.config.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Infrastructure Manager is a managed service that automates the deployment and
 * management of Google Cloud infrastructure resources.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/config/v1/config.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ConfigGrpc {

  private ConfigGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.config.v1.Config";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.config.v1.ListDeploymentsRequest,
      com.google.cloud.config.v1.ListDeploymentsResponse> getListDeploymentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDeployments",
      requestType = com.google.cloud.config.v1.ListDeploymentsRequest.class,
      responseType = com.google.cloud.config.v1.ListDeploymentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.config.v1.ListDeploymentsRequest,
      com.google.cloud.config.v1.ListDeploymentsResponse> getListDeploymentsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.config.v1.ListDeploymentsRequest, com.google.cloud.config.v1.ListDeploymentsResponse> getListDeploymentsMethod;
    if ((getListDeploymentsMethod = ConfigGrpc.getListDeploymentsMethod) == null) {
      synchronized (ConfigGrpc.class) {
        if ((getListDeploymentsMethod = ConfigGrpc.getListDeploymentsMethod) == null) {
          ConfigGrpc.getListDeploymentsMethod = getListDeploymentsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.config.v1.ListDeploymentsRequest, com.google.cloud.config.v1.ListDeploymentsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDeployments"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.config.v1.ListDeploymentsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.config.v1.ListDeploymentsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ConfigMethodDescriptorSupplier("ListDeployments"))
              .build();
        }
      }
    }
    return getListDeploymentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.config.v1.GetDeploymentRequest,
      com.google.cloud.config.v1.Deployment> getGetDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDeployment",
      requestType = com.google.cloud.config.v1.GetDeploymentRequest.class,
      responseType = com.google.cloud.config.v1.Deployment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.config.v1.GetDeploymentRequest,
      com.google.cloud.config.v1.Deployment> getGetDeploymentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.config.v1.GetDeploymentRequest, com.google.cloud.config.v1.Deployment> getGetDeploymentMethod;
    if ((getGetDeploymentMethod = ConfigGrpc.getGetDeploymentMethod) == null) {
      synchronized (ConfigGrpc.class) {
        if ((getGetDeploymentMethod = ConfigGrpc.getGetDeploymentMethod) == null) {
          ConfigGrpc.getGetDeploymentMethod = getGetDeploymentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.config.v1.GetDeploymentRequest, com.google.cloud.config.v1.Deployment>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDeployment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.config.v1.GetDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.config.v1.Deployment.getDefaultInstance()))
              .setSchemaDescriptor(new ConfigMethodDescriptorSupplier("GetDeployment"))
              .build();
        }
      }
    }
    return getGetDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.config.v1.CreateDeploymentRequest,
      com.google.longrunning.Operation> getCreateDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDeployment",
      requestType = com.google.cloud.config.v1.CreateDeploymentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.config.v1.CreateDeploymentRequest,
      com.google.longrunning.Operation> getCreateDeploymentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.config.v1.CreateDeploymentRequest, com.google.longrunning.Operation> getCreateDeploymentMethod;
    if ((getCreateDeploymentMethod = ConfigGrpc.getCreateDeploymentMethod) == null) {
      synchronized (ConfigGrpc.class) {
        if ((getCreateDeploymentMethod = ConfigGrpc.getCreateDeploymentMethod) == null) {
          ConfigGrpc.getCreateDeploymentMethod = getCreateDeploymentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.config.v1.CreateDeploymentRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateDeployment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.config.v1.CreateDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ConfigMethodDescriptorSupplier("CreateDeployment"))
              .build();
        }
      }
    }
    return getCreateDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.config.v1.UpdateDeploymentRequest,
      com.google.longrunning.Operation> getUpdateDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDeployment",
      requestType = com.google.cloud.config.v1.UpdateDeploymentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.config.v1.UpdateDeploymentRequest,
      com.google.longrunning.Operation> getUpdateDeploymentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.config.v1.UpdateDeploymentRequest, com.google.longrunning.Operation> getUpdateDeploymentMethod;
    if ((getUpdateDeploymentMethod = ConfigGrpc.getUpdateDeploymentMethod) == null) {
      synchronized (ConfigGrpc.class) {
        if ((getUpdateDeploymentMethod = ConfigGrpc.getUpdateDeploymentMethod) == null) {
          ConfigGrpc.getUpdateDeploymentMethod = getUpdateDeploymentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.config.v1.UpdateDeploymentRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateDeployment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.config.v1.UpdateDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ConfigMethodDescriptorSupplier("UpdateDeployment"))
              .build();
        }
      }
    }
    return getUpdateDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.config.v1.DeleteDeploymentRequest,
      com.google.longrunning.Operation> getDeleteDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDeployment",
      requestType = com.google.cloud.config.v1.DeleteDeploymentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.config.v1.DeleteDeploymentRequest,
      com.google.longrunning.Operation> getDeleteDeploymentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.config.v1.DeleteDeploymentRequest, com.google.longrunning.Operation> getDeleteDeploymentMethod;
    if ((getDeleteDeploymentMethod = ConfigGrpc.getDeleteDeploymentMethod) == null) {
      synchronized (ConfigGrpc.class) {
        if ((getDeleteDeploymentMethod = ConfigGrpc.getDeleteDeploymentMethod) == null) {
          ConfigGrpc.getDeleteDeploymentMethod = getDeleteDeploymentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.config.v1.DeleteDeploymentRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteDeployment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.config.v1.DeleteDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ConfigMethodDescriptorSupplier("DeleteDeployment"))
              .build();
        }
      }
    }
    return getDeleteDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.config.v1.ListRevisionsRequest,
      com.google.cloud.config.v1.ListRevisionsResponse> getListRevisionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRevisions",
      requestType = com.google.cloud.config.v1.ListRevisionsRequest.class,
      responseType = com.google.cloud.config.v1.ListRevisionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.config.v1.ListRevisionsRequest,
      com.google.cloud.config.v1.ListRevisionsResponse> getListRevisionsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.config.v1.ListRevisionsRequest, com.google.cloud.config.v1.ListRevisionsResponse> getListRevisionsMethod;
    if ((getListRevisionsMethod = ConfigGrpc.getListRevisionsMethod) == null) {
      synchronized (ConfigGrpc.class) {
        if ((getListRevisionsMethod = ConfigGrpc.getListRevisionsMethod) == null) {
          ConfigGrpc.getListRevisionsMethod = getListRevisionsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.config.v1.ListRevisionsRequest, com.google.cloud.config.v1.ListRevisionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListRevisions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.config.v1.ListRevisionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.config.v1.ListRevisionsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ConfigMethodDescriptorSupplier("ListRevisions"))
              .build();
        }
      }
    }
    return getListRevisionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.config.v1.GetRevisionRequest,
      com.google.cloud.config.v1.Revision> getGetRevisionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRevision",
      requestType = com.google.cloud.config.v1.GetRevisionRequest.class,
      responseType = com.google.cloud.config.v1.Revision.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.config.v1.GetRevisionRequest,
      com.google.cloud.config.v1.Revision> getGetRevisionMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.config.v1.GetRevisionRequest, com.google.cloud.config.v1.Revision> getGetRevisionMethod;
    if ((getGetRevisionMethod = ConfigGrpc.getGetRevisionMethod) == null) {
      synchronized (ConfigGrpc.class) {
        if ((getGetRevisionMethod = ConfigGrpc.getGetRevisionMethod) == null) {
          ConfigGrpc.getGetRevisionMethod = getGetRevisionMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.config.v1.GetRevisionRequest, com.google.cloud.config.v1.Revision>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRevision"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.config.v1.GetRevisionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.config.v1.Revision.getDefaultInstance()))
              .setSchemaDescriptor(new ConfigMethodDescriptorSupplier("GetRevision"))
              .build();
        }
      }
    }
    return getGetRevisionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.config.v1.GetResourceRequest,
      com.google.cloud.config.v1.Resource> getGetResourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetResource",
      requestType = com.google.cloud.config.v1.GetResourceRequest.class,
      responseType = com.google.cloud.config.v1.Resource.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.config.v1.GetResourceRequest,
      com.google.cloud.config.v1.Resource> getGetResourceMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.config.v1.GetResourceRequest, com.google.cloud.config.v1.Resource> getGetResourceMethod;
    if ((getGetResourceMethod = ConfigGrpc.getGetResourceMethod) == null) {
      synchronized (ConfigGrpc.class) {
        if ((getGetResourceMethod = ConfigGrpc.getGetResourceMethod) == null) {
          ConfigGrpc.getGetResourceMethod = getGetResourceMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.config.v1.GetResourceRequest, com.google.cloud.config.v1.Resource>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetResource"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.config.v1.GetResourceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.config.v1.Resource.getDefaultInstance()))
              .setSchemaDescriptor(new ConfigMethodDescriptorSupplier("GetResource"))
              .build();
        }
      }
    }
    return getGetResourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.config.v1.ListResourcesRequest,
      com.google.cloud.config.v1.ListResourcesResponse> getListResourcesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListResources",
      requestType = com.google.cloud.config.v1.ListResourcesRequest.class,
      responseType = com.google.cloud.config.v1.ListResourcesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.config.v1.ListResourcesRequest,
      com.google.cloud.config.v1.ListResourcesResponse> getListResourcesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.config.v1.ListResourcesRequest, com.google.cloud.config.v1.ListResourcesResponse> getListResourcesMethod;
    if ((getListResourcesMethod = ConfigGrpc.getListResourcesMethod) == null) {
      synchronized (ConfigGrpc.class) {
        if ((getListResourcesMethod = ConfigGrpc.getListResourcesMethod) == null) {
          ConfigGrpc.getListResourcesMethod = getListResourcesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.config.v1.ListResourcesRequest, com.google.cloud.config.v1.ListResourcesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListResources"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.config.v1.ListResourcesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.config.v1.ListResourcesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ConfigMethodDescriptorSupplier("ListResources"))
              .build();
        }
      }
    }
    return getListResourcesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.config.v1.ExportDeploymentStatefileRequest,
      com.google.cloud.config.v1.Statefile> getExportDeploymentStatefileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportDeploymentStatefile",
      requestType = com.google.cloud.config.v1.ExportDeploymentStatefileRequest.class,
      responseType = com.google.cloud.config.v1.Statefile.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.config.v1.ExportDeploymentStatefileRequest,
      com.google.cloud.config.v1.Statefile> getExportDeploymentStatefileMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.config.v1.ExportDeploymentStatefileRequest, com.google.cloud.config.v1.Statefile> getExportDeploymentStatefileMethod;
    if ((getExportDeploymentStatefileMethod = ConfigGrpc.getExportDeploymentStatefileMethod) == null) {
      synchronized (ConfigGrpc.class) {
        if ((getExportDeploymentStatefileMethod = ConfigGrpc.getExportDeploymentStatefileMethod) == null) {
          ConfigGrpc.getExportDeploymentStatefileMethod = getExportDeploymentStatefileMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.config.v1.ExportDeploymentStatefileRequest, com.google.cloud.config.v1.Statefile>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExportDeploymentStatefile"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.config.v1.ExportDeploymentStatefileRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.config.v1.Statefile.getDefaultInstance()))
              .setSchemaDescriptor(new ConfigMethodDescriptorSupplier("ExportDeploymentStatefile"))
              .build();
        }
      }
    }
    return getExportDeploymentStatefileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.config.v1.ExportRevisionStatefileRequest,
      com.google.cloud.config.v1.Statefile> getExportRevisionStatefileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportRevisionStatefile",
      requestType = com.google.cloud.config.v1.ExportRevisionStatefileRequest.class,
      responseType = com.google.cloud.config.v1.Statefile.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.config.v1.ExportRevisionStatefileRequest,
      com.google.cloud.config.v1.Statefile> getExportRevisionStatefileMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.config.v1.ExportRevisionStatefileRequest, com.google.cloud.config.v1.Statefile> getExportRevisionStatefileMethod;
    if ((getExportRevisionStatefileMethod = ConfigGrpc.getExportRevisionStatefileMethod) == null) {
      synchronized (ConfigGrpc.class) {
        if ((getExportRevisionStatefileMethod = ConfigGrpc.getExportRevisionStatefileMethod) == null) {
          ConfigGrpc.getExportRevisionStatefileMethod = getExportRevisionStatefileMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.config.v1.ExportRevisionStatefileRequest, com.google.cloud.config.v1.Statefile>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExportRevisionStatefile"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.config.v1.ExportRevisionStatefileRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.config.v1.Statefile.getDefaultInstance()))
              .setSchemaDescriptor(new ConfigMethodDescriptorSupplier("ExportRevisionStatefile"))
              .build();
        }
      }
    }
    return getExportRevisionStatefileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.config.v1.ImportStatefileRequest,
      com.google.cloud.config.v1.Statefile> getImportStatefileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportStatefile",
      requestType = com.google.cloud.config.v1.ImportStatefileRequest.class,
      responseType = com.google.cloud.config.v1.Statefile.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.config.v1.ImportStatefileRequest,
      com.google.cloud.config.v1.Statefile> getImportStatefileMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.config.v1.ImportStatefileRequest, com.google.cloud.config.v1.Statefile> getImportStatefileMethod;
    if ((getImportStatefileMethod = ConfigGrpc.getImportStatefileMethod) == null) {
      synchronized (ConfigGrpc.class) {
        if ((getImportStatefileMethod = ConfigGrpc.getImportStatefileMethod) == null) {
          ConfigGrpc.getImportStatefileMethod = getImportStatefileMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.config.v1.ImportStatefileRequest, com.google.cloud.config.v1.Statefile>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ImportStatefile"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.config.v1.ImportStatefileRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.config.v1.Statefile.getDefaultInstance()))
              .setSchemaDescriptor(new ConfigMethodDescriptorSupplier("ImportStatefile"))
              .build();
        }
      }
    }
    return getImportStatefileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.config.v1.DeleteStatefileRequest,
      com.google.protobuf.Empty> getDeleteStatefileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteStatefile",
      requestType = com.google.cloud.config.v1.DeleteStatefileRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.config.v1.DeleteStatefileRequest,
      com.google.protobuf.Empty> getDeleteStatefileMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.config.v1.DeleteStatefileRequest, com.google.protobuf.Empty> getDeleteStatefileMethod;
    if ((getDeleteStatefileMethod = ConfigGrpc.getDeleteStatefileMethod) == null) {
      synchronized (ConfigGrpc.class) {
        if ((getDeleteStatefileMethod = ConfigGrpc.getDeleteStatefileMethod) == null) {
          ConfigGrpc.getDeleteStatefileMethod = getDeleteStatefileMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.config.v1.DeleteStatefileRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteStatefile"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.config.v1.DeleteStatefileRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new ConfigMethodDescriptorSupplier("DeleteStatefile"))
              .build();
        }
      }
    }
    return getDeleteStatefileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.config.v1.LockDeploymentRequest,
      com.google.longrunning.Operation> getLockDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LockDeployment",
      requestType = com.google.cloud.config.v1.LockDeploymentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.config.v1.LockDeploymentRequest,
      com.google.longrunning.Operation> getLockDeploymentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.config.v1.LockDeploymentRequest, com.google.longrunning.Operation> getLockDeploymentMethod;
    if ((getLockDeploymentMethod = ConfigGrpc.getLockDeploymentMethod) == null) {
      synchronized (ConfigGrpc.class) {
        if ((getLockDeploymentMethod = ConfigGrpc.getLockDeploymentMethod) == null) {
          ConfigGrpc.getLockDeploymentMethod = getLockDeploymentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.config.v1.LockDeploymentRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LockDeployment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.config.v1.LockDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ConfigMethodDescriptorSupplier("LockDeployment"))
              .build();
        }
      }
    }
    return getLockDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.config.v1.UnlockDeploymentRequest,
      com.google.longrunning.Operation> getUnlockDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UnlockDeployment",
      requestType = com.google.cloud.config.v1.UnlockDeploymentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.config.v1.UnlockDeploymentRequest,
      com.google.longrunning.Operation> getUnlockDeploymentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.config.v1.UnlockDeploymentRequest, com.google.longrunning.Operation> getUnlockDeploymentMethod;
    if ((getUnlockDeploymentMethod = ConfigGrpc.getUnlockDeploymentMethod) == null) {
      synchronized (ConfigGrpc.class) {
        if ((getUnlockDeploymentMethod = ConfigGrpc.getUnlockDeploymentMethod) == null) {
          ConfigGrpc.getUnlockDeploymentMethod = getUnlockDeploymentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.config.v1.UnlockDeploymentRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UnlockDeployment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.config.v1.UnlockDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ConfigMethodDescriptorSupplier("UnlockDeployment"))
              .build();
        }
      }
    }
    return getUnlockDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.config.v1.ExportLockInfoRequest,
      com.google.cloud.config.v1.LockInfo> getExportLockInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportLockInfo",
      requestType = com.google.cloud.config.v1.ExportLockInfoRequest.class,
      responseType = com.google.cloud.config.v1.LockInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.config.v1.ExportLockInfoRequest,
      com.google.cloud.config.v1.LockInfo> getExportLockInfoMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.config.v1.ExportLockInfoRequest, com.google.cloud.config.v1.LockInfo> getExportLockInfoMethod;
    if ((getExportLockInfoMethod = ConfigGrpc.getExportLockInfoMethod) == null) {
      synchronized (ConfigGrpc.class) {
        if ((getExportLockInfoMethod = ConfigGrpc.getExportLockInfoMethod) == null) {
          ConfigGrpc.getExportLockInfoMethod = getExportLockInfoMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.config.v1.ExportLockInfoRequest, com.google.cloud.config.v1.LockInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExportLockInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.config.v1.ExportLockInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.config.v1.LockInfo.getDefaultInstance()))
              .setSchemaDescriptor(new ConfigMethodDescriptorSupplier("ExportLockInfo"))
              .build();
        }
      }
    }
    return getExportLockInfoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ConfigStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConfigStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ConfigStub>() {
        @java.lang.Override
        public ConfigStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ConfigStub(channel, callOptions);
        }
      };
    return ConfigStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ConfigBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConfigBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ConfigBlockingStub>() {
        @java.lang.Override
        public ConfigBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ConfigBlockingStub(channel, callOptions);
        }
      };
    return ConfigBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ConfigFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConfigFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ConfigFutureStub>() {
        @java.lang.Override
        public ConfigFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ConfigFutureStub(channel, callOptions);
        }
      };
    return ConfigFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Infrastructure Manager is a managed service that automates the deployment and
   * management of Google Cloud infrastructure resources.
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Lists [Deployment][google.cloud.config.v1.Deployment]s in a given project
     * and location.
     * </pre>
     */
    default void listDeployments(com.google.cloud.config.v1.ListDeploymentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.config.v1.ListDeploymentsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListDeploymentsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets details about a [Deployment][google.cloud.config.v1.Deployment].
     * </pre>
     */
    default void getDeployment(com.google.cloud.config.v1.GetDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.config.v1.Deployment> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetDeploymentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a [Deployment][google.cloud.config.v1.Deployment].
     * </pre>
     */
    default void createDeployment(com.google.cloud.config.v1.CreateDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateDeploymentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates a [Deployment][google.cloud.config.v1.Deployment].
     * </pre>
     */
    default void updateDeployment(com.google.cloud.config.v1.UpdateDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateDeploymentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a [Deployment][google.cloud.config.v1.Deployment].
     * </pre>
     */
    default void deleteDeployment(com.google.cloud.config.v1.DeleteDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteDeploymentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists [Revision][google.cloud.config.v1.Revision]s of a deployment.
     * </pre>
     */
    default void listRevisions(com.google.cloud.config.v1.ListRevisionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.config.v1.ListRevisionsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListRevisionsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets details about a [Revision][google.cloud.config.v1.Revision].
     * </pre>
     */
    default void getRevision(com.google.cloud.config.v1.GetRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.config.v1.Revision> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetRevisionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets details about a [Resource][google.cloud.config.v1.Resource] deployed
     * by Infra Manager.
     * </pre>
     */
    default void getResource(com.google.cloud.config.v1.GetResourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.config.v1.Resource> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetResourceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists [Resource][google.cloud.config.v1.Resource]s in a given revision.
     * </pre>
     */
    default void listResources(com.google.cloud.config.v1.ListResourcesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.config.v1.ListResourcesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListResourcesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Exports Terraform state file from a given deployment.
     * </pre>
     */
    default void exportDeploymentStatefile(com.google.cloud.config.v1.ExportDeploymentStatefileRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.config.v1.Statefile> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExportDeploymentStatefileMethod(), responseObserver);
    }

    /**
     * <pre>
     * Exports Terraform state file from a given revision.
     * </pre>
     */
    default void exportRevisionStatefile(com.google.cloud.config.v1.ExportRevisionStatefileRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.config.v1.Statefile> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExportRevisionStatefileMethod(), responseObserver);
    }

    /**
     * <pre>
     * Imports Terraform state file in a given deployment. The state file does not
     * take effect until the Deployment has been unlocked.
     * </pre>
     */
    default void importStatefile(com.google.cloud.config.v1.ImportStatefileRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.config.v1.Statefile> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getImportStatefileMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes Terraform state file in a given deployment.
     * </pre>
     */
    default void deleteStatefile(com.google.cloud.config.v1.DeleteStatefileRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteStatefileMethod(), responseObserver);
    }

    /**
     * <pre>
     * Locks a deployment.
     * </pre>
     */
    default void lockDeployment(com.google.cloud.config.v1.LockDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLockDeploymentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Unlocks a locked deployment.
     * </pre>
     */
    default void unlockDeployment(com.google.cloud.config.v1.UnlockDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUnlockDeploymentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Exports the lock info on a locked deployment.
     * </pre>
     */
    default void exportLockInfo(com.google.cloud.config.v1.ExportLockInfoRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.config.v1.LockInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExportLockInfoMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Config.
   * <pre>
   * Infrastructure Manager is a managed service that automates the deployment and
   * management of Google Cloud infrastructure resources.
   * </pre>
   */
  public static abstract class ConfigImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ConfigGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Config.
   * <pre>
   * Infrastructure Manager is a managed service that automates the deployment and
   * management of Google Cloud infrastructure resources.
   * </pre>
   */
  public static final class ConfigStub
      extends io.grpc.stub.AbstractAsyncStub<ConfigStub> {
    private ConfigStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfigStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConfigStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists [Deployment][google.cloud.config.v1.Deployment]s in a given project
     * and location.
     * </pre>
     */
    public void listDeployments(com.google.cloud.config.v1.ListDeploymentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.config.v1.ListDeploymentsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDeploymentsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets details about a [Deployment][google.cloud.config.v1.Deployment].
     * </pre>
     */
    public void getDeployment(com.google.cloud.config.v1.GetDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.config.v1.Deployment> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDeploymentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a [Deployment][google.cloud.config.v1.Deployment].
     * </pre>
     */
    public void createDeployment(com.google.cloud.config.v1.CreateDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDeploymentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates a [Deployment][google.cloud.config.v1.Deployment].
     * </pre>
     */
    public void updateDeployment(com.google.cloud.config.v1.UpdateDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDeploymentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a [Deployment][google.cloud.config.v1.Deployment].
     * </pre>
     */
    public void deleteDeployment(com.google.cloud.config.v1.DeleteDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDeploymentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists [Revision][google.cloud.config.v1.Revision]s of a deployment.
     * </pre>
     */
    public void listRevisions(com.google.cloud.config.v1.ListRevisionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.config.v1.ListRevisionsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRevisionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets details about a [Revision][google.cloud.config.v1.Revision].
     * </pre>
     */
    public void getRevision(com.google.cloud.config.v1.GetRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.config.v1.Revision> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRevisionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets details about a [Resource][google.cloud.config.v1.Resource] deployed
     * by Infra Manager.
     * </pre>
     */
    public void getResource(com.google.cloud.config.v1.GetResourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.config.v1.Resource> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetResourceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists [Resource][google.cloud.config.v1.Resource]s in a given revision.
     * </pre>
     */
    public void listResources(com.google.cloud.config.v1.ListResourcesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.config.v1.ListResourcesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListResourcesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Exports Terraform state file from a given deployment.
     * </pre>
     */
    public void exportDeploymentStatefile(com.google.cloud.config.v1.ExportDeploymentStatefileRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.config.v1.Statefile> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportDeploymentStatefileMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Exports Terraform state file from a given revision.
     * </pre>
     */
    public void exportRevisionStatefile(com.google.cloud.config.v1.ExportRevisionStatefileRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.config.v1.Statefile> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportRevisionStatefileMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Imports Terraform state file in a given deployment. The state file does not
     * take effect until the Deployment has been unlocked.
     * </pre>
     */
    public void importStatefile(com.google.cloud.config.v1.ImportStatefileRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.config.v1.Statefile> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportStatefileMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes Terraform state file in a given deployment.
     * </pre>
     */
    public void deleteStatefile(com.google.cloud.config.v1.DeleteStatefileRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteStatefileMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Locks a deployment.
     * </pre>
     */
    public void lockDeployment(com.google.cloud.config.v1.LockDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLockDeploymentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Unlocks a locked deployment.
     * </pre>
     */
    public void unlockDeployment(com.google.cloud.config.v1.UnlockDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUnlockDeploymentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Exports the lock info on a locked deployment.
     * </pre>
     */
    public void exportLockInfo(com.google.cloud.config.v1.ExportLockInfoRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.config.v1.LockInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportLockInfoMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Config.
   * <pre>
   * Infrastructure Manager is a managed service that automates the deployment and
   * management of Google Cloud infrastructure resources.
   * </pre>
   */
  public static final class ConfigBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ConfigBlockingStub> {
    private ConfigBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfigBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConfigBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists [Deployment][google.cloud.config.v1.Deployment]s in a given project
     * and location.
     * </pre>
     */
    public com.google.cloud.config.v1.ListDeploymentsResponse listDeployments(com.google.cloud.config.v1.ListDeploymentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDeploymentsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets details about a [Deployment][google.cloud.config.v1.Deployment].
     * </pre>
     */
    public com.google.cloud.config.v1.Deployment getDeployment(com.google.cloud.config.v1.GetDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDeploymentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a [Deployment][google.cloud.config.v1.Deployment].
     * </pre>
     */
    public com.google.longrunning.Operation createDeployment(com.google.cloud.config.v1.CreateDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDeploymentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates a [Deployment][google.cloud.config.v1.Deployment].
     * </pre>
     */
    public com.google.longrunning.Operation updateDeployment(com.google.cloud.config.v1.UpdateDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDeploymentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a [Deployment][google.cloud.config.v1.Deployment].
     * </pre>
     */
    public com.google.longrunning.Operation deleteDeployment(com.google.cloud.config.v1.DeleteDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDeploymentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists [Revision][google.cloud.config.v1.Revision]s of a deployment.
     * </pre>
     */
    public com.google.cloud.config.v1.ListRevisionsResponse listRevisions(com.google.cloud.config.v1.ListRevisionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRevisionsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets details about a [Revision][google.cloud.config.v1.Revision].
     * </pre>
     */
    public com.google.cloud.config.v1.Revision getRevision(com.google.cloud.config.v1.GetRevisionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRevisionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets details about a [Resource][google.cloud.config.v1.Resource] deployed
     * by Infra Manager.
     * </pre>
     */
    public com.google.cloud.config.v1.Resource getResource(com.google.cloud.config.v1.GetResourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetResourceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists [Resource][google.cloud.config.v1.Resource]s in a given revision.
     * </pre>
     */
    public com.google.cloud.config.v1.ListResourcesResponse listResources(com.google.cloud.config.v1.ListResourcesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListResourcesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Exports Terraform state file from a given deployment.
     * </pre>
     */
    public com.google.cloud.config.v1.Statefile exportDeploymentStatefile(com.google.cloud.config.v1.ExportDeploymentStatefileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportDeploymentStatefileMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Exports Terraform state file from a given revision.
     * </pre>
     */
    public com.google.cloud.config.v1.Statefile exportRevisionStatefile(com.google.cloud.config.v1.ExportRevisionStatefileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportRevisionStatefileMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Imports Terraform state file in a given deployment. The state file does not
     * take effect until the Deployment has been unlocked.
     * </pre>
     */
    public com.google.cloud.config.v1.Statefile importStatefile(com.google.cloud.config.v1.ImportStatefileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportStatefileMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes Terraform state file in a given deployment.
     * </pre>
     */
    public com.google.protobuf.Empty deleteStatefile(com.google.cloud.config.v1.DeleteStatefileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteStatefileMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Locks a deployment.
     * </pre>
     */
    public com.google.longrunning.Operation lockDeployment(com.google.cloud.config.v1.LockDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLockDeploymentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Unlocks a locked deployment.
     * </pre>
     */
    public com.google.longrunning.Operation unlockDeployment(com.google.cloud.config.v1.UnlockDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUnlockDeploymentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Exports the lock info on a locked deployment.
     * </pre>
     */
    public com.google.cloud.config.v1.LockInfo exportLockInfo(com.google.cloud.config.v1.ExportLockInfoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportLockInfoMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Config.
   * <pre>
   * Infrastructure Manager is a managed service that automates the deployment and
   * management of Google Cloud infrastructure resources.
   * </pre>
   */
  public static final class ConfigFutureStub
      extends io.grpc.stub.AbstractFutureStub<ConfigFutureStub> {
    private ConfigFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfigFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConfigFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists [Deployment][google.cloud.config.v1.Deployment]s in a given project
     * and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.config.v1.ListDeploymentsResponse> listDeployments(
        com.google.cloud.config.v1.ListDeploymentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDeploymentsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets details about a [Deployment][google.cloud.config.v1.Deployment].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.config.v1.Deployment> getDeployment(
        com.google.cloud.config.v1.GetDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDeploymentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a [Deployment][google.cloud.config.v1.Deployment].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createDeployment(
        com.google.cloud.config.v1.CreateDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDeploymentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates a [Deployment][google.cloud.config.v1.Deployment].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateDeployment(
        com.google.cloud.config.v1.UpdateDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDeploymentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a [Deployment][google.cloud.config.v1.Deployment].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteDeployment(
        com.google.cloud.config.v1.DeleteDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDeploymentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists [Revision][google.cloud.config.v1.Revision]s of a deployment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.config.v1.ListRevisionsResponse> listRevisions(
        com.google.cloud.config.v1.ListRevisionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRevisionsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets details about a [Revision][google.cloud.config.v1.Revision].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.config.v1.Revision> getRevision(
        com.google.cloud.config.v1.GetRevisionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRevisionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets details about a [Resource][google.cloud.config.v1.Resource] deployed
     * by Infra Manager.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.config.v1.Resource> getResource(
        com.google.cloud.config.v1.GetResourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetResourceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists [Resource][google.cloud.config.v1.Resource]s in a given revision.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.config.v1.ListResourcesResponse> listResources(
        com.google.cloud.config.v1.ListResourcesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListResourcesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Exports Terraform state file from a given deployment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.config.v1.Statefile> exportDeploymentStatefile(
        com.google.cloud.config.v1.ExportDeploymentStatefileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportDeploymentStatefileMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Exports Terraform state file from a given revision.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.config.v1.Statefile> exportRevisionStatefile(
        com.google.cloud.config.v1.ExportRevisionStatefileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportRevisionStatefileMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Imports Terraform state file in a given deployment. The state file does not
     * take effect until the Deployment has been unlocked.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.config.v1.Statefile> importStatefile(
        com.google.cloud.config.v1.ImportStatefileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportStatefileMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes Terraform state file in a given deployment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteStatefile(
        com.google.cloud.config.v1.DeleteStatefileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteStatefileMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Locks a deployment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> lockDeployment(
        com.google.cloud.config.v1.LockDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLockDeploymentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Unlocks a locked deployment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> unlockDeployment(
        com.google.cloud.config.v1.UnlockDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUnlockDeploymentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Exports the lock info on a locked deployment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.config.v1.LockInfo> exportLockInfo(
        com.google.cloud.config.v1.ExportLockInfoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportLockInfoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_DEPLOYMENTS = 0;
  private static final int METHODID_GET_DEPLOYMENT = 1;
  private static final int METHODID_CREATE_DEPLOYMENT = 2;
  private static final int METHODID_UPDATE_DEPLOYMENT = 3;
  private static final int METHODID_DELETE_DEPLOYMENT = 4;
  private static final int METHODID_LIST_REVISIONS = 5;
  private static final int METHODID_GET_REVISION = 6;
  private static final int METHODID_GET_RESOURCE = 7;
  private static final int METHODID_LIST_RESOURCES = 8;
  private static final int METHODID_EXPORT_DEPLOYMENT_STATEFILE = 9;
  private static final int METHODID_EXPORT_REVISION_STATEFILE = 10;
  private static final int METHODID_IMPORT_STATEFILE = 11;
  private static final int METHODID_DELETE_STATEFILE = 12;
  private static final int METHODID_LOCK_DEPLOYMENT = 13;
  private static final int METHODID_UNLOCK_DEPLOYMENT = 14;
  private static final int METHODID_EXPORT_LOCK_INFO = 15;

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
        case METHODID_LIST_DEPLOYMENTS:
          serviceImpl.listDeployments((com.google.cloud.config.v1.ListDeploymentsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.config.v1.ListDeploymentsResponse>) responseObserver);
          break;
        case METHODID_GET_DEPLOYMENT:
          serviceImpl.getDeployment((com.google.cloud.config.v1.GetDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.config.v1.Deployment>) responseObserver);
          break;
        case METHODID_CREATE_DEPLOYMENT:
          serviceImpl.createDeployment((com.google.cloud.config.v1.CreateDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_DEPLOYMENT:
          serviceImpl.updateDeployment((com.google.cloud.config.v1.UpdateDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_DEPLOYMENT:
          serviceImpl.deleteDeployment((com.google.cloud.config.v1.DeleteDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_REVISIONS:
          serviceImpl.listRevisions((com.google.cloud.config.v1.ListRevisionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.config.v1.ListRevisionsResponse>) responseObserver);
          break;
        case METHODID_GET_REVISION:
          serviceImpl.getRevision((com.google.cloud.config.v1.GetRevisionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.config.v1.Revision>) responseObserver);
          break;
        case METHODID_GET_RESOURCE:
          serviceImpl.getResource((com.google.cloud.config.v1.GetResourceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.config.v1.Resource>) responseObserver);
          break;
        case METHODID_LIST_RESOURCES:
          serviceImpl.listResources((com.google.cloud.config.v1.ListResourcesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.config.v1.ListResourcesResponse>) responseObserver);
          break;
        case METHODID_EXPORT_DEPLOYMENT_STATEFILE:
          serviceImpl.exportDeploymentStatefile((com.google.cloud.config.v1.ExportDeploymentStatefileRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.config.v1.Statefile>) responseObserver);
          break;
        case METHODID_EXPORT_REVISION_STATEFILE:
          serviceImpl.exportRevisionStatefile((com.google.cloud.config.v1.ExportRevisionStatefileRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.config.v1.Statefile>) responseObserver);
          break;
        case METHODID_IMPORT_STATEFILE:
          serviceImpl.importStatefile((com.google.cloud.config.v1.ImportStatefileRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.config.v1.Statefile>) responseObserver);
          break;
        case METHODID_DELETE_STATEFILE:
          serviceImpl.deleteStatefile((com.google.cloud.config.v1.DeleteStatefileRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LOCK_DEPLOYMENT:
          serviceImpl.lockDeployment((com.google.cloud.config.v1.LockDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UNLOCK_DEPLOYMENT:
          serviceImpl.unlockDeployment((com.google.cloud.config.v1.UnlockDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_EXPORT_LOCK_INFO:
          serviceImpl.exportLockInfo((com.google.cloud.config.v1.ExportLockInfoRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.config.v1.LockInfo>) responseObserver);
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
          getListDeploymentsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.config.v1.ListDeploymentsRequest,
              com.google.cloud.config.v1.ListDeploymentsResponse>(
                service, METHODID_LIST_DEPLOYMENTS)))
        .addMethod(
          getGetDeploymentMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.config.v1.GetDeploymentRequest,
              com.google.cloud.config.v1.Deployment>(
                service, METHODID_GET_DEPLOYMENT)))
        .addMethod(
          getCreateDeploymentMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.config.v1.CreateDeploymentRequest,
              com.google.longrunning.Operation>(
                service, METHODID_CREATE_DEPLOYMENT)))
        .addMethod(
          getUpdateDeploymentMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.config.v1.UpdateDeploymentRequest,
              com.google.longrunning.Operation>(
                service, METHODID_UPDATE_DEPLOYMENT)))
        .addMethod(
          getDeleteDeploymentMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.config.v1.DeleteDeploymentRequest,
              com.google.longrunning.Operation>(
                service, METHODID_DELETE_DEPLOYMENT)))
        .addMethod(
          getListRevisionsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.config.v1.ListRevisionsRequest,
              com.google.cloud.config.v1.ListRevisionsResponse>(
                service, METHODID_LIST_REVISIONS)))
        .addMethod(
          getGetRevisionMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.config.v1.GetRevisionRequest,
              com.google.cloud.config.v1.Revision>(
                service, METHODID_GET_REVISION)))
        .addMethod(
          getGetResourceMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.config.v1.GetResourceRequest,
              com.google.cloud.config.v1.Resource>(
                service, METHODID_GET_RESOURCE)))
        .addMethod(
          getListResourcesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.config.v1.ListResourcesRequest,
              com.google.cloud.config.v1.ListResourcesResponse>(
                service, METHODID_LIST_RESOURCES)))
        .addMethod(
          getExportDeploymentStatefileMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.config.v1.ExportDeploymentStatefileRequest,
              com.google.cloud.config.v1.Statefile>(
                service, METHODID_EXPORT_DEPLOYMENT_STATEFILE)))
        .addMethod(
          getExportRevisionStatefileMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.config.v1.ExportRevisionStatefileRequest,
              com.google.cloud.config.v1.Statefile>(
                service, METHODID_EXPORT_REVISION_STATEFILE)))
        .addMethod(
          getImportStatefileMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.config.v1.ImportStatefileRequest,
              com.google.cloud.config.v1.Statefile>(
                service, METHODID_IMPORT_STATEFILE)))
        .addMethod(
          getDeleteStatefileMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.config.v1.DeleteStatefileRequest,
              com.google.protobuf.Empty>(
                service, METHODID_DELETE_STATEFILE)))
        .addMethod(
          getLockDeploymentMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.config.v1.LockDeploymentRequest,
              com.google.longrunning.Operation>(
                service, METHODID_LOCK_DEPLOYMENT)))
        .addMethod(
          getUnlockDeploymentMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.config.v1.UnlockDeploymentRequest,
              com.google.longrunning.Operation>(
                service, METHODID_UNLOCK_DEPLOYMENT)))
        .addMethod(
          getExportLockInfoMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.config.v1.ExportLockInfoRequest,
              com.google.cloud.config.v1.LockInfo>(
                service, METHODID_EXPORT_LOCK_INFO)))
        .build();
  }

  private static abstract class ConfigBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ConfigBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.config.v1.ConfigProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Config");
    }
  }

  private static final class ConfigFileDescriptorSupplier
      extends ConfigBaseDescriptorSupplier {
    ConfigFileDescriptorSupplier() {}
  }

  private static final class ConfigMethodDescriptorSupplier
      extends ConfigBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ConfigMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ConfigGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ConfigFileDescriptorSupplier())
              .addMethod(getListDeploymentsMethod())
              .addMethod(getGetDeploymentMethod())
              .addMethod(getCreateDeploymentMethod())
              .addMethod(getUpdateDeploymentMethod())
              .addMethod(getDeleteDeploymentMethod())
              .addMethod(getListRevisionsMethod())
              .addMethod(getGetRevisionMethod())
              .addMethod(getGetResourceMethod())
              .addMethod(getListResourcesMethod())
              .addMethod(getExportDeploymentStatefileMethod())
              .addMethod(getExportRevisionStatefileMethod())
              .addMethod(getImportStatefileMethod())
              .addMethod(getDeleteStatefileMethod())
              .addMethod(getLockDeploymentMethod())
              .addMethod(getUnlockDeploymentMethod())
              .addMethod(getExportLockInfoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
