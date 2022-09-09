package com.google.area120.tables.v1alpha1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * The Tables Service provides an API for reading and updating tables.
 * It defines the following resource model:
 * - The API has a collection of [Table][google.area120.tables.v1alpha1.Table]
 *   resources, named `tables/&#42;`
 * - Each Table has a collection of [Row][google.area120.tables.v1alpha1.Row]
 *   resources, named `tables/&#42;&#47;rows/&#42;`
 * - The API has a collection of
 *   [Workspace][google.area120.tables.v1alpha1.Workspace]
 *   resources, named `workspaces/&#42;`.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/area120/tables/v1alpha1/tables.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TablesServiceGrpc {

  private TablesServiceGrpc() {}

  public static final String SERVICE_NAME = "google.area120.tables.v1alpha1.TablesService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.area120.tables.v1alpha1.GetTableRequest,
      com.google.area120.tables.v1alpha1.Table> getGetTableMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTable",
      requestType = com.google.area120.tables.v1alpha1.GetTableRequest.class,
      responseType = com.google.area120.tables.v1alpha1.Table.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.area120.tables.v1alpha1.GetTableRequest,
      com.google.area120.tables.v1alpha1.Table> getGetTableMethod() {
    io.grpc.MethodDescriptor<com.google.area120.tables.v1alpha1.GetTableRequest, com.google.area120.tables.v1alpha1.Table> getGetTableMethod;
    if ((getGetTableMethod = TablesServiceGrpc.getGetTableMethod) == null) {
      synchronized (TablesServiceGrpc.class) {
        if ((getGetTableMethod = TablesServiceGrpc.getGetTableMethod) == null) {
          TablesServiceGrpc.getGetTableMethod = getGetTableMethod =
              io.grpc.MethodDescriptor.<com.google.area120.tables.v1alpha1.GetTableRequest, com.google.area120.tables.v1alpha1.Table>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTable"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.area120.tables.v1alpha1.GetTableRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.area120.tables.v1alpha1.Table.getDefaultInstance()))
              .setSchemaDescriptor(new TablesServiceMethodDescriptorSupplier("GetTable"))
              .build();
        }
      }
    }
    return getGetTableMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.area120.tables.v1alpha1.ListTablesRequest,
      com.google.area120.tables.v1alpha1.ListTablesResponse> getListTablesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTables",
      requestType = com.google.area120.tables.v1alpha1.ListTablesRequest.class,
      responseType = com.google.area120.tables.v1alpha1.ListTablesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.area120.tables.v1alpha1.ListTablesRequest,
      com.google.area120.tables.v1alpha1.ListTablesResponse> getListTablesMethod() {
    io.grpc.MethodDescriptor<com.google.area120.tables.v1alpha1.ListTablesRequest, com.google.area120.tables.v1alpha1.ListTablesResponse> getListTablesMethod;
    if ((getListTablesMethod = TablesServiceGrpc.getListTablesMethod) == null) {
      synchronized (TablesServiceGrpc.class) {
        if ((getListTablesMethod = TablesServiceGrpc.getListTablesMethod) == null) {
          TablesServiceGrpc.getListTablesMethod = getListTablesMethod =
              io.grpc.MethodDescriptor.<com.google.area120.tables.v1alpha1.ListTablesRequest, com.google.area120.tables.v1alpha1.ListTablesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTables"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.area120.tables.v1alpha1.ListTablesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.area120.tables.v1alpha1.ListTablesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TablesServiceMethodDescriptorSupplier("ListTables"))
              .build();
        }
      }
    }
    return getListTablesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.area120.tables.v1alpha1.GetWorkspaceRequest,
      com.google.area120.tables.v1alpha1.Workspace> getGetWorkspaceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetWorkspace",
      requestType = com.google.area120.tables.v1alpha1.GetWorkspaceRequest.class,
      responseType = com.google.area120.tables.v1alpha1.Workspace.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.area120.tables.v1alpha1.GetWorkspaceRequest,
      com.google.area120.tables.v1alpha1.Workspace> getGetWorkspaceMethod() {
    io.grpc.MethodDescriptor<com.google.area120.tables.v1alpha1.GetWorkspaceRequest, com.google.area120.tables.v1alpha1.Workspace> getGetWorkspaceMethod;
    if ((getGetWorkspaceMethod = TablesServiceGrpc.getGetWorkspaceMethod) == null) {
      synchronized (TablesServiceGrpc.class) {
        if ((getGetWorkspaceMethod = TablesServiceGrpc.getGetWorkspaceMethod) == null) {
          TablesServiceGrpc.getGetWorkspaceMethod = getGetWorkspaceMethod =
              io.grpc.MethodDescriptor.<com.google.area120.tables.v1alpha1.GetWorkspaceRequest, com.google.area120.tables.v1alpha1.Workspace>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetWorkspace"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.area120.tables.v1alpha1.GetWorkspaceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.area120.tables.v1alpha1.Workspace.getDefaultInstance()))
              .setSchemaDescriptor(new TablesServiceMethodDescriptorSupplier("GetWorkspace"))
              .build();
        }
      }
    }
    return getGetWorkspaceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.area120.tables.v1alpha1.ListWorkspacesRequest,
      com.google.area120.tables.v1alpha1.ListWorkspacesResponse> getListWorkspacesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListWorkspaces",
      requestType = com.google.area120.tables.v1alpha1.ListWorkspacesRequest.class,
      responseType = com.google.area120.tables.v1alpha1.ListWorkspacesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.area120.tables.v1alpha1.ListWorkspacesRequest,
      com.google.area120.tables.v1alpha1.ListWorkspacesResponse> getListWorkspacesMethod() {
    io.grpc.MethodDescriptor<com.google.area120.tables.v1alpha1.ListWorkspacesRequest, com.google.area120.tables.v1alpha1.ListWorkspacesResponse> getListWorkspacesMethod;
    if ((getListWorkspacesMethod = TablesServiceGrpc.getListWorkspacesMethod) == null) {
      synchronized (TablesServiceGrpc.class) {
        if ((getListWorkspacesMethod = TablesServiceGrpc.getListWorkspacesMethod) == null) {
          TablesServiceGrpc.getListWorkspacesMethod = getListWorkspacesMethod =
              io.grpc.MethodDescriptor.<com.google.area120.tables.v1alpha1.ListWorkspacesRequest, com.google.area120.tables.v1alpha1.ListWorkspacesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListWorkspaces"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.area120.tables.v1alpha1.ListWorkspacesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.area120.tables.v1alpha1.ListWorkspacesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TablesServiceMethodDescriptorSupplier("ListWorkspaces"))
              .build();
        }
      }
    }
    return getListWorkspacesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.area120.tables.v1alpha1.GetRowRequest,
      com.google.area120.tables.v1alpha1.Row> getGetRowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRow",
      requestType = com.google.area120.tables.v1alpha1.GetRowRequest.class,
      responseType = com.google.area120.tables.v1alpha1.Row.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.area120.tables.v1alpha1.GetRowRequest,
      com.google.area120.tables.v1alpha1.Row> getGetRowMethod() {
    io.grpc.MethodDescriptor<com.google.area120.tables.v1alpha1.GetRowRequest, com.google.area120.tables.v1alpha1.Row> getGetRowMethod;
    if ((getGetRowMethod = TablesServiceGrpc.getGetRowMethod) == null) {
      synchronized (TablesServiceGrpc.class) {
        if ((getGetRowMethod = TablesServiceGrpc.getGetRowMethod) == null) {
          TablesServiceGrpc.getGetRowMethod = getGetRowMethod =
              io.grpc.MethodDescriptor.<com.google.area120.tables.v1alpha1.GetRowRequest, com.google.area120.tables.v1alpha1.Row>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRow"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.area120.tables.v1alpha1.GetRowRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.area120.tables.v1alpha1.Row.getDefaultInstance()))
              .setSchemaDescriptor(new TablesServiceMethodDescriptorSupplier("GetRow"))
              .build();
        }
      }
    }
    return getGetRowMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.area120.tables.v1alpha1.ListRowsRequest,
      com.google.area120.tables.v1alpha1.ListRowsResponse> getListRowsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRows",
      requestType = com.google.area120.tables.v1alpha1.ListRowsRequest.class,
      responseType = com.google.area120.tables.v1alpha1.ListRowsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.area120.tables.v1alpha1.ListRowsRequest,
      com.google.area120.tables.v1alpha1.ListRowsResponse> getListRowsMethod() {
    io.grpc.MethodDescriptor<com.google.area120.tables.v1alpha1.ListRowsRequest, com.google.area120.tables.v1alpha1.ListRowsResponse> getListRowsMethod;
    if ((getListRowsMethod = TablesServiceGrpc.getListRowsMethod) == null) {
      synchronized (TablesServiceGrpc.class) {
        if ((getListRowsMethod = TablesServiceGrpc.getListRowsMethod) == null) {
          TablesServiceGrpc.getListRowsMethod = getListRowsMethod =
              io.grpc.MethodDescriptor.<com.google.area120.tables.v1alpha1.ListRowsRequest, com.google.area120.tables.v1alpha1.ListRowsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListRows"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.area120.tables.v1alpha1.ListRowsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.area120.tables.v1alpha1.ListRowsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TablesServiceMethodDescriptorSupplier("ListRows"))
              .build();
        }
      }
    }
    return getListRowsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.area120.tables.v1alpha1.CreateRowRequest,
      com.google.area120.tables.v1alpha1.Row> getCreateRowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRow",
      requestType = com.google.area120.tables.v1alpha1.CreateRowRequest.class,
      responseType = com.google.area120.tables.v1alpha1.Row.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.area120.tables.v1alpha1.CreateRowRequest,
      com.google.area120.tables.v1alpha1.Row> getCreateRowMethod() {
    io.grpc.MethodDescriptor<com.google.area120.tables.v1alpha1.CreateRowRequest, com.google.area120.tables.v1alpha1.Row> getCreateRowMethod;
    if ((getCreateRowMethod = TablesServiceGrpc.getCreateRowMethod) == null) {
      synchronized (TablesServiceGrpc.class) {
        if ((getCreateRowMethod = TablesServiceGrpc.getCreateRowMethod) == null) {
          TablesServiceGrpc.getCreateRowMethod = getCreateRowMethod =
              io.grpc.MethodDescriptor.<com.google.area120.tables.v1alpha1.CreateRowRequest, com.google.area120.tables.v1alpha1.Row>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateRow"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.area120.tables.v1alpha1.CreateRowRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.area120.tables.v1alpha1.Row.getDefaultInstance()))
              .setSchemaDescriptor(new TablesServiceMethodDescriptorSupplier("CreateRow"))
              .build();
        }
      }
    }
    return getCreateRowMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.area120.tables.v1alpha1.BatchCreateRowsRequest,
      com.google.area120.tables.v1alpha1.BatchCreateRowsResponse> getBatchCreateRowsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchCreateRows",
      requestType = com.google.area120.tables.v1alpha1.BatchCreateRowsRequest.class,
      responseType = com.google.area120.tables.v1alpha1.BatchCreateRowsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.area120.tables.v1alpha1.BatchCreateRowsRequest,
      com.google.area120.tables.v1alpha1.BatchCreateRowsResponse> getBatchCreateRowsMethod() {
    io.grpc.MethodDescriptor<com.google.area120.tables.v1alpha1.BatchCreateRowsRequest, com.google.area120.tables.v1alpha1.BatchCreateRowsResponse> getBatchCreateRowsMethod;
    if ((getBatchCreateRowsMethod = TablesServiceGrpc.getBatchCreateRowsMethod) == null) {
      synchronized (TablesServiceGrpc.class) {
        if ((getBatchCreateRowsMethod = TablesServiceGrpc.getBatchCreateRowsMethod) == null) {
          TablesServiceGrpc.getBatchCreateRowsMethod = getBatchCreateRowsMethod =
              io.grpc.MethodDescriptor.<com.google.area120.tables.v1alpha1.BatchCreateRowsRequest, com.google.area120.tables.v1alpha1.BatchCreateRowsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchCreateRows"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.area120.tables.v1alpha1.BatchCreateRowsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.area120.tables.v1alpha1.BatchCreateRowsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TablesServiceMethodDescriptorSupplier("BatchCreateRows"))
              .build();
        }
      }
    }
    return getBatchCreateRowsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.area120.tables.v1alpha1.UpdateRowRequest,
      com.google.area120.tables.v1alpha1.Row> getUpdateRowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateRow",
      requestType = com.google.area120.tables.v1alpha1.UpdateRowRequest.class,
      responseType = com.google.area120.tables.v1alpha1.Row.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.area120.tables.v1alpha1.UpdateRowRequest,
      com.google.area120.tables.v1alpha1.Row> getUpdateRowMethod() {
    io.grpc.MethodDescriptor<com.google.area120.tables.v1alpha1.UpdateRowRequest, com.google.area120.tables.v1alpha1.Row> getUpdateRowMethod;
    if ((getUpdateRowMethod = TablesServiceGrpc.getUpdateRowMethod) == null) {
      synchronized (TablesServiceGrpc.class) {
        if ((getUpdateRowMethod = TablesServiceGrpc.getUpdateRowMethod) == null) {
          TablesServiceGrpc.getUpdateRowMethod = getUpdateRowMethod =
              io.grpc.MethodDescriptor.<com.google.area120.tables.v1alpha1.UpdateRowRequest, com.google.area120.tables.v1alpha1.Row>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateRow"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.area120.tables.v1alpha1.UpdateRowRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.area120.tables.v1alpha1.Row.getDefaultInstance()))
              .setSchemaDescriptor(new TablesServiceMethodDescriptorSupplier("UpdateRow"))
              .build();
        }
      }
    }
    return getUpdateRowMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.area120.tables.v1alpha1.BatchUpdateRowsRequest,
      com.google.area120.tables.v1alpha1.BatchUpdateRowsResponse> getBatchUpdateRowsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchUpdateRows",
      requestType = com.google.area120.tables.v1alpha1.BatchUpdateRowsRequest.class,
      responseType = com.google.area120.tables.v1alpha1.BatchUpdateRowsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.area120.tables.v1alpha1.BatchUpdateRowsRequest,
      com.google.area120.tables.v1alpha1.BatchUpdateRowsResponse> getBatchUpdateRowsMethod() {
    io.grpc.MethodDescriptor<com.google.area120.tables.v1alpha1.BatchUpdateRowsRequest, com.google.area120.tables.v1alpha1.BatchUpdateRowsResponse> getBatchUpdateRowsMethod;
    if ((getBatchUpdateRowsMethod = TablesServiceGrpc.getBatchUpdateRowsMethod) == null) {
      synchronized (TablesServiceGrpc.class) {
        if ((getBatchUpdateRowsMethod = TablesServiceGrpc.getBatchUpdateRowsMethod) == null) {
          TablesServiceGrpc.getBatchUpdateRowsMethod = getBatchUpdateRowsMethod =
              io.grpc.MethodDescriptor.<com.google.area120.tables.v1alpha1.BatchUpdateRowsRequest, com.google.area120.tables.v1alpha1.BatchUpdateRowsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchUpdateRows"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.area120.tables.v1alpha1.BatchUpdateRowsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.area120.tables.v1alpha1.BatchUpdateRowsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TablesServiceMethodDescriptorSupplier("BatchUpdateRows"))
              .build();
        }
      }
    }
    return getBatchUpdateRowsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.area120.tables.v1alpha1.DeleteRowRequest,
      com.google.protobuf.Empty> getDeleteRowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteRow",
      requestType = com.google.area120.tables.v1alpha1.DeleteRowRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.area120.tables.v1alpha1.DeleteRowRequest,
      com.google.protobuf.Empty> getDeleteRowMethod() {
    io.grpc.MethodDescriptor<com.google.area120.tables.v1alpha1.DeleteRowRequest, com.google.protobuf.Empty> getDeleteRowMethod;
    if ((getDeleteRowMethod = TablesServiceGrpc.getDeleteRowMethod) == null) {
      synchronized (TablesServiceGrpc.class) {
        if ((getDeleteRowMethod = TablesServiceGrpc.getDeleteRowMethod) == null) {
          TablesServiceGrpc.getDeleteRowMethod = getDeleteRowMethod =
              io.grpc.MethodDescriptor.<com.google.area120.tables.v1alpha1.DeleteRowRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteRow"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.area120.tables.v1alpha1.DeleteRowRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new TablesServiceMethodDescriptorSupplier("DeleteRow"))
              .build();
        }
      }
    }
    return getDeleteRowMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.area120.tables.v1alpha1.BatchDeleteRowsRequest,
      com.google.protobuf.Empty> getBatchDeleteRowsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchDeleteRows",
      requestType = com.google.area120.tables.v1alpha1.BatchDeleteRowsRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.area120.tables.v1alpha1.BatchDeleteRowsRequest,
      com.google.protobuf.Empty> getBatchDeleteRowsMethod() {
    io.grpc.MethodDescriptor<com.google.area120.tables.v1alpha1.BatchDeleteRowsRequest, com.google.protobuf.Empty> getBatchDeleteRowsMethod;
    if ((getBatchDeleteRowsMethod = TablesServiceGrpc.getBatchDeleteRowsMethod) == null) {
      synchronized (TablesServiceGrpc.class) {
        if ((getBatchDeleteRowsMethod = TablesServiceGrpc.getBatchDeleteRowsMethod) == null) {
          TablesServiceGrpc.getBatchDeleteRowsMethod = getBatchDeleteRowsMethod =
              io.grpc.MethodDescriptor.<com.google.area120.tables.v1alpha1.BatchDeleteRowsRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchDeleteRows"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.area120.tables.v1alpha1.BatchDeleteRowsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new TablesServiceMethodDescriptorSupplier("BatchDeleteRows"))
              .build();
        }
      }
    }
    return getBatchDeleteRowsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TablesServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TablesServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TablesServiceStub>() {
        @java.lang.Override
        public TablesServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TablesServiceStub(channel, callOptions);
        }
      };
    return TablesServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TablesServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TablesServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TablesServiceBlockingStub>() {
        @java.lang.Override
        public TablesServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TablesServiceBlockingStub(channel, callOptions);
        }
      };
    return TablesServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TablesServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TablesServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TablesServiceFutureStub>() {
        @java.lang.Override
        public TablesServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TablesServiceFutureStub(channel, callOptions);
        }
      };
    return TablesServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * The Tables Service provides an API for reading and updating tables.
   * It defines the following resource model:
   * - The API has a collection of [Table][google.area120.tables.v1alpha1.Table]
   *   resources, named `tables/&#42;`
   * - Each Table has a collection of [Row][google.area120.tables.v1alpha1.Row]
   *   resources, named `tables/&#42;&#47;rows/&#42;`
   * - The API has a collection of
   *   [Workspace][google.area120.tables.v1alpha1.Workspace]
   *   resources, named `workspaces/&#42;`.
   * </pre>
   */
  public static abstract class TablesServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Gets a table. Returns NOT_FOUND if the table does not exist.
     * </pre>
     */
    public void getTable(com.google.area120.tables.v1alpha1.GetTableRequest request,
        io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.Table> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTableMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists tables for the user.
     * </pre>
     */
    public void listTables(com.google.area120.tables.v1alpha1.ListTablesRequest request,
        io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.ListTablesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListTablesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets a workspace. Returns NOT_FOUND if the workspace does not exist.
     * </pre>
     */
    public void getWorkspace(com.google.area120.tables.v1alpha1.GetWorkspaceRequest request,
        io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.Workspace> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetWorkspaceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists workspaces for the user.
     * </pre>
     */
    public void listWorkspaces(com.google.area120.tables.v1alpha1.ListWorkspacesRequest request,
        io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.ListWorkspacesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListWorkspacesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets a row. Returns NOT_FOUND if the row does not exist in the table.
     * </pre>
     */
    public void getRow(com.google.area120.tables.v1alpha1.GetRowRequest request,
        io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.Row> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetRowMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists rows in a table. Returns NOT_FOUND if the table does not exist.
     * </pre>
     */
    public void listRows(com.google.area120.tables.v1alpha1.ListRowsRequest request,
        io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.ListRowsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListRowsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a row.
     * </pre>
     */
    public void createRow(com.google.area120.tables.v1alpha1.CreateRowRequest request,
        io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.Row> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateRowMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates multiple rows.
     * </pre>
     */
    public void batchCreateRows(com.google.area120.tables.v1alpha1.BatchCreateRowsRequest request,
        io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.BatchCreateRowsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBatchCreateRowsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates a row.
     * </pre>
     */
    public void updateRow(com.google.area120.tables.v1alpha1.UpdateRowRequest request,
        io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.Row> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateRowMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates multiple rows.
     * </pre>
     */
    public void batchUpdateRows(com.google.area120.tables.v1alpha1.BatchUpdateRowsRequest request,
        io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.BatchUpdateRowsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBatchUpdateRowsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a row.
     * </pre>
     */
    public void deleteRow(com.google.area120.tables.v1alpha1.DeleteRowRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteRowMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes multiple rows.
     * </pre>
     */
    public void batchDeleteRows(com.google.area120.tables.v1alpha1.BatchDeleteRowsRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBatchDeleteRowsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetTableMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.area120.tables.v1alpha1.GetTableRequest,
                com.google.area120.tables.v1alpha1.Table>(
                  this, METHODID_GET_TABLE)))
          .addMethod(
            getListTablesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.area120.tables.v1alpha1.ListTablesRequest,
                com.google.area120.tables.v1alpha1.ListTablesResponse>(
                  this, METHODID_LIST_TABLES)))
          .addMethod(
            getGetWorkspaceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.area120.tables.v1alpha1.GetWorkspaceRequest,
                com.google.area120.tables.v1alpha1.Workspace>(
                  this, METHODID_GET_WORKSPACE)))
          .addMethod(
            getListWorkspacesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.area120.tables.v1alpha1.ListWorkspacesRequest,
                com.google.area120.tables.v1alpha1.ListWorkspacesResponse>(
                  this, METHODID_LIST_WORKSPACES)))
          .addMethod(
            getGetRowMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.area120.tables.v1alpha1.GetRowRequest,
                com.google.area120.tables.v1alpha1.Row>(
                  this, METHODID_GET_ROW)))
          .addMethod(
            getListRowsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.area120.tables.v1alpha1.ListRowsRequest,
                com.google.area120.tables.v1alpha1.ListRowsResponse>(
                  this, METHODID_LIST_ROWS)))
          .addMethod(
            getCreateRowMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.area120.tables.v1alpha1.CreateRowRequest,
                com.google.area120.tables.v1alpha1.Row>(
                  this, METHODID_CREATE_ROW)))
          .addMethod(
            getBatchCreateRowsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.area120.tables.v1alpha1.BatchCreateRowsRequest,
                com.google.area120.tables.v1alpha1.BatchCreateRowsResponse>(
                  this, METHODID_BATCH_CREATE_ROWS)))
          .addMethod(
            getUpdateRowMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.area120.tables.v1alpha1.UpdateRowRequest,
                com.google.area120.tables.v1alpha1.Row>(
                  this, METHODID_UPDATE_ROW)))
          .addMethod(
            getBatchUpdateRowsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.area120.tables.v1alpha1.BatchUpdateRowsRequest,
                com.google.area120.tables.v1alpha1.BatchUpdateRowsResponse>(
                  this, METHODID_BATCH_UPDATE_ROWS)))
          .addMethod(
            getDeleteRowMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.area120.tables.v1alpha1.DeleteRowRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_ROW)))
          .addMethod(
            getBatchDeleteRowsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.area120.tables.v1alpha1.BatchDeleteRowsRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_BATCH_DELETE_ROWS)))
          .build();
    }
  }

  /**
   * <pre>
   * The Tables Service provides an API for reading and updating tables.
   * It defines the following resource model:
   * - The API has a collection of [Table][google.area120.tables.v1alpha1.Table]
   *   resources, named `tables/&#42;`
   * - Each Table has a collection of [Row][google.area120.tables.v1alpha1.Row]
   *   resources, named `tables/&#42;&#47;rows/&#42;`
   * - The API has a collection of
   *   [Workspace][google.area120.tables.v1alpha1.Workspace]
   *   resources, named `workspaces/&#42;`.
   * </pre>
   */
  public static final class TablesServiceStub extends io.grpc.stub.AbstractAsyncStub<TablesServiceStub> {
    private TablesServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TablesServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TablesServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Gets a table. Returns NOT_FOUND if the table does not exist.
     * </pre>
     */
    public void getTable(com.google.area120.tables.v1alpha1.GetTableRequest request,
        io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.Table> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTableMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists tables for the user.
     * </pre>
     */
    public void listTables(com.google.area120.tables.v1alpha1.ListTablesRequest request,
        io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.ListTablesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTablesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a workspace. Returns NOT_FOUND if the workspace does not exist.
     * </pre>
     */
    public void getWorkspace(com.google.area120.tables.v1alpha1.GetWorkspaceRequest request,
        io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.Workspace> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetWorkspaceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists workspaces for the user.
     * </pre>
     */
    public void listWorkspaces(com.google.area120.tables.v1alpha1.ListWorkspacesRequest request,
        io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.ListWorkspacesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListWorkspacesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a row. Returns NOT_FOUND if the row does not exist in the table.
     * </pre>
     */
    public void getRow(com.google.area120.tables.v1alpha1.GetRowRequest request,
        io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.Row> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRowMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists rows in a table. Returns NOT_FOUND if the table does not exist.
     * </pre>
     */
    public void listRows(com.google.area120.tables.v1alpha1.ListRowsRequest request,
        io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.ListRowsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRowsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a row.
     * </pre>
     */
    public void createRow(com.google.area120.tables.v1alpha1.CreateRowRequest request,
        io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.Row> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateRowMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates multiple rows.
     * </pre>
     */
    public void batchCreateRows(com.google.area120.tables.v1alpha1.BatchCreateRowsRequest request,
        io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.BatchCreateRowsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchCreateRowsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates a row.
     * </pre>
     */
    public void updateRow(com.google.area120.tables.v1alpha1.UpdateRowRequest request,
        io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.Row> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateRowMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates multiple rows.
     * </pre>
     */
    public void batchUpdateRows(com.google.area120.tables.v1alpha1.BatchUpdateRowsRequest request,
        io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.BatchUpdateRowsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchUpdateRowsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a row.
     * </pre>
     */
    public void deleteRow(com.google.area120.tables.v1alpha1.DeleteRowRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteRowMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes multiple rows.
     * </pre>
     */
    public void batchDeleteRows(com.google.area120.tables.v1alpha1.BatchDeleteRowsRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchDeleteRowsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The Tables Service provides an API for reading and updating tables.
   * It defines the following resource model:
   * - The API has a collection of [Table][google.area120.tables.v1alpha1.Table]
   *   resources, named `tables/&#42;`
   * - Each Table has a collection of [Row][google.area120.tables.v1alpha1.Row]
   *   resources, named `tables/&#42;&#47;rows/&#42;`
   * - The API has a collection of
   *   [Workspace][google.area120.tables.v1alpha1.Workspace]
   *   resources, named `workspaces/&#42;`.
   * </pre>
   */
  public static final class TablesServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<TablesServiceBlockingStub> {
    private TablesServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TablesServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TablesServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Gets a table. Returns NOT_FOUND if the table does not exist.
     * </pre>
     */
    public com.google.area120.tables.v1alpha1.Table getTable(com.google.area120.tables.v1alpha1.GetTableRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTableMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists tables for the user.
     * </pre>
     */
    public com.google.area120.tables.v1alpha1.ListTablesResponse listTables(com.google.area120.tables.v1alpha1.ListTablesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTablesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a workspace. Returns NOT_FOUND if the workspace does not exist.
     * </pre>
     */
    public com.google.area120.tables.v1alpha1.Workspace getWorkspace(com.google.area120.tables.v1alpha1.GetWorkspaceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetWorkspaceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists workspaces for the user.
     * </pre>
     */
    public com.google.area120.tables.v1alpha1.ListWorkspacesResponse listWorkspaces(com.google.area120.tables.v1alpha1.ListWorkspacesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListWorkspacesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a row. Returns NOT_FOUND if the row does not exist in the table.
     * </pre>
     */
    public com.google.area120.tables.v1alpha1.Row getRow(com.google.area120.tables.v1alpha1.GetRowRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRowMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists rows in a table. Returns NOT_FOUND if the table does not exist.
     * </pre>
     */
    public com.google.area120.tables.v1alpha1.ListRowsResponse listRows(com.google.area120.tables.v1alpha1.ListRowsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRowsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a row.
     * </pre>
     */
    public com.google.area120.tables.v1alpha1.Row createRow(com.google.area120.tables.v1alpha1.CreateRowRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateRowMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates multiple rows.
     * </pre>
     */
    public com.google.area120.tables.v1alpha1.BatchCreateRowsResponse batchCreateRows(com.google.area120.tables.v1alpha1.BatchCreateRowsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchCreateRowsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates a row.
     * </pre>
     */
    public com.google.area120.tables.v1alpha1.Row updateRow(com.google.area120.tables.v1alpha1.UpdateRowRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateRowMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates multiple rows.
     * </pre>
     */
    public com.google.area120.tables.v1alpha1.BatchUpdateRowsResponse batchUpdateRows(com.google.area120.tables.v1alpha1.BatchUpdateRowsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchUpdateRowsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a row.
     * </pre>
     */
    public com.google.protobuf.Empty deleteRow(com.google.area120.tables.v1alpha1.DeleteRowRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteRowMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes multiple rows.
     * </pre>
     */
    public com.google.protobuf.Empty batchDeleteRows(com.google.area120.tables.v1alpha1.BatchDeleteRowsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchDeleteRowsMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The Tables Service provides an API for reading and updating tables.
   * It defines the following resource model:
   * - The API has a collection of [Table][google.area120.tables.v1alpha1.Table]
   *   resources, named `tables/&#42;`
   * - Each Table has a collection of [Row][google.area120.tables.v1alpha1.Row]
   *   resources, named `tables/&#42;&#47;rows/&#42;`
   * - The API has a collection of
   *   [Workspace][google.area120.tables.v1alpha1.Workspace]
   *   resources, named `workspaces/&#42;`.
   * </pre>
   */
  public static final class TablesServiceFutureStub extends io.grpc.stub.AbstractFutureStub<TablesServiceFutureStub> {
    private TablesServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TablesServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TablesServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Gets a table. Returns NOT_FOUND if the table does not exist.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.area120.tables.v1alpha1.Table> getTable(
        com.google.area120.tables.v1alpha1.GetTableRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTableMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists tables for the user.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.area120.tables.v1alpha1.ListTablesResponse> listTables(
        com.google.area120.tables.v1alpha1.ListTablesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTablesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a workspace. Returns NOT_FOUND if the workspace does not exist.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.area120.tables.v1alpha1.Workspace> getWorkspace(
        com.google.area120.tables.v1alpha1.GetWorkspaceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetWorkspaceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists workspaces for the user.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.area120.tables.v1alpha1.ListWorkspacesResponse> listWorkspaces(
        com.google.area120.tables.v1alpha1.ListWorkspacesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListWorkspacesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a row. Returns NOT_FOUND if the row does not exist in the table.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.area120.tables.v1alpha1.Row> getRow(
        com.google.area120.tables.v1alpha1.GetRowRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRowMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists rows in a table. Returns NOT_FOUND if the table does not exist.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.area120.tables.v1alpha1.ListRowsResponse> listRows(
        com.google.area120.tables.v1alpha1.ListRowsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRowsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a row.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.area120.tables.v1alpha1.Row> createRow(
        com.google.area120.tables.v1alpha1.CreateRowRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateRowMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates multiple rows.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.area120.tables.v1alpha1.BatchCreateRowsResponse> batchCreateRows(
        com.google.area120.tables.v1alpha1.BatchCreateRowsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchCreateRowsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates a row.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.area120.tables.v1alpha1.Row> updateRow(
        com.google.area120.tables.v1alpha1.UpdateRowRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateRowMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates multiple rows.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.area120.tables.v1alpha1.BatchUpdateRowsResponse> batchUpdateRows(
        com.google.area120.tables.v1alpha1.BatchUpdateRowsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchUpdateRowsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a row.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteRow(
        com.google.area120.tables.v1alpha1.DeleteRowRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteRowMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes multiple rows.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> batchDeleteRows(
        com.google.area120.tables.v1alpha1.BatchDeleteRowsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchDeleteRowsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_TABLE = 0;
  private static final int METHODID_LIST_TABLES = 1;
  private static final int METHODID_GET_WORKSPACE = 2;
  private static final int METHODID_LIST_WORKSPACES = 3;
  private static final int METHODID_GET_ROW = 4;
  private static final int METHODID_LIST_ROWS = 5;
  private static final int METHODID_CREATE_ROW = 6;
  private static final int METHODID_BATCH_CREATE_ROWS = 7;
  private static final int METHODID_UPDATE_ROW = 8;
  private static final int METHODID_BATCH_UPDATE_ROWS = 9;
  private static final int METHODID_DELETE_ROW = 10;
  private static final int METHODID_BATCH_DELETE_ROWS = 11;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TablesServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TablesServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_TABLE:
          serviceImpl.getTable((com.google.area120.tables.v1alpha1.GetTableRequest) request,
              (io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.Table>) responseObserver);
          break;
        case METHODID_LIST_TABLES:
          serviceImpl.listTables((com.google.area120.tables.v1alpha1.ListTablesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.ListTablesResponse>) responseObserver);
          break;
        case METHODID_GET_WORKSPACE:
          serviceImpl.getWorkspace((com.google.area120.tables.v1alpha1.GetWorkspaceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.Workspace>) responseObserver);
          break;
        case METHODID_LIST_WORKSPACES:
          serviceImpl.listWorkspaces((com.google.area120.tables.v1alpha1.ListWorkspacesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.ListWorkspacesResponse>) responseObserver);
          break;
        case METHODID_GET_ROW:
          serviceImpl.getRow((com.google.area120.tables.v1alpha1.GetRowRequest) request,
              (io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.Row>) responseObserver);
          break;
        case METHODID_LIST_ROWS:
          serviceImpl.listRows((com.google.area120.tables.v1alpha1.ListRowsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.ListRowsResponse>) responseObserver);
          break;
        case METHODID_CREATE_ROW:
          serviceImpl.createRow((com.google.area120.tables.v1alpha1.CreateRowRequest) request,
              (io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.Row>) responseObserver);
          break;
        case METHODID_BATCH_CREATE_ROWS:
          serviceImpl.batchCreateRows((com.google.area120.tables.v1alpha1.BatchCreateRowsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.BatchCreateRowsResponse>) responseObserver);
          break;
        case METHODID_UPDATE_ROW:
          serviceImpl.updateRow((com.google.area120.tables.v1alpha1.UpdateRowRequest) request,
              (io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.Row>) responseObserver);
          break;
        case METHODID_BATCH_UPDATE_ROWS:
          serviceImpl.batchUpdateRows((com.google.area120.tables.v1alpha1.BatchUpdateRowsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.area120.tables.v1alpha1.BatchUpdateRowsResponse>) responseObserver);
          break;
        case METHODID_DELETE_ROW:
          serviceImpl.deleteRow((com.google.area120.tables.v1alpha1.DeleteRowRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_BATCH_DELETE_ROWS:
          serviceImpl.batchDeleteRows((com.google.area120.tables.v1alpha1.BatchDeleteRowsRequest) request,
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

  private static abstract class TablesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TablesServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.area120.tables.v1alpha1.TablesProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TablesService");
    }
  }

  private static final class TablesServiceFileDescriptorSupplier
      extends TablesServiceBaseDescriptorSupplier {
    TablesServiceFileDescriptorSupplier() {}
  }

  private static final class TablesServiceMethodDescriptorSupplier
      extends TablesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TablesServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (TablesServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TablesServiceFileDescriptorSupplier())
              .addMethod(getGetTableMethod())
              .addMethod(getListTablesMethod())
              .addMethod(getGetWorkspaceMethod())
              .addMethod(getListWorkspacesMethod())
              .addMethod(getGetRowMethod())
              .addMethod(getListRowsMethod())
              .addMethod(getCreateRowMethod())
              .addMethod(getBatchCreateRowsMethod())
              .addMethod(getUpdateRowMethod())
              .addMethod(getBatchUpdateRowsMethod())
              .addMethod(getDeleteRowMethod())
              .addMethod(getBatchDeleteRowsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
