package com.google.cloud.bigtable.data.v2.stub;

import com.google.api.core.SettableApiFuture;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.bigtable.admin.v2.InstanceName;
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
      RequestContext.create(InstanceName.of("fake-project", "fake-instance"), "fake-profile");
  private UnaryCallable<MutateRowRequest, MutateRowResponse> innerCallable;
  private ArgumentCaptor<MutateRowRequest> innerMutation;
  private SettableApiFuture<MutateRowResponse> innerResult;

  @SuppressWarnings("unchecked")
  @Before
  public void setUp() {
    innerCallable = Mockito.mock(UnaryCallable.class);
    innerMutation = ArgumentCaptor.forClass(MutateRowRequest.class);
    innerResult = SettableApiFuture.create();
    Mockito.when(
            innerCallable.futureCall(innerMutation.capture(), Mockito.any(ApiCallContext.class)))
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
