package com.google.cloud.model;

import com.google.common.collect.ImmutableList;
import java.util.List;

/**
 * Information about a specific package version, including its licenses and any security advisories
 * known to affect it.
 * <p>
 * For more information, please refer to <a
 * href="https://docs.deps.dev/api/v3/#getversion">GetVersion</a>.
 *
 * @param versionKey The name of the package version.
 * @param licenses The licenses governing the use of this package version.
 * @param advisoryKeys Security advisories known to affect this package version.
 */
public record Version(
    VersionKey versionKey,
    List<String> licenses,
    List<AdvisoryKey> advisoryKeys) {

  public List<AdvisoryKey> advisoryKeys() {
    return ImmutableList.copyOf(advisoryKeys);
  }

  public List<String> licenses() {
    return ImmutableList.copyOf(licenses);
  }
}
