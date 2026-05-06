package com.google.cloud.model;

import com.google.common.collect.ImmutableList;
import java.util.List;

/**
 * Selected package information associated with a package version, including licenses and security
 * advisories.
 */
public record PackageInfo(
    VersionKey versionKey,
    List<License> licenses,
    List<Advisory> advisories) {

  public List<License> licenses() {
    return ImmutableList.copyOf(licenses);
  }

  public List<Advisory> advisories() {
    return ImmutableList.copyOf(advisories);
  }
}
