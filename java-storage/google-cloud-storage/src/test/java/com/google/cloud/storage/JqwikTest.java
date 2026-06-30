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

package com.google.cloud.storage;

import static com.google.cloud.storage.StorageV2ProtoUtils.fmtProto;
import static net.jqwik.api.providers.TypeUsage.of;

import com.google.protobuf.Message;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.EdgeCases;
import net.jqwik.api.Example;
import net.jqwik.api.providers.TypeUsage;
import net.jqwik.engine.support.JqwikStringSupport;

public class JqwikTest {
  @Example
  public void reportSimple() {
    report(of(short.class));
    report(of(int.class));
    report(of(double.class));
    report(of(String.class));
    report(of(String.class).asNullable());
    report(of(List.class));
    report(of(List.class).asNullable());
    report(of(Map.class));
    report(of(Map.class).asNullable());
    report(of(Boolean.class));
    report(of(Boolean.class).asNullable());
  }

  public static void report(TypeUsage t) {
    report(t, Arbitraries.defaultFor(t));
  }

  public static void report(TypeUsage t, Arbitrary<?> objectArbitrary) {
    if (!CIUtils.verbose()) {
      return;
    }
    EdgeCases<?> cases = objectArbitrary.edgeCases();
    // inspired from net.jqwik.engine.properties.arbitraries.EdgeCasesSupport$1#toString()
    String formattedCases =
        StreamSupport.stream(cases.spliterator(), false)
            .map(
                s -> {
                  Object value = s.value();
                  if (value instanceof Message) {
                    Message m = (Message) value;
                    return fmtProto(m);
                  } else {
                    return JqwikStringSupport.displayString(value);
                  }
                })
            .collect(Collectors.joining(",\n  ", "[\n  ", "]"));
    System.out.printf("%-25s = EdgeCases%s%n", t, formattedCases);
  }
}
