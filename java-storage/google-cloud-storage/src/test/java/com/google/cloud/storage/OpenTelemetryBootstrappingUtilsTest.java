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

package com.google.cloud.storage;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assume.assumeFalse;
import static org.mockito.Mockito.mock;

import com.google.cloud.storage.OpenTelemetryBootstrappingUtils.ChannelConfigurator;
import io.grpc.ManagedChannelBuilder;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.Test;

public final class OpenTelemetryBootstrappingUtilsTest {

  @Test
  public void noErrorIfNotRunningOnGcp() {
    assumeFalse("Skipping because running on GCP", TestUtils.isOnComputeEngine());

    ChannelConfigurator cc = ChannelConfigurator.identity();

    String endpoint = "storage.googleapis.com:443";
    String projectId = null;
    String universeDomain = null;
    ChannelConfigurator actual =
        OpenTelemetryBootstrappingUtils.enableGrpcMetrics(
            cc, endpoint, projectId, universeDomain, true);

    assertThat(actual).isSameInstanceAs(cc);
  }

  @SuppressWarnings("rawtypes") // ManagedChannelBuilder
  @Test
  public void channelConfigurator_andThen() {
    ManagedChannelBuilder b1 = mock(ManagedChannelBuilder.class, "b1");
    ManagedChannelBuilder b2 = mock(ManagedChannelBuilder.class, "b2");
    ManagedChannelBuilder b3 = mock(ManagedChannelBuilder.class, "b2");

    ChannelConfigurator cc1 =
        b -> {
          assertThat(b).isSameInstanceAs(b1);
          return b2;
        };
    ChannelConfigurator cc2 =
        b -> {
          assertThat(b).isSameInstanceAs(b2);
          return b3;
        };

    ChannelConfigurator cc3 = cc1.andThen(cc2);

    ManagedChannelBuilder apply = cc3.apply(b1);
    assertThat(apply).isSameInstanceAs(b3);
  }

  @Test
  public void channelConfigurator_lift_nullToIdentity() {
    ChannelConfigurator actual = ChannelConfigurator.lift(null);
    assertThat(actual).isSameInstanceAs(ChannelConfigurator.identity());
  }

  @SuppressWarnings("rawtypes") // ManagedChannelBuilder
  @Test
  public void channelConfigurator_lift_plumbingWorks() {
    ManagedChannelBuilder b1 = mock(ManagedChannelBuilder.class, "b1");
    AtomicBoolean called = new AtomicBoolean(false);
    ChannelConfigurator lifted =
        ChannelConfigurator.lift(
            b -> {
              called.compareAndSet(false, true);
              return b;
            });
    ManagedChannelBuilder actual = lifted.apply(b1);
    assertThat(actual).isSameInstanceAs(b1);
    assertThat(called.get()).isTrue();
  }

  @Test
  public void channelConfigurator_andThen_nullsafe() {
    ChannelConfigurator actual = ChannelConfigurator.identity().andThen(null);
    assertThat(actual).isSameInstanceAs(ChannelConfigurator.identity());
  }
}
