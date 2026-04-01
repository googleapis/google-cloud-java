package com.google.cloud.model;

import com.google.common.collect.ImmutableSet;
import java.util.Set;

/**
 * The type of license associated with open-source software.
 * <p>
 * For more information, please refer to go/thirdpartylicenses.
 */
public enum LicenseCategory {
  PERMISSIVE,
  RESTRICTED,
  NOTICE;

  public static Set<LicenseCategory> compliantCategories() {
    return ImmutableSet.of(LicenseCategory.NOTICE);
  }
}
