package com.google.cloud.model;

/**
 * The name of the package version.
 */

public record VersionKey(
    PkgManagement pkgManagement,
    String name,
    String version) {

  public static VersionKey from(String system, String name, String version)
      throws IllegalArgumentException {
    PkgManagement pkg = PkgManagement.valueOf(system.toUpperCase());
    if (!PkgManagement.checkPackageName(pkg, name)) {
      throw new IllegalArgumentException(
          String.format("%s is an incorrect package name in %s package management system", name,
              pkg));
    }
    return new VersionKey(pkg, name, version);
  }

  @Override
  public String toString() {
    if (pkgManagement == PkgManagement.MAVEN) {
      return String.format("%s:%s", name, version);
    }

    return "VersionKey{" +
        "pkgManagement=" + pkgManagement +
        ", name='" + name + '\'' +
        ", version='" + version + '\'' +
        '}';
  }
}
