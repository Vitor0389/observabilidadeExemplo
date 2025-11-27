📊 Observabilidade com OpenTelemetry, Jaeger, Prometheus, Grafana e Apps Java

Este repositório contém uma stack completa de observabilidade utilizando Docker Compose.
O ambiente inclui:

Jaeger – Visualização de traces

OpenTelemetry Collector – Pipeline central de ingestão e exportação

Prometheus – Armazenamento de métricas

Grafana – Dashboards e visualização

App A e App B (Java 17) – Aplicações instrumentadas via OTel

🚀 Como Executar o Projeto
🟦 1. Pré-requisitos

Certifique-se de ter instalado:

Docker

Docker Compose

(Opcional) Java 17, caso queira rodar os apps localmente

▶️ 2. Subindo toda a Stack

Na raiz do projeto, execute:

docker compose up --build


Ou em modo detached:

docker compose up --build -d


A stack iniciará os seguintes serviços:

Serviço	URL / Porta
Jaeger	http://localhost:16686

Prometheus	http://localhost:9090

Grafana	http://localhost:3000

App A	http://localhost:8081

App B	http://localhost:8082

OTel Collector	4317 (gRPC), 4318 (HTTP), 8889 (Prometheus metrics)
🔍 3. Acessando as Ferramentas
🟣 Jaeger (Visualização de Traces)

Acesse:

http://localhost:16686

Em Service, selecione appA ou appB

Explore spans, dependências e tempo de resposta

📈 Grafana (Dashboards)

Acesse:

http://localhost:3000

Login padrão:

Usuário: admin
Senha: admin


Adicione o Prometheus como Data Source:

URL: http://prometheus:9090

📊 Prometheus (Métricas cruas)

Acesse:

http://localhost:9090

Pesquise métricas do OpenTelemetry Collector e das aplicações.

🧪 4. Gerando Traces e Métricas

Chame o App A para iniciar chamadas encadeadas:

curl http://localhost:8081/algum-endpoint


Fluxo gerado:

App A recebe a requisição

App A chama o App B

Os dois geram spans

OTel Collector recebe tudo e envia para Jaeger e Prometheus

🔧 5. Arquitetura do Ambiente
App A  →  OTel Collector  →  Jaeger
   ↓              ↓
App B        Prometheus  →  Grafana


Apps Java enviam traces e métricas via OTLP/gRPC

Collector roteia os dados para Jaeger e Prometheus

Grafana visualiza métricas vindas do Prometheus

🔄 6. Comandos Úteis
Parar os serviços:
docker compose down

Parar e apagar volumes:
docker compose down -v

Subir novamente:
docker compose up --build

📁 7. Estrutura do Projeto
/
├── docker-compose.yml
├── otel-collector-config.yaml
├── prometheus.yml
├── appA/
│   └── (código Java)
├── appB/
│   └── (código Java)

🧱 8. Tecnologias Usadas

Jaeger 1.60

OpenTelemetry Collector 0.110

Prometheus (latest)

Grafana (latest)

Java 17 + OTel SDK
