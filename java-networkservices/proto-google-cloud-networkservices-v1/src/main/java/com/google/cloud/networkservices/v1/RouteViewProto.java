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
// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/cloud/networkservices/v1/route_view.proto

// Protobuf Java Version: 3.25.8
package com.google.cloud.networkservices.v1;

public final class RouteViewProto {
  private RouteViewProto() {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite registry) {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions((com.google.protobuf.ExtensionRegistryLite) registry);
  }

  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_networkservices_v1_GatewayRouteView_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_networkservices_v1_GatewayRouteView_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_networkservices_v1_MeshRouteView_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_networkservices_v1_MeshRouteView_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_networkservices_v1_GetGatewayRouteViewRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_networkservices_v1_GetGatewayRouteViewRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_networkservices_v1_GetMeshRouteViewRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_networkservices_v1_GetMeshRouteViewRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_networkservices_v1_ListGatewayRouteViewsRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_networkservices_v1_ListGatewayRouteViewsRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_networkservices_v1_ListMeshRouteViewsRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_networkservices_v1_ListMeshRouteViewsRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_networkservices_v1_ListGatewayRouteViewsResponse_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_networkservices_v1_ListGatewayRouteViewsResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_networkservices_v1_ListMeshRouteViewsResponse_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_networkservices_v1_ListMeshRouteViewsResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }

  private static com.google.protobuf.Descriptors.FileDescriptor descriptor;

  static {
    java.lang.String[] descriptorData = {
      "\n"
          + "0google/cloud/networkservices/v1/route_view.proto\022\037google.cloud.networkservices"
          + ".v1\032\037google/api/field_behavior.proto\032\031google/api/resource.proto\"\311\002\n"
          + "\020GatewayRouteView\022\024\n"
          + "\004name\030\001 \001(\tB\006\340A\003\340A\010\022!\n"
          + "\024route_project_number\030\002 \001(\003B\003\340A\003\022\033\n"
          + "\016route_location\030\003 \001(\tB\003\340A\003\022\027\n\n"
          + "route_type\030\004 \001(\tB\003\340A\003\022\025\n"
          + "\010route_id\030\005 \001(\tB\003\340A\003:\256\001\352A\252\001\n"
          + "/networkservices.googleapis.com/GatewayRouteView\022Rproj"
          + "ects/{project}/locations/{location}/gate"
          + "ways/{gateway}/routeViews/{route_view}*\021gatewayRouteViews2\020gatewayRouteView\"\270\002\n\r"
          + "MeshRouteView\022\024\n"
          + "\004name\030\001 \001(\tB\006\340A\003\340A\010\022!\n"
          + "\024route_project_number\030\002 \001(\003B\003\340A\003\022\033\n"
          + "\016route_location\030\003 \001(\tB\003\340A\003\022\027\n\n"
          + "route_type\030\004 \001(\tB\003\340A\003\022\025\n"
          + "\010route_id\030\005 \001(\tB\003\340A\003:\240\001\352A\234\001\n"
          + ",networkservices.googleapis.com/MeshRouteView"
          + "\022Mprojects/{project}/locations/{location"
          + "}/meshes/{mesh}/routeViews/{route_view}*\016meshRouteViews2\r"
          + "meshRouteView\"c\n"
          + "\032GetGatewayRouteViewRequest\022E\n"
          + "\004name\030\001 \001(\tB7\340A\002\372A1\n"
          + "/networkservices.googleapis.com/GatewayRouteView\"]\n"
          + "\027GetMeshRouteViewRequest\022B\n"
          + "\004name\030\001 \001(\tB4\340A\002\372A.\n"
          + ",networkservices.googleapis.com/MeshRouteView\"\216\001\n"
          + "\034ListGatewayRouteViewsRequest\022G\n"
          + "\006parent\030\001 \001(\tB7\340A\002"
          + "\372A1\022/networkservices.googleapis.com/GatewayRouteView\022\021\n"
          + "\tpage_size\030\002 \001(\005\022\022\n\n"
          + "page_token\030\003 \001(\t\"\210\001\n"
          + "\031ListMeshRouteViewsRequest\022D\n"
          + "\006parent\030\001 \001("
          + "\tB4\340A\002\372A.\022,networkservices.googleapis.com/MeshRouteView\022\021\n"
          + "\tpage_size\030\002 \001(\005\022\022\n\n"
          + "page_token\030\003 \001(\t\"\235\001\n"
          + "\035ListGatewayRouteViewsResponse\022N\n"
          + "\023gateway_route_views\030\001"
          + " \003(\01321.google.cloud.networkservices.v1.GatewayRouteView\022\027\n"
          + "\017next_page_token\030\002 \001(\t\022\023\n"
          + "\013unreachable\030\003 \003(\t\"\224\001\n"
          + "\032ListMeshRouteViewsResponse\022H\n"
          + "\020mesh_route_views\030\001"
          + " \003(\0132..google.cloud.networkservices.v1.MeshRouteView\022\027\n"
          + "\017next_page_token\030\002 \001(\t\022\023\n"
          + "\013unreachable\030\003 \003(\tB\357\001\n"
          + "#com.google.cloud.networkservices.v1B\016RouteViewProtoP\001Z"
          + "Mcloud.google.com/go/networkservices/apiv1/networkservicespb;networkservicespb\252\002"
          + "\037Google.Cloud.NetworkServices.V1\312\002\037Googl"
          + "e\\Cloud\\NetworkServices\\V1\352\002\"Google::Cloud::NetworkServices::V1b\006proto3"
    };
    descriptor =
        com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(
            descriptorData,
            new com.google.protobuf.Descriptors.FileDescriptor[] {
              com.google.api.FieldBehaviorProto.getDescriptor(),
              com.google.api.ResourceProto.getDescriptor(),
            });
    internal_static_google_cloud_networkservices_v1_GatewayRouteView_descriptor =
        getDescriptor().getMessageTypes().get(0);
    internal_static_google_cloud_networkservices_v1_GatewayRouteView_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_networkservices_v1_GatewayRouteView_descriptor,
            new java.lang.String[] {
              "Name", "RouteProjectNumber", "RouteLocation", "RouteType", "RouteId",
            });
    internal_static_google_cloud_networkservices_v1_MeshRouteView_descriptor =
        getDescriptor().getMessageTypes().get(1);
    internal_static_google_cloud_networkservices_v1_MeshRouteView_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_networkservices_v1_MeshRouteView_descriptor,
            new java.lang.String[] {
              "Name", "RouteProjectNumber", "RouteLocation", "RouteType", "RouteId",
            });
    internal_static_google_cloud_networkservices_v1_GetGatewayRouteViewRequest_descriptor =
        getDescriptor().getMessageTypes().get(2);
    internal_static_google_cloud_networkservices_v1_GetGatewayRouteViewRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_networkservices_v1_GetGatewayRouteViewRequest_descriptor,
            new java.lang.String[] {
              "Name",
            });
    internal_static_google_cloud_networkservices_v1_GetMeshRouteViewRequest_descriptor =
        getDescriptor().getMessageTypes().get(3);
    internal_static_google_cloud_networkservices_v1_GetMeshRouteViewRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_networkservices_v1_GetMeshRouteViewRequest_descriptor,
            new java.lang.String[] {
              "Name",
            });
    internal_static_google_cloud_networkservices_v1_ListGatewayRouteViewsRequest_descriptor =
        getDescriptor().getMessageTypes().get(4);
    internal_static_google_cloud_networkservices_v1_ListGatewayRouteViewsRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_networkservices_v1_ListGatewayRouteViewsRequest_descriptor,
            new java.lang.String[] {
              "Parent", "PageSize", "PageToken",
            });
    internal_static_google_cloud_networkservices_v1_ListMeshRouteViewsRequest_descriptor =
        getDescriptor().getMessageTypes().get(5);
    internal_static_google_cloud_networkservices_v1_ListMeshRouteViewsRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_networkservices_v1_ListMeshRouteViewsRequest_descriptor,
            new java.lang.String[] {
              "Parent", "PageSize", "PageToken",
            });
    internal_static_google_cloud_networkservices_v1_ListGatewayRouteViewsResponse_descriptor =
        getDescriptor().getMessageTypes().get(6);
    internal_static_google_cloud_networkservices_v1_ListGatewayRouteViewsResponse_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_networkservices_v1_ListGatewayRouteViewsResponse_descriptor,
            new java.lang.String[] {
              "GatewayRouteViews", "NextPageToken", "Unreachable",
            });
    internal_static_google_cloud_networkservices_v1_ListMeshRouteViewsResponse_descriptor =
        getDescriptor().getMessageTypes().get(7);
    internal_static_google_cloud_networkservices_v1_ListMeshRouteViewsResponse_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_networkservices_v1_ListMeshRouteViewsResponse_descriptor,
            new java.lang.String[] {
              "MeshRouteViews", "NextPageToken", "Unreachable",
            });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.api.FieldBehaviorProto.fieldBehavior);
    registry.add(com.google.api.ResourceProto.resource);
    registry.add(com.google.api.ResourceProto.resourceReference);
    com.google.protobuf.Descriptors.FileDescriptor.internalUpdateFileDescriptor(
        descriptor, registry);
    com.google.api.FieldBehaviorProto.getDescriptor();
    com.google.api.ResourceProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
