/*
 * Copyright 2025 Google LLC
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

import static com.google.cloud.storage.JsonUtils.jop;
import static com.google.cloud.storage.TestUtils.hashMapOf;
import static com.google.cloud.storage.UnifiedOpts.NamedField.literal;
import static com.google.cloud.storage.UnifiedOpts.NamedField.nested;
import static com.google.common.truth.Truth.assertThat;

import com.google.api.client.util.Data;
import com.google.api.services.storage.model.ObjectCustomContextPayload;
import com.google.api.services.storage.model.StorageObject;
import com.google.api.services.storage.model.StorageObject.Contexts;
import com.google.cloud.storage.Storage.BlobField;
import com.google.cloud.storage.UnifiedOpts.NamedField;
import com.google.cloud.storage.UnifiedOpts.NestedNamedField;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Stream;
import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.Combinators;
import net.jqwik.api.Example;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.Provide;
import net.jqwik.api.Tuple;
import net.jqwik.api.arbitraries.SetArbitrary;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class JsonUtilsTest {

  @Example
  public void getOutputJson_WithSelectedFields_metadata() throws IOException {
    StorageObject src = jop.parseAndClose(new StringReader(jsonString), StorageObject.class);
    StorageObject expected =
        new StorageObject()
            .setBucket("some-bucket")
            .setName("some-name")
            .setGeneration(1755811928351810L)
            .setMetadata(hashMapOf("k1", Data.nullOf(String.class)));

    NestedNamedField nested = (NestedNamedField) nested(literal("metadata"), literal("k1"));
    ImmutableSet<NamedField> modifiedFields =
        Stream.of(
                BlobField.REQUIRED_FIELDS.stream(),
                Stream.of(BlobField.GENERATION),
                Stream.of(nested))
            .flatMap(s -> s)
            .collect(ImmutableSet.toImmutableSet());

    StorageObject dst = JsonUtils.getOutputJsonWithSelectedFields(src, modifiedFields);

    assertThat(dst).isEqualTo(expected);
  }

  @Example
  public void getOutputJson_WithSelectedFields_contexts() throws IOException {
    StorageObject src = jop.parseAndClose(new StringReader(jsonString), StorageObject.class);
    StorageObject expected =
        new StorageObject()
            .setBucket("some-bucket")
            .setName("some-name")
            .setGeneration(1755811928351810L)
            .setContexts(c(hashMapOf("k2", null)));

    NestedNamedField nested =
        (NestedNamedField) nested(nested(literal("contexts"), literal("custom")), literal("k2"));
    ImmutableSet<NamedField> modifiedFields =
        Stream.of(
                BlobField.REQUIRED_FIELDS.stream(),
                Stream.of(BlobField.GENERATION),
                Stream.of(nested))
            .flatMap(s -> s)
            .collect(ImmutableSet.toImmutableSet());
    NamedField custom = nested.getParent();

    StorageObject dst = JsonUtils.getOutputJsonWithSelectedFields(src, modifiedFields);

    assertThat(dst).isEqualTo(expected);
  }

  @Property(tries = 10_000)
  void getOutputJson_WithSelectedFields_works(@ForAll("jts") JsonTrimmingScenario s) {
    JsonObject actual = JsonUtils.getOutputJson(s.original, s.fieldsToRetain);

    assertThat(actual).isEqualTo(s.expected);
  }

  @Provide("jts")
  static Arbitrary<JsonTrimmingScenario> jsonTrimmingScenarioArbitrary() {
    return fieldPaths()
        .flatMap(
            fieldPaths ->
                Combinators.combine(
                        // carry through our field paths as-is
                        Arbitraries.just(fieldPaths),
                        // create a new map that contains any number of the defined field paths
                        // where we set the value to "3"
                        // the value here isn't actually important, just that it's set to a non-null
                        // value.
                        Arbitraries.maps(Arbitraries.of(fieldPaths), Arbitraries.just("3")))
                    .as(Tuple::of)
                    .flatMap(
                        t -> {
                          Set<String> paths = t.get1();
                          assertThat(paths).isNotNull();
                          Map<String, String> m = t.get2();
                          assertThat(m).isNotNull();

                          return Combinators.combine(
                                  // carry through our m as is
                                  Arbitraries.just(m),
                                  // select a subset of the field paths we want to make sure are
                                  // present in the output object
                                  Arbitraries.of(paths).set().ofMinSize(1).ofMaxSize(paths.size()))
                              .as(JsonTrimmingScenario::of);
                        }));
  }

  private static SetArbitrary<String> fieldPaths() {
    return fieldPath().set().ofMinSize(1).ofMaxSize(30);
  }

  /**
   * Generate a json field path with a depth between 1 and 4 (inclusive).
   *
   * <p>A json field path is of the form `a.b.c.d`
   */
  private static @NonNull Arbitrary<String> fieldPath() {
    return Arbitraries.integers()
        .between(1, 4)
        .flatMap(
            depth ->
                Arbitraries.strings()
                    .withCharRange('a', 'f')
                    .ofLength(depth)
                    .map(
                        s -> {
                          StringBuilder sb = new StringBuilder();
                          char[] charArray = s.toCharArray();
                          for (int i = 0; i < charArray.length; i++) {
                            char c = charArray[i];
                            sb.append(c);
                            if (i == 0) {
                              // add the overall length as part of the first key
                              // this makes is it so different depth keys don't collide
                              // and cause trouble for things like `a.a.a: 3` and `a.a.a.a: 4`
                              sb.append(charArray.length);
                            }
                            if (i + 1 < charArray.length) {
                              sb.append(".");
                            }
                          }
                          return sb.toString();
                        }));
  }

  @Example
  public void treeify_flatten_roundtrip_withArray() {
    JsonObject o = new JsonObject();
    JsonArray a = new JsonArray();
    JsonArray b = new JsonArray();
    b.add(JsonNull.INSTANCE);
    b.add(JsonNull.INSTANCE);
    b.add(JsonNull.INSTANCE);
    b.add("b3");
    JsonObject a0 = new JsonObject();
    a0.addProperty("id", "a0");
    JsonObject a1 = new JsonObject();
    a1.addProperty("id", "a1");
    a.add(a0);
    a.add(a1);
    o.add("a", a);
    o.add("b", b);

    Map<String, @Nullable String> expected = new TreeMap<>();
    expected.put("a[0].id", "a0");
    expected.put("a[1].id", "a1");
    expected.put("b[3]", "b3");
    expected.put("b[2]", null);
    expected.put("b[1]", null);
    expected.put("b[0]", null);

    Map<String, String> flatten = new TreeMap<>(JsonUtils.flatten(o));
    assertThat(flatten).isEqualTo(expected);

    JsonObject treeify = JsonUtils.treeify(expected);
    assertThat(treeify).isEqualTo(o);
  }

  @Example
  public void treeify_arrayWithHoles() {
    JsonObject o = new JsonObject();
    JsonArray b = new JsonArray();
    b.add(JsonNull.INSTANCE);
    b.add(JsonNull.INSTANCE);
    b.add(JsonNull.INSTANCE);
    b.add("b3");
    o.add("b", b);

    Map<String, @Nullable String> expected = new TreeMap<>();
    expected.put("b[3]", "b3");

    JsonObject treeify = JsonUtils.treeify(expected);
    assertThat(treeify).isEqualTo(o);
  }

  @Example
  public void treeify_flatten_roundtrip() {
    ImmutableMap<String, String> m =
        ImmutableMap.of(
            "a.b.c.d", "D",
            "a.b.c.e", "E",
            "f.g", "G",
            "h", "H",
            "z.x.y", "Y");

    JsonObject expected = new JsonObject();
    JsonObject a = new JsonObject();
    JsonObject b = new JsonObject();
    JsonObject c = new JsonObject();
    JsonObject f = new JsonObject();
    JsonObject x = new JsonObject();
    JsonObject z = new JsonObject();

    x.addProperty("y", "Y");
    z.add("x", x);
    expected.add("z", z);

    f.addProperty("g", "G");

    c.addProperty("d", "D");
    c.addProperty("e", "E");

    b.add("c", c);
    a.add("b", b);

    expected.add("a", a);
    expected.add("f", f);
    expected.addProperty("h", "H");

    JsonObject treeified = JsonUtils.treeify(m);
    assertThat(treeified).isEqualTo(expected);

    Map<String, String> flattened = JsonUtils.flatten(treeified);
    assertThat(flattened).isEqualTo(m);
  }

  private static Contexts c(Map<String, String> m) {
    Contexts contexts = new Contexts();
    if (!m.isEmpty()) {
      contexts.setCustom(Maps.transformValues(m, JsonUtilsTest::p));
    }
    return contexts;
  }

  private static @NonNull ObjectCustomContextPayload p(@Nullable String v) {
    if (v == null) {
      return Data.nullOf(ObjectCustomContextPayload.class);
    }
    return new ObjectCustomContextPayload().setValue(v);
  }

  private static final class JsonTrimmingScenario {
    private static final Gson gson =
        new GsonBuilder()
            // ensure null values are not stripped, they are important to us
            .serializeNulls()
            .create();

    private final JsonObject original;
    private final TreeSet<String> fieldsToRetain;
    private final JsonObject expected;

    private JsonTrimmingScenario(
        JsonObject original, TreeSet<String> fieldsToRetain, JsonObject expected) {
      this.original = original;
      this.fieldsToRetain = fieldsToRetain;
      this.expected = expected;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("\noriginal", gson.toJson(original))
          .add("\nfieldsToRetain", fieldsToRetain)
          .add("\nexpected", gson.toJson(expected))
          .toString();
    }

    public static JsonTrimmingScenario of(Map<String, String> m, Set<String> fieldsToRetain) {
      TreeSet<String> ftr = new TreeSet<>(fieldsToRetain);
      JsonObject original = JsonUtils.treeify(m);
      HashMap<String, String> mm = new HashMap<>(Maps.filterKeys(m, fieldsToRetain::contains));
      for (String f : fieldsToRetain) {
        if (m.containsKey(f)) {
          continue;
        }

        mm.put(f, null);
      }
      JsonObject expected = JsonUtils.treeify(mm);
      return new JsonTrimmingScenario(original, ftr, expected);
    }
  }

  // language=JSON
  private static final String jsonString =
      "{\n"
          + "  \"bucket\": \"some-bucket\",\n"
          + "  \"contentType\": \"application/octet-stream\",\n"
          + "  \"crc32c\": \"AAAAAA\\u003d\\u003d\",\n"
          + "  \"etag\": \"CMLIoJLtnI8DEAE\\u003d\",\n"
          + "  \"generation\": \"1755811928351810\",\n"
          + "  \"id\": \"some-bucket/some-name/1755811928351810\",\n"
          + "  \"md5Hash\": \"1B2M2Y8AsgTpgAmY7PhCfg\\u003d\\u003d\",\n"
          + "  \"mediaLink\":"
          + " \"https://storage.googleapis.com/download/storage/v1/b/some-bucket/o/some-name?generation\\u003d1755811928351810\\u0026alt\\u003dmedia\",\n"
          + "  \"metadata\": {\n"
          + "    \"k1\": \"\"\n"
          + "  },\n"
          + "  \"metageneration\": \"1\",\n"
          + "  \"name\": \"some-name\",\n"
          + "  \"selfLink\": \"https://www.googleapis.com/storage/v1/b/some-bucket/o/some-name\",\n"
          + "  \"storageClass\": \"STANDARD\",\n"
          + "  \"contexts\": {\n"
          + "    \"custom\": {\n"
          + "      \"k2\": null,\n"
          + "      \"k3\": {\n"
          + "        \"value\": \"glavin\"\n"
          + "      }\n"
          + "    }\n"
          + "  }\n"
          + "}";
}
