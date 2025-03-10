# Usa a imagem oficial do OpenJDK 17
FROM openjdk:17

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia todos os arquivos do projeto para dentro do container
COPY . .

# Concede permissão para o Maven Wrapper (caso necessário)
RUN chmod +x mvnw

# Compila a aplicação e gera o JAR
RUN ./mvnw clean package -DskipTests

# Define o nome exato do JAR gerado (verifique se o nome está correto)
CMD ["java", "-jar", "target/someli-0.0.1-SNAPSHOT.jar"]

# Expõe a porta 8080 para o Render acessar
EXPOSE 8080
