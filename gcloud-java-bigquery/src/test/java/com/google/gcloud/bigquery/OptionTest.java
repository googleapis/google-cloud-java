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

package com.google.gcloud.bigquery;

import static org.junit.Assert.assertEquals;

import com.google.gcloud.spi.BigQueryRpc;

import org.junit.Test;

public class OptionTest {

  @Test
  public void testOption() {
    Option option = new Option(BigQueryRpc.Option.PAGE_TOKEN, "token");
    assertEquals(BigQueryRpc.Option.PAGE_TOKEN, option.rpcOption());
    assertEquals("token", option.value());
  }

  @Test(expected=NullPointerException.class)
  public void testNullRpcOption() {
    new Option(null, "token");
  }
}
