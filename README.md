# Benchmark
* Fazendo testes de cargas locais com o Postman, tive resultados diferentes entre uma API Rest normal vs uma API Rest reativa com Webflux
## Http normal
* Banco de dados: MySQL
* 20k de registros
## Http reativo
* Banco de dados: MongoDB
* 20k de registros

## Cenário 1: Requests buscando um mesmo recurso através do ID
#### Http normal
![image](https://github.com/kaikeventura/webflux/assets/44590259/743b29e0-8541-423b-b5c7-eb5954c68985)
![image](https://github.com/kaikeventura/webflux/assets/44590259/5d42b3a6-409c-4b7e-80d9-5a5f454d4fb3)

#### Http reativo
![image](https://github.com/kaikeventura/webflux/assets/44590259/a27f2c52-dc8a-4f99-8aff-c3769c1f1c80)
![image](https://github.com/kaikeventura/webflux/assets/44590259/ac9f6b49-f118-4d8e-a452-e4b62facaf1a)

#### Comparação
|     App type    | Requests | Min(ms) |  Max(ms) | AVG(ms) |
|:---------------:|:--------:|:-------:|:--------:|:-------:|
| **Http normal** | **9229** |  **3**  | **1892** |  **14** |
|   Http reativo  |   8524   |    3    |    933   |    17   |
|       Diff      |    705   |    0    |    959   |    3    |

## Cenário 2: Requests buscando múltiplos recursos através do ID
#### Http normal
![image](https://github.com/kaikeventura/webflux/assets/44590259/7c960f41-1757-4074-897c-ce8e29be0029)
![image](https://github.com/kaikeventura/webflux/assets/44590259/4ef99c6e-6086-4982-98e0-5bad644af93b)

#### Http reativo
![image](https://github.com/kaikeventura/webflux/assets/44590259/4643ee9d-04d8-46af-9002-fcbb59d04338)
![image](https://github.com/kaikeventura/webflux/assets/44590259/a7afdd99-19a4-4c16-978a-cb0adf6c4de4)

#### Comparação
|     App type     | Requests | Min(ms) |  Max(ms) | AVG(ms) |
|:----------------:|:--------:|:-------:|:--------:|:-------:|
|    Http normal   |   7433   |    3    |   10236  |    28   |
| **Http reativo** | **7507** |  **2**  | **1167** |  **23** |
|       Diff       |    74    |    1    |   9069   |    5    |
