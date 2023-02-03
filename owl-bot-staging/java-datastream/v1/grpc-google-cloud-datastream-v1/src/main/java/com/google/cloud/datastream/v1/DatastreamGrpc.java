package com.google.cloud.datastream.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Datastream service
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/datastream/v1/datastream.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DatastreamGrpc {

  private DatastreamGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.datastream.v1.Datastream";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.ListConnectionProfilesRequest,
      com.google.cloud.datastream.v1.ListConnectionProfilesResponse> getListConnectionProfilesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListConnectionProfiles",
      requestType = com.google.cloud.datastream.v1.ListConnectionProfilesRequest.class,
      responseType = com.google.cloud.datastream.v1.ListConnectionProfilesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.ListConnectionProfilesRequest,
      com.google.cloud.datastream.v1.ListConnectionProfilesResponse> getListConnectionProfilesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.ListConnectionProfilesRequest, com.google.cloud.datastream.v1.ListConnectionProfilesResponse> getListConnectionProfilesMethod;
    if ((getListConnectionProfilesMethod = DatastreamGrpc.getListConnectionProfilesMethod) == null) {
      synchronized (DatastreamGrpc.class) {
        if ((getListConnectionProfilesMethod = DatastreamGrpc.getListConnectionProfilesMethod) == null) {
          DatastreamGrpc.getListConnectionProfilesMethod = getListConnectionProfilesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.datastream.v1.ListConnectionProfilesRequest, com.google.cloud.datastream.v1.ListConnectionProfilesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListConnectionProfiles"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datastream.v1.ListConnectionProfilesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datastream.v1.ListConnectionProfilesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DatastreamMethodDescriptorSupplier("ListConnectionProfiles"))
              .build();
        }
      }
    }
    return getListConnectionProfilesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.GetConnectionProfileRequest,
      com.google.cloud.datastream.v1.ConnectionProfile> getGetConnectionProfileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetConnectionProfile",
      requestType = com.google.cloud.datastream.v1.GetConnectionProfileRequest.class,
      responseType = com.google.cloud.datastream.v1.ConnectionProfile.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.GetConnectionProfileRequest,
      com.google.cloud.datastream.v1.ConnectionProfile> getGetConnectionProfileMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.GetConnectionProfileRequest, com.google.cloud.datastream.v1.ConnectionProfile> getGetConnectionProfileMethod;
    if ((getGetConnectionProfileMethod = DatastreamGrpc.getGetConnectionProfileMethod) == null) {
      synchronized (DatastreamGrpc.class) {
        if ((getGetConnectionProfileMethod = DatastreamGrpc.getGetConnectionProfileMethod) == null) {
          DatastreamGrpc.getGetConnectionProfileMethod = getGetConnectionProfileMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.datastream.v1.GetConnectionProfileRequest, com.google.cloud.datastream.v1.ConnectionProfile>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetConnectionProfile"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datastream.v1.GetConnectionProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datastream.v1.ConnectionProfile.getDefaultInstance()))
              .setSchemaDescriptor(new DatastreamMethodDescriptorSupplier("GetConnectionProfile"))
              .build();
        }
      }
    }
    return getGetConnectionProfileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.CreateConnectionProfileRequest,
      com.google.longrunning.Operation> getCreateConnectionProfileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateConnectionProfile",
      requestType = com.google.cloud.datastream.v1.CreateConnectionProfileRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.CreateConnectionProfileRequest,
      com.google.longrunning.Operation> getCreateConnectionProfileMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.CreateConnectionProfileRequest, com.google.longrunning.Operation> getCreateConnectionProfileMethod;
    if ((getCreateConnectionProfileMethod = DatastreamGrpc.getCreateConnectionProfileMethod) == null) {
      synchronized (DatastreamGrpc.class) {
        if ((getCreateConnectionProfileMethod = DatastreamGrpc.getCreateConnectionProfileMethod) == null) {
          DatastreamGrpc.getCreateConnectionProfileMethod = getCreateConnectionProfileMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.datastream.v1.CreateConnectionProfileRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateConnectionProfile"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datastream.v1.CreateConnectionProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new DatastreamMethodDescriptorSupplier("CreateConnectionProfile"))
              .build();
        }
      }
    }
    return getCreateConnectionProfileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.UpdateConnectionProfileRequest,
      com.google.longrunning.Operation> getUpdateConnectionProfileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateConnectionProfile",
      requestType = com.google.cloud.datastream.v1.UpdateConnectionProfileRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.UpdateConnectionProfileRequest,
      com.google.longrunning.Operation> getUpdateConnectionProfileMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.UpdateConnectionProfileRequest, com.google.longrunning.Operation> getUpdateConnectionProfileMethod;
    if ((getUpdateConnectionProfileMethod = DatastreamGrpc.getUpdateConnectionProfileMethod) == null) {
      synchronized (DatastreamGrpc.class) {
        if ((getUpdateConnectionProfileMethod = DatastreamGrpc.getUpdateConnectionProfileMethod) == null) {
          DatastreamGrpc.getUpdateConnectionProfileMethod = getUpdateConnectionProfileMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.datastream.v1.UpdateConnectionProfileRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateConnectionProfile"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datastream.v1.UpdateConnectionProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new DatastreamMethodDescriptorSupplier("UpdateConnectionProfile"))
              .build();
        }
      }
    }
    return getUpdateConnectionProfileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.DeleteConnectionProfileRequest,
      com.google.longrunning.Operation> getDeleteConnectionProfileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteConnectionProfile",
      requestType = com.google.cloud.datastream.v1.DeleteConnectionProfileRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.DeleteConnectionProfileRequest,
      com.google.longrunning.Operation> getDeleteConnectionProfileMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.DeleteConnectionProfileRequest, com.google.longrunning.Operation> getDeleteConnectionProfileMethod;
    if ((getDeleteConnectionProfileMethod = DatastreamGrpc.getDeleteConnectionProfileMethod) == null) {
      synchronized (DatastreamGrpc.class) {
        if ((getDeleteConnectionProfileMethod = DatastreamGrpc.getDeleteConnectionProfileMethod) == null) {
          DatastreamGrpc.getDeleteConnectionProfileMethod = getDeleteConnectionProfileMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.datastream.v1.DeleteConnectionProfileRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteConnectionProfile"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datastream.v1.DeleteConnectionProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new DatastreamMethodDescriptorSupplier("DeleteConnectionProfile"))
              .build();
        }
      }
    }
    return getDeleteConnectionProfileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.DiscoverConnectionProfileRequest,
      com.google.cloud.datastream.v1.DiscoverConnectionProfileResponse> getDiscoverConnectionProfileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DiscoverConnectionProfile",
      requestType = com.google.cloud.datastream.v1.DiscoverConnectionProfileRequest.class,
      responseType = com.google.cloud.datastream.v1.DiscoverConnectionProfileResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.DiscoverConnectionProfileRequest,
      com.google.cloud.datastream.v1.DiscoverConnectionProfileResponse> getDiscoverConnectionProfileMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.DiscoverConnectionProfileRequest, com.google.cloud.datastream.v1.DiscoverConnectionProfileResponse> getDiscoverConnectionProfileMethod;
    if ((getDiscoverConnectionProfileMethod = DatastreamGrpc.getDiscoverConnectionProfileMethod) == null) {
      synchronized (DatastreamGrpc.class) {
        if ((getDiscoverConnectionProfileMethod = DatastreamGrpc.getDiscoverConnectionProfileMethod) == null) {
          DatastreamGrpc.getDiscoverConnectionProfileMethod = getDiscoverConnectionProfileMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.datastream.v1.DiscoverConnectionProfileRequest, com.google.cloud.datastream.v1.DiscoverConnectionProfileResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DiscoverConnectionProfile"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datastream.v1.DiscoverConnectionProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datastream.v1.DiscoverConnectionProfileResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DatastreamMethodDescriptorSupplier("DiscoverConnectionProfile"))
              .build();
        }
      }
    }
    return getDiscoverConnectionProfileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.ListStreamsRequest,
      com.google.cloud.datastream.v1.ListStreamsResponse> getListStreamsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListStreams",
      requestType = com.google.cloud.datastream.v1.ListStreamsRequest.class,
      responseType = com.google.cloud.datastream.v1.ListStreamsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.ListStreamsRequest,
      com.google.cloud.datastream.v1.ListStreamsResponse> getListStreamsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.ListStreamsRequest, com.google.cloud.datastream.v1.ListStreamsResponse> getListStreamsMethod;
    if ((getListStreamsMethod = DatastreamGrpc.getListStreamsMethod) == null) {
      synchronized (DatastreamGrpc.class) {
        if ((getListStreamsMethod = DatastreamGrpc.getListStreamsMethod) == null) {
          DatastreamGrpc.getListStreamsMethod = getListStreamsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.datastream.v1.ListStreamsRequest, com.google.cloud.datastream.v1.ListStreamsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListStreams"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datastream.v1.ListStreamsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datastream.v1.ListStreamsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DatastreamMethodDescriptorSupplier("ListStreams"))
              .build();
        }
      }
    }
    return getListStreamsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.GetStreamRequest,
      com.google.cloud.datastream.v1.Stream> getGetStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStream",
      requestType = com.google.cloud.datastream.v1.GetStreamRequest.class,
      responseType = com.google.cloud.datastream.v1.Stream.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.GetStreamRequest,
      com.google.cloud.datastream.v1.Stream> getGetStreamMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.GetStreamRequest, com.google.cloud.datastream.v1.Stream> getGetStreamMethod;
    if ((getGetStreamMethod = DatastreamGrpc.getGetStreamMethod) == null) {
      synchronized (DatastreamGrpc.class) {
        if ((getGetStreamMethod = DatastreamGrpc.getGetStreamMethod) == null) {
          DatastreamGrpc.getGetStreamMethod = getGetStreamMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.datastream.v1.GetStreamRequest, com.google.cloud.datastream.v1.Stream>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datastream.v1.GetStreamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datastream.v1.Stream.getDefaultInstance()))
              .setSchemaDescriptor(new DatastreamMethodDescriptorSupplier("GetStream"))
              .build();
        }
      }
    }
    return getGetStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.CreateStreamRequest,
      com.google.longrunning.Operation> getCreateStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateStream",
      requestType = com.google.cloud.datastream.v1.CreateStreamRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.CreateStreamRequest,
      com.google.longrunning.Operation> getCreateStreamMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.CreateStreamRequest, com.google.longrunning.Operation> getCreateStreamMethod;
    if ((getCreateStreamMethod = DatastreamGrpc.getCreateStreamMethod) == null) {
      synchronized (DatastreamGrpc.class) {
        if ((getCreateStreamMethod = DatastreamGrpc.getCreateStreamMethod) == null) {
          DatastreamGrpc.getCreateStreamMethod = getCreateStreamMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.datastream.v1.CreateStreamRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datastream.v1.CreateStreamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new DatastreamMethodDescriptorSupplier("CreateStream"))
              .build();
        }
      }
    }
    return getCreateStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.UpdateStreamRequest,
      com.google.longrunning.Operation> getUpdateStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateStream",
      requestType = com.google.cloud.datastream.v1.UpdateStreamRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.UpdateStreamRequest,
      com.google.longrunning.Operation> getUpdateStreamMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.UpdateStreamRequest, com.google.longrunning.Operation> getUpdateStreamMethod;
    if ((getUpdateStreamMethod = DatastreamGrpc.getUpdateStreamMethod) == null) {
      synchronized (DatastreamGrpc.class) {
        if ((getUpdateStreamMethod = DatastreamGrpc.getUpdateStreamMethod) == null) {
          DatastreamGrpc.getUpdateStreamMethod = getUpdateStreamMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.datastream.v1.UpdateStreamRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datastream.v1.UpdateStreamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new DatastreamMethodDescriptorSupplier("UpdateStream"))
              .build();
        }
      }
    }
    return getUpdateStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.DeleteStreamRequest,
      com.google.longrunning.Operation> getDeleteStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteStream",
      requestType = com.google.cloud.datastream.v1.DeleteStreamRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.DeleteStreamRequest,
      com.google.longrunning.Operation> getDeleteStreamMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.DeleteStreamRequest, com.google.longrunning.Operation> getDeleteStreamMethod;
    if ((getDeleteStreamMethod = DatastreamGrpc.getDeleteStreamMethod) == null) {
      synchronized (DatastreamGrpc.class) {
        if ((getDeleteStreamMethod = DatastreamGrpc.getDeleteStreamMethod) == null) {
          DatastreamGrpc.getDeleteStreamMethod = getDeleteStreamMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.datastream.v1.DeleteStreamRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datastream.v1.DeleteStreamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new DatastreamMethodDescriptorSupplier("DeleteStream"))
              .build();
        }
      }
    }
    return getDeleteStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.GetStreamObjectRequest,
      com.google.cloud.datastream.v1.StreamObject> getGetStreamObjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStreamObject",
      requestType = com.google.cloud.datastream.v1.GetStreamObjectRequest.class,
      responseType = com.google.cloud.datastream.v1.StreamObject.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.GetStreamObjectRequest,
      com.google.cloud.datastream.v1.StreamObject> getGetStreamObjectMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.GetStreamObjectRequest, com.google.cloud.datastream.v1.StreamObject> getGetStreamObjectMethod;
    if ((getGetStreamObjectMethod = DatastreamGrpc.getGetStreamObjectMethod) == null) {
      synchronized (DatastreamGrpc.class) {
        if ((getGetStreamObjectMethod = DatastreamGrpc.getGetStreamObjectMethod) == null) {
          DatastreamGrpc.getGetStreamObjectMethod = getGetStreamObjectMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.datastream.v1.GetStreamObjectRequest, com.google.cloud.datastream.v1.StreamObject>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetStreamObject"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datastream.v1.GetStreamObjectRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datastream.v1.StreamObject.getDefaultInstance()))
              .setSchemaDescriptor(new DatastreamMethodDescriptorSupplier("GetStreamObject"))
              .build();
        }
      }
    }
    return getGetStreamObjectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.LookupStreamObjectRequest,
      com.google.cloud.datastream.v1.StreamObject> getLookupStreamObjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LookupStreamObject",
      requestType = com.google.cloud.datastream.v1.LookupStreamObjectRequest.class,
      responseType = com.google.cloud.datastream.v1.StreamObject.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.LookupStreamObjectRequest,
      com.google.cloud.datastream.v1.StreamObject> getLookupStreamObjectMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.LookupStreamObjectRequest, com.google.cloud.datastream.v1.StreamObject> getLookupStreamObjectMethod;
    if ((getLookupStreamObjectMethod = DatastreamGrpc.getLookupStreamObjectMethod) == null) {
      synchronized (DatastreamGrpc.class) {
        if ((getLookupStreamObjectMethod = DatastreamGrpc.getLookupStreamObjectMethod) == null) {
          DatastreamGrpc.getLookupStreamObjectMethod = getLookupStreamObjectMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.datastream.v1.LookupStreamObjectRequest, com.google.cloud.datastream.v1.StreamObject>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LookupStreamObject"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datastream.v1.LookupStreamObjectRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datastream.v1.StreamObject.getDefaultInstance()))
              .setSchemaDescriptor(new DatastreamMethodDescriptorSupplier("LookupStreamObject"))
              .build();
        }
      }
    }
    return getLookupStreamObjectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.ListStreamObjectsRequest,
      com.google.cloud.datastream.v1.ListStreamObjectsResponse> getListStreamObjectsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListStreamObjects",
      requestType = com.google.cloud.datastream.v1.ListStreamObjectsRequest.class,
      responseType = com.google.cloud.datastream.v1.ListStreamObjectsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.ListStreamObjectsRequest,
      com.google.cloud.datastream.v1.ListStreamObjectsResponse> getListStreamObjectsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.ListStreamObjectsRequest, com.google.cloud.datastream.v1.ListStreamObjectsResponse> getListStreamObjectsMethod;
    if ((getListStreamObjectsMethod = DatastreamGrpc.getListStreamObjectsMethod) == null) {
      synchronized (DatastreamGrpc.class) {
        if ((getListStreamObjectsMethod = DatastreamGrpc.getListStreamObjectsMethod) == null) {
          DatastreamGrpc.getListStreamObjectsMethod = getListStreamObjectsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.datastream.v1.ListStreamObjectsRequest, com.google.cloud.datastream.v1.ListStreamObjectsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListStreamObjects"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datastream.v1.ListStreamObjectsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datastream.v1.ListStreamObjectsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DatastreamMethodDescriptorSupplier("ListStreamObjects"))
              .build();
        }
      }
    }
    return getListStreamObjectsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.StartBackfillJobRequest,
      com.google.cloud.datastream.v1.StartBackfillJobResponse> getStartBackfillJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartBackfillJob",
      requestType = com.google.cloud.datastream.v1.StartBackfillJobRequest.class,
      responseType = com.google.cloud.datastream.v1.StartBackfillJobResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.StartBackfillJobRequest,
      com.google.cloud.datastream.v1.StartBackfillJobResponse> getStartBackfillJobMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.StartBackfillJobRequest, com.google.cloud.datastream.v1.StartBackfillJobResponse> getStartBackfillJobMethod;
    if ((getStartBackfillJobMethod = DatastreamGrpc.getStartBackfillJobMethod) == null) {
      synchronized (DatastreamGrpc.class) {
        if ((getStartBackfillJobMethod = DatastreamGrpc.getStartBackfillJobMethod) == null) {
          DatastreamGrpc.getStartBackfillJobMethod = getStartBackfillJobMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.datastream.v1.StartBackfillJobRequest, com.google.cloud.datastream.v1.StartBackfillJobResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartBackfillJob"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datastream.v1.StartBackfillJobRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datastream.v1.StartBackfillJobResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DatastreamMethodDescriptorSupplier("StartBackfillJob"))
              .build();
        }
      }
    }
    return getStartBackfillJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.StopBackfillJobRequest,
      com.google.cloud.datastream.v1.StopBackfillJobResponse> getStopBackfillJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StopBackfillJob",
      requestType = com.google.cloud.datastream.v1.StopBackfillJobRequest.class,
      responseType = com.google.cloud.datastream.v1.StopBackfillJobResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.StopBackfillJobRequest,
      com.google.cloud.datastream.v1.StopBackfillJobResponse> getStopBackfillJobMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.StopBackfillJobRequest, com.google.cloud.datastream.v1.StopBackfillJobResponse> getStopBackfillJobMethod;
    if ((getStopBackfillJobMethod = DatastreamGrpc.getStopBackfillJobMethod) == null) {
      synchronized (DatastreamGrpc.class) {
        if ((getStopBackfillJobMethod = DatastreamGrpc.getStopBackfillJobMethod) == null) {
          DatastreamGrpc.getStopBackfillJobMethod = getStopBackfillJobMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.datastream.v1.StopBackfillJobRequest, com.google.cloud.datastream.v1.StopBackfillJobResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StopBackfillJob"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datastream.v1.StopBackfillJobRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datastream.v1.StopBackfillJobResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DatastreamMethodDescriptorSupplier("StopBackfillJob"))
              .build();
        }
      }
    }
    return getStopBackfillJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.FetchStaticIpsRequest,
      com.google.cloud.datastream.v1.FetchStaticIpsResponse> getFetchStaticIpsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchStaticIps",
      requestType = com.google.cloud.datastream.v1.FetchStaticIpsRequest.class,
      responseType = com.google.cloud.datastream.v1.FetchStaticIpsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.FetchStaticIpsRequest,
      com.google.cloud.datastream.v1.FetchStaticIpsResponse> getFetchStaticIpsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.FetchStaticIpsRequest, com.google.cloud.datastream.v1.FetchStaticIpsResponse> getFetchStaticIpsMethod;
    if ((getFetchStaticIpsMethod = DatastreamGrpc.getFetchStaticIpsMethod) == null) {
      synchronized (DatastreamGrpc.class) {
        if ((getFetchStaticIpsMethod = DatastreamGrpc.getFetchStaticIpsMethod) == null) {
          DatastreamGrpc.getFetchStaticIpsMethod = getFetchStaticIpsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.datastream.v1.FetchStaticIpsRequest, com.google.cloud.datastream.v1.FetchStaticIpsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FetchStaticIps"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datastream.v1.FetchStaticIpsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datastream.v1.FetchStaticIpsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DatastreamMethodDescriptorSupplier("FetchStaticIps"))
              .build();
        }
      }
    }
    return getFetchStaticIpsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.CreatePrivateConnectionRequest,
      com.google.longrunning.Operation> getCreatePrivateConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreatePrivateConnection",
      requestType = com.google.cloud.datastream.v1.CreatePrivateConnectionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.CreatePrivateConnectionRequest,
      com.google.longrunning.Operation> getCreatePrivateConnectionMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.CreatePrivateConnectionRequest, com.google.longrunning.Operation> getCreatePrivateConnectionMethod;
    if ((getCreatePrivateConnectionMethod = DatastreamGrpc.getCreatePrivateConnectionMethod) == null) {
      synchronized (DatastreamGrpc.class) {
        if ((getCreatePrivateConnectionMethod = DatastreamGrpc.getCreatePrivateConnectionMethod) == null) {
          DatastreamGrpc.getCreatePrivateConnectionMethod = getCreatePrivateConnectionMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.datastream.v1.CreatePrivateConnectionRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreatePrivateConnection"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datastream.v1.CreatePrivateConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new DatastreamMethodDescriptorSupplier("CreatePrivateConnection"))
              .build();
        }
      }
    }
    return getCreatePrivateConnectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.GetPrivateConnectionRequest,
      com.google.cloud.datastream.v1.PrivateConnection> getGetPrivateConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPrivateConnection",
      requestType = com.google.cloud.datastream.v1.GetPrivateConnectionRequest.class,
      responseType = com.google.cloud.datastream.v1.PrivateConnection.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.GetPrivateConnectionRequest,
      com.google.cloud.datastream.v1.PrivateConnection> getGetPrivateConnectionMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.GetPrivateConnectionRequest, com.google.cloud.datastream.v1.PrivateConnection> getGetPrivateConnectionMethod;
    if ((getGetPrivateConnectionMethod = DatastreamGrpc.getGetPrivateConnectionMethod) == null) {
      synchronized (DatastreamGrpc.class) {
        if ((getGetPrivateConnectionMethod = DatastreamGrpc.getGetPrivateConnectionMethod) == null) {
          DatastreamGrpc.getGetPrivateConnectionMethod = getGetPrivateConnectionMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.datastream.v1.GetPrivateConnectionRequest, com.google.cloud.datastream.v1.PrivateConnection>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPrivateConnection"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datastream.v1.GetPrivateConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datastream.v1.PrivateConnection.getDefaultInstance()))
              .setSchemaDescriptor(new DatastreamMethodDescriptorSupplier("GetPrivateConnection"))
              .build();
        }
      }
    }
    return getGetPrivateConnectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.ListPrivateConnectionsRequest,
      com.google.cloud.datastream.v1.ListPrivateConnectionsResponse> getListPrivateConnectionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPrivateConnections",
      requestType = com.google.cloud.datastream.v1.ListPrivateConnectionsRequest.class,
      responseType = com.google.cloud.datastream.v1.ListPrivateConnectionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.ListPrivateConnectionsRequest,
      com.google.cloud.datastream.v1.ListPrivateConnectionsResponse> getListPrivateConnectionsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.ListPrivateConnectionsRequest, com.google.cloud.datastream.v1.ListPrivateConnectionsResponse> getListPrivateConnectionsMethod;
    if ((getListPrivateConnectionsMethod = DatastreamGrpc.getListPrivateConnectionsMethod) == null) {
      synchronized (DatastreamGrpc.class) {
        if ((getListPrivateConnectionsMethod = DatastreamGrpc.getListPrivateConnectionsMethod) == null) {
          DatastreamGrpc.getListPrivateConnectionsMethod = getListPrivateConnectionsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.datastream.v1.ListPrivateConnectionsRequest, com.google.cloud.datastream.v1.ListPrivateConnectionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListPrivateConnections"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datastream.v1.ListPrivateConnectionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datastream.v1.ListPrivateConnectionsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DatastreamMethodDescriptorSupplier("ListPrivateConnections"))
              .build();
        }
      }
    }
    return getListPrivateConnectionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.DeletePrivateConnectionRequest,
      com.google.longrunning.Operation> getDeletePrivateConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeletePrivateConnection",
      requestType = com.google.cloud.datastream.v1.DeletePrivateConnectionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.DeletePrivateConnectionRequest,
      com.google.longrunning.Operation> getDeletePrivateConnectionMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.DeletePrivateConnectionRequest, com.google.longrunning.Operation> getDeletePrivateConnectionMethod;
    if ((getDeletePrivateConnectionMethod = DatastreamGrpc.getDeletePrivateConnectionMethod) == null) {
      synchronized (DatastreamGrpc.class) {
        if ((getDeletePrivateConnectionMethod = DatastreamGrpc.getDeletePrivateConnectionMethod) == null) {
          DatastreamGrpc.getDeletePrivateConnectionMethod = getDeletePrivateConnectionMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.datastream.v1.DeletePrivateConnectionRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeletePrivateConnection"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datastream.v1.DeletePrivateConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new DatastreamMethodDescriptorSupplier("DeletePrivateConnection"))
              .build();
        }
      }
    }
    return getDeletePrivateConnectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.CreateRouteRequest,
      com.google.longrunning.Operation> getCreateRouteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRoute",
      requestType = com.google.cloud.datastream.v1.CreateRouteRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.CreateRouteRequest,
      com.google.longrunning.Operation> getCreateRouteMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.CreateRouteRequest, com.google.longrunning.Operation> getCreateRouteMethod;
    if ((getCreateRouteMethod = DatastreamGrpc.getCreateRouteMethod) == null) {
      synchronized (DatastreamGrpc.class) {
        if ((getCreateRouteMethod = DatastreamGrpc.getCreateRouteMethod) == null) {
          DatastreamGrpc.getCreateRouteMethod = getCreateRouteMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.datastream.v1.CreateRouteRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateRoute"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datastream.v1.CreateRouteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new DatastreamMethodDescriptorSupplier("CreateRoute"))
              .build();
        }
      }
    }
    return getCreateRouteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.GetRouteRequest,
      com.google.cloud.datastream.v1.Route> getGetRouteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRoute",
      requestType = com.google.cloud.datastream.v1.GetRouteRequest.class,
      responseType = com.google.cloud.datastream.v1.Route.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.GetRouteRequest,
      com.google.cloud.datastream.v1.Route> getGetRouteMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.GetRouteRequest, com.google.cloud.datastream.v1.Route> getGetRouteMethod;
    if ((getGetRouteMethod = DatastreamGrpc.getGetRouteMethod) == null) {
      synchronized (DatastreamGrpc.class) {
        if ((getGetRouteMethod = DatastreamGrpc.getGetRouteMethod) == null) {
          DatastreamGrpc.getGetRouteMethod = getGetRouteMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.datastream.v1.GetRouteRequest, com.google.cloud.datastream.v1.Route>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRoute"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datastream.v1.GetRouteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datastream.v1.Route.getDefaultInstance()))
              .setSchemaDescriptor(new DatastreamMethodDescriptorSupplier("GetRoute"))
              .build();
        }
      }
    }
    return getGetRouteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.ListRoutesRequest,
      com.google.cloud.datastream.v1.ListRoutesResponse> getListRoutesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRoutes",
      requestType = com.google.cloud.datastream.v1.ListRoutesRequest.class,
      responseType = com.google.cloud.datastream.v1.ListRoutesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.ListRoutesRequest,
      com.google.cloud.datastream.v1.ListRoutesResponse> getListRoutesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.ListRoutesRequest, com.google.cloud.datastream.v1.ListRoutesResponse> getListRoutesMethod;
    if ((getListRoutesMethod = DatastreamGrpc.getListRoutesMethod) == null) {
      synchronized (DatastreamGrpc.class) {
        if ((getListRoutesMethod = DatastreamGrpc.getListRoutesMethod) == null) {
          DatastreamGrpc.getListRoutesMethod = getListRoutesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.datastream.v1.ListRoutesRequest, com.google.cloud.datastream.v1.ListRoutesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListRoutes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datastream.v1.ListRoutesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datastream.v1.ListRoutesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DatastreamMethodDescriptorSupplier("ListRoutes"))
              .build();
        }
      }
    }
    return getListRoutesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.DeleteRouteRequest,
      com.google.longrunning.Operation> getDeleteRouteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteRoute",
      requestType = com.google.cloud.datastream.v1.DeleteRouteRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.DeleteRouteRequest,
      com.google.longrunning.Operation> getDeleteRouteMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.datastream.v1.DeleteRouteRequest, com.google.longrunning.Operation> getDeleteRouteMethod;
    if ((getDeleteRouteMethod = DatastreamGrpc.getDeleteRouteMethod) == null) {
      synchronized (DatastreamGrpc.class) {
        if ((getDeleteRouteMethod = DatastreamGrpc.getDeleteRouteMethod) == null) {
          DatastreamGrpc.getDeleteRouteMethod = getDeleteRouteMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.datastream.v1.DeleteRouteRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteRoute"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datastream.v1.DeleteRouteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new DatastreamMethodDescriptorSupplier("DeleteRoute"))
              .build();
        }
      }
    }
    return getDeleteRouteMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DatastreamStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DatastreamStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DatastreamStub>() {
        @java.lang.Override
        public DatastreamStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DatastreamStub(channel, callOptions);
        }
      };
    return DatastreamStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DatastreamBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DatastreamBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DatastreamBlockingStub>() {
        @java.lang.Override
        public DatastreamBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DatastreamBlockingStub(channel, callOptions);
        }
      };
    return DatastreamBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DatastreamFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DatastreamFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DatastreamFutureStub>() {
        @java.lang.Override
        public DatastreamFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DatastreamFutureStub(channel, callOptions);
        }
      };
    return DatastreamFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Datastream service
   * </pre>
   */
  public static abstract class DatastreamImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Use this method to list connection profiles created in a project and
     * location.
     * </pre>
     */
    public void listConnectionProfiles(com.google.cloud.datastream.v1.ListConnectionProfilesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datastream.v1.ListConnectionProfilesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListConnectionProfilesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Use this method to get details about a connection profile.
     * </pre>
     */
    public void getConnectionProfile(com.google.cloud.datastream.v1.GetConnectionProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datastream.v1.ConnectionProfile> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetConnectionProfileMethod(), responseObserver);
    }

    /**
     * <pre>
     * Use this method to create a connection profile in a project and location.
     * </pre>
     */
    public void createConnectionProfile(com.google.cloud.datastream.v1.CreateConnectionProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateConnectionProfileMethod(), responseObserver);
    }

    /**
     * <pre>
     * Use this method to update the parameters of a connection profile.
     * </pre>
     */
    public void updateConnectionProfile(com.google.cloud.datastream.v1.UpdateConnectionProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateConnectionProfileMethod(), responseObserver);
    }

    /**
     * <pre>
     * Use this method to delete a connection profile.
     * </pre>
     */
    public void deleteConnectionProfile(com.google.cloud.datastream.v1.DeleteConnectionProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteConnectionProfileMethod(), responseObserver);
    }

    /**
     * <pre>
     * Use this method to discover a connection profile.
     * The discover API call exposes the data objects and metadata belonging to
     * the profile. Typically, a request returns children data objects of a
     * parent data object that's optionally supplied in the request.
     * </pre>
     */
    public void discoverConnectionProfile(com.google.cloud.datastream.v1.DiscoverConnectionProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datastream.v1.DiscoverConnectionProfileResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDiscoverConnectionProfileMethod(), responseObserver);
    }

    /**
     * <pre>
     * Use this method to list streams in a project and location.
     * </pre>
     */
    public void listStreams(com.google.cloud.datastream.v1.ListStreamsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datastream.v1.ListStreamsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListStreamsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Use this method to get details about a stream.
     * </pre>
     */
    public void getStream(com.google.cloud.datastream.v1.GetStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datastream.v1.Stream> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetStreamMethod(), responseObserver);
    }

    /**
     * <pre>
     * Use this method to create a stream.
     * </pre>
     */
    public void createStream(com.google.cloud.datastream.v1.CreateStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateStreamMethod(), responseObserver);
    }

    /**
     * <pre>
     * Use this method to update the configuration of a stream.
     * </pre>
     */
    public void updateStream(com.google.cloud.datastream.v1.UpdateStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateStreamMethod(), responseObserver);
    }

    /**
     * <pre>
     * Use this method to delete a stream.
     * </pre>
     */
    public void deleteStream(com.google.cloud.datastream.v1.DeleteStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteStreamMethod(), responseObserver);
    }

    /**
     * <pre>
     * Use this method to get details about a stream object.
     * </pre>
     */
    public void getStreamObject(com.google.cloud.datastream.v1.GetStreamObjectRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datastream.v1.StreamObject> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetStreamObjectMethod(), responseObserver);
    }

    /**
     * <pre>
     * Use this method to look up a stream object by its source object identifier.
     * </pre>
     */
    public void lookupStreamObject(com.google.cloud.datastream.v1.LookupStreamObjectRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datastream.v1.StreamObject> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLookupStreamObjectMethod(), responseObserver);
    }

    /**
     * <pre>
     * Use this method to list the objects of a specific stream.
     * </pre>
     */
    public void listStreamObjects(com.google.cloud.datastream.v1.ListStreamObjectsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datastream.v1.ListStreamObjectsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListStreamObjectsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Use this method to start a backfill job for the specified stream object.
     * </pre>
     */
    public void startBackfillJob(com.google.cloud.datastream.v1.StartBackfillJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datastream.v1.StartBackfillJobResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStartBackfillJobMethod(), responseObserver);
    }

    /**
     * <pre>
     * Use this method to stop a backfill job for the specified stream object.
     * </pre>
     */
    public void stopBackfillJob(com.google.cloud.datastream.v1.StopBackfillJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datastream.v1.StopBackfillJobResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStopBackfillJobMethod(), responseObserver);
    }

    /**
     * <pre>
     * The FetchStaticIps API call exposes the static IP addresses used by
     * Datastream.
     * </pre>
     */
    public void fetchStaticIps(com.google.cloud.datastream.v1.FetchStaticIpsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datastream.v1.FetchStaticIpsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFetchStaticIpsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Use this method to create a private connectivity configuration.
     * </pre>
     */
    public void createPrivateConnection(com.google.cloud.datastream.v1.CreatePrivateConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreatePrivateConnectionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Use this method to get details about a private connectivity configuration.
     * </pre>
     */
    public void getPrivateConnection(com.google.cloud.datastream.v1.GetPrivateConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datastream.v1.PrivateConnection> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetPrivateConnectionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Use this method to list private connectivity configurations in a project
     * and location.
     * </pre>
     */
    public void listPrivateConnections(com.google.cloud.datastream.v1.ListPrivateConnectionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datastream.v1.ListPrivateConnectionsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListPrivateConnectionsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Use this method to delete a private connectivity configuration.
     * </pre>
     */
    public void deletePrivateConnection(com.google.cloud.datastream.v1.DeletePrivateConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeletePrivateConnectionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Use this method to create a route for a private connectivity configuration
     * in a project and location.
     * </pre>
     */
    public void createRoute(com.google.cloud.datastream.v1.CreateRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateRouteMethod(), responseObserver);
    }

    /**
     * <pre>
     * Use this method to get details about a route.
     * </pre>
     */
    public void getRoute(com.google.cloud.datastream.v1.GetRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datastream.v1.Route> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetRouteMethod(), responseObserver);
    }

    /**
     * <pre>
     * Use this method to list routes created for a private connectivity
     * configuration in a project and location.
     * </pre>
     */
    public void listRoutes(com.google.cloud.datastream.v1.ListRoutesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datastream.v1.ListRoutesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListRoutesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Use this method to delete a route.
     * </pre>
     */
    public void deleteRoute(com.google.cloud.datastream.v1.DeleteRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteRouteMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListConnectionProfilesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.datastream.v1.ListConnectionProfilesRequest,
                com.google.cloud.datastream.v1.ListConnectionProfilesResponse>(
                  this, METHODID_LIST_CONNECTION_PROFILES)))
          .addMethod(
            getGetConnectionProfileMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.datastream.v1.GetConnectionProfileRequest,
                com.google.cloud.datastream.v1.ConnectionProfile>(
                  this, METHODID_GET_CONNECTION_PROFILE)))
          .addMethod(
            getCreateConnectionProfileMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.datastream.v1.CreateConnectionProfileRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_CONNECTION_PROFILE)))
          .addMethod(
            getUpdateConnectionProfileMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.datastream.v1.UpdateConnectionProfileRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_CONNECTION_PROFILE)))
          .addMethod(
            getDeleteConnectionProfileMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.datastream.v1.DeleteConnectionProfileRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_CONNECTION_PROFILE)))
          .addMethod(
            getDiscoverConnectionProfileMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.datastream.v1.DiscoverConnectionProfileRequest,
                com.google.cloud.datastream.v1.DiscoverConnectionProfileResponse>(
                  this, METHODID_DISCOVER_CONNECTION_PROFILE)))
          .addMethod(
            getListStreamsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.datastream.v1.ListStreamsRequest,
                com.google.cloud.datastream.v1.ListStreamsResponse>(
                  this, METHODID_LIST_STREAMS)))
          .addMethod(
            getGetStreamMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.datastream.v1.GetStreamRequest,
                com.google.cloud.datastream.v1.Stream>(
                  this, METHODID_GET_STREAM)))
          .addMethod(
            getCreateStreamMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.datastream.v1.CreateStreamRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_STREAM)))
          .addMethod(
            getUpdateStreamMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.datastream.v1.UpdateStreamRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_STREAM)))
          .addMethod(
            getDeleteStreamMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.datastream.v1.DeleteStreamRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_STREAM)))
          .addMethod(
            getGetStreamObjectMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.datastream.v1.GetStreamObjectRequest,
                com.google.cloud.datastream.v1.StreamObject>(
                  this, METHODID_GET_STREAM_OBJECT)))
          .addMethod(
            getLookupStreamObjectMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.datastream.v1.LookupStreamObjectRequest,
                com.google.cloud.datastream.v1.StreamObject>(
                  this, METHODID_LOOKUP_STREAM_OBJECT)))
          .addMethod(
            getListStreamObjectsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.datastream.v1.ListStreamObjectsRequest,
                com.google.cloud.datastream.v1.ListStreamObjectsResponse>(
                  this, METHODID_LIST_STREAM_OBJECTS)))
          .addMethod(
            getStartBackfillJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.datastream.v1.StartBackfillJobRequest,
                com.google.cloud.datastream.v1.StartBackfillJobResponse>(
                  this, METHODID_START_BACKFILL_JOB)))
          .addMethod(
            getStopBackfillJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.datastream.v1.StopBackfillJobRequest,
                com.google.cloud.datastream.v1.StopBackfillJobResponse>(
                  this, METHODID_STOP_BACKFILL_JOB)))
          .addMethod(
            getFetchStaticIpsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.datastream.v1.FetchStaticIpsRequest,
                com.google.cloud.datastream.v1.FetchStaticIpsResponse>(
                  this, METHODID_FETCH_STATIC_IPS)))
          .addMethod(
            getCreatePrivateConnectionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.datastream.v1.CreatePrivateConnectionRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_PRIVATE_CONNECTION)))
          .addMethod(
            getGetPrivateConnectionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.datastream.v1.GetPrivateConnectionRequest,
                com.google.cloud.datastream.v1.PrivateConnection>(
                  this, METHODID_GET_PRIVATE_CONNECTION)))
          .addMethod(
            getListPrivateConnectionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.datastream.v1.ListPrivateConnectionsRequest,
                com.google.cloud.datastream.v1.ListPrivateConnectionsResponse>(
                  this, METHODID_LIST_PRIVATE_CONNECTIONS)))
          .addMethod(
            getDeletePrivateConnectionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.datastream.v1.DeletePrivateConnectionRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_PRIVATE_CONNECTION)))
          .addMethod(
            getCreateRouteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.datastream.v1.CreateRouteRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_ROUTE)))
          .addMethod(
            getGetRouteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.datastream.v1.GetRouteRequest,
                com.google.cloud.datastream.v1.Route>(
                  this, METHODID_GET_ROUTE)))
          .addMethod(
            getListRoutesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.datastream.v1.ListRoutesRequest,
                com.google.cloud.datastream.v1.ListRoutesResponse>(
                  this, METHODID_LIST_ROUTES)))
          .addMethod(
            getDeleteRouteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.datastream.v1.DeleteRouteRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_ROUTE)))
          .build();
    }
  }

  /**
   * <pre>
   * Datastream service
   * </pre>
   */
  public static final class DatastreamStub extends io.grpc.stub.AbstractAsyncStub<DatastreamStub> {
    private DatastreamStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DatastreamStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DatastreamStub(channel, callOptions);
    }

    /**
     * <pre>
     * Use this method to list connection profiles created in a project and
     * location.
     * </pre>
     */
    public void listConnectionProfiles(com.google.cloud.datastream.v1.ListConnectionProfilesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datastream.v1.ListConnectionProfilesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListConnectionProfilesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Use this method to get details about a connection profile.
     * </pre>
     */
    public void getConnectionProfile(com.google.cloud.datastream.v1.GetConnectionProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datastream.v1.ConnectionProfile> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetConnectionProfileMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Use this method to create a connection profile in a project and location.
     * </pre>
     */
    public void createConnectionProfile(com.google.cloud.datastream.v1.CreateConnectionProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateConnectionProfileMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Use this method to update the parameters of a connection profile.
     * </pre>
     */
    public void updateConnectionProfile(com.google.cloud.datastream.v1.UpdateConnectionProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateConnectionProfileMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Use this method to delete a connection profile.
     * </pre>
     */
    public void deleteConnectionProfile(com.google.cloud.datastream.v1.DeleteConnectionProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteConnectionProfileMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Use this method to discover a connection profile.
     * The discover API call exposes the data objects and metadata belonging to
     * the profile. Typically, a request returns children data objects of a
     * parent data object that's optionally supplied in the request.
     * </pre>
     */
    public void discoverConnectionProfile(com.google.cloud.datastream.v1.DiscoverConnectionProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datastream.v1.DiscoverConnectionProfileResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDiscoverConnectionProfileMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Use this method to list streams in a project and location.
     * </pre>
     */
    public void listStreams(com.google.cloud.datastream.v1.ListStreamsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datastream.v1.ListStreamsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListStreamsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Use this method to get details about a stream.
     * </pre>
     */
    public void getStream(com.google.cloud.datastream.v1.GetStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datastream.v1.Stream> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetStreamMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Use this method to create a stream.
     * </pre>
     */
    public void createStream(com.google.cloud.datastream.v1.CreateStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateStreamMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Use this method to update the configuration of a stream.
     * </pre>
     */
    public void updateStream(com.google.cloud.datastream.v1.UpdateStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateStreamMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Use this method to delete a stream.
     * </pre>
     */
    public void deleteStream(com.google.cloud.datastream.v1.DeleteStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteStreamMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Use this method to get details about a stream object.
     * </pre>
     */
    public void getStreamObject(com.google.cloud.datastream.v1.GetStreamObjectRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datastream.v1.StreamObject> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetStreamObjectMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Use this method to look up a stream object by its source object identifier.
     * </pre>
     */
    public void lookupStreamObject(com.google.cloud.datastream.v1.LookupStreamObjectRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datastream.v1.StreamObject> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLookupStreamObjectMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Use this method to list the objects of a specific stream.
     * </pre>
     */
    public void listStreamObjects(com.google.cloud.datastream.v1.ListStreamObjectsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datastream.v1.ListStreamObjectsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListStreamObjectsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Use this method to start a backfill job for the specified stream object.
     * </pre>
     */
    public void startBackfillJob(com.google.cloud.datastream.v1.StartBackfillJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datastream.v1.StartBackfillJobResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartBackfillJobMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Use this method to stop a backfill job for the specified stream object.
     * </pre>
     */
    public void stopBackfillJob(com.google.cloud.datastream.v1.StopBackfillJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datastream.v1.StopBackfillJobResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStopBackfillJobMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * The FetchStaticIps API call exposes the static IP addresses used by
     * Datastream.
     * </pre>
     */
    public void fetchStaticIps(com.google.cloud.datastream.v1.FetchStaticIpsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datastream.v1.FetchStaticIpsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFetchStaticIpsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Use this method to create a private connectivity configuration.
     * </pre>
     */
    public void createPrivateConnection(com.google.cloud.datastream.v1.CreatePrivateConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreatePrivateConnectionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Use this method to get details about a private connectivity configuration.
     * </pre>
     */
    public void getPrivateConnection(com.google.cloud.datastream.v1.GetPrivateConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datastream.v1.PrivateConnection> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPrivateConnectionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Use this method to list private connectivity configurations in a project
     * and location.
     * </pre>
     */
    public void listPrivateConnections(com.google.cloud.datastream.v1.ListPrivateConnectionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datastream.v1.ListPrivateConnectionsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPrivateConnectionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Use this method to delete a private connectivity configuration.
     * </pre>
     */
    public void deletePrivateConnection(com.google.cloud.datastream.v1.DeletePrivateConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeletePrivateConnectionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Use this method to create a route for a private connectivity configuration
     * in a project and location.
     * </pre>
     */
    public void createRoute(com.google.cloud.datastream.v1.CreateRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateRouteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Use this method to get details about a route.
     * </pre>
     */
    public void getRoute(com.google.cloud.datastream.v1.GetRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datastream.v1.Route> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRouteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Use this method to list routes created for a private connectivity
     * configuration in a project and location.
     * </pre>
     */
    public void listRoutes(com.google.cloud.datastream.v1.ListRoutesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datastream.v1.ListRoutesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRoutesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Use this method to delete a route.
     * </pre>
     */
    public void deleteRoute(com.google.cloud.datastream.v1.DeleteRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteRouteMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Datastream service
   * </pre>
   */
  public static final class DatastreamBlockingStub extends io.grpc.stub.AbstractBlockingStub<DatastreamBlockingStub> {
    private DatastreamBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DatastreamBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DatastreamBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Use this method to list connection profiles created in a project and
     * location.
     * </pre>
     */
    public com.google.cloud.datastream.v1.ListConnectionProfilesResponse listConnectionProfiles(com.google.cloud.datastream.v1.ListConnectionProfilesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListConnectionProfilesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Use this method to get details about a connection profile.
     * </pre>
     */
    public com.google.cloud.datastream.v1.ConnectionProfile getConnectionProfile(com.google.cloud.datastream.v1.GetConnectionProfileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetConnectionProfileMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Use this method to create a connection profile in a project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createConnectionProfile(com.google.cloud.datastream.v1.CreateConnectionProfileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateConnectionProfileMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Use this method to update the parameters of a connection profile.
     * </pre>
     */
    public com.google.longrunning.Operation updateConnectionProfile(com.google.cloud.datastream.v1.UpdateConnectionProfileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateConnectionProfileMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Use this method to delete a connection profile.
     * </pre>
     */
    public com.google.longrunning.Operation deleteConnectionProfile(com.google.cloud.datastream.v1.DeleteConnectionProfileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteConnectionProfileMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Use this method to discover a connection profile.
     * The discover API call exposes the data objects and metadata belonging to
     * the profile. Typically, a request returns children data objects of a
     * parent data object that's optionally supplied in the request.
     * </pre>
     */
    public com.google.cloud.datastream.v1.DiscoverConnectionProfileResponse discoverConnectionProfile(com.google.cloud.datastream.v1.DiscoverConnectionProfileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDiscoverConnectionProfileMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Use this method to list streams in a project and location.
     * </pre>
     */
    public com.google.cloud.datastream.v1.ListStreamsResponse listStreams(com.google.cloud.datastream.v1.ListStreamsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListStreamsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Use this method to get details about a stream.
     * </pre>
     */
    public com.google.cloud.datastream.v1.Stream getStream(com.google.cloud.datastream.v1.GetStreamRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetStreamMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Use this method to create a stream.
     * </pre>
     */
    public com.google.longrunning.Operation createStream(com.google.cloud.datastream.v1.CreateStreamRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateStreamMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Use this method to update the configuration of a stream.
     * </pre>
     */
    public com.google.longrunning.Operation updateStream(com.google.cloud.datastream.v1.UpdateStreamRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateStreamMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Use this method to delete a stream.
     * </pre>
     */
    public com.google.longrunning.Operation deleteStream(com.google.cloud.datastream.v1.DeleteStreamRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteStreamMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Use this method to get details about a stream object.
     * </pre>
     */
    public com.google.cloud.datastream.v1.StreamObject getStreamObject(com.google.cloud.datastream.v1.GetStreamObjectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetStreamObjectMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Use this method to look up a stream object by its source object identifier.
     * </pre>
     */
    public com.google.cloud.datastream.v1.StreamObject lookupStreamObject(com.google.cloud.datastream.v1.LookupStreamObjectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLookupStreamObjectMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Use this method to list the objects of a specific stream.
     * </pre>
     */
    public com.google.cloud.datastream.v1.ListStreamObjectsResponse listStreamObjects(com.google.cloud.datastream.v1.ListStreamObjectsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListStreamObjectsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Use this method to start a backfill job for the specified stream object.
     * </pre>
     */
    public com.google.cloud.datastream.v1.StartBackfillJobResponse startBackfillJob(com.google.cloud.datastream.v1.StartBackfillJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartBackfillJobMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Use this method to stop a backfill job for the specified stream object.
     * </pre>
     */
    public com.google.cloud.datastream.v1.StopBackfillJobResponse stopBackfillJob(com.google.cloud.datastream.v1.StopBackfillJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStopBackfillJobMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * The FetchStaticIps API call exposes the static IP addresses used by
     * Datastream.
     * </pre>
     */
    public com.google.cloud.datastream.v1.FetchStaticIpsResponse fetchStaticIps(com.google.cloud.datastream.v1.FetchStaticIpsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchStaticIpsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Use this method to create a private connectivity configuration.
     * </pre>
     */
    public com.google.longrunning.Operation createPrivateConnection(com.google.cloud.datastream.v1.CreatePrivateConnectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePrivateConnectionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Use this method to get details about a private connectivity configuration.
     * </pre>
     */
    public com.google.cloud.datastream.v1.PrivateConnection getPrivateConnection(com.google.cloud.datastream.v1.GetPrivateConnectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPrivateConnectionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Use this method to list private connectivity configurations in a project
     * and location.
     * </pre>
     */
    public com.google.cloud.datastream.v1.ListPrivateConnectionsResponse listPrivateConnections(com.google.cloud.datastream.v1.ListPrivateConnectionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPrivateConnectionsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Use this method to delete a private connectivity configuration.
     * </pre>
     */
    public com.google.longrunning.Operation deletePrivateConnection(com.google.cloud.datastream.v1.DeletePrivateConnectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeletePrivateConnectionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Use this method to create a route for a private connectivity configuration
     * in a project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createRoute(com.google.cloud.datastream.v1.CreateRouteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateRouteMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Use this method to get details about a route.
     * </pre>
     */
    public com.google.cloud.datastream.v1.Route getRoute(com.google.cloud.datastream.v1.GetRouteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRouteMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Use this method to list routes created for a private connectivity
     * configuration in a project and location.
     * </pre>
     */
    public com.google.cloud.datastream.v1.ListRoutesResponse listRoutes(com.google.cloud.datastream.v1.ListRoutesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRoutesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Use this method to delete a route.
     * </pre>
     */
    public com.google.longrunning.Operation deleteRoute(com.google.cloud.datastream.v1.DeleteRouteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteRouteMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Datastream service
   * </pre>
   */
  public static final class DatastreamFutureStub extends io.grpc.stub.AbstractFutureStub<DatastreamFutureStub> {
    private DatastreamFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DatastreamFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DatastreamFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Use this method to list connection profiles created in a project and
     * location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.datastream.v1.ListConnectionProfilesResponse> listConnectionProfiles(
        com.google.cloud.datastream.v1.ListConnectionProfilesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListConnectionProfilesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Use this method to get details about a connection profile.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.datastream.v1.ConnectionProfile> getConnectionProfile(
        com.google.cloud.datastream.v1.GetConnectionProfileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetConnectionProfileMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Use this method to create a connection profile in a project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createConnectionProfile(
        com.google.cloud.datastream.v1.CreateConnectionProfileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateConnectionProfileMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Use this method to update the parameters of a connection profile.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateConnectionProfile(
        com.google.cloud.datastream.v1.UpdateConnectionProfileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateConnectionProfileMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Use this method to delete a connection profile.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteConnectionProfile(
        com.google.cloud.datastream.v1.DeleteConnectionProfileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteConnectionProfileMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Use this method to discover a connection profile.
     * The discover API call exposes the data objects and metadata belonging to
     * the profile. Typically, a request returns children data objects of a
     * parent data object that's optionally supplied in the request.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.datastream.v1.DiscoverConnectionProfileResponse> discoverConnectionProfile(
        com.google.cloud.datastream.v1.DiscoverConnectionProfileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDiscoverConnectionProfileMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Use this method to list streams in a project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.datastream.v1.ListStreamsResponse> listStreams(
        com.google.cloud.datastream.v1.ListStreamsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListStreamsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Use this method to get details about a stream.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.datastream.v1.Stream> getStream(
        com.google.cloud.datastream.v1.GetStreamRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetStreamMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Use this method to create a stream.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createStream(
        com.google.cloud.datastream.v1.CreateStreamRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateStreamMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Use this method to update the configuration of a stream.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateStream(
        com.google.cloud.datastream.v1.UpdateStreamRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateStreamMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Use this method to delete a stream.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteStream(
        com.google.cloud.datastream.v1.DeleteStreamRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteStreamMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Use this method to get details about a stream object.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.datastream.v1.StreamObject> getStreamObject(
        com.google.cloud.datastream.v1.GetStreamObjectRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetStreamObjectMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Use this method to look up a stream object by its source object identifier.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.datastream.v1.StreamObject> lookupStreamObject(
        com.google.cloud.datastream.v1.LookupStreamObjectRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLookupStreamObjectMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Use this method to list the objects of a specific stream.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.datastream.v1.ListStreamObjectsResponse> listStreamObjects(
        com.google.cloud.datastream.v1.ListStreamObjectsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListStreamObjectsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Use this method to start a backfill job for the specified stream object.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.datastream.v1.StartBackfillJobResponse> startBackfillJob(
        com.google.cloud.datastream.v1.StartBackfillJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartBackfillJobMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Use this method to stop a backfill job for the specified stream object.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.datastream.v1.StopBackfillJobResponse> stopBackfillJob(
        com.google.cloud.datastream.v1.StopBackfillJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStopBackfillJobMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * The FetchStaticIps API call exposes the static IP addresses used by
     * Datastream.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.datastream.v1.FetchStaticIpsResponse> fetchStaticIps(
        com.google.cloud.datastream.v1.FetchStaticIpsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFetchStaticIpsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Use this method to create a private connectivity configuration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createPrivateConnection(
        com.google.cloud.datastream.v1.CreatePrivateConnectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreatePrivateConnectionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Use this method to get details about a private connectivity configuration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.datastream.v1.PrivateConnection> getPrivateConnection(
        com.google.cloud.datastream.v1.GetPrivateConnectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPrivateConnectionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Use this method to list private connectivity configurations in a project
     * and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.datastream.v1.ListPrivateConnectionsResponse> listPrivateConnections(
        com.google.cloud.datastream.v1.ListPrivateConnectionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPrivateConnectionsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Use this method to delete a private connectivity configuration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deletePrivateConnection(
        com.google.cloud.datastream.v1.DeletePrivateConnectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeletePrivateConnectionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Use this method to create a route for a private connectivity configuration
     * in a project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createRoute(
        com.google.cloud.datastream.v1.CreateRouteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateRouteMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Use this method to get details about a route.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.datastream.v1.Route> getRoute(
        com.google.cloud.datastream.v1.GetRouteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRouteMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Use this method to list routes created for a private connectivity
     * configuration in a project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.datastream.v1.ListRoutesResponse> listRoutes(
        com.google.cloud.datastream.v1.ListRoutesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRoutesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Use this method to delete a route.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteRoute(
        com.google.cloud.datastream.v1.DeleteRouteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteRouteMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_CONNECTION_PROFILES = 0;
  private static final int METHODID_GET_CONNECTION_PROFILE = 1;
  private static final int METHODID_CREATE_CONNECTION_PROFILE = 2;
  private static final int METHODID_UPDATE_CONNECTION_PROFILE = 3;
  private static final int METHODID_DELETE_CONNECTION_PROFILE = 4;
  private static final int METHODID_DISCOVER_CONNECTION_PROFILE = 5;
  private static final int METHODID_LIST_STREAMS = 6;
  private static final int METHODID_GET_STREAM = 7;
  private static final int METHODID_CREATE_STREAM = 8;
  private static final int METHODID_UPDATE_STREAM = 9;
  private static final int METHODID_DELETE_STREAM = 10;
  private static final int METHODID_GET_STREAM_OBJECT = 11;
  private static final int METHODID_LOOKUP_STREAM_OBJECT = 12;
  private static final int METHODID_LIST_STREAM_OBJECTS = 13;
  private static final int METHODID_START_BACKFILL_JOB = 14;
  private static final int METHODID_STOP_BACKFILL_JOB = 15;
  private static final int METHODID_FETCH_STATIC_IPS = 16;
  private static final int METHODID_CREATE_PRIVATE_CONNECTION = 17;
  private static final int METHODID_GET_PRIVATE_CONNECTION = 18;
  private static final int METHODID_LIST_PRIVATE_CONNECTIONS = 19;
  private static final int METHODID_DELETE_PRIVATE_CONNECTION = 20;
  private static final int METHODID_CREATE_ROUTE = 21;
  private static final int METHODID_GET_ROUTE = 22;
  private static final int METHODID_LIST_ROUTES = 23;
  private static final int METHODID_DELETE_ROUTE = 24;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DatastreamImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DatastreamImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_CONNECTION_PROFILES:
          serviceImpl.listConnectionProfiles((com.google.cloud.datastream.v1.ListConnectionProfilesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datastream.v1.ListConnectionProfilesResponse>) responseObserver);
          break;
        case METHODID_GET_CONNECTION_PROFILE:
          serviceImpl.getConnectionProfile((com.google.cloud.datastream.v1.GetConnectionProfileRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datastream.v1.ConnectionProfile>) responseObserver);
          break;
        case METHODID_CREATE_CONNECTION_PROFILE:
          serviceImpl.createConnectionProfile((com.google.cloud.datastream.v1.CreateConnectionProfileRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_CONNECTION_PROFILE:
          serviceImpl.updateConnectionProfile((com.google.cloud.datastream.v1.UpdateConnectionProfileRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_CONNECTION_PROFILE:
          serviceImpl.deleteConnectionProfile((com.google.cloud.datastream.v1.DeleteConnectionProfileRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DISCOVER_CONNECTION_PROFILE:
          serviceImpl.discoverConnectionProfile((com.google.cloud.datastream.v1.DiscoverConnectionProfileRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datastream.v1.DiscoverConnectionProfileResponse>) responseObserver);
          break;
        case METHODID_LIST_STREAMS:
          serviceImpl.listStreams((com.google.cloud.datastream.v1.ListStreamsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datastream.v1.ListStreamsResponse>) responseObserver);
          break;
        case METHODID_GET_STREAM:
          serviceImpl.getStream((com.google.cloud.datastream.v1.GetStreamRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datastream.v1.Stream>) responseObserver);
          break;
        case METHODID_CREATE_STREAM:
          serviceImpl.createStream((com.google.cloud.datastream.v1.CreateStreamRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_STREAM:
          serviceImpl.updateStream((com.google.cloud.datastream.v1.UpdateStreamRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_STREAM:
          serviceImpl.deleteStream((com.google.cloud.datastream.v1.DeleteStreamRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_STREAM_OBJECT:
          serviceImpl.getStreamObject((com.google.cloud.datastream.v1.GetStreamObjectRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datastream.v1.StreamObject>) responseObserver);
          break;
        case METHODID_LOOKUP_STREAM_OBJECT:
          serviceImpl.lookupStreamObject((com.google.cloud.datastream.v1.LookupStreamObjectRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datastream.v1.StreamObject>) responseObserver);
          break;
        case METHODID_LIST_STREAM_OBJECTS:
          serviceImpl.listStreamObjects((com.google.cloud.datastream.v1.ListStreamObjectsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datastream.v1.ListStreamObjectsResponse>) responseObserver);
          break;
        case METHODID_START_BACKFILL_JOB:
          serviceImpl.startBackfillJob((com.google.cloud.datastream.v1.StartBackfillJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datastream.v1.StartBackfillJobResponse>) responseObserver);
          break;
        case METHODID_STOP_BACKFILL_JOB:
          serviceImpl.stopBackfillJob((com.google.cloud.datastream.v1.StopBackfillJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datastream.v1.StopBackfillJobResponse>) responseObserver);
          break;
        case METHODID_FETCH_STATIC_IPS:
          serviceImpl.fetchStaticIps((com.google.cloud.datastream.v1.FetchStaticIpsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datastream.v1.FetchStaticIpsResponse>) responseObserver);
          break;
        case METHODID_CREATE_PRIVATE_CONNECTION:
          serviceImpl.createPrivateConnection((com.google.cloud.datastream.v1.CreatePrivateConnectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_PRIVATE_CONNECTION:
          serviceImpl.getPrivateConnection((com.google.cloud.datastream.v1.GetPrivateConnectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datastream.v1.PrivateConnection>) responseObserver);
          break;
        case METHODID_LIST_PRIVATE_CONNECTIONS:
          serviceImpl.listPrivateConnections((com.google.cloud.datastream.v1.ListPrivateConnectionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datastream.v1.ListPrivateConnectionsResponse>) responseObserver);
          break;
        case METHODID_DELETE_PRIVATE_CONNECTION:
          serviceImpl.deletePrivateConnection((com.google.cloud.datastream.v1.DeletePrivateConnectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_ROUTE:
          serviceImpl.createRoute((com.google.cloud.datastream.v1.CreateRouteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_ROUTE:
          serviceImpl.getRoute((com.google.cloud.datastream.v1.GetRouteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datastream.v1.Route>) responseObserver);
          break;
        case METHODID_LIST_ROUTES:
          serviceImpl.listRoutes((com.google.cloud.datastream.v1.ListRoutesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datastream.v1.ListRoutesResponse>) responseObserver);
          break;
        case METHODID_DELETE_ROUTE:
          serviceImpl.deleteRoute((com.google.cloud.datastream.v1.DeleteRouteRequest) request,
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

  private static abstract class DatastreamBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DatastreamBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.datastream.v1.DatastreamProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Datastream");
    }
  }

  private static final class DatastreamFileDescriptorSupplier
      extends DatastreamBaseDescriptorSupplier {
    DatastreamFileDescriptorSupplier() {}
  }

  private static final class DatastreamMethodDescriptorSupplier
      extends DatastreamBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DatastreamMethodDescriptorSupplier(String methodName) {
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
      synchronized (DatastreamGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DatastreamFileDescriptorSupplier())
              .addMethod(getListConnectionProfilesMethod())
              .addMethod(getGetConnectionProfileMethod())
              .addMethod(getCreateConnectionProfileMethod())
              .addMethod(getUpdateConnectionProfileMethod())
              .addMethod(getDeleteConnectionProfileMethod())
              .addMethod(getDiscoverConnectionProfileMethod())
              .addMethod(getListStreamsMethod())
              .addMethod(getGetStreamMethod())
              .addMethod(getCreateStreamMethod())
              .addMethod(getUpdateStreamMethod())
              .addMethod(getDeleteStreamMethod())
              .addMethod(getGetStreamObjectMethod())
              .addMethod(getLookupStreamObjectMethod())
              .addMethod(getListStreamObjectsMethod())
              .addMethod(getStartBackfillJobMethod())
              .addMethod(getStopBackfillJobMethod())
              .addMethod(getFetchStaticIpsMethod())
              .addMethod(getCreatePrivateConnectionMethod())
              .addMethod(getGetPrivateConnectionMethod())
              .addMethod(getListPrivateConnectionsMethod())
              .addMethod(getDeletePrivateConnectionMethod())
              .addMethod(getCreateRouteMethod())
              .addMethod(getGetRouteMethod())
              .addMethod(getListRoutesMethod())
              .addMethod(getDeleteRouteMethod())
              .build();
        }
      }
    }
    return result;
  }
}
