
# OpenapiUpdateTiKVComponent

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**storageSizeGib** | **Integer** | The storage size of a node in the cluster. You can get the minimum and maximum of storage size from the response of [List the cloud providers, regions and available specifications](#tag/Cluster/operation/ListProviderRegions).  **Limitations**: - You cannot decrease storage size for TiKV. - If your TiDB cluster is hosted by AWS, after changing the storage size of TiKV, you must wait at least six hours before you can change it again. |  [optional]
**nodeQuantity** | **Integer** | The number of nodes in the cluster. You can get the minimum and step of a node quantity from the response of [List the cloud providers, regions and available specifications](#tag/Cluster/operation/ListProviderRegions).  **Limitations**: - You cannot decrease node quantity for TiKV. - The &#x60;node_quantity&#x60; of TiKV must be a multiple of 3. |  [optional]



