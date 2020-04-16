package com.bsnux.kubernetes;

import io.kubernetes.client.ApiClient;
import io.kubernetes.client.ApiException;
import io.kubernetes.client.Configuration;
import io.kubernetes.client.apis.CoreV1Api;
import io.kubernetes.client.models.V1Namespace;
import io.kubernetes.client.models.V1NamespaceList;
import io.kubernetes.client.util.KubeConfig;
import io.kubernetes.client.util.ClientBuilder;
import java.io.FileReader;
import java.io.IOException;

/**
 * List Kubernetes namespaces in configured context
 *
 */
public class App {
    public static void main(String[] args) throws IOException, ApiException {
        String kubeConfigPath = String.format("%s/.kube/config", System.getenv("HOME"));
        ApiClient client = ClientBuilder.kubeconfig(KubeConfig.loadKubeConfig(new FileReader(kubeConfigPath))).build();
        Configuration.setDefaultApiClient(client);

        CoreV1Api api = new CoreV1Api();
        V1NamespaceList list = api.listNamespace(null, null, null, null, null, null, null, null, null);
        for (V1Namespace ns : list.getItems()) {
            System.out.println(ns.getMetadata().getName());
        }
    }
}
