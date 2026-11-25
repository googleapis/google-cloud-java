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

package com.google.cloud.storage;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.api.core.ApiClock;
import com.google.api.gax.rpc.EndpointContext;
import com.google.api.gax.rpc.UnauthenticatedException;
import com.google.auth.Credentials;
import com.google.auth.ServiceAccountSigner;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.NoCredentials;
import com.google.cloud.storage.PostPolicyV4.PostConditionsV4;
import com.google.cloud.storage.PostPolicyV4.PostFieldsV4;
import com.google.cloud.storage.Storage.PostPolicyV4Option;
import com.google.cloud.storage.Storage.SignUrlOption;
import com.google.cloud.storage.Storage.UriScheme;
import com.google.common.collect.ObjectArrays;
import java.net.URL;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.After;
import org.junit.Test;

public final class StorageSigningUniverseDomainTest {

  private static final String CUSTOM_UNIVERSE = "custom.example.com";
  private static final long FIXED_TIMESTAMP_MILLIS = 1700000000000L;
  private static final BlobInfo BLOB_INFO = BlobInfo.newBuilder("my-bucket", "my-obj.txt").build();
  private static final PrivateKey RSA_KEY = generateRsaPrivateKey();
  private static final ApiClock FIXED_CLOCK =
      new ApiClock() {
        @Override
        public long nanoTime() {
          return TimeUnit.MILLISECONDS.toNanos(FIXED_TIMESTAMP_MILLIS);
        }

        @Override
        public long millisTime() {
          return FIXED_TIMESTAMP_MILLIS;
        }
      };

  @After
  public void tearDown() {
    StorageOptions.resetEnvResolverForTesting();
  }

  @Test
  public void formatsSignedUrlsAndPostPolicyV4ForConfiguredUniverseDomain() {
    setEnvUniverse(CUSTOM_UNIVERSE);
    ServiceAccountCredentials customSigner = createServiceAccountCredentials(CUSTOM_UNIVERSE);
    Storage storage = createStorage(customSigner, null);

    assertThat(storage.signUrl(BLOB_INFO, 15, TimeUnit.MINUTES).getHost())
        .isEqualTo("storage.custom.example.com");
    assertThat(
            storage
                .signUrl(BLOB_INFO, 15, TimeUnit.MINUTES, SignUrlOption.withVirtualHostedStyle())
                .getHost())
        .isEqualTo("my-bucket.storage.custom.example.com");

    assertThat(signV4(storage).getHost()).isEqualTo("storage.custom.example.com");

    assertThat(signV4(storage, SignUrlOption.withVirtualHostedStyle()).getHost())
        .isEqualTo("my-bucket.storage.custom.example.com");
    assertThat(
            signV4(storage, SignUrlOption.withHostName("https://override.example.com")).getHost())
        .isEqualTo("override.example.com");
    assertThat(
            signV4(
                    storage,
                    SignUrlOption.withBucketBoundHostname(
                        "cdn.custom.example.com", UriScheme.HTTPS))
                .getHost())
        .isEqualTo("cdn.custom.example.com");

    assertThat(storage.generateSignedPostPolicyV4(BLOB_INFO, 900, TimeUnit.SECONDS).getUrl())
        .isEqualTo("https://storage.custom.example.com/my-bucket/");
    assertThat(
            storage
                .generateSignedPostPolicyV4(
                    BLOB_INFO, 900, TimeUnit.SECONDS, PostPolicyV4Option.withVirtualHostedStyle())
                .getUrl())
        .isEqualTo("https://my-bucket.storage.custom.example.com/");

    Storage unauthStorage = StorageOptions.getUnauthenticatedInstance().getService();
    assertThat(signV4(unauthStorage, SignUrlOption.signWith(customSigner)).getHost())
        .isEqualTo("storage.custom.example.com");
  }

  @Test
  public void validatesCredentialsUniverseDomainInSignUrl() {
    Storage defaultStorage = createStorage(createServiceAccountCredentials(CUSTOM_UNIVERSE), null);
    StorageException thrown = assertUnauthenticated(() -> signV4(defaultStorage));
    assertThat(thrown)
        .hasMessageThat()
        .contains(expectedMismatch(Credentials.GOOGLE_DEFAULT_UNIVERSE, CUSTOM_UNIVERSE));
    assertThat(
            signV4(defaultStorage, SignUrlOption.withHostName("https://override.example.com"))
                .getHost())
        .isEqualTo("override.example.com");

    setEnvUniverse(CUSTOM_UNIVERSE);
    Storage configuredStorage = createStorage(NoCredentials.getInstance(), null);
    SignUrlOption signWithDefault =
        SignUrlOption.signWith(
            createServiceAccountCredentials(Credentials.GOOGLE_DEFAULT_UNIVERSE));
    assertUnauthenticated(() -> signV4(configuredStorage, signWithDefault));

    ServiceAccountCredentials defaultCredentials =
        createServiceAccountCredentials(Credentials.GOOGLE_DEFAULT_UNIVERSE);
    ServiceAccountSigner signer =
        new ServiceAccountSigner() {
          @Override
          public String getAccount() {
            return defaultCredentials.getAccount();
          }

          @Override
          public byte[] sign(byte[] toSign) {
            return defaultCredentials.sign(toSign);
          }
        };
    Storage clientCredentialsStorage = createStorage(defaultCredentials, null);
    assertThat(signV4(clientCredentialsStorage, SignUrlOption.signWith(signer)).getHost())
        .isEqualTo("storage.custom.example.com");
  }

  @Test
  public void validatesCredentialsUniverseDomainInPostPolicyV4() {
    Storage customStorage = createStorage(NoCredentials.getInstance(), CUSTOM_UNIVERSE);
    PostFieldsV4 fields = PostFieldsV4.newBuilder().build();
    PostConditionsV4 conditions = PostConditionsV4.newBuilder().build();
    PostPolicyV4Option signWithDefault =
        PostPolicyV4Option.signWith(
            createServiceAccountCredentials(Credentials.GOOGLE_DEFAULT_UNIVERSE));

    StorageException thrown =
        assertUnauthenticated(
            () ->
                customStorage.generateSignedPostPolicyV4(
                    BLOB_INFO, 15, TimeUnit.MINUTES, fields, conditions, signWithDefault));
    assertThat(thrown)
        .hasMessageThat()
        .contains(expectedMismatch(CUSTOM_UNIVERSE, Credentials.GOOGLE_DEFAULT_UNIVERSE));
  }

  private static URL signV4(Storage storage, SignUrlOption... options) {
    return storage.signUrl(
        BLOB_INFO,
        900,
        TimeUnit.SECONDS,
        ObjectArrays.concat(SignUrlOption.withV4Signature(), options));
  }

  private static String expectedMismatch(String expectedUniverse, String actualUniverse) {
    return String.format(
        EndpointContext.INVALID_UNIVERSE_DOMAIN_ERROR_TEMPLATE, expectedUniverse, actualUniverse);
  }

  private static void setEnvUniverse(String universe) {
    StorageOptions.setEnvResolverForTesting(
        k -> EndpointContext.GOOGLE_CLOUD_UNIVERSE_DOMAIN.equals(k) ? universe : null);
  }

  private static Storage createStorage(Credentials creds, @Nullable String explicitUniverse) {
    HttpStorageOptions.Builder builder =
        StorageOptions.http().setProjectId("test-proj").setCredentials(creds).setClock(FIXED_CLOCK);
    if (explicitUniverse != null) {
      builder.setUniverseDomain(explicitUniverse);
    }
    return builder.build().getService();
  }

  private static StorageException assertUnauthenticated(Runnable runnable) {
    StorageException thrown = assertThrows(StorageException.class, runnable::run);
    assertThat(thrown.getCode()).isEqualTo(401);
    assertThat(thrown.isRetryable()).isFalse();
    assertThat(thrown).hasCauseThat().isInstanceOf(UnauthenticatedException.class);
    return thrown;
  }

  private static ServiceAccountCredentials createServiceAccountCredentials(String universeDomain) {
    return ServiceAccountCredentials.newBuilder()
        .setClientId("test-client-id")
        .setClientEmail("signer@test-proj.iam.gserviceaccount.com")
        .setPrivateKey(RSA_KEY)
        .setPrivateKeyId("test-key-id")
        .setProjectId("test-proj")
        .setUniverseDomain(universeDomain)
        .build();
  }

  private static PrivateKey generateRsaPrivateKey() {
    try {
      KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
      generator.initialize(2048);
      return generator.generateKeyPair().getPrivate();
    } catch (Exception e) {
      throw new IllegalStateException(e);
    }
  }
}
