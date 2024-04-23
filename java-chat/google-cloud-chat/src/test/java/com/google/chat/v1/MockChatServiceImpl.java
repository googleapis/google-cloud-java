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

package com.google.chat.v1;

import com.google.api.core.BetaApi;
import com.google.chat.v1.ChatServiceGrpc.ChatServiceImplBase;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockChatServiceImpl extends ChatServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockChatServiceImpl() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  public List<AbstractMessage> getRequests() {
    return requests;
  }

  public void addResponse(AbstractMessage response) {
    responses.add(response);
  }

  public void setResponses(List<AbstractMessage> responses) {
    this.responses = new LinkedList<Object>(responses);
  }

  public void addException(Exception exception) {
    responses.add(exception);
  }

  public void reset() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  @Override
  public void createMessage(
      CreateMessageRequest request, StreamObserver<Message> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Message) {
      requests.add(request);
      responseObserver.onNext(((Message) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateMessage, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Message.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listMessages(
      ListMessagesRequest request, StreamObserver<ListMessagesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListMessagesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListMessagesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListMessages, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListMessagesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listMemberships(
      ListMembershipsRequest request, StreamObserver<ListMembershipsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListMembershipsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListMembershipsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListMemberships, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListMembershipsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getMembership(
      GetMembershipRequest request, StreamObserver<Membership> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Membership) {
      requests.add(request);
      responseObserver.onNext(((Membership) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetMembership, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Membership.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getMessage(GetMessageRequest request, StreamObserver<Message> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Message) {
      requests.add(request);
      responseObserver.onNext(((Message) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetMessage, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Message.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateMessage(
      UpdateMessageRequest request, StreamObserver<Message> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Message) {
      requests.add(request);
      responseObserver.onNext(((Message) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateMessage, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Message.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteMessage(DeleteMessageRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteMessage, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAttachment(
      GetAttachmentRequest request, StreamObserver<Attachment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Attachment) {
      requests.add(request);
      responseObserver.onNext(((Attachment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAttachment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Attachment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void uploadAttachment(
      UploadAttachmentRequest request, StreamObserver<UploadAttachmentResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof UploadAttachmentResponse) {
      requests.add(request);
      responseObserver.onNext(((UploadAttachmentResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UploadAttachment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  UploadAttachmentResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listSpaces(
      ListSpacesRequest request, StreamObserver<ListSpacesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListSpacesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListSpacesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListSpaces, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListSpacesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getSpace(GetSpaceRequest request, StreamObserver<Space> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Space) {
      requests.add(request);
      responseObserver.onNext(((Space) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetSpace, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Space.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createSpace(CreateSpaceRequest request, StreamObserver<Space> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Space) {
      requests.add(request);
      responseObserver.onNext(((Space) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateSpace, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Space.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void setUpSpace(SetUpSpaceRequest request, StreamObserver<Space> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Space) {
      requests.add(request);
      responseObserver.onNext(((Space) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SetUpSpace, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Space.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateSpace(UpdateSpaceRequest request, StreamObserver<Space> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Space) {
      requests.add(request);
      responseObserver.onNext(((Space) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateSpace, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Space.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteSpace(DeleteSpaceRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteSpace, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void completeImportSpace(
      CompleteImportSpaceRequest request,
      StreamObserver<CompleteImportSpaceResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CompleteImportSpaceResponse) {
      requests.add(request);
      responseObserver.onNext(((CompleteImportSpaceResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CompleteImportSpace, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CompleteImportSpaceResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void findDirectMessage(
      FindDirectMessageRequest request, StreamObserver<Space> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Space) {
      requests.add(request);
      responseObserver.onNext(((Space) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method FindDirectMessage, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Space.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createMembership(
      CreateMembershipRequest request, StreamObserver<Membership> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Membership) {
      requests.add(request);
      responseObserver.onNext(((Membership) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateMembership, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Membership.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateMembership(
      UpdateMembershipRequest request, StreamObserver<Membership> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Membership) {
      requests.add(request);
      responseObserver.onNext(((Membership) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateMembership, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Membership.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteMembership(
      DeleteMembershipRequest request, StreamObserver<Membership> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Membership) {
      requests.add(request);
      responseObserver.onNext(((Membership) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteMembership, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Membership.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createReaction(
      CreateReactionRequest request, StreamObserver<Reaction> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Reaction) {
      requests.add(request);
      responseObserver.onNext(((Reaction) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateReaction, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Reaction.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listReactions(
      ListReactionsRequest request, StreamObserver<ListReactionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListReactionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListReactionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListReactions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListReactionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteReaction(
      DeleteReactionRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteReaction, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getSpaceReadState(
      GetSpaceReadStateRequest request, StreamObserver<SpaceReadState> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SpaceReadState) {
      requests.add(request);
      responseObserver.onNext(((SpaceReadState) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetSpaceReadState, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SpaceReadState.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateSpaceReadState(
      UpdateSpaceReadStateRequest request, StreamObserver<SpaceReadState> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SpaceReadState) {
      requests.add(request);
      responseObserver.onNext(((SpaceReadState) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateSpaceReadState, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SpaceReadState.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getThreadReadState(
      GetThreadReadStateRequest request, StreamObserver<ThreadReadState> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ThreadReadState) {
      requests.add(request);
      responseObserver.onNext(((ThreadReadState) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetThreadReadState, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ThreadReadState.class.getName(),
                  Exception.class.getName())));
    }
  }
}
