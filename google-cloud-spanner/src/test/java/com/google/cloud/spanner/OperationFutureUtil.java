/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.spanner;

import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.longrunning.OperationFutures;
import com.google.api.gax.longrunning.OperationSnapshot;

// TODO(hzyi): add a public FakeOperationSnapshot in gax to support testing
class OperationFutureUtil {

  private OperationFutureUtil() {
    // Utility class
  }

  public static final <ResponseT, MetadataT> OperationSnapshot fakeOperationFuture(
      final String name, final ResponseT response, final MetadataT metadata) throws Exception {
    OperationSnapshot snapshot =
        new OperationSnapshot() {
          @Override
          public String getName() {
            return name;
          }

          @Override
          public Object getMetadata() {
            return metadata;
          }

          @Override
          public Object getResponse() {
            return response;
          }

          @Override
          public boolean isDone() {
            return true;
          }

          @Override
          public StatusCode getErrorCode() {
            return null;
          }
        };

    return OperationFutures.immediateOperationFuture(snapshot);
  }
}
