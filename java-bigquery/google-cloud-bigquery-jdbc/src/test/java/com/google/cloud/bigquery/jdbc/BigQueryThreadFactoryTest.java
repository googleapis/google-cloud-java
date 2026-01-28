/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

import static com.google.common.truth.Truth.assertThat;

import java.util.concurrent.ThreadFactory;
import org.junit.Before;
import org.junit.Test;

public class BigQueryThreadFactoryTest {

  private static ThreadFactory JDBC_THREAD_FACTORY;

  @Before
  public void setUp() {
    JDBC_THREAD_FACTORY = new BigQueryThreadFactory("BigQuery-Thread-");
  }

  @Test
  public void testNewThread() {
    assertThat(JDBC_THREAD_FACTORY).isNotNull();
    Thread thread = JDBC_THREAD_FACTORY.newThread(() -> {});
    assertThat(thread).isNotNull();
    assertThat(thread.getName()).startsWith("BigQuery-Thread-");
  }
}
