/*
 * Copyright 2023 Google LLC
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

import com.google.api.gax.rpc.BidiStreamObserver;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientStream;

public final class FirestoreSpy {

  public final FirestoreImpl spy;
  public BidiStreamObserver streamRequestBidiStreamObserver;

  public FirestoreSpy(FirestoreOptions firestoreOptions) {
    spy =
        new FirestoreImpl(firestoreOptions) {
          @Override
          public <RequestT, ResponseT> ClientStream<RequestT> streamRequest(
              BidiStreamObserver<RequestT, ResponseT> responseObserverT,
              BidiStreamingCallable<RequestT, ResponseT> callable) {
            streamRequestBidiStreamObserver = responseObserverT;
            return super.streamRequest(responseObserverT, callable);
          }
        };
  }
}
