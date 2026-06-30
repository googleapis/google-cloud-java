/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.spanner.connection;

import static com.google.cloud.spanner.connection.ConnectionOptionsTest.runWithSystemPropertyEnabled;
import static org.junit.Assert.assertEquals;

import com.google.api.gax.core.CredentialsProvider;
import com.google.auth.Credentials;
import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.OAuth2Credentials;
import io.grpc.ManagedChannelBuilder;
import java.io.ObjectStreamException;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CredentialsProviderTest extends AbstractMockServerTest {
  private static final AtomicInteger COUNTER = new AtomicInteger();

  @BeforeClass
  public static void resetCounter() {
    COUNTER.set(0);
  }

  private static final class TestCredentials extends OAuth2Credentials {
    private final int id;

    private TestCredentials(int id) {
      this.id = id;
    }

    private Object readResolve() throws ObjectStreamException {
      return this;
    }

    @Override
    public AccessToken refreshAccessToken() {
      return AccessToken.newBuilder()
          .setTokenValue("foo")
          .setExpirationTime(new Date(Long.MAX_VALUE))
          .build();
    }

    public boolean equals(Object obj) {
      if (!(obj instanceof TestCredentials)) {
        return false;
      }
      return this.id == ((TestCredentials) obj).id;
    }

    public int hashCode() {
      return System.identityHashCode(this.id);
    }
  }

  static final class TestCredentialsProvider implements CredentialsProvider {
    @Override
    public Credentials getCredentials() {
      return new TestCredentials(COUNTER.incrementAndGet());
    }
  }

  @Test
  public void testCredentialsProvider() throws Throwable {
    runWithSystemPropertyEnabled(
        ConnectionOptions.ENABLE_CREDENTIALS_PROVIDER_SYSTEM_PROPERTY,
        () -> {
          ConnectionOptions options =
              ConnectionOptions.newBuilder()
                  .setUri(
                      String.format(
                          "cloudspanner://localhost:%d/projects/proj/instances/inst/databases/db?credentialsProvider=%s",
                          getPort(), TestCredentialsProvider.class.getName()))
                  .setConfigurator(
                      spannerOptions -> {
                        spannerOptions.setChannelConfigurator(ManagedChannelBuilder::usePlaintext);
                        spannerOptions.setEnableDirectAccess(false);
                      })
                  .build();

          try (Connection connection = options.getConnection()) {
            assertEquals(
                TestCredentials.class,
                ((ConnectionImpl) connection)
                    .getSpanner()
                    .getOptions()
                    .getCredentials()
                    .getClass());
            TestCredentials credentials =
                (TestCredentials)
                    ((ConnectionImpl) connection).getSpanner().getOptions().getCredentials();
            assertEquals(1, credentials.id);
          }
          // The second connection should get the same credentials from the provider.
          try (Connection connection = options.getConnection()) {
            assertEquals(
                TestCredentials.class,
                ((ConnectionImpl) connection)
                    .getSpanner()
                    .getOptions()
                    .getCredentials()
                    .getClass());
            TestCredentials credentials =
                (TestCredentials)
                    ((ConnectionImpl) connection).getSpanner().getOptions().getCredentials();
            assertEquals(1, credentials.id);
          }

          // Creating new ConnectionOptions should refresh the credentials.
          options =
              ConnectionOptions.newBuilder()
                  .setUri(
                      String.format(
                          "cloudspanner://localhost:%d/projects/proj/instances/inst/databases/db?credentialsProvider=%s",
                          getPort(), TestCredentialsProvider.class.getName()))
                  .setConfigurator(
                      spannerOptions -> {
                        spannerOptions.setChannelConfigurator(ManagedChannelBuilder::usePlaintext);
                        spannerOptions.setEnableDirectAccess(false);
                      })
                  .build();
          try (Connection connection = options.getConnection()) {
            assertEquals(
                TestCredentials.class,
                ((ConnectionImpl) connection)
                    .getSpanner()
                    .getOptions()
                    .getCredentials()
                    .getClass());
            TestCredentials credentials =
                (TestCredentials)
                    ((ConnectionImpl) connection).getSpanner().getOptions().getCredentials();
            assertEquals(2, credentials.id);
          }
        });
  }
}
