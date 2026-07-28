/*
 * Copyright 2025 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub.sql;

import com.google.api.core.InternalApi;
import com.google.api.gax.retrying.StreamResumptionStrategy;
import com.google.bigtable.v2.ExecuteQueryResponse;
import com.google.protobuf.ByteString;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@InternalApi
public class ExecuteQueryResumptionStrategy
    implements StreamResumptionStrategy<ExecuteQueryCallContext, ExecuteQueryResponse> {

  private ByteString latestResumeToken = null;

  @Nonnull
  @Override
  public StreamResumptionStrategy<ExecuteQueryCallContext, ExecuteQueryResponse> createNew() {
    return new ExecuteQueryResumptionStrategy();
  }

  @Nonnull
  @Override
  public ExecuteQueryResponse processResponse(ExecuteQueryResponse response) {
    if (!response.getResults().getResumeToken().isEmpty()) {
      latestResumeToken = response.getResults().getResumeToken();
    }
    return response;
  }

  @Nullable
  @Override
  public ExecuteQueryCallContext getResumeRequest(ExecuteQueryCallContext originalRequest) {
    if (latestResumeToken != null) {
      // ExecuteQueryCallContext can handle null token, but we don't bother setting it for
      // clarity
      originalRequest.setLatestResumeToken(latestResumeToken);
    }
    return originalRequest;
  }

  @Override
  public boolean canResume() {
    return true;
  }
}
