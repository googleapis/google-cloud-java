/*
 * Copyright 2025 Google LLC
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
package com.google.cloud.bigtable.gaxx.grpc;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.grpc.ChannelPoolSettings;
import com.google.common.collect.ImmutableSet;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BigtableChannelPoolSettingsTest {

  @Test
  public void testToBigtableChannelPoolSettingsAllFieldsSetCopiesCorrectly() throws Exception {
    ChannelPoolSettings originalSettings =
        ChannelPoolSettings.builder()
            .setMinRpcsPerChannel(10)
            .setMaxRpcsPerChannel(50)
            .setMinChannelCount(5)
            .setMaxChannelCount(100)
            .setInitialChannelCount(20)
            .setPreemptiveRefreshEnabled(true)
            .build();

    BigtableChannelPoolSettings copiedSettings =
        BigtableChannelPoolSettings.copyFrom(originalSettings);
    assertSettingsCopiedCorrectly(originalSettings, copiedSettings);
  }

  @Test
  public void testToBigtableChannelPoolSettingsDefaultValuesCopiesCorrectly() throws Exception {
    ChannelPoolSettings originalSettings = ChannelPoolSettings.builder().build();
    BigtableChannelPoolSettings copiedSettings =
        BigtableChannelPoolSettings.copyFrom(originalSettings);
    assertSettingsCopiedCorrectly(originalSettings, copiedSettings);
  }

  private void assertSettingsCopiedCorrectly(
      ChannelPoolSettings originalSettings, BigtableChannelPoolSettings copiedSettings)
      throws Exception {

    Set<String> supportedGetters =
        ImmutableSet.of(
            "getMinRpcsPerChannel",
            "getMaxRpcsPerChannel",
            "getMinChannelCount",
            "getMaxChannelCount",
            "getInitialChannelCount",
            "isPreemptiveRefreshEnabled",
            "isStaticSize");

    Set<String> actualGetters =
        Arrays.stream(ChannelPoolSettings.class.getDeclaredMethods())
            .filter(
                method ->
                    Modifier.isPublic(method.getModifiers())
                        && Modifier.isAbstract(method.getModifiers())
                        && (method.getName().startsWith("get")
                            || method.getName().startsWith("is")))
            .map(Method::getName)
            .collect(Collectors.toSet());

    // If this fails then we need to add support for the additional attributes on the gax
    // ChannelPool by updating the BigtableChannelPoolSettings.copyFrom method
    assertThat(supportedGetters).containsAtLeastElementsIn(actualGetters);

    assertThat(originalSettings.getInitialChannelCount())
        .isEqualTo(copiedSettings.getInitialChannelCount());
    assertThat(originalSettings.getMaxChannelCount())
        .isEqualTo(copiedSettings.getMaxChannelCount());
    assertThat(originalSettings.getMinChannelCount())
        .isEqualTo(copiedSettings.getMinChannelCount());
    assertThat(originalSettings.getMaxRpcsPerChannel())
        .isEqualTo(copiedSettings.getMaxRpcsPerChannel());
    assertThat(originalSettings.getMinRpcsPerChannel())
        .isEqualTo(copiedSettings.getMinRpcsPerChannel());
    assertThat(originalSettings.getInitialChannelCount())
        .isEqualTo(copiedSettings.getInitialChannelCount());
    assertThat(originalSettings.isPreemptiveRefreshEnabled())
        .isEqualTo(copiedSettings.isPreemptiveRefreshEnabled());
  }
}
