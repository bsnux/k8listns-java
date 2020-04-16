# k8listns-java

Simple *Java* application for listing all namespaces in current configured
[Kubernetes cluster](https://kubernetes.io).

Make sure you have a valid `~/.kube/config` file.


## Requirements

* Java > 8.x
* [Maven](https://maven.apache.org/)

## Creating an uber (fat) jar

```
$ mvn clean package
```

## Usage

```
$ java -jar target/k8listns-1.0-shaded.jar
```
