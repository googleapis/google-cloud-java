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

package com.google.cloud.compute;

import static org.junit.Assert.assertEquals;

import com.google.common.collect.ImmutableList;

import org.junit.Test;

public class ServiceAccountTest {

  private static final ServiceAccount SERVICE_ACCOUNT =
      ServiceAccount.of("email", ImmutableList.of("scope1"));

  @Test
  public void testOf() {
    compareServiceAccount(SERVICE_ACCOUNT, ServiceAccount.of("email", ImmutableList.of("scope1")));
    compareServiceAccount(SERVICE_ACCOUNT, ServiceAccount.of("email", "scope1"));
  }

  @Test
  public void testOfDeprecated() {
    assertEquals("email", SERVICE_ACCOUNT.email());
    assertEquals(ImmutableList.of("scope1"), SERVICE_ACCOUNT.scopes());
  }

  @Test
  public void testToAndFromPb() {
    compareServiceAccount(SERVICE_ACCOUNT, ServiceAccount.fromPb(SERVICE_ACCOUNT.toPb()));
  }

  public void compareServiceAccount(ServiceAccount expected, ServiceAccount value) {
    assertEquals(expected, value);
    assertEquals(expected.getEmail(), value.getEmail());
    assertEquals(expected.getScopes(), value.getScopes());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
