/*
 * Copyright 2026 Google LLC
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
package com.google.cloud.gkehub.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The GKE Hub service handles the registration of many Kubernetes clusters to
 * Google Cloud, and the management of multi-cluster features over those
 * clusters.
 * The GKE Hub service operates on the following resources:
 * * [Membership][google.cloud.gkehub.v1.Membership]
 * * [Feature][google.cloud.gkehub.v1.Feature]
 * GKE Hub is currently available in the global region and all regions in
 * https://cloud.google.com/compute/docs/regions-zones. Feature is only
 * available in global region while membership is global region and all the
 * regions.
 * **Membership management may be non-trivial:** it is recommended to use one
 * of the Google-provided client libraries or tools where possible when working
 * with Membership resources.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class GkeHubGrpc {

  private GkeHubGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.gkehub.v1.GkeHub";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.ListMembershipsRequest,
          com.google.cloud.gkehub.v1.ListMembershipsResponse>
      getListMembershipsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMemberships",
      requestType = com.google.cloud.gkehub.v1.ListMembershipsRequest.class,
      responseType = com.google.cloud.gkehub.v1.ListMembershipsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.ListMembershipsRequest,
          com.google.cloud.gkehub.v1.ListMembershipsResponse>
      getListMembershipsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkehub.v1.ListMembershipsRequest,
            com.google.cloud.gkehub.v1.ListMembershipsResponse>
        getListMembershipsMethod;
    if ((getListMembershipsMethod = GkeHubGrpc.getListMembershipsMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getListMembershipsMethod = GkeHubGrpc.getListMembershipsMethod) == null) {
          GkeHubGrpc.getListMembershipsMethod =
              getListMembershipsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkehub.v1.ListMembershipsRequest,
                          com.google.cloud.gkehub.v1.ListMembershipsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListMemberships"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.ListMembershipsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.ListMembershipsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new GkeHubMethodDescriptorSupplier("ListMemberships"))
                      .build();
        }
      }
    }
    return getListMembershipsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.ListBoundMembershipsRequest,
          com.google.cloud.gkehub.v1.ListBoundMembershipsResponse>
      getListBoundMembershipsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBoundMemberships",
      requestType = com.google.cloud.gkehub.v1.ListBoundMembershipsRequest.class,
      responseType = com.google.cloud.gkehub.v1.ListBoundMembershipsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.ListBoundMembershipsRequest,
          com.google.cloud.gkehub.v1.ListBoundMembershipsResponse>
      getListBoundMembershipsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkehub.v1.ListBoundMembershipsRequest,
            com.google.cloud.gkehub.v1.ListBoundMembershipsResponse>
        getListBoundMembershipsMethod;
    if ((getListBoundMembershipsMethod = GkeHubGrpc.getListBoundMembershipsMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getListBoundMembershipsMethod = GkeHubGrpc.getListBoundMembershipsMethod) == null) {
          GkeHubGrpc.getListBoundMembershipsMethod =
              getListBoundMembershipsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkehub.v1.ListBoundMembershipsRequest,
                          com.google.cloud.gkehub.v1.ListBoundMembershipsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListBoundMemberships"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.ListBoundMembershipsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.ListBoundMembershipsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GkeHubMethodDescriptorSupplier("ListBoundMemberships"))
                      .build();
        }
      }
    }
    return getListBoundMembershipsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.ListFeaturesRequest,
          com.google.cloud.gkehub.v1.ListFeaturesResponse>
      getListFeaturesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFeatures",
      requestType = com.google.cloud.gkehub.v1.ListFeaturesRequest.class,
      responseType = com.google.cloud.gkehub.v1.ListFeaturesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.ListFeaturesRequest,
          com.google.cloud.gkehub.v1.ListFeaturesResponse>
      getListFeaturesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkehub.v1.ListFeaturesRequest,
            com.google.cloud.gkehub.v1.ListFeaturesResponse>
        getListFeaturesMethod;
    if ((getListFeaturesMethod = GkeHubGrpc.getListFeaturesMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getListFeaturesMethod = GkeHubGrpc.getListFeaturesMethod) == null) {
          GkeHubGrpc.getListFeaturesMethod =
              getListFeaturesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkehub.v1.ListFeaturesRequest,
                          com.google.cloud.gkehub.v1.ListFeaturesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListFeatures"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.ListFeaturesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.ListFeaturesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new GkeHubMethodDescriptorSupplier("ListFeatures"))
                      .build();
        }
      }
    }
    return getListFeaturesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.GetMembershipRequest, com.google.cloud.gkehub.v1.Membership>
      getGetMembershipMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMembership",
      requestType = com.google.cloud.gkehub.v1.GetMembershipRequest.class,
      responseType = com.google.cloud.gkehub.v1.Membership.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.GetMembershipRequest, com.google.cloud.gkehub.v1.Membership>
      getGetMembershipMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkehub.v1.GetMembershipRequest, com.google.cloud.gkehub.v1.Membership>
        getGetMembershipMethod;
    if ((getGetMembershipMethod = GkeHubGrpc.getGetMembershipMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getGetMembershipMethod = GkeHubGrpc.getGetMembershipMethod) == null) {
          GkeHubGrpc.getGetMembershipMethod =
              getGetMembershipMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkehub.v1.GetMembershipRequest,
                          com.google.cloud.gkehub.v1.Membership>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMembership"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.GetMembershipRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.Membership.getDefaultInstance()))
                      .setSchemaDescriptor(new GkeHubMethodDescriptorSupplier("GetMembership"))
                      .build();
        }
      }
    }
    return getGetMembershipMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.GetFeatureRequest, com.google.cloud.gkehub.v1.Feature>
      getGetFeatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFeature",
      requestType = com.google.cloud.gkehub.v1.GetFeatureRequest.class,
      responseType = com.google.cloud.gkehub.v1.Feature.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.GetFeatureRequest, com.google.cloud.gkehub.v1.Feature>
      getGetFeatureMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkehub.v1.GetFeatureRequest, com.google.cloud.gkehub.v1.Feature>
        getGetFeatureMethod;
    if ((getGetFeatureMethod = GkeHubGrpc.getGetFeatureMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getGetFeatureMethod = GkeHubGrpc.getGetFeatureMethod) == null) {
          GkeHubGrpc.getGetFeatureMethod =
              getGetFeatureMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkehub.v1.GetFeatureRequest,
                          com.google.cloud.gkehub.v1.Feature>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetFeature"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.GetFeatureRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.Feature.getDefaultInstance()))
                      .setSchemaDescriptor(new GkeHubMethodDescriptorSupplier("GetFeature"))
                      .build();
        }
      }
    }
    return getGetFeatureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.CreateMembershipRequest, com.google.longrunning.Operation>
      getCreateMembershipMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateMembership",
      requestType = com.google.cloud.gkehub.v1.CreateMembershipRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.CreateMembershipRequest, com.google.longrunning.Operation>
      getCreateMembershipMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkehub.v1.CreateMembershipRequest, com.google.longrunning.Operation>
        getCreateMembershipMethod;
    if ((getCreateMembershipMethod = GkeHubGrpc.getCreateMembershipMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getCreateMembershipMethod = GkeHubGrpc.getCreateMembershipMethod) == null) {
          GkeHubGrpc.getCreateMembershipMethod =
              getCreateMembershipMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkehub.v1.CreateMembershipRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateMembership"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.CreateMembershipRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new GkeHubMethodDescriptorSupplier("CreateMembership"))
                      .build();
        }
      }
    }
    return getCreateMembershipMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.CreateFeatureRequest, com.google.longrunning.Operation>
      getCreateFeatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateFeature",
      requestType = com.google.cloud.gkehub.v1.CreateFeatureRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.CreateFeatureRequest, com.google.longrunning.Operation>
      getCreateFeatureMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkehub.v1.CreateFeatureRequest, com.google.longrunning.Operation>
        getCreateFeatureMethod;
    if ((getCreateFeatureMethod = GkeHubGrpc.getCreateFeatureMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getCreateFeatureMethod = GkeHubGrpc.getCreateFeatureMethod) == null) {
          GkeHubGrpc.getCreateFeatureMethod =
              getCreateFeatureMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkehub.v1.CreateFeatureRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateFeature"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.CreateFeatureRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new GkeHubMethodDescriptorSupplier("CreateFeature"))
                      .build();
        }
      }
    }
    return getCreateFeatureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.DeleteMembershipRequest, com.google.longrunning.Operation>
      getDeleteMembershipMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteMembership",
      requestType = com.google.cloud.gkehub.v1.DeleteMembershipRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.DeleteMembershipRequest, com.google.longrunning.Operation>
      getDeleteMembershipMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkehub.v1.DeleteMembershipRequest, com.google.longrunning.Operation>
        getDeleteMembershipMethod;
    if ((getDeleteMembershipMethod = GkeHubGrpc.getDeleteMembershipMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getDeleteMembershipMethod = GkeHubGrpc.getDeleteMembershipMethod) == null) {
          GkeHubGrpc.getDeleteMembershipMethod =
              getDeleteMembershipMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkehub.v1.DeleteMembershipRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteMembership"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.DeleteMembershipRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new GkeHubMethodDescriptorSupplier("DeleteMembership"))
                      .build();
        }
      }
    }
    return getDeleteMembershipMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.DeleteFeatureRequest, com.google.longrunning.Operation>
      getDeleteFeatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteFeature",
      requestType = com.google.cloud.gkehub.v1.DeleteFeatureRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.DeleteFeatureRequest, com.google.longrunning.Operation>
      getDeleteFeatureMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkehub.v1.DeleteFeatureRequest, com.google.longrunning.Operation>
        getDeleteFeatureMethod;
    if ((getDeleteFeatureMethod = GkeHubGrpc.getDeleteFeatureMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getDeleteFeatureMethod = GkeHubGrpc.getDeleteFeatureMethod) == null) {
          GkeHubGrpc.getDeleteFeatureMethod =
              getDeleteFeatureMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkehub.v1.DeleteFeatureRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteFeature"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.DeleteFeatureRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new GkeHubMethodDescriptorSupplier("DeleteFeature"))
                      .build();
        }
      }
    }
    return getDeleteFeatureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.UpdateMembershipRequest, com.google.longrunning.Operation>
      getUpdateMembershipMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateMembership",
      requestType = com.google.cloud.gkehub.v1.UpdateMembershipRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.UpdateMembershipRequest, com.google.longrunning.Operation>
      getUpdateMembershipMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkehub.v1.UpdateMembershipRequest, com.google.longrunning.Operation>
        getUpdateMembershipMethod;
    if ((getUpdateMembershipMethod = GkeHubGrpc.getUpdateMembershipMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getUpdateMembershipMethod = GkeHubGrpc.getUpdateMembershipMethod) == null) {
          GkeHubGrpc.getUpdateMembershipMethod =
              getUpdateMembershipMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkehub.v1.UpdateMembershipRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateMembership"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.UpdateMembershipRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new GkeHubMethodDescriptorSupplier("UpdateMembership"))
                      .build();
        }
      }
    }
    return getUpdateMembershipMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.UpdateFeatureRequest, com.google.longrunning.Operation>
      getUpdateFeatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateFeature",
      requestType = com.google.cloud.gkehub.v1.UpdateFeatureRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.UpdateFeatureRequest, com.google.longrunning.Operation>
      getUpdateFeatureMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkehub.v1.UpdateFeatureRequest, com.google.longrunning.Operation>
        getUpdateFeatureMethod;
    if ((getUpdateFeatureMethod = GkeHubGrpc.getUpdateFeatureMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getUpdateFeatureMethod = GkeHubGrpc.getUpdateFeatureMethod) == null) {
          GkeHubGrpc.getUpdateFeatureMethod =
              getUpdateFeatureMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkehub.v1.UpdateFeatureRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateFeature"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.UpdateFeatureRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new GkeHubMethodDescriptorSupplier("UpdateFeature"))
                      .build();
        }
      }
    }
    return getUpdateFeatureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.GenerateConnectManifestRequest,
          com.google.cloud.gkehub.v1.GenerateConnectManifestResponse>
      getGenerateConnectManifestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateConnectManifest",
      requestType = com.google.cloud.gkehub.v1.GenerateConnectManifestRequest.class,
      responseType = com.google.cloud.gkehub.v1.GenerateConnectManifestResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.GenerateConnectManifestRequest,
          com.google.cloud.gkehub.v1.GenerateConnectManifestResponse>
      getGenerateConnectManifestMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkehub.v1.GenerateConnectManifestRequest,
            com.google.cloud.gkehub.v1.GenerateConnectManifestResponse>
        getGenerateConnectManifestMethod;
    if ((getGenerateConnectManifestMethod = GkeHubGrpc.getGenerateConnectManifestMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getGenerateConnectManifestMethod = GkeHubGrpc.getGenerateConnectManifestMethod)
            == null) {
          GkeHubGrpc.getGenerateConnectManifestMethod =
              getGenerateConnectManifestMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkehub.v1.GenerateConnectManifestRequest,
                          com.google.cloud.gkehub.v1.GenerateConnectManifestResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GenerateConnectManifest"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.GenerateConnectManifestRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.GenerateConnectManifestResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GkeHubMethodDescriptorSupplier("GenerateConnectManifest"))
                      .build();
        }
      }
    }
    return getGenerateConnectManifestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.CreateFleetRequest, com.google.longrunning.Operation>
      getCreateFleetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateFleet",
      requestType = com.google.cloud.gkehub.v1.CreateFleetRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.CreateFleetRequest, com.google.longrunning.Operation>
      getCreateFleetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkehub.v1.CreateFleetRequest, com.google.longrunning.Operation>
        getCreateFleetMethod;
    if ((getCreateFleetMethod = GkeHubGrpc.getCreateFleetMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getCreateFleetMethod = GkeHubGrpc.getCreateFleetMethod) == null) {
          GkeHubGrpc.getCreateFleetMethod =
              getCreateFleetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkehub.v1.CreateFleetRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateFleet"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.CreateFleetRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new GkeHubMethodDescriptorSupplier("CreateFleet"))
                      .build();
        }
      }
    }
    return getCreateFleetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.GetFleetRequest, com.google.cloud.gkehub.v1.Fleet>
      getGetFleetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFleet",
      requestType = com.google.cloud.gkehub.v1.GetFleetRequest.class,
      responseType = com.google.cloud.gkehub.v1.Fleet.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.GetFleetRequest, com.google.cloud.gkehub.v1.Fleet>
      getGetFleetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkehub.v1.GetFleetRequest, com.google.cloud.gkehub.v1.Fleet>
        getGetFleetMethod;
    if ((getGetFleetMethod = GkeHubGrpc.getGetFleetMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getGetFleetMethod = GkeHubGrpc.getGetFleetMethod) == null) {
          GkeHubGrpc.getGetFleetMethod =
              getGetFleetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkehub.v1.GetFleetRequest,
                          com.google.cloud.gkehub.v1.Fleet>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetFleet"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.GetFleetRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.Fleet.getDefaultInstance()))
                      .setSchemaDescriptor(new GkeHubMethodDescriptorSupplier("GetFleet"))
                      .build();
        }
      }
    }
    return getGetFleetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.UpdateFleetRequest, com.google.longrunning.Operation>
      getUpdateFleetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateFleet",
      requestType = com.google.cloud.gkehub.v1.UpdateFleetRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.UpdateFleetRequest, com.google.longrunning.Operation>
      getUpdateFleetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkehub.v1.UpdateFleetRequest, com.google.longrunning.Operation>
        getUpdateFleetMethod;
    if ((getUpdateFleetMethod = GkeHubGrpc.getUpdateFleetMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getUpdateFleetMethod = GkeHubGrpc.getUpdateFleetMethod) == null) {
          GkeHubGrpc.getUpdateFleetMethod =
              getUpdateFleetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkehub.v1.UpdateFleetRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateFleet"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.UpdateFleetRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new GkeHubMethodDescriptorSupplier("UpdateFleet"))
                      .build();
        }
      }
    }
    return getUpdateFleetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.DeleteFleetRequest, com.google.longrunning.Operation>
      getDeleteFleetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteFleet",
      requestType = com.google.cloud.gkehub.v1.DeleteFleetRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.DeleteFleetRequest, com.google.longrunning.Operation>
      getDeleteFleetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkehub.v1.DeleteFleetRequest, com.google.longrunning.Operation>
        getDeleteFleetMethod;
    if ((getDeleteFleetMethod = GkeHubGrpc.getDeleteFleetMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getDeleteFleetMethod = GkeHubGrpc.getDeleteFleetMethod) == null) {
          GkeHubGrpc.getDeleteFleetMethod =
              getDeleteFleetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkehub.v1.DeleteFleetRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteFleet"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.DeleteFleetRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new GkeHubMethodDescriptorSupplier("DeleteFleet"))
                      .build();
        }
      }
    }
    return getDeleteFleetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.ListFleetsRequest,
          com.google.cloud.gkehub.v1.ListFleetsResponse>
      getListFleetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFleets",
      requestType = com.google.cloud.gkehub.v1.ListFleetsRequest.class,
      responseType = com.google.cloud.gkehub.v1.ListFleetsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.ListFleetsRequest,
          com.google.cloud.gkehub.v1.ListFleetsResponse>
      getListFleetsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkehub.v1.ListFleetsRequest,
            com.google.cloud.gkehub.v1.ListFleetsResponse>
        getListFleetsMethod;
    if ((getListFleetsMethod = GkeHubGrpc.getListFleetsMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getListFleetsMethod = GkeHubGrpc.getListFleetsMethod) == null) {
          GkeHubGrpc.getListFleetsMethod =
              getListFleetsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkehub.v1.ListFleetsRequest,
                          com.google.cloud.gkehub.v1.ListFleetsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListFleets"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.ListFleetsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.ListFleetsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new GkeHubMethodDescriptorSupplier("ListFleets"))
                      .build();
        }
      }
    }
    return getListFleetsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.GetScopeNamespaceRequest, com.google.cloud.gkehub.v1.Namespace>
      getGetScopeNamespaceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetScopeNamespace",
      requestType = com.google.cloud.gkehub.v1.GetScopeNamespaceRequest.class,
      responseType = com.google.cloud.gkehub.v1.Namespace.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.GetScopeNamespaceRequest, com.google.cloud.gkehub.v1.Namespace>
      getGetScopeNamespaceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkehub.v1.GetScopeNamespaceRequest,
            com.google.cloud.gkehub.v1.Namespace>
        getGetScopeNamespaceMethod;
    if ((getGetScopeNamespaceMethod = GkeHubGrpc.getGetScopeNamespaceMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getGetScopeNamespaceMethod = GkeHubGrpc.getGetScopeNamespaceMethod) == null) {
          GkeHubGrpc.getGetScopeNamespaceMethod =
              getGetScopeNamespaceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkehub.v1.GetScopeNamespaceRequest,
                          com.google.cloud.gkehub.v1.Namespace>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetScopeNamespace"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.GetScopeNamespaceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.Namespace.getDefaultInstance()))
                      .setSchemaDescriptor(new GkeHubMethodDescriptorSupplier("GetScopeNamespace"))
                      .build();
        }
      }
    }
    return getGetScopeNamespaceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.CreateScopeNamespaceRequest, com.google.longrunning.Operation>
      getCreateScopeNamespaceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateScopeNamespace",
      requestType = com.google.cloud.gkehub.v1.CreateScopeNamespaceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.CreateScopeNamespaceRequest, com.google.longrunning.Operation>
      getCreateScopeNamespaceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkehub.v1.CreateScopeNamespaceRequest,
            com.google.longrunning.Operation>
        getCreateScopeNamespaceMethod;
    if ((getCreateScopeNamespaceMethod = GkeHubGrpc.getCreateScopeNamespaceMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getCreateScopeNamespaceMethod = GkeHubGrpc.getCreateScopeNamespaceMethod) == null) {
          GkeHubGrpc.getCreateScopeNamespaceMethod =
              getCreateScopeNamespaceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkehub.v1.CreateScopeNamespaceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateScopeNamespace"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.CreateScopeNamespaceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GkeHubMethodDescriptorSupplier("CreateScopeNamespace"))
                      .build();
        }
      }
    }
    return getCreateScopeNamespaceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.UpdateScopeNamespaceRequest, com.google.longrunning.Operation>
      getUpdateScopeNamespaceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateScopeNamespace",
      requestType = com.google.cloud.gkehub.v1.UpdateScopeNamespaceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.UpdateScopeNamespaceRequest, com.google.longrunning.Operation>
      getUpdateScopeNamespaceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkehub.v1.UpdateScopeNamespaceRequest,
            com.google.longrunning.Operation>
        getUpdateScopeNamespaceMethod;
    if ((getUpdateScopeNamespaceMethod = GkeHubGrpc.getUpdateScopeNamespaceMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getUpdateScopeNamespaceMethod = GkeHubGrpc.getUpdateScopeNamespaceMethod) == null) {
          GkeHubGrpc.getUpdateScopeNamespaceMethod =
              getUpdateScopeNamespaceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkehub.v1.UpdateScopeNamespaceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateScopeNamespace"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.UpdateScopeNamespaceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GkeHubMethodDescriptorSupplier("UpdateScopeNamespace"))
                      .build();
        }
      }
    }
    return getUpdateScopeNamespaceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.DeleteScopeNamespaceRequest, com.google.longrunning.Operation>
      getDeleteScopeNamespaceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteScopeNamespace",
      requestType = com.google.cloud.gkehub.v1.DeleteScopeNamespaceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.DeleteScopeNamespaceRequest, com.google.longrunning.Operation>
      getDeleteScopeNamespaceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkehub.v1.DeleteScopeNamespaceRequest,
            com.google.longrunning.Operation>
        getDeleteScopeNamespaceMethod;
    if ((getDeleteScopeNamespaceMethod = GkeHubGrpc.getDeleteScopeNamespaceMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getDeleteScopeNamespaceMethod = GkeHubGrpc.getDeleteScopeNamespaceMethod) == null) {
          GkeHubGrpc.getDeleteScopeNamespaceMethod =
              getDeleteScopeNamespaceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkehub.v1.DeleteScopeNamespaceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteScopeNamespace"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.DeleteScopeNamespaceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GkeHubMethodDescriptorSupplier("DeleteScopeNamespace"))
                      .build();
        }
      }
    }
    return getDeleteScopeNamespaceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.ListScopeNamespacesRequest,
          com.google.cloud.gkehub.v1.ListScopeNamespacesResponse>
      getListScopeNamespacesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListScopeNamespaces",
      requestType = com.google.cloud.gkehub.v1.ListScopeNamespacesRequest.class,
      responseType = com.google.cloud.gkehub.v1.ListScopeNamespacesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.ListScopeNamespacesRequest,
          com.google.cloud.gkehub.v1.ListScopeNamespacesResponse>
      getListScopeNamespacesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkehub.v1.ListScopeNamespacesRequest,
            com.google.cloud.gkehub.v1.ListScopeNamespacesResponse>
        getListScopeNamespacesMethod;
    if ((getListScopeNamespacesMethod = GkeHubGrpc.getListScopeNamespacesMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getListScopeNamespacesMethod = GkeHubGrpc.getListScopeNamespacesMethod) == null) {
          GkeHubGrpc.getListScopeNamespacesMethod =
              getListScopeNamespacesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkehub.v1.ListScopeNamespacesRequest,
                          com.google.cloud.gkehub.v1.ListScopeNamespacesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListScopeNamespaces"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.ListScopeNamespacesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.ListScopeNamespacesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GkeHubMethodDescriptorSupplier("ListScopeNamespaces"))
                      .build();
        }
      }
    }
    return getListScopeNamespacesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.GetScopeRBACRoleBindingRequest,
          com.google.cloud.gkehub.v1.RBACRoleBinding>
      getGetScopeRBACRoleBindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetScopeRBACRoleBinding",
      requestType = com.google.cloud.gkehub.v1.GetScopeRBACRoleBindingRequest.class,
      responseType = com.google.cloud.gkehub.v1.RBACRoleBinding.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.GetScopeRBACRoleBindingRequest,
          com.google.cloud.gkehub.v1.RBACRoleBinding>
      getGetScopeRBACRoleBindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkehub.v1.GetScopeRBACRoleBindingRequest,
            com.google.cloud.gkehub.v1.RBACRoleBinding>
        getGetScopeRBACRoleBindingMethod;
    if ((getGetScopeRBACRoleBindingMethod = GkeHubGrpc.getGetScopeRBACRoleBindingMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getGetScopeRBACRoleBindingMethod = GkeHubGrpc.getGetScopeRBACRoleBindingMethod)
            == null) {
          GkeHubGrpc.getGetScopeRBACRoleBindingMethod =
              getGetScopeRBACRoleBindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkehub.v1.GetScopeRBACRoleBindingRequest,
                          com.google.cloud.gkehub.v1.RBACRoleBinding>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetScopeRBACRoleBinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.GetScopeRBACRoleBindingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.RBACRoleBinding.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GkeHubMethodDescriptorSupplier("GetScopeRBACRoleBinding"))
                      .build();
        }
      }
    }
    return getGetScopeRBACRoleBindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.CreateScopeRBACRoleBindingRequest,
          com.google.longrunning.Operation>
      getCreateScopeRBACRoleBindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateScopeRBACRoleBinding",
      requestType = com.google.cloud.gkehub.v1.CreateScopeRBACRoleBindingRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.CreateScopeRBACRoleBindingRequest,
          com.google.longrunning.Operation>
      getCreateScopeRBACRoleBindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkehub.v1.CreateScopeRBACRoleBindingRequest,
            com.google.longrunning.Operation>
        getCreateScopeRBACRoleBindingMethod;
    if ((getCreateScopeRBACRoleBindingMethod = GkeHubGrpc.getCreateScopeRBACRoleBindingMethod)
        == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getCreateScopeRBACRoleBindingMethod = GkeHubGrpc.getCreateScopeRBACRoleBindingMethod)
            == null) {
          GkeHubGrpc.getCreateScopeRBACRoleBindingMethod =
              getCreateScopeRBACRoleBindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkehub.v1.CreateScopeRBACRoleBindingRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateScopeRBACRoleBinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.CreateScopeRBACRoleBindingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GkeHubMethodDescriptorSupplier("CreateScopeRBACRoleBinding"))
                      .build();
        }
      }
    }
    return getCreateScopeRBACRoleBindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.UpdateScopeRBACRoleBindingRequest,
          com.google.longrunning.Operation>
      getUpdateScopeRBACRoleBindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateScopeRBACRoleBinding",
      requestType = com.google.cloud.gkehub.v1.UpdateScopeRBACRoleBindingRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.UpdateScopeRBACRoleBindingRequest,
          com.google.longrunning.Operation>
      getUpdateScopeRBACRoleBindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkehub.v1.UpdateScopeRBACRoleBindingRequest,
            com.google.longrunning.Operation>
        getUpdateScopeRBACRoleBindingMethod;
    if ((getUpdateScopeRBACRoleBindingMethod = GkeHubGrpc.getUpdateScopeRBACRoleBindingMethod)
        == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getUpdateScopeRBACRoleBindingMethod = GkeHubGrpc.getUpdateScopeRBACRoleBindingMethod)
            == null) {
          GkeHubGrpc.getUpdateScopeRBACRoleBindingMethod =
              getUpdateScopeRBACRoleBindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkehub.v1.UpdateScopeRBACRoleBindingRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateScopeRBACRoleBinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.UpdateScopeRBACRoleBindingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GkeHubMethodDescriptorSupplier("UpdateScopeRBACRoleBinding"))
                      .build();
        }
      }
    }
    return getUpdateScopeRBACRoleBindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.DeleteScopeRBACRoleBindingRequest,
          com.google.longrunning.Operation>
      getDeleteScopeRBACRoleBindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteScopeRBACRoleBinding",
      requestType = com.google.cloud.gkehub.v1.DeleteScopeRBACRoleBindingRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.DeleteScopeRBACRoleBindingRequest,
          com.google.longrunning.Operation>
      getDeleteScopeRBACRoleBindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkehub.v1.DeleteScopeRBACRoleBindingRequest,
            com.google.longrunning.Operation>
        getDeleteScopeRBACRoleBindingMethod;
    if ((getDeleteScopeRBACRoleBindingMethod = GkeHubGrpc.getDeleteScopeRBACRoleBindingMethod)
        == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getDeleteScopeRBACRoleBindingMethod = GkeHubGrpc.getDeleteScopeRBACRoleBindingMethod)
            == null) {
          GkeHubGrpc.getDeleteScopeRBACRoleBindingMethod =
              getDeleteScopeRBACRoleBindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkehub.v1.DeleteScopeRBACRoleBindingRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteScopeRBACRoleBinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.DeleteScopeRBACRoleBindingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GkeHubMethodDescriptorSupplier("DeleteScopeRBACRoleBinding"))
                      .build();
        }
      }
    }
    return getDeleteScopeRBACRoleBindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.ListScopeRBACRoleBindingsRequest,
          com.google.cloud.gkehub.v1.ListScopeRBACRoleBindingsResponse>
      getListScopeRBACRoleBindingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListScopeRBACRoleBindings",
      requestType = com.google.cloud.gkehub.v1.ListScopeRBACRoleBindingsRequest.class,
      responseType = com.google.cloud.gkehub.v1.ListScopeRBACRoleBindingsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.ListScopeRBACRoleBindingsRequest,
          com.google.cloud.gkehub.v1.ListScopeRBACRoleBindingsResponse>
      getListScopeRBACRoleBindingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkehub.v1.ListScopeRBACRoleBindingsRequest,
            com.google.cloud.gkehub.v1.ListScopeRBACRoleBindingsResponse>
        getListScopeRBACRoleBindingsMethod;
    if ((getListScopeRBACRoleBindingsMethod = GkeHubGrpc.getListScopeRBACRoleBindingsMethod)
        == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getListScopeRBACRoleBindingsMethod = GkeHubGrpc.getListScopeRBACRoleBindingsMethod)
            == null) {
          GkeHubGrpc.getListScopeRBACRoleBindingsMethod =
              getListScopeRBACRoleBindingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkehub.v1.ListScopeRBACRoleBindingsRequest,
                          com.google.cloud.gkehub.v1.ListScopeRBACRoleBindingsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListScopeRBACRoleBindings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.ListScopeRBACRoleBindingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.ListScopeRBACRoleBindingsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GkeHubMethodDescriptorSupplier("ListScopeRBACRoleBindings"))
                      .build();
        }
      }
    }
    return getListScopeRBACRoleBindingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.GetScopeRequest, com.google.cloud.gkehub.v1.Scope>
      getGetScopeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetScope",
      requestType = com.google.cloud.gkehub.v1.GetScopeRequest.class,
      responseType = com.google.cloud.gkehub.v1.Scope.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.GetScopeRequest, com.google.cloud.gkehub.v1.Scope>
      getGetScopeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkehub.v1.GetScopeRequest, com.google.cloud.gkehub.v1.Scope>
        getGetScopeMethod;
    if ((getGetScopeMethod = GkeHubGrpc.getGetScopeMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getGetScopeMethod = GkeHubGrpc.getGetScopeMethod) == null) {
          GkeHubGrpc.getGetScopeMethod =
              getGetScopeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkehub.v1.GetScopeRequest,
                          com.google.cloud.gkehub.v1.Scope>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetScope"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.GetScopeRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.Scope.getDefaultInstance()))
                      .setSchemaDescriptor(new GkeHubMethodDescriptorSupplier("GetScope"))
                      .build();
        }
      }
    }
    return getGetScopeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.CreateScopeRequest, com.google.longrunning.Operation>
      getCreateScopeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateScope",
      requestType = com.google.cloud.gkehub.v1.CreateScopeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.CreateScopeRequest, com.google.longrunning.Operation>
      getCreateScopeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkehub.v1.CreateScopeRequest, com.google.longrunning.Operation>
        getCreateScopeMethod;
    if ((getCreateScopeMethod = GkeHubGrpc.getCreateScopeMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getCreateScopeMethod = GkeHubGrpc.getCreateScopeMethod) == null) {
          GkeHubGrpc.getCreateScopeMethod =
              getCreateScopeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkehub.v1.CreateScopeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateScope"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.CreateScopeRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new GkeHubMethodDescriptorSupplier("CreateScope"))
                      .build();
        }
      }
    }
    return getCreateScopeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.UpdateScopeRequest, com.google.longrunning.Operation>
      getUpdateScopeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateScope",
      requestType = com.google.cloud.gkehub.v1.UpdateScopeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.UpdateScopeRequest, com.google.longrunning.Operation>
      getUpdateScopeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkehub.v1.UpdateScopeRequest, com.google.longrunning.Operation>
        getUpdateScopeMethod;
    if ((getUpdateScopeMethod = GkeHubGrpc.getUpdateScopeMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getUpdateScopeMethod = GkeHubGrpc.getUpdateScopeMethod) == null) {
          GkeHubGrpc.getUpdateScopeMethod =
              getUpdateScopeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkehub.v1.UpdateScopeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateScope"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.UpdateScopeRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new GkeHubMethodDescriptorSupplier("UpdateScope"))
                      .build();
        }
      }
    }
    return getUpdateScopeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.DeleteScopeRequest, com.google.longrunning.Operation>
      getDeleteScopeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteScope",
      requestType = com.google.cloud.gkehub.v1.DeleteScopeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.DeleteScopeRequest, com.google.longrunning.Operation>
      getDeleteScopeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkehub.v1.DeleteScopeRequest, com.google.longrunning.Operation>
        getDeleteScopeMethod;
    if ((getDeleteScopeMethod = GkeHubGrpc.getDeleteScopeMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getDeleteScopeMethod = GkeHubGrpc.getDeleteScopeMethod) == null) {
          GkeHubGrpc.getDeleteScopeMethod =
              getDeleteScopeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkehub.v1.DeleteScopeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteScope"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.DeleteScopeRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new GkeHubMethodDescriptorSupplier("DeleteScope"))
                      .build();
        }
      }
    }
    return getDeleteScopeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.ListScopesRequest,
          com.google.cloud.gkehub.v1.ListScopesResponse>
      getListScopesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListScopes",
      requestType = com.google.cloud.gkehub.v1.ListScopesRequest.class,
      responseType = com.google.cloud.gkehub.v1.ListScopesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.ListScopesRequest,
          com.google.cloud.gkehub.v1.ListScopesResponse>
      getListScopesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkehub.v1.ListScopesRequest,
            com.google.cloud.gkehub.v1.ListScopesResponse>
        getListScopesMethod;
    if ((getListScopesMethod = GkeHubGrpc.getListScopesMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getListScopesMethod = GkeHubGrpc.getListScopesMethod) == null) {
          GkeHubGrpc.getListScopesMethod =
              getListScopesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkehub.v1.ListScopesRequest,
                          com.google.cloud.gkehub.v1.ListScopesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListScopes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.ListScopesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.ListScopesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new GkeHubMethodDescriptorSupplier("ListScopes"))
                      .build();
        }
      }
    }
    return getListScopesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.ListPermittedScopesRequest,
          com.google.cloud.gkehub.v1.ListPermittedScopesResponse>
      getListPermittedScopesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPermittedScopes",
      requestType = com.google.cloud.gkehub.v1.ListPermittedScopesRequest.class,
      responseType = com.google.cloud.gkehub.v1.ListPermittedScopesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.ListPermittedScopesRequest,
          com.google.cloud.gkehub.v1.ListPermittedScopesResponse>
      getListPermittedScopesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkehub.v1.ListPermittedScopesRequest,
            com.google.cloud.gkehub.v1.ListPermittedScopesResponse>
        getListPermittedScopesMethod;
    if ((getListPermittedScopesMethod = GkeHubGrpc.getListPermittedScopesMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getListPermittedScopesMethod = GkeHubGrpc.getListPermittedScopesMethod) == null) {
          GkeHubGrpc.getListPermittedScopesMethod =
              getListPermittedScopesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkehub.v1.ListPermittedScopesRequest,
                          com.google.cloud.gkehub.v1.ListPermittedScopesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListPermittedScopes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.ListPermittedScopesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.ListPermittedScopesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GkeHubMethodDescriptorSupplier("ListPermittedScopes"))
                      .build();
        }
      }
    }
    return getListPermittedScopesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.GetMembershipBindingRequest,
          com.google.cloud.gkehub.v1.MembershipBinding>
      getGetMembershipBindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMembershipBinding",
      requestType = com.google.cloud.gkehub.v1.GetMembershipBindingRequest.class,
      responseType = com.google.cloud.gkehub.v1.MembershipBinding.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.GetMembershipBindingRequest,
          com.google.cloud.gkehub.v1.MembershipBinding>
      getGetMembershipBindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkehub.v1.GetMembershipBindingRequest,
            com.google.cloud.gkehub.v1.MembershipBinding>
        getGetMembershipBindingMethod;
    if ((getGetMembershipBindingMethod = GkeHubGrpc.getGetMembershipBindingMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getGetMembershipBindingMethod = GkeHubGrpc.getGetMembershipBindingMethod) == null) {
          GkeHubGrpc.getGetMembershipBindingMethod =
              getGetMembershipBindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkehub.v1.GetMembershipBindingRequest,
                          com.google.cloud.gkehub.v1.MembershipBinding>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetMembershipBinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.GetMembershipBindingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.MembershipBinding.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GkeHubMethodDescriptorSupplier("GetMembershipBinding"))
                      .build();
        }
      }
    }
    return getGetMembershipBindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.CreateMembershipBindingRequest,
          com.google.longrunning.Operation>
      getCreateMembershipBindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateMembershipBinding",
      requestType = com.google.cloud.gkehub.v1.CreateMembershipBindingRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.CreateMembershipBindingRequest,
          com.google.longrunning.Operation>
      getCreateMembershipBindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkehub.v1.CreateMembershipBindingRequest,
            com.google.longrunning.Operation>
        getCreateMembershipBindingMethod;
    if ((getCreateMembershipBindingMethod = GkeHubGrpc.getCreateMembershipBindingMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getCreateMembershipBindingMethod = GkeHubGrpc.getCreateMembershipBindingMethod)
            == null) {
          GkeHubGrpc.getCreateMembershipBindingMethod =
              getCreateMembershipBindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkehub.v1.CreateMembershipBindingRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateMembershipBinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.CreateMembershipBindingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GkeHubMethodDescriptorSupplier("CreateMembershipBinding"))
                      .build();
        }
      }
    }
    return getCreateMembershipBindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.UpdateMembershipBindingRequest,
          com.google.longrunning.Operation>
      getUpdateMembershipBindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateMembershipBinding",
      requestType = com.google.cloud.gkehub.v1.UpdateMembershipBindingRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.UpdateMembershipBindingRequest,
          com.google.longrunning.Operation>
      getUpdateMembershipBindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkehub.v1.UpdateMembershipBindingRequest,
            com.google.longrunning.Operation>
        getUpdateMembershipBindingMethod;
    if ((getUpdateMembershipBindingMethod = GkeHubGrpc.getUpdateMembershipBindingMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getUpdateMembershipBindingMethod = GkeHubGrpc.getUpdateMembershipBindingMethod)
            == null) {
          GkeHubGrpc.getUpdateMembershipBindingMethod =
              getUpdateMembershipBindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkehub.v1.UpdateMembershipBindingRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateMembershipBinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.UpdateMembershipBindingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GkeHubMethodDescriptorSupplier("UpdateMembershipBinding"))
                      .build();
        }
      }
    }
    return getUpdateMembershipBindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.DeleteMembershipBindingRequest,
          com.google.longrunning.Operation>
      getDeleteMembershipBindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteMembershipBinding",
      requestType = com.google.cloud.gkehub.v1.DeleteMembershipBindingRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.DeleteMembershipBindingRequest,
          com.google.longrunning.Operation>
      getDeleteMembershipBindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkehub.v1.DeleteMembershipBindingRequest,
            com.google.longrunning.Operation>
        getDeleteMembershipBindingMethod;
    if ((getDeleteMembershipBindingMethod = GkeHubGrpc.getDeleteMembershipBindingMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getDeleteMembershipBindingMethod = GkeHubGrpc.getDeleteMembershipBindingMethod)
            == null) {
          GkeHubGrpc.getDeleteMembershipBindingMethod =
              getDeleteMembershipBindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkehub.v1.DeleteMembershipBindingRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteMembershipBinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.DeleteMembershipBindingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GkeHubMethodDescriptorSupplier("DeleteMembershipBinding"))
                      .build();
        }
      }
    }
    return getDeleteMembershipBindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.ListMembershipBindingsRequest,
          com.google.cloud.gkehub.v1.ListMembershipBindingsResponse>
      getListMembershipBindingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMembershipBindings",
      requestType = com.google.cloud.gkehub.v1.ListMembershipBindingsRequest.class,
      responseType = com.google.cloud.gkehub.v1.ListMembershipBindingsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.ListMembershipBindingsRequest,
          com.google.cloud.gkehub.v1.ListMembershipBindingsResponse>
      getListMembershipBindingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkehub.v1.ListMembershipBindingsRequest,
            com.google.cloud.gkehub.v1.ListMembershipBindingsResponse>
        getListMembershipBindingsMethod;
    if ((getListMembershipBindingsMethod = GkeHubGrpc.getListMembershipBindingsMethod) == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getListMembershipBindingsMethod = GkeHubGrpc.getListMembershipBindingsMethod)
            == null) {
          GkeHubGrpc.getListMembershipBindingsMethod =
              getListMembershipBindingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkehub.v1.ListMembershipBindingsRequest,
                          com.google.cloud.gkehub.v1.ListMembershipBindingsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListMembershipBindings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.ListMembershipBindingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.ListMembershipBindingsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GkeHubMethodDescriptorSupplier("ListMembershipBindings"))
                      .build();
        }
      }
    }
    return getListMembershipBindingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.GetMembershipRBACRoleBindingRequest,
          com.google.cloud.gkehub.v1.RBACRoleBinding>
      getGetMembershipRBACRoleBindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMembershipRBACRoleBinding",
      requestType = com.google.cloud.gkehub.v1.GetMembershipRBACRoleBindingRequest.class,
      responseType = com.google.cloud.gkehub.v1.RBACRoleBinding.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.GetMembershipRBACRoleBindingRequest,
          com.google.cloud.gkehub.v1.RBACRoleBinding>
      getGetMembershipRBACRoleBindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkehub.v1.GetMembershipRBACRoleBindingRequest,
            com.google.cloud.gkehub.v1.RBACRoleBinding>
        getGetMembershipRBACRoleBindingMethod;
    if ((getGetMembershipRBACRoleBindingMethod = GkeHubGrpc.getGetMembershipRBACRoleBindingMethod)
        == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getGetMembershipRBACRoleBindingMethod =
                GkeHubGrpc.getGetMembershipRBACRoleBindingMethod)
            == null) {
          GkeHubGrpc.getGetMembershipRBACRoleBindingMethod =
              getGetMembershipRBACRoleBindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkehub.v1.GetMembershipRBACRoleBindingRequest,
                          com.google.cloud.gkehub.v1.RBACRoleBinding>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetMembershipRBACRoleBinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.GetMembershipRBACRoleBindingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.RBACRoleBinding.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GkeHubMethodDescriptorSupplier("GetMembershipRBACRoleBinding"))
                      .build();
        }
      }
    }
    return getGetMembershipRBACRoleBindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.CreateMembershipRBACRoleBindingRequest,
          com.google.longrunning.Operation>
      getCreateMembershipRBACRoleBindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateMembershipRBACRoleBinding",
      requestType = com.google.cloud.gkehub.v1.CreateMembershipRBACRoleBindingRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.CreateMembershipRBACRoleBindingRequest,
          com.google.longrunning.Operation>
      getCreateMembershipRBACRoleBindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkehub.v1.CreateMembershipRBACRoleBindingRequest,
            com.google.longrunning.Operation>
        getCreateMembershipRBACRoleBindingMethod;
    if ((getCreateMembershipRBACRoleBindingMethod =
            GkeHubGrpc.getCreateMembershipRBACRoleBindingMethod)
        == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getCreateMembershipRBACRoleBindingMethod =
                GkeHubGrpc.getCreateMembershipRBACRoleBindingMethod)
            == null) {
          GkeHubGrpc.getCreateMembershipRBACRoleBindingMethod =
              getCreateMembershipRBACRoleBindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkehub.v1.CreateMembershipRBACRoleBindingRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateMembershipRBACRoleBinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.CreateMembershipRBACRoleBindingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GkeHubMethodDescriptorSupplier("CreateMembershipRBACRoleBinding"))
                      .build();
        }
      }
    }
    return getCreateMembershipRBACRoleBindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.UpdateMembershipRBACRoleBindingRequest,
          com.google.longrunning.Operation>
      getUpdateMembershipRBACRoleBindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateMembershipRBACRoleBinding",
      requestType = com.google.cloud.gkehub.v1.UpdateMembershipRBACRoleBindingRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.UpdateMembershipRBACRoleBindingRequest,
          com.google.longrunning.Operation>
      getUpdateMembershipRBACRoleBindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkehub.v1.UpdateMembershipRBACRoleBindingRequest,
            com.google.longrunning.Operation>
        getUpdateMembershipRBACRoleBindingMethod;
    if ((getUpdateMembershipRBACRoleBindingMethod =
            GkeHubGrpc.getUpdateMembershipRBACRoleBindingMethod)
        == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getUpdateMembershipRBACRoleBindingMethod =
                GkeHubGrpc.getUpdateMembershipRBACRoleBindingMethod)
            == null) {
          GkeHubGrpc.getUpdateMembershipRBACRoleBindingMethod =
              getUpdateMembershipRBACRoleBindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkehub.v1.UpdateMembershipRBACRoleBindingRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateMembershipRBACRoleBinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.UpdateMembershipRBACRoleBindingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GkeHubMethodDescriptorSupplier("UpdateMembershipRBACRoleBinding"))
                      .build();
        }
      }
    }
    return getUpdateMembershipRBACRoleBindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.DeleteMembershipRBACRoleBindingRequest,
          com.google.longrunning.Operation>
      getDeleteMembershipRBACRoleBindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteMembershipRBACRoleBinding",
      requestType = com.google.cloud.gkehub.v1.DeleteMembershipRBACRoleBindingRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.DeleteMembershipRBACRoleBindingRequest,
          com.google.longrunning.Operation>
      getDeleteMembershipRBACRoleBindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkehub.v1.DeleteMembershipRBACRoleBindingRequest,
            com.google.longrunning.Operation>
        getDeleteMembershipRBACRoleBindingMethod;
    if ((getDeleteMembershipRBACRoleBindingMethod =
            GkeHubGrpc.getDeleteMembershipRBACRoleBindingMethod)
        == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getDeleteMembershipRBACRoleBindingMethod =
                GkeHubGrpc.getDeleteMembershipRBACRoleBindingMethod)
            == null) {
          GkeHubGrpc.getDeleteMembershipRBACRoleBindingMethod =
              getDeleteMembershipRBACRoleBindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkehub.v1.DeleteMembershipRBACRoleBindingRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteMembershipRBACRoleBinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.DeleteMembershipRBACRoleBindingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GkeHubMethodDescriptorSupplier("DeleteMembershipRBACRoleBinding"))
                      .build();
        }
      }
    }
    return getDeleteMembershipRBACRoleBindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.ListMembershipRBACRoleBindingsRequest,
          com.google.cloud.gkehub.v1.ListMembershipRBACRoleBindingsResponse>
      getListMembershipRBACRoleBindingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMembershipRBACRoleBindings",
      requestType = com.google.cloud.gkehub.v1.ListMembershipRBACRoleBindingsRequest.class,
      responseType = com.google.cloud.gkehub.v1.ListMembershipRBACRoleBindingsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.ListMembershipRBACRoleBindingsRequest,
          com.google.cloud.gkehub.v1.ListMembershipRBACRoleBindingsResponse>
      getListMembershipRBACRoleBindingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkehub.v1.ListMembershipRBACRoleBindingsRequest,
            com.google.cloud.gkehub.v1.ListMembershipRBACRoleBindingsResponse>
        getListMembershipRBACRoleBindingsMethod;
    if ((getListMembershipRBACRoleBindingsMethod =
            GkeHubGrpc.getListMembershipRBACRoleBindingsMethod)
        == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getListMembershipRBACRoleBindingsMethod =
                GkeHubGrpc.getListMembershipRBACRoleBindingsMethod)
            == null) {
          GkeHubGrpc.getListMembershipRBACRoleBindingsMethod =
              getListMembershipRBACRoleBindingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkehub.v1.ListMembershipRBACRoleBindingsRequest,
                          com.google.cloud.gkehub.v1.ListMembershipRBACRoleBindingsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListMembershipRBACRoleBindings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.ListMembershipRBACRoleBindingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1.ListMembershipRBACRoleBindingsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GkeHubMethodDescriptorSupplier("ListMembershipRBACRoleBindings"))
                      .build();
        }
      }
    }
    return getListMembershipRBACRoleBindingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.GenerateMembershipRBACRoleBindingYAMLRequest,
          com.google.cloud.gkehub.v1.GenerateMembershipRBACRoleBindingYAMLResponse>
      getGenerateMembershipRBACRoleBindingYAMLMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateMembershipRBACRoleBindingYAML",
      requestType = com.google.cloud.gkehub.v1.GenerateMembershipRBACRoleBindingYAMLRequest.class,
      responseType = com.google.cloud.gkehub.v1.GenerateMembershipRBACRoleBindingYAMLResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkehub.v1.GenerateMembershipRBACRoleBindingYAMLRequest,
          com.google.cloud.gkehub.v1.GenerateMembershipRBACRoleBindingYAMLResponse>
      getGenerateMembershipRBACRoleBindingYAMLMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkehub.v1.GenerateMembershipRBACRoleBindingYAMLRequest,
            com.google.cloud.gkehub.v1.GenerateMembershipRBACRoleBindingYAMLResponse>
        getGenerateMembershipRBACRoleBindingYAMLMethod;
    if ((getGenerateMembershipRBACRoleBindingYAMLMethod =
            GkeHubGrpc.getGenerateMembershipRBACRoleBindingYAMLMethod)
        == null) {
      synchronized (GkeHubGrpc.class) {
        if ((getGenerateMembershipRBACRoleBindingYAMLMethod =
                GkeHubGrpc.getGenerateMembershipRBACRoleBindingYAMLMethod)
            == null) {
          GkeHubGrpc.getGenerateMembershipRBACRoleBindingYAMLMethod =
              getGenerateMembershipRBACRoleBindingYAMLMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkehub.v1.GenerateMembershipRBACRoleBindingYAMLRequest,
                          com.google.cloud.gkehub.v1.GenerateMembershipRBACRoleBindingYAMLResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "GenerateMembershipRBACRoleBindingYAML"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1
                                  .GenerateMembershipRBACRoleBindingYAMLRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkehub.v1
                                  .GenerateMembershipRBACRoleBindingYAMLResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GkeHubMethodDescriptorSupplier(
                              "GenerateMembershipRBACRoleBindingYAML"))
                      .build();
        }
      }
    }
    return getGenerateMembershipRBACRoleBindingYAMLMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static GkeHubStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GkeHubStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GkeHubStub>() {
          @java.lang.Override
          public GkeHubStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GkeHubStub(channel, callOptions);
          }
        };
    return GkeHubStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static GkeHubBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GkeHubBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GkeHubBlockingV2Stub>() {
          @java.lang.Override
          public GkeHubBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GkeHubBlockingV2Stub(channel, callOptions);
          }
        };
    return GkeHubBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GkeHubBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GkeHubBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GkeHubBlockingStub>() {
          @java.lang.Override
          public GkeHubBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GkeHubBlockingStub(channel, callOptions);
          }
        };
    return GkeHubBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static GkeHubFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GkeHubFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GkeHubFutureStub>() {
          @java.lang.Override
          public GkeHubFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GkeHubFutureStub(channel, callOptions);
          }
        };
    return GkeHubFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The GKE Hub service handles the registration of many Kubernetes clusters to
   * Google Cloud, and the management of multi-cluster features over those
   * clusters.
   * The GKE Hub service operates on the following resources:
   * * [Membership][google.cloud.gkehub.v1.Membership]
   * * [Feature][google.cloud.gkehub.v1.Feature]
   * GKE Hub is currently available in the global region and all regions in
   * https://cloud.google.com/compute/docs/regions-zones. Feature is only
   * available in global region while membership is global region and all the
   * regions.
   * **Membership management may be non-trivial:** it is recommended to use one
   * of the Google-provided client libraries or tools where possible when working
   * with Membership resources.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists Memberships in a given project and location.
     * </pre>
     */
    default void listMemberships(
        com.google.cloud.gkehub.v1.ListMembershipsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.ListMembershipsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListMembershipsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Memberships bound to a Scope. The response includes relevant
     * Memberships from all regions.
     * </pre>
     */
    default void listBoundMemberships(
        com.google.cloud.gkehub.v1.ListBoundMembershipsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.ListBoundMembershipsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListBoundMembershipsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Features in a given project and location.
     * </pre>
     */
    default void listFeatures(
        com.google.cloud.gkehub.v1.ListFeaturesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.ListFeaturesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListFeaturesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a Membership.
     * </pre>
     */
    default void getMembership(
        com.google.cloud.gkehub.v1.GetMembershipRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.Membership> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetMembershipMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Feature.
     * </pre>
     */
    default void getFeature(
        com.google.cloud.gkehub.v1.GetFeatureRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.Feature> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetFeatureMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Membership.
     * **This is currently only supported for GKE clusters on Google Cloud**.
     * To register other clusters, follow the instructions at
     * https://cloud.google.com/anthos/multicluster-management/connect/registering-a-cluster.
     * </pre>
     */
    default void createMembership(
        com.google.cloud.gkehub.v1.CreateMembershipRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateMembershipMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds a new Feature.
     * </pre>
     */
    default void createFeature(
        com.google.cloud.gkehub.v1.CreateFeatureRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateFeatureMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Removes a Membership.
     * **This is currently only supported for GKE clusters on Google Cloud**.
     * To unregister other clusters, follow the instructions at
     * https://cloud.google.com/anthos/multicluster-management/connect/unregistering-a-cluster.
     * </pre>
     */
    default void deleteMembership(
        com.google.cloud.gkehub.v1.DeleteMembershipRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteMembershipMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Removes a Feature.
     * </pre>
     */
    default void deleteFeature(
        com.google.cloud.gkehub.v1.DeleteFeatureRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteFeatureMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing Membership.
     * </pre>
     */
    default void updateMembership(
        com.google.cloud.gkehub.v1.UpdateMembershipRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateMembershipMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing Feature.
     * </pre>
     */
    default void updateFeature(
        com.google.cloud.gkehub.v1.UpdateFeatureRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateFeatureMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generates the manifest for deployment of the GKE connect agent.
     * **This method is used internally by Google-provided libraries.**
     * Most clients should not need to call this method directly.
     * </pre>
     */
    default void generateConnectManifest(
        com.google.cloud.gkehub.v1.GenerateConnectManifestRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.GenerateConnectManifestResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGenerateConnectManifestMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a fleet.
     * </pre>
     */
    default void createFleet(
        com.google.cloud.gkehub.v1.CreateFleetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateFleetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the details of a fleet.
     * </pre>
     */
    default void getFleet(
        com.google.cloud.gkehub.v1.GetFleetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.Fleet> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetFleetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a fleet.
     * </pre>
     */
    default void updateFleet(
        com.google.cloud.gkehub.v1.UpdateFleetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateFleetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Removes a Fleet. There must be no memberships remaining in the Fleet.
     * </pre>
     */
    default void deleteFleet(
        com.google.cloud.gkehub.v1.DeleteFleetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteFleetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns all fleets within an organization or a project that the caller has
     * access to.
     * </pre>
     */
    default void listFleets(
        com.google.cloud.gkehub.v1.ListFleetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.ListFleetsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListFleetsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the details of a fleet namespace.
     * </pre>
     */
    default void getScopeNamespace(
        com.google.cloud.gkehub.v1.GetScopeNamespaceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.Namespace> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetScopeNamespaceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a fleet namespace.
     * </pre>
     */
    default void createScopeNamespace(
        com.google.cloud.gkehub.v1.CreateScopeNamespaceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateScopeNamespaceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a fleet namespace.
     * </pre>
     */
    default void updateScopeNamespace(
        com.google.cloud.gkehub.v1.UpdateScopeNamespaceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateScopeNamespaceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a fleet namespace.
     * </pre>
     */
    default void deleteScopeNamespace(
        com.google.cloud.gkehub.v1.DeleteScopeNamespaceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteScopeNamespaceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists fleet namespaces.
     * </pre>
     */
    default void listScopeNamespaces(
        com.google.cloud.gkehub.v1.ListScopeNamespacesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.ListScopeNamespacesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListScopeNamespacesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the details of a Scope RBACRoleBinding.
     * </pre>
     */
    default void getScopeRBACRoleBinding(
        com.google.cloud.gkehub.v1.GetScopeRBACRoleBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.RBACRoleBinding> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetScopeRBACRoleBindingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a Scope RBACRoleBinding.
     * </pre>
     */
    default void createScopeRBACRoleBinding(
        com.google.cloud.gkehub.v1.CreateScopeRBACRoleBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateScopeRBACRoleBindingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a Scope RBACRoleBinding.
     * </pre>
     */
    default void updateScopeRBACRoleBinding(
        com.google.cloud.gkehub.v1.UpdateScopeRBACRoleBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateScopeRBACRoleBindingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Scope RBACRoleBinding.
     * </pre>
     */
    default void deleteScopeRBACRoleBinding(
        com.google.cloud.gkehub.v1.DeleteScopeRBACRoleBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteScopeRBACRoleBindingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all Scope RBACRoleBindings.
     * </pre>
     */
    default void listScopeRBACRoleBindings(
        com.google.cloud.gkehub.v1.ListScopeRBACRoleBindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.ListScopeRBACRoleBindingsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListScopeRBACRoleBindingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the details of a Scope.
     * </pre>
     */
    default void getScope(
        com.google.cloud.gkehub.v1.GetScopeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.Scope> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetScopeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a Scope.
     * </pre>
     */
    default void createScope(
        com.google.cloud.gkehub.v1.CreateScopeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateScopeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a scopes.
     * </pre>
     */
    default void updateScope(
        com.google.cloud.gkehub.v1.UpdateScopeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateScopeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Scope.
     * </pre>
     */
    default void deleteScope(
        com.google.cloud.gkehub.v1.DeleteScopeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteScopeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Scopes.
     * </pre>
     */
    default void listScopes(
        com.google.cloud.gkehub.v1.ListScopesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.ListScopesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListScopesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists permitted Scopes.
     * </pre>
     */
    default void listPermittedScopes(
        com.google.cloud.gkehub.v1.ListPermittedScopesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.ListPermittedScopesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListPermittedScopesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the details of a MembershipBinding.
     * </pre>
     */
    default void getMembershipBinding(
        com.google.cloud.gkehub.v1.GetMembershipBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.MembershipBinding>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetMembershipBindingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a MembershipBinding.
     * </pre>
     */
    default void createMembershipBinding(
        com.google.cloud.gkehub.v1.CreateMembershipBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateMembershipBindingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a MembershipBinding.
     * </pre>
     */
    default void updateMembershipBinding(
        com.google.cloud.gkehub.v1.UpdateMembershipBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateMembershipBindingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a MembershipBinding.
     * </pre>
     */
    default void deleteMembershipBinding(
        com.google.cloud.gkehub.v1.DeleteMembershipBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteMembershipBindingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists MembershipBindings.
     * </pre>
     */
    default void listMembershipBindings(
        com.google.cloud.gkehub.v1.ListMembershipBindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.ListMembershipBindingsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListMembershipBindingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the details of a Membership RBACRoleBinding.
     * </pre>
     */
    default void getMembershipRBACRoleBinding(
        com.google.cloud.gkehub.v1.GetMembershipRBACRoleBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.RBACRoleBinding> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetMembershipRBACRoleBindingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a Membership RBACRoleBinding.
     * </pre>
     */
    default void createMembershipRBACRoleBinding(
        com.google.cloud.gkehub.v1.CreateMembershipRBACRoleBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateMembershipRBACRoleBindingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a Membership RBACRoleBinding.
     * </pre>
     */
    default void updateMembershipRBACRoleBinding(
        com.google.cloud.gkehub.v1.UpdateMembershipRBACRoleBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateMembershipRBACRoleBindingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Membership RBACRoleBinding.
     * </pre>
     */
    default void deleteMembershipRBACRoleBinding(
        com.google.cloud.gkehub.v1.DeleteMembershipRBACRoleBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteMembershipRBACRoleBindingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all Membership RBACRoleBindings.
     * </pre>
     */
    default void listMembershipRBACRoleBindings(
        com.google.cloud.gkehub.v1.ListMembershipRBACRoleBindingsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.gkehub.v1.ListMembershipRBACRoleBindingsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListMembershipRBACRoleBindingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generates a YAML of the  RBAC policies for the specified
     * RoleBinding and its associated impersonation resources.
     * </pre>
     */
    default void generateMembershipRBACRoleBindingYAML(
        com.google.cloud.gkehub.v1.GenerateMembershipRBACRoleBindingYAMLRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.gkehub.v1.GenerateMembershipRBACRoleBindingYAMLResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGenerateMembershipRBACRoleBindingYAMLMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service GkeHub.
   *
   * <pre>
   * The GKE Hub service handles the registration of many Kubernetes clusters to
   * Google Cloud, and the management of multi-cluster features over those
   * clusters.
   * The GKE Hub service operates on the following resources:
   * * [Membership][google.cloud.gkehub.v1.Membership]
   * * [Feature][google.cloud.gkehub.v1.Feature]
   * GKE Hub is currently available in the global region and all regions in
   * https://cloud.google.com/compute/docs/regions-zones. Feature is only
   * available in global region while membership is global region and all the
   * regions.
   * **Membership management may be non-trivial:** it is recommended to use one
   * of the Google-provided client libraries or tools where possible when working
   * with Membership resources.
   * </pre>
   */
  public abstract static class GkeHubImplBase implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return GkeHubGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service GkeHub.
   *
   * <pre>
   * The GKE Hub service handles the registration of many Kubernetes clusters to
   * Google Cloud, and the management of multi-cluster features over those
   * clusters.
   * The GKE Hub service operates on the following resources:
   * * [Membership][google.cloud.gkehub.v1.Membership]
   * * [Feature][google.cloud.gkehub.v1.Feature]
   * GKE Hub is currently available in the global region and all regions in
   * https://cloud.google.com/compute/docs/regions-zones. Feature is only
   * available in global region while membership is global region and all the
   * regions.
   * **Membership management may be non-trivial:** it is recommended to use one
   * of the Google-provided client libraries or tools where possible when working
   * with Membership resources.
   * </pre>
   */
  public static final class GkeHubStub extends io.grpc.stub.AbstractAsyncStub<GkeHubStub> {
    private GkeHubStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GkeHubStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GkeHubStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Memberships in a given project and location.
     * </pre>
     */
    public void listMemberships(
        com.google.cloud.gkehub.v1.ListMembershipsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.ListMembershipsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMembershipsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Memberships bound to a Scope. The response includes relevant
     * Memberships from all regions.
     * </pre>
     */
    public void listBoundMemberships(
        com.google.cloud.gkehub.v1.ListBoundMembershipsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.ListBoundMembershipsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListBoundMembershipsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Features in a given project and location.
     * </pre>
     */
    public void listFeatures(
        com.google.cloud.gkehub.v1.ListFeaturesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.ListFeaturesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListFeaturesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a Membership.
     * </pre>
     */
    public void getMembership(
        com.google.cloud.gkehub.v1.GetMembershipRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.Membership> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMembershipMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Feature.
     * </pre>
     */
    public void getFeature(
        com.google.cloud.gkehub.v1.GetFeatureRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.Feature> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFeatureMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Membership.
     * **This is currently only supported for GKE clusters on Google Cloud**.
     * To register other clusters, follow the instructions at
     * https://cloud.google.com/anthos/multicluster-management/connect/registering-a-cluster.
     * </pre>
     */
    public void createMembership(
        com.google.cloud.gkehub.v1.CreateMembershipRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateMembershipMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds a new Feature.
     * </pre>
     */
    public void createFeature(
        com.google.cloud.gkehub.v1.CreateFeatureRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateFeatureMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Removes a Membership.
     * **This is currently only supported for GKE clusters on Google Cloud**.
     * To unregister other clusters, follow the instructions at
     * https://cloud.google.com/anthos/multicluster-management/connect/unregistering-a-cluster.
     * </pre>
     */
    public void deleteMembership(
        com.google.cloud.gkehub.v1.DeleteMembershipRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteMembershipMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Removes a Feature.
     * </pre>
     */
    public void deleteFeature(
        com.google.cloud.gkehub.v1.DeleteFeatureRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteFeatureMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing Membership.
     * </pre>
     */
    public void updateMembership(
        com.google.cloud.gkehub.v1.UpdateMembershipRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateMembershipMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing Feature.
     * </pre>
     */
    public void updateFeature(
        com.google.cloud.gkehub.v1.UpdateFeatureRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateFeatureMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generates the manifest for deployment of the GKE connect agent.
     * **This method is used internally by Google-provided libraries.**
     * Most clients should not need to call this method directly.
     * </pre>
     */
    public void generateConnectManifest(
        com.google.cloud.gkehub.v1.GenerateConnectManifestRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.GenerateConnectManifestResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateConnectManifestMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a fleet.
     * </pre>
     */
    public void createFleet(
        com.google.cloud.gkehub.v1.CreateFleetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateFleetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the details of a fleet.
     * </pre>
     */
    public void getFleet(
        com.google.cloud.gkehub.v1.GetFleetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.Fleet> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFleetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a fleet.
     * </pre>
     */
    public void updateFleet(
        com.google.cloud.gkehub.v1.UpdateFleetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateFleetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Removes a Fleet. There must be no memberships remaining in the Fleet.
     * </pre>
     */
    public void deleteFleet(
        com.google.cloud.gkehub.v1.DeleteFleetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteFleetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns all fleets within an organization or a project that the caller has
     * access to.
     * </pre>
     */
    public void listFleets(
        com.google.cloud.gkehub.v1.ListFleetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.ListFleetsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListFleetsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the details of a fleet namespace.
     * </pre>
     */
    public void getScopeNamespace(
        com.google.cloud.gkehub.v1.GetScopeNamespaceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.Namespace> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetScopeNamespaceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a fleet namespace.
     * </pre>
     */
    public void createScopeNamespace(
        com.google.cloud.gkehub.v1.CreateScopeNamespaceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateScopeNamespaceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a fleet namespace.
     * </pre>
     */
    public void updateScopeNamespace(
        com.google.cloud.gkehub.v1.UpdateScopeNamespaceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateScopeNamespaceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a fleet namespace.
     * </pre>
     */
    public void deleteScopeNamespace(
        com.google.cloud.gkehub.v1.DeleteScopeNamespaceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteScopeNamespaceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists fleet namespaces.
     * </pre>
     */
    public void listScopeNamespaces(
        com.google.cloud.gkehub.v1.ListScopeNamespacesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.ListScopeNamespacesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListScopeNamespacesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the details of a Scope RBACRoleBinding.
     * </pre>
     */
    public void getScopeRBACRoleBinding(
        com.google.cloud.gkehub.v1.GetScopeRBACRoleBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.RBACRoleBinding> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetScopeRBACRoleBindingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a Scope RBACRoleBinding.
     * </pre>
     */
    public void createScopeRBACRoleBinding(
        com.google.cloud.gkehub.v1.CreateScopeRBACRoleBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateScopeRBACRoleBindingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a Scope RBACRoleBinding.
     * </pre>
     */
    public void updateScopeRBACRoleBinding(
        com.google.cloud.gkehub.v1.UpdateScopeRBACRoleBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateScopeRBACRoleBindingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Scope RBACRoleBinding.
     * </pre>
     */
    public void deleteScopeRBACRoleBinding(
        com.google.cloud.gkehub.v1.DeleteScopeRBACRoleBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteScopeRBACRoleBindingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all Scope RBACRoleBindings.
     * </pre>
     */
    public void listScopeRBACRoleBindings(
        com.google.cloud.gkehub.v1.ListScopeRBACRoleBindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.ListScopeRBACRoleBindingsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListScopeRBACRoleBindingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the details of a Scope.
     * </pre>
     */
    public void getScope(
        com.google.cloud.gkehub.v1.GetScopeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.Scope> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetScopeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a Scope.
     * </pre>
     */
    public void createScope(
        com.google.cloud.gkehub.v1.CreateScopeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateScopeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a scopes.
     * </pre>
     */
    public void updateScope(
        com.google.cloud.gkehub.v1.UpdateScopeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateScopeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Scope.
     * </pre>
     */
    public void deleteScope(
        com.google.cloud.gkehub.v1.DeleteScopeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteScopeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Scopes.
     * </pre>
     */
    public void listScopes(
        com.google.cloud.gkehub.v1.ListScopesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.ListScopesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListScopesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists permitted Scopes.
     * </pre>
     */
    public void listPermittedScopes(
        com.google.cloud.gkehub.v1.ListPermittedScopesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.ListPermittedScopesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPermittedScopesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the details of a MembershipBinding.
     * </pre>
     */
    public void getMembershipBinding(
        com.google.cloud.gkehub.v1.GetMembershipBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.MembershipBinding>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMembershipBindingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a MembershipBinding.
     * </pre>
     */
    public void createMembershipBinding(
        com.google.cloud.gkehub.v1.CreateMembershipBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateMembershipBindingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a MembershipBinding.
     * </pre>
     */
    public void updateMembershipBinding(
        com.google.cloud.gkehub.v1.UpdateMembershipBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateMembershipBindingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a MembershipBinding.
     * </pre>
     */
    public void deleteMembershipBinding(
        com.google.cloud.gkehub.v1.DeleteMembershipBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteMembershipBindingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists MembershipBindings.
     * </pre>
     */
    public void listMembershipBindings(
        com.google.cloud.gkehub.v1.ListMembershipBindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.ListMembershipBindingsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMembershipBindingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the details of a Membership RBACRoleBinding.
     * </pre>
     */
    public void getMembershipRBACRoleBinding(
        com.google.cloud.gkehub.v1.GetMembershipRBACRoleBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.RBACRoleBinding> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMembershipRBACRoleBindingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a Membership RBACRoleBinding.
     * </pre>
     */
    public void createMembershipRBACRoleBinding(
        com.google.cloud.gkehub.v1.CreateMembershipRBACRoleBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateMembershipRBACRoleBindingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a Membership RBACRoleBinding.
     * </pre>
     */
    public void updateMembershipRBACRoleBinding(
        com.google.cloud.gkehub.v1.UpdateMembershipRBACRoleBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateMembershipRBACRoleBindingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Membership RBACRoleBinding.
     * </pre>
     */
    public void deleteMembershipRBACRoleBinding(
        com.google.cloud.gkehub.v1.DeleteMembershipRBACRoleBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteMembershipRBACRoleBindingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all Membership RBACRoleBindings.
     * </pre>
     */
    public void listMembershipRBACRoleBindings(
        com.google.cloud.gkehub.v1.ListMembershipRBACRoleBindingsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.gkehub.v1.ListMembershipRBACRoleBindingsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMembershipRBACRoleBindingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generates a YAML of the  RBAC policies for the specified
     * RoleBinding and its associated impersonation resources.
     * </pre>
     */
    public void generateMembershipRBACRoleBindingYAML(
        com.google.cloud.gkehub.v1.GenerateMembershipRBACRoleBindingYAMLRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.gkehub.v1.GenerateMembershipRBACRoleBindingYAMLResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateMembershipRBACRoleBindingYAMLMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service GkeHub.
   *
   * <pre>
   * The GKE Hub service handles the registration of many Kubernetes clusters to
   * Google Cloud, and the management of multi-cluster features over those
   * clusters.
   * The GKE Hub service operates on the following resources:
   * * [Membership][google.cloud.gkehub.v1.Membership]
   * * [Feature][google.cloud.gkehub.v1.Feature]
   * GKE Hub is currently available in the global region and all regions in
   * https://cloud.google.com/compute/docs/regions-zones. Feature is only
   * available in global region while membership is global region and all the
   * regions.
   * **Membership management may be non-trivial:** it is recommended to use one
   * of the Google-provided client libraries or tools where possible when working
   * with Membership resources.
   * </pre>
   */
  public static final class GkeHubBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<GkeHubBlockingV2Stub> {
    private GkeHubBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GkeHubBlockingV2Stub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GkeHubBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Memberships in a given project and location.
     * </pre>
     */
    public com.google.cloud.gkehub.v1.ListMembershipsResponse listMemberships(
        com.google.cloud.gkehub.v1.ListMembershipsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListMembershipsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Memberships bound to a Scope. The response includes relevant
     * Memberships from all regions.
     * </pre>
     */
    public com.google.cloud.gkehub.v1.ListBoundMembershipsResponse listBoundMemberships(
        com.google.cloud.gkehub.v1.ListBoundMembershipsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListBoundMembershipsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Features in a given project and location.
     * </pre>
     */
    public com.google.cloud.gkehub.v1.ListFeaturesResponse listFeatures(
        com.google.cloud.gkehub.v1.ListFeaturesRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListFeaturesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a Membership.
     * </pre>
     */
    public com.google.cloud.gkehub.v1.Membership getMembership(
        com.google.cloud.gkehub.v1.GetMembershipRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetMembershipMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Feature.
     * </pre>
     */
    public com.google.cloud.gkehub.v1.Feature getFeature(
        com.google.cloud.gkehub.v1.GetFeatureRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetFeatureMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Membership.
     * **This is currently only supported for GKE clusters on Google Cloud**.
     * To register other clusters, follow the instructions at
     * https://cloud.google.com/anthos/multicluster-management/connect/registering-a-cluster.
     * </pre>
     */
    public com.google.longrunning.Operation createMembership(
        com.google.cloud.gkehub.v1.CreateMembershipRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateMembershipMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Adds a new Feature.
     * </pre>
     */
    public com.google.longrunning.Operation createFeature(
        com.google.cloud.gkehub.v1.CreateFeatureRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateFeatureMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Removes a Membership.
     * **This is currently only supported for GKE clusters on Google Cloud**.
     * To unregister other clusters, follow the instructions at
     * https://cloud.google.com/anthos/multicluster-management/connect/unregistering-a-cluster.
     * </pre>
     */
    public com.google.longrunning.Operation deleteMembership(
        com.google.cloud.gkehub.v1.DeleteMembershipRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteMembershipMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Removes a Feature.
     * </pre>
     */
    public com.google.longrunning.Operation deleteFeature(
        com.google.cloud.gkehub.v1.DeleteFeatureRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteFeatureMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing Membership.
     * </pre>
     */
    public com.google.longrunning.Operation updateMembership(
        com.google.cloud.gkehub.v1.UpdateMembershipRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateMembershipMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing Feature.
     * </pre>
     */
    public com.google.longrunning.Operation updateFeature(
        com.google.cloud.gkehub.v1.UpdateFeatureRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateFeatureMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Generates the manifest for deployment of the GKE connect agent.
     * **This method is used internally by Google-provided libraries.**
     * Most clients should not need to call this method directly.
     * </pre>
     */
    public com.google.cloud.gkehub.v1.GenerateConnectManifestResponse generateConnectManifest(
        com.google.cloud.gkehub.v1.GenerateConnectManifestRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGenerateConnectManifestMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a fleet.
     * </pre>
     */
    public com.google.longrunning.Operation createFleet(
        com.google.cloud.gkehub.v1.CreateFleetRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateFleetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the details of a fleet.
     * </pre>
     */
    public com.google.cloud.gkehub.v1.Fleet getFleet(
        com.google.cloud.gkehub.v1.GetFleetRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetFleetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a fleet.
     * </pre>
     */
    public com.google.longrunning.Operation updateFleet(
        com.google.cloud.gkehub.v1.UpdateFleetRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateFleetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Removes a Fleet. There must be no memberships remaining in the Fleet.
     * </pre>
     */
    public com.google.longrunning.Operation deleteFleet(
        com.google.cloud.gkehub.v1.DeleteFleetRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteFleetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns all fleets within an organization or a project that the caller has
     * access to.
     * </pre>
     */
    public com.google.cloud.gkehub.v1.ListFleetsResponse listFleets(
        com.google.cloud.gkehub.v1.ListFleetsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListFleetsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the details of a fleet namespace.
     * </pre>
     */
    public com.google.cloud.gkehub.v1.Namespace getScopeNamespace(
        com.google.cloud.gkehub.v1.GetScopeNamespaceRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetScopeNamespaceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a fleet namespace.
     * </pre>
     */
    public com.google.longrunning.Operation createScopeNamespace(
        com.google.cloud.gkehub.v1.CreateScopeNamespaceRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateScopeNamespaceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a fleet namespace.
     * </pre>
     */
    public com.google.longrunning.Operation updateScopeNamespace(
        com.google.cloud.gkehub.v1.UpdateScopeNamespaceRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateScopeNamespaceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a fleet namespace.
     * </pre>
     */
    public com.google.longrunning.Operation deleteScopeNamespace(
        com.google.cloud.gkehub.v1.DeleteScopeNamespaceRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteScopeNamespaceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists fleet namespaces.
     * </pre>
     */
    public com.google.cloud.gkehub.v1.ListScopeNamespacesResponse listScopeNamespaces(
        com.google.cloud.gkehub.v1.ListScopeNamespacesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListScopeNamespacesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the details of a Scope RBACRoleBinding.
     * </pre>
     */
    public com.google.cloud.gkehub.v1.RBACRoleBinding getScopeRBACRoleBinding(
        com.google.cloud.gkehub.v1.GetScopeRBACRoleBindingRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetScopeRBACRoleBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a Scope RBACRoleBinding.
     * </pre>
     */
    public com.google.longrunning.Operation createScopeRBACRoleBinding(
        com.google.cloud.gkehub.v1.CreateScopeRBACRoleBindingRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateScopeRBACRoleBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a Scope RBACRoleBinding.
     * </pre>
     */
    public com.google.longrunning.Operation updateScopeRBACRoleBinding(
        com.google.cloud.gkehub.v1.UpdateScopeRBACRoleBindingRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateScopeRBACRoleBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Scope RBACRoleBinding.
     * </pre>
     */
    public com.google.longrunning.Operation deleteScopeRBACRoleBinding(
        com.google.cloud.gkehub.v1.DeleteScopeRBACRoleBindingRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteScopeRBACRoleBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all Scope RBACRoleBindings.
     * </pre>
     */
    public com.google.cloud.gkehub.v1.ListScopeRBACRoleBindingsResponse listScopeRBACRoleBindings(
        com.google.cloud.gkehub.v1.ListScopeRBACRoleBindingsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListScopeRBACRoleBindingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the details of a Scope.
     * </pre>
     */
    public com.google.cloud.gkehub.v1.Scope getScope(
        com.google.cloud.gkehub.v1.GetScopeRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetScopeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a Scope.
     * </pre>
     */
    public com.google.longrunning.Operation createScope(
        com.google.cloud.gkehub.v1.CreateScopeRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateScopeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a scopes.
     * </pre>
     */
    public com.google.longrunning.Operation updateScope(
        com.google.cloud.gkehub.v1.UpdateScopeRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateScopeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Scope.
     * </pre>
     */
    public com.google.longrunning.Operation deleteScope(
        com.google.cloud.gkehub.v1.DeleteScopeRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteScopeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Scopes.
     * </pre>
     */
    public com.google.cloud.gkehub.v1.ListScopesResponse listScopes(
        com.google.cloud.gkehub.v1.ListScopesRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListScopesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists permitted Scopes.
     * </pre>
     */
    public com.google.cloud.gkehub.v1.ListPermittedScopesResponse listPermittedScopes(
        com.google.cloud.gkehub.v1.ListPermittedScopesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListPermittedScopesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the details of a MembershipBinding.
     * </pre>
     */
    public com.google.cloud.gkehub.v1.MembershipBinding getMembershipBinding(
        com.google.cloud.gkehub.v1.GetMembershipBindingRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetMembershipBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a MembershipBinding.
     * </pre>
     */
    public com.google.longrunning.Operation createMembershipBinding(
        com.google.cloud.gkehub.v1.CreateMembershipBindingRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateMembershipBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a MembershipBinding.
     * </pre>
     */
    public com.google.longrunning.Operation updateMembershipBinding(
        com.google.cloud.gkehub.v1.UpdateMembershipBindingRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateMembershipBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a MembershipBinding.
     * </pre>
     */
    public com.google.longrunning.Operation deleteMembershipBinding(
        com.google.cloud.gkehub.v1.DeleteMembershipBindingRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteMembershipBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists MembershipBindings.
     * </pre>
     */
    public com.google.cloud.gkehub.v1.ListMembershipBindingsResponse listMembershipBindings(
        com.google.cloud.gkehub.v1.ListMembershipBindingsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListMembershipBindingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the details of a Membership RBACRoleBinding.
     * </pre>
     */
    public com.google.cloud.gkehub.v1.RBACRoleBinding getMembershipRBACRoleBinding(
        com.google.cloud.gkehub.v1.GetMembershipRBACRoleBindingRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetMembershipRBACRoleBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a Membership RBACRoleBinding.
     * </pre>
     */
    public com.google.longrunning.Operation createMembershipRBACRoleBinding(
        com.google.cloud.gkehub.v1.CreateMembershipRBACRoleBindingRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateMembershipRBACRoleBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a Membership RBACRoleBinding.
     * </pre>
     */
    public com.google.longrunning.Operation updateMembershipRBACRoleBinding(
        com.google.cloud.gkehub.v1.UpdateMembershipRBACRoleBindingRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateMembershipRBACRoleBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Membership RBACRoleBinding.
     * </pre>
     */
    public com.google.longrunning.Operation deleteMembershipRBACRoleBinding(
        com.google.cloud.gkehub.v1.DeleteMembershipRBACRoleBindingRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteMembershipRBACRoleBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all Membership RBACRoleBindings.
     * </pre>
     */
    public com.google.cloud.gkehub.v1.ListMembershipRBACRoleBindingsResponse
        listMembershipRBACRoleBindings(
            com.google.cloud.gkehub.v1.ListMembershipRBACRoleBindingsRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListMembershipRBACRoleBindingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Generates a YAML of the  RBAC policies for the specified
     * RoleBinding and its associated impersonation resources.
     * </pre>
     */
    public com.google.cloud.gkehub.v1.GenerateMembershipRBACRoleBindingYAMLResponse
        generateMembershipRBACRoleBindingYAML(
            com.google.cloud.gkehub.v1.GenerateMembershipRBACRoleBindingYAMLRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(),
          getGenerateMembershipRBACRoleBindingYAMLMethod(),
          getCallOptions(),
          request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service GkeHub.
   *
   * <pre>
   * The GKE Hub service handles the registration of many Kubernetes clusters to
   * Google Cloud, and the management of multi-cluster features over those
   * clusters.
   * The GKE Hub service operates on the following resources:
   * * [Membership][google.cloud.gkehub.v1.Membership]
   * * [Feature][google.cloud.gkehub.v1.Feature]
   * GKE Hub is currently available in the global region and all regions in
   * https://cloud.google.com/compute/docs/regions-zones. Feature is only
   * available in global region while membership is global region and all the
   * regions.
   * **Membership management may be non-trivial:** it is recommended to use one
   * of the Google-provided client libraries or tools where possible when working
   * with Membership resources.
   * </pre>
   */
  public static final class GkeHubBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<GkeHubBlockingStub> {
    private GkeHubBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GkeHubBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GkeHubBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Memberships in a given project and location.
     * </pre>
     */
    public com.google.cloud.gkehub.v1.ListMembershipsResponse listMemberships(
        com.google.cloud.gkehub.v1.ListMembershipsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMembershipsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Memberships bound to a Scope. The response includes relevant
     * Memberships from all regions.
     * </pre>
     */
    public com.google.cloud.gkehub.v1.ListBoundMembershipsResponse listBoundMemberships(
        com.google.cloud.gkehub.v1.ListBoundMembershipsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBoundMembershipsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Features in a given project and location.
     * </pre>
     */
    public com.google.cloud.gkehub.v1.ListFeaturesResponse listFeatures(
        com.google.cloud.gkehub.v1.ListFeaturesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFeaturesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a Membership.
     * </pre>
     */
    public com.google.cloud.gkehub.v1.Membership getMembership(
        com.google.cloud.gkehub.v1.GetMembershipRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMembershipMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Feature.
     * </pre>
     */
    public com.google.cloud.gkehub.v1.Feature getFeature(
        com.google.cloud.gkehub.v1.GetFeatureRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFeatureMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Membership.
     * **This is currently only supported for GKE clusters on Google Cloud**.
     * To register other clusters, follow the instructions at
     * https://cloud.google.com/anthos/multicluster-management/connect/registering-a-cluster.
     * </pre>
     */
    public com.google.longrunning.Operation createMembership(
        com.google.cloud.gkehub.v1.CreateMembershipRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMembershipMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Adds a new Feature.
     * </pre>
     */
    public com.google.longrunning.Operation createFeature(
        com.google.cloud.gkehub.v1.CreateFeatureRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateFeatureMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Removes a Membership.
     * **This is currently only supported for GKE clusters on Google Cloud**.
     * To unregister other clusters, follow the instructions at
     * https://cloud.google.com/anthos/multicluster-management/connect/unregistering-a-cluster.
     * </pre>
     */
    public com.google.longrunning.Operation deleteMembership(
        com.google.cloud.gkehub.v1.DeleteMembershipRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMembershipMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Removes a Feature.
     * </pre>
     */
    public com.google.longrunning.Operation deleteFeature(
        com.google.cloud.gkehub.v1.DeleteFeatureRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteFeatureMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing Membership.
     * </pre>
     */
    public com.google.longrunning.Operation updateMembership(
        com.google.cloud.gkehub.v1.UpdateMembershipRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateMembershipMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing Feature.
     * </pre>
     */
    public com.google.longrunning.Operation updateFeature(
        com.google.cloud.gkehub.v1.UpdateFeatureRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateFeatureMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Generates the manifest for deployment of the GKE connect agent.
     * **This method is used internally by Google-provided libraries.**
     * Most clients should not need to call this method directly.
     * </pre>
     */
    public com.google.cloud.gkehub.v1.GenerateConnectManifestResponse generateConnectManifest(
        com.google.cloud.gkehub.v1.GenerateConnectManifestRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateConnectManifestMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a fleet.
     * </pre>
     */
    public com.google.longrunning.Operation createFleet(
        com.google.cloud.gkehub.v1.CreateFleetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateFleetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the details of a fleet.
     * </pre>
     */
    public com.google.cloud.gkehub.v1.Fleet getFleet(
        com.google.cloud.gkehub.v1.GetFleetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFleetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a fleet.
     * </pre>
     */
    public com.google.longrunning.Operation updateFleet(
        com.google.cloud.gkehub.v1.UpdateFleetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateFleetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Removes a Fleet. There must be no memberships remaining in the Fleet.
     * </pre>
     */
    public com.google.longrunning.Operation deleteFleet(
        com.google.cloud.gkehub.v1.DeleteFleetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteFleetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns all fleets within an organization or a project that the caller has
     * access to.
     * </pre>
     */
    public com.google.cloud.gkehub.v1.ListFleetsResponse listFleets(
        com.google.cloud.gkehub.v1.ListFleetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFleetsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the details of a fleet namespace.
     * </pre>
     */
    public com.google.cloud.gkehub.v1.Namespace getScopeNamespace(
        com.google.cloud.gkehub.v1.GetScopeNamespaceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetScopeNamespaceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a fleet namespace.
     * </pre>
     */
    public com.google.longrunning.Operation createScopeNamespace(
        com.google.cloud.gkehub.v1.CreateScopeNamespaceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateScopeNamespaceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a fleet namespace.
     * </pre>
     */
    public com.google.longrunning.Operation updateScopeNamespace(
        com.google.cloud.gkehub.v1.UpdateScopeNamespaceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateScopeNamespaceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a fleet namespace.
     * </pre>
     */
    public com.google.longrunning.Operation deleteScopeNamespace(
        com.google.cloud.gkehub.v1.DeleteScopeNamespaceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteScopeNamespaceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists fleet namespaces.
     * </pre>
     */
    public com.google.cloud.gkehub.v1.ListScopeNamespacesResponse listScopeNamespaces(
        com.google.cloud.gkehub.v1.ListScopeNamespacesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListScopeNamespacesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the details of a Scope RBACRoleBinding.
     * </pre>
     */
    public com.google.cloud.gkehub.v1.RBACRoleBinding getScopeRBACRoleBinding(
        com.google.cloud.gkehub.v1.GetScopeRBACRoleBindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetScopeRBACRoleBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a Scope RBACRoleBinding.
     * </pre>
     */
    public com.google.longrunning.Operation createScopeRBACRoleBinding(
        com.google.cloud.gkehub.v1.CreateScopeRBACRoleBindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateScopeRBACRoleBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a Scope RBACRoleBinding.
     * </pre>
     */
    public com.google.longrunning.Operation updateScopeRBACRoleBinding(
        com.google.cloud.gkehub.v1.UpdateScopeRBACRoleBindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateScopeRBACRoleBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Scope RBACRoleBinding.
     * </pre>
     */
    public com.google.longrunning.Operation deleteScopeRBACRoleBinding(
        com.google.cloud.gkehub.v1.DeleteScopeRBACRoleBindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteScopeRBACRoleBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all Scope RBACRoleBindings.
     * </pre>
     */
    public com.google.cloud.gkehub.v1.ListScopeRBACRoleBindingsResponse listScopeRBACRoleBindings(
        com.google.cloud.gkehub.v1.ListScopeRBACRoleBindingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListScopeRBACRoleBindingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the details of a Scope.
     * </pre>
     */
    public com.google.cloud.gkehub.v1.Scope getScope(
        com.google.cloud.gkehub.v1.GetScopeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetScopeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a Scope.
     * </pre>
     */
    public com.google.longrunning.Operation createScope(
        com.google.cloud.gkehub.v1.CreateScopeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateScopeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a scopes.
     * </pre>
     */
    public com.google.longrunning.Operation updateScope(
        com.google.cloud.gkehub.v1.UpdateScopeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateScopeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Scope.
     * </pre>
     */
    public com.google.longrunning.Operation deleteScope(
        com.google.cloud.gkehub.v1.DeleteScopeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteScopeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Scopes.
     * </pre>
     */
    public com.google.cloud.gkehub.v1.ListScopesResponse listScopes(
        com.google.cloud.gkehub.v1.ListScopesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListScopesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists permitted Scopes.
     * </pre>
     */
    public com.google.cloud.gkehub.v1.ListPermittedScopesResponse listPermittedScopes(
        com.google.cloud.gkehub.v1.ListPermittedScopesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPermittedScopesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the details of a MembershipBinding.
     * </pre>
     */
    public com.google.cloud.gkehub.v1.MembershipBinding getMembershipBinding(
        com.google.cloud.gkehub.v1.GetMembershipBindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMembershipBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a MembershipBinding.
     * </pre>
     */
    public com.google.longrunning.Operation createMembershipBinding(
        com.google.cloud.gkehub.v1.CreateMembershipBindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMembershipBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a MembershipBinding.
     * </pre>
     */
    public com.google.longrunning.Operation updateMembershipBinding(
        com.google.cloud.gkehub.v1.UpdateMembershipBindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateMembershipBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a MembershipBinding.
     * </pre>
     */
    public com.google.longrunning.Operation deleteMembershipBinding(
        com.google.cloud.gkehub.v1.DeleteMembershipBindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMembershipBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists MembershipBindings.
     * </pre>
     */
    public com.google.cloud.gkehub.v1.ListMembershipBindingsResponse listMembershipBindings(
        com.google.cloud.gkehub.v1.ListMembershipBindingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMembershipBindingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the details of a Membership RBACRoleBinding.
     * </pre>
     */
    public com.google.cloud.gkehub.v1.RBACRoleBinding getMembershipRBACRoleBinding(
        com.google.cloud.gkehub.v1.GetMembershipRBACRoleBindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMembershipRBACRoleBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a Membership RBACRoleBinding.
     * </pre>
     */
    public com.google.longrunning.Operation createMembershipRBACRoleBinding(
        com.google.cloud.gkehub.v1.CreateMembershipRBACRoleBindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMembershipRBACRoleBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a Membership RBACRoleBinding.
     * </pre>
     */
    public com.google.longrunning.Operation updateMembershipRBACRoleBinding(
        com.google.cloud.gkehub.v1.UpdateMembershipRBACRoleBindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateMembershipRBACRoleBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Membership RBACRoleBinding.
     * </pre>
     */
    public com.google.longrunning.Operation deleteMembershipRBACRoleBinding(
        com.google.cloud.gkehub.v1.DeleteMembershipRBACRoleBindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMembershipRBACRoleBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all Membership RBACRoleBindings.
     * </pre>
     */
    public com.google.cloud.gkehub.v1.ListMembershipRBACRoleBindingsResponse
        listMembershipRBACRoleBindings(
            com.google.cloud.gkehub.v1.ListMembershipRBACRoleBindingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMembershipRBACRoleBindingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Generates a YAML of the  RBAC policies for the specified
     * RoleBinding and its associated impersonation resources.
     * </pre>
     */
    public com.google.cloud.gkehub.v1.GenerateMembershipRBACRoleBindingYAMLResponse
        generateMembershipRBACRoleBindingYAML(
            com.google.cloud.gkehub.v1.GenerateMembershipRBACRoleBindingYAMLRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getGenerateMembershipRBACRoleBindingYAMLMethod(),
          getCallOptions(),
          request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service GkeHub.
   *
   * <pre>
   * The GKE Hub service handles the registration of many Kubernetes clusters to
   * Google Cloud, and the management of multi-cluster features over those
   * clusters.
   * The GKE Hub service operates on the following resources:
   * * [Membership][google.cloud.gkehub.v1.Membership]
   * * [Feature][google.cloud.gkehub.v1.Feature]
   * GKE Hub is currently available in the global region and all regions in
   * https://cloud.google.com/compute/docs/regions-zones. Feature is only
   * available in global region while membership is global region and all the
   * regions.
   * **Membership management may be non-trivial:** it is recommended to use one
   * of the Google-provided client libraries or tools where possible when working
   * with Membership resources.
   * </pre>
   */
  public static final class GkeHubFutureStub
      extends io.grpc.stub.AbstractFutureStub<GkeHubFutureStub> {
    private GkeHubFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GkeHubFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GkeHubFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Memberships in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gkehub.v1.ListMembershipsResponse>
        listMemberships(com.google.cloud.gkehub.v1.ListMembershipsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMembershipsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Memberships bound to a Scope. The response includes relevant
     * Memberships from all regions.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gkehub.v1.ListBoundMembershipsResponse>
        listBoundMemberships(com.google.cloud.gkehub.v1.ListBoundMembershipsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListBoundMembershipsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Features in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gkehub.v1.ListFeaturesResponse>
        listFeatures(com.google.cloud.gkehub.v1.ListFeaturesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListFeaturesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a Membership.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.gkehub.v1.Membership>
        getMembership(com.google.cloud.gkehub.v1.GetMembershipRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMembershipMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Feature.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.gkehub.v1.Feature>
        getFeature(com.google.cloud.gkehub.v1.GetFeatureRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFeatureMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Membership.
     * **This is currently only supported for GKE clusters on Google Cloud**.
     * To register other clusters, follow the instructions at
     * https://cloud.google.com/anthos/multicluster-management/connect/registering-a-cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createMembership(com.google.cloud.gkehub.v1.CreateMembershipRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateMembershipMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Adds a new Feature.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createFeature(com.google.cloud.gkehub.v1.CreateFeatureRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateFeatureMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Removes a Membership.
     * **This is currently only supported for GKE clusters on Google Cloud**.
     * To unregister other clusters, follow the instructions at
     * https://cloud.google.com/anthos/multicluster-management/connect/unregistering-a-cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteMembership(com.google.cloud.gkehub.v1.DeleteMembershipRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteMembershipMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Removes a Feature.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteFeature(com.google.cloud.gkehub.v1.DeleteFeatureRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteFeatureMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing Membership.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateMembership(com.google.cloud.gkehub.v1.UpdateMembershipRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateMembershipMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing Feature.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateFeature(com.google.cloud.gkehub.v1.UpdateFeatureRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateFeatureMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Generates the manifest for deployment of the GKE connect agent.
     * **This method is used internally by Google-provided libraries.**
     * Most clients should not need to call this method directly.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gkehub.v1.GenerateConnectManifestResponse>
        generateConnectManifest(com.google.cloud.gkehub.v1.GenerateConnectManifestRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateConnectManifestMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a fleet.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createFleet(com.google.cloud.gkehub.v1.CreateFleetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateFleetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the details of a fleet.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.gkehub.v1.Fleet>
        getFleet(com.google.cloud.gkehub.v1.GetFleetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFleetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a fleet.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateFleet(com.google.cloud.gkehub.v1.UpdateFleetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateFleetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Removes a Fleet. There must be no memberships remaining in the Fleet.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteFleet(com.google.cloud.gkehub.v1.DeleteFleetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteFleetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns all fleets within an organization or a project that the caller has
     * access to.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gkehub.v1.ListFleetsResponse>
        listFleets(com.google.cloud.gkehub.v1.ListFleetsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListFleetsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the details of a fleet namespace.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.gkehub.v1.Namespace>
        getScopeNamespace(com.google.cloud.gkehub.v1.GetScopeNamespaceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetScopeNamespaceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a fleet namespace.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createScopeNamespace(com.google.cloud.gkehub.v1.CreateScopeNamespaceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateScopeNamespaceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a fleet namespace.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateScopeNamespace(com.google.cloud.gkehub.v1.UpdateScopeNamespaceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateScopeNamespaceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a fleet namespace.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteScopeNamespace(com.google.cloud.gkehub.v1.DeleteScopeNamespaceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteScopeNamespaceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists fleet namespaces.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gkehub.v1.ListScopeNamespacesResponse>
        listScopeNamespaces(com.google.cloud.gkehub.v1.ListScopeNamespacesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListScopeNamespacesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the details of a Scope RBACRoleBinding.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gkehub.v1.RBACRoleBinding>
        getScopeRBACRoleBinding(com.google.cloud.gkehub.v1.GetScopeRBACRoleBindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetScopeRBACRoleBindingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a Scope RBACRoleBinding.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createScopeRBACRoleBinding(
            com.google.cloud.gkehub.v1.CreateScopeRBACRoleBindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateScopeRBACRoleBindingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a Scope RBACRoleBinding.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateScopeRBACRoleBinding(
            com.google.cloud.gkehub.v1.UpdateScopeRBACRoleBindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateScopeRBACRoleBindingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Scope RBACRoleBinding.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteScopeRBACRoleBinding(
            com.google.cloud.gkehub.v1.DeleteScopeRBACRoleBindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteScopeRBACRoleBindingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all Scope RBACRoleBindings.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gkehub.v1.ListScopeRBACRoleBindingsResponse>
        listScopeRBACRoleBindings(
            com.google.cloud.gkehub.v1.ListScopeRBACRoleBindingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListScopeRBACRoleBindingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the details of a Scope.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.gkehub.v1.Scope>
        getScope(com.google.cloud.gkehub.v1.GetScopeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetScopeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a Scope.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createScope(com.google.cloud.gkehub.v1.CreateScopeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateScopeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a scopes.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateScope(com.google.cloud.gkehub.v1.UpdateScopeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateScopeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Scope.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteScope(com.google.cloud.gkehub.v1.DeleteScopeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteScopeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Scopes.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gkehub.v1.ListScopesResponse>
        listScopes(com.google.cloud.gkehub.v1.ListScopesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListScopesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists permitted Scopes.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gkehub.v1.ListPermittedScopesResponse>
        listPermittedScopes(com.google.cloud.gkehub.v1.ListPermittedScopesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPermittedScopesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the details of a MembershipBinding.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gkehub.v1.MembershipBinding>
        getMembershipBinding(com.google.cloud.gkehub.v1.GetMembershipBindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMembershipBindingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a MembershipBinding.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createMembershipBinding(com.google.cloud.gkehub.v1.CreateMembershipBindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateMembershipBindingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a MembershipBinding.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateMembershipBinding(com.google.cloud.gkehub.v1.UpdateMembershipBindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateMembershipBindingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a MembershipBinding.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteMembershipBinding(com.google.cloud.gkehub.v1.DeleteMembershipBindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteMembershipBindingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists MembershipBindings.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gkehub.v1.ListMembershipBindingsResponse>
        listMembershipBindings(com.google.cloud.gkehub.v1.ListMembershipBindingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMembershipBindingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the details of a Membership RBACRoleBinding.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gkehub.v1.RBACRoleBinding>
        getMembershipRBACRoleBinding(
            com.google.cloud.gkehub.v1.GetMembershipRBACRoleBindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMembershipRBACRoleBindingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a Membership RBACRoleBinding.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createMembershipRBACRoleBinding(
            com.google.cloud.gkehub.v1.CreateMembershipRBACRoleBindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateMembershipRBACRoleBindingMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Updates a Membership RBACRoleBinding.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateMembershipRBACRoleBinding(
            com.google.cloud.gkehub.v1.UpdateMembershipRBACRoleBindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateMembershipRBACRoleBindingMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Membership RBACRoleBinding.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteMembershipRBACRoleBinding(
            com.google.cloud.gkehub.v1.DeleteMembershipRBACRoleBindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteMembershipRBACRoleBindingMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists all Membership RBACRoleBindings.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gkehub.v1.ListMembershipRBACRoleBindingsResponse>
        listMembershipRBACRoleBindings(
            com.google.cloud.gkehub.v1.ListMembershipRBACRoleBindingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMembershipRBACRoleBindingsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Generates a YAML of the  RBAC policies for the specified
     * RoleBinding and its associated impersonation resources.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gkehub.v1.GenerateMembershipRBACRoleBindingYAMLResponse>
        generateMembershipRBACRoleBindingYAML(
            com.google.cloud.gkehub.v1.GenerateMembershipRBACRoleBindingYAMLRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateMembershipRBACRoleBindingYAMLMethod(), getCallOptions()),
          request);
    }
  }

  private static final int METHODID_LIST_MEMBERSHIPS = 0;
  private static final int METHODID_LIST_BOUND_MEMBERSHIPS = 1;
  private static final int METHODID_LIST_FEATURES = 2;
  private static final int METHODID_GET_MEMBERSHIP = 3;
  private static final int METHODID_GET_FEATURE = 4;
  private static final int METHODID_CREATE_MEMBERSHIP = 5;
  private static final int METHODID_CREATE_FEATURE = 6;
  private static final int METHODID_DELETE_MEMBERSHIP = 7;
  private static final int METHODID_DELETE_FEATURE = 8;
  private static final int METHODID_UPDATE_MEMBERSHIP = 9;
  private static final int METHODID_UPDATE_FEATURE = 10;
  private static final int METHODID_GENERATE_CONNECT_MANIFEST = 11;
  private static final int METHODID_CREATE_FLEET = 12;
  private static final int METHODID_GET_FLEET = 13;
  private static final int METHODID_UPDATE_FLEET = 14;
  private static final int METHODID_DELETE_FLEET = 15;
  private static final int METHODID_LIST_FLEETS = 16;
  private static final int METHODID_GET_SCOPE_NAMESPACE = 17;
  private static final int METHODID_CREATE_SCOPE_NAMESPACE = 18;
  private static final int METHODID_UPDATE_SCOPE_NAMESPACE = 19;
  private static final int METHODID_DELETE_SCOPE_NAMESPACE = 20;
  private static final int METHODID_LIST_SCOPE_NAMESPACES = 21;
  private static final int METHODID_GET_SCOPE_RBACROLE_BINDING = 22;
  private static final int METHODID_CREATE_SCOPE_RBACROLE_BINDING = 23;
  private static final int METHODID_UPDATE_SCOPE_RBACROLE_BINDING = 24;
  private static final int METHODID_DELETE_SCOPE_RBACROLE_BINDING = 25;
  private static final int METHODID_LIST_SCOPE_RBACROLE_BINDINGS = 26;
  private static final int METHODID_GET_SCOPE = 27;
  private static final int METHODID_CREATE_SCOPE = 28;
  private static final int METHODID_UPDATE_SCOPE = 29;
  private static final int METHODID_DELETE_SCOPE = 30;
  private static final int METHODID_LIST_SCOPES = 31;
  private static final int METHODID_LIST_PERMITTED_SCOPES = 32;
  private static final int METHODID_GET_MEMBERSHIP_BINDING = 33;
  private static final int METHODID_CREATE_MEMBERSHIP_BINDING = 34;
  private static final int METHODID_UPDATE_MEMBERSHIP_BINDING = 35;
  private static final int METHODID_DELETE_MEMBERSHIP_BINDING = 36;
  private static final int METHODID_LIST_MEMBERSHIP_BINDINGS = 37;
  private static final int METHODID_GET_MEMBERSHIP_RBACROLE_BINDING = 38;
  private static final int METHODID_CREATE_MEMBERSHIP_RBACROLE_BINDING = 39;
  private static final int METHODID_UPDATE_MEMBERSHIP_RBACROLE_BINDING = 40;
  private static final int METHODID_DELETE_MEMBERSHIP_RBACROLE_BINDING = 41;
  private static final int METHODID_LIST_MEMBERSHIP_RBACROLE_BINDINGS = 42;
  private static final int METHODID_GENERATE_MEMBERSHIP_RBACROLE_BINDING_YAML = 43;

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
        case METHODID_LIST_MEMBERSHIPS:
          serviceImpl.listMemberships(
              (com.google.cloud.gkehub.v1.ListMembershipsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.ListMembershipsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_BOUND_MEMBERSHIPS:
          serviceImpl.listBoundMemberships(
              (com.google.cloud.gkehub.v1.ListBoundMembershipsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.ListBoundMembershipsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_FEATURES:
          serviceImpl.listFeatures(
              (com.google.cloud.gkehub.v1.ListFeaturesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.ListFeaturesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_MEMBERSHIP:
          serviceImpl.getMembership(
              (com.google.cloud.gkehub.v1.GetMembershipRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.Membership>)
                  responseObserver);
          break;
        case METHODID_GET_FEATURE:
          serviceImpl.getFeature(
              (com.google.cloud.gkehub.v1.GetFeatureRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.Feature>) responseObserver);
          break;
        case METHODID_CREATE_MEMBERSHIP:
          serviceImpl.createMembership(
              (com.google.cloud.gkehub.v1.CreateMembershipRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_FEATURE:
          serviceImpl.createFeature(
              (com.google.cloud.gkehub.v1.CreateFeatureRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_MEMBERSHIP:
          serviceImpl.deleteMembership(
              (com.google.cloud.gkehub.v1.DeleteMembershipRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_FEATURE:
          serviceImpl.deleteFeature(
              (com.google.cloud.gkehub.v1.DeleteFeatureRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_MEMBERSHIP:
          serviceImpl.updateMembership(
              (com.google.cloud.gkehub.v1.UpdateMembershipRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_FEATURE:
          serviceImpl.updateFeature(
              (com.google.cloud.gkehub.v1.UpdateFeatureRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GENERATE_CONNECT_MANIFEST:
          serviceImpl.generateConnectManifest(
              (com.google.cloud.gkehub.v1.GenerateConnectManifestRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.gkehub.v1.GenerateConnectManifestResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_FLEET:
          serviceImpl.createFleet(
              (com.google.cloud.gkehub.v1.CreateFleetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_FLEET:
          serviceImpl.getFleet(
              (com.google.cloud.gkehub.v1.GetFleetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.Fleet>) responseObserver);
          break;
        case METHODID_UPDATE_FLEET:
          serviceImpl.updateFleet(
              (com.google.cloud.gkehub.v1.UpdateFleetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_FLEET:
          serviceImpl.deleteFleet(
              (com.google.cloud.gkehub.v1.DeleteFleetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_FLEETS:
          serviceImpl.listFleets(
              (com.google.cloud.gkehub.v1.ListFleetsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.ListFleetsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_SCOPE_NAMESPACE:
          serviceImpl.getScopeNamespace(
              (com.google.cloud.gkehub.v1.GetScopeNamespaceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.Namespace>) responseObserver);
          break;
        case METHODID_CREATE_SCOPE_NAMESPACE:
          serviceImpl.createScopeNamespace(
              (com.google.cloud.gkehub.v1.CreateScopeNamespaceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_SCOPE_NAMESPACE:
          serviceImpl.updateScopeNamespace(
              (com.google.cloud.gkehub.v1.UpdateScopeNamespaceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_SCOPE_NAMESPACE:
          serviceImpl.deleteScopeNamespace(
              (com.google.cloud.gkehub.v1.DeleteScopeNamespaceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_SCOPE_NAMESPACES:
          serviceImpl.listScopeNamespaces(
              (com.google.cloud.gkehub.v1.ListScopeNamespacesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.ListScopeNamespacesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_SCOPE_RBACROLE_BINDING:
          serviceImpl.getScopeRBACRoleBinding(
              (com.google.cloud.gkehub.v1.GetScopeRBACRoleBindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.RBACRoleBinding>)
                  responseObserver);
          break;
        case METHODID_CREATE_SCOPE_RBACROLE_BINDING:
          serviceImpl.createScopeRBACRoleBinding(
              (com.google.cloud.gkehub.v1.CreateScopeRBACRoleBindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_SCOPE_RBACROLE_BINDING:
          serviceImpl.updateScopeRBACRoleBinding(
              (com.google.cloud.gkehub.v1.UpdateScopeRBACRoleBindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_SCOPE_RBACROLE_BINDING:
          serviceImpl.deleteScopeRBACRoleBinding(
              (com.google.cloud.gkehub.v1.DeleteScopeRBACRoleBindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_SCOPE_RBACROLE_BINDINGS:
          serviceImpl.listScopeRBACRoleBindings(
              (com.google.cloud.gkehub.v1.ListScopeRBACRoleBindingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.gkehub.v1.ListScopeRBACRoleBindingsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_SCOPE:
          serviceImpl.getScope(
              (com.google.cloud.gkehub.v1.GetScopeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.Scope>) responseObserver);
          break;
        case METHODID_CREATE_SCOPE:
          serviceImpl.createScope(
              (com.google.cloud.gkehub.v1.CreateScopeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_SCOPE:
          serviceImpl.updateScope(
              (com.google.cloud.gkehub.v1.UpdateScopeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_SCOPE:
          serviceImpl.deleteScope(
              (com.google.cloud.gkehub.v1.DeleteScopeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_SCOPES:
          serviceImpl.listScopes(
              (com.google.cloud.gkehub.v1.ListScopesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.ListScopesResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_PERMITTED_SCOPES:
          serviceImpl.listPermittedScopes(
              (com.google.cloud.gkehub.v1.ListPermittedScopesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.ListPermittedScopesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_MEMBERSHIP_BINDING:
          serviceImpl.getMembershipBinding(
              (com.google.cloud.gkehub.v1.GetMembershipBindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.MembershipBinding>)
                  responseObserver);
          break;
        case METHODID_CREATE_MEMBERSHIP_BINDING:
          serviceImpl.createMembershipBinding(
              (com.google.cloud.gkehub.v1.CreateMembershipBindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_MEMBERSHIP_BINDING:
          serviceImpl.updateMembershipBinding(
              (com.google.cloud.gkehub.v1.UpdateMembershipBindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_MEMBERSHIP_BINDING:
          serviceImpl.deleteMembershipBinding(
              (com.google.cloud.gkehub.v1.DeleteMembershipBindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_MEMBERSHIP_BINDINGS:
          serviceImpl.listMembershipBindings(
              (com.google.cloud.gkehub.v1.ListMembershipBindingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.gkehub.v1.ListMembershipBindingsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_MEMBERSHIP_RBACROLE_BINDING:
          serviceImpl.getMembershipRBACRoleBinding(
              (com.google.cloud.gkehub.v1.GetMembershipRBACRoleBindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkehub.v1.RBACRoleBinding>)
                  responseObserver);
          break;
        case METHODID_CREATE_MEMBERSHIP_RBACROLE_BINDING:
          serviceImpl.createMembershipRBACRoleBinding(
              (com.google.cloud.gkehub.v1.CreateMembershipRBACRoleBindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_MEMBERSHIP_RBACROLE_BINDING:
          serviceImpl.updateMembershipRBACRoleBinding(
              (com.google.cloud.gkehub.v1.UpdateMembershipRBACRoleBindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_MEMBERSHIP_RBACROLE_BINDING:
          serviceImpl.deleteMembershipRBACRoleBinding(
              (com.google.cloud.gkehub.v1.DeleteMembershipRBACRoleBindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_MEMBERSHIP_RBACROLE_BINDINGS:
          serviceImpl.listMembershipRBACRoleBindings(
              (com.google.cloud.gkehub.v1.ListMembershipRBACRoleBindingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.gkehub.v1.ListMembershipRBACRoleBindingsResponse>)
                  responseObserver);
          break;
        case METHODID_GENERATE_MEMBERSHIP_RBACROLE_BINDING_YAML:
          serviceImpl.generateMembershipRBACRoleBindingYAML(
              (com.google.cloud.gkehub.v1.GenerateMembershipRBACRoleBindingYAMLRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.gkehub.v1.GenerateMembershipRBACRoleBindingYAMLResponse>)
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
            getListMembershipsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkehub.v1.ListMembershipsRequest,
                    com.google.cloud.gkehub.v1.ListMembershipsResponse>(
                    service, METHODID_LIST_MEMBERSHIPS)))
        .addMethod(
            getListBoundMembershipsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkehub.v1.ListBoundMembershipsRequest,
                    com.google.cloud.gkehub.v1.ListBoundMembershipsResponse>(
                    service, METHODID_LIST_BOUND_MEMBERSHIPS)))
        .addMethod(
            getListFeaturesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkehub.v1.ListFeaturesRequest,
                    com.google.cloud.gkehub.v1.ListFeaturesResponse>(
                    service, METHODID_LIST_FEATURES)))
        .addMethod(
            getGetMembershipMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkehub.v1.GetMembershipRequest,
                    com.google.cloud.gkehub.v1.Membership>(service, METHODID_GET_MEMBERSHIP)))
        .addMethod(
            getGetFeatureMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkehub.v1.GetFeatureRequest,
                    com.google.cloud.gkehub.v1.Feature>(service, METHODID_GET_FEATURE)))
        .addMethod(
            getCreateMembershipMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkehub.v1.CreateMembershipRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_MEMBERSHIP)))
        .addMethod(
            getCreateFeatureMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkehub.v1.CreateFeatureRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_FEATURE)))
        .addMethod(
            getDeleteMembershipMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkehub.v1.DeleteMembershipRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_MEMBERSHIP)))
        .addMethod(
            getDeleteFeatureMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkehub.v1.DeleteFeatureRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_FEATURE)))
        .addMethod(
            getUpdateMembershipMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkehub.v1.UpdateMembershipRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_MEMBERSHIP)))
        .addMethod(
            getUpdateFeatureMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkehub.v1.UpdateFeatureRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_FEATURE)))
        .addMethod(
            getGenerateConnectManifestMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkehub.v1.GenerateConnectManifestRequest,
                    com.google.cloud.gkehub.v1.GenerateConnectManifestResponse>(
                    service, METHODID_GENERATE_CONNECT_MANIFEST)))
        .addMethod(
            getCreateFleetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkehub.v1.CreateFleetRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_FLEET)))
        .addMethod(
            getGetFleetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkehub.v1.GetFleetRequest, com.google.cloud.gkehub.v1.Fleet>(
                    service, METHODID_GET_FLEET)))
        .addMethod(
            getUpdateFleetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkehub.v1.UpdateFleetRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_FLEET)))
        .addMethod(
            getDeleteFleetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkehub.v1.DeleteFleetRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_FLEET)))
        .addMethod(
            getListFleetsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkehub.v1.ListFleetsRequest,
                    com.google.cloud.gkehub.v1.ListFleetsResponse>(service, METHODID_LIST_FLEETS)))
        .addMethod(
            getGetScopeNamespaceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkehub.v1.GetScopeNamespaceRequest,
                    com.google.cloud.gkehub.v1.Namespace>(service, METHODID_GET_SCOPE_NAMESPACE)))
        .addMethod(
            getCreateScopeNamespaceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkehub.v1.CreateScopeNamespaceRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_SCOPE_NAMESPACE)))
        .addMethod(
            getUpdateScopeNamespaceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkehub.v1.UpdateScopeNamespaceRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_SCOPE_NAMESPACE)))
        .addMethod(
            getDeleteScopeNamespaceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkehub.v1.DeleteScopeNamespaceRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_SCOPE_NAMESPACE)))
        .addMethod(
            getListScopeNamespacesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkehub.v1.ListScopeNamespacesRequest,
                    com.google.cloud.gkehub.v1.ListScopeNamespacesResponse>(
                    service, METHODID_LIST_SCOPE_NAMESPACES)))
        .addMethod(
            getGetScopeRBACRoleBindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkehub.v1.GetScopeRBACRoleBindingRequest,
                    com.google.cloud.gkehub.v1.RBACRoleBinding>(
                    service, METHODID_GET_SCOPE_RBACROLE_BINDING)))
        .addMethod(
            getCreateScopeRBACRoleBindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkehub.v1.CreateScopeRBACRoleBindingRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_SCOPE_RBACROLE_BINDING)))
        .addMethod(
            getUpdateScopeRBACRoleBindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkehub.v1.UpdateScopeRBACRoleBindingRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_UPDATE_SCOPE_RBACROLE_BINDING)))
        .addMethod(
            getDeleteScopeRBACRoleBindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkehub.v1.DeleteScopeRBACRoleBindingRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_SCOPE_RBACROLE_BINDING)))
        .addMethod(
            getListScopeRBACRoleBindingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkehub.v1.ListScopeRBACRoleBindingsRequest,
                    com.google.cloud.gkehub.v1.ListScopeRBACRoleBindingsResponse>(
                    service, METHODID_LIST_SCOPE_RBACROLE_BINDINGS)))
        .addMethod(
            getGetScopeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkehub.v1.GetScopeRequest, com.google.cloud.gkehub.v1.Scope>(
                    service, METHODID_GET_SCOPE)))
        .addMethod(
            getCreateScopeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkehub.v1.CreateScopeRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_SCOPE)))
        .addMethod(
            getUpdateScopeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkehub.v1.UpdateScopeRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_SCOPE)))
        .addMethod(
            getDeleteScopeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkehub.v1.DeleteScopeRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_SCOPE)))
        .addMethod(
            getListScopesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkehub.v1.ListScopesRequest,
                    com.google.cloud.gkehub.v1.ListScopesResponse>(service, METHODID_LIST_SCOPES)))
        .addMethod(
            getListPermittedScopesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkehub.v1.ListPermittedScopesRequest,
                    com.google.cloud.gkehub.v1.ListPermittedScopesResponse>(
                    service, METHODID_LIST_PERMITTED_SCOPES)))
        .addMethod(
            getGetMembershipBindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkehub.v1.GetMembershipBindingRequest,
                    com.google.cloud.gkehub.v1.MembershipBinding>(
                    service, METHODID_GET_MEMBERSHIP_BINDING)))
        .addMethod(
            getCreateMembershipBindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkehub.v1.CreateMembershipBindingRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_MEMBERSHIP_BINDING)))
        .addMethod(
            getUpdateMembershipBindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkehub.v1.UpdateMembershipBindingRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_MEMBERSHIP_BINDING)))
        .addMethod(
            getDeleteMembershipBindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkehub.v1.DeleteMembershipBindingRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_MEMBERSHIP_BINDING)))
        .addMethod(
            getListMembershipBindingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkehub.v1.ListMembershipBindingsRequest,
                    com.google.cloud.gkehub.v1.ListMembershipBindingsResponse>(
                    service, METHODID_LIST_MEMBERSHIP_BINDINGS)))
        .addMethod(
            getGetMembershipRBACRoleBindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkehub.v1.GetMembershipRBACRoleBindingRequest,
                    com.google.cloud.gkehub.v1.RBACRoleBinding>(
                    service, METHODID_GET_MEMBERSHIP_RBACROLE_BINDING)))
        .addMethod(
            getCreateMembershipRBACRoleBindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkehub.v1.CreateMembershipRBACRoleBindingRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_MEMBERSHIP_RBACROLE_BINDING)))
        .addMethod(
            getUpdateMembershipRBACRoleBindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkehub.v1.UpdateMembershipRBACRoleBindingRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_UPDATE_MEMBERSHIP_RBACROLE_BINDING)))
        .addMethod(
            getDeleteMembershipRBACRoleBindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkehub.v1.DeleteMembershipRBACRoleBindingRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_MEMBERSHIP_RBACROLE_BINDING)))
        .addMethod(
            getListMembershipRBACRoleBindingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkehub.v1.ListMembershipRBACRoleBindingsRequest,
                    com.google.cloud.gkehub.v1.ListMembershipRBACRoleBindingsResponse>(
                    service, METHODID_LIST_MEMBERSHIP_RBACROLE_BINDINGS)))
        .addMethod(
            getGenerateMembershipRBACRoleBindingYAMLMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkehub.v1.GenerateMembershipRBACRoleBindingYAMLRequest,
                    com.google.cloud.gkehub.v1.GenerateMembershipRBACRoleBindingYAMLResponse>(
                    service, METHODID_GENERATE_MEMBERSHIP_RBACROLE_BINDING_YAML)))
        .build();
  }

  private abstract static class GkeHubBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GkeHubBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.gkehub.v1.ServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GkeHub");
    }
  }

  private static final class GkeHubFileDescriptorSupplier extends GkeHubBaseDescriptorSupplier {
    GkeHubFileDescriptorSupplier() {}
  }

  private static final class GkeHubMethodDescriptorSupplier extends GkeHubBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    GkeHubMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (GkeHubGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new GkeHubFileDescriptorSupplier())
                      .addMethod(getListMembershipsMethod())
                      .addMethod(getListBoundMembershipsMethod())
                      .addMethod(getListFeaturesMethod())
                      .addMethod(getGetMembershipMethod())
                      .addMethod(getGetFeatureMethod())
                      .addMethod(getCreateMembershipMethod())
                      .addMethod(getCreateFeatureMethod())
                      .addMethod(getDeleteMembershipMethod())
                      .addMethod(getDeleteFeatureMethod())
                      .addMethod(getUpdateMembershipMethod())
                      .addMethod(getUpdateFeatureMethod())
                      .addMethod(getGenerateConnectManifestMethod())
                      .addMethod(getCreateFleetMethod())
                      .addMethod(getGetFleetMethod())
                      .addMethod(getUpdateFleetMethod())
                      .addMethod(getDeleteFleetMethod())
                      .addMethod(getListFleetsMethod())
                      .addMethod(getGetScopeNamespaceMethod())
                      .addMethod(getCreateScopeNamespaceMethod())
                      .addMethod(getUpdateScopeNamespaceMethod())
                      .addMethod(getDeleteScopeNamespaceMethod())
                      .addMethod(getListScopeNamespacesMethod())
                      .addMethod(getGetScopeRBACRoleBindingMethod())
                      .addMethod(getCreateScopeRBACRoleBindingMethod())
                      .addMethod(getUpdateScopeRBACRoleBindingMethod())
                      .addMethod(getDeleteScopeRBACRoleBindingMethod())
                      .addMethod(getListScopeRBACRoleBindingsMethod())
                      .addMethod(getGetScopeMethod())
                      .addMethod(getCreateScopeMethod())
                      .addMethod(getUpdateScopeMethod())
                      .addMethod(getDeleteScopeMethod())
                      .addMethod(getListScopesMethod())
                      .addMethod(getListPermittedScopesMethod())
                      .addMethod(getGetMembershipBindingMethod())
                      .addMethod(getCreateMembershipBindingMethod())
                      .addMethod(getUpdateMembershipBindingMethod())
                      .addMethod(getDeleteMembershipBindingMethod())
                      .addMethod(getListMembershipBindingsMethod())
                      .addMethod(getGetMembershipRBACRoleBindingMethod())
                      .addMethod(getCreateMembershipRBACRoleBindingMethod())
                      .addMethod(getUpdateMembershipRBACRoleBindingMethod())
                      .addMethod(getDeleteMembershipRBACRoleBindingMethod())
                      .addMethod(getListMembershipRBACRoleBindingsMethod())
                      .addMethod(getGenerateMembershipRBACRoleBindingYAMLMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
