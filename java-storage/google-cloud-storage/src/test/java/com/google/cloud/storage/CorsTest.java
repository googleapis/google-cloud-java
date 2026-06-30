/*
 * Copyright 2015 Google LLC
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

import static org.junit.Assert.assertEquals;

import com.google.cloud.storage.Cors.Origin;
import com.google.common.collect.ImmutableList;
import java.util.List;
import org.junit.Test;

public class CorsTest {

  @Test
  public void testOrigin() {
    assertEquals("bla", Origin.of("bla").getValue());
    assertEquals("http://host:8080", Origin.of("http", "host", 8080).toString());
    assertEquals(Origin.of("*"), Origin.any());
  }

  @Test
  public void corsTest() {
    List<Origin> origins = ImmutableList.of(Origin.any(), Origin.of("o"));
    List<String> headers = ImmutableList.of("h1", "h2");
    List<HttpMethod> methods = ImmutableList.of(HttpMethod.GET);
    Cors cors =
        Cors.newBuilder()
            .setMaxAgeSeconds(100)
            .setOrigins(origins)
            .setResponseHeaders(headers)
            .setMethods(methods)
            .build();

    assertEquals(Integer.valueOf(100), cors.getMaxAgeSeconds());
    assertEquals(origins, cors.getOrigins());
    assertEquals(methods, cors.getMethods());
    assertEquals(headers, cors.getResponseHeaders());
  }
}
