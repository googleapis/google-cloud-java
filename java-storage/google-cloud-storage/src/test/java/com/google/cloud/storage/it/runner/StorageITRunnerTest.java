/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.storage.it.runner;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.CrossRun;
import com.google.cloud.storage.it.runner.annotations.Inject;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public final class StorageITRunnerTest {

  @RunWith(StorageITRunner.class)
  @CrossRun(
      backends = {Backend.PROD},
      transports = {Transport.HTTP, Transport.GRPC})
  public abstract static class Parent {
    @Inject public Transport transport;
  }

  public static final class Child extends Parent {
    @Test
    public void transport() {
      assertThat(transport).isNotNull();
    }
  }
}
