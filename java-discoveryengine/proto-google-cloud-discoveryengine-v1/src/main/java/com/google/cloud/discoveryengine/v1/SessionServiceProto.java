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
// source: google/cloud/discoveryengine/v1/session_service.proto

// Protobuf Java Version: 3.25.8
package com.google.cloud.discoveryengine.v1;

public final class SessionServiceProto {
  private SessionServiceProto() {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite registry) {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions((com.google.protobuf.ExtensionRegistryLite) registry);
  }

  public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }

  private static com.google.protobuf.Descriptors.FileDescriptor descriptor;

  static {
    java.lang.String[] descriptorData = {
      "\n5google/cloud/discoveryengine/v1/sessio"
          + "n_service.proto\022\037google.cloud.discoverye"
          + "ngine.v1\032\034google/api/annotations.proto\032\027"
          + "google/api/client.proto\032\037google/api/fiel"
          + "d_behavior.proto\032\031google/api/resource.pr"
          + "oto\032Cgoogle/cloud/discoveryengine/v1/con"
          + "versational_search_service.proto\032-google"
          + "/cloud/discoveryengine/v1/session.proto\032"
          + "\033google/protobuf/empty.proto2\332\016\n\016Session"
          + "Service\022\364\002\n\rCreateSession\0225.google.cloud"
          + ".discoveryengine.v1.CreateSessionRequest"
          + "\032(.google.cloud.discoveryengine.v1.Sessi"
          + "on\"\201\002\332A\016parent,session\202\323\344\223\002\351\001\"9/v1/{pare"
          + "nt=projects/*/locations/*/dataStores/*}/"
          + "sessions:\007sessionZR\"G/v1/{parent=project"
          + "s/*/locations/*/collections/*/dataStores"
          + "/*}/sessions:\007sessionZO\"D/v1/{parent=pro"
          + "jects/*/locations/*/collections/*/engine"
          + "s/*}/sessions:\007session\022\275\002\n\rDeleteSession"
          + "\0225.google.cloud.discoveryengine.v1.Delet"
          + "eSessionRequest\032\026.google.protobuf.Empty\""
          + "\334\001\332A\004name\202\323\344\223\002\316\001*9/v1/{name=projects/*/l"
          + "ocations/*/dataStores/*/sessions/*}ZI*G/"
          + "v1/{name=projects/*/locations/*/collecti"
          + "ons/*/dataStores/*/sessions/*}ZF*D/v1/{n"
          + "ame=projects/*/locations/*/collections/*"
          + "/engines/*/sessions/*}\022\221\003\n\rUpdateSession"
          + "\0225.google.cloud.discoveryengine.v1.Updat"
          + "eSessionRequest\032(.google.cloud.discovery"
          + "engine.v1.Session\"\236\002\332A\023session,update_ma"
          + "sk\202\323\344\223\002\201\0022A/v1/{session.name=projects/*/"
          + "locations/*/dataStores/*/sessions/*}:\007se"
          + "ssionZZ2O/v1/{session.name=projects/*/lo"
          + "cations/*/collections/*/dataStores/*/ses"
          + "sions/*}:\007sessionZW2L/v1/{session.name=p"
          + "rojects/*/locations/*/collections/*/engi"
          + "nes/*/sessions/*}:\007session\022\311\002\n\nGetSessio"
          + "n\0222.google.cloud.discoveryengine.v1.GetS"
          + "essionRequest\032(.google.cloud.discoveryen"
          + "gine.v1.Session\"\334\001\332A\004name\202\323\344\223\002\316\001\0229/v1/{n"
          + "ame=projects/*/locations/*/dataStores/*/"
          + "sessions/*}ZI\022G/v1/{name=projects/*/loca"
          + "tions/*/collections/*/dataStores/*/sessi"
          + "ons/*}ZF\022D/v1/{name=projects/*/locations"
          + "/*/collections/*/engines/*/sessions/*}\022\334"
          + "\002\n\014ListSessions\0224.google.cloud.discovery"
          + "engine.v1.ListSessionsRequest\0325.google.c"
          + "loud.discoveryengine.v1.ListSessionsResp"
          + "onse\"\336\001\332A\006parent\202\323\344\223\002\316\001\0229/v1/{parent=pro"
          + "jects/*/locations/*/dataStores/*}/sessio"
          + "nsZI\022G/v1/{parent=projects/*/locations/*"
          + "/collections/*/dataStores/*}/sessionsZF\022"
          + "D/v1/{parent=projects/*/locations/*/coll"
          + "ections/*/engines/*}/sessions\032R\312A\036discov"
          + "eryengine.googleapis.com\322A.https://www.g"
          + "oogleapis.com/auth/cloud-platformB\206\002\n#co"
          + "m.google.cloud.discoveryengine.v1B\023Sessi"
          + "onServiceProtoP\001ZMcloud.google.com/go/di"
          + "scoveryengine/apiv1/discoveryenginepb;di"
          + "scoveryenginepb\242\002\017DISCOVERYENGINE\252\002\037Goog"
          + "le.Cloud.DiscoveryEngine.V1\312\002\037Google\\Clo"
          + "ud\\DiscoveryEngine\\V1\352\002\"Google::Cloud::D"
          + "iscoveryEngine::V1b\006proto3"
    };
    descriptor =
        com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(
            descriptorData,
            new com.google.protobuf.Descriptors.FileDescriptor[] {
              com.google.api.AnnotationsProto.getDescriptor(),
              com.google.api.ClientProto.getDescriptor(),
              com.google.api.FieldBehaviorProto.getDescriptor(),
              com.google.api.ResourceProto.getDescriptor(),
              com.google.cloud.discoveryengine.v1.ConversationalSearchServiceProto.getDescriptor(),
              com.google.cloud.discoveryengine.v1.SessionProto.getDescriptor(),
              com.google.protobuf.EmptyProto.getDescriptor(),
            });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.api.ClientProto.defaultHost);
    registry.add(com.google.api.AnnotationsProto.http);
    registry.add(com.google.api.ClientProto.methodSignature);
    registry.add(com.google.api.ClientProto.oauthScopes);
    com.google.protobuf.Descriptors.FileDescriptor.internalUpdateFileDescriptor(
        descriptor, registry);
    com.google.api.AnnotationsProto.getDescriptor();
    com.google.api.ClientProto.getDescriptor();
    com.google.api.FieldBehaviorProto.getDescriptor();
    com.google.api.ResourceProto.getDescriptor();
    com.google.cloud.discoveryengine.v1.ConversationalSearchServiceProto.getDescriptor();
    com.google.cloud.discoveryengine.v1.SessionProto.getDescriptor();
    com.google.protobuf.EmptyProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
