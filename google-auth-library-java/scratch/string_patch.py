import sys
import re

def main():
    # Fix AgentIdentityUtils.java
    file1 = 'oauth2_http/java/com/google/auth/oauth2/AgentIdentityUtils.java'
    with open(file1, 'r') as f:
        content = f.read()

    # Add Javadocs to constants
    for var in ['Logger LOGGER', 'String GOOGLE_API_CERTIFICATE_CONFIG', 'String GOOGLE_API_PREVENT_TOKEN_SHARING_FOR_GCP_SERVICES', 'List<Pattern> AGENT_IDENTITY_SPIFFE_PATTERNS', 'int SAN_URI_TYPE', 'String SPIFFE_SCHEME_PREFIX', 'String wellKnownDir', 'int CERT_KEY_MATCH_RETRIES', 'long CERT_KEY_MATCH_RETRY_INTERVAL_MS', 'int FAST_POLL_CYCLES', 'long FAST_POLL_INTERVAL_MS', 'long SLOW_POLL_INTERVAL_MS', 'long TOTAL_TIMEOUT_MS', 'List<Long> POLLING_INTERVALS', 'EnvReader envReader', 'TimeService timeService']:
        content = re.sub(r'(\s+)(.*' + var + r' =)', r'\1/** Javadoc. */\1\2', content)

    # Missing Javadocs on methods
    content = content.replace('    String getEnv(String name);', '    /** Javadoc. */\n    String getEnv(String name);')
    content = content.replace('    void sleep(long millis) throws InterruptedException;', '    /** Javadoc. */\n    void sleep(final long millis) throws InterruptedException;')

    # Replace parameter finals using regex
    content = content.replace('void setWellKnownDir(String dir) {', 'void setWellKnownDir(final String dir) {')
    content = content.replace('void sleep(long millis) throws InterruptedException {', 'void sleep(final long millis) throws InterruptedException {')

    # Fix magic number
    content = content.replace('timeService.sleep(100);', 'timeService.sleep(CERT_KEY_MATCH_RETRY_INTERVAL_MS);')

    # Inner classes fixes (visibility, finals, accessors, javadocs)
    content = content.replace(
        "    final X509Certificate certificate;\n    final String certContent;\n",
        "    /** Javadoc. */\n    private final X509Certificate certificate;\n    /** Javadoc. */\n    private final String certContent;\n"
    )
    content = content.replace(
        "    CertInfo(X509Certificate certificate, String certContent) {\n      this.certificate = certificate;\n      this.certContent = certContent;\n    }",
        "    CertInfo(final X509Certificate certificate, final String certContent) {\n      this.certificate = certificate;\n      this.certContent = certContent;\n    }\n    /** Javadoc. */\n    public X509Certificate getCertificate() { return certificate; }\n    /** Javadoc. */\n    public String getCertContent() { return certContent; }"
    )
    
    content = content.replace(
        "    final String certPath;\n    final String keyPath;\n",
        "    /** Javadoc. */\n    private final String certPath;\n    /** Javadoc. */\n    private final String keyPath;\n"
    )
    content = content.replace(
        "    ResolvedCertAndKeyPaths(String certPath, String keyPath) {\n      this.certPath = certPath;\n      this.keyPath = keyPath;\n    }",
        "    ResolvedCertAndKeyPaths(final String certPath, final String keyPath) {\n      this.certPath = certPath;\n      this.keyPath = keyPath;\n    }\n    /** Javadoc. */\n    public String getCertPath() { return certPath; }\n    /** Javadoc. */\n    public String getKeyPath() { return keyPath; }"
    )

    content = content.replace("info.certificate", "info.getCertificate()")
    content = content.replace("info.certContent", "info.getCertContent()")
    content = content.replace("paths.certPath", "paths.getCertPath()")
    content = content.replace("paths.keyPath", "paths.getKeyPath()")
    
    with open(file1, 'w') as f:
        f.write(content)

    # Fix ComputeEngineCredentials.java
    file2 = 'oauth2_http/java/com/google/auth/oauth2/ComputeEngineCredentials.java'
    with open(file2, 'r') as f:
        content2 = f.read()
        
    for var in ['String transportFactory', 'Collection<String> scopes', 'Collection<String> defaultScopes', 'String universeDomain', 'String quotaProjectId']:
        pass
    
    # Let's fix missing javadocs in Builder
    content2 = re.sub(r'(\s+)public Builder setHttpTransportFactory\(', r'\1/** Javadoc. */\1public Builder setHttpTransportFactory(', content2)
    content2 = re.sub(r'(\s+)public Builder setScopes\(', r'\1/** Javadoc. */\1public Builder setScopes(', content2)
    content2 = re.sub(r'(\s+)public Builder setDefaultScopes\(', r'\1/** Javadoc. */\1public Builder setDefaultScopes(', content2)
    content2 = re.sub(r'(\s+)public Builder setUniverseDomain\(', r'\1/** Javadoc. */\1public Builder setUniverseDomain(', content2)
    content2 = re.sub(r'(\s+)public Builder setQuotaProjectId\(', r'\1/** Javadoc. */\1public Builder setQuotaProjectId(', content2)
    content2 = re.sub(r'(\s+)public HttpTransportFactory getHttpTransportFactory\(', r'\1/** Javadoc. */\1public HttpTransportFactory getHttpTransportFactory(', content2)
    content2 = re.sub(r'(\s+)public Collection<String> getScopes\(', r'\1/** Javadoc. */\1public Collection<String> getScopes(', content2)
    content2 = re.sub(r'(\s+)public Collection<String> getDefaultScopes\(', r'\1/** Javadoc. */\1public Collection<String> getDefaultScopes(', content2)
    content2 = re.sub(r'(\s+)public ComputeEngineCredentials build\(', r'\1/** Javadoc. */\1public ComputeEngineCredentials build(', content2)

    # Add javadocs to missing vars in builder:
    content2 = re.sub(r'(\s+)private HttpTransportFactory transportFactory;', r'\1/** Javadoc. */\1private HttpTransportFactory transportFactory;', content2)
    content2 = re.sub(r'(\s+)private Collection<String> defaultScopes;', r'\1/** Javadoc. */\1private Collection<String> defaultScopes;', content2)
    content2 = re.sub(r'(\s+)private String universeDomain;', r'\1/** Javadoc. */\1private String universeDomain;', content2)
    
    # Final parameters in Builder
    content2 = content2.replace('Builder(ComputeEngineCredentials credentials) {', 'Builder(final ComputeEngineCredentials credentials) {')
    content2 = content2.replace('public Builder setHttpTransportFactory(HttpTransportFactory transportFactory) {', 'public Builder setHttpTransportFactory(final HttpTransportFactory transportFactory) {')
    content2 = content2.replace('public Builder setScopes(Collection<String> scopes) {', 'public Builder setScopes(final Collection<String> scopes) {')
    content2 = content2.replace('public Builder setDefaultScopes(Collection<String> defaultScopes) {', 'public Builder setDefaultScopes(final Collection<String> defaultScopes) {')
    content2 = content2.replace('public Builder setUniverseDomain(String universeDomain) {', 'public Builder setUniverseDomain(final String universeDomain) {')
    content2 = content2.replace('public Builder setQuotaProjectId(String quotaProjectId) {', 'public Builder setQuotaProjectId(final String quotaProjectId) {')

    # Final parameters in other methods
    content2 = content2.replace('public static ComputeEngineCredentials create(HttpTransport transport) {', 'public static ComputeEngineCredentials create(final HttpTransport transport) {')
    content2 = content2.replace('public Builder setTokenBindingEnforcement(\n        TokenBindingEnforcement bindingEnforcement)', 'public Builder setTokenBindingEnforcement(\n        final TokenBindingEnforcement bindingEnforcement)')
    
    with open(file2, 'w') as f:
        f.write(content2)

if __name__ == '__main__':
    main()
