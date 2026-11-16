/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.data.v2.internal.compat;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.withSettings;

import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.auth.Credentials;
import com.google.bigtable.v2.FeatureFlags;
import com.google.cloud.bigtable.data.v2.internal.api.ChannelProviders.ChannelProvider;
import java.lang.reflect.Field;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GaxDirectAccessChannelProviderTest {

  private String originalOsName;
  private String originalProductName;

  @BeforeEach
  void setUp() throws Exception {
    originalOsName = System.getProperty("os.name");
    originalProductName =
        (String) getStaticField(InstantiatingGrpcChannelProvider.class, "systemProductName");
  }

  @AfterEach
  void tearDown() throws Exception {
    if (originalOsName != null) {
      System.setProperty("os.name", originalOsName);
    }
    setStaticField(
        InstantiatingGrpcChannelProvider.class, "systemProductName", originalProductName);
  }

  @Test
  void create_withNonDefaultServiceAccountOnGce_enablesDirectAccess() throws Exception {
    System.setProperty("os.name", "Linux");
    setStaticField(
        InstantiatingGrpcChannelProvider.class, "systemProductName", "Google Compute Engine");

    Credentials nonDefaultSaCredentials =
        mock(Credentials.class, withSettings().withoutAnnotations());
    InstantiatingGrpcChannelProvider outer =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setEndpoint("bigtable.googleapis.com:443")
            .setCredentials(nonDefaultSaCredentials)
            .build();

    ChannelProvider directChannelProvider =
        GaxDirectAccessChannelProvider.create(outer, nonDefaultSaCredentials);
    assertThat(directChannelProvider).isInstanceOf(GaxDirectAccessChannelProvider.class);
    FeatureFlags flags =
        directChannelProvider.updateFeatureFlags(FeatureFlags.getDefaultInstance());
    assertThat(flags.getDirectAccessRequested()).isTrue();
    assertThat(flags.getTrafficDirectorEnabled()).isTrue();
    assertThat(directChannelProvider.getFallback()).isEmpty();

    ChannelProvider fallbackChannelProvider =
        GaxDirectAccessChannelProvider.createWithFallback(outer, nonDefaultSaCredentials);
    assertThat(fallbackChannelProvider).isInstanceOf(GaxDirectAccessChannelProvider.class);
    assertThat(fallbackChannelProvider.getFallback()).isPresent();
    assertThat(fallbackChannelProvider.getFallback().get())
        .isInstanceOf(GaxBasicChannelProvider.class);
  }

  private static Object getStaticField(Class<?> clazz, String fieldName) throws Exception {
    Field field = clazz.getDeclaredField(fieldName);
    field.setAccessible(true);
    return field.get(null);
  }

  private static void setStaticField(Class<?> clazz, String fieldName, Object value)
      throws Exception {
    Field field = clazz.getDeclaredField(fieldName);
    field.setAccessible(true);
    field.set(null, value);
  }
}
