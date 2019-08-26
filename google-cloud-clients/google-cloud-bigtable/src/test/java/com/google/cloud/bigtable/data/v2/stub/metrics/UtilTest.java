package com.google.cloud.bigtable.data.v2.stub.metrics;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.DeadlineExceededException;
import com.google.common.util.concurrent.Futures;
import io.grpc.Status;
import io.opencensus.tags.TagValue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class UtilTest {
  @Test
  public void testOk() {
    TagValue tagValue = Util.extractStatus((Throwable) null);
    assertThat(tagValue.asString()).isEqualTo("OK");
  }

  @Test
  public void testOkFuture() {
    TagValue tagValue = Util.extractStatus(Futures.immediateFuture(null));
    assertThat(tagValue.asString()).isEqualTo("OK");
  }

  @Test
  public void testError() {
    DeadlineExceededException error =
        new DeadlineExceededException(
            "Deadline exceeded", null, GrpcStatusCode.of(Status.Code.DEADLINE_EXCEEDED), true);
    TagValue tagValue = Util.extractStatus(error);
    assertThat(tagValue.asString()).isEqualTo("DEADLINE_EXCEEDED");
  }

  @Test
  public void testErrorFuture() {
    DeadlineExceededException error =
        new DeadlineExceededException(
            "Deadline exceeded", null, GrpcStatusCode.of(Status.Code.DEADLINE_EXCEEDED), true);
    TagValue tagValue = Util.extractStatus(Futures.immediateFailedFuture(error));
    assertThat(tagValue.asString()).isEqualTo("DEADLINE_EXCEEDED");
  }

  @Test
  public void testCancelledFuture() {
    TagValue tagValue = Util.extractStatus(Futures.immediateCancelledFuture());
    assertThat(tagValue.asString()).isEqualTo("CANCELLED");
  }
}
