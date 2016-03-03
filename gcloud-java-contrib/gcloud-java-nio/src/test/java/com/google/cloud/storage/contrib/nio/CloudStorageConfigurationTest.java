package com.google.cloud.storage.contrib.nio;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableMap;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Unit tests for {@link CloudStorageConfiguration}.
 */
@RunWith(JUnit4.class)
public class CloudStorageConfigurationTest {

  @Rule public final ExpectedException thrown = ExpectedException.none();

  @Test
  public void testBuilder() {
    CloudStorageConfiguration config =
        CloudStorageConfiguration.builder()
            .workingDirectory("/omg")
            .permitEmptyPathComponents(true)
            .stripPrefixSlash(false)
            .usePseudoDirectories(false)
            .blockSize(666)
            .build();
    assertThat(config.workingDirectory()).isEqualTo("/omg");
    assertThat(config.permitEmptyPathComponents()).isTrue();
    assertThat(config.stripPrefixSlash()).isFalse();
    assertThat(config.usePseudoDirectories()).isFalse();
    assertThat(config.blockSize()).isEqualTo(666);
  }

  @Test
  public void testFromMap() {
    CloudStorageConfiguration config =
        CloudStorageConfiguration.fromMap(
            new ImmutableMap.Builder<String, Object>()
                .put("workingDirectory", "/omg")
                .put("permitEmptyPathComponents", true)
                .put("stripPrefixSlash", false)
                .put("usePseudoDirectories", false)
                .put("blockSize", 666)
                .build());
    assertThat(config.workingDirectory()).isEqualTo("/omg");
    assertThat(config.permitEmptyPathComponents()).isTrue();
    assertThat(config.stripPrefixSlash()).isFalse();
    assertThat(config.usePseudoDirectories()).isFalse();
    assertThat(config.blockSize()).isEqualTo(666);
  }

  @Test
  public void testFromMap_badKey_throwsIae() {
    thrown.expect(IllegalArgumentException.class);
    CloudStorageConfiguration.fromMap(ImmutableMap.of("lol", "/omg"));
  }
}
