/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.core.ApiFuture;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.NotFoundException;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.bigtable.v2.SampleRowKeysResponse;
import com.google.cloud.bigtable.data.v2.internal.NameUtil;
import com.google.cloud.bigtable.data.v2.internal.RequestContext;
import com.google.cloud.bigtable.data.v2.models.KeyOffset;
import com.google.cloud.bigtable.data.v2.models.SampleRowKeysRequest;
import com.google.cloud.bigtable.data.v2.models.TableId;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.ByteString;
import io.grpc.Status.Code;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SampleRowKeysCallableWithRequestTest {

  private final RequestContext requestContext =
      RequestContext.create("my-project", "my-instance", "my-profile");
  private FakeCallable inner;
  private SampleRowKeysCallableWithRequest callable;

  @Before
  public void setUp() {
    inner = new FakeCallable();
    callable = new SampleRowKeysCallableWithRequest(inner, requestContext);
  }

  @Test
  public void requestIsCorrect() {
    callable.futureCall(SampleRowKeysRequest.create(TableId.of("my-table")));

    assertThat(inner.request)
        .isEqualTo(
            com.google.bigtable.v2.SampleRowKeysRequest.newBuilder()
                .setTableName(
                    NameUtil.formatTableName(
                        requestContext.getProjectId(), requestContext.getInstanceId(), "my-table"))
                .setAppProfileId(requestContext.getAppProfileId())
                .build());
  }

  @Test
  public void responseCorrectlyTransformed() throws Exception {
    ApiFuture<List<KeyOffset>> result =
        callable.futureCall(SampleRowKeysRequest.create(TableId.of("my-table")));

    inner.response.set(
        ImmutableList.of(
            SampleRowKeysResponse.newBuilder()
                .setRowKey(ByteString.copyFromUtf8("key1"))
                .setOffsetBytes(100)
                .build(),
            SampleRowKeysResponse.newBuilder()
                .setRowKey(ByteString.copyFromUtf8(""))
                .setOffsetBytes(1000)
                .build()));

    assertThat(result.get(1, TimeUnit.SECONDS))
        .isEqualTo(
            ImmutableList.of(
                KeyOffset.create(ByteString.copyFromUtf8("key1"), 100),
                KeyOffset.create(ByteString.EMPTY, 1000)));
  }

  @Test
  public void errorIsPropagated() throws Exception {
    ApiFuture<List<KeyOffset>> result =
        callable.futureCall(SampleRowKeysRequest.create(TableId.of("my-table")));

    Throwable expectedError =
        new NotFoundException("fake error", null, GrpcStatusCode.of(Code.NOT_FOUND), false);
    inner.response.setException(expectedError);

    Throwable actualError = null;
    try {
      result.get(1, TimeUnit.SECONDS);
    } catch (ExecutionException e) {
      actualError = e.getCause();
    }

    assertThat(actualError).isEqualTo(expectedError);
  }

  static class FakeCallable
      extends UnaryCallable<
          com.google.bigtable.v2.SampleRowKeysRequest, List<SampleRowKeysResponse>> {
    com.google.bigtable.v2.SampleRowKeysRequest request;
    ApiCallContext callContext;
    SettableApiFuture<List<SampleRowKeysResponse>> response = SettableApiFuture.create();

    @Override
    public ApiFuture<List<SampleRowKeysResponse>> futureCall(
        com.google.bigtable.v2.SampleRowKeysRequest request, ApiCallContext context) {
      this.request = request;
      this.callContext = context;

      return response;
    }
  }
}
