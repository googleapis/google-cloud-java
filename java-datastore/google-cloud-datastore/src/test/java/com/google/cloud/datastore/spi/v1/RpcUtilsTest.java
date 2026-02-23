/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.datastore.spi.v1;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.datastore.DatastoreOptions;
import java.time.Duration;
import org.junit.Test;

public class RpcUtilsTest {

  @Test
  public void testRetrySettingSetter() {
    UnaryCallSettings.Builder<Object, Object> builder =
        UnaryCallSettings.newUnaryCallSettingsBuilder();

    // datastoreOptions with default retry settings
    DatastoreOptions datastoreOptions =
        DatastoreOptions.newBuilder().setProjectId("project-id").build();
    RpcUtils.retrySettingSetter(datastoreOptions).apply(builder);
    assertThat(builder.getRetrySettings()).isEqualTo(datastoreOptions.getRetrySettings());

    // datastoreOptions with custom retry settings
    RetrySettings customRetrySettings =
        RetrySettings.newBuilder()
            .setTotalTimeoutDuration(Duration.ofMinutes(2))
            .setInitialRpcTimeoutDuration(Duration.ofSeconds(5))
            .setMaxRpcTimeoutDuration(Duration.ofSeconds(10))
            .setRetryDelayMultiplier(1.5)
            .setMaxAttempts(5)
            .build();
    DatastoreOptions datastoreOptionsWithCustomRetrySettings =
        DatastoreOptions.newBuilder()
            .setProjectId("project-id")
            .setRetrySettings(customRetrySettings)
            .build();
    RpcUtils.retrySettingSetter(datastoreOptionsWithCustomRetrySettings).apply(builder);
    assertThat(builder.getRetrySettings()).isEqualTo(customRetrySettings);
  }
}
