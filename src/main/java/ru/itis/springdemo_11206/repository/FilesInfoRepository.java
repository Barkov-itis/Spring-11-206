package ru.itis.springdemo_11206.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.springdemo_11206.models.FileInfo;

public interface FilesInfoRepository extends JpaRepository<FileInfo, Long> {
    FileInfo findByStorageFileName (String fileName);
}
