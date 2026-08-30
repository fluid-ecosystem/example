# for k8s

put under `fluid-deployment-receiver.yaml`:
```
apiVersion: apps/v1
kind: Deployment
metadata:
  name: fluid-deployment-receiver
spec:
  replicas: 1
  selector:
    matchLabels:
      app: fluid-receiver
  template:
    metadata:
      labels:
        app: fluid-receiver
    spec:
      containers:
        - name: fluid-container
          image: fluid-test-docker
          imagePullPolicy: IfNotPresent
```

one shot deployment:
```
# remove any existing deployment
kubectl delete -f fluid-deployment-receiver.yaml -n fluid-test --ignore-not-found
# kafka-cluster:9092
docker build -t fluid-test-docker .
minikube image load fluid-test-docker
kubectl apply -f fluid-deployment-receiver.yaml -n fluid-test 
```