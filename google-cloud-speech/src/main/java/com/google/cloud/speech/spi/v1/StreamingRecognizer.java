/*
 * Copyright 2017, Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.speech.spi.v1;

import com.google.api.gax.grpc.ApiStreamObserver;
import com.google.cloud.speech.v1.StreamingRecognitionConfig;
import com.google.cloud.speech.v1.StreamingRecognizeRequest;
import com.google.cloud.speech.v1.StreamingRecognizeResponse;
import com.google.protobuf.ByteString;
import java.io.OutputStream;

public class StreamingRecognizer {
  public static OutputStream call(
      SpeechClient client,
      StreamingRecognitionConfig config,
      ApiStreamObserver<StreamingRecognizeResponse> responseObserver) {
    ApiStreamObserver<StreamingRecognizeRequest> requestObserver =
        client.streamingRecognizeCallable().bidiStreamingCall(responseObserver);
    requestObserver.onNext(
        StreamingRecognizeRequest.newBuilder().setStreamingConfig(config).build());
    return new StreamWriter(requestObserver);
  }

  private static class StreamWriter extends OutputStream {
    private final ApiStreamObserver<StreamingRecognizeRequest> stream;

    private StreamWriter(ApiStreamObserver<StreamingRecognizeRequest> stream) {
      this.stream = stream;
    }

    @Override
    public void close() {
      stream.onCompleted();
    }

    @Override
    public void write(byte[] b, int off, int len) {
      stream.onNext(
          StreamingRecognizeRequest.newBuilder()
              .setAudioContent(ByteString.copyFrom(b, off, len))
              .build());
    }

    /**
     * This method exists to satisfy the abstract OutputStream class. However, it's probably slow
     * and should be avoided. If writing byte-by-byte is required, consider buffering the stream.
     */
    @Override
    public void write(int b) {
      stream.onNext(
          StreamingRecognizeRequest.newBuilder()
              .setAudioContent(ByteString.copyFrom(new byte[] {(byte) (b & 0xFF)}))
              .build());
    }
  }
}
