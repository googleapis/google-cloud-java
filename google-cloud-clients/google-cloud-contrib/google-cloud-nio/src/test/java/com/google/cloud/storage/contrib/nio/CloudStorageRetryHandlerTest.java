/*
 * Copyright 2018 Google LLC
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
