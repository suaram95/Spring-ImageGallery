package am.itspace.springimagegallery.repository;

import am.itspace.springimagegallery.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Integer> {

    List<Image> findImageByCategoryId(int id);
}
