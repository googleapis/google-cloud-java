package com.google.cloud.pubsub.spi.v1;

import com.google.common.truth.Truth;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import org.junit.Test;

public class StatusUtilTest {

  @Test
  public void testIsRetryable() {
    Truth.assertThat(StatusUtil.isRetryable(new StatusRuntimeException(Status.UNAVAILABLE)))
        .isTrue();
    Truth.assertThat(StatusUtil.isRetryable(new StatusRuntimeException(
        Status.UNAVAILABLE.withDescription("Server shutdownNow invoked"))))
        .isFalse();
  }
}
