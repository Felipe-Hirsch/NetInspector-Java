🚀 NetInspector - Ferramenta de Diagnóstico de Redes
O NetInspector é uma aplicação Java desenvolvida para analisar e inspecionar diferentes camadas do modelo TCP/IP. O objetivo do projeto é fornecer uma visão prática de como a comunicação entre cliente e servidor acontece, desde a resolução de nomes até a análise de cabeçalhos de aplicação.

✨ Funcionalidades
O projeto está dividido em quatro módulos principais de análise:

🔍 Resolução DNS: Tradução de domínios para endereços IPv4 e IPv6 e cálculo do tempo de resposta da resolução.
s
🔌 Analisador de Portas (TCP): Verificação de conectividade em portas comuns (80, 443, 21) para análise da camada de transporte.

✉️ Requisição HTTP Manual: Implementação de uma requisição GET bruta via Sockets, permitindo visualizar a estrutura nativa do protocolo HTTP/1.1.

📊 Análise de Cabeçalhos: Uso da HttpClient API moderna para extrair metadados do servidor (Server, Content-Type, Date).

🛠️ Tecnologias Utilizadas
Linguagem: Java 17+ 

Bibliotecas Nativas: * java.net.* (Sockets e InetAddress)

java.net.http.* (Requisições HTTP modernas)

java.io.* (Fluxo de dados e buffers)
