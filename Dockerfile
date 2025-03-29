# Chọn base image từ OpenJDK
FROM openjdk:17

# Thiết lập thư mục làm việc trong container
WORKDIR /app

# Sao chép file JAR đã build vào container
COPY target/customermanagement-0.0.1.jar app.jar

# Mở cổng 8080 trong container (Spring Boot mặc định chạy trên cổng 8080)
EXPOSE 8080

# Chạy ứng dụng Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]
