/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.benchwrapper;

import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.nio.ByteBuffer;

import com.google.cloud.benchwrapper.PubsubBenchWrapperGrpc.PubsubBenchWrapperImplBase;
import com.google.cloud.ReadChannel;
import com.google.cloud.pubsub.v1.AckReplyConsumer;
import com.google.cloud.pubsub.v1.MessageReceiver;
import com.google.cloud.pubsub.v1.Subscriber;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.pubsub.v1.PubsubMessage;
import com.google.api.gax.core.InstantiatingExecutorProvider;

class PubsubBenchWrapperImpl extends PubsubBenchWrapperImplBase {
  private Pubsub client;

  public PubsubBenchWrapperImpl(String pubsubEmulatorHost) {
    
  }

  public void recv(PubsubRecv request, StreamObserver<EmptyResponse> responseObserver) {
    System.out.println("recv has been called");

    ProjectSubscriptionName subscriptionName = ProjectSubscriptionName.of(
        "some-project", request.getSubName());
    
    Subscriber subscriber = null;
    try {
      InstantiatingExecutorProvider executorProvider =
        InstantiatingExecutorProvider.newBuilder().setExecutorThreadCount(1).build();

      subscriber =
          Subscriber.newBuilder(subscriptionName, new SimpleReceiver())
              .setExecutorProvider(executorProvider)
              .build();
      subscriber.startAsync().awaitRunning();

      // Allow the subscriber to run indefinitely unless an unrecoverable error occurs.
      subscriber.awaitTerminated();
    } catch (IllegalStateException e) {
      System.out.println("Subscriber unexpectedly stopped: " + e);
    }

    EmptyResponse reply = EmptyResponse.newBuilder().build();
    responseObserver.onNext(reply);
    responseObserver.onCompleted();
  }

  static class SimpleReceiver implements MessageReceiver {
    @Override
    public void receiveMessage(PubsubMessage message, AckReplyConsumer consumer) {
      consumer.ack();
    }
  }
}
