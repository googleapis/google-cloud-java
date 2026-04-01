/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.storage.spi.v1;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.cloud.Tuple;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class AuditingHttpTransport extends HttpTransport {
  private final LowLevelHttpResponse response;
  private final List<Tuple<String, String>> buildRequestCalls;
  private final List<Tuple<String, String>> addHeaderCalls;

  public AuditingHttpTransport(LowLevelHttpResponse response) {
    this.response = response;
    this.buildRequestCalls = Collections.synchronizedList(new ArrayList<>());
    this.addHeaderCalls = Collections.synchronizedList(new ArrayList<>());
  }

  public List<Tuple<String, String>> getBuildRequestCalls() {
    return ImmutableList.copyOf(buildRequestCalls);
  }

  public List<Tuple<String, String>> getAddHeaderCalls() {
    return ImmutableList.copyOf(addHeaderCalls);
  }

  @Override
  protected LowLevelHttpRequest buildRequest(String method, String url) {
    buildRequestCalls.add(Tuple.of(method, url));
    return new LowLevelHttpRequest() {
      @Override
      public void addHeader(String name, String value) {
        addHeaderCalls.add(Tuple.of(name, value));
      }

      @Override
      public LowLevelHttpResponse execute() {
        return response;
      }
    };
  }
}
