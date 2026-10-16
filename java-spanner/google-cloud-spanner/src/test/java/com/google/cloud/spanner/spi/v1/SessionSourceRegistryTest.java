/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.spanner.spi.v1;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.cloud.spanner.spi.v1.SpannerRpc.ChannelPrimeSessionSource;
import javax.annotation.Nullable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SessionSourceRegistryTest {
  private static final String SESSION_NAME =
      "projects/my-project/instances/my-instance/databases/my-database/sessions/session";
  private static final String OTHER_SESSION_NAME =
      "projects/my-project/instances/my-instance/databases/other-database/sessions/other-session";
  private static final String REFRESHED_SESSION_NAME =
      "projects/my-project/instances/my-instance/databases/my-database/sessions/refreshed-session";

  private static class MutableSessionSource implements ChannelPrimeSessionSource {
    @Nullable volatile String sessionName;

    private MutableSessionSource(@Nullable String sessionName) {
      this.sessionName = sessionName;
    }

    @Override
    @Nullable
    public String getChannelPrimeSessionName() {
      return sessionName;
    }
  }

  private static final class EqualSessionSource extends MutableSessionSource {
    private EqualSessionSource(String sessionName) {
      super(sessionName);
    }

    @Override
    public boolean equals(Object other) {
      return other instanceof EqualSessionSource;
    }

    @Override
    public int hashCode() {
      return 1;
    }
  }

  @Test
  public void nextSessionNameRotatesAcrossAvailableSources() {
    SessionSourceRegistry registry = new SessionSourceRegistry();
    assertThat(registry.nextSessionName()).isNull();

    MutableSessionSource first = new MutableSessionSource(SESSION_NAME);
    MutableSessionSource second = new MutableSessionSource(OTHER_SESSION_NAME);
    registry.register(first);
    registry.register(second);

    assertThat(registry.nextSessionName()).isEqualTo(SESSION_NAME);
    assertThat(registry.nextSessionName()).isEqualTo(OTHER_SESSION_NAME);
    assertThat(registry.nextSessionName()).isEqualTo(SESSION_NAME);

    first.sessionName = REFRESHED_SESSION_NAME;
    assertThat(registry.nextSessionName()).isEqualTo(OTHER_SESSION_NAME);
    assertThat(registry.nextSessionName()).isEqualTo(REFRESHED_SESSION_NAME);

    first.sessionName = null;
    assertThat(registry.nextSessionName()).isEqualTo(OTHER_SESSION_NAME);
    assertThat(registry.nextSessionName()).isEqualTo(OTHER_SESSION_NAME);
    assertThat(registry.getSources()).containsExactly(first, second).inOrder();
  }

  @Test
  public void registrationIsByIdentityAndUnregisterIsIdempotent() {
    SessionSourceRegistry registry = new SessionSourceRegistry();
    EqualSessionSource first = new EqualSessionSource(SESSION_NAME);
    EqualSessionSource second = new EqualSessionSource(OTHER_SESSION_NAME);
    assertThat(first).isEqualTo(second);

    registry.register(first);
    registry.register(first);
    registry.register(second);
    assertThat(registry.getSources()).containsExactly(first, second).inOrder();

    registry.unregister(first);
    registry.unregister(first);
    assertThat(registry.getSources()).containsExactly(second);
    assertThat(registry.nextSessionName()).isEqualTo(OTHER_SESSION_NAME);

    registry.unregister(second);
    assertThat(registry.getSources()).isEmpty();
    assertThat(registry.nextSessionName()).isNull();
  }

  @Test
  public void nullSourcesAreRejected() {
    SessionSourceRegistry registry = new SessionSourceRegistry();

    assertThrows(NullPointerException.class, () -> registry.register(null));
    assertThrows(NullPointerException.class, () -> registry.unregister(null));
    assertThat(registry.getSources()).isEmpty();
  }
}
