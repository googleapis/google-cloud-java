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

package com.google.cloud.storage;

import com.google.api.gax.rpc.ClientStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.storage.Retrying.RetrierWithAlg;
import com.google.storage.v2.QueryWriteStatusRequest;
import com.google.storage.v2.QueryWriteStatusResponse;
import com.google.storage.v2.WriteObjectRequest;
import com.google.storage.v2.WriteObjectResponse;

final class ResumableSession {

  private ResumableSession() {}

  static JsonResumableSession json(
      HttpClientContext context, RetrierWithAlg retrier, JsonResumableWrite resumableWrite) {
    return new JsonResumableSession(context, retrier, resumableWrite);
  }

  static GrpcResumableSession grpc(
      RetrierWithAlg retrier,
      ClientStreamingCallable<WriteObjectRequest, WriteObjectResponse> writeCallable,
      UnaryCallable<QueryWriteStatusRequest, QueryWriteStatusResponse> queryWriteStatusCallable,
      ResumableWrite resumableWrite,
      Hasher hasher) {
    return new GrpcResumableSession(
        retrier, writeCallable, queryWriteStatusCallable, resumableWrite, hasher);
  }
}
