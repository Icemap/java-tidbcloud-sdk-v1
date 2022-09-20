wget -nc https://oss.sonatype.org/content/repositories/releases/io/swagger/swagger-codegen-cli/2.2.1/swagger-codegen-cli-2.2.1.jar
java -jar swagger-codegen-cli-2.2.1.jar generate \
    -i https://download.pingcap.org/tidbcloud-oas.json \
    -l java \
    --group-id com.github.icemap \
    --artifact-id java-tidbcloud-sdk-v1 \
    --artifact-version 0.0.1 \
    --git-user-id Icemap \
    --model-package com.github.icemap.model \
    --api-package com.github.icemap.api \
    --invoker-package com.github.icemap.invoker
