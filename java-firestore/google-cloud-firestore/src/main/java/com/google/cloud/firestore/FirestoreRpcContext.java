/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.firestore;

import static com.google.api.gax.util.TimeConversionUtils.toJavaTimeDuration;

import com.google.api.core.ApiClock;
import com.google.api.core.ApiFuture;
import com.google.api.core.InternalApi;
import com.google.api.core.InternalExtensionOnly;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.rpc.BidiStreamObserver;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientStream;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.firestore.spi.v1.FirestoreRpc;

@InternalApi
@InternalExtensionOnly
interface FirestoreRpcContext<FS extends Firestore> {

  FS getFirestore();

  String getDatabaseName();

  ResourcePath getResourcePath();

  FirestoreRpc getClient();

  /** This method is obsolete. Use {@link #getTotalRequestTimeoutDuration()} instead. */
  @ObsoleteApi("Use getTotalRequestTimeoutDuration() instead")
  org.threeten.bp.Duration getTotalRequestTimeout();

  default java.time.Duration getTotalRequestTimeoutDuration() {
    return toJavaTimeDuration(getTotalRequestTimeout());
  }

  ApiClock getClock();

  <RequestT, ResponseT> ApiFuture<ResponseT> sendRequest(
      RequestT requestT, UnaryCallable<RequestT, ResponseT> callable);

  <RequestT, ResponseT> void streamRequest(
      RequestT requestT,
      ResponseObserver<ResponseT> responseObserverT,
      ServerStreamingCallable<RequestT, ResponseT> callable);

  <RequestT, ResponseT> ClientStream<RequestT> streamRequest(
      BidiStreamObserver<RequestT, ResponseT> responseObserverT,
      BidiStreamingCallable<RequestT, ResponseT> callable);
}
