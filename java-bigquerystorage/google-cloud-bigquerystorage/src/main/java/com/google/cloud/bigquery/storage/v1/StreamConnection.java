/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.bigquery.storage.v1;

import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientStream;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.StreamController;
import io.grpc.CallOptions;
import io.grpc.Status;
import io.grpc.Status.Code;
import io.grpc.StatusRuntimeException;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/**
 * StreamConnection is responsible for writing requests to a GRPC bidirecional connection.
 *
 * <p>StreamWriter creates a connection. Two callback functions are necessary: request_callback and
 * done_callback. Request callback is used for every request, and done callback is used to notify
 * the user that the connection is closed and no more callbacks will be received from this
 * connection.
 *
 * <p>The stream writer will accept all the requests without flow control, and makes the callbacks
 * in receiving order.
 *
 * <p>It's user's responsibility to do the flow control and maintain the lifetime of the requests.
 */
class StreamConnection {
  private BidiStreamingCallable<AppendRowsRequest, AppendRowsResponse> bidiStreamingCallable;
  private ClientStream<AppendRowsRequest> clientStream;

  private RequestCallback requestCallback;
  private DoneCallback doneCallback;

  private static final Logger log = Logger.getLogger(StreamConnection.class.getName());

  public StreamConnection(
      BigQueryWriteClient client,
      RequestCallback requestCallback,
      DoneCallback doneCallback,
      @Nullable String compressorName) {
    this.requestCallback = requestCallback;
    this.doneCallback = doneCallback;

    ApiCallContext apiCallContext = null;
    if (compressorName != null) {
      apiCallContext =
          GrpcCallContext.createDefault()
              .withCallOptions(CallOptions.DEFAULT.withCompression(compressorName));
      log.info("gRPC compression is enabled with " + compressorName + " compression");
    }

    bidiStreamingCallable = client.appendRowsCallable();
    clientStream =
        bidiStreamingCallable.splitCall(
            new ResponseObserver<AppendRowsResponse>() {

              @Override
              public void onStart(StreamController controller) {
                // no-op
              }

              @Override
              public void onResponse(AppendRowsResponse response) {
                StreamConnection.this.requestCallback.run(response);
              }

              @Override
              public void onError(Throwable t) {
                StreamConnection.this.doneCallback.run(t);
              }

              @Override
              public void onComplete() {
                StreamConnection.this.doneCallback.run(
                    new StatusRuntimeException(
                        Status.fromCode(Code.CANCELLED)
                            .withDescription("Stream is closed by user.")));
              }
            },
            apiCallContext);
  }

  /**
   * Sends a request to the bi-directional stream connection.
   *
   * @param request request to send.
   */
  public void send(AppendRowsRequest request) {
    clientStream.send(request);
  }

  /** Close the bi-directional stream connection. */
  public void close() {
    clientStream.closeSend();
  }

  /** Invoked when a response is received from the server. */
  public static interface RequestCallback {
    public void run(AppendRowsResponse response);
  }

  /** Invoked when server closes the connection. */
  public static interface DoneCallback {
    public void run(Throwable finalStatus);
  }
}
