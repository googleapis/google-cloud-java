package com.google.cloud.storage.contrib.nio;

import org.junit.Test;
import com.google.cloud.storage.StorageException;
import com.google.common.collect.ImmutableList;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static com.google.common.truth.Truth.assertThat;

@RunWith(JUnit4.class)
public class CloudStorageRetryHandlerTest {

  @Test
  public void testIsRetryable() throws Exception {
    CloudStorageConfiguration config = CloudStorageConfiguration.builder().retryableHttpCodes(ImmutableList.of(1,2,3)).build();
    CloudStorageRetryHandler retrier = new CloudStorageRetryHandler(config);
    assertThat(retrier.isRetryable( new StorageException(1, "pretend error code 1"))).isTrue();
  }
}
