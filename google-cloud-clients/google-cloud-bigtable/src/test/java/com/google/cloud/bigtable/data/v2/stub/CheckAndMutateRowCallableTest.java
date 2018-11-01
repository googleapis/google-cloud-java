/*
 * Copyright 2018 Google LLC
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
import com.google.cloud.bigtable.data.v2.models.InstanceName;
import com.google.bigtable.v2.CheckAndMutateRowRequest;
import com.google.bigtable.v2.CheckAndMutateRowResponse;
import com.google.bigtable.v2.Mutation.DeleteFromRow;
import com.google.cloud.bigtable.data.v2.internal.RequestContext;
import com.google.cloud.bigtable.data.v2.models.ConditionalRowMutation;
import com.google.cloud.bigtable.data.v2.models.Mutation;
import com.google.protobuf.ByteString;
import io.grpc.Status.Code;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CheckAndMutateRowCallableTest {
  private final RequestContext requestContext =
      RequestContext.create(InstanceName.of("my-project", "my-instance"), "my-app-profile");
  private FakeCallable inner;
  private CheckAndMutateRowCallable callable;

  @Before
  public void setUp() {
    inner = new FakeCallable();
    callable = new CheckAndMutateRowCallable(inner, requestContext);
  }

  @Test
  public void requestIsCorrect() {
    callable.futureCall(
        ConditionalRowMutation.create("my-table", "row-key").then(Mutation.create().deleteRow()));

    assertThat(inner.request)
        .isEqualTo(
            CheckAndMutateRowRequest.newBuilder()
                .setTableName(requestContext.getInstanceName() + "/tables/my-table")
                .setRowKey(ByteString.copyFromUtf8("row-key"))
                .setAppProfileId(requestContext.getAppProfileId())
                .addTrueMutations(
                    com.google.bigtable.v2.Mutation.newBuilder()
                        .setDeleteFromRow(DeleteFromRow.getDefaultInstance()))
                .build());
  }

  @Test
  public void responseCorrectlyTransformed() throws Exception {
    ApiFuture<Boolean> result =
        callable.futureCall(
            ConditionalRowMutation.create("my-table", "row-key")
                .then(Mutation.create().deleteRow()));

    inner.response.set(CheckAndMutateRowResponse.newBuilder().setPredicateMatched(true).build());

    assertThat(result.get(1, TimeUnit.SECONDS)).isEqualTo(true);
  }

  @Test
  public void errorIsPropagated() throws Exception {
    ApiFuture<Boolean> result =
        callable.futureCall(
            ConditionalRowMutation.create("my-table", "row-key")
                .then(Mutation.create().deleteRow()));

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
      extends UnaryCallable<CheckAndMutateRowRequest, CheckAndMutateRowResponse> {
    CheckAndMutateRowRequest request;
    ApiCallContext callContext;
    SettableApiFuture<CheckAndMutateRowResponse> response = SettableApiFuture.create();

    @Override
    public ApiFuture<CheckAndMutateRowResponse> futureCall(
        CheckAndMutateRowRequest request, ApiCallContext context) {
      this.request = request;
      this.callContext = context;

      return response;
    }
  }
}
