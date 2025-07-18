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
// source: google/ads/admanager/v1/live_stream_event_messages.proto

// Protobuf Java Version: 3.25.8
package com.google.ads.admanager.v1;

public final class LiveStreamEventMessagesProto {
  private LiveStreamEventMessagesProto() {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite registry) {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions((com.google.protobuf.ExtensionRegistryLite) registry);
  }

  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_ads_admanager_v1_LiveStreamEvent_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_ads_admanager_v1_LiveStreamEvent_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }

  private static com.google.protobuf.Descriptors.FileDescriptor descriptor;

  static {
    java.lang.String[] descriptorData = {
      "\n8google/ads/admanager/v1/live_stream_ev"
          + "ent_messages.proto\022\027google.ads.admanager"
          + ".v1\032\037google/api/field_behavior.proto\032\031go"
          + "ogle/api/resource.proto\"\266\001\n\017LiveStreamEv"
          + "ent\022\021\n\004name\030\001 \001(\tB\003\340A\010:\217\001\352A\213\001\n(admanager"
          + ".googleapis.com/LiveStreamEvent\022<network"
          + "s/{network_code}/liveStreamEvents/{live_"
          + "stream_event}*\020liveStreamEvents2\017liveStr"
          + "eamEventB\320\001\n\033com.google.ads.admanager.v1"
          + "B\034LiveStreamEventMessagesProtoP\001Z@google"
          + ".golang.org/genproto/googleapis/ads/adma"
          + "nager/v1;admanager\252\002\027Google.Ads.AdManage"
          + "r.V1\312\002\027Google\\Ads\\AdManager\\V1\352\002\032Google:"
          + ":Ads::AdManager::V1b\006proto3"
    };
    descriptor =
        com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(
            descriptorData,
            new com.google.protobuf.Descriptors.FileDescriptor[] {
              com.google.api.FieldBehaviorProto.getDescriptor(),
              com.google.api.ResourceProto.getDescriptor(),
            });
    internal_static_google_ads_admanager_v1_LiveStreamEvent_descriptor =
        getDescriptor().getMessageTypes().get(0);
    internal_static_google_ads_admanager_v1_LiveStreamEvent_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_ads_admanager_v1_LiveStreamEvent_descriptor,
            new java.lang.String[] {
              "Name",
            });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.api.FieldBehaviorProto.fieldBehavior);
    registry.add(com.google.api.ResourceProto.resource);
    com.google.protobuf.Descriptors.FileDescriptor.internalUpdateFileDescriptor(
        descriptor, registry);
    com.google.api.FieldBehaviorProto.getDescriptor();
    com.google.api.ResourceProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
