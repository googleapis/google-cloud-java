import os
import re

# Set to True to preview changes without applying them
DRY_RUN = False

def parse_versions_txt():
    """Reads versions.txt and returns its lines and a structured data map."""
    lines = []
    module_versions = {}
    if not os.path.exists('versions.txt'):
        return [], {}
    with open('versions.txt', 'r') as f:
        for line in f:
            lines.append(line)
            stripped = line.strip()
            if not stripped or stripped.startswith('#'):
                continue
            parts = stripped.split(':')
            if len(parts) == 3:
                # Map artifact_id -> {released_version, current_version}
                module_versions[parts[0]] = {'released': parts[1], 'current': parts[2]}
    return lines, module_versions

def get_library_info():
    """Maps library directories to their 'owned' artifacts and current versions."""
    libraries = [d for d in os.listdir('.') if os.path.isdir(d) and d.startswith('java-')]
    lib_data = {}

    for lib in libraries:
        owned_artifacts = set()
        # 1. Identify which artifact IDs actually belong to this library
        for root, dirs, files in os.walk(lib):
            if 'pom.xml' in files:
                pom_path = os.path.join(root, 'pom.xml')
                with open(pom_path, 'r') as f:
                    content = f.read()
                    # Extract the top-level <artifactId> defined in the pom (ignoring parents/dependencies)
                    content_no_comments = re.sub(r'<!--.*?-->', '', content, flags=re.DOTALL)
                    project_match = re.search(r'<project[^>]*>(.*?)</project>', content_no_comments, re.DOTALL)
                    if project_match:
                        project_content = project_match.group(1)
                        # Strip away tags that might contain 'other' artifact IDs
                        project_content = re.sub(r'<(parent|dependencies|dependencyManagement|build)>.*?</\1>', '', project_content, flags=re.DOTALL)
                        art_match = re.search(r'<artifactId>([^<]+)</artifactId>', project_content)
                        if art_match:
                            owned_artifacts.add(art_match.group(1).strip())
        
        # 2. Extract current version/artifact info for these owned modules
        modules = []
        for root, dirs, files in os.walk(lib):
            if 'pom.xml' in files:
                pom_path = os.path.join(root, 'pom.xml')
                with open(pom_path, 'r') as f:
                    content = f.read()
                    # Find version strings marked with the update comment
                    matches = re.findall(r'<version>([^<]+)</version>\s*<!--\s*\{x-version-update:([^:]+):current\}\s*-->', content)
                    for version, artifact_id in matches:
                        if artifact_id in owned_artifacts and artifact_id != 'google-cloud-java':
                            modules.append({'artifact_id': artifact_id, 'version': version, 'file': pom_path})
        if modules:
            lib_data[lib] = {'modules': modules, 'owned_artifacts': owned_artifacts}

    return lib_data

def analyze(lib_data, versions_txt_data):
    """Calculates the target versions and identifies which modules to bump."""
    global_bump_map = {}
    for lib, data in lib_data.items():
        modules = data['modules']
        
        # Determine the maximum version currently used in this specific library
        max_version = None
        for m in modules:
            v = m['version']
            if max_version is None or v > max_version:
                max_version = v
        
        if not max_version:
            continue

        # Find the released-version corresponding to this max-version from versions.txt
        target_released = None
        for m in modules:
            if m['version'] == max_version:
                v_info = versions_txt_data.get(m['artifact_id'])
                if v_info and v_info['current'] == max_version:
                    target_released = v_info['released']
                    break
        
        # Fallback if the library doesn't have the info yet
        if not target_released:
            for art, info in versions_txt_data.items():
                if info['current'] == max_version:
                    target_released = info['released']
                    break

        # Map out the bumps for modules starting with proto- or grpc-
        for art in data['owned_artifacts']:
            if not (art.startswith('proto-') or art.startswith('grpc-')):
                continue
            
            curr = None
            for m in modules:
                if m['artifact_id'] == art:
                    curr = m['version']
                    break
            if curr and curr != max_version:
                global_bump_map[art] = {
                    'old_current': curr, 
                    'new_current': max_version, 
                    'new_released': target_released
                }
            
    return global_bump_map

def execute(global_bump_map, versions_txt_lines):
    """Applies the bumps to all pom.xml files and versions.txt."""
    # 1. Surgical string replacement in ALL pom.xml files across the repo
    for root, dirs, files in os.walk('.'):
        if '.git' in dirs: dirs.remove('.git')
        for file in files:
            if file == 'pom.xml':
                pom_path = os.path.join(root, file)
                with open(pom_path, 'r') as f:
                    content = f.read()
                
                new_content = content
                for art, bump in global_bump_map.items():
                    # Precise regex matching the version + the specific update comment
                    pattern = r'<version>' + re.escape(bump['old_current']) + \
                              r'</version>\s*<!--\s*\{x-version-update:' + re.escape(art) + r':current\}\s*-->'
                    replacement = r'<version>' + bump['new_current'] + \
                                  r'</version><!-- {x-version-update:' + art + r':current} -->'
                    new_content = re.sub(pattern, replacement, new_content)
                
                if new_content != content:
                    if not DRY_RUN:
                        with open(pom_path, 'w') as f:
                            f.write(new_content)
                    print(f"Updated {pom_path}")

    # 2. Update the central versions.txt tracking file
    new_v_txt_lines = []
    for line in versions_txt_lines:
        stripped = line.strip()
        if not stripped or stripped.startswith('#'):
            new_v_txt_lines.append(line)
            continue
        parts = stripped.split(':')
        if len(parts) == 3:
            art = parts[0]
            if art in global_bump_map:
                bump = global_bump_map[art]
                new_line = f"{art}:{bump['new_released']}:{bump['new_current']}\n"
                new_v_txt_lines.append(new_line)
                print(f"Updated versions.txt entry for {art}")
            else:
                new_v_txt_lines.append(line)
        else:
            new_v_txt_lines.append(line)
    
    if not DRY_RUN:
        with open('versions.txt', 'w') as f:
            f.writelines(new_v_txt_lines)

if __name__ == "__main__":
    v_txt_lines, v_txt_data = parse_versions_txt()
    lib_info = get_library_info()
    global_bump_map = analyze(lib_info, v_txt_data)
    
    if not global_bump_map:
        print("No updates needed.")
    else:
        execute(global_bump_map, v_txt_lines)
