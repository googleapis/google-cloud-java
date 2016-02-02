/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.gcloud.dns;

import com.google.gcloud.spi.DnsRpc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

public class AbstractOptionTest {

  private static final DnsRpc.Option RPC_OPTION = DnsRpc.Option.DNS_TYPE;
  private static final DnsRpc.Option ANOTHER_RPC_OPTION = DnsRpc.Option.DNS_NAME;
  private static final String VALUE = "some value";
  private static final String OTHER_VALUE = "another value";
  private static final AbstractOption OPTION = new AbstractOption(RPC_OPTION, VALUE) {};
  private static final AbstractOption OPTION_EQUALS = new AbstractOption(RPC_OPTION, VALUE) {};
  private static final AbstractOption OPTION_NOT_EQUALS1 =
      new AbstractOption(RPC_OPTION, OTHER_VALUE) {};
  private static final AbstractOption OPTION_NOT_EQUALS2 =
      new AbstractOption(ANOTHER_RPC_OPTION, VALUE) {};

  @Test
  public void testEquals() {
    assertEquals(OPTION, OPTION_EQUALS);
    assertNotEquals(OPTION, OPTION_NOT_EQUALS1);
    assertNotEquals(OPTION, OPTION_NOT_EQUALS2);
  }

  @Test
  public void testHashCode() {
    assertEquals(OPTION.hashCode(), OPTION_EQUALS.hashCode());
  }

  @Test
  public void testConstructor() {
    assertEquals(RPC_OPTION, OPTION.rpcOption());
    assertEquals(VALUE, OPTION.value());
    try {
      new AbstractOption(null, VALUE) {};
      fail("Cannot build with empty option.");
    } catch (NullPointerException e) {
      // expected
    }
    new AbstractOption(RPC_OPTION, null) {}; // null value is ok
  }
}
