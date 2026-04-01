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

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.gson.GsonFactory;
import com.google.cloud.storage.UnifiedOpts.NamedField;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableSet;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.qual.NonNull;

final class JsonUtils {

  private static final Gson gson =
      new GsonBuilder()
          // ensure null values are not stripped, they are important to us
          .serializeNulls()
          .setPrettyPrinting()
          .create();
  @VisibleForTesting static final JsonObjectParser jop = new JsonObjectParser(new GsonFactory());
  private static final Pattern array_part = Pattern.compile("(.*)\\[(\\d+)]");

  private JsonUtils() {}

  /**
   * Given a GenericJson src, and a list of {@code fieldsForOutput} create a new GenericJson where
   * every field specified in {@code fieldsForOutput} is present. If a field exists in {@code src}
   * with a specified name, that value will be used. If the field does not exist in {@code src} it
   * will be set to {@code null}.
   */
  static <T extends GenericJson> T getOutputJsonWithSelectedFields(
      T src, Set<NamedField> fieldsForOutput) {
    Set<String> fieldPaths =
        fieldsForOutput.stream()
            .map(NamedField::getApiaryName)
            .collect(ImmutableSet.toImmutableSet());
    try {
      // The datamodel of the apiary json representation doesn't have a common parent for all
      // field types, rather than writing a significant amount of code to handle all of these types
      // leverage Gson.
      // 1. serialize the object to it's json string
      // 2. load that back with gson
      // 3. use gson's datamodel which is more sane to allow named field traversal and cross
      //    selection
      // 4. output the json string of the resulting gson object
      // 5. deserialize the json string to the apiary model class.
      String string = jop.getJsonFactory().toPrettyString(src);
      JsonObject jsonObject = gson.fromJson(string, JsonObject.class);
      JsonObject ret = getOutputJson(jsonObject, fieldPaths);
      String json = gson.toJson(ret);
      Class<? extends GenericJson> aClass = src.getClass();
      //noinspection unchecked
      Class<T> clazz = (Class<T>) aClass;
      return jop.parseAndClose(new StringReader(json), clazz);
    } catch (IOException e) {
      // StringReader does not throw an IOException
      throw StorageException.coalesce(e);
    }
  }

  /**
   * Given the provided {@code inputJson} flatten it to a Map&lt;String, String> where keys are the
   * field path, and values are the string representation of the value. Then, create a
   * Map&lt;String, String> by defining an entry for each value from {@code fieldsInOutput} with a
   * null value. Then, diff the two maps retaining those entries that present in both, and adding
   * entries that only exist in the right. Then, turn that diffed map back into a tree.
   */
  @VisibleForTesting
  static @NonNull JsonObject getOutputJson(JsonObject inputJson, Set<String> fieldsInOutput) {

    Map<String, String> l = flatten(inputJson);

    // use hashmap so we can have null values
    HashMap<String, String> flat = new HashMap<>();
    for (String fieldToRetain : fieldsInOutput) {
      boolean keyFound = false;
      // Check for exact match or prefix match in the flattened source map (l)
      for (Map.Entry<String, String> sourceEntry : l.entrySet()) {
        String sourceKey = sourceEntry.getKey();
        if (sourceKey.equals(fieldToRetain) || sourceKey.startsWith(fieldToRetain + ".")) {
          flat.put(sourceKey, sourceEntry.getValue());
          keyFound = true;
        }
      }
      // If the field to retain wasn't found in the source, it means we need to add it
      // to the output with a null value, signaling a deletion.
      if (!keyFound) {
        flat.put(fieldToRetain, null);
      }
    }
    return treeify(flat);
  }

  /**
   * Given a {@link JsonObject} produce a map where keys represent the full field path using json
   * traversal notation ({@code a.b.c.d}) and the value is the string representations of that leaf
   * value.
   *
   * <p>Inverse of {@link #treeify(Map)}
   *
   * @see #treeify
   */
  @VisibleForTesting
  static Map<String, String> flatten(JsonObject o) {
    // use hashmap so we can have null values
    HashMap<String, String> ret = new HashMap<>();
    for (Entry<String, JsonElement> e : o.asMap().entrySet()) {
      ret.putAll(flatten(e.getKey(), e.getValue()));
    }
    return ret;
  }

  /**
   * Given a map where keys represent json field paths and values represent values, produce a {@link
   * JsonObject} with the tree structure matching those paths and values.
   *
   * <p>Inverse of {@link #flatten(JsonObject)}
   *
   * @see #flatten(JsonObject)
   */
  @VisibleForTesting
  static JsonObject treeify(Map<String, String> m) {
    JsonObject o = new JsonObject();
    for (Entry<String, String> e : m.entrySet()) {
      String key = e.getKey();
      String[] splits = key.split("\\.");
      String leaf = splits[splits.length - 1];

      JsonElement curr = o;
      int currIdx = -1;
      for (int i = 0, splitsEnd = splits.length, leafIdx = splitsEnd - 1; i < splitsEnd; i++) {
        final String name;
        final int idx;
        {
          String split = splits[i];
          Matcher matcher = array_part.matcher(split);
          if (matcher.matches()) {
            name = matcher.group(1);
            String idxString = matcher.group(2);
            idx = Integer.parseInt(idxString);
          } else {
            idx = -1;
            name = split;
          }
        }

        if (curr.isJsonObject()) {
          if (i != leafIdx) {
            curr =
                curr.getAsJsonObject()
                    .asMap()
                    .computeIfAbsent(
                        name,
                        s -> {
                          if (idx > -1) {
                            return new JsonArray();
                          }
                          return new JsonObject();
                        });
          } else if (idx > -1) {
            curr = curr.getAsJsonObject().asMap().computeIfAbsent(name, s -> new JsonArray());
          }
          if (currIdx == -1) {
            currIdx = idx;
          } else {
            currIdx = -1;
          }
        }

        if (curr.isJsonArray()) {
          JsonArray a = curr.getAsJsonArray();
          int size = a.size();
          int nullElementsToAdd = 0;
          if (size < currIdx) {
            nullElementsToAdd = currIdx - size;
          }

          for (int j = 0; j < nullElementsToAdd; j++) {
            a.add(JsonNull.INSTANCE);
          }
        }

        if (i == leafIdx) {
          String v = e.getValue();
          if (curr.isJsonObject()) {
            curr.getAsJsonObject().addProperty(leaf, v);
          } else if (curr.isJsonArray()) {
            JsonArray a = curr.getAsJsonArray();
            JsonElement toAdd;
            if (idx != currIdx) {
              JsonObject tmp = new JsonObject();
              tmp.addProperty(leaf, v);
              toAdd = tmp;
            } else {
              toAdd = v == null ? JsonNull.INSTANCE : new JsonPrimitive(v);
            }

            if (a.size() == currIdx) {
              a.add(toAdd);
            } else {
              List<JsonElement> l = a.asList();
              l.add(currIdx, toAdd);
              // the add above will push all values after it down an index, we instead want to
              // replace it. Remove the next index so we have the same overall size of array.
              l.remove(currIdx + 1);
            }
          }
        }
      }
    }
    return o;
  }

  private static Map<String, String> flatten(String k, JsonElement e) {
    HashMap<String, String> ret = new HashMap<>();
    if (e.isJsonObject()) {
      JsonObject o = e.getAsJsonObject();
      for (Entry<String, JsonElement> oe : o.asMap().entrySet()) {
        String prefix = k + "." + oe.getKey();
        ret.putAll(flatten(prefix, oe.getValue()));
      }
    } else if (e.isJsonArray()) {
      List<JsonElement> asList = e.getAsJsonArray().asList();
      for (int i = 0, asListSize = asList.size(); i < asListSize; i++) {
        JsonElement ee = asList.get(i);
        ret.putAll(flatten(k + "[" + i + "]", ee));
      }
    } else if (e.isJsonNull()) {
      ret.put(k, null);
    } else {
      ret.put(k, e.getAsString());
    }
    return ret;
  }
}
