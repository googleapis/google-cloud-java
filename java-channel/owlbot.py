import synthtool as s
from synthtool.languages import java


for library in s.get_staging_dirs():
    # put any special-case replacements here
    s.move(library)

s.remove_staging_dirs()
java.common_templates(monorepo=True, excludes=[
    ".github/*",
    ".kokoro/*",
    "samples/*",
    "CODE_OF_CONDUCT.md",
    "CONTRIBUTING.md",
    "LICENSE",
    "SECURITY.md",
    "java.header",
    "license-checks.xml",
    "renovate.json",
    ".gitignore"
])
