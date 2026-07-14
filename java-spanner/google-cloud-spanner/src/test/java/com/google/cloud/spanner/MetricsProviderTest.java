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

package com.google.cloud.spanner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.cloud.NoCredentials;
import io.opentelemetry.api.OpenTelemetry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Tests for the {@link MetricsProvider} semantics matrix on {@link SpannerOptions}. The Cloud
 * Monitoring (GCM) sink and a caller-provided client-metrics sink are independent booleans that can
 * both be active at once:
 *
 * <pre>
 * instanceType | provider | built-in disabled?      | GCM sink | client-metrics sink
 * CLOUD        | Default  | no                       | on       | -
 * CLOUD        | Default  | setBuiltInMetricsEnabled | off      | -
 * CLOUD        | Noop     | -                        | on       | off
 * CLOUD        | Custom   | no                       | on       | on
 * CLOUD        | Custom   | setBuiltInMetricsEnabled | off      | on
 * CLOUD        | Custom   | env kill-switch          | off      | on
 * OMNI         | Default  | -                        | off (Noop) | -
 * OMNI         | Noop     | -                        | off      | -
 * OMNI         | Custom   | no                       | off      | on
 * OMNI         | Custom   | setBuiltInMetricsEnabled | off      | on
 * OMNI         | Custom   | env kill-switch          | off      | on
 * </pre>
 */
@RunWith(JUnit4.class)
public class MetricsProviderTest {

  @Before
  public void setUp() {
    SpannerOptions.useEnvironment(new SpannerOptions.SpannerEnvironment() {});
  }

  @After
  public void reset() {
    SpannerOptions.useDefaultEnvironment();
    BuiltInMetricsProvider.INSTANCE.reset();
  }

  private static SpannerOptions.Builder cloudBuilder() {
    return SpannerOptions.newBuilder()
        .setProjectId("test-project")
        .setCredentials(NoCredentials.getInstance());
  }

  private static SpannerOptions.Builder omniBuilder() {
    return SpannerOptions.newBuilder()
        .setType(SpannerOptions.InstanceType.OMNI)
        .setHost("http://localhost:8080")
        .setCredentials(NoCredentials.getInstance());
  }

  @Test
  public void cloudDefaultProviderKeepsCloudMonitoringSink() {
    SpannerOptions options = cloudBuilder().build();
    assertSame(DefaultMetricsProvider.INSTANCE, options.getClientMetricsProvider());
    assertTrue(options.isEnableBuiltInMetrics());
  }

  @Test
  public void cloudNoopProviderDisablesOnlyClientMetrics() {
    SpannerOptions options =
        cloudBuilder().setClientMetricsProvider(NoopMetricsProvider.INSTANCE).build();
    assertSame(NoopMetricsProvider.INSTANCE, options.getClientMetricsProvider());
    assertTrue(options.isEnableBuiltInMetrics());
  }

  @Test
  public void cloudCustomProviderKeepsBothSinks() {
    // Additive semantics: adding a client-metrics sink does not silence the Cloud Monitoring sink.
    CustomOpenTelemetryMetricsProvider provider =
        CustomOpenTelemetryMetricsProvider.create(OpenTelemetry.noop());
    SpannerOptions options = cloudBuilder().setClientMetricsProvider(provider).build();
    assertSame(provider, options.getClientMetricsProvider());
    assertTrue(options.isEnableBuiltInMetrics());
  }

  @Test
  public void cloudCustomProviderWithBuiltInMetricsDisabledIsCustomOnly() {
    CustomOpenTelemetryMetricsProvider provider =
        CustomOpenTelemetryMetricsProvider.create(OpenTelemetry.noop());
    SpannerOptions options =
        cloudBuilder().setClientMetricsProvider(provider).setBuiltInMetricsEnabled(false).build();
    // The client-metrics sink survives; only the Cloud Monitoring sink is turned off.
    assertSame(provider, options.getClientMetricsProvider());
    assertFalse(options.isEnableBuiltInMetrics());
  }

  @Test
  public void explicitProviderCombinesWithBuiltInMetricsEnabledFlag() {
    CustomOpenTelemetryMetricsProvider provider =
        CustomOpenTelemetryMetricsProvider.create(OpenTelemetry.noop());
    SpannerOptions options =
        cloudBuilder().setBuiltInMetricsEnabled(true).setClientMetricsProvider(provider).build();
    // Custom provider plus the built-in flag on: both sinks active.
    assertSame(provider, options.getClientMetricsProvider());
    assertTrue(options.isEnableBuiltInMetrics());

    options =
        cloudBuilder()
            .setBuiltInMetricsEnabled(true)
            .setClientMetricsProvider(NoopMetricsProvider.INSTANCE)
            .build();
    // A Noop provider means no caller-owned client metrics; Cloud Monitoring is separate.
    assertSame(NoopMetricsProvider.INSTANCE, options.getClientMetricsProvider());
    assertTrue(options.isEnableBuiltInMetrics());
  }

  @Test
  public void builtInMetricsEnabledFlagStillControlsDefaultProvider() {
    SpannerOptions options = cloudBuilder().setBuiltInMetricsEnabled(false).build();
    assertSame(DefaultMetricsProvider.INSTANCE, options.getClientMetricsProvider());
    assertFalse(options.isEnableBuiltInMetrics());
  }

  @Test
  public void omniDefaultProviderIsCoercedToNoop() {
    SpannerOptions options = omniBuilder().build();
    assertSame(NoopMetricsProvider.INSTANCE, options.getClientMetricsProvider());
    assertFalse(options.isEnableBuiltInMetrics());
  }

  @Test
  public void omniDefaultProviderIsCoercedToNoopEvenWithBuiltInMetricsEnabled() {
    SpannerOptions options = omniBuilder().setBuiltInMetricsEnabled(true).build();
    assertSame(NoopMetricsProvider.INSTANCE, options.getClientMetricsProvider());
    assertFalse(options.isEnableBuiltInMetrics());
  }

  @Test
  public void omniCustomProviderIsHonored() {
    CustomOpenTelemetryMetricsProvider provider =
        CustomOpenTelemetryMetricsProvider.create(OpenTelemetry.noop());
    SpannerOptions options = omniBuilder().setClientMetricsProvider(provider).build();
    assertSame(provider, options.getClientMetricsProvider());
    // The Cloud Monitoring sink stays off on OMNI.
    assertFalse(options.isEnableBuiltInMetrics());

    options =
        omniBuilder().setClientMetricsProvider(provider).setBuiltInMetricsEnabled(true).build();
    assertSame(provider, options.getClientMetricsProvider());
    assertFalse(options.isEnableBuiltInMetrics());
  }

  @Test
  public void omniCustomProviderWithBuiltInMetricsDisabledStaysActive() {
    CustomOpenTelemetryMetricsProvider provider =
        CustomOpenTelemetryMetricsProvider.create(OpenTelemetry.noop());
    SpannerOptions options =
        omniBuilder().setClientMetricsProvider(provider).setBuiltInMetricsEnabled(false).build();
    assertSame(provider, options.getClientMetricsProvider());
    assertFalse(options.isEnableBuiltInMetrics());
  }

  @Test
  public void environmentKillSwitchTurnsOffGcmButKeepsCustomSink() {
    SpannerOptions.useEnvironment(
        new SpannerOptions.SpannerEnvironment() {
          @Override
          public boolean isEnableBuiltInMetrics() {
            // Simulates SPANNER_DISABLE_BUILTIN_METRICS=true.
            return false;
          }
        });
    CustomOpenTelemetryMetricsProvider provider =
        CustomOpenTelemetryMetricsProvider.create(OpenTelemetry.noop());

    // Non-OMNI: the kill-switch only turns off the Cloud Monitoring sink; the client-metrics sink
    // stays.
    SpannerOptions cloudOptions = cloudBuilder().setClientMetricsProvider(provider).build();
    assertSame(provider, cloudOptions.getClientMetricsProvider());
    assertFalse(cloudOptions.isEnableBuiltInMetrics());

    // OMNI: the kill-switch only affects Cloud Monitoring, which is impossible there anyway.
    SpannerOptions omniOptions = omniBuilder().setClientMetricsProvider(provider).build();
    assertSame(provider, omniOptions.getClientMetricsProvider());
    assertFalse(omniOptions.isEnableBuiltInMetrics());
  }

  @Test
  public void omniCustomProviderEnvironmentKillSwitchStaysActive() {
    SpannerOptions.useEnvironment(
        new SpannerOptions.SpannerEnvironment() {
          @Override
          public boolean isEnableBuiltInMetrics() {
            return false;
          }
        });
    CustomOpenTelemetryMetricsProvider provider =
        CustomOpenTelemetryMetricsProvider.create(OpenTelemetry.noop());

    SpannerOptions options =
        omniBuilder().setClientMetricsProvider(provider).setBuiltInMetricsEnabled(true).build();
    assertSame(provider, options.getClientMetricsProvider());
    assertFalse(options.isEnableBuiltInMetrics());
  }

  @Test
  public void nullMetricsProviderIsRejected() {
    assertThrows(NullPointerException.class, () -> cloudBuilder().setClientMetricsProvider(null));
  }

  @Test
  public void toBuilderKeepsMetricsProvider() {
    CustomOpenTelemetryMetricsProvider provider =
        CustomOpenTelemetryMetricsProvider.create(OpenTelemetry.noop());
    SpannerOptions options = cloudBuilder().setClientMetricsProvider(provider).build();
    SpannerOptions copy = options.toBuilder().build();
    assertSame(provider, copy.getClientMetricsProvider());
    // Additive: a non-OMNI custom provider keeps the Cloud Monitoring sink on across toBuilder().
    assertTrue(copy.isEnableBuiltInMetrics());
  }

  @Test
  public void toBuilderPreservesRawProviderAcrossInstanceTypeChange() {
    SpannerOptions omniOptions = omniBuilder().build();
    assertSame(NoopMetricsProvider.INSTANCE, omniOptions.getClientMetricsProvider());

    SpannerOptions cloudCopy =
        omniOptions.toBuilder()
            .setType(SpannerOptions.InstanceType.CLOUD)
            .setProjectId("test-project")
            .build();
    assertSame(DefaultMetricsProvider.INSTANCE, cloudCopy.getClientMetricsProvider());
  }

  @Test
  public void toBuilderReResolvesBuiltInMetricsFlagAgainstNewProvider() {
    CustomOpenTelemetryMetricsProvider provider =
        CustomOpenTelemetryMetricsProvider.create(OpenTelemetry.noop());
    SpannerOptions options =
        cloudBuilder().setClientMetricsProvider(provider).setBuiltInMetricsEnabled(false).build();
    assertFalse(options.isEnableBuiltInMetrics());

    // Switching back to the default provider re-enables the Cloud Monitoring sink, and the raw
    // built-in flag is re-evaluated rather than pinned to the previously resolved value.
    SpannerOptions copy =
        options.toBuilder()
            .setClientMetricsProvider(DefaultMetricsProvider.INSTANCE)
            .setBuiltInMetricsEnabled(true)
            .build();
    assertSame(DefaultMetricsProvider.INSTANCE, copy.getClientMetricsProvider());
    assertTrue(copy.isEnableBuiltInMetrics());
  }

  @Test
  public void toBuilderPreservesRawProviderAcrossKillSwitchOnOmni() {
    SpannerOptions.useEnvironment(
        new SpannerOptions.SpannerEnvironment() {
          @Override
          public boolean isEnableBuiltInMetrics() {
            return false;
          }
        });
    CustomOpenTelemetryMetricsProvider provider =
        CustomOpenTelemetryMetricsProvider.create(OpenTelemetry.noop());
    // On OMNI the kill-switch does not affect the custom provider.
    SpannerOptions options = omniBuilder().setClientMetricsProvider(provider).build();
    assertSame(provider, options.getClientMetricsProvider());

    SpannerOptions.useDefaultEnvironment();
    SpannerOptions copy = options.toBuilder().build();
    assertSame(provider, copy.getClientMetricsProvider());
  }

  @Test
  public void customProviderDoesNotTouchProcessWideCloudMonitoringSingleton() {
    BuiltInMetricsProvider.INSTANCE.reset();
    CustomOpenTelemetryMetricsProvider provider =
        CustomOpenTelemetryMetricsProvider.create(OpenTelemetry.noop());

    SpannerOptions cloudOptions = cloudBuilder().setClientMetricsProvider(provider).build();
    cloudOptions.getApiTracerFactory(/* isAdminClient= */ false, /* isEmulatorEnabled= */ false);
    assertNull(BuiltInMetricsProvider.INSTANCE.getOpenTelemetry());

    SpannerOptions omniOptions = omniBuilder().setClientMetricsProvider(provider).build();
    omniOptions.getApiTracerFactory(/* isAdminClient= */ false, /* isEmulatorEnabled= */ false);
    assertNull(BuiltInMetricsProvider.INSTANCE.getOpenTelemetry());
  }
}
