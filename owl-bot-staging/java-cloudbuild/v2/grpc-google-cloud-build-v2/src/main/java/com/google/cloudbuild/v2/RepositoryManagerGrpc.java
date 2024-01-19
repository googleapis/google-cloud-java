package com.google.cloudbuild.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Manages connections to source code repositories.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/devtools/cloudbuild/v2/repositories.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RepositoryManagerGrpc {

  private RepositoryManagerGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.devtools.cloudbuild.v2.RepositoryManager";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloudbuild.v2.CreateConnectionRequest,
      com.google.longrunning.Operation> getCreateConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateConnection",
      requestType = com.google.cloudbuild.v2.CreateConnectionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloudbuild.v2.CreateConnectionRequest,
      com.google.longrunning.Operation> getCreateConnectionMethod() {
    io.grpc.MethodDescriptor<com.google.cloudbuild.v2.CreateConnectionRequest, com.google.longrunning.Operation> getCreateConnectionMethod;
    if ((getCreateConnectionMethod = RepositoryManagerGrpc.getCreateConnectionMethod) == null) {
      synchronized (RepositoryManagerGrpc.class) {
        if ((getCreateConnectionMethod = RepositoryManagerGrpc.getCreateConnectionMethod) == null) {
          RepositoryManagerGrpc.getCreateConnectionMethod = getCreateConnectionMethod =
              io.grpc.MethodDescriptor.<com.google.cloudbuild.v2.CreateConnectionRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateConnection"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v2.CreateConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new RepositoryManagerMethodDescriptorSupplier("CreateConnection"))
              .build();
        }
      }
    }
    return getCreateConnectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloudbuild.v2.GetConnectionRequest,
      com.google.cloudbuild.v2.Connection> getGetConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetConnection",
      requestType = com.google.cloudbuild.v2.GetConnectionRequest.class,
      responseType = com.google.cloudbuild.v2.Connection.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloudbuild.v2.GetConnectionRequest,
      com.google.cloudbuild.v2.Connection> getGetConnectionMethod() {
    io.grpc.MethodDescriptor<com.google.cloudbuild.v2.GetConnectionRequest, com.google.cloudbuild.v2.Connection> getGetConnectionMethod;
    if ((getGetConnectionMethod = RepositoryManagerGrpc.getGetConnectionMethod) == null) {
      synchronized (RepositoryManagerGrpc.class) {
        if ((getGetConnectionMethod = RepositoryManagerGrpc.getGetConnectionMethod) == null) {
          RepositoryManagerGrpc.getGetConnectionMethod = getGetConnectionMethod =
              io.grpc.MethodDescriptor.<com.google.cloudbuild.v2.GetConnectionRequest, com.google.cloudbuild.v2.Connection>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetConnection"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v2.GetConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v2.Connection.getDefaultInstance()))
              .setSchemaDescriptor(new RepositoryManagerMethodDescriptorSupplier("GetConnection"))
              .build();
        }
      }
    }
    return getGetConnectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloudbuild.v2.ListConnectionsRequest,
      com.google.cloudbuild.v2.ListConnectionsResponse> getListConnectionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListConnections",
      requestType = com.google.cloudbuild.v2.ListConnectionsRequest.class,
      responseType = com.google.cloudbuild.v2.ListConnectionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloudbuild.v2.ListConnectionsRequest,
      com.google.cloudbuild.v2.ListConnectionsResponse> getListConnectionsMethod() {
    io.grpc.MethodDescriptor<com.google.cloudbuild.v2.ListConnectionsRequest, com.google.cloudbuild.v2.ListConnectionsResponse> getListConnectionsMethod;
    if ((getListConnectionsMethod = RepositoryManagerGrpc.getListConnectionsMethod) == null) {
      synchronized (RepositoryManagerGrpc.class) {
        if ((getListConnectionsMethod = RepositoryManagerGrpc.getListConnectionsMethod) == null) {
          RepositoryManagerGrpc.getListConnectionsMethod = getListConnectionsMethod =
              io.grpc.MethodDescriptor.<com.google.cloudbuild.v2.ListConnectionsRequest, com.google.cloudbuild.v2.ListConnectionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListConnections"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v2.ListConnectionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v2.ListConnectionsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RepositoryManagerMethodDescriptorSupplier("ListConnections"))
              .build();
        }
      }
    }
    return getListConnectionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloudbuild.v2.UpdateConnectionRequest,
      com.google.longrunning.Operation> getUpdateConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateConnection",
      requestType = com.google.cloudbuild.v2.UpdateConnectionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloudbuild.v2.UpdateConnectionRequest,
      com.google.longrunning.Operation> getUpdateConnectionMethod() {
    io.grpc.MethodDescriptor<com.google.cloudbuild.v2.UpdateConnectionRequest, com.google.longrunning.Operation> getUpdateConnectionMethod;
    if ((getUpdateConnectionMethod = RepositoryManagerGrpc.getUpdateConnectionMethod) == null) {
      synchronized (RepositoryManagerGrpc.class) {
        if ((getUpdateConnectionMethod = RepositoryManagerGrpc.getUpdateConnectionMethod) == null) {
          RepositoryManagerGrpc.getUpdateConnectionMethod = getUpdateConnectionMethod =
              io.grpc.MethodDescriptor.<com.google.cloudbuild.v2.UpdateConnectionRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateConnection"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v2.UpdateConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new RepositoryManagerMethodDescriptorSupplier("UpdateConnection"))
              .build();
        }
      }
    }
    return getUpdateConnectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloudbuild.v2.DeleteConnectionRequest,
      com.google.longrunning.Operation> getDeleteConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteConnection",
      requestType = com.google.cloudbuild.v2.DeleteConnectionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloudbuild.v2.DeleteConnectionRequest,
      com.google.longrunning.Operation> getDeleteConnectionMethod() {
    io.grpc.MethodDescriptor<com.google.cloudbuild.v2.DeleteConnectionRequest, com.google.longrunning.Operation> getDeleteConnectionMethod;
    if ((getDeleteConnectionMethod = RepositoryManagerGrpc.getDeleteConnectionMethod) == null) {
      synchronized (RepositoryManagerGrpc.class) {
        if ((getDeleteConnectionMethod = RepositoryManagerGrpc.getDeleteConnectionMethod) == null) {
          RepositoryManagerGrpc.getDeleteConnectionMethod = getDeleteConnectionMethod =
              io.grpc.MethodDescriptor.<com.google.cloudbuild.v2.DeleteConnectionRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteConnection"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v2.DeleteConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new RepositoryManagerMethodDescriptorSupplier("DeleteConnection"))
              .build();
        }
      }
    }
    return getDeleteConnectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloudbuild.v2.CreateRepositoryRequest,
      com.google.longrunning.Operation> getCreateRepositoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRepository",
      requestType = com.google.cloudbuild.v2.CreateRepositoryRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloudbuild.v2.CreateRepositoryRequest,
      com.google.longrunning.Operation> getCreateRepositoryMethod() {
    io.grpc.MethodDescriptor<com.google.cloudbuild.v2.CreateRepositoryRequest, com.google.longrunning.Operation> getCreateRepositoryMethod;
    if ((getCreateRepositoryMethod = RepositoryManagerGrpc.getCreateRepositoryMethod) == null) {
      synchronized (RepositoryManagerGrpc.class) {
        if ((getCreateRepositoryMethod = RepositoryManagerGrpc.getCreateRepositoryMethod) == null) {
          RepositoryManagerGrpc.getCreateRepositoryMethod = getCreateRepositoryMethod =
              io.grpc.MethodDescriptor.<com.google.cloudbuild.v2.CreateRepositoryRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateRepository"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v2.CreateRepositoryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new RepositoryManagerMethodDescriptorSupplier("CreateRepository"))
              .build();
        }
      }
    }
    return getCreateRepositoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloudbuild.v2.BatchCreateRepositoriesRequest,
      com.google.longrunning.Operation> getBatchCreateRepositoriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchCreateRepositories",
      requestType = com.google.cloudbuild.v2.BatchCreateRepositoriesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloudbuild.v2.BatchCreateRepositoriesRequest,
      com.google.longrunning.Operation> getBatchCreateRepositoriesMethod() {
    io.grpc.MethodDescriptor<com.google.cloudbuild.v2.BatchCreateRepositoriesRequest, com.google.longrunning.Operation> getBatchCreateRepositoriesMethod;
    if ((getBatchCreateRepositoriesMethod = RepositoryManagerGrpc.getBatchCreateRepositoriesMethod) == null) {
      synchronized (RepositoryManagerGrpc.class) {
        if ((getBatchCreateRepositoriesMethod = RepositoryManagerGrpc.getBatchCreateRepositoriesMethod) == null) {
          RepositoryManagerGrpc.getBatchCreateRepositoriesMethod = getBatchCreateRepositoriesMethod =
              io.grpc.MethodDescriptor.<com.google.cloudbuild.v2.BatchCreateRepositoriesRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchCreateRepositories"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v2.BatchCreateRepositoriesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new RepositoryManagerMethodDescriptorSupplier("BatchCreateRepositories"))
              .build();
        }
      }
    }
    return getBatchCreateRepositoriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloudbuild.v2.GetRepositoryRequest,
      com.google.cloudbuild.v2.Repository> getGetRepositoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRepository",
      requestType = com.google.cloudbuild.v2.GetRepositoryRequest.class,
      responseType = com.google.cloudbuild.v2.Repository.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloudbuild.v2.GetRepositoryRequest,
      com.google.cloudbuild.v2.Repository> getGetRepositoryMethod() {
    io.grpc.MethodDescriptor<com.google.cloudbuild.v2.GetRepositoryRequest, com.google.cloudbuild.v2.Repository> getGetRepositoryMethod;
    if ((getGetRepositoryMethod = RepositoryManagerGrpc.getGetRepositoryMethod) == null) {
      synchronized (RepositoryManagerGrpc.class) {
        if ((getGetRepositoryMethod = RepositoryManagerGrpc.getGetRepositoryMethod) == null) {
          RepositoryManagerGrpc.getGetRepositoryMethod = getGetRepositoryMethod =
              io.grpc.MethodDescriptor.<com.google.cloudbuild.v2.GetRepositoryRequest, com.google.cloudbuild.v2.Repository>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRepository"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v2.GetRepositoryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v2.Repository.getDefaultInstance()))
              .setSchemaDescriptor(new RepositoryManagerMethodDescriptorSupplier("GetRepository"))
              .build();
        }
      }
    }
    return getGetRepositoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloudbuild.v2.ListRepositoriesRequest,
      com.google.cloudbuild.v2.ListRepositoriesResponse> getListRepositoriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRepositories",
      requestType = com.google.cloudbuild.v2.ListRepositoriesRequest.class,
      responseType = com.google.cloudbuild.v2.ListRepositoriesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloudbuild.v2.ListRepositoriesRequest,
      com.google.cloudbuild.v2.ListRepositoriesResponse> getListRepositoriesMethod() {
    io.grpc.MethodDescriptor<com.google.cloudbuild.v2.ListRepositoriesRequest, com.google.cloudbuild.v2.ListRepositoriesResponse> getListRepositoriesMethod;
    if ((getListRepositoriesMethod = RepositoryManagerGrpc.getListRepositoriesMethod) == null) {
      synchronized (RepositoryManagerGrpc.class) {
        if ((getListRepositoriesMethod = RepositoryManagerGrpc.getListRepositoriesMethod) == null) {
          RepositoryManagerGrpc.getListRepositoriesMethod = getListRepositoriesMethod =
              io.grpc.MethodDescriptor.<com.google.cloudbuild.v2.ListRepositoriesRequest, com.google.cloudbuild.v2.ListRepositoriesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListRepositories"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v2.ListRepositoriesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v2.ListRepositoriesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RepositoryManagerMethodDescriptorSupplier("ListRepositories"))
              .build();
        }
      }
    }
    return getListRepositoriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloudbuild.v2.DeleteRepositoryRequest,
      com.google.longrunning.Operation> getDeleteRepositoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteRepository",
      requestType = com.google.cloudbuild.v2.DeleteRepositoryRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloudbuild.v2.DeleteRepositoryRequest,
      com.google.longrunning.Operation> getDeleteRepositoryMethod() {
    io.grpc.MethodDescriptor<com.google.cloudbuild.v2.DeleteRepositoryRequest, com.google.longrunning.Operation> getDeleteRepositoryMethod;
    if ((getDeleteRepositoryMethod = RepositoryManagerGrpc.getDeleteRepositoryMethod) == null) {
      synchronized (RepositoryManagerGrpc.class) {
        if ((getDeleteRepositoryMethod = RepositoryManagerGrpc.getDeleteRepositoryMethod) == null) {
          RepositoryManagerGrpc.getDeleteRepositoryMethod = getDeleteRepositoryMethod =
              io.grpc.MethodDescriptor.<com.google.cloudbuild.v2.DeleteRepositoryRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteRepository"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v2.DeleteRepositoryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new RepositoryManagerMethodDescriptorSupplier("DeleteRepository"))
              .build();
        }
      }
    }
    return getDeleteRepositoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloudbuild.v2.FetchReadWriteTokenRequest,
      com.google.cloudbuild.v2.FetchReadWriteTokenResponse> getFetchReadWriteTokenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchReadWriteToken",
      requestType = com.google.cloudbuild.v2.FetchReadWriteTokenRequest.class,
      responseType = com.google.cloudbuild.v2.FetchReadWriteTokenResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloudbuild.v2.FetchReadWriteTokenRequest,
      com.google.cloudbuild.v2.FetchReadWriteTokenResponse> getFetchReadWriteTokenMethod() {
    io.grpc.MethodDescriptor<com.google.cloudbuild.v2.FetchReadWriteTokenRequest, com.google.cloudbuild.v2.FetchReadWriteTokenResponse> getFetchReadWriteTokenMethod;
    if ((getFetchReadWriteTokenMethod = RepositoryManagerGrpc.getFetchReadWriteTokenMethod) == null) {
      synchronized (RepositoryManagerGrpc.class) {
        if ((getFetchReadWriteTokenMethod = RepositoryManagerGrpc.getFetchReadWriteTokenMethod) == null) {
          RepositoryManagerGrpc.getFetchReadWriteTokenMethod = getFetchReadWriteTokenMethod =
              io.grpc.MethodDescriptor.<com.google.cloudbuild.v2.FetchReadWriteTokenRequest, com.google.cloudbuild.v2.FetchReadWriteTokenResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FetchReadWriteToken"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v2.FetchReadWriteTokenRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v2.FetchReadWriteTokenResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RepositoryManagerMethodDescriptorSupplier("FetchReadWriteToken"))
              .build();
        }
      }
    }
    return getFetchReadWriteTokenMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloudbuild.v2.FetchReadTokenRequest,
      com.google.cloudbuild.v2.FetchReadTokenResponse> getFetchReadTokenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchReadToken",
      requestType = com.google.cloudbuild.v2.FetchReadTokenRequest.class,
      responseType = com.google.cloudbuild.v2.FetchReadTokenResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloudbuild.v2.FetchReadTokenRequest,
      com.google.cloudbuild.v2.FetchReadTokenResponse> getFetchReadTokenMethod() {
    io.grpc.MethodDescriptor<com.google.cloudbuild.v2.FetchReadTokenRequest, com.google.cloudbuild.v2.FetchReadTokenResponse> getFetchReadTokenMethod;
    if ((getFetchReadTokenMethod = RepositoryManagerGrpc.getFetchReadTokenMethod) == null) {
      synchronized (RepositoryManagerGrpc.class) {
        if ((getFetchReadTokenMethod = RepositoryManagerGrpc.getFetchReadTokenMethod) == null) {
          RepositoryManagerGrpc.getFetchReadTokenMethod = getFetchReadTokenMethod =
              io.grpc.MethodDescriptor.<com.google.cloudbuild.v2.FetchReadTokenRequest, com.google.cloudbuild.v2.FetchReadTokenResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FetchReadToken"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v2.FetchReadTokenRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v2.FetchReadTokenResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RepositoryManagerMethodDescriptorSupplier("FetchReadToken"))
              .build();
        }
      }
    }
    return getFetchReadTokenMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloudbuild.v2.FetchLinkableRepositoriesRequest,
      com.google.cloudbuild.v2.FetchLinkableRepositoriesResponse> getFetchLinkableRepositoriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchLinkableRepositories",
      requestType = com.google.cloudbuild.v2.FetchLinkableRepositoriesRequest.class,
      responseType = com.google.cloudbuild.v2.FetchLinkableRepositoriesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloudbuild.v2.FetchLinkableRepositoriesRequest,
      com.google.cloudbuild.v2.FetchLinkableRepositoriesResponse> getFetchLinkableRepositoriesMethod() {
    io.grpc.MethodDescriptor<com.google.cloudbuild.v2.FetchLinkableRepositoriesRequest, com.google.cloudbuild.v2.FetchLinkableRepositoriesResponse> getFetchLinkableRepositoriesMethod;
    if ((getFetchLinkableRepositoriesMethod = RepositoryManagerGrpc.getFetchLinkableRepositoriesMethod) == null) {
      synchronized (RepositoryManagerGrpc.class) {
        if ((getFetchLinkableRepositoriesMethod = RepositoryManagerGrpc.getFetchLinkableRepositoriesMethod) == null) {
          RepositoryManagerGrpc.getFetchLinkableRepositoriesMethod = getFetchLinkableRepositoriesMethod =
              io.grpc.MethodDescriptor.<com.google.cloudbuild.v2.FetchLinkableRepositoriesRequest, com.google.cloudbuild.v2.FetchLinkableRepositoriesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FetchLinkableRepositories"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v2.FetchLinkableRepositoriesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v2.FetchLinkableRepositoriesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RepositoryManagerMethodDescriptorSupplier("FetchLinkableRepositories"))
              .build();
        }
      }
    }
    return getFetchLinkableRepositoriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloudbuild.v2.FetchGitRefsRequest,
      com.google.cloudbuild.v2.FetchGitRefsResponse> getFetchGitRefsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchGitRefs",
      requestType = com.google.cloudbuild.v2.FetchGitRefsRequest.class,
      responseType = com.google.cloudbuild.v2.FetchGitRefsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloudbuild.v2.FetchGitRefsRequest,
      com.google.cloudbuild.v2.FetchGitRefsResponse> getFetchGitRefsMethod() {
    io.grpc.MethodDescriptor<com.google.cloudbuild.v2.FetchGitRefsRequest, com.google.cloudbuild.v2.FetchGitRefsResponse> getFetchGitRefsMethod;
    if ((getFetchGitRefsMethod = RepositoryManagerGrpc.getFetchGitRefsMethod) == null) {
      synchronized (RepositoryManagerGrpc.class) {
        if ((getFetchGitRefsMethod = RepositoryManagerGrpc.getFetchGitRefsMethod) == null) {
          RepositoryManagerGrpc.getFetchGitRefsMethod = getFetchGitRefsMethod =
              io.grpc.MethodDescriptor.<com.google.cloudbuild.v2.FetchGitRefsRequest, com.google.cloudbuild.v2.FetchGitRefsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FetchGitRefs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v2.FetchGitRefsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v2.FetchGitRefsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RepositoryManagerMethodDescriptorSupplier("FetchGitRefs"))
              .build();
        }
      }
    }
    return getFetchGitRefsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RepositoryManagerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RepositoryManagerStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RepositoryManagerStub>() {
        @java.lang.Override
        public RepositoryManagerStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RepositoryManagerStub(channel, callOptions);
        }
      };
    return RepositoryManagerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RepositoryManagerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RepositoryManagerBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RepositoryManagerBlockingStub>() {
        @java.lang.Override
        public RepositoryManagerBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RepositoryManagerBlockingStub(channel, callOptions);
        }
      };
    return RepositoryManagerBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RepositoryManagerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RepositoryManagerFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RepositoryManagerFutureStub>() {
        @java.lang.Override
        public RepositoryManagerFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RepositoryManagerFutureStub(channel, callOptions);
        }
      };
    return RepositoryManagerFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Manages connections to source code repositories.
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Creates a Connection.
     * </pre>
     */
    default void createConnection(com.google.cloudbuild.v2.CreateConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateConnectionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single connection.
     * </pre>
     */
    default void getConnection(com.google.cloudbuild.v2.GetConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v2.Connection> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetConnectionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists Connections in a given project and location.
     * </pre>
     */
    default void listConnections(com.google.cloudbuild.v2.ListConnectionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v2.ListConnectionsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListConnectionsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates a single connection.
     * </pre>
     */
    default void updateConnection(com.google.cloudbuild.v2.UpdateConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateConnectionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a single connection.
     * </pre>
     */
    default void deleteConnection(com.google.cloudbuild.v2.DeleteConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteConnectionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a Repository.
     * </pre>
     */
    default void createRepository(com.google.cloudbuild.v2.CreateRepositoryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateRepositoryMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates multiple repositories inside a connection.
     * </pre>
     */
    default void batchCreateRepositories(com.google.cloudbuild.v2.BatchCreateRepositoriesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBatchCreateRepositoriesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single repository.
     * </pre>
     */
    default void getRepository(com.google.cloudbuild.v2.GetRepositoryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v2.Repository> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetRepositoryMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists Repositories in a given connection.
     * </pre>
     */
    default void listRepositories(com.google.cloudbuild.v2.ListRepositoriesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v2.ListRepositoriesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListRepositoriesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a single repository.
     * </pre>
     */
    default void deleteRepository(com.google.cloudbuild.v2.DeleteRepositoryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteRepositoryMethod(), responseObserver);
    }

    /**
     * <pre>
     * Fetches read/write token of a given repository.
     * </pre>
     */
    default void fetchReadWriteToken(com.google.cloudbuild.v2.FetchReadWriteTokenRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v2.FetchReadWriteTokenResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFetchReadWriteTokenMethod(), responseObserver);
    }

    /**
     * <pre>
     * Fetches read token of a given repository.
     * </pre>
     */
    default void fetchReadToken(com.google.cloudbuild.v2.FetchReadTokenRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v2.FetchReadTokenResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFetchReadTokenMethod(), responseObserver);
    }

    /**
     * <pre>
     * FetchLinkableRepositories get repositories from SCM that are
     * accessible and could be added to the connection.
     * </pre>
     */
    default void fetchLinkableRepositories(com.google.cloudbuild.v2.FetchLinkableRepositoriesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v2.FetchLinkableRepositoriesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFetchLinkableRepositoriesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Fetch the list of branches or tags for a given repository.
     * </pre>
     */
    default void fetchGitRefs(com.google.cloudbuild.v2.FetchGitRefsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v2.FetchGitRefsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFetchGitRefsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service RepositoryManager.
   * <pre>
   * Manages connections to source code repositories.
   * </pre>
   */
  public static abstract class RepositoryManagerImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return RepositoryManagerGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service RepositoryManager.
   * <pre>
   * Manages connections to source code repositories.
   * </pre>
   */
  public static final class RepositoryManagerStub
      extends io.grpc.stub.AbstractAsyncStub<RepositoryManagerStub> {
    private RepositoryManagerStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RepositoryManagerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RepositoryManagerStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a Connection.
     * </pre>
     */
    public void createConnection(com.google.cloudbuild.v2.CreateConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateConnectionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single connection.
     * </pre>
     */
    public void getConnection(com.google.cloudbuild.v2.GetConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v2.Connection> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetConnectionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists Connections in a given project and location.
     * </pre>
     */
    public void listConnections(com.google.cloudbuild.v2.ListConnectionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v2.ListConnectionsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListConnectionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates a single connection.
     * </pre>
     */
    public void updateConnection(com.google.cloudbuild.v2.UpdateConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateConnectionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a single connection.
     * </pre>
     */
    public void deleteConnection(com.google.cloudbuild.v2.DeleteConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteConnectionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a Repository.
     * </pre>
     */
    public void createRepository(com.google.cloudbuild.v2.CreateRepositoryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateRepositoryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates multiple repositories inside a connection.
     * </pre>
     */
    public void batchCreateRepositories(com.google.cloudbuild.v2.BatchCreateRepositoriesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchCreateRepositoriesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single repository.
     * </pre>
     */
    public void getRepository(com.google.cloudbuild.v2.GetRepositoryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v2.Repository> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRepositoryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists Repositories in a given connection.
     * </pre>
     */
    public void listRepositories(com.google.cloudbuild.v2.ListRepositoriesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v2.ListRepositoriesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRepositoriesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a single repository.
     * </pre>
     */
    public void deleteRepository(com.google.cloudbuild.v2.DeleteRepositoryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteRepositoryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Fetches read/write token of a given repository.
     * </pre>
     */
    public void fetchReadWriteToken(com.google.cloudbuild.v2.FetchReadWriteTokenRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v2.FetchReadWriteTokenResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFetchReadWriteTokenMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Fetches read token of a given repository.
     * </pre>
     */
    public void fetchReadToken(com.google.cloudbuild.v2.FetchReadTokenRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v2.FetchReadTokenResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFetchReadTokenMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * FetchLinkableRepositories get repositories from SCM that are
     * accessible and could be added to the connection.
     * </pre>
     */
    public void fetchLinkableRepositories(com.google.cloudbuild.v2.FetchLinkableRepositoriesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v2.FetchLinkableRepositoriesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFetchLinkableRepositoriesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Fetch the list of branches or tags for a given repository.
     * </pre>
     */
    public void fetchGitRefs(com.google.cloudbuild.v2.FetchGitRefsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v2.FetchGitRefsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFetchGitRefsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service RepositoryManager.
   * <pre>
   * Manages connections to source code repositories.
   * </pre>
   */
  public static final class RepositoryManagerBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<RepositoryManagerBlockingStub> {
    private RepositoryManagerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RepositoryManagerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RepositoryManagerBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a Connection.
     * </pre>
     */
    public com.google.longrunning.Operation createConnection(com.google.cloudbuild.v2.CreateConnectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateConnectionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets details of a single connection.
     * </pre>
     */
    public com.google.cloudbuild.v2.Connection getConnection(com.google.cloudbuild.v2.GetConnectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetConnectionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists Connections in a given project and location.
     * </pre>
     */
    public com.google.cloudbuild.v2.ListConnectionsResponse listConnections(com.google.cloudbuild.v2.ListConnectionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListConnectionsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates a single connection.
     * </pre>
     */
    public com.google.longrunning.Operation updateConnection(com.google.cloudbuild.v2.UpdateConnectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateConnectionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a single connection.
     * </pre>
     */
    public com.google.longrunning.Operation deleteConnection(com.google.cloudbuild.v2.DeleteConnectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteConnectionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a Repository.
     * </pre>
     */
    public com.google.longrunning.Operation createRepository(com.google.cloudbuild.v2.CreateRepositoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateRepositoryMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates multiple repositories inside a connection.
     * </pre>
     */
    public com.google.longrunning.Operation batchCreateRepositories(com.google.cloudbuild.v2.BatchCreateRepositoriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchCreateRepositoriesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets details of a single repository.
     * </pre>
     */
    public com.google.cloudbuild.v2.Repository getRepository(com.google.cloudbuild.v2.GetRepositoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRepositoryMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists Repositories in a given connection.
     * </pre>
     */
    public com.google.cloudbuild.v2.ListRepositoriesResponse listRepositories(com.google.cloudbuild.v2.ListRepositoriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRepositoriesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a single repository.
     * </pre>
     */
    public com.google.longrunning.Operation deleteRepository(com.google.cloudbuild.v2.DeleteRepositoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteRepositoryMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Fetches read/write token of a given repository.
     * </pre>
     */
    public com.google.cloudbuild.v2.FetchReadWriteTokenResponse fetchReadWriteToken(com.google.cloudbuild.v2.FetchReadWriteTokenRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchReadWriteTokenMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Fetches read token of a given repository.
     * </pre>
     */
    public com.google.cloudbuild.v2.FetchReadTokenResponse fetchReadToken(com.google.cloudbuild.v2.FetchReadTokenRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchReadTokenMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * FetchLinkableRepositories get repositories from SCM that are
     * accessible and could be added to the connection.
     * </pre>
     */
    public com.google.cloudbuild.v2.FetchLinkableRepositoriesResponse fetchLinkableRepositories(com.google.cloudbuild.v2.FetchLinkableRepositoriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchLinkableRepositoriesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Fetch the list of branches or tags for a given repository.
     * </pre>
     */
    public com.google.cloudbuild.v2.FetchGitRefsResponse fetchGitRefs(com.google.cloudbuild.v2.FetchGitRefsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchGitRefsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service RepositoryManager.
   * <pre>
   * Manages connections to source code repositories.
   * </pre>
   */
  public static final class RepositoryManagerFutureStub
      extends io.grpc.stub.AbstractFutureStub<RepositoryManagerFutureStub> {
    private RepositoryManagerFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RepositoryManagerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RepositoryManagerFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a Connection.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createConnection(
        com.google.cloudbuild.v2.CreateConnectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateConnectionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets details of a single connection.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloudbuild.v2.Connection> getConnection(
        com.google.cloudbuild.v2.GetConnectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetConnectionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists Connections in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloudbuild.v2.ListConnectionsResponse> listConnections(
        com.google.cloudbuild.v2.ListConnectionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListConnectionsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates a single connection.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateConnection(
        com.google.cloudbuild.v2.UpdateConnectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateConnectionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a single connection.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteConnection(
        com.google.cloudbuild.v2.DeleteConnectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteConnectionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a Repository.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createRepository(
        com.google.cloudbuild.v2.CreateRepositoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateRepositoryMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates multiple repositories inside a connection.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> batchCreateRepositories(
        com.google.cloudbuild.v2.BatchCreateRepositoriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchCreateRepositoriesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets details of a single repository.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloudbuild.v2.Repository> getRepository(
        com.google.cloudbuild.v2.GetRepositoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRepositoryMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists Repositories in a given connection.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloudbuild.v2.ListRepositoriesResponse> listRepositories(
        com.google.cloudbuild.v2.ListRepositoriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRepositoriesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a single repository.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteRepository(
        com.google.cloudbuild.v2.DeleteRepositoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteRepositoryMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Fetches read/write token of a given repository.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloudbuild.v2.FetchReadWriteTokenResponse> fetchReadWriteToken(
        com.google.cloudbuild.v2.FetchReadWriteTokenRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFetchReadWriteTokenMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Fetches read token of a given repository.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloudbuild.v2.FetchReadTokenResponse> fetchReadToken(
        com.google.cloudbuild.v2.FetchReadTokenRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFetchReadTokenMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * FetchLinkableRepositories get repositories from SCM that are
     * accessible and could be added to the connection.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloudbuild.v2.FetchLinkableRepositoriesResponse> fetchLinkableRepositories(
        com.google.cloudbuild.v2.FetchLinkableRepositoriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFetchLinkableRepositoriesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Fetch the list of branches or tags for a given repository.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloudbuild.v2.FetchGitRefsResponse> fetchGitRefs(
        com.google.cloudbuild.v2.FetchGitRefsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFetchGitRefsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_CONNECTION = 0;
  private static final int METHODID_GET_CONNECTION = 1;
  private static final int METHODID_LIST_CONNECTIONS = 2;
  private static final int METHODID_UPDATE_CONNECTION = 3;
  private static final int METHODID_DELETE_CONNECTION = 4;
  private static final int METHODID_CREATE_REPOSITORY = 5;
  private static final int METHODID_BATCH_CREATE_REPOSITORIES = 6;
  private static final int METHODID_GET_REPOSITORY = 7;
  private static final int METHODID_LIST_REPOSITORIES = 8;
  private static final int METHODID_DELETE_REPOSITORY = 9;
  private static final int METHODID_FETCH_READ_WRITE_TOKEN = 10;
  private static final int METHODID_FETCH_READ_TOKEN = 11;
  private static final int METHODID_FETCH_LINKABLE_REPOSITORIES = 12;
  private static final int METHODID_FETCH_GIT_REFS = 13;

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
        case METHODID_CREATE_CONNECTION:
          serviceImpl.createConnection((com.google.cloudbuild.v2.CreateConnectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_CONNECTION:
          serviceImpl.getConnection((com.google.cloudbuild.v2.GetConnectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloudbuild.v2.Connection>) responseObserver);
          break;
        case METHODID_LIST_CONNECTIONS:
          serviceImpl.listConnections((com.google.cloudbuild.v2.ListConnectionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloudbuild.v2.ListConnectionsResponse>) responseObserver);
          break;
        case METHODID_UPDATE_CONNECTION:
          serviceImpl.updateConnection((com.google.cloudbuild.v2.UpdateConnectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_CONNECTION:
          serviceImpl.deleteConnection((com.google.cloudbuild.v2.DeleteConnectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_REPOSITORY:
          serviceImpl.createRepository((com.google.cloudbuild.v2.CreateRepositoryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_BATCH_CREATE_REPOSITORIES:
          serviceImpl.batchCreateRepositories((com.google.cloudbuild.v2.BatchCreateRepositoriesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_REPOSITORY:
          serviceImpl.getRepository((com.google.cloudbuild.v2.GetRepositoryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloudbuild.v2.Repository>) responseObserver);
          break;
        case METHODID_LIST_REPOSITORIES:
          serviceImpl.listRepositories((com.google.cloudbuild.v2.ListRepositoriesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloudbuild.v2.ListRepositoriesResponse>) responseObserver);
          break;
        case METHODID_DELETE_REPOSITORY:
          serviceImpl.deleteRepository((com.google.cloudbuild.v2.DeleteRepositoryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_FETCH_READ_WRITE_TOKEN:
          serviceImpl.fetchReadWriteToken((com.google.cloudbuild.v2.FetchReadWriteTokenRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloudbuild.v2.FetchReadWriteTokenResponse>) responseObserver);
          break;
        case METHODID_FETCH_READ_TOKEN:
          serviceImpl.fetchReadToken((com.google.cloudbuild.v2.FetchReadTokenRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloudbuild.v2.FetchReadTokenResponse>) responseObserver);
          break;
        case METHODID_FETCH_LINKABLE_REPOSITORIES:
          serviceImpl.fetchLinkableRepositories((com.google.cloudbuild.v2.FetchLinkableRepositoriesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloudbuild.v2.FetchLinkableRepositoriesResponse>) responseObserver);
          break;
        case METHODID_FETCH_GIT_REFS:
          serviceImpl.fetchGitRefs((com.google.cloudbuild.v2.FetchGitRefsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloudbuild.v2.FetchGitRefsResponse>) responseObserver);
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
          getCreateConnectionMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloudbuild.v2.CreateConnectionRequest,
              com.google.longrunning.Operation>(
                service, METHODID_CREATE_CONNECTION)))
        .addMethod(
          getGetConnectionMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloudbuild.v2.GetConnectionRequest,
              com.google.cloudbuild.v2.Connection>(
                service, METHODID_GET_CONNECTION)))
        .addMethod(
          getListConnectionsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloudbuild.v2.ListConnectionsRequest,
              com.google.cloudbuild.v2.ListConnectionsResponse>(
                service, METHODID_LIST_CONNECTIONS)))
        .addMethod(
          getUpdateConnectionMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloudbuild.v2.UpdateConnectionRequest,
              com.google.longrunning.Operation>(
                service, METHODID_UPDATE_CONNECTION)))
        .addMethod(
          getDeleteConnectionMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloudbuild.v2.DeleteConnectionRequest,
              com.google.longrunning.Operation>(
                service, METHODID_DELETE_CONNECTION)))
        .addMethod(
          getCreateRepositoryMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloudbuild.v2.CreateRepositoryRequest,
              com.google.longrunning.Operation>(
                service, METHODID_CREATE_REPOSITORY)))
        .addMethod(
          getBatchCreateRepositoriesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloudbuild.v2.BatchCreateRepositoriesRequest,
              com.google.longrunning.Operation>(
                service, METHODID_BATCH_CREATE_REPOSITORIES)))
        .addMethod(
          getGetRepositoryMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloudbuild.v2.GetRepositoryRequest,
              com.google.cloudbuild.v2.Repository>(
                service, METHODID_GET_REPOSITORY)))
        .addMethod(
          getListRepositoriesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloudbuild.v2.ListRepositoriesRequest,
              com.google.cloudbuild.v2.ListRepositoriesResponse>(
                service, METHODID_LIST_REPOSITORIES)))
        .addMethod(
          getDeleteRepositoryMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloudbuild.v2.DeleteRepositoryRequest,
              com.google.longrunning.Operation>(
                service, METHODID_DELETE_REPOSITORY)))
        .addMethod(
          getFetchReadWriteTokenMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloudbuild.v2.FetchReadWriteTokenRequest,
              com.google.cloudbuild.v2.FetchReadWriteTokenResponse>(
                service, METHODID_FETCH_READ_WRITE_TOKEN)))
        .addMethod(
          getFetchReadTokenMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloudbuild.v2.FetchReadTokenRequest,
              com.google.cloudbuild.v2.FetchReadTokenResponse>(
                service, METHODID_FETCH_READ_TOKEN)))
        .addMethod(
          getFetchLinkableRepositoriesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloudbuild.v2.FetchLinkableRepositoriesRequest,
              com.google.cloudbuild.v2.FetchLinkableRepositoriesResponse>(
                service, METHODID_FETCH_LINKABLE_REPOSITORIES)))
        .addMethod(
          getFetchGitRefsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloudbuild.v2.FetchGitRefsRequest,
              com.google.cloudbuild.v2.FetchGitRefsResponse>(
                service, METHODID_FETCH_GIT_REFS)))
        .build();
  }

  private static abstract class RepositoryManagerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RepositoryManagerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloudbuild.v2.RepositoryManagerProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RepositoryManager");
    }
  }

  private static final class RepositoryManagerFileDescriptorSupplier
      extends RepositoryManagerBaseDescriptorSupplier {
    RepositoryManagerFileDescriptorSupplier() {}
  }

  private static final class RepositoryManagerMethodDescriptorSupplier
      extends RepositoryManagerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    RepositoryManagerMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (RepositoryManagerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RepositoryManagerFileDescriptorSupplier())
              .addMethod(getCreateConnectionMethod())
              .addMethod(getGetConnectionMethod())
              .addMethod(getListConnectionsMethod())
              .addMethod(getUpdateConnectionMethod())
              .addMethod(getDeleteConnectionMethod())
              .addMethod(getCreateRepositoryMethod())
              .addMethod(getBatchCreateRepositoriesMethod())
              .addMethod(getGetRepositoryMethod())
              .addMethod(getListRepositoriesMethod())
              .addMethod(getDeleteRepositoryMethod())
              .addMethod(getFetchReadWriteTokenMethod())
              .addMethod(getFetchReadTokenMethod())
              .addMethod(getFetchLinkableRepositoriesMethod())
              .addMethod(getFetchGitRefsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
