package io.gapi.gax.protobuf;

import com.google.common.truth.Truth;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Tests for {@link ResourceName}. As resource names are mostly a wrapper around path
 * templates, not much needs to be done here.
 */
@RunWith(JUnit4.class)
public class ResourceNameTest {

  @Test
  public void resourceNameMethods() {
    PathTemplate template = PathTemplate.create("buckets/*/objects/**");
    ResourceName name = ResourceName.create(template, "buckets/b/objects/1/2");
    Truth.assertThat(name.toString()).isEqualTo("buckets/b/objects/1/2");
    Truth.assertThat(name.get("$1")).isEqualTo("1/2");
    Truth.assertThat(name.get("$0")).isEqualTo("b");
    Truth.assertThat(name.parentName().toString()).isEqualTo("buckets/b/objects");
  }
}
