# poc-bingo-2026.2

## MongoDB

Inicie o banco e informe à aplicação o mesmo usuário e senha configurados no
arquivo Compose:

```bash
docker compose -f 'docker -compose.yml' up -d
export MONGODB_USERNAME='<usuario>'
export MONGODB_PASSWORD='<senha>'
./gradlew bootRun
```

O banco padrão é `bingo`, com autenticação no banco `admin`. Para alterar a
conexão, defina `MONGODB_HOST`, `MONGODB_PORT` ou `MONGODB_DATABASE`. As
credenciais de inicialização do MongoDB só são aplicadas a um volume novo.
