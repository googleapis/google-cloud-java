package com.google.cloud.edgenetwork.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * EdgeNetwork API provides managed, highly available cloud dynamic network
 * configuration service to the GEC customer to enable edge application and
 * network function solutions. This allows the customers to easily define and
 * configure the network setup and property to meet the workload requirement.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/edgenetwork/v1/service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class EdgeNetworkGrpc {

  private EdgeNetworkGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.edgenetwork.v1.EdgeNetwork";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.InitializeZoneRequest,
      com.google.cloud.edgenetwork.v1.InitializeZoneResponse> getInitializeZoneMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "InitializeZone",
      requestType = com.google.cloud.edgenetwork.v1.InitializeZoneRequest.class,
      responseType = com.google.cloud.edgenetwork.v1.InitializeZoneResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.InitializeZoneRequest,
      com.google.cloud.edgenetwork.v1.InitializeZoneResponse> getInitializeZoneMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.InitializeZoneRequest, com.google.cloud.edgenetwork.v1.InitializeZoneResponse> getInitializeZoneMethod;
    if ((getInitializeZoneMethod = EdgeNetworkGrpc.getInitializeZoneMethod) == null) {
      synchronized (EdgeNetworkGrpc.class) {
        if ((getInitializeZoneMethod = EdgeNetworkGrpc.getInitializeZoneMethod) == null) {
          EdgeNetworkGrpc.getInitializeZoneMethod = getInitializeZoneMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.edgenetwork.v1.InitializeZoneRequest, com.google.cloud.edgenetwork.v1.InitializeZoneResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "InitializeZone"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgenetwork.v1.InitializeZoneRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgenetwork.v1.InitializeZoneResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EdgeNetworkMethodDescriptorSupplier("InitializeZone"))
              .build();
        }
      }
    }
    return getInitializeZoneMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.ListZonesRequest,
      com.google.cloud.edgenetwork.v1.ListZonesResponse> getListZonesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListZones",
      requestType = com.google.cloud.edgenetwork.v1.ListZonesRequest.class,
      responseType = com.google.cloud.edgenetwork.v1.ListZonesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.ListZonesRequest,
      com.google.cloud.edgenetwork.v1.ListZonesResponse> getListZonesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.ListZonesRequest, com.google.cloud.edgenetwork.v1.ListZonesResponse> getListZonesMethod;
    if ((getListZonesMethod = EdgeNetworkGrpc.getListZonesMethod) == null) {
      synchronized (EdgeNetworkGrpc.class) {
        if ((getListZonesMethod = EdgeNetworkGrpc.getListZonesMethod) == null) {
          EdgeNetworkGrpc.getListZonesMethod = getListZonesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.edgenetwork.v1.ListZonesRequest, com.google.cloud.edgenetwork.v1.ListZonesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListZones"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgenetwork.v1.ListZonesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgenetwork.v1.ListZonesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EdgeNetworkMethodDescriptorSupplier("ListZones"))
              .build();
        }
      }
    }
    return getListZonesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.GetZoneRequest,
      com.google.cloud.edgenetwork.v1.Zone> getGetZoneMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetZone",
      requestType = com.google.cloud.edgenetwork.v1.GetZoneRequest.class,
      responseType = com.google.cloud.edgenetwork.v1.Zone.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.GetZoneRequest,
      com.google.cloud.edgenetwork.v1.Zone> getGetZoneMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.GetZoneRequest, com.google.cloud.edgenetwork.v1.Zone> getGetZoneMethod;
    if ((getGetZoneMethod = EdgeNetworkGrpc.getGetZoneMethod) == null) {
      synchronized (EdgeNetworkGrpc.class) {
        if ((getGetZoneMethod = EdgeNetworkGrpc.getGetZoneMethod) == null) {
          EdgeNetworkGrpc.getGetZoneMethod = getGetZoneMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.edgenetwork.v1.GetZoneRequest, com.google.cloud.edgenetwork.v1.Zone>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetZone"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgenetwork.v1.GetZoneRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgenetwork.v1.Zone.getDefaultInstance()))
              .setSchemaDescriptor(new EdgeNetworkMethodDescriptorSupplier("GetZone"))
              .build();
        }
      }
    }
    return getGetZoneMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.ListNetworksRequest,
      com.google.cloud.edgenetwork.v1.ListNetworksResponse> getListNetworksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListNetworks",
      requestType = com.google.cloud.edgenetwork.v1.ListNetworksRequest.class,
      responseType = com.google.cloud.edgenetwork.v1.ListNetworksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.ListNetworksRequest,
      com.google.cloud.edgenetwork.v1.ListNetworksResponse> getListNetworksMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.ListNetworksRequest, com.google.cloud.edgenetwork.v1.ListNetworksResponse> getListNetworksMethod;
    if ((getListNetworksMethod = EdgeNetworkGrpc.getListNetworksMethod) == null) {
      synchronized (EdgeNetworkGrpc.class) {
        if ((getListNetworksMethod = EdgeNetworkGrpc.getListNetworksMethod) == null) {
          EdgeNetworkGrpc.getListNetworksMethod = getListNetworksMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.edgenetwork.v1.ListNetworksRequest, com.google.cloud.edgenetwork.v1.ListNetworksResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListNetworks"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgenetwork.v1.ListNetworksRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgenetwork.v1.ListNetworksResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EdgeNetworkMethodDescriptorSupplier("ListNetworks"))
              .build();
        }
      }
    }
    return getListNetworksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.GetNetworkRequest,
      com.google.cloud.edgenetwork.v1.Network> getGetNetworkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetNetwork",
      requestType = com.google.cloud.edgenetwork.v1.GetNetworkRequest.class,
      responseType = com.google.cloud.edgenetwork.v1.Network.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.GetNetworkRequest,
      com.google.cloud.edgenetwork.v1.Network> getGetNetworkMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.GetNetworkRequest, com.google.cloud.edgenetwork.v1.Network> getGetNetworkMethod;
    if ((getGetNetworkMethod = EdgeNetworkGrpc.getGetNetworkMethod) == null) {
      synchronized (EdgeNetworkGrpc.class) {
        if ((getGetNetworkMethod = EdgeNetworkGrpc.getGetNetworkMethod) == null) {
          EdgeNetworkGrpc.getGetNetworkMethod = getGetNetworkMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.edgenetwork.v1.GetNetworkRequest, com.google.cloud.edgenetwork.v1.Network>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetNetwork"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgenetwork.v1.GetNetworkRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgenetwork.v1.Network.getDefaultInstance()))
              .setSchemaDescriptor(new EdgeNetworkMethodDescriptorSupplier("GetNetwork"))
              .build();
        }
      }
    }
    return getGetNetworkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.DiagnoseNetworkRequest,
      com.google.cloud.edgenetwork.v1.DiagnoseNetworkResponse> getDiagnoseNetworkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DiagnoseNetwork",
      requestType = com.google.cloud.edgenetwork.v1.DiagnoseNetworkRequest.class,
      responseType = com.google.cloud.edgenetwork.v1.DiagnoseNetworkResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.DiagnoseNetworkRequest,
      com.google.cloud.edgenetwork.v1.DiagnoseNetworkResponse> getDiagnoseNetworkMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.DiagnoseNetworkRequest, com.google.cloud.edgenetwork.v1.DiagnoseNetworkResponse> getDiagnoseNetworkMethod;
    if ((getDiagnoseNetworkMethod = EdgeNetworkGrpc.getDiagnoseNetworkMethod) == null) {
      synchronized (EdgeNetworkGrpc.class) {
        if ((getDiagnoseNetworkMethod = EdgeNetworkGrpc.getDiagnoseNetworkMethod) == null) {
          EdgeNetworkGrpc.getDiagnoseNetworkMethod = getDiagnoseNetworkMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.edgenetwork.v1.DiagnoseNetworkRequest, com.google.cloud.edgenetwork.v1.DiagnoseNetworkResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DiagnoseNetwork"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgenetwork.v1.DiagnoseNetworkRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgenetwork.v1.DiagnoseNetworkResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EdgeNetworkMethodDescriptorSupplier("DiagnoseNetwork"))
              .build();
        }
      }
    }
    return getDiagnoseNetworkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.CreateNetworkRequest,
      com.google.longrunning.Operation> getCreateNetworkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateNetwork",
      requestType = com.google.cloud.edgenetwork.v1.CreateNetworkRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.CreateNetworkRequest,
      com.google.longrunning.Operation> getCreateNetworkMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.CreateNetworkRequest, com.google.longrunning.Operation> getCreateNetworkMethod;
    if ((getCreateNetworkMethod = EdgeNetworkGrpc.getCreateNetworkMethod) == null) {
      synchronized (EdgeNetworkGrpc.class) {
        if ((getCreateNetworkMethod = EdgeNetworkGrpc.getCreateNetworkMethod) == null) {
          EdgeNetworkGrpc.getCreateNetworkMethod = getCreateNetworkMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.edgenetwork.v1.CreateNetworkRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateNetwork"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgenetwork.v1.CreateNetworkRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new EdgeNetworkMethodDescriptorSupplier("CreateNetwork"))
              .build();
        }
      }
    }
    return getCreateNetworkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.DeleteNetworkRequest,
      com.google.longrunning.Operation> getDeleteNetworkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteNetwork",
      requestType = com.google.cloud.edgenetwork.v1.DeleteNetworkRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.DeleteNetworkRequest,
      com.google.longrunning.Operation> getDeleteNetworkMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.DeleteNetworkRequest, com.google.longrunning.Operation> getDeleteNetworkMethod;
    if ((getDeleteNetworkMethod = EdgeNetworkGrpc.getDeleteNetworkMethod) == null) {
      synchronized (EdgeNetworkGrpc.class) {
        if ((getDeleteNetworkMethod = EdgeNetworkGrpc.getDeleteNetworkMethod) == null) {
          EdgeNetworkGrpc.getDeleteNetworkMethod = getDeleteNetworkMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.edgenetwork.v1.DeleteNetworkRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteNetwork"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgenetwork.v1.DeleteNetworkRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new EdgeNetworkMethodDescriptorSupplier("DeleteNetwork"))
              .build();
        }
      }
    }
    return getDeleteNetworkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.ListSubnetsRequest,
      com.google.cloud.edgenetwork.v1.ListSubnetsResponse> getListSubnetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSubnets",
      requestType = com.google.cloud.edgenetwork.v1.ListSubnetsRequest.class,
      responseType = com.google.cloud.edgenetwork.v1.ListSubnetsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.ListSubnetsRequest,
      com.google.cloud.edgenetwork.v1.ListSubnetsResponse> getListSubnetsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.ListSubnetsRequest, com.google.cloud.edgenetwork.v1.ListSubnetsResponse> getListSubnetsMethod;
    if ((getListSubnetsMethod = EdgeNetworkGrpc.getListSubnetsMethod) == null) {
      synchronized (EdgeNetworkGrpc.class) {
        if ((getListSubnetsMethod = EdgeNetworkGrpc.getListSubnetsMethod) == null) {
          EdgeNetworkGrpc.getListSubnetsMethod = getListSubnetsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.edgenetwork.v1.ListSubnetsRequest, com.google.cloud.edgenetwork.v1.ListSubnetsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSubnets"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgenetwork.v1.ListSubnetsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgenetwork.v1.ListSubnetsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EdgeNetworkMethodDescriptorSupplier("ListSubnets"))
              .build();
        }
      }
    }
    return getListSubnetsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.GetSubnetRequest,
      com.google.cloud.edgenetwork.v1.Subnet> getGetSubnetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSubnet",
      requestType = com.google.cloud.edgenetwork.v1.GetSubnetRequest.class,
      responseType = com.google.cloud.edgenetwork.v1.Subnet.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.GetSubnetRequest,
      com.google.cloud.edgenetwork.v1.Subnet> getGetSubnetMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.GetSubnetRequest, com.google.cloud.edgenetwork.v1.Subnet> getGetSubnetMethod;
    if ((getGetSubnetMethod = EdgeNetworkGrpc.getGetSubnetMethod) == null) {
      synchronized (EdgeNetworkGrpc.class) {
        if ((getGetSubnetMethod = EdgeNetworkGrpc.getGetSubnetMethod) == null) {
          EdgeNetworkGrpc.getGetSubnetMethod = getGetSubnetMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.edgenetwork.v1.GetSubnetRequest, com.google.cloud.edgenetwork.v1.Subnet>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSubnet"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgenetwork.v1.GetSubnetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgenetwork.v1.Subnet.getDefaultInstance()))
              .setSchemaDescriptor(new EdgeNetworkMethodDescriptorSupplier("GetSubnet"))
              .build();
        }
      }
    }
    return getGetSubnetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.CreateSubnetRequest,
      com.google.longrunning.Operation> getCreateSubnetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSubnet",
      requestType = com.google.cloud.edgenetwork.v1.CreateSubnetRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.CreateSubnetRequest,
      com.google.longrunning.Operation> getCreateSubnetMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.CreateSubnetRequest, com.google.longrunning.Operation> getCreateSubnetMethod;
    if ((getCreateSubnetMethod = EdgeNetworkGrpc.getCreateSubnetMethod) == null) {
      synchronized (EdgeNetworkGrpc.class) {
        if ((getCreateSubnetMethod = EdgeNetworkGrpc.getCreateSubnetMethod) == null) {
          EdgeNetworkGrpc.getCreateSubnetMethod = getCreateSubnetMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.edgenetwork.v1.CreateSubnetRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSubnet"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgenetwork.v1.CreateSubnetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new EdgeNetworkMethodDescriptorSupplier("CreateSubnet"))
              .build();
        }
      }
    }
    return getCreateSubnetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.UpdateSubnetRequest,
      com.google.longrunning.Operation> getUpdateSubnetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSubnet",
      requestType = com.google.cloud.edgenetwork.v1.UpdateSubnetRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.UpdateSubnetRequest,
      com.google.longrunning.Operation> getUpdateSubnetMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.UpdateSubnetRequest, com.google.longrunning.Operation> getUpdateSubnetMethod;
    if ((getUpdateSubnetMethod = EdgeNetworkGrpc.getUpdateSubnetMethod) == null) {
      synchronized (EdgeNetworkGrpc.class) {
        if ((getUpdateSubnetMethod = EdgeNetworkGrpc.getUpdateSubnetMethod) == null) {
          EdgeNetworkGrpc.getUpdateSubnetMethod = getUpdateSubnetMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.edgenetwork.v1.UpdateSubnetRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateSubnet"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgenetwork.v1.UpdateSubnetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new EdgeNetworkMethodDescriptorSupplier("UpdateSubnet"))
              .build();
        }
      }
    }
    return getUpdateSubnetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.DeleteSubnetRequest,
      com.google.longrunning.Operation> getDeleteSubnetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSubnet",
      requestType = com.google.cloud.edgenetwork.v1.DeleteSubnetRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.DeleteSubnetRequest,
      com.google.longrunning.Operation> getDeleteSubnetMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.DeleteSubnetRequest, com.google.longrunning.Operation> getDeleteSubnetMethod;
    if ((getDeleteSubnetMethod = EdgeNetworkGrpc.getDeleteSubnetMethod) == null) {
      synchronized (EdgeNetworkGrpc.class) {
        if ((getDeleteSubnetMethod = EdgeNetworkGrpc.getDeleteSubnetMethod) == null) {
          EdgeNetworkGrpc.getDeleteSubnetMethod = getDeleteSubnetMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.edgenetwork.v1.DeleteSubnetRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteSubnet"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgenetwork.v1.DeleteSubnetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new EdgeNetworkMethodDescriptorSupplier("DeleteSubnet"))
              .build();
        }
      }
    }
    return getDeleteSubnetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.ListInterconnectsRequest,
      com.google.cloud.edgenetwork.v1.ListInterconnectsResponse> getListInterconnectsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListInterconnects",
      requestType = com.google.cloud.edgenetwork.v1.ListInterconnectsRequest.class,
      responseType = com.google.cloud.edgenetwork.v1.ListInterconnectsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.ListInterconnectsRequest,
      com.google.cloud.edgenetwork.v1.ListInterconnectsResponse> getListInterconnectsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.ListInterconnectsRequest, com.google.cloud.edgenetwork.v1.ListInterconnectsResponse> getListInterconnectsMethod;
    if ((getListInterconnectsMethod = EdgeNetworkGrpc.getListInterconnectsMethod) == null) {
      synchronized (EdgeNetworkGrpc.class) {
        if ((getListInterconnectsMethod = EdgeNetworkGrpc.getListInterconnectsMethod) == null) {
          EdgeNetworkGrpc.getListInterconnectsMethod = getListInterconnectsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.edgenetwork.v1.ListInterconnectsRequest, com.google.cloud.edgenetwork.v1.ListInterconnectsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListInterconnects"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgenetwork.v1.ListInterconnectsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgenetwork.v1.ListInterconnectsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EdgeNetworkMethodDescriptorSupplier("ListInterconnects"))
              .build();
        }
      }
    }
    return getListInterconnectsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.GetInterconnectRequest,
      com.google.cloud.edgenetwork.v1.Interconnect> getGetInterconnectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetInterconnect",
      requestType = com.google.cloud.edgenetwork.v1.GetInterconnectRequest.class,
      responseType = com.google.cloud.edgenetwork.v1.Interconnect.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.GetInterconnectRequest,
      com.google.cloud.edgenetwork.v1.Interconnect> getGetInterconnectMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.GetInterconnectRequest, com.google.cloud.edgenetwork.v1.Interconnect> getGetInterconnectMethod;
    if ((getGetInterconnectMethod = EdgeNetworkGrpc.getGetInterconnectMethod) == null) {
      synchronized (EdgeNetworkGrpc.class) {
        if ((getGetInterconnectMethod = EdgeNetworkGrpc.getGetInterconnectMethod) == null) {
          EdgeNetworkGrpc.getGetInterconnectMethod = getGetInterconnectMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.edgenetwork.v1.GetInterconnectRequest, com.google.cloud.edgenetwork.v1.Interconnect>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetInterconnect"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgenetwork.v1.GetInterconnectRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgenetwork.v1.Interconnect.getDefaultInstance()))
              .setSchemaDescriptor(new EdgeNetworkMethodDescriptorSupplier("GetInterconnect"))
              .build();
        }
      }
    }
    return getGetInterconnectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.DiagnoseInterconnectRequest,
      com.google.cloud.edgenetwork.v1.DiagnoseInterconnectResponse> getDiagnoseInterconnectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DiagnoseInterconnect",
      requestType = com.google.cloud.edgenetwork.v1.DiagnoseInterconnectRequest.class,
      responseType = com.google.cloud.edgenetwork.v1.DiagnoseInterconnectResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.DiagnoseInterconnectRequest,
      com.google.cloud.edgenetwork.v1.DiagnoseInterconnectResponse> getDiagnoseInterconnectMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.DiagnoseInterconnectRequest, com.google.cloud.edgenetwork.v1.DiagnoseInterconnectResponse> getDiagnoseInterconnectMethod;
    if ((getDiagnoseInterconnectMethod = EdgeNetworkGrpc.getDiagnoseInterconnectMethod) == null) {
      synchronized (EdgeNetworkGrpc.class) {
        if ((getDiagnoseInterconnectMethod = EdgeNetworkGrpc.getDiagnoseInterconnectMethod) == null) {
          EdgeNetworkGrpc.getDiagnoseInterconnectMethod = getDiagnoseInterconnectMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.edgenetwork.v1.DiagnoseInterconnectRequest, com.google.cloud.edgenetwork.v1.DiagnoseInterconnectResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DiagnoseInterconnect"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgenetwork.v1.DiagnoseInterconnectRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgenetwork.v1.DiagnoseInterconnectResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EdgeNetworkMethodDescriptorSupplier("DiagnoseInterconnect"))
              .build();
        }
      }
    }
    return getDiagnoseInterconnectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.ListInterconnectAttachmentsRequest,
      com.google.cloud.edgenetwork.v1.ListInterconnectAttachmentsResponse> getListInterconnectAttachmentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListInterconnectAttachments",
      requestType = com.google.cloud.edgenetwork.v1.ListInterconnectAttachmentsRequest.class,
      responseType = com.google.cloud.edgenetwork.v1.ListInterconnectAttachmentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.ListInterconnectAttachmentsRequest,
      com.google.cloud.edgenetwork.v1.ListInterconnectAttachmentsResponse> getListInterconnectAttachmentsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.ListInterconnectAttachmentsRequest, com.google.cloud.edgenetwork.v1.ListInterconnectAttachmentsResponse> getListInterconnectAttachmentsMethod;
    if ((getListInterconnectAttachmentsMethod = EdgeNetworkGrpc.getListInterconnectAttachmentsMethod) == null) {
      synchronized (EdgeNetworkGrpc.class) {
        if ((getListInterconnectAttachmentsMethod = EdgeNetworkGrpc.getListInterconnectAttachmentsMethod) == null) {
          EdgeNetworkGrpc.getListInterconnectAttachmentsMethod = getListInterconnectAttachmentsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.edgenetwork.v1.ListInterconnectAttachmentsRequest, com.google.cloud.edgenetwork.v1.ListInterconnectAttachmentsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListInterconnectAttachments"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgenetwork.v1.ListInterconnectAttachmentsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgenetwork.v1.ListInterconnectAttachmentsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EdgeNetworkMethodDescriptorSupplier("ListInterconnectAttachments"))
              .build();
        }
      }
    }
    return getListInterconnectAttachmentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.GetInterconnectAttachmentRequest,
      com.google.cloud.edgenetwork.v1.InterconnectAttachment> getGetInterconnectAttachmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetInterconnectAttachment",
      requestType = com.google.cloud.edgenetwork.v1.GetInterconnectAttachmentRequest.class,
      responseType = com.google.cloud.edgenetwork.v1.InterconnectAttachment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.GetInterconnectAttachmentRequest,
      com.google.cloud.edgenetwork.v1.InterconnectAttachment> getGetInterconnectAttachmentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.GetInterconnectAttachmentRequest, com.google.cloud.edgenetwork.v1.InterconnectAttachment> getGetInterconnectAttachmentMethod;
    if ((getGetInterconnectAttachmentMethod = EdgeNetworkGrpc.getGetInterconnectAttachmentMethod) == null) {
      synchronized (EdgeNetworkGrpc.class) {
        if ((getGetInterconnectAttachmentMethod = EdgeNetworkGrpc.getGetInterconnectAttachmentMethod) == null) {
          EdgeNetworkGrpc.getGetInterconnectAttachmentMethod = getGetInterconnectAttachmentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.edgenetwork.v1.GetInterconnectAttachmentRequest, com.google.cloud.edgenetwork.v1.InterconnectAttachment>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetInterconnectAttachment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgenetwork.v1.GetInterconnectAttachmentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgenetwork.v1.InterconnectAttachment.getDefaultInstance()))
              .setSchemaDescriptor(new EdgeNetworkMethodDescriptorSupplier("GetInterconnectAttachment"))
              .build();
        }
      }
    }
    return getGetInterconnectAttachmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.CreateInterconnectAttachmentRequest,
      com.google.longrunning.Operation> getCreateInterconnectAttachmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateInterconnectAttachment",
      requestType = com.google.cloud.edgenetwork.v1.CreateInterconnectAttachmentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.CreateInterconnectAttachmentRequest,
      com.google.longrunning.Operation> getCreateInterconnectAttachmentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.CreateInterconnectAttachmentRequest, com.google.longrunning.Operation> getCreateInterconnectAttachmentMethod;
    if ((getCreateInterconnectAttachmentMethod = EdgeNetworkGrpc.getCreateInterconnectAttachmentMethod) == null) {
      synchronized (EdgeNetworkGrpc.class) {
        if ((getCreateInterconnectAttachmentMethod = EdgeNetworkGrpc.getCreateInterconnectAttachmentMethod) == null) {
          EdgeNetworkGrpc.getCreateInterconnectAttachmentMethod = getCreateInterconnectAttachmentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.edgenetwork.v1.CreateInterconnectAttachmentRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateInterconnectAttachment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgenetwork.v1.CreateInterconnectAttachmentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new EdgeNetworkMethodDescriptorSupplier("CreateInterconnectAttachment"))
              .build();
        }
      }
    }
    return getCreateInterconnectAttachmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.DeleteInterconnectAttachmentRequest,
      com.google.longrunning.Operation> getDeleteInterconnectAttachmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteInterconnectAttachment",
      requestType = com.google.cloud.edgenetwork.v1.DeleteInterconnectAttachmentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.DeleteInterconnectAttachmentRequest,
      com.google.longrunning.Operation> getDeleteInterconnectAttachmentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.DeleteInterconnectAttachmentRequest, com.google.longrunning.Operation> getDeleteInterconnectAttachmentMethod;
    if ((getDeleteInterconnectAttachmentMethod = EdgeNetworkGrpc.getDeleteInterconnectAttachmentMethod) == null) {
      synchronized (EdgeNetworkGrpc.class) {
        if ((getDeleteInterconnectAttachmentMethod = EdgeNetworkGrpc.getDeleteInterconnectAttachmentMethod) == null) {
          EdgeNetworkGrpc.getDeleteInterconnectAttachmentMethod = getDeleteInterconnectAttachmentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.edgenetwork.v1.DeleteInterconnectAttachmentRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteInterconnectAttachment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgenetwork.v1.DeleteInterconnectAttachmentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new EdgeNetworkMethodDescriptorSupplier("DeleteInterconnectAttachment"))
              .build();
        }
      }
    }
    return getDeleteInterconnectAttachmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.ListRoutersRequest,
      com.google.cloud.edgenetwork.v1.ListRoutersResponse> getListRoutersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRouters",
      requestType = com.google.cloud.edgenetwork.v1.ListRoutersRequest.class,
      responseType = com.google.cloud.edgenetwork.v1.ListRoutersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.ListRoutersRequest,
      com.google.cloud.edgenetwork.v1.ListRoutersResponse> getListRoutersMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.ListRoutersRequest, com.google.cloud.edgenetwork.v1.ListRoutersResponse> getListRoutersMethod;
    if ((getListRoutersMethod = EdgeNetworkGrpc.getListRoutersMethod) == null) {
      synchronized (EdgeNetworkGrpc.class) {
        if ((getListRoutersMethod = EdgeNetworkGrpc.getListRoutersMethod) == null) {
          EdgeNetworkGrpc.getListRoutersMethod = getListRoutersMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.edgenetwork.v1.ListRoutersRequest, com.google.cloud.edgenetwork.v1.ListRoutersResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListRouters"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgenetwork.v1.ListRoutersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgenetwork.v1.ListRoutersResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EdgeNetworkMethodDescriptorSupplier("ListRouters"))
              .build();
        }
      }
    }
    return getListRoutersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.GetRouterRequest,
      com.google.cloud.edgenetwork.v1.Router> getGetRouterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRouter",
      requestType = com.google.cloud.edgenetwork.v1.GetRouterRequest.class,
      responseType = com.google.cloud.edgenetwork.v1.Router.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.GetRouterRequest,
      com.google.cloud.edgenetwork.v1.Router> getGetRouterMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.GetRouterRequest, com.google.cloud.edgenetwork.v1.Router> getGetRouterMethod;
    if ((getGetRouterMethod = EdgeNetworkGrpc.getGetRouterMethod) == null) {
      synchronized (EdgeNetworkGrpc.class) {
        if ((getGetRouterMethod = EdgeNetworkGrpc.getGetRouterMethod) == null) {
          EdgeNetworkGrpc.getGetRouterMethod = getGetRouterMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.edgenetwork.v1.GetRouterRequest, com.google.cloud.edgenetwork.v1.Router>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRouter"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgenetwork.v1.GetRouterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgenetwork.v1.Router.getDefaultInstance()))
              .setSchemaDescriptor(new EdgeNetworkMethodDescriptorSupplier("GetRouter"))
              .build();
        }
      }
    }
    return getGetRouterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.DiagnoseRouterRequest,
      com.google.cloud.edgenetwork.v1.DiagnoseRouterResponse> getDiagnoseRouterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DiagnoseRouter",
      requestType = com.google.cloud.edgenetwork.v1.DiagnoseRouterRequest.class,
      responseType = com.google.cloud.edgenetwork.v1.DiagnoseRouterResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.DiagnoseRouterRequest,
      com.google.cloud.edgenetwork.v1.DiagnoseRouterResponse> getDiagnoseRouterMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.DiagnoseRouterRequest, com.google.cloud.edgenetwork.v1.DiagnoseRouterResponse> getDiagnoseRouterMethod;
    if ((getDiagnoseRouterMethod = EdgeNetworkGrpc.getDiagnoseRouterMethod) == null) {
      synchronized (EdgeNetworkGrpc.class) {
        if ((getDiagnoseRouterMethod = EdgeNetworkGrpc.getDiagnoseRouterMethod) == null) {
          EdgeNetworkGrpc.getDiagnoseRouterMethod = getDiagnoseRouterMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.edgenetwork.v1.DiagnoseRouterRequest, com.google.cloud.edgenetwork.v1.DiagnoseRouterResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DiagnoseRouter"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgenetwork.v1.DiagnoseRouterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgenetwork.v1.DiagnoseRouterResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EdgeNetworkMethodDescriptorSupplier("DiagnoseRouter"))
              .build();
        }
      }
    }
    return getDiagnoseRouterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.CreateRouterRequest,
      com.google.longrunning.Operation> getCreateRouterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRouter",
      requestType = com.google.cloud.edgenetwork.v1.CreateRouterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.CreateRouterRequest,
      com.google.longrunning.Operation> getCreateRouterMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.CreateRouterRequest, com.google.longrunning.Operation> getCreateRouterMethod;
    if ((getCreateRouterMethod = EdgeNetworkGrpc.getCreateRouterMethod) == null) {
      synchronized (EdgeNetworkGrpc.class) {
        if ((getCreateRouterMethod = EdgeNetworkGrpc.getCreateRouterMethod) == null) {
          EdgeNetworkGrpc.getCreateRouterMethod = getCreateRouterMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.edgenetwork.v1.CreateRouterRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateRouter"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgenetwork.v1.CreateRouterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new EdgeNetworkMethodDescriptorSupplier("CreateRouter"))
              .build();
        }
      }
    }
    return getCreateRouterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.UpdateRouterRequest,
      com.google.longrunning.Operation> getUpdateRouterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateRouter",
      requestType = com.google.cloud.edgenetwork.v1.UpdateRouterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.UpdateRouterRequest,
      com.google.longrunning.Operation> getUpdateRouterMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.UpdateRouterRequest, com.google.longrunning.Operation> getUpdateRouterMethod;
    if ((getUpdateRouterMethod = EdgeNetworkGrpc.getUpdateRouterMethod) == null) {
      synchronized (EdgeNetworkGrpc.class) {
        if ((getUpdateRouterMethod = EdgeNetworkGrpc.getUpdateRouterMethod) == null) {
          EdgeNetworkGrpc.getUpdateRouterMethod = getUpdateRouterMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.edgenetwork.v1.UpdateRouterRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateRouter"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgenetwork.v1.UpdateRouterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new EdgeNetworkMethodDescriptorSupplier("UpdateRouter"))
              .build();
        }
      }
    }
    return getUpdateRouterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.DeleteRouterRequest,
      com.google.longrunning.Operation> getDeleteRouterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteRouter",
      requestType = com.google.cloud.edgenetwork.v1.DeleteRouterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.DeleteRouterRequest,
      com.google.longrunning.Operation> getDeleteRouterMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.edgenetwork.v1.DeleteRouterRequest, com.google.longrunning.Operation> getDeleteRouterMethod;
    if ((getDeleteRouterMethod = EdgeNetworkGrpc.getDeleteRouterMethod) == null) {
      synchronized (EdgeNetworkGrpc.class) {
        if ((getDeleteRouterMethod = EdgeNetworkGrpc.getDeleteRouterMethod) == null) {
          EdgeNetworkGrpc.getDeleteRouterMethod = getDeleteRouterMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.edgenetwork.v1.DeleteRouterRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteRouter"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.edgenetwork.v1.DeleteRouterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new EdgeNetworkMethodDescriptorSupplier("DeleteRouter"))
              .build();
        }
      }
    }
    return getDeleteRouterMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EdgeNetworkStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EdgeNetworkStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EdgeNetworkStub>() {
        @java.lang.Override
        public EdgeNetworkStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EdgeNetworkStub(channel, callOptions);
        }
      };
    return EdgeNetworkStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EdgeNetworkBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EdgeNetworkBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EdgeNetworkBlockingStub>() {
        @java.lang.Override
        public EdgeNetworkBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EdgeNetworkBlockingStub(channel, callOptions);
        }
      };
    return EdgeNetworkBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EdgeNetworkFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EdgeNetworkFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EdgeNetworkFutureStub>() {
        @java.lang.Override
        public EdgeNetworkFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EdgeNetworkFutureStub(channel, callOptions);
        }
      };
    return EdgeNetworkFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * EdgeNetwork API provides managed, highly available cloud dynamic network
   * configuration service to the GEC customer to enable edge application and
   * network function solutions. This allows the customers to easily define and
   * configure the network setup and property to meet the workload requirement.
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * InitializeZone will initialize resources for a zone in a project.
     * </pre>
     */
    default void initializeZone(com.google.cloud.edgenetwork.v1.InitializeZoneRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgenetwork.v1.InitializeZoneResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getInitializeZoneMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists Zones in a given project and location.
     * </pre>
     */
    default void listZones(com.google.cloud.edgenetwork.v1.ListZonesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgenetwork.v1.ListZonesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListZonesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single Zone.
     * </pre>
     */
    default void getZone(com.google.cloud.edgenetwork.v1.GetZoneRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgenetwork.v1.Zone> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetZoneMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists Networks in a given project and location.
     * </pre>
     */
    default void listNetworks(com.google.cloud.edgenetwork.v1.ListNetworksRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgenetwork.v1.ListNetworksResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListNetworksMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single Network.
     * </pre>
     */
    default void getNetwork(com.google.cloud.edgenetwork.v1.GetNetworkRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgenetwork.v1.Network> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetNetworkMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get the diagnostics of a single network resource.
     * </pre>
     */
    default void diagnoseNetwork(com.google.cloud.edgenetwork.v1.DiagnoseNetworkRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgenetwork.v1.DiagnoseNetworkResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDiagnoseNetworkMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new Network in a given project and location.
     * </pre>
     */
    default void createNetwork(com.google.cloud.edgenetwork.v1.CreateNetworkRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateNetworkMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a single Network.
     * </pre>
     */
    default void deleteNetwork(com.google.cloud.edgenetwork.v1.DeleteNetworkRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteNetworkMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists Subnets in a given project and location.
     * </pre>
     */
    default void listSubnets(com.google.cloud.edgenetwork.v1.ListSubnetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgenetwork.v1.ListSubnetsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListSubnetsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single Subnet.
     * </pre>
     */
    default void getSubnet(com.google.cloud.edgenetwork.v1.GetSubnetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgenetwork.v1.Subnet> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSubnetMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new Subnet in a given project and location.
     * </pre>
     */
    default void createSubnet(com.google.cloud.edgenetwork.v1.CreateSubnetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateSubnetMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates the parameters of a single Subnet.
     * </pre>
     */
    default void updateSubnet(com.google.cloud.edgenetwork.v1.UpdateSubnetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateSubnetMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a single Subnet.
     * </pre>
     */
    default void deleteSubnet(com.google.cloud.edgenetwork.v1.DeleteSubnetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteSubnetMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists Interconnects in a given project and location.
     * </pre>
     */
    default void listInterconnects(com.google.cloud.edgenetwork.v1.ListInterconnectsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgenetwork.v1.ListInterconnectsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListInterconnectsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single Interconnect.
     * </pre>
     */
    default void getInterconnect(com.google.cloud.edgenetwork.v1.GetInterconnectRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgenetwork.v1.Interconnect> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetInterconnectMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get the diagnostics of a single interconnect resource.
     * </pre>
     */
    default void diagnoseInterconnect(com.google.cloud.edgenetwork.v1.DiagnoseInterconnectRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgenetwork.v1.DiagnoseInterconnectResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDiagnoseInterconnectMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists InterconnectAttachments in a given project and location.
     * </pre>
     */
    default void listInterconnectAttachments(com.google.cloud.edgenetwork.v1.ListInterconnectAttachmentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgenetwork.v1.ListInterconnectAttachmentsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListInterconnectAttachmentsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single InterconnectAttachment.
     * </pre>
     */
    default void getInterconnectAttachment(com.google.cloud.edgenetwork.v1.GetInterconnectAttachmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgenetwork.v1.InterconnectAttachment> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetInterconnectAttachmentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new InterconnectAttachment in a given project and location.
     * </pre>
     */
    default void createInterconnectAttachment(com.google.cloud.edgenetwork.v1.CreateInterconnectAttachmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateInterconnectAttachmentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a single InterconnectAttachment.
     * </pre>
     */
    default void deleteInterconnectAttachment(com.google.cloud.edgenetwork.v1.DeleteInterconnectAttachmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteInterconnectAttachmentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists Routers in a given project and location.
     * </pre>
     */
    default void listRouters(com.google.cloud.edgenetwork.v1.ListRoutersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgenetwork.v1.ListRoutersResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListRoutersMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single Router.
     * </pre>
     */
    default void getRouter(com.google.cloud.edgenetwork.v1.GetRouterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgenetwork.v1.Router> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetRouterMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get the diagnostics of a single router resource.
     * </pre>
     */
    default void diagnoseRouter(com.google.cloud.edgenetwork.v1.DiagnoseRouterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgenetwork.v1.DiagnoseRouterResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDiagnoseRouterMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new Router in a given project and location.
     * </pre>
     */
    default void createRouter(com.google.cloud.edgenetwork.v1.CreateRouterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateRouterMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates the parameters of a single Router.
     * </pre>
     */
    default void updateRouter(com.google.cloud.edgenetwork.v1.UpdateRouterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateRouterMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a single Router.
     * </pre>
     */
    default void deleteRouter(com.google.cloud.edgenetwork.v1.DeleteRouterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteRouterMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service EdgeNetwork.
   * <pre>
   * EdgeNetwork API provides managed, highly available cloud dynamic network
   * configuration service to the GEC customer to enable edge application and
   * network function solutions. This allows the customers to easily define and
   * configure the network setup and property to meet the workload requirement.
   * </pre>
   */
  public static abstract class EdgeNetworkImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return EdgeNetworkGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service EdgeNetwork.
   * <pre>
   * EdgeNetwork API provides managed, highly available cloud dynamic network
   * configuration service to the GEC customer to enable edge application and
   * network function solutions. This allows the customers to easily define and
   * configure the network setup and property to meet the workload requirement.
   * </pre>
   */
  public static final class EdgeNetworkStub
      extends io.grpc.stub.AbstractAsyncStub<EdgeNetworkStub> {
    private EdgeNetworkStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EdgeNetworkStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EdgeNetworkStub(channel, callOptions);
    }

    /**
     * <pre>
     * InitializeZone will initialize resources for a zone in a project.
     * </pre>
     */
    public void initializeZone(com.google.cloud.edgenetwork.v1.InitializeZoneRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgenetwork.v1.InitializeZoneResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInitializeZoneMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists Zones in a given project and location.
     * </pre>
     */
    public void listZones(com.google.cloud.edgenetwork.v1.ListZonesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgenetwork.v1.ListZonesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListZonesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single Zone.
     * </pre>
     */
    public void getZone(com.google.cloud.edgenetwork.v1.GetZoneRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgenetwork.v1.Zone> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetZoneMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists Networks in a given project and location.
     * </pre>
     */
    public void listNetworks(com.google.cloud.edgenetwork.v1.ListNetworksRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgenetwork.v1.ListNetworksResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListNetworksMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single Network.
     * </pre>
     */
    public void getNetwork(com.google.cloud.edgenetwork.v1.GetNetworkRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgenetwork.v1.Network> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetNetworkMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get the diagnostics of a single network resource.
     * </pre>
     */
    public void diagnoseNetwork(com.google.cloud.edgenetwork.v1.DiagnoseNetworkRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgenetwork.v1.DiagnoseNetworkResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDiagnoseNetworkMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new Network in a given project and location.
     * </pre>
     */
    public void createNetwork(com.google.cloud.edgenetwork.v1.CreateNetworkRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateNetworkMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a single Network.
     * </pre>
     */
    public void deleteNetwork(com.google.cloud.edgenetwork.v1.DeleteNetworkRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteNetworkMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists Subnets in a given project and location.
     * </pre>
     */
    public void listSubnets(com.google.cloud.edgenetwork.v1.ListSubnetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgenetwork.v1.ListSubnetsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSubnetsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single Subnet.
     * </pre>
     */
    public void getSubnet(com.google.cloud.edgenetwork.v1.GetSubnetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgenetwork.v1.Subnet> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSubnetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new Subnet in a given project and location.
     * </pre>
     */
    public void createSubnet(com.google.cloud.edgenetwork.v1.CreateSubnetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSubnetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the parameters of a single Subnet.
     * </pre>
     */
    public void updateSubnet(com.google.cloud.edgenetwork.v1.UpdateSubnetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSubnetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a single Subnet.
     * </pre>
     */
    public void deleteSubnet(com.google.cloud.edgenetwork.v1.DeleteSubnetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSubnetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists Interconnects in a given project and location.
     * </pre>
     */
    public void listInterconnects(com.google.cloud.edgenetwork.v1.ListInterconnectsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgenetwork.v1.ListInterconnectsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListInterconnectsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single Interconnect.
     * </pre>
     */
    public void getInterconnect(com.google.cloud.edgenetwork.v1.GetInterconnectRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgenetwork.v1.Interconnect> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetInterconnectMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get the diagnostics of a single interconnect resource.
     * </pre>
     */
    public void diagnoseInterconnect(com.google.cloud.edgenetwork.v1.DiagnoseInterconnectRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgenetwork.v1.DiagnoseInterconnectResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDiagnoseInterconnectMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists InterconnectAttachments in a given project and location.
     * </pre>
     */
    public void listInterconnectAttachments(com.google.cloud.edgenetwork.v1.ListInterconnectAttachmentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgenetwork.v1.ListInterconnectAttachmentsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListInterconnectAttachmentsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single InterconnectAttachment.
     * </pre>
     */
    public void getInterconnectAttachment(com.google.cloud.edgenetwork.v1.GetInterconnectAttachmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgenetwork.v1.InterconnectAttachment> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetInterconnectAttachmentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new InterconnectAttachment in a given project and location.
     * </pre>
     */
    public void createInterconnectAttachment(com.google.cloud.edgenetwork.v1.CreateInterconnectAttachmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateInterconnectAttachmentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a single InterconnectAttachment.
     * </pre>
     */
    public void deleteInterconnectAttachment(com.google.cloud.edgenetwork.v1.DeleteInterconnectAttachmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteInterconnectAttachmentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists Routers in a given project and location.
     * </pre>
     */
    public void listRouters(com.google.cloud.edgenetwork.v1.ListRoutersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgenetwork.v1.ListRoutersResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRoutersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single Router.
     * </pre>
     */
    public void getRouter(com.google.cloud.edgenetwork.v1.GetRouterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgenetwork.v1.Router> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRouterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get the diagnostics of a single router resource.
     * </pre>
     */
    public void diagnoseRouter(com.google.cloud.edgenetwork.v1.DiagnoseRouterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.edgenetwork.v1.DiagnoseRouterResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDiagnoseRouterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new Router in a given project and location.
     * </pre>
     */
    public void createRouter(com.google.cloud.edgenetwork.v1.CreateRouterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateRouterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the parameters of a single Router.
     * </pre>
     */
    public void updateRouter(com.google.cloud.edgenetwork.v1.UpdateRouterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateRouterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a single Router.
     * </pre>
     */
    public void deleteRouter(com.google.cloud.edgenetwork.v1.DeleteRouterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteRouterMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service EdgeNetwork.
   * <pre>
   * EdgeNetwork API provides managed, highly available cloud dynamic network
   * configuration service to the GEC customer to enable edge application and
   * network function solutions. This allows the customers to easily define and
   * configure the network setup and property to meet the workload requirement.
   * </pre>
   */
  public static final class EdgeNetworkBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<EdgeNetworkBlockingStub> {
    private EdgeNetworkBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EdgeNetworkBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EdgeNetworkBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * InitializeZone will initialize resources for a zone in a project.
     * </pre>
     */
    public com.google.cloud.edgenetwork.v1.InitializeZoneResponse initializeZone(com.google.cloud.edgenetwork.v1.InitializeZoneRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInitializeZoneMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists Zones in a given project and location.
     * </pre>
     */
    public com.google.cloud.edgenetwork.v1.ListZonesResponse listZones(com.google.cloud.edgenetwork.v1.ListZonesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListZonesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets details of a single Zone.
     * </pre>
     */
    public com.google.cloud.edgenetwork.v1.Zone getZone(com.google.cloud.edgenetwork.v1.GetZoneRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetZoneMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists Networks in a given project and location.
     * </pre>
     */
    public com.google.cloud.edgenetwork.v1.ListNetworksResponse listNetworks(com.google.cloud.edgenetwork.v1.ListNetworksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListNetworksMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets details of a single Network.
     * </pre>
     */
    public com.google.cloud.edgenetwork.v1.Network getNetwork(com.google.cloud.edgenetwork.v1.GetNetworkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetNetworkMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get the diagnostics of a single network resource.
     * </pre>
     */
    public com.google.cloud.edgenetwork.v1.DiagnoseNetworkResponse diagnoseNetwork(com.google.cloud.edgenetwork.v1.DiagnoseNetworkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDiagnoseNetworkMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new Network in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createNetwork(com.google.cloud.edgenetwork.v1.CreateNetworkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateNetworkMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a single Network.
     * </pre>
     */
    public com.google.longrunning.Operation deleteNetwork(com.google.cloud.edgenetwork.v1.DeleteNetworkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteNetworkMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists Subnets in a given project and location.
     * </pre>
     */
    public com.google.cloud.edgenetwork.v1.ListSubnetsResponse listSubnets(com.google.cloud.edgenetwork.v1.ListSubnetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSubnetsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets details of a single Subnet.
     * </pre>
     */
    public com.google.cloud.edgenetwork.v1.Subnet getSubnet(com.google.cloud.edgenetwork.v1.GetSubnetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSubnetMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new Subnet in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createSubnet(com.google.cloud.edgenetwork.v1.CreateSubnetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSubnetMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the parameters of a single Subnet.
     * </pre>
     */
    public com.google.longrunning.Operation updateSubnet(com.google.cloud.edgenetwork.v1.UpdateSubnetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSubnetMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a single Subnet.
     * </pre>
     */
    public com.google.longrunning.Operation deleteSubnet(com.google.cloud.edgenetwork.v1.DeleteSubnetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSubnetMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists Interconnects in a given project and location.
     * </pre>
     */
    public com.google.cloud.edgenetwork.v1.ListInterconnectsResponse listInterconnects(com.google.cloud.edgenetwork.v1.ListInterconnectsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListInterconnectsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets details of a single Interconnect.
     * </pre>
     */
    public com.google.cloud.edgenetwork.v1.Interconnect getInterconnect(com.google.cloud.edgenetwork.v1.GetInterconnectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetInterconnectMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get the diagnostics of a single interconnect resource.
     * </pre>
     */
    public com.google.cloud.edgenetwork.v1.DiagnoseInterconnectResponse diagnoseInterconnect(com.google.cloud.edgenetwork.v1.DiagnoseInterconnectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDiagnoseInterconnectMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists InterconnectAttachments in a given project and location.
     * </pre>
     */
    public com.google.cloud.edgenetwork.v1.ListInterconnectAttachmentsResponse listInterconnectAttachments(com.google.cloud.edgenetwork.v1.ListInterconnectAttachmentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListInterconnectAttachmentsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets details of a single InterconnectAttachment.
     * </pre>
     */
    public com.google.cloud.edgenetwork.v1.InterconnectAttachment getInterconnectAttachment(com.google.cloud.edgenetwork.v1.GetInterconnectAttachmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetInterconnectAttachmentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new InterconnectAttachment in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createInterconnectAttachment(com.google.cloud.edgenetwork.v1.CreateInterconnectAttachmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateInterconnectAttachmentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a single InterconnectAttachment.
     * </pre>
     */
    public com.google.longrunning.Operation deleteInterconnectAttachment(com.google.cloud.edgenetwork.v1.DeleteInterconnectAttachmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteInterconnectAttachmentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists Routers in a given project and location.
     * </pre>
     */
    public com.google.cloud.edgenetwork.v1.ListRoutersResponse listRouters(com.google.cloud.edgenetwork.v1.ListRoutersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRoutersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets details of a single Router.
     * </pre>
     */
    public com.google.cloud.edgenetwork.v1.Router getRouter(com.google.cloud.edgenetwork.v1.GetRouterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRouterMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get the diagnostics of a single router resource.
     * </pre>
     */
    public com.google.cloud.edgenetwork.v1.DiagnoseRouterResponse diagnoseRouter(com.google.cloud.edgenetwork.v1.DiagnoseRouterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDiagnoseRouterMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new Router in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createRouter(com.google.cloud.edgenetwork.v1.CreateRouterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateRouterMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the parameters of a single Router.
     * </pre>
     */
    public com.google.longrunning.Operation updateRouter(com.google.cloud.edgenetwork.v1.UpdateRouterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateRouterMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a single Router.
     * </pre>
     */
    public com.google.longrunning.Operation deleteRouter(com.google.cloud.edgenetwork.v1.DeleteRouterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteRouterMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service EdgeNetwork.
   * <pre>
   * EdgeNetwork API provides managed, highly available cloud dynamic network
   * configuration service to the GEC customer to enable edge application and
   * network function solutions. This allows the customers to easily define and
   * configure the network setup and property to meet the workload requirement.
   * </pre>
   */
  public static final class EdgeNetworkFutureStub
      extends io.grpc.stub.AbstractFutureStub<EdgeNetworkFutureStub> {
    private EdgeNetworkFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EdgeNetworkFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EdgeNetworkFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * InitializeZone will initialize resources for a zone in a project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.edgenetwork.v1.InitializeZoneResponse> initializeZone(
        com.google.cloud.edgenetwork.v1.InitializeZoneRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getInitializeZoneMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists Zones in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.edgenetwork.v1.ListZonesResponse> listZones(
        com.google.cloud.edgenetwork.v1.ListZonesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListZonesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets details of a single Zone.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.edgenetwork.v1.Zone> getZone(
        com.google.cloud.edgenetwork.v1.GetZoneRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetZoneMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists Networks in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.edgenetwork.v1.ListNetworksResponse> listNetworks(
        com.google.cloud.edgenetwork.v1.ListNetworksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListNetworksMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets details of a single Network.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.edgenetwork.v1.Network> getNetwork(
        com.google.cloud.edgenetwork.v1.GetNetworkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetNetworkMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get the diagnostics of a single network resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.edgenetwork.v1.DiagnoseNetworkResponse> diagnoseNetwork(
        com.google.cloud.edgenetwork.v1.DiagnoseNetworkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDiagnoseNetworkMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new Network in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createNetwork(
        com.google.cloud.edgenetwork.v1.CreateNetworkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateNetworkMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a single Network.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteNetwork(
        com.google.cloud.edgenetwork.v1.DeleteNetworkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteNetworkMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists Subnets in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.edgenetwork.v1.ListSubnetsResponse> listSubnets(
        com.google.cloud.edgenetwork.v1.ListSubnetsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSubnetsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets details of a single Subnet.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.edgenetwork.v1.Subnet> getSubnet(
        com.google.cloud.edgenetwork.v1.GetSubnetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSubnetMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new Subnet in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createSubnet(
        com.google.cloud.edgenetwork.v1.CreateSubnetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSubnetMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the parameters of a single Subnet.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateSubnet(
        com.google.cloud.edgenetwork.v1.UpdateSubnetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSubnetMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a single Subnet.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteSubnet(
        com.google.cloud.edgenetwork.v1.DeleteSubnetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSubnetMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists Interconnects in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.edgenetwork.v1.ListInterconnectsResponse> listInterconnects(
        com.google.cloud.edgenetwork.v1.ListInterconnectsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListInterconnectsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets details of a single Interconnect.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.edgenetwork.v1.Interconnect> getInterconnect(
        com.google.cloud.edgenetwork.v1.GetInterconnectRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetInterconnectMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get the diagnostics of a single interconnect resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.edgenetwork.v1.DiagnoseInterconnectResponse> diagnoseInterconnect(
        com.google.cloud.edgenetwork.v1.DiagnoseInterconnectRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDiagnoseInterconnectMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists InterconnectAttachments in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.edgenetwork.v1.ListInterconnectAttachmentsResponse> listInterconnectAttachments(
        com.google.cloud.edgenetwork.v1.ListInterconnectAttachmentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListInterconnectAttachmentsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets details of a single InterconnectAttachment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.edgenetwork.v1.InterconnectAttachment> getInterconnectAttachment(
        com.google.cloud.edgenetwork.v1.GetInterconnectAttachmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetInterconnectAttachmentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new InterconnectAttachment in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createInterconnectAttachment(
        com.google.cloud.edgenetwork.v1.CreateInterconnectAttachmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateInterconnectAttachmentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a single InterconnectAttachment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteInterconnectAttachment(
        com.google.cloud.edgenetwork.v1.DeleteInterconnectAttachmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteInterconnectAttachmentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists Routers in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.edgenetwork.v1.ListRoutersResponse> listRouters(
        com.google.cloud.edgenetwork.v1.ListRoutersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRoutersMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets details of a single Router.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.edgenetwork.v1.Router> getRouter(
        com.google.cloud.edgenetwork.v1.GetRouterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRouterMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get the diagnostics of a single router resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.edgenetwork.v1.DiagnoseRouterResponse> diagnoseRouter(
        com.google.cloud.edgenetwork.v1.DiagnoseRouterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDiagnoseRouterMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new Router in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createRouter(
        com.google.cloud.edgenetwork.v1.CreateRouterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateRouterMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the parameters of a single Router.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateRouter(
        com.google.cloud.edgenetwork.v1.UpdateRouterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateRouterMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a single Router.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteRouter(
        com.google.cloud.edgenetwork.v1.DeleteRouterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteRouterMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_INITIALIZE_ZONE = 0;
  private static final int METHODID_LIST_ZONES = 1;
  private static final int METHODID_GET_ZONE = 2;
  private static final int METHODID_LIST_NETWORKS = 3;
  private static final int METHODID_GET_NETWORK = 4;
  private static final int METHODID_DIAGNOSE_NETWORK = 5;
  private static final int METHODID_CREATE_NETWORK = 6;
  private static final int METHODID_DELETE_NETWORK = 7;
  private static final int METHODID_LIST_SUBNETS = 8;
  private static final int METHODID_GET_SUBNET = 9;
  private static final int METHODID_CREATE_SUBNET = 10;
  private static final int METHODID_UPDATE_SUBNET = 11;
  private static final int METHODID_DELETE_SUBNET = 12;
  private static final int METHODID_LIST_INTERCONNECTS = 13;
  private static final int METHODID_GET_INTERCONNECT = 14;
  private static final int METHODID_DIAGNOSE_INTERCONNECT = 15;
  private static final int METHODID_LIST_INTERCONNECT_ATTACHMENTS = 16;
  private static final int METHODID_GET_INTERCONNECT_ATTACHMENT = 17;
  private static final int METHODID_CREATE_INTERCONNECT_ATTACHMENT = 18;
  private static final int METHODID_DELETE_INTERCONNECT_ATTACHMENT = 19;
  private static final int METHODID_LIST_ROUTERS = 20;
  private static final int METHODID_GET_ROUTER = 21;
  private static final int METHODID_DIAGNOSE_ROUTER = 22;
  private static final int METHODID_CREATE_ROUTER = 23;
  private static final int METHODID_UPDATE_ROUTER = 24;
  private static final int METHODID_DELETE_ROUTER = 25;

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
        case METHODID_INITIALIZE_ZONE:
          serviceImpl.initializeZone((com.google.cloud.edgenetwork.v1.InitializeZoneRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.edgenetwork.v1.InitializeZoneResponse>) responseObserver);
          break;
        case METHODID_LIST_ZONES:
          serviceImpl.listZones((com.google.cloud.edgenetwork.v1.ListZonesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.edgenetwork.v1.ListZonesResponse>) responseObserver);
          break;
        case METHODID_GET_ZONE:
          serviceImpl.getZone((com.google.cloud.edgenetwork.v1.GetZoneRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.edgenetwork.v1.Zone>) responseObserver);
          break;
        case METHODID_LIST_NETWORKS:
          serviceImpl.listNetworks((com.google.cloud.edgenetwork.v1.ListNetworksRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.edgenetwork.v1.ListNetworksResponse>) responseObserver);
          break;
        case METHODID_GET_NETWORK:
          serviceImpl.getNetwork((com.google.cloud.edgenetwork.v1.GetNetworkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.edgenetwork.v1.Network>) responseObserver);
          break;
        case METHODID_DIAGNOSE_NETWORK:
          serviceImpl.diagnoseNetwork((com.google.cloud.edgenetwork.v1.DiagnoseNetworkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.edgenetwork.v1.DiagnoseNetworkResponse>) responseObserver);
          break;
        case METHODID_CREATE_NETWORK:
          serviceImpl.createNetwork((com.google.cloud.edgenetwork.v1.CreateNetworkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_NETWORK:
          serviceImpl.deleteNetwork((com.google.cloud.edgenetwork.v1.DeleteNetworkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_SUBNETS:
          serviceImpl.listSubnets((com.google.cloud.edgenetwork.v1.ListSubnetsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.edgenetwork.v1.ListSubnetsResponse>) responseObserver);
          break;
        case METHODID_GET_SUBNET:
          serviceImpl.getSubnet((com.google.cloud.edgenetwork.v1.GetSubnetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.edgenetwork.v1.Subnet>) responseObserver);
          break;
        case METHODID_CREATE_SUBNET:
          serviceImpl.createSubnet((com.google.cloud.edgenetwork.v1.CreateSubnetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_SUBNET:
          serviceImpl.updateSubnet((com.google.cloud.edgenetwork.v1.UpdateSubnetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_SUBNET:
          serviceImpl.deleteSubnet((com.google.cloud.edgenetwork.v1.DeleteSubnetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_INTERCONNECTS:
          serviceImpl.listInterconnects((com.google.cloud.edgenetwork.v1.ListInterconnectsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.edgenetwork.v1.ListInterconnectsResponse>) responseObserver);
          break;
        case METHODID_GET_INTERCONNECT:
          serviceImpl.getInterconnect((com.google.cloud.edgenetwork.v1.GetInterconnectRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.edgenetwork.v1.Interconnect>) responseObserver);
          break;
        case METHODID_DIAGNOSE_INTERCONNECT:
          serviceImpl.diagnoseInterconnect((com.google.cloud.edgenetwork.v1.DiagnoseInterconnectRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.edgenetwork.v1.DiagnoseInterconnectResponse>) responseObserver);
          break;
        case METHODID_LIST_INTERCONNECT_ATTACHMENTS:
          serviceImpl.listInterconnectAttachments((com.google.cloud.edgenetwork.v1.ListInterconnectAttachmentsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.edgenetwork.v1.ListInterconnectAttachmentsResponse>) responseObserver);
          break;
        case METHODID_GET_INTERCONNECT_ATTACHMENT:
          serviceImpl.getInterconnectAttachment((com.google.cloud.edgenetwork.v1.GetInterconnectAttachmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.edgenetwork.v1.InterconnectAttachment>) responseObserver);
          break;
        case METHODID_CREATE_INTERCONNECT_ATTACHMENT:
          serviceImpl.createInterconnectAttachment((com.google.cloud.edgenetwork.v1.CreateInterconnectAttachmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_INTERCONNECT_ATTACHMENT:
          serviceImpl.deleteInterconnectAttachment((com.google.cloud.edgenetwork.v1.DeleteInterconnectAttachmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_ROUTERS:
          serviceImpl.listRouters((com.google.cloud.edgenetwork.v1.ListRoutersRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.edgenetwork.v1.ListRoutersResponse>) responseObserver);
          break;
        case METHODID_GET_ROUTER:
          serviceImpl.getRouter((com.google.cloud.edgenetwork.v1.GetRouterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.edgenetwork.v1.Router>) responseObserver);
          break;
        case METHODID_DIAGNOSE_ROUTER:
          serviceImpl.diagnoseRouter((com.google.cloud.edgenetwork.v1.DiagnoseRouterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.edgenetwork.v1.DiagnoseRouterResponse>) responseObserver);
          break;
        case METHODID_CREATE_ROUTER:
          serviceImpl.createRouter((com.google.cloud.edgenetwork.v1.CreateRouterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_ROUTER:
          serviceImpl.updateRouter((com.google.cloud.edgenetwork.v1.UpdateRouterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_ROUTER:
          serviceImpl.deleteRouter((com.google.cloud.edgenetwork.v1.DeleteRouterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
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
          getInitializeZoneMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.edgenetwork.v1.InitializeZoneRequest,
              com.google.cloud.edgenetwork.v1.InitializeZoneResponse>(
                service, METHODID_INITIALIZE_ZONE)))
        .addMethod(
          getListZonesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.edgenetwork.v1.ListZonesRequest,
              com.google.cloud.edgenetwork.v1.ListZonesResponse>(
                service, METHODID_LIST_ZONES)))
        .addMethod(
          getGetZoneMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.edgenetwork.v1.GetZoneRequest,
              com.google.cloud.edgenetwork.v1.Zone>(
                service, METHODID_GET_ZONE)))
        .addMethod(
          getListNetworksMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.edgenetwork.v1.ListNetworksRequest,
              com.google.cloud.edgenetwork.v1.ListNetworksResponse>(
                service, METHODID_LIST_NETWORKS)))
        .addMethod(
          getGetNetworkMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.edgenetwork.v1.GetNetworkRequest,
              com.google.cloud.edgenetwork.v1.Network>(
                service, METHODID_GET_NETWORK)))
        .addMethod(
          getDiagnoseNetworkMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.edgenetwork.v1.DiagnoseNetworkRequest,
              com.google.cloud.edgenetwork.v1.DiagnoseNetworkResponse>(
                service, METHODID_DIAGNOSE_NETWORK)))
        .addMethod(
          getCreateNetworkMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.edgenetwork.v1.CreateNetworkRequest,
              com.google.longrunning.Operation>(
                service, METHODID_CREATE_NETWORK)))
        .addMethod(
          getDeleteNetworkMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.edgenetwork.v1.DeleteNetworkRequest,
              com.google.longrunning.Operation>(
                service, METHODID_DELETE_NETWORK)))
        .addMethod(
          getListSubnetsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.edgenetwork.v1.ListSubnetsRequest,
              com.google.cloud.edgenetwork.v1.ListSubnetsResponse>(
                service, METHODID_LIST_SUBNETS)))
        .addMethod(
          getGetSubnetMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.edgenetwork.v1.GetSubnetRequest,
              com.google.cloud.edgenetwork.v1.Subnet>(
                service, METHODID_GET_SUBNET)))
        .addMethod(
          getCreateSubnetMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.edgenetwork.v1.CreateSubnetRequest,
              com.google.longrunning.Operation>(
                service, METHODID_CREATE_SUBNET)))
        .addMethod(
          getUpdateSubnetMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.edgenetwork.v1.UpdateSubnetRequest,
              com.google.longrunning.Operation>(
                service, METHODID_UPDATE_SUBNET)))
        .addMethod(
          getDeleteSubnetMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.edgenetwork.v1.DeleteSubnetRequest,
              com.google.longrunning.Operation>(
                service, METHODID_DELETE_SUBNET)))
        .addMethod(
          getListInterconnectsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.edgenetwork.v1.ListInterconnectsRequest,
              com.google.cloud.edgenetwork.v1.ListInterconnectsResponse>(
                service, METHODID_LIST_INTERCONNECTS)))
        .addMethod(
          getGetInterconnectMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.edgenetwork.v1.GetInterconnectRequest,
              com.google.cloud.edgenetwork.v1.Interconnect>(
                service, METHODID_GET_INTERCONNECT)))
        .addMethod(
          getDiagnoseInterconnectMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.edgenetwork.v1.DiagnoseInterconnectRequest,
              com.google.cloud.edgenetwork.v1.DiagnoseInterconnectResponse>(
                service, METHODID_DIAGNOSE_INTERCONNECT)))
        .addMethod(
          getListInterconnectAttachmentsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.edgenetwork.v1.ListInterconnectAttachmentsRequest,
              com.google.cloud.edgenetwork.v1.ListInterconnectAttachmentsResponse>(
                service, METHODID_LIST_INTERCONNECT_ATTACHMENTS)))
        .addMethod(
          getGetInterconnectAttachmentMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.edgenetwork.v1.GetInterconnectAttachmentRequest,
              com.google.cloud.edgenetwork.v1.InterconnectAttachment>(
                service, METHODID_GET_INTERCONNECT_ATTACHMENT)))
        .addMethod(
          getCreateInterconnectAttachmentMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.edgenetwork.v1.CreateInterconnectAttachmentRequest,
              com.google.longrunning.Operation>(
                service, METHODID_CREATE_INTERCONNECT_ATTACHMENT)))
        .addMethod(
          getDeleteInterconnectAttachmentMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.edgenetwork.v1.DeleteInterconnectAttachmentRequest,
              com.google.longrunning.Operation>(
                service, METHODID_DELETE_INTERCONNECT_ATTACHMENT)))
        .addMethod(
          getListRoutersMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.edgenetwork.v1.ListRoutersRequest,
              com.google.cloud.edgenetwork.v1.ListRoutersResponse>(
                service, METHODID_LIST_ROUTERS)))
        .addMethod(
          getGetRouterMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.edgenetwork.v1.GetRouterRequest,
              com.google.cloud.edgenetwork.v1.Router>(
                service, METHODID_GET_ROUTER)))
        .addMethod(
          getDiagnoseRouterMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.edgenetwork.v1.DiagnoseRouterRequest,
              com.google.cloud.edgenetwork.v1.DiagnoseRouterResponse>(
                service, METHODID_DIAGNOSE_ROUTER)))
        .addMethod(
          getCreateRouterMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.edgenetwork.v1.CreateRouterRequest,
              com.google.longrunning.Operation>(
                service, METHODID_CREATE_ROUTER)))
        .addMethod(
          getUpdateRouterMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.edgenetwork.v1.UpdateRouterRequest,
              com.google.longrunning.Operation>(
                service, METHODID_UPDATE_ROUTER)))
        .addMethod(
          getDeleteRouterMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.edgenetwork.v1.DeleteRouterRequest,
              com.google.longrunning.Operation>(
                service, METHODID_DELETE_ROUTER)))
        .build();
  }

  private static abstract class EdgeNetworkBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EdgeNetworkBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.edgenetwork.v1.ServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EdgeNetwork");
    }
  }

  private static final class EdgeNetworkFileDescriptorSupplier
      extends EdgeNetworkBaseDescriptorSupplier {
    EdgeNetworkFileDescriptorSupplier() {}
  }

  private static final class EdgeNetworkMethodDescriptorSupplier
      extends EdgeNetworkBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    EdgeNetworkMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (EdgeNetworkGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EdgeNetworkFileDescriptorSupplier())
              .addMethod(getInitializeZoneMethod())
              .addMethod(getListZonesMethod())
              .addMethod(getGetZoneMethod())
              .addMethod(getListNetworksMethod())
              .addMethod(getGetNetworkMethod())
              .addMethod(getDiagnoseNetworkMethod())
              .addMethod(getCreateNetworkMethod())
              .addMethod(getDeleteNetworkMethod())
              .addMethod(getListSubnetsMethod())
              .addMethod(getGetSubnetMethod())
              .addMethod(getCreateSubnetMethod())
              .addMethod(getUpdateSubnetMethod())
              .addMethod(getDeleteSubnetMethod())
              .addMethod(getListInterconnectsMethod())
              .addMethod(getGetInterconnectMethod())
              .addMethod(getDiagnoseInterconnectMethod())
              .addMethod(getListInterconnectAttachmentsMethod())
              .addMethod(getGetInterconnectAttachmentMethod())
              .addMethod(getCreateInterconnectAttachmentMethod())
              .addMethod(getDeleteInterconnectAttachmentMethod())
              .addMethod(getListRoutersMethod())
              .addMethod(getGetRouterMethod())
              .addMethod(getDiagnoseRouterMethod())
              .addMethod(getCreateRouterMethod())
              .addMethod(getUpdateRouterMethod())
              .addMethod(getDeleteRouterMethod())
              .build();
        }
      }
    }
    return result;
  }
}
