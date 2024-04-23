/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.chat.v1.stub;

import static com.google.chat.v1.ChatServiceClient.ListMembershipsPagedResponse;
import static com.google.chat.v1.ChatServiceClient.ListMessagesPagedResponse;
import static com.google.chat.v1.ChatServiceClient.ListReactionsPagedResponse;
import static com.google.chat.v1.ChatServiceClient.ListSpacesPagedResponse;

import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.chat.v1.Attachment;
import com.google.chat.v1.CompleteImportSpaceRequest;
import com.google.chat.v1.CompleteImportSpaceResponse;
import com.google.chat.v1.CreateMembershipRequest;
import com.google.chat.v1.CreateMessageRequest;
import com.google.chat.v1.CreateReactionRequest;
import com.google.chat.v1.CreateSpaceRequest;
import com.google.chat.v1.DeleteMembershipRequest;
import com.google.chat.v1.DeleteMessageRequest;
import com.google.chat.v1.DeleteReactionRequest;
import com.google.chat.v1.DeleteSpaceRequest;
import com.google.chat.v1.FindDirectMessageRequest;
import com.google.chat.v1.GetAttachmentRequest;
import com.google.chat.v1.GetMembershipRequest;
import com.google.chat.v1.GetMessageRequest;
import com.google.chat.v1.GetSpaceReadStateRequest;
import com.google.chat.v1.GetSpaceRequest;
import com.google.chat.v1.GetThreadReadStateRequest;
import com.google.chat.v1.ListMembershipsRequest;
import com.google.chat.v1.ListMembershipsResponse;
import com.google.chat.v1.ListMessagesRequest;
import com.google.chat.v1.ListMessagesResponse;
import com.google.chat.v1.ListReactionsRequest;
import com.google.chat.v1.ListReactionsResponse;
import com.google.chat.v1.ListSpacesRequest;
import com.google.chat.v1.ListSpacesResponse;
import com.google.chat.v1.Membership;
import com.google.chat.v1.Message;
import com.google.chat.v1.Reaction;
import com.google.chat.v1.SetUpSpaceRequest;
import com.google.chat.v1.Space;
import com.google.chat.v1.SpaceReadState;
import com.google.chat.v1.ThreadReadState;
import com.google.chat.v1.UpdateMembershipRequest;
import com.google.chat.v1.UpdateMessageRequest;
import com.google.chat.v1.UpdateSpaceReadStateRequest;
import com.google.chat.v1.UpdateSpaceRequest;
import com.google.chat.v1.UploadAttachmentRequest;
import com.google.chat.v1.UploadAttachmentResponse;
import com.google.protobuf.Empty;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the ChatService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonChatServiceStub extends ChatServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateMessageRequest, Message>
      createMessageMethodDescriptor =
          ApiMethodDescriptor.<CreateMessageRequest, Message>newBuilder()
              .setFullMethodName("google.chat.v1.ChatService/CreateMessage")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateMessageRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=spaces/*}/messages",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateMessageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateMessageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "messageId", request.getMessageId());
                            serializer.putQueryParam(
                                fields, "messageReplyOption", request.getMessageReplyOptionValue());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "threadKey", request.getThreadKey());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("message", request.getMessage(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Message>newBuilder()
                      .setDefaultInstance(Message.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListMessagesRequest, ListMessagesResponse>
      listMessagesMethodDescriptor =
          ApiMethodDescriptor.<ListMessagesRequest, ListMessagesResponse>newBuilder()
              .setFullMethodName("google.chat.v1.ChatService/ListMessages")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListMessagesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=spaces/*}/messages",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListMessagesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListMessagesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(
                                fields, "showDeleted", request.getShowDeleted());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListMessagesResponse>newBuilder()
                      .setDefaultInstance(ListMessagesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListMembershipsRequest, ListMembershipsResponse>
      listMembershipsMethodDescriptor =
          ApiMethodDescriptor.<ListMembershipsRequest, ListMembershipsResponse>newBuilder()
              .setFullMethodName("google.chat.v1.ChatService/ListMemberships")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListMembershipsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=spaces/*}/members",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListMembershipsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListMembershipsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "showGroups", request.getShowGroups());
                            serializer.putQueryParam(
                                fields, "showInvited", request.getShowInvited());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListMembershipsResponse>newBuilder()
                      .setDefaultInstance(ListMembershipsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetMembershipRequest, Membership>
      getMembershipMethodDescriptor =
          ApiMethodDescriptor.<GetMembershipRequest, Membership>newBuilder()
              .setFullMethodName("google.chat.v1.ChatService/GetMembership")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetMembershipRequest>newBuilder()
                      .setPath(
                          "/v1/{name=spaces/*/members/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetMembershipRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetMembershipRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Membership>newBuilder()
                      .setDefaultInstance(Membership.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetMessageRequest, Message> getMessageMethodDescriptor =
      ApiMethodDescriptor.<GetMessageRequest, Message>newBuilder()
          .setFullMethodName("google.chat.v1.ChatService/GetMessage")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetMessageRequest>newBuilder()
                  .setPath(
                      "/v1/{name=spaces/*/messages/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetMessageRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetMessageRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Message>newBuilder()
                  .setDefaultInstance(Message.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<UpdateMessageRequest, Message>
      updateMessageMethodDescriptor =
          ApiMethodDescriptor.<UpdateMessageRequest, Message>newBuilder()
              .setFullMethodName("google.chat.v1.ChatService/UpdateMessage")
              .setHttpMethod("PUT")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateMessageRequest>newBuilder()
                      .setPath(
                          "/v1/{message.name=spaces/*/messages/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateMessageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "message.name", request.getMessage().getName());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/{message.name=spaces/*/messages/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateMessageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("message", request.getMessage(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Message>newBuilder()
                      .setDefaultInstance(Message.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteMessageRequest, Empty>
      deleteMessageMethodDescriptor =
          ApiMethodDescriptor.<DeleteMessageRequest, Empty>newBuilder()
              .setFullMethodName("google.chat.v1.ChatService/DeleteMessage")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteMessageRequest>newBuilder()
                      .setPath(
                          "/v1/{name=spaces/*/messages/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteMessageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteMessageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetAttachmentRequest, Attachment>
      getAttachmentMethodDescriptor =
          ApiMethodDescriptor.<GetAttachmentRequest, Attachment>newBuilder()
              .setFullMethodName("google.chat.v1.ChatService/GetAttachment")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAttachmentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=spaces/*/messages/*/attachments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAttachmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAttachmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Attachment>newBuilder()
                      .setDefaultInstance(Attachment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UploadAttachmentRequest, UploadAttachmentResponse>
      uploadAttachmentMethodDescriptor =
          ApiMethodDescriptor.<UploadAttachmentRequest, UploadAttachmentResponse>newBuilder()
              .setFullMethodName("google.chat.v1.ChatService/UploadAttachment")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UploadAttachmentRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=spaces/*}/attachments:upload",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UploadAttachmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UploadAttachmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UploadAttachmentResponse>newBuilder()
                      .setDefaultInstance(UploadAttachmentResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListSpacesRequest, ListSpacesResponse>
      listSpacesMethodDescriptor =
          ApiMethodDescriptor.<ListSpacesRequest, ListSpacesResponse>newBuilder()
              .setFullMethodName("google.chat.v1.ChatService/ListSpaces")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSpacesRequest>newBuilder()
                      .setPath(
                          "/v1/spaces",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSpacesRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSpacesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListSpacesResponse>newBuilder()
                      .setDefaultInstance(ListSpacesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetSpaceRequest, Space> getSpaceMethodDescriptor =
      ApiMethodDescriptor.<GetSpaceRequest, Space>newBuilder()
          .setFullMethodName("google.chat.v1.ChatService/GetSpace")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetSpaceRequest>newBuilder()
                  .setPath(
                      "/v1/{name=spaces/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetSpaceRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetSpaceRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Space>newBuilder()
                  .setDefaultInstance(Space.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateSpaceRequest, Space> createSpaceMethodDescriptor =
      ApiMethodDescriptor.<CreateSpaceRequest, Space>newBuilder()
          .setFullMethodName("google.chat.v1.ChatService/CreateSpace")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CreateSpaceRequest>newBuilder()
                  .setPath(
                      "/v1/spaces",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CreateSpaceRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CreateSpaceRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "requestId", request.getRequestId());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("space", request.getSpace(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Space>newBuilder()
                  .setDefaultInstance(Space.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<SetUpSpaceRequest, Space> setUpSpaceMethodDescriptor =
      ApiMethodDescriptor.<SetUpSpaceRequest, Space>newBuilder()
          .setFullMethodName("google.chat.v1.ChatService/SetUpSpace")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<SetUpSpaceRequest>newBuilder()
                  .setPath(
                      "/v1/spaces:setup",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<SetUpSpaceRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<SetUpSpaceRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody("*", request.toBuilder().build(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Space>newBuilder()
                  .setDefaultInstance(Space.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<UpdateSpaceRequest, Space> updateSpaceMethodDescriptor =
      ApiMethodDescriptor.<UpdateSpaceRequest, Space>newBuilder()
          .setFullMethodName("google.chat.v1.ChatService/UpdateSpace")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateSpaceRequest>newBuilder()
                  .setPath(
                      "/v1/{space.name=spaces/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateSpaceRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "space.name", request.getSpace().getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateSpaceRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("space", request.getSpace(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Space>newBuilder()
                  .setDefaultInstance(Space.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<DeleteSpaceRequest, Empty> deleteSpaceMethodDescriptor =
      ApiMethodDescriptor.<DeleteSpaceRequest, Empty>newBuilder()
          .setFullMethodName("google.chat.v1.ChatService/DeleteSpace")
          .setHttpMethod("DELETE")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteSpaceRequest>newBuilder()
                  .setPath(
                      "/v1/{name=spaces/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteSpaceRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteSpaceRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Empty>newBuilder()
                  .setDefaultInstance(Empty.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CompleteImportSpaceRequest, CompleteImportSpaceResponse>
      completeImportSpaceMethodDescriptor =
          ApiMethodDescriptor.<CompleteImportSpaceRequest, CompleteImportSpaceResponse>newBuilder()
              .setFullMethodName("google.chat.v1.ChatService/CompleteImportSpace")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CompleteImportSpaceRequest>newBuilder()
                      .setPath(
                          "/v1/{name=spaces/*}:completeImport",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CompleteImportSpaceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CompleteImportSpaceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CompleteImportSpaceResponse>newBuilder()
                      .setDefaultInstance(CompleteImportSpaceResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<FindDirectMessageRequest, Space>
      findDirectMessageMethodDescriptor =
          ApiMethodDescriptor.<FindDirectMessageRequest, Space>newBuilder()
              .setFullMethodName("google.chat.v1.ChatService/FindDirectMessage")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FindDirectMessageRequest>newBuilder()
                      .setPath(
                          "/v1/spaces:findDirectMessage",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FindDirectMessageRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FindDirectMessageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "name", request.getName());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Space>newBuilder()
                      .setDefaultInstance(Space.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateMembershipRequest, Membership>
      createMembershipMethodDescriptor =
          ApiMethodDescriptor.<CreateMembershipRequest, Membership>newBuilder()
              .setFullMethodName("google.chat.v1.ChatService/CreateMembership")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateMembershipRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=spaces/*}/members",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateMembershipRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateMembershipRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("membership", request.getMembership(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Membership>newBuilder()
                      .setDefaultInstance(Membership.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateMembershipRequest, Membership>
      updateMembershipMethodDescriptor =
          ApiMethodDescriptor.<UpdateMembershipRequest, Membership>newBuilder()
              .setFullMethodName("google.chat.v1.ChatService/UpdateMembership")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateMembershipRequest>newBuilder()
                      .setPath(
                          "/v1/{membership.name=spaces/*/members/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateMembershipRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "membership.name", request.getMembership().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateMembershipRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("membership", request.getMembership(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Membership>newBuilder()
                      .setDefaultInstance(Membership.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteMembershipRequest, Membership>
      deleteMembershipMethodDescriptor =
          ApiMethodDescriptor.<DeleteMembershipRequest, Membership>newBuilder()
              .setFullMethodName("google.chat.v1.ChatService/DeleteMembership")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteMembershipRequest>newBuilder()
                      .setPath(
                          "/v1/{name=spaces/*/members/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteMembershipRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteMembershipRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Membership>newBuilder()
                      .setDefaultInstance(Membership.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateReactionRequest, Reaction>
      createReactionMethodDescriptor =
          ApiMethodDescriptor.<CreateReactionRequest, Reaction>newBuilder()
              .setFullMethodName("google.chat.v1.ChatService/CreateReaction")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateReactionRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=spaces/*/messages/*}/reactions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateReactionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateReactionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("reaction", request.getReaction(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Reaction>newBuilder()
                      .setDefaultInstance(Reaction.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListReactionsRequest, ListReactionsResponse>
      listReactionsMethodDescriptor =
          ApiMethodDescriptor.<ListReactionsRequest, ListReactionsResponse>newBuilder()
              .setFullMethodName("google.chat.v1.ChatService/ListReactions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListReactionsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=spaces/*/messages/*}/reactions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListReactionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListReactionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListReactionsResponse>newBuilder()
                      .setDefaultInstance(ListReactionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteReactionRequest, Empty>
      deleteReactionMethodDescriptor =
          ApiMethodDescriptor.<DeleteReactionRequest, Empty>newBuilder()
              .setFullMethodName("google.chat.v1.ChatService/DeleteReaction")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteReactionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=spaces/*/messages/*/reactions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteReactionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteReactionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetSpaceReadStateRequest, SpaceReadState>
      getSpaceReadStateMethodDescriptor =
          ApiMethodDescriptor.<GetSpaceReadStateRequest, SpaceReadState>newBuilder()
              .setFullMethodName("google.chat.v1.ChatService/GetSpaceReadState")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetSpaceReadStateRequest>newBuilder()
                      .setPath(
                          "/v1/{name=users/*/spaces/*/spaceReadState}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetSpaceReadStateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetSpaceReadStateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SpaceReadState>newBuilder()
                      .setDefaultInstance(SpaceReadState.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateSpaceReadStateRequest, SpaceReadState>
      updateSpaceReadStateMethodDescriptor =
          ApiMethodDescriptor.<UpdateSpaceReadStateRequest, SpaceReadState>newBuilder()
              .setFullMethodName("google.chat.v1.ChatService/UpdateSpaceReadState")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateSpaceReadStateRequest>newBuilder()
                      .setPath(
                          "/v1/{spaceReadState.name=users/*/spaces/*/spaceReadState}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSpaceReadStateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "spaceReadState.name",
                                request.getSpaceReadState().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSpaceReadStateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("spaceReadState", request.getSpaceReadState(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SpaceReadState>newBuilder()
                      .setDefaultInstance(SpaceReadState.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetThreadReadStateRequest, ThreadReadState>
      getThreadReadStateMethodDescriptor =
          ApiMethodDescriptor.<GetThreadReadStateRequest, ThreadReadState>newBuilder()
              .setFullMethodName("google.chat.v1.ChatService/GetThreadReadState")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetThreadReadStateRequest>newBuilder()
                      .setPath(
                          "/v1/{name=users/*/spaces/*/threads/*/threadReadState}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetThreadReadStateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetThreadReadStateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ThreadReadState>newBuilder()
                      .setDefaultInstance(ThreadReadState.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateMessageRequest, Message> createMessageCallable;
  private final UnaryCallable<ListMessagesRequest, ListMessagesResponse> listMessagesCallable;
  private final UnaryCallable<ListMessagesRequest, ListMessagesPagedResponse>
      listMessagesPagedCallable;
  private final UnaryCallable<ListMembershipsRequest, ListMembershipsResponse>
      listMembershipsCallable;
  private final UnaryCallable<ListMembershipsRequest, ListMembershipsPagedResponse>
      listMembershipsPagedCallable;
  private final UnaryCallable<GetMembershipRequest, Membership> getMembershipCallable;
  private final UnaryCallable<GetMessageRequest, Message> getMessageCallable;
  private final UnaryCallable<UpdateMessageRequest, Message> updateMessageCallable;
  private final UnaryCallable<DeleteMessageRequest, Empty> deleteMessageCallable;
  private final UnaryCallable<GetAttachmentRequest, Attachment> getAttachmentCallable;
  private final UnaryCallable<UploadAttachmentRequest, UploadAttachmentResponse>
      uploadAttachmentCallable;
  private final UnaryCallable<ListSpacesRequest, ListSpacesResponse> listSpacesCallable;
  private final UnaryCallable<ListSpacesRequest, ListSpacesPagedResponse> listSpacesPagedCallable;
  private final UnaryCallable<GetSpaceRequest, Space> getSpaceCallable;
  private final UnaryCallable<CreateSpaceRequest, Space> createSpaceCallable;
  private final UnaryCallable<SetUpSpaceRequest, Space> setUpSpaceCallable;
  private final UnaryCallable<UpdateSpaceRequest, Space> updateSpaceCallable;
  private final UnaryCallable<DeleteSpaceRequest, Empty> deleteSpaceCallable;
  private final UnaryCallable<CompleteImportSpaceRequest, CompleteImportSpaceResponse>
      completeImportSpaceCallable;
  private final UnaryCallable<FindDirectMessageRequest, Space> findDirectMessageCallable;
  private final UnaryCallable<CreateMembershipRequest, Membership> createMembershipCallable;
  private final UnaryCallable<UpdateMembershipRequest, Membership> updateMembershipCallable;
  private final UnaryCallable<DeleteMembershipRequest, Membership> deleteMembershipCallable;
  private final UnaryCallable<CreateReactionRequest, Reaction> createReactionCallable;
  private final UnaryCallable<ListReactionsRequest, ListReactionsResponse> listReactionsCallable;
  private final UnaryCallable<ListReactionsRequest, ListReactionsPagedResponse>
      listReactionsPagedCallable;
  private final UnaryCallable<DeleteReactionRequest, Empty> deleteReactionCallable;
  private final UnaryCallable<GetSpaceReadStateRequest, SpaceReadState> getSpaceReadStateCallable;
  private final UnaryCallable<UpdateSpaceReadStateRequest, SpaceReadState>
      updateSpaceReadStateCallable;
  private final UnaryCallable<GetThreadReadStateRequest, ThreadReadState>
      getThreadReadStateCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonChatServiceStub create(ChatServiceStubSettings settings)
      throws IOException {
    return new HttpJsonChatServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonChatServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonChatServiceStub(
        ChatServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonChatServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonChatServiceStub(
        ChatServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonChatServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonChatServiceStub(ChatServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonChatServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonChatServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonChatServiceStub(
      ChatServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateMessageRequest, Message> createMessageTransportSettings =
        HttpJsonCallSettings.<CreateMessageRequest, Message>newBuilder()
            .setMethodDescriptor(createMessageMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListMessagesRequest, ListMessagesResponse> listMessagesTransportSettings =
        HttpJsonCallSettings.<ListMessagesRequest, ListMessagesResponse>newBuilder()
            .setMethodDescriptor(listMessagesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListMembershipsRequest, ListMembershipsResponse>
        listMembershipsTransportSettings =
            HttpJsonCallSettings.<ListMembershipsRequest, ListMembershipsResponse>newBuilder()
                .setMethodDescriptor(listMembershipsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetMembershipRequest, Membership> getMembershipTransportSettings =
        HttpJsonCallSettings.<GetMembershipRequest, Membership>newBuilder()
            .setMethodDescriptor(getMembershipMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetMessageRequest, Message> getMessageTransportSettings =
        HttpJsonCallSettings.<GetMessageRequest, Message>newBuilder()
            .setMethodDescriptor(getMessageMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateMessageRequest, Message> updateMessageTransportSettings =
        HttpJsonCallSettings.<UpdateMessageRequest, Message>newBuilder()
            .setMethodDescriptor(updateMessageMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("message.name", String.valueOf(request.getMessage().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteMessageRequest, Empty> deleteMessageTransportSettings =
        HttpJsonCallSettings.<DeleteMessageRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteMessageMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetAttachmentRequest, Attachment> getAttachmentTransportSettings =
        HttpJsonCallSettings.<GetAttachmentRequest, Attachment>newBuilder()
            .setMethodDescriptor(getAttachmentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UploadAttachmentRequest, UploadAttachmentResponse>
        uploadAttachmentTransportSettings =
            HttpJsonCallSettings.<UploadAttachmentRequest, UploadAttachmentResponse>newBuilder()
                .setMethodDescriptor(uploadAttachmentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListSpacesRequest, ListSpacesResponse> listSpacesTransportSettings =
        HttpJsonCallSettings.<ListSpacesRequest, ListSpacesResponse>newBuilder()
            .setMethodDescriptor(listSpacesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetSpaceRequest, Space> getSpaceTransportSettings =
        HttpJsonCallSettings.<GetSpaceRequest, Space>newBuilder()
            .setMethodDescriptor(getSpaceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateSpaceRequest, Space> createSpaceTransportSettings =
        HttpJsonCallSettings.<CreateSpaceRequest, Space>newBuilder()
            .setMethodDescriptor(createSpaceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SetUpSpaceRequest, Space> setUpSpaceTransportSettings =
        HttpJsonCallSettings.<SetUpSpaceRequest, Space>newBuilder()
            .setMethodDescriptor(setUpSpaceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateSpaceRequest, Space> updateSpaceTransportSettings =
        HttpJsonCallSettings.<UpdateSpaceRequest, Space>newBuilder()
            .setMethodDescriptor(updateSpaceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("space.name", String.valueOf(request.getSpace().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteSpaceRequest, Empty> deleteSpaceTransportSettings =
        HttpJsonCallSettings.<DeleteSpaceRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteSpaceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CompleteImportSpaceRequest, CompleteImportSpaceResponse>
        completeImportSpaceTransportSettings =
            HttpJsonCallSettings
                .<CompleteImportSpaceRequest, CompleteImportSpaceResponse>newBuilder()
                .setMethodDescriptor(completeImportSpaceMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<FindDirectMessageRequest, Space> findDirectMessageTransportSettings =
        HttpJsonCallSettings.<FindDirectMessageRequest, Space>newBuilder()
            .setMethodDescriptor(findDirectMessageMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateMembershipRequest, Membership> createMembershipTransportSettings =
        HttpJsonCallSettings.<CreateMembershipRequest, Membership>newBuilder()
            .setMethodDescriptor(createMembershipMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateMembershipRequest, Membership> updateMembershipTransportSettings =
        HttpJsonCallSettings.<UpdateMembershipRequest, Membership>newBuilder()
            .setMethodDescriptor(updateMembershipMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("membership.name", String.valueOf(request.getMembership().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteMembershipRequest, Membership> deleteMembershipTransportSettings =
        HttpJsonCallSettings.<DeleteMembershipRequest, Membership>newBuilder()
            .setMethodDescriptor(deleteMembershipMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateReactionRequest, Reaction> createReactionTransportSettings =
        HttpJsonCallSettings.<CreateReactionRequest, Reaction>newBuilder()
            .setMethodDescriptor(createReactionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListReactionsRequest, ListReactionsResponse>
        listReactionsTransportSettings =
            HttpJsonCallSettings.<ListReactionsRequest, ListReactionsResponse>newBuilder()
                .setMethodDescriptor(listReactionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteReactionRequest, Empty> deleteReactionTransportSettings =
        HttpJsonCallSettings.<DeleteReactionRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteReactionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetSpaceReadStateRequest, SpaceReadState>
        getSpaceReadStateTransportSettings =
            HttpJsonCallSettings.<GetSpaceReadStateRequest, SpaceReadState>newBuilder()
                .setMethodDescriptor(getSpaceReadStateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateSpaceReadStateRequest, SpaceReadState>
        updateSpaceReadStateTransportSettings =
            HttpJsonCallSettings.<UpdateSpaceReadStateRequest, SpaceReadState>newBuilder()
                .setMethodDescriptor(updateSpaceReadStateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "space_read_state.name",
                          String.valueOf(request.getSpaceReadState().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetThreadReadStateRequest, ThreadReadState>
        getThreadReadStateTransportSettings =
            HttpJsonCallSettings.<GetThreadReadStateRequest, ThreadReadState>newBuilder()
                .setMethodDescriptor(getThreadReadStateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();

    this.createMessageCallable =
        callableFactory.createUnaryCallable(
            createMessageTransportSettings, settings.createMessageSettings(), clientContext);
    this.listMessagesCallable =
        callableFactory.createUnaryCallable(
            listMessagesTransportSettings, settings.listMessagesSettings(), clientContext);
    this.listMessagesPagedCallable =
        callableFactory.createPagedCallable(
            listMessagesTransportSettings, settings.listMessagesSettings(), clientContext);
    this.listMembershipsCallable =
        callableFactory.createUnaryCallable(
            listMembershipsTransportSettings, settings.listMembershipsSettings(), clientContext);
    this.listMembershipsPagedCallable =
        callableFactory.createPagedCallable(
            listMembershipsTransportSettings, settings.listMembershipsSettings(), clientContext);
    this.getMembershipCallable =
        callableFactory.createUnaryCallable(
            getMembershipTransportSettings, settings.getMembershipSettings(), clientContext);
    this.getMessageCallable =
        callableFactory.createUnaryCallable(
            getMessageTransportSettings, settings.getMessageSettings(), clientContext);
    this.updateMessageCallable =
        callableFactory.createUnaryCallable(
            updateMessageTransportSettings, settings.updateMessageSettings(), clientContext);
    this.deleteMessageCallable =
        callableFactory.createUnaryCallable(
            deleteMessageTransportSettings, settings.deleteMessageSettings(), clientContext);
    this.getAttachmentCallable =
        callableFactory.createUnaryCallable(
            getAttachmentTransportSettings, settings.getAttachmentSettings(), clientContext);
    this.uploadAttachmentCallable =
        callableFactory.createUnaryCallable(
            uploadAttachmentTransportSettings, settings.uploadAttachmentSettings(), clientContext);
    this.listSpacesCallable =
        callableFactory.createUnaryCallable(
            listSpacesTransportSettings, settings.listSpacesSettings(), clientContext);
    this.listSpacesPagedCallable =
        callableFactory.createPagedCallable(
            listSpacesTransportSettings, settings.listSpacesSettings(), clientContext);
    this.getSpaceCallable =
        callableFactory.createUnaryCallable(
            getSpaceTransportSettings, settings.getSpaceSettings(), clientContext);
    this.createSpaceCallable =
        callableFactory.createUnaryCallable(
            createSpaceTransportSettings, settings.createSpaceSettings(), clientContext);
    this.setUpSpaceCallable =
        callableFactory.createUnaryCallable(
            setUpSpaceTransportSettings, settings.setUpSpaceSettings(), clientContext);
    this.updateSpaceCallable =
        callableFactory.createUnaryCallable(
            updateSpaceTransportSettings, settings.updateSpaceSettings(), clientContext);
    this.deleteSpaceCallable =
        callableFactory.createUnaryCallable(
            deleteSpaceTransportSettings, settings.deleteSpaceSettings(), clientContext);
    this.completeImportSpaceCallable =
        callableFactory.createUnaryCallable(
            completeImportSpaceTransportSettings,
            settings.completeImportSpaceSettings(),
            clientContext);
    this.findDirectMessageCallable =
        callableFactory.createUnaryCallable(
            findDirectMessageTransportSettings,
            settings.findDirectMessageSettings(),
            clientContext);
    this.createMembershipCallable =
        callableFactory.createUnaryCallable(
            createMembershipTransportSettings, settings.createMembershipSettings(), clientContext);
    this.updateMembershipCallable =
        callableFactory.createUnaryCallable(
            updateMembershipTransportSettings, settings.updateMembershipSettings(), clientContext);
    this.deleteMembershipCallable =
        callableFactory.createUnaryCallable(
            deleteMembershipTransportSettings, settings.deleteMembershipSettings(), clientContext);
    this.createReactionCallable =
        callableFactory.createUnaryCallable(
            createReactionTransportSettings, settings.createReactionSettings(), clientContext);
    this.listReactionsCallable =
        callableFactory.createUnaryCallable(
            listReactionsTransportSettings, settings.listReactionsSettings(), clientContext);
    this.listReactionsPagedCallable =
        callableFactory.createPagedCallable(
            listReactionsTransportSettings, settings.listReactionsSettings(), clientContext);
    this.deleteReactionCallable =
        callableFactory.createUnaryCallable(
            deleteReactionTransportSettings, settings.deleteReactionSettings(), clientContext);
    this.getSpaceReadStateCallable =
        callableFactory.createUnaryCallable(
            getSpaceReadStateTransportSettings,
            settings.getSpaceReadStateSettings(),
            clientContext);
    this.updateSpaceReadStateCallable =
        callableFactory.createUnaryCallable(
            updateSpaceReadStateTransportSettings,
            settings.updateSpaceReadStateSettings(),
            clientContext);
    this.getThreadReadStateCallable =
        callableFactory.createUnaryCallable(
            getThreadReadStateTransportSettings,
            settings.getThreadReadStateSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createMessageMethodDescriptor);
    methodDescriptors.add(listMessagesMethodDescriptor);
    methodDescriptors.add(listMembershipsMethodDescriptor);
    methodDescriptors.add(getMembershipMethodDescriptor);
    methodDescriptors.add(getMessageMethodDescriptor);
    methodDescriptors.add(updateMessageMethodDescriptor);
    methodDescriptors.add(deleteMessageMethodDescriptor);
    methodDescriptors.add(getAttachmentMethodDescriptor);
    methodDescriptors.add(uploadAttachmentMethodDescriptor);
    methodDescriptors.add(listSpacesMethodDescriptor);
    methodDescriptors.add(getSpaceMethodDescriptor);
    methodDescriptors.add(createSpaceMethodDescriptor);
    methodDescriptors.add(setUpSpaceMethodDescriptor);
    methodDescriptors.add(updateSpaceMethodDescriptor);
    methodDescriptors.add(deleteSpaceMethodDescriptor);
    methodDescriptors.add(completeImportSpaceMethodDescriptor);
    methodDescriptors.add(findDirectMessageMethodDescriptor);
    methodDescriptors.add(createMembershipMethodDescriptor);
    methodDescriptors.add(updateMembershipMethodDescriptor);
    methodDescriptors.add(deleteMembershipMethodDescriptor);
    methodDescriptors.add(createReactionMethodDescriptor);
    methodDescriptors.add(listReactionsMethodDescriptor);
    methodDescriptors.add(deleteReactionMethodDescriptor);
    methodDescriptors.add(getSpaceReadStateMethodDescriptor);
    methodDescriptors.add(updateSpaceReadStateMethodDescriptor);
    methodDescriptors.add(getThreadReadStateMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateMessageRequest, Message> createMessageCallable() {
    return createMessageCallable;
  }

  @Override
  public UnaryCallable<ListMessagesRequest, ListMessagesResponse> listMessagesCallable() {
    return listMessagesCallable;
  }

  @Override
  public UnaryCallable<ListMessagesRequest, ListMessagesPagedResponse> listMessagesPagedCallable() {
    return listMessagesPagedCallable;
  }

  @Override
  public UnaryCallable<ListMembershipsRequest, ListMembershipsResponse> listMembershipsCallable() {
    return listMembershipsCallable;
  }

  @Override
  public UnaryCallable<ListMembershipsRequest, ListMembershipsPagedResponse>
      listMembershipsPagedCallable() {
    return listMembershipsPagedCallable;
  }

  @Override
  public UnaryCallable<GetMembershipRequest, Membership> getMembershipCallable() {
    return getMembershipCallable;
  }

  @Override
  public UnaryCallable<GetMessageRequest, Message> getMessageCallable() {
    return getMessageCallable;
  }

  @Override
  public UnaryCallable<UpdateMessageRequest, Message> updateMessageCallable() {
    return updateMessageCallable;
  }

  @Override
  public UnaryCallable<DeleteMessageRequest, Empty> deleteMessageCallable() {
    return deleteMessageCallable;
  }

  @Override
  public UnaryCallable<GetAttachmentRequest, Attachment> getAttachmentCallable() {
    return getAttachmentCallable;
  }

  @Override
  public UnaryCallable<UploadAttachmentRequest, UploadAttachmentResponse>
      uploadAttachmentCallable() {
    return uploadAttachmentCallable;
  }

  @Override
  public UnaryCallable<ListSpacesRequest, ListSpacesResponse> listSpacesCallable() {
    return listSpacesCallable;
  }

  @Override
  public UnaryCallable<ListSpacesRequest, ListSpacesPagedResponse> listSpacesPagedCallable() {
    return listSpacesPagedCallable;
  }

  @Override
  public UnaryCallable<GetSpaceRequest, Space> getSpaceCallable() {
    return getSpaceCallable;
  }

  @Override
  public UnaryCallable<CreateSpaceRequest, Space> createSpaceCallable() {
    return createSpaceCallable;
  }

  @Override
  public UnaryCallable<SetUpSpaceRequest, Space> setUpSpaceCallable() {
    return setUpSpaceCallable;
  }

  @Override
  public UnaryCallable<UpdateSpaceRequest, Space> updateSpaceCallable() {
    return updateSpaceCallable;
  }

  @Override
  public UnaryCallable<DeleteSpaceRequest, Empty> deleteSpaceCallable() {
    return deleteSpaceCallable;
  }

  @Override
  public UnaryCallable<CompleteImportSpaceRequest, CompleteImportSpaceResponse>
      completeImportSpaceCallable() {
    return completeImportSpaceCallable;
  }

  @Override
  public UnaryCallable<FindDirectMessageRequest, Space> findDirectMessageCallable() {
    return findDirectMessageCallable;
  }

  @Override
  public UnaryCallable<CreateMembershipRequest, Membership> createMembershipCallable() {
    return createMembershipCallable;
  }

  @Override
  public UnaryCallable<UpdateMembershipRequest, Membership> updateMembershipCallable() {
    return updateMembershipCallable;
  }

  @Override
  public UnaryCallable<DeleteMembershipRequest, Membership> deleteMembershipCallable() {
    return deleteMembershipCallable;
  }

  @Override
  public UnaryCallable<CreateReactionRequest, Reaction> createReactionCallable() {
    return createReactionCallable;
  }

  @Override
  public UnaryCallable<ListReactionsRequest, ListReactionsResponse> listReactionsCallable() {
    return listReactionsCallable;
  }

  @Override
  public UnaryCallable<ListReactionsRequest, ListReactionsPagedResponse>
      listReactionsPagedCallable() {
    return listReactionsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteReactionRequest, Empty> deleteReactionCallable() {
    return deleteReactionCallable;
  }

  @Override
  public UnaryCallable<GetSpaceReadStateRequest, SpaceReadState> getSpaceReadStateCallable() {
    return getSpaceReadStateCallable;
  }

  @Override
  public UnaryCallable<UpdateSpaceReadStateRequest, SpaceReadState> updateSpaceReadStateCallable() {
    return updateSpaceReadStateCallable;
  }

  @Override
  public UnaryCallable<GetThreadReadStateRequest, ThreadReadState> getThreadReadStateCallable() {
    return getThreadReadStateCallable;
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}
