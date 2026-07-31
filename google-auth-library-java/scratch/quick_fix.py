import re
import sys

def fix_agent_identity_utils(filepath):
    with open(filepath, 'r') as f:
        lines = f.readlines()
        
    out = []
    i = 0
    while i < len(lines):
        line = lines[i]
        
        # Javadocs for fields
        if any(v in line for v in [
            "Logger LOGGER =", 
            "GOOGLE_API_CERTIFICATE_CONFIG =",
            "GOOGLE_API_PREVENT_TOKEN_SHARING_FOR_GCP_SERVICES =",
             "AGENT_IDENTITY_SPIFFE_PATTERNS =",
            "SAN_URI_TYPE =",
            "SPIFFE_SCHEME_PREFIX =",
            "wellKnownDir =",
            "CERT_KEY_MATCH_RETRIES =",
            "CERT_KEY_MATCH_RETRY_INTERVAL_MS =",
            "FAST_POLL_CYCLES =",
            "FAST_POLL_INTERVAL_MS =",
            "SLOW_POLL_INTERVAL_MS =",
            "TOTAL_TIMEOUT_MS =",
            "POLLING_INTERVALS =",
            "EnvReader envReader =",
            "TimeService timeService =",
            "X509Certificate certificate;",
            "String certContent;",
            "String certPath;",
            "String keyPath;"
        ]) and "/**" not in lines[i-1]:
            indent = " " * (len(line) - len(line.lstrip()))
            out.append(indent + "/** Javadoc. */\n")
            
        # Missing Javadoc methods
        if "String getEnv(String name);" in line and "/**" not in lines[i-1]:
            indent = " " * (len(line) - len(line.lstrip()))
            out.append(indent + "/** Javadoc. */\n")

        # Line Length fixes
        if "Logger LOGGER = LoggerFactory.getLogger(AgentIdentityUtils.class);" in line:
            line = "  private static final Logger LOGGER =\n      LoggerFactory.getLogger(AgentIdentityUtils.class);\n"
        elif "static final String GOOGLE_API_PREVENT_TOKEN_SHARING_FOR_GCP_SERVICES =" in line:
            line = "  static final String GOOGLE_API_PREVENT_TOKEN_SHARING_FOR_GCP_SERVICES =\n      \"GOOGLE_API_PREVENT_TOKEN_SHARING_FOR_GCP_SERVICES\";\n"
            i += 1 # skip next line Since we merged it
        elif "private static final List<Pattern> AGENT_IDENTITY_SPIFFE_PATTERNS =" in line:
            line = "  private static final List<Pattern> AGENT_IDENTITY_SPIFFE_PATTERNS =\n"
        elif "wellKnownDir = \"/var/run/secrets/workload-spiffe-credentials/\";" in line:
            line = "  private static String wellKnownDir =\n      \"/var/run/secrets/workload-spiffe-credentials/\";\n"
        elif "long remainingTime = TOTAL_TIMEOUT_MS - (FAST_POLL_CYCLES * FAST_POLL_INTERVAL_MS);" in line:
            line = "    long remainingTime =\n        TOTAL_TIMEOUT_MS - (FAST_POLL_CYCLES * FAST_POLL_INTERVAL_MS);\n"
            
        # Magic number fixes
        elif "timeService.sleep(100);" in line:
            line = line.replace("100", "CERT_KEY_MATCH_RETRY_INTERVAL_MS")
            
        # Final parameters
        elif "static void setWellKnownDir(String dir) {" in line:
            line = line.replace("(String dir)", "(final String dir)")
        elif "void sleep(long millis) throws InterruptedException;" in line:
            line = line.replace("(long millis)", "(final long millis)")
        elif "void sleep(long millis) throws InterruptedException {" in line:
            line = line.replace("(long millis)", "(final long millis)")
            
        # Visibility and accessors for CertInfo
        elif "static class CertInfo {" in line:
            out.append(line)
            i += 1
            if "/** Javadoc. */" not in lines[i]:
                out.append("    /** Javadoc. */\n")
            out.append("    private final X509Certificate certificate;\n\n")
            if "/** Javadoc. */" not in lines[i+1]:
                out.append("    /** Javadoc. */\n")
            out.append("    private final String certContent;\n")
            i += 2 # Skip the original two fields
            continue
            
        # Fix CertInfo constructor and add getters
        elif "CertInfo(X509Certificate certificate, String certContent) {" in line:
            out.append("    CertInfo(final X509Certificate certificate, final String certContent) {\n")
            out.append(lines[i+1])
            out.append(lines[i+2])
            out.append("\n    /** Javadoc. */\n    public X509Certificate getCertificate() {\n      return certificate;\n    }\n")
            out.append("\n    /** Javadoc. */\n    public String getCertContent() {\n      return certContent;\n    }\n")
            i += 2
            continue
            
        # Visibility and accessors for ResolvedCertAndKeyPaths
        elif "static class ResolvedCertAndKeyPaths {" in line:
            out.append(line)
            i += 1
            if "/** Javadoc. */" not in lines[i]:
                out.append("    /** Javadoc. */\n")
            out.append("    private final String certPath;\n\n")
            if "/** Javadoc. */" not in lines[i+1]:
                out.append("    /** Javadoc. */\n")
            out.append("    private final String keyPath;\n")
            i += 2 # Skip the original two fields
            continue

        # Fix ResolvedCertAndKeyPaths constructor and add getters
        elif "ResolvedCertAndKeyPaths(String certPath, String keyPath) {" in line:
            out.append("    ResolvedCertAndKeyPaths(final String certPath, final String keyPath) {\n")
            out.append(lines[i+1])
            out.append(lines[i+2])
            out.append("\n    /** Javadoc. */\n    public String getCertPath() {\n      return certPath;\n    }\n")
            out.append("\n    /** Javadoc. */\n    public String getKeyPath() {\n      return keyPath;\n    }\n")
            i += 2
            continue
            
        # Empty blocks fixing (WhitespaceAround)
        elif line.strip() == "private AgentIdentityUtils() {}":
            line = "  private AgentIdentityUtils() {\n  }\n"
            
        if "info.certificate" in line:
            line = line.replace("info.certificate", "info.getCertificate()")
        if "info.certContent" in line:
            line = line.replace("info.certContent", "info.getCertContent()")

        if "paths.certPath" in line:
            line = line.replace("paths.certPath", "paths.getCertPath()")
        if "paths.keyPath" in line:
            line = line.replace("paths.keyPath", "paths.getKeyPath()")

        out.append(line)
        i += 1

    with open(filepath, 'w') as f:
        f.writelines(out)

if __name__ == '__main__':
    fix_agent_identity_utils(sys.argv[1])
