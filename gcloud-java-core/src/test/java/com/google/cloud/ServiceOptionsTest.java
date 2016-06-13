/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.cloud;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.cloud.spi.ServiceRpcFactory;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

public class ServiceOptionsTest {
  private static final String JSON_KEY =
      "{\n"
      + "  \"private_key_id\": \"somekeyid\",\n"
      + "  \"private_key\": \"-----BEGIN PRIVATE KEY-----\\nMIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggS"
      + "kAgEAAoIBAQC+K2hSuFpAdrJI\\nnCgcDz2M7t7bjdlsadsasad+fvRSW6TjNQZ3p5LLQY1kSZRqBqylRkzteMOyHg"
      + "aR\\n0Pmxh3ILCND5men43j3h4eDbrhQBuxfEMalkG92sL+PNQSETY2tnvXryOvmBRwa/\\nQP/9dJfIkIDJ9Fw9N4"
      + "Bhhhp6mCcRpdQjV38H7JsyJ7lih/oNjECgYAt\\nknddadwkwewcVxHFhcZJO+XWf6ofLUXpRwiTZakGMn8EE1uVa2"
      + "LgczOjwWHGi99MFjxSer5m9\\n1tCa3/KEGKiS/YL71JvjwX3mb+cewlkcmweBKZHM2JPTk0ZednFSpVZMtycjkbLa"
      + "\\ndYOS8V85AgMBewECggEBAKksaldajfDZDV6nGqbFjMiizAKJolr/M3OQw16K6o3/\\n0S31xIe3sSlgW0+UbYlF"
      + "4U8KifhManD1apVSC3csafaspP4RZUHFhtBywLO9pR5c\\nr6S5aLp+gPWFyIp1pfXbWGvc5VY/v9x7ya1VEa6rXvL"
      + "sKupSeWAW4tMj3eo/64ge\\nsdaceaLYw52KeBYiT6+vpsnYrEkAHO1fF/LavbLLOFJmFTMxmsNaG0tuiJHgjshB\\"
      + "n82DpMCbXG9YcCgI/DbzuIjsdj2JC1cascSP//3PmefWysucBQe7Jryb6NQtASmnv\\nCdDw/0jmZTEjpe4S1lxfHp"
      + "lAhHFtdgYTvyYtaLZiVVkCgYEA8eVpof2rceecw/I6\\n5ng1q3Hl2usdWV/4mZMvR0fOemacLLfocX6IYxT1zA1FF"
      + "JlbXSRsJMf/Qq39mOR2\\nSpW+hr4jCoHeRVYLgsbggtrevGmILAlNoqCMpGZ6vDmJpq6ECV9olliDvpPgWOP+\\nm"
      + "YPDreFBGxWvQrADNbRt2dmGsrsCgYEAyUHqB2wvJHFqdmeBsaacewzV8x9WgmeX\\ngUIi9REwXlGDW0Mz50dxpxcK"
      + "CAYn65+7TCnY5O/jmL0VRxU1J2mSWyWTo1C+17L0\\n3fUqjxL1pkefwecxwecvC+gFFYdJ4CQ/MHHXU81Lwl1iWdF"
      + "Cd2UoGddYaOF+KNeM\\nHC7cmqra+JsCgYEAlUNywzq8nUg7282E+uICfCB0LfwejuymR93CtsFgb7cRd6ak\\nECR"
      + "8FGfCpH8ruWJINllbQfcHVCX47ndLZwqv3oVFKh6pAS/vVI4dpOepP8++7y1u\\ncoOvtreXCX6XqfrWDtKIvv0vjl"
      + "HBhhhp6mCcRpdQjV38H7JsyJ7lih/oNjECgYAt\\nkndj5uNl5SiuVxHFhcZJO+XWf6ofLUregtevZakGMn8EE1uVa"
      + "2AY7eafmoU/nZPT\\n00YB0TBATdCbn/nBSuKDESkhSg9s2GEKQZG5hBmL5uCMfo09z3SfxZIhJdlerreP\\nJ7gSi"
      + "dI12N+EZxYd4xIJh/HFDgp7RRO87f+WJkofMQKBgGTnClK1VMaCRbJZPriw\\nEfeFCoOX75MxKwXs6xgrw4W//AYG"
      + "GUjDt83lD6AZP6tws7gJ2IwY/qP7+lyhjEqN\\nHtfPZRGFkGZsdaksdlaksd323423d+15/UvrlRSFPNj1tWQmNKk"
      + "XyRDW4IG1Oa2p\\nrALStNBx5Y9t0/LQnFI4w3aG\\n-----END PRIVATE KEY-----\\n\",\n"
      + "  \"client_email\": \"someclientid@developer.gserviceaccount.com\",\n"
      + "  \"client_id\": \"someclientid.apps.googleusercontent.com\",\n"
      + "  \"type\": \"service_account\"\n"
      + "}";
  private static final InputStream JSON_KEY_STREAM = new ByteArrayInputStream(JSON_KEY.getBytes());
  private static AuthCredentials authCredentials;
  static {
    try {
      authCredentials = AuthCredentials.createForJson(JSON_KEY_STREAM);
    } catch (IOException e) {
      fail("Couldn't create fake JSON credentials.");
    }
  }
  private static final Clock TEST_CLOCK = new TestClock();
  private static final TestServiceOptions OPTIONS =
      TestServiceOptions.builder()
          .authCredentials(authCredentials)
          .clock(TEST_CLOCK)
          .host("host")
          .projectId("project-id")
          .retryParams(RetryParams.noRetries())
          .build();
  private static final TestServiceOptions DEFAULT_OPTIONS =
      TestServiceOptions.builder().projectId("project-id").build();
  private static final TestServiceOptions OPTIONS_COPY = OPTIONS.toBuilder().build();

  private static class TestClock extends Clock {
    @Override
    public long millis() {
      return 123456789L;
    }
  }

  private interface TestService extends Service<TestServiceOptions> {}

  private static class TestServiceImpl
      extends BaseService<TestServiceOptions> implements TestService {
    private TestServiceImpl(TestServiceOptions options) {
      super(options);
    }
  }

  private interface TestServiceFactory extends ServiceFactory<TestService, TestServiceOptions> {}

  private static class DefaultTestServiceFactory implements TestServiceFactory {
    private static final TestServiceFactory INSTANCE = new DefaultTestServiceFactory();

    @Override
    public TestService create(TestServiceOptions options) {
      return new TestServiceImpl(options);
    }
  }

  private interface TestServiceRpcFactory
      extends ServiceRpcFactory<TestServiceRpc, TestServiceOptions> {}

  private static class DefaultTestServiceRpcFactory implements TestServiceRpcFactory {
    private static final TestServiceRpcFactory INSTANCE = new DefaultTestServiceRpcFactory();

    @Override
    public TestServiceRpc create(TestServiceOptions options) {
      return new DefaultTestServiceRpc(options);
    }
  }

  private interface TestServiceRpc {}

  private static class DefaultTestServiceRpc implements TestServiceRpc {
    DefaultTestServiceRpc(TestServiceOptions options) {}
  }

  private static class TestServiceOptions
      extends ServiceOptions<TestService, TestServiceRpc, TestServiceOptions> {
    private static class Builder
        extends ServiceOptions.Builder<TestService, TestServiceRpc, TestServiceOptions, Builder> {
      private Builder() {}

      private Builder(TestServiceOptions options) {
        super(options);
      }

      @Override
      protected TestServiceOptions build() {
        return new TestServiceOptions(this);
      }
    }

    private TestServiceOptions(Builder builder) {
      super(TestServiceFactory.class, TestServiceRpcFactory.class, builder);
    }

    @Override
    protected TestServiceFactory defaultServiceFactory() {
      return DefaultTestServiceFactory.INSTANCE;
    }

    @Override
    protected TestServiceRpcFactory defaultRpcFactory() {
      return DefaultTestServiceRpcFactory.INSTANCE;
    }

    @Override
    protected Set<String> scopes() {
      return null;
    }

    @Override
    public Builder toBuilder() {
      return new Builder(this);
    }

    private static Builder builder() {
      return new Builder();
    }

    @Override
    public boolean equals(Object obj) {
      return obj instanceof TestServiceOptions && baseEquals((TestServiceOptions) obj);
    }

    @Override
    public int hashCode() {
      return baseHashCode();
    }
  }

  @Test
  public void testBuilder() {
    assertSame(authCredentials, OPTIONS.authCredentials());
    assertSame(TEST_CLOCK, OPTIONS.clock());
    assertEquals("host", OPTIONS.host());
    assertEquals("project-id", OPTIONS.projectId());
    assertSame(RetryParams.noRetries(), OPTIONS.retryParams());
    assertSame(Clock.defaultClock(), DEFAULT_OPTIONS.clock());
    assertEquals("https://www.googleapis.com", DEFAULT_OPTIONS.host());
    assertSame(RetryParams.defaultInstance(), DEFAULT_OPTIONS.retryParams());
  }

  @Test
  public void testGetProjectIdRequired() {
    assertTrue(OPTIONS.projectIdRequired());
  }

  @Test
  public void testService() {
    assertTrue(OPTIONS.service() instanceof TestServiceImpl);
  }

  @Test
  public void testRpc() {
    assertTrue(OPTIONS.rpc() instanceof DefaultTestServiceRpc);
  }

  @Test
  public void testBaseEquals() {
    assertEquals(OPTIONS, OPTIONS_COPY);
    assertNotEquals(DEFAULT_OPTIONS, OPTIONS);
  }

  @Test
  public void testBaseHashCode() {
    assertEquals(OPTIONS.hashCode(), OPTIONS_COPY.hashCode());
    assertNotEquals(DEFAULT_OPTIONS.hashCode(), OPTIONS.hashCode());
  }
}
