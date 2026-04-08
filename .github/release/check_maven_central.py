import os
import xml.etree.ElementTree as ET
import urllib.request
import urllib.error
from concurrent.futures import ThreadPoolExecutor, as_completed

def get_tag_text(element, tag, namespaces):
    found = element.find(tag, namespaces)
    return found.text if found is not None else None

def is_deploy_skipped(root, namespaces):
    props = root.find('mvn:properties', namespaces)
    if props is None:
        props = root.find('properties', {})
    
    if props is not None:
        for prop in props:
            # Check for both maven.deploy.skip and deploy.skip
            if prop.tag.endswith('maven.deploy.skip') or prop.tag.endswith('deploy.skip'):
                if prop.text and prop.text.strip().lower() == 'true':
                    return True
    return False

def check_maven_central(group_id, artifact_id, version):
    group_path = group_id.replace('.', '/')
    url = f"https://repo1.maven.org/maven2/{group_path}/{artifact_id}/{version}/{artifact_id}-{version}.pom"
    try:
        req = urllib.request.Request(url, method='HEAD')
        with urllib.request.urlopen(req, timeout=10) as response:
            if response.getcode() == 200:
                return True, group_id, artifact_id, version, url
    except urllib.error.HTTPError as e:
        if e.code != 404:
            print(f"HTTP error {e.code} checking {url}")
        return False, group_id, artifact_id, version, url
    except Exception as e:
        print(f"Error checking {url}: {e}")
        return False, group_id, artifact_id, version, url

def main():
    print("Finding pom.xml files...")
    pom_files = []
    for root, dirs, files in os.walk('.'):
        if '.github' in dirs:
            dirs.remove('.github')
        for file in files:
            if file == 'pom.xml':
                pom_files.append(os.path.join(root, file))

    print(f"Found {len(pom_files)} pom.xml files. Parsing unique non-SNAPSHOT artifacts...")
    
    to_check = {}
    
    for pom_path in pom_files:
        try:
            tree = ET.parse(pom_path)
            root = tree.getroot()
            
            namespaces = {'mvn': 'http://maven.apache.org/POM/4.0.0'}
            if '}' in root.tag:
                ns = root.tag.split('}')[0].strip('{')
                namespaces = {'mvn': ns}

            if is_deploy_skipped(root, namespaces):
                # print(f"Skipping {pom_path} because deployment is skipped.")
                continue

            group_id = get_tag_text(root, 'mvn:groupId', namespaces)
            artifact_id = get_tag_text(root, 'mvn:artifactId', namespaces)
            version = get_tag_text(root, 'mvn:version', namespaces)

            parent = root.find('mvn:parent', namespaces)
            if parent is not None:
                if not group_id:
                    group_id = get_tag_text(parent, 'mvn:groupId', namespaces)
                if not version:
                    version = get_tag_text(parent, 'mvn:version', namespaces)

            if not group_id or not artifact_id or not version:
                if not group_id: group_id = get_tag_text(root, 'groupId', {})
                if not artifact_id: artifact_id = get_tag_text(root, 'artifactId', {})
                if not version: version = get_tag_text(root, 'version', {})
                if parent is not None:
                    if not group_id: group_id = get_tag_text(parent, 'groupId', {})
                    if not version: version = get_tag_text(parent, 'version', {})

            if not group_id or not artifact_id or not version:
                continue

            if version.endswith('-SNAPSHOT'):
                continue

            key = (group_id, artifact_id, version)
            if key not in to_check:
                to_check[key] = pom_path

        except Exception:
            pass

    print(f"Checking {len(to_check)} unique artifacts on Maven Central...")
    
    found_published = []
    with ThreadPoolExecutor(max_workers=25) as executor:
        futures = [executor.submit(check_maven_central, g, a, v) for (g, a, v) in to_check.keys()]
        
        count = 0
        total = len(futures)
        for future in as_completed(futures):
            is_published, g, a, v, url = future.result()
            count += 1
            if is_published:
                found_published.append(f"{g}:{a}:{v} (found in {to_check[(g,a,v)]})")
                print(f"[{count}/{total}] ALREADY PUBLISHED: {g}:{a}:{v}")
            elif count % 100 == 0:
                print(f"[{count}/{total}] Checking...")

    if found_published:
        print("\nSummary of published versions found in local pom.xml files:")
        for item in sorted(found_published):
            print(item)
        import sys
        sys.exit(1)
    else:
        print("\nNo published non-SNAPSHOT versions found.")

if __name__ == "__main__":
    main()
