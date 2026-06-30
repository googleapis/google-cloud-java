/*
 * Copyright 2023 Google LLC
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

import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.storage.v2.StorageSettings;
import java.util.Map;
import org.junit.Test;

public final class XGoogApiClientHeaderProviderTest {

  @Test
  public void union_ignoreKeyCase() {
    ImmutableMap<String, String> l = ImmutableMap.of("a", "1");
    ImmutableMap<String, String> r = ImmutableMap.of("A", "2");

    ImmutableMap<String, String> union = XGoogApiClientHeaderProvider.union(l, r);
    assertThat(union).isEqualTo(ImmutableMap.of("a", "1 2"));
  }

  @Test
  public void union_diff_full() {
    ImmutableMap<String, String> l = ImmutableMap.of("a", "1");
    ImmutableMap<String, String> r = ImmutableMap.of("b", "2");

    ImmutableMap<String, String> union = XGoogApiClientHeaderProvider.union(l, r);
    assertThat(union).isEqualTo(ImmutableMap.of("a", "1", "b", "2"));
  }

  @Test
  public void union_equal() {
    ImmutableMap<String, String> l = ImmutableMap.of("a", "1");
    ImmutableMap<String, String> r = ImmutableMap.of("a", "1");

    ImmutableMap<String, String> union = XGoogApiClientHeaderProvider.union(l, r);
    assertThat(union).isEqualTo(ImmutableMap.of("a", "1"));
  }

  @Test
  public void union_equal_ignoreCase() {
    ImmutableMap<String, String> l = ImmutableMap.of("a", "1");
    ImmutableMap<String, String> r = ImmutableMap.of("A", "1");

    ImmutableMap<String, String> union = XGoogApiClientHeaderProvider.union(l, r);
    assertThat(union).isEqualTo(ImmutableMap.of("a", "1"));
  }

  @Test
  public void union_mixed() {
    ImmutableMap<String, String> l = ImmutableMap.of("a", "1", "b", "5", "d", "22");
    ImmutableMap<String, String> r = ImmutableMap.of("A", "2", "c", "300", "d", "22");

    ImmutableMap<String, String> union = XGoogApiClientHeaderProvider.union(l, r);
    assertThat(union).isEqualTo(ImmutableMap.of("a", "1 2", "b", "5", "c", "300", "d", "22"));
  }

  @Test
  public void getHeaders_sameInstance() {
    XGoogApiClientHeaderProvider provider =
        XGoogApiClientHeaderProvider.of(
            () -> ImmutableMap.of("x-goog-api-client", "java-storage"),
            ImmutableList.of("some/thing"));

    Map<String, String> headers1 = provider.getHeaders();
    Map<String, String> headers2 = provider.getHeaders();
    assertThat(headers2).isSameInstanceAs(headers1);

    assertThat(headers1).isEqualTo(ImmutableMap.of("x-goog-api-client", "java-storage some/thing"));
  }

  @Test
  public void emptyAdditionalEntries() {
    ImmutableMap<String, String> base = ImmutableMap.of("x-goog-api-client", "java-storage");
    XGoogApiClientHeaderProvider provider =
        XGoogApiClientHeaderProvider.of(() -> base, ImmutableList.of());

    Map<String, String> headers1 = provider.getHeaders();
    assertThat(headers1).isSameInstanceAs(base);
  }

  @Test
  public void apiClientProvider() {
    ApiClientHeaderProvider base = StorageSettings.defaultApiClientHeaderProviderBuilder().build();
    XGoogApiClientHeaderProvider provider =
        XGoogApiClientHeaderProvider.of(base, ImmutableList.of("some/thing"));

    Map<String, String> headers = provider.getHeaders();
    assertThat(headers).isNotNull();

    assertThat(headers).containsKey("x-goog-api-client");
    assertThat(headers.get("x-goog-api-client")).contains("gl-java/");
    assertThat(headers.get("x-goog-api-client")).contains("some/thing");
  }
}
