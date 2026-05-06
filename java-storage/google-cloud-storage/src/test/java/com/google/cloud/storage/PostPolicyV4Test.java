/*
 * Copyright 2020 Google LLC
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
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import org.junit.Test;

public class PostPolicyV4Test {
  private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

  private void assertMapsEquals(Map<String, String> expected, Map<String, String> returned) {
    assertEquals("map sizes", expected.size(), returned.size());
    for (String key : expected.keySet()) {
      assertEquals("value of $" + key, expected.get(key), returned.get(key));
    }
  }

  private static final String[] VALID_FIELDS = {
    "acl",
    "bucket",
    "cache-control",
    "content-disposition",
    "content-encoding",
    "content-type",
    "expires",
    "file",
    "key",
    "policy",
    "success_action_redirect",
    "success_action_status",
    "x-goog-algorithm",
    "x-goog-credential",
    "x-goog-date",
    "x-goog-signature",
  };

  private static final String CUSTOM_PREFIX = "x-goog-meta-";

  private static Map<String, String> initAllFields() {
    Map<String, String> fields = new HashMap<>();
    for (String key : VALID_FIELDS) {
      fields.put(key, "value of " + key);
    }
    fields.put(CUSTOM_PREFIX + "custom", "value of custom field");
    return Collections.unmodifiableMap(fields);
  }

  private static final Map<String, String> ALL_FIELDS = initAllFields();

  @Test
  public void testPostPolicyV4_of() {
    String url = "http://example.com";
    PostPolicyV4 policy = PostPolicyV4.of(url, ALL_FIELDS);
    assertEquals(url, policy.getUrl());
    assertMapsEquals(ALL_FIELDS, policy.getFields());
  }

  @Test
  public void testPostPolicyV4_ofMalformedURL() {
    try {
      PostPolicyV4.of("example.com", new HashMap<String, String>());
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("example.com is not an absolute URL", e.getMessage());
    }

    try {
      PostPolicyV4.of("Scio nescio", new HashMap<String, String>());
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals(
          "java.net.URISyntaxException: Illegal character in path at index 4: Scio nescio",
          e.getMessage());
    }
  }

  @Test
  public void testPostFieldsV4_of() {
    PostPolicyV4.PostFieldsV4 fields = PostPolicyV4.PostFieldsV4.of(ALL_FIELDS);
    assertMapsEquals(ALL_FIELDS, fields.getFieldsMap());
  }

  @Test
  public void testPostPolicyV4_builder() {
    PostPolicyV4.PostFieldsV4.Builder builder = PostPolicyV4.PostFieldsV4.newBuilder();
    builder.setAcl("acl");
    builder.setCacheControl("cache-control");
    builder.setContentDisposition("content-disposition");
    builder.setContentType("content-type");
    builder.setExpires("expires");
    builder.setSuccessActionRedirect("success_action_redirect");
    Map<String, String> map = builder.build().getFieldsMap();
    assertEquals("map size", 6, map.size());
    for (String key : map.keySet()) {
      assertEquals("value of $" + key, key, map.get(key));
    }

    Map<String, String> expectedUpdated = new HashMap<>(map);
    builder.setCustomMetadataField("xxx", "XXX");
    builder.setCustomMetadataField(CUSTOM_PREFIX + "yyy", "YYY");
    builder.setAcl(null);
    builder.setContentType("new-content-type");
    builder.setSuccessActionStatus(42);
    expectedUpdated.put(CUSTOM_PREFIX + "xxx", "XXX");
    expectedUpdated.put(CUSTOM_PREFIX + "yyy", "YYY");
    expectedUpdated.put("acl", null);
    expectedUpdated.put("content-type", "new-content-type");
    expectedUpdated.put("success_action_status", "42");
    Map<String, String> updated = builder.build().getFieldsMap();
    assertMapsEquals(expectedUpdated, updated);
  }

  @Test
  public void testPostPolicyV4_setContentLength() {
    PostPolicyV4.PostFieldsV4.Builder builder = PostPolicyV4.PostFieldsV4.newBuilder();
    builder.setContentLength(12345);
    assertTrue(builder.build().getFieldsMap().isEmpty());
  }

  @Test
  public void testPostConditionsV4_builder() {
    PostPolicyV4.PostConditionsV4.Builder builder = PostPolicyV4.PostConditionsV4.newBuilder();
    assertTrue(builder.build().getConditions().isEmpty());

    builder.addAclCondition(PostPolicyV4.ConditionV4Type.STARTS_WITH, "public");
    builder.addBucketCondition(PostPolicyV4.ConditionV4Type.MATCHES, "travel-maps");
    builder.addContentLengthRangeCondition(0, 100000);

    PostPolicyV4.PostConditionsV4 postConditionsV4 = builder.build();
    Set<PostPolicyV4.ConditionV4> conditions = postConditionsV4.getConditions();
    assertEquals(3, conditions.size());

    try {
      conditions.clear();
      fail();
    } catch (UnsupportedOperationException e) {
      // expected
    }

    PostPolicyV4.PostConditionsV4 postConditionsV4Extended =
        postConditionsV4.toBuilder()
            .addCustomCondition(PostPolicyV4.ConditionV4Type.STARTS_WITH, "key", "")
            .build();
    assertEquals(4, postConditionsV4Extended.getConditions().size());
  }

  interface ConditionTest {
    /**
     * Calls one of addCondition method on the given builder and returns expected ConditionV4
     * object.
     */
    PostPolicyV4.ConditionV4 addCondition(PostPolicyV4.PostConditionsV4.Builder builder);
  }

  @Test
  public void testPostConditionsV4_addCondition() {
    // shortcuts
    final PostPolicyV4.ConditionV4Type eq = PostPolicyV4.ConditionV4Type.MATCHES;
    final PostPolicyV4.ConditionV4Type startsWith = PostPolicyV4.ConditionV4Type.STARTS_WITH;
    final PostPolicyV4.ConditionV4Type range = PostPolicyV4.ConditionV4Type.CONTENT_LENGTH_RANGE;

    ConditionTest[] cases = {
      new ConditionTest() {
        @Override
        public PostPolicyV4.ConditionV4 addCondition(
            PostPolicyV4.PostConditionsV4.Builder builder) {
          builder.addContentLengthRangeCondition(123, 456);
          return new PostPolicyV4.ConditionV4(range, "123", "456");
        }

        @Override
        public String toString() {
          return "addContentLengthRangeCondition()";
        }
      },
      new ConditionTest() {
        @Override
        public PostPolicyV4.ConditionV4 addCondition(
            PostPolicyV4.PostConditionsV4.Builder builder) {
          long date = 2000000000000L;
          builder.addExpiresCondition(date);
          return new PostPolicyV4.ConditionV4(eq, "expires", dateFormat.format(date));
        }

        @Override
        public String toString() {
          return "addExpiresCondition(long)";
        }
      },
      new ConditionTest() {
        @Override
        public PostPolicyV4.ConditionV4 addCondition(
            PostPolicyV4.PostConditionsV4.Builder builder) {
          builder.addExpiresCondition("2030-Dec-31");
          return new PostPolicyV4.ConditionV4(eq, "expires", "2030-Dec-31");
        }

        @Override
        public String toString() {
          return "addExpiresCondition(String)";
        }
      },
      new ConditionTest() {
        @Override
        public PostPolicyV4.ConditionV4 addCondition(
            PostPolicyV4.PostConditionsV4.Builder builder) {
          builder.addExpiresCondition(range, 0);
          return new PostPolicyV4.ConditionV4(eq, "expires", dateFormat.format(0));
        }

        @Override
        public String toString() {
          return "@deprecated addExpiresCondition(type,long)";
        }
      },
      new ConditionTest() {
        @Override
        public PostPolicyV4.ConditionV4 addCondition(
            PostPolicyV4.PostConditionsV4.Builder builder) {
          builder.addExpiresCondition(startsWith, "2030-Dec-31");
          return new PostPolicyV4.ConditionV4(eq, "expires", "2030-Dec-31");
        }

        @Override
        public String toString() {
          return "@deprecated addExpiresCondition(type,String)";
        }
      },
      new ConditionTest() {
        @Override
        public PostPolicyV4.ConditionV4 addCondition(
            PostPolicyV4.PostConditionsV4.Builder builder) {
          builder.addSuccessActionStatusCondition(202);
          return new PostPolicyV4.ConditionV4(eq, "success_action_status", "202");
        }

        @Override
        public String toString() {
          return "addSuccessActionStatusCondition(int)";
        }
      },
      new ConditionTest() {
        @Override
        public PostPolicyV4.ConditionV4 addCondition(
            PostPolicyV4.PostConditionsV4.Builder builder) {
          builder.addSuccessActionStatusCondition(startsWith, 202);
          return new PostPolicyV4.ConditionV4(eq, "success_action_status", "202");
        }

        @Override
        public String toString() {
          return "@deprecated addSuccessActionStatusCondition(type,int)";
        }
      },
      new ConditionTest() {
        @Override
        public PostPolicyV4.ConditionV4 addCondition(
            PostPolicyV4.PostConditionsV4.Builder builder) {
          builder.addAclCondition(startsWith, "read");
          return new PostPolicyV4.ConditionV4(startsWith, "acl", "read");
        }

        @Override
        public String toString() {
          return "addAclCondition()";
        }
      },
      new ConditionTest() {
        @Override
        public PostPolicyV4.ConditionV4 addCondition(
            PostPolicyV4.PostConditionsV4.Builder builder) {
          builder.addBucketCondition(eq, "my-bucket");
          return new PostPolicyV4.ConditionV4(eq, "bucket", "my-bucket");
        }

        @Override
        public String toString() {
          return "addBucketCondition()";
        }
      },
      new ConditionTest() {
        @Override
        public PostPolicyV4.ConditionV4 addCondition(
            PostPolicyV4.PostConditionsV4.Builder builder) {
          builder.addCacheControlCondition(eq, "false");
          return new PostPolicyV4.ConditionV4(eq, "cache-control", "false");
        }

        @Override
        public String toString() {
          return "addCacheControlCondition()";
        }
      },
      new ConditionTest() {
        @Override
        public PostPolicyV4.ConditionV4 addCondition(
            PostPolicyV4.PostConditionsV4.Builder builder) {
          builder.addContentDispositionCondition(startsWith, "gzip");
          return new PostPolicyV4.ConditionV4(startsWith, "content-disposition", "gzip");
        }

        @Override
        public String toString() {
          return "addContentDispositionCondition()";
        }
      },
      new ConditionTest() {
        @Override
        public PostPolicyV4.ConditionV4 addCondition(
            PostPolicyV4.PostConditionsV4.Builder builder) {
          builder.addContentEncodingCondition(eq, "koi8");
          return new PostPolicyV4.ConditionV4(eq, "content-encoding", "koi8");
        }

        @Override
        public String toString() {
          return "addContentEncodingCondition()";
        }
      },
      new ConditionTest() {
        @Override
        public PostPolicyV4.ConditionV4 addCondition(
            PostPolicyV4.PostConditionsV4.Builder builder) {
          builder.addContentTypeCondition(startsWith, "application/");
          return new PostPolicyV4.ConditionV4(startsWith, "content-type", "application/");
        }

        @Override
        public String toString() {
          return "addContentTypeCondition()";
        }
      },
      new ConditionTest() {
        @Override
        public PostPolicyV4.ConditionV4 addCondition(
            PostPolicyV4.PostConditionsV4.Builder builder) {
          builder.addKeyCondition(startsWith, "");
          return new PostPolicyV4.ConditionV4(startsWith, "key", "");
        }

        @Override
        public String toString() {
          return "addKeyCondition()";
        }
      },
      new ConditionTest() {
        @Override
        public PostPolicyV4.ConditionV4 addCondition(
            PostPolicyV4.PostConditionsV4.Builder builder) {
          builder.addSuccessActionRedirectUrlCondition(eq, "fail");
          return new PostPolicyV4.ConditionV4(eq, "success_action_redirect", "fail");
        }

        @Override
        public String toString() {
          return "addSuccessActionRedirectUrlCondition()";
        }
      },
    };

    for (ConditionTest testCase : cases) {
      PostPolicyV4.PostConditionsV4.Builder builder = PostPolicyV4.PostConditionsV4.newBuilder();
      PostPolicyV4.ConditionV4 expected = testCase.addCondition(builder);
      Set<PostPolicyV4.ConditionV4> conditions = builder.build().getConditions();
      assertEquals("size", 1, conditions.size());
      PostPolicyV4.ConditionV4 actual = conditions.toArray(new PostPolicyV4.ConditionV4[1])[0];
      assertEquals(testCase.toString(), expected, actual);
    }
  }

  @Test
  public void testPostConditionsV4_addConditionFail() {
    final PostPolicyV4.PostConditionsV4.Builder builder =
        PostPolicyV4.PostConditionsV4.newBuilder();
    final PostPolicyV4.ConditionV4Type range = PostPolicyV4.ConditionV4Type.CONTENT_LENGTH_RANGE;

    Callable[] cases = {
      new Callable<Void>() {
        @Override
        public Void call() {
          builder.addAclCondition(range, "");
          return null;
        }

        @Override
        public String toString() {
          return "acl";
        }
      },
      new Callable<Void>() {
        @Override
        public Void call() {
          builder.addBucketCondition(range, "");
          return null;
        }

        @Override
        public String toString() {
          return "bucket";
        }
      },
      new Callable<Void>() {
        @Override
        public Void call() {
          builder.addCacheControlCondition(range, "");
          return null;
        }

        @Override
        public String toString() {
          return "cache-control";
        }
      },
      new Callable<Void>() {
        @Override
        public Void call() {
          builder.addContentDispositionCondition(range, "");
          return null;
        }

        @Override
        public String toString() {
          return "content-disposition";
        }
      },
      new Callable<Void>() {
        @Override
        public Void call() {
          builder.addContentEncodingCondition(range, "");
          return null;
        }

        @Override
        public String toString() {
          return "content-encoding";
        }
      },
      new Callable<Void>() {
        @Override
        public Void call() {
          builder.addContentTypeCondition(range, "");
          return null;
        }

        @Override
        public String toString() {
          return "content-type";
        }
      },
      new Callable<Void>() {
        @Override
        public Void call() {
          builder.addKeyCondition(range, "");
          return null;
        }

        @Override
        public String toString() {
          return "key";
        }
      },
      new Callable<Void>() {
        @Override
        public Void call() {
          builder.addSuccessActionRedirectUrlCondition(range, "");
          return null;
        }

        @Override
        public String toString() {
          return "success_action_redirect";
        }
      },
    };

    for (Callable testCase : cases) {
      try {
        testCase.call();
        fail();
      } catch (Exception e) {
        String expected =
            "java.lang.IllegalArgumentException: Field "
                + testCase
                + " can't use content-length-range";
        assertEquals(expected, e.toString());
      }
    }
    assertTrue(builder.build().getConditions().isEmpty());
  }

  @Test
  public void testPostConditionsV4_toString() {
    PostPolicyV4.PostConditionsV4.Builder builder = PostPolicyV4.PostConditionsV4.newBuilder();
    builder.addKeyCondition(PostPolicyV4.ConditionV4Type.MATCHES, "test-object");
    builder.addAclCondition(PostPolicyV4.ConditionV4Type.STARTS_WITH, "public");
    builder.addContentLengthRangeCondition(246, 266);

    Set<String> toStringSet = new HashSet<>();
    for (PostPolicyV4.ConditionV4 conditionV4 : builder.build().getConditions()) {
      toStringSet.add(conditionV4.toString());
    }
    assertEquals(3, toStringSet.size());

    String[] expectedStrings = {
      "[\"eq\", \"$key\", \"test-object\"]",
      "[\"starts-with\", \"$acl\", \"public\"]",
      "[\"content-length-range\", 246, 266]"
    };

    for (String expected : expectedStrings) {
      assertTrue(expected + "/" + toStringSet, toStringSet.contains(expected));
    }
  }

  @Test
  public void testPostPolicyV4Document_of_toJson() {
    PostPolicyV4.PostConditionsV4 emptyConditions =
        PostPolicyV4.PostConditionsV4.newBuilder().build();
    PostPolicyV4.PostPolicyV4Document emptyDocument =
        PostPolicyV4.PostPolicyV4Document.of("", emptyConditions);
    String emptyJson = emptyDocument.toJson();
    assertEquals(emptyJson, "{\"conditions\":[],\"expiration\":\"\"}");

    PostPolicyV4.PostConditionsV4 postConditionsV4 =
        PostPolicyV4.PostConditionsV4.newBuilder()
            .addBucketCondition(PostPolicyV4.ConditionV4Type.MATCHES, "my-bucket")
            .addKeyCondition(PostPolicyV4.ConditionV4Type.STARTS_WITH, "")
            .addContentLengthRangeCondition(1, 1000)
            .build();

    String expiration = dateFormat.format(System.currentTimeMillis());
    PostPolicyV4.PostPolicyV4Document document =
        PostPolicyV4.PostPolicyV4Document.of(expiration, postConditionsV4);
    String json = document.toJson();
    assertEquals(
        json,
        "{\"conditions\":[{\"bucket\":\"my-bucket\"},[\"starts-with\",\"$key\",\"\"],[\"content-length-range\",1,1000]],\"expiration\":\""
            + expiration
            + "\"}");
  }
}
