package com.google.cloud.model;

/**
 * GetAdvisory returns information about security advisories hosted by OSV.
 * <p>
 * For more information, please refer to <a
 * href="https://docs.deps.dev/api/v3/#getadvisory">GetAdvisory</a>.
 *
 * @param advisoryKey The identifier for the security advisory.
 * @param url The URL of the security advisory.
 * @param title A brief human-readable description.
 * @param aliases Other identifiers used for the advisory, including CVEs.
 * @param cvss3Score The severity of the advisory as a CVSS v3 score in the range [0,10]. A higher
 * score represents greater severity.
 * @param cvss3Vector The severity of the advisory as a CVSS v3 vector string.
 */
public record Advisory(
    AdvisoryKey advisoryKey,
    String url,
    String title,
    String[] aliases,
    double cvss3Score,
    String cvss3Vector) {

  @Override
  public String toString() {
    return String.format("Advisory (id: %s, more info: [%s](%s))", advisoryKey.id(), title, url);
  }
}

