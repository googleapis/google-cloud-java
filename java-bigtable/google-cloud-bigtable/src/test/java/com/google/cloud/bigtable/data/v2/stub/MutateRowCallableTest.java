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

import com.google.api.core.SettableApiFuture;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.bigtable.v2.MutateRowRequest;
import com.google.bigtable.v2.MutateRowResponse;
import com.google.cloud.bigtable.data.v2.internal.RequestContext;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
import com.google.common.truth.Truth;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

@RunWith(JUnit4.class)
public class MutateRowCallableTest {

  private static final RequestContext REQUEST_CONTEXT =
      RequestContext.create("fake-project", "fake-instance", "fake-profile");
  private UnaryCallable<MutateRowRequest, MutateRowResponse> innerCallable;
  private ArgumentCaptor<MutateRowRequest> innerMutation;
  private SettableApiFuture<MutateRowResponse> innerResult;

  @SuppressWarnings("unchecked")
  @Before
  public void setUp() {
    innerCallable = Mockito.mock(UnaryCallable.class);
    innerMutation = ArgumentCaptor.forClass(MutateRowRequest.class);
    innerResult = SettableApiFuture.create();
    Mockito.when(innerCallable.futureCall(innerMutation.capture(), Mockito.any()))
        .thenReturn(innerResult);
  }

  @Test
  public void testRequestConversion() {
    MutateRowCallable callable = new MutateRowCallable(innerCallable, REQUEST_CONTEXT);
    RowMutation outerRequest =
        RowMutation.create("fake-table", "fake-key")
            .setCell("fake-family", "fake-qualifier", 1_000, "fake-value");

    innerResult.set(MutateRowResponse.getDefaultInstance());
    callable.call(outerRequest);

    Truth.assertThat(innerMutation.getValue()).isEqualTo(outerRequest.toProto(REQUEST_CONTEXT));
  }
}
