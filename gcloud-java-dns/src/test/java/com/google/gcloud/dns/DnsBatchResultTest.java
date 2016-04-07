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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class DnsBatchResultTest {

  private DnsBatchResult<Boolean> result;

  @Before
  public void setUp() {
    result = new DnsBatchResult<>();
  }

  @Test
  public void testSuccess() {
    assertFalse(result.submitted());
    try {
      result.get();
      fail("This was not submitted yet.");
    } catch (IllegalStateException ex) {
      // expected
    }
    result.success(true);
    assertTrue(result.get());
  }

  @Test
  public void testError() {
    assertFalse(result.submitted());
    try {
      result.get();
      fail("This was not submitted yet.");
    } catch (IllegalStateException ex) {
      // expected
    }
    DnsException ex = new DnsException(new IOException("some error"));
    result.error(ex);
    try {
      result.get();
      fail("This is a failed operation and should have thrown a DnsException.");
    } catch (DnsException real) {
      assertSame(ex, real);
    }
  }

  // todo(mderka) test notify when implemented
}
