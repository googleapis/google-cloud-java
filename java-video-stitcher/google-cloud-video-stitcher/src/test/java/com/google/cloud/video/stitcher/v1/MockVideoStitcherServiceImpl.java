/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.video.stitcher.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.video.stitcher.v1.VideoStitcherServiceGrpc.VideoStitcherServiceImplBase;
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
public class MockVideoStitcherServiceImpl extends VideoStitcherServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockVideoStitcherServiceImpl() {
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
  public void createCdnKey(CreateCdnKeyRequest request, StreamObserver<CdnKey> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CdnKey) {
      requests.add(request);
      responseObserver.onNext(((CdnKey) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateCdnKey, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CdnKey.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listCdnKeys(
      ListCdnKeysRequest request, StreamObserver<ListCdnKeysResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListCdnKeysResponse) {
      requests.add(request);
      responseObserver.onNext(((ListCdnKeysResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListCdnKeys, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListCdnKeysResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getCdnKey(GetCdnKeyRequest request, StreamObserver<CdnKey> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CdnKey) {
      requests.add(request);
      responseObserver.onNext(((CdnKey) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetCdnKey, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CdnKey.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteCdnKey(DeleteCdnKeyRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteCdnKey, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateCdnKey(UpdateCdnKeyRequest request, StreamObserver<CdnKey> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CdnKey) {
      requests.add(request);
      responseObserver.onNext(((CdnKey) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateCdnKey, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CdnKey.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createVodSession(
      CreateVodSessionRequest request, StreamObserver<VodSession> responseObserver) {
    Object response = responses.poll();
    if (response instanceof VodSession) {
      requests.add(request);
      responseObserver.onNext(((VodSession) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateVodSession, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  VodSession.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getVodSession(
      GetVodSessionRequest request, StreamObserver<VodSession> responseObserver) {
    Object response = responses.poll();
    if (response instanceof VodSession) {
      requests.add(request);
      responseObserver.onNext(((VodSession) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetVodSession, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  VodSession.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listVodStitchDetails(
      ListVodStitchDetailsRequest request,
      StreamObserver<ListVodStitchDetailsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListVodStitchDetailsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListVodStitchDetailsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListVodStitchDetails, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListVodStitchDetailsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getVodStitchDetail(
      GetVodStitchDetailRequest request, StreamObserver<VodStitchDetail> responseObserver) {
    Object response = responses.poll();
    if (response instanceof VodStitchDetail) {
      requests.add(request);
      responseObserver.onNext(((VodStitchDetail) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetVodStitchDetail, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  VodStitchDetail.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listVodAdTagDetails(
      ListVodAdTagDetailsRequest request,
      StreamObserver<ListVodAdTagDetailsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListVodAdTagDetailsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListVodAdTagDetailsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListVodAdTagDetails, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListVodAdTagDetailsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getVodAdTagDetail(
      GetVodAdTagDetailRequest request, StreamObserver<VodAdTagDetail> responseObserver) {
    Object response = responses.poll();
    if (response instanceof VodAdTagDetail) {
      requests.add(request);
      responseObserver.onNext(((VodAdTagDetail) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetVodAdTagDetail, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  VodAdTagDetail.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listLiveAdTagDetails(
      ListLiveAdTagDetailsRequest request,
      StreamObserver<ListLiveAdTagDetailsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListLiveAdTagDetailsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListLiveAdTagDetailsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListLiveAdTagDetails, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListLiveAdTagDetailsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getLiveAdTagDetail(
      GetLiveAdTagDetailRequest request, StreamObserver<LiveAdTagDetail> responseObserver) {
    Object response = responses.poll();
    if (response instanceof LiveAdTagDetail) {
      requests.add(request);
      responseObserver.onNext(((LiveAdTagDetail) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetLiveAdTagDetail, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  LiveAdTagDetail.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createSlate(CreateSlateRequest request, StreamObserver<Slate> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Slate) {
      requests.add(request);
      responseObserver.onNext(((Slate) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateSlate, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Slate.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listSlates(
      ListSlatesRequest request, StreamObserver<ListSlatesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListSlatesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListSlatesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListSlates, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListSlatesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getSlate(GetSlateRequest request, StreamObserver<Slate> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Slate) {
      requests.add(request);
      responseObserver.onNext(((Slate) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetSlate, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Slate.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateSlate(UpdateSlateRequest request, StreamObserver<Slate> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Slate) {
      requests.add(request);
      responseObserver.onNext(((Slate) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateSlate, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Slate.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteSlate(DeleteSlateRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteSlate, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createLiveSession(
      CreateLiveSessionRequest request, StreamObserver<LiveSession> responseObserver) {
    Object response = responses.poll();
    if (response instanceof LiveSession) {
      requests.add(request);
      responseObserver.onNext(((LiveSession) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateLiveSession, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  LiveSession.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getLiveSession(
      GetLiveSessionRequest request, StreamObserver<LiveSession> responseObserver) {
    Object response = responses.poll();
    if (response instanceof LiveSession) {
      requests.add(request);
      responseObserver.onNext(((LiveSession) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetLiveSession, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  LiveSession.class.getName(),
                  Exception.class.getName())));
    }
  }
}
