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
      app: fluid
  template:
    metadata:
      labels:
        app: fluid
    spec:
      containers:
        - name: fluid-container
          image: fluid-test-docker
          imagePullPolicy: IfNotPresent
```