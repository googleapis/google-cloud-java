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

import com.google.api.gax.core.BackgroundResource;
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
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ChatService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ChatServiceStub implements BackgroundResource {

  public UnaryCallable<CreateMessageRequest, Message> createMessageCallable() {
    throw new UnsupportedOperationException("Not implemented: createMessageCallable()");
  }

  public UnaryCallable<ListMessagesRequest, ListMessagesPagedResponse> listMessagesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listMessagesPagedCallable()");
  }

  public UnaryCallable<ListMessagesRequest, ListMessagesResponse> listMessagesCallable() {
    throw new UnsupportedOperationException("Not implemented: listMessagesCallable()");
  }

  public UnaryCallable<ListMembershipsRequest, ListMembershipsPagedResponse>
      listMembershipsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listMembershipsPagedCallable()");
  }

  public UnaryCallable<ListMembershipsRequest, ListMembershipsResponse> listMembershipsCallable() {
    throw new UnsupportedOperationException("Not implemented: listMembershipsCallable()");
  }

  public UnaryCallable<GetMembershipRequest, Membership> getMembershipCallable() {
    throw new UnsupportedOperationException("Not implemented: getMembershipCallable()");
  }

  public UnaryCallable<GetMessageRequest, Message> getMessageCallable() {
    throw new UnsupportedOperationException("Not implemented: getMessageCallable()");
  }

  public UnaryCallable<UpdateMessageRequest, Message> updateMessageCallable() {
    throw new UnsupportedOperationException("Not implemented: updateMessageCallable()");
  }

  public UnaryCallable<DeleteMessageRequest, Empty> deleteMessageCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteMessageCallable()");
  }

  public UnaryCallable<GetAttachmentRequest, Attachment> getAttachmentCallable() {
    throw new UnsupportedOperationException("Not implemented: getAttachmentCallable()");
  }

  public UnaryCallable<UploadAttachmentRequest, UploadAttachmentResponse>
      uploadAttachmentCallable() {
    throw new UnsupportedOperationException("Not implemented: uploadAttachmentCallable()");
  }

  public UnaryCallable<ListSpacesRequest, ListSpacesPagedResponse> listSpacesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSpacesPagedCallable()");
  }

  public UnaryCallable<ListSpacesRequest, ListSpacesResponse> listSpacesCallable() {
    throw new UnsupportedOperationException("Not implemented: listSpacesCallable()");
  }

  public UnaryCallable<GetSpaceRequest, Space> getSpaceCallable() {
    throw new UnsupportedOperationException("Not implemented: getSpaceCallable()");
  }

  public UnaryCallable<CreateSpaceRequest, Space> createSpaceCallable() {
    throw new UnsupportedOperationException("Not implemented: createSpaceCallable()");
  }

  public UnaryCallable<SetUpSpaceRequest, Space> setUpSpaceCallable() {
    throw new UnsupportedOperationException("Not implemented: setUpSpaceCallable()");
  }

  public UnaryCallable<UpdateSpaceRequest, Space> updateSpaceCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSpaceCallable()");
  }

  public UnaryCallable<DeleteSpaceRequest, Empty> deleteSpaceCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSpaceCallable()");
  }

  public UnaryCallable<CompleteImportSpaceRequest, CompleteImportSpaceResponse>
      completeImportSpaceCallable() {
    throw new UnsupportedOperationException("Not implemented: completeImportSpaceCallable()");
  }

  public UnaryCallable<FindDirectMessageRequest, Space> findDirectMessageCallable() {
    throw new UnsupportedOperationException("Not implemented: findDirectMessageCallable()");
  }

  public UnaryCallable<CreateMembershipRequest, Membership> createMembershipCallable() {
    throw new UnsupportedOperationException("Not implemented: createMembershipCallable()");
  }

  public UnaryCallable<UpdateMembershipRequest, Membership> updateMembershipCallable() {
    throw new UnsupportedOperationException("Not implemented: updateMembershipCallable()");
  }

  public UnaryCallable<DeleteMembershipRequest, Membership> deleteMembershipCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteMembershipCallable()");
  }

  public UnaryCallable<CreateReactionRequest, Reaction> createReactionCallable() {
    throw new UnsupportedOperationException("Not implemented: createReactionCallable()");
  }

  public UnaryCallable<ListReactionsRequest, ListReactionsPagedResponse>
      listReactionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listReactionsPagedCallable()");
  }

  public UnaryCallable<ListReactionsRequest, ListReactionsResponse> listReactionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listReactionsCallable()");
  }

  public UnaryCallable<DeleteReactionRequest, Empty> deleteReactionCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteReactionCallable()");
  }

  public UnaryCallable<GetSpaceReadStateRequest, SpaceReadState> getSpaceReadStateCallable() {
    throw new UnsupportedOperationException("Not implemented: getSpaceReadStateCallable()");
  }

  public UnaryCallable<UpdateSpaceReadStateRequest, SpaceReadState> updateSpaceReadStateCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSpaceReadStateCallable()");
  }

  public UnaryCallable<GetThreadReadStateRequest, ThreadReadState> getThreadReadStateCallable() {
    throw new UnsupportedOperationException("Not implemented: getThreadReadStateCallable()");
  }

  @Override
  public abstract void close();
}
