package com.google.cloud.pubsub.v1;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.ApiException;
import io.grpc.Status.Code;
import org.junit.Test;

public class StatusUtilTest {

  @Test
  public void testIsRetryable() {
    assertThat(
            StatusUtil.isRetryable(
                new ApiException("derp", null, GrpcStatusCode.of(Code.UNAVAILABLE), false)))
        .isTrue();
    assertThat(
            StatusUtil.isRetryable(
                new ApiException(
                    "Server shutdownNow invoked",
                    null,
                    GrpcStatusCode.of(Code.UNAVAILABLE),
                    false)))
        .isFalse();
  }
}
