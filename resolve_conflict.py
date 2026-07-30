import re
with open('google-auth-library-java/oauth2_http/javatests/com/google/auth/oauth2/ComputeEngineCredentialsTest.java', 'r') as f:
    content = f.read()

# Conflict 1: Keep theirs
content = re.sub(
    r'<<<<<<< ours\n=======\n(.*?)>>>>>>> theirs\n',
    r'\1',
    content,
    flags=re.DOTALL
)

# Conflict 2: Keep both
content = re.sub(
    r'<<<<<<< ours\n(.*?)=======\n(.*?)>>>>>>> theirs\n',
    r'\1\n\2',
    content,
    flags=re.DOTALL
)

with open('google-auth-library-java/oauth2_http/javatests/com/google/auth/oauth2/ComputeEngineCredentialsTest.java', 'w') as f:
    f.write(content)
