package com.google.cloud.model;

/**
 * The package management system containing the package.
 */
public enum PkgManagement {
  MAVEN;

  public static boolean checkPackageName(PkgManagement system, String name) {
    if (system == MAVEN) {
      String[] strs = name.split(":");
      return strs.length == 2;
    }

    return false;
  }
}
