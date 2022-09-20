/**
 * TiDB Cloud API
 * TiDB Cloud API is still in beta and only available upon request. You can apply for API access by submitting a request:  - Click **Help** in the lower-right corner of [TiDB Cloud console](https://tidbcloud.com). - In the dialog, fill in \"Apply for TiDB Cloud API\" in the **Description** field and click **Send**.  You will receive an email for notification when the API is available for you.  # Overview  The TiDB Cloud API is a [REST interface](https://en.wikipedia.org/wiki/Representational_state_transfer) that provides you with programmatic access to manage administrative objects within TiDB Cloud. Through this API, you can manage resources automatically and efficiently:  * Projects * Clusters * Backups * Restores  The API has the following features:  - **JSON entities.** All entities are expressed in JSON. - **HTTPS-only.** You can only access the API via HTTPS, ensuring all the data sent over the network is encrypted with TLS. - **Key-based access and digest authentication.** Before you access TiDB Cloud API, you must generate an API key. All requests are authenticated through [HTTP Digest Authentication](https://en.wikipedia.org/wiki/Digest_access_authentication), ensuring the API key is never sent over the network.  # Get Started  This guide helps you make your first API call to TiDB Cloud API. You'll learn how to authenticate a request, build a request, and interpret the response. The [List all accessible projects](#tag/Project/operation/ListProjects) endpoint is used in this guide as an example.  ## Prerequisites  To complete this guide, you need to perform the following tasks:  - Create a [TiDB Cloud account](https://tidbcloud.com/free-trial) - Install [curl](https://curl.se/)  ## Step 1. Create an API key  To create an API key, log in to your TiDB Cloud console. Navigate to the **Organization Settings** page, and create an API key.  An API key contains a public key and a private key. Copy and save them in a secure location. You will need to use the API key later in this guide.  For more details about creating API key, refer to [API Key Management](#section/Authentication/API-Key-Management).  ## Step 2. Make your first API call  ### Build an API call  TiDB Cloud API call have the following components:  - **A host.** The host for TiDB Cloud API is <https://api.tidbcloud.com>. - **An API Key**. The public key and the private key are required for authentication. - **A request.** When submitting data to a resource via `POST`, `PATCH`, or `PUT`, you must submit your payload in JSON.  In this guide, you call the [List all accessible projects](#tag/Project/operation/ListProjects) endpoint. For the detailed description of the endpoint, see the [API reference](#tag/Project/operation/ListProjects).  ### Call an API endpoint  To get all projects in your organization, run the following command in your terminal. Remember to change `YOUR_PUBLIC_KEY` to your public key and `YOUR_PRIVATE_KEY` to your private key.  ```shell curl --digest \\   --user 'YOUR_PUBLIC_KEY:YOUR_PRIVATE_KEY' \\   --request GET \\   --url https://api.tidbcloud.com/api/v1beta/projects ```  ## Step 3. Check the response  After making the API call, if the status code in response is `200` and you see details about all the projects in your organization, your request is successful. Here is an example of a successful response.  ```log {   \"items\": [     {       \"id\": \"{project_id}\",       \"org_id\": \"{org_id}\",       \"name\": \"MyProject\",       \"cluster_count\": 3,       \"user_count\": 1,       \"create_timestamp\": \"1652407748\"     }   ],   \"total\": 1 } ```  If your API call is not successful, you will receive a status code other than `200` and the response looks similar to the following example. To troubleshoot the failed call, you can check the `message` in the response.  ```log {   \"code\": 49900001,   \"message\": \"public_key not found\",   \"details\": [] } ```  ## Code samples  This section walks you through the quickest way to get started with TiDB Cloud API using programming languages. In these examples, you will learn how to use Python to create a cluster, backup and restore data, and scale out a cluster.  You can view the [full code examples](https://github.com/tidbcloud/tidbcloud-api-samples) of Python and Golang on GitHub or clone the repository to your local machine.  ```git git clone https://github.com/tidbcloud/tidbcloud-api-samples.git ```  ### Create and connect to a TiDB cluster  The following code examples show how to create a TiDB cluster and connect to the cluster. The whole process takes five steps:  1. Get all projects. 2. Get the cloud providers, regions and specifications. 3. Create a cluster in your specified project. 4. Get the new cluster information. 5. Connect to the cluster using a MySQL client.  #### Step 1: Get all projects  Before you create a cluster, you need to get the ID of the project that you want to create a cluster in.  To view the information of all available projects, you can use the [List all accessible projects](#tag/Project/operation/ListProjects) endpoint.  ```python import requests from requests.auth import HTTPDigestAuth  HOST = \"https://api.tidbcloud.com\"   def get_all_projects(public_key: str, private_key: str) -> dict:     \"\"\"     Get all projects     :param public_key: Your public key     :param private_key: Your private key     :return: Projects detail     \"\"\"     url = f\"{HOST}/api/v1beta/projects\"     resp = requests.get(url=url, auth=HTTPDigestAuth(public_key, private_key))     if resp.status_code != 200:         print(f\"request invalid, code : {resp.status_code}, message : {resp.text}\")         raise Exception(f\"request invalid, code : {resp.status_code}, message : {resp.text}\")     return resp.json()   if __name__ == \"__main__\":     # Replace YOUR_PUBLIC_KEY and YOUR_PRIVATE_KEY     project = get_all_projects(\"{YOUR_PUBLIC_KEY}\", \"{YOUR_PRIVATE_KEY}\")     print(project) ```  For more details about the request and response, see [List all accessible projects](#tag/Project/operation/ListProjects).  #### Step 2: Get the cloud providers, regions and specifications  Before you create a cluster, you need to get the list of available cloud providers, regions, and specifications.  ```python import requests from requests.auth import HTTPDigestAuth  HOST = \"https://api.tidbcloud.com\"   def get_provider_regions_specifications(public_key: str, private_key: str) -> dict:     \"\"\"     Get cloud providers, regions and available specifications.     :param public_key: Your public key     :param private_key: Your private key     :return: List the cloud providers, regions and available specifications.     \"\"\"     url = f\"{HOST}/api/v1beta/clusters/provider/regions\"     resp = requests.get(url=url, auth=HTTPDigestAuth(public_key, private_key))     if resp.status_code != 200:         print(f\"request invalid, code : {resp.status_code}, message : {resp.text}\")         raise Exception(f\"request invalid, code : {resp.status_code}, message : {resp.text}\")     return resp.json()   if __name__ == \"__main__\":     # Replace YOUR_PUBLIC_KEY and YOUR_PRIVATE_KEY     provider_regions_specifications = get_provider_regions_specifications(\"{YOUR_PUBLIC_KEY}\", \"{YOUR_PRIVATE_KEY}\")     print(provider_regions_specifications) ```  For more details about the request and response, see [List the cloud providers, regions and available specifications](#tag/Cluster/operation/ListProviderRegions).  #### Step 3: Create a cluster in your specified project and cloud provider  The following example uses the [Create a cluster](#tag/Cluster/operation/CreateCluster) endpoint to create a Dedicated Tier cluster. A configuration example is provided in the code; you can replace the parameters using the information you get in the previous two steps.  ```python import requests import time import json from requests.auth import HTTPDigestAuth  HOST = \"https://api.tidbcloud.com\"   def create_dedicated_cluster(public_key: str, private_key: str, project_id: str) -> dict:     \"\"\"     Create a dedicated cluster in your specified project.     `data_config` below is a demo. You should fill in the field according to     your own situation     :param public_key: Your public key     :param private_key: Your private key     :param project_id: The project id     :return: Dedicated cluster id     \"\"\"     url = f\"{HOST}/api/v1beta/projects/{project_id}/clusters\"     ts = int(time.time())     data_config = \\         {             \"name\": f\"tidbcloud-sample-{ts}\",             \"cluster_type\": \"DEDICATED\",             \"cloud_provider\": \"AWS\",             \"region\": \"us-west-2\",             \"config\":                 {                     \"root_password\": \"input_your_password\",                     \"port\": 4000,                     \"components\":                         {                             \"tidb\":                                 {                                     \"node_size\": \"8C16G\",                                     \"node_quantity\": 1                                 },                             \"tikv\":                                 {\"node_size\": \"8C32G\",                                  \"storage_size_gib\": 500,                                  \"node_quantity\": 3                                  }                         },                     \"ip_access_list\":                         [                             {                                 \"cidr\": \"0.0.0.0/0\",                                 \"description\": \"Allow Access from Anywhere.\"                             }                         ]                  }         }     data_config_json = json.dumps(data_config)     resp = requests.post(url=url,                          auth=HTTPDigestAuth(public_key, private_key),                          data=data_config_json)     if resp.status_code != 200:         print(f\"request invalid, code : {resp.status_code}, message : {resp.text}\")         raise Exception(f\"request invalid, code : {resp.status_code}, message : {resp.text}\")     return resp.json()   if __name__ == \"__main__\":     # Replace YOUR_PUBLIC_KEY, YOUR_PRIVATE_KEY and YOUR_PROJECT_ID     cluster = create_dedicated_cluster(\"{YOUR_PUBLIC_KEY}\", \"{YOUR_PRIVATE_KEY}\", \"{YOUR_PROJECT_ID}\")     print(cluster) ```  This request returns the ID of the cluster that you just created. For more details about the request and response, see [Create a cluster](#tag/Cluster/operation/CreateCluster).  #### Step 4: Get the new cluster information  After you successfully create a cluster, you can use the [Get cluster by ID](#tag/Cluster/operation/GetCluster) endpoint to get the information of the cluster.  ```python import requests from requests.auth import HTTPDigestAuth  HOST = \"https://api.tidbcloud.com\"   def get_cluster_by_id(public_key: str, private_key: str, project_id: str, cluster_id: str) -> dict:     \"\"\"     Get the cluster detail.     You will get `connection_strings` from the response after the cluster's status is`AVAILABLE`.     Then, you can connect to TiDB using the default user, host, and port in `connection_strings`     :param public_key: Your public key     :param private_key: Your private key     :param project_id: The project id     :param cluster_id: The cluster id     :return: The cluster detail     \"\"\"     url = f\"{HOST}/api/v1beta/projects/{project_id}/clusters/{cluster_id}\"     resp = requests.get(url=url,                         auth=HTTPDigestAuth(public_key, private_key))     if resp.status_code != 200:         print(f\"request invalid, code : {resp.status_code}, message : {resp.text}\")         raise Exception(f\"request invalid, code : {resp.status_code}, message : {resp.text}\")     return resp.json()   if __name__ == \"__main__\":     # Replace YOUR_PUBLIC_KEY, YOUR_PRIVATE_KEY, YOUR_PROJECT_ID and YOUR_CLUSTER_ID     cluster = get_cluster_by_id(\"{YOUR_PUBLIC_KEY}\", \"{YOUR_PRIVATE_KEY}\", \"{YOUR_PROJECT_ID}\",                                        \"{YOUR_CLUSTER_ID}\")     print(cluster) ```  In the response, you can see the `connection_strings` field, which will be used later for connecting to the TiDB cluster. However, if your cluster status is `CREATING`, the `connection_strings` field might be empty. In such cases, you need to wait a while until the cluster status becomes `AVAILABLE` so that you can move on to the next step.  For more details about the request and response, see [Get a cluster by ID](#tag/Cluster/operation/GetCluster).  #### Step 5: Connect to the cluster using a MySQL client  After the cluster becomes `AVAILABLE`, you can get the connection strings. With the connection strings, you can connect to the cluster using a MySQL client.  The connection strings contain three fields:  - `default_user`, the username you use to connect to TiDB. - `standard` connection string. In this guide, you'll use the `standard` connection. - `vpc_peering` connection string.  The `standard` connection string contains a `host` and a `port`. In the following command, replace `${default_user}` and `${host}` with the actual values in the connection strings. Run the command to connect to the TiDB cluster.  ```shell mysql --connect-timeout 15 -u ${default_user} -h ${host} -P 4000 -D test -p ```  For more details on connection, see [Connect to TiDB Cluster](https://docs.pingcap.com/tidbcloud/connect-to-tidb-cluster).  ### Manage backups for your clusters  The following example shows how to create a manual backup and restore the last backup data to a new cluster.  #### Step 1: Create a manual backup  To create a manual backup, you can use the [Create a backup for a cluster](#tag/Backup/operation/CreateBackup) endpoint.  ```python import requests import json import datetime from requests.auth import HTTPDigestAuth  HOST = \"https://api.tidbcloud.com\"   def create_manual_backup(public_key: str, private_key: str, project_id: str, cluster_id: str) -> dict:     \"\"\"     Create manual backup     `data_for_backup` below is a demo. You should fill in the field according to     your own situation     :param public_key: Your public key     :param private_key: Your private key     :param project_id: The project id     :param cluster_id: The dedicated cluster id     :return: The backup id     \"\"\"     url = f\"{HOST}/api/v1beta/projects/{project_id}/clusters/{cluster_id}/backups\"     cur_date = datetime.datetime.now().strftime(\"%Y-%m-%d\")     data_for_backup = {\"name\": f\"tidbcloud-backup-{cur_date}\", \"description\": f\"tidbcloud-backup-{cur_date}\"}     data_for_backup_json = json.dumps(data_for_backup)     resp = requests.post(url=url,                          data=data_for_backup_json,                          auth=HTTPDigestAuth(public_key, private_key))     if resp.status_code != 200:         print(f\"request invalid, code : {resp.status_code}, message : {resp.text}\")         raise Exception(f\"request invalid, code : {resp.status_code}, message : {resp.text}\")     return resp.json()   if __name__ == \"__main__\":     # Replace YOUR_PUBLIC_KEY, YOUR_PRIVATE_KEY, YOUR_PROJECT_ID and YOUR_CLUSTER_ID     backup = create_manual_backup(\"{YOUR_PUBLIC_KEY}\", \"{YOUR_PRIVATE_KEY}\", \"{YOUR_PROJECT_ID}\",                                   \"{YOUR_CLUSTER_ID}\")     print(backup) ```  #### Step 2: Restore the last backup data to a new cluster  To restore the last backup data to a new cluster, you can use the [Create a restore task](#tag/Restore/operation/CreateRestoreTask) endpoint.  ```python import requests import json import datetime from requests.auth import HTTPDigestAuth  HOST = \"https://api.tidbcloud.com\"   def create_restore_task(public_key: str, private_key: str, project_id: str, back_up_id: str) -> dict:     \"\"\"     Create restore task     `data_for_restore` below is a demo. You should fill in the field according to     your own situation     :param private_key: Your public key     :param public_key: Your private key     :param project_id: The project id     :param back_up_id: The backup id     :return: The restore task id     \"\"\"     url = f\"{HOST}/api/v1beta/projects/{project_id}/restores\"     cur_date = datetime.datetime.now().strftime(\"%Y-%m-%d\")     data_for_restore = \\         {             \"backup_id\": f\"{back_up_id}\",             \"name\": f\"tidbcloud-restore-{cur_date}\",             \"config\":                 {                     \"root_password\": \"input_your_password\",                     \"port\": 4000,                     \"components\":                         {                             \"tidb\":                                 {                                     \"node_size\": \"8C16G\",                                     \"node_quantity\": 1                                 },                             \"tikv\":                                 {                                     \"node_size\": \"8C32G\",                                     \"storage_size_gib\": 500,                                     \"node_quantity\": 3                                 }                         },                     \"ip_access_list\":                         [                             {                                 \"cidr\": \"0.0.0.0/0\",                                 \"description\": \"Allow Access from Anywhere.\"                             }                         ]                  }         }     data_for_restore_json = json.dumps(data_for_restore)     resp = requests.post(url=url,                          auth=HTTPDigestAuth(public_key, private_key),                          data=data_for_restore_json)     if resp.status_code != 200:         print(f\"request invalid, code : {resp.status_code}, message : {resp.text}\")         raise Exception(f\"request invalid, code : {resp.status_code}, message : {resp.text}\")     return resp.json()   if __name__ == \"__main__\":     # Replace YOUR_PUBLIC_KEY, YOUR_PRIVATE_KEY, YOUR_PROJECT_ID and YOUR_BACKUP_ID     restore = create_restore_task(\"{YOUR_PUBLIC_KEY}\", \"{YOUR_PRIVATE_KEY}\", \"{YOUR_PROJECT_ID}\",                                   \"{YOUR_BACKUP_ID}\")     print(restore) ```  #### Step 3: Get the restored cluster information  To get the information of the restored cluster, you can use the [Get a cluster by ID](#tag/Cluster/operation/GetCluster) endpoint.  ```python import requests from requests.auth import HTTPDigestAuth  HOST = \"https://api.tidbcloud.com\"   def get_cluster_by_id(public_key: str, private_key: str, project_id: str, cluster_id: str) -> dict:     \"\"\"     Get the cluster detail.     You will get `connection_strings` from the response after the cluster's status is`AVAILABLE`.     Then, you can connect to TiDB using the default user, host, and port in `connection_strings`     :param public_key: Your public key     :param private_key: Your private key     :param project_id: The project id     :param cluster_id: The cluster id     :return: The cluster detail     \"\"\"     url = f\"{HOST}/api/v1beta/projects/{project_id}/clusters/{cluster_id}\"     resp = requests.get(url=url,                         auth=HTTPDigestAuth(public_key, private_key))     if resp.status_code != 200:         print(f\"request invalid, code : {resp.status_code}, message : {resp.text}\")         raise Exception(f\"request invalid, code : {resp.status_code}, message : {resp.text}\")     return resp.json()   if __name__ == \"__main__\":     # Replace YOUR_PUBLIC_KEY, YOUR_PRIVATE_KEY, YOUR_PROJECT_ID and YOUR_CLUSTER_ID     cluster = get_cluster_by_id(\"{YOUR_PUBLIC_KEY}\", \"{YOUR_PRIVATE_KEY}\", \"{YOUR_PROJECT_ID}\",                                        \"{YOUR_CLUSTER_ID}\")     print(cluster) ```  ### Scale out one TiFlash node for an existing cluster  The following example shows how to scale out one TiFlash node for an existing cluster.  #### Step 1: Add one TiFlash node for the specified cluster  To add a TiFlash node for the Dedicated Tier cluster, you can use the [Modify a Dedicated Tier cluster](#tag/Cluster/operation/UpdateCluster) endpoint.  ```python import requests import json from requests.auth import HTTPDigestAuth  HOST = \"https://api.tidbcloud.com\"   def modify_cluster(public_key: str, private_key: str, project_id: str, cluster_id: str, tiflash_num: int) -> dict:     \"\"\"     Add one TiFlash node for specified cluster     If the vCPUs of TiDB or TiKV component is 2 or 4, then the cluster does not support TiFlash.     `data_add_tiflash` below is a demo. You should fill in the field according to     your own situation     :param public_key: Your public key     :param private_key: Your private key     :param project_id: The project id     :param cluster_id: The cluster id     :param tiflash_num: The tiflash num     :return: If success, return None. Else, return message     \"\"\"     url = f\"{HOST}/api/v1beta/projects/{project_id}/clusters/{cluster_id}\"     data_add_tiflash = \\         {             \"config\":                 {                     \"components\":                         {                             \"tidb\":                                 {                                     \"node_quantity\": 1                                 },                             \"tikv\":                                 {                                     \"node_quantity\": 3                                 },                             \"tiflash\":                                 {                                     \"node_quantity\": f\"{tiflash_num}\",                                     \"node_size\": \"8C64G\",                                     \"storage_size_gib\": 500                                 }                         }                 }         }     data_add_tiflash_json = json.dumps(data_add_tiflash)     resp = requests.patch(url=url,                           auth=HTTPDigestAuth(public_key, private_key),                           data=data_add_tiflash_json)     if resp.status_code != 200:         print(f\"request invalid, code : {resp.status_code}, message : {resp.text}\")         raise Exception(f\"request invalid, code : {resp.status_code}, message : {resp.text}\")     return resp.json()   if __name__ == \"__main__\":     # Replace YOUR_PUBLIC_KEY, YOUR_PRIVATE_KEY, YOUR_PROJECT_ID, YOUR_CLUSTER_ID and MODIFY_TIFLASH_NUM     modify_cluster(\"{YOUR_PUBLIC_KEY}\", \"{YOUR_PRIVATE_KEY}\", \"{YOUR_PROJECT_ID}\",                    \"{YOUR_CLUSTER_ID}\", \"{MODIFY_TIFLASH_NUM}\") ```  #### Step 2: View the scale-out progress  To view the scale-out progress, you can use the [Get a cluster by ID](#tag/Cluster/operation/GetCluster) endpoint.  ```python import requests from requests.auth import HTTPDigestAuth  HOST = \"https://api.tidbcloud.com\"   def get_cluster_by_id(public_key: str, private_key: str, project_id: str, cluster_id: str) -> dict:     \"\"\"     Get the cluster detail.     You will get `connection_strings` from the response after the cluster's status is`AVAILABLE`.     Then, you can connect to TiDB using the default user, host, and port in `connection_strings`     :param public_key: Your public key     :param private_key: Your private key     :param project_id: The project id     :param cluster_id: The cluster id     :return: The cluster detail     \"\"\"     url = f\"{HOST}/api/v1beta/projects/{project_id}/clusters/{cluster_id}\"     resp = requests.get(url=url,                         auth=HTTPDigestAuth(public_key, private_key))     if resp.status_code != 200:         print(f\"request invalid, code : {resp.status_code}, message : {resp.text}\")         raise Exception(f\"request invalid, code : {resp.status_code}, message : {resp.text}\")     return resp.json()   if __name__ == \"__main__\":     # Replace YOUR_PUBLIC_KEY, YOUR_PRIVATE_KEY, YOUR_PROJECT_ID and YOUR_CLUSTER_ID     cluster = get_cluster_by_id(\"{YOUR_PUBLIC_KEY}\", \"{YOUR_PRIVATE_KEY}\", \"{YOUR_PROJECT_ID}\",                                        \"{YOUR_CLUSTER_ID}\")     print(cluster) ```  # Authentication  The TiDB Cloud API uses [HTTP Digest Authentication](https://en.wikipedia.org/wiki/Digest_access_authentication). It protects your private key from being sent over the network. For more details about HTTP Digest Authentication, refer to the [IETF RFC](https://datatracker.ietf.org/doc/html/rfc7616).  ## API Key Overview  - The API key contains a public key and a private key, which act as the username and password required in the HTTP Digest Authentication. The private key only displays upon the key creation. - The API key belongs to your organization and acts as the `Owner` role. You can check [permissions of owner](https://docs.pingcap.com/tidbcloud/manage-user-access#configure-member-roles). - You must provide the correct API key in every request. Otherwise, the TiDB Cloud responds with a `401` error.  ## API Key Management  ### Create an API Key  Only the **owner** of an organization can create an API key.  To create an API key in an organization, perform the following steps:  1. Click the account name in the upper-right corner of the TiDB Cloud console. 2. Click **Organization Settings**. The organization settings page is displayed. 3. Click the **API Keys** tab and then click **Create API Key**. 4. Enter a description for your API key. The role of the API key is always `Owner` currently. 5. Click **Next**. Copy and save the public key and the private key. 6. Make sure that you have copied and saved the private key in a secure location. The private key only displays upon the creation. After leaving this page, you will not be able to get the full private key again. 7. Click **Done**.  ### View Details of an API Key  To view details of an API key, perform the following steps:  1. Click the account name in the upper-right corner of the TiDB Cloud console. 2. Click **Organization Settings**. The organization settings page is displayed. 3. Click the **API Keys** tab. 4. You can view the details of the API keys in the menu.  ### Edit an API Key  Only the **owner** of an organization can modify an API key.  To edit an API key in an organization, perform the following steps:  1. Click the account name in the upper-right corner of the TiDB Cloud console. 2. Click **Organization Settings**. The organization settings page is displayed. 3. Click the **API Keys** tab. 4. Click **Edit** in the API key row that you want to change. 4. You can update the API key description. 5. Click **Done**.  ### Delete an API key  Only the **owner** of an organization can delete an API key.  To delete an API key in an organization, perform the following steps:  1. Click the account name in the upper-right corner of the TiDB Cloud console. 2. Click **Organization Settings**. The organization settings page is displayed. 3. Click the **API Keys** tab. 4. Click **Delete** in the API key row that you want to delete. 5. Click **I understand the consequences, delete this API Key.**  # Rate Limiting   The TiDB Cloud API allows up to 100 requests per minute per API key. If you exceed the rate limit, the API returns a `429` error.  Each API request returns the following headers about the limit.  - `X-Ratelimit-Limit-Minute`: The number of requests allowed per minute. It is 100 currently. - `X-Ratelimit-Remaining-Minute`: The number of remaining requests in the current minute. When it reaches `0`, the API returns a `429` error and indicates that you exceed the rate limit. - `X-Ratelimit-Reset`: The time in seconds at which the current rate limit resets.  If you exceed the rate limit, an error response returns like this.  ``` > HTTP/2 429 > date: Fri, 22 Jul 2022 05:28:37 GMT > content-type: application/json > content-length: 66 > x-ratelimit-reset: 23 > x-ratelimit-remaining-minute: 0 > x-ratelimit-limit-minute: 100 > x-kong-response-latency: 2 > server: kong/2.8.1  > {\"details\":[],\"code\":49900007,\"message\":\"API rate limit exceeded\"} ```  # API Changelog  This changelog lists all changes to the TiDB Cloud API.  <!-- In reverse chronological order -->  ## 20220906  - Add a `config.components.tikv.storage_size_gib` field to the [Modify a Dedicated Tier cluster](#tag/Cluster/operation/UpdateCluster) endpoint. - Modify the `config.components.tikv.node_quantity` and `config.components.tiflash.node_quantity` fields from `required` to `optional` for the [Modify a Dedicated Tier cluster](#tag/Cluster/operation/UpdateCluster) endpoint. - Remove the \"Can not modify `storage_size_gib` of an existing cluster\" limitation of the `config.components.tiflash.storage_size_gib` field for the [Create a cluster](#tag/Cluster/operation/CreateCluster) and [Modify a Dedicated Tier cluster](#tag/Cluster/operation/UpdateCluster) endpoints.  ## 20220823  - Add a `config.paused` field to the [Modify a Dedicated Tier cluster](#tag/Cluster/operation/UpdateCluster) endpoint. - Add two cluster statuses: `\"IMPORTING\"` and `\"UNAVAILABLE\"`.  ## 20220809  - Initial release of the TiDB Cloud API (v1beta) in private beta, including the following resources and endpoints:      - Project:          - [List all accessible projects](#tag/Project/operation/ListProjects)      - Cluster:         - [List the cloud providers, regions and available specifications](#tag/Cluster/operation/ListProviderRegions)         - [List all clusters in a project](/#tag/Cluster/operation/ListClustersOfProject)         - [Create a cluster](#tag/Cluster/operation/CreateCluster)         - [Get a cluster by ID](#tag/Cluster/operation/GetCluster)         - [Delete a cluster](#tag/Cluster/operation/DeleteCluster)         - [Modify a Dedicated Tier cluster](#tag/Cluster/operation/UpdateCluster)     - Backup:         - [List all backups for a cluster](#tag/Backup/operation/ListBackUpOfCluster)         - [Create a backup for a cluster](#tag/Backup/operation/CreateBackup)         - [Get a backup for a cluster](#tag/Backup/operation/GetBackupOfCluster)         - [Delete a backup for a cluster](#tag/Backup/operation/DeleteBackup)     - Restore:         - [List the restore tasks in a project](#tag/Restore/operation/ListRestoreTasks)         - [Create a restore task](#tag/Restore/operation/CreateRestoreTask)         - [Get a restore task](#tag/Restore/operation/GetRestoreTask) 
 *
 * OpenAPI spec version: v1-beta
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.github.icemap.invoker;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public class JSON {
    private ApiClient apiClient;
    private Gson gson;

    /**
     * JSON constructor.
     *
     * @param apiClient An instance of ApiClient
     */
    public JSON(ApiClient apiClient) {
        this.apiClient = apiClient;
        gson = new GsonBuilder()
            .registerTypeAdapter(Date.class, new DateAdapter(apiClient))
            .registerTypeAdapter(DateTime.class, new DateTimeTypeAdapter())
            .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
            .create();
    }

    /**
     * Get Gson.
     *
     * @return Gson
     */
    public Gson getGson() {
        return gson;
    }

    /**
     * Set Gson.
     *
     * @param gson Gson
     */
    public void setGson(Gson gson) {
        this.gson = gson;
    }

    /**
     * Serialize the given Java object into JSON string.
     *
     * @param obj Object
     * @return String representation of the JSON
     */
    public String serialize(Object obj) {
        return gson.toJson(obj);
    }

    /**
     * Deserialize the given JSON string to Java object.
     *
     * @param <T> Type
     * @param body The JSON string
     * @param returnType The type to deserialize inot
     * @return The deserialized Java object
     */
    @SuppressWarnings("unchecked")
    public <T> T deserialize(String body, Type returnType) {
        try {
            if (apiClient.isLenientOnJson()) {
                JsonReader jsonReader = new JsonReader(new StringReader(body));
                // see https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/stream/JsonReader.html#setLenient(boolean)
                jsonReader.setLenient(true);
                return gson.fromJson(jsonReader, returnType);
            } else {
                return gson.fromJson(body, returnType);
            }
        } catch (JsonParseException e) {
            // Fallback processing when failed to parse JSON form response body:
            //   return the response body string directly for the String return type;
            //   parse response body into date or datetime for the Date return type.
            if (returnType.equals(String.class))
                return (T) body;
            else if (returnType.equals(Date.class))
                return (T) apiClient.parseDateOrDatetime(body);
            else throw(e);
        }
    }
}

class DateAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {
    private final ApiClient apiClient;

    /**
     * Constructor for DateAdapter
     *
     * @param apiClient Api client
     */
    public DateAdapter(ApiClient apiClient) {
        super();
        this.apiClient = apiClient;
    }

    /**
     * Serialize
     *
     * @param src Date
     * @param typeOfSrc Type
     * @param context Json Serialization Context
     * @return Json Element
     */
    @Override
    public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
        if (src == null) {
            return JsonNull.INSTANCE;
        } else {
            return new JsonPrimitive(apiClient.formatDatetime(src));
        }
    }

    /**
     * Deserialize
     *
     * @param json Json element
     * @param date Type
     * @param typeOfSrc Type
     * @param context Json Serialization Context
     * @return Date
     * @throw JsonParseException if fail to parse
     */
    @Override
    public Date deserialize(JsonElement json, Type date, JsonDeserializationContext context) throws JsonParseException {
        String str = json.getAsJsonPrimitive().getAsString();
        try {
            return apiClient.parseDateOrDatetime(str);
        } catch (RuntimeException e) {
            throw new JsonParseException(e);
        }
    }
}

/**
 * Gson TypeAdapter for Joda DateTime type
 */
class DateTimeTypeAdapter extends TypeAdapter<DateTime> {

    private final DateTimeFormatter formatter = ISODateTimeFormat.dateTime();

    @Override
    public void write(JsonWriter out, DateTime date) throws IOException {
        if (date == null) {
            out.nullValue();
        } else {
            out.value(formatter.print(date));
        }
    }

    @Override
    public DateTime read(JsonReader in) throws IOException {
        switch (in.peek()) {
            case NULL:
                in.nextNull();
                return null;
            default:
                String date = in.nextString();
                return formatter.parseDateTime(date);
        }
    }
}

/**
 * Gson TypeAdapter for Joda LocalDate type
 */
class LocalDateTypeAdapter extends TypeAdapter<LocalDate> {

    private final DateTimeFormatter formatter = ISODateTimeFormat.date();

    @Override
    public void write(JsonWriter out, LocalDate date) throws IOException {
        if (date == null) {
            out.nullValue();
        } else {
            out.value(formatter.print(date));
        }
    }

    @Override
    public LocalDate read(JsonReader in) throws IOException {
        switch (in.peek()) {
            case NULL:
                in.nextNull();
                return null;
            default:
                String date = in.nextString();
                return formatter.parseLocalDate(date);
        }
    }
}
