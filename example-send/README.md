# for k8s

put under `fluid-deployment-sender.yaml`:
```
apiVersion: apps/v1
kind: Deployment
metadata:
  name: fluid-deployment-sender
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
          image: fluid-test-sender-docker
          imagePullPolicy: IfNotPresent
```