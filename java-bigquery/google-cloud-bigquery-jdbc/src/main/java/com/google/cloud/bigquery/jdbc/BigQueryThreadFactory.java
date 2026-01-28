/*
 * Copyright 2023 Google LLC
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

import com.google.api.core.InternalApi;
import java.util.concurrent.ThreadFactory;

@InternalApi
class BigQueryThreadFactory implements ThreadFactory {
  private static final BigQueryJdbcCustomLogger LOG =
      new BigQueryJdbcCustomLogger(BigQueryThreadFactory.class.getName());
  private String threadPrefix;
  private int threadSerialNum = 0;

  public BigQueryThreadFactory(String threadPrefix) {
    this.threadPrefix = threadPrefix;
  }

  public BigQueryThreadFactory() {
    this.threadPrefix = "DEFAULT_POOL_";
  }

  @Override
  public Thread newThread(Runnable r) {
    Thread t = new Thread(r, threadPrefix + (++threadSerialNum)); // non thread safe increment
    t.setDaemon(true);
    LOG.finest(String.format("New thread %s created.", t.getName()));
    return t;
  }
}
