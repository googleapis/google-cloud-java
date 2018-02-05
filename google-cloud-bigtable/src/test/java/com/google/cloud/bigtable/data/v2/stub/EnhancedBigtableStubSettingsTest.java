/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.bigtable.admin.v2.InstanceName;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

@RunWith(JUnit4.class)
public class EnhancedBigtableStubSettingsTest {
  @Test
  public void instanceNameIsRequiredTest() {
    EnhancedBigtableStubSettings.Builder builder = EnhancedBigtableStubSettings.newBuilder();

    Throwable error = null;
    try {
      builder.build();
    } catch (Throwable t) {
      error = t;
    }

    assertThat(error).isInstanceOf(IllegalStateException.class);
  }

  @Test
  public void settingsAreNotLostTest() throws Exception {
    InstanceName instanceName = InstanceName.of("my-project", "my-instance");
    String appProfileId = "my-app-profile-id";
    String endpoint = "some.other.host:123";
    CredentialsProvider credentialsProvider = Mockito.mock(CredentialsProvider.class);

    BigtableDataSettings.Builder builder =
        BigtableDataSettings.newBuilder()
            .setInstanceName(instanceName)
            .setAppProfileId(appProfileId)
            .setEndpoint(endpoint)
            .setCredentialsProvider(credentialsProvider);

    verifyBuilder(builder, instanceName, appProfileId, endpoint, credentialsProvider);
    verifySettings(builder.build(), instanceName, appProfileId, endpoint, credentialsProvider);
    verifyBuilder(
        builder.build().toBuilder(), instanceName, appProfileId, endpoint, credentialsProvider);
  }

  private void verifyBuilder(
      BigtableDataSettings.Builder builder,
      InstanceName instanceName,
      String appProfileId,
      String endpoint,
      CredentialsProvider credentialsProvider) {
    assertThat(builder.getInstanceName()).isEqualTo(instanceName);
    assertThat(builder.getAppProfileId()).isEqualTo(appProfileId);
    assertThat(builder.getEndpoint()).isEqualTo(endpoint);
    assertThat(builder.getCredentialsProvider()).isEqualTo(credentialsProvider);
  }

  private void verifySettings(
      BigtableDataSettings settings,
      InstanceName instanceName,
      String appProfileId,
      String endpoint,
      CredentialsProvider credentialsProvider) {
    assertThat(settings.getInstanceName()).isEqualTo(instanceName);
    assertThat(settings.getAppProfileId()).isEqualTo(appProfileId);
    assertThat(settings.getEndpoint()).isEqualTo(endpoint);
    assertThat(settings.getCredentialsProvider()).isEqualTo(credentialsProvider);
  }

  @Test
  public void multipleChannelsByDefaultTest() {
    InstanceName dummyInstanceName = InstanceName.of("my-project", "my-instance");

    BigtableDataSettings.Builder builder =
        BigtableDataSettings.newBuilder().setInstanceName(dummyInstanceName);

    InstantiatingGrpcChannelProvider provider =
        (InstantiatingGrpcChannelProvider) builder.getTransportChannelProvider();

    assertThat(provider.toBuilder().getPoolSize()).isGreaterThan(1);
  }
}
